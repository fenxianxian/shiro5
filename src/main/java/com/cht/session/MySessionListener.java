package com.cht.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;

public class MySessionListener extends SessionListenerAdapter {
    //session创建时触发
    @Override
    public void onStart(Session session) {
        System.out.println("session create");
    }
    //session停止时触发   session.logout()  session.stop()
    @Override
    public void onStop(Session session) {
        System.out.println("session stop");
    }
    //session过期时触发，静默时间超过过期时间
    //但注意它不会主动告知已过期，而是当你再一次访问的时候，它才会去校验是否过期，如果过期，就触发
    @Override
    public void onExpiration(Session session) {
        System.out.println("session expire");
    }
}
