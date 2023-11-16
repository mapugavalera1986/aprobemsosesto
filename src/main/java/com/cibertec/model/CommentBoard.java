package com.cibertec.model;

import java.util.ArrayList;
import java.util.List;

public class CommentBoard {
	private List<Comment> comments;

	public CommentBoard() {
		this.comments = new ArrayList<>();
	}

	public void addComment(String username, String content) {
		Comment comment = new Comment(username, content);
		comments.add(comment);
	}

	public List<Comment> getComments() {
		return comments;
	}

}
