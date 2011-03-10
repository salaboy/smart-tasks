/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.salaboy.wordpress.api.test;

import org.example.ws_ht.api.TTaskAbstract;
import org.example.ws_ht.api.wsdl.IllegalArgumentFault;
import org.example.ws_ht.api.wsdl.IllegalStateFault;
import org.example.ws_ht.api.wsdl.TaskOperations;
import com.salaboy.wordpress.api.test.mock.MockQueryClientAdapter;
import com.wordpress.salaboy.api.HumanTaskClientRegistry;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author salaboy
 */
public class SimpleAPITest {

    private TaskOperations queryClient;
    
    public SimpleAPITest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        queryClient = MockQueryClientAdapter.newQueryClient();
        
        HumanTaskClientRegistry.getInstance().addQueryClient("mockQuery", queryClient);
    }

    @After
    public void tearDown() {
    }

  
    @Test
    public void renderTaskDefinitionTest() throws IllegalArgumentFault, IllegalStateFault {
        
        List<TTaskAbstract> tasks = queryClient.getMyTaskAbstracts("","salaboy","",null,"","","",0,0);
//        
//        for(TaskDefinition task : tasks){
//            task.render();
//        }
        
        assertEquals(2, tasks.size());
       // assertEquals(16, MockRendererProvider.results.size()); // 8 fields per taskDefinition
        
    }
    
//    @Test
//    public void getAndRenderTaskDefinitionTest(){
//        TaskDefinition task = queryClient.getMyTask(2);
//        task.render();
//        assertEquals(8, MockRendererProvider.results.size()); // 8 fields per taskDefinition
//    }
    
//    @Test
//    public void clientRegistryTest(){
//        List<TaskDefinition> tasks = HumanTaskClientRegistry.getInstance().getQueryClient("mockQuery").getMyTaskAbstracts("salaboy");
//        for(TaskDefinition task : tasks){
//            task.render();
//        }
//        
//    }

}