/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.api;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperConfigurationProvider;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.mock.MockConfigurationHandler;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.mock.MockHumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.mock.MockHumanTaskServiceOperations;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

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
        UIHelperConfigurationProvider uIHelperConfigurationProvider = new UIHelperConfigurationProvider(root);
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
        UIHelperConfiguration configuration = uIHelperConfigurationProvider.createConfiguration();

        
        SmartTaskUIHelper helper = new SmartTaskUIHelper(configuration);
        
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