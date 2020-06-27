package com.example.expirationdateapp.login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    final static private String URL = "http://expapp.dothome.co.kr/Login.php";
    private Map<String, String> parameters;

    public LoginRequest(String userID, String userPassword, long userToken, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("user-token", Long.toString(userToken));
    }

    @Override
    public Map<String, String> getParams(){

        return parameters;
    }

}