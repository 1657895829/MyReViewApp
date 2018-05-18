package com.example.newframe_09.component;

import com.example.newframe_09.MainActivity;
import com.example.newframe_09.module.HttpModule;
import dagger.Component;

/**
 * Created by Dewey on  2018/05/18  星期五.
 * 站在顶峰，看世界
 * 落在谷底，思人生
 * 沟通部分Component
 * @Component:作为桥梁，注入对象的通道。
 */

@Component(modules = HttpModule.class)       //作为桥梁，沟通调用者和依赖对象库
public interface HttpComponent {

    void inject(MainActivity mainActivity);  //注入对象到MainActivity中
}
