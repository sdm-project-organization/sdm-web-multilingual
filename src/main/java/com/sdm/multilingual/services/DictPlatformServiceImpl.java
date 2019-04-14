package com.sdm.multilingual.services;

import com.sdm.multilingual.models.tables.DictCommonTable;
import com.sdm.multilingual.services.cores.DictCommonService;
import com.sdm.multilingual.services.cores.DictPlatformService;
import org.springframework.data.domain.Page;

import java.util.List;

public class DictPlatformServiceImpl implements DictPlatformService, DictCommonService {

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public DictCommonTable findBySequence(int sequence, byte enableFlag) {
        return null;
    }

    @Override
    public DictCommonTable findByDisplayName(String displayName, byte enableFlag) {
        return null;
    }

    @Override
    public Page<DictCommonTable> findAllByPage(int offset, int limit, byte enableFlag) {
        return null;
    }

    @Override
    public DictCommonTable save(DictCommonTable DictCommonTable) {
        return null;
    }

    @Override
    public List<DictCommonTable> saveAll(List<DictCommonTable> listOfDictCommonTable) {
        return null;
    }

    @Override
    public void update(DictCommonTable DictCommonTable) {

    }

    @Override
    public void active(int platformSequence) {

    }

    @Override
    public void unactive(int platformSequence) {

    }

    @Override
    public void enable(int platformSequence) {

    }

    @Override
    public void unenable(int platformSequence) {

    }

}
