package top.sceon.blog.service;

import top.sceon.blog.util.Pages;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author zhouwei
 * @since 2016/6/12
 */
public interface IBaseService<T, ID extends Serializable> {

    public void save(T entity);

    public void update(T entity);

    /**
     * 保存或更新实体。
     * 使用了反射，必须要求实体类有getId()方法才能调用成功。
     *
     * @param entity 实体
     */
    public void saveOrUpdate(T entity);

    public void delete(ID id);

    public List<T> findAll();

    public T getById(ID id);

    public List<T> findByProperty(String key, Object value);

    public List<T> findByPropertyAndOrder(String key, Object value, String order);

    public List<T> findByProperties(String[] keys, Object[] values);

    public List<T> findByPropertiesAndOrder(String[] keys, Object[] values, String order);

    public List<T> findByParams(Map<String, Object> params);

    public List<T> findByParamsAndOrder(Map<String, Object> params, String order);

    public int countAll();

    public int countByProperty(String key, Object value);

    public int countByProperties(String[] keys, Object[] values);

    public int countByParams(Map<String, Object> params);

    public Pages<T> findPages(Pages<T> pages);

}
