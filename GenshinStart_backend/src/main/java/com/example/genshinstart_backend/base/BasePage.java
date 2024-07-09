package com.example.genshinstart_backend.base;

/**
 * @version 1.0.0
 * @description: The type Base page.
 * @author feixia0g
 * @date 2024/7/9 19:55
 */
public class BasePage {

    private Integer pageIndex;

    private Integer pageSize;

    /**
     * Gets page index.
     *
     * @return the page index
     */
    public Integer getPageIndex() {
        return pageIndex;
    }

    /**
     * Sets page index.
     *
     * @param pageIndex the page index
     */
    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * Gets page size.
     *
     * @return the page size
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets page size.
     *
     * @param pageSize the page size
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

