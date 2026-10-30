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

/** Screen 1: list of current medications (UI only, no real data yet). */
public class CurrentMedicationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_current_medication, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Three-dot menus show Edit / Delete (placeholders for now)
        int[] moreButtons = {R.id.btnMore1, R.id.btnMore2, R.id.btnMore3};
        for (int id : moreButtons) {
            view.findViewById(id).setOnClickListener(this::showEditDeleteMenu);
        }

        // Add Medication: placeholder until the Add Medication screen is built.
        // To hook it up later, replace the Toast with:
        //   ((MainActivity) requireActivity()).showScreen(new AddMedicationFragment(), true);
        view.findViewById(R.id.rowAddMedication).setOnClickListener(v ->
                Toast.makeText(requireContext(), "Add Medication - coming soon",
                        Toast.LENGTH_SHORT).show());

        // Bottom tab: switch to Past
        view.findViewById(R.id.tabPast).setOnClickListener(v ->
                ((MainActivity) requireActivity()).showScreen(new PastMedicationFragment(), false));
    }

    private void showEditDeleteMenu(View anchor) {
        PopupMenu menu = new PopupMenu(requireContext(), anchor);
        menu.getMenu().add("Edit");
        menu.getMenu().add("Delete");
        menu.setOnMenuItemClickListener(item -> {
            Toast.makeText(requireContext(), item.getTitle() + " - coming soon",
                    Toast.LENGTH_SHORT).show();
            return true;
        });
        menu.show();
    }
}
