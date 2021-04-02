package io.dolphin.service.impl;

import io.dolphin.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2021-4-2 8:08
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello "+name;
    }
}
