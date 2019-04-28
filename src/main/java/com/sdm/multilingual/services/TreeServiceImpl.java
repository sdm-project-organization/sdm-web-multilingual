package com.sdm.multilingual.services;

import com.sdm.multilingual.constants.EnableFlag;
import com.sdm.multilingual.models.tables.Partition;
import com.sdm.multilingual.models.tables.Tree;
import com.sdm.multilingual.repositorys.TreeRepository;
import com.sdm.multilingual.services.cores.TreeService;
import com.sdm.multilingual.utils.StringUtil;
import com.sdm.multilingual.utils.TreeUtil;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    TreeRepository treeRepository;

    @Override
    public long count() {
        return treeRepository.count();
    }

    @Override
    public Tree findBySequence(int sequence) {
        return treeRepository.findBySequenceAndEnableFlag(
                sequence,
                EnableFlag.Y.getValue());
    }

    @Override
    public Tree findBySequenceAndEnableFlag(int sequence, byte enableFlag) {
        return null;
    }

    @Override
    public Tree findBySequenceAndActiveFlagAndEnableFlag(int sequence, byte activeFlag, byte enableFlag) {
        return null;
    }

    @Override
    public List<Tree> findAllByDisplayName(String displayName) {
        return treeRepository.findAllByDisplayNameAndEnableFlag(
                displayName,
                EnableFlag.Y.getValue());
    }

    @Override
    public List<Tree> findAllByDisplayNameAndEnableFlag(String displayName, byte enableFlag) {
        return null;
    }

    @Override
    public List<Tree> findAllByDisplayNameAndActiveFlagAndEnableFlag(String displayName, byte activeFlag, byte enableFlag) {
        return null;
    }

    @Override
    public List<Tree> findAllByPartitionSequenceAndDisplayName(int serviceSequence, String displayName) {
        return treeRepository.findAllByPartitionSequenceAndDisplayNameAndEnableFlag(
                serviceSequence,
                displayName,
                EnableFlag.Y.getValue());
    }

    @Override
    public List<Tree> findAllByPartitionSequenceAndTreePath(int serviceSequence, String treePath) {
        return treeRepository.findAllByPartitionSequenceAndTreeLevelAndTreePathStartingWithAndEnableFlag(
                serviceSequence,
                TreeUtil.dividePath(treePath).size(),
                treePath,
                EnableFlag.Y.getValue());
    }

    @Override
    public List<Tree> findAllByPartitionSequenceAndTreeLevel(int serviceSequence, int treeLevel) {
        return treeRepository.findAllByPartitionSequenceAndTreeLevelAndEnableFlag(
                serviceSequence,
                treeLevel,
                EnableFlag.Y.getValue());
    }

    @Override
    public Page<Tree> findAllByPage(int offset, int limit) {
        return null;
    }

    @Override
    public Tree save(Tree tree) {
        // TODO 1.중복체크 2.연결고리
        return treeRepository.save(tree);
    }

    @Override
    public List<Tree> saveAll(List<Tree> listOfTree) {
        return null;
    }

    @Override
    public void updateBySequence(int sequence, Tree tree) {

    }

    @Override
    public void active(int sequence) {

    }

    @Override
    public void unactive(int sequence) {

    }

    @Override
    public void enable(int sequence) {

    }

    @Override
    public void unenable(int sequence) throws Exception {

    }

}
