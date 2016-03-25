package co.ko.hey;
import com.google.android.gms.maps.GoogleMap;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
public class MainActivity extends Activity {
private RadioGroup radioGroupWebsite;
private RadioButton radioBtn1;
private Button btnWebsiteName;

@Override
protected void onCreate(Bundle savedInstanceState) {
	
super.onCreate(savedInstanceState);
setContentView(R.layout.start);
addListenerRadioButton();
    
Toast.makeText(this, "Select The Field To Be Search", Toast.LENGTH_SHORT).show();
		



	}
private void addListenerRadioButton() {
radioGroupWebsite = (RadioGroup) findViewById (R.id.radioGroup1);
btnWebsiteName = (Button) findViewById(R.id.button1);

btnWebsiteName.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View v) {
int selected =
radioGroupWebsite.getCheckedRadioButtonId();
radioBtn1 = (RadioButton) findViewById(selected);

switch(radioBtn1.getId())
{
case R.id.radio0:
	startActivity(new Intent(MainActivity.this,Sub.class));
	break;
case R.id.radio1:
	startActivity(new Intent(MainActivity.this,Sub1.class));
	break;
case R.id.radio2:
	startActivity(new Intent(MainActivity.this,Sub2.class));
	break;
case R.id.radio3:
	startActivity(new Intent(MainActivity.this,Sub3.class));
	break;
case R.id.radio4:
	startActivity(new Intent(MainActivity.this,Sub4.class));
	break;
case R.id.radio5:
	startActivity(new Intent(MainActivity.this,Sub5.class));
	break;
}
}
});


}
@Override
public boolean onCreateOptionsMenu(Menu menu){
	MenuInflater inflater=getMenuInflater();
	inflater.inflate(R.menu.main1, menu);
	return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item){
	switch(item.getItemId()){
	case R.id.insert:
		AlertDialog.Builder alert=new AlertDialog.Builder(this);
		alert.setTitle("Add a Map");
		String a="Please send Your locations Logitude and Latitude to the Following Mails  \n1.deathrace25@gmail.com \n2.k1nnn18@gmail.com \n3.manu@gmail.com\nYou can refer to the website itouchmap.com for adding longitude and latiude\n We will add your location in next Update ";
		alert.setMessage(a);
		alert.setIcon(R.drawable.ic_launcher);
		alert.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int buttonId){
				return;
			}});
		
		alert.show();
			break;
	case R.id.about:
		AlertDialog.Builder alert2=new AlertDialog.Builder(this);
		alert2.setTitle("About");
		String b="MyCity v1.0 Find your City like petrolpump,hotel,etc. \nDevelopers List \n1.Shrikant Narayankar \n2. Mangesh Ghodke \n3.Manohar Kudkyal ";
		alert2.setMessage(b);
		alert2.setIcon(R.drawable.ic_launcher);
		alert2.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int buttonId){
				return;
			}});
		alert2.show();
		break;
	}
	return true;
}

}

