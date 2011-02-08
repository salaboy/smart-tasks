/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf;

import com.wordpress.salaboy.conf.HumanTaskClientConfiguration;

/**
 *
 * @author salaboy
 */
public class JBPM5HumanTaskClientConfiguration implements HumanTaskClientConfiguration{
    private String host;
    private int port;

    public JBPM5HumanTaskClientConfiguration(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getType() {
        return "jBPM5";
    }
    
    
}
