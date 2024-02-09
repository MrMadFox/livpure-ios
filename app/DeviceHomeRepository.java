package com.livpure.safedrink.app;

import android.content.Context;
import com.livpure.safedrink.database.dao.DeviceDao;
import com.livpure.safedrink.database.database.AppDataBase;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.utils.RxUtilsKt;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DeviceHomeRepository.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/livpure/safedrink/app/DeviceHomeRepository;", "", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "database", "Lcom/livpure/safedrink/database/database/AppDataBase;", "deviceDao", "Lcom/livpure/safedrink/database/dao/DeviceDao;", "deleteAllDevice", "", "getAllDevices", "", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "insert", AndroidContextPlugin.DEVICE_KEY, "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeviceHomeRepository {
    private final AppDataBase database;
    private DeviceDao deviceDao;

    public DeviceHomeRepository(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppDataBase dataBase = AppDataBase.Companion.getDataBase(context);
        this.database = dataBase;
        this.deviceDao = dataBase.deviceDao();
    }

    public final void insert(final List<DeviceList> device) {
        Intrinsics.checkNotNullParameter(device, "device");
        RxUtilsKt.subscribeOnBackground(new Function0<Unit>() { // from class: com.livpure.safedrink.app.DeviceHomeRepository$insert$1
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
                DeviceDao deviceDao;
                deviceDao = DeviceHomeRepository.this.deviceDao;
                deviceDao.insertAllDevice(device);
            }
        });
    }

    public final void deleteAllDevice() {
        RxUtilsKt.subscribeOnBackground(new Function0<Unit>() { // from class: com.livpure.safedrink.app.DeviceHomeRepository$deleteAllDevice$1
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
                DeviceDao deviceDao;
                try {
                    deviceDao = DeviceHomeRepository.this.deviceDao;
                    deviceDao.deleteAllDevice();
                } catch (Exception unused) {
                }
            }
        });
    }

    public final List<DeviceList> getAllDevices() {
        return this.deviceDao.getAllDevice();
    }
}
