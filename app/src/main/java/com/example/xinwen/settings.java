package com.example.xinwen;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class settings extends Activity implements OnClickListener {
	
private TextView guanyu2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		guanyu2=(TextView) findViewById(R.id.guanyu2);
		guanyu2.setOnClickListener(this);
		setContentView(R.layout.settings);
	
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.exitlogin:
	
			
			break;
			
		case R.id.guanyu2:
			AlertDialog.Builder guanyus = new AlertDialog.Builder(this);
    		
    		
    		guanyus.setTitle("关于");
    		guanyus.setMessage("Copyright© 2016  孙智红 张佳楠 张闯 版权所有 ");
    		guanyus.setIcon(R.drawable.guanyus);

    		guanyus.create().show();
			
			break;

		default:
			break;
		}
		
	}
	

}
