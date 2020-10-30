package Practice83;


import java.util.*;

    class Main {

        public static void main(String[] args) {
            String tel;
            String name;
            Map<String, String> map = new HashMap<String, String>();
            Set<String> keys = map.keySet();
            Collection<String> values = map.values();
            Scanner in = new Scanner(System.in);
            String text = "";
            text = in.nextLine();
            TreeSet<String> tree = new TreeSet();
            while (!text.equals("0")){
                if (text.equals("LIST")) {
                    for (String tr : tree) {
                        System.out.println(tr);
                    }
                } else {
                    int k = 0;
                    for (int i = 0; i < text.length(); i++) {
                        if (text.charAt(i) > 47 && text.charAt(i) < 58) {
                            k += 1;
                        }
                    }
                    if (k == text.length()) {
                        boolean f1 = false;
                        for (String t : map.keySet()) {
                            if (text.equals(t)) {
                                f1 = true;
                            }
                        }
                        if (f1) {
                            System.out.println(map.get(text) + " " + text);
                        } else {
                            tel = text;
                            System.out.println("Введите имя абонента");
                            name = in.nextLine();
                            map.put(tel, name);
                            tree.add(name + " " + tel);
                        }
                    } else {
                        boolean f1 = false;
                        for (String t : map.values()) {
                            if (text.equals(t)) {
                                f1 = true;
                            }
                        }
                        if (f1) {
                            for (String t : map.keySet()) {
                                if (text.equals(map.get(t))) {
                                    System.out.println(text + " " + t);
                                }
                            }
                        } else {
                            name = text;
                            System.out.println("Введите номер телефона");
                            tel = in.nextLine();
                            map.put(tel, name);
                            tree.add(name + " " + tel);
                        }
                    }
                }
                text = in.nextLine();

            }
        }
    }