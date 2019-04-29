package com.sdm.multilingual.controllers;

import com.sdm.multilingual.constants.EnableFlag;
import com.sdm.multilingual.models.resources.PartitionResource;
import com.sdm.multilingual.models.resources.TreeResource;
import com.sdm.multilingual.models.tables.Tree;
import com.sdm.multilingual.services.TreeServiceImpl;
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
@RequestMapping("/api/trees")
public class TreeController {

    @Autowired
    TreeServiceImpl treeService;

    @RequestMapping(path="count", method = RequestMethod.GET)
    public long getTreeCount() {
        return treeService.count();
    }

    @RequestMapping(path = "/sequence/{sequence}", method = RequestMethod.GET)
    public Tree getTreeBySequence( @PathVariable int sequence ) throws Exception {
        return treeService.findBySequenceAndEnableFlag( sequence, EnableFlag.Y.getValue() );
    }

    @RequestMapping(path = "/name/{name}", method = RequestMethod.GET)
    public List<Tree> getTreeByDisplayName(
            @PathVariable String name) throws Exception {
        return treeService.findAllByDisplayNameAndEnableFlag( name, EnableFlag.Y.getValue() );
    }

    @RequestMapping(path = "/partitionid/{partitionid}/name/{name}", method = RequestMethod.GET)
    public List<Tree> getTreeBySerivceSequenceAndDisplayName(
            @PathVariable int partitionid,
            @PathVariable String name) throws Exception {
        return treeService.findAllByPartitionSequenceAndDisplayNameAndEnableFlag( partitionid, name, EnableFlag.Y.getValue() );
    }

    @RequestMapping(path = "/partitionid/{partitionid}/path/{path}", method = RequestMethod.GET)
    public List<Tree> getTreeByPatitionSequenceAndTreePath(
            @PathVariable int partitionid,
            @PathVariable String path) throws Exception {
        // TODO 동등(eq), 이상(gt), 이하(lt) 로직추가예정
        return treeService.findAllByPartitionSequenceAndLessThanTreePathAndEnableFlag( partitionid, path, EnableFlag.Y.getValue() );
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveTree(
            @Validated @RequestBody TreeResource treeResource,
            UriComponentsBuilder uriBuilder) throws Exception {
        Tree tree = treeService.save(treeResource.toInsert().toEntity());

        URI resourceUri = MvcUriComponentsBuilder
                .relativeTo(uriBuilder)
                .withMethodCall(on(TreeController.class).getTreeBySequence(tree.getSequence()))
                .build().encode().toUri();
        return ResponseEntity.created(resourceUri).build();
    }

    @RequestMapping(path = "/sequence/{sequence}", method = RequestMethod.PUT)
    public void updateTree(
            @PathVariable int sequence,
            @Validated @RequestBody TreeResource treeResource) throws Exception {
        treeService.updateBySequence(sequence, treeResource.toUpdate().toEntity());
    }

    @RequestMapping(path = "/sequence/{sequence}", method = RequestMethod.DELETE)
    public void deleteTree(@PathVariable int sequence) throws Exception {
        treeService.unenable(sequence);
    }

}
