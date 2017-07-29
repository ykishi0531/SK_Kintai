package jp.co.sakusaku.sk_kintai.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqliteOpenHelper extends SQLiteOpenHelper {

    public MySqliteOpenHelper(Context context) {
        super(context, "sk_kintai.db", null, 1);
    }

    /**
     * 初回起動時の処理
     * @param db
     *
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS attendance_achievements (" +
                        "  worked_year INTEGER," +
                        "  worked_month INTEGER," +
                        "  worked_day INTEGER," +
                        "  work_start_at TEXT," +
                        "  work_end_at TEXT," +
                        "  break_time TEXT," +
                        "  remarks TEXT," +
                        "  application_major_category_code TEXT," +
                        "  application_middle_category_code TEXT," +
                        "  PRIMARY KEY (worked_year, worked_month, worked_day)" +
                        ")"
        );
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS application_major_categories (" +
                        "  application_major_category_code TEXT," +
                        "  application_major_category_name TEXT NOT NULL," +
                        "  uneditable_flag INTEGER DEFAULT 0," +
                        "  deleted_flag INTEGER DEFAULT 0," +
                        "  PRIMARY KEY (application_major_category_code)" +
                        ")"
        );
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS application_middle_categories (" +
                        "  application_major_category_code TEXT," +
                        "  application_middle_category_code TEXT," +
                        "  application_middle_category_name TEXT NOT NULL," +
                        "  uneditable_flag INTEGER DEFAULT 0," +
                        "  deleted_flag INTEGER DEFAULT 0," +
                        "  PRIMARY KEY (application_major_category_code, application_middle_category_code)" +
                        ")"
        );
        System.out.println("Table created...");
    }

    /**
     * バージョンアップした場合に実行される
     * @param db
     * @param oldVersion
     * @param newVersion
     *
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
