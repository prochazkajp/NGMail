package com.insia.ngmail;

import android.app.Service;  
import android.content.Intent;  
import android.os.IBinder;  
import android.widget.Toast;
  
public class AuthenticationService extends Service {  
  @Override  
  public IBinder onBind(Intent intent) {  
    // TODO Auto-generated method stub  

	  Toast.makeText(getApplicationContext(), "Sluzba bezi" , Toast.LENGTH_LONG).show();
    return new AccountAuthenticator(this).getIBinder();  
  }  
  
}  
