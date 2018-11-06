package red.silence.Interface;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import red.silence.util.TitleAdapt;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangDongling
 * @version 1.0
 * @date 2018-11-06
 */
public abstract class AbstractColumnRule implements ExcelRuleInterface{
    @Override
    public List<Cell> getCells(int start, int end, List<Row> rows, TitleAdapt titleAdapt) {
        List<Cell> cells = new ArrayList<>();
        //遍历查找子列标签
        for(Row row : rows) {
            if(end == 0) {
                end = row.getLastCellNum();
            }

            for(int i=start; i<end; i++) {
                cells.add(row.getCell(i));
            }
        }

        return cells;
    }
}