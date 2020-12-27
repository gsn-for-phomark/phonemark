package com.gsn.pm.entity;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name= "memberinfo")
public class Memberinfo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2593620613133115154L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
