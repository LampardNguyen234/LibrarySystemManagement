/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author lampard
 */
public class LibrarySystemManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //SupportFunctions.restoreData();
        String filePath = System.getProperty("user.dir");
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String file = filePath + "\\Data\\mysql"+ timeStamp+".sql";
        System.out.println(file);
        Process p = null;
        try {
            p = Runtime.getRuntime().exec("cmd /c mysqldump -uroot -p123456 datalibrary > " + file);
//change the dbpass and dbname with your dbpass and dbname
            int processComplete = p.waitFor();
            if (processComplete == 0) {
                System.out.println("Backup created successfully!");
            } else {
                System.out.println("Could not create the backup");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
