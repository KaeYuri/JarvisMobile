package com.example.jarvis.jarvis;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by cybil_000 on 12-Apr-14.
 */
public class RetrieveFeedTask extends AsyncTask<String, Void, Void> {

    private Exception exception;

    protected Void doInBackground(String... urls) {
        String msg;
        byte[] tab = new byte[512];
        Log.d("DEBUG", "Test envoie message");
        try {
//            Socket sock = new Socket("127.0.0.1", 4242, false);
//            sock.connect(new InetSocketAddress(4242));
            Process p = Runtime.getRuntime().exec("ping www.google.com");
            InputStream inputStream = p.getInputStream();
            inputStream.read(tab);
            Log.d("DEBUG", tab.toString());
//            outputStream.flush();
        } catch (Exception e) {
            this.exception = e;
        }
        return null;
    }

    protected void onPostExecute() {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}
