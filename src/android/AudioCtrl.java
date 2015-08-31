package com.zhxjz.map.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.media.AudioManager;

/**
 * 控制设备声音模式的插件
 * 
 * @author yangxy
 * 
 */
public class AudioCtrl extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		try {
			Context context = this.webView.getContext();
			if(action.equals("setSilent")) { //无声音且不震动
				setSilent(context);
			}
			else if(action.equals("setNormal")) { //有声音、且震动
				setNormal(context);
			}
			callbackContext.success();
			return true;
		} catch (Exception e) {
			callbackContext.error(e.getMessage());
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	private void setNormal(Context context) {
		AudioManager mAudioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
		mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		mAudioManager.setVibrateSetting(AudioManager.RINGER_MODE_VIBRATE, AudioManager.VIBRATE_SETTING_ON);
	}

	private void setSilent(Context context) {
		AudioManager mAudioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
		mAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	}

}
