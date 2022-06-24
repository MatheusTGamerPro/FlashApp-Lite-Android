package com.tgpprojects.FlashApp;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends Activity {
	
	private boolean flashState = false;
	
	private LinearLayout linear1;
	private ImageView btnFlash;
	private TextView txtState;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		btnFlash = findViewById(R.id.btnFlash);
		txtState = findViewById(R.id.txtState);
		
		btnFlash.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (flashState) {
					android.hardware.camera2.CameraManager cameraManager = (android.hardware.camera2.CameraManager) getSystemService(Context.CAMERA_SERVICE);
					try {
						String cameraId = cameraManager.getCameraIdList()[0]; cameraManager.setTorchMode(cameraId, false); } catch (android.hardware.camera2.CameraAccessException e) { }
					flashState = false;
					btnFlash.setImageResource(R.drawable.ic_flash_off);
					txtState.setTextColor(0xFF000000);
					txtState.setText("OFF");
				}
				else {
					android.hardware.camera2.CameraManager cameraManager = (android.hardware.camera2.CameraManager) getSystemService(Context.CAMERA_SERVICE);
					try {
						String cameraId = cameraManager.getCameraIdList()[0]; cameraManager.setTorchMode(cameraId, true); } catch (android.hardware.camera2.CameraAccessException e) { }
					flashState = true;
					btnFlash.setImageResource(R.drawable.ic_flash_on);
					txtState.setTextColor(0xFFFF9800);
					txtState.setText("ON");
				}
			}
		});
	}
	
	private void initializeLogic() {
	}
	
}