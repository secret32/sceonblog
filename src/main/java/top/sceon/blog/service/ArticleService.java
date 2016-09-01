package top.sceon.blog.service;

import org.springframework.stereotype.Service;
import top.sceon.blog.entity.Article;

/**
 * @author zhou_wei
 * @date 8/31/2016
 */
@Service
public class ArticleService extends BaseServiceImpl<Article, Integer> implements IBaseService<Article, Integer> {
}
