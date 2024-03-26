package polinom;
//importez bibliotecile pentru regex si map
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Clasa "Despart" este o clasă Java care reprezintă un polinom sub formă de șir de caractere
//și oferă metode pentru a parsa șirul și a-l converti într-un obiect HashMap.
public class Despart {
    //am un sir d ecaractere
    private String poliString;
    //si un hashmap
    private HashMap<Integer, Double> poliMap;
//constructor cu acelasi nume ac si clasa
    public Despart(String poliString) {
        this.poliString = poliString;
        this.poliMap = Despart.parse(poliString);
    }

 //Metoda getMap() returnează obiectul "poliMap" de tip HashMap
    public HashMap<Integer, Double> getMap() {
        return this.poliMap;
    }
//Metoda parse primește un șir de caractere ce reprezintă un polinom
// și returneaza un obiect de tip HashMap<Integer, Double> care conține coeficienții și exponentii acestuia
    public static HashMap<Integer, Double> parse(String polinom) {

        //compilează o expresie regulată pentru a extrage coeficienții și exponentele din șirul de polinom
        Pattern pattern = Pattern.compile("([+-]?\\d*)x\\^(\\d*)");
        //avem matvher pentru a efectua căutarea în șirul de polinom folosind expresia regulată
        Matcher matcher = pattern.matcher(polinom);
        //declarari si initializam cu 0 exp si coeficientul
        int coeficientul_meu=0,exponentul_meu=0;
        double rez_vechi;
        HashMap<Integer, Double> poliMap = new HashMap<>();
        //parcurgem  și adaugăm coeficienții corespunzători într-un obiect de tip HashMap
        while (matcher.find()) {
            // Verifica daca primul grup din expresia regulata
            // este gol sau contine semnul "+" si stabileste coeficientul corespunzator
            if (matcher.group(1).isEmpty() || matcher.group(1).equals("+"))
                        coeficientul_meu = 1;
             else if (matcher.group(1).equals("-"))
                        coeficientul_meu = -1;
             else
                         coeficientul_meu = Integer.parseInt(matcher.group(1));
            // Daca al doilea grup din expresia regulata  nu este gol,
            // converteste valoarea din String la int si o atribuie variabilei exponentul_meu
            if (!matcher.group(2).isEmpty()) {
                exponentul_meu = Integer.parseInt(matcher.group(2));
            }
            // Daca polinomul deja contine un termen cu acelasi exponent, aduna coeficientul actual la
            // coeficientul vechi si pune valoarea noua in mapa poliMap
            if (poliMap.containsKey(exponentul_meu) ) {
                 rez_vechi = poliMap.get(exponentul_meu);
                poliMap.put(exponentul_meu, rez_vechi + coeficientul_meu);
            } else
                //pune termenul in mapa
               // cu coeficientul actual si exponentul actual
                poliMap.put(exponentul_meu, (double) coeficientul_meu);

        }
     //returnam map ul rezultat
        return poliMap;
    }
//metoda TOSTRING
    public static String toString(HashMap<Integer, Double> poli) {
        //declarari
        StringBuilder strbuilder= new StringBuilder();
        boolean e_primul = true;
        int maxi_exp = -1;
        // vrem sa gasim cel mai mare exponent din toti ce ii am
        for ( int exp_act : poli.keySet())
            //dc exp actual >maxi, maxi primeste exp actual
            if (exp_act > maxi_exp)
                maxi_exp = exp_act;

        //afisam frumos de la exponentul maxim pana la 0 deci inn ordine descresc
        for ( int exp_act = maxi_exp; exp_act >= 0; exp_act--) {
            if (!poli.containsKey(exp_act))
                continue;
            double coeficientul_meu = poli.get(exp_act);

            // Dacă coeficientul este 0, nu facem nimic și trecem la următorul termen
            if (coeficientul_meu == 0)
                continue;
            // Dacă este primul termen, adaugă un semn minus dacă coeficientul este negativ
            if (e_primul) {
                e_primul = false;
                if (coeficientul_meu < 0)
                    strbuilder.append("-");
            } else
                strbuilder.append(coeficientul_meu > 0 ? " + " : " - ");

            // Adaugă coeficientul (dacă este diferit de 1 sau exponentul este 0)
            if (coeficientul_meu != 1 || exp_act == 0)
                strbuilder.append(Double.toString(Math.abs(coeficientul_meu)));
            //Adaug variabila x și exponentul (dacă exponentul este diferit de 0 sau 1)
            if (exp_act != 0) {
                strbuilder.append("x");
                if (exp_act != 1)
                    strbuilder.append("^").append(Integer.toString(exp_act));
            }
        }
        // Dacă polinomul este 0, afișează 0
        if (strbuilder.length() == 0)
            strbuilder.append("0");
        //returnm
        return strbuilder.toString();
    }
}