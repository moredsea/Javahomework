package Practice11_1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class Main {

    public static void main(String[] args) {
        final String PATH = "movementList.csv";
        File file = new File(PATH);
        Map<String, Float> map = new HashMap<>();
        float spr = 0;
        float sra = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int k = 0;
            while ((line = br.readLine()) != null) {
                if (k>0) {
                    String[] companyArray;
                    if(line.contains("\\")){
                        companyArray = line.split("\\\\");
                    } else {
                        companyArray = line.split("/");
                    }
                    String company ="";
                    for(int i = 1; i<companyArray.length-1; i++){
                        company+=companyArray[i];
                    }
                    company+=companyArray[companyArray.length-1].split("  ")[0];


                    String[] info = line.split(",");
                    float pr = Float.parseFloat(info[6]);
                    float ra;
                    if (info.length > 8){
                        String n0 = info[7] + "." + info[8];
                        String[] n1 = n0.split("\"");
                        ra = Float.parseFloat(n1[1]);
                    } else {
                        ra = Float.parseFloat(info[7]);
                    }
                    spr +=pr;
                    sra +=ra;
                    if(!map.containsKey(company)){
                        map.put(company, ra);
                    } else{
                        float r = map.get(company);
                        r+=ra;
                        map.remove(company);
                        map.put(company, r);
                    }
                } else {
                    k+=1;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Сумма расходов: " + sra + " руб.");
        System.out.println("Сумма доходов: " + spr + " руб.");
        System.out.println();
        System.out.println("Суммы расходов по организациям:");
        for(String name : map.keySet()){
            System.out.println(name + "    " + map.get(name) + " руб.");
        }

    }
}
