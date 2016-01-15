/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.familytree.interpreter;

import com.okmich.designpatterns.familytree.FamilyTree;


/**
 *
 * @author m.enudi
 */
public abstract class Term {

    private Term nextTerm;

    public Term() {
    }

    /**
     *
     * @param term
     * @param familyTree
     */
    public abstract void figureIt(String term, FamilyTree familyTree);

    /**
     * the default term is not an action term
     *
     * @return
     */
    public boolean isAction() {
        return false;
    }

    /**
     *
     * @return
     */
    public Term nextTerm() {
        return this.nextTerm;
    }

    /**
     *
     * @param term
     */
    public void setNextTerm(Term term) {
        this.nextTerm = term;
    }

    /**
     * NEW_PERSON_INDICATOR
     */
    public static final String NEW_PERSON_INDICATOR = "p:";

}
