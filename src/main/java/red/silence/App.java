package red.silence;

import com.alibaba.fastjson.JSON;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;
import red.silence.model.ExcelColumnRule;
import red.silence.model.ExcelRowColCustom;
import red.silence.model.ExcelRowColumn;
import red.silence.model.ExcelRowRule;
import red.silence.util.DataMatchUtil;
import red.silence.util.ExcelPOIUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static String uuid_QMYE = UUIDUtil.generateUUID();
    public static String uuid_NCYE = UUIDUtil.generateUUID();

    public static String uuid_LDZC = UUIDUtil.generateUUID();
    public static String uuid_LDZC_HBZJ = UUIDUtil.generateUUID();
    public static String uuid_LDZC_JYXJRZC = UUIDUtil.generateUUID();
    public static String uuid_LDZC_YSPJ = UUIDUtil.generateUUID();
    public static String uuid_LDZC_YSZK = UUIDUtil.generateUUID();

    public static String uuid_LDFZ = UUIDUtil.generateUUID();
    public static String uuid_LDFZ_DQJK = UUIDUtil.generateUUID();
    public static String uuid_LDFZ_JYXJRFZ = UUIDUtil.generateUUID();
    public static String uuid_LDFZ_YFPJ = UUIDUtil.generateUUID();
    public static String uuid_LDFZ_YFZK = UUIDUtil.generateUUID();

    @Test
    public void test() {
        Path path = Paths.get("resource/testX.xlsx").toAbsolutePath();

        ExcelPOIUtil excelPOIUtil = null;
        List<Sheet> sheets = null;
        try {
            excelPOIUtil = new ExcelPOIUtil(path);
            sheets = excelPOIUtil.readSheets();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        List<ExcelRowColCustom> defaultCustoms = new ArrayList<>();
        List<ExcelRowColCustom> customRules = new ArrayList<>();

        List<ExcelColumnRule> columnRules = new ArrayList<>();
        List<ExcelRowRule> rowRules = new ArrayList<>();


        List<ExcelRowColumn> rowColumnList = null;

        ExcelColumnRule columnRule = new ExcelColumnRule();
        columnRule.setPid(null);
        columnRule.setUuid(uuid_QMYE);
        columnRule.setLableName("期末余额");
        //-------------------------------
        //-------------------------------
        ExcelColumnRule columnRule2 = new ExcelColumnRule();
        columnRule2.setPid(null);
        columnRule2.setUuid(uuid_NCYE);
        columnRule2.setLableName("年初余额");

        columnRules.add(columnRule);
        columnRules.add(columnRule2);

        ExcelRowColumn rowColumn = null;
        ExcelRowColumn rowColumn2 = null;

        //*****************************
        //*****************************
        ExcelRowRule rowRule = new ExcelRowRule();
        rowRules.add(rowRule);
        rowRule.setLableName("流动资产：");
        rowRule.setPid(null);
        rowRule.setUuid(uuid_LDZC);


        //**
        rowRule = new ExcelRowRule();
        rowRules.add(rowRule);
        rowRule.setLableName("货币资金");
        rowRule.setPid(uuid_LDZC);
        rowRule.setUuid(uuid_LDZC_HBZJ);

        //--
        rowColumn = new ExcelRowColumn();
        rowColumn2 = new ExcelRowColumn();

        rowColumn.setUuid(UUIDUtil.generateUUID());
        rowColumn2.setUuid(UUIDUtil.generateUUID());
        rowColumn.setExcelRowRule(rowRule);
        rowColumn.setExcelColumnRule(columnRule);
        rowColumn2.setExcelRowRule(rowRule);
        rowColumn2.setExcelColumnRule(columnRule2);
        //---
        rowColumnList = new ArrayList<>();
        rowColumnList.add(rowColumn);
        rowColumnList.add(rowColumn2);
        //--
        rowRule.setExcelRules(rowColumnList);

        //**
        rowRule = new ExcelRowRule();
        rowRules.add(rowRule);
        rowRule.setLableName("交易性金融资产");
        rowRule.setPid(uuid_LDZC);
        rowRule.setUuid(uuid_LDZC_JYXJRZC);

        //--
        rowColumn = new ExcelRowColumn();
        rowColumn2 = new ExcelRowColumn();

        rowColumn.setUuid(UUIDUtil.generateUUID());
        rowColumn2.setUuid(UUIDUtil.generateUUID());
        rowColumn.setExcelRowRule(rowRule);
        rowColumn.setExcelColumnRule(columnRule);
        rowColumn2.setExcelRowRule(rowRule);
        rowColumn2.setExcelColumnRule(columnRule2);
        //---
        rowColumnList = new ArrayList<>();
        rowColumnList.add(rowColumn);
        rowColumnList.add(rowColumn2);
        //--
        rowRule.setExcelRules(rowColumnList);

        //**
        rowRule = new ExcelRowRule();
        rowRules.add(rowRule);
        rowRule.setLableName("应收票据");
        rowRule.setPid(uuid_LDZC);
        rowRule.setUuid(uuid_LDZC_YSPJ);

        //--
        rowColumn = new ExcelRowColumn();
        rowColumn2 = new ExcelRowColumn();

        rowColumn.setUuid(UUIDUtil.generateUUID());
        rowColumn2.setUuid(UUIDUtil.generateUUID());
        rowColumn.setExcelRowRule(rowRule);
        rowColumn.setExcelColumnRule(columnRule);
        rowColumn2.setExcelRowRule(rowRule);
        rowColumn2.setExcelColumnRule(columnRule2);
        //---
        rowColumnList = new ArrayList<>();
        rowColumnList.add(rowColumn);
        rowColumnList.add(rowColumn2);
        //--
        rowRule.setExcelRules(rowColumnList);

        //**
        rowRule = new ExcelRowRule();
        rowRules.add(rowRule);
        rowRule.setLableName("应收账款");
        rowRule.setPid(uuid_LDZC);
        rowRule.setUuid(uuid_LDZC_YSZK);
        //--
        rowColumn = new ExcelRowColumn();
        rowColumn2 = new ExcelRowColumn();

        rowColumn.setUuid(UUIDUtil.generateUUID());
        rowColumn2.setUuid(UUIDUtil.generateUUID());
        rowColumn.setExcelRowRule(rowRule);
        rowColumn.setExcelColumnRule(columnRule);
        rowColumn2.setExcelRowRule(rowRule);
        rowColumn2.setExcelColumnRule(columnRule2);
        //---
        rowColumnList = new ArrayList<>();
        rowColumnList.add(rowColumn);
        rowColumnList.add(rowColumn2);
        //--
        rowRule.setExcelRules(rowColumnList);

        //------------------------------
        //------------------------------
        rowRule = new ExcelRowRule();
        rowRules.add(rowRule);
        rowRule.setLableName("流动负债：");
        rowRule.setPid(null);
        rowRule.setUuid(uuid_LDFZ);

        //**
        rowRule = new ExcelRowRule();
        rowRules.add(rowRule);
        rowRule.setLableName("短期借款");
        rowRule.setPid(uuid_LDFZ);
        rowRule.setUuid(uuid_LDFZ_DQJK);

        //--
        rowColumn = new ExcelRowColumn();
        rowColumn2 = new ExcelRowColumn();

        rowColumn.setUuid(UUIDUtil.generateUUID());
        rowColumn2.setUuid(UUIDUtil.generateUUID());
        rowColumn.setExcelRowRule(rowRule);
        rowColumn.setExcelColumnRule(columnRule);
        rowColumn2.setExcelRowRule(rowRule);
        rowColumn2.setExcelColumnRule(columnRule2);

        //---
        rowColumnList = new ArrayList<>();
        rowColumnList.add(rowColumn);
        rowColumnList.add(rowColumn2);
        //--
        rowRule.setExcelRules(rowColumnList);

        //**
        rowRule = new ExcelRowRule();
        rowRules.add(rowRule);
        rowRule.setLableName("交易性金融负债");
        rowRule.setPid(uuid_LDFZ);
        rowRule.setUuid(uuid_LDFZ_JYXJRFZ);

        //--
        rowColumn = new ExcelRowColumn();
        rowColumn2 = new ExcelRowColumn();

        rowColumn.setUuid(UUIDUtil.generateUUID());
        rowColumn2.setUuid(UUIDUtil.generateUUID());
        rowColumn.setExcelRowRule(rowRule);
        rowColumn.setExcelColumnRule(columnRule);
        rowColumn2.setExcelRowRule(rowRule);
        rowColumn2.setExcelColumnRule(columnRule2);
        //---
        rowColumnList = new ArrayList<>();
        rowColumnList.add(rowColumn);
        rowColumnList.add(rowColumn2);
        //--
        rowRule.setExcelRules(rowColumnList);

        //**
        rowRule = new ExcelRowRule();
        rowRules.add(rowRule);
        rowRule.setLableName("应付票据");
        rowRule.setPid(uuid_LDFZ);
        rowRule.setUuid(uuid_LDFZ_YFPJ);

        //--
        rowColumn = new ExcelRowColumn();
        rowColumn2 = new ExcelRowColumn();

        rowColumn.setUuid(UUIDUtil.generateUUID());
        rowColumn2.setUuid(UUIDUtil.generateUUID());
        rowColumn.setExcelRowRule(rowRule);
        rowColumn.setExcelColumnRule(columnRule);
        rowColumn2.setExcelRowRule(rowRule);
        rowColumn2.setExcelColumnRule(columnRule2);
        //---
        rowColumnList = new ArrayList<>();
        rowColumnList.add(rowColumn);
        rowColumnList.add(rowColumn2);
        //--
        rowRule.setExcelRules(rowColumnList);

        //**
        rowRule = new ExcelRowRule();
        rowRules.add(rowRule);
        rowRule.setLableName("应付账款");
        rowRule.setPid(uuid_LDFZ);
        rowRule.setUuid(uuid_LDFZ_YFZK);
        //--

        //--
        rowColumn = new ExcelRowColumn();
        rowColumn2 = new ExcelRowColumn();

        rowColumn.setUuid(UUIDUtil.generateUUID());
        rowColumn2.setUuid(UUIDUtil.generateUUID());
        rowColumn.setExcelRowRule(rowRule);
        rowColumn.setExcelColumnRule(columnRule);
        rowColumn2.setExcelRowRule(rowRule);
        rowColumn2.setExcelColumnRule(columnRule2);
        //---
        rowColumnList = new ArrayList<>();
        rowColumnList.add(rowColumn);
        rowColumnList.add(rowColumn2);
        //--
        rowRule.setExcelRules(rowColumnList);

        DataMatchUtil.match(excelPOIUtil, sheets.get(0), defaultCustoms, customRules, columnRules, rowRules);

        System.out.println(JSON.toJSONString(rowRules));
    }

    public static void main(String[] args) {
        App app = new App();
        app.test();
    }
}
