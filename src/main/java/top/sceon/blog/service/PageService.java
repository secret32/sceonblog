package top.sceon.blog.service;

import org.springframework.stereotype.Service;
import top.sceon.blog.dao.PageDao;
import top.sceon.blog.entity.Page;

import javax.annotation.Resource;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Service
public class PageService extends BaseServiceImpl<Page, Integer> implements IBaseService<Page, Integer> {

    private PageDao pageDao;

    public PageDao getPageDao() {
        return pageDao;
    }

    @Resource
    public void setPageDao(PageDao pageDao) {
        this.pageDao = pageDao;
        super.setBaseDao(pageDao);
    }

}
