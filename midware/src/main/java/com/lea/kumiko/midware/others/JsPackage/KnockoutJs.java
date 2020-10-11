package com.lea.kumiko.midware.others.JsPackage;

import java.io.IOException;

public class KnockoutJs {

    public static final String knockoutJs = "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/editMyTeacher.jsp        /addressBook/toEditMyTeacher.do\n" +
            "src/main/webapp/WEB-INF/addressBook/myTeacher/myTeacherManager.jsp                  /addressBook/toAddressBook.do\n";


    public static void main(String[] args) throws IOException {
//        WriteJs.testString(knockoutJs);
        WriteJs.writeString("/js/knockout/knockout-3.4.0.js", knockoutJs);
    }

}
