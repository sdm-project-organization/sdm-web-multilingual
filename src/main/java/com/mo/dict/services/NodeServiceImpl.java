package com.mo.dict.services;

import com.mo.dict.constants.EnableFlag;
import com.mo.dict.models.tables.Node;
import com.mo.dict.repositorys.NodeRepository;
import com.mo.dict.services.cores.NodeServicce;
import com.mo.dict.utils.StringUtil;
import com.mo.dict.utils.SystemUtil;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeServiceImpl implements NodeServicce {

    @Autowired
    NodeRepository nodeRepository;

    @Override
    public long count() {
        return nodeRepository.count();
    }

    @Override
    public Node findBySequence(int sequence) {
        return nodeRepository.findBySequence(sequence);
    }

    @Override
    public Node findBySequenceAndEnableFlag(int sequence, byte enableFlag) {
        return nodeRepository.findBySequenceAndEnableFlag(sequence, enableFlag);
    }

    @Override
    public Node findBySequenceAndActiveFlagAndEnableFlag(int sequence, byte activeFlag, byte enableFlag) {
        return nodeRepository.findBySequenceAndActiveFlagAndEnableFlag(sequence, enableFlag, activeFlag);
    }

    @Override
    public List<Node> findAllByDisplayName(String displayName) {
        return nodeRepository.findAllByDisplayName(displayName);
    }

    @Override
    public List<Node> findAllByDisplayNameAndEnableFlag(String displayName, byte enableFlag) {
        return nodeRepository.findAllByDisplayNameAndEnableFlag(displayName, enableFlag);

    }

    @Override
    public List<Node> findAllByDisplayNameAndActiveFlagAndEnableFlag(String displayName, byte activeFlag, byte enableFlag) {
        return null;
    }

    @Override
    public Page<Node> findAllByPage(int offset, int limit) {
        return null;
    }

    @Override
    public Node save(Node node) throws Exception {
        nodeRepository.save(node);
        return node;
    }

    @Override
    public List<Node> saveAll(List<Node> list) {
        return null;
    }

    @Override
    public void updateBySequence(int sequence, Node fromNode) throws Exception {
        Node toNode = findBySequenceAndEnableFlag(sequence, EnableFlag.Y.getValue());
        if (toNode == null)
            throw new NotFoundException(StringUtil.getExceptionMessage(this, "NOT_FOUNT"));

        SystemUtil.moveEntityToEntity(Node.CANNOT_UPDATED_FIELDS, Node.class, fromNode, toNode);
        nodeRepository.flush();
    }

    @Override
    public void active(int sequence) {

    }

    @Override
    public void unactive(int sequence) {

    }

    @Override
    public void enable(int sequence) {

    }

    @Override
    public void unenable(int sequence) throws Exception {
        Node node = findBySequenceAndEnableFlag(sequence, EnableFlag.Y.getValue());
        if (node == null)
            throw new NotFoundException(StringUtil.getExceptionMessage(this, "NOT_FOUNT"));

        node.setEnableFlag(EnableFlag.N.getValue());
        nodeRepository.flush();
    }
}
