package red.silence.Interface;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import red.silence.util.TitleAdapt;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangDongling
 * @version 1.0
 * @date 2018-11-06
 */
public abstract class AbstractRowRule implements ExcelRuleInterface {
    @Override
    public List<Cell> getCells(int start, int end, List<Row> rows, TitleAdapt titleAdapt) {
        List<Cell> cells = new ArrayList<>();

        if(0 >= end) {
            end = rows.size();
        }

        for(int i=start; i<end; i++) {
            cells.add(rows.get(i).getCell(titleAdapt.getCellAddress().getColumn()));
        }
        return cells;
    }

    @Override
    public int getIndex(CellAddress cellAddress) {
        return cellAddress.getRow();
    }
}
