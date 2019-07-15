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
@Table(name = "DICT_NODE_TB")
@EntityListeners(value = {AuditingEntityListener.class})
@Data
public class Node {

    public static final String[] CANNOT_UPDATED_FIELDS = new String[]{"sequence", "createdDate", "writer", "updatedDate", "editor"};

    @Id
    @Column(name = "node_sq", nullable = false, updatable = false)
    public Integer sequence;

    @Column(name = "partition_sq", nullable = false)
    public Integer partitionSequence;

    @Column(name = "tree_sq", nullable = false)
    public Integer treeSequence;

    @Column(name = "txt0")
    public String txt0;

    @Column(name = "disp_ord")
    public Integer displayOrder;

    @Column(name = "disp_nm")
    public String displayName;

    @Column(name = "`desc`")
    public String desc;

    @Column(name = "active_fl", nullable = false)
    public Byte activeFlag = ActiveFlag.Y.getValue();

    @Column(name = "enable_fl", nullable = false)
    public Byte enableFlag = EnableFlag.Y.getValue();

    @CreatedDate
    @Column(name = "created_dt", nullable = false, updatable = false)
    public LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_dt")
    public LocalDateTime updatedDate;

    @CreatedBy
    @Column(name = "writer", nullable = false, updatable = false)
    public String writer;

    @LastModifiedBy
    @Column(name = "editor")
    public String editor;

}
