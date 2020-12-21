package com.gsn.pm.domain;

import com.gsn.pm.entity.Followinfo;
import lombok.Data;

import java.util.List;

@Data
public class FollowListDomain {
    private Integer follno;//关注人编号
    private Integer fansno;
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

    public FollowListDomain(Integer follno, Integer fansno, String nickName, String mpic, String msign, Integer messaynums, Integer fnum, Integer bnum, Integer showid, Integer fanshowid, Integer status, List<Followinfo> relation) {
        this.follno = follno;
        this.fansno = fansno;
        this.nickName = nickName;
        this.mpic = mpic;
        this.msign = msign;
        this.messaynums = messaynums;
        this.fnum = fnum;
        this.bnum = bnum;
        this.showid = showid;
        this.fanshowid = fanshowid;
        this.status = status;
        this.relation = relation;
    }

    public FollowListDomain() {
    }
}
