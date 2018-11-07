package red.silence.Interface;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import red.silence.util.TitleAdapt;

import java.util.List;

/**
 * @author WangDongling
 * @version 1.0
 * @date 2018-11-06
 */
public interface ExcelRuleInterface {
    String getPid();

    String getUuid();

    int getIndex(CellAddress cellAddress);

    List<Cell> getCells(int start, int end, List<Row> rows, TitleAdapt titleAdapt);
}
