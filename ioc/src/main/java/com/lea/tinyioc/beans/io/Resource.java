package com.lea.tinyioc.beans.io;

import java.io.InputStream;

/**
 *  Resource 是 Spring 内部定位资源的接口
 */
public interface Resource {

    InputStream getInputStream() throws Exception;

}
