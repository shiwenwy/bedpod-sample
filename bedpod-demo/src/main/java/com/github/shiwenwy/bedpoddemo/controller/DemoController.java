package com.github.shiwenwy.bedpoddemo.controller;

import com.github.shiwen.bedpod.core.ext.ExtensionLoaderFactory;
import com.github.shiwen.demo.sdk.api.DemoExtPoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiwen.wy
 * @date 2020/11/22 11:19 上午
 */
@RestController
public class DemoController {

    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public String say(String name){
        DemoExtPoint demo = getExtPoint("demo");
        return demo.sayHello(name);
    }

    private DemoExtPoint getExtPoint(String extId) {
        return ExtensionLoaderFactory.
            getExtensionLoader(DemoExtPoint.class).getExtension(extId);
    }
}
