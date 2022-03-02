package com.example.noteproject.ui.main_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.noteproject.R;
import com.example.noteproject.data.models.NoteModel;
import com.example.noteproject.databinding.FragmentMainBinding;
import com.example.noteproject.ui.App;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    private FragmentMainBinding binding;
    private NavController controller;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater);
         controller = Navigation.findNavController(container);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
        initRv();
    }

    private void initRv() {
        binding.rvNote.setAdapter(App.adapter);
        if (getArguments() != null) {
            String title = getArguments().getString("title");
            App.adapter.addItem(new NoteModel(title));
        }
    }

    private void initListener() {
        binding.btnAdd.setOnClickListener(view -> {
            controller.navigate(R.id.addNoteFragment);
        });
    }
}