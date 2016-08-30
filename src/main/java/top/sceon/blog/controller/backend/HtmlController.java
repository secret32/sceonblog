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

import javax.annotation.Resource;

/**
 * @author zhou_wei
 * @date 8/29/2016
 */
@Controller
@RequestMapping(path = "/manage")
public class HtmlController extends BaseController {

    final private Log logger = LogFactory.getLog(HtmlController.class);

    @Resource
    private HtmlService htmlService;

    @RequestMapping(path = "/html/home", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public JSONObject generateHome() {
        JSONObject result = new JSONObject();
        try {
            htmlService.generateHome();
            s(result);
        } catch (Exception e) {
            e(result, e);
            logger.error(e);
        }
        return result;
    }

}
