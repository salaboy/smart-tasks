/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf;

import java.util.Properties;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.conf.HumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.JBPM5HumanTaskServiceOperations;

/**
 *
 * @author salaboy
 */
public class JBPM5HumanTaskClientConfiguration implements HumanTaskClientConfiguration{
    public final static String TYPE = "jBPM5";
    
    private String host;
    private int port;
    private Properties extraInfo;

    public JBPM5HumanTaskClientConfiguration(String host, int port) {
    	this(host, port, new Properties());
    }
    
    public JBPM5HumanTaskClientConfiguration(String host, int port, Properties extraInfo) {
        this.host = host;
        this.port = port;
        this.extraInfo = extraInfo;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public Properties getExtraInfo() {
		return extraInfo;
	}
    
    public String getType() {
        return TYPE;
    }

    public HumanTaskServiceOperations getServiceOperationsImplementation() {
        return new JBPM5HumanTaskServiceOperations(this);
    }
    
    
}
