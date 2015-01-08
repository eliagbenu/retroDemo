package com.eliagbenu.retrodemo;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;
import org.w3c.dom.Text;


import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    TextView editTextName, editTextAccountNumber;
    Button buttonSubmit, buttonNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveEntries();

        nextClick();

    }

    public void nextClick(){
        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listPage = new Intent(getApplicationContext(),ListActivity.class);
                startActivity(listPage);
            }
        });
    }

    public void saveEntries(){
        editTextName = (TextView) findViewById(R.id.editTextName);
        editTextAccountNumber = (TextView) findViewById(R.id.editTextAccountNumber);

        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PersonService personService = new RestAdapter.Builder()
                             .setEndpoint(AppController.API_URL)
                             .build().create(PersonService.class);

                String name = editTextName.getText().toString() ;
                int account_number = Integer.valueOf(editTextAccountNumber.getText().toString()) ;
                Person person = new Person();
                person.name = name;
                person.account_number = account_number ;
                personService.addPerson ( person,
                                   new Callback<JSONObject>() {
                            @Override
                            public void failure(final RetrofitError error) {
                                android.util.Log.i("Notice", ""+error);

                                Toast.makeText(getApplicationContext(), "error came up", Toast.LENGTH_LONG).show();

                            }
                            @Override
                            public void success(JSONObject arg0, Response arg1) {

                                Toast.makeText(getApplicationContext(), "saved data", Toast.LENGTH_LONG).show();

                                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                                startActivity(intent);

                            }
                        });

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
