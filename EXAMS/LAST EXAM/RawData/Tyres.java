package src.RawData;

public class Tyres {

   private double tyre1;
   private int tyreAge1;
    private double tyre2;
    private int tyreAge2;
    private double tyre3;
    private int tyreAge3;
    private double tyre4;
    private int tyreAge4;

    public double getTyre1() {
        return tyre1;
    }

    public double getTyre2() {
        return tyre2;
    }

    public double getTyre3() {
        return tyre3;
    }

    public double getTyre4() {
        return tyre4;
    }

    public Tyres (double tyre1, int tyreAge1, double tyre2, int tyreAge2, double tyre3, int tyreAge3, double tyre4, int tyreAge4) {
       this.tyre1 = tyre1;
       this.tyreAge1 = tyreAge1;
       this.tyre2 = tyre2;
       this.tyreAge2 = tyreAge2;
       this.tyre3 = tyre3;
       this.tyreAge3 = tyreAge3;
       this.tyre4 = tyre4;
       this.tyreAge4 = tyreAge4;
   }
}
