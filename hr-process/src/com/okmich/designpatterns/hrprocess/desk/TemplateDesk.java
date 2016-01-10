/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.hrprocess.desk;

import com.okmich.designpatterns.hrprocess.Desk;
import com.okmich.designpatterns.hrprocess.TxnObject;

/**
 * I am implementing a design pattern with this class such that every other
 * class concentrates on their specific function while this class coordinates
 * the chain passing and the general behaviours of the chain of responsibility
 * design pattern
 *
 * @author m.enudi
 */
public abstract class TemplateDesk implements Desk {

    private Desk nextDesk;

    protected TemplateDesk() {
    }

    @Override
    public void setNextDesk(Desk desk) {
        this.nextDesk = desk;
    }

    /**
     *
     * @param txn
     * @return
     */
    @Override
    public TxnObject processTxn(TxnObject txn) {
        //performing specific action and return and indicator that all is well
        //should all not be well, we would discontinue this chain of responsibility
        boolean shouldContinue = doSpecificFunction(txn);
        //calling the next Desk
        if (this.nextDesk != null && shouldContinue) {
            return this.nextDesk.processTxn(txn);
        } else {
            return txn;
        }
    }

    /**
     * this is the variable part of the template design pattern implementation
     * for this chain of responsibility design demonstration
     *
     * @param txn
     */
    protected abstract boolean doSpecificFunction(TxnObject txn);
}
