package com.livpure.safedrink.subscription.payment.viewmodel;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.login.data.models.User;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ReferAndEarnModel.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/viewmodel/ReferAndEarnModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "()V", "initials", "Landroidx/lifecycle/LiveData;", "", "getInitials", "()Landroidx/lifecycle/LiveData;", "user", "Landroidx/lifecycle/MutableLiveData;", "Lcom/livpure/safedrink/login/data/models/User;", "getUser", "()Landroidx/lifecycle/MutableLiveData;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferAndEarnModel extends AnalyticsViewModel {
    private final LiveData<String> initials;
    private final MutableLiveData<User> user;

    public ReferAndEarnModel() {
        MutableLiveData<User> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(LSApplication.Companion.getUser());
        this.user = mutableLiveData;
        LiveData<String> map = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.ReferAndEarnModel$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m1384initials$lambda3;
                m1384initials$lambda3 = ReferAndEarnModel.m1384initials$lambda3((User) obj);
                return m1384initials$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(user) { user ->\n    …\"\"\n        initials\n    }");
        this.initials = map;
    }

    public final MutableLiveData<User> getUser() {
        return this.user;
    }

    public final LiveData<String> getInitials() {
        return this.initials;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initials$lambda-3  reason: not valid java name */
    public static final String m1384initials$lambda3(User user) {
        List<String> split$default;
        String name = user.getName();
        String obj = name != null ? StringsKt.trim((CharSequence) name).toString() : null;
        if (obj != null && (split$default = StringsKt.split$default((CharSequence) obj, new char[]{SafeJsonPrimitive.NULL_CHAR}, false, 0, 6, (Object) null)) != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : split$default) {
                Character firstOrNull = StringsKt.firstOrNull(str);
                String ch = firstOrNull != null ? firstOrNull.toString() : null;
                if (ch != null) {
                    arrayList.add(ch);
                }
            }
            Iterator it = arrayList.iterator();
            if (!it.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it.next();
            while (it.hasNext()) {
                next = ((String) next) + ((String) it.next());
            }
            String str2 = (String) next;
            if (str2 != null) {
                return str2;
            }
        }
        return "";
    }
}
