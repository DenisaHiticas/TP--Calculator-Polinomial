package interfata_principala;

import operatii.ToateOperatiilePOLINOM;
import polinom.Despart;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
public class InterfataButoane extends JFrame {
//constructor cu acelasi nume ca si clasa
    public InterfataButoane() {
        //titlu
        super("Calculator Polinomial-TEMA 1 TP - Hiticas Denisa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700); //marime fereasrra
        setLocationRelativeTo(null); //sa o deschida pe mijloc
        //un pic de culori
        Font font = new Font("Arial", Font.BOLD, 20);
        Color color = Color.GREEN;

        JPanel panel_buton = new JPanel(new FlowLayout());
        JPanel panel = new JPanel();

        JLabel pol1 = new JLabel("Primul polinom:");
        pol1.setFont(font);
        pol1.setForeground(color);
        JTextField textField1 = new JTextField(20);
        panel.add(pol1);
        panel.add(textField1);

        JLabel pol2 = new JLabel("Al doilea polinom:");
        pol2.setFont(font);
        pol2.setForeground(color);
        JTextField textField2 = new JTextField(20);
        panel.add(pol2);
        panel.add(textField2);

        // BUTOANE SI ACTION LISTENERURI
        JButton but_adun = new JButton("Aduna polinoamele");
        panel.add(but_adun);
        add(panel);
        JButton but_scad = new JButton("Scade polinoamele");
        panel.add(but_scad);
        add(panel);
        JButton but_inmultire = new JButton("Inmultesc polinoamele");
        panel.add(but_inmultire);
        add(panel);
        JButton but_derivare = new JButton("Derivez p1 ");
        panel.add(but_derivare);
        add(panel);
        JButton but_integrare = new JButton("Integrez p1");
        panel.add(but_integrare);
        add(panel);

        // PRINTARE REZULTAT
        JLabel caseta_rez = new JLabel("                     Rezultat:  ");
        caseta_rez.setFont(font);
        caseta_rez.setForeground(color);
        JTextField txt = new JTextField(25);
        panel.add(caseta_rez);
        panel.add(txt);
        add(panel);
        setVisible(true);

        but_adun.addActionListener(e -> {
            String p1 = textField1.getText();
            String p2 = textField2.getText();
            HashMap<Integer, Double> polinom1 = Despart.parse(p1);
            HashMap<Integer, Double> polinom2 = Despart.parse(p2);
            HashMap<Integer, Double> polinom_rez = ToateOperatiilePOLINOM.adunare(polinom1, polinom2);
            txt.setText(Despart.toString(polinom_rez));
        });
        but_scad.addActionListener(e -> {
            String p1 = textField1.getText();
            String p2 = textField2.getText();
            HashMap<Integer, Double> polinom1 = Despart.parse(p1);
            HashMap<Integer, Double> polinom2 = Despart.parse(p2);
            HashMap<Integer, Double> polinom_rez = ToateOperatiilePOLINOM.scadere(polinom1, polinom2);
            txt.setText(Despart.toString(polinom_rez));
        });

        // buton inmultire
        but_inmultire.addActionListener(e -> {
            String p1 = textField1.getText();
            String p2 = textField2.getText();
            HashMap<Integer, Double> polinom1 = Despart.parse(p1);
            HashMap<Integer, Double> polinom2 = Despart.parse(p2);
            HashMap<Integer, Double> polinom_rez = ToateOperatiilePOLINOM.inmultire(polinom1, polinom2);
            txt.setText(Despart.toString(polinom_rez));
        });

        // buton derivare
        but_derivare.addActionListener(e -> {
            String p1 = textField1.getText();
            HashMap<Integer, Double> polinom1 = Despart.parse(p1);
            HashMap<Integer, Double> polinom_rez = ToateOperatiilePOLINOM.derivare(polinom1);
            txt.setText(Despart.toString(polinom_rez));
        });

        // buton integrare
        but_integrare.addActionListener(e -> {
            String p1 = textField1.getText();
            HashMap<Integer, Double> polinom1 = Despart.parse(p1);
            HashMap<Integer, Double> polinom_rez = ToateOperatiilePOLINOM.integrare(polinom1);
            txt.setText(Despart.toString(polinom_rez));
        });

    }

    public static void main(String[] args) {
        new InterfataButoane();
    }
}