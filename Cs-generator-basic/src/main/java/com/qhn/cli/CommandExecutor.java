package com.qhn.cli;

import com.qhn.cli.command.ConfigCommand;
import com.qhn.cli.command.GeneratorCommand;
import com.qhn.cli.command.ListCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "qhn",version = "1.0.0",mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {
    private final CommandLine commandLine;
    {
        commandLine =new CommandLine(this)
                .addSubcommand(new GeneratorCommand())
                .addSubcommand(new ListCommand())
                .addSubcommand(new ConfigCommand());
    }

    @Override
    public void run() {
        System.out.println("请输入命令：，或者输入 --help  查看帮助");
    }
    public Integer execute(String[] args) {
        return commandLine.execute(args);
    }
}
