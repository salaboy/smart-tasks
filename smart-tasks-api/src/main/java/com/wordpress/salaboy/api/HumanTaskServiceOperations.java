/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import org.example.ws_ht.api.wsdl.TaskOperations;

/**
 *
 * @author salaboy
 */
public interface HumanTaskServiceOperations extends TaskOperations, AuthorizedService, LocalizedService,  ManagedService {
}
