package com.obilet.android.kariyernetchallange.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Mustafa Bayram on 20.11.2018.
 */
public class LocalStorage {

    private SharedPreferences sharedPreferences;
    private Gson gson;

    public LocalStorage(Context context, Gson gson) {
        this.gson = gson;
        sharedPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }

    public boolean storeObject(String key, Object value) {
        String s = gson.toJson(value);
        return sharedPreferences.edit().putString(key, s).commit();
    }

    public boolean storeBoolean(String key, boolean value) {
        return sharedPreferences.edit().putBoolean(key, value).commit();
    }


    public <T> T getObject(String key, Class<T> objectClass, T defaultValue) {
        T returnObject;
        String cipherText = sharedPreferences.getString(key, null);

        if (cipherText == null) {
            return defaultValue;
        }

        try {
            returnObject = gson.fromJson(cipherText, objectClass);
        } catch (Exception e) {
            returnObject = defaultValue;
        }
        return returnObject == null ? defaultValue : returnObject;
    }


    public boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public boolean remove(String key) {
        return sharedPreferences.edit().remove(key).commit();
    }


    public List<String> getAllKeys() {
        List<String> keys = new ArrayList<>();
        Map<String, ?> allEntries = sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            keys.add(entry.getKey());
        }
        return keys;
    }
}

