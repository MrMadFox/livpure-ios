package com.livpure.safedrink.app;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.login.data.models.User;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ProfileViewModel.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/livpure/safedrink/app/ProfileViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "()V", "initials", "Landroidx/lifecycle/LiveData;", "", "getInitials", "()Landroidx/lifecycle/LiveData;", "user", "Landroidx/lifecycle/MutableLiveData;", "Lcom/livpure/safedrink/login/data/models/User;", "getUser", "()Landroidx/lifecycle/MutableLiveData;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ProfileViewModel extends AnalyticsViewModel {
    private final LiveData<String> initials;
    private final MutableLiveData<User> user;

    public ProfileViewModel() {
        MutableLiveData<User> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(LSApplication.Companion.getUser());
        this.user = mutableLiveData;
        LiveData<String> map = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.app.ProfileViewModel$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m448initials$lambda3;
                m448initials$lambda3 = ProfileViewModel.m448initials$lambda3((User) obj);
                return m448initials$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(user) { user ->\n    … }\n        initials\n    }");
        this.initials = map;
    }

    public final MutableLiveData<User> getUser() {
        return this.user;
    }

    public final LiveData<String> getInitials() {
        return this.initials;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a9 A[ORIG_RETURN, RETURN] */
    /* renamed from: initials$lambda-3  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String m448initials$lambda3(com.livpure.safedrink.login.data.models.User r11) {
        /*
            java.lang.String r11 = r11.getName()
            r0 = 0
            if (r11 == 0) goto L12
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            java.lang.CharSequence r11 = kotlin.text.StringsKt.trim(r11)
            java.lang.String r11 = r11.toString()
            goto L13
        L12:
            r11 = r0
        L13:
            r1 = 1
            r2 = 0
            if (r11 == 0) goto L27
            r3 = r11
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L22
            r3 = 1
            goto L23
        L22:
            r3 = 0
        L23:
            if (r3 != r1) goto L27
            r3 = 1
            goto L28
        L27:
            r3 = 0
        L28:
            java.lang.String r4 = ""
            if (r3 == 0) goto La9
            r5 = r11
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            char[] r6 = new char[r1]
            r11 = 32
            r6[r2] = r11
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            java.util.List r11 = kotlin.text.StringsKt.split$default(r5, r6, r7, r8, r9, r10)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r11 = r11.iterator()
        L4a:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L6a
            java.lang.Object r2 = r11.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Character r2 = kotlin.text.StringsKt.firstOrNull(r2)
            if (r2 == 0) goto L63
            java.lang.String r2 = r2.toString()
            goto L64
        L63:
            r2 = r0
        L64:
            if (r2 == 0) goto L4a
            r1.add(r2)
            goto L4a
        L6a:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r11 = r1.iterator()
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto La1
            java.lang.Object r0 = r11.next()
        L7c:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L9a
            java.lang.Object r1 = r11.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            goto L7c
        L9a:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L9f
            goto La9
        L9f:
            r4 = r0
            goto La9
        La1:
            java.lang.UnsupportedOperationException r11 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "Empty collection can't be reduced."
            r11.<init>(r0)
            throw r11
        La9:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.app.ProfileViewModel.m448initials$lambda3(com.livpure.safedrink.login.data.models.User):java.lang.String");
    }
}
