/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import org.example.ws_ht.TOrganizationalEntity;

/**
 *
 * @author salaboy
 */
public interface AuthorizedService {
    public void setAuthorizedOrganizationalEntity(TOrganizationalEntity entity);
    public TOrganizationalEntity getAuthorizedOrganizationalEntity();
}
