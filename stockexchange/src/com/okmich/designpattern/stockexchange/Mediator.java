/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpattern.stockexchange;

/**
 *
 * @author m.enudi
 */
public interface Mediator {

    void register(Colleague colleague);

    void unregister(Colleague colleague);

    void salesOffer(String symbol, int shares, int _code);

    void buyOffer(String symbol, int shares, int _code);

    void getStockOffering();
}
