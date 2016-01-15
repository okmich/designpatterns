/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpattern.stockexchange.v2;

import java.io.Serializable;

/**
 *
 * @author michael.enudi
 */
public interface Broker extends Serializable {

    /**
     * registers broker and assigns id
     */
    void register();

    /**
     * leave the exchange
     */
    void unregister();

    /**
     *
     * @param stock
     */
    void update(Stock stock);

    /**
     *
     * @param symbol
     * @param price
     * @return - order ticket
     */
    String buyOffer(String symbol, float price);

    /**
     *
     * @param symbol
     * @param price
     * @return - order ticket
     */
    String salesOffer(String symbol, float price);
}
