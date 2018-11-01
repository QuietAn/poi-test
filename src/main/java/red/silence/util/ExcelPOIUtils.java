package red.silence.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WangDongling
 * @version 1.0
 * @date 2018-10-31
 */
public class ExcelPOIUtils {

    public static List<Row> readFile(Path path) throws IOException {
        List<Row> rows = new ArrayList<>();

        NPOIFSFileSystem fs = new NPOIFSFileSystem(path.toFile());
        HSSFWorkbook wb = new HSSFWorkbook(fs.getRoot(), true);

        for(Sheet sheet : wb) {
            for(Row row : sheet) {
                if(null != row) {
                    rows.add(row);
                }
            }
        }

        fs.close();

        return rows;
    }

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

    public static Object getValueByType(Cell cell, CellType cellType) {

        if(cell.getCellTypeEnum() == cellType) {
            return getValue(cell);
        } else {
            return null;
        }
    }
}
