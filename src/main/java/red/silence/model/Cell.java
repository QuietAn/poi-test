package red.silence.model;

/**
 * @author WangDongling
 * @version 1.0
 * @date 2018-10-31
 */
public class Cell {
    //主键
    private String uuid;
    //申报表代码
    private String sbbdm;
    //申报表码表代码
    private String sbbmbDm;
    //标签名
    private String lableName;
    //父id
    private String pid;
    //类型：1,2,3
    private String type;
    //排序
    private String order;

    /**
     * 获取 主键
     *
     * @return uuid 主键
     */
    public String getUuid() {
        return this.uuid;
    }

    /**
     * 设置 主键
     *
     * @param uuid 主键
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取 申报表代码
     *
     * @return sbbdm 申报表代码
     */
    public String getSbbdm() {
        return this.sbbdm;
    }

    /**
     * 设置 申报表代码
     *
     * @param sbbdm 申报表代码
     */
    public void setSbbdm(String sbbdm) {
        this.sbbdm = sbbdm;
    }

    /**
     * 获取 申报表代码码表
     *
     * @return sbbmbDm 申报表代码码表
     */
    public String getSbbmbDm() {
        return this.sbbmbDm;
    }

    /**
     * 设置 申报表代码码表
     *
     * @param sbbmbDm 申报表代码码表
     */
    public void setSbbmbDm(String sbbmbDm) {
        this.sbbmbDm = sbbmbDm;
    }

    /**
     * 获取 标签名
     *
     * @return lableName 标签名
     */
    public String getLableName() {
        return this.lableName;
    }

    /**
     * 设置 标签名
     *
     * @param lableName 标签名
     */
    public void setLableName(String lableName) {
        this.lableName = lableName;
    }

    /**
     * 获取 父id
     *
     * @return pid 父id
     */
    public String getPid() {
        return this.pid;
    }

    /**
     * 设置 父id
     *
     * @param pid 父id
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * 获取 类型：123
     *
     * @return type 类型：123
     */
    public String getType() {
        return this.type;
    }

    /**
     * 设置 类型：123
     *
     * @param type 类型：123
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取 排序
     *
     * @return order 排序
     */
    public String getOrder() {
        return this.order;
    }

    /**
     * 设置 排序
     *
     * @param order 排序
     */
    public void setOrder(String order) {
        this.order = order;
    }
}
