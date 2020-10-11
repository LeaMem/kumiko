package com.lea.kumiko.midware.others.JsPackage;

import java.io.IOException;

public class ViewJs {

    public static final String viewJs = "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/teachingtask/teachingTask.jsp                /addressBook/teachingtask/qureyTeachingTask.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/customer/classFeedback/classFeedbackDetail.jsp                     /course/toClassFeedbackDetail.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/tadStat/workPlatform/viewStudentCommunication.jsp          /workPlatform/viewTaskDetails.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/customer/customerInfoMaintain/customerBaseInfoMaintain.jsp                 /customer/customerInfoMaintain.do";

    public static void main(String[] args) throws IOException {
//        WriteJs.testString(viewJs);
        WriteJs.writeString("/js/viewer/viewer.min.js", viewJs);
    }

}
