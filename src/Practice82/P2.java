package Practice82;


import java.util.Scanner;
import java.util.TreeSet;

    class Main {

        public static void main(String[] args) {
            TreeSet<String> tree = new TreeSet();
            Scanner in = new Scanner(System.in);
            String text = "";
            text = in.nextLine();

            while (!text.equals("0")) {
                if (text.equals("LIST")) {
                    for (String tr : tree) {
                        System.out.println(tr);
                    }
                } else if (text.substring(0, 3).equals("ADD")) {
                    if (!(text.contains("@") && text.contains(".") && !text.substring(4).contains(" "))) {
                        System.out.println("Некорректный адрес эл. почты");
                    } else {
                        tree.add(text.substring(text.indexOf(' ') + 1));
                    }
                } else {
                    System.out.println("Некорректная команда");
                }
                text = in.nextLine();
            }
        }
    }