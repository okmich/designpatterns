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
public class GeneralSecretaryDesk extends TemplateDesk {

    public GeneralSecretaryDesk() {
    }

    @Override
    protected boolean doSpecificFunction(TxnObject txn) {
        txn.update("Applicant was received. Documents were collected and sents review committe");
        return true;
    }

}
