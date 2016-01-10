/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.familytree.interpreter;

import com.okmich.practise.designpattern.familytree.FamilyTree;

/**
 *
 * @author m.enudi
 */
public class ReferenceTerm extends Term {

    protected final String ref;

    public ReferenceTerm(String refWord) {
        this.ref = refWord.toLowerCase();
    }

    @Override
    public void figureIt(String term, FamilyTree familyTree) {
        if (familyTree.getContext() == null) { //subject of the grammer

        } else { //the object of the grammer

        }
    }
}
