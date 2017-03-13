package com.example.xinwen;



import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends FragmentActivity implements OnClickListener {
	

	private MySqliteHelper helper;
    String  name;
	String  mypwd;
    private EditText user;
    private EditText pwd;
	private Button login,youke;
	private ImageView imgwx;
	private ImageView imgwb;
	private ImageView imgqq;
	private TextView reg; 

	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		login=(Button) findViewById(R.id.logins);
		youke=(Button) findViewById(R.id.youke);
		reg=(TextView) findViewById(R.id.textreg);
		youke.setOnClickListener(this);
		login.setOnClickListener(this);
		reg.setOnClickListener(this);
		
		user=(EditText) findViewById(R.id.editname);
		pwd=(EditText) findViewById(R.id.editpassword);
		
		imgwx=(ImageView) findViewById(R.id.imagewx);
		imgwb=(ImageView) findViewById(R.id.imagewb);
		imgqq=(ImageView) findViewById(R.id.imageQQ);

		
	
		imgwx.setOnClickListener(this);
		imgwb.setOnClickListener(this);
		imgqq.setOnClickListener(this);
		
			
	       
	         }
	
	  public void select()
	  {
	      
	       helper = new MySqliteHelper(getApplicationContext());
	       SQLiteDatabase db=helper.getWritableDatabase();
	         
	       String sql = "select * from users";
	       
	       Cursor cursor = db.rawQuery(sql, null);
	       while (cursor.moveToNext()) {
	           //第一列为id
	           name =  cursor.getString(1); //获取第2列的值,第一列的索引从0开始
	           mypwd = cursor.getString(2);//获取第3列的值
	          
	       }
	       
	       if((user.getText().toString().equals(name))&&(pwd.getText().toString().equals(mypwd)))
	          {
	                 Toast.makeText(this, "用户验证成功", Toast.LENGTH_SHORT).show(); 
	                 Intent intent1 = new Intent(Login.this,MainActivity.class);
	                 intent1.putExtra("username", name);
	               
	                   startActivity(intent1);  
	                   finish();//退出
	          }
	          else
	           {
	                 Toast.makeText(this, "账号或者密码错误,请重新输入", Toast.LENGTH_SHORT).show();  
	           }
	       
	                 cursor.close();
	                 db.close();
	                 //Toast.makeText(this, "已经关闭数据库", Toast.LENGTH_SHORT).show();  
	  }




	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {
		case R.id.logins:
			
			select();  
			break;
		case R.id.youke:
			
            Intent intent3 = new Intent(Login.this,youkefragment.class);
	        
	        startActivity(intent3);   
			
	        break;
			
         case R.id.textreg:
			
			Intent intent = new Intent(Login.this,registration.class);
	        
	        startActivity(intent);  
			break;
	        case R.id.imagewx:
				Toast.makeText(Login.this, "您没安装有微信",Toast.LENGTH_SHORT).show();
				break;
				
			case R.id.imagewb:
			Toast.makeText(Login.this, "您没安装有微博",Toast.LENGTH_SHORT).show();
			break;
			
			case R.id.imageQQ:
			Toast.makeText(Login.this, "您没安装有QQ",Toast.LENGTH_SHORT).show();
			break;  
			

		default:
			break;
		}
		  
		
		
	}
}



	


	
