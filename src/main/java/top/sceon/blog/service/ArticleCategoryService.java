package top.sceon.blog.service;

import org.springframework.stereotype.Service;
import top.sceon.blog.dao.ArticleCategoryDao;
import top.sceon.blog.entity.ArticleCategory;

import javax.annotation.Resource;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Service
public class ArticleCategoryService extends BaseServiceImpl<ArticleCategory, Integer> implements IBaseService<ArticleCategory, Integer> {

    private ArticleCategoryDao articleCategoryDao;

    public ArticleCategoryDao getArticleCategoryDao() {
        return articleCategoryDao;
    }

    @Resource
    public void setArticleCategoryDao(ArticleCategoryDao articleCategoryDao) {
        this.articleCategoryDao = articleCategoryDao;
        super.setBaseDao(articleCategoryDao);
    }
}
