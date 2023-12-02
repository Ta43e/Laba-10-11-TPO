package service;

import model.User;

public class UserCreator {
    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_CODE = "testdata.user.code";

    public static User WithCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME), TestDataReader.getTestData(TESTDATA_USER_CODE));
    }

}
