/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.familytree.connection;

import java.util.LinkedHashSet;
import java.util.Set;



/**
 *
 * @author m.enudi
 */
public class SiblingConnection implements Connector<Person> {

    public SiblingConnection() {
    }

    @Override
    public void findConnection(Person person) {
        if (person.getFather() != null && person.getMother() != null) {
            System.out.println("Sorry!!!.. No record of father or mother ");
            return;
        }
        Set<Person> siblings = new LinkedHashSet<>();
        //add all from mother and father
        siblings.addAll(person.getFather().getChildren());
        siblings.addAll(person.getMother().getChildren());

        System.out.println("Siblings are " + siblings);
    }
}
