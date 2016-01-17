/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpattern.stockexchange.v2.broker;

import com.okmich.designpattern.stockexchange.v2.Exchange;
import com.okmich.designpattern.stockexchange.v2.Order;
import com.okmich.designpattern.stockexchange.v2.OrderType;
import com.okmich.designpattern.stockexchange.v2.Stock;
import java.util.UUID;

/**
 *
 * @author michael.enudi
 */
public class ExchangeBroker implements Broker {

    private final Exchange _exchange;
    private String _Id;
    private String _name;

    /**
     *
     * @param name
     * @param exchange
     */
    public ExchangeBroker(String name, Exchange exchange) {
        this._exchange = exchange;
        this._name = name;
        //give it some random id
        this._Id = UUID.randomUUID().toString();
        //perform self registration
        register();
    }

    /**
     * registers broker and assigns id
     */
    @Override
    public void register() {
        this._exchange.registerBroker(this);
    }

    /**
     * leave the exchange
     */
    @Override
    public void unregister() {
        this._exchange.unregisterBroker(this);
    }

    /**
     *
     * @param stock
     */
    @Override
    public void update(Stock stock) {
        //do something with it
    }

    /**
     *
     * {@inheritDoc }
     */
    @Override
    public String buyOffer(String symbol, int unit) {
        Order order = this._exchange.getOrderTicket(OrderType.BUY, this);
        return placeOrder(order, symbol, unit);
    }

    /**
     *
     * {@inheritDoc }
     */
    @Override
    public String salesOffer(String symbol, int unit) {
        Order order = this._exchange.getOrderTicket(OrderType.SELL, this);
        return placeOrder(order, symbol, unit);
    }

    /**
     * @return the _Id
     */
    @Override
    public String getBrokerId() {
        return _Id;
    }

    /**
     * @param _Id the _Id to set
     */
    public void setBrokerId(String _Id) {
        this._Id = _Id;
    }

    /**
     * @return the _name
     */
    @Override
    public String getBrokerName() {
        return _name;
    }

    /**
     * @param _name the _name to set
     */
    public void setBrokerName(String _name) {
        this._name = _name;
    }

    @Override
    public int hashCode() {
        return this._Id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExchangeBroker other = (ExchangeBroker) obj;

        return this._Id.equals(other._Id);
    }

    /**
     *
     * @param order
     * @param symbol
     * @param unit
     * @return
     */
    private String placeOrder(Order order, String symbol, int unit) {
        order.setSymbol(symbol);
        order.setUnits(unit);
        order = this._exchange.fill(order);

        return String.valueOf(order.getTicketId());
    }
}
