public class Monoame {
    private int grad;
    private double coeficient;

    Monoame(int grad, double coeficient){
        this.grad = grad;
        this.coeficient = coeficient;
    }

    public int getGrad() {
        return grad;
    }
    public void setGrad(int newGrad) {
        this.grad = newGrad;
    }

    public double getCoeficient() {
        return coeficient;
    }
    public void setCoeficient(double newCoeficient) {
        this.coeficient = newCoeficient;
    }

    @Override
    public String toString() {
        return "Monoame{" +
                "grad=" + grad +
                ", coeficient=" + coeficient +
                '}';
    }
}
