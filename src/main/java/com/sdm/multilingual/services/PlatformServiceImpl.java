package com.sdm.multilingual.services;

import com.sdm.multilingual.constants.ActiveFlag;
import com.sdm.multilingual.constants.EnableFlag;
import com.sdm.multilingual.models.tables.Platform;
import com.sdm.multilingual.repositorys.PlatformRepository;
import com.sdm.multilingual.services.cores.CommonService;
import com.sdm.multilingual.services.cores.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformServiceImpl implements PlatformService, CommonService {

    @Autowired
    PlatformRepository platformRepository;

    @Override
    public long count() {
        return platformRepository.count();
    }

    @Override
    public Platform findBySequence(int sequence) {
        return platformRepository.findByPlatformSequenceAndEnableFlag(sequence, EnableFlag.Y.getValue());
    }

    @Override
    public Platform findByDisplayName(String displayName) {
        return platformRepository.findByDisplayNameAndEnableFlag(displayName, EnableFlag.Y.getValue());
    }

    @Override
    public Page<Platform> findAllByPage(int offset, int limit) {
        /*return dictPlatformRepository.findAllByEnableFlag(EnableFlag.Y.getValue());*/
        return null;
    }

    @Override
    public Platform save(Platform platform) {
        return platformRepository.save(platform);
    }

    @Override
    public List<Platform> saveAll(List<Platform> listOfPlatform) {
        return platformRepository.saveAll(listOfPlatform);
    }

    @Override
    public Platform update(Platform platform) {
        platformRepository.flush();
        return platform;
    }

    @Override
    public Platform active(int platformSequence) {
        Platform platform =
                platformRepository.findByPlatformSequenceAndActiveFlagAndEnableFlag(
                        platformSequence, ActiveFlag.N.getValue(), EnableFlag.Y.getValue());
        platform.setActiveFlag(ActiveFlag.Y.getValue());
        platformRepository.flush();
        return platform;
    }

    @Override
    public Platform unactive(int platformSequence) {
        Platform platform =
                platformRepository.findByPlatformSequenceAndActiveFlagAndEnableFlag(
                        platformSequence, ActiveFlag.Y.getValue(), EnableFlag.Y.getValue());
        platform.setActiveFlag(ActiveFlag.N.getValue());
        platformRepository.flush();
        return platform;
    }

    @Override
    public Platform enable(int platformSequence) {
        Platform platform =
                platformRepository.findByPlatformSequenceAndEnableFlag(
                        platformSequence, EnableFlag.N.getValue());
        platform.setEnableFlag(EnableFlag.Y.getValue());
        platformRepository.flush();
        return platform;
    }

    @Override
    public Platform unenable(int platformSequence) {
        Platform platform =
                platformRepository.findByPlatformSequenceAndEnableFlag(
                        platformSequence, EnableFlag.Y.getValue());
        platform.setEnableFlag(EnableFlag.N.getValue());
        platformRepository.flush();
        return platform;
    }

}
