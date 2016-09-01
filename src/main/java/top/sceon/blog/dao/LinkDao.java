package top.sceon.blog.dao;

import org.springframework.stereotype.Repository;
import top.sceon.blog.entity.Link;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Repository
public class LinkDao extends BaseDaoImpl<Link, Integer> implements IBaseDao<Link, Integer> {
    public LinkDao() {
        super("link");
    }
}
