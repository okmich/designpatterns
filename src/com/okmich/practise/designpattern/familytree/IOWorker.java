/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.practise.designpattern.familytree;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author m.enudi
 */
public class IOWorker {

    private Scanner scanner;
    private Taker taker;

    public IOWorker(Taker taker) {
        this.taker = taker;
        this.scanner = new Scanner(System.in);
    }

    void awaitInputCommand() {
        readyForInput();
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            if ("exit".equalsIgnoreCase(command)) {
                break;
            }
            //send the command to the interpreter
            String output = this.taker.process(command);
            System.out.println(output);

            readyForInput();
        }
        this.taker = null;
    }

    void readyForInput() {
        if (taker.hasContext()) {
            System.out.printf("\n[%s] >> ", taker.getContext());
        } else {
            System.out.printf("\n>> ");
        }
    }

    public IOWorker() {
    }

    public static void main(String[] args) {
        Taker taker = new Taker();
        IOWorker io = new IOWorker(taker);

        System.out.println("bla bla bla bla \n");
        io.awaitInputCommand();
    }

    public static class Taker {

        String context = null;

        Taker() {
        }

        String process(String input) {
            if (new Random().nextInt(10) % 2 == 0) {
                this.context = "michael";
            } else {
                this.context = null;
            }
            //do someing
            return "Hello Everybody.";
        }

        String getContext() {
            return this.context;
        }

        boolean hasContext() {
            return this.context != null;
        }
    }
}
