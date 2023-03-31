/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.homework5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Seregi
 */
public class Homework5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Работу выполнил Кузьмин Сергей Александрович, РИБО-01-21, вариант 1");
        System.out.println("Введите количество файлов для склейки: ");
        int fileNum;
        try{
            fileNum = scan.nextInt();
            String path;
            ArrayList<String> newPath = new ArrayList<>();
            ArrayList<String> pathes = new ArrayList<>();
            for (int i=0; i<fileNum; i++){
                System.out.println("Введите путь к файлу, используя // в качестве разделителя: ");
                path = scan.next();
                try{
                    if (i==0){
                        for (String j: path.split("//")){
                            newPath.add(j);
                        }
                        newPath.remove(newPath.size()-1);
                        newPath.add("sumariseFiles.txt");
                        File file = new File(String.join("//", newPath));
                        pathes.add(String.join("//", newPath));
                        pathes.add(path);
                        FileSum.sumFile(pathes.get(0), pathes.get(1));
                    }else{
                        pathes.add(path);
                        FileSum.sumFile(pathes.get(0), pathes.get(i+1));
                    }
                }catch(IOException ex){
                    System.out.println("Указанного файла не существует! Попробуйте снова");
                    break;
                }
            }
        }catch(InputMismatchException ex){
            System.out.println("Неправильный тип данных! Попробуйте еще раз");
        }
    }
}
