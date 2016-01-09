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
public class PronounTerm extends ReferenceTerm {

    static String[] pronouns = {"he", "she", "they"};

    /**
     *
     * @param pronoun
     */
    public PronounTerm(String pronoun) {
        super(pronoun);
    }

    /**
     *
     * @param item
     * @return
     */
    public static boolean isPronoun(String item) {
        for (String p : pronouns) {
            if (p.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
