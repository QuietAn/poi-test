package red.silence.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author WangDongling
 * @version 1.0
 * @date 2018-10-25
 */
public abstract class BaseTest {
    private Long startTime;

    protected Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @Rule
    public TestName name = new TestName();

    @Before
    public void init() {
        startTime = System.currentTimeMillis();
        logger.info("===Start " + name.getMethodName() + " ===");
    }

    @After
    public void tearDown() throws Exception {
        logger.info("===End " + name.getMethodName() + " ===");
        logger.info("方法运行时间：" + (System.currentTimeMillis() - startTime));
    }
}
