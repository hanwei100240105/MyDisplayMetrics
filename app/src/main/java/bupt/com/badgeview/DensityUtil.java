package bupt.com.badgeview;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * Created by HanWei on 2017/8/2.
 */

public class DensityUtil {
private Context context;
public DensityUtil(Context context) {
  this.context=context;
    }
    public void getScreenDensity_ByResources(){
        DisplayMetrics mDisplayMetrics = context.getResources().getDisplayMetrics();
        Log.v("text","调用了");

    }

}
