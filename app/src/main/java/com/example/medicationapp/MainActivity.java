package com.example.medicationapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * The single Activity that hosts every screen.
 * Screens are Fragments, so adding a new screen does NOT require
 * editing AndroidManifest.xml. Just create a Fragment and call showScreen().
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // First screen shown when the app opens
        if (savedInstanceState == null) {
            showScreen(new CurrentMedicationFragment(), false);
        }
    }

    /**
     * Swap the visible screen.
     *
     * @param fragment       the screen to show
     * @param addToBackStack true  = the phone's Back button returns to the previous screen
     *                       (use for screens like Add Medication);
     *                       false = replace without history (use for tab switches)
     */
    public void showScreen(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
