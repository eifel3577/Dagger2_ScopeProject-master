package ru.startandroid.scopeproject;

import javax.inject.Singleton;

import dagger.Component;
import ru.startandroid.scopeproject.api.ApiModule;
import ru.startandroid.scopeproject.login.LoginActivityComponent;
import ru.startandroid.scopeproject.mail.MailComponent;
import ru.startandroid.scopeproject.mail.MailModule;

/**AppComponent - создается на все время работы приложения. Соответственно, объекты, которые он
 *  умеет создавать и которые имеют тот же scope, что и у него, будут синглтонами на протяжении
 *  жизни этого компонента. В данном примере - это класс по работе с сетью ApiService. */
@Singleton
@Component(modules = {ApiModule.class})
public interface AppComponent {

    LoginActivityComponent createLoginComponent();

    MailComponent createMailComponent(MailModule mailModule);
}
