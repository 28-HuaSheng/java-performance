package com.ibeetl.code.ch01.test;

import com.ibeetl.code.ch01.sample.Config;
import com.ibeetl.code.ch01.sample.User;

import java.util.HashMap;
import java.util.Map;

public class OutMemoryCase1  {

    public static Map<Long, User> map = new HashMap<>();
    public static long idBase = 0;
    public static Config config = new Config();

    public static void test() {
        config.setMax(1000);
        config.setSleep(100);
        for(int i=0;i<config.getMax();i++){
            User user = new User();
            user.setId((long)idBase);
            user.setName("user"+idBase);
            user.setDepartId((long)idBase);
            map.put(user.getId(),user);
            idBase++;
        }
    }

    public static void begin() throws InterruptedException{
        while(true){
            test();
            Thread.sleep(config.getSleep());
            System.out.println(config.getMessage()+idBase);
        }
    }

    public static void  main(String[] ags) throws InterruptedException {
        OutMemoryCase1 case1 = new OutMemoryCase1();
        case1.begin();
    }
}
