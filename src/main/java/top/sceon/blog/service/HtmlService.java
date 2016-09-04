package top.sceon.blog.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import top.sceon.blog.dao.MenuDao;
import top.sceon.blog.dao.PageDao;
import top.sceon.blog.entity.Menu;
import top.sceon.blog.entity.Page;
import top.sceon.blog.entity.vo.MenuVo;
import top.sceon.blog.util.AppConfig;
import top.sceon.blog.util.HtmlTemplate;
import top.sceon.common.exception.ParamException;

import javax.annotation.Resource;
import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhou_wei
 * @date 8/29/2016
 */
@Service
public class HtmlService {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
    @Resource
    private AppConfig appConfig;
    @Resource
    private PageDao pageDao;
    @Resource
    private MenuDao menuDao;

    @Deprecated
    public void generateHome() throws IOException, TemplateException {
        String template = HtmlTemplate.HOME.getFtl();
        String filepath = appConfig.getHtmlSavePath() + HtmlTemplate.HOME.getHtml();
        Map<String, Object> rootMap = initRootMap(null);
        writeHtml(template, filepath, rootMap);
    }

    public void generate(int userId, int pageId) throws ParamException, IOException, TemplateException {
        Page page = pageDao.get(pageId);
        if (page == null) {
            throw new ParamException();
        }
        List<Menu> menus = menuDao.findByProperty("userId", 1);
        List<MenuVo> menuList = MenuVo.newList(menus);
        String template = HtmlTemplate.HOME.getFtl();
        String filepath = appConfig.getHtmlSavePath() + HtmlTemplate.HOME.getHtml();
        Map<String, Object> rootMap = initRootMap(null);
        rootMap.put("menuList", menuList);
        rootMap.put("noteList", Collections.EMPTY_LIST);
        rootMap.put("articleList", Collections.EMPTY_LIST);
        writeHtml(template, filepath, rootMap);
    }

    private Map<String, Object> initRootMap(Map<String, Object> rootMap) {
        if (rootMap == null) {
            rootMap = new HashMap<>();
        } else {
            rootMap.clear();
        }
        rootMap.put("scheme", appConfig.getScheme());
        rootMap.put("resAccessPath", appConfig.getResAccessPath());
        return rootMap;
    }

    private void writeHtml(String ftl, String html, Map<String, Object> map) throws IOException, TemplateException {
        Writer out = null;
        try {
            Configuration configuration = freeMarkerConfigurer.getConfiguration();
            Template template = configuration.getTemplate(ftl);
            File file = new File(html);
            out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            template.process(map, out);
        } finally {
            if (out != null) {
                IOUtils.closeQuietly(out);
            }
        }
    }

}
