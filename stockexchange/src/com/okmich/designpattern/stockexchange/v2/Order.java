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
public interface Order extends Serializable {

    /**
     * @return the ticketId
     */
    public long getTicketId();

    /**
     * @return the symbol
     */
    public String getSymbol();

    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol);

    /**
     * @return the price
     */
    public float getPrice();

    /**
     * @param price the price to set
     */
    public void setPrice(float price);

    /**
     * @return the units
     */
    public int getUnits();

    /**
     * @param units the units to set
     */
    public void setUnits(int units);

    /**
     * @return the orderType
     */
    public int getOrderType();

    /**
     * @return the brokerId
     */
    public String getBrokerId();

    /**
     * @return the brokerName
     */
    public String getBrokerName();
}
