package laba78;
import java.util.List;

public class test {
        public static void main(String[] args) {
            String c;
            Company b = new Company(180,80,10);
            List<Employee> print1 = b.getTopSalaryStaff(10);
            for(int i=0;i<10;i++) {
                c = print1.get(i).toString();
            }
            System.out.println("-----");
            List<Employee> print2 = b.getLowestSalaryStaff(30);
            for(int i=0;i<30;i++) {
                c = print2.get(i).toString();
            }
            System.out.println("AfterFire");
            for(int i=0;i<135;i++)
                b.fire();
            List<Employee> print3 = b.getTopSalaryStaff(10);
            for(int i=0;i<10;i++) {
                c = print3.get(i).toString();
            }
            System.out.println("-----");
            List<Employee> print4 = b.getLowestSalaryStaff(30);
            for(int i=0;i<30;i++) {
                c = print4.get(i).toString();
            }
        }
    }
