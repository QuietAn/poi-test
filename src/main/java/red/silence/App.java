package red.silence;

import org.junit.Test;
import red.silence.junit.BaseTest;
import red.silence.util.ExcelPOIUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App extends BaseTest
{
    @Test
    public void test()
    {
        Path path = Paths.get("resource/test.xls").toAbsolutePath();

        try {
            ExcelPOIUtil excelPOIUtil = new ExcelPOIUtil(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
