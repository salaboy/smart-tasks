package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.example.ws_ht.api.TTaskQueryResultRow;

import bitronix.tm.utils.PropertyUtils;

import com.wordpress.salaboy.api.TaskAdapter;

public class JBPM5TTaskQueryResultAdapter implements TaskAdapter<TTaskQueryResultRow, Object> {
	
	private static JBPM5TTaskQueryResultAdapter instance = new JBPM5TTaskQueryResultAdapter();
	
	private JBPM5TTaskQueryResultAdapter() {
	}
	
	public static JBPM5TTaskQueryResultAdapter getInstance() {
		return instance;
	}

	public TTaskQueryResultRow adapt(Object vendorQueryResult) {
		TTaskQueryResultRow row = new TTaskQueryResultRow();
		Map props = PropertyUtils.getProperties(vendorQueryResult);
		for (Object keyObj : props.keySet()) {
			String key = (String) keyObj;
			JAXBElement elem = new JAXBElement(
					new QName(key),
					PropertyUtils.getProperty(vendorQueryResult, key).getClass(),
					props.get(key));
			row.getIdOrTaskTypeOrName().add(elem);
		}
		return row;
	}

	public List<TTaskQueryResultRow> adaptCollection(List<Object> vendorQueryResults) {
		List<TTaskQueryResultRow> retval = new ArrayList<TTaskQueryResultRow>(vendorQueryResults.size());
		for (Object obj : vendorQueryResults) {
			retval.add(adapt(obj));
		}
		return retval;
	}

}
