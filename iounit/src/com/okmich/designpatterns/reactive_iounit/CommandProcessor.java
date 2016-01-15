/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.reactive_iounit;

/**
 *
 * @author michael.enudi
 * @param <InputType>
 * @param <OutputType>
 */
public interface CommandProcessor<InputType, OutputType> {

    /**
     *
     *
     * @param inputType
     * @param outputWriter
     * @return boolean - return true if the processor is expecting a continued
     * conversation. Very necessary for a keep alive channel but a stateless
     * channel should always return false.
     * @throws Exception
     */
    boolean process(InputType inputType, OutputWriter<OutputType> outputWriter) throws Exception;

    /**
     *
     * @return
     */
    default Object getContextType() {
        //the very default is a null context
        return null;
    }
}
