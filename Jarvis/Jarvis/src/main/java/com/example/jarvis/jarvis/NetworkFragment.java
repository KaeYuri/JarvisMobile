package com.example.jarvis.jarvis;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by cybil_000 on 04-Apr-14.
 */
public class NetworkFragment extends Fragment{

    String  ip;
    int     port;

    public NetworkFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.network, container, false);
        int i = getArguments().getInt(MainActivity.ARG_MENU_NUMBER);
        String selectedMenu = getResources().getStringArray(R.array.menus_array)[i];
        getActivity().setTitle(selectedMenu);

        setOnClickButton(rootView);
        return rootView;
    }

    private void setOnClickButton(View view) {

        Button connectButton = (Button) view.findViewById(R.id.button);
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.d("DEBUG", "Network test button");
                    new RetrieveFeedTask().execute(ip);
                } catch (Exception e) {
                    Log.e("Exception IO", "create Socket() failed.");
                }
            }
        });
    }
}
