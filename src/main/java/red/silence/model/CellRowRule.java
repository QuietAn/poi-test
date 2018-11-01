package red.silence.model;

import java.util.List;

/**
 * @author WangDongling
 * @version 1.0
 * @date 2018-10-31
 */
public class CellRowRule extends Cell{
    //数量
    private int size;
    //
    private List<Object> datas;

    private List<CellColumnRule> columnRules;
    
    /**
     * 获取 数量
     *
     * @return size 数量
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 设置 数量
     *
     * @param size 数量
     */
    public void setSize(int size) {
        this.size = size;
    }

    //
    public List<Object> getDatas() {
        return this.datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }

    public List<CellColumnRule> getColumnRules() {
        return this.columnRules;
    }

    public void setColumnRules(List<CellColumnRule> columnRules) {
        this.columnRules = columnRules;
    }
}
