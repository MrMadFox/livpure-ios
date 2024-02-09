package com.livpure.safedrink.subscription.plan.data.model;

import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.DashboardDetails;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DashboardDetailsResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/DashboardDetailsResponse;", "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "dashboardDetails", "Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/DashboardDetails;", "(Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/DashboardDetails;)V", "getDashboardDetails", "()Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/DashboardDetails;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DashboardDetailsResponse extends BaseV1Response {
    private final DashboardDetails dashboardDetails;

    public static /* synthetic */ DashboardDetailsResponse copy$default(DashboardDetailsResponse dashboardDetailsResponse, DashboardDetails dashboardDetails, int i, Object obj) {
        if ((i & 1) != 0) {
            dashboardDetails = dashboardDetailsResponse.dashboardDetails;
        }
        return dashboardDetailsResponse.copy(dashboardDetails);
    }

    public final DashboardDetails component1() {
        return this.dashboardDetails;
    }

    public final DashboardDetailsResponse copy(DashboardDetails dashboardDetails) {
        return new DashboardDetailsResponse(dashboardDetails);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DashboardDetailsResponse) && Intrinsics.areEqual(this.dashboardDetails, ((DashboardDetailsResponse) obj).dashboardDetails);
    }

    public int hashCode() {
        DashboardDetails dashboardDetails = this.dashboardDetails;
        if (dashboardDetails == null) {
            return 0;
        }
        return dashboardDetails.hashCode();
    }

    public String toString() {
        return "DashboardDetailsResponse(dashboardDetails=" + this.dashboardDetails + ')';
    }

    public final DashboardDetails getDashboardDetails() {
        return this.dashboardDetails;
    }

    public DashboardDetailsResponse(DashboardDetails dashboardDetails) {
        super(null, null, null, null, 15, null);
        this.dashboardDetails = dashboardDetails;
    }
}
