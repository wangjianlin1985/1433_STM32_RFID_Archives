package com.bs.glr.controller;

import com.bs.glr.bean.BsBookAddress;
import com.bs.glr.bean.BsBookSort;
import com.bs.glr.bean.OptionVO;
import com.bs.glr.bean.ResultBean;
import com.bs.glr.service.BookAddressService;
import com.bs.glr.service.BookSortService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/auth/book/address")
public class BookAddressController {

    @Resource
    BookAddressService bookAddressService;

    //添加图书物理区域
    @RequestMapping("addBookAddress")
    public ResultBean addBookAddress (String addressName){

        Integer line = bookAddressService.insertBookAddress(addressName);
        if(line>0){
            return ResultBean.returnOk();
        }
        return ResultBean.returnError();

    }

    //删除图书物理区域
    @RequestMapping("delBookAddressById")
    public ResultBean delBookAddressById (Integer aid){

        Integer line = bookAddressService.delBookAddress(aid);
        if(line>0){
            return ResultBean.returnOk();
        }
        return ResultBean.returnError();

    }

    //更新图书物理区域
    @RequestMapping("updateBookAddressById")
    public ResultBean updateBookAddressById (Integer sid,String addressName){

        Integer line = bookAddressService.updateBookAddressById(sid,addressName);
        if(line>0){
            return ResultBean.returnOk();
        }
        return ResultBean.returnError();

    }

    //查询图书物理区域
    @RequestMapping("selectBookAddressByPage")
    public ResultBean selectBookAddressByPage (Integer page,Integer limit){


        if(page == null ){
            page = 1;
        }
        if(limit == null){
            limit =10;
        }

        PageInfo<BsBookAddress> pageInfo = bookAddressService.selectBookAddressByPage(page,limit);

        long total = pageInfo.getTotal();
        List<BsBookAddress> list = pageInfo.getList();
        return ResultBean.returnOk().pushData("total", total).pushData("list",list);
    }

    //获取地址信息 用于下拉框
    @RequestMapping("getAddressOption")
    public ResultBean getAddressOption (){
        List<BsBookAddress> bsBookAddressses = bookAddressService.getAddressOption();
        List<OptionVO> list = new ArrayList<>();
        for (BsBookAddress bookAddress : bsBookAddressses) {
            OptionVO optionVO = new OptionVO();
            optionVO.setLabel(bookAddress.getAddressName());
            optionVO.setValue(bookAddress.getId().toString());
            list.add(optionVO);
        }
        return ResultBean.returnOk().pushData("data",list);
    }
}
