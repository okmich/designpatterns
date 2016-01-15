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
public interface Exchange extends Serializable {

    /**
     *
     * @param broker
     */
    void registerBroker(ExchangeBroker broker);

    /**
     *
     * @param broker
     */
    void unregisterBroker(ExchangeBroker broker);

    /**
     *
     * @param stock
     */
    void notifyOnStockEvent(Stock stock);

    /**
     *
     * @param order
     */
    void fill(Order order);

    /**
     *
     * @param orderType
     * @return
     */
    Order getOrderTicket(String orderType);

    /**
     *
     * @return
     */
    StockRegister getStockRegister();
}
