package com.sdm.multilingual.controllers;

import com.sdm.multilingual.models.resources.GroupResource;
import com.sdm.multilingual.models.tables.Group;
import com.sdm.multilingual.services.GroupServiceImpl;
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
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    GroupServiceImpl groupService;

    // MasterLevel
    @RequestMapping(path="count", method=RequestMethod.GET)
    public long getGroupCount() {
        return groupService.count();
    }

    // MasterLevel
    @RequestMapping(path = "/sequence/{sequence}", method=RequestMethod.GET)
    public Group getGroupBySequence(
            @PathVariable int sequence) throws Exception {
        return groupService.findBySequence(sequence);
    }

    // MasterLevel - 이름 조회
    @RequestMapping(path = "/name/{name}", method=RequestMethod.GET)
    public List<Group> getGroupByDisplayName(
            @PathVariable String name) throws Exception {
        return groupService.findAllByDisplayName(name);
    }

    // BasicLevel - 서비스 ID + 이름 조회
    @RequestMapping(path = "/name/{name}/serviceid/{serviceSequence}", method=RequestMethod.GET)
    public List<Group> getGroupBySerivceSequenceAndDisplayName(
            @PathVariable int serviceSequence,
            @PathVariable String name) throws Exception {
        return groupService.findAllByServiceSequenceAndDisplayName(serviceSequence, name);
    }

    // BasicLevel - 서비스 ID + 그룹 Path
    @RequestMapping(path = "/path/{path}/serviceid/{serviceSequence}", method=RequestMethod.GET)
    public List<Group> getGroupBySerivceSequenceAndGroupSequence(
            @PathVariable int serviceSequence,
            @PathVariable String path) throws Exception {
        return groupService.findAllByServiceSequenceAndGroupPath(serviceSequence, path);
    }

    // BasicLevel - 서비스 ID + Depth
    @RequestMapping(path = "/depth/{depth}/serviceid/{serviceSequence}", method=RequestMethod.GET)
    public List<Group> getGroupBySerivceSequenceAndGroupSequence(
            @PathVariable int serviceSequence,
            @PathVariable int depth) throws Exception {
        return groupService.findAllByServiceSequenceAndDepth(serviceSequence, depth);
    }

    // AdminLevel - 그룹 저장
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> saveGroup(
            @Validated @RequestBody GroupResource groupResource,
            UriComponentsBuilder uriBuilder) throws Exception {
        System.out.println(groupResource.toString()); // TODO LOG
        Group group = groupService.save(groupResource.toInsert().toEntity()); // TODO NO_ID
        System.out.println(group.toString()); // TODO LOG

        URI resourceUri = MvcUriComponentsBuilder
                .relativeTo(uriBuilder)
                .withMethodCall(on(GroupController.class).getGroupBySequence(group.getGroupSequence()))
                .build().encode().toUri();
        return ResponseEntity.created(resourceUri).build();
    }

    // AdminLevel - 그룹 수정
    @RequestMapping(method=RequestMethod.PUT)
    public Group updateGroup(@PathVariable int sequence) throws Exception {
        return null;
    }


}
