package com.bs.glr.service;

import com.bs.glr.bean.BsRfid;


public interface RfidService {
    Integer updateStatus(String s);

    BsRfid getRfidId();

    Integer insertRfid(String rfidId);

    void setRfidStatusToOne();
}
