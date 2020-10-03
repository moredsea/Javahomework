package laba78;
import java.util.*;

public class Company {
    ArrayList<Employee> b = new ArrayList<Employee>();
    int all;
    int income;
    int operator=0,manager=0,topmanager=0;
    int basesalary=50000;
    public Company(int o, int m, int tm){
        all=o+m+tm;
        income=this.getIncome();
        for(int i=0;i<o;i++) {
            operator++;
            Operator O=new Operator();
            b.add(new Employee("Operator"," "+i+1,O.getJobTitle(),O.calcSalary(basesalary)));
        }
        for(int i=0;i<m;i++)
        {
            manager++;
            Manager M = new Manager(income);
            b.add(new Employee("Manager", " "+i+1,M.getJobTitle(),M.calcSalary(basesalary)));
        }
        for(int i=0;i<tm;i++)
        {
            topmanager++;
            TopManager TM = new TopManager(income);

            b.add(new Employee("Top", "Manager  "+i+1,TM.getJobTitle(), TM.calcSalary(basesalary)));
        }
    }
    public void hire()
    {
        Operator O=new Operator();
        b.add(new Employee("Operator"," "+(++operator),O.getJobTitle(),O.calcSalary(basesalary)));
    }
    public void hireAll(int num)
    {
        for(int i=0;i<num;i++) {
            operator++;
            Operator O=new Operator();
            b.add(new Employee("Operator"," "+i+1,O.getJobTitle(),O.calcSalary(basesalary)));
        }
    }
    public void fire()
    {
        b.remove((int)(Math.random()*all));
        all--;
    }
    int getIncome()
    {
        int sum=0;
        for(int i=0;i<all;i++)
            sum+=(int)(115000+Math.random()*25000);
        return sum;
    }

    public List getTopSalaryStaff(int count){
        List<Employee> tr= b;
        Collections.sort(tr,Collections.reverseOrder());
        List<Employee> ret = new ArrayList<Employee>();
        for(int i=0;i<count;i++) {
            ret.add(i,tr.get(i));
        }
        return ret;
    }
    public List getLowestSalaryStaff(int count){
        List<Employee> tr= b;
        Collections.sort(tr);
        ArrayList<Employee> ret = new ArrayList<Employee>();
        for(int i=0;i<count;i++) {
            ret.add(i,tr.get(i));
        }
        return ret;
    }
}