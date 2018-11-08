package red.silence.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import red.silence.Interface.ExcelRuleInterface;
import red.silence.model.ExcelColumnRule;
import red.silence.model.ExcelRowColCustom;
import red.silence.model.ExcelRowColumn;
import red.silence.model.ExcelRowRule;

import java.util.*;

/**
 * @author Quiet
 * @date 2018-11-01
 */
public class DataMatchUtil {

    public static List<Object> match(ExcelPOIUtil excelPOIUtil, Sheet sheet,
             List<ExcelRowColCustom> defaultCustoms,
             List<ExcelRowColCustom> customRules,
             List<ExcelColumnRule> columnRules,
             List<ExcelRowRule> rowRules) {

        //系统列标签map，便于数据查找，以及用户自定义配置规则映射
        RuleMap<RuleMap.Entry<String, RuleKey>, ExcelColumnRule> colRuleMap = new RuleMap();
        //系统行标签map，便于数据查找，以及用户自定义配置规则映射
        RuleMap<RuleMap.Entry<String, RuleKey>, ExcelRowRule> rowRuleMap = new RuleMap();

        RuleKey ruleKey = null;
        RuleMap.Entry<String, RuleKey> entry = null;
        //遍历系统列标签配置，放入map
        for(ExcelColumnRule colRule : columnRules) {
            //标签名及pid
            ruleKey = new RuleKey(colRule.getPid(), colRule.getLableName());
            entry = new RuleMap.Entry<>(colRule.getUuid(), ruleKey);

            colRuleMap.put(entry, colRule);
        }

        //遍历系统行标签配置，放入map
        for(ExcelRowRule rowRule : rowRules) {
            //标签名及pid
            ruleKey = new RuleKey(rowRule.getPid(), rowRule.getLableName());
            entry = new RuleMap.Entry<>(rowRule.getUuid(), ruleKey);

            rowRuleMap.put(entry, rowRule);
        }

        //用户配置优于系统默认配置
        //系统针对部分厂商的配置替换
        customRuleMapping(defaultCustoms, colRuleMap, rowRuleMap);
        //遍历用户自定义配置，对系统配置进行替换
        customRuleMapping(customRules, colRuleMap, rowRuleMap);

        //处理列标签
        Map<Object,List<TitleAdapt<ExcelColumnRule>>> colTitleMap = new HashMap<>();
        getTitle(excelPOIUtil, sheet, colRuleMap, colTitleMap,null,null);

        //处理行标签
        Map<Object,List<TitleAdapt<ExcelRowRule>>> rowTitleMap = new HashMap<>();
        getTitle(excelPOIUtil, sheet, rowRuleMap, rowTitleMap,null,null);

        List<TitleAdapt<ExcelColumnRule>> colTitleAdapts = null;
        List<TitleAdapt<ExcelRowRule>> rowTitleAdapts = null;
        ExcelRowRule rowRule = null;
        //当前行标签关联的列标签集合
        List<ExcelRowColumn> rowColumns = null;
        //关联的单个列标签
        ExcelColumnRule columnRule = null;

        for(Map.Entry<Object, List<TitleAdapt<ExcelRowRule>>> mEntry: rowTitleMap.entrySet()) {
            rowTitleAdapts = mEntry.getValue();

            for(TitleAdapt rowTitleAdapt : rowTitleAdapts) {
                rowRule = (ExcelRowRule) rowTitleAdapt.getRule();

                rowColumns = rowRule.getExcelRules();
                if(null == rowColumns || 0 == rowColumns.size()) {
                    continue;
                }
                //行位置
                int rowIdx = 0;
                rowIdx = rowTitleAdapt.getCellAddress().getRow();
                for(ExcelRowColumn excelRowColumn : rowColumns) {
                    columnRule = excelRowColumn.getExcelColumnRule();

                    colTitleAdapts = colTitleMap.get(columnRule.getPid());

                    //列位置
                    int colIdx = 0;

                    int colDiff = 0;
                    //计算距离该标签最近的列位置
                    for(TitleAdapt colTitleAdapt : colTitleAdapts) {
                        if(!columnRule.getUuid().equals(
                                colTitleAdapt.getRule().getUuid())) {
                            continue;
                        }
                        if(0 >= colDiff) {
                            colDiff = colTitleAdapt.getCellAddress().getColumn() -
                                    rowTitleAdapt.getCellAddress().getColumn();
                            if(colDiff > 0) {
                                colIdx = colTitleAdapt.getCellAddress().getColumn();
                            }
                        } else {
                            int diff = colTitleAdapt.getCellAddress().getColumn() -
                                    rowTitleAdapt.getCellAddress().getColumn();
                            if(diff < colDiff) {
                                colDiff = diff;
                                colIdx = colTitleAdapt.getCellAddress().getColumn();
                            }
                        }
                    }

                    Cell cell = sheet.getRow(rowIdx).getCell(colIdx);

                    excelRowColumn.setData(excelPOIUtil.getCellValue(cell));
                    //单元格格式校验//TODO:单元格格式校验
                    //if(validateData(cell, excelRowColumn))
                }
            }
        }

        return null;
    }

    //校验单元格数据格式
    private static boolean validateData(Cell cell, ExcelRowColumn excelRowColumn) {
        return cell.getClass().getSimpleName().equals(excelRowColumn.getDataType());
    }

