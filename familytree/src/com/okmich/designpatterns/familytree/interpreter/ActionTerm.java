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
public abstract class ActionTerm extends Term {

    public static boolean isActionCommand(String item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Term getTerm(String item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
    public ActionTerm() {
    }

    @Override
    public boolean isAction() {
        return true;
    }

    /**
     *
     *
     */
    public static final class Marry extends ActionTerm {

        @Override
        public void figureIt(String term, FamilyTree familyTree) {

        }

    }

    /**
     *
     *
     */
    public static final class Divorce extends ActionTerm {

        @Override
        public void figureIt(String term, FamilyTree familyTree) {

        }
    }

    /**
     *
     *
     */
    public static final class Beget extends ActionTerm {

        @Override
        public void figureIt(String term, FamilyTree familyTree) {

        }
    }
}
