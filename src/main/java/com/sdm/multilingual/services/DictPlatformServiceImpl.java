package com.sdm.multilingual.services;

import com.sdm.multilingual.constants.ActiveFlag;
import com.sdm.multilingual.constants.EnableFlag;
import com.sdm.multilingual.models.tables.DictCommonTable;
import com.sdm.multilingual.models.tables.DictPlatformTable;
import com.sdm.multilingual.repositorys.DictPlatformRepository;
import com.sdm.multilingual.services.cores.DictCommonService;
import com.sdm.multilingual.services.cores.DictPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictPlatformServiceImpl implements DictPlatformService, DictCommonService {

    @Autowired
    DictPlatformRepository dictPlatformRepository;


    @Override
    public long count() {
        return dictPlatformRepository.count();
    }

    @Override
    public DictPlatformTable findBySequence(short sequence) {
        return dictPlatformRepository.findByPlatformSequenceAndEnableFlag(sequence, EnableFlag.Y.getValue());
    }

    @Override
    public DictPlatformTable findByDisplayName(String displayName) {
        return dictPlatformRepository.findByDisplayNameAndEnableFlag(displayName, EnableFlag.Y.getValue());
    }

    @Override
    public Page<DictPlatformTable> findAllByPage(int offset, int limit) {
        /*return dictPlatformRepository.findAllByEnableFlag(EnableFlag.Y.getValue());*/
        return null;
    }

    @Override
    public DictPlatformTable save(DictPlatformTable dictPlatformTable) {
        return dictPlatformRepository.save(dictPlatformTable);
    }

    @Override
    public List<DictPlatformTable> saveAll(List<DictPlatformTable> listOfDictPlatformTable) {
        return dictPlatformRepository.saveAll(listOfDictPlatformTable);
    }

    @Override
    public DictPlatformTable update(DictPlatformTable dictPlatformTable) {
        dictPlatformRepository.flush();
        return dictPlatformTable;
    }

    @Override
    public DictPlatformTable active(short platformSequence) {
        DictPlatformTable dictPlatformTable =
                dictPlatformRepository.findByPlatformSequenceAndActiveFlagAndEnableFlag(
                        platformSequence, ActiveFlag.N.getValue(), EnableFlag.Y.getValue());
        dictPlatformTable.setActiveFlag(ActiveFlag.Y.getValue());
        dictPlatformRepository.flush();
        return dictPlatformTable;
    }

    @Override
    public DictPlatformTable unactive(short platformSequence) {
        DictPlatformTable dictPlatformTable =
                dictPlatformRepository.findByPlatformSequenceAndActiveFlagAndEnableFlag(
                        platformSequence, ActiveFlag.Y.getValue(), EnableFlag.Y.getValue());
        dictPlatformTable.setActiveFlag(ActiveFlag.N.getValue());
        dictPlatformRepository.flush();
        return dictPlatformTable;
    }

    @Override
    public DictPlatformTable enable(short platformSequence) {
        DictPlatformTable dictPlatformTable =
                dictPlatformRepository.findByPlatformSequenceAndEnableFlag(
                        platformSequence, EnableFlag.N.getValue());
        dictPlatformTable.setEnableFlag(EnableFlag.Y.getValue());
        dictPlatformRepository.flush();
        return dictPlatformTable;
    }

    @Override
    public DictPlatformTable unenable(short platformSequence) {
        DictPlatformTable dictPlatformTable =
                dictPlatformRepository.findByPlatformSequenceAndEnableFlag(
                        platformSequence, EnableFlag.Y.getValue());
        dictPlatformTable.setEnableFlag(EnableFlag.N.getValue());
        dictPlatformRepository.flush();
        return dictPlatformTable;
    }

}
