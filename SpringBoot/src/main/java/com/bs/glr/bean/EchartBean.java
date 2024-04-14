package com.bs.glr.bean;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class EchartBean {
    Integer deviceId;
    Integer dId;
    Integer paramId;
    String[] date;
    Integer value;
    String name;

    public EchartBean() {
    }

    public EchartBean(String name,Integer value) {
        this.value = value;
        this.name = name;
    }
}
