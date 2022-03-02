package com.example.noteproject.ui.main_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteproject.data.models.NoteModel;
import com.example.noteproject.databinding.ItemNoteBinding;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private ItemNoteBinding binding;
    private List<NoteModel> list = new ArrayList<>();

    public void setList(List<NoteModel> title) {
        this.list = title;
        notifyDataSetChanged();
    }
    public void addItem(NoteModel title) {
        this.list.add(title);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new NoteViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(NoteModel title) {
            binding.tvItemTitle.setText(title.getTitle());
        }
    }
}
