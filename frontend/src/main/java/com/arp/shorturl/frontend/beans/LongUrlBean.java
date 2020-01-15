/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arp.shorturl.frontend.beans;

import lombok.Data;

import javax.inject.Named;
import java.io.Serializable;

@Data
@Named
public class LongUrlBean implements Serializable {

    private String longURL;

}
