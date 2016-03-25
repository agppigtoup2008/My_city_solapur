package co.ko.hey;
import android.app.Activity;
import co.ko.hey.var.*;
import android.os.Bundle;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.CameraUpdate;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
public class man extends Sub
{	
	static void hotel()
	{
		Marker m[]=new Marker[100];
		for(int i=0;i<var.hotels.length;i++)
		{
			
	 m[i]= googleMap.addMarker(new MarkerOptions().position(new LatLng(var.hotellang[i],var.hotellati[i])).title(var.hotels[i]).icon(BitmapDescriptorFactory.fromResource(R.drawable.hotel)));
		}
	
	}static void hotel1(String s)
	{
		Marker m[]=new Marker[100];
		for(int i=0;i<var.hotels.length;i++)
		{
			if(s.equals(var.hotels[i]))
			{
				googleMap.clear();
	 m[i]= googleMap.addMarker(new MarkerOptions().position(new LatLng(var.hotellang[i],var.hotellati[i])).title(var.hotels[i]).icon(BitmapDescriptorFactory.fromResource(R.drawable.hotel)));
		}}
	
	}

	static void police() {
		Marker m[]=new Marker[100];
		for(int i=0;i<var.polices.length;i++)
		{
			
	 m[i]= googleMap.addMarker(new MarkerOptions().position(new LatLng(var.policelang[i],var.policelati[i])).title(var.polices[i]).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_marker_star)));
		}

	}static void police1(String s) {
		Marker m[]=new Marker[100];
		for(int i=0;i<var.polices.length;i++)
		{
			if(s.equals(var.polices[i])){
				googleMap.clear();
	 m[i]= googleMap.addMarker(new MarkerOptions().position(new LatLng(var.policelang[i],var.policelati[i])).title(var.polices[i]).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_marker_star)));
	 CameraUpdate ur=CameraUpdateFactory.newLatLngZoom(new LatLng(var.policelang[i],var.policelati[i]), 10);
	 googleMap.animateCamera(ur);
			}}

	}
	public static void hospital() {googleMap.clear();
		Marker m[]=new Marker[100];
		for(int i=0;i<var.hospitals.length;i++)
		{
	 m[i]= googleMap.addMarker(new MarkerOptions().position(new LatLng(var.hospitallong[i],var.hospitallati[i])).title(var.hospitals[i]).icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitalbuilding)));
		}
	}
	static void hospital1(String s) {
		Marker m[]=new Marker[100];
		for(int i=0;i<var.hospitals.length;i++)
		{
			if(s.equals(var.hospitals[i]))
			{googleMap.clear();
	 m[i]= googleMap.addMarker(new MarkerOptions().position(new LatLng(var.hospitallong[i],var.hospitallati[i])).title(var.hospitals[i]).icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitalbuilding)));
	 
			}
			}
			
			
	}
	static void GasStation()
	{

		Marker m[]=new Marker[100];
		for(int i=0;i<var.GasStations.length;i++)
		{
	 m[i]= googleMap.addMarker(new MarkerOptions().position(new LatLng(var.GasStationlong[i],var.GasStationlati[i])).title(var.GasStations[i]).icon(BitmapDescriptorFactory.fromResource(R.drawable.gasstation)));
		}
	}
	static void GasStation1(String s)
	{

		Marker m[]=new Marker[100];
		for(int i=0;i<var.GasStations.length;i++)
		{ if(s.equals(var.GasStations[i])){
			googleMap.clear();
	 m[i]= googleMap.addMarker(new MarkerOptions().position(new LatLng(var.GasStationlong[i],var.GasStationlati[i])).title(var.GasStations[i]).icon(BitmapDescriptorFactory.fromResource(R.drawable.gasstation)));
		}}
	}
	static void ATM()
	{
		Marker m[]=new Marker[100];
		for(int i=0;i<var.ATMs.length;i++)
		{
	 m[i]= googleMap.addMarker(new MarkerOptions().position(new LatLng(var.ATMlong[i],var.ATMlati[i])).title(var.ATMs[i]).icon(BitmapDescriptorFactory.fromResource(R.drawable.atm)));
		}
	}
	static void ATM1(String s)
	{
		Marker m[]=new Marker[100];
		for(int i=0;i<var.ATMs.length;i++)
		{
			if(s.equals(var.ATMs[i])){
				googleMap.clear();
	 m[i]= googleMap.addMarker(new MarkerOptions().position(new LatLng(var.ATMlong[i],var.ATMlati[i])).title(var.ATMs[i]).icon(BitmapDescriptorFactory.fromResource(R.drawable.atm)));
		}}
	}
	static void College()
	{
		Marker m[]=new Marker[100];
		for(int i=0;i<var.Colleges.length;i++)
		{
	 m[i]= googleMap.addMarker(new MarkerOptions().position(new LatLng(var.Collegelong[i],var.Collegelati[i])).title(var.Colleges[i]).icon(BitmapDescriptorFactory.fromResource(R.drawable.college)));
		}
		
	}

	static void College1(String s)
	{
		Marker m[]=new Marker[100];
		for(int i=0;i<var.Colleges.length;i++)
		{
			if(s.equals(var.Colleges[i]))
			{
				googleMap.clear();
	 m[i]= googleMap.addMarker(new MarkerOptions().position(new LatLng(var.Collegelong[i],var.Collegelati[i])).title(var.Colleges[i]).icon(BitmapDescriptorFactory.fromResource(R.drawable.college)));
		}}
		
	}
	
	
	
}