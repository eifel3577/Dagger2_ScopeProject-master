package ru.startandroid.scopeproject.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import javax.inject.Inject;

import ru.startandroid.scopeproject.App;
import ru.startandroid.scopeproject.R;
import ru.startandroid.scopeproject.datatype.Account;
import ru.startandroid.scopeproject.folders.FolderListActivity;

public class LoginActivity extends AppCompatActivity {

    /**получаем презентер для работы.Он предоставляется компонентом LoginActivityComponent */
    @Inject
    LoginActivityPresenter presenter;

    EditText userEditText;
    EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /**получаем LoginActivityComponent.Для этого вызываем инстанс апп класса,с помощью него создаем AppComponent,а у него 
        запрашиваем создание LoginActivityComponent.Поскольку мы создаем LoginActivityComponent в onCreate() LoginActivity,то 
        время жизни (скоуп) этого компонента будет такое же как время жизни этого активити.Это подчеркивается названием скоупа
        ActivityScope*/
        LoginActivityComponent loginActivityComponent = App.getInstance().getAppComponent().createLoginComponent();

        loginActivityComponent.injectLoginActivity(this);

        userEditText = (EditText)findViewById(R.id.user);
        passwordEditText = (EditText)findViewById(R.id.password);

        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login(userEditText.getText().toString(), passwordEditText.getText().toString());
            }
        });
    }

    void showMailForAccount(Account account) {
        App.getInstance().createMailComponent(account);
        startActivity(new Intent(this, FolderListActivity.class));
    }

    @Inject
    void setActivity() {
        presenter.setActivity(this);
    }
}
