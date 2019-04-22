package com.sdm.multilingual.services;

import com.sdm.multilingual.constants.EnableFlag;
import com.sdm.multilingual.models.tables.Group;
import com.sdm.multilingual.repositorys.GroupRepository;
import com.sdm.multilingual.services.cores.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Override
    public long count() {
        return groupRepository.count();
    }

    @Override
    public Group findBySequence(long sequence) {
        return groupRepository.findByGroupSequenceAndEnableFlag(sequence, EnableFlag.Y.getValue());
    }

    @Override
    public List<Group> findAllByDisplayName(String displayName) {
        return groupRepository.findAllByDisplayNameAndEnableFlag(displayName, EnableFlag.Y.getValue());
    }

    @Override
    public Group update(Group group) {
        return null;
    }

    @Override
    public Group active(short sequence) {
        return null;
    }

    @Override
    public Group unactive(short sequence) {
        return null;
    }

    @Override
    public Group enable(short sequence) {
        return null;
    }

    @Override
    public Group unenable(short sequence) {
        return null;
    }

    @Override
    public Page<Group> findAllByPage(int offset, int limit) {
        return null;
    }

    @Override
    public Group save(Group group) {
        return null;
    }

    @Override
    public List<Group> saveAll(List<Group> listOfGroup) {
        return null;
    }
}
