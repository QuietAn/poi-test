package red.silence.model; /***********************************************************************
 * Module:  ExcelRowRule.java
 * Author:  Quiet
 * Purpose: Defines the Class ExcelRowRule
 ***********************************************************************/

import red.silence.Interface.AbstractRowRule;

import java.util.Date;
import java.util.List;

/** excel模板行标签规则 */
public class ExcelRowRule  extends AbstractRowRule {
   /** 主键 */
   private String uuid;
   /** 申报表代码 */
   private String sbbdm;
   /** 申报表码表代码 */
   private String sbbmbDm;
   /** 标签名 */
   private String lableName;
   /** 读取数据数量 */
   private Integer size;
   /** 父id */
   private String pid;
   /** 扩展类型，待定义 */
   private String extType;
   /** 排序字段 */
   private Integer sOrder;
   /** 创建时间 */
   private Date createTime;
   /** 更新时间 */
   private Date updateTime;
   /** 是否有效 */
   private Date isvalidate;
   /** 创建人 */
   private String creator;
   /** 修改人 */
   private String modifier;

   /**关联的所有单元格*/
   private List<ExcelRowColumn> excelRules;

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
    * 获取 读取数据数量
    *
    * @return size 读取数据数量
    */
   public Integer getSize() {
      return this.size;
   }

   /**
    * 设置 读取数据数量
    *
    * @param size 读取数据数量
    */
   public void setSize(Integer size) {
      this.size = size;
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
    * 获取 扩展类型，待定义
    *
    * @return extType 扩展类型，待定义
    */
   public String getExtType() {
      return this.extType;
   }

   /**
    * 设置 扩展类型，待定义
    *
    * @param extType 扩展类型，待定义
    */
   public void setExtType(String extType) {
      this.extType = extType;
   }

   /**
    * 获取 排序字段
    *
    * @return sOrder 排序字段
    */
   public Integer getSOrder() {
      return this.sOrder;
   }

   /**
    * 设置 排序字段
    *
    * @param sOrder 排序字段
    */
   public void setSOrder(Integer sOrder) {
      this.sOrder = sOrder;
   }

   /**
    * 获取 创建时间
    *
    * @return createTime 创建时间
    */
   public Date getCreateTime() {
      return this.createTime;
   }

   /**
    * 设置 创建时间
    *
    * @param createTime 创建时间
    */
   public void setCreateTime(Date createTime) {
      this.createTime = createTime;
   }

   /**
    * 获取 更新时间
    *
    * @return updateTime 更新时间
    */
   public Date getUpdateTime() {
      return this.updateTime;
   }

   /**
    * 设置 更新时间
    *
    * @param updateTime 更新时间
    */
   public void setUpdateTime(Date updateTime) {
      this.updateTime = updateTime;
   }

   /**
    * 获取 是否有效
    *
    * @return isvalidate 是否有效
    */
   public Date getIsvalidate() {
      return this.isvalidate;
   }

   /**
    * 设置 是否有效
    *
    * @param isvalidate 是否有效
    */
   public void setIsvalidate(Date isvalidate) {
      this.isvalidate = isvalidate;
   }

   /**
    * 获取 创建人
    *
    * @return creator 创建人
    */
   public String getCreator() {
      return this.creator;
   }

   /**
    * 设置 创建人
    *
    * @param creator 创建人
    */
   public void setCreator(String creator) {
      this.creator = creator;
   }

   /**
    * 获取 修改人
    *
    * @return modifier 修改人
    */
   public String getModifier() {
      return this.modifier;
   }

   /**
    * 设置 修改人
    *
    * @param modifier 修改人
    */
   public void setModifier(String modifier) {
      this.modifier = modifier;
   }

   /**
    * 获取 关联的所有单元格
    *
    * @return excelRules 关联的所有单元格
    */
   public List<ExcelRowColumn> getExcelRules() {
      return this.excelRules;
   }

   /**
    * 设置 关联的所有单元格
    *
    * @param excelRules 关联的所有单元格
    */
   public void setExcelRules(List<ExcelRowColumn> excelRules) {
      this.excelRules = excelRules;
   }

   @Override
   public String toString() {
      return "ExcelRowRule{" +
              "uuid='" + uuid + '\'' +
              ", lableName='" + lableName + '\'' +
              ", pid='" + pid + '\'' +
              ", excelRules=" + excelRules +
              '}';
   }
}