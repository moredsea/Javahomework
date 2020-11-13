package Practice10_1;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


     class Main {

        private static Logger log = Logger.getLogger(Main.class.getName());
        private static FileHandler fh;

        public static void main(String[] args) {
            logMessages();

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