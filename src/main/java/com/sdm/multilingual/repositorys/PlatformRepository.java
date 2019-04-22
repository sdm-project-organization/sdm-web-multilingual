package com.sdm.multilingual.repositorys;

import com.sdm.multilingual.models.tables.Platform;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, String> {

    // ======================================================
    // Common

    // find by sequence and enableFlag
    Platform findByPlatformSequenceAndEnableFlag(short platformSequence, byte enableFlag);

    // find by name and enableFlag
    Platform findByDisplayNameAndEnableFlag(String displayName, byte enableFlag);

    // find by sequence and activeFlag and enableFlag
    Platform findByPlatformSequenceAndActiveFlagAndEnableFlag(int platformSequence, byte activeFlag, byte enableFlag);

    // findAll by page and enableFlag (need pageable)
    Page<Platform> findAllByEnableFlag(@Param("enableFlag") byte enableFlag, Pageable pageable);

    // ======================================================

}
