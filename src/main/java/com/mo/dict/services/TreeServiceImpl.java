package com.mo.dict.services;

import com.mo.dict.constants.EnableFlag;
import com.mo.dict.models.tables.Tree;
import com.mo.dict.repositorys.TreeRepository;
import com.mo.dict.services.cores.TreeService;
import com.mo.dict.utils.StringUtil;
import com.mo.dict.utils.TreeUtil;
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
        return treeRepository.findBySequence(sequence);
    }

    @Override
    public Tree findBySequenceAndEnableFlag(int sequence, byte enableFlag) {
        return treeRepository.findBySequenceAndEnableFlag(sequence, enableFlag);
    }

    @Override
    public Tree findBySequenceAndActiveFlagAndEnableFlag(int sequence, byte activeFlag, byte enableFlag) {
        return null;
    }

    @Override
    public List<Tree> findAllByDisplayName(String displayName) {
        return treeRepository.findAllByDisplayName(displayName);
    }

    @Override
    public List<Tree> findAllByDisplayNameAndEnableFlag(String displayName, byte enableFlag) {
        return treeRepository.findAllByDisplayNameAndEnableFlag(displayName, EnableFlag.Y.getValue());
    }

    @Override
    public List<Tree> findAllByDisplayNameAndActiveFlagAndEnableFlag(String displayName, byte activeFlag, byte enableFlag) {
        return null;
    }

    @Override
    public List<Tree> findAllByPartitionSequenceAndDisplayNameAndEnableFlag(int partitionSequence, String displayName, byte enableFlag) {
        return treeRepository.findAllByPartitionSequenceAndDisplayNameAndEnableFlag(
                partitionSequence, displayName, EnableFlag.Y.getValue());
    }


    @Override
    public Tree findByPartitionSequenceAndEqualTreePathAndEnableFlag(int partitionSequence, String treePath, byte enableFlag) {
        return treeRepository.findByPartitionSequenceAndTreePathAndEnableFlag(
                partitionSequence, treePath, EnableFlag.Y.getValue());
    }

    @Override
    public List<Tree> findAllByPartitionSequenceAndLessThanTreePathAndEnableFlag(int partitionSequence, String treePath, byte enableFlag) {
        return treeRepository.findAllByPartitionSequenceAndTreePathStartingWithAndEnableFlag(
                partitionSequence, treePath, EnableFlag.Y.getValue());
    }

    @Override
    public List<Tree> findAllByPartitionSequenceAndGreaterThanTreePathAndEnableFlag(int partitionSequence, String treePath, byte enableFlag) {
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

        if (equalTree != null)
            throw new Exception(); // TODO

        // 2.연결고리체크

        // 전체체크
        /*List<Tree> greaterThanTrees = findAllByPartitionSequenceAndGreaterThanTreePathAndEnableFlag(
                tree.getPartitionSequence(), tree.getTreePath(), EnableFlag.Y.getValue());*/

        // 상위체크
        Tree greaterThanTree = findByPartitionSequenceAndEqualTreePathAndEnableFlag(
                tree.getPartitionSequence(), TreeUtil.getNextGreaterThanTreePath(tree.getTreePath()), EnableFlag.Y.getValue());

        if (greaterThanTree == null)
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
        if (toTree == null)
            throw new NotFoundException(StringUtil.getExceptionMessage(this, "NOT_FOUNT"));

        if (tree.getTreeCode() != null || tree.getTreePath() != null) {
            List<Tree> lessThanTrees = findAllByPartitionSequenceAndLessThanTreePathAndEnableFlag(
                    tree.getPartitionSequence(), tree.getTreePath(), EnableFlag.Y.getValue());

            // TODO 1. treeCode 변경
            if (tree.getTreeCode() != null) {
                lessThanTrees.forEach(v -> {
                    List<String> listOfTreeCode = TreeUtil.dividePath(v.getTreePath());
                    listOfTreeCode.set(v.getTreeLevel() - 1, tree.getTreeCode());
                    v.setTreePath(TreeUtil.compressPath(listOfTreeCode));
                });
            }

            // TODO 2. treePath 변경
            Tree greaterThanTree = findByPartitionSequenceAndEqualTreePathAndEnableFlag(
                    tree.getPartitionSequence(), TreeUtil.getNextGreaterThanTreePath(tree.getTreePath()), EnableFlag.Y.getValue());

            if (greaterThanTree == null)
                throw new Exception(); // TODO

            if (tree.getTreePath() != null) {
                lessThanTrees.forEach(v -> {
                    List<String> listOfTreeCode = TreeUtil.dividePath(v.getTreePath());
                    listOfTreeCode.set(v.getTreeLevel() - 1, tree.getTreeCode());
                    v.setTreePath(TreeUtil.compressPath(listOfTreeCode));
                });
            }
        }

        treeRepository.flush();
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
