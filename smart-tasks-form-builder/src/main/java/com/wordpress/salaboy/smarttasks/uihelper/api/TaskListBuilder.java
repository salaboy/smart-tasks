/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.api;

/**
 *
 * @author esteban
 */
public interface TaskListBuilder {
    
    /**
     * Returns the task list column headers 
     */
    public String[] getColumnHeaders();
    
    /**
     * Return a TaskListDataSet
     * @param from the number of the first record to be returned
     * @param ammount the amount of records requested.
     * @return 
     */
    public TaskListDataSet getDataSet(int from, int amount);
    
    /**
     * Returns the total number of records.
     * @return 
     */
    public int getDataCount();
    
    public String[] getRowMetadataKeys();
    
    
}
