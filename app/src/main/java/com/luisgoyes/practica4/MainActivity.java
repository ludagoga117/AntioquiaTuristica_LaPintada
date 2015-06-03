package com.luisgoyes.practica4;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {
	private final boolean[] opcionMenuHoteles = {true, false, false, false, false, false};
	private final boolean[] opcionMenuBares = {false, true, false, false, false, false};
	private final boolean[] opcionMenuTurista = {false, false, true, false, false, false};
	private final boolean[] opcionMenuDemogra = {false, false, false, true, false, false};
	private final boolean[] opcionMenuPrincipal = {false, false, false, false, false, true};
	private final boolean[] opcionMenuMapa = {false, false, false, false, true, false};
	private boolean[] opcionMenu = opcionMenuPrincipal;

	public static FragmentManager fragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
		F_index f1 = new F_index();
		fragmentTransaction.add(android.R.id.content, f1).commit();
		fragmentManager = getSupportFragmentManager();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.iHoteles:
				HotelesMenuItem();
				break;
			case R.id.iBares:
				BaresMenuItem();
				break;
			case R.id.iTurista:
				TuristaMenuItem();
				break;
			case R.id.iDemografica:
				DemograficaMenuItem();
				break;
			case R.id.iMapa:
				MapaMenuItem();
				break;
			case R.id.iPrincipal:
				PrincipalMenuItem();
				break;
			case R.id.iAbout:
				AboutMenuItem();
				break;
			case R.id.iHelp:
				HelpMenuItem();
				break;
			default:
				break;
		}
		invalidateOptionsMenu();
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onPrepareOptionsMenu (Menu menu) {
		for(int i = 0; i<= 5; i++){
			menu.getItem(i).setEnabled(!opcionMenu[i]);
		}
	    return true;
	}
	
	private void HotelesMenuItem(){
		opcionMenu = opcionMenuHoteles;
		F_hoteles f2 = new F_hoteles();
		getFragmentManager().beginTransaction().replace(android.R.id.content, f2).commit();
	}
	
	private void BaresMenuItem(){
		opcionMenu = opcionMenuBares;
		F_bares f3 = new F_bares();
		getFragmentManager().beginTransaction().replace(android.R.id.content, f3).commit();
	}
	
	private void TuristaMenuItem(){
		opcionMenu = opcionMenuTurista;
		F_turista f4 = new F_turista();
		getFragmentManager().beginTransaction().replace(android.R.id.content, f4).commit();
	}
	
	private void DemograficaMenuItem(){
		opcionMenu = opcionMenuDemogra;
		F_demogra f5 = new F_demogra();
		getFragmentManager().beginTransaction().replace(android.R.id.content, f5).commit();
	}

	private void MapaMenuItem(){
		opcionMenu = opcionMenuMapa;
		F_mapa f6 = new F_mapa();
		getFragmentManager().beginTransaction().replace(android.R.id.content, f6).commit();
	}

	private void PrincipalMenuItem(){
		opcionMenu = opcionMenuPrincipal;
		F_index f7 = new F_index();
		getFragmentManager().beginTransaction().replace(android.R.id.content, f7).commit();
	}
	
	private void AboutMenuItem(){
		new AlertDialog.Builder(this)
		.setTitle(getResources().getString(R.string.sAbout))
		.setMessage(getResources().getString(R.string.sAboutInfo))
		.setNeutralButton(getResources().getString(R.string.sOk), new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		}).show();
	}
	
	private void HelpMenuItem(){
		new AlertDialog.Builder(this)
		.setTitle(getResources().getString(R.string.sHelp))
		.setMessage(getResources().getString(R.string.sHelpText))
		.setNeutralButton(getResources().getString(R.string.sOk), new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		}).show();
	}
}
