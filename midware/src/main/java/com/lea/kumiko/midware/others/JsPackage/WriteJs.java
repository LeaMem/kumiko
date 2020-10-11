package com.lea.kumiko.midware.others.JsPackage;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteJs {

    public static void main(String[] args) throws IOException {

        String myString = "src/main/webapp/WEB-INF/V2/bigBackstageSales/performanceTarget.jsp                                                  /bigBackstageSales/toPerformanceTarget.do\n" +
                "src/main/webapp/WEB-INF/addressBook/myTeacher/editMyTeacher.jsp                                             /addressBook/toEditMyTeacher.do\n" +
                "src/main/webapp/WEB-INF/V2/courseContentPackage/addSelfDefineCourseContentPackage.jsp       /tra/courseContentPackage/toAddSelfDefineCourseContentPackage.do\n" +
                "src/main/webapp/WEB-INF/V2/courseContentPackage/addSelfDefineCourseContentPackage.jsp /tra/courseContentPackage/toEditSelfDefineContentPackage.do\n" +
                "src/main/webapp/WEB-INF/mailbox/schoolMasterMailBox.jsp                         /mailBox/schoolMasterMailBox.do\n" +
                "src/main/webapp/WEB-INF/tadStat/performanceTarget/performanceTarget.jsp                                             /tad/performance/toSetPerformanceTarget.do\n" +
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
                "ta-admin/src/main/webapp/WEB-INF/V2/groupChat/groupChatList.jsp                             /tra/groupChat/groupChatList.do\n" +
                "\n" +
                "ta-admin/src/main/webapp/WEB-INF/V2/groupChat/groupChatManage.jsp                   /tra/groupChat/groupChatManage.do\n" +
                "ta-admin/src/main/webapp/WEB-INF/V2/groupChat/groupChatMemberList.jsp               /tra/groupChat/groupChatMemberList.do\n" +
                "\n" +
                "ta-admin/src/main/webapp/WEB-INF/V2/groupChat/groupChatMemberManage.jsp                         /tra/groupChat/groupChatMemberManage.do\n" +
                "ta-admin/src/main/webapp/WEB-INF/trtmk/trTmkLeadsManage.jsp                             無\n" +
                "ta-admin/src/main/webapp/WEB-INF/V2/tmk/tmkleadsdetail/dispatchTaManager.jsp                    /salesLeads/toDispatchTaManager.do\n" +
                "ta-admin/src/main/webapp/WEB-INF/addressBook/importTeacherLeads.jsp                                     /addressBook/teacherLeads/preTobatchImportLeads.do\n" +
                "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/communicate/editTeacherCommunicate.jsp            /addressBook/toCommunicateMyTeacher.do\n" +
                "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/praiseHonor/editPraiseHonor.jsp               /addressBook/toEditPraiseHonor.do\n" +
                "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/praiseHonor/newPraiseHonor.jsp                    /addressBook/toNewPraiseHonor.do\n" +
                "ta-admin/src/main/webapp/WEB-INF/addressBook/myTeacher/teacherInfo/editTeacherHeadPic.jsp               /addressBook/toEditTeacherHeadPic.do\n" +
                "ta-admin/src/main/webapp/WEB-INF/complaints/complaintsDetailInfo.jsp                            /complaints/toComplaintsDetailInfo.do\n" +
                "ta-admin/src/main/webapp/WEB-INF/complaints/complaintsDetailInfo.jsp  /complaints/toComplaitsDetailFromWorkPlatForm.do\n" +
                "ta-admin/src/main/webapp/WEB-INF/set/setupData.jsp                                       /set/toSetupData.do\n" +
                "ta-admin/src/main/webapp/WEB-INF/traStat/communityOperation/selectTeacherManage.jsp                          /tra/communityOperation/toSelectTeacherMainPage.do\n" +
                "ta-admin/src/main/webapp/WEB-INF/V2/bigBackstageSales/cityTargetSetting.jsp                         /bigBackstageSales/toCityTargetSetting.do\n" +
                "ta-admin/src/main/webapp/WEB-INF/V2/taskcenter/createTaskDialog.jsp                                 /taTaskCenter/getCreateTaskDialog.do\n" +
                "ta-admin/src/main/webapp/WEB-INF/V2/tcsPerformance/toBatchImportPerformanceDialog.jsp               /tcs/performance_import/toBatchImportPerformanceDialog.do\n" +
                "ta-admin/src/main/webapp/WEB-INF/V2/tmkleads/importTmkLeads.jsp                                 /tmkLeads/preTobatchImportLeads.do\n";

        String path = "/Users/lea/Desktop/js整理.xlsx";
        Workbook wb = new XSSFWorkbook(new FileInputStream(path));

        Sheet sheet = wb.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        System.out.println(lastRowNum);

        Scanner scanner = new Scanner(myString);

        FileOutputStream fileInputStream=new FileOutputStream(path);  //获取d://test.xls,建立数据的输入通道

        String js = "/js/ajaxfileupload.js";

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.trim();

            if(StringUtils.isEmpty(line)){
                continue;
            }

            String[] split = line.split("\\s+");
            System.out.println(split[0]);
            System.out.println(split[1]);




            lastRowNum++;
            Row row = sheet.createRow(lastRowNum);
            Cell first = row.createCell(0);
            first.setCellValue(js);
            Cell second = row.createCell(1);
            second.setCellValue(split[0]);
            Cell third = row.createCell(2);
            third.setCellValue(split[1]);


        }
        scanner.close();

        wb.write(fileInputStream);
        wb.close();

    }

    public static void testString(String myString){
        Scanner scanner = new Scanner(myString);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.trim();

            if(StringUtils.isEmpty(line)){
                continue;
            }

            String[] split = line.split("\\s+");
            System.out.println(split[0]);
            System.out.println(split[1]);
        }

        scanner.close();

    }

    public static void writeString(String jsPath, String myString) throws IOException {
        String path = "/Users/lea/Desktop/js整理.xlsx";
        Workbook wb = new XSSFWorkbook(new FileInputStream(path));

        Sheet sheet = wb.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        System.out.println(lastRowNum);

        Scanner scanner = new Scanner(myString);

        FileOutputStream fileInputStream=new FileOutputStream(path);  //获取d://test.xls,建立数据的输入通道

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.trim();

            if(StringUtils.isEmpty(line)){
                continue;
            }

            String[] split = line.split("\\s+");
            System.out.println(split[0]);
            System.out.println(split[1]);




            lastRowNum++;
            Row row = sheet.createRow(lastRowNum);
            Cell first = row.createCell(0);
            first.setCellValue(jsPath);
            Cell second = row.createCell(1);
            second.setCellValue(split[0]);
            Cell third = row.createCell(2);
            third.setCellValue(split[1]);


        }
        scanner.close();

        wb.write(fileInputStream);
        wb.close();

    }

}
