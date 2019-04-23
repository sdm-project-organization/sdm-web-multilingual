package com.sdm.multilingual.services;

import com.sdm.multilingual.constants.EnableFlag;
import com.sdm.multilingual.models.tables.Group;
import com.sdm.multilingual.repositorys.GroupRepository;
import com.sdm.multilingual.services.cores.GroupService;
import com.sdm.multilingual.utils.GroupUtil;
import com.sdm.multilingual.utils.StringUtil;
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
    public Group findBySequence(int sequence) {
        return groupRepository.findByGroupSequenceAndEnableFlag(
                sequence,
                EnableFlag.Y.getValue());
    }

    @Override
    public List<Group> findAllByDisplayName(String displayName) {
        return groupRepository.findAllByDisplayNameAndEnableFlag(
                displayName,
                EnableFlag.Y.getValue());
    }

    @Override
    public List<Group> findAllByServiceSequenceAndDisplayName(int serviceSequence, String displayName) {
        return groupRepository.findAllByServiceSequenceAndDisplayNameAndEnableFlag(
                serviceSequence,
                displayName,
                EnableFlag.Y.getValue());
    }

    @Override
    public List<Group> findAllByServiceSequenceAndGroupPath(int serviceSequence, String groupPath) {
        return groupRepository.findAllByServiceSequenceAndDepthAndGroupPathStartingWithAndEnableFlag(
                serviceSequence,
                GroupUtil.dividePath(groupPath).size(),
                groupPath,
                EnableFlag.Y.getValue());
    }

    @Override
    public List<Group> findAllByServiceSequenceAndDepth(int serviceSequence, int depth) {
        return groupRepository.findAllByServiceSequenceAndDepthAndEnableFlag(serviceSequence, depth, EnableFlag.Y.getValue());
    }

    @Override
    public Page<Group> findAllByPage(int offset, int limit) {
        return null;
    }

    @Override
    public Group update(Group group) {
        return null;
    }

    @Override
    public Group active(int sequence) {
        return null;
    }

    @Override
    public Group unactive(int sequence) {
        return null;
    }

    @Override
    public Group enable(int sequence) {
        return null;
    }

    @Override
    public Group unenable(int sequence) {
        return null;
    }

    @Override
    public Group save(Group group) {
        // TODO 1.중복체크 2.연결고리
        return groupRepository.save(group);
    }

    @Override
    public List<Group> saveAll(List<Group> listOfGroup) {
        return null;
    }
}
