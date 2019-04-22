package com.sdm.multilingual.controllers;

import com.sdm.multilingual.models.tables.Platform;
import com.sdm.multilingual.services.PlatformServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/platforms")
public class PlatformController {

    @Autowired
    PlatformServiceImpl platformService;


    @RequestMapping(path = "/sequence/{sequence}", method = RequestMethod.GET)
    public Platform getPlatformBySequence(
            @PathVariable short sequence) throws Exception {
        return (Platform) platformService.findBySequence(sequence);
    }


    @RequestMapping(path = "/name/{name}", method = RequestMethod.GET)
    public Platform getPlatformBySequence(
            @PathVariable String name) {
        return (Platform) platformService.findByDisplayName(name);
    }

    /*@RequestMapping(method = RequestMethod.POST)
    public Platform savePlatform(@Validated @RequestBody Platform dictPlatformTable) {
        dictPlatformService.save(dictPlatformTable);

        URI resourceUri = uriBuilder // == RES URI ==
                .path("/api/platform/sequence/{sequence}")
                .buildAndExpand(dictPlatformTable.getPlatformSequence())
                .encode()
                .toUri();

        return ResponseEntity.created(URI.create(resourceUri)).build();;
    }*/

}
