package top.sceon.blog.dao;

import org.springframework.stereotype.Repository;
import top.sceon.blog.entity.Menu;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Repository
public class MenuDao extends BaseDaoImpl<Menu, Integer> implements IBaseDao<Menu, Integer> {
    public MenuDao() {
        super("menu");
    }
}
