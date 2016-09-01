package top.sceon.blog.dao;

import org.springframework.stereotype.Repository;
import top.sceon.blog.entity.Category;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Repository
public class CategoryDao extends BaseDaoImpl<Category, Integer> implements IBaseDao<Category, Integer> {
    public CategoryDao() {
        super("category");
    }
}
