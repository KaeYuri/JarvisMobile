package com.example.jarvis.jarvis;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import junit.framework.Test;

import java.io.IOException;

/**
 * Created by cybil_000 on 04-Apr-14.
 */
public class JarvisFragment extends Fragment {

    private MediaRecorder mediaRecorder;
    private MediaPlayer mPlayer;
    private boolean onRecord = false;
    private String mFileName;

    public JarvisFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.jarvis, container, false);
        int i = getArguments().getInt(MainActivity.ARG_MENU_NUMBER);
        String selectedMenu = getResources().getStringArray(R.array.menus_array)[i];
        getActivity().setTitle(selectedMenu);
        setButtonAction(rootView);
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/test_audio.3gp";
        return rootView;
    }

    // Click une fois pour commencer l'enregistrement; un deuxième click pour l'arreter et lancer le replay
    private void setButtonAction(View view) {
        Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if (onRecord == false) {
                    onRecord = !onRecord;
                    mediaRecorder = new MediaRecorder();
                    mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    mediaRecorder.setOutputFile(mFileName);
                    mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                    try {
                        mediaRecorder.prepare();
                    } catch (IOException e) {
                        Log.e("Exception IO", "prepare() failed");
                    }
                    mediaRecorder.start();
                } else {
                    mediaRecorder.stop();
                    onRecord = !onRecord;
                    mPlayer = new MediaPlayer();
                    try {
                        mPlayer.setDataSource(mFileName);
                        mPlayer.prepare();
                        mPlayer.start();
                    } catch (IOException e) {
                        Log.e("Exception IO", "prepare() failed");
                    }
                }
            }

        });
    }
}
