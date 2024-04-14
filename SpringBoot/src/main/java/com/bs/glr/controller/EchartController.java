package com.bs.glr.controller;

import com.bs.glr.bean.BsUser;
import com.bs.glr.bean.EchartBean;
import com.bs.glr.bean.ResultBean;
import com.bs.glr.service.BookInfoService;
import com.bs.glr.service.EchartService;
import com.bs.glr.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/auth/echart")
public class EchartController {

    @Resource
    EchartService echartService;

    @Resource
    UserService userService;

    @Resource
    BookInfoService bookInfoService;

    /**
     * @desc //获取用户类型饼状图
     * @Date  2022/5/2
     **/
    @RequestMapping("getUserInfoChart")
    public ResultBean getUserInfoChart (){
        //获取不活跃读者数量
        List<BsUser> inactiveList = userService.getInactiveUser();
        //获取一般读者数量
        List<BsUser> commonlyList = userService.getCommonlyUser();
        //获取活跃读者数量
        List<BsUser> activeList = userService.getActiveUser();
        List<EchartBean> list = new ArrayList<>();
        list.add(new EchartBean("不活跃",inactiveList.size()));
        list.add(new EchartBean("一般",commonlyList.size()));
        list.add(new EchartBean("活跃",activeList.size()));

        return ResultBean.returnOk().pushData("data",list);
    }
    /**
     * @desc //获取借阅图书类型占比
     * @Date  2022/5/2
     **/
    @RequestMapping("getBookTypeInfoChart")
    public ResultBean getBookTypeInfoChart (){
        List<EchartBean> echartBeans = bookInfoService.getBookTypeInfoChart();
        return ResultBean.returnOk().pushData("data",echartBeans);
    }


    /**
     * @desc //获取借阅图书类型占比
     * @Date  2022/5/8
     **/
    @RequestMapping("getBookTypeInfoChartByUid")
    public ResultBean getBookTypeInfoChartByUid (Integer uid){
        List<EchartBean> echartBeans = bookInfoService.getBookTypeInfoChartByUid(uid);
        return ResultBean.returnOk().pushData("data",echartBeans);
    }


    /**
     * @desc //setBootCountChart
     * @Date  2022/5/2
     **/
    @RequestMapping("getBootCountChart")
    public ResultBean getBootCountChart (){
        List<EchartBean> echartBeans = bookInfoService.getBootCountChart();
        List<String> xData = new ArrayList<>();
        List<Integer> yData = new ArrayList<>();

        for (EchartBean echartBean : echartBeans) {
            xData.add(echartBean.getName());
            yData.add(echartBean.getValue());
        }
        return ResultBean.returnOk().pushData("xData",xData).pushData("yData",yData);
    }


    /**
     * @desc //获取某个用户的借书数量
     * @Date  2022/5/2
     **/
    @RequestMapping("getBookCountByUid")
    public ResultBean getBookCountByUid (String uid){
        List<EchartBean> echartBeans = bookInfoService.getBootCountChartByUid(uid);
        List<String> xData = new ArrayList<>();
        List<Integer> yData = new ArrayList<>();

        for (EchartBean echartBean : echartBeans) {
            xData.add(echartBean.getName());
            yData.add(echartBean.getValue());
        }
        return ResultBean.returnOk().pushData("xData",xData).pushData("yData",yData);
    }


}
