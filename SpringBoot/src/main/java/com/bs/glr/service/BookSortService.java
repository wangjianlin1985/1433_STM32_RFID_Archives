package com.bs.glr.service;

import com.bs.glr.bean.BsBookSort;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface BookSortService  {
    Integer insertBookSort(String sortName);

    Integer delBookSort(Integer sid);

    Integer updateBookSortById(Integer sid, String sortName);

    PageInfo<BsBookSort> selectBookSortByPage(Integer page, Integer limit);

    List<BsBookSort> getSortOption();

    BsBookSort selectBookSortById(Integer sortId);
}
