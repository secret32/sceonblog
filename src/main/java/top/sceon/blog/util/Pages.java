package top.sceon.blog.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 分页实体类
 */
public class Pages<T> {
    private int pageNo;//当前页数
    private int pageSize;//每页条数
    private int allCount;//总条数
    private int allPage;//总页数
    private int recordStart;//每页开始
    private int recordEnd;//每页结束
    private boolean hasPrePage;//是否有上一页
    private boolean hasNextPage;//是否有下一页
    private int showCount;//显示页数
    private List<T> pageList;
    private Map<String, Object> searchTerms;

    public Map<String, Object> getSearchTerms() {
        return searchTerms;
    }

    public void setSearchTerms(Map<String, Object> searchTerms) {
        searchTerms.remove("page.pageNo");
        searchTerms.remove("page.pageSize");
        this.searchTerms = searchTerms;
    }

    public Pages() {
        pageNo = 1;
        pageSize = 10;
        allPage = 1;
        recordStart = 0;
        recordEnd = 0;
        hasPrePage = false;
        hasNextPage = false;
        try {
            execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Pages(int pageNo, int allCount) {
        this.pageNo = pageNo;
        this.pageSize = 10;
        this.allCount = allCount;
        this.allPage = 1;
        this.recordStart = 0;
        this.recordEnd = 0;
        hasPrePage = false;
        hasNextPage = false;
        try {
            execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Pages(int pageNo, int pageSize, int allCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.allCount = allCount;
        this.allPage = 1;
        this.recordStart = 0;
        this.recordEnd = 0;
        hasPrePage = false;
        hasNextPage = false;
        try {
            execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void execute() {
        if (pageNo <= 0) {
            pageNo = 1;
        }
        recordStart = (pageNo - 1) * pageSize;
        recordEnd = Math.min(recordStart + pageSize, allCount);
        if (allCount % pageSize == 0) {
            allPage = allCount / pageSize;
        } else {
            allPage = allCount / pageSize + 1;
        }
        if (pageNo > 1) {
            hasPrePage = true;
        }
        if (pageNo < allPage) {
            hasNextPage = true;
        }
        // 当前页码大于总页数时，修改当前页码
        if (pageNo > allPage) {
            pageNo = allPage;
        }
        if (showCount <= 0) {
            showCount = 9;
        }
    }

    public void execute(int pageNo, int pageSize, int allCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.allCount = allCount;
        this.allPage = 1;
        this.recordStart = 0;
        this.recordEnd = 0;
        hasPrePage = false;
        hasNextPage = false;
        try {
            execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 获取总条数
     *
     * @return int
     */
    public int getAllCount() {
        return allCount;
    }

    /**
     * 设置总条数
     *
     * @param allCount
     */
    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    /**
     * 获取总页数
     *
     * @return int
     */
    public int getAllPage() {
        return allPage;
    }

    /**
     * 设置总页数
     *
     * @param allPage
     */
    public void setAllPage(int allPage) {
        this.allPage = allPage;
    }

    /**
     * 是否有下一页
     *
     * @return boolean
     */
    public boolean isHasNextPage() {
        return hasNextPage;
    }

    /**
     * 设置是否有下一页
     *
     * @param hasNextPage
     */
    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    /**
     * 是否有上一页
     *
     * @return
     */
    public boolean isHasPrePage() {
        return hasPrePage;
    }

    /**
     * 设置是否有上一页
     *
     * @return
     */
    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    /**
     * 获取分页结果
     *
     * @return
     */
    public List<T> getPageList() {
        return pageList;
    }

    /**
     * 设置分页结果
     *
     * @param pageList
     */
    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    /**
     * 获取当前页
     *
     * @return
     */
    public int getPageNo() {
        if (pageNo == 0) {
            pageNo = 1;
        }
        return pageNo;
    }

    /**
     * 设置当前页
     *
     * @param pageNo
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 每页数据条数
     *
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页数据条数
     *
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 每页结束
     *
     * @return
     */
    public int getRecordEnd() {
        return recordEnd;
    }

    /**
     * 设置每页结束
     *
     * @param recordEnd
     */
    public void setRecordEnd(int recordEnd) {
        this.recordEnd = recordEnd;
    }

    /**
     * 获取每页开始
     *
     * @return int
     */
    public int getRecordStart() {
        return recordStart;
    }

    /**
     * 设置每页开始
     *
     * @param recordStart
     */
    public void setRecordStart(int recordStart) {
        this.recordStart = recordStart;
    }

    /**
     * 显示条数
     *
     * @return int
     */
    public int getShowCount() {
        return showCount;
    }

    /**
     * 设置显示条数
     *
     * @param showCount
     */
    public void setShowCount(int showCount) {
        this.showCount = showCount;
    }

    public static <T> Pages<T> paging(Pages<T> page, List<T> list) {
        try {
            page.setAllCount(list.size());
            page.execute();
            page.setPageList(pageList(page.getPageNo(), page.getPageSize(), list));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;

    }

    /**
     * @param <T>
     * @param pageNo   当前页码
     * @param pageSize 页数
     * @param list     所有集合
     * @return
     * @throws Exception
     */
    public static <T> List<T> pageList(int pageNo, int pageSize, List<T> list) throws Exception {
        List<T> result = new ArrayList<T>();
        if (list != null && list.size() > 0) {
            int allCount = list.size();
            int pageCount = (allCount + pageSize - 1) / pageSize;
            if (pageNo >= pageCount) {
                pageNo = pageCount;
            }
            int start = (pageNo - 1) * pageSize;
            int end = pageNo * pageSize;
            if (end >= allCount) {
                end = allCount;
            }
            for (int i = start; i < end; i++) {
                result.add(list.get(i));
            }
        }
        return (result != null && result.size() > 0) ? result : null;
    }

}
