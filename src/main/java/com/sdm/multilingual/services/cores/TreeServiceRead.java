package com.sdm.multilingual.services.cores;

import com.sdm.multilingual.models.tables.Tree;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TreeServiceRead {

    List<Tree> findAllByPartitionSequenceAndDisplayNameAndEnableFlag(int partitionSequence, String displayName, byte enableFlag);

    Tree findByPartitionSequenceAndEqualTreePathAndEnableFlag(int partitionSequence, String treePath, byte enableFlag);

    List<Tree> findAllByPartitionSequenceAndLessThanTreePathAndEnableFlag(int partitionSequence, String treePath, byte enableFlag);

    List<Tree> findAllByPartitionSequenceAndGreaterThanTreePathAndEnableFlag(int partitionSequence, String treePath, byte enableFlag);

}
