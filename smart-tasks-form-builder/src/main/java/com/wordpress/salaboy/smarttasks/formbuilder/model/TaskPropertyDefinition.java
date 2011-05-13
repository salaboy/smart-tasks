/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.formbuilder.model;

import com.wordpress.salaboy.smarttasks.formbuilder.impl.Formatter;

/**
 * The definition of a Task property.
 * @author esteban
 */
public class TaskPropertyDefinition {
   private String name;
   private String sourceExpresion;
   private Formatter formatter;

    public Formatter getFormatter() {
        return formatter;
    }

    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceExpresion() {
        return sourceExpresion;
    }

    public void setSourceExpresion(String sourceExpresion) {
        this.sourceExpresion = sourceExpresion;
    }

}
