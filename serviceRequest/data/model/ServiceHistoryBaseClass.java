package com.livpure.safedrink.serviceRequest.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServiceHistoryBaseClass.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/ServiceHistoryBaseClass;", "", "cases", "", "Lcom/livpure/safedrink/serviceRequest/data/model/ServiceHistoryResponse;", "(Ljava/util/List;)V", "getCases", "()Ljava/util/List;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceHistoryBaseClass {
    @SerializedName("cases")
    private final List<ServiceHistoryResponse> cases;

    public ServiceHistoryBaseClass(List<ServiceHistoryResponse> cases) {
        Intrinsics.checkNotNullParameter(cases, "cases");
        this.cases = cases;
    }

    public final List<ServiceHistoryResponse> getCases() {
        return this.cases;
    }
}
