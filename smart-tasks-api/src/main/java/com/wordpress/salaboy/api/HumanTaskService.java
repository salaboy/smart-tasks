/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import java.util.Map;
import org.example.ws_ht.api.wsdl.TaskOperations;

/**
 *
 * @author salaboy
 */
public interface HumanTaskService extends AuthorizedTaskOperations {
    
    public Map<String, AuthorizedTaskOperations> getTaskOperations();
    
    
}
