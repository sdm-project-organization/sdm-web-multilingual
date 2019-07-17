package com.mo.dict.repositorys;

import com.mo.dict.models.tables.Partition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartitionRepository extends JpaRepository<Partition, String>, CommonRepository<Partition> {

    // service_sequence

    List<Partition> findAllByServiceSequence(int serviceSequence);

    List<Partition> findAllByServiceSequenceAndEnableFlag(int serviceSequence, byte enableFlag);

    List<Partition> findAllByServiceSequenceAndActiveFlagAndEnableFlag(int serviceSequence, byte actvieFlag, byte enableFlag);

}