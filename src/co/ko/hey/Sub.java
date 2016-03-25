package co.ko.hey;
import android.content.Intent;
import android.media.MediaPlayer;
import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


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
import android.media.MediaPlayer;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import co.ko.hey.man;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
public class Sub extends MainActivity {
	public static GoogleMap googleMap;


GPSTracker gps;
double longitude;
double latitude;
@Override

public  void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
ArrayAdapter <String> arr=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,var.polices);
final AutoCompleteTextView t=(AutoCompleteTextView)findViewById(R.id.produ);

t.setThreshold(1);
t.setAdapter(arr);
t.setOnItemClickListener(new OnItemClickListener() {

@Override
public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {
	t.performCompletion();
	Toast.makeText(Sub.this, t.getText().toString(), Toast.LENGTH_LONG).show();
	man.police1(t.getText().toString());	
}


});

try {
	

	gps = new GPSTracker(Sub.this);

// check if GPS enabled		
if(gps.canGetLocation()){
	
	latitude = gps.getLatitude();
	longitude = gps.getLongitude();
}

googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
googleMap.setMyLocationEnabled(true);	
googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
Criteria criteria=new Criteria();
googleMap.clear();
man.police();
LocationManager locationmanager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
String provider=locationmanager.getBestProvider(criteria,false);
Location location=locationmanager.getLastKnownLocation(provider);
double lat=location.getLatitude();
double lng=location.getLongitude();
LatLng coordinate=new LatLng(lat,lng);
CameraUpdate ur=CameraUpdateFactory.newLatLngZoom(coordinate, 10);
googleMap.animateCamera(ur);


} catch (Exception e) {
e.printStackTrace();
}}

@Override
public boolean onCreateOptionsMenu(Menu menu){
	MenuInflater inflater=getMenuInflater();
	inflater.inflate(R.menu.main, menu);
	return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item){
	switch(item.getItemId()){
	case R.id.search:
		
	Toast.makeText(Sub.this, "search", Toast.LENGTH_LONG).show();
	break;
	case R.id.mapview:
	Toast.makeText(Sub.this, "Mapview", Toast.LENGTH_LONG).show();
	break;
	case R.id.search_hotel:
		googleMap.clear();
		man.hotel();
		break;
	case R.id.search_police:
		googleMap.clear();
		man.police();
		break;
	case R.id.search_hospital:
		googleMap.clear();
		man.hospital();
		break;
	case R.id.search_gasstation:
		googleMap.clear();
		man.GasStation();
		break;
	case R.id.search_ATM:
		googleMap.clear();
		man.ATM();
		break;
	case R.id.search_College:
		googleMap.clear();
		man.College();
		break;		
	case R.id.mapview_maps:
		googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		break;
	case R.id.mapview_hybrid:
		googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		break;
	case R.id.mapview_terrain:
		googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
		break;
	case R.id.mapview_normal:
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		break;
	}
	return true;
}
}