/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

/**
 *
 * @author salaboy
 */
public interface ManagedService {
    public void initializeService();
    public void cleanUpService();
    public void setServiceLifeCycle(String name, ServiceLifeCycleManager serviceLifeCycle);
}
