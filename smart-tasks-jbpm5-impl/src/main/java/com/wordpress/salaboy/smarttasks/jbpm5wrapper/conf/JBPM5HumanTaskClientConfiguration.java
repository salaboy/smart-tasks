/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf;

import java.util.Properties;

import org.jbpm.task.service.TaskClientConnector;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.conf.HumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.JBPM5HumanTaskServiceOperations;

/**
 *
 * @author salaboy
 */
public abstract class JBPM5HumanTaskClientConfiguration implements HumanTaskClientConfiguration{
    public final static String TYPE = "jBPM5";
    
    public final static long DEFAULT_TIMEOUT = 5000; 
    
    private String host;
    private int port;
    private long timeout = DEFAULT_TIMEOUT;
    private Properties extraInfo;

    public JBPM5HumanTaskClientConfiguration(String host, int port) {
    	this(host, port, new Properties());
    }
    
    public JBPM5HumanTaskClientConfiguration(String host, int port, Properties extraInfo) {
        this.host = host;
        this.port = port;
        this.extraInfo = extraInfo;
        this.timeout = extraInfo == null ? DEFAULT_TIMEOUT : Long.valueOf(extraInfo.getProperty("timeout", String.valueOf(DEFAULT_TIMEOUT)));
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
    
    public long getTimeout() {
		return timeout;
	}
    
    public String getType() {
        return TYPE;
    }

    public HumanTaskServiceOperations getServiceOperationsImplementation() {
        return new JBPM5HumanTaskServiceOperations(this);
    }

    public abstract TaskClientConnector createConnector();
    
}
