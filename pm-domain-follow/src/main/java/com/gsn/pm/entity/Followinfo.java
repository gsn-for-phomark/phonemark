package com.gsn.pm.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name= "followinfo")
public class Followinfo {
    private static final long serialVersionUID = 5108766564600880548L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fno; //关注编号
    private Integer mno;//关注人编号
    private Integer bno;//被关注人编号
    private Integer fnum;//关注数
    private Integer bnum;//粉丝数
    private Integer status;

    public Followinfo(Integer fno, Integer mno, Integer bno, Integer fnum, Integer bnum, Integer status) {
        this.fno = fno;
        this.mno = mno;
        this.bno = bno;
        this.fnum = fnum;
        this.bnum = bnum;
        this.status = status;
    }

    public Followinfo() {
    }



}
