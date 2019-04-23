package com.sdm.multilingual.models.resources;

import com.sdm.multilingual.constants.ActiveFlag;
import com.sdm.multilingual.constants.EnableFlag;
import com.sdm.multilingual.models.tables.Group;
import com.sdm.multilingual.utils.GroupUtil;
import com.sdm.multilingual.utils.StringUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class GroupResource implements Serializable {

    private int groupSequence;
    private int serviceSequence;
    private String groupCode;
    private String groupPath;
    private int depth;
    private int displayOrder;
    private String displayName;
    private String desc;
    private byte activeFlag;
    private byte enableFlag;

    private List<String> listOfCode;

    // TODO 추상화
    public GroupResource toInsert() {
        setGroupSequence(0);
        setServiceSequence(1); // TODO TEMP
        listOfCode.add(getGroupCode());
        setGroupPath(GroupUtil.compressPath(listOfCode));
        setDepth(listOfCode.size());
        setActiveFlag(ActiveFlag.Y.getValue());
        setEnableFlag(EnableFlag.Y.getValue());
        return this;
    }

    // TODO 추상화
    public Group toEntity() {
        Group group = new Group();
        group.setServiceSequence(serviceSequence); // TODO TEMP
        group.setGroupCode(groupCode);
        group.setGroupPath(groupPath);
        group.setDepth(depth);
        group.setDisplayOrder(displayOrder);
        group.setDisplayName(displayName);
        group.setDesc(desc);
        group.setActiveFlag(activeFlag);
        group.setEnableFlag(enableFlag);
        return group;
    }
}
