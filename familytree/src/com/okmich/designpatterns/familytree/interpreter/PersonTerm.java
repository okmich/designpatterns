/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.familytree.interpreter;

import com.okmich.practise.designpattern.familytree.FamilyTree;
import com.okmich.practise.designpattern.familytree.Person;

/**
 *
 * @author m.enudi
 */
public abstract class PersonTerm extends Term {

    private Person person;

    public PersonTerm() {
    }

    @Override
    public void figureIt(String term, FamilyTree familyTree) {
        //hook method  call
        doFigureIt(familyTree);
        //clear this reference before leaving
        person = null;
    }

    public abstract void doFigureIt(FamilyTree familyTree);

    /**
     *
     */
    public static class SinglePersonTerm extends PersonTerm {

        public SinglePersonTerm() {
        }

        @Override
        public void doFigureIt(FamilyTree familyTree) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    /**
     *
     */
    public static class MultiPersonTerm extends PersonTerm {

        private Person[] persons;

        public MultiPersonTerm(Person[] persons) {
            this.persons = persons;
        }

        @Override
        public void doFigureIt(FamilyTree familyTree) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
}
