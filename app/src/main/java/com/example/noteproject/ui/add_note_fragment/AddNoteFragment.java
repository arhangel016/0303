package com.example.noteproject.ui.add_note_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.noteproject.R;
import com.example.noteproject.databinding.FragmentAddNoteBinding;

public class AddNoteFragment extends Fragment {
    private FragmentAddNoteBinding binding;
    private NavController controller;
    private Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddNoteBinding.inflate(inflater);
        controller = Navigation.findNavController(container);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
    }

    private void initListeners() {
        binding.btnSave.setOnClickListener(view -> {
            bundle = new Bundle();
            bundle.putString("title", binding.etTitle.getText().toString());
            controller.navigate(R.id.mainFragment, bundle);
        });
    }
}