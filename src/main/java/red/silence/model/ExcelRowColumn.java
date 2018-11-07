package red.silence.model;

/***********************************************************************
 * Module:  ExcelRowColumn.java
 * Author:  Quiet
 * Purpose: Defines the Class ExcelRowColumn
 ***********************************************************************/

public class ExcelRowColumn {
   /** 主键 */
   private String uuid;
   /** 前台-模板标签名称 */
   private String labelName;
   /** 该单元格数据类型 */
   private String dataType;
   /** 创建人 */
   private String creator;
   /** 修改人 */
   private String modifier;
   
   /** 引用行规则表主键 */
   private ExcelRowRule excelRowRule;
   private ExcelColumnRule excelColumnRule;

   //数据
   private Object data;

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
    * 获取 前台-模板标签名称
    *
    * @return labelName 前台-模板标签名称
    */
   public String getLabelName() {
      return this.labelName;
   }

   /**
    * 设置 前台-模板标签名称
    *
    * @param labelName 前台-模板标签名称
    */
   public void setLabelName(String labelName) {
      this.labelName = labelName;
   }

   /**
    * 获取 该单元格数据类型
    *
    * @return dataType 该单元格数据类型
    */
   public String getDataType() {
      return this.dataType;
   }

   /**
    * 设置 该单元格数据类型
    *
    * @param dataType 该单元格数据类型
    */
   public void setDataType(String dataType) {
      this.dataType = dataType;
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
    * 获取 引用行规则表主键
    *
    * @return excelRowRule 引用行规则表主键
    */
   public ExcelRowRule getExcelRowRule() {
      return this.excelRowRule;
   }

   /**
    * 设置 引用行规则表主键
    *
    * @param excelRowRule 引用行规则表主键
    */
   public void setExcelRowRule(ExcelRowRule excelRowRule) {
      this.excelRowRule = excelRowRule;
   }

   /**
    * 获取
    *
    * @return excelColumnRule
    */
   public ExcelColumnRule getExcelColumnRule() {
      return this.excelColumnRule;
   }

   /**
    * 设置
    *
    * @param excelColumnRule
    */
   public void setExcelColumnRule(ExcelColumnRule excelColumnRule) {
      this.excelColumnRule = excelColumnRule;
   }

   /**
    * 获取 数据
    *
    * @return data 数据
    */
   public Object getData() {
      return this.data;
   }

   /**
    * 设置 数据
    *
    * @param data 数据
    */
   public void setData(Object data) {
      this.data = data;
   }
}