/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpattern.stockexchange.v2;

/**
 *
 * @author m.enudi
 */
public abstract class ServerOrder implements Order {

    private long ticketId;
    private String symbol;
    private float price;
    private int units;
    private int orderType;
    private String brokerId;
    private String brokerName;

    /**
     *
     *
     * @param id
     */
    protected ServerOrder(long id) {
        this.ticketId = id;
    }

    /**
     *
     * @param exchange
     * @throws Exception
     */
    abstract void execute(Exchange exchange, Stock stock) throws Exception;

    /**
     * @return the ticketId
     */
    @Override
    public long getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId the ticketId to set
     */
    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * @return the symbol
     */
    @Override
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol the symbol to set
     */
    @Override
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the price
     */
    @Override
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the units
     */
    @Override
    public int getUnits() {
        return units;
    }

    /**
     * @param units the units to set
     */
    @Override
    public void setUnits(int units) {
        this.units = units;
    }

    /**
     * @return the orderType
     */
    @Override
    public int getOrderType() {
        return orderType;
    }

    /**
     * @param orderType the orderType to set
     */
    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    /**
     * @return the brokerId
     */
    public String getBrokerId() {
        return brokerId;
    }

    /**
     * @param brokerId the brokerId to set
     */
    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }

    /**
     * @return the brokerName
     */
    public String getBrokerName() {
        return brokerName;
    }

    /**
     * @param brokerName the brokerName to set
     */
    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }
}
