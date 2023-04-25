package notepad;

public interface NoteListener {

    void onNoteClick(Notes note);

    void onNoteEditPress(Notes note);
    void onNoteDeletePress(Notes note);
}
