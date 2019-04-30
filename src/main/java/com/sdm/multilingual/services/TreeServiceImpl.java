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

import java.util.Arrays;
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
        return treeRepository.findBySequence( sequence );
    }

    @Override
    public Tree findBySequenceAndEnableFlag(int sequence, byte enableFlag) {
        return treeRepository.findBySequenceAndEnableFlag( sequence, enableFlag );
    }

    @Override
    public Tree findBySequenceAndActiveFlagAndEnableFlag(int sequence, byte activeFlag, byte enableFlag) {
        return null;
    }

    @Override
    public List<Tree> findAllByDisplayName( String displayName ) {
        return treeRepository.findAllByDisplayName( displayName );
    }

    @Override
    public List<Tree> findAllByDisplayNameAndEnableFlag(String displayName, byte enableFlag) {
        return treeRepository.findAllByDisplayNameAndEnableFlag( displayName, EnableFlag.Y.getValue() );
    }

    @Override
    public List<Tree> findAllByDisplayNameAndActiveFlagAndEnableFlag(String displayName, byte activeFlag, byte enableFlag) {
        return null;
    }

    @Override
    public List<Tree> findAllByPartitionSequenceAndDisplayNameAndEnableFlag( int partitionSequence, String displayName, byte enableFlag ) {
        return treeRepository.findAllByPartitionSequenceAndDisplayNameAndEnableFlag(
                partitionSequence, displayName, EnableFlag.Y.getValue());
    }


    @Override
    public Tree findByPartitionSequenceAndEqualTreePathAndEnableFlag( int partitionSequence, String treePath, byte enableFlag ) {
        return treeRepository.findByPartitionSequenceAndTreePathAndEnableFlag(
                partitionSequence, treePath, EnableFlag.Y.getValue());
    }

    @Override
    public List<Tree> findAllByPartitionSequenceAndLessThanTreePathAndEnableFlag( int partitionSequence, String treePath, byte enableFlag ) {
        return treeRepository.findAllByPartitionSequenceAndTreePathStartingWithAndEnableFlag(
                partitionSequence, treePath, EnableFlag.Y.getValue());
    }

    @Override
    public List<Tree> findAllByPartitionSequenceAndGreaterThanTreePathAndEnableFlag( int partitionSequence, String treePath, byte enableFlag ) {
        return treeRepository.findAllByPartitionSequenceAndTreePathInAndEnableFlag(
                partitionSequence, TreeUtil.getAllGreaterThanTreePath(treePath), EnableFlag.Y.getValue());
    }

    @Override
    public Page<Tree> findAllByPage(int offset, int limit) {
        return null;
    }

    @Override
    public Tree save(Tree tree) throws Exception {
        // 1.중복체크
        Tree equalTree = findByPartitionSequenceAndEqualTreePathAndEnableFlag(
                tree.getPartitionSequence(), tree.getTreePath(), EnableFlag.Y.getValue());

        if(equalTree != null)
            throw new Exception(); // TODO

        // 2.연결고리체크

        // 전체체크
        /*List<Tree> greaterThanTrees = findAllByPartitionSequenceAndGreaterThanTreePathAndEnableFlag(
                tree.getPartitionSequence(), tree.getTreePath(), EnableFlag.Y.getValue());*/

        // 상위체크
        Tree greaterThanTree = findByPartitionSequenceAndEqualTreePathAndEnableFlag(
                tree.getPartitionSequence(), TreeUtil.getNextGreaterThanTreePath(tree.getTreePath()), EnableFlag.Y.getValue());

        if(greaterThanTree == null)
            throw new Exception(); // TODO

        return treeRepository.save(tree);
    }

    @Override
    public List<Tree> saveAll(List<Tree> listOfTree) {
        return null;
    }

    @Override
    public void updateBySequence(int sequence, Tree tree) throws Exception {
        // TODO Transaction

        Tree toTree = findBySequenceAndEnableFlag(sequence, EnableFlag.Y.getValue());
        if(toTree == null)
            throw new NotFoundException(StringUtil.getExceptionMessage(this,"NOT_FOUNT"));

        // TODO 1. 하위트리변경 2. 관련노드변경


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
