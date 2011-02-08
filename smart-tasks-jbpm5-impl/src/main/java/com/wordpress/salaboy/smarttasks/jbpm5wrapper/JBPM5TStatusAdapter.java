/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import com.wordpress.salaboy.api.TStatusAdapter;
import java.util.ArrayList;
import java.util.List;
import org.example.ws_ht.api.TStatus;
import org.jbpm.task.Status;

/**
 *
 * @author esteban
 */
public class JBPM5TStatusAdapter implements TStatusAdapter<Status> {

    public List<TStatus> adaptCollection(List<Status> vendorStatus) {
        List<TStatus> statusList = new ArrayList<TStatus>();
        for (Status status : vendorStatus) {
            statusList.add(this.adapt(status));
        }
        return statusList;
    }

    public TStatus adapt(Status vendorStatus) {
        switch (vendorStatus){
            case Completed:
                return TStatus.COMPLETED;
            case Created:
                return TStatus.CREATED;
            case Error:
                return TStatus.ERROR;
            case Exited:
                return TStatus.EXITED;
            case Failed:
                return TStatus.FAILED;
            case InProgress:
                return TStatus.IN_PROGRESS;
            case Obsolete:
                return TStatus.OBSOLETE;
            case Ready:
                return TStatus.READY;
            case Reserved:
                return TStatus.RESERVED;
            case Suspended:
                return TStatus.SUSPENDED;
            default:
                throw new IllegalArgumentException("Unable to convert from "+vendorStatus+" to TStatus");
        }
    }

}
