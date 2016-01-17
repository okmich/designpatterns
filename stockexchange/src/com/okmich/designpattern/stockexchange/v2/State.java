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
public abstract class State implements Serializable {

    /**
     * direction of the state - flat, up or down
     */
    protected Direction _direction;
    /**
     * creates a singleton instances for each state
     */
    private static final State bullish = new Bull();
    private static final State bearish = new Bear();
    private static final State flat = new Flat();

    protected State(Direction defaultDirection) {
        this._direction = defaultDirection;
    }

    /**
     *
     * @param owningStock
     * @param requestedVol
     */
    protected abstract void effect(Stock owningStock, int requestedVol);

    /**
     *
     * @return
     */
    public Direction getDirection() {
        return _direction;
    }

    @Override
    public String toString() {
        return _direction.name();
    }

    /**
     * factory for creating state.
     * <p>
     * the default state is flat and is returned if null is passed in as
     * parameter</p>
     *
     * @param direction
     * @return
     */
    public static State getState(Direction direction) {
        if (null != direction) {
            switch (direction) {
                case DOWN:
                    return bearish;
                case UP:
                    return bullish;
                default:
                    return flat;
            }
        }
        return flat;
    }

    /**
     *
     */
    public static enum Direction {

        UP, DOWN, FLAT
    }

    /**
     *
     */
    static final class Flat extends State {

        public Flat() {
            super(Direction.FLAT);
        }

        @Override
        protected void effect(Stock owningStock, int requestedVol) {
            //do nothing
        }

    }

    /**
     *
     */
    static final class Bull extends State {

        Bull() {
            super(Direction.UP);
        }

        @Override
        protected void effect(Stock owningStock, int requestedVol) {
            float newPrice = (owningStock.getBidPrice() * requestedVol)
                    / Math.abs(owningStock.getVolume());

            owningStock.setBidPrice(owningStock.getBidPrice() + newPrice);
            owningStock.setVolume(owningStock.getVolume() + requestedVol);
        }

    }

    /**
     *
     */
    static final class Bear extends State {

        Bear() {
            super(Direction.DOWN);
        }

        @Override
        protected void effect(Stock owningStock, int requestedVol) {
            float newPrice = (owningStock.getAskPrice() * requestedVol)
                    / Math.abs(owningStock.getVolume());

            owningStock.setAskPrice(owningStock.getAskPrice() - newPrice);
            owningStock.setVolume(owningStock.getVolume() - requestedVol);
        }
    }
}
