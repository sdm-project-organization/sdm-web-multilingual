package com.sdm.multilingual.models.tables;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="DICT_PLATFORM_TB")
@Data
public class DictPlatformTable {

    @Id
    @Column(name="platform_sq")
    /*@GeneratedValue(strategy=GenerationType.AUTO)*/
    private short platformSequence;

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

}
