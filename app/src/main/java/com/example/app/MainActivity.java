package com.example.app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.ansca.corona.CoronaView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        CoronaView mBigCoronaView;
        CoronaView mSmallCoronaView;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            mBigCoronaView = (CoronaView)rootView.findViewById(R.id.view_outer);
            mSmallCoronaView = (CoronaView)rootView.findViewById(R.id.view_inner);
            mBigCoronaView.init("Fishies/");
            mSmallCoronaView.init("Fishies/");
            mBigCoronaView.setZOrderMediaOverlay(false);
            mSmallCoronaView.setZOrderMediaOverlay(true);

            return rootView;
        }

        @Override
        public void onResume() {
            super.onResume();
            mSmallCoronaView.resume();
            mBigCoronaView.resume();
        }

        @Override
        public void onPause() {
            super.onPause();
            mSmallCoronaView.pause();
            mBigCoronaView.pause();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            mSmallCoronaView.destroy();
            mBigCoronaView.destroy();
        }
    }
}
