package br.edu.ifmt.springbootcleanarch.client.cli;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class MyCommands {

    @ShellMethod(key = "")
    public String create(
        @ShellOption(defaultValue = "") String arg
    ) {
        return "";
    }

}