package com.sdm.multilingual.services.cores;

import com.sdm.multilingual.models.tables.Tree;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TreeServiceRead {

    List<Tree> findAllByPartitionSequenceAndTreeLevel(int partitionSequence, int treeLevel);

    List<Tree> findAllByPartitionSequenceAndTreePath(int partitionSequence, String treePath);

    List<Tree> findAllByPartitionSequenceAndDisplayName(int partitionSequence, String displayName);

}
