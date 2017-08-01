package bupt.com.badgeview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=(Button)findViewById(R.id.bt);
         BadgeView badgeView = new BadgeView(this);
        badgeView.setTargetView(findViewById(R.id.rl));
        badgeView.setBadgeGravity(Gravity.RIGHT | Gravity.CENTER);
        badgeView.setBadgeMargin(0, 0, 10, 0);
        badgeView.setText("韩维");
        final BadgeView badgeView2 = new BadgeView(this);
        badgeView2.setTargetView(findViewById(R.id.rl2));
bt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {//点击按钮出现随机数
        Random r=new Random();
        int randNum = r.nextInt(1000);//0-1000的随机数
        badgeView2.setBadgeCount(randNum);
        //
    }
});


    }
}
