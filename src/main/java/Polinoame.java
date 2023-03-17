import java.util.ArrayList;

public class Polinoame {
    private int nrMonoame;
    ArrayList<Monoame> Monoame;

    Polinoame(int nrMonoame,ArrayList<Monoame> monoame){
        this.nrMonoame = nrMonoame;
        this.Monoame = monoame;
    }

    public int getNrMonoame() {
        return nrMonoame;
    }
    public void setNrMonoame(int newNrMonoame) {
        this.nrMonoame = newNrMonoame;
    }

    public ArrayList<Monoame> getArray(){
        return Monoame;
    }
    public void setArrayList(ArrayList<Monoame> Monoame) {
        this.Monoame = Monoame;
    }

    @Override
    public String toString() {
        return "Polinoame{" +
                "nrMonoame=" + nrMonoame +
                ", Monoame=" + Monoame +
                '}';
    }
}
