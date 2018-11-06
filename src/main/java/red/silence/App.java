package red.silence;

import org.junit.Test;
import red.silence.junit.BaseTest;

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

        /*try {
           //List<Row> rows = ExcelPOIUtil.readFile(path);

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
