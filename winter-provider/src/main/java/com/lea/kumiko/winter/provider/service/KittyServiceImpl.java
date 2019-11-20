package com.lea.kumiko.winter.provider.service;

import com.lea.kumiko.api.dto.Person;
import com.lea.kumiko.api.service.KittyService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class KittyServiceImpl implements KittyService {
    @Override
    public Person find() {

        return new Person();
    }
}
