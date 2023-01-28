package br.com.oratio.oratio.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.oratio.oratio.database.entities.User;
import br.com.oratio.oratio.domain.repository.UserRepository;

@CrossOrigin(maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/test")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/user/register", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @ResponseBody
    @RequestMapping( path = "/user/login", method = RequestMethod.GET)
    public ResponseEntity<String> login(@RequestBody User user) {
    User userEmail = userRepository.findByEmail(user.getEmail());

    if(userEmail != null) {
        String password = user.getPassword();
        String realPassword = userEmail.getPassword();

        if(!password.equals(realPassword)) {
            return ResponseEntity.status(401).body("Algo deu errado!");
        }

        return ResponseEntity.ok("Login realizado com sucesso!");
    } else {
        return ResponseEntity.badRequest().body("Usuário não encontrado!");
       
    }
}
  
    
}
