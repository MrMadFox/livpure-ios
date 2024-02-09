package com.livpure.safedrink.app.support.viewmodels;

import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import kotlin.Metadata;
/* compiled from: ContactUsViewModel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/app/support/viewmodels/ContactUsViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "()V", "serialNumber", "", "getSerialNumber", "()Ljava/lang/String;", "setSerialNumber", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ContactUsViewModel extends AnalyticsViewModel {
    private String serialNumber = "";

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final void setSerialNumber(String str) {
        this.serialNumber = str;
    }
}
