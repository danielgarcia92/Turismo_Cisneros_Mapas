package com.example.daniel.practica5;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MyMenu extends ListFragment {

    Comunicador interfaz;

    private String[] MenuS;
    public int cont=0;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        interfaz = (Comunicador)activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        final String sHotel      = getResources().getString(R.string.sHotel);
        final String sBar        = getResources().getString(R.string.sBar);
        final String sTurismo    = getResources().getString(R.string.sTurismo);
        final String sDemografia = getResources().getString(R.string.sDemografia);
        final String sMapas      = getResources().getString(R.string.sMapas);
        MenuS = new String[]{sHotel, sBar, sTurismo, sDemografia, sMapas};
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,MenuS));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            if (MenuS[position] == MenuS[0]) {
                hotel fragment = new hotel();
                fragmentTransaction.replace(R.id.frame2, fragment).commit();
                cont=0;
            }

            if (MenuS[position] == MenuS[1]) {
                Bar fragment = new Bar();
                fragmentTransaction.replace(R.id.frame2, fragment).commit();
                cont=1;
            }

            if (MenuS[position] == MenuS[2]) {
                Turismo fragment = new Turismo();
                fragmentTransaction.replace(R.id.frame2, fragment).commit();
                cont=2;
            }

            if (MenuS[position] == MenuS[3]) {
                Demografia fragment = new Demografia();
                fragmentTransaction.replace(R.id.frame2, fragment).commit();
                cont=3;
            }

            if (MenuS[position] == MenuS[4]) {
                Intent i = new Intent(getActivity(), MapsActivity.class);
                startActivity(i);
                cont=4;
            }

        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){

            if (MenuS[position] == MenuS[0]) {
                hotel fragment2 = new hotel();
                fragmentTransaction.replace(R.id.frame3, fragment2).commit();
                cont=0;
            }

            if (MenuS[position] == MenuS[1]) {
                Bar fragment = new Bar();
                fragmentTransaction.replace(R.id.frame3, fragment).commit();
                cont=1;
            }

            if (MenuS[position] == MenuS[2]) {
                Turismo fragment = new Turismo();
                fragmentTransaction.replace(R.id.frame3, fragment).commit();
                cont=2;
            }

            if (MenuS[position] == MenuS[3]) {
                Demografia fragment = new Demografia();
                fragmentTransaction.replace(R.id.frame3, fragment).commit();
                cont=3;
            }

            if (MenuS[position] == MenuS[4]) {
                Intent i = new Intent(getActivity(), MapsActivity.class);
                startActivity(i);
                cont=4;
            }

            else{
                cont=5;
            }

        }

    }

    public void retrieveInfo(){

        interfaz.sendContent(cont);

    }

}