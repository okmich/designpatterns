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
public class FilingSecretaryDesk extends TemplateDesk {

    public FilingSecretaryDesk() {
    }

    @Override
    protected boolean doSpecificFunction(TxnObject txn) {
        txn.update("Files were updated and confirmed up to date");
        return true;
    }

}
