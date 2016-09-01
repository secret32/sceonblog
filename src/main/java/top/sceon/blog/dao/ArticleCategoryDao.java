package top.sceon.blog.dao;

import org.springframework.stereotype.Repository;
import top.sceon.blog.entity.ArticleCategory;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Repository
public class ArticleCategoryDao extends BaseDaoImpl<ArticleCategory, Integer> implements IBaseDao<ArticleCategory, Integer> {
    public ArticleCategoryDao() {
        super("mapper.ArticleCategoryMapper");
    }
}
