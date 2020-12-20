package com.gsn.pm.domain;

import lombok.Data;

@Data
public class ETypeList {
    private Integer tno; //类型id  类似与tag
    private String tname;//类型名称
    private String typedesc;//类型简介
    private Integer eno;//文章编号
    private Integer mno;

    @Override
    public String toString() {
        return "ETypeList{" +
                "tno=" + tno +
                ", tname='" + tname + '\'' +
                ", typedesc='" + typedesc + '\'' +
                ", eno=" + eno +
                ", mno=" + mno +
                '}';
    }
}
