package top.sceon.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * @author zhou_wei
 * @date 8/29/2016
 */
public class StringUtil extends StringUtils {

    public static String guid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
