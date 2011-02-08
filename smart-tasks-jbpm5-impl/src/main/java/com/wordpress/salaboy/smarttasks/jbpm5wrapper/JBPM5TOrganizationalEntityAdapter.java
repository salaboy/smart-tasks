/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import com.wordpress.salaboy.api.TOrganizationalEntityAdapter;
import java.util.List;
import org.example.ws_ht.TGrouplist;
import org.example.ws_ht.TOrganizationalEntity;
import org.example.ws_ht.TUserlist;
import org.jbpm.task.Group;
import org.jbpm.task.OrganizationalEntity;
import org.jbpm.task.User;

/**
 *
 * @author esteban
 */
public class JBPM5TOrganizationalEntityAdapter implements TOrganizationalEntityAdapter<OrganizationalEntity> {

    public TOrganizationalEntity adapt(List<OrganizationalEntity> vendorOrganizationalEntities){
        TOrganizationalEntity tOrganizationalEntity = new TOrganizationalEntity();
        tOrganizationalEntity.setGroups(new TGrouplist());
        tOrganizationalEntity.setUsers(new TUserlist());
        for (OrganizationalEntity organizationalEntity : vendorOrganizationalEntities) {
            this.adaptSingleEntity(tOrganizationalEntity, organizationalEntity);
        }
        
        return tOrganizationalEntity;
    }
    
    private void adaptSingleEntity(TOrganizationalEntity organizationalEntity, OrganizationalEntity vendorOrganizationalEntity) {
        if ( vendorOrganizationalEntity instanceof Group){
            organizationalEntity.getGroups().getGroup().add(((Group)vendorOrganizationalEntity).getId());
            return;
        }
        if ( vendorOrganizationalEntity instanceof User){
            organizationalEntity.getUsers().getUser().add(((User)vendorOrganizationalEntity).getId());
            return;
        }
        throw new IllegalArgumentException("Impossible to add "+vendorOrganizationalEntity+" to TOrganizationalEntity");
        
    }

}
