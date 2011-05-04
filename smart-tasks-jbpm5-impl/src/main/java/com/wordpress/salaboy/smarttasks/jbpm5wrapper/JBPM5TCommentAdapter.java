package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import java.util.ArrayList;
import java.util.List;

import org.example.ws_ht.api.TComment;
import org.jbpm.task.Comment;

import com.wordpress.salaboy.api.TaskAdapter;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.util.XMLDataTypeUtils;

public class JBPM5TCommentAdapter implements TaskAdapter<TComment, Comment> {

	private static JBPM5TCommentAdapter instance = new JBPM5TCommentAdapter();

	private JBPM5TCommentAdapter() {
	}
	
	public static JBPM5TCommentAdapter getInstance() {
		return instance;
	}
	
	public TComment adapt(Comment vendorComment) {
		TComment comment = new TComment();
		comment.setAddedAt(XMLDataTypeUtils.convertDateToGregorianCalendar(vendorComment.getAddedAt()));
		comment.setAddedBy(vendorComment.getAddedBy().getId());
		comment.setText(vendorComment.getText());
		comment.getAny().add(vendorComment.getId());
		return comment;
	}

	public List<TComment> adaptCollection(List<Comment> vendorComments) {
		List<TComment> retval = new ArrayList<TComment>(vendorComments.size());
		for (Comment comment : vendorComments) {
			retval.add(adapt(comment));
		}
		return retval;
	}

}
