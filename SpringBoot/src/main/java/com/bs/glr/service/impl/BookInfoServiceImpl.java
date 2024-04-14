package com.bs.glr.service.impl;

import com.bs.glr.bean.BsBookInfo;
import com.bs.glr.bean.BsBookInfoExample;
import com.bs.glr.bean.EchartBean;
import com.bs.glr.mapper.BsBookInfoMapper;
import com.bs.glr.service.BookInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BookInfoServiceImpl implements BookInfoService{
    @Resource
    BsBookInfoMapper bookInfoMapper;

    @Override
    public Integer insertBookInfo(BsBookInfo bsBookInfo) {

        return bookInfoMapper.insertSelective(bsBookInfo);
    }

    @Override
    public Integer delBookInfo(Integer sid) {
        return bookInfoMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public Integer updateBookInfoById(Integer sid,Integer sortId,Integer addressId) {
        BsBookInfo bsBookInfo = new BsBookInfo();
        bsBookInfo.setId(sid);
        bsBookInfo.setSortId(sortId);
        bsBookInfo.setAddressId(addressId);
        return bookInfoMapper.updateByPrimaryKeySelective(bsBookInfo);
    }

    @Override
    public PageInfo<BsBookInfo> selectBookInfoByPage(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        BsBookInfoExample example = new BsBookInfoExample();
        example.setOrderByClause("select_number desc");
        List<BsBookInfo> bsBookSorts = bookInfoMapper.selectByExample(example);
        PageInfo<BsBookInfo> bsBookSortPageInfo = new PageInfo<>(bsBookSorts);
        return bsBookSortPageInfo;
    }

    @Override
    public BsBookInfo selectBookInfoById(Integer id) {
        return bookInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<BsBookInfo> selectBookInfoByBookName(String bookName,Integer page ,Integer limit) {
        PageHelper.startPage(page,limit);
        BsBookInfoExample example = new BsBookInfoExample();
        example.createCriteria().andBookNameLike("%"+bookName+"%");
        List<BsBookInfo> bsBookInfos = bookInfoMapper.selectByExample(example);
        PageInfo<BsBookInfo> pageInfo = new PageInfo<>(bsBookInfos);
        return pageInfo;
    }

    @Override
    public PageInfo<BsBookInfo> selectBookInfoByBookSortId(Integer sortId, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        BsBookInfoExample example = new BsBookInfoExample();
        example.createCriteria().andSortIdEqualTo(sortId);
        List<BsBookInfo> bsBookInfos = bookInfoMapper.selectByExample(example);
        PageInfo<BsBookInfo> pageInfo = new PageInfo<>(bsBookInfos);
        return pageInfo;
    }

    @Override
    public BsBookInfo getBookByRfid(String rfidId) {
        BsBookInfoExample example = new BsBookInfoExample();
        example.createCriteria().andRfidIdEqualTo(rfidId);
        List<BsBookInfo> bsBookInfos = bookInfoMapper.selectByExample(example);
        if(bsBookInfos == null || bsBookInfos.size()<=0){
            return null;
        }
        return bsBookInfos.get(0);
    }

    @Override
    public Integer updateBookInfoById(Integer sid,Integer addressId) {
        BsBookInfo bsBookInfo = new BsBookInfo();
        bsBookInfo.setId(sid);
        bsBookInfo.setAddressId(addressId);
        return bookInfoMapper.updateByPrimaryKeySelective(bsBookInfo);
    }

    @Override
    public BsBookInfo getBookById(Integer bookId) {
        return bookInfoMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public void updateBookInfo(BsBookInfo bsBookInfo1) {
        bookInfoMapper.updateByPrimaryKeySelective(bsBookInfo1);
    }

    @Override
    public PageInfo<BsBookInfo> selectBookInfoConditionByPage(String bookName, String author, String press, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        BsBookInfoExample example = new BsBookInfoExample();
        BsBookInfoExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(bookName)){
            criteria.andBookNameLike("%"+bookName+"%");
        }
        if(!StringUtils.isEmpty(author)){
            criteria.andAuthorLike("%"+author+"%");
        }
        if(!StringUtils.isEmpty(press)){
            criteria.andPressLike("%"+press+"%");
        }
//        example.createCriteria().andBookNameLike("%"+bookName+"%");
        List<BsBookInfo> bsBookInfos = bookInfoMapper.selectByExample(example);
        PageInfo<BsBookInfo> pageInfo = new PageInfo<>(bsBookInfos);
        return pageInfo;
    }

    @Override
    public Integer updateAllBookInfoById(BsBookInfo bookCount) {
        return bookInfoMapper.updateByPrimaryKeySelective(bookCount);
    }

    @Override
    public List<EchartBean> getBookTypeInfoChart() {
        return bookInfoMapper.getBookTypeInfoChart();
    }

    @Override
    public List<EchartBean> getBootCountChart() {
        return bookInfoMapper.getBootCountChart();
    }

    @Override
    public List<EchartBean> getBookTypeInfoChartByUid(Integer uid) {
        Map<String,Integer> map = new HashMap<>();
        map.put("uid",uid);
        return bookInfoMapper.getBookTypeInfoChartByUid(map);
    }

    @Override
    public PageInfo<BsBookInfo> getBookInfoCreatList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        BsBookInfoExample example = new BsBookInfoExample();
        example.setOrderByClause("create_time desc");
        List<BsBookInfo> bsBookSorts = bookInfoMapper.selectByExample(example);
        PageInfo<BsBookInfo> bsBookSortPageInfo = new PageInfo<>(bsBookSorts);
        return bsBookSortPageInfo;
    }

    @Override
    public List<EchartBean> getBootCountChartByUid(String uid) {
        Map<String,String> map = new HashMap<>();
        map.put("uid",uid);
        return bookInfoMapper.getBootCountChartByUid(map);
    }

}
