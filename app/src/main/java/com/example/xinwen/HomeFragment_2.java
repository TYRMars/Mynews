package com.example.xinwen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HomeFragment_2 extends Fragment implements OnClickListener {
	
	
	private ImageView new3,new4;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home_2, null);
		new3=(ImageView) view.findViewById(R.id.new3);
		new4=(ImageView) view.findViewById(R.id.new4);
		new3.setOnClickListener(this);
		new4.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.new3:
			Intent intent=new Intent(getActivity(),xinwen4.class);
			startActivity(intent);
			
			break;
			
         case R.id.new4:
        	 
        	 Intent intent1=new Intent(getActivity(),xinwen3.class);
 			startActivity(intent1);
			
			break;

		default:
			break;
		
	}
	
	}

}
