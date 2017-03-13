package com.example.xinwen;



import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registration extends Activity implements OnClickListener {
    private MySqliteHelper helper;
    
    Button sign;  
    Button zhuce;
    
    String  name;
    String  mypwd;
    private EditText user;
    private EditText pwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.registration);
		
		zhuce=(Button) findViewById(R.id.zhuce);
		zhuce.setOnClickListener(this);
	      user = (EditText)findViewById(R.id.editText1);
	       pwd=(EditText)findViewById(R.id.editText2);	
	}
//定义茶如数据库的方法
	 public void  insert()
	 {
	     

	      helper = new MySqliteHelper(getApplicationContext());
	      SQLiteDatabase db=helper.getWritableDatabase();    
	      
	      //查询一下，是否用户名重复
	       String sql1 = "select * from users";
	       Cursor cursor = db.rawQuery(sql1, null);
	       while (cursor.moveToNext()) {
	          //第一列为id
	          name =  cursor.getString(1); //获取第2列的值,第一列的索引从0开始
	          mypwd = cursor.getString(2);//获取第3列的值
	         
	      }
	      
	     if((user.getText().toString().equals(name)))
	         {
	                Toast.makeText(this, "已存在此用户，请重新注册", Toast.LENGTH_SHORT).show(); 
	         }
	         else
	          {
	             String sql2 = "insert into users(name,pwd) values ('"+user.getText().toString()+"','"+pwd.getText().toString()+"')";
	                db.execSQL(sql2);
	               Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show(); 
	          }
	     
	 }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		insert();
		
	}
	

}
