package Practice11_2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.Iterator;

class Main {

    public static void main(String[] args) throws IOException {
        File dir = new File("images");
        if(!dir.exists()) {
            dir.mkdir();
        }
        Document doc = Jsoup.connect("https://www.mirea.ru").get();
        Elements images = doc.select("img");
        Iterator<Element> iterator = images.iterator();
        while(iterator.hasNext())  {
            Element e = iterator.next();
            File file = new File("images/" + e.attr("abs:src").substring(e.attr("abs:src").lastIndexOf("/") + 1));
            if(!file.exists()) {
                if(e.attr("abs:src").substring(e.attr("abs:src").lastIndexOf("/")+1).contains(".")) {
                    if (!e.attr("abs:src").equals("")) {
                        System.out.println(e.attr("abs:src").substring(e.attr("abs:src").lastIndexOf("/") + 1));
                        URL url = new URL(e.attr("abs:src"));
                        InputStream inputStream = url.openStream();
                        Files.copy(inputStream, file.toPath());
                    }
                }
            }
        }
    }
}
