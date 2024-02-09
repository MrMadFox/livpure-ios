package com.livpure.safedrink.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.actions.SearchIntents;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: IntentHelper.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tJ\"\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Lcom/livpure/safedrink/utils/IntentHelper;", "", "()V", "newAActivityIntent", "Landroid/content/Intent;", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "newBActivityIntent", SearchIntents.EXTRA_QUERY, "", "newCActivityIntent", "choice", "", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IntentHelper {
    public static final Companion Companion = new Companion(null);
    private static String EXTRA_B_QUERY = "com.justeat.app.deeplinks.intents.Intents.EXTRA_B_QUERY";
    private static String EXTRA_C_QUERY = "com.justeat.app.deeplinks.intents.Intents.EXTRA_C_QUERY";
    private static String EXTRA_C_CHOICE = "com.justeat.app.deeplinks.intents.Intents.EXTRA_C_CHOICE";

    public final Intent newAActivityIntent(Context context) {
        Intent intent = new Intent(context, Activity.class);
        intent.addFlags(67108864);
        return intent;
    }

    public final Intent newBActivityIntent(Context context, String str) {
        Intent intent = new Intent(context, Activity.class);
        intent.addFlags(67108864);
        intent.putExtra(EXTRA_B_QUERY, str);
        return intent;
    }

    public final Intent newCActivityIntent(Context context, String str, int i) {
        Intent intent = new Intent(context, Activity.class);
        intent.addFlags(67108864);
        intent.putExtra(EXTRA_C_QUERY, str);
        intent.putExtra(EXTRA_C_CHOICE, i);
        return intent;
    }

    /* compiled from: IntentHelper.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/livpure/safedrink/utils/IntentHelper$Companion;", "", "()V", "EXTRA_B_QUERY", "", "getEXTRA_B_QUERY", "()Ljava/lang/String;", "setEXTRA_B_QUERY", "(Ljava/lang/String;)V", "EXTRA_C_CHOICE", "getEXTRA_C_CHOICE", "setEXTRA_C_CHOICE", "EXTRA_C_QUERY", "getEXTRA_C_QUERY", "setEXTRA_C_QUERY", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getEXTRA_B_QUERY() {
            return IntentHelper.EXTRA_B_QUERY;
        }

        public final void setEXTRA_B_QUERY(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            IntentHelper.EXTRA_B_QUERY = str;
        }

        public final String getEXTRA_C_QUERY() {
            return IntentHelper.EXTRA_C_QUERY;
        }

        public final void setEXTRA_C_QUERY(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            IntentHelper.EXTRA_C_QUERY = str;
        }

        public final String getEXTRA_C_CHOICE() {
            return IntentHelper.EXTRA_C_CHOICE;
        }

        public final void setEXTRA_C_CHOICE(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            IntentHelper.EXTRA_C_CHOICE = str;
        }
    }
}
