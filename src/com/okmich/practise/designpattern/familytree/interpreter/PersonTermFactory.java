/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.practise.designpattern.familytree.interpreter;

/**
 *
 * @author m.enudi
 */
public class PersonTermFactory {

    public static PersonTerm getPersonTerm(String arg) {
        //check for multiple person
        if (arg.contains(",")) {

        } else {
            return createPersonTerm(arg);
        }

        return null;
    }

    /**
     *
     * @param arg
     * @return
     */
    private static PersonTerm createPersonTerm(String arg) {
        String[] args = arg.split(":");

        return null;
    }
}
