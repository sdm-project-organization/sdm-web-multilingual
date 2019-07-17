package com.mo.dict.repositorys;

import com.mo.dict.models.tables.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeRepository extends JpaRepository<Tree, String>, CommonRepository<Tree> {


    // findAll by paritionSequence & name & enableFlag
    List<Tree> findAllByPartitionSequenceAndDisplayNameAndEnableFlag(int paritionSequence, String displayName, byte enableFlag);

    // findAll by partitionSequence & treeLevel & enableFlag
    List<Tree> findAllByPartitionSequenceAndTreeLevelAndEnableFlag(int paritionSequence, int treeLevel, byte enableFlag);

    // findAll by partitionSequence & treePath & enableFlag
    Tree findByPartitionSequenceAndTreePathAndEnableFlag(int paritionSequence, String treePath, byte enableFlag);

    // findAll by partitionSequence & treePath (LessThan) & enableFlag
    // @Query("SELECT g FROM DICT_TREE_TB g WHERE g.partition_sq = :partitionSequence and g.tree_level = :treeLevel and g.tree_path LIKE CONCAT(:treePath, '%') and g.enable_fl = :enableFlag")
    List<Tree> findAllByPartitionSequenceAndTreePathStartingWithAndEnableFlag(int partitionSequence, String treePath, byte enableFlag);

    // findAll by partitionSequence & treePath (GreaterThan) & enableFlag
    // @Query("SELECT t FROM DICT_TREE_TB t WHERE g.partition_sq = :partitionSequence AND t.tree_path IN (:treePaths) AND t.enable_fl = :enableFlag")
    List<Tree> findAllByPartitionSequenceAndTreePathInAndEnableFlag(int partitionSequence, List<String> treePaths, byte enableFlag);

}
