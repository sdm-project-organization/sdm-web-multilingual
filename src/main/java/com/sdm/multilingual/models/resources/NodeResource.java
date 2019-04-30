package com.sdm.multilingual.models.resources;

import com.sdm.multilingual.constants.ActiveFlag;
import com.sdm.multilingual.constants.EnableFlag;
import com.sdm.multilingual.models.tables.Node;
import com.sdm.multilingual.models.tables.Tree;
import lombok.Data;

import java.io.Serializable;

@Data
public class NodeResource extends CommonResource<Node, NodeResource> implements Serializable {

    private Integer partitionSequence;
    private Integer treeSequence;
    private String txt0;

    @Override
    public NodeResource toInsert() throws Exception {
        setSequence(CommonResource.INIT_SEQUENCE);
        setPartitionSequence(1); // TODO TEMP
        setActiveFlag(ActiveFlag.Y.getValue());
        setEnableFlag(EnableFlag.Y.getValue());
        return this;
    }

    @Override
    public NodeResource toUpdate() throws Exception {
        setSequence(CommonResource.INIT_SEQUENCE);
        setPartitionSequence(1); // TODO TEMP
        return this;
    }

    @Override
    public Node toEntity() {
        Node node = new Node();
        node.setSequence(this.getSequence());
        node.setPartitionSequence(this.getPartitionSequence());
        node.setTreeSequence(this.getTreeSequence());
        node.setTxt0(this.getTxt0());
        node.setDisplayOrder(this.getDisplayOrder());
        node.setDisplayName(this.getDisplayName());
        node.setDesc(this.getDesc());
        node.setActiveFlag(this.getActiveFlag());
        node.setEnableFlag(this.getEnableFlag());
        return node;
    }

}
