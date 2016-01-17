/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpattern.stockexchange.v2;

import com.okmich.designpattern.stockexchange.v2.broker.Broker;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michael.enudi
 */
public class BarterExchange implements Exchange {

    private final StockRegister _stockRegister;

    private final Set<Broker> brokers;

    /**
     *
     */
    public BarterExchange() {
        this.brokers = new HashSet<>();
        this._stockRegister = StockRegister.getInstance(this);
    }

    private void init() {

    }

    @Override
    public void registerBroker(Broker broker) {
        brokers.add(broker);
    }

    @Override
    public void unregisterBroker(Broker broker) {
        this.brokers.remove(broker);
    }

    @Override
    public void notifyOnStockEvent(Stock stock) {
        brokers.stream().forEach((_broker) -> {
            _broker.update(null);
        });
    }

    @Override
    public Order fill(Order order) {
        Stock stock = _stockRegister.getStock(order.getSymbol());
        try {
            ((ServerOrder) order).execute(this, stock);
        } catch (Exception ex) {
            Logger.getLogger(BarterExchange.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return order;
    }

    @Override
    public Order getOrderTicket(int orderType, Broker broker) {
        return OrderFactory.getOrder(orderType,
                broker.getBrokerId(), broker.getBrokerName());
    }

    @Override
    public StockRegister getStockRegister() {
        return this._stockRegister;
    }

    public void initStockRegister(String symbol, int vol, float unitPrice) {
        Stock s = new Stock(symbol);
        s.setAskPrice(unitPrice);
        s.setBidPrice(unitPrice);
        s.setVolume(vol);
        this._stockRegister.addStock(s);
    }
}
