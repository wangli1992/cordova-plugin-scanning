package cordova.plugins.scanning;

import android.content.Intent;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class Scanning extends CordovaPlugin {

    CallbackContext callbackContext;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("startScanning")) {
            String message = args.getString(0);
            this.callbackContext = callbackContext;
            startScanning(message);
            return true;
        }
        return false;
    }

    private void startScanning(String message) {
        Intent intent = new Intent(this.cordova.getActivity(), QrActivity.class);
        intent.putExtra("title", "扫一扫");
        cordova.setActivityResultCallback(this);
        cordova.startActivityForResult(this, intent, 1000);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (intent != null && requestCode == 1000 && callbackContext != null) {
            String result = intent.getStringExtra("result");
            if (result != null)
                callbackContext.success(result);
            else
                callbackContext.error("Rev null from camera");
        }
    }
}
