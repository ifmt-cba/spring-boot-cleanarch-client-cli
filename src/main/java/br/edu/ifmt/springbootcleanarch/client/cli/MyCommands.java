package br.edu.ifmt.springbootcleanarch.client.cli;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

import com.fasterxml.jackson.databind.ObjectMapper;

@Command(group = "User Commands")
public class MyCommands {

    @Autowired
    private UserPort userPort = null;

    @Command(command = "create-user",
             description = "Cadastra um novo usuário")
    public String createUser(
        @Option(required = true, shortNames = 'n', description = "Nome do usuário") String name,
        @Option(required = true, shortNames = 'e', description = "E-mail do usuário") String email,
        @Option(required = true, shortNames = 'p', description = "Senha do usuário") String password
    ) {
        try {
            String reply = userPort.createUser(name, email, password);
            ObjectMapper objectMapper = new ObjectMapper();
            Map map = objectMapper.readValue(reply.getBytes(),Map.class);
            if (map.get("error")!=null && !map.get("error").toString().isEmpty())
                return map.get("error").toString();
            else
                return "Usuário criado com sucesso!\n" + reply;
            } catch (IOException e) {
            return e.getMessage();
        }
    }

}