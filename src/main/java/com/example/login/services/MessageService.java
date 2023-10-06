package com.example.login.services;

import java.util.HashMap;
import java.util.Map;

public class MessageService {

    private int statusCode;
    private String message;
    private Map<String, Object> data;


    public MessageService(int statusCode, String message, Map<String, Object> data){
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public Map<String, Object> getMessage(){
        Map<String, Object> data = new HashMap<>();
        data.put("statusCode", this.statusCode);
        data.put("message", this.message);
        data.put("data", this.data);
        return data;
    }

}
