package com.sdm.multilingual.services.cores;

import com.sdm.multilingual.models.tables.Group;

public interface GroupService extends GroupReadService, GroupWriteService {

    long count();

    Group active(int sequence);

    Group unactive(int sequence);

    Group enable(int sequence);

    Group unenable(int sequence);

}
