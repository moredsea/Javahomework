package Practice81;



import java.util.ArrayList;
import java.util.Scanner;

    class Main {

        public static void main(String[] args) {
            ArrayList todo = new ArrayList();
            Scanner in = new Scanner(System.in);
            String text = "";
            text = in.nextLine();
            while(!text.equals("0")){
                if(text.equals("LIST")){
                    for(int i = 0; i<todo.size(); i++){
                        System.out.println((i+1) + ": " + todo.get(i));
                    }
                } else if(text.substring(0,3).equals("ADD")){
                    if(text.charAt(4) >= 48 && text.charAt(4)<58){
                        todo.add(text.substring(text.indexOf(' ', 4)+1));
                        String delo = text.substring(text.indexOf(' ', 4)+1);
                        for(int i = todo.size()-2; i >= Integer.parseInt(text.substring(4, text.indexOf(' ', 4)))-1; i--){
                            todo.set(i+1, todo.get(i));
                        }
                        todo.set(Integer.parseInt(text.substring(4, text.indexOf(' ', 4)))-1, delo);
                    } else {
                        todo.add(text.substring(text.indexOf(' ')+1));
                    }

                } else if(text.substring(0,4).equals("EDIT")){
                    todo.set(Integer.parseInt(text.substring(5, text.indexOf(' ', 5)))-1, text.substring(text.indexOf(' ', 5)+1));
                } else if(text.substring(0,6).equals("DELETE")) {
                    todo.remove(Integer.parseInt(text.substring(7))-1);
                } else{
                    System.out.println("Некорректная задача");
                }
                text = in.nextLine();
            }
        }
    }