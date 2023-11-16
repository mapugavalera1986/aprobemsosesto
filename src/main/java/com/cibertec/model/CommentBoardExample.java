package com.cibertec.model;

import java.util.List;

public class CommentBoardExample {
	public static void main(String[] args) {
		CommentBoard commentBoard = new CommentBoard();

		// Agregar comentarios al tablón
		commentBoard.addComment("User1", "¡Este es un comentario genial!");
		commentBoard.addComment("User2", "¡Gracias por compartir!");
		commentBoard.addComment("User3", "Interesante discusión.");

		// Obtener y mostrar comentarios
		List<Comment>comments = commentBoard.getComments();
		for (Comment comment : comments) {
			System.out.println("Usuario: " + comment.getUsername());
			System.out.println("Contenido: " + comment.getContent());
			System.out.println("Fecha y hora: " + comment.getTimestamp());
			System.out.println("-------------------------");
		}
	}
}



