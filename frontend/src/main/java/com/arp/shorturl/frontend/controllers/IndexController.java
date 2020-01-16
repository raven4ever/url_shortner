/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arp.shorturl.frontend.controllers;

import com.arp.shorturl.frontend.beans.LongUrlBean;
import com.arp.shorturl.frontend.rest.RestClientService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
@Slf4j
@Getter
public class IndexController implements Serializable {

    @Autowired
    private RestClientService restClientService;
    @Autowired
    private LongUrlBean longUrlBean;
    private boolean showResult = false;

    public void addNewMapping() {
        String resp = restClientService.getNewMappingFor(longUrlBean.getLongURL());

        longUrlBean.setShortUrlResponse("Your short URL is: " + resp);

        showResult = true;

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfully created the mapping!", resp));
    }
}
