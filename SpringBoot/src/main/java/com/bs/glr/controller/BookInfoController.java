package com.bs.glr.controller;

import com.alibaba.druid.util.StringUtils;
import com.bs.glr.bean.*;
import com.bs.glr.service.BookAddressService;
import com.bs.glr.service.BookInfoService;
import com.bs.glr.service.BookSortService;
import com.bs.glr.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/auth/book/info")
public class BookInfoController {

    @Resource
    BookInfoService bookInfoService;
    @Resource
    BookSortService bookSortService;
    @Resource
    BookAddressService bookAddressService;

    @Resource
    UserService userService;

    //添加图书信息
    @RequestMapping("addBookInfo")
    public ResultBean addBookInfo (String bookName, Integer sortId, String rfidId, Integer addressId,
                                   String author, String press, String publicationDate,String  imageUrl,String bookCount,String isbn){
        Integer count = 0;
        try {
            count = Integer.parseInt(bookCount);
        } catch (NumberFormatException e) {
            return ResultBean.returnError("图书数量必输且为数字");
        }
        if(count<0){
            return ResultBean.returnError("图书数量不能小于0");
        }


        if(StringUtils.isEmpty(imageUrl)){
            return ResultBean.returnError("图书封面图片必输");
        }
        if(StringUtils.isEmpty(rfidId)){
            return ResultBean.returnError("请获取RFID");
        }

        if(sortId == null ||addressId == null){
            return ResultBean.returnError("请将信息输入完整");
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = new Date();
        try {
            parse = format.parse(publicationDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResultBean.returnError("时间转换失败");
        }

        BsBookInfo bsBookInfoRfid = bookInfoService.getBookByRfid(rfidId);
        if (bsBookInfoRfid != null){
            return ResultBean.returnError("该RFID信息已经存在");
        }

        BsBookInfo bsBookInfo = new BsBookInfo();
        bsBookInfo.setBookName(bookName);
        bsBookInfo.setSortId(sortId);
        bsBookInfo.setAddressId(addressId);
        bsBookInfo.setRfidId(rfidId);
        bsBookInfo.setSelectNumber(0);
        bsBookInfo.setAuthor(author);
        bsBookInfo.setPublicationDate(parse);
        bsBookInfo.setPress(press);
        bsBookInfo.setPhotoUrl(imageUrl);
        bsBookInfo.setCreateTime(new Date());
        bsBookInfo.setIsbn(isbn);
        bsBookInfo.setRaters("5");
        bsBookInfo.setRatersNumber(1);
        if(count==0){
            bsBookInfo.setBookStatus("不可借");
        }else{
            bsBookInfo.setBookStatus("可借");
        }

        bsBookInfo.setBookCount(bookCount);
        Integer line = bookInfoService.insertBookInfo(bsBookInfo);
        if(line>0){
            return ResultBean.returnOk();
        }
        return ResultBean.returnError();

    }

    //修改图书信息
    @RequestMapping("updateAllBookInfoById")
    public ResultBean updateAllBookInfoById (Integer bid,String bookName, Integer sortId, String rfidId, Integer addressId,
                                   String author, String press, String publicationDate,String  imageUrl,String bookCount){
        Integer count = 0;
        try {
            count = Integer.parseInt(bookCount);
        } catch (NumberFormatException e) {
            return ResultBean.returnError("图书数量必输且为数字");
        }
        if(count<0){
            return ResultBean.returnError("图书数量不能小于0");
        }


        if(StringUtils.isEmpty(imageUrl)){
            return ResultBean.returnError("图书封面图片必输");
        }
        if(StringUtils.isEmpty(rfidId)){
            return ResultBean.returnError("请获取RFID");
        }

        if(sortId == null ||addressId == null){
            return ResultBean.returnError("请将信息输入完整");
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = new Date();
        try {
            parse = format.parse(publicationDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResultBean.returnError("时间转换失败");
        }


        BsBookInfo bsBookInfo = new BsBookInfo();
        bsBookInfo.setId(bid);
        bsBookInfo.setBookName(bookName);
        bsBookInfo.setSortId(sortId);
        bsBookInfo.setAddressId(addressId);
        bsBookInfo.setRfidId(rfidId);
        bsBookInfo.setAuthor(author);
        bsBookInfo.setPublicationDate(parse);
        bsBookInfo.setPress(press);
        bsBookInfo.setPhotoUrl(imageUrl);
        if(count==0){
            bsBookInfo.setBookStatus("不可借");
        }else{
            bsBookInfo.setBookStatus("可借");
        }

        bsBookInfo.setBookCount(bookCount);
        Integer line = bookInfoService.updateAllBookInfoById(bsBookInfo);
        if(line>0){
            return ResultBean.returnOk();
        }
        return ResultBean.returnError();

    }
    /**
     * @desc //根据主键获取图书信息
     * * @Date  2022/4/30
     **/
    @RequestMapping("getBookInfoById")
    public ResultBean getBookInfoById (Integer bid){

        BsBookInfo bookById = bookInfoService.getBookById(bid);
        BsBookSort bsBookSort = bookSortService.selectBookSortById(bookById.getSortId());
        BsBookAddress bookAddress = bookAddressService.selectBookAddressById(bookById.getAddressId());
        bookById.setSortName(bsBookSort.getSortName());
        bookById.setAddressName(bookAddress.getAddressName());
        return ResultBean.returnOk().pushData("data",bookById);

    }
    //删除图书信息
    @RequestMapping("delBookInfoById")
    public ResultBean delBookInfoById (Integer aid){

        Integer line = bookInfoService.delBookInfo(aid);
        if(line>0){
            return ResultBean.returnOk();
        }
        return ResultBean.returnError();

    }

    //更新图书信息  分类id以及地址id
    @RequestMapping("updateBookInfoById")
    public ResultBean updateBookInfoById (Integer sid,Integer sortId,Integer addressId){

        if (sortId == null || addressId == null){
            return ResultBean.returnError();
        }

        Integer line = bookInfoService.updateBookInfoById(sid,sortId,addressId);
        if(line>0){
            return ResultBean.returnOk();
        }
        return ResultBean.returnError();

    }

    @RequestMapping("updateBookAddresssInfoById")
    public ResultBean updateBookInfoById (Integer sid,Integer addressId){

        if ( addressId == null){
            return ResultBean.returnError();
        }

        Integer line = bookInfoService.updateBookInfoById(sid,addressId);
        if(line>0){
            return ResultBean.returnOk();
        }
        return ResultBean.returnError();

    }

    //查询图书信息 根据借阅信息倒序
    @RequestMapping("selectBookInfoByPage")
    public ResultBean selectBookInfoByPage (Integer page,Integer limit){


        if(page == null ){
            page = 1;
        }
        if(limit == null){
            limit =10;
        }

        PageInfo<BsBookInfo> pageInfo = bookInfoService.selectBookInfoByPage(page,limit);

        List<BsBookAddress> addressOption = bookAddressService.getAddressOption();
        List<BsBookSort> sortOption = bookSortService.getSortOption();

        long total = pageInfo.getTotal();
        List<BsBookInfo> list = pageInfo.getList();
        List<BsBookInfo> retuenList = new ArrayList<>();

        for (BsBookInfo bsBookInfo : list) {
            bsBookInfo.setAddressName(getAddressName(addressOption,bsBookInfo.getAddressId()));
            bsBookInfo.setSortName(getSortName(sortOption,bsBookInfo.getSortId()));
            retuenList.add(bsBookInfo);
        }

        return ResultBean.returnOk().pushData("total", total).pushData("list",retuenList);
    }

    //查询图书信息 根据上架时间倒序
    @RequestMapping("getBookInfoCreatList")
    public ResultBean getBookInfoCreatList (Integer page,Integer limit){


        if(page == null ){
            page = 1;
        }
        if(limit == null){
            limit =10;
        }

        PageInfo<BsBookInfo> pageInfo = bookInfoService.getBookInfoCreatList(page,limit);

        List<BsBookAddress> addressOption = bookAddressService.getAddressOption();
        List<BsBookSort> sortOption = bookSortService.getSortOption();

        long total = pageInfo.getTotal();
        List<BsBookInfo> list = pageInfo.getList();
        List<BsBookInfo> retuenList = new ArrayList<>();

        for (BsBookInfo bsBookInfo : list) {
            bsBookInfo.setAddressName(getAddressName(addressOption,bsBookInfo.getAddressId()));
            bsBookInfo.setSortName(getSortName(sortOption,bsBookInfo.getSortId()));
            retuenList.add(bsBookInfo);
        }

        return ResultBean.returnOk().pushData("total", total).pushData("list",retuenList);
    }

    //根据条件查询
    @RequestMapping("selectBookInfoConditionByPage")
    public ResultBean selectBookInfoConditionByPage (String bookName,String author,String press,Integer page,Integer limit){
        if(page == null ){
            page = 1;
        }
        if(limit == null){
            limit =10;
        }

        PageInfo<BsBookInfo> pageInfo = bookInfoService.selectBookInfoConditionByPage(bookName,author,press,page,limit);

        List<BsBookAddress> addressOption = bookAddressService.getAddressOption();
        List<BsBookSort> sortOption = bookSortService.getSortOption();

        long total = pageInfo.getTotal();
        List<BsBookInfo> list = pageInfo.getList();
        List<BsBookInfo> retuenList = new ArrayList<>();

        for (BsBookInfo bsBookInfo : list) {
            bsBookInfo.setAddressName(getAddressName(addressOption,bsBookInfo.getAddressId()));
            bsBookInfo.setSortName(getSortName(sortOption,bsBookInfo.getSortId()));
            retuenList.add(bsBookInfo);
        }

        return ResultBean.returnOk().pushData("total", total).pushData("list",retuenList);
    }

    //查询图书信息 根据图书id
    @RequestMapping("selectBookInfoById")
    public ResultBean selectBookInfoById(Integer id){

        BsBookInfo bsBookInfo = bookInfoService.selectBookInfoById(id);

        return ResultBean.returnOk().pushData("date", bsBookInfo);
    }

    //查询图书信息 根据图书名称
    @RequestMapping("selectBookInfoByBookName")
    public ResultBean selectBookInfoByBookName(String bookName,Integer page,Integer limit){
        if(page == null ){
            page = 1;
        }
        if(limit == null){
            limit =10;
        }

        PageInfo<BsBookInfo> pageInfo  = bookInfoService.selectBookInfoByBookName(bookName,page,limit);

        long total = pageInfo.getTotal();
        List<BsBookInfo> list = pageInfo.getList();
        return ResultBean.returnOk().pushData("total", total).pushData("list",list);
    }

    //查询图书信息 根据图书分类id
    @RequestMapping("selectBookInfoByBookSortId")
    public ResultBean selectBookInfoByBookSortId(Integer sortId,Integer page,Integer limit){
        if(page == null ){
            page = 1;
        }
        if(limit == null){
            limit =10;
        }

        PageInfo<BsBookInfo> pageInfo  = bookInfoService.selectBookInfoByBookSortId(sortId,page,limit);


        List<BsBookAddress> addressOption = bookAddressService.getAddressOption();
        List<BsBookSort> sortOption = bookSortService.getSortOption();

        long total = pageInfo.getTotal();
        List<BsBookInfo> list = pageInfo.getList();
        List<BsBookInfo> retuenList = new ArrayList<>();

        for (BsBookInfo bsBookInfo : list) {
            bsBookInfo.setAddressName(getAddressName(addressOption,bsBookInfo.getAddressId()));
            bsBookInfo.setSortName(getSortName(sortOption,bsBookInfo.getSortId()));
            retuenList.add(bsBookInfo);
        }

        return ResultBean.returnOk().pushData("total", total).pushData("list",retuenList);
    }

    private String getAddressName(List<BsBookAddress>  list,Integer key){
        for (BsBookAddress bsBookAddress : list) {
            if(key.equals(bsBookAddress.getId())){
                return bsBookAddress.getAddressName();
            }
        }

        return "获取失败";
    }

    private String getSortName(List<BsBookSort>  list,Integer key){
        for (BsBookSort bsBookSort : list) {
            if(key.equals(bsBookSort.getId())){
                return bsBookSort.getSortName();
            }
        }

        return "获取失败";
    }

    /**
     * @desc //使用RFID获取书籍信息
     * @Date  2022/4/30
     **/
    @RequestMapping("getBookInfoByRfid")
    public ResultBean getBookInfoByRfid (String rfid){
        BsBookInfo bookByRfid = bookInfoService.getBookByRfid(rfid);
        return ResultBean.returnOk().pushData("data",bookByRfid);
    }


}
