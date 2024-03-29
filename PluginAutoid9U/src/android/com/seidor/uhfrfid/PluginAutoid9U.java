package com.seidor.uhfrfid;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.seuic.uhf.UHFService;

/**
 * This class echoes a string called from JavaScript.
 */
public class PluginAutoid9U extends CordovaPlugin {
	private CallbackContext receiveScanCallback;
	// static private UHFClient instance = null;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("initialise")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message + "Teste deu bom em !!!");
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
