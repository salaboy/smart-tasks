package com.wordpress.salaboy.api;

/**
 * Interface to adapt TAttachments.
 * @author calcacuervo
 *
 * @param <T>
 * @param <U>
 */
public interface TAttachmentAdapter <T, U> {
	
	public T adapt(U attachment);

}
