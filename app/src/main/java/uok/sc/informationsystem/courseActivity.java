package uok.sc.informationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class courseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }

    public void clickCourse(View view) {
        ImageButton imageButton = findViewById(view.getId());
        String picName = imageButton.getTag().toString();

        Intent intent = new Intent(this,courseDetailsActivity.class);
        intent.putExtra("picName",picName);
        startActivity(intent);
    }
}