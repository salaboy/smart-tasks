/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.formbuilder.api;

/**
 * Interface that represents a set of TTaskAbstracts
 * @author esteban
 */
public interface TaskListDataSet {
    
    String[][] getData();
    String[][] getRowsMetaData();

}
