package com.livpure.safedrink.dispenser.data;

import android.content.Context;
import com.livpure.safedrink.database.dao.DashboardDao;
import com.livpure.safedrink.database.database.AppDataBase;
import com.livpure.safedrink.dispenser.data.models.EnvyDashbordOffline;
import com.livpure.safedrink.utils.RxUtilsKt;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DispenserOflineRepository.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/livpure/safedrink/dispenser/data/DispenserOflineRepository;", "", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "dashboardDao", "Lcom/livpure/safedrink/database/dao/DashboardDao;", "database", "Lcom/livpure/safedrink/database/database/AppDataBase;", "deleteDashboard", "", "getDashboard", "", "Lcom/livpure/safedrink/dispenser/data/models/EnvyDashbordOffline;", "insert", "dashboard", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DispenserOflineRepository {
    private DashboardDao dashboardDao;
    private final AppDataBase database;

    public DispenserOflineRepository(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppDataBase dataBase = AppDataBase.Companion.getDataBase(context);
        this.database = dataBase;
        this.dashboardDao = dataBase.dashboardDao();
    }

    public final void insert(final EnvyDashbordOffline dashboard) {
        Intrinsics.checkNotNullParameter(dashboard, "dashboard");
        RxUtilsKt.subscribeOnBackground(new Function0<Unit>() { // from class: com.livpure.safedrink.dispenser.data.DispenserOflineRepository$insert$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DashboardDao dashboardDao;
                dashboardDao = DispenserOflineRepository.this.dashboardDao;
                dashboardDao.insertDashboardData(dashboard);
            }
        });
    }

    public final void deleteDashboard() {
        RxUtilsKt.subscribeOnBackground(new Function0<Unit>() { // from class: com.livpure.safedrink.dispenser.data.DispenserOflineRepository$deleteDashboard$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DashboardDao dashboardDao;
                dashboardDao = DispenserOflineRepository.this.dashboardDao;
                dashboardDao.deleteAllDashboardData();
            }
        });
    }

    public final List<EnvyDashbordOffline> getDashboard() {
        return this.dashboardDao.getAllDashboardData();
    }
}
