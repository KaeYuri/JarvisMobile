package com.example.jarvis.jarvis;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by cybil_000 on 04-Apr-14.
 */
public class ProfilFragment extends Fragment{

    public ProfilFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profil, container, false);
        int i = getArguments().getInt(MainActivity.ARG_MENU_NUMBER);
        String selectedMenu = getResources().getStringArray(R.array.menus_array)[i];
        getActivity().setTitle(selectedMenu);

        // Fill the spinner with the language array define in strings.xml
        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return rootView;
    }
}
