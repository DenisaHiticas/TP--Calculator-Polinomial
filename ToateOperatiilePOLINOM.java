package operatii;

//importez biblioteci necesare pentru a face HASHMAPPINGUL
import java.util.HashMap;
import java.util.Map;

//clasa ToateOperatiilePOLINOM este clasa in interiorul careia am implementate operatiile de :
// adunare, scadere,inmultire,derivare si integrare
public class ToateOperatiilePOLINOM {

    //metoda care aduna doua POLINOAME numita ADUNARE
    public static HashMap<Integer, Double> adunare(HashMap<Integer, Double> p1, HashMap<Integer, Double> p2) {
        //formez un map de o  variabila intreaga (exponentul_meu) si un double adica coeficientul_,meu
        HashMap<Integer, Double> rezultatul_meu = new HashMap<>();
        for (Map.Entry<Integer, Double> in : p1.entrySet()) {
            //declarari
            int exponentul_meu;
            double coeficientul_meu;
            exponentul_meu = in.getKey(); //iau exponentul fiecarei parti din polinomul mare
            coeficientul_meu = in.getValue(); //iau coeficientul fiecarei parti din polinomul mare
            rezultatul_meu.put(exponentul_meu, coeficientul_meu);
            // adaugă exponentul si  coeficientul la HashMap-ul rezultatul_meu
        }
        //pentru fiecare pereche din al doilea polinom, dacă exponentul există deja în rezultatul_meu,
        // valoarea sa este adunată cu coeficientul din perechea curentă. În caz contrar, perechea este adăugată la rezultatul_meu
        for (Map.Entry<Integer, Double> in : p2.entrySet()) {
            //declarari
            int exponentul_meu;
            double coeficientul_meu;
            exponentul_meu = in.getKey(); //iau exponentul
            coeficientul_meu = in.getValue(); //iau coeficientul
            if (rezultatul_meu.containsKey(exponentul_meu)) { //daca in rezultatul actual am deja exponentul ala
                double rez_vechi = rezultatul_meu.get(exponentul_meu);
                //valoarea sa este adunată cu coeficientul din perechea curentă
                rezultatul_meu.put(exponentul_meu, rez_vechi + coeficientul_meu);
            } else
                rezultatul_meu.put(exponentul_meu, coeficientul_meu);
                //În caz contrar, perechea este adăugată la "rezultatul_meu
        }
        //printez rezultatul adunarii a 2 polinoame
        return rezultatul_meu;
    }

    //metoda care scade doua POLINOAME numita SCADERE
    public static HashMap<Integer, Double> scadere(HashMap<Integer, Double> p1, HashMap<Integer, Double> p2) {
        //formez un map de o  variabila intreaga (exponentul_meu) si un double adica coeficientul_,meu
        HashMap<Integer, Double> rezultatul_meu = new HashMap<>();
        for (Map.Entry<Integer, Double> in1 : p1.entrySet()) {
            //declarari
            int exponentul_meu;
            double coeficientul_meu;
            exponentul_meu= in1.getKey(); //iau exponentul
           coeficientul_meu = in1.getValue(); //iau coeficientul
            //formez rezulultatul mini pentru p1
            rezultatul_meu.put(exponentul_meu, coeficientul_meu);
        }
        for (Map.Entry<Integer, Double> in2 : p2.entrySet()) {
            //declarari
            int exponentul_meu;
            double coeficientul_meu,rez_vechi;
            exponentul_meu = in2.getKey(); //iau exponentul
            coeficientul_meu = in2.getValue(); //iau coeficientul
            if (rezultatul_meu.containsKey(exponentul_meu)) { //daca in rezultatul actual am deja exponentul ala
                 rez_vechi = rezultatul_meu.get(exponentul_meu);
                 //modific rezultatul facand scaderea
                rezultatul_meu.put(exponentul_meu, rez_vechi - coeficientul_meu);
            } else
                rezultatul_meu.put(exponentul_meu, -coeficientul_meu);
            //În caz contrar, perechea este adăugată la rezultatul_meu
        }
        //printez rezultatul scaderii a 2 polinoame
        return rezultatul_meu;
    }
    //metoda care inmulteste doua POLINOAME numita INMULTIRE
    public static HashMap<Integer, Double> inmultire(HashMap<Integer, Double> p1, HashMap<Integer, Double> p2) {
        //declarari
        int exponentul_meu;
        double coeficientul_meu;
        //formez un map de o  variabila intreaga (exponentul_meu) si un double adica coeficientul_,meu
        HashMap<Integer, Double> rezultatul_meu = new HashMap<>();
        for (Map.Entry<Integer, Double> in1: p1.entrySet()) {
            for (Map.Entry<Integer, Double> in2 : p2.entrySet()) {
                exponentul_meu = in2.getKey() + in2.getKey(); // se aduna exponentii daca am bazele egale
                coeficientul_meu = in2.getValue() * in2.getValue(); //se inmultesc coeficientii normal
                rezultatul_meu.put(exponentul_meu, rezultatul_meu.getOrDefault(exponentul_meu, 0.0) + coeficientul_meu);
            }
        }
        //printez rezultatul inmultirii a 2 polinoame
        return rezultatul_meu;
    }
    //metoda care deriveaza un POLINOM numita DERIVARE
    public static HashMap<Integer, Double> derivare(HashMap<Integer, Double> p) {
        //declarari
        int exponentul_meu;
        double coeficientul_meu;
        //formez un map de o  variabila intreaga  adica exponentul_meu si un double adica coeficientul_meu
        HashMap<Integer, Double> rezultatul_meu = new HashMap<>();
        for (Map.Entry<Integer, Double> in : p.entrySet()) {
            exponentul_meu = in.getKey(); //iau exponentul
            coeficientul_meu= in.getValue(); //iau coeficientul
            if (exponentul_meu != 0) {
                //folosim fromula de la derivare x^n derivat= n*x^(n-1)
                rezultatul_meu.put(exponentul_meu - 1, coeficientul_meu * exponentul_meu);
            }
        }
        //printez rezultatul derivarii unui polinom

        return rezultatul_meu;
    }
    //metoda care integreaza un POLINOM numita INTEGRARE
    public static HashMap<Integer, Double> integrare(HashMap<Integer, Double> p) {
        //declarari
        int exponentul_meu;
        double coeficientul_meu;
        //formez un map de o  variabila intreaga adica exponentul_meu si un double adica coeficientul_meu
        HashMap<Integer, Double> rezultatul_meu = new HashMap<>();
        for (Map.Entry<Integer, Double> in : p.entrySet()) {
            exponentul_meu = in.getKey(); //iau exponentul
            coeficientul_meu = in.getValue(); //iau coeficientul
            //folosim formula de la integrare x^n integrat= x^(n+1) /(n+1)
            rezultatul_meu.put(exponentul_meu + 1, coeficientul_meu / (exponentul_meu + 1));
        }
        //printez rezultatul integrarii unui polinom
        return rezultatul_meu;
    }
}