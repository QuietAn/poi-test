package red.silence.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import red.silence.model.ExcelColumnRule;
import red.silence.model.ExcelRowColCustom;
import red.silence.model.ExcelRowRule;

import java.util.LinkedList;
import java.util.List;

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

        return null;
    }

    public static void getTitle(ExcelPOIUtil excelPOIUtil, Sheet sheet,
            RuleMap<RuleMap.Entry<String,RuleKey>, ExcelColumnRule> colRuleMap) {

        List<Row> rows = ExcelPOIUtil.getRows(sheet);

        Object key = null;
        for(Row row : rows) {
            for(Cell cell : row) {
                key = excelPOIUtil.getCellValue(cell, CellType.STRING);
            }
        }
    }

    private static Object matchData(Sheet sheet,
            RuleMap<RuleMap.Entry<String, RuleKey>, ExcelColumnRule> colRuleMap,
            RuleMap<RuleMap.Entry<String, RuleKey>, ExcelRowRule> rowRuleMap) {

        LinkedList<Row> rows = new LinkedList<>(ExcelPOIUtil.getRows(sheet));

        return null;
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
                rowEntry = rowRuleMap.getValByEntryKey(custom.getRefUuid());
                if(null != rowEntry) {
                    rowEntry.getKey().getValue().setLableName(custom.getLabelName());
                }
            } else if(Constants.EXCEL_CELL_TYPE_COLUMN.equals(custom.getCellType())) {
                colEntry = colRuleMap.getValByEntryKey(custom.getRefUuid());
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
