package top.sceon.blog.util;

/**
 * @author zhou_wei
 * @date 9/5/2016
 */
public enum Results {

    // category
    CATEGORY_EXISTS(101, "category exists"),
    ;

    int code;
    String msg;

    Results(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
