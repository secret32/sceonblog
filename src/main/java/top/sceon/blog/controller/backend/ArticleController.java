package top.sceon.blog.controller.backend;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import top.sceon.blog.controller.BaseController;
import top.sceon.blog.entity.Article;
import top.sceon.blog.service.ArticleService;
import top.sceon.blog.util.Pages;

import javax.annotation.Resource;

/**
 * @author zhou_wei
 * @date 8/31/2016
 */
@Controller
@RequestMapping(path = "/manage/article")
public class ArticleController extends BaseController {

    final private Log logger = LogFactory.getLog(ArticleController.class);

    @Resource
    private ArticleService articleService;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public ModelAndView list(Pages<Article> pages) {
        ModelAndView result = new ModelAndView("/backend/articleList");
        if (pages == null) {
            pages = new Pages<>();
        }
        pages = articleService.findPages(pages);
        result.addObject("pages", pages);
        return result;
    }

}
