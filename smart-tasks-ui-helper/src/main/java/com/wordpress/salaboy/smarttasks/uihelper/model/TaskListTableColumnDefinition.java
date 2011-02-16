/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.model;

import com.wordpress.salaboy.smarttasks.uihelper.impl.Formatter;

/**
 * The definition of a TaskList table column.
 * @author esteban
 */
public class TaskListTableColumnDefinition {
   private String header;
   private String sourceExpresion;
   private Formatter formatter;

    public Formatter getFormatter() {
        return formatter;
    }

    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSourceExpresion() {
        return sourceExpresion;
    }

    public void setSourceExpresion(String sourceExpresion) {
        this.sourceExpresion = sourceExpresion;
    }
   
}
