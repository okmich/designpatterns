/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.practise.designpattern.familytree;

import com.okmich.practise.designpattern.familytree.interpreter.ActionTerm;
import com.okmich.practise.designpattern.familytree.interpreter.PersonTermFactory;
import com.okmich.practise.designpattern.familytree.interpreter.PronounTerm;
import com.okmich.practise.designpattern.familytree.interpreter.ReferenceTerm;
import com.okmich.practise.designpattern.familytree.interpreter.Term;

/**
 *
 * @author m.enudi
 */
public class GenelogyProcessor implements Processor<Void> {

    /**
     *
     */
    public GenelogyProcessor() {
    }

    @Override
    public Void process(String command, FamilyTree familyTree) {
        //split the string into commands
        Term term = getTermFromCommand(command);
        //loop through composite terms to call process
        try {
            term.figureIt("", familyTree);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     *
     * @param command
     * @return
     */
    private Term getTermFromCommand(String command) {
        String[] expressions = command.split("\\s");
        Term term = null;
        for (String item : expressions) {
            if (term == null) {
                term = getTerm(item);
            } else {
                term.setNextTerm(getTerm(item));
            }
        }
        return term;
    }

    /**
     *
     * @param item
     * @return
     */
    private Term getTerm(String item) {
        //if the word starts with p:, a new person registration
        if (item == null) {
            throw new IllegalArgumentException("cant have a null term");
        }
        //
        if (item.startsWith(Term.NEW_PERSON_INDICATOR)) {
            return PersonTermFactory.getPersonTerm(item);
        } else if (ActionTerm.isActionCommand(item)) {
            return ActionTerm.getTerm(item);
        } else if (PronounTerm.isPronoun(item)) {
            return new PronounTerm(item);
        } else { //we asuume this is a reference to a previously declared term
            return new ReferenceTerm(item);
        }
    }

}
