package com.winenergy.bookmark;

/**
 * Model class that stores a message.
 * @author Fuping Ma
 *
 */
public class MessageStore {
	
	public static String BOOKMARK_ADDED_SUCCESSFUL = "The bookmark has been added successfully.";
	public static String BOOKMARK_ADDED_FAILED = "The bookmark was not added!";
	public static String BOOKMARK_REMOVED_SUCCESSFUL = "The bookmark has been deleted.";
	public static String BOOKMARK_REMOVED_FAILED = "The bookmark was not deleted!";
	public static String BOOKMARK_RETRIEVE_FAILED = "Could not retrieve bookmarks from the database.";
	
	private String message;
	
	public MessageStore() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}