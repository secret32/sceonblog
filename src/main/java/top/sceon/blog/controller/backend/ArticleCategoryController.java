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
import top.sceon.blog.entity.ArticleCategory;
import top.sceon.blog.service.ArticleCategoryService;
import top.sceon.blog.util.Pages;
import top.sceon.blog.util.Results;
import top.sceon.blog.util.SessionKey;
import top.sceon.common.util.ElementStatus;
import top.sceon.common.util.StringUtil;

import javax.annotation.Resource;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Controller
@RequestMapping(path = "/manage/articleCategory")
public class ArticleCategoryController extends BaseController {

    final private Log logger = LogFactory.getLog(ArticleCategoryController.class);

    @Resource
    private ArticleCategoryService articleCategoryService;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public ModelAndView list(Pages<ArticleCategory> pages) {
        ModelAndView result = new ModelAndView("/backend/categoryList");
        super.list(logger, articleCategoryService, result, pages);
        return result;
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject save(ArticleCategory articleCategory) {
        Integer userId = (Integer) session.getAttribute(SessionKey.USER_ID);
        if (articleCategory.getId() == null) {
            int count = articleCategoryService.countByProperties(new String[] {"userId", "exactName"},
                    new Object[] {userId, articleCategory.getName()});
            if (count > 0) {
                return e(Results.CATEGORY_EXISTS);
            }
            articleCategory.setUserId(userId);
            articleCategory.setGuid(StringUtil.guid());
            articleCategory.setStatus(ElementStatus.OFFLINE);
        }
        return super.save(logger, articleCategoryService, articleCategory);
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject get(int id) {
        return super.get(logger, articleCategoryService, id);
    }

    @RequestMapping(path = "/del", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject del(int id) {
        return super.del(logger, articleCategoryService, id);
    }

}
