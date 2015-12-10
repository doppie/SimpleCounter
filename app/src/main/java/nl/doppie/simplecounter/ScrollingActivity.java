package nl.doppie.simplecounter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class ScrollingActivity extends AppCompatActivity {

    private TextView count1, count2;
    private Button plus1, plus2, min1, min2;

    private Dataset dataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataset.updateStoredData(S.P_COUNT1, 0 + "");
                dataset.updateStoredData(S.P_COUNT2, 0 + "");
                updateUI();
                Snackbar.make(view, "Resetted all counters.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        dataset = (Dataset) getApplication();
        initUI();
        updateUI();
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
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

    private void initUI() {
        count1 = (TextView) findViewById(R.id.count1);
        count2 = (TextView) findViewById(R.id.count2);
        plus1 = (Button) findViewById(R.id.plus1);
        plus2 = (Button) findViewById(R.id.plus2);
        min1 = (Button) findViewById(R.id.min1);
        min2 = (Button) findViewById(R.id.min2);

        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataset.updateStoredData(S.P_COUNT1, Integer.valueOf(dataset.getStoredData(S.P_COUNT1)) + 1 + "");

                updateUI();
            }
        });
        plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataset.updateStoredData(S.P_COUNT2, Integer.valueOf(dataset.getStoredData(S.P_COUNT2)) + 1 + "");

                updateUI();
            }
        });
        min1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataset.updateStoredData(S.P_COUNT1, Integer.valueOf(dataset.getStoredData(S.P_COUNT1)) - 1 + "");

                updateUI();
            }
        });
        min2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataset.updateStoredData(S.P_COUNT2, Integer.valueOf(dataset.getStoredData(S.P_COUNT2)) - 1 + "");

                updateUI();
            }
        });


    }

    private void updateUI() {
        count1.setText(dataset.getStoredData(S.P_COUNT1));
        count2.setText(dataset.getStoredData(S.P_COUNT2));
    }
}
