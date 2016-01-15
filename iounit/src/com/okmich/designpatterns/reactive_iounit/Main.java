/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.reactive_iounit;

/**
 * This is an implementation of a Reactor (without the concurrency) design
 * pattern.
 *
 * The scenario is a simple console input and output unit that receives inputs
 * from the command line, dispatches the entry to an implementation of
 * {@link CommandProcessor} who then sends back an output if necessary.
 *
 * <p>
 * While the example here seems trivial, the power behind it is the ability to
 * extends it to handle command processing as a full capable single-threaded
 * reactive service servers without changing the structure of the framework.
 * </p>
 *
 * <p>
 * This architecture can be made to become concurrent by making the
 * {@link CommandProcessor} implementation to execute each command in a separate
 * thread of control either by firing a new {@link Thread#Thread(java.lang.Runnable)
 * } for each call or using any of java concurrency executor services (a more
 * efficient approach).
 * </p>
 *
 * Other patterns used here include:
 * <ul>
 * <li> Template pattern</li>
 * <li> Command Pattern </li>
 * </ul>
 *
 * <p>
 * <strong>NOTE:</strong> The use of java 8 features - Functional Interfaces
 * </p>
 *
 * @author michael.enudi
 */
public class Main {

    public static void main(String[] args) throws Exception {
        IOUnit iounit = new ConsoleIOUnit(uppperCaseCommandProcessor,
                "Welcome to the test",
                "Goodbye!!!");

        iounit.runIOEventLoop();
    }

    /**
     * implementation of the command processor - our command object in this
     * context
     */
    private static final CommandProcessor<String, String> uppperCaseCommandProcessor
            = (String inputType, OutputWriter<String> outputWriter) -> {
                if ("exit".equalsIgnoreCase(inputType)) {
                    outputWriter.writeOutput("", null);
                    return false;
                } else {
                    outputWriter.writeOutput(inputType.toUpperCase());
                    return true;
                }
            };
}
