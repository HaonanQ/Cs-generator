package com.qhn;

import com.qhn.cli.CommandExecutor;

public class Main {
    public static void main(String[] args) {
//        args = new String[] {"config"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.execute(args);
    }
}
