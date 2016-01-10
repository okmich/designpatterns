/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpattern.stockexchange;

/**
 *
 * @author m.enudi
 */
public abstract class Colleague {

    private final Mediator _mediator;
    private int _code;

    public Colleague(Mediator mediator) {
        this._mediator = mediator;
        register();
    }

    private void register() {
        this._mediator.register(this);
    }

    public void salesOffer(String symbol, int shares) {
        this._mediator.salesOffer(symbol, shares, this.getCode());
    }

    public void buyOffer(String symbol, int shares) {
        this._mediator.buyOffer(symbol, shares, this.getCode());
    }

    public void unregister() {
        this._mediator.unregister(this);
        System.out.println("Colleague " + this._code + " just signed out of the exchange");
    }

    /**
     * @return the _code
     */
    public int getCode() {
        return _code;
    }

    /**
     * @param _code the _code to set
     */
    public void setCode(int _code) {
        System.out.println("Colleague " + _code + " just signed in to the exchange");
        this._code = _code;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this._code;
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
        final Colleague other = (Colleague) obj;
        if (this._code != other._code) {
            return false;
        }
        return true;
    }

}
