package com.company.demo.core;

import com.haulmont.cuba.security.auth.events.AuthenticationSuccessEvent;
import com.haulmont.cuba.security.global.UserSession;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AuthenticationSuccessEventListener
        implements ApplicationListener<AuthenticationSuccessEvent> {
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        UserSession session = event.getAuthenticationDetails().getSession();

        Locale locale = session.getLocale();
        session.setAttribute("language", locale.toLanguageTag());
    }
}