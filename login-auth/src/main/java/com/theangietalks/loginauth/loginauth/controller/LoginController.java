package com.theangietalks.loginauth.loginauth.controller;

import com.theangietalks.loginauth.loginauth.entity.User;
import com.theangietalks.loginauth.loginauth.entity.UserResponse;
import com.theangietalks.loginauth.loginauth.security.JwtUtil;
import com.theangietalks.loginauth.loginauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private UserService service;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User authRequest) throws Exception {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        // Verifique as credenciais do usuário (pode ser uma verificação no banco de dados, por exemplo)
        boolean credentialsValid = verifyCredentials(username, password);

        if (credentialsValid) {
            String token = jwtTokenUtil.generateToken(username);
            return ResponseEntity.ok(new UserResponse(token));
        } else {
            throw new Exception("Invalid username or password");
        }
    }

    private boolean verifyCredentials(String username, String password) {
        if(service.findByUsernameAndPassword(username, password)){
            return true;
        }
        return false;
    }

//    @GetMapping("/token")
//    public ResponseEntity<String> getToken(@RequestHeader("Authorization") String authorizationHeader){
//        String token = authorizationHeader.substring(7);
//        return ResponseEntity.ok(token);
//    }

    @PostMapping("/token")
    public ResponseEntity<String> getToken(@RequestBody User authRequest) throws Exception {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        boolean credentialsValid = verifyCredentials(username, password);

        if (credentialsValid) {
            String token = jwtTokenUtil.generateToken(username);
            return ResponseEntity.ok(token);
        } else {
            throw new Exception("Invalid username or password");
        }
    }

//    public String getToken(){
//
//    }

}
