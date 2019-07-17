package com.mo.dict.services.cores;

import com.mo.dict.models.tables.Tree;

import java.util.List;

public interface TreeServiceRead {

    List<Tree> findAllByPartitionSequenceAndDisplayNameAndEnableFlag(int partitionSequence, String displayName, byte enableFlag);

    Tree findByPartitionSequenceAndEqualTreePathAndEnableFlag(int partitionSequence, String treePath, byte enableFlag);

    List<Tree> findAllByPartitionSequenceAndLessThanTreePathAndEnableFlag(int partitionSequence, String treePath, byte enableFlag);

    List<Tree> findAllByPartitionSequenceAndGreaterThanTreePathAndEnableFlag(int partitionSequence, String treePath, byte enableFlag);

}
