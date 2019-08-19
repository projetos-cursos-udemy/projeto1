package natan.io.projeto1.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import natan.io.projeto1.entity.User;

// VERSÃO MONGODB
public interface UserRepository extends MongoRepository<User, Long> {
	
	// Busca padrão no Spring Data:
	
	// findBy[nome da propriedade][(tipo parametro)]
	User findByName(String name);
	
	User findByEmail(String email);
	
	// Ignorar Case Sensitive
	User findByNameIgnoreCase(String name);
	
	// Ignorar Case Sensitive + Like
	User findByNameIgnoreCaseLike(String name);
	
	// Nome de busca personalizado:
	@Query("{ 'email' : ?0}")
	User findByEmailPersonalizado(String email);
	
}

// VERSÃO MYSQL
/*
 * public interface UserRepository extends JpaRepository<User, Long> {
 * 
 * // Busca padrão no Spring Data:
 * 
 * // findBy[nome da propriedade][(tipo parametro)] 
 * User findByName(String name);
 * 
 * User findByEmail(String email);
 * 
 * // Nome de busca personalizado:
 * 
 * // O 1 no final define retornar apenas o 1º encontrado
 * 
 * @Query("select u from User u where u.name = ?1") 
 * User procurarPorNome(String name);
 * 
 * // %?1 define qualquer texto que termine com o texto passado no parâmetro e
 * retorna o 1º encontrado
 * 
 * @Query("select u from User u where u.name like %?1%") 
 * User procurarPorNomeFimTexto(String name);
 * 
 * // Ignorar Case Sensitive 
 * User findByNameIgnoreCase(String name);
 * 
 * }
 */