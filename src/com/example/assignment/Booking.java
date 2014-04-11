package com.example.assignment;



import java.sql.SQLException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Booking extends Activity {
   
        EditText edit1,edit2,edit3, edit4, edit5;
        Button submit;

        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.booking_layout);
             final DBAdapter db = new DBAdapter(this);
            
				try {
					db.open();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
             edit1=(EditText)findViewById(R.id.surnameInput);
             edit2=(EditText)findViewById(R.id.firstnameinput);
             edit3=(EditText)findViewById(R.id.addressinput);
             edit4=(EditText)findViewById(R.id.phoneinput);
             edit5=(EditText)findViewById(R.id.emailInput);
             
             submit=(Button)findViewById(R.id.book);
            submit.setOnClickListener(new OnClickListener(){


                public void onClick(View v) {
                    String editText1=edit1.getText().toString();
                    String editText2=edit2.getText().toString();
                    String editText3=edit3.getText().toString();
                    String editText4=edit4.getText().toString();
                    String editText5=edit5.getText().toString();
                    long result=db.insertTitle(editText1, editText2, editText3, editText4, editText5);
                    Toast.makeText(Booking.this,"DataSaved",Toast.LENGTH_LONG).show();// TODO Auto-generated method stub

                }

				@Override
				public void onClick(android.view.View v) {
					// TODO Auto-generated method stub
					   String editText1=edit1.getText().toString();
	                    String editText2=edit2.getText().toString();
	                    String editText3=edit3.getText().toString();
	                    String editText4=edit4.getText().toString();
	                    String editText5=edit5.getText().toString();
	                    long result1=db.insertTitle(editText1, editText2, editText3, editText4, editText5);
	                    Toast.makeText(Booking.this,"DataSaved",Toast.LENGTH_LONG).show();// TODO Auto-generated method stub
				}

            });
        }
    }


