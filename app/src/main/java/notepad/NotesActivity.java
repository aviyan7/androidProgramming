package notepad;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.demoapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class NotesActivity extends AppCompatActivity {

    FloatingActionButton btnAddNote;
    ArrayList<Notes> notes;
    NotesAdapter adapter;
    NotebookDbHelper dbHelper;
    LinearLayout llNoNotes;


    ActivityResultLauncher<Intent> result = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode()== RESULT_OK){
                Intent data = result.getData();
                String title = data.getExtras().getString("title");
                String description = data.getExtras().getString("description");
                String category = data.getExtras().getString("category");
                Notes notes = new Notes(title,description,category);
                adapter.addData(notes);
                dbHelper.addNote(notes);
                if(llNoNotes.getVisibility() == View.VISIBLE){
                    llNoNotes.setVisibility(View.GONE);
                }
            }
        }
    }) ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        dbHelper = new NotebookDbHelper(getApplicationContext());

        btnAddNote = findViewById(R.id.btnAddNote);
        llNoNotes = findViewById(R.id.ll_no_notes);
        notes = new ArrayList<>();
        notes.addAll(dbHelper.getAllNotes());
        if(notes.size()<1){
            llNoNotes.setVisibility(View.VISIBLE);
        } else {
            llNoNotes.setVisibility(View.GONE);
        }
      RecyclerView rv = findViewById(R.id.rv_notes);
      adapter = new NotesAdapter(notes, new NoteListener(){

          @Override
          public void onNoteClick(Notes note) {
              Intent intent = new Intent(NotesActivity.this, DetailView.class);
              intent.putExtra("title", note.getTitle());
              startActivity(intent);
          }

          @Override
          public void onNoteEditPress(Notes note) {

          }

          @Override
          public void onNoteDeletePress(Notes note) {
              AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(NotesActivity.this);
              alertDialogBuilder.setTitle("Are you sure you want to delete ?");
              AlertDialog alertDialog = alertDialogBuilder.create();
              alertDialog.show();
          }
      });
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