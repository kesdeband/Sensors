package com.example.kjoseph.sensors;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kjoseph.sensors.models.AccelerometerModel;
import com.example.kjoseph.sensors.models.DBContract;
import com.example.kjoseph.sensors.models.DBHandler;
import com.example.kjoseph.sensors.models.GravityModel;
import com.example.kjoseph.sensors.models.GyroscopeModel;
import com.example.kjoseph.sensors.models.LinearAccelerationModel;
import com.example.kjoseph.sensors.models.MagneticFieldModel;
import com.example.kjoseph.sensors.models.PressureModel;
import com.example.kjoseph.sensors.models.ProximityModel;
import com.example.kjoseph.sensors.models.RotationVectorModel;
import com.example.kjoseph.sensors.models.Sensor;
import com.example.kjoseph.sensors.models.TemperatureModel;

import java.util.List;

public class SensorDataActivity extends ActionBarActivity {

    private DBHandler database;
    private String table;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_data);

        Intent intentExtras = getIntent();
        if(intentExtras.hasExtra(SensorsActivity.SENSOR_TABLE)){
            table = intentExtras.getStringExtra(SensorsActivity.SENSOR_TABLE);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.dataList);
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);



        new SensorEventDataTask().execute(table);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sensor_data, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class SensorEventDataTask extends AsyncTask<String, Void, List<Sensor>> {

        @Override
        protected List<Sensor> doInBackground(String... tables) {
            
            switch(tables[0]) {
                case DBContract.ACCELEROMETER_TABLE:
                    database = new AccelerometerModel(getApplication());
                    break;

                case DBContract.MAGNETIC_FIELD_TABLE:
                    database = new MagneticFieldModel(getApplication());
                    break;

                case DBContract.GRAVITY_TABLE:
                    database = new GravityModel(getApplication());
                    break;

                case DBContract.PROXIMITY_TABLE:
                    database = new ProximityModel(getApplication());
                    break;

                case DBContract.PRESSURE_TABLE:
                    database = new PressureModel(getApplication());
                    break;

                case DBContract.TEMPERATURE_TABLE:
                    database = new TemperatureModel(getApplication());
                    break;

                case DBContract.LINEAR_ACCELERATION_TABLE:
                    database = new LinearAccelerationModel(getApplication());
                    break;

                case DBContract.ROTATION_VECTOR_TABLE:
                    database = new RotationVectorModel(getApplication());
                    break;

                case DBContract.GYROSCOPE_TABLE:
                    database = new GyroscopeModel(getApplication());
                    break;
            }
            return database.retrieveAllValues();
        }

        @Override
        protected void onPostExecute(List<Sensor> sensors) {

            // Execution of results from doInBackground method

            // specify an adapter
            CustomRecyclerAdapter mAdapter = new CustomRecyclerAdapter(sensors);
            mRecyclerView.setAdapter(mAdapter);
        }
    }

}
