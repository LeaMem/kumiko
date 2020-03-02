package com.lea.tinyioc.beans.io;

import java.net.URL;

public class ResourceLoader {

    public Resource getResource(String location){
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resource = classLoader.getResource(location);
        return new UrlResource(resource);
    }

}
