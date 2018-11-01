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
}
