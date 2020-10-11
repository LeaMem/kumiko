package com.lea.kumiko.midware.others.JsPackage;

import java.io.IOException;

public class ValidateJs {

    public static final String validateJs = "src/main/webapp/WEB-INF/addressBook/myTeacher/editMyTeacher.jsp                                             /addressBook/toEditMyTeacher.do\n" +
            "src/main/webapp/WEB-INF/V2/courseContentPackage/addSelfDefineCourseContentPackage.jsp       /tra/courseContentPackage/toAddSelfDefineCourseContentPackage.do\n" +
            "src/main/webapp/WEB-INF/V2/courseContentPackage/addSelfDefineCourseContentPackage.jsp   /tra/courseContentPackage/toEditSelfDefineContentPackage.do\n" +
            "src/main/webapp/WEB-INF/addressBook/leads/leadsManage.jsp                  K20181127 废弃使用\n" +
            "src/main/webapp/WEB-INF/addressBook/leads/createLeads.jsp                           无\n" +
            "src/main/webapp/WEB-INF/addressBook/myTeacher/editCourseContentPrice.jsp                                /addressBook/toEditCourseContentPrice.do\n" +
            "src/main/webapp/WEB-INF/addressBook/liveLesson/liveLessonFormalVideoManage.jsp                                      /addressBook/liveLesson/moreLiveLessonVideoManage.do\n" +
            "src/main/webapp/WEB-INF/V2/coursemonitor/courseMonitorManager.jsp                                                   /courseMonitor/courseBehaviourMonitor/toCourseMonitorManager.do\n" +
            "src/main/webapp/WEB-INF/V2/trialLecture/lectureTaskConfig/lectureTaskConfigPage.jsp                             /trialLecture/lectureTask/toLectureTaskConfigPage.do\n" +
            "src/main/webapp/WEB-INF/addressBook/lectureinvite/lectureAuditManager.jsp                                       /addressBook/lectureAudit/addressBook/lectureinvite/lectureAuditManager.jsp\n" +
            "src/main/webapp/WEB-INF/V2/trialLecture/teachingTask/teachingTaskManager.jsp                                /trialLecture/teachingTask/toTeachingTaskManager.do\n" +
            "src/main/webapp/WEB-INF/addressBook/lectureinvite/lectureInviteManager.jsp                                      /addressBook/lectureInvite/toLectureInviteManager.do\n" +
            "src/main/webapp/WEB-INF/addressBook/lectureinvite/myOnlineLectureInviteManager.jsp                          /addressBook/lectureInvite/toMyOnlineLectureInviteManager.do\n" +
            "src/main/webapp/WEB-INF/addressBook/lectureinvite/onlineLectureInviteManager.jsp                            /addressBook/lectureInvite/toOnlineLectureInviteManager.do\n" +
            "src/main/webapp/WEB-INF/addressBook/liveLesson/liveLessonFormalVideoManage.jsp                                  /addressBook/liveLesson/moreLiveLessonVideoManage.do\n" +
            "src/main/webapp/WEB-INF/addressBook/liveLesson/liveLessonVideoManage.jsp                            /addressBook/liveLesson/liveLessonVideoManage.do\n" +
            "src/main/webapp/WEB-INF/addressBook/onlinegrouplesson/myOnlineGroupLessonManage.jsp                 /addressBook/onlineGroupLesson/myOnlineGroupLessonManage.do\n" +
            "src/main/webapp/WEB-INF/addressBook/onlinegrouplesson/onlineGroupLessonManage.jsp               /addressBook/onlineGroupLesson/onlineGroupLessonManage.do\n" +
            "src/main/webapp/WEB-INF/addressBook/searchTeacher/searchTeacherList.jsp                             /addressBook/searchTeacher/searchTeacher.do\n" +
            "src/main/webapp/WEB-INF/addressBook/searchTeacher/searchTeacherManage.jsp                           無\n" +
            "src/main/webapp/WEB-INF/addressBook/searchTeacher/searchTeacherV2Manage.jsp                     /addressBook/searchTeacher/toSearchTeacherManage.do\n" +
            "src/main/webapp/WEB-INF/addressBook/searchTeacher/searchTeacherV2Manage.jsp         /addressBook/searchTeacher/toSearchTeacherManageWithDemand.do\n" +
            "src/main/webapp/WEB-INF/addressBook/teachingtask/teachingTaskManager.jsp                        無\n" +
            "src/main/webapp/WEB-INF/addressBook/searchTeacher/searchTeacherV2Manage.jsp                                     /addressBook/searchTeacher/toSearchTeacherManage.do\n" +
            "src/main/webapp/WEB-INF/addressBook/searchTeacher/searchTeacherV2Manage.jsp       /addressBook/searchTeacher/toSearchTeacherManageWithDemand.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/lectureinvite/lectureAuditManager.jsp                                          /addressBook/lectureAudit/addressBook/lectureinvite/lectureAuditManager.jsp\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/lectureinvite/lectureAuditManager.jsp                              /addressBook/lectureAudit/addressBook/lectureinvite/lectureAuditManager.jsp\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/liveLesson/liveLessonFormalVideoManage.jsp                      /addressBook/liveLesson/moreLiveLessonVideoManage.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/liveLesson/liveLessonUnFormalVideoManage.jsp               /addressBook/liveLesson/moreUnLiveLessonVideoManage.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/liveLesson/liveLessonVideoManage.jsp                   /addressBook/liveLesson/liveLessonVideoManage.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/onlinegrouplesson/livecloudLessonManager.jsp                   /addressBook/onlineGroupLesson/toLiveCloudLessonManager.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/onlinegrouplesson/myOnlineGroupLessonManage.jsp                    /addressBook/onlineGroupLesson/myOnlineGroupLessonManage.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/onlinegrouplesson/onlineGroupLessonManage.jsp                  /addressBook/onlineGroupLesson/onlineGroupLessonManage.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/searchTeacher/searchTeacherManage.jsp                                      无\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/searchTeacher/searchTeacherV2Manage.jsp                        /addressBook/searchTeacher/toSearchTeacherManage.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/searchTeacher/searchTeacherV2Manage.jsp   /addressBook/searchTeacher/toSearchTeacherManageWithDemand.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/addStudentPoolChoose.jsp                             /addressBook/studentPoolV2/toStudentPoolChoose.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/enrollTeacherStudentPool.jsp                                 /addressBook/studentPoolV2/toEnrollTeacherStudentPool.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/enrollTeacherStudentPool.jsp    /addressBook/studentPoolV2/toEnrollTeacherStudentPoolWarn.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/myTeacherEnrollStudentPoolManage.jsp                     无\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/queryTeacherEnrollStudentPoolManage.jsp                          /addressBook/studentPoolV2/toQueryTeacherEnrollStudentPoolList.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/reAddStudentPool.jsp                                 /addressBook/studentPoolV2/toReAddStudentPool.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/reAddStudentPoolFromStudentSent.jsp                          /addressBook/studentPoolV2/toReAddStudentPoolFromStudentSent.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/receiverStudentPoolAcceptManage.jsp                          /addressBook/studentPoolV2/receiverStudentPoolManage.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/receiverStudentPoolManage.jsp                                        /addressBook/studentPoolV2/toReceiverStudentPoolManage.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/recommendEnrollTeacher.jsp                                       /addressBook/studentPoolV2/showRecommendTeacherDetail.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/studentPoolAcceptDetail.jsp                              /addressBook/studentPoolV2/showReceiverTeacherDetail.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/studentPoolAcceptManage.jsp              无\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/studentPoolAcceptManageV2.jsp    无\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/studentPoolDetail.jsp    /addressBook/studentPoolV2/studentPoolDetail.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/studentPoolManage.jsp                   無\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/studentSentStudentPoolManage.jsp         無\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/traStudentPoolManage.jsp             /addressBook/studentPoolV2/traStudentPoolManage.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/editMyTeacher.jsp                            /addressBook/toEditMyTeacher.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/V2/cWEB-INF/addressBook/myTeacher/editMyTeacher.jsp                    /addressBook/toEditMyTeacher.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/V2/courseContentPackage/courseContentPackageApplyManage.jsp    /tra/courseContentPackage/courseContentPackageApplyManage.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/V2/courseContentPackage/editCourseContentPackage.jsp               /tra/courseContentPackage/toEditContentPackage.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/V2/courseContentPackage/editOutline.jsp                            /tra/courseContentPackage/outlineList.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/V2/courseContentPackage/flagPayedMain.jsp                              /tra/courseContentPackage/toFlagPayedMain.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/V2/courseContentPackage/flagUnpayedMain.jsp                        /tra/courseContentPackage/toUnFlagPayedMain.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/V2/courseContentPackage/toEditOutline.jsp                  /tra/courseContentPackage/toEditOutline.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/V2/courseContentPackage/verifyCourseContentPackage.jsp                 /tra/courseContentPackage/toVerifyContentPackage.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/V2/courseContentPackage/verifyOfficialCourseContentPackage.jsp     /tra/courseContentPackage/toVerifyContentPackage.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/V2/courseContentPackage/viewOutline.jsp                    /tra/courseContentPackage/viewOutline.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/setShareRate.jsp       /addressBook/toSetShareRate.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/addTeacherCourse.jsp                     /addressBook/toAddTeacherCourse.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/addTeacherGroupCourse.jsp                  /addressBook/toAddTeacherGroupCourse.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/deteleTeacherCourse.jsp                  /addressBook/toDeteleTeacherCourse.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/deteleTeacherGroupCourse.jsp                              /addressBook/toDeteleTeacherGroupCourse.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/editOfficialCourseContentPrice.jsp                           /addressBook/toEditOfficialCourseContentPrice.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/editTeacherCourse.jsp                            /addressBook/toEditTeacherCourse.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/editTeacherGroupCourse.jsp                    /addressBook/toEditTeacherGroupCourse.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/communicate/applyTeacherAppointment.jsp              /addressBook/toApplyInterviewMyTeacher.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/communicate/commonEditTeacherCommunicate.jsp                     /addressBook/toAddCommunicate.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/communicate/operateTeacherAppointment.jsp                        /addressBook/toOperateTeacherAppointment.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/teacherCourseInfoApply/editTeacherCourseApply.jsp                    /addressBook/toEditTeacherCourseInfoApply.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/closeStudentPool.jsp                  /addressBook/studentPoolV2/toCloseStudentPool.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/addressBook/studentPoolV2/studentPoolBlacklist.jsp                     /addressBook/studentPoolV2/toBlacklist.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/customer/batchHandle/createUser.jsp                            /addressBook/preCreateLeads.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/customer/mycustomer/customerRemarkEdit.jsp                             /crCustomer/toCustomerEditRemark.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/customer/mycustomer/customerRemarkEditForTag.jsp           /customer/toCustomerEditRemark.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/tadStat/workPlatform/addTeacherCommunication.jsp                  /workPlatform/taskAddCommunication.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/tadStat/workPlatform/viewTeacherCommunication.jsp                  /workPlatform/viewTaskDetails.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/V2/map/searchTeacherMapPage.jsp                /findTeacherMap/toSearchTeacherMapPage.do\n" +
            "ta-admin/src/main/webapp/WEB-INF/V2/map/searchTeacherMapPage.jsp     /findTeacherMap/toSearchTeacherMapPageV2.do\n";

    public static void main(String[] args) throws IOException {
//        WriteJs.testString(validateJs);
        WriteJs.writeString("/js/jquery.validate.js", validateJs);
    }

}
