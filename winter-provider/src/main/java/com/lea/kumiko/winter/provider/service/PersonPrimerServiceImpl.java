package com.lea.kumiko.winter.provider.service;

import com.lea.kumiko.api.dto.Person;
import com.lea.kumiko.api.service.PersonService;
import org.apache.dubbo.config.annotation.Service;

import java.util.HashMap;
import java.util.Map;

@Service(group = "primary")
public class PersonPrimerServiceImpl implements PersonService {

    @Override
    public Person getOne() {
        Person person = new Person();
        person.setAge(26);
        person.setName("dingding");
        return person;
    }


    public static void main(String[] args) throws InterruptedException {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < 10; i++){
            map.put(i, i + 1);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(Integer key : map.keySet()){
                    System.out.println(key);
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(1000L);
        map.remove(3);


    }
}
