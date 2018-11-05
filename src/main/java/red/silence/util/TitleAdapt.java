package red.silence.util;

import org.apache.poi.ss.util.CellAddress;
import red.silence.model.ExcelColumnRule;

/**
 * @author WangDongling
 * @version 1.0
 * @date 2018-11-05
 */
public class TitleAdapt {
    private ExcelColumnRule columnRule;

    private CellAddress cellAddress;

    public ExcelColumnRule getColumnRule() {
        return columnRule;
    }

    public void setColumnRule(ExcelColumnRule columnRule) {
        this.columnRule = columnRule;
    }

    public CellAddress getCellAddress() {
        return cellAddress;
    }

    public void setCellAddress(CellAddress cellAddress) {
        this.cellAddress = cellAddress;
    }
}
