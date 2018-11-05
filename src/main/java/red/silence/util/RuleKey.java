package red.silence.util;

/**
 * Excel标签名，hashMap存储处理
 * @author WangDongling
 * @version 1.0
 * @date 2018-11-05
 */
public class RuleKey {
    //父id
    private String pid;

    //标签名
    private String lableName;

    public RuleKey(String pid, String lableName) {
        this.pid = pid;
        if(null == lableName) {
            throw new IllegalArgumentException("key con't be null");
        }
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

    @Override
    public int hashCode() {
        return lableName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RuleKey) {
            RuleKey ruleKey = (RuleKey) obj;

            if( ( (pid!=null && pid.equals(ruleKey.pid))
                    || (pid==null && ruleKey.pid==null) )
                    && (lableName.equals(ruleKey.lableName))
                    ) {
                return true;
            }

            return false;
        } else {
            return false;
        }
    }
}
