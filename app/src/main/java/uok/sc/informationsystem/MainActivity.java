package uok.sc.informationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Picasso.get()
                .load("https://www.vectorstock.com/royalty-free-vector/book-education-university-logo-vector-19952793.jpg")
                .into((ImageView) findViewById(R.id.uni_image));
    }

    public void loginToView(View view){
        Intent loginIntent= new Intent(this,Login.class);
        startActivity(loginIntent);
    }

}