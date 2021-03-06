package top.sceon.blog.test

import org.junit.Test
import org.springframework.test.annotation.Rollback
import top.sceon.blog.entity.Page
import top.sceon.blog.service.PageService
import top.sceon.common.util.ElementStatus
import top.sceon.common.util.StringUtil

import javax.annotation.Resource

/**
 * @author zhouwei
 * @since 2016/9/3
 */
class PageTest extends SpringBaseTest {

    @Resource
    PageService pageService

    @Rollback(false)
    @Test
    void add() {
        Page page = new Page()
        page.guid = StringUtil.guid()
        page.userId = 1
        page.alias = "首页"
        page.status = ElementStatus.OFFLINE
        pageService.save(page)
    }

    @Rollback(false)
    @Test
    void add2() {
        Page page = new Page()
        page.guid = StringUtil.guid()
        page.userId = 1
        page.alias = "关于"
        page.status = ElementStatus.OFFLINE
        pageService.save(page)
    }

}
