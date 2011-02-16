package com.wordpress.salaboy.smarttasks.uihelper.configuration;

import com.wordpress.salaboy.smarttasks.activiti5wrapper.conf.ActivitiHumanTaskClientConfiguration;
import com.wordpress.salaboy.conf.HumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf.JBPM5HumanTaskClientConfiguration;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import static org.junit.Assert.*;

/**
 *
 * @author esteban
 */
public class UIHelperConfigurationProviderTest {

    public UIHelperConfigurationProviderTest() {
    }

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNoConfigFile() throws IOException{
        File root = tempFolder.newFolder("emptyFolder");
        UIHelperConfigurationProvider.createConfiguration(root);
    }
    
    
    @Test
    public void testConfigurationParser() throws IOException{
        File root = tempFolder.newFolder("testConnectionConfig");

        File destConfigurationFile = new File(root,UIHelperConfigurationProvider.UI_HELPER_FILE_NAME);
        
        FileOutputStream destination = new FileOutputStream(destConfigurationFile); 
        InputStream source = Thread.currentThread().getContextClassLoader().getResourceAsStream("smartTaskUIHelperTest/UIHelper.config.xml");
        
        IOUtils.copy(source, destination);
        
        source.close();
        destination.close();
        
        UIHelperConfiguration configuration = UIHelperConfigurationProvider.createConfiguration(root);
        
        assertEquals(root, configuration.getUiHelperRootDirectory());

        assertNotNull(configuration.getHumanTaskServiceConfiguration());
        
        Map<String, HumanTaskClientConfiguration> humanTaskClientConfigurations = configuration.getHumanTaskServiceConfiguration().getHumanTaskClientConfigurations();
        assertNotNull(humanTaskClientConfigurations);
        assertEquals(2,humanTaskClientConfigurations.size());
        
        HumanTaskClientConfiguration jbpm5Configuration = humanTaskClientConfigurations.get("JBPM5");
        assertNotNull(jbpm5Configuration);
        assertTrue(jbpm5Configuration instanceof JBPM5HumanTaskClientConfiguration);
        assertEquals("http://localhost/some/url", ((JBPM5HumanTaskClientConfiguration)jbpm5Configuration).getHost());
        assertEquals(8123, ((JBPM5HumanTaskClientConfiguration)jbpm5Configuration).getPort());
        
        HumanTaskClientConfiguration activitiConfiguration = humanTaskClientConfigurations.get("Activiti");
        assertNotNull(activitiConfiguration);
        assertTrue(activitiConfiguration instanceof ActivitiHumanTaskClientConfiguration);
        assertEquals("/some/configuration/resource", ((ActivitiHumanTaskClientConfiguration)activitiConfiguration).getConfigurationResource());
        
    }
    
}