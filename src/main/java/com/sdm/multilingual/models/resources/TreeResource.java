package com.sdm.multilingual.models.resources;

import com.sdm.multilingual.constants.ActiveFlag;
import com.sdm.multilingual.constants.EnableFlag;
import com.sdm.multilingual.models.tables.Tree;
import com.sdm.multilingual.utils.TreeUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TreeResource implements Serializable {

    private int treeSequence;
    private int partitionSequence;
    private String treeCode;
    private String treePath;
    private int treeLevel;
    private int displayOrder;
    private String displayName;
    private String desc;
    private byte activeFlag;
    private byte enableFlag;

    private List<String> listOfCode;

    public TreeResource toInsert() {
        setTreeSequence(0);
        setPartitionSequence(1); // TODO TEMP
        listOfCode.add(getTreeCode());
        setTreePath(TreeUtil.compressPath(listOfCode));
        setTreeLevel(listOfCode.size());
        setActiveFlag(ActiveFlag.Y.getValue());
        setEnableFlag(EnableFlag.Y.getValue());
        return this;
    }

    public Tree toEntity() {
        Tree tree = new Tree();
        tree.setPartitionSequence(partitionSequence); // TODO TEMP
        tree.setTreeCode(treeCode);
        tree.setTreePath(treePath);
        tree.setTreeLevel(treeLevel);
        tree.setDisplayOrder(displayOrder);
        tree.setDisplayName(displayName);
        tree.setDesc(desc);
        tree.setActiveFlag(activeFlag);
        tree.setEnableFlag(enableFlag);
        return tree;
    }
}
