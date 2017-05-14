/****************************************************************************
Copyright (c) 2008-2010 Ricardo Quesada
Copyright (c) 2010-2012 cocos2d-x.org
Copyright (c) 2011      Zynga Inc.
Copyright (c) 2013-2014 Chukong Technologies Inc.
 
http://www.cocos2d-x.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
****************************************************************************/
package org.cocos2dx.cpp;

import java.util.Map;

import org.cocos2dx.lib.Cocos2dxActivity;

import com.soulgame.sgsdk.tgsdklib.TGSDK;
import com.soulgame.sgsdk.tgsdklib.TGSDKServiceResultCallBack;
import com.soulgame.sgsdk.tgsdklib.ad.ITGADListener;
import com.soulgame.sgsdk.tgsdklib.ad.ITGPreloadListener;
import com.soulgame.sgsdk.tgsdklib.ad.ITGRewardVideoADListener;
import com.soulgame.sgsdk.tgsdklib.cocos2dx.TGSDKCocos2dxHelper;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.view.ViewGroup.LayoutParams;


public class AppActivity extends Cocos2dxActivity {
	
	private static AppActivity _appActiviy;

	@Override
	protected void onCreate(Bundle savedInstanceState){
	    super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//横屏：根据传感器横向切换
        TGSDK.setDebugModel(true);
        TGSDKCocos2dxHelper.setup(this);
	}
	
	@Override
	protected void onStart() {
	    super.onStart();
	    TGSDK.onStart(this);
	}
	
	@Override
	protected void onStop() {
	    super.onStop();
	    TGSDK.onStop(this);
	}
	
	@Override
	protected void onPause() {
	    super.onPause();
	    TGSDK.onPause(this);
	}
	
	@Override
	protected void onResume() {
	    super.onResume();
	    TGSDK.onResume(this);
	}
	
	@Override
	protected void onDestroy() {
	    super.onDestroy();
	    TGSDK.onDestroy(this);
	}
	
	@Override
	protected void onActivityResult(int reqCode, int resCode, Intent data) {
	    super.onActivityResult(reqCode, resCode, data);
	    TGSDK.onActivityResult(this, reqCode, resCode, data);
	}

}
