/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.familytree;

import com.okmich.designpatterns.familytree.interpreter.term.ActionTerm;
import com.okmich.designpatterns.familytree.interpreter.PersonTermFactory;
import com.okmich.designpatterns.familytree.interpreter.term.ReferenceTerm;
import com.okmich.designpatterns.familytree.interpreter.term.Term;
import java.util.ArrayList;
import java.util.List;

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
        //loop through list of terms to call process
        try {
            // term.interprete("", familyTree);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     *
     * @param command
     * @return
     */
    private List<Term> getTermFromCommand(String command) {
        String[] expressions = command.split("\\s");
        List<Term> terms = new ArrayList<>(expressions.length);
        for (String item : expressions) {
            terms.add(getTerm(item));
        }
        return terms;
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
        if (ActionTerm.isActionCommand(item)) {
            return ActionTerm.getTerm(item);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
