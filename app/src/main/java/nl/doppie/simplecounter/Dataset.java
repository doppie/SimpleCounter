package nl.doppie.simplecounter;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jelle ten Brinke on 10-12-2015.
 */
public class Dataset extends Application {

    private SharedPreferences prefs;
    private HashMap<Integer, String> storedData;

    @Override
    public void onCreate() {
        super.onCreate();

        storedData = new HashMap<Integer, String>();
        prefs = getSharedPreferences("counter", Context.MODE_PRIVATE);

        readStoredData();

        if(getStoredData(S.P_COUNT1).isEmpty()) updateStoredData(S.P_COUNT1, 0 + "");
        if(getStoredData(S.P_COUNT2).isEmpty()) updateStoredData(S.P_COUNT2, 0 + "");
    }

    /* Shared Preferences methods */
    private void readStoredData() {
        ArrayList<Integer> prefsList = S.getPrefsList();
        for (int pref_id : prefsList) {
            String value = prefs.getString("counter." + pref_id, "");
            storedData.put(pref_id, value);
        }
    }

    private void saveStoredData() {
        for (int key : storedData.keySet()) {
            prefs.edit().putString("counter." + key, storedData.get(key)).commit();
        }
    }

    public String getStoredData(int key) {
        return storedData.get(key);
    }

    public void updateStoredData(int key, String value) {

        switch (key) {
            default:
                storedData.put(key, value);
                break;
        }

        saveStoredData();
    }

    public void clearStoredData(int key) {
        storedData.put(key, "");
        saveStoredData();
    }
}
