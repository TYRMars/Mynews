package com.example.xinwen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HomeFragment_1 extends Fragment implements OnClickListener {
	private ImageView new1,new2;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home_1, null);
		new1=(ImageView) view.findViewById(R.id.xinwen1);
		new2=(ImageView) view.findViewById(R.id.xinwen2);
		new1.setOnClickListener(this);
		new2.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.xinwen1:
			Intent intent=new Intent(getActivity(),xinwen1.class);
			startActivity(intent);
			
			break;
			
         case R.id.xinwen2:
        	 
        	 Intent intent1=new Intent(getActivity(),xinwen2.class);
 			startActivity(intent1);
			
			break;

		default:
			break;
		}
		
	}
	


}
