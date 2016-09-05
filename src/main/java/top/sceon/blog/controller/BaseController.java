package top.sceon.blog.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import top.sceon.blog.service.IBaseService;
import top.sceon.blog.util.Pages;
import top.sceon.blog.util.Results;
import top.sceon.common.util.StringUtil;

import javax.servlet.http.HttpSession;

/**
 * @author zhou_wei
 * @date 8/29/2016
 */
public class BaseController {

    @Autowired
    protected HttpSession session;

    /********************* return ***********************/

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

    final protected JSONObject e(Results r) {
        JSONObject result = new JSONObject();
        result.put(RESULT, r.getCode());
        result.put(ERROR, r.getMsg());
        return result;
    }

    /********************** return end ************************/

    /********************** invoke service *******************/

    protected <T> void list(Log logger, IBaseService<T, Integer> service, ModelAndView result, Pages<T> pages) {
        if (pages == null) {
            pages = new Pages<T>();
        }
        try {
            pages = service.findPages(pages);
            result.addObject("pages", pages);
        } catch (Exception e) {
            logger.error(e);
            result.addObject("error", e.getMessage());
        }
    }

    protected <T> JSONObject listJson(Log logger, IBaseService<T, Integer> service, Pages<T> pages) {
        JSONObject result = new JSONObject();
        if (pages == null) {
            pages = new Pages<T>();
        }
        try {
            pages = service.findPages(pages);
            result.put("pages", pages);
            s(result);
        } catch (Exception e) {
            logger.error(e);
            e(result, e);
        }
        return result;
    }

    protected <T> JSONObject save(Log logger, IBaseService<T, Integer> service, T entity) {
        JSONObject result = new JSONObject();
        try {
            service.saveOrUpdate(entity);
            result.put("entity", entity);
            s(result);
        } catch (Exception e) {
            logger.error(e);
            e(result, e);
        }
        return result;
    }

    protected <T> JSONObject get(Log logger, IBaseService<T, Integer> service, int id) {
        JSONObject result = new JSONObject();
        try {
            T entity = service.getById(id);
            result.put(StringUtil.uncapitalize(entity.getClass().getName()), entity);
            s(result);
        } catch (Exception e) {
            logger.error(e);
            e(result, e);
        }
        return result;
    }

    protected <T> JSONObject del(Log logger, IBaseService<T, Integer> service, int id) {
        JSONObject result = new JSONObject();
        try {
            service.delete(id);
            s(result);
        } catch (Exception e) {
            logger.error(e);
            e(result, e);
        }
        return result;
    }

    /********************** invoke service end *******************/

}
