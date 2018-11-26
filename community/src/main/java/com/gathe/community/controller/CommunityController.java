package com.gathe.community.controller;

import com.gathe.community.domain.Community;
import com.gathe.community.resource.CommunityRes;
import com.gathe.community.resource.CommunityShortRes;
import com.gathe.community.service.CommunityService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/communities")
public class CommunityController {

    private final CommunityService communityService;

    public CommunityController(final CommunityService communityService) {
        this.communityService = communityService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommunityRes getCommunity(@PathVariable Long id) {

        if (id == null) {}
        else {
            Community searched = communityService.find(id);
            CommunityShortRes resource = new CommunityShortRes(searched);
            return resource;
        }

        return null;
    }
}
