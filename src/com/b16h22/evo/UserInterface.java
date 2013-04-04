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
        IconPreferenceScreen test = (IconPreferenceScreen) findPreference("lock");
        Resources res = getResources();
        Drawable icon = res.getDrawable(R.drawable.ic_settings_lockscreen);
        test.setIcon(icon);
        //For edt tweaks
        IconPreferenceScreen test1 = (IconPreferenceScreen) findPreference("edt");
        Resources res1 = getResources();
        Drawable icon1 = res1.getDrawable(R.drawable.ic_settings_edt);
        test1.setIcon(icon1);
        //For battery bar
        IconPreferenceScreen test2 = (IconPreferenceScreen) findPreference("battery");
        Resources res2 = getResources();
        Drawable icon2 = res2.getDrawable(R.drawable.ic_settings_battery);
        test2.setIcon(icon2);
        //For battery bar
        IconPreferenceScreen test3 = (IconPreferenceScreen) findPreference("quickpanel");
        Resources res3 = getResources();
        Drawable icon3 = res3.getDrawable(R.drawable.ic_settings_quickpanel);
        test3.setIcon(icon3);        
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
