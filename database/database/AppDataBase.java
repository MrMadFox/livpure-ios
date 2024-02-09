package com.livpure.safedrink.database.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.livpure.safedrink.database.dao.DashboardDao;
import com.livpure.safedrink.database.dao.DeviceDao;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;
/* compiled from: AppDataBase.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/livpure/safedrink/database/database/AppDataBase;", "Landroidx/room/RoomDatabase;", "()V", "dashboardDao", "Lcom/livpure/safedrink/database/dao/DashboardDao;", "deviceDao", "Lcom/livpure/safedrink/database/dao/DeviceDao;", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AppDataBase extends RoomDatabase {
    public static final Companion Companion = new Companion(null);
    private static AppDataBase appDataBase;

    public abstract DashboardDao dashboardDao();

    public abstract DeviceDao deviceDao();

    /* compiled from: AppDataBase.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/livpure/safedrink/database/database/AppDataBase$Companion;", "", "()V", "appDataBase", "Lcom/livpure/safedrink/database/database/AppDataBase;", "getAppDataBase", "()Lcom/livpure/safedrink/database/database/AppDataBase;", "setAppDataBase", "(Lcom/livpure/safedrink/database/database/AppDataBase;)V", "getDataBase", "mContext", "Landroid/content/Context;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AppDataBase getAppDataBase() {
            return AppDataBase.appDataBase;
        }

        public final void setAppDataBase(AppDataBase appDataBase) {
            AppDataBase.appDataBase = appDataBase;
        }

        public final AppDataBase getDataBase(Context mContext) {
            AppDataBase appDataBase;
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            AppDataBase appDataBase2 = getAppDataBase();
            if (appDataBase2 == null) {
                synchronized (this) {
                    char[] charArray = "PassPhrase".toCharArray();
                    Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
                    RoomDatabase build = Room.databaseBuilder(mContext, AppDataBase.class, "Livpure_Smart_Encrypt.db").openHelperFactory(new SupportFactory(SQLiteDatabase.getBytes(charArray))).allowMainThreadQueries().build();
                    Intrinsics.checkNotNullExpressionValue(build, "databaseBuilder(mContext…inThreadQueries().build()");
                    appDataBase = (AppDataBase) build;
                    AppDataBase.Companion.setAppDataBase(appDataBase);
                }
                return appDataBase;
            }
            return appDataBase2;
        }
    }
}
