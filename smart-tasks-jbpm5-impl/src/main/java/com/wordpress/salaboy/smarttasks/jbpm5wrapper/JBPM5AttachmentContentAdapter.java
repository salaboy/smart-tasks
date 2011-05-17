package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jbpm.task.Content;

import com.wordpress.salaboy.api.TAttachmentAdapter;

public class JBPM5AttachmentContentAdapter implements
		TAttachmentAdapter<String[], Content> {
	public String[] adapt(Content content) {
		ByteArrayInputStream bais = new ByteArrayInputStream(
				content.getContent());
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(bais);
			String taskinfo = (String) ois.readObject();
			return taskinfo.split(",");
		} catch (IOException e) {
			Logger.getLogger(JBPM5HumanTaskServiceOperations.class.getName())
					.log(Level.SEVERE, "There was an exception.", e);
		} catch (ClassNotFoundException e) {
			Logger.getLogger(JBPM5HumanTaskServiceOperations.class.getName())
					.log(Level.SEVERE, "There was an exception.", e);
		}
		return null;
	};
}
