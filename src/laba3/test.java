package laba3;

public class test {
    public static void main(String[] args) {
        circle gosha = new circle();
        gosha.setR(45);
        System.out.println(gosha.toString());
        human human = new human(2, 2, 1);
        human.intoHuman();
        book book = new book("orwell", "1984", "yellow", true);
        book.info();

    }
}

