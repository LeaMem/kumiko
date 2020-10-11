package com.lea.kumiko.midware.others.JsPackage;

import java.io.IOException;

public class KnoukoutCaseJs {

    public static final String knockOutCaseJs = "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/myTeacherManager.jsp     /addressBook/toAddressBook.do";

    public static void main(String[] args) throws IOException {
//        WriteJs.testString(knockOutCaseJs);
        WriteJs.writeString("/js/knockout/knockout-switch-case.min.js", knockOutCaseJs);
    }

}
