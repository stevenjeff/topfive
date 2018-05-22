package com.fangrui.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/5/21
 */
@Entity
@EqualsAndHashCode
@Data
@Table(name = "RESOURCE", schema = "PUBLIC", catalog = "PUBLIC")
public class Resource {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private Integer type;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "url")
    private String url;
    @Column(name = "author")
    private String author;
    @Column(name = "createTime")
    private Timestamp createTime;
}
