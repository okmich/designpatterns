/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpattern.stockexchange;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m.enudi
 */
public class StockMediator implements Mediator {

    private int colleagueCode = 0;
    private final List<Broker> colleagues;
    private final List<StockOffer> sellStockOffers;
    private final List<StockOffer> buyStockOffers;

    public StockMediator() {
        this.colleagues = new ArrayList<>();
        this.sellStockOffers = new ArrayList<>();
        this.buyStockOffers = new ArrayList<>();
    }

    @Override
    public void register(Broker colleague) {
        colleagueCode++;
        colleague.setCode(colleagueCode);
        colleagues.add(colleague);
    }

    @Override
    public void unregister(Broker colleague) {
        colleagues.remove(colleague);
    }

    @Override
    public void salesOffer(String symbol, int shares, int _code) {
        boolean sold = false;

        for (StockOffer offer : buyStockOffers) {
            if (offer.getStockShare() == shares && offer.getStockSymbol().equals(symbol)) {
                System.out.println("\t\t" + shares + " share of " + symbol + " sold to colleague "
                        + offer.getColleagueCode());

                sold = true;
                buyStockOffers.remove(offer);
                //break out of the loop to avoid double sell
                if (sold) {
                    break;
                }
            }
        }
        //if we couldn't sell, add to inventory
        if (!sold) {
            System.out.println("\t\t\t" + shares + " share of " + symbol
                    + " added to inventory");
            this.sellStockOffers.add(new StockOffer(shares, symbol, _code));
        }

    }

    @Override
    public void buyOffer(String symbol, int shares, int _code) {
        boolean bought = false;

        for (StockOffer offer : sellStockOffers) {
            if (offer.getStockShare() == shares && offer.getStockSymbol().equals(symbol)) {
                System.out.println("\t\t" + shares + " share of " + symbol + " bought by colleague "
                        + offer.getColleagueCode());

                bought = true;
                sellStockOffers.remove(offer);
                //break out of the loop to avoid double sell
                if (bought) {
                    break;
                }
            }
        }
        //if we couldn't sell, add to inventory
        if (!bought) {
            System.out.println("\t\t\t" + shares + " share of " + symbol
                    + " added to inventory");
            this.buyStockOffers.add(new StockOffer(shares, symbol, _code));
        }
    }

    @Override
    public void getStockOffering() {
        System.out.println("\nStocks for sale:");
        sellStockOffers.stream().forEach((offer) -> {
            System.out.println("\t" + offer);
        });

        System.out.println("\nStocks for buy:");
        buyStockOffers.stream().forEach((offer) -> {
            System.out.println("\t" + offer);
        });
    }
}
