package com.insia.ngmail;

import android.os.Bundle;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button btn, btn2;
	AccountManager mAccountManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Context context = getApplicationContext();
        mAccountManager = AccountManager.get(this);
        
        btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {
             public void onClick(View v) {
                 // Perform action on click
                 Toast.makeText(context, "Ja jsem email!!", Toast.LENGTH_SHORT).show();
                 
                 final Account account = new Account("test2", "com.insia.ngmail");
                 mAccountManager.addAccountExplicitly(account, "test", null);
                 
                   
             }
         });
        
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
                // Perform action on click
                Toast.makeText(context, "Login?", Toast.LENGTH_SHORT).show();
                Account[] accounts = mAccountManager.getAccountsByType("com.insia.ngmail");
                Log.v("ACC velikost",String.valueOf(accounts.length) );
                Log.v("ACC ",accounts[0].name );
                Log.v("ACC ",mAccountManager.getPassword(accounts[0]) );
                
                
                  
            }
         });
        
      
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
