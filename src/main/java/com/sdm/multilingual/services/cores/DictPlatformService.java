package com.sdm.multilingual.services.cores;

import com.sdm.multilingual.models.tables.DictCommonTable;
import com.sdm.multilingual.models.tables.DictPlatformTable;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DictPlatformService {

    long count();

    DictPlatformTable findBySequence(short sequence);

    DictPlatformTable findByDisplayName(String displayName);

    DictPlatformTable update(DictPlatformTable dictPlatformTable);

    DictPlatformTable active(short platformSequence);

    DictPlatformTable unactive(short platformSequence);

    DictPlatformTable enable(short platformSequence);

    DictPlatformTable unenable(short platformSequence);

    Page<DictPlatformTable> findAllByPage(int offset, int limit);

    DictPlatformTable save(DictPlatformTable dictPlatformTable);

    List<DictPlatformTable> saveAll(List<DictPlatformTable> listOfDictPlatformTable);

}
