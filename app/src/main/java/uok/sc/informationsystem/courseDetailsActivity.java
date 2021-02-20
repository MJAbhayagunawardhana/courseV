package uok.sc.informationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;

public class courseDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        if(getIntent()!=null){
            String courseName = getIntent().getStringExtra("picName");
            int image = getResources().getIdentifier(courseName,"drawable",getPackageName());
            int textID = getResources().getIdentifier(courseName,"raw",getPackageName());
            String courseDetails = new Scanner(getResources().openRawResource(textID)).nextLine();
            TextView name = findViewById(R.id.course_name);
            name.setText(courseName.toUpperCase());
            TextView details = findViewById(R.id.course_details);
            details.setText(courseDetails);
            ImageView imageView = findViewById(R.id.course_img);
            imageView.setImageResource(image);
        }

    }

    public void clickDash(View view){
        Intent mainIntent = new Intent(this, courseActivity.class);
        startActivity(mainIntent);
    }

    public void clickMore(View view){
        ImageButton imageButton = findViewById(view.getId());
        String picName = imageButton.getTag().toString();

        Intent intent = new Intent(this,MoreActivity.class);
        intent.putExtra("picName",picName);
        startActivity(intent);
    }
}