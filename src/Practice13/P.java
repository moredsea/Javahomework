package Practice13;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

class JThread extends Thread {

    File[] files;

    JThread(String name){
        super(name);
    }

    JThread(String name, File[] files){
        super(name);
        this.files = files;
    }



    public void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try
        {
            for(File file : files)
            {
                BufferedImage image = ImageIO.read(file);
                if(image == null) {
                    continue;
                }

                int newWidth = image.getWidth() / 2;
                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );
                BufferedImage newImage = new BufferedImage(
                        newWidth, newHeight, BufferedImage.TYPE_INT_RGB
                );

                int widthStep = image.getWidth() / newWidth;
                int heightStep = image.getHeight() / newHeight;

                for (int x = 0; x < newWidth; x++)
                {
                    for (int y = 0; y < newHeight; y++) {
                        int rgb = image.getRGB(x * widthStep, y * heightStep);
                        newImage.setRGB(x, y, rgb);
                    }
                }

                File newFile = new File("dst/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
                System.out.println(Thread.currentThread().getName() + " записал файл");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}

     class Main {

    public static void main(String[] args) {
        File srcDir = new File("images");

        File[] files = srcDir.listFiles();

        try
        {
            if (!Files.exists(Paths.get("dst")))
            {
                Files.createDirectories(Paths.get("dst"));
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        int kolThread = Runtime.getRuntime().availableProcessors();
        int filesPerThread = files.length/kolThread;
        int ost = files.length % kolThread;
        int a = files.length;

        for(int i=1; i <= kolThread; i++) {
            File[] curFiles;
            if(ost !=0){
                curFiles = new File[filesPerThread + 1];
                ost--;
            } else {
                curFiles = new File[filesPerThread];
            }
            for(int j = 0; j < curFiles.length; j++){
                curFiles[j] = files[files.length - a];
                a--;
            }
            new JThread("JThread " + i, curFiles).start();
        }
    }
}