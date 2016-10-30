package com.example.administrator.project1030;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button button= (Button) findViewById(R.id.btnset);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=((EditText)findViewById(R.id.username)).getText().toString();
                String pwd=((EditText)findViewById(R.id.password)).getText().toString();

                boolean flag=false;
                String index="";
                for(int i=0;i<Data.USER.length;i++)
                {
                    if(number.equals(Data.USER[i][0]))
                    {
                        if(pwd.equals(Data.USER[i][1]))
                        {
                            index=Data.USER[i][2];
                            flag=true;
                            break;
                        }
                    }
                }
                if(flag)
                {
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putInt("Index",Integer.parseInt(index));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else
                {
                    Toast toast=Toast.makeText(LoginActivity.this,"你输入的账号或密码错误!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM,0,0);
                    toast.show();
                }
            }
        });
    }
}
