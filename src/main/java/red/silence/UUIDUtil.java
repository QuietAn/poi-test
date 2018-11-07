package red.silence;

import java.util.UUID;

/**
 * @author WangDongling
 * @version 1.0
 * @date 2018-11-07
 */
public class UUIDUtil {
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
