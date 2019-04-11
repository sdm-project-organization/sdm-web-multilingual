package com.sdm.multilingual.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="DICT_SERVICE")
public class DictService {

    @Id
    @Column(name="service_id")
    private short serviceId;

    @Column(name="service_name")
    private short serviceName;

    @Column(name="export_type")
    private byte exportType;

    @Column(name="export_url")
    private String exportUrl;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name="active")
    private byte active;

    @Column(name="enable")
    private byte enable;

    @Column(name="writer")
    private String writer;

    @Column(name="modifier")
    private String modifier;

    @Column(name="desc")
    private String desc;

}
