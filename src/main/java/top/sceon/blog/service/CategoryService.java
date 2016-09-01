package top.sceon.blog.service;

import org.springframework.stereotype.Service;
import top.sceon.blog.dao.CategoryDao;
import top.sceon.blog.entity.Category;

import javax.annotation.Resource;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Service
public class CategoryService extends BaseServiceImpl<Category, Integer> implements IBaseService<Category, Integer> {

    private CategoryDao categoryDao;

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    @Resource
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
        super.setBaseDao(categoryDao);
    }
}
