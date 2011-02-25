package com.wordpress.salaboy.smarttasks.client.console;

import org.junit.Test;
import org.sonatype.gshell.notification.ExitNotification;
import static org.junit.Assert.*;
/**
 * Unit test for simple App.
 */
public class AppTest 
  
{
    MyApp main = new MyApp();
    
    @Test
    public void test_h() throws Exception {
        main.boot("-h");
        assertEquals(ExitNotification.DEFAULT_CODE, main.exitCode);
    }
 
}
