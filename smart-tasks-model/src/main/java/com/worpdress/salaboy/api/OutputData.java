/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.worpdress.salaboy.api;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author salaboy
 */
public class OutputData {
    private Map<String, Object> data = new HashMap<String, Object>();

    public OutputData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getData() {
        return data;
    }

    
    
    
    
}
