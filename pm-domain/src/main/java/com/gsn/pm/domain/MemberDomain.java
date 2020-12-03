package com.gsn.pm.domain;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
public class MemberDomain {

    private Integer mno;//用户id
    private String nickName;//用户名
    private String msex;//用户性别
    private String pwd;//用户密码
    private String tel;//用户电话
    private String email;//用户邮箱
    private Integer status;//用户状态     1.正常 2.禁用
    private String mpic;
    private String msign;
    private Integer messaynums;
    private Integer eno;
    private Integer fno;
    private Integer cno;
    private String spare1;//备用字段1
    private String spare2;//备用字段2

    public MemberDomain(Integer mno, String nickName, String msex, String pwd, String tel, String email, Integer status, String mpic, String msign, Integer messaynums, Integer eno, Integer fno, Integer cno, String spare1, String spare2) {
        this.mno = mno;
        this.nickName = nickName;
        this.msex = msex;
        this.pwd = pwd;
        this.tel = tel;
        this.email = email;
        this.status = status;
        this.mpic = mpic;
        this.msign = msign;
        this.messaynums = messaynums;
        this.eno = eno;
        this.fno = fno;
        this.cno = cno;
        this.spare1 = spare1;
        this.spare2 = spare2;
    }

    public MemberDomain() {
    }
}
