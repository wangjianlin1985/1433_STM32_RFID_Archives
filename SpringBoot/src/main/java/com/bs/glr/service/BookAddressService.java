package com.bs.glr.service;

import com.bs.glr.bean.BsBookAddress;
import com.bs.glr.bean.BsBookSort;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface BookAddressService {
    Integer insertBookAddress(String addressName);

    Integer delBookAddress(Integer aid);

    Integer updateBookAddressById(Integer sid, String addressName);

    PageInfo<BsBookAddress> selectBookAddressByPage(Integer page, Integer limit);

    List<BsBookAddress> getAddressOption();

    BsBookAddress selectBookAddressById(Integer addressId);
}
