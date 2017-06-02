package com.example.dthompson.daggertest;
/**
 * Created by dthompson on 6/2/17.
 */

import javax.inject.Inject;

public class NetworkApi {

    @Inject
    public NetworkApi(){
    }

    public boolean validateUser(String username, String password){
        if(username == null || username.length() == 0){
            return false;
        } else {
            return true;
        }
    }
}
