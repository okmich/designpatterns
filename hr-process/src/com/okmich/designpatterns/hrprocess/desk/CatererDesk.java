/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.hrprocess.desk;

import com.okmich.designpatterns.hrprocess.TxnObject;

/**
 *
 * @author m.enudi
 */
public class CatererDesk extends TemplateDesk {

    public CatererDesk() {
    }

    @Override
    protected boolean doSpecificFunction(TxnObject txn) {
        txn.update("Visitor was served coffee and well received.");
        return true;
    }

}
