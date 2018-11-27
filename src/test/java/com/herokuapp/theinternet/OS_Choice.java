package com.herokuapp.theinternet;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OS_Choice {


    private static List<String> generateOSList() {
        List<String> oses = new ArrayList<>();
        oses.add(0, "Microsoft Windows");
        oses.add(1, "Linux");
        oses.add(2, "Unix");
        oses.add(3, "Mac OS X");
        oses.add(4, "Solaris");
        return oses;
    }

    public static void main(String[] args) {

        Random r = new Random();
        List<String> oses;
        oses= OS_Choice.generateOSList();


        //System.out.println("i picked " + oses.get(random));

        //System.out.println("Privet Kroka ! ");
        //String osResult = System.getProperty("os.name").toLowerCase();


        int counter = 100;
        while (counter != 0) {
            int random = r.nextInt(oses.size());


            counter -= 1;

            String osResult = oses.get((random)).toLowerCase();
            System.out.println("random picked ---> " + osResult);

            if (osResult.contains("mac") && osResult.contains("os x")) {
                System.out.println("It's mac!");
            } else if (osResult.contains("win") || osResult.contains("microsoft")) {
                System.out.println("It's a nightmare . Good luck working with that crap !");
            } else if (osResult.contains("nux")) {
                System.out.println("It's Linux");
            } else if (osResult.contains("unix")) {
                System.out.println("Unix!");
            } else {
                System.out.println("Unsupported file system");

            }
        }

    }
}
