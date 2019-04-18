package com.sdm.multilingual.repositorys;

import com.sdm.multilingual.models.tables.DictPlatformTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DictPlatformRepository extends JpaRepository<DictPlatformTable, String> {

    // find by sequence and enableFlag
    DictPlatformTable findByPlatformSequenceAndEnableFlag(short platformSequence, byte enableFlag);

    // find by name and enableFlag
    DictPlatformTable findByDisplayNameAndEnableFlag(String displayName, byte enableFlag);

    // find by sequence and activeFlag and enableFlag
    DictPlatformTable findByPlatformSequenceAndActiveFlagAndEnableFlag(int platformSequence, byte activeFlag, byte enableFlag);

    // findAll by page and enableFlag (need pageable)
    Page<DictPlatformTable> findAllByEnableFlag(@Param("enableFlag") byte enableFlag, Pageable pageable);

}
