package uok.sc.informationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    EditText et_username, et_password, et_cpassword;
    Button btn_register, btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        databaseHelper = new DatabaseHelper(this);
        et_username = findViewById(R.id.registerUser);
        et_password =findViewById(R.id.registerPassword);
        et_cpassword = findViewById(R.id.registerConfirm);
        btn_register = findViewById(R.id.register_btn);
        btn_login = findViewById(R.id.registerLogin);

    }
    public void loginToLogViewFromRegistration(View view){
        Intent lgIntent= new Intent(this,Login.class);
        startActivity(lgIntent);
    }

    public void registerForSystem(View view){
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();
        String cpassword = et_cpassword.getText().toString();

        if(username.equals("") || password.equals("")|| cpassword.equals("") ){
            Toast.makeText(getApplicationContext(),"Fiels Required",Toast.LENGTH_LONG).show();
        }
        else{
            if(password.equals(cpassword)){
                Boolean checkusername = databaseHelper.CheckUsername(username);
                if(checkusername == true){
                    Boolean insert = databaseHelper.CheckUsername(username);
                    if(insert == true){
                        Toast.makeText(getApplicationContext(),"You are successfully Registered",Toast.LENGTH_LONG).show();
                        et_username.setText("");
                        et_password.setText("");
                        et_cpassword.setText("");

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"This username already taken",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Confirm Password does not match with password",Toast.LENGTH_LONG).show();
                }
            }
        }

    }



}