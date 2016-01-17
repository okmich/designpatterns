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
public class OrderFactory {

    /**
     *
     * @param orderType
     * @return
     */
    static Order getOrder(int orderType, String brokerId, String brokerName) {
        ServerOrder serverOrder;
        switch (orderType) {
            case OrderType.BUY:
                serverOrder = new BuyOrder();
                break;
            case OrderType.SELL:
                serverOrder = new SellOrder();
                break;
            default:
                throw new IllegalArgumentException("unknown order type constant");
        }
        //set the broker
        serverOrder.setBrokerId(brokerId);
        serverOrder.setBrokerName(brokerName);

        return serverOrder;
    }

    static class BuyOrder extends ServerOrder {

        public BuyOrder() {
            super(System.currentTimeMillis());
        }

        @Override
        void execute(Exchange exchange, Stock stock) throws Exception {
            //apply the price from the market
            setPrice(stock.getBidPrice());
            System.out.printf("\texecuting a BUY order from %s for %s at %5.2f\n",
                    getBrokerName(), getSymbol(), getPrice());
            State state = State.getState(State.Direction.UP);
            stock.setState(state, getUnits());
            //add stock back to to the register
            exchange.getStockRegister().addStock(stock);
        }
    }

    static class SellOrder extends ServerOrder {

        public SellOrder() {
            super(System.currentTimeMillis());
        }

        @Override
        void execute(Exchange exchange, Stock stock) throws Exception {
            //apply the price from the market
            setPrice(stock.getAskPrice());
            System.out.printf("\t\texecuting a SELL order from %s for %s at %5.2f\n",
                    getBrokerName(), getSymbol(), getPrice());
            State state = State.getState(State.Direction.DOWN);
            stock.setState(state, getUnits());
            //add stock back to to the register
            exchange.getStockRegister().addStock(stock);
        }
    }
}
