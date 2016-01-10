/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.familytree;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author m.enudi
 */
public class FamilyTree {

    /**
     * a flat reference for all persons in this family tree
     */
    private final Map<String, Person> LOOKUP_TABLE = new HashMap<>();
    /**
     * the person or persons in current context
     */
    private Person context;

    public FamilyTree() {

    }

    /**
     * @return the context
     */
    public Person getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(Person context) {
        this.context = context;
    }
}
