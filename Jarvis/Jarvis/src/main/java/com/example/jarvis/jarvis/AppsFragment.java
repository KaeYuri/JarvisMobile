package com.example.jarvis.jarvis;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by cybil_000 on 04-Apr-14.
 */
public class AppsFragment extends Fragment {

    String[] connectedApps = {"VLC", "Machine a cafe", "EditText"};

    public AppsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.apps, container, false);
        int i = getArguments().getInt(MainActivity.ARG_MENU_NUMBER);
        String selectedMenu = getResources().getStringArray(R.array.menus_array)[i];
        getActivity().setTitle(selectedMenu);

        // Fill the listView with connected apps
        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, connectedApps);
        listView.setAdapter(adapter);
        return rootView;
    }
}
