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

public class youke_mefragment extends Fragment implements OnClickListener {
	
	private Button denglu;
	private TextView qr,guanyu;
	private ImageView imgwx;
	private ImageView imgwb;
	private ImageView imgqq;

	
	private TextView textwx;
	private TextView textwb;
	private TextView textqq;
	
    private Button mExitBtn;
	private static boolean isExit = false;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		 View view= inflater.inflate(R.layout.youke_me, container, false);
		 
		 denglu=(Button) view.findViewById(R.id.dengru);
		 qr=(TextView) view.findViewById(R.id.QR);
		 
		 denglu.setOnClickListener(this);
		 qr.setOnClickListener(this);
		 
		 imgwx=(ImageView) view.findViewById(R.id.imagewxo);
		 imgwx.setOnClickListener(this);
		 imgwb=(ImageView) view.findViewById(R.id.imagewbo);
		 imgwb.setOnClickListener(this);
		 imgqq=(ImageView) view.findViewById(R.id.imageqqo);
		 imgqq.setOnClickListener(this);
		 
		 textwx=(TextView) view.findViewById(R.id.WX);
		 textwx.setOnClickListener(this);
		 textwb=(TextView) view.findViewById(R.id.WB);
		 textwb.setOnClickListener(this);
		 textqq=(TextView) view.findViewById(R.id.QQ);
		 textqq.setOnClickListener(this);
		 
		 guanyu=(TextView) view.findViewById(R.id.guanyu);
		 guanyu.setOnClickListener(this);
		 
	
		 
		 mExitBtn = (Button)view.findViewById(R.id.exit);
		 mExitBtn.setOnClickListener(this);

			return view;

}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.dengru:
			
			 Intent intent =new Intent(getActivity(),Login.class);
	     		getActivity().startActivity(intent);
			
			
			break;
		case R.id.QR:
			
			 Intent intent1 =new Intent(getActivity(),registration.class);
	     		getActivity().startActivity(intent1);
	     	break;
	     	  case R.id.imagewxo:
		        	 if(youke_mefragment.this!=null&&youke_mefragment.this.isAdded()){  
		        		    Toast.makeText(getActivity(), "你未安装微信", Toast.LENGTH_SHORT).show();  
		        		    }  
		     		break;
		     		
		         case R.id.imagewbo:
		        	 if(youke_mefragment.this!=null&&youke_mefragment.this.isAdded()){  
		        		    Toast.makeText(getActivity(), "你未安装微博", Toast.LENGTH_SHORT).show();  
		        		    }  
		     		break;
		         case R.id.imageqqo:
		        	 if(youke_mefragment.this!=null&&youke_mefragment.this.isAdded()){  
		        		    Toast.makeText(getActivity(), "你未安装qq", Toast.LENGTH_SHORT).show();  
		        		    }  
		     		break;
		     		
		         case R.id.WB:
		        	 if(youke_mefragment.this!=null&&youke_mefragment.this.isAdded()){  
		        		    Toast.makeText(getActivity(), "你未安装微信", Toast.LENGTH_SHORT).show();  
		        		    }  
		     		break;
		         case R.id.WX:
		        	 if(youke_mefragment.this!=null&&youke_mefragment.this.isAdded()){  
		        		    Toast.makeText(getActivity(), "你未安装微博", Toast.LENGTH_SHORT).show();  
		        		    }  
		     		break;
		         case R.id.QQ:
		        	 if(youke_mefragment.this!=null&&youke_mefragment.this.isAdded()){  
		        		    Toast.makeText(getActivity(), "你未安装qq", Toast.LENGTH_SHORT).show();  
		        		    }  
		     		break;
		     		
		         case R.id.exit:
		             exit();
		            break;
		            
		    
		           
		          
		         case R.id.guanyu:
		        	 
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
		  
       
        public void handleMessage(Message msg) {  
            // TODO Auto-generated method stub  
            super.handleMessage(msg);  
            isExit = false;  
        }  
  
    };
	
}
