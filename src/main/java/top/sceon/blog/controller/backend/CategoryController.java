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
import top.sceon.blog.entity.Category;
import top.sceon.blog.service.CategoryService;
import top.sceon.blog.util.Pages;

import javax.annotation.Resource;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Controller
@RequestMapping(path = "/manage/category")
public class CategoryController extends BaseController {

    final private Log logger = LogFactory.getLog(CategoryController.class);

    @Resource
    private CategoryService categoryService;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public ModelAndView list(Pages<Category> pages) {
        ModelAndView result = new ModelAndView("/backend/categoryList");
        super.list(logger, categoryService, result, pages);
        return result;
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject save(Category category) {
        return super.save(logger, categoryService, category);
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject get(int id) {
        return super.get(logger, categoryService, id);
    }

    @RequestMapping(path = "/del", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject del(int id) {
        return super.del(logger, categoryService, id);
    }

}
