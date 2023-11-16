package com.cibertec.model;

import java.util.Date;

public class Comment {
	private String username;
	private String content;
	private Date timestamp;

	public Comment(String username, String content) {
		this.username = username;
		this.content = content;
		this.timestamp = new Date();
	}

	// Getters and setters (puedes generarlos automáticamente en tu IDE)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
