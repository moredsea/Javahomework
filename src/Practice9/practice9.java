package Practice9;

import java.util.*;

    class Main {

        public static void main(String[] args) {
            String nomer;
            String[] letters = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};
            ArrayList<String> a1 = new ArrayList<>();
            ArrayList<String> a2 = new ArrayList<>();
            HashSet<String> a3 = new HashSet<>();
            TreeSet<String> a4 = new TreeSet<>();
            for(int i = 1; i<200; i++){
                for(int j = 1; j<10; j++){
                    for(int k = 0; k<letters.length; k++){
                        for(int y = 0; y<letters.length; y++){
                            for(int r = 0; r<letters.length; r++){
                                nomer = "";
                                nomer = letters[k]+Integer.toString(j+10*j+100*j)+letters[y]+letters[r];
                                if(i<10){
                                    nomer+="0";
                                }
                                nomer+=Integer.toString(i);
                                a1.add(nomer);
                                a2.add(nomer);
                                a3.add(nomer);
                                a4.add(nomer);
                            }
                        }
                    }
                }
            }
            Scanner in = new Scanner(System.in);
            System.out.println("Введите искомый номер");
            String n = in.nextLine();

            long z = System.nanoTime();
            String heh = a1.contains(n)?"номер найден":"номер не найден";
            z = System.nanoTime() - z;
            System.out.println("Поиск перебором: " + heh + ", поиск занял " + z+"нс");

            Collections.sort(a2);
            z = System.nanoTime();
            heh = Collections.binarySearch(a2, n)!=-1?"номер найден":"номер не найден";
            z = System.nanoTime() - z;
            System.out.println("Бинарный поиск: " + heh + ", поиск занял " + z+"нс");

            z = System.nanoTime();
            heh = a3.contains(n)?"номер найден":"номер не найден";
            z = System.nanoTime() - z;
            System.out.println("Поиск в HashSet: " + heh + ", поиск занял " + z+"нс");

            z = System.nanoTime();
            heh = a4.contains(n)?"номер найден":"номер не найден";
            z = System.nanoTime() - z;
            System.out.println("Поиск в TreeSet: " + heh + ", поиск занял " + z+"нс");
        }
    }