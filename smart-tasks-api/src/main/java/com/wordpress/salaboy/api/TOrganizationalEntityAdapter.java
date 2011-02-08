/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import java.util.List;
import org.example.ws_ht.TOrganizationalEntity;

/**
 *
 * @author esteban
 */
public interface TOrganizationalEntityAdapter<T> {
    public TOrganizationalEntity adapt(List<T> vendorOrganizationalEntities);
}
