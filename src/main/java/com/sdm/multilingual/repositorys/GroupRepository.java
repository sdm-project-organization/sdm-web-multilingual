package com.sdm.multilingual.repositorys;

import com.sdm.multilingual.models.tables.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, String>  {

    // ======================================================
    // Common

    // find by sequence & enableFlag
    Group findByGroupSequenceAndEnableFlag(int sequence, byte enableFlag);

    // find by name & enableFlag
    Group findByDisplayNameAndEnableFlag(String displayName, byte enableFlag);

    // find by sequence & activeFlag & enableFlag
    Group findByGroupSequenceAndActiveFlagAndEnableFlag(int sequence, byte activeFlag, byte enableFlag);

    // findAll by page & enableFlag (need pageable)
    Page<Group> findAllByEnableFlag(@Param("enableFlag") byte enableFlag, Pageable pageable);

    // ======================================================

    // findAll by name & enableFlag
    List<Group> findAllByDisplayNameAndEnableFlag(String displayName, byte enableFlag);

    // findAll by serviceSequence & name & enableFlag
    List<Group> findAllByServiceSequenceAndDisplayNameAndEnableFlag(int serviceSequence, String displayName, byte enableFlag);
    
    // findAll by serviceSequence & depth & enableFlag
    List<Group> findAllByServiceSequenceAndDepthAndEnableFlag(int serviceSequence, int depth, byte enableFlag);
    
    // findAll by serviceSequence & groupPath & enableFlag
    // @Query("SELECT g FROM DICT_GROUP_TB g WHERE g.service_sq = :serviceSequence and g.depth = :depth and g.group_path LIKE CONCAT(:groupPath, '%') and g.enable_fl = :enableFlag")
    List<Group> findAllByServiceSequenceAndDepthAndGroupPathStartingWithAndEnableFlag(int serviceSequence, int depth, String groupPath, byte enableFlag);

}
