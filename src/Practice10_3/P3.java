package Practice10_3;

import java.io.*;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class Main {

    private static Logger log = Logger.getLogger(Main.class.getName());
    private static FileHandler fh;

    public static void main(String[] args) {

        String path;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите путь к копируемой папке");
        while(true) {
            path = in.nextLine();
            File dir = new File(path);
            if (!dir.exists()) {
                System.out.println("Directory doesn't exist. Try again");
            } else {
                break;
            }
        }
        File srcFolder = new File(path);

        System.out.println("Введите путь к папке, в которую нужно скопировать файлы");
        while(true) {
            path = in.nextLine();
            File dir = new File(path);
            if (!dir.exists()) {
                System.out.println("Directory doesn't exist. Try again");
            } else {
                break;
            }
        }
        File destFolder= new File(path);

        try{
            copyFolder(srcFolder,destFolder);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void copyFolder(File src, File dest)
            throws IOException{

        if(src.isDirectory()){

            if(!dest.exists()){
                dest.mkdir();
            }

            String files[]= src.list();

            for (String file : files) {
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                copyFolder(srcFile,destFile);
            }

        }else{
            FileInputStream in = new FileInputStream(src);
            FileOutputStream out = new FileOutputStream(dest);

            byte[]buffer = new byte[1024];

            int length;

            while ((length = in.read(buffer)) > 0){
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
        }
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