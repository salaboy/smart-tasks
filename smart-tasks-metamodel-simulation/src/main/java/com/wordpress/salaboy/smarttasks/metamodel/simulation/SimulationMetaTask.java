/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.metamodel.simulation;

import com.wordpress.salaboy.smarttasks.metamodel.MetaTask;
import org.example.ws_ht.api.TTask;

/**
 *
 * @author salaboy
 */
public class SimulationMetaTask extends MetaTask {
   private double effort;
   private int estimatedTime;
   private String measure;

    public SimulationMetaTask(TTask task) {
        super(task);
    }

    public double getEffort() {
        return effort;
    }

    public void setEffort(double effort) {
        this.effort = effort;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
   
   
    
}
