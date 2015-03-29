package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends Activity {

	protected static final int requestCode = 0;
	private EditText textnumber1;
	private EditText textnumber2;
	private Button pressme;
	private Button pressme2;
	private Button navigate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		textnumber1=(EditText) findViewById(R.id.textnumber01);
		textnumber2=(EditText) findViewById(R.id.textnumber02);
		 if (savedInstanceState != null) {
		      String leftCount = savedInstanceState.getString("leftCount");
		      if (leftCount != null) {
		    	  textnumber1.setText(leftCount);
		      } else {
		    	  textnumber1.setText(String.valueOf(0));
		      }
		      String rightCount = savedInstanceState.getString("rightCount");
		      if (rightCount != null) {
		    	  textnumber2.setText(rightCount);
		      } else {
		    	  textnumber2.setText(String.valueOf(0));
		      }
		    } else {
		    	textnumber1.setText(String.valueOf(0));
		    	textnumber2.setText(String.valueOf(0));
		    }
		 
		 
		
        pressme=(Button)findViewById(R.id.buttonpressme);
        pressme2=(Button)findViewById(R.id.buttonpressme2);
        
        navigate=(Button)findViewById(R.id.navigateTo);
        
        navigate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(PracticalTest01MainActivity.this, PracticalTest01SecondaryActivity.class);
				i.putExtra("total_number",Integer.parseInt(textnumber1.getText().toString()) + Integer.parseInt(textnumber2.getText().toString()) );
				startActivityForResult(i, requestCode);
			}
		});
        
        
        pressme.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int oldNumber=Integer.parseInt(textnumber1.getText().toString())+1;
				textnumber1.setText(Integer.toString(oldNumber));
				
			}
		});
        
        
        pressme2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int oldNumber2=Integer.parseInt(textnumber2.getText().toString())+1;
				textnumber2.setText(Integer.toString(oldNumber2));
				
			}
		});
	}

	

	 @Override
	  protected void onSaveInstanceState(Bundle savedInstanceState) {
	    EditText leftEditText = (EditText)findViewById(R.id.textnumber01);
	    EditText rightEditText = (EditText)findViewById(R.id.textnumber02);
	    savedInstanceState.putString("leftCount", leftEditText.getText().toString());
	    savedInstanceState.putString("rightCount", rightEditText.getText().toString());
	  }
	 
	 @Override
	  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    Toast.makeText(this, "The activity returned with result "+resultCode, Toast.LENGTH_LONG).show();
	  }
	
}
