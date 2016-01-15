/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.reactive_iounit;

import java.io.Serializable;

/**
 *
 * @author michael.enudi
 * @param <InputType>
 * @param <OutputType>
 */
public abstract class IOUnit<InputType, OutputType> implements Serializable {

    /**
     *
     */
    protected final CommandProcessor mCommandProcessor;
    /**
     * the implementation of the input writer
     */
    protected InputReader<InputType> inputReader;
    /**
     * the implementation of the output Writer
     */
    protected OutputWriter outputWriter;

    /**
     *
     * @param commandProcessor
     */
    protected IOUnit(CommandProcessor<InputType, OutputType> commandProcessor) {
        this.mCommandProcessor = commandProcessor;
    }

    /**
     *
     */
    protected abstract void onInitialization();

    /**
     *
     * @throws java.lang.Exception
     */
    public final void runIOEventLoop() throws Exception {
        InputType input;

        //perform initialization
        onInitialization();
        //begin the infinite loop
        while (true) {
            input = inputReader.readInput();
            //command processor handles the processing and output
            if (!mCommandProcessor.process(input, outputWriter)) {
                break;
            } else {
                listenForInput();
            }
        }

        //perform finalization
        onFinalization();
    }

    /**
     *
     */
    protected abstract void onFinalization();

    /**
     *
     */
    public abstract void listenForInput();

}
