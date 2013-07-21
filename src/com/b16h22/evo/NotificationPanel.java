package com.b16h22.evo;

import org.jraf.android.backport.switchwidget.SwitchPreference;

import net.margaritov.preference.colorpicker.ColorPickerPreference;

import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;

public class NotificationPanel extends SherlockPreferenceActivity {
	
    String color;
    String clock;
    String color1;
    String color2;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);  
        addPreferencesFromResource(R.xml.notification_panel);
        IconPreferenceScreen iconPref = (IconPreferenceScreen) findPreference("quickpanel");
        Resources res = getResources();
        Drawable icon = res.getDrawable(R.drawable.ic_settings_quickpanel);
        iconPref.setIcon(icon);         
        Boolean switchPref = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE).getBoolean("switchOn",false);
        ((SwitchPreference)findPreference("battery")).setChecked(switchPref);
        Boolean switchPrefClock = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE).getBoolean("switchOnClock",false);
        ((SwitchPreference)findPreference("clock")).setChecked(switchPrefClock);
        Boolean switchPrefDay = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE).getBoolean("switchOnDay",false);
        ((SwitchPreference)findPreference("day")).setChecked(switchPrefDay);


        ((ColorPickerPreference)findPreference("backgroundColor")).setOnPreferenceChangeListener(new OnPreferenceChangeListener() {

			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				color = (ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(newValue))));;
				preference.setSummary(color);
	            SharedPreferences sharedPreferences = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE);
	            SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	            editor.putString("backgroundColor", color); //true or false
	            editor.commit();
				Intent intent = new Intent();
				intent.setAction("com.b16h22.statusbar.CHANGE_BACKGROUND");
				intent.putExtra("color",color.toString());
				sendBroadcast(intent);				
				return false;
			}

        });
        String bgcolor = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE).getString("backgroundColor","#f9111111");
	    
	    ((ColorPickerPreference)findPreference("backgroundColor")).setDefaultValue(bgcolor);
	    ((ColorPickerPreference)findPreference("backgroundColor")).setSummary(bgcolor);
	    
        ((SwitchPreference)findPreference("battery")).setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
		        if (newValue.toString().equals("true")) {
					Intent intent = new Intent();
					intent.setAction("com.b16h22.statusbar.HIDE_BATTERY");
					sendBroadcast(intent);
		            SharedPreferences sharedPreferences = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE);
		            SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
		            editor.putBoolean("switchOn", true); //true or false
		            editor.commit();
		        } else {
					Intent intent = new Intent();
					intent.setAction("com.b16h22.statusbar.UNHIDE_BATTERY");
					sendBroadcast(intent);
		            SharedPreferences sharedPreferences = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE);
		            SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
		            editor.putBoolean("switchOn", false); //true or false
		            editor.commit();
		        }
				return true;
				
			}
        });
 
        ((SwitchPreference)findPreference("clock")).setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
		        if (newValue.toString().equals("true")) {
					Intent intent = new Intent();
					intent.setAction("com.b16h22.statusbar.HIDE_CLOCK");
					sendBroadcast(intent);
		            SharedPreferences sharedPreferences = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE);
		            SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
		            editor.putBoolean("switchOnClock", true); //true or false
		            editor.commit();
		        } else {
					Intent intent = new Intent();
					intent.setAction("com.b16h22.statusbar.UNHIDE_CLOCK");
					sendBroadcast(intent);
		            SharedPreferences sharedPreferences = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE);
		            SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
		            editor.putBoolean("switchOnClock", false); //true or false
		            editor.commit();
		        }
				return true;
				
			}
        });
        
        
        
        ((ColorPickerPreference)findPreference("clockColor")).setOnPreferenceChangeListener(new OnPreferenceChangeListener() {

 			@Override
 			public boolean onPreferenceChange(Preference preference, Object newValue) {
 				clock = (ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(newValue))));;
 				preference.setSummary(clock);
 	            SharedPreferences sharedPreferences = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE);
 	            SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
 	            editor.putString("clockColor", clock); //true or false
 	            editor.commit();
 				Intent intent = new Intent();
 				intent.setAction("com.b16h22.statusbar.CHANGE_CLOCK_COLOR");
 				intent.putExtra("clockcolor",clock.toString());
 				sendBroadcast(intent);				
 				return false;
 			}

         });
         String clockcolor = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE).getString("clockColor","#ffffffff");
 	    
 	    ((ColorPickerPreference)findPreference("clockColor")).setDefaultValue(clockcolor);
 	    ((ColorPickerPreference)findPreference("clockColor")).setSummary(clockcolor);
 	    
        ((SwitchPreference)findPreference("day")).setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
		        if (newValue.toString().equals("true")) {
					Intent intent = new Intent();
					intent.setAction("com.b16h22.statusbar.HIDE_DAY");
					sendBroadcast(intent);
		            SharedPreferences sharedPreferences = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE);
		            SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
		            editor.putBoolean("switchOnDay", true); //true or false
		            editor.commit();
		        } else {
					Intent intent = new Intent();
					intent.setAction("com.b16h22.statusbar.UNHIDE_DAY");
					sendBroadcast(intent);
		            SharedPreferences sharedPreferences = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE);
		            SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
		            editor.putBoolean("switchOnDay", false); //true or false
		            editor.commit();
		        }
				return true;
				
			}
        }); 	    
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
