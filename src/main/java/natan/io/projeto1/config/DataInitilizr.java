package natan.io.projeto1.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import natan.io.projeto1.entity.User;
import natan.io.projeto1.repository.UserRepository;

@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent> {

	// VERSÃO MONGODB
	 @Autowired UserRepository userRepository;
	  
	  @Override public void onApplicationEvent(ContextRefreshedEvent event) {
	  
	  List<User> users = userRepository.findAll();
	  
	  if(users.isEmpty()) {
	  
	  createUser("Ada Loverlace", "adaloverlace@hotmail.com");
	  createUser("Nicola Tesla", "nicolatesla@gmail.com");
	  createUser("Albert Einstein", "alberteinstein@gmail.com"); }
	  
	  User user1 = userRepository.findByName("Nicola Tesla"); 
	  User user4 = userRepository.findByEmail("alberteinstein@gmail.com");
	  User user5 = userRepository.findByNameIgnoreCase("ada loverlace");
	  User user6 = userRepository.findByNameIgnoreCaseLike("lace");
	  User user7 = userRepository.findByEmailPersonalizado("alberteinstein@gmail.com");
	  
	  System.out.println("\nProcurando pelo nome (findByName).................usuário 1: "  + user1.getName());	  
	  System.out.println("\nProcurando pelo email (findByEmail)...............usuário 4: "  + user4.getName());
	  System.out.println("\nProcurando pelo nome (sem case)...................usuário 5: "  + user5.getName()); 
	  System.out.println("\nProcurando pelo nome (sem case + Like)............usuário 6: "  + user6.getName()); 
	  System.out.println("\nProcurando pelo email (findByEmailPersonalizado)..usuário 7: "  + user7.getName());
	  System.out.println("\n"); 
	  }
	  
	  public void createUser(String name, String email){
	  
	  User user = new User(name, email);
	  
	  userRepository.save(user); }
	 
	
	
	// VERSÃO MYSQL	
	/*
	 * @Autowired UserRepository userRepository;
	 * 
	 * @Override public void onApplicationEvent(ContextRefreshedEvent event) {
	 * 
	 * List<User> users = userRepository.findAll();
	 * 
	 * if(users.isEmpty()) {
	 * 
	 * createUser("Ada Loverlace", "adaloverlace@hotmail.com");
	 * createUser("Nicola Tesla", "nicolatesla@gmail.com");
	 * createUser("Albert Einstein", "alberteinstein@gmail.com"); }
	 * 
	 * 
	 * // Pega o usuário de código 2 User user = userRepository.getOne(2L);
	 * System.out.println(user.getName());
	 * 
	 * // Exclui usuário de código 0 userRepository.deleteById(0L);
	 * 
	 * // Modifica um registro de código 2 (Update) User user =
	 * userRepository.getOne(2L);
	 * 
	 * System.out.println("\n\nNome original: " + user.getName());
	 * 
	 * user.setName("Nicola Tesla - Cientista");
	 * 
	 * userRepository.save(user);
	 * 
	 * System.out.println("\nNome alterado: " + user.getName());
	 * 
	 * System.out.println("\n\n");
	 * 
	 * 
	 * User user1 = userRepository.findByName("Nicola Tesla"); User user2 =
	 * userRepository.procurarPorNome("Nicola Tesla"); User user3 =
	 * userRepository.procurarPorNomeFimTexto("Lov"); User user4 =
	 * userRepository.findByEmail("alberteinstein@gmail.com"); User user5 =
	 * userRepository.findByNameIgnoreCase("ada loverlace");
	 * 
	 * System.out.println("\nProcurando pelo nome (findByName).........usuário 1: "
	 * + user1.getName());
	 * System.out.println("\nProcurando pelo nome (person.)............usuário 2: "
	 * + user2.getName());
	 * System.out.println("\nProcurando pelo nome (person. fim texto)..usuário 3: "
	 * + user3.getName());
	 * System.out.println("\nProcurando pelo email (findByEmail).......usuário 4: "
	 * + user4.getName());
	 * System.out.println("\nProcurando pelo nome (sem case)...........usuário 5: "
	 * + user5.getName()); System.out.println("\n"); }
	 * 
	 * public void createUser(String name, String email){
	 * 
	 * User user = new User(name, email);
	 * 
	 * userRepository.save(user); }
	 */

}
