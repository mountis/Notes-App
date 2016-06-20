package thedorkknightrises.notes.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GoogleApiAvailability;

import thedorkknightrises.notes.R;

/**
 * Created by Samriddha Basu on 6/20/2016.
 */
public class AboutActivity extends AppCompatActivity {
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    public void onLinkClick(View v) {
        String text = (String) ((Button) v).getText();
        String uri = new String();
        if (text.equals(getString(R.string.gplus))) {
            uri = "https://plus.google.com/u/0/+SamriddhaBasu";
        } else if (text.equals(getString(R.string.github))) {
            uri = "https://github.com/TheDorkKnightRises";
        } else if (text.equals(getString(R.string.website))) {
            uri = "https://thedorkknightrises.github.io";
        } else if (text.equals(getString(R.string.source))) {
            uri = "https://github.com/TheDorkKnightRises/Notes-App";
        } else {
            Toast.makeText(getApplicationContext(), "This app is not on the Play Store yet :P", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(i);
    }

    public void onNoticeClick(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(R.string.copyright)
                .show();
    }
}
