package com.mo.dict.models.resources;

import com.mo.dict.constants.ActiveFlag;
import com.mo.dict.constants.EnableFlag;
import com.mo.dict.models.tables.Tree;
import com.mo.dict.utils.StringUtil;
import com.mo.dict.utils.TreeUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TreeResource extends CommonResource<Tree, TreeResource> implements Serializable {

    private Integer partitionSequence;
    private String treeCode;
    private String treePath;
    private Integer treeLevel;
    private List<String> listOfCode;

    @Override
    public TreeResource toInsert() throws Exception {
        setSequence(CommonResource.INIT_SEQUENCE);
        setPartitionSequence(1); // TODO TEMP

        // 1. null 체크
        if (getTreeCode() == null || getTreeCode() == "")
            throw new Exception();

        // 2. 문자열 체크
        if (getTreeCode().contains(String.valueOf(StringUtil.DELIMETER_OF_PATH)))
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
        setSequence(CommonResource.INIT_SEQUENCE);
        setPartitionSequence(1); // TODO TEMP

        return this;
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
        return tree;
    }

}
