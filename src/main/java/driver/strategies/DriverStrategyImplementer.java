package driver.strategies;

import utils.Constans;

public class DriverStrategyImplementer {
    public static DriverStrategy chooseStrategy(String strategy){
        switch(strategy){
            case Constans.CHROME:
                return new Chrome();

            case Constans.PHANTOMJS:
                return new PhantomJS();

            default:
                return null;
        }

    }
}
