package com.livpure.safedrink.database.dao;

import com.livpure.safedrink.bolt.data.models.RechargeResponse;
import com.livpure.safedrink.dispenser.data.models.EnvyBLEResponse;
import com.livpure.safedrink.dispenser.data.models.EnvyDashbordOffline;
import java.util.List;
import kotlin.Metadata;
/* compiled from: DashboardDao.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H'J\b\u0010\u0005\u001a\u00020\u0003H'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H'J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH'J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\fH'¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/database/dao/DashboardDao;", "", "deleteAllDashboardData", "", "deleteBLERechargeList", "deleteBLEResponse", "getAllBLERechargeList", "", "Lcom/livpure/safedrink/bolt/data/models/RechargeResponse;", "getAllBLEResponse", "Lcom/livpure/safedrink/dispenser/data/models/EnvyBLEResponse;", "getAllDashboardData", "Lcom/livpure/safedrink/dispenser/data/models/EnvyDashbordOffline;", "insertBLERechargeList", "bleRechargeList", "insertBLEResponse", "insertDashboardData", "dashboard", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface DashboardDao {
    void deleteAllDashboardData();

    void deleteBLERechargeList();

    void deleteBLEResponse();

    List<RechargeResponse> getAllBLERechargeList();

    List<EnvyBLEResponse> getAllBLEResponse();

    List<EnvyDashbordOffline> getAllDashboardData();

    void insertBLERechargeList(List<RechargeResponse> list);

    void insertBLEResponse(EnvyBLEResponse envyBLEResponse);

    void insertDashboardData(EnvyDashbordOffline envyDashbordOffline);
}
