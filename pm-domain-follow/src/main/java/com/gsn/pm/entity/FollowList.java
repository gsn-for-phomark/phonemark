package com.gsn.pm.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
@Data
public class FollowList {

    private static final long serialVersionUID = 47270913890810661L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer follno;//关注人编号
    private Integer fansno;//粉丝id
    private String nickName;//用户名
    private String mpic;
    private String msign;
    private Integer messaynums;
    private Integer fnum;//关注数
    private Integer bnum;//粉丝数
    private Integer showid;
    private Integer fanshowid;
    private Integer status;
    private List<Followinfo> relation;


}
