package com.eliagbenu.retrodemo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eli on 1/4/15.
 */

public class PeopleListAdapter extends ArrayAdapter<Person>{


    public PeopleListAdapter(Context context, ArrayList<Person> person) {
        super(context, 0, person);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Person person = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_person, parent, false);
        }
        // Lookup view for data population
        TextView personName = (TextView) convertView.findViewById(R.id.personName);
        TextView personAccountNumber = (TextView) convertView.findViewById(R.id.personAccountNumber);
        // Populate the data into the template view using the data object
        personName.setText(person.name);
        personAccountNumber.setText(""+person.account_number);
        // Return the completed view to render on screen
        return convertView;
    }

}
/*public class PeopleList extends BaseAdapter {
    private List<Person> peopleList=null;
    private static LayoutInflater inflater=null;

    @Override
    public int getCount() {
        return peopleList.size();
    }

    @Override
    public Object getItem(int position) {
        return peopleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    *//********* Create a holder Class to contain inflated xml file elements *********//*
    public static class ViewHolder{

        public TextView personName;
        public TextView personAccountNumber;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder holder;

        if (convertView==null){

            *//****** Inflate tabitem.xml file for each row ( Defined below ) *******//*
            vi = inflater.inflate(R.layout.person, null);

            *//****** View Holder Object to contain tabitem.xml file elements ******//*

            holder = new ViewHolder();
            holder.personName = (TextView) vi.findViewById(R.id.personName);
            holder.personAccountNumber=(TextView)vi.findViewById(R.id.personAccountNumber);

            *//************  Set holder with LayoutInflater ************//*
            vi.setTag( holder );
        }else{
            holder=(ViewHolder)vi.getTag();
        }

        if(peopleList.size()<=0)
        {
            holder.personName.setText("No Data");

        }else
        {
            *//***** Get each Model object from Arraylist ********//*
            Person person  =  peopleList.get( position );

            *//************  Set Model values in Holder elements ***********//*

            holder.personName.setText( person.getName() );
            holder.personAccountNumber.setText( person.account_number );

        }

        return null;
    }

}*/
