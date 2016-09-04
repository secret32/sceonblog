package top.sceon.blog.service;

import org.springframework.stereotype.Service;
import top.sceon.blog.dao.MenuDao;
import top.sceon.blog.entity.Menu;

import javax.annotation.Resource;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Service
public class MenuService extends BaseServiceImpl<Menu, Integer> implements IBaseService<Menu, Integer> {
    private MenuDao menuDao;

    public MenuDao getMenuDao() {
        return menuDao;
    }

    @Resource
    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
        super.setBaseDao(menuDao);
    }

    public void updatePage(int id, int pageId) {
        menuDao.updatePage(id, pageId);
    }
}
