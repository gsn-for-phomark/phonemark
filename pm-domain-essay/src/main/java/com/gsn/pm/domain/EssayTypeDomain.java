package com.gsn.pm.domain;


import lombok.Data;

@Data
public class EssayTypeDomain {

    private Integer tno; //类型id  类似与tag
    private String tname;//类型名称
    private String typedesc;//类型简介
    private Integer eno;//文章编号
    private String spare1;//备用字段1
    private String spare2;//备用字段2
    private Integer totalNum;//各类的文章数     -------------------改了

    public EssayTypeDomain(Integer tno, String tname, String typedesc,
                           Integer eno, String spare1, String spare2, Integer totalNum) {
        this.tno = tno;
        this.tname = tname;
        this.typedesc = typedesc;
        this.eno = eno;
        this.spare1 = spare1;
        this.spare2 = spare2;
        this.totalNum = totalNum;
    }

    public EssayTypeDomain() {
    }
}
