package red.silence.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import red.silence.model.CellColumnRule;
import red.silence.model.CellRowRule;
import red.silence.model.UserCellRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Quiet
 * @date 2018-11-01
 */
public class DataMatchUtil {
    public static List<CellRowRule> match(List<CellRowRule> cellRowRules, List<UserCellRule> userCellRules, List<Row> rows) {

        Map<String, CellRowRule> map = new HashMap<>();
        Map<String, UserCellRule> userRoles = new HashMap<>();

        for(CellRowRule cellRowRule : cellRowRules) {
            map.put(cellRowRule.getLableName(), cellRowRule);
        }

        for(Row row : rows) {
            for(Cell cell : row) {
                Object key = ExcelPOIUtils.getValueByType(cell, CellType.STRING);

                if(map.containsKey(key)) {
                    CellRowRule cellRowRule = map.get(key);

                    List<CellColumnRule> cellColumnRules = cellRowRule.getColumnRules();

                    Map<String, CellAddress> mapkey = getTitle(cellColumnRules, rows);

                    List<Object> datas = new ArrayList<>();
                    for(CellColumnRule columnRule : cellColumnRules) {
                        datas.add(ExcelPOIUtils.getValue( cell.getRow().getCell( (mapkey.get( columnRule.getLableName() ).getColumn()) )) );
                    }

                    cellRowRule.setDatas(datas);
                    cellRowRule.setColumnRules(null);
                }
            }
        }

        return cellRowRules;
    }

    public static Map<String, CellAddress> getTitle(List<CellColumnRule> columnRules, List<Row> rows) {
        Map<String, CellAddress> map = new HashMap<>();


        for(CellColumnRule cellColumnRule : columnRules) {
            String key = null;
            key = cellColumnRule.getLableName();

            map.put(key, null);
        }

        for(Row row : rows) {
            for(Cell cell : row) {
                Object key = ExcelPOIUtils.getValueByType(cell, CellType.STRING);
                if(map.containsKey(key)) {
                    map.put(key.toString(), cell.getAddress());
                }
            }
        }

        return map;
    }


}
