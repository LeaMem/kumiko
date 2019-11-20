package com.lea.kumiko.winter.provider.service;

import com.lea.kumiko.api.dto.Person;
import com.lea.kumiko.api.service.PersonService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public Person getOne() {
        Person person = new Person();
        person.setAge(26);
        person.setName("dingding");
        return person;
    }
}
