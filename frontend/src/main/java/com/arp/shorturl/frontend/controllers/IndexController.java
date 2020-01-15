/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arp.shorturl.frontend.controllers;

import com.arp.shorturl.frontend.beans.LongUrlBean;
import com.arp.shorturl.frontend.rest.RestClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
@Slf4j
public class IndexController {

    @Autowired
    private RestClientService restClientService;
    @Autowired
    private LongUrlBean longUrlBean;

    public void addNewMapping() {
        log.info("gigel");
        restClientService.getNewMappingFor(longUrlBean.getLongURL());
    }
}
