package top.sceon.blog.dao;

import top.sceon.blog.util.Pages;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author zhouwei
 * @since 2016/6/6
 */
public interface IBaseDao<T, PK extends Serializable> {

    public int save(T entity);

    public int update(T entity);

    public int updateByParams(Map<String, Object> params);

    public int delete(PK primaryKey);

    public int deleteByParams(Map<String, Object> params);

    // public int truncate();

    public int countAll();

    public int countByParams(Map<String, Object> params);

    public T get(PK primaryKey);

    public List<T> findAll();

    public List<T> findByParams(Map<String, Object> params);

    public Pages<T> findByPage(Pages<T> pages);

    public List<T> findByProperty(String key, Object value);

    public List<T> findByPropertyAndOrder(String key, Object value, String order);

    public List<T> findByProperties(String[] keys, Object[] values);

    public List<T> findByPropertiesAndOrder(String[] keys, Object[] values, String order);

    public List<T> findByParamsAndOrder(Map<String, Object> params, String order);

    public int countByProperty(String key, Object value);

    public int countByProperties(String[] keys, Object[] values);

}