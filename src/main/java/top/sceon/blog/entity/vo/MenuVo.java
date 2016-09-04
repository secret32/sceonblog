package top.sceon.blog.entity.vo;

import top.sceon.blog.entity.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhouwei
 * @since 2016/9/3
 */
public class MenuVo {

    private Menu menu;
    private List<Menu> children;
    private String linkUrl;

    public MenuVo(Menu menu, List<Menu> children, String linkUrl) {
        this.menu = menu;
        this.children = children;
        this.linkUrl = linkUrl;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public static List<MenuVo> newList(List<Menu> menus) {
        List<MenuVo> list = new ArrayList<>(menus.size());
        for (Menu m : menus) {
            list.add(new MenuVo(m, Collections.EMPTY_LIST, ""));
        }
        return list;
    }
}
