package Practice12;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;

class Line{
    String number;
    String name;
    public Line(String name, String number){
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}


class Stations{
    @SerializedName("1") ArrayList<String> l1 = new ArrayList<>();
    @SerializedName("2") ArrayList<String> l2 = new ArrayList<>();
    @SerializedName("3") ArrayList<String> l3 = new ArrayList<>();
    @SerializedName("4") ArrayList<String> l4 = new ArrayList<>();
    @SerializedName("5") ArrayList<String> l5 = new ArrayList<>();
    @SerializedName("6") ArrayList<String> l6 = new ArrayList<>();
    @SerializedName("7") ArrayList<String> l7 = new ArrayList<>();
    @SerializedName("8") ArrayList<String> l8 = new ArrayList<>();
    @SerializedName("9") ArrayList<String> l9 = new ArrayList<>();
    @SerializedName("10") ArrayList<String> l10 = new ArrayList<>();
    @SerializedName("11") ArrayList<String> l11 = new ArrayList<>();
    @SerializedName("11A") ArrayList<String> l11A = new ArrayList<>();
    @SerializedName("12") ArrayList<String> l12 = new ArrayList<>();
    @SerializedName("14") ArrayList<String> l14 = new ArrayList<>();
    @SerializedName("15") ArrayList<String> l15 = new ArrayList<>();
    @SerializedName("D1") ArrayList<String> lD1 = new ArrayList<>();
    @SerializedName("D2") ArrayList<String> lD2 = new ArrayList<>();
}

class LinesAndStations{
    Stations stations = new Stations();
    ArrayList<Line> lines= new ArrayList();

    LinesAndStations(){

    }

    public void addLine(Line line){
        lines.add(line);
    }


    public void addStationList(String n, String[] names){
        switch (n){
            case "1":
                for(String s : names){
                    stations.l1.add(s);
                }
                break;
            case "2":
                for(String s : names){
                    stations.l2.add(s);
                }
                break;
            case "3":
                for(String s : names){
                    stations.l3.add(s);
                }
                break;
            case "4":
                for(String s : names){
                    stations.l4.add(s);
                }
                break;
            case "5":
                for(String s : names){
                    stations.l5.add(s);
                }
                break;
            case "6":
                for(String s : names){
                    stations.l6.add(s);
                }
                break;
            case "7":
                for(String s : names){
                    stations.l7.add(s);
                }
                break;
            case "8":
                for(String s : names){
                    stations.l8.add(s);
                }
                break;
            case "9":
                for(String s : names){
                    stations.l9.add(s);
                }
                break;
            case "10":
                for(String s : names){
                    stations.l10.add(s);
                }
                break;
            case "11":
                for(String s : names){
                    stations.l11.add(s);
                }
                break;
            case "11A":
                for(String s : names){
                    stations.l11A.add(s);
                }
                break;
            case "12":
                for(String s : names){
                    stations.l12.add(s);
                }
                break;
            case "14":
                for(String s : names){
                    stations.l14.add(s);
                }
                break;
            case "15":
                for(String s : names){
                    stations.l15.add(s);
                }
                break;
            case "D1":
                for(String s : names){
                    stations.lD1.add(s);
                }
                break;
            case "D2":
                for(String s : names){
                    stations.lD2.add(s);
                }
                break;
        }
    }


}

    class Main {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).timeout(0).get();
        Elements linesFromSite = doc.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln");
        Elements stationsFromSite = doc.select("div.js-metro-stations.t-metrostation-list-table");

        LinesAndStations las = new LinesAndStations();
        for(Element e : linesFromSite){
            las.addLine(new Line(e.text(), e.attr("data-line")));
        }

        for(Element e : stationsFromSite){
            String[] sad = e.text().split("\\d+.");
            String[] need = new String[sad.length-1];
            for(int i = 1; i<sad.length;i++){
                need[i-1] = sad[i].trim();
            }
            las.addStationList(e.attr("data-line"), need);
        }


        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        File file = new File("jsonFile.json");
        FileWriter writer = new FileWriter(file.getPath());
        String json = gson.toJson(las);
        writer.write(json);
        writer.flush();

        Gson g = new Gson();
        FileReader reader = new FileReader(file.getPath());
        LinesAndStations las2 = g.fromJson(reader, LinesAndStations.class);
        System.out.println("Количество станций на каждой ветке:");
        int k = 1;
        for(Line line : las2.lines){
            System.out.print(line.getName() + ": ");
            switch (k) {
                case 1:
                    System.out.println(las2.stations.l1.size());
                    break;
                case 2:
                    System.out.println(las2.stations.l2.size());
                    break;
                case 3:
                    System.out.println(las2.stations.l3.size());
                    break;
                case 4:
                    System.out.println(las2.stations.l4.size());
                    break;
                case 5:
                    System.out.println(las2.stations.l5.size());
                    break;
                case 6:
                    System.out.println(las2.stations.l6.size());
                    break;
                case 7:
                    System.out.println(las2.stations.l7.size());
                    break;
                case 8:
                    System.out.println(las2.stations.l8.size());
                    break;
                case 9:
                    System.out.println(las2.stations.l9.size());
                    break;
                case 10:
                    System.out.println(las2.stations.l10.size());
                    break;
                case 11:
                    System.out.println(las2.stations.l11.size());
                    break;
                case 12:
                    System.out.println(las2.stations.l11A.size());
                    break;
                case 13:
                    System.out.println(las2.stations.l12.size());
                    break;
                case 14:
                    System.out.println(las2.stations.l14.size());
                    break;
                case 15:
                    System.out.println(las2.stations.l15.size());
                    break;
                case 16:
                    System.out.println(las2.stations.lD1.size());
                    break;
                case 17:
                    System.out.println(las2.stations.lD2.size());
                    break;
            }
            k+=1;
        }
    }
}
