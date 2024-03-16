package br.edu.ifmt.springbootcleanarch.client.cli;

import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

@Command(group = "Global Commands",
         command = "server")
public class GlobalCommands {

    public static String url = "http://cleanarch:7070";

    @Command(command = "connect",
             description = "Se conecta ao servidor cleanarch")
    public String connect(@Option(required = true, description = "Server Address") String host,
                          @Option(required = true, description = "Server Port") String port) {
        url = "http://" + host + ":" + port;
        return "Dados de conexão estabelecidos para: ".concat(url);
    }

    @Command(command = "url",
             description = "Exibe a URL de conexão")
    public String url() {
        return url;
    }    

}