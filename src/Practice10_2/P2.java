package Practice10_2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


   class Main {

    private static Logger log = Logger.getLogger(Main.class.getName());
    private static FileHandler fh;

    public static void main(String[] args) {
//        logMessages();
        String path;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter path");
        while(true) {
            path = in.nextLine();
            File dir = new File(path);
            if (!dir.exists()) {
                System.out.println("Directory doesn't exist. Try again");
            } else {
                break;
            }
        }
        File dir = new File(path);
        System.out.print("Размер папки "+path+" составляет ");
        if(getFolderSize(dir)>1073741824){
            System.out.printf("%.1f", (float)getFolderSize(dir)/1073741824);
            System.out.print(" ГБ");
        } else if(getFolderSize(dir)>1048576){
            System.out.printf("%.1f", (float)getFolderSize(dir)/1048576);
            System.out.print(" МБ");
        }else if(getFolderSize(dir)>1024){
            System.out.printf("%.1f", (float)getFolderSize(dir)/1024);
            System.out.print(" КБ");
        }else{
            System.out.printf(getFolderSize(dir) + " Б");
        }

    }

    private static long getFolderSize(File folder) {
        long length = 0;
        File[]files = folder.listFiles();

        int count = files.length;

        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            }
            else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }

    public static void logMessages() {
        File dir = new File("papka");
        if(!dir.exists()){
            if (dir.mkdir()) {
                System.out.println("Directory is created");
            }
            else {
                System.out.println("Directory cannot be created");
            }
        } else {
            System.out.println("Directory already exists");
        }
        File file = new File(dir, "log.txt");
        if(!file.exists()){
            try
            {
                boolean created = file.createNewFile();
                if(created)
                    System.out.println("File has been created");
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("File already exists");
        }

        try {
            fh = new FileHandler(file.getPath(), true);
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            log.info("Something...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("jjjjjj");
    }

}