package top.sceon.blog.util;

/**
 * @author zhou_wei
 * @date 8/30/2016
 */
public enum HtmlTemplate {
    HOME(1, "home.ftl", "/home.html"),
    ;

    private int id;
    private String ftl;
    private String html;

    HtmlTemplate(int id, String ftl, String html) {
        this.id = id;
        this.ftl = ftl;
        this.html = html;
    }

    public int getId() {
        return id;
    }

    public String getFtl() {
        return ftl;
    }

    public String getHtml() {
        return html;
    }
}
