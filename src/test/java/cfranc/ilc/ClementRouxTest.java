/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfranc.ilc;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author cr877826
 */
public class ClementRouxTest {

    public ClementRouxTest() {
    }

    String[] when2SimpleWords = new String[]{"parapluie", "parachute", "parapente"};

    @Test
    public void getSimilarity_2SimpleWords_26() {

        MarkovWord m = new MarkovWord();
        double expected = 0.33;
        double actual = m.getSimilarity(when2SimpleWords[0], when2SimpleWords[1], 2);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void getSimilarity_SameWord_100() {

        MarkovWord m = new MarkovWord();
        double expected = 1.0;
        double actual = m.getSimilarity(when2SimpleWords[0], when2SimpleWords[0], 4);
        assertEquals(expected, actual, 0.000000001);
    }

    @Test
    public void common_SameWord_10() {

        MarkovWord m = new MarkovWord();

        double expected = 10;
        double actual = m.common(m.processString(when2SimpleWords[0], 2), m.processString(when2SimpleWords[0], 2));
        assertEquals(expected, actual, 1);
    }

    @Test
    public void common_2SimpleWord_5() {

        MarkovWord m = new MarkovWord();

        double expected = 5;
        double actual = m.common(m.processString(when2SimpleWords[0], 2), m.processString(when2SimpleWords[1], 2));
        assertEquals(expected, actual, 1);
    }

    @Test
    public void union_SameWord_15() {

        MarkovWord m = new MarkovWord();

        double expected = 20 - 5;
        double actual = m.union(m.processString(when2SimpleWords[0], 2), m.processString(when2SimpleWords[1], 2));
        assertEquals(expected, actual, 1);
    }

    @Test
    public void union_2SimpleWord_15() {

        MarkovWord m = new MarkovWord();

        double expected = 20 - 6;
        double actual = m.union(m.processString(when2SimpleWords[0], 2), m.processString(when2SimpleWords[2], 2));
        assertEquals(expected, actual, 1);
    }

    @Test
    public void processString_ab_ab() {

        String motTest = "ab";
        List<MarkovData> expected = new ArrayList<MarkovData>();
        expected.add(new MarkovData("%a", 1));
        expected.add(new MarkovData("ab", 1));
        expected.add(new MarkovData("b%", 1));
        MarkovWord m = new MarkovWord();
        List<MarkovData> actual = m.processString(motTest, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void contains_pa_1() {

        MarkovWord m = new MarkovWord(when2SimpleWords[0], 2);

        int actual = m.contains("pa");
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void contains_azed_0() {

        MarkovWord m = new MarkovWord(when2SimpleWords[0], 2);

        int actual = m.contains("azed");
        int expected = 0;

        assertEquals(expected, actual);
    }



    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
