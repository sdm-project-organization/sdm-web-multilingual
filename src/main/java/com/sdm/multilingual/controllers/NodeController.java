package com.sdm.multilingual.controllers;

import com.sdm.multilingual.constants.EnableFlag;
import com.sdm.multilingual.models.resources.NodeResource;
import com.sdm.multilingual.models.resources.PartitionResource;
import com.sdm.multilingual.models.tables.Node;
import com.sdm.multilingual.models.tables.Partition;
import com.sdm.multilingual.services.NodeServiceImpl;
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
@RequestMapping("api/nodes")
public class NodeController {

    @Autowired
    NodeServiceImpl nodeService;

    @RequestMapping(path = "/sequence/{sequence}", method = RequestMethod.GET)
    public Node getNodeBySequence(@PathVariable int sequence ) throws Exception {
        return nodeService.findBySequenceAndEnableFlag( sequence, EnableFlag.Y.getValue() );
    }

    @RequestMapping(path = "/name/{name}", method = RequestMethod.GET)
    public List<Node> getNodeByDisplayName(@PathVariable String name ) throws Exception {
        return nodeService.findAllByDisplayNameAndEnableFlag( name, EnableFlag.Y.getValue() );
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveGroup(
            @Validated @RequestBody NodeResource nodeResource,
            UriComponentsBuilder uriBuilder) throws Exception {
        Node node = nodeService.save(nodeResource.toInsert().toEntity());

        URI resourceUri = MvcUriComponentsBuilder
                .relativeTo(uriBuilder)
                .withMethodCall(on(NodeController.class).getNodeBySequence(node.getSequence()))
                .build().encode().toUri();
        return ResponseEntity.created(resourceUri).build();
    }

    @RequestMapping(path = "/sequence/{sequence}", method = RequestMethod.PUT)
    public void updateGroupBySequence(
            @PathVariable int sequence,
            @Validated @RequestBody NodeResource nodeResource) throws Exception {
        nodeService.updateBySequence(sequence, nodeResource.toUpdate().toEntity());
    }

    @RequestMapping(path = "/sequence/{sequence}", method = RequestMethod.DELETE)
    public void deleteGroupBySequence(
            @PathVariable int sequence) throws Exception {
        nodeService.unenable(sequence);
    }

}
