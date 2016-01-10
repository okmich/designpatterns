/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.hrprocess;

/**
 *
 * @author m.enudi
 */
public interface Desk {

    /**
     * increase the chain
     *
     * @param desk
     */
    void setNextDesk(Desk desk);

    /**
     * perform specific action
     *
     * @param txn
     * @return
     */
    TxnObject processTxn(TxnObject txn);
}
