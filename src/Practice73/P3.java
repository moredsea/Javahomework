package Practice73;


import java.util.Scanner;

     class Main {

        public static void main(String[] args) {
            String nomer;
            Scanner in = new Scanner(System.in);
            while (true) {
                System.out.println("Введите номер телефона");
                nomer = in.nextLine();
                int k = 0;
                String tel = "";
                for (int i = 0; i < nomer.length(); i++) {
                    if (nomer.charAt(i) > 47 && nomer.charAt(i) < 58) {
                        k += 1;
                        tel += nomer.charAt(i);
                    }
                }
                if (k == 11 && (nomer.charAt(0) == '8' || (nomer.charAt(0) == '+' && nomer.charAt(1)=='7'))) {
                    String telNomer = "+7 (";
                    for (int i = 1; i < 4; i++) {
                        telNomer += tel.charAt(i);
                    }
                    telNomer += ") ";
                    for (int i = 4; i < 7; i++) {
                        telNomer += tel.charAt(i);
                    }
                    telNomer += "-";
                    for (int i = 7; i < 9; i++) {
                        telNomer += tel.charAt(i);
                    }
                    telNomer += "-";
                    for (int i = 9; i < 11; i++) {
                        telNomer += tel.charAt(i);
                    }
                    System.out.println(telNomer);
                    break;
                } else {
                    System.out.println("Неверный формат номера");
                }
            }
        }
    }