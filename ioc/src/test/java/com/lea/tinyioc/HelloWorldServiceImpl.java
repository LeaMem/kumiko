package com.lea.tinyioc;

public class HelloWorldServiceImpl implements HelloWorldService {

    private String text;

    private OutputService outputService;

    @Override
    public void runAway() {
        System.out.println("kitty");
    }

    @Override
    public void helloWorld() {
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
