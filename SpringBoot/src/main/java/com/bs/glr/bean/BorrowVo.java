package com.bs.glr.bean;

import lombok.Data;

import java.util.Date;


@Data
public class BorrowVo  extends  BsBookInfo{
    Integer id;
    String endTime;
    String status;
    String getTime;
    String returnTime;
    String userNameCh;
    String userName;
    String overdue;
}
