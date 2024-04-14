package com.bs.glr.service.impl;

import com.bs.glr.bean.BsBorrow;
import com.bs.glr.bean.BsBorrowExample;
import com.bs.glr.mapper.BsBorrowMapper;
import com.bs.glr.service.BorrowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class BorrowServiceImpl implements BorrowService {


    @Resource
    BsBorrowMapper borrowMapper;

    @Override
    public Integer insertBorrowBook(BsBorrow borrow) {
        return borrowMapper.insertSelective(borrow);
    }

    @Override
    public BsBorrow selectBorrowByUidAndrfidID(Integer uid,Integer bookId) {
        BsBorrowExample example = new BsBorrowExample();
        example.setOrderByClause("id desc");
        example.createCriteria().andUidEqualTo(uid).andBookIdEqualTo(bookId);
        List<BsBorrow> bsBorrows = borrowMapper.selectByExample(example);
        if(bsBorrows==null || bsBorrows.size()<=0){
            return null;
        }
        return bsBorrows.get(0);
    }

    @Override
    public Integer returnBook(Integer id) {
        BsBorrow bsBorrow = new BsBorrow();
        bsBorrow.setId(id);
        bsBorrow.setBoorrwStatus("1");
        bsBorrow.setReturnTime(new Date());
        return borrowMapper.updateByPrimaryKeySelective(bsBorrow);
    }

    @Override
    public PageInfo<BsBorrow> selectBorrowList(Integer uid,Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        BsBorrowExample example = new BsBorrowExample();
        if(uid != null&& uid != 1){
            example.createCriteria().andUidEqualTo(uid);
        }
        List<BsBorrow> bsBorrows = borrowMapper.selectByExample(example);
        PageInfo<BsBorrow> pageInfo = new PageInfo<>(bsBorrows);
        return pageInfo;
    }

    @Override
    public BsBorrow selectBorrowById(Integer borrowId) {
        return borrowMapper.selectByPrimaryKey(borrowId);
    }

    @Override
    public PageInfo<BsBorrow> selectBorrowListByStatus(String status, Integer uid, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        BsBorrowExample example = new BsBorrowExample();
        BsBorrowExample.Criteria criteria = example.createCriteria();
        if(uid != null && uid != 1){
            criteria.andUidEqualTo(uid);
        }
        if(!StringUtils.isEmpty(status)){
            criteria.andBoorrwStatusEqualTo(status);
        }

        List<BsBorrow> bsBorrows = borrowMapper.selectByExample(example);
        PageInfo<BsBorrow> pageInfo = new PageInfo<>(bsBorrows);
        return pageInfo;
    }
}
