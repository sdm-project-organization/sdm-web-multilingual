package com.sdm.multilingual.controllers;

import com.sdm.multilingual.models.tables.Group;
import com.sdm.multilingual.models.tables.Platform;
import com.sdm.multilingual.services.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
            @PathVariable long sequence) throws Exception {
        return groupService.findBySequence(sequence);
    }

    // MasterLevel - 이름 조회
    @RequestMapping(path = "/name/{name}", method=RequestMethod.GET)
    public List<Group> getGroupByDisplayName(
            @PathVariable String name) throws Exception {
        return groupService.findAllByDisplayName(name);
    }

    // BasicLevel - 서비스 ID + 이름 조회
    @RequestMapping(path = "/name/{name}", method=RequestMethod.GET)
    public List<Group> getGroupBySerivceSequenceAndDisplayName(
            @PathVariable String name) throws Exception {
        return null;
    }

    // BasicLevel - 서비스 ID + 그룹 Path + Depth
    @RequestMapping(path = "/name/{name}", method=RequestMethod.GET)
    public List<Group> getGroupBySerivceSequenceAndGroupSequenceAndDepth(
            @PathVariable String name) throws Exception {
        return null;
    }

    // AdminLevel - 그룹 저장
    @RequestMapping(method=RequestMethod.POST)
    public Group saveGroup(@PathVariable long sequence) throws Exception {
        return null;
    }

    // AdminLevel - 그룹 수정
    @RequestMapping(method=RequestMethod.PUT)
    public Group updateGroup(@PathVariable long sequence) throws Exception {
        return null;
    }


}
