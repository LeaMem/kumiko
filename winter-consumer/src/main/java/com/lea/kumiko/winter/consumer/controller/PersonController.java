package com.lea.kumiko.winter.consumer.controller;

import com.lea.kumiko.api.dto.Person;
import com.lea.kumiko.api.service.PersonService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.zookeeper.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PersonController {

    @Reference(group = "primary")
    PersonService personService;

    @RequestMapping(value = "findOne")
    public Person findOne(){
        return personService.getOne();
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.40.13:2181", 1000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
        zooKeeper.addAuthInfo("digest","leamem:WhiteWinter".getBytes());
        String s = zooKeeper.create("/ss", "kitty".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        System.out.println(s);
    }

}

