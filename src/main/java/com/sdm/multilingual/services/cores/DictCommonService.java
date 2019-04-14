package com.sdm.multilingual.services.cores;

import com.sdm.multilingual.models.tables.DictCommonTable;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DictCommonService {

    int count();

    int countAll();

    DictCommonTable findBySequence(int sequence, byte enableFlag);

    DictCommonTable findByDisplayName(String displayName, byte enableFlag);

    Page<DictCommonTable> findAllByPage(int offset, int limit, byte enableFlag);

    DictCommonTable save(DictCommonTable DictCommonTable);

    List<DictCommonTable> saveAll(List<DictCommonTable> listOfDictCommonTable);

    void update(DictCommonTable DictCommonTable);

    void active(int platformSequence);

    void unactive(int platformSequence);

    void enable(int platformSequence);

    void unenable(int platformSequence);

}
