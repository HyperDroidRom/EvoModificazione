package com.b16h22.evo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class AboutActivity extends SherlockActivity {
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true); 
		setContentView(R.layout.about);
		
		LinearLayout rom =(LinearLayout) findViewById(R.id.rom);
		
		rom.setOnClickListener(new View.OnClickListener() {
			 
			@Override
			public void onClick(View v) {

				 Uri uri = Uri.parse("http://forum.xda-developers.com/showthread.php?t=1757125");
				 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				 startActivity(intent);

		        };
		});
		
		LinearLayout theme =(LinearLayout) findViewById(R.id.theme);
		
		theme.setOnClickListener(new View.OnClickListener() {
			 
			@Override
			public void onClick(View v) {

				 Uri uri = Uri.parse("http://forum.xda-developers.com/showthread.php?t=2129475");
				 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				 startActivity(intent);

		        };
		});
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
