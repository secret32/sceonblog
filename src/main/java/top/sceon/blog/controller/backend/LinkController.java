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
import top.sceon.blog.entity.Link;
import top.sceon.blog.service.LinkService;
import top.sceon.blog.util.Pages;

import javax.annotation.Resource;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Controller
@RequestMapping(path = "/manage/link")
public class LinkController extends BaseController {

    final private Log logger = LogFactory.getLog(LinkController.class);

    @Resource
    private LinkService linkService;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public ModelAndView list(Pages<Link> pages) {
        ModelAndView result = new ModelAndView("/backend/linkList");
        super.list(logger, linkService, result, pages);
        return result;
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject save(Link link) {
        return super.save(logger, linkService, link);
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject get(int id) {
        return super.get(logger, linkService, id);
    }

    @RequestMapping(path = "/del", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject del(int id) {
        return super.del(logger, linkService, id);
    }

}
