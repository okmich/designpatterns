/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpattern.stockexchange.v2;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author michael.enudi
 */
public final class StockRegister implements Serializable {

    private final Map<String, Stock> stockMap;
    private static volatile StockRegister _stockRegister;
    private final Exchange _exchange;

    /**
     *
     * @param exchange
     */
    private StockRegister(Exchange exchange) {
        this._exchange = exchange;
        this.stockMap = new ConcurrentHashMap<>();
    }

    /**
     *
     * @param exchange
     * @return
     */
    static StockRegister getInstance(Exchange exchange) {
        if (_stockRegister == null) {
            _stockRegister = new StockRegister(exchange);
        }
        return _stockRegister;
    }

    /**
     *
     * @param stock
     */
    void addStock(Stock stock) {
        this.stockMap.put(stock.getSymbol(), stock);
        //notify all brokers about this move
        this._exchange.notifyOnStockEvent(stock);
    }

    /**
     *
     * @param symbol
     * @return
     */
    public Stock getStock(String symbol) {
        Stock iStock = this.stockMap.get(symbol);
        if (iStock == null) {
            throw new IllegalArgumentException("invalid stock symbol");
        }
        return iStock;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#,##0.00");

        sb.append("SYM").append("\t").append("ASK").append("\t").append("BID")
                .append("\t").append("VOL").append("\t").append("STATE");
        sb.append("\n");
        sb.append("=====").append("\t").append("=====").append("\t").append("=====")
                .append("\t").append("=====").append("\t").append("=====");

        stockMap.values().stream().forEach((_stock) -> {
            sb.append("\n");
            sb.append(_stock.getSymbol()).append("\t").append(df.format(_stock.getAskPrice()))
                    .append("\t").append(df.format(_stock.getBidPrice()))
                    .append("\t").append(_stock.getVolume()).append("\t")
                    .append(_stock.getState());
        });

        return sb.toString();
    }
}
