package com.example.kjoseph.sensors;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kjoseph.sensors.factory.SensorsSingleton;
import com.example.kjoseph.sensors.models.DBContract;
import com.example.kjoseph.sensors.ui.SensorDetailsFragment;
import com.example.kjoseph.sensors.ui.SensorsFragment;

public class SensorsActivity extends ActionBarActivity implements SensorsFragment.SpinnerChangedListener {

    public final static String SENSOR_TABLE = "table";

    private String sensorTableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sensors, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                // TODO: nothing implemented
                return true;
            case R.id.action_sensors_data:
                Intent intent = new Intent(this, SensorDataActivity.class);
                intent.putExtra(SENSOR_TABLE, sensorTableName);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onSpinnerChanged(int position, String name) {

        // Set the table name for the current sensor in order to pull data for that sensor
        switch (position) {
            case 0:
                sensorTableName = DBContract.ACCELEROMETER_TABLE;
                break;

            case 1:
                sensorTableName = DBContract.MAGNETIC_FIELD_TABLE;
                break;

            case 2:
                sensorTableName = DBContract.GRAVITY_TABLE;
                break;

            case 3:
                sensorTableName = DBContract.PROXIMITY_TABLE;
                break;

            case 4:
                sensorTableName = DBContract.PRESSURE_TABLE;
                break;

            case 5:
                sensorTableName = DBContract.TEMPERATURE_TABLE;
                break;

            case 6:
                sensorTableName = DBContract.LINEAR_ACCELERATION_TABLE;
                break;

            case 7:
                sensorTableName= DBContract.ROTATION_VECTOR_TABLE;
                break;

            case 8:
                sensorTableName = DBContract.GYROSCOPE_TABLE;
                break;
        }

        // Create fragment and give it an argument for the selected article
        Fragment fragment = SensorsSingleton.getInstance().getSensorFragment(position);
        Bundle args = new Bundle();
        args.putInt(SensorDetailsFragment.ITEM_POSITION, position);
        args.putString(SensorDetailsFragment.ITEM_NAME, name);
        fragment.setArguments(args);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.sensors_fragment_container, fragment)
                .commit();

    }

}
