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
                .load("https://en.wikipedia.org/wiki/University_of_Kelaniya#/media/File:Kelaniya.png")
                .into((ImageView) findViewById(R.id.uni_image));
    }

    public void loginToView(View view){
        Intent loginIntent= new Intent(this,Login.class);
        startActivity(loginIntent);
    }

}