import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest extends Main {

    @org.junit.jupiter.api.Test
    void main() {
        String str1 = "2*X^3+2*X^2";
        String str2 = "2*X^2";
        String str3 = "";

        Polinoame polinom1 =  stringToPolinom(str1);
        Polinoame polinom2 = stringToPolinom(str2);
        Polinoame polinom3 =  stringToPolinom(str1);
        Polinoame polinom4 = stringToPolinom(str2);
        Polinoame polinom5 =  stringToPolinom(str1);
        Polinoame polinom6 = stringToPolinom(str2);
        Polinoame polinom7 =  stringToPolinom(str1);
        Polinoame polinom8 = stringToPolinom(str2);

        Polinoame polinomS = sumaPolinoame(polinom1,polinom2);
        str3 = polinomToString(polinomS);
        assertEquals(str3,"+2.0*X^3+4.0*X^2");

        Polinoame polinomD = diferentaPolinoame(polinom3,polinom4);
        str3 = polinomToString(polinomD);
        assertEquals(str3,"+2.0*X^3");

        Polinoame polinomI = inmultirePolinoame(polinom5,polinom6);
        str3 = polinomToString(polinomI);
        assertEquals(str3,"+4.0*X^5+4.0*X^4");

        derivarePolinom(polinom7);
        str3 = polinomToString(polinom7);
        assertEquals(str3,"+6.0*X^2+4.0*X^1");

        integrarePolinom(polinom8);
        str3 = polinomToString(polinom8);
        assertEquals(str3,"+0.6666666666666666*X^3");

        Polinoame polinom9 = stringToPolinom("1*X^3-2*X^2+6*X^1-5*X^0");
        Polinoame polinom10 = stringToPolinom("1*X^2-1*X^0");
        ArrayList<Polinoame> polinomIm = impartirePolinoame(polinom9,polinom10);
        str3 = "C: "+polinomToString(polinomIm.get(0))+" R: "+polinomToString(polinomIm.get(1));
        assertEquals(str3,"C: +1.0*X^1-2.0*X^0 R: +7.0*X^1-7.0*X^0");
    }
}