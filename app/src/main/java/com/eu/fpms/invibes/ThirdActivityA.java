package com.eu.fpms.invibes;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivityA extends AppCompatActivity {

    EditText _etRTm, _etRTM, _etRHm, _etRHM, _etRBm, _etRBM;
    Button _bRSave;
    private final static int SEND_SMS_PERMISSION_REQUEST_CODE = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_a);

        final DatabaseHelper databaseHelper = new DatabaseHelper(this);

        _etRTm = (EditText)findViewById(R.id.etRTm);
        _etRTM = (EditText)findViewById(R.id.etRTM);
        _etRHm = (EditText)findViewById(R.id.etRHm);
        _etRHM = (EditText)findViewById(R.id.etRHM);
        _etRBm = (EditText)findViewById(R.id.etRBm);
        _etRBM = (EditText)findViewById(R.id.etRBM);

        _bRSave = (Button)findViewById(R.id.bRSave);
        _bRSave.setEnabled(false);

        if(checkPermission(Manifest.permission.SEND_SMS)){

            _bRSave.setEnabled(true);

        }else{

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, SEND_SMS_PERMISSION_REQUEST_CODE);

        }

        Bundle bundle=getIntent().getExtras();

        final String username=bundle.getString("username");

        _bRSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String RTmin=_etRTm.getText().toString();
                String RTmax=_etRTM.getText().toString();
                String RHmin=_etRHm.getText().toString();
                String RHmax=_etRHM.getText().toString();
                String RBmin=_etRBm.getText().toString();
                String RBmax=_etRBM.getText().toString();

                User currentUserPref = databaseHelper.fetchUserInfo(username);

                String TminValue=currentUserPref.getTmin();
                String TmaxValue=currentUserPref.getTmax();
                String HmaxValue=currentUserPref.getHmax();
                String HminValue=currentUserPref.getHmin();
                String BminValue=currentUserPref.getBmin();
                String BmaxValue=currentUserPref.getBmax();
                String phoneNumber=currentUserPref.getPhone();

                String RTminS = RTmin;
                String TminValueS = TminValue;
                int RTminI = Integer.parseInt(RTminS);
                int TminValueI = Integer.parseInt(TminValueS);

                if(RTminI<TminValueI){

                    String message = "Tourne un peu la vanne du radiateur. Il ne fait que "+RTminI+" °C.";

                    if(checkPermission(Manifest.permission.SEND_SMS)){

                    sendSMS(phoneNumber,message);

                    }else{

                        Toast.makeText(ThirdActivityA.this,"Permission SMS refusée", Toast.LENGTH_SHORT).show();

                    }
                    //System.out.println(message);

                }

                String RTmaxS = RTmax;
                String TmaxValueS = TmaxValue;
                int RTmaxI = Integer.parseInt(RTmaxS);
                int TmaxValueI = Integer.parseInt(TmaxValueS);

                if(RTmaxI>TmaxValueI){

                    String message = "Ouvre un peu une fenêtre. Il fait chaud ici, il fait "+RTmaxI+" °C.";

                    if(checkPermission(Manifest.permission.SEND_SMS)){

                        sendSMS(phoneNumber,message);

                    }else{

                        Toast.makeText(ThirdActivityA.this,"Permission SMS refusée", Toast.LENGTH_SHORT).show();

                    }

                    //System.out.println(message);

                }

                String RHminS = RHmin;
                String HminValueS = HminValue;
                int RHminI = Integer.parseInt(RHminS);
                int HminValueI = Integer.parseInt(HminValueS);

                if(RHminI<HminValueI){

                    String message = "Il fait sec ici : "+RHminI+" %. Ouvre une fenêtre pour aérer un peu.";

                    if(checkPermission(Manifest.permission.SEND_SMS)){

                        sendSMS(phoneNumber,message);

                    }else{

                        Toast.makeText(ThirdActivityA.this,"Permission SMS refusée", Toast.LENGTH_SHORT).show();

                    }

                    //System.out.println(message);

                }

                String RHmaxS = RHmax;
                String HmaxValueS = HmaxValue;
                int RHmaxI = Integer.parseInt(RHmaxS);
                int HmaxValueI = Integer.parseInt(HmaxValueS);

                if(RHmaxI>HmaxValueI){

                    String message = "Il fait tellement humide ici : "+RHmaxI+" % que je vais croire qu'il pleut à l'intérieur.";

                    if(checkPermission(Manifest.permission.SEND_SMS)){

                        sendSMS(phoneNumber,message);

                    }else{

                        Toast.makeText(ThirdActivityA.this,"Permission SMS refusée", Toast.LENGTH_SHORT).show();

                    }

                    //System.out.println(message);

                }

                String RBminS = RBmin;
                String BminValueS = BminValue;
                int RBminI = Integer.parseInt(RBminS);
                int BminValueI = Integer.parseInt(BminValueS);

                if(RBminI<BminValueI){

                    String message = "Il est temps de changer ma batterie. Je suis à plat. Il ne me reste que "+RBminI+" %.";

                    if(checkPermission(Manifest.permission.SEND_SMS)){

                        sendSMS(phoneNumber,message);

                    }else{

                        Toast.makeText(ThirdActivityA.this,"Permission SMS refusée", Toast.LENGTH_SHORT).show();

                    }

                    //System.out.println(message);

                }

                String RBmaxS = RBmax;
                String BmaxValueS = BmaxValue;
                int RBmaxI = Integer.parseInt(RBmaxS);
                int BmaxValueI = Integer.parseInt(BmaxValueS);

                if(RBmaxI>BmaxValueI){

                    String message = "Je ne sais pas ce qu'il m'arrive. Je suis survolté, ma batterie atteint "+RBmaxI+" %.";

                    if(checkPermission(Manifest.permission.SEND_SMS)){

                        sendSMS(phoneNumber,message);

                    }else{

                        Toast.makeText(ThirdActivityA.this,"Permission SMS refusée", Toast.LENGTH_SHORT).show();

                    }

                    //System.out.println(message);

                }

                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                Intent intent = new Intent(ThirdActivityA.this, UserAreaActivity2.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }

        });


    }

    private void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }

    private boolean checkPermission(String permission){

        int checkPermission = ContextCompat.checkSelfPermission(this,permission);
        return checkPermission == PackageManager.PERMISSION_GRANTED;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){

        switch(requestCode){

            case SEND_SMS_PERMISSION_REQUEST_CODE:

                if(grantResults.length>0 && (grantResults[0]==PackageManager.PERMISSION_GRANTED)){

                    _bRSave.setEnabled(true);

                }

                break;

        }

    }

}
