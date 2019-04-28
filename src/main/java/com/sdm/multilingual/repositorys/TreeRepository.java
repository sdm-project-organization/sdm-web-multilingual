package com.sdm.multilingual.repositorys;

import com.sdm.multilingual.models.tables.Partition;
import com.sdm.multilingual.models.tables.Tree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeRepository extends JpaRepository<Tree,String>, CommonRepository<Tree>  {


    // findAll by paritionSequence & name & enableFlag
    List<Tree> findAllByPartitionSequenceAndDisplayNameAndEnableFlag(int paritionSequence, String displayName, byte enableFlag);
    
    // findAll by serviceSequence & treeLevel & enableFlag
    List<Tree> findAllByPartitionSequenceAndTreeLevelAndEnableFlag(int paritionSequence, int treeLevel, byte enableFlag);
    
    // findAll by serviceSequence & treePath & enableFlag
    // @Query("SELECT g FROM DICT_TREE_TB g WHERE g.service_sq = :serviceSequence and g.treeLevel = :treeLevel and g.tree_path LIKE CONCAT(:treePath, '%') and g.enable_fl = :enableFlag")
    List<Tree> findAllByPartitionSequenceAndTreeLevelAndTreePathStartingWithAndEnableFlag(int paritionSequence, int treeLevel, String treePath, byte enableFlag);

}
