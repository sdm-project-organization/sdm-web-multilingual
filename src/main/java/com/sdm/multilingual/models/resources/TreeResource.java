package com.sdm.multilingual.models.resources;

import com.sdm.multilingual.constants.ActiveFlag;
import com.sdm.multilingual.constants.EnableFlag;
import com.sdm.multilingual.models.tables.Partition;
import com.sdm.multilingual.models.tables.Tree;
import com.sdm.multilingual.utils.StringUtil;
import com.sdm.multilingual.utils.TreeUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TreeResource extends CommonResource<Tree, TreeResource> implements Serializable {

    private int partitionSequence;
    private String treeCode;
    private String treePath;
    private int treeLevel;
    private List<String> listOfCode;

    @Override
    public TreeResource toInsert() throws Exception {
        setSequence(CommonResource.INIT_SEQUENCE);
        setPartitionSequence(1); // TODO TEMP

        // 1. null 체크
        if(getTreeCode() == null || getTreeCode() == "")
            throw new Exception();

        // 2. 문자열 체크
        if(getTreeCode().contains(String.valueOf(StringUtil.DELIMETER_OF_PATH)))
            throw new Exception();

        listOfCode.add(getTreeCode());
        setTreePath(TreeUtil.compressPath(listOfCode));
        setTreeLevel(listOfCode.size());
        setActiveFlag(ActiveFlag.Y.getValue());
        setEnableFlag(EnableFlag.Y.getValue());
        return this;
    }

    @Override
    public TreeResource toUpdate() {
        return null;
    }

    @Override
    public Tree toEntity() {
        Tree tree = new Tree();
        tree.setSequence(this.getSequence());
        tree.setPartitionSequence(this.getPartitionSequence());
        tree.setTreeCode(this.getTreeCode());
        tree.setTreePath(this.getTreePath());
        tree.setTreeLevel(this.getTreeLevel());
        tree.setDisplayOrder(this.getDisplayOrder());
        tree.setDisplayName(this.getDisplayName());
        tree.setDesc(this.getDesc());
        tree.setActiveFlag(this.getActiveFlag());
        tree.setEnableFlag(this.getEnableFlag());
        System.out.println(tree.toString()); // TODO LOG
        return tree;
    }

}
