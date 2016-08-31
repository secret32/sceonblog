package top.sceon.blog.service;

import top.sceon.blog.dao.IBaseDao;
import top.sceon.blog.util.Pages;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Service的基类
 * @author zhouwei
 * @since 2016/6/12
 */
public class BaseServiceImpl<T, ID extends Serializable> implements IBaseService<T, ID> {

	private IBaseDao<T, ID> baseDao;

	public IBaseDao<T, ID> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao<T, ID> baseDao) {
		this.baseDao = baseDao;
	}

    @Override
    public void save(T entity) {
        baseDao.save(entity);
    }

    @Override
    public void update(T entity) {
        baseDao.update(entity);
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void saveOrUpdate(T entity) {
        try {
            Method method = entity.getClass().getDeclaredMethod("getId");
            ID id = (ID) method.invoke(entity);
            if (id == null) {
                save(entity);
            } else {
                update(entity);
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ID id) {
        baseDao.delete(id);
    }

    @Override
    public List<T> findAll() {
        return baseDao.findAll();
    }

    @Override
    public T getById(ID id) {
        return baseDao.get(id);
    }

    @Override
    public List<T> findByProperty(String key, Object value) {
        return baseDao.findByProperty(key, value);
    }

    @Override
    public List<T> findByPropertyAndOrder(String key, Object value, String order) {
        return baseDao.findByPropertyAndOrder(key, value, order);
    }

    @Override
    public List<T> findByProperties(String[] keys, Object[] values) {
        return baseDao.findByProperties(keys, values);
    }

    @Override
    public List<T> findByPropertiesAndOrder(String[] keys, Object[] values, String order) {
        return baseDao.findByPropertiesAndOrder(keys, values, order);
    }

    @Override
    public List<T> findByParams(Map<String, Object> params) {
        return baseDao.findByParams(params);
    }

    @Override
    public List<T> findByParamsAndOrder(Map<String, Object> params, String order) {
        return baseDao.findByParamsAndOrder(params, order);
    }

    @Override
    public int countAll() {
        return baseDao.countAll();
    }

    @Override
    public int countByProperty(String key, Object value) {
        return baseDao.countByProperty(key, value);
    }

    @Override
    public int countByProperties(String[] keys, Object[] values) {
        return baseDao.countByProperties(keys, values);
    }

    @Override
    public int countByParams(Map<String, Object> params) {
        return baseDao.countByParams(params);
    }

    @Override
    public Pages<T> findPages(Pages<T> pages) {
        return baseDao.findByPage(pages);
    }
}
