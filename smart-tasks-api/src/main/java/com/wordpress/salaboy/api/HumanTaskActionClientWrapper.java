/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

/**
 *
 * @author salaboy
 * This interface is based on the WS-HT standard defined by the oasis group
 */
public interface HumanTaskActionClientWrapper {
    public void claim(Long taskId);
    public void start(Long taskId);
    public void stop(Long taskId);
    public void release(Long taskId);
    public void resume(Long taskId);
    public void complete(Long taskId, OutputData data);
}
