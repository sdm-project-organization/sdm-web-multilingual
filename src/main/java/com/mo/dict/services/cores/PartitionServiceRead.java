package com.mo.dict.services.cores;

import com.mo.dict.models.tables.Partition;

import java.util.List;

public interface PartitionServiceRead /*extends PartitionRepository*/ {

    List<Partition> findAllByServiceSequence(int serviceSequence);

    List<Partition> findAllByServiceSequenceAndEnableFlag(int serviceSequence, byte enableFlag);

    List<Partition> findAllByServiceSequenceAndActiveFlagAndEnableFlag(int serviceSequence, byte actvieFlag, byte enableFlag);

}
