package com.sdm.multilingual.models.tables;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DICT_PLATFORM_TB")
@Data
public class DictPlatformTable extends DictCommonTable {

    @Id
    @Column(name="platform_sq")
    private short platformSequence;

}
