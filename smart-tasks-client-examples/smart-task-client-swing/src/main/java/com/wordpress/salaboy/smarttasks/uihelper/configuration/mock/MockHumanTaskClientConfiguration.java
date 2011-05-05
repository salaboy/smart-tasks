/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.configuration.mock;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.conf.HumanTaskClientConfiguration;

/**
 *
 * @author esteban
 */
public class MockHumanTaskClientConfiguration implements HumanTaskClientConfiguration {
    public final static String TYPE = "MOCK";
    private String attr1;
    private String attr2;
    
    
    public String getType() {
        return MockHumanTaskClientConfiguration.TYPE;
    }

    
    public HumanTaskServiceOperations getServiceOperationsImplementation() {
        return new MockHumanTaskServiceOperations();
    }

    public String getAttr1() {
        return this.attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return this.attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }
    
}
