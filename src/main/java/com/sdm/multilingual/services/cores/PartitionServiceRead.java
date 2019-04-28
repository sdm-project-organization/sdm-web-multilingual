package com.sdm.multilingual.services.cores;

import com.sdm.multilingual.models.tables.Partition;
import com.sdm.multilingual.repositorys.PartitionRepository;

import java.util.List;

public interface PartitionServiceRead /*extends PartitionRepository*/ {

    List<Partition> findAllByServiceSequence(int serviceSequence);

    List<Partition> findAllByServiceSequenceAndEnableFlag(int serviceSequence, byte enableFlag);

    List<Partition> findAllByServiceSequenceAndActiveFlagAndEnableFlag(int serviceSequence, byte actvieFlag, byte enableFlag);

}
