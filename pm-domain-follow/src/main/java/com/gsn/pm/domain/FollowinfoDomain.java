package com.gsn.pm.domain;

import lombok.Data;

@Data
public class FollowinfoDomain {
    private Integer fno; //关注编号
    private Integer mno;//关注人编号
    private Integer bno;//被关注人编号
    private Integer fnum;//关注数
    private Integer bnum;//粉丝数
    private Integer status;

    public FollowinfoDomain(Integer fno, Integer mno, Integer bno, Integer fnum, Integer bnum, Integer status) {
        this.fno = fno;
        this.mno = mno;
        this.bno = bno;
        this.fnum = fnum;
        this.bnum = bnum;
        this.status = status;
    }

    public FollowinfoDomain() {
    }
}
