package com.eliagbenu.retrodemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Path;


public class ListActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Construct the data source
        final ArrayList<Person> arrayOfPersons = new ArrayList<Person>();

        AppController.personService.getPeople(new Callback <List<Person>>() {
            @Override
            public void success(List<Person> persons, Response response) {

                arrayOfPersons.addAll(persons);

                PeopleListAdapter adapter = new PeopleListAdapter(ListActivity.this , arrayOfPersons);
                // Attach the adapter to a ListView
                ListView listView = (ListView) findViewById(R.id.peopleList);
                listView.setAdapter(adapter);

            }

            @Override
            public void failure(RetrofitError error) {

                Log.e("xxxxx","failure: "+error);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
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
