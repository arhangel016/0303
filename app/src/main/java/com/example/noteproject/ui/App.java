package com.example.noteproject.ui;

import android.app.Application;

import com.example.noteproject.ui.main_fragment.NoteAdapter;

public class App extends Application {

    public static NoteAdapter adapter;

    @Override
    public void onCreate() {
        super.onCreate();
        adapter = new NoteAdapter();
    }
}
