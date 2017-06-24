package jp.co.sakusaku.sk_kintai.activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by rhirose on 2017/04/15.
 * 打刻画面アクティビティクラス
 */

public class StampingActivity extends AppCompatActivity {

    /**
     * 初期表示
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 初期設定
        super.onCreate(savedInstanceState);

        // 描画する画面のxmlを設定
        setContentView(R.layout.stamping_layout);

        // 画面タイトルを設定。
        String title = "打刻";

        TextView strTitle = (TextView) findViewById(R.id.title);
        strTitle.setText(title);

        // 現在日時を取得　（yyyy年MM月dd日(曜日)　hh：mm：ss）
        long millsec = System.currentTimeMillis();
        final Date now = getSysDate(millsec);

        // 画面へセット
        TextView nowDate = (TextView) findViewById(R.id.now);
        nowDate.setText(now.toString());

        // 出勤時間を表示
        final String at = "出勤時間　:　" ;

        TextView attendance_time = (TextView) findViewById(R.id.attend);
        attendance_time.setText(at);


        // 退勤時間を表示
        String lv = "退勤時間　:　";

        TextView leave_time = (TextView) findViewById(R.id.leave);
        leave_time.setText(lv);


        // 出勤ボタン押下時のイベントを設定する
        // TODO 出退勤テーブルに値を登録する・出勤時間に値をセットする
        findViewById(R.id.attendance).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // ボタン押下時のイベント
                StringBuilder attend = new StringBuilder();
                attend = attend.append(at);
                attend = attend.append(now.toString());

                TextView attendance_time = (TextView) findViewById(R.id.attend);
                attendance_time.setText(attend);

                // TODO 出退勤テーブルに値を登録する

            }
        });

        // 退勤ボタン押下時のイベントを設定する

        findViewById(R.id.leaving).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // ボタン押下時のイベント
                StringBuilder leave = new StringBuilder();
                leave = leave.append(lv);
                leave = leave.append(now.toString());

                TextView attendance_time = (TextView) findViewById(R.id.leave);
                attendance_time.setText(leave);

                // TODO 出退勤テーブルに値を登録する

            }
        });
    }

    /**
     * ミリ秒をDate型に変換する
     *
     * @param millsec
     * @return
     */
    private Date getSysDate(Long millsec) {
        Date now = new Date(millsec);

        return now;
    }

    //test
    // s\\ample
    // Issueテスト
}