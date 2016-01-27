/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.familytree.interpreter.term;

import com.okmich.designpatterns.familytree.interpreter.term.Term;
import com.okmich.designpatterns.familytree.FamilyTree;

/**
 *
 * @author m.enudi
 */
public abstract class ReferenceTerm<T> extends Term {

    protected final String ref;

    public ReferenceTerm(String refWord) {
        this.ref = refWord.toLowerCase();
    }

    @Override
    public void interpret(String term, FamilyTree familyTree) {
        if (familyTree.getContext() == null) { //subject of the grammer

        } else { //the object of the grammer

        }
    }

    /**
     *
     * @return
     */
    public abstract T get();

    /**
     *
     * @return
     */
    public abstract T[] getArray();
}
