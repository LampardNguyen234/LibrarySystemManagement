/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

/**
 *
 * @author Thành
 */
public class BarcodeGenerator {
    public static void Generate(String fileName, String Folder) {
        try {
            Barcode barcode = BarcodeFactory.createCode128(fileName);
            barcode.setBarHeight(70);
            barcode.setBarWidth(3);
            
            File imgFile = new File("src/Barcode/"+ Folder+ "/" +fileName + ".png");
            File imgFile2 = new File("build/classes/Barcode/"+ Folder+ "/" +fileName + ".png");
            //Write the bar code to PNG file
            BarcodeImageHandler.savePNG(barcode, imgFile);
            BarcodeImageHandler.savePNG(barcode, imgFile2);
            System.out.println("Barcode Generate Successfully!");
        } catch (OutputException ex) {
            Logger.getLogger(BarcodeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BarcodeException ex) {
            Logger.getLogger(BarcodeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
