/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import java.util.List;
import org.example.ws_ht.api.TStatus;

/**
 *
 * @author esteban
 */
public interface TStatusAdapter<T> {
    public List<TStatus> adaptCollection(List<T> vendorStatus);
    public TStatus adapt(T vendorStatus);
}
