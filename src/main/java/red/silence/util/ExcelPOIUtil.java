package red.silence.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel 数据读取工具类
 * @author WangDongling
 * @version 1.0
 * @date 2018-10-31
 */
public class ExcelPOIUtil {

    private FormulaEvaluator formulaEvaluator;
    private Workbook wb;
    private List<Sheet> sheets;

    /**
     * 构造方法
     * @param path 文件path
     * @throws IOException
     */
    public ExcelPOIUtil(Path path) throws IOException {
        wb = getWorkBook(path);
        formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
    }

    /**
     * 读取所有sheet
     * @return
     */
    public List<Sheet> readSheets() {
        if(null != sheets) {
            return sheets;
        }
        sheets = readSheets(wb);
        return new ArrayList<>(sheets);
    }

    /**
     * 读取单元格内容支持公式计算
     * @param cell
     * @return
     */
    public Object getCellValue(Cell cell) {
        if(cell.getCellTypeEnum() == CellType.FORMULA) {
            return getCellValue(formulaEvaluator.evaluate(cell));
        }

        return getValue(cell);
    }

    /**
     * 通过workbook 读取cell；
     *  支持公式单元格
     * @param wb
     * @param cell
     * @return
     */
    public static Object getCellValue(Workbook wb, Cell cell) {
        if(cell.getCellTypeEnum() == CellType.FORMULA) {
            FormulaEvaluator fEvaluator = wb.getCreationHelper()
                    .createFormulaEvaluator();
            return getCellValue(fEvaluator.evaluate(cell));
        }

        return getValue(cell);
    }

    /**
     * 读取CellValue 单元格内容
     * @param cellValue
     * @return
     */
    public static Object getCellValue(CellValue cellValue) {
        switch (cellValue.getCellTypeEnum()) {
            case STRING:
                return cellValue.getStringValue();
            case NUMERIC:
                return cellValue.getNumberValue();
            default:
                return null;
        }

    }

    /**
     * 读取workbook
     * @param path
     * @return
     * @throws IOException
     */
    public static Workbook getWorkBook(Path path) throws IOException {
        HSSFWorkbook wb = null;
        try(NPOIFSFileSystem fs = new NPOIFSFileSystem(path.toFile())) {
            wb = new HSSFWorkbook(fs.getRoot(), true);
        }

        return wb;
    }

    /**
     * 读取所有sheet
     * @param wb
     * @return
     */
    public static List<Sheet> readSheets(Workbook wb) {
        return getList(wb);
    }

    /**
     * 读取所有行
     * @param sheet
     * @return
     */
    public static List<Row> getRows(Sheet sheet) {
        return getList(sheet);
    }

    /**
     * 读取行的所有单元格
     * @param row
     * @return
     */
    public static List<Cell> getCells(Row row) {
        return getList(row);
    }

    /**
     * 读取指定类型的单元格内容，格式不一致返回null;
     * <b>公式返回公式字符串</b>
     * @param cell
     * @param cellType
     * @return
     */
    public static Object getValueByType(Cell cell, CellType cellType) {

        if(cell.getCellTypeEnum() == cellType) {
            return getValue(cell);
        } else {
            return null;
        }
    }

    /**
     * 读取单元格内容：
     * <b>公式返回公式字符串</b>
     * @param cell
     * @return
     */
    public static Object getValue(Cell cell) {
        Object obj = null;
        switch (cell.getCellTypeEnum()){
            case _NONE:
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    obj = cell.getDateCellValue();
                } else {
                    obj = cell.getNumericCellValue();
                }
                break;
            case BLANK:
                obj = "";
                break;
            case ERROR:
                obj = cell.getErrorCellValue();
                break;
            case STRING:
                obj = cell.getStringCellValue();
                break;
            case BOOLEAN:
                obj = cell.getBooleanCellValue();
                break;
            case FORMULA:
                obj = cell.getCellFormula();
                break;
            default:
                break;
        }

        return obj;
    }

    /*
     * 遍历 iterable
     */
    private static <T> List<T> getList(Iterable<T> iterable) {
        List<T> result = new ArrayList<>();
        for(T t : iterable){
            if(null != t) {
                result.add(t);
            }
        }

        return result;
    }

}
