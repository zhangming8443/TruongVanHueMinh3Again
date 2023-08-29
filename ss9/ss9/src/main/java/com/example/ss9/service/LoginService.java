package com.example.ss9.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoginService implements ILoginService{


    @Override
    public String checkDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
