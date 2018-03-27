package main;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

/**
 * Created by gcalori on 27/03/2018.
 */

public abstract class SharedPreferencesActivity extends AppCompatActivity  implements Auth{

    @Override
    public void storeAccessToken(String token) {
        SharedPreferences preferences = getSharedPreferences("spacePref",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("accessToken",token);
        editor.apply();
    }

    @Override
    public String getAccessTokenFromPref() {
        SharedPreferences preferences = getSharedPreferences("spacePref",MODE_PRIVATE);
        return preferences.getString("accessToken",null);

    }


}

