package notepad;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demoapp.R;

public class DetailView extends AppCompatActivity {
    TextView title, description, category;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_view);

        title = findViewById(R.id.tit);
        category = findViewById(R.id.cat);
        description = findViewById(R.id.des);
    }
}
