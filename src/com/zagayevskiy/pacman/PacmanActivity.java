package com.zagayevskiy.pacman;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;

public class PacmanActivity extends Activity{
	
	PacmanView pacmanView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
      
       pacmanView = new PacmanView(getApplication());
       setContentView(pacmanView);   
       
    }

    @Override
    protected void onPause() {
        super.onPause();
        PacmanLib.stop();
    }
    

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(PacmanLib.tag, "Activity.onResume");
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        PacmanLib.stop();
    }
    
    @Override
    protected void onDestroy(){	
    	super.onDestroy();
    	PacmanLib.free();
    }
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {
	        if (keyCode == KeyEvent.KEYCODE_BACK) {
	        		if(PacmanLib.stop()){
	        			finish();
	        		}
	                return true;
	        }
	    return super.onKeyDown(keyCode, event);
	}
}
