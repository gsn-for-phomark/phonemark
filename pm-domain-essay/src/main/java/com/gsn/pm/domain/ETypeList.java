package com.gsn.pm.domain;

import lombok.Data;

@Data

public class ETypeList {

    private Integer tno; //类型id  类似与tag
    private String tname;//类型名称
    private String typedesc;//类型简介
    private Integer eno;//文章编号
    private Integer mno;

    public Integer getTno() {
        return tno;
    }

    public void setTno(Integer tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTypedesc() {
        return typedesc;
    }

    public void setTypedesc(String typedesc) {
        this.typedesc = typedesc;
    }

    public Integer getEno() {
        return eno;
    }

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public Integer getMno() {
        return mno;
    }

    public void setMno(Integer mno) {
        this.mno = mno;
    }


    public ETypeList(Integer tno, String tname, String typedesc, Integer eno, Integer mno) {
        this.tno = tno;
        this.tname = tname;
        this.typedesc = typedesc;
        this.eno = eno;
        this.mno = mno;
    }

    public ETypeList() {
    }
}
