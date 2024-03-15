package br.edu.ifmt.springbootcleanarch.client.cli;

import java.io.IOException;

public interface UserPort {
    
    String createUser(String username, String email, String password) throws IOException;

}
