package top.sceon.blog.dao;

import org.springframework.stereotype.Repository;
import top.sceon.blog.entity.Page;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Repository
public class PageDao extends BaseDaoImpl<Page, Integer> implements IBaseDao<Page, Integer> {
    public PageDao() {
        super("page");
    }
}
