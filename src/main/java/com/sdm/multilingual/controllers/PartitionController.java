package com.sdm.multilingual.controllers;

import com.sdm.multilingual.constants.EnableFlag;
import com.sdm.multilingual.models.resources.PartitionResource;
import com.sdm.multilingual.models.tables.Partition;
import com.sdm.multilingual.services.PartitionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

@RestController
@RequestMapping("api/partitions")
public class PartitionController {

    @Autowired
    PartitionServiceImpl partitionService;

    @RequestMapping(path = "/sequence/{sequence}", method = RequestMethod.GET)
    public Partition getPartitionBySequence( @PathVariable int sequence ) throws Exception {
        return partitionService.findBySequenceAndEnableFlag( sequence, EnableFlag.Y.getValue() );
    }

    @RequestMapping(path = "/name/{name}", method = RequestMethod.GET)
    public List<Partition> getPartitionByDisplayName( @PathVariable String name ) throws Exception {
        return partitionService.findAllByDisplayNameAndEnableFlag( name, EnableFlag.Y.getValue() );
    }

    @RequestMapping(path = "/serviceid/{sequence}", method = RequestMethod.GET)
    public List<Partition> getPartitionByServiceSequence( @PathVariable int sequence ) throws Exception {
        return partitionService.findAllByServiceSequenceAndEnableFlag( sequence, EnableFlag.Y.getValue() );
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveGroup(
            @Validated @RequestBody PartitionResource partitionResource,
            UriComponentsBuilder uriBuilder) throws Exception {
        Partition partition = partitionService.save(partitionResource.toInsert().toEntity());

        URI resourceUri = MvcUriComponentsBuilder
                .relativeTo(uriBuilder)
                .withMethodCall(on(TreeController.class).getTreeBySequence(partition.getSequence()))
                .build().encode().toUri();
        return ResponseEntity.created(resourceUri).build();
    }

    @RequestMapping(path = "/sequence/{sequence}", method = RequestMethod.PUT)
    public void updateGroupBySequence(
            @PathVariable int sequence,
            @Validated @RequestBody PartitionResource partitionResource) throws Exception {
        System.out.println(sequence);
        partitionService.updateBySequence(sequence, partitionResource.toUpdate().toEntity());
    }

    @RequestMapping(path = "/sequence/{sequence}", method = RequestMethod.DELETE)
    public void deleteGroupBySequence(
            @PathVariable int sequence) throws Exception {
        partitionService.unenable(sequence);
    }

}
