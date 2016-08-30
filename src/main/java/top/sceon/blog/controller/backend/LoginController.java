package top.sceon.blog.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import top.sceon.blog.controller.BaseController;
import top.sceon.blog.util.SessionKey;
import top.sceon.common.util.HashUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author zhou_wei
 * @date 8/29/2016
 */
@Controller
@RequestMapping(path = "/manage")
public class LoginController extends BaseController {

    final private String USERNAME = "admin";
    final private String PASSWORD = HashUtil.sha1("1");

    @RequestMapping(path = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView login(HttpServletRequest request, String username, String password, String verifyCode) {
        ModelAndView result;
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute(SessionKey.USER_ID);
        if (username == null && password == null && userId != null) {
            result = new ModelAndView("/backend/index");
            result.addObject("username", userId);
            session.setAttribute(SessionKey.USER_ID, userId);
        } else if (username != null) {
            if (PASSWORD.equals(HashUtil.sha1(password))) {
                result = new ModelAndView("/backend/index");
                result.addObject("username", username);
                session.setAttribute(SessionKey.USER_ID, username);
            } else {
                result = new ModelAndView("/backend/login");
                result.addObject("error", "Invalid username or password");
            }
        } else {
            result = new ModelAndView("/backend/login");
        }
        return result;
    }

}
