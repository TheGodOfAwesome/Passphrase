package com.example.passphrase;



import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
 
import java.util.ArrayList;
 
public class MyActivity extends Activity
{
    private ListView mList;
    private ArrayList arrayList;
    private MyCustomAdapter mAdapter;
    private TCPClient mTcpClient;
 
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
 
        arrayList = new ArrayList();
 
        
        Button send = (Button)findViewById(R.id.send_button);
 
        //relate the listView from java to the one created in xml
        mList = (ListView)findViewById(R.id.list);
        mAdapter = new MyCustomAdapter(this, arrayList);
        mList.setAdapter(mAdapter);
 
        // connect to the server
        new connectTask().execute("");
 
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
 
                String Request = "client:Requesting Passphrase. . .";
 
                //add the text in the arrayList
                arrayList.add(Request);
 
                //sends the message to the server
                if (mTcpClient != null) {
                    mTcpClient.sendMessage(Request);
                }
 
                //refresh the list
                mAdapter.notifyDataSetChanged();
            }
        });
 
    }
 
    public class connectTask extends AsyncTask<String,String,TCPClient> {
 
        @Override
        protected TCPClient doInBackground(String... message) {
 
            //we create a TCPClient object and
            mTcpClient = new TCPClient(new TCPClient.OnMessageReceived() {
                @Override
                //here the messageReceived method is implemented
                public void messageReceived(String message) {
                    //this method calls the onProgressUpdate
                    publishProgress(message);
                }
            });
            mTcpClient.run();
 
            return null;
        }
 
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
 
            //in the arrayList we add the messaged received from server
            arrayList.add(values[0]);
            // notify the adapter that the data set has changed. This means that new message received
            // from server was added to the list
            mAdapter.notifyDataSetChanged();
        }
    }
}