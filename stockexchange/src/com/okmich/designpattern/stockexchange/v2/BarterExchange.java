/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpattern.stockexchange.v2;

import java.util.HashSet;
import java.util.Set;

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
    public void registerBroker(ExchangeBroker broker) {
        broker.setId(broker.getName().replace(" ", "") + "_" + brokers.size());
        brokers.add(broker);
    }

    @Override
    public void unregisterBroker(ExchangeBroker broker) {
        this.brokers.remove(broker);
        broker.setId(null);
    }

    @Override
    public void notifyOnStockEvent(Stock stock) {
        brokers.stream().forEach((_broker) -> {
            _broker.update(null);
        });
    }

    @Override
    public void fill(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order getOrderTicket(String orderType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
