package top.sceon.blog.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import top.sceon.blog.util.Pages;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouwei
 * @since 2016/6/6
 */
public class BaseDaoImpl<T, PK extends Serializable> extends SqlSessionDaoSupport implements IBaseDao<T, PK> {

    // mapper.xml中的namespace
    protected String namespace;

    // mapper.xml定义文件中对应的sqlid
    public static final String SQLID_INSERT = "insert";
    public static final String SQLID_UPDATE = "update";
    public static final String SQLID_UPDATE_PARAM = "updateParam";
    public static final String SQLID_DELETE = "delete";
    public static final String SQLID_DELETE_PARAM = "deleteParam";
    // public static final String SQLID_TRUNCATE = "truncate";
    public static final String SQLID_SELECT = "select";
    public static final String SQLID_SELECT_PK = "selectPk";
    public static final String SQLID_SELECT_PARAM = "selectParam";
    public static final String SQLID_COUNT = "count";
    public static final String SQLID_COUNT_PARAM = "countParam";

    public static final String SELECT_START_INDEX = "startIndex";
    public static final String SELECT_FETCH_SIZE = "fetchSize";
    public static final String SELECT_ORDER = "order";

    @Resource(name = "sqlSessionTemplate")
    public void setSuperSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public BaseDaoImpl(String namespace) {
        this.namespace = namespace;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @Override
    public int save(T entity) {
        return getSqlSession().insert(namespace + "." + SQLID_INSERT, entity);
    }

    @Override
    public int update(T entity) {
        return getSqlSession().update(namespace + "." + SQLID_UPDATE, entity);
    }

    @Override
    public int updateByParams(Map<String, Object> params) {
        return getSqlSession().update(namespace + "." + SQLID_UPDATE_PARAM, params);
    }

    @Override
    public int delete(PK primaryKey) {
        return getSqlSession().delete(namespace + "." + SQLID_DELETE, primaryKey);
    }

    @Override
    public int deleteByParams(Map<String, Object> params) {
        return getSqlSession().delete(namespace + "." + SQLID_DELETE_PARAM, params);
    }

//    @Override
//    public int truncate() {
//        return getSqlSession().delete(namespace + "." + SQLID_TRUNCATE);
//    }

    @Override
    public int countAll() {
        return getSqlSession().selectOne(namespace + "." + SQLID_COUNT);
    }

    @Override
    public int countByParams(Map<String, Object> params) {
        return getSqlSession().selectOne(namespace + "." + SQLID_COUNT_PARAM, params);
    }

    @Override
    public T get(PK primaryKey) {
        return getSqlSession().selectOne(namespace + "." + SQLID_SELECT_PK, primaryKey);
    }

    @Override
    public List<T> findAll() {
        return getSqlSession().selectList(namespace + "." + SQLID_SELECT);
    }

    @Override
    public List<T> findByParams(Map<String, Object> params) {
        return getSqlSession().selectList(namespace + "." + SQLID_SELECT_PARAM, params);
    }

    @Override
    public Pages<T> findByPage(Pages<T> pages) {
        if (pages == null) {
            pages = new Pages<>();
        }
        Map<String, Object> params = new HashMap<>();
        if (pages.getSearchTerms() != null) {
            params.putAll(pages.getSearchTerms());
        }
        int count = this.countByParams(params);
        pages.setAllCount(count);
        pages.execute();
        params.put(SELECT_START_INDEX, (pages.getPageNo() - 1) * pages.getPageSize());
        params.put(SELECT_FETCH_SIZE, pages.getPageSize());
        List<T> list = this.findByParams(params);
        pages.setPageList(list);
        return pages;
    }

    @Override
    public List<T> findByProperty(String key, Object value) {
        return findByPropertyAndOrder(key, value, null);
    }

    @Override
    public List<T> findByPropertyAndOrder(String key, Object value, String order) {
        Map<String, Object> params = new HashMap<>();
        params.put(key, value);
        return findByParamsAndOrder(params, order);
    }

    @Override
    public List<T> findByProperties(String[] keys, Object[] values) {
        return findByPropertiesAndOrder(keys, values, null);
    }

    @Override
    public List<T> findByPropertiesAndOrder(String[] keys, Object[] values, String order) {
        if (keys == null || values == null || keys.length != values.length)
            throw new IllegalArgumentException("parameters error");
        Map<String, Object> params = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            params.put(keys[i], values[i]);
        }
        return findByParamsAndOrder(params, order);
    }

    @Override
    public List<T> findByParamsAndOrder(Map<String, Object> params, String order) {
        if (params != null && order != null) {
            params.put(SELECT_ORDER, order);
        }
        return findByParams(params);
    }

    @Override
    public int countByProperty(String key, Object value) {
        Map<String, Object> params = new HashMap<>();
        params.put(key, value);
        return countByParams(params);
    }

    @Override
    public int countByProperties(String[] keys, Object[] values) {
        if (keys == null || values == null || keys.length != values.length)
            throw new IllegalArgumentException("parameters error");
        Map<String, Object> params = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            params.put(keys[i], values[i]);
        }
        return countByParams(params);
    }
}
