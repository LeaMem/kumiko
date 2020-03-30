package com.lea.leet.design.Decorator;


import com.lea.leet.alg.Solution1078;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bird extends Change {

    public Bird(GreatSage sage) {
        super(sage);
    }

    @Override
    void move() {
        System.out.println("Bird Move");
    }

    public static void main(String[] args) {

        GreatSage sage = new Monkey();

        sage.move();

        GreatSage flower = new Flower(sage);
        flower.move();

        GreatSage bird = new Bird(flower);
        bird.move();

        String path = "D:\\Projects\\IdeaProjects\\lost-butterfly\\file\\basemap\\2020-03-16\\途径一片静美.jpg";

        File file = new File(path);

        String[] split = path.split("[\\\\/]");

        System.out.println(split[split.length - 1]);


        Pattern pattern = Pattern.compile("file(.*)");
        Matcher matcher = pattern.matcher(path);
        if(matcher.find()){
            System.out.println(matcher.group(1));
        }
        System.out.println(matcher.find());

        System.out.println(file.getName());

    }

}
