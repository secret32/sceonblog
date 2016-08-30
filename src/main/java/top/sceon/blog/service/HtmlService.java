package top.sceon.blog.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import top.sceon.blog.util.AppConfig;
import top.sceon.blog.util.HtmlTemplate;

import javax.annotation.Resource;
import java.io.*;
import java.util.HashMap;
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

    public void generateHome() throws IOException, TemplateException {
        String template = HtmlTemplate.HOME.getFtl();
        String filepath = appConfig.getHtmlSavePath() + HtmlTemplate.HOME.getHtml();
        Map<String, Object> rootMap = new HashMap<>();
        rootMap.put("resAccessPath", appConfig.getResAccessPath());
        writeHtml(template, filepath, rootMap);
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
