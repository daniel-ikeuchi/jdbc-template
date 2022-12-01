package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Book {

	private Long id;
	private String title;
	private String description;
	private boolean published;
	
	public Book(String title, String description, boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}
	
	@Override
	  public String toString() {
	    return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
	  }
	
}
