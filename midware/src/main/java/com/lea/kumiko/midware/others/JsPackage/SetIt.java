package com.lea.kumiko.midware.others.JsPackage;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.*;

public class SetIt {

    public static void main(String[] args) throws FileNotFoundException {




        String filePath = "/Users/lea/Desktop/整理的js/WdatePicker.txt";

        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))){


            while((line = reader.readLine()) != null){
                line = line.trim();
                if(line.endsWith(".js") || StringUtils.isEmpty(line)){
                    continue;
                }
                System.out.println(line);

            }

        }catch (Exception exception){
            exception.printStackTrace();
        }



    }

}
