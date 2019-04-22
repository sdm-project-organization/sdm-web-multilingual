package com.sdm.multilingual.services.cores;

import com.sdm.multilingual.models.tables.Platform;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PlatformService {

    long count();

    Platform findBySequence(short sequence);

    Platform findByDisplayName(String displayName);

    Platform update(Platform platform);

    Platform active(short platformSequence);

    Platform unactive(short platformSequence);

    Platform enable(short platformSequence);

    Platform unenable(short platformSequence);

    Page<Platform> findAllByPage(int offset, int limit);

    Platform save(Platform platform);

    List<Platform> saveAll(List<Platform> listOfPlatform);

}
