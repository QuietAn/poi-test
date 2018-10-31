package red.silence.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author WangDongling
 * @version 1.0
 * @date 2018-10-31
 */
public class ExcelPOIUtils {
    private Path path;

    public ExcelPOIUtils(Path path) {
        this.path = path;
    }

    public List<Object> readList() {
        return null;
    }

    public void createFile() throws IOException {
       /* Workbook wb = new HSSFWorkbook();

        wb.createSheet("Sheet one");
        wb.createSheet("Sheet two");

        wb.write(Files.newOutputStream(path, StandardOpenOption.CREATE_NEW));

*/
        NPOIFSFileSystem fs = new NPOIFSFileSystem(path.toFile());
        HSSFWorkbook wb = new HSSFWorkbook(fs.getRoot(), true);

        for(Sheet sheet : wb) {
            System.out.println(sheet.getSheetName());
        }
        fs.close();
    }

    public static void main(String[] args) {
        ExcelPOIUtils epu = new ExcelPOIUtils(Paths.get("resource/test.xls").toAbsolutePath());

        try {
            epu.createFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
