package com.fangrui.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "{resource.type.notBlank}")
    @Column(name = "type", columnDefinition = "int not null")
    private Integer type;
    @NotBlank(message = "{resource.name.notBlank}")
    @Column(name = "name", unique = true, columnDefinition = "varchar(200) not null")
    private String name;
    @NotBlank(message = "{resource.url.notBlank}")
    @Column(name = "url", columnDefinition = "varchar(2000) not null")
    private String url;
    @Column(name = "author")
    private String author;
    @Column(name = "createTime", columnDefinition = "Date not null")
    @SuppressWarnings("unchecked")
    private Timestamp createTime;
}
