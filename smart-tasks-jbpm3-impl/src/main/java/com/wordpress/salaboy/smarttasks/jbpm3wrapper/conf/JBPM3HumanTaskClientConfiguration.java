/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.jbpm3wrapper.conf;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.conf.HumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.jbpm3wrapper.JBPM3HumanTaskServiceOperations;

/**
 *
 * @author salaboy
 */
public class JBPM3HumanTaskClientConfiguration implements HumanTaskClientConfiguration{
    public final static String TYPE = "jBPM3";
    private String jbpmConfigFile = "jbpm.cfg.xml";
    private JbpmContext ctx;

    public JBPM3HumanTaskClientConfiguration(String hibernateCfg) {
    	this.jbpmConfigFile = hibernateCfg;
    }
    
    public JBPM3HumanTaskClientConfiguration() {
	}
    
    public JBPM3HumanTaskClientConfiguration(JbpmContext ctx) {
    	this.ctx = ctx;
	}
    
    public String getType() {
        return TYPE;
    }

    public HumanTaskServiceOperations getServiceOperationsImplementation() {
    	if (ctx != null) {
    		return new JBPM3HumanTaskServiceOperations(ctx);
    	}
    	JbpmConfiguration config = JbpmConfiguration
		.parseInputStream(JBPM3HumanTaskClientConfiguration.class.getClassLoader()
				.getResourceAsStream(jbpmConfigFile));
    	return new JBPM3HumanTaskServiceOperations(config.createJbpmContext());
    }

    
}
