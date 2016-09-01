package top.sceon.blog.controller.backend;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.sceon.blog.controller.BaseController;
import top.sceon.blog.entity.Note;
import top.sceon.blog.service.NoteService;
import top.sceon.blog.util.Pages;

import javax.annotation.Resource;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Controller
@RequestMapping(path = "/manage/note")
public class NoteController extends BaseController {

    final private Log logger = LogFactory.getLog(NoteController.class);

    @Resource
    private NoteService noteService;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public ModelAndView list(Pages<Note> pages) {
        ModelAndView result = new ModelAndView("/backend/noteList");
        super.list(logger, noteService, result, pages);
        return result;
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject save(Note note) {
        return super.save(logger, noteService, note);
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject get(int id) {
        return super.get(logger, noteService, id);
    }

    @RequestMapping(path = "/del", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject del(int id) {
        return super.del(logger, noteService, id);
    }

    @RequestMapping(path = "/addLinks", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addLinks(int[] linkIds) {
        // TODO
        return null;
    }

}
