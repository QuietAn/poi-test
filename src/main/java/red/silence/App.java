package red.silence;

import com.alibaba.fastjson.JSON;
import org.apache.poi.ss.usermodel.Row;
import red.silence.model.CellColumnRule;
import red.silence.model.CellRowRule;
import red.silence.util.DataMatchUtil;
import red.silence.util.ExcelPOIUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Path path = Paths.get("resource/test.xls").toAbsolutePath();

        try {
            List<Row> rows = ExcelPOIUtils.readFile(path);

            List<CellColumnRule> columnRules = new ArrayList<>();

            CellColumnRule columnRule = new CellColumnRule();
            columnRule.setLableName("月收入");
            columnRules.add(columnRule);

            CellColumnRule columnRule2 = new CellColumnRule();
            columnRule2.setLableName("年收入");
            columnRules.add(columnRule2);

            List<CellRowRule> cellRowRules = new ArrayList<>();
            CellRowRule cellRowRule = new CellRowRule();
            cellRowRule.setColumnRules(columnRules);
            cellRowRule.setLableName("桌子");
            cellRowRules.add(cellRowRule);


            CellRowRule cellRowRule2 = new CellRowRule();
            cellRowRule2.setColumnRules(columnRules);
            cellRowRule2.setLableName("椅子");
            cellRowRules.add(cellRowRule2);

            CellRowRule cellRowRule3 = new CellRowRule();
            cellRowRule3.setColumnRules(columnRules);
            cellRowRule3.setLableName("柜子");
            cellRowRules.add(cellRowRule3);


            cellRowRules = DataMatchUtil.match(cellRowRules,rows);

            System.out.println(JSON.toJSONString(cellRowRules));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
