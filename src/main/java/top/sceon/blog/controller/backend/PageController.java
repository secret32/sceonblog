package top.sceon.blog.controller.backend;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.sceon.blog.controller.BaseController;
import top.sceon.blog.entity.Page;
import top.sceon.blog.service.PageService;
import top.sceon.blog.util.Pages;

import javax.annotation.Resource;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Controller
@RequestMapping(path = "/manage/page")
public class PageController extends BaseController {

    final private Log logger = LogFactory.getLog(PageController.class);

    @Resource
    private PageService pageService;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public ModelAndView list(Pages<Page> pages) {
        ModelAndView result = new ModelAndView("/backend/pageList");
        super.list(logger, pageService, result, pages);
        return result;
    }

    @RequestMapping(path = "/listJson", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject listJson(Pages<Page> pages) {
        return super.listJson(logger, pageService, pages);
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject save(Page page) {
        return super.save(logger, pageService, page);
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject get(int id) {
        return super.get(logger, pageService, id);
    }

    @RequestMapping(path = "/del", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject del(int id) {
        return super.del(logger, pageService, id);
    }

    @RequestMapping(path = "/addArticles")
    @ResponseBody
    public JSONObject addArticles(int[] articleIds) {
        // TODO
        return null;
    }

    @RequestMapping(path = "/addCategories")
    @ResponseBody
    public JSONObject addCategories(int[] categoryIds) {
        // TODO
        return null;
    }

    @RequestMapping(path = "/addNotes")
    @ResponseBody
    public JSONObject addNotes(int[] noteIds) {
        // TODO
        return null;
    }

}
