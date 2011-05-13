package com.wordpress.salaboy.smarttasks.uihelper.configuration;

import com.wordpress.salaboy.smarttasks.activiti5wrapper.conf.ActivitiHumanTaskClientConfiguration;
import com.wordpress.salaboy.conf.HumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf.JBPM5HumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.mock.MockConfigurationHandler;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.mock.MockHumanTaskClientConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.Map;
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
        new BuilderConfigurationProvider(root).createConfiguration();
    }
    
    
    @Test
    public void testConfigurationParser() throws IOException{
        
        File root = new File(Thread.currentThread().getContextClassLoader().getResource(("UIHelperConfigurationProviderTest/configurationParser")).getFile());
        
        BuilderConfiguration configuration = new BuilderConfigurationProvider(root).createConfiguration();
        
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
    
    @Test
    public void testCustomHumanTaskOperationsConfigurationParser() throws IOException{
        
        File root = new File(Thread.currentThread().getContextClassLoader().getResource(("UIHelperConfigurationProviderTest/customHumanTaskOperationsTest")).getFile());
        BuilderConfigurationProvider uIHelperConfigurationProvider = new BuilderConfigurationProvider(root);
        uIHelperConfigurationProvider.addUIHelperConfigurationUriHandler(new MockConfigurationHandler());
        
        
        BuilderConfiguration configuration = uIHelperConfigurationProvider.createConfiguration();
        
        assertEquals(root, configuration.getUiHelperRootDirectory());

        assertNotNull(configuration.getHumanTaskServiceConfiguration());
        
        Map<String, HumanTaskClientConfiguration> humanTaskClientConfigurations = configuration.getHumanTaskServiceConfiguration().getHumanTaskClientConfigurations();
        assertNotNull(humanTaskClientConfigurations);
        assertEquals(1,humanTaskClientConfigurations.size());
        
        HumanTaskClientConfiguration mockConfiguration = humanTaskClientConfigurations.get(MockHumanTaskClientConfiguration.TYPE);
        assertNotNull(mockConfiguration);
        assertTrue(mockConfiguration instanceof MockHumanTaskClientConfiguration);
        assertEquals("value1", ((MockHumanTaskClientConfiguration)mockConfiguration).getAttr1());
        assertEquals("value2", ((MockHumanTaskClientConfiguration)mockConfiguration).getAttr2());
        
    }
    
}