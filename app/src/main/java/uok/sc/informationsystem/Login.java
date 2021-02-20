package uok.sc.informationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button regBtn,logBtn;
    EditText userEdit,passwordEdit;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseHelper =new DatabaseHelper(this);

        userEdit = findViewById(R.id.et_user);
        passwordEdit = findViewById(R.id.password);

        logBtn =findViewById(R.id.login_btn);
        regBtn = findViewById(R.id.register_btn);


    }
    public void loginToRegisterView(View view){
        Intent regIntent= new Intent(this,Registration.class);
        startActivity(regIntent);
    }
        public void OnClickLogin(View view){
            String username = userEdit.getText().toString();
            String pword = passwordEdit.getText().toString();

            Boolean checklogin = databaseHelper.CheckLogin(username,pword);
            if(checklogin== true){
                //Toast.makeText(getApplicationContext(),"Login Successful!!!!",Toast.LENGTH_LONG).show();

                Intent courseView= new Intent(this,courseActivity.class);
                startActivity(courseView);
            }
            else{
                Toast.makeText(getApplicationContext(),"Invalid username or password!!!Please Check",Toast.LENGTH_LONG).show();
            }
        }
}