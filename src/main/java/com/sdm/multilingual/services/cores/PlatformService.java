package com.sdm.multilingual.services.cores;

import com.sdm.multilingual.models.tables.Platform;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PlatformService {

    long count();

    Platform findBySequence(int sequence);

    Platform findByDisplayName(String displayName);

    Platform update(Platform platform);

    Platform active(int platformSequence);

    Platform unactive(int platformSequence);

    Platform enable(int platformSequence);

    Platform unenable(int platformSequence);

    Page<Platform> findAllByPage(int offset, int limit);

    Platform save(Platform platform);

    List<Platform> saveAll(List<Platform> listOfPlatform);

}
