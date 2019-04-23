package com.sdm.multilingual.models.tables;

import com.sdm.multilingual.constants.ActiveFlag;
import com.sdm.multilingual.constants.EnableFlag;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="DICT_GROUP_TB")
@EntityListeners(value = { AuditingEntityListener.class })
@Data
public class Group {

    @Id
    @Column(name="group_sq", updatable = false, nullable = false)
    /*@GeneratedValue(strategy=GenerationType.AUTO)*/
    private int groupSequence;

    @Column(name="service_sq", nullable = false)
    private int serviceSequence;

    /*@ManyToOne
    @Column(name = "service_sq")
    private Service service;*/

    @Column(name="group_cd")
    private String groupCode;

    @Column(name="group_path")
    private String groupPath;

    @Column(name="depth")
    private int depth;

    // =====================================================
    // Common

    @Column(name="disp_ord")
    private int displayOrder;

    @Column(name="disp_nm")
    private String displayName;

    @Column(name="`desc`")
    private String desc;

    @Column(name="active_fl", nullable = false)
    private byte activeFlag = ActiveFlag.Y.getValue();

    @Column(name="enable_fl", nullable = false)
    private byte enableFlag = EnableFlag.Y.getValue();

    @CreatedDate
    @Column(name="created_dt", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name="updated_dt")
    private LocalDateTime updatedDate;

    @CreatedBy
    @Column(name="writer")
    private String writer;

    @LastModifiedBy
    @Column(name="editor")
    private String editor;

    // =====================================================

}
