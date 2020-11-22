package com.github.shiwenwy.bedpoddemo.ability;

import com.github.shiwen.bedpod.common.annotations.AbilityService;
import com.github.shiwen.demo.sdk.openability.DemoAbility;
import org.springframework.stereotype.Service;

/**
 * @author shiwen.wy
 * @date 2020/11/22 11:27 上午
 */
@Service
@AbilityService("demoAbility")
public class DemoAbilityImpl implements DemoAbility {
    @Override
    public String doSomething(String s) {
        return s + " doSomething in DemoAbility";
    }
}
