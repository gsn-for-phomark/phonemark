package com.gsn.pm.entity;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name= "essayinfo")
public class Essayinfo {

    /**
     *
     */
    private static final long serialVersionUID = 2593620613133115154L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eno ;//文章id
    private String ename;//文章标题
    private Integer mno;//用户id
    private Integer tno;//文章类型
    private Integer cno;//评论编号
    private Integer status;//文章状态   1.可用  2.禁用  3.热门
    private String edate;//发表时间
    private Integer eheat;//点赞数
    private String epic;//文章封面
    private String edser;//文章内容
    private Integer ecomcount;//评论数
    private String spare1;//备用字段1
    private String spare2;//备用字段2
    private String nickName;//作者名
}
