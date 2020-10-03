package laba3;

public class circle {
    private double R;
    private double D;
    private double S;
    private double C;

    public void setR(double r) {
        this.R = r;
        this.D = 2.0D * this.R;
        this.C = 6.283185307179586D * this.R;
        this.S = 3.141592653589793D * this.R * this.R;
    }

    public double getC() {
        return this.C;
    }

    public double getD() {
        return this.D;
    }

    public double getR() {
        return this.R;
    }

    public double getS() {
        return this.S;
    }
    @Override
    public String toString(){
        return("Radius = "+R+" Diameter = "+D+ " Perimetr = "+C+" Area = "+S);
    }
}