    private static <T extends ExcelRuleInterface> void getTitle(ExcelPOIUtil excelPOIUtil, Sheet sheet,
            RuleMap<RuleMap.Entry<String,RuleKey>, T> ruleMap,
            Map<Object,List<TitleAdapt<T>>> titleMap, String pid, String ppid) {

        /*
            标签名冲突分两种情况--
            1.一种是因为单列，对半拆分为多列展示，同一行有多个行标签；
                这种不区分冲突，数据通过行标签所在列距离近的有限匹配
            2.一种是一行的所有数据都属于单个行标签，但是在列标签中存在重复；
                这种通过父标签来区分
         */
        List<Row> rows = ExcelPOIUtil.getRows(sheet);

        if(pid == null) {
            for(Row row : rows) {
                if(null == row) {
                    continue;
                }
                for(Cell cell : row) {
                    cacheTitle(excelPOIUtil, sheet, ruleMap, titleMap, pid, cell);
                }
            }
        } else {
            //处理存在父标签的列标签
            List<TitleAdapt<T>> titleAdapts = titleMap.get(ppid);
            TitleAdapt<T> parrentTitle = null;
            if(null != titleAdapts) {
                for(TitleAdapt titleAdapt : titleAdapts) {
                    if(pid.equals(titleAdapt.getRule().getUuid())) {
                        parrentTitle = titleAdapt;
                        break;
                    }
                }

                if(null == parrentTitle) {
                    return;
                }

                //遍历查找子列标签
                for(Cell cell : parrentTitle.getCells(sheet, titleAdapts)) {
                    cacheTitle(excelPOIUtil, sheet, ruleMap,
                            titleMap, pid, cell);
                }
            }
        }

        //递归处理子标签
        for(String tPid : getChildColRule(pid, ruleMap, titleMap)) {
            getTitle(excelPOIUtil,sheet,ruleMap,titleMap,tPid, pid);
        }
    }

    //记录标签位置
    private static <T extends ExcelRuleInterface> void cacheTitle(ExcelPOIUtil excelPOIUtil, Sheet sheet,
               RuleMap<RuleMap.Entry<String,RuleKey>, T> ruleMap,
               Map<Object, List<TitleAdapt<T>>> titleMap, String pid, Cell cell) {

        Object lableName = null;
        RuleMap.Entry<RuleMap.Entry<String,RuleKey>, T> entry = null;
        RuleKey ruleKey = null;
        TitleAdapt titleAdapt = null;

        lableName = excelPOIUtil.getCellValue(cell, CellType.STRING);

        if(null == lableName) {
            return;
        }

        ruleKey = new RuleKey(pid, lableName.toString().trim());
        entry = ruleMap.getByKeyV(ruleKey);

        if(null == entry) {
            return;
        }

        titleAdapt = new TitleAdapt();
        titleAdapt.setRule(entry.getValue());
        titleAdapt.setCellAddress(cell.getAddress());


        //通过pid确认子节点数据
        List<TitleAdapt<T>> titleAdapts = titleMap.get(pid);
        if(null == titleAdapts) {
            titleAdapts = new ArrayList<>();
            titleMap.put(pid, titleAdapts);
        }/* else {
            //处理子标签被多次查找且保存问题--如果保存过不再保存
            if(titleAdapts.contains(titleAdapt)) {
                return;
            }
        }*/


        titleAdapts.add(titleAdapt);
    }

    //把当前节点当父节点，通过遍历确认是否存在子节点
    private static <T extends ExcelRuleInterface> List<String> getChildColRule(String pid,
              RuleMap<RuleMap.Entry<String,RuleKey>, T> colRuleMap,
              Map<Object,List<TitleAdapt<T>>> titleMap) {

        List<TitleAdapt<T>> titleAdapts = titleMap.get(pid);
        List<String> pids = new ArrayList<>();
        if(null == titleAdapts) {
            return pids;
        }

        for(TitleAdapt<T> t : titleAdapts) {
            pids.add(t.getRule().getUuid());
        }

        return pids;
    }

    //自定义规则映射替换
    private static void customRuleMapping(List<ExcelRowColCustom> customs,
           RuleMap<RuleMap.Entry<String, RuleKey>, ExcelColumnRule> colRuleMap,
           RuleMap<RuleMap.Entry<String, RuleKey>, ExcelRowRule> rowRuleMap) {

        for(ExcelRowColCustom custom : customs) {
            //映射规则entry--缓存的数据
            RuleMap.Entry<RuleMap.Entry<String, RuleKey>, ExcelRowRule> rowEntry = null;
            RuleMap.Entry<RuleMap.Entry<String, RuleKey>, ExcelColumnRule> colEntry = null;

            if(Constants.EXCEL_CELL_TYPE_ROW.equals(custom.getCellType())) {
                rowEntry = rowRuleMap.getByKeyk(custom.getRefUuid());
                if(null != rowEntry) {
                    rowEntry.getKey().getValue().setLableName(custom.getLabelName());
                }
            } else if(Constants.EXCEL_CELL_TYPE_COLUMN.equals(custom.getCellType())) {
                colEntry = colRuleMap.getByKeyk(custom.getRefUuid());
                if(null != colEntry) {
                    colEntry.getKey().getValue().setLableName(custom.getLabelName());
                }
            } else {
                throw new RuntimeException("err ExcelRowColCustom.type: "
                        + custom.getCellType());
            }
        }
    }
}
