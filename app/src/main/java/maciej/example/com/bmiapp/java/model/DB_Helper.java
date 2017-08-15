package maciej.example.com.bmiapp.java.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Maciej on 2017-08-11.
 */

public class DB_Helper extends OrmLiteSqliteOpenHelper {

    public static final String DB_NAME = "bmi_db.db";
    public static final int DB_VERSION = 1;
    private Dao<BMI_DB, Long> bmiDao;

    public Dao<BMI_DB, Long> getBmiDao(){
        if(bmiDao == null){
            try {
                bmiDao = getDao(BMI_DB.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bmiDao;
    }



    public DB_Helper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, BMI_DB.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, BMI_DB.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        onCreate(database, connectionSource);
    }
}
