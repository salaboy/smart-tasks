/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import com.wordpress.salaboy.api.render.Renderizable;
import com.wordpress.salaboy.api.render.RendererProvider;
import java.util.Date;

/**
 *
 * @author salaboy
 */
public class TaskDefinition implements Renderizable{
    private long id;
    private String name;
    private String actorId;
    private String description;
    private Date creationDate;
    private Date startDate;
    private Date dueDate;
    private int priority;
    private RendererProvider renderer;
    public TaskDefinition(long id, String name, String actorId, String description, Date creationDate, Date startDate, Date dueDate, int priority) {
        this.id = id;
        this.name = name;
        this.actorId = actorId;
        this.description = description;
        this.creationDate = creationDate;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getActorId() {
        return actorId;
    }
    
    
    public void render() {
        this.renderer.render();
    }

    public void setRendererProvider(RendererProvider rendererProvider) {
        this.renderer =  rendererProvider;
    }
    
    
    
    
}
