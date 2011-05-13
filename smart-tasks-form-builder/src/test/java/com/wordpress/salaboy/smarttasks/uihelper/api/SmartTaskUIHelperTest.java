/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.BuilderConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.BuilderConfigurationProvider;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.mock.MockConfigurationHandler;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.mock.MockHumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.mock.MockHumanTaskServiceOperations;

/**
 *
 * @author esteban
 */
public class SmartTaskUIHelperTest {

    public SmartTaskUIHelperTest() {
    }


    @Test
    public void testInitializeCleanUp(){
        final List<String> eventList = new ArrayList<String>();
        
        
        File root = new File(Thread.currentThread().getContextClassLoader().getResource(("SmartTaskUIHelperTest/testInitializeCleanUp")).getFile());
        BuilderConfigurationProvider uIHelperConfigurationProvider = new BuilderConfigurationProvider(root);
        uIHelperConfigurationProvider.addUIHelperConfigurationUriHandler(new MockConfigurationHandler(new MockHumanTaskClientConfiguration(){

            @Override
            public HumanTaskServiceOperations getServiceOperationsImplementation() {
                return new MockHumanTaskServiceOperations(){

                    @Override
                    public void initializeService() {
                        eventList.add("Service Initialized");
                    }

                    @Override
                    public void cleanUpService() {
                        eventList.add("Sevice Cleaned Up!");
                    }
                    
                };
            }
            
        }));
        BuilderConfiguration configuration = uIHelperConfigurationProvider.createConfiguration();

        
        SmartTaskBuilder helper = new SmartTaskBuilder(configuration);
        
        //Connection
        ConnectionData connectionData = new ConnectionData();
        connectionData.setEntityId("Some_User");
        helper.connect(connectionData);
        
        assertEquals(1, eventList.size());
        assertTrue(eventList.contains("Service Initialized"));
        eventList.clear();
        
        helper.disconnect();
        assertEquals(1, eventList.size());
        assertTrue(eventList.contains("Sevice Cleaned Up!"));
        
    }
    
}