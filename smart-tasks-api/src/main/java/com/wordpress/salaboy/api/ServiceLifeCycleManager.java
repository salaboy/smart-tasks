/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

/**
 *
 * @author salaboy
 * This interface will represent the set of actions that can be executed against a service
 * The main idea is to handle the lifecycle of a client from a HumanTaskServer. being able to 
 * connect, disconnect the client when is needed.
 * More complex lifecycles can be created extending this interface.
 */
public interface ServiceLifeCycleManager {
    public void start();
    public void stop();

}
