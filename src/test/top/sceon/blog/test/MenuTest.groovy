package top.sceon.blog.test

import org.junit.Test
import org.springframework.test.annotation.Rollback
import top.sceon.blog.entity.Menu
import top.sceon.blog.service.MenuService
import top.sceon.common.util.ElementStatus
import top.sceon.common.util.StringUtil

import javax.annotation.Resource

class MenuTest extends SpringBaseTest {

    @Resource
    MenuService menuService

    @Rollback(false)
    @Test
    void add() {
        Menu menu = new Menu()
        menu.guid = StringUtil.guid()
        menu.userId = 1
        menu.name = "首页"
        menu.alias = "首页"
        menu.ordinal = 1
        menu.status = ElementStatus.OFFLINE
        menu.pageId = 0
        menu.parentId = 0
        menuService.save(menu)
    }

    @Test
    void list() {
        List<Menu> list = menuService.findByProperty("userId", 1)
        list.each { println it.name }
    }

}