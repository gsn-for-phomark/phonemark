package com.gsn.pm.entity;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@Table(name= "commentinfo")
public class Commentinfo {
    /**
     *
     */
    private static final long serialVersionUID = 8606619959699859981L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cno ;//评论id
    private Integer eno ;//文章id
    private Integer mno ;//用户id
    private String cdesr;//评论具体内容
    private String cheat;//评论点赞数
    private String cdate;//评论时间
    private String cstatus;//评论状态
    private Integer flag;//判断评论层数
    private String spare1;//备用字段1 为二级评论所用的字段： 回复对象的回复id（cno）
    private String tel;//评论用户电话
    private String email;//评论用户邮箱
    private String ename;//评论文章名
    private String comcount;//评论文章 评论总数
    private String spare2;//备用字段2   为三级评论所用的字段： 回复对象的回复id（cno）
    private String nickName;//评论用户名
    private String mpic;//评论用户头像
    private List<Commentinfo> level2com;
    private Integer replyid;//回复对象的 用户id
    private String replyname;//回复对象的 用户名
    private String countcom1;//一级评论下 评论总数
    private Integer showandhid;//小回复的显示和隐藏
    private Integer heat;//点赞数

}
