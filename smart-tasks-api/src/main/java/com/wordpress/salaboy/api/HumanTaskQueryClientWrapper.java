/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import com.worpdress.salaboy.api.TaskDefinition;
import java.util.List;

/**
 *
 * @author salaboy
 */
public interface HumanTaskQueryClientWrapper {
    public List<TaskDefinition> getMyTaskAbstracts(String potentialOwner);
    public TaskDefinition getMyTask(long taskId);
}
