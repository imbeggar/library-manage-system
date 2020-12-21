package com.tlshzp.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener("CountLitsener")
public class CountLitsener implements HttpSessionListener {
    private static int counter = 0;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        counter++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        if (counter > 0) counter--;
    }

    public static int getActiveNumber(){
        return counter;
    }
}
