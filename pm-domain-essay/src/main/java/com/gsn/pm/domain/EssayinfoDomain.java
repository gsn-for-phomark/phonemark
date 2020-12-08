package com.gsn.pm.domain;


import lombok.Data;

@Data
public class EssayinfoDomain {

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

    public EssayinfoDomain(Integer eno, String ename, Integer mno, Integer tno, Integer cno, Integer status, String edate,
                           Integer eheat, String epic, String edser, Integer ecomcount, String spare1,
                           String spare2, String nickName) {
        this.eno = eno;
        this.ename = ename;
        this.mno = mno;
        this.tno = tno;
        this.cno = cno;
        this.status = status;
        this.edate = edate;
        this.eheat = eheat;
        this.epic = epic;
        this.edser = edser;
        this.ecomcount = ecomcount;
        this.spare1 = spare1;
        this.spare2 = spare2;
        this.nickName = nickName;
    }

    public EssayinfoDomain() {
    }
}
