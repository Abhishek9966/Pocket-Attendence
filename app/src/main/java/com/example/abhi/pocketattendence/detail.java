package com.example.abhi.pocketattendence;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;

public class detail  extends Activity {

    //update ateendence+1 in course where mac+address is same;
    SQLiteDatabase mdatabase;
    //DatabaseHelper mydb;
    TextView txt;
    Button btnAtd,btnDetails;
    String course;

    //Bluetooth
    ListView listViewPaired;
    ListView listViewDetected;
    ArrayList<String> arrayListpaired;
    ArrayAdapter<String> adapter,detectedAdapter;
    static HandleSeacrh handleSeacrh;
    ArrayList<BluetoothDevice> arrayListPairedBluetoothDevices;
    //private ButtonClicked clicked;
    //ListItemClickedonPaired listItemClickedonPaired;
    BluetoothAdapter bluetoothAdapter = null;
    ArrayList<BluetoothDevice> arrayListBluetoothDevices = null;
    ListView listview;
    // ListItemClicked listItemClicked;

    //Bluetooth
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        //Log.i("Log","hello");
        Intent intent=getIntent();
        course=intent.getExtras().getString("course");
        //txt=findViewById(R.id.txt1);
        btnAtd = (Button)findViewById(R.id.button_viewAll);
        btnDetails = (Button)findViewById(R.id.button_add);
        //txt.setText(course);


        //mydb=new DatabaseHelper(this);
        //viewAll();
        // AddData();
        //Log.i("tag","In Main");
        Attendence();
        // present_student(arrayListBluetoothDevices);


    }

   /* public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean insert=mydb.insertData("kailash","19","MC16129");

                       /* mydb.insertData("kailash1","167918","MC16128");
                        mydb.insertData("kailash2","167917","MC16127");
                        mydb.insertData("kailash3","167916","MC16126");
                        mydb.insertData("kailash4","167915","MC16125");
                        mydb.insertData("kailash5","167914","MC16124");
                        mydb.insertData("kailash6","167913","MC16123");
                        mydb.insertData("kailash7","167912","MC16122");
                        mydb.insertData("kailash8","167911","MC16121");
                        mydb.insertData("kailash9","167910","MC16120");
                        */
                        /*if(insert == true)
                            Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getApplicationContext(),"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = mydb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Roll No :"+ res.getString(2)+"\n");
                            buffer.append("Reg No :"+ res.getString(3)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }*/


    public void Details(View view){
        //Intent intent=new Intent(this,Student.class);
       // intent.putExtra("course",course);
       // startActivity(intent);

    }
    //Bluetooth
    public void Attendence(){
        btnAtd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayListpaired = new ArrayList<String>();
                bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                handleSeacrh = new HandleSeacrh();
                arrayListBluetoothDevices = new ArrayList<BluetoothDevice>();
                onBluetooth();
                arrayListBluetoothDevices.clear();
                // Log.i("tag","In Attendence");
                startSearching();
            }
        });
    }
    //@Override
    /*protected void onStart() {
        super.onStart();
        //if(onBluetooth()) {
        if(arrayListBluetoothDevices.size()>0)
            arrayListBluetoothDevices.clear();
            startSearching();
       // }

    }*/



    class HandleSeacrh extends Handler
    {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 111:
                    break;

                default:
                    break;
            }
        }
    }

    private void onBluetooth() {
        if(!bluetoothAdapter.isEnabled())
        {
            bluetoothAdapter.enable();
            // Log.i("Log", "Bluetooth is Enabled");
        }
    }


    private BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Message msg = Message.obtain();
            String action = intent.getAction();
            // Log.i("tag","In Broadcast");
            if(BluetoothDevice.ACTION_FOUND.equals(action)){
                //Toast.makeText(context, "ACTION_FOUND", Toast.LENGTH_SHORT).show();

                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                try
                {
                    //device.getClass().getMethod("setPairingConfirmation", boolean.class).invoke(device, true);
                    //device.getClass().getMethod("cancelPairingUserInput", boolean.class).invoke(device);
                }
                catch (Exception e) {
                    //Log.i("Log", "Inside the exception: ");
                    e.printStackTrace();
                }

                if(arrayListBluetoothDevices.size()<1) // this checks if the size of bluetooth device is 0,then add the
                {                                           // device to the arraylist.
                    //detectedAdapter.add(device.getName()+"\n"+device.getAddress());
                    // Log.i("tag","In one");
                    arrayListBluetoothDevices.add(device);
                    present_student(arrayListBluetoothDevices);
                    // Log.i("log",arrayListBluetoothDevices.get(0).getAddress());
                    //detectedAdapter.notifyDataSetChanged();
                }
                else
                {
                    boolean flag = true;    // flag to indicate that particular device is already in the arlist or not
                    //Log.i("tag","In Multiple");
                    for(int i = 0; i<arrayListBluetoothDevices.size();i++)
                    {
                        // Log.i("log",arrayListBluetoothDevices.get(i).getAddress());
                        if(device.getAddress().equals(arrayListBluetoothDevices.get(i).getAddress()))
                        {
                            flag = false;
                        }
                    }
                    if(flag == true)
                    {
                        //detectedAdapter.add(device.getName()+"\n"+device.getAddress());
                        arrayListBluetoothDevices.add(device);
                        present_student(arrayListBluetoothDevices);
                        // detectedAdapter.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private void startSearching() {
        //Log.i("Log", "in the start searching method");
        IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        detail.this.registerReceiver(myReceiver, intentFilter);
        bluetoothAdapter.startDiscovery();
        present_student(arrayListBluetoothDevices);
    }

    //Bluetooth

    public void present_student(ArrayList<BluetoothDevice> arrayListBluetoothDevices){
        /*Intent intent=new Intent(detail.this,Present.class);
        intent.putExtra("device",arrayListBluetoothDevices);
        startActivity(intent);*/
        //arrayListBluetoothDevices=(ArrayList<BluetoothDevice>)getIntent().getSerializableExtra("device");
        // Log.i("tag","In Methos");
        listview=(ListView)findViewById(R.id.listview1);

        ArrayAdapter ad=new ArrayAdapter<BluetoothDevice>(this,R.layout.activity_listview,arrayListBluetoothDevices);
        listview.setAdapter(ad);
    }
}



