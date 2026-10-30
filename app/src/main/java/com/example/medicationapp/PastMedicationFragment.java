package com.example.medicationapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/** Screen 2: list of past medications (UI only, no real data yet). */
public class PastMedicationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_past_medication, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Three-dot menus show Delete only (placeholder)
        int[] moreButtons = {R.id.btnMore1, R.id.btnMore2, R.id.btnMore3};
        for (int id : moreButtons) {
            view.findViewById(id).setOnClickListener(this::showDeleteMenu);
        }

        // Bottom tab: switch to Current
        view.findViewById(R.id.tabCurrent).setOnClickListener(v ->
                ((MainActivity) requireActivity()).showScreen(new CurrentMedicationFragment(), false));
    }

    private void showDeleteMenu(View anchor) {
        PopupMenu menu = new PopupMenu(requireContext(), anchor);
        menu.getMenu().add("Delete");
        menu.setOnMenuItemClickListener(item -> {
            Toast.makeText(requireContext(), "Delete - coming soon", Toast.LENGTH_SHORT).show();
            return true;
        });
        menu.show();
    }
}
