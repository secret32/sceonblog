package top.sceon.blog.dao;

import org.springframework.stereotype.Repository;
import top.sceon.blog.entity.Menu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Repository
public class MenuDao extends BaseDaoImpl<Menu, Integer> implements IBaseDao<Menu, Integer> {
    public MenuDao() {
        super("mapper.MenuMapper");
    }

    public void updatePage(int id, int pageId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("pageId", pageId);
        getSqlSession().update(namespace + ".updatePage", params);
    }
}
