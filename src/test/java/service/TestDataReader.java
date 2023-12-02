package service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("dev");

    private static String TESTDATA_AMOUNT_WITHDRAW = "testdata.amount.withdraw";

    public static String GetAmountWithdraw(String key){
        System.out.println(resourceBundle.getString(key));
        return resourceBundle.getString(key);
    }

    public static String GetAmountWithdraw(){
        return GetAmountWithdraw(TESTDATA_AMOUNT_WITHDRAW);
    }

    public static String getTestData(String key) {return resourceBundle.getString(key);}
}
