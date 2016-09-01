package top.sceon.blog.dao;

import org.springframework.stereotype.Repository;
import top.sceon.blog.entity.Note;

/**
 * @author zhouwei
 * @since 2016/9/1
 */
@Repository
public class NoteDao extends BaseDaoImpl<Note, Integer> implements IBaseDao<Note, Integer> {
    public NoteDao() {
        super("note");
    }
}
