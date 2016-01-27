/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.familytree.interpreter.term;

import com.okmich.designpatterns.familytree.Entity;
import java.util.Arrays;

/**
 *
 * @author m.enudi
 */
public abstract class ActionTerm extends Term {

    static final String ACTION_TERMS[] = {"begets", "divorces", "marries"};

    /**
     *
     * @param item
     * @return
     */
    public static boolean isActionCommand(String item) {
        return Arrays.binarySearch(ACTION_TERMS, item) != -1;
    }

    /**
     *
     * @param item
     * @return
     */
    public static Term getTerm(String item) {
        switch (item) {

        }
        return null;
    }

    /**
     *
     */
    protected ActionTerm() {
    }

    @Override
    public boolean isAction() {
        return true;
    }

    public abstract <T extends Entity> void apply(T t1, T t2);
}
