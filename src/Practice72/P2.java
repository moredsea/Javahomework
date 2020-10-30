package Practice72;


import java.util.Scanner;

    class Main {

        public static void main(String[] args) {
            int k = 0;
            Scanner in = new Scanner(System.in);
            while(true) {
                System.out.println("Введите Ф.И.О.");
                String fio = in.nextLine();
                for (int i = 0; i < fio.length(); i++) {
                    if (fio.charAt(i) == ' ') {
                        k += 1;
                    }
                    if((fio.charAt(i) < 1040 || fio.charAt(i)>1103) && fio.charAt(i)!=' '){
                        System.out.println((int)fio.charAt(i));
                        k = 0;
                        break;
                    }
                }
                if (k == 2) {
                    String fam, name, otch;
                    fam = fio.substring(0, fio.indexOf(' '));
                    name = fio.substring(fio.indexOf(' ') + 1, fio.indexOf(' ', fio.indexOf(' ') + 1));
                    otch = fio.substring(fio.indexOf(' ', fio.indexOf(' ') + 1));
                    System.out.println("Фамилия: " + fam + "\n" + "Имя: " + name + "\n" + "Отчество: " + otch);
                    break;
                } else if (k == 1) {
                    String fam, name;
                    fam = fio.substring(0, fio.indexOf(' '));
                    name = fio.substring(fio.indexOf(' ') + 1);
                    System.out.println("Фамилия: " + fam + "\n" + "Имя: " + name);
                    break;
                } else {
                    System.out.println("Введенная строка не является ФИО");
                }
            }
        }
    }
