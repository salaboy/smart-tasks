/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.client.console;

import org.sonatype.gshell.MainSupport;
import org.sonatype.gshell.branding.Branding;
import org.sonatype.gshell.branding.BrandingSupport;
import org.sonatype.gshell.event.EventManagerImpl;
import org.sonatype.gshell.execute.CommandExecutorImpl;
import org.sonatype.gshell.shell.Shell;
import org.sonatype.gshell.shell.ShellImpl;

/**
 *
 * @author salaboy
 */
public class MyApp extends MainSupport {

    private Branding branding = new BrandingSupport();
    public int exitCode;

    @Override
    protected Branding createBranding() {
        return branding;
    }

    @Override
    protected Shell createShell() throws Exception {
        return null;
      //  return new ShellImpl(new EventManagerImpl(), new CommandExecutorImpl(), branding, null, null);
    }

    @Override
    protected void exit(int code) {
        this.exitCode = code;
    }
}
