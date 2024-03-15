package br.edu.ifmt.springbootcleanarch.client.cli;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.fasterxml.jackson.databind.ObjectMapper;

@ShellComponent
public class MyCommands {

    @Autowired
    private UserPort userPort = null;

    @ShellMethod(key = "create-user")
    public String createUser(
        @ShellOption String name,
        @ShellOption String email,
        @ShellOption String password
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