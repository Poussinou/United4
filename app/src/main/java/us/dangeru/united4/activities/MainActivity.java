package us.dangeru.united4.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import us.dangeru.united4.R;
import us.dangeru.united4.fragments.UnitedWebFragment;
import us.dangeru.united4.utils.UnitedActivity;

import static us.dangeru.united4.fragments.UnitedWebFragment.RESOURCE_FOLDER;

/**
 * Main activity for danger/u/
 */
public class MainActivity extends Activity implements UnitedActivity {
    @SuppressWarnings("FieldCanBeLocal")
    private UnitedWebFragment webFragment;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        FragmentManager manager = getFragmentManager();
        webFragment = (UnitedWebFragment) manager.findFragmentByTag("main_webkit_wrapper");
        if (webFragment == null) {
            webFragment = new UnitedWebFragment();
            Bundle args = new Bundle();
            args.putString("URL", RESOURCE_FOLDER + "index.html");
            webFragment.setArguments(args);
            FragmentTransaction trans = manager.beginTransaction();
            trans.replace(R.id.activity_main_activity, webFragment, "main_webkit_wrapper");
            trans.addToBackStack("main_webkit_wrapper");
            trans.commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
