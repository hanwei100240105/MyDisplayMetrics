package bupt.com.badgeview;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private String TAG="text";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = (TextView)this.findViewById(R.id.tv);
        Button bt = (Button) findViewById(R.id.bt);
        final BadgeView badgeView = new BadgeView(this);
        badgeView.setTargetView(findViewById(R.id.rl));
        badgeView.setBadgeGravity(Gravity.LEFT | Gravity.CENTER);
        badgeView.setBadgeMargin(0, 0, 10, 0);
        badgeView.setText("韩维");
        final BadgeView badgeView2 = new BadgeView(this);
        badgeView2.setTargetView(findViewById(R.id.rl2));
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//点击按钮出现随机数
                Random r = new Random();
                int randNum = r.nextInt(1000);//0-1000的随机数
                badgeView2.setBadgeCount(randNum);

                //方法1
                WindowManager windowManager = getWindowManager();
                Display display = windowManager.getDefaultDisplay();
                int screenWidth = screenWidth = display.getWidth();
                int screenHeight = screenHeight = display.getHeight();


                // 方法2
                DisplayMetrics dm = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(dm);

                System.out.println("屏幕密度信息为："+dm);

                float width=dm.widthPixels*dm.density;
                float height=dm.heightPixels*dm.density;
//                tv.setTextSize(20);
                //System.out.println("屏幕密度信息为："+dm);
                System.out.println("First method:"+"Y="+screenWidth+";X="+screenHeight);
              //getDefaultScreenDensity();
                //getScreenDensity_ByResources();
                getScreenDensity_ByWindowManager();
                getScreenSizeOfDevice();
                Log.v(TAG,"160dp转px="+ convertDpToPixel(160));
                Log.v(TAG,"720px转dp="+ convertPixelToDp(720));
                // Toast.makeText(MainActivity.this,""+ badgeView.getText(),Toast.LENGTH_LONG).show();
            }
        });

    }

    // 通过WindowManager获取
    public void getScreenDensity_ByWindowManager(){
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();//屏幕分辨率容器
        getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        int width = mDisplayMetrics.widthPixels;
        int height = mDisplayMetrics.heightPixels;
        float density = mDisplayMetrics.density;
        int densityDpi = mDisplayMetrics.densityDpi;
        float xdpi=mDisplayMetrics.xdpi;
        float ydpi=mDisplayMetrics.ydpi;
        float scaledDensity=mDisplayMetrics.scaledDensity;
        Log.d(TAG,"屏幕分辨率: ["+width+"x"+height+"],density="+density
                +",densityDpi="+densityDpi);
        Log.d(TAG,"屏幕分辨率：xdpi="+xdpi
                +",ydpi="+ydpi+",scaledDensity="+scaledDensity);
        Log.d(TAG,"屏幕分辨率参数--mDisplayMetrics="+mDisplayMetrics);
    }
    // 通过Resources获取
    public void getScreenDensity_ByResources(){
        DisplayMetrics mDisplayMetrics = getResources().getDisplayMetrics();
        int width = mDisplayMetrics.widthPixels;
        int height = mDisplayMetrics.heightPixels;
        float density = mDisplayMetrics.density;
        int densityDpi = mDisplayMetrics.densityDpi;
        float xdpi=mDisplayMetrics.xdpi;
        float ydpi=mDisplayMetrics.ydpi;
        float scaledDensity=mDisplayMetrics.scaledDensity;

        Log.d(TAG,"屏幕分辨率: ["+width+"x"+height+"],density="+density
                +",densityDpi="+densityDpi);
        Log.d(TAG,"屏幕分辨率：xdpi="+xdpi
                +",ydpi="+ydpi+",scaledDensity="+scaledDensity);

        Log.d(TAG,"屏幕参数mDisplayMetrics="+mDisplayMetrics);

    }

    // 获取屏幕的默认分辨率
    public void getDefaultScreenDensity(){

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        Log.d(TAG,"屏幕默认的分辨率信息: "+point.toString());

    }
    //获取屏幕尺寸
    private void getScreenSizeOfDevice() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int widthPixels=dm.widthPixels;//720px
        int heightPixels=dm.heightPixels;//1280px
        float xdpi=dm.xdpi;//345.0566
        float ydpi=dm.ydpi;//342.23157

        double x = Math.pow(widthPixels/ xdpi, 2);
        double y = Math.pow(heightPixels / ydpi, 2);
        double screenInches = Math.sqrt(x + y);
        Log.v(TAG,"widthPixels="+widthPixels+
                ",heightPixels="+heightPixels+",xdpi="+xdpi+",ydpi="+ydpi);
        Log.v(TAG,"屏幕宽英寸="+widthPixels/xdpi+",高英寸="+heightPixels/ydpi);
        Log.d(TAG,"屏幕英寸 "+screenInches);
    }
    //dp转成px
    private int convertDpToPixel(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return (int)(dp*displayMetrics.density);
    }
    //px转成dp
    private int convertPixelToDp(int pixel) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return (int)(pixel/displayMetrics.density);
    }
}

   // WindowManager windowManager = getWindowManager();
//        Display mDisplay = windowManager.getDefaultDisplay();
//        int width = mDisplay.getWidth();
//        int height = mDisplay.getHeight();
//Log.d(TAG,"屏幕默认的分辨率信息: ["+width+"x"+height+"]");
//        Log.d(TAG,"Screen mDisplay: "+mDisplay);