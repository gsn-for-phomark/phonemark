package com.gsn.pm.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
public class EssayComment {

    private static final long serialVersionUID = 163653102481878662L;

    private Integer eno ;//文章id
    private String ename;//文章标题
    private Integer mno;//用户id
    private Integer status;//文章状态   1.可用  2.禁用  3.热门
    private String edate;//发表时间
    private Integer eheat;//点赞数
    private String epic;//文章封面
    private String edser;//文章内容
    private Integer commentcount;//评论数
    private String mpic;//用户头像
    private String nickName;//作者名

    private Integer tno;
    private String tname;
}
