package red.silence.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import red.silence.Interface.ExcelRuleInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangDongling
 * @version 1.0
 * @date 2018-11-05
 */
public class TitleAdapt<T extends ExcelRuleInterface> {
    private T rule;

    private CellAddress cellAddress;

    public T getRule() {
        return rule;
    }

    public void setRule(T rule) {
        this.rule = rule;
    }

    public int getIndex() {
        return rule.getIndex(cellAddress);
    }

    public List<Cell> getCells(List<Row> rows, List<TitleAdapt<T>> titleAdapts) {
        int diff = 0;
        int endIdx = 0;

        for(TitleAdapt titleAdapt : titleAdapts) {
            if(titleAdapt == this) {
                continue;
            }

            if(0 >= diff) {
                diff = titleAdapt.getIndex() - this.getIndex();
                if(diff > 0) {
                    endIdx = titleAdapt.getIndex();
                }
            } else {
                int temp = titleAdapt.getIndex() - this.getIndex();
                if(diff < temp) {
                    endIdx = titleAdapt.getIndex();
                }
            }
        }
        //相差1代表两个节点相邻不计算
        if(diff==1) {
            return new ArrayList<>();
        }

        return rule.getCells(this.getIndex(), endIdx, rows, this);
    }

    public CellAddress getCellAddress() {
        return cellAddress;
    }

    public void setCellAddress(CellAddress cellAddress) {
        this.cellAddress = cellAddress;
    }

    @Override
    public int hashCode() {
        return rule.getUuid().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        TitleAdapt<T> ta = (TitleAdapt<T>) obj;

        //如果单元格位置相同 代表该单元格已被其他标签引用不可再使用
        return this.getCellAddress().equals(ta.getCellAddress());
    }
}
