package com.enlern.pen.sms.greendao.node_save;

import android.database.sqlite.SQLiteDatabase;

import com.enlern.pen.sms.application.MyApplication;
import com.enlern.pen.sms.greendao.DaoMaster;
import com.enlern.pen.sms.greendao.DaoSession;

/**
 * Created by pen on 2018/3/5.
 * 数据库插入工具类
 */

public class NodeSaveUtils {
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private static NodeSaveUtils greenDaoUtils;

    private NodeSaveUtils() {
    }

    public static NodeSaveUtils getSingleTon() {
        if (greenDaoUtils == null) {
            greenDaoUtils = new NodeSaveUtils();
        }
        return greenDaoUtils;
    }

    private void initGreenDao() {
        mHelper = new DaoMaster.DevOpenHelper(MyApplication.getInstance(), "EN_NODE_SAVE", null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getmDaoSession() {
        if (mDaoMaster == null) {
            initGreenDao();
        }
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        if (db == null) {
            initGreenDao();
        }
        return db;
    }
}
