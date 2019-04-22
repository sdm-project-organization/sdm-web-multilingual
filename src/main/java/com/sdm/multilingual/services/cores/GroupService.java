package com.sdm.multilingual.services.cores;

import com.sdm.multilingual.models.tables.Group;

import java.util.List;

public interface GroupService extends GroupFindService, GroupUpdateService {

    long count();

    Group update(Group group);

    Group active(short sequence);

    Group unactive(short sequence);

    Group enable(short sequence);

    Group unenable(short sequence);

    Group save(Group group);

    List<Group> saveAll(List<Group> listOfGroup);

}
