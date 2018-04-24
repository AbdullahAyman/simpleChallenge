package com.tps.challenge;

import com.tps.challenge.Utilities.CommonUtils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Abdullah on 4/21/2018.
 */

public class LoginUnitTest {


    @Test
    public void IsValidPasswordTest() {
        String[] password = new String[]{
                "mChallenge#1", "2cha#2$"};
        for (String temp : password) {
            boolean valid = CommonUtils.isPasswordValid(temp);
            System.out.println("Password is valid : " + temp + " , " + valid);
            Assert.assertEquals(valid, valid);
        }
    }
    @Test
    public void IsValidEmailTest() {
        String[] password = new String[]{
                "asd@asd.com", "asd.asd@com","2cha#2$","  .  @  ",""};
        for (String temp : password) {
            boolean valid = CommonUtils.isEmailValid(temp);
            System.out.println("Email is valid : " + temp + " , " + valid);
            Assert.assertEquals(valid, valid);
        }
    }
}
