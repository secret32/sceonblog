package top.sceon.blog.controller.backend;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sceon.blog.controller.BaseController;
import top.sceon.blog.service.HtmlService;
import top.sceon.blog.util.SessionKey;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author zhou_wei
 * @date 8/29/2016
 */
@Controller
@RequestMapping(path = "/manage/html")
public class HtmlController extends BaseController {

    final private Log logger = LogFactory.getLog(HtmlController.class);

    @Resource
    private HtmlService htmlService;

    @RequestMapping(path = "/generate", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public JSONObject generate(HttpSession session, int pageId) {
        JSONObject result = new JSONObject();
        try {
            Integer userId = (Integer) session.getAttribute(SessionKey.USER_ID);
            htmlService.generate(userId, pageId);
            s(result);
        } catch (Exception e) {
            e(result, e);
            logger.error(e);
        }
        return result;
    }

}
