/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.salaboy.wordpress.api.test.mock;

import com.worpdress.salaboy.api.TaskDefinition;
import com.worpdress.salaboy.api.render.RendererProvider;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salaboy
 */
public class MockRendererProvider implements RendererProvider{

    public static List< String> results = new ArrayList<String>();
    private TaskDefinition taskDefinition;

    public MockRendererProvider(TaskDefinition taskDefinition) {
        this.taskDefinition = taskDefinition;
    }
    
    public void render() {
        Method[] methods = this.taskDefinition.getClass().getDeclaredMethods();
        for(Method method: methods){
            if(method.getName().startsWith("get")){
                try {
                    results.add("Field: "+method.getName()+" = "+method.invoke(this.taskDefinition, null));
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(MockRendererProvider.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(MockRendererProvider.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(MockRendererProvider.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

}
