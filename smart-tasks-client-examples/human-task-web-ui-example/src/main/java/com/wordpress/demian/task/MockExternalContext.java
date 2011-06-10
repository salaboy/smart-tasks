package com.wordpress.demian.task;

import java.util.HashMap;
import java.util.Map;


public class MockExternalContext{

    public Map<String, String> getDictionary() {
        Map<String, String> mockMap = new HashMap<String, String>();
        mockMap.put("Example", "Ejemplo");
        return mockMap;
    }
    
    public Map<String, String> getDictionaryForTask(String taskId) {
        
        //only to test parameters are working fine.
        if (taskId.endsWith("1") || taskId.endsWith("2") || taskId.endsWith("3")) {
            Map<String, String> mockMap = new HashMap<String, String>();
            mockMap.put("example", "ejemplo");
            return mockMap;
        }
        Map<String, String> mockMap = new HashMap<String, String>();
        mockMap.put("another example", "otro ejemplo");
        return mockMap;
    }
    
}
