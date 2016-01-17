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
public interface OrderType extends Serializable {

    /**
     * BUY
     */
    int BUY = 0;
    /**
     * SELL
     */
    int SELL = 5;
}
