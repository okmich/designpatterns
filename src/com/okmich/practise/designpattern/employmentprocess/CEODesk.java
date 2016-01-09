/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.practise.designpattern.employmentprocess;

/**
 *
 * @author m.enudi
 */
public class CEODesk extends TemplateDesk {

    public CEODesk() {
    }

    @Override
    protected boolean doSpecificFunction(TxnObject txn) {
        txn.update("Official talk with our new employee and fomalities performed.");
        return true;
    }

}
