/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.salaboy.wordpress.api.test.mock;

import com.wordpress.salaboy.api.HumanTaskQueryClientWrapper;
import com.worpdress.salaboy.api.TaskDefinition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author salaboy
 */
public class MockQueryClientAdapter {
    public static List<TaskDefinition> mockTasks = new ArrayList<TaskDefinition>(){{
                    add(new TaskDefinition(1,"First Task", "salaboy", "The first Mock Task", new Date(), new Date(), null, 10));
                    add(new TaskDefinition(2,"Second Task", "salaboy", "The second Mock Task", new Date(), new Date(), null, 15));
                }};
    
    public static HumanTaskQueryClientWrapper newQueryClient(){
        return new HumanTaskQueryClientWrapper() {
            // static block
            {
                initializeRenderer();
            }
            public List<TaskDefinition> getMyTaskAbstracts(String potentialOwner) {
                
                return MockQueryClientAdapter.mockTasks;
            }

            public TaskDefinition getMyTask(long taskId) {
                for(TaskDefinition task: mockTasks){
                    if(task.getId() == taskId ){
                        return task;
                    }
                    
                }
                return null;
            }
            private void initializeRenderer(){
                for(TaskDefinition task : MockQueryClientAdapter.mockTasks){
                    task.setRendererProvider(new MockRendererProvider(task));
                }
            }
        };
                
    }
}
