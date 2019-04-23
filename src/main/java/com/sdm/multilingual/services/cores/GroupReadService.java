package com.sdm.multilingual.services.cores;

import com.sdm.multilingual.models.tables.Group;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GroupReadService {

    // Master
    Group findBySequence(int sequence);

    // Master
    List<Group> findAllByDisplayName(String displayName);

    // Master
    Page<Group> findAllByPage(int offset, int limit);

    // Open
    List<Group> findAllByServiceSequenceAndDepth(int serviceSequence, int depth);

    // Open
    List<Group> findAllByServiceSequenceAndGroupPath(int serviceSequence, String groupPath);

    // Open
    List<Group> findAllByServiceSequenceAndDisplayName(int serviceSequence, String displayName);

}
