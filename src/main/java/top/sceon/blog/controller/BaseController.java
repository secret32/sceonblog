package top.sceon.blog.controller;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zhou_wei
 * @date 8/29/2016
 */
public class BaseController {

    final private String RESULT = "result";
    final private String ERROR = "error";

    final private int SUCCESS = 1;
    final private int EXCEPTION = 2;
    final private int UNDEF = -119;

    final protected void s(JSONObject result) {
        result.put(RESULT, SUCCESS);
    }

    final protected void f(JSONObject result, int code, String error) {
        if (code == 1 || code == 2) {
            code = UNDEF;
        }
        result.put(RESULT, code);
        result.put(ERROR, error);
    }

    final protected void e(JSONObject result, Exception e) {
        result.put(RESULT, EXCEPTION);
        result.put(ERROR, e.getMessage());
    }

}
