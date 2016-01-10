
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.okmich.designpattern.stockexchange.Colleague;
import com.okmich.designpattern.stockexchange.FirstBroker;
import com.okmich.designpattern.stockexchange.Mediator;
import com.okmich.designpattern.stockexchange.SecondBroker;
import com.okmich.designpattern.stockexchange.StockMediator;
import com.okmich.designpattern.stockexchange.ThirdBroker;

/**
 * This is a demonstration of a Mediator Design pattern. The case scenario is an
 * exchange with about 3 brokers who know nothing about themselves.
 *
 * The brokers only sign up to the Exchange - the mediator who then coordinates
 * interaction between parties (brokers) that don't reference each other.
 *
 * The Mediator can handles as many brokers that sign in and pass stocks sales
 * and purchase among them.
 *
 * Other patterns used here include
 * <ul>
 * <li>Observer Design Pattern</li>
 * </ul>
 *
 * @author Michael Enudi
 */
public class Main {

    public static void main(String[] args) {
        Mediator exchange = new StockMediator();

        Colleague firstBroker = new FirstBroker(exchange);
        Colleague secondBroker = new SecondBroker(exchange);
        Colleague thirdBroker = new ThirdBroker(exchange);

        System.out.println("++++++++++++++++ trading begins ++++++++++++++++++++++++++");
        //begin trading
        firstBroker.salesOffer("MSFT", 100);
        firstBroker.salesOffer("GOOG", 30);
        firstBroker.buyOffer("APPL", 120);

        secondBroker.buyOffer("MSFT", 100);
        secondBroker.salesOffer("APPL", 120);
        secondBroker.buyOffer("ORCL", 70);

        thirdBroker.buyOffer("GOOG", 30);
        thirdBroker.salesOffer("GOOG", 30);
        thirdBroker.salesOffer("MSFT", 10);

        System.out.println("++++++++++++++++ trading ends ++++++++++++++++++++++++++");

        //show the remain stock offering
        exchange.getStockOffering();

        System.out.println("++++++++++++++++ brokers exit ++++++++++++++++++++++++++");
        //close for the day
        firstBroker.unregister();
        secondBroker.unregister();
        thirdBroker.unregister();

    }
}
