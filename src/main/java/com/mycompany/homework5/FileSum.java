/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homework5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Seregi
 */
public class FileSum {
    private String path1;
    private String path2;

    public FileSum(String path1, String path2) {
        this.path1 = path1;
        this.path2 = path2;
    }
    
    public static void sumFile (String path1, String path2) throws IOException{
            FileInputStream fis = new FileInputStream(path2);
            FileOutputStream fos = new FileOutputStream(path1, true);
            byte[] data = new byte[fis.available()];
            fis.read(data);
            fis.close();
            fos.write(data);
            fos.close();
    }
}
