/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpattern.stockexchange.v2.broker;

import com.okmich.designpattern.stockexchange.v2.Stock;
import java.io.Serializable;

/**
 *
 * @author michael.enudi
 */
public interface Broker extends Serializable {

    /**
     *
     * @return
     */
    String getBrokerId();

    /**
     *
     * @return
     */
    String getBrokerName();

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
     * @param unit
     * @return - order ticket
     */
    String buyOffer(String symbol, int unit);

    /**
     *
     * @param symbol
     * @param unit
     * @return - order ticket
     */
    String salesOffer(String symbol, int unit);
}
