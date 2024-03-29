package natan.io.projeto1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

// VERSÃO MONGODB
@Document
public class Role {

	@Id
	private String id;
	private String name;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}



//VERSÃO MYSQL
/*
 * @Entity public class Role {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.AUTO) private Long id; private
 * String name;
 * 
 * 
 * public Long getId() { return id; } public void setId(Long id) { this.id = id;
 * } public String getName() { return name; } public void setName(String name) {
 * this.name = name; } }
 */