package notepad;

public interface NoteListener {
    void setNotes(Notes note);

    void onNoteClick(Notes note);

    void onNoteEditPress(Notes note);
    void onNoteDeletePress(Notes note);
}
