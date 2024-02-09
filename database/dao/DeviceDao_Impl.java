package com.livpure.safedrink.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public final class DeviceDao_Impl implements DeviceDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<DeviceList> __insertionAdapterOfDeviceList;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllDevice;

    public DeviceDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfDeviceList = new EntityInsertionAdapter<DeviceList>(__db) { // from class: com.livpure.safedrink.database.dao.DeviceDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `Device` (`serial_no`,`imei_no`,`user_id`,`name`,`is_configured`,`product_type`,`connectivity`,`id`) VALUES (?,?,?,?,?,?,?,nullif(?, 0))";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, DeviceList value) {
                if (value.getSerialNo() == null) {
                    stmt.bindNull(1);
                } else {
                    stmt.bindString(1, value.getSerialNo());
                }
                if (value.getImeiNo() == null) {
                    stmt.bindNull(2);
                } else {
                    stmt.bindString(2, value.getImeiNo());
                }
                if (value.getUserId() == null) {
                    stmt.bindNull(3);
                } else {
                    stmt.bindString(3, value.getUserId());
                }
                if (value.getName() == null) {
                    stmt.bindNull(4);
                } else {
                    stmt.bindString(4, value.getName());
                }
                Integer valueOf = value.isConfigured() == null ? null : Integer.valueOf(value.isConfigured().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    stmt.bindNull(5);
                } else {
                    stmt.bindLong(5, valueOf.intValue());
                }
                if (value.getProductType() == null) {
                    stmt.bindNull(6);
                } else {
                    stmt.bindString(6, value.getProductType());
                }
                if (value.getConnectivity() == null) {
                    stmt.bindNull(7);
                } else {
                    stmt.bindString(7, value.getConnectivity());
                }
                stmt.bindLong(8, value.getId());
            }
        };
        this.__preparedStmtOfDeleteAllDevice = new SharedSQLiteStatement(__db) { // from class: com.livpure.safedrink.database.dao.DeviceDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete From Device";
            }
        };
    }

    @Override // com.livpure.safedrink.database.dao.DeviceDao
    public void insertAllDevice(final List<DeviceList> deviceList) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfDeviceList.insert(deviceList);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.livpure.safedrink.database.dao.DeviceDao
    public void deleteAllDevice() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllDevice.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllDevice.release(acquire);
        }
    }

    @Override // com.livpure.safedrink.database.dao.DeviceDao
    public List<DeviceList> getAllDevice() {
        Boolean valueOf;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("Select * From Device", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "serial_no");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "imei_no");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "is_configured");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "product_type");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "connectivity");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "id");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                String string2 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                String string3 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                String string4 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                Integer valueOf2 = query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5));
                if (valueOf2 == null) {
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(valueOf2.intValue() != 0);
                }
                DeviceList deviceList = new DeviceList(string, string2, string3, string4, valueOf, query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6), query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7));
                deviceList.setId(query.getInt(columnIndexOrThrow8));
                arrayList.add(deviceList);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
