package com.sdm.multilingual.repositorys;

import com.sdm.multilingual.models.tables.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, String>  {

    // ======================================================
    // Common

    // find by sequence and enableFlag
    Group findByGroupSequenceAndEnableFlag(long sequence, byte enableFlag);

    // find by name and enableFlag
    Group findByDisplayNameAndEnableFlag(String displayName, byte enableFlag);

    // find by sequence and activeFlag and enableFlag
    Group findByGroupSequenceAndActiveFlagAndEnableFlag(int sequence, byte activeFlag, byte enableFlag);

    // findAll by page and enableFlag (need pageable)
    Page<Group> findAllByEnableFlag(@Param("enableFlag") byte enableFlag, Pageable pageable);

    // ======================================================

    // findAll by name and enableFlag
    List<Group> findAllByDisplayNameAndEnableFlag(String displayName, byte enableFlag);

}
