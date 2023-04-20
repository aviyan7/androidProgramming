package notepad;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.demoapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class NotesActivity extends AppCompatActivity {

    FloatingActionButton btnAddNote;
    ArrayList<Notes> notes;
    NotesAdapter adapter;

    ActivityResultLauncher<Intent> result = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode()== RESULT_OK){
                Intent data = result.getData();
                String title = data.getExtras().getString("title");
                adapter.addData(new Notes(title,"fun","fun"));
            }
        }
    }) ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        notes = new ArrayList<>();

        btnAddNote = findViewById(R.id.btnAddNote);
      RecyclerView rv = findViewById(R.id.rv_notes);
      adapter = new NotesAdapter(notes);
      rv.setAdapter(adapter);
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotesActivity.this, AddNotesActivity.class);
                result.launch(intent);
            }
        });
    }
}