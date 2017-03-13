package com.example.xinwen;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class wodeFragment extends Fragment implements OnClickListener  {

	  private TextView user ,guanyu;
	  private Button mExitBtn;
	  private ImageView set;
		private static boolean isExit = false;
	  

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

  View view= inflater.inflate(R.layout.wodefragment, container, false);
  
  user =(TextView) view.findViewById(R.id.user);
  set=(ImageView) view.findViewById(R.id.imageset);
  guanyu=(TextView) view.findViewById(R.id.guanyua);
  guanyu.setOnClickListener(this);
  set.setOnClickListener(this);
     Bundle bundle = getArguments();
     
     //bundle传值
      String str = bundle.getString("username");
      user.setText("用户名："+str);
      mExitBtn = (Button)view.findViewById(R.id.exit);
		 mExitBtn.setOnClickListener(this);
		return view;
		
		
		
	}
	
	
	

   
	  
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.exit:
		     exit();
			
			break;
		case R.id.imageset:
			 Intent intent1=new Intent(getActivity(),setting.class);
	 			startActivity(intent1);
			
			break;
			
		case R.id.guanyua:
			AlertDialog.Builder guanyus = new AlertDialog.Builder(getActivity());
    		
    		
    		guanyus.setTitle("关于");
    		guanyus.setMessage("Copyright© 2016  孙智红 张佳楠 张闯 版权所有 ");
    		guanyus.setIcon(R.drawable.guanyus);

    		guanyus.create().show();
			
			break;

		default:
			break;
		}
	}
	
//双击退出方法
	private void exit() {
		// TODO Auto-generated method stub
		 if (!isExit) {  
	            isExit = true;  
	            Toast.makeText(getActivity(), "再按一次退出程序", Toast.LENGTH_SHORT).show();  
	            mHandler.sendEmptyMessageDelayed(0, 2000);  
	        } else {  
	            Intent intent = new Intent(Intent.ACTION_MAIN);  
	            intent.addCategory(Intent.CATEGORY_HOME);  
	            startActivity(intent);  
	            System.exit(0);  
	        }  
		
	}
	Handler mHandler = new Handler() {  
		  
        @Override  
        public void handleMessage(Message msg) {  
            // TODO Auto-generated method stub  
            super.handleMessage(msg);  
            isExit = false;  
        }  
  
    };
	
}
