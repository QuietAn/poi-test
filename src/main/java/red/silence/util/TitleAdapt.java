package red.silence.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import red.silence.Interface.ExcelRuleInterface;

import java.util.List;

/**
 * @author WangDongling
 * @version 1.0
 * @date 2018-11-05
 */
public class TitleAdapt {
    private ExcelRuleInterface columnRule;

    private CellAddress cellAddress;

    public ExcelRuleInterface getColumnRule() {
        return columnRule;
    }

    public void setColumnRule(ExcelRuleInterface columnRule) {
        this.columnRule = columnRule;
    }

    public List<Cell> getCells(List<Row> rows, List<TitleAdapt> titleAdapts) {
        int startIdx = 0;
        int endIdx = 0;

        startIdx = columnRule.getIndex(cellAddress);

        for(TitleAdapt titleAdapt : titleAdapts) {
            if(titleAdapt == this) {
                continue;
            }

            int index = titleAdapt.getColumnRule().getIndex(
                    titleAdapt.getCellAddress());

            if(endIdx > index) {
                endIdx = index;
            }
        }

        return columnRule.getCells(startIdx, endIdx, rows, this);
    }

    public CellAddress getCellAddress() {
        return cellAddress;
    }

    public void setCellAddress(CellAddress cellAddress) {
        this.cellAddress = cellAddress;
    }
}
