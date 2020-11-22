package com.github.shiwenwy.demo.impl;

import com.github.shiwen.bedpod.common.annotations.AbilityReference;
import com.github.shiwen.bedpod.common.annotations.Extension;
import com.github.shiwen.demo.sdk.api.DemoExtPoint;
import com.github.shiwen.demo.sdk.openability.DemoAbility;

/**
 * @author shiwen.wy
 * @date 2020/11/22 11:33 上午
 */
@Extension("demo")
public class DemoExtPointImpl implements DemoExtPoint {

    @AbilityReference("demoAbility")
    private DemoAbility demoAbility;

    public String sayHello(String s) {
        return s +" say hello in demo extPoint and " + demoAbility.doSomething(s);
    }
}
