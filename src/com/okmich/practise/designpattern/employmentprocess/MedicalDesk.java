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
public class MedicalDesk extends TemplateDesk {

    @Override
    protected boolean doSpecificFunction(TxnObject txn) {
        txn.update("Medical test performed. Clean bill of health issue.");
        return true;
    }

}
