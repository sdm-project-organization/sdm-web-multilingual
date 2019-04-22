package com.sdm.multilingual.models.tables;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="DICT_GROUP_TB")
@Data
public class Group {

    @Id
    @Column(name="group_sq")
    /*@GeneratedValue(strategy=GenerationType.AUTO)*/
    private long groupSequence;

    @Column(name="service_sq")
    private short serviceSequence;

    /*@ManyToOne
    @Column(name = "service_sq")
    private Service service;*/

    @Column(name="group_cd")
    private String groupCode;

    @Column(name="group_path")
    private String groupPath;

    @Column(name="depth")
    private short depth;

    // =====================================================
    // Common

    @Column(name="disp_ord")
    private short displayOrder;

    @Column(name="disp_nm")
    private String displayName;

    @Column(name="created_dt")
    private LocalDateTime createdDate;

    @Column(name="updated_dt")
    private LocalDateTime updatedDate;

    @Column(name="active_fl")
    private byte activeFlag;

    @Column(name="enable_fl")
    private byte enableFlag;

    @Column(name="writer")
    private String writer;

    @Column(name="editor")
    private String editor;

    @Column(name="desc")
    private String desc;

    // =====================================================

}
