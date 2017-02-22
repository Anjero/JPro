package net.anjero.plugins.mybaits;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :Anjero
 * @version :1.0
 * @Title :Page.java
 * @Description:
 * @Datetime :2013-9-27
 * @Copyright :Copyright (c) 2012
 * @Company :Cheshell
 */
public class Page<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5032045958325257142L;
    private int totalCount;
    private int pageNo;
    private int pageSize;
    private String sortname;
    private String sortorder;

    private List<T> list;

    public Page() {
        this(0, 1, 20, new ArrayList<T>());
    }

    public Page(int totalCount, int pageNo, int pageSize, List<T> list) {
        super();
        this.totalCount = totalCount;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        if (pageSize == 0) {
            return 0;
        }
        return (this.totalCount + pageSize - 1) / pageSize;
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    public String getSortorder() {
        return sortorder;
    }

    public void setSortorder(String sortorder) {
        this.sortorder = sortorder;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalCount=" + totalCount +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", sortname='" + sortname + '\'' +
                ", sortorder='" + sortorder + '\'' +
                ", list=" + list +
                '}';
    }
}
