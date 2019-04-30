package com.sdm.multilingual.services;

import com.sdm.multilingual.constants.EnableFlag;
import com.sdm.multilingual.models.tables.Partition;
import com.sdm.multilingual.repositorys.PartitionRepository;
import com.sdm.multilingual.services.cores.PartitionService;
import com.sdm.multilingual.utils.StringUtil;
import com.sdm.multilingual.utils.SystemUtil;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartitionServiceImpl implements PartitionService {

    @Autowired
    PartitionRepository partitionRepository;

    @Override
    public long count() {
        return partitionRepository.count();
    }

    @Override
    public Partition findBySequence(int sequence) {
        return partitionRepository.findBySequence(sequence);
    }

    @Override
    public Partition findBySequenceAndEnableFlag(int sequence, byte enableFlag) {
        return partitionRepository.findBySequenceAndEnableFlag(sequence, enableFlag);
    }

    @Override
    public Partition findBySequenceAndActiveFlagAndEnableFlag(int sequence, byte activeFlag, byte enableFlag) {
        return null;
    }

    @Override
    public List<Partition> findAllByDisplayName(String displayName) {
        return null;
    }

    @Override
    public List<Partition> findAllByDisplayNameAndEnableFlag(String displayName, byte enableFlag) {
        return partitionRepository.findAllByDisplayNameAndEnableFlag(displayName, enableFlag);
    }

    @Override
    public List<Partition> findAllByDisplayNameAndActiveFlagAndEnableFlag(String displayName, byte activeFlag, byte enableFlag) {
        return null;
    }

    @Override
    public List<Partition> findAllByServiceSequence(int serviceSequence) {
        return null;
    }

    @Override
    public List<Partition> findAllByServiceSequenceAndEnableFlag(int serviceSequence, byte enableFlag) {
        return partitionRepository.findAllByServiceSequenceAndEnableFlag(serviceSequence, enableFlag);
    }

    @Override
    public List<Partition> findAllByServiceSequenceAndActiveFlagAndEnableFlag(int serviceSequence, byte actvieFlag, byte enableFlag) {
        return null;
    }

    @Override
    public Page<Partition> findAllByPage(int offset, int limit) {
        return null;
    }

    @Override
    public void updateBySequence( int sequence, Partition fromPartition ) throws Exception {
        Partition toPartition = findBySequenceAndEnableFlag(sequence, EnableFlag.Y.getValue());
        if(toPartition == null)
            throw new NotFoundException(StringUtil.getExceptionMessage(this,"NOT_FOUNT"));

        SystemUtil.moveEntityToEntity(Partition.CANNOT_UPDATED_FIELDS, Partition.class, fromPartition, toPartition);
        partitionRepository.flush();
    }

    @Override
    public Partition save(Partition partition) {
        return partitionRepository.save(partition);
    }

    @Override
    public List<Partition> saveAll(List<Partition> list) {
        return partitionRepository.saveAll(list);
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
        Partition partition = findBySequenceAndEnableFlag(sequence, EnableFlag.Y.getValue());
        if(partition == null)
            throw new NotFoundException(StringUtil.getExceptionMessage(this,"NOT_FOUNT"));

        partition.setEnableFlag(EnableFlag.N.getValue());
        partitionRepository.flush();
    }

}
