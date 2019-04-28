package com.sdm.multilingual.controllers;

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

    // MasterLevel
    @RequestMapping(path="count", method = RequestMethod.GET)
    public long getTreeCount() {
        return treeService.count();
    }

    // MasterLevel
    @RequestMapping(path = "/sequence/{sequence}", method = RequestMethod.GET)
    public Tree getTreeBySequence(
            @PathVariable int sequence) throws Exception {
        return treeService.findBySequence(sequence);
    }

    // MasterLevel - 이름 조회
    @RequestMapping(path = "/name/{name}", method = RequestMethod.GET)
    public List<Tree> getTreeByDisplayName(
            @PathVariable String name) throws Exception {
        return treeService.findAllByDisplayName(name);
    }

    // BasicLevel - 서비스 ID + 이름 조회
    @RequestMapping(path = "/name/{name}/serviceid/{serviceSequence}", method = RequestMethod.GET)
    public List<Tree> getTreeBySerivceSequenceAndDisplayName(
            @PathVariable int serviceSequence,
            @PathVariable String name) throws Exception {
        return treeService.findAllByPartitionSequenceAndDisplayName(serviceSequence, name);
    }

    // BasicLevel - 서비스 ID + 그룹 Path
    @RequestMapping(path = "/path/{path}/serviceid/{serviceSequence}", method = RequestMethod.GET)
    public List<Tree> getTreeByPatitionSequenceAndTreePath(
            @PathVariable int serviceSequence,
            @PathVariable String path) throws Exception {
        return treeService.findAllByPartitionSequenceAndTreePath(serviceSequence, path);
    }

    // BasicLevel - 서비스 ID + TreeLevel
    @RequestMapping(path = "/level/{level}/serviceid/{serviceSequence}", method = RequestMethod.GET)
    public List<Tree> getTreeByPartitionSequenceAndTreeLevel (
            @PathVariable int serviceSequence,
            @PathVariable int level) throws Exception {
        return treeService.findAllByPartitionSequenceAndTreeLevel(serviceSequence, level);
    }

    // AdminLevel - 그룹 저장
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveGroup(
            @Validated @RequestBody TreeResource treeResource,
            UriComponentsBuilder uriBuilder) throws Exception {
        System.out.println(treeResource.toString()); // TODO LOG
        Tree tree = treeService.save(treeResource.toInsert().toEntity()); // TODO NO_ID
        System.out.println(tree.toString()); // TODO LOG

        URI resourceUri = MvcUriComponentsBuilder
                .relativeTo(uriBuilder)
                .withMethodCall(on(TreeController.class).getTreeBySequence(tree.getSequence()))
                .build().encode().toUri();
        return ResponseEntity.created(resourceUri).build();
    }

    // AdminLevel - 그룹 수정
    @RequestMapping(method = RequestMethod.PUT)
    public Tree updateGroup(@PathVariable int sequence) throws Exception {
        return null;
    }


}
