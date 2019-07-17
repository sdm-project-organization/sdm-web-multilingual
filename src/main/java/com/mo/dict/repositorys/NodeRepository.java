package com.mo.dict.repositorys;

import com.mo.dict.models.tables.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends JpaRepository<Node, String>, CommonRepository<Node> {

}