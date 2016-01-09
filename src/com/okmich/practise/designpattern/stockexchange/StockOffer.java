/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.practise.designpattern.stockexchange;

import java.util.Objects;

/**
 *
 * @author m.enudi
 */
public class StockOffer {

    private int stockShare = 0;
    private String stockSymbol = "";
    private int colleagueCode = 0;

    public StockOffer() {
    }

    /**
     *
     * @param _stockShare
     * @param _stockSymbol
     * @param collCode
     */
    public StockOffer(int _stockShare, String _stockSymbol, int collCode) {
        this.stockShare = _stockShare;
        this.stockSymbol = _stockSymbol;
        this.colleagueCode = collCode;
    }

    /**
     * @return the stockShare
     */
    public int getStockShare() {
        return stockShare;
    }

    /**
     * @param stockShare the stockShare to set
     */
    public void setStockShare(int stockShare) {
        this.stockShare = stockShare;
    }

    /**
     * @return the stockSymbol
     */
    public String getStockSymbol() {
        return stockSymbol;
    }

    /**
     * @param stockSymbol the stockSymbol to set
     */
    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    /**
     * @return the colleagueCode
     */
    public int getColleagueCode() {
        return colleagueCode;
    }

    /**
     * @param colleagueCode the colleagueCode to set
     */
    public void setColleagueCode(int colleagueCode) {
        this.colleagueCode = colleagueCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.stockShare;
        hash = 71 * hash + Objects.hashCode(this.stockSymbol);
        hash = 71 * hash + this.colleagueCode;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StockOffer other = (StockOffer) obj;
        return true;
    }

    @Override
    public String toString() {
        return "StockOffer{" + "stockShare=" + stockShare + ", stockSymbol=" + stockSymbol + ", colleagueCode=" + colleagueCode + "}";
    }

}
