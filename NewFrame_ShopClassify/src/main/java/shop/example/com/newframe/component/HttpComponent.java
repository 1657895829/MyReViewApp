package shop.example.com.newframe.component;

import dagger.Component;
import shop.example.com.newframe.MainActivity;
import shop.example.com.newframe.module.HttpModule;

/**
 * 沟通部分Component
 * @Component:作为桥梁，注入对象的通道。
 */
@Component(modules = HttpModule.class)                // 作为桥梁，沟通调用者和依赖对象库
public interface HttpComponent {
    void inject(MainActivity mainActivity);           //注入对象到MainActivity中
}
