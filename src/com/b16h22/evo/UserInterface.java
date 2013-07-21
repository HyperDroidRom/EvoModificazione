package com.b16h22.evo;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.actionbarsherlock.view.MenuItem;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class UserInterface extends SherlockPreferenceActivity {
    protected TextView title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);	
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);        
		//For lock screen settings
        addPreferencesFromResource(R.xml.user_interface);        
        IconPreferenceScreen iconPref = (IconPreferenceScreen) findPreference("lock");
        Resources res = getResources();
        Drawable icon = res.getDrawable(R.drawable.ic_settings_lockscreen);
        iconPref.setIcon(icon);        
        IconPreferenceScreen iconPref4 = (IconPreferenceScreen) findPreference("notifpanel");
        Resources res4 = getResources();
        Drawable icon4 = res4.getDrawable(R.drawable.ic_notify);
        iconPref4.setIcon(icon4); 
        IconPreferenceScreen iconPref5 = (IconPreferenceScreen) findPreference("profile");
        Resources res5 = getResources();
        Drawable icon5 = res5.getDrawable(R.drawable.ic_settings_profile);
        iconPref5.setIcon(icon5);
        IconPreferenceScreen iconPref6 = (IconPreferenceScreen) findPreference("statusbar");
        Resources res6 = getResources();
        Drawable icon6 = res6.getDrawable(R.drawable.ic_settings_statusbar_color);
        iconPref6.setIcon(icon6);
        IconPreferenceScreen iconPref7 = (IconPreferenceScreen) findPreference("quicksettings");
        Resources res7 = getResources();
        Drawable icon7 = res7.getDrawable(R.drawable.ic_settings_quicksettings);
        iconPref7.setIcon(icon7);
        IconPreferenceScreen iconPref8 = (IconPreferenceScreen) findPreference("statusbarlayout");
        Resources res8 = getResources();
        Drawable icon8 = res8.getDrawable(R.drawable.ic_settings_statusbar);
        iconPref8.setIcon(icon8);
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
