package com.np.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;


/**
 * @goal log
 */
public class NotificationPlugin extends AbstractMojo {
	public void execute() throws MojoExecutionException, MojoFailureException {
		super.getLog().info("this is notification maven plugin");
	}
}
