package com.gsn.pm.entity;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name= "heatinfo")
public class Heatinfo {
    private static final long serialVersionUID = 1736135195252845145L;
    private Integer heatno;
    private Integer eno;
    private Integer cno;
    private Integer mno;
}
