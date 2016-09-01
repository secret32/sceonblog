package top.sceon.blog.service;

import org.springframework.stereotype.Service;
import top.sceon.blog.dao.LinkDao;
import top.sceon.blog.entity.Link;

import javax.annotation.Resource;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Service
public class LinkService extends BaseServiceImpl<Link, Integer> implements IBaseService<Link, Integer> {

    private LinkDao linkDao;

    public LinkDao getLinkDao() {
        return linkDao;
    }

    @Resource
    public void setLinkDao(LinkDao linkDao) {
        this.linkDao = linkDao;
        super.setBaseDao(linkDao);
    }
}
