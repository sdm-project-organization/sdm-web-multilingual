package com.sdm.multilingual.controllers;

import com.sdm.multilingual.models.tables.DictPlatformTable;
import com.sdm.multilingual.services.DictPlatformServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/platform")
public class PlatformController {

    @Autowired
    DictPlatformServiceImpl dictPlatformService;


    @RequestMapping(path = "/sequence/{sequence}", method = RequestMethod.GET)
    public DictPlatformTable getPlatformBySequence(
            @PathVariable short sequence) throws Exception {
        return (DictPlatformTable) dictPlatformService.findBySequence(sequence);
    }


    @RequestMapping(path = "/name/{name}", method = RequestMethod.GET)
    public DictPlatformTable getPlatformBySequence(
            @PathVariable String name) {
        return (DictPlatformTable) dictPlatformService.findByDisplayName(name);
    }

    /*@RequestMapping(method = RequestMethod.POST)
    public DictPlatformTable savePlatform(
            @Validated @RequestBody DictPlatformTable dictPlatformTable) {
        dictPlatformService.save(dictPlatformTable);

        URI resourceUri = uriBuilder // == RES URI ==
                .path("/api/platform/sequence/{sequence}")
                .buildAndExpand(dictPlatformTable.getPlatformSequence())
                .encode()
                .toUri();

        return dictPlatformTable;
    }*/

}
