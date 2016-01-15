/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.reactive_iounit;

import java.util.Scanner;

/**
 *
 * @author michael.enudi
 */
public class ConsoleIOUnit extends IOUnit<String, String> {

    private final String initMsg, closingMsg;

    public ConsoleIOUnit(CommandProcessor<String, String> commandProcessor,
            String initMsg, String closingMsg) {
        super(commandProcessor);

        //input reader
        this.inputReader = new ConsoleInputReader();
        //output writer
        this.outputWriter = new ConsoleOutputWriter();

        this.initMsg = initMsg;
        this.closingMsg = closingMsg;
        
    }

    @Override
    public void onInitialization() {
        System.out.println(this.initMsg + "\n\n");
        listenForInput();
    }

    @Override
    public void onFinalization() {
        System.out.println(this.closingMsg);
    }

    @Override
    public void listenForInput() {
        if (mCommandProcessor.getContextType() == null) {//default
            System.out.printf(">> ");
        } else {
            System.out.printf("[%s] >> " + mCommandProcessor.getContextType().toString());
        }
    }

    private final class ConsoleInputReader implements InputReader<String> {

        private final Scanner scanner;

        ConsoleInputReader() {
            this.scanner = new Scanner(System.in);
        }

        @Override
        public String readInput() {
            return scanner.nextLine();
        }
    }

    private class ConsoleOutputWriter implements OutputWriter<String> {

        ConsoleOutputWriter() {
        }

        @Override
        public void writeOutput(String... message) throws RuntimeException {
            System.out.printf("%s\n", message[0]);
        }
    }

}