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
@Table(name = "DICT_TREE_TB")
@EntityListeners(value = { AuditingEntityListener.class })
@Data
public class Tree {

    @Id
    @Column(name = "tree_sq", updatable = false, nullable = false)
    private int sequence;

    @Column(name = "partition_sq", nullable = false)
    private int partitionSequence;

    /*@ManyToOne
    @Column(name = "service_sq")
    private Partition service;*/

    @Column(name = "tree_cd")
    private String treeCode;

    @Column(name = "tree_path")
    private String treePath;

    @Column(name = "tree_level")
    private int treeLevel;

    // =====================================================
    // Common

    @Column(name = "disp_ord")
    private int displayOrder;

    @Column(name = "disp_nm")
    private String displayName;

    @Column(name = "`desc`")
    private String desc;

    @Column(name = "active_fl", nullable = false)
    private byte activeFlag = ActiveFlag.Y.getValue();

    @Column(name = "enable_fl", nullable = false)
    private byte enableFlag = EnableFlag.Y.getValue();

    @CreatedDate
    @Column(name = "created_dt", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_dt")
    private LocalDateTime updatedDate;

    @CreatedBy
    @Column(name = "writer")
    private String writer;

    @LastModifiedBy
    @Column(name = "editor")
    private String editor;

    // =====================================================

}
