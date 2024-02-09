package com.livpure.safedrink.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.actions.SearchIntents;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UriToIntentMapper.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/livpure/safedrink/utils/UriToIntentMapper;", "", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "intentHelper", "Lcom/livpure/safedrink/utils/IntentHelper;", "(Landroid/content/Context;Lcom/livpure/safedrink/utils/IntentHelper;)V", "mContext", "mIntents", "dispatchIntent", "", "intent", "Landroid/content/Intent;", "mapAppLink", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "mapWebLink", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UriToIntentMapper {
    private final Context mContext;
    private final IntentHelper mIntents;

    public UriToIntentMapper(Context context, IntentHelper intentHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intentHelper, "intentHelper");
        this.mContext = context;
        this.mIntents = intentHelper;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0025, code lost:
        if (r0 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dispatchIntent(android.content.Intent r7) {
        /*
            r6 = this;
            java.lang.String r0 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            android.net.Uri r7 = r7.getData()
            if (r7 == 0) goto L7c
            java.lang.String r0 = r7.getScheme()
            java.lang.String r1 = "this as java.lang.String).toLowerCase(locale)"
            java.lang.String r2 = "getDefault()"
            java.lang.String r3 = ""
            if (r0 == 0) goto L27
            java.util.Locale r4 = java.util.Locale.getDefault()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            java.lang.String r0 = r0.toLowerCase(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            if (r0 != 0) goto L28
        L27:
            r0 = r3
        L28:
            java.lang.String r4 = r7.getHost()
            if (r4 == 0) goto L40
            java.util.Locale r5 = java.util.Locale.getDefault()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            java.lang.String r2 = r4.toLowerCase(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            if (r2 != 0) goto L3f
            goto L40
        L3f:
            r3 = r2
        L40:
            java.lang.String r1 = "example-scheme"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r0)
            if (r1 == 0) goto L4d
            android.content.Intent r7 = r6.mapAppLink(r7)
            goto L74
        L4d:
            java.lang.String r1 = "http"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r0)
            if (r1 != 0) goto L5d
            java.lang.String r1 = "https"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r0)
            if (r0 == 0) goto L6e
        L5d:
            java.lang.String r0 = "www.livpuresmart.com"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r0 != 0) goto L70
            java.lang.String r0 = "livpuresmart.com"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r0 == 0) goto L6e
            goto L70
        L6e:
            r7 = 0
            goto L74
        L70:
            android.content.Intent r7 = r6.mapWebLink(r7)
        L74:
            if (r7 == 0) goto L7b
            android.content.Context r0 = r6.mContext
            r0.startActivity(r7)
        L7b:
            return
        L7c:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Uri cannot be null"
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.utils.UriToIntentMapper.dispatchIntent(android.content.Intent):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0018, code lost:
        if (r0 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.content.Intent mapAppLink(android.net.Uri r4) {
        /*
            r3 = this;
            java.lang.String r0 = r4.getHost()
            if (r0 == 0) goto L1a
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r2 = "getDefault()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r0 = r0.toLowerCase(r1)
            java.lang.String r1 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            if (r0 != 0) goto L1c
        L1a:
            java.lang.String r0 = ""
        L1c:
            int r1 = r0.hashCode()
            java.lang.String r2 = "query"
            switch(r1) {
                case 204631858: goto L64;
                case 204631859: goto L4a;
                case 204631860: goto L26;
                default: goto L25;
            }
        L25:
            goto L76
        L26:
            java.lang.String r1 = "activityc"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2f
            goto L76
        L2f:
            java.lang.String r0 = r4.getQueryParameter(r2)
            java.lang.String r1 = "choice"
            java.lang.String r4 = r4.getQueryParameter(r1)
            if (r4 == 0) goto L40
            int r4 = java.lang.Integer.parseInt(r4)
            goto L41
        L40:
            r4 = 0
        L41:
            com.livpure.safedrink.utils.IntentHelper r1 = r3.mIntents
            android.content.Context r2 = r3.mContext
            android.content.Intent r4 = r1.newCActivityIntent(r2, r0, r4)
            return r4
        L4a:
            java.lang.String r1 = "activityb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L53
            goto L76
        L53:
            java.lang.String r4 = r4.getQueryParameter(r2)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            com.livpure.safedrink.utils.IntentHelper r0 = r3.mIntents
            android.content.Context r1 = r3.mContext
            android.content.Intent r4 = r0.newBActivityIntent(r1, r4)
            return r4
        L64:
            java.lang.String r4 = "activitya"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L6d
            goto L76
        L6d:
            com.livpure.safedrink.utils.IntentHelper r4 = r3.mIntents
            android.content.Context r0 = r3.mContext
            android.content.Intent r4 = r4.newAActivityIntent(r0)
            return r4
        L76:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.utils.UriToIntentMapper.mapAppLink(android.net.Uri):android.content.Intent");
    }

    private final Intent mapWebLink(Uri uri) {
        String valueOf = String.valueOf(uri.getPath());
        if (Intrinsics.areEqual(valueOf, "/a")) {
            return this.mIntents.newAActivityIntent(this.mContext);
        }
        if (Intrinsics.areEqual(valueOf, "/c")) {
            String queryParameter = uri.getQueryParameter(SearchIntents.EXTRA_QUERY);
            String queryParameter2 = uri.getQueryParameter("choice");
            return this.mIntents.newCActivityIntent(this.mContext, queryParameter, queryParameter2 != null ? Integer.parseInt(queryParameter2) : 0);
        }
        return null;
    }
}
