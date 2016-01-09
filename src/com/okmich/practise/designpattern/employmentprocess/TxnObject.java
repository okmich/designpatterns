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
public class TxnObject {

    private final StringBuilder txnLog = new StringBuilder();

    public TxnObject() {
    }

    public void update(String msg) {
        txnLog.append("\n").append(msg);
    }

    public String getTxnLog() {
        return txnLog.toString();
    }
}
