/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.conf;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;

/**
 *
 * @author salaboy
 */
public interface HumanTaskClientConfiguration {
    String getType();
    HumanTaskServiceOperations getServiceOperationsImplementation();
}
