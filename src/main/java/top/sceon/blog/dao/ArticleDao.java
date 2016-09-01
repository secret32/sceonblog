package top.sceon.blog.dao;

import org.springframework.stereotype.Repository;
import top.sceon.blog.entity.Article;

/**
 * @author zhou_wei
 * @date 8/31/2016
 */
@Repository
public class ArticleDao extends BaseDaoImpl<Article, Integer> implements IBaseDao<Article, Integer> {
    public ArticleDao() {
        super("mapper.ArticleMapper");
    }
}
