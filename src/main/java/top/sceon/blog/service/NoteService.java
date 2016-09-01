package top.sceon.blog.service;

import org.springframework.stereotype.Service;
import top.sceon.blog.dao.NoteDao;
import top.sceon.blog.entity.Note;

import javax.annotation.Resource;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Service
public class NoteService extends BaseServiceImpl<Note, Integer> implements IBaseService<Note, Integer> {
    private NoteDao noteDao;

    public NoteDao getNoteDao() {
        return noteDao;
    }

    @Resource
    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
        super.setBaseDao(noteDao);
    }
}
