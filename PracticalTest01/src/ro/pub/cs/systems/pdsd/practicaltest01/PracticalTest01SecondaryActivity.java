package ro.pub.cs.systems.pdsd.practicaltest01;


import org.w3c.dom.Text;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01SecondaryActivity extends Activity {

	private Button ok;
	private Button cancel;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		int number=(int) this.getIntent().getExtras().get("total_number");
		TextView totalnumber= (TextView) findViewById(R.id.number_of_clicks_text_view);
		totalnumber.setText(""+number);
		
		
		ok=(Button)findViewById(R.id.ok_button);
		cancel=(Button)findViewById(R.id.cancel_button);
		
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setResult(RESULT_OK, new Intent());
		          finish();
		          
			}
		});

		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setResult(RESULT_CANCELED, new Intent());
		          finish();
			}
		});
	}

	
}
