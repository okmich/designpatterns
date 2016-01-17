/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpattern.stockexchange.v2;

import com.okmich.designpattern.stockexchange.v2.broker.Broker;
import com.okmich.designpattern.stockexchange.v2.broker.ExchangeBroker;
import java.io.Serializable;

/**
 *
 * @author michael.enudi
 */
public interface Exchange extends Serializable {

    /**
     *
     * @param broker
     */
    void registerBroker(Broker broker);

    /**
     *
     * @param broker
     */
    void unregisterBroker(Broker broker);

    /**
     *
     * @param stock
     */
    void notifyOnStockEvent(Stock stock);

    /**
     *
     * @param order
     * @return
     */
    Order fill(Order order);

    /**
     *
     * @param orderType
     * @param broker
     * @return
     */
    Order getOrderTicket(int orderType, Broker broker);

    /**
     *
     * @return
     */
    StockRegister getStockRegister();
}
