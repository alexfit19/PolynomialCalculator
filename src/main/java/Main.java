import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static Polinoame stringToPolinom(String s){
        ArrayList<Monoame> monoame = new ArrayList<>();
        ArrayList<Double> coeficienti = new ArrayList<>();
        ArrayList<Integer> grade = new ArrayList<>();
        int nrMonoame = 0, semn = 0, j = 0, grad = 0, ok = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                nrMonoame++;
            }
        }
        String[] parts = s.split("X");
        boolean b = false;
        for (String str : parts) {
            grad = 0;
            for (int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '^'){
                    b = true;
                    continue;
                }
                if(b){
                    if(str.charAt(i) != '+' && str.charAt(i) != '-' && str.charAt(i) != '\0' && str.charAt(i) != '^' && str.charAt(i) != '.' && str.charAt(i) != 'X'){
                        grad = grad * 10 + (int)str.charAt(i) - 48;
                        ok = 1;
                    }else{
                        if(ok == 1){
                            grade.add(grad);
                            b = false;
                            break;
                        }
                    }
                }else {
                    break;
                }

            }
        }
        grade.add(grad);
        StringBuilder coef = new StringBuilder();
        b = true;
        for (String str : parts) {
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '+'){
                    semn = 1;
                    b = true;
                    continue;
                }
                if (str.charAt(i) == '-'){
                    semn = -1;
                    b = true;
                    continue;
                }
                if(str.charAt(i) == '^'){
                    continue;
                }
                if(str.charAt(i) == '*'){
                    continue;
                }
                if(b){
                    coef.append(str.charAt(i));
                }
            }
            b = false;
            if(!coef.toString().equals("") && semn != 0){
                coeficienti.add(semn * Double.parseDouble(coef.toString()));
            }else if(!coef.toString().equals("")){
                coeficienti.add(Double.parseDouble(coef.toString()));
            }
            coef = new StringBuilder();
        }
        for (Integer gr : grade) {
            monoame.add(new Monoame(gr,coeficienti.get(j++)));
        }
        return new Polinoame(nrMonoame,monoame);
    }
    public static String polinomToString(Polinoame polinom){
        StringBuilder s = new StringBuilder();
        for (Monoame monom : polinom.getArray()) {
            if(monom.getCoeficient() > 0){
                s.append("+").append(monom.getCoeficient()).append("*X^").append(monom.getGrad());
            }else {
                s.append(monom.getCoeficient()).append("*X^").append(monom.getGrad());
            }
        }
        return s.toString();
    }
    static void sortarePolinom(Polinoame polinom){
        ArrayList<Monoame> monoamePolinom = polinom.getArray();
        Monoame monomAuxiliar = new Monoame(0,0);
        for (Monoame monom : monoamePolinom) {
            for (Monoame monom2 : monoamePolinom) {
                if(monom.getGrad() > monom2.getGrad())
                {
                    monomAuxiliar.setGrad(monom.getGrad());
                    monomAuxiliar.setCoeficient(monom.getCoeficient());
                    monom.setGrad(monom2.getGrad());
                    monom.setCoeficient(monom2.getCoeficient());
                    monom2.setGrad(monomAuxiliar.getGrad());
                    monom2.setCoeficient(monomAuxiliar.getCoeficient());
                }
            }
        }
        polinom.setArrayList(monoamePolinom);
    }
    public static Polinoame sumaPolinoame(Polinoame polinom1, Polinoame polinom2){
        double coeficient;
        int grad;
        int nrMonoame = 0;
        int ok;
        ArrayList<Monoame> monoameSuma= new ArrayList<>();
        Polinoame polinom3 = new Polinoame(nrMonoame,monoameSuma);
        for (Monoame monom : polinom1.getArray()) {
            for (Monoame monom2 : polinom2.getArray()) {
                if(monom.getGrad() == monom2.getGrad()){
                    coeficient = monom.getCoeficient() + monom2.getCoeficient();
                    grad = monom.getGrad();
                    nrMonoame++;
                    monoameSuma.add(new Monoame(grad,coeficient));
                }
            }
        }

        polinom3.setNrMonoame(nrMonoame);
        polinom3.setArrayList(monoameSuma);

        for (Monoame monom : polinom1.getArray()) {
            ok = 0;
            for (Monoame monom2 : polinom3.getArray()) {
                if (monom.getGrad() == monom2.getGrad()) {
                    ok = 1;
                    break;
                }
            }
            if(ok == 0){
                nrMonoame++;
                monoameSuma.add(monom);
            }
        }
        polinom3.setNrMonoame(nrMonoame);
        polinom3.setArrayList(monoameSuma);

        for (Monoame monom : polinom2.getArray()) {
            ok = 0;
            for (Monoame monom2 : polinom3.getArray()) {
                if (monom.getGrad() == monom2.getGrad()) {
                    ok = 1;
                    break;
                }
            }
            if(ok == 0){
                nrMonoame++;
                monoameSuma.add(monom);
            }
        }
        polinom3.setNrMonoame(nrMonoame);
        polinom3.setArrayList(monoameSuma);
        sortarePolinom(polinom3);

        return polinom3;
    }
    public static Polinoame diferentaPolinoame(Polinoame polinom1, Polinoame polinom2){
        double coeficient;
        int grad;
        int nrMonoame = 0;
        int ok;
        ArrayList<Monoame> monoameDiferenta= new ArrayList<>();
        Polinoame polinom3 = new Polinoame(nrMonoame,monoameDiferenta);

        for (Monoame monom : polinom1.getArray()) {
            for (Monoame monom2 : polinom2.getArray()) {
                if(monom.getGrad() == monom2.getGrad()){
                    coeficient = monom.getCoeficient() - monom2.getCoeficient();
                    grad = monom.getGrad();
                    nrMonoame++;
                    monoameDiferenta.add(new Monoame(grad,coeficient));
                }
            }
        }
        polinom3.setNrMonoame(nrMonoame);
        polinom3.setArrayList(monoameDiferenta);

        for (Monoame monom : polinom1.getArray()) {
            ok = 0;
            for (Monoame monom2 : polinom3.getArray()) {
                if (monom.getGrad() == monom2.getGrad()) {
                    ok = 1;
                    break;
                }
            }
            if(ok == 0){
                nrMonoame++;
                monoameDiferenta.add(monom);
            }
        }
        polinom3.setNrMonoame(nrMonoame);
        polinom3.setArrayList(monoameDiferenta);

        for (Monoame monom : polinom2.getArray()) {
            ok = 0;
            for (Monoame monom2 : polinom3.getArray()) {
                if (monom.getGrad() == monom2.getGrad()) {
                    ok = 1;
                    break;
                }
            }
            if(ok == 0){
                nrMonoame++;
                monom.setCoeficient(monom.getCoeficient()*(-1));
                monoameDiferenta.add(monom);
            }
        }
        polinom3.setNrMonoame(nrMonoame);
        polinom3.setArrayList(monoameDiferenta);
        sortarePolinom(polinom3);
        stergereMonoameNule(polinom3.getArray(), polinom3);

        return polinom3;
    }
    public static Polinoame inmultirePolinoame(Polinoame polinom1, Polinoame polinom2){
        int nrMonoame = 0;
        ArrayList<Monoame> monoamePolinom = new ArrayList<>();
        Polinoame polinom3 = new Polinoame(nrMonoame,monoamePolinom);
        for (Monoame monom : polinom1.getArray()) {
            for (Monoame monom2 : polinom2.getArray()) {
                monoamePolinom.add(new Monoame(monom.getGrad()+monom2.getGrad(),monom.getCoeficient()*monom2.getCoeficient()));
                polinom3.setNrMonoame(polinom3.getNrMonoame() + 1);
                polinom3.setArrayList(monoamePolinom);
            }
        }
        return polinom3;
    }
    public static ArrayList<Polinoame> impartirePolinoame(Polinoame polinom1, Polinoame polinom2) {
        ArrayList<Polinoame> polinoameCatRest = new ArrayList<>();
        boolean found = false;
        for (Monoame monom : polinom2.getArray()) {
            if(monom.getCoeficient() != 0){
                found = true;
                break;
            }
        }
        if(!found){
            return null;
        }

        int grad1 = polinom1.getArray().get(0).getGrad();
        int grad2 = polinom2.getArray().get(0).getGrad();

        if(grad2 > grad1) {
            ArrayList<Monoame> monoame = new ArrayList<>();
            monoame.add(new Monoame(0,0));
            polinoameCatRest.add(new Polinoame(1, monoame));
            polinoameCatRest.add(polinom1);
            return polinoameCatRest;
        }

        int grad = polinom1.getArray().get(0).getGrad() - polinom2.getArray().get(0).getGrad();
        double coeficient = polinom1.getArray().get(0).getCoeficient() / polinom2.getArray().get(0).getCoeficient();

        Monoame monom = new Monoame(grad, coeficient);
        ArrayList<Monoame> list = new ArrayList<>();
        list.add(monom);

        Polinoame cat = new Polinoame(1, list);
        Polinoame rest = inmultirePolinoame(polinom2, cat);
        rest = diferentaPolinoame(polinom1, rest);

        int gradRest = rest.getArray().isEmpty() ? 0 : rest.getArray().get(0).getGrad();

        while (gradRest >= grad2) {
            grad = rest.getArray().get(0).getGrad() - polinom2.getArray().get(0).getGrad();
            coeficient = rest.getArray().get(0).getCoeficient() / polinom2.getArray().get(0).getCoeficient();

            Monoame aux = new Monoame(grad, coeficient);

            cat.getArray().add(aux);

            ArrayList<Monoame> l = new ArrayList<>();
            l.add(aux);
            Polinoame p = inmultirePolinoame(polinom2, new Polinoame(1, l));

            rest = diferentaPolinoame(rest, p);

            gradRest = rest.getArray().get(0).getGrad();

        }
        polinoameCatRest.add(cat);
        polinoameCatRest.add(rest);
        return polinoameCatRest;
    }
    public static void integrarePolinom(Polinoame polinom) {
        for (Monoame monom : polinom.getArray()) {
            monom.setGrad(monom.getGrad() + 1);
            monom.setCoeficient(monom.getCoeficient() / monom.getGrad());
        }
    }
    static void stergereMonoameNule(ArrayList<Monoame> arrayList, Polinoame polinom){
        Iterator<Monoame> itr = arrayList.iterator();
        while (itr.hasNext()) {
            Monoame monom = itr.next();
            if (monom.getCoeficient() == 0) {
                itr.remove();
                polinom.setNrMonoame(polinom.getNrMonoame() - 1);
                polinom.setArrayList(arrayList);
            }
        }
    }
    public static void derivarePolinom(Polinoame polinom){
        ArrayList<Monoame> monoame= polinom.getArray();
        Iterator<Monoame> itr = monoame.iterator();
        while (itr.hasNext()) {
            Monoame monom = itr.next();
            if (monom.getGrad() == 0) {
                itr.remove();
                polinom.setNrMonoame(polinom.getNrMonoame() - 1);
                polinom.setArrayList(monoame);
            }else{
                monom.setCoeficient(monom.getCoeficient() * monom.getGrad());
                monom.setGrad(monom.getGrad() - 1);
            }
        }
    }
}