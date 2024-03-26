import operatii.ToateOperatiilePOLINOM;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
//clasa in care se testeaza operatiile: adunare, scadere,inmultire,derivare,integrare

    class ToateOperatiilePOLINOMTest {

        private static void assertMapsEqual(HashMap<Integer, Double> expected, HashMap<Integer, Double> actual) {
            assertEquals(expected.size(), actual.size(), "Nu se potrivesc marimile");
            int exponentul_meu;
            double coeficientul_meu_actual, coeficientul_rezultat_bun;
            for (Map.Entry<Integer, Double> entry : expected.entrySet()) {
                exponentul_meu = entry.getKey();
                coeficientul_rezultat_bun = entry.getValue();
                coeficientul_meu_actual = actual.getOrDefault(exponentul_meu, 0.0);
                assertEquals(coeficientul_rezultat_bun, coeficientul_meu_actual, 1e-9, "Nu e oke exp " + exponentul_meu);
            }
        }
        @Test
        void testAdunare() {
            HashMap<Integer, Double> p1 = new HashMap<>();
            p1.put(2, 3.0);
            p1.put(1, 2.0);

            HashMap<Integer, Double> p2 = new HashMap<>();
            p2.put(2, 2.0);
            p2.put(0, 1.0);

            HashMap<Integer, Double> expected = new HashMap<>();
            expected.put(2, 5.0);
            expected.put(1, 2.0);
            expected.put(0, 1.0);

            HashMap<Integer, Double> rezultatul_meu = ToateOperatiilePOLINOM.adunare(p1, p2);
            assertMapsEqual(expected, rezultatul_meu);
        }
        @Test

        void testScadere() {
            HashMap<Integer, Double> p1 = new HashMap<>();
            p1.put(2, 3.0);
            p1.put(1, 2.0);

            HashMap<Integer, Double> p2 = new HashMap<>();
            p2.put(2, 2.0);
            p2.put(0, 1.0);

            HashMap<Integer, Double> rezultat_bun = new HashMap<>();
            rezultat_bun.put(2, 1.0);
            rezultat_bun.put(1, 2.0);
            rezultat_bun.put(0, -1.0);

            HashMap<Integer, Double> rezultatul_meu = ToateOperatiilePOLINOM.scadere(p1, p2);
            assertMapsEqual(rezultat_bun, rezultatul_meu);
        }

        @Test
        void testInmultire() {
            HashMap<Integer, Double> p1 = new HashMap<>();
            p1.put(2, 3.0);
            p1.put(1, 2.0);

            HashMap<Integer, Double> p2 = new HashMap<>();
            p2.put(2, 1.0);
            p2.put(1, -1.0);

            HashMap<Integer, Double> expected = new HashMap<>();
            expected.put(3, 0.0);
            expected.put(2, 2.0);

            HashMap<Integer, Double> result = ToateOperatiilePOLINOM.inmultire(p1, p2);
            assertMapsEqual(expected, result);
        }

        @Test
        void testDerivare() {
            HashMap<Integer, Double> p = new HashMap<>();
            p.put(2, 3.0);
            p.put(1, 2.0);

            HashMap<Integer, Double> rezultat_bun = new HashMap<>();
            rezultat_bun.put(1, 6.0);
            rezultat_bun.put(0, 2.0);

            HashMap<Integer, Double> rezultatul_meu = ToateOperatiilePOLINOM.derivare(p);
            assertMapsEqual(rezultat_bun, rezultatul_meu);
        }
        @Test
        void testIntegrare() {
            HashMap<Integer, Double> p = new HashMap<>();
            p.put(2, 3.0);
            p.put(1, 2.0);

            HashMap<Integer, Double> rezultat_bun = new HashMap<>();
            rezultat_bun.put(3, 1.0);
            rezultat_bun.put(2, 1.0);

            HashMap<Integer, Double> rezultatul_meu = ToateOperatiilePOLINOM.integrare(p);
            assertMapsEqual(rezultat_bun, rezultatul_meu);
        }
    }
