package com.example.xinwen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class youkefragment extends FragmentActivity implements OnClickListener {
	
	private FrameLayout framelaout;
	private ImageView xinwen;
	private ImageView huati;
	private ImageView wode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		changeFragment(new xinwenFragment(), "xinwenfragment");
		setContentView(R.layout.youkemoshi);
		
		initView();
		xinwen.setImageResource(R.drawable.new1);

}
	
	private void initView() {
		framelaout=(FrameLayout) findViewById(R.id.framelaout);
		xinwen =(ImageView) findViewById(R.id.xinwen);
		huati=(ImageView) findViewById(R.id.huati);
		wode=(ImageView) findViewById(R.id.wode);
		
		xinwen.setOnClickListener(this);
		huati.setOnClickListener(this);
		wode.setOnClickListener(this);
		
	}

    private void resetImgs() 
	{
		xinwen.setImageResource(R.drawable.new2);
		huati.setImageResource(R.drawable.b2);
		wode.setImageResource(R.drawable.me2);
	}

	@Override
	public void onClick(View view) {
	
		
		
		
		switch (view.getId()) {
		case R.id.xinwen:
			 resetImgs();
			changeFragment(new xinwenFragment(), "xinwenfragment");
			
			xinwen.setImageResource(R.drawable.new1);
			
			break;
        case R.id.huati:
        	 resetImgs();
        	 changeFragment(new huatiFragment(), "huatifragment");
			huati.setImageResource(R.drawable.b1);
		
			
			break;
         case R.id.wode:
        	
        	 resetImgs();
        	 changeFragment(new youke_mefragment (), "youke_mefragment");
    			wode.setImageResource(R.drawable.me1);
    		
	        break; 

		default:
			break;
		}
		
		
	}


	public void changeFragment(Fragment fragment ,String tag){
		
		
		FragmentManager supportFragmentManager=	getSupportFragmentManager();
		FragmentTransaction beginTransaction= supportFragmentManager.beginTransaction();

		beginTransaction.replace(R.id.framelaout,fragment ,tag);
		beginTransaction.commit();
	}


}