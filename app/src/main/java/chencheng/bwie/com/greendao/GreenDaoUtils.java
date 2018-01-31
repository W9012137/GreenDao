package chencheng.bwie.com.greendao;

import android.database.sqlite.SQLiteDatabase;


import com.kson.greendao.gen.DaoMaster;
import com.kson.greendao.gen.DaoSession;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/01/26
 * Description:封装greendao，orm框架
 */
public class GreenDaoUtils {

    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private DaoMaster.DevOpenHelper devOpenHelper;
    private SQLiteDatabase database;




    private volatile static GreenDaoUtils mInstance;
    private GreenDaoUtils(){

    }

    /**
     * 双重检验锁单利模式实现，不加同步锁，多线程同时调用这个方法的时候，可能会创建多个对象
     * 加上同步锁，同一时刻只能有一个线程访问该方法
     * @return
     */
    public static GreenDaoUtils getmInstance(){
        if (mInstance==null){
            synchronized (GreenDaoUtils.class){
                if (mInstance==null){
                    mInstance = new GreenDaoUtils();
                }
            }
        }

        return mInstance;
    }

    public void init(){
        setDataBase();
    }

    /**
     * 初始化greendao自动生成的几个重要的对象
     */
    private void setDataBase(){

        devOpenHelper = new DaoMaster.DevOpenHelper(App.context,"kson-db",null);

        database = devOpenHelper.getWritableDatabase();

        daoMaster = new DaoMaster(database);

        daoSession = daoMaster.newSession();



    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

}
