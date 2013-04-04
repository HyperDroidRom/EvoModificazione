package com.b16h22.evo;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.actionbarsherlock.view.MenuItem;
import com.b16h22.evo.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Toast;


public class MainActivity extends SherlockPreferenceActivity {
    private static final String TAG = "MainActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);       
        addPreferencesFromResource(R.xml.preferences);
        IconPreferenceScreen test = (IconPreferenceScreen) findPreference("ui");
        Resources res = getResources();
        Drawable icon = res.getDrawable(R.drawable.ic_settings_ui);
        test.setIcon(icon);
        IconPreferenceScreen test1 = (IconPreferenceScreen) findPreference("utility");
        Resources res1 = getResources();
        Drawable icon1 = res1.getDrawable(R.drawable.ic_settings_utilities);
        test1.setIcon(icon1);
        IconPreferenceScreen test2 = (IconPreferenceScreen) findPreference("about");
        Resources res2 = getResources();
        Drawable icon2 = res2.getDrawable(R.drawable.ic_settings_about);
        test2.setIcon(icon2);        
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
