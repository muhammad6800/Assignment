package com.example.assignment;



import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {
 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TabHost tabHost = getTabHost();
        
        // Tab for Photos
        TabSpec photospec = tabHost.newTabSpec("Booking");
        photospec.setIndicator("Booking", getResources().getDrawable(R.drawable.ic_launcher));
        Intent photosIntent = new Intent(this, Booking.class);
        photospec.setContent(photosIntent);
        
        // Tab for Photos
        TabSpec view = tabHost.newTabSpec("View");
        view.setIndicator("View Booking", getResources().getDrawable(R.drawable.ic_launcher));
        Intent ViewIntent = new Intent(this, View.class);
        view.setContent(ViewIntent);
   
        
        // Adding all TabSpec to TabHost
        tabHost.addTab(photospec); // Adding photos tab
        tabHost.addTab(view);
       
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}