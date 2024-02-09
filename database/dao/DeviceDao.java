package com.livpure.safedrink.database.dao;

import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import java.util.List;
import kotlin.Metadata;
/* compiled from: DeviceDao.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/database/dao/DeviceDao;", "", "deleteAllDevice", "", "getAllDevice", "", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "insertAllDevice", "deviceList", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface DeviceDao {
    void deleteAllDevice();

    List<DeviceList> getAllDevice();

    void insertAllDevice(List<DeviceList> list);
}
