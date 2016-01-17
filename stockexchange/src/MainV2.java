import com.okmich.designpattern.stockexchange.v2.BarterExchange;
import com.okmich.designpattern.stockexchange.v2.broker.Broker;
import com.okmich.designpattern.stockexchange.v2.Exchange;
import com.okmich.designpattern.stockexchange.v2.broker.ExchangeBroker;

/**
 * The main class for version 2 of the stock exchange project
 *
 * @author Michael Enudi
 */
public class MainV2 {

    public static void main(String[] args) {
        Exchange exchange = new BarterExchange();
        //load some stocks to begin with
        initStocks(exchange);
        //print stock register
        System.out.println(exchange.getStockRegister());

        Broker firstBroker = new ExchangeBroker("Primier Stock Brokers", exchange);
        Broker abcBrokers = new ExchangeBroker("ABC Traders", exchange);
        Broker guruBrokers = new ExchangeBroker("Alpha Gurus", exchange);

        System.out.println("++++++++++++++++ trading begins ++++++++++++++++++++++++++");
        //begin trading
        firstBroker.salesOffer("MSFT", 100);
        firstBroker.salesOffer("GOOG", 30);
        firstBroker.buyOffer("APPL", 120);

        abcBrokers.buyOffer("MSFT", 100);
        abcBrokers.salesOffer("APPL", 120);
        abcBrokers.buyOffer("ORCL", 70);

        guruBrokers.buyOffer("GOOG", 30);
        guruBrokers.salesOffer("GOOG", 30);
        guruBrokers.salesOffer("MSFT", 10);
        guruBrokers.buyOffer("AMZN", 120);

        System.out.println("++++++++++++++++ trading ends ++++++++++++++++++++++++++");

        //show the remain stock offering
        System.out.println(exchange.getStockRegister());

        System.out.println("++++++++++++++++ brokers exit ++++++++++++++++++++++++++");
        //close for the day
        firstBroker.unregister();
        abcBrokers.unregister();
        guruBrokers.unregister();

    }

    private static void initStocks(Exchange exchange) {
        BarterExchange barterExchange = (BarterExchange) exchange;

        barterExchange.initStockRegister("AMZN", 9910, 115.5f);
        barterExchange.initStockRegister("APPL", 5000, 759.50f);
        barterExchange.initStockRegister("GOOG", 10000, 439.52f);
        barterExchange.initStockRegister("MSFT", 1200, 235.91f);
        barterExchange.initStockRegister("ORCL", 2222, 390.11f);
    }
}
