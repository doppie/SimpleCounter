package nl.doppie.simplecounter;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jelle ten Brinke on 10-12-2015.
 */
public class S {

    public static final int P_COUNT1 = 1;
    public static final int P_COUNT2 = 2;

    public static ArrayList<Integer> getPrefsList() {
        ArrayList<Integer> prefs = new ArrayList<>();
        prefs.add(P_COUNT1);
        prefs.add(P_COUNT2);
        return prefs;
    }
}
