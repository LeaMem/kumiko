package com.lea.kumiko.winter.provider.service;

import com.lea.kumiko.api.dto.Person;
import com.lea.kumiko.api.service.PersonService;
import org.apache.dubbo.config.annotation.Service;

@Service(group = "secondary")
public class PersonSecondaryServiceImpl implements PersonService {

    @Override
    public Person getOne() {
        Person person = new Person();
        person.setName("secondary");
        person.setAge(33);
        return person;
    }
}
