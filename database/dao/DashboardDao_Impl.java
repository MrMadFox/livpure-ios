package com.livpure.safedrink.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.livpure.safedrink.bolt.data.models.RechargeResponse;
import com.livpure.safedrink.dispenser.data.models.EnvyBLEResponse;
import com.livpure.safedrink.dispenser.data.models.EnvyDashbordOffline;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public final class DashboardDao_Impl implements DashboardDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<EnvyBLEResponse> __insertionAdapterOfEnvyBLEResponse;
    private final EntityInsertionAdapter<EnvyDashbordOffline> __insertionAdapterOfEnvyDashbordOffline;
    private final EntityInsertionAdapter<RechargeResponse> __insertionAdapterOfRechargeResponse;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllDashboardData;
    private final SharedSQLiteStatement __preparedStmtOfDeleteBLERechargeList;
    private final SharedSQLiteStatement __preparedStmtOfDeleteBLEResponse;

    public DashboardDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfEnvyDashbordOffline = new EntityInsertionAdapter<EnvyDashbordOffline>(__db) { // from class: com.livpure.safedrink.database.dao.DashboardDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `EnvyDashbord` (`serialNo`,`lastSyncOn`,`remaining`,`planDetails`,`filterLife`,`tankStatus`,`productType`,`connectivity`,`id`) VALUES (?,?,?,?,?,?,?,?,nullif(?, 0))";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, EnvyDashbordOffline value) {
                if (value.getSerialNo() == null) {
                    stmt.bindNull(1);
                } else {
                    stmt.bindString(1, value.getSerialNo());
                }
                if (value.getLastSyncOn() == null) {
                    stmt.bindNull(2);
                } else {
                    stmt.bindString(2, value.getLastSyncOn());
                }
                if (value.getRemaining() == null) {
                    stmt.bindNull(3);
                } else {
                    stmt.bindString(3, value.getRemaining());
                }
                if (value.getPlanDetails() == null) {
                    stmt.bindNull(4);
                } else {
                    stmt.bindString(4, value.getPlanDetails());
                }
                if (value.getFilterLife() == null) {
                    stmt.bindNull(5);
                } else {
                    stmt.bindString(5, value.getFilterLife());
                }
                if (value.getTankStatus() == null) {
                    stmt.bindNull(6);
                } else {
                    stmt.bindString(6, value.getTankStatus());
                }
                if (value.getProductType() == null) {
                    stmt.bindNull(7);
                } else {
                    stmt.bindString(7, value.getProductType());
                }
                if (value.getConnectivity() == null) {
                    stmt.bindNull(8);
                } else {
                    stmt.bindString(8, value.getConnectivity());
                }
                stmt.bindLong(9, value.getId());
            }
        };
        this.__insertionAdapterOfRechargeResponse = new EntityInsertionAdapter<RechargeResponse>(__db) { // from class: com.livpure.safedrink.database.dao.DashboardDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `BLERechargeList` (`rechargeList`,`id`) VALUES (?,nullif(?, 0))";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, RechargeResponse value) {
                if (value.getRechargeList() == null) {
                    stmt.bindNull(1);
                } else {
                    stmt.bindString(1, value.getRechargeList());
                }
                stmt.bindLong(2, value.getId());
            }
        };
        this.__insertionAdapterOfEnvyBLEResponse = new EntityInsertionAdapter<EnvyBLEResponse>(__db) { // from class: com.livpure.safedrink.database.dao.DashboardDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `EnvyBLEResponse` (`serialNo`,`response`,`id`) VALUES (?,?,nullif(?, 0))";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, EnvyBLEResponse value) {
                if (value.getSerialNo() == null) {
                    stmt.bindNull(1);
                } else {
                    stmt.bindString(1, value.getSerialNo());
                }
                if (value.getResponse() == null) {
                    stmt.bindNull(2);
                } else {
                    stmt.bindString(2, value.getResponse());
                }
                stmt.bindLong(3, value.getId());
            }
        };
        this.__preparedStmtOfDeleteAllDashboardData = new SharedSQLiteStatement(__db) { // from class: com.livpure.safedrink.database.dao.DashboardDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete From EnvyDashbord";
            }
        };
        this.__preparedStmtOfDeleteBLERechargeList = new SharedSQLiteStatement(__db) { // from class: com.livpure.safedrink.database.dao.DashboardDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete From BLERechargeList";
            }
        };
        this.__preparedStmtOfDeleteBLEResponse = new SharedSQLiteStatement(__db) { // from class: com.livpure.safedrink.database.dao.DashboardDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete From EnvyBLEResponse";
            }
        };
    }

    @Override // com.livpure.safedrink.database.dao.DashboardDao
    public void insertDashboardData(final EnvyDashbordOffline dashboard) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfEnvyDashbordOffline.insert((EntityInsertionAdapter<EnvyDashbordOffline>) dashboard);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.livpure.safedrink.database.dao.DashboardDao
    public void insertBLERechargeList(final List<RechargeResponse> bleRechargeList) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRechargeResponse.insert(bleRechargeList);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.livpure.safedrink.database.dao.DashboardDao
    public void insertBLEResponse(final EnvyBLEResponse bleRechargeList) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfEnvyBLEResponse.insert((EntityInsertionAdapter<EnvyBLEResponse>) bleRechargeList);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.livpure.safedrink.database.dao.DashboardDao
    public void deleteAllDashboardData() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllDashboardData.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllDashboardData.release(acquire);
        }
    }

    @Override // com.livpure.safedrink.database.dao.DashboardDao
    public void deleteBLERechargeList() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteBLERechargeList.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteBLERechargeList.release(acquire);
        }
    }

    @Override // com.livpure.safedrink.database.dao.DashboardDao
    public void deleteBLEResponse() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteBLEResponse.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteBLEResponse.release(acquire);
        }
    }

    @Override // com.livpure.safedrink.database.dao.DashboardDao
    public List<EnvyDashbordOffline> getAllDashboardData() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("Select * From EnvyDashbord", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "serialNo");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "lastSyncOn");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "remaining");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "planDetails");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "filterLife");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "tankStatus");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "productType");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "connectivity");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                EnvyDashbordOffline envyDashbordOffline = new EnvyDashbordOffline(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6), query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7), query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8));
                envyDashbordOffline.setId(query.getInt(columnIndexOrThrow9));
                arrayList.add(envyDashbordOffline);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.livpure.safedrink.database.dao.DashboardDao
    public List<RechargeResponse> getAllBLERechargeList() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("Select * From BLERechargeList", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "rechargeList");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "id");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                RechargeResponse rechargeResponse = new RechargeResponse(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow));
                rechargeResponse.setId(query.getInt(columnIndexOrThrow2));
                arrayList.add(rechargeResponse);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.livpure.safedrink.database.dao.DashboardDao
    public List<EnvyBLEResponse> getAllBLEResponse() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("Select * From EnvyBLEResponse", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "serialNo");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "response");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "id");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                EnvyBLEResponse envyBLEResponse = new EnvyBLEResponse(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2));
                envyBLEResponse.setId(query.getInt(columnIndexOrThrow3));
                arrayList.add(envyBLEResponse);
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
