package red.silence.model;

/**
 * @author WangDongling
 * @version 1.0
 * @date 2018-10-31
 */
public class UserCellRule {
    //主键
    private String uuid;
    //纳税人序号
    private String nsrxh;
    /*
     系统规则配置uuid
        TYPE：1时取行规则uuid
        TYPE: 2时取列规则uuid
     */
    private String sysCellRuleUuid;

    //申报表代码
    private String sbbdm;
    //申报表码表代码
    private String sbbmbDm;
    //标签名
    private String lableName;
    //软件名
    private String softType;
    //类型
    private String type;
    //数据类型
    private String dataType;

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
     * 获取 纳税人序号
     *
     * @return nsrxh 纳税人序号
     */
    public String getNsrxh() {
        return this.nsrxh;
    }

    /**
     * 设置 纳税人序号
     *
     * @param nsrxh 纳税人序号
     */
    public void setNsrxh(String nsrxh) {
        this.nsrxh = nsrxh;
    }

    /**
     * 获取 系统规则配置uuid
     * TYPE：1时取行规则uuid
     * TYPE: 2时取列规则uuid
     *
     * @return sysCellRuleUuid
     */
    public String getSysCellRuleUuid() {
        return this.sysCellRuleUuid;
    }

    /**
     * 设置 系统规则配置uuid        TYPE：1时取行规则uuid        TYPE: 2时取列规则uuid
     *
     * @param sysCellRuleUuid
     */
    public void setSysCellRuleUuid(String sysCellRuleUuid) {
        this.sysCellRuleUuid = sysCellRuleUuid;
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
     * 获取 申报表码表代码
     *
     * @return sbbmbDm 申报表码表代码
     */
    public String getSbbmbDm() {
        return this.sbbmbDm;
    }

    /**
     * 设置 申报表码表代码
     *
     * @param sbbmbDm 申报表码表代码
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
     * 获取 软件名
     *
     * @return softType 软件名
     */
    public String getSoftType() {
        return this.softType;
    }

    /**
     * 设置 软件名
     *
     * @param softType 软件名
     */
    public void setSoftType(String softType) {
        this.softType = softType;
    }

    /**
     * 获取 类型
     *
     * @return type 类型
     */
    public String getType() {
        return this.type;
    }

    /**
     * 设置 类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取 数据类型
     *
     * @return dataType 数据类型
     */
    public String getDataType() {
        return this.dataType;
    }

    /**
     * 设置 数据类型
     *
     * @param dataType 数据类型
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
