package com.gsn.pm.domain;

import lombok.Data;

@Data
public class EssayVO {

    private static final long serialVersionUID = 1L;
    private Integer eno;// 文章id
    private String ename;// 文章标题
    private Integer mno;// 用户id
    private Integer status;// 文章状态
    private String edate;// 发表时间
    private Integer eheat;// 点赞数
    private String epic;// 文章封面
    private String nickName;// 作者名
    private String mpic;// 作者头像
    private Integer commentcount;// 评论数
}
