package com.example.login13.component;

import com.example.login13.module.HttpModule;
import com.example.login13.ui.activity.LoginActivity;
import com.example.login13.ui.activity.PersonInfoActivity;
import com.example.login13.ui.activity.RegActivity;
import dagger.Component;

/**
 * Created   by    Dewey
 * 作为桥梁，沟通调用者和依赖对象库
 */
@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(LoginActivity loginActivity);

    void inject(RegActivity regActivity);

    void inject(PersonInfoActivity personInfoActivity);
}
