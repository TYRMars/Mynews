package com.example.xinwen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity implements OnClickListener{
	
	private FrameLayout framelaout;
	private ImageView xinwen;
	private ImageView huati;
	private ImageView wode;
  private String username;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		changeFragment(new xinwenFragment(), "xinwenfragment");
		
		
		initView();
		
		xinwen.setImageResource(R.drawable.new1);
		
		Intent intent = getIntent();
		username =intent.getStringExtra("username");
		
		
		

		
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
        	 wodeFragment fragment = new wodeFragment();
        	 
        	 changeFragment(fragment, "wodefragment");
    			wode.setImageResource(R.drawable.me1);
    			
    			
    			Bundle bundle = new Bundle();
    			bundle.putString("username", username);
    			fragment.setArguments(bundle);
    			
    		
	        break; 

		default:
			break;
		}
		
		
	}

//定义changefragment方法来切换界面
	public void changeFragment(Fragment fragment ,String tag){
		
		//获取管理者
		FragmentManager supportFragmentManager=	getSupportFragmentManager();
		//开启事务
		FragmentTransaction beginTransaction= supportFragmentManager.beginTransaction();

		beginTransaction.replace(R.id.framelaout,fragment ,tag);
		beginTransaction.commit();
	}


	
}
