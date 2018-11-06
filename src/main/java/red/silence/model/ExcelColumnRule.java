package red.silence.model;
/***********************************************************************
 * Module:  ExcelColumnRule.java
 * Author:  Quiet
 * Purpose: Defines the Class ExcelColumnRule
 ***********************************************************************/

import org.apache.poi.ss.util.CellAddress;
import red.silence.Interface.AbstractColumnRule;

import java.util.Date;

public class ExcelColumnRule extends AbstractColumnRule{
   /** 主键 */
   private String uuid;
   /** 申报表代码 */
   private String sbbdm;
   /** 申报表码表代码 */
   private String sbbmbDm;
   /** 标签名 */
   private String lableName;
   /** 数据类型 */
   private String dataType;
   /** 扩展类型：待定义 */
   private String extType;
   /** 父id */
   private String pid;
   /** 排序字段 */
   private double sOrder;
   /** 创建时间 */
   private Date createTime;
   /** 更新时间 */
   private Date updateTime;
   /** 是否有效 */
   private String isvalidate;
   /** 创建人 */
   private String creator;
   /** 修改人 */
   private String modifier;

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

   /**
    * 获取 扩展类型：待定义
    *
    * @return extType 扩展类型：待定义
    */
   public String getExtType() {
      return this.extType;
   }

   /**
    * 设置 扩展类型：待定义
    *
    * @param extType 扩展类型：待定义
    */
   public void setExtType(String extType) {
      this.extType = extType;
   }

   /**
    * 获取 父id
    *
    * @return pid 父id
    */
   @Override
   public String getPid() {
      return this.pid;
   }

   @Override
   public int getIndex(CellAddress cellAddress) {
      return cellAddress.getColumn();
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
    * 获取 排序字段
    *
    * @return sOrder 排序字段
    */
   public double getSOrder() {
      return this.sOrder;
   }

   /**
    * 设置 排序字段
    *
    * @param sOrder 排序字段
    */
   public void setSOrder(double sOrder) {
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
   public String getIsvalidate() {
      return this.isvalidate;
   }

   /**
    * 设置 是否有效
    *
    * @param isvalidate 是否有效
    */
   public void setIsvalidate(String isvalidate) {
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
}