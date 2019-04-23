package com.sdm.multilingual.services.cores;

import com.sdm.multilingual.models.tables.Group;

import java.util.List;

public interface GroupWriteService {

    Group update(Group group);

    Group save(Group group);

    List<Group> saveAll(List<Group> listOfGroup);

}
