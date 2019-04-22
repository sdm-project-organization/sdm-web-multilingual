package com.sdm.multilingual.services.cores;

import com.sdm.multilingual.models.tables.Group;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GroupFindService {

    // Master
    Group findBySequence(long sequence);

    // Master
    List<Group> findAllByDisplayName(String displayName);

    // Master
    Page<Group> findAllByPage(int offset, int limit);

    // Open
    Page<Group> findAllByServiceIdAndDepth(long serviceId, int depth);

    // Open
    Page<Group> findAllByServiceIdAndGroupPath(long serviceId, String groupPath);

    // Open
    Page<Group> findAllByServiceIdAndDisplayName(long serviceId, String displayName);

}
