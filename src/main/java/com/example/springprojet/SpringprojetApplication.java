package com.example.springprojet;

import com.example.springprojet.modele.User;
import com.example.springprojet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringprojetApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringprojetApplication.class, args);
    }

  /*  @Autowired
    PasswordEncoder encoder;
    @Override
    public void run(String... args) throws Exception{ System.out.println(encoder.encode("ndiaye")); }*/
  @Autowired
    UserRepository userRepository;
    public void run(String... args) throws Exception{

     /* User user=new User();
      user.setStatus("activer");
      user.setPrenom("Kabirou");
      user.setNom("ndiaye");
      user.setTelephone(338501225);
      user.setImage_Name("super.png");
      user.setMatricule("SUPER");
      user.setAdresse("dakar");
      user.setEmail("super@gmail.com");
      user.setName("kabirou bodji");
      user.setPassword("super");
      user.setUsername("superadmin");

      return userRepository.save(user);*/
     userRepository.save(new User("kabirou bodji","kabirou","ndiaye@gmail.com","ndiaye","SUPER","ndiaye","ndioufa","dakar",338501225,"activer","sup.png"));

     userRepository.findAll().forEach(c->{
         System.out.println(c.getName());
     });
  }
}
