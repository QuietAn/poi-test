package red.silence.model; /***********************************************************************
 * Module:  ExcelRowColCustom.java
 * Author:  Quiet
 * Purpose: Defines the Class ExcelRowColCustom
 ***********************************************************************/

import java.util.Date;

/** 用户行列自定义规则 */
public class ExcelRowColCustom<T> {
   /** 主键 */
   private String uuid;
   /** 关联的行或列uuid；
    * CELL_TYPE：1，取ROW_RULE：UUID;
    * CELL_TYPE：2，取COLNUM_RULE：UUID; */
   private String refUuid;
   /** 纳税人序号 */
   private String nsrxh;
   /** 申报表代码 */
   private String sbbdm;
   /** 申报表码表代码 */
   private String sbbmbDm;
   /** 标签名 */
   private String labelName;
   /** 1：行标签； 2：列表签 */
   private String cellType;
   /** 软件类型：金蝶，用友，其他等 */
   private String softType;
   /** 扩展类型，1：系统默认规则，2：用户自定义规则 */
   private String extType;
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
    * 获取 关联的行或列uuid；     CELL_TYPE：1，取ROW_RULE：UUID;     CELL_TYPE：2，取COLNUM_RULE：UUID;
    *
    * @return refUuid 关联的行或列uuid；     CELL_TYPE：1，取ROW_RULE：UUID;     CELL_TYPE：2，取COLNUM_RULE：UUID;
    */
   public String getRefUuid() {
      return this.refUuid;
   }

   /**
    * 设置 关联的行或列uuid；     CELL_TYPE：1，取ROW_RULE：UUID;     CELL_TYPE：2，取COLNUM_RULE：UUID;
    *
    * @param refUuid 关联的行或列uuid；     CELL_TYPE：1，取ROW_RULE：UUID;     CELL_TYPE：2，取COLNUM_RULE：UUID;
    */
   public void setRefUuid(String refUuid) {
      this.refUuid = refUuid;
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
    * @return labelName 标签名
    */
   public String getLabelName() {
      return this.labelName;
   }

   /**
    * 设置 标签名
    *
    * @param labelName 标签名
    */
   public void setLabelName(String labelName) {
      this.labelName = labelName;
   }

   /**
    * 获取 1：行标签； 2：列表签
    *
    * @return cellType 1：行标签； 2：列表签
    */
   public String getCellType() {
      return this.cellType;
   }

   /**
    * 设置 1：行标签； 2：列表签
    *
    * @param cellType 1：行标签； 2：列表签
    */
   public void setCellType(String cellType) {
      this.cellType = cellType;
   }

   /**
    * 获取 软件类型：金蝶，用友，其他等
    *
    * @return softType 软件类型：金蝶，用友，其他等
    */
   public String getSoftType() {
      return this.softType;
   }

   /**
    * 设置 软件类型：金蝶，用友，其他等
    *
    * @param softType 软件类型：金蝶，用友，其他等
    */
   public void setSoftType(String softType) {
      this.softType = softType;
   }

   /**
    * 获取 扩展类型，1：系统默认规则，2：用户自定义规则
    *
    * @return extType 扩展类型，1：系统默认规则，2：用户自定义规则
    */
   public String getExtType() {
      return this.extType;
   }

   /**
    * 设置 扩展类型，1：系统默认规则，2：用户自定义规则
    *
    * @param extType 扩展类型，1：系统默认规则，2：用户自定义规则
    */
   public void setExtType(String extType) {
      this.extType = extType;
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
}