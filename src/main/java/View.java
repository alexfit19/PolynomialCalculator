import java.awt.event.*;

import javax.swing.*;
import java.lang.*;
import java.util.ArrayList;


public class View extends Main{
    private JFormattedTextField rezultat;
    private JFormattedTextField polinom1;
    private JFormattedTextField polinom2;
    private JPanel panel;
    private JButton Suma;
    private JButton Inmultire;
    private JButton Derivare;
    private JButton Diferenta;
    private JButton Impartire;
    private JButton Integrare;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button0;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonInmultire;
    private JButton buttonImpartire;
    private JButton buttonPutere;
    private JButton buttonP;
    private JButton buttonX;
    private JButton buttonC;
    private JCheckBox apasaInserareCheckBox;
    private JCheckBox apasaInserareCheckBox1;
    private JButton deleteTextFields;
    boolean bool = true;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        JPanel p = new JPanel();
        View interfata = new View();
        p.add(interfata.panel);

        interfata.apasaInserareCheckBox.addActionListener(e -> {
            interfata.apasaInserareCheckBox1.setSelected(false);
            interfata.bool = true;
        });
        interfata.apasaInserareCheckBox1.addActionListener(e -> {
            interfata.apasaInserareCheckBox.setSelected(false);
            interfata.bool = false;
        });
        interfata.deleteTextFields.addActionListener(e -> {
            interfata.rezultat.setText(null);
            interfata.polinom1.setText(null);
            interfata.polinom2.setText(null);
        });
        interfata.buttonPlus.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+"+");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+"+");
            }
        });
        interfata.buttonMinus.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+"-");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+"-");
            }
        });
        interfata.buttonImpartire.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+"/");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+"/");
            }
        });
        interfata.buttonInmultire.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+"*");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+"*");
            }
        });
        interfata.buttonPutere.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+"^");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+"^");
            }
        });
        interfata.buttonP.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+".");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+".");
            }
        });
        interfata.buttonX.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+"X");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+"X");
            }
        });
        interfata.buttonC.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                if(t.length() != 0) {
                    int index = t.length() - 1;
                    t = t.substring(0, index) + t.substring(index + 1);
                    interfata.polinom1.setText(t);
                }
            }else{
                String t = interfata.polinom2.getText();
                if(t.length() != 0) {
                    int index = t.length() - 1;
                    t = t.substring(0, index) + t.substring(index + 1);
                    interfata.polinom2.setText(t);
                }
            }
        });
        interfata.button1.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+"1");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+"1");
            }
        });
        interfata.button2.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+"2");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+"2");
            }
        });
        interfata.button3.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+"3");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+"3");
            }
        });
        interfata.button4.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+"4");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+"4");
            }
        });
        interfata.button5.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+"5");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+"5");
            }
        });
        interfata.button6.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+"6");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+"6");
            }
        });
        interfata.button7.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+"7");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+"7");
            }
        });
        interfata.button8.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+"8");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+"8");
            }
        });
        interfata.button9.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+"9");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+"9");
            }
        });
        interfata.button0.addActionListener(e -> {
            if(interfata.bool){
                String t = interfata.polinom1.getText();
                interfata.polinom1.setText(t+"0");
            }else{
                String t = interfata.polinom2.getText();
                interfata.polinom2.setText(t+"0");
            }
        });
        interfata.Suma.addActionListener(e -> {
            Polinoame polinom1 = stringToPolinom(interfata.polinom1.getText());
            Polinoame polinom2 = stringToPolinom(interfata.polinom2.getText());
            Polinoame polinom3 = sumaPolinoame(polinom1,polinom2);
            interfata.rezultat.setText(polinomToString(polinom3));
        });
        interfata.Diferenta.addActionListener(e -> {
            Polinoame polinom1 = stringToPolinom(interfata.polinom1.getText());
            Polinoame polinom2 = stringToPolinom(interfata.polinom2.getText());
            Polinoame polinom3 = diferentaPolinoame(polinom1,polinom2);
            interfata.rezultat.setText(polinomToString(polinom3));
        });
        interfata.Inmultire.addActionListener(e -> {
            Polinoame polinom1 = stringToPolinom(interfata.polinom1.getText());
            Polinoame polinom2 = stringToPolinom(interfata.polinom2.getText());
            Polinoame polinom3 = inmultirePolinoame(polinom1,polinom2);
            interfata.rezultat.setText(polinomToString(polinom3));
        });
        interfata.Impartire.addActionListener(e -> {
            Polinoame polinom1 = stringToPolinom(interfata.polinom1.getText());
            Polinoame polinom2 = stringToPolinom(interfata.polinom2.getText());
            ArrayList<Polinoame> polinom3 = impartirePolinoame(polinom1,polinom2);
            interfata.rezultat.setText("C: "+polinomToString(polinom3.get(0))+" R: "+polinomToString(polinom3.get(1)));
        });
        interfata.Derivare.addActionListener(e -> {
            if(interfata.bool){
                Polinoame polinom1 = stringToPolinom(interfata.polinom1.getText());
                derivarePolinom(polinom1);
                interfata.rezultat.setText(polinomToString(polinom1));
            }else{
                Polinoame polinom2 = stringToPolinom(interfata.polinom2.getText());
                derivarePolinom(polinom2);
                interfata.rezultat.setText(polinomToString(polinom2));
            }
        });
        interfata.Integrare.addActionListener(e -> {
            if(interfata.bool){
                Polinoame polinom1 = stringToPolinom(interfata.polinom1.getText());
                integrarePolinom(polinom1);
                interfata.rezultat.setText(polinomToString(polinom1));
            }else{
                Polinoame polinom2 = stringToPolinom(interfata.polinom2.getText());
                integrarePolinom(polinom2);
                interfata.rezultat.setText(polinomToString(polinom2));
            }
        });
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        frame.setContentPane(p);
        frame.setVisible(true);
    }
}
