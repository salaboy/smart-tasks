/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import org.example.ws_ht.TDeadlinesInfo;

/**
 *
 * @author esteban
 */
public interface TDeadlinesInfoAdapter<T> {
    public TDeadlinesInfo adapt(T vendorDeadlines);
}
