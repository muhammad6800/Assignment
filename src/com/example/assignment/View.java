package com.example.assignment;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class View extends Activity {

	DBAdapter db;
	Cursor c;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view);
		db=new DBAdapter(this);
		db.open();
		
		c=db.getTitle();
		String[] columns = new String[] {"task_name", "complete"}; 
		int[] into = new int[] {R.id.task_name, R.id.complete};
		SimpleCursorAdapter mAdapter=new SimpleCursorAdapter(this, R.layout.view, c, columns, into);
		
		this.setListAdapter(mAdapter);
		//fourth part of the lab 
			// OnlistIteClick (int position, )
			// getITem(position) 
			// get string 
			//  intent  put extra ( name ,, )
			// start activity 
		
		
	}
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
   
}