/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.practise.designpattern.familytree;

/**
 *
 * @author m.enudi
 */
public interface Processor<T> {

    T process(String command, FamilyTree familyTree);
}
