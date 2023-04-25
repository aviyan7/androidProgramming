package notepad;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demoapp.R;

public class DetailView extends AppCompatActivity {
    TextView Title, Description, Category;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String title = getIntent().getExtras().getString("tit");
        setContentView(R.layout.detail_view);

        Title = findViewById(R.id.tit);
        Category = findViewById(R.id.cat);
        Description = findViewById(R.id.des);

        Title.setText("Title is :" + title);
    }
}
