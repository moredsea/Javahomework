package laba78;

public class Manager implements EmployeePosition {

    int work;
    Manager(int sum){
        int a= (int)(115000+Math.random()*25000);
        work=a;
    }
    public String getJobTitle() {
        return "Manager";
    }

    public int calcSalary(int baseSalary) {
        return baseSalary+(int)(this.work*0.05);
    }
}
