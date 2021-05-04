package com.gsn.pm.domain;


import lombok.Data;

@Data
public class EssayList {

    private static final long serialVersionUID = -1314106515974211623L;
    private Integer eno ;//文章id
    private String ename;//文章标题
    private Integer mno;//用户id
    private String nickName;//用户名
    private Integer tno;//文章类型
    private String tname;//文章类型名
    private Integer cno;//评论id
    private Integer status;//文章状态   1.可用  2.禁用  3.热门
    private String edate;//发表时间
    private Integer eheat;//点赞数
    private String epic;//文章封面
    private String edser;//文章内容
    private String mpic;//用户头像
    private String etime;//已发表时间
    private String cnum;//评论数

}
