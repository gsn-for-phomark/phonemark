package com.gsn.pm.domain;


import lombok.Data;

@Data
public class EssayShow {

    private static final long serialVersionUID = -7414549563617697916L;
    private Integer eno ;//文章id
    private String ename;//文章标题
    private Integer mno;//用户id
    private Integer tno;//文章类型
    private Integer status;//文章状态   1.可用  2.禁用  3.热门
    private String edate;//发表时间
    private Integer eheat;//点赞数
    private String epic;//文章封面
    private String edser;//文章内容
    private Integer ecomcount;//评论数
    private String nickName;//作者名
    private String mpic;//作者头像
}
