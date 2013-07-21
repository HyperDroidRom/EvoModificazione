package com.b16h22.evo;

import net.margaritov.preference.colorpicker.ColorPickerPreference;

import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.actionbarsherlock.view.MenuItem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;

public class StatusBar extends SherlockPreferenceActivity {
	
    String color;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);  
        addPreferencesFromResource(R.xml.status_bar);
        
        IconPreferenceScreen iconPref1 = (IconPreferenceScreen) findPreference("edt");
        Resources res1 = getResources();
        Drawable icon1 = res1.getDrawable(R.drawable.ic_settings_edt);
        iconPref1.setIcon(icon1);
        //For battery bar
        IconPreferenceScreen iconPref2 = (IconPreferenceScreen) findPreference("battery");
        Resources res2 = getResources();
        Drawable icon2 = res2.getDrawable(R.drawable.ic_settings_battery);
        iconPref2.setIcon(icon2);        

        ((ColorPickerPreference)findPreference("statusbarColor")).setOnPreferenceChangeListener(new OnPreferenceChangeListener() {

			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				color = (ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(newValue))));;
				preference.setSummary(color);
	            SharedPreferences sharedPreferences = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE);
	            SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	            editor.putString("statusbarColor", color); //true or false
	            editor.commit();
				Intent intent = new Intent();
				intent.setAction("com.b16h22.statusbar.CHANGE_STATUSBAR_BACKGROUND");
				intent.putExtra("statbarColor",color.toString());
				sendBroadcast(intent);				
				return false;
			}

        });
        String bgcolor = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE).getString("statusbarColor","#ff000000");
	    
	    ((ColorPickerPreference)findPreference("statusbarColor")).setDefaultValue(bgcolor);
	    ((ColorPickerPreference)findPreference("statusbarColor")).setSummary(bgcolor);
	    
 
	}
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case android.R.id.home:

                    Intent intent = new Intent(this, UserInterface.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
	}
}
