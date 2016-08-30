package top.sceon.common.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author zhou_wei
 * @date 8/29/2016
 */
public class HashUtil {

    public static String sha1(String s) {
        return DigestUtils.sha1Hex(s);
    }

}
