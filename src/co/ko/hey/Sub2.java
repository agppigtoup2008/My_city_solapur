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

public class Sub2 extends MainActivity {
	public static GoogleMap googleMap;


GPSTracker gps;
double longitude;
double latitude;
@Override

public  void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
ArrayAdapter <String> arr2=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,var.hotels);
final AutoCompleteTextView p=(AutoCompleteTextView)findViewById(R.id.produ);
p.setThreshold(1);
p.setAdapter(arr2);
p.setOnItemClickListener(new OnItemClickListener() {

@Override
public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {
	p.performCompletion();
	man2.hotel1(p.getText().toString());
	
}
});
try {
gps = new GPSTracker(Sub2.this);

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
man2.hotel();
LocationManager locationmanager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
String provider=locationmanager.getBestProvider(criteria,false);
Location location=locationmanager.getLastKnownLocation(provider);
double lat=location.getLatitude();
double lng=location.getLongitude();
LatLng coordinate=new LatLng(lat,lng);
CameraUpdate ur=CameraUpdateFactory.newLatLngZoom(coordinate, 5);
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
		
	Toast.makeText(Sub2.this, "search", Toast.LENGTH_LONG).show();
	break;
	case R.id.mapview:
	Toast.makeText(Sub2.this, "Mapview", Toast.LENGTH_LONG).show();
	break;
	case R.id.search_hotel:
		googleMap.clear();
		man3.hotel();
		break;
	case R.id.search_police:
		googleMap.clear();
		man3.police();
		break;
	case R.id.search_hospital:
		googleMap.clear();
		man3.hospital();
		break;
	case R.id.search_gasstation:
		googleMap.clear();
		man3.GasStation();
		break;
	case R.id.search_ATM:
		googleMap.clear();
		man3.ATM();
		break;
	case R.id.search_College:
		googleMap.clear();
		man3.College();
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