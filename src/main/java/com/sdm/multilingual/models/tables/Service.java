package com.sdm.multilingual.models.tables;

import javax.persistence.*;

//@Entity
//@Table(name="DICT_SERVICE_TB")
//@Data
public class Service extends CommonTable {

    @Id
    @Column(name="service_sq")
    private int serviceSequence;

    @Column(name="platform_sq")
    private int platformSequence;

    @Column(name="export_type")
    private byte exportType;

    @Column(name="export_url")
    private String exportUrl;

}
