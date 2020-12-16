package com.gsn.pm.entity;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name= "essaytype")
public class EssayType {

    private static final long serialVersionUID = 2593620613133115154L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tno; //类型id  类似与tag
    private String tname;//类型名称
    private String typedesc;//类型简介
    private Integer eno;//文章编号
    private String spare1;//备用字段1
    private String spare2;//备用字段2
    private Integer totalNum;//各类的文章数     -------------------改了
}
