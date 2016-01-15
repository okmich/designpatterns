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
public abstract class Order implements Serializable {

    private final int ticketId;
    private String symbol;
    private float price;
    private int units;
    private OrderType orderType;

    protected Order(int id) {
        this.ticketId = id;
    }

    /**
     *
     * @param exchange
     * @throws Exception
     */
    abstract void execute(Exchange exchange) throws Exception;

    /**
     * @return the ticketId
     */
    int getTicketId() {
        return ticketId;
    }

    /**
     * @return the symbol
     */
    String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol the symbol to set
     */
    void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the price
     */
    float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the units
     */
    int getUnits() {
        return units;
    }

    /**
     * @param units the units to set
     */
    void setUnits(int units) {
        this.units = units;
    }

    /**
     * @return the orderType
     */
    OrderType getOrderType() {
        return orderType;
    }
}
