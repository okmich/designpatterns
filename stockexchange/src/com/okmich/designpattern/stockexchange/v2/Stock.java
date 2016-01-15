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
public class Stock implements Serializable {

    private String symbol;
    private float askPrice;
    private float bidPrice;
    private int volume;
    private State state;

    /**
     *
     * @param symbol
     */
    public Stock(String symbol) {
        this.symbol = symbol;
        this.state = State.getState(null);
    }

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the askPrice
     */
    public float getAskPrice() {
        return askPrice;
    }

    /**
     * @param askPrice the askPrice to set
     */
    public void setAskPrice(float askPrice) {
        this.askPrice = askPrice;
    }

    /**
     * @return the bidPrice
     */
    public float getBidPrice() {
        return bidPrice;
    }

    /**
     * @param bidPrice the bidPrice to set
     */
    public void setBidPrice(float bidPrice) {
        this.bidPrice = bidPrice;
    }

    /**
     * @return the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * @return the state
     */
    public State getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(State state) {
        this.state = state;
        //setting the new state will affect the pricing and direction
        this.state.effect(this);
    }
}