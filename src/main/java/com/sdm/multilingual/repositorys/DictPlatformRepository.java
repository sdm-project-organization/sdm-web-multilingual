package com.sdm.multilingual.repositorys;

import com.sdm.multilingual.models.tables.DictPlatformTable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface DictPlatformRepository extends JpaRepository<DictPlatformTable, Integer> {

    // find by sequence
    DictPlatformTable findByPlatformSequenceAndEnableFlag(int platformSequence, byte enableFlag);

    // find by name
    DictPlatformTable findByDisplayNameAndEnableFlag(String displayName, byte enableFlag);

    // findAll by page
    Page<DictPlatformTable> findAllByEnableFlag(@Param("enableFlag") byte enableFlag);

}
