package com.livpure.safedrink.database.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.livpure.safedrink.database.dao.DashboardDao;
import com.livpure.safedrink.database.dao.DashboardDao_Impl;
import com.livpure.safedrink.database.dao.DeviceDao;
import com.livpure.safedrink.database.dao.DeviceDao_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public final class AppDataBase_Impl extends AppDataBase {
    private volatile DashboardDao _dashboardDao;
    private volatile DeviceDao _deviceDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
        return configuration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(configuration.context).name(configuration.name).callback(new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) { // from class: com.livpure.safedrink.database.database.AppDataBase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase _db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase _db) {
                _db.execSQL("CREATE TABLE IF NOT EXISTS `Device` (`serial_no` TEXT, `imei_no` TEXT, `user_id` TEXT, `name` TEXT, `is_configured` INTEGER, `product_type` TEXT, `connectivity` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `EnvyDashbord` (`serialNo` TEXT, `lastSyncOn` TEXT, `remaining` TEXT, `planDetails` TEXT, `filterLife` TEXT, `tankStatus` TEXT, `productType` TEXT, `connectivity` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `BLERechargeList` (`rechargeList` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `EnvyBLEResponse` (`serialNo` TEXT, `response` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                _db.execSQL(RoomMasterTable.CREATE_QUERY);
                _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '143aa5778f815ad6550041eb020bb8e8')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase _db) {
                _db.execSQL("DROP TABLE IF EXISTS `Device`");
                _db.execSQL("DROP TABLE IF EXISTS `EnvyDashbord`");
                _db.execSQL("DROP TABLE IF EXISTS `BLERechargeList`");
                _db.execSQL("DROP TABLE IF EXISTS `EnvyBLEResponse`");
                if (AppDataBase_Impl.this.mCallbacks != null) {
                    int size = AppDataBase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) AppDataBase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected void onCreate(SupportSQLiteDatabase _db) {
                if (AppDataBase_Impl.this.mCallbacks != null) {
                    int size = AppDataBase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) AppDataBase_Impl.this.mCallbacks.get(i)).onCreate(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase _db) {
                AppDataBase_Impl.this.mDatabase = _db;
                AppDataBase_Impl.this.internalInitInvalidationTracker(_db);
                if (AppDataBase_Impl.this.mCallbacks != null) {
                    int size = AppDataBase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) AppDataBase_Impl.this.mCallbacks.get(i)).onOpen(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase _db) {
                DBUtil.dropFtsSyncTriggers(_db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
                HashMap hashMap = new HashMap(8);
                hashMap.put("serial_no", new TableInfo.Column("serial_no", "TEXT", false, 0, null, 1));
                hashMap.put("imei_no", new TableInfo.Column("imei_no", "TEXT", false, 0, null, 1));
                hashMap.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                hashMap.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
                hashMap.put("is_configured", new TableInfo.Column("is_configured", "INTEGER", false, 0, null, 1));
                hashMap.put("product_type", new TableInfo.Column("product_type", "TEXT", false, 0, null, 1));
                hashMap.put("connectivity", new TableInfo.Column("connectivity", "TEXT", false, 0, null, 1));
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                TableInfo tableInfo = new TableInfo("Device", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(_db, "Device");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "Device(com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(9);
                hashMap2.put("serialNo", new TableInfo.Column("serialNo", "TEXT", false, 0, null, 1));
                hashMap2.put("lastSyncOn", new TableInfo.Column("lastSyncOn", "TEXT", false, 0, null, 1));
                hashMap2.put("remaining", new TableInfo.Column("remaining", "TEXT", false, 0, null, 1));
                hashMap2.put("planDetails", new TableInfo.Column("planDetails", "TEXT", false, 0, null, 1));
                hashMap2.put("filterLife", new TableInfo.Column("filterLife", "TEXT", false, 0, null, 1));
                hashMap2.put("tankStatus", new TableInfo.Column("tankStatus", "TEXT", false, 0, null, 1));
                hashMap2.put("productType", new TableInfo.Column("productType", "TEXT", false, 0, null, 1));
                hashMap2.put("connectivity", new TableInfo.Column("connectivity", "TEXT", false, 0, null, 1));
                hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                TableInfo tableInfo2 = new TableInfo("EnvyDashbord", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(_db, "EnvyDashbord");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "EnvyDashbord(com.livpure.safedrink.dispenser.data.models.EnvyDashbordOffline).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(2);
                hashMap3.put("rechargeList", new TableInfo.Column("rechargeList", "TEXT", true, 0, null, 1));
                hashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                TableInfo tableInfo3 = new TableInfo("BLERechargeList", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(_db, "BLERechargeList");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "BLERechargeList(com.livpure.safedrink.bolt.data.models.RechargeResponse).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(3);
                hashMap4.put("serialNo", new TableInfo.Column("serialNo", "TEXT", false, 0, null, 1));
                hashMap4.put("response", new TableInfo.Column("response", "TEXT", false, 0, null, 1));
                hashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                TableInfo tableInfo4 = new TableInfo("EnvyBLEResponse", hashMap4, new HashSet(0), new HashSet(0));
                TableInfo read4 = TableInfo.read(_db, "EnvyBLEResponse");
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(false, "EnvyBLEResponse(com.livpure.safedrink.dispenser.data.models.EnvyBLEResponse).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "143aa5778f815ad6550041eb020bb8e8", "e9d7906cc89be62fa9ec00977827eeaf")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "Device", "EnvyDashbord", "BLERechargeList", "EnvyBLEResponse");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `Device`");
            writableDatabase.execSQL("DELETE FROM `EnvyDashbord`");
            writableDatabase.execSQL("DELETE FROM `BLERechargeList`");
            writableDatabase.execSQL("DELETE FROM `EnvyBLEResponse`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(DeviceDao.class, DeviceDao_Impl.getRequiredConverters());
        hashMap.put(DashboardDao.class, DashboardDao_Impl.getRequiredConverters());
        return hashMap;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // com.livpure.safedrink.database.database.AppDataBase
    public DeviceDao deviceDao() {
        DeviceDao deviceDao;
        if (this._deviceDao != null) {
            return this._deviceDao;
        }
        synchronized (this) {
            if (this._deviceDao == null) {
                this._deviceDao = new DeviceDao_Impl(this);
            }
            deviceDao = this._deviceDao;
        }
        return deviceDao;
    }

    @Override // com.livpure.safedrink.database.database.AppDataBase
    public DashboardDao dashboardDao() {
        DashboardDao dashboardDao;
        if (this._dashboardDao != null) {
            return this._dashboardDao;
        }
        synchronized (this) {
            if (this._dashboardDao == null) {
                this._dashboardDao = new DashboardDao_Impl(this);
            }
            dashboardDao = this._dashboardDao;
        }
        return dashboardDao;
    }
}
