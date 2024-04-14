package com.bs.glr.service;

import com.bs.glr.bean.BsBookInfo;
import com.bs.glr.bean.EchartBean;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface BookInfoService {
    Integer insertBookInfo(BsBookInfo bsBookInfo);

    Integer delBookInfo(Integer aid);

    Integer updateBookInfoById(Integer sid,Integer sortId,Integer addressId);

    PageInfo<BsBookInfo> selectBookInfoByPage(Integer page, Integer limit);

    BsBookInfo selectBookInfoById(Integer id);

    PageInfo<BsBookInfo> selectBookInfoByBookName(String bookName,Integer page ,Integer limit);

    PageInfo<BsBookInfo> selectBookInfoByBookSortId(Integer sortId, Integer page, Integer limit);

    BsBookInfo getBookByRfid(String rfidId);

    Integer updateBookInfoById(Integer sid,Integer addressId);

    BsBookInfo getBookById(Integer bookId);

    void updateBookInfo(BsBookInfo bsBookInfo1);


    PageInfo<BsBookInfo> selectBookInfoConditionByPage(String bookName, String author, String press, Integer page, Integer limit);

    Integer updateAllBookInfoById(BsBookInfo bookCount);

    List<EchartBean> getBookTypeInfoChart();

    List<EchartBean> getBootCountChart();

    List<EchartBean> getBookTypeInfoChartByUid(Integer uid);

    PageInfo<BsBookInfo> getBookInfoCreatList(Integer page, Integer limit);

    List<EchartBean> getBootCountChartByUid(String uid);
}
