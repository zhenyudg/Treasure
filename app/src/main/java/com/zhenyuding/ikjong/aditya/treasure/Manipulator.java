package com.zhenyuding.ikjong.aditya.treasure;

import java.util.Scanner;
public class Manipulator {
    public static void main(String[] args) {

        boolean doAgain=true;
        do {
            Scanner Aditya = new Scanner(System.in);
            System.out.println("Please enter the OCR Results: ");
            String fullString = Aditya.nextLine();
//        String fullString="Aditya Sharma  Purdue University  Software Engineer  sharm280@purdue.edu  765-237-7231  306, Tarkington Hall, 1165 W Stadium Drive";
            String spliting[] = fullString.split(" " +
                    " ");

            String email = "";
            String phonenumber = "";
            String uniorCompany = "";
            String address = "";
            String position = "";
            String name = "";
            for (int i = 0; i < spliting.length; i++) {
                if (spliting[i].contains("@")) {
                    email = spliting[i];
                }
                if (((int) spliting[i].charAt(0) >= 48 && (int) spliting[i].charAt(0) <= 57) && ((int) spliting[i].charAt(spliting[i].length() - 1) >= 47 && (int) spliting[i].charAt(spliting[i].length() - 1) <= 57)) {
                    phonenumber = spliting[i];
                }
                if (spliting[i].contains("Inc.") || spliting[i].contains("University") || spliting[i].contains("Corporation") || spliting[i].contains("L.L.C") || spliting[i].contains("Trading") || spliting[i].contains("Institute") || spliting[i].contains("College")) {
                    uniorCompany = spliting[i];
                }
                if (((int) spliting[i].charAt(0) >= 47 && (int) spliting[i].charAt(0) <= 57) && (((int) spliting[i].charAt(spliting[i].length() - 1) >= 97) && (int) spliting[i].charAt(spliting[i].length() - 1) <= 122)) {
                    address = spliting[i];
                }
                if (spliting[i].contains("Manager") || spliting[i].contains("Engineer") || spliting[i].contains("Software") || spliting[i].contains("Officer") || spliting[i].contains("Teacher") || spliting[i].contains("Professor")) {
                    position = spliting[i];
                }
                if ((int) spliting[i].charAt(0) >= 65 && (int) spliting[i].charAt(0) <= 90 && (!(spliting[i].contains("Engineer"))) && (!(spliting[i].contains("University"))) && (!(spliting[i].contains(("Corporation"))))) {
//                boolean naming=true;
//                for(int j=0;j<spliting[i].length();j++)
//                {
//                    if((int)spliting[i].charAt(j)<=40)
//                    {
//                        naming=false;
//                    }
//                }
//                if(naming)
//                {
                    name = spliting[i];
//                }
                }
            }
            System.out.println("Before manipulating the string:");
            System.out.println(fullString);
            System.out.println();
            System.out.println("After manipulating the string: ");
            System.out.println("Name: " + name);
            System.out.println("University/Company: " + uniorCompany);
            System.out.println("Position: " + position);
            System.out.println("Email: " + email);
            System.out.println("Phone Number: " + phonenumber);
            System.out.println("Address: " + address);

            System.out.println();
            System.out.println("Do you want to enter another profile?(yes/no)");
            String reply = Aditya.nextLine().toLowerCase();
            if (reply.equals("yes")) {
                doAgain = true;
            }else
            {
                doAgain=false;
            }
        }while(doAgain);
        System.out.println("Thanks for using Treasure!");

    }
}
