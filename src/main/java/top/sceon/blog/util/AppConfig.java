package top.sceon.blog.util;

/**
 * @author zhou_wei
 * @date 8/30/2016
 */
public class AppConfig {

    private String resSavePath;
    private String resAccessPath;

    private String htmlSavePath;
    private String htmlAccessPath;

    public String getResSavePath() {
        return resSavePath;
    }

    public void setResSavePath(String resSavePath) {
        this.resSavePath = resSavePath;
    }

    public String getResAccessPath() {
        return resAccessPath;
    }

    public void setResAccessPath(String resAccessPath) {
        this.resAccessPath = resAccessPath;
    }

    public String getHtmlSavePath() {
        return htmlSavePath;
    }

    public void setHtmlSavePath(String htmlSavePath) {
        this.htmlSavePath = htmlSavePath;
    }

    public String getHtmlAccessPath() {
        return htmlAccessPath;
    }

    public void setHtmlAccessPath(String htmlAccessPath) {
        this.htmlAccessPath = htmlAccessPath;
    }
}
