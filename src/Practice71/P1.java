package Practice71;

 class Main {

        public static void main(String[] args) {
            String text = "Вася заработал 3079 рублей, Петя - 7563 рубля, а Маша - 2230 рублей";
            System.out.println(text);
            int indexVasya = text.indexOf("Вася");
            int indexMasha = text.indexOf("Маша");
            int k = indexVasya;
            int l = indexMasha;
            boolean f1 = false, f2 = false;
            String cena1 = "", cena2 = "";
            while(true){
                if (text.charAt(k) >= 48 && text.charAt(k) < 58) {
                    while (text.charAt(k) >= 48 && text.charAt(k) < 58) {
                        cena1 += text.charAt(k);
                        k += 1;
                    }
                    f1 = true;
                }
                if (text.charAt(l) >= 48 && text.charAt(l) < 58) {
                    while (text.charAt(l) >= 48 && text.charAt(l) < 58) {
                        cena2 += text.charAt(l);
                        l += 1;
                    }
                    f2 = true;
                }
                if(f1 == false){
                    k+=1;
                }
                if(f2 == false){
                    l+=1;
                }

                if(f1&&f2){
                    break;
                }
            }
            int s = Integer.parseInt(cena1) + Integer.parseInt(cena2);
            System.out.println("Маша и Вася вместе заработали " + s + " рублей");
        }
    }