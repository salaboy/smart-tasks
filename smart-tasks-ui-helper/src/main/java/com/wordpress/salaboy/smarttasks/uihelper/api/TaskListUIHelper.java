/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.api;

/**
 *
 * @author esteban
 */
public interface TaskListUIHelper {
    
    /**
     * Returns the task list column headers 
     */
    public String[] getColumnHeaders();
    
    /**
     * Return the data that should be used to populate the task list.
     * @param from the number of the first record to be returned
     * @param ammount the amount of records requested.
     * @return 
     */
    public String[][] getData(int from, int amount);
    
    /**
     * Returns the total number of records.
     * @return 
     */
    public int getDataCount();
    
    
}
