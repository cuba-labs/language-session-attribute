# Custom session attribute demo

We can add session attributes using the application event listener of AuthenticationSuccessEvent:
```
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
```

Then we will be able to query entities by the active user session language using session attributes:
```
select e from sec$User e
where e.language = :session$language
``` 

