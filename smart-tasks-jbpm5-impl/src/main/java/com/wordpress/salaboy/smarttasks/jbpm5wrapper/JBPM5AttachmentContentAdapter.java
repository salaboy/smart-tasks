package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jbpm.task.Content;

import com.wordpress.salaboy.api.TAttachmentAdapter;

public class JBPM5AttachmentContentAdapter implements
		TAttachmentAdapter<Map<String, Object>, Content> {
	
	/**
	 * This will be used as default key for the getAttachment method map return,
	 * it does not come a map from jbpm5 attachment.
	 */
	public static final String defaultAttachmentKey = "Content";
	
	public Map<String, Object> adapt(Content content) {
		ByteArrayInputStream bais = new ByteArrayInputStream(
				content.getContent());
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(bais);
			Object input = ois.readObject();
			if (input instanceof Map) {
				Map mapInput = (Map) input;
				Map<String, Object> finalMap = new HashMap<String, Object>();
				for (Object key : mapInput.keySet()) {
					finalMap.put(key.toString(), mapInput.get(key));
				}
				return finalMap;
			}
			if (input instanceof String) {
				Map<String, Object> newMap = new HashMap<String, Object>();
				newMap.put(defaultAttachmentKey, (String) input);
				return newMap;
			}
			return null;
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
