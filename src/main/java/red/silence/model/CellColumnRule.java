package red.silence.model;

/**
 * @author WangDongling
 * @version 1.0
 * @date 2018-10-31
 */
public class CellColumnRule extends Cell{
    //行UUID
    private String rowUuid;

    //数据格式
    private String dataType;

    /**
     * 获取 行UUID
     *
     * @return rowUuid 行UUID
     */
    public String getRowUuid() {
        return this.rowUuid;
    }

    /**
     * 设置 行UUID
     *
     * @param rowUuid 行UUID
     */
    public void setRowUuid(String rowUuid) {
        this.rowUuid = rowUuid;
    }

    /**
     * 获取 数据格式
     *
     * @return dataType 数据格式
     */
    public String getDataType() {
        return this.dataType;
    }

    /**
     * 设置 数据格式
     *
     * @param dataType 数据格式
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
