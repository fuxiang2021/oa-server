package com.ldyswlp.vo;

import lombok.extern.java.Log;

import java.io.Serializable;

/**
 * 分页查询 vo
 */
public class PageVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long page = 1L;
    private Long pageSize = 10L;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}
