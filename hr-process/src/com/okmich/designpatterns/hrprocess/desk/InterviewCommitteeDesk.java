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
public class InterviewCommitteeDesk extends TemplateDesk {

    public InterviewCommitteeDesk() {
    }

    @Override
    protected boolean doSpecificFunction(TxnObject txn) {
        txn.update("Interview conducted. Applicant performed creditably well");
        return true;
//        txn.update("Interview conducted. Applicant did not show sufficient reason to be employed");
//        return false;
    }

}
