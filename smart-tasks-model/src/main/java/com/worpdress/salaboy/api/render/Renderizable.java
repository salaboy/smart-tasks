/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.worpdress.salaboy.api.render;

/**
 *
 * @author salaboy
 */
public interface Renderizable {
    public void render();
    public void setRendererProvider(RendererProvider provider);
    
    
}
