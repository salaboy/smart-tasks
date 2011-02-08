/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import com.wordpress.salaboy.api.TDeadlinesInfoAdapter;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.util.XMLDataTypeUtils;
import org.example.ws_ht.TDeadlineInfo;
import org.example.ws_ht.TDeadlinesInfo;
import org.jbpm.task.Deadline;
import org.jbpm.task.Deadlines;

/**
 *
 * @author esteban
 */
public class JBPM5TDeadlinesInfoAdapter implements TDeadlinesInfoAdapter<Deadlines>{

    public TDeadlinesInfo adapt(Deadlines vendorDeadlines){
        TDeadlinesInfo tDeadlinesInfo = new TDeadlinesInfo();
        
        for (Deadline deadline : vendorDeadlines.getStartDeadlines()) {
            tDeadlinesInfo.getStartBy().add(this.adapt(deadline));
        }
        
        for (Deadline deadline : vendorDeadlines.getEndDeadlines()) {
            tDeadlinesInfo.getCompleteBy().add(this.adapt(deadline));
        }
        
        return tDeadlinesInfo;
    }
    
    private TDeadlineInfo adapt(Deadline vendorDeadline){
        TDeadlineInfo tDeadlineInfo = new TDeadlineInfo();
        tDeadlineInfo.setName(String.valueOf(vendorDeadline.getId()));
        tDeadlineInfo.setDate(XMLDataTypeUtils.convertDateToGregorianCalendar(vendorDeadline.getDate()));
        
        return tDeadlineInfo;
    }

}
