/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.familytree.interpreter.term;

import com.okmich.designpatterns.familytree.FamilyTree;

/**
 *
 * @author m.enudi
 */
public abstract class Term {

    protected Term() {
    }

    /**
     *
     * @param term -
     * @param familyTree - this is the context
     */
    public abstract void interpret(String term, FamilyTree familyTree);

    /**
     * the default term is not an action term
     *
     * @return
     */
    public boolean isAction() {
        return false;
    }
}
