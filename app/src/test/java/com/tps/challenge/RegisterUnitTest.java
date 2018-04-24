package com.tps.challenge;

import com.tps.challenge.Utilities.CommonUtils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Abdullah on 4/21/2018.
 */

public class RegisterUnitTest {
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

    @Test
    public void IsValidPhoneTest() {
        String[] password = new String[]{
                "+60 12 345 6789", "011 2721 8012","0111 123 4567","01111234567","+601111234567"};
        for (String temp : password) {
            boolean valid = CommonUtils.isPhoneValid(temp);
            System.out.println("Phone is valid : " + temp + " , " + valid);
            Assert.assertEquals(valid, valid);
        }
    }
}
