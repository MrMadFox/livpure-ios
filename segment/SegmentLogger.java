package com.livpure.safedrink.segment;

import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.ktx.AnalyticsKt;
import com.google.firebase.analytics.ktx.ParametersBuilder;
import com.google.firebase.ktx.Firebase;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.segment.SegmentIdentityManager;
import com.livpure.safedrink.utils.AppConstants;
import com.moengage.core.Properties;
import com.moengage.core.analytics.MoEAnalyticsHelper;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import com.moengage.richnotification.internal.RichPushConstantsKt;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.segment.analytics.Analytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SegmentLogger.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\u0018\u0000 <2\u00020\u0001:\u0002<=B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u001a\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\r\u001a\u00020\u000eH\u0002J8\u0010\u000f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u0014\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\u0015\u001a\u00020\bH\u0002J$\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\nJ)\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\bJ$\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010$\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\nJ\u0006\u0010&\u001a\u00020\bJ@\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010\n2\b\u0010*\u001a\u0004\u0018\u00010\n2\b\u0010$\u001a\u0004\u0018\u00010\n2\b\u0010+\u001a\u0004\u0018\u00010\n2\b\u0010,\u001a\u0004\u0018\u00010\nJ\u0010\u0010-\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ8\u0010.\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010\n2\b\u0010)\u001a\u0004\u0018\u00010\n2\b\u0010/\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\b\u0002\u00100\u001a\u00020\nJ[\u00101\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010$\u001a\u0004\u0018\u00010\n2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u00102\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u00103JQ\u00104\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010$\u001a\u0004\u0018\u00010\n2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u00105JQ\u00106\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010$\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u00107J[\u00108\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010$\u001a\u0004\u0018\u00010\n2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u00102\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u00103J\u001a\u00109\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010\n2\b\u0010;\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/livpure/safedrink/segment/SegmentLogger;", "", "()V", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "contactUsClick", "", "userName", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "emailUsClick", "initializeProperties", "Lcom/segment/analytics/Properties;", "raiseServiceRequest", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "appointmentdate", SegmentProperties.REMARK, "raiseServiceRequestClick", "raiseServiceRequestHistory", "resetAnalytics", "sendAddedAddressEvent", "city", "state", "pinCode", "sendAddedLitresEvent", "orderId", "amount", "", SegmentProperties.LITRES, "", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;)V", "sendPaymentClickedEvent", "sendPlanSelectedEvent", "tier", "planId", RichPushConstantsKt.PROPERTY_DURATION_KEY, "sendRechargeClickedEvent", "sendSignedInEvent", "type", "email", "planTier", "name", "mobile", "sendSignedOutEvent", "sendSignedUpEvent", "phone", "referralCode", "sendSubscriptionDowngradedEvent", "previousPlanId", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "sendSubscriptionRechargedEvent", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "sendSubscriptionStartedEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;)V", "sendSubscriptionUpgradedEvent", "sendUploadedKYCEvent", "idProof", "addressProof", "Companion", "ContextNotFoundException", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SegmentLogger {
    public static final Companion Companion = new Companion(null);
    private Context context;
    private FirebaseAnalytics firebaseAnalytics;

    public /* synthetic */ SegmentLogger(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SegmentLogger() {
    }

    /* compiled from: SegmentLogger.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/livpure/safedrink/segment/SegmentLogger$Companion;", "", "()V", "with", "Lcom/livpure/safedrink/segment/SegmentLogger;", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SegmentLogger with(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SegmentLogger segmentLogger = new SegmentLogger(null);
            segmentLogger.context = context;
            return segmentLogger;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r6 == null) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void sendSignedInEvent(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            java.lang.String r2 = "username"
            java.lang.String r3 = ""
            java.lang.String r4 = "Signed In"
            java.lang.String r5 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
            if (r23 == 0) goto L17
            kotlin.Pair r6 = com.livpure.safedrink.utils.StringUtilsKt.getFirstAndLastName(r23)     // Catch: java.lang.Exception -> Lf8
            if (r6 != 0) goto L1c
        L17:
            kotlin.Pair r6 = new kotlin.Pair     // Catch: java.lang.Exception -> Lf8
            r6.<init>(r3, r3)     // Catch: java.lang.Exception -> Lf8
        L1c:
            java.lang.Object r3 = r6.getFirst()     // Catch: java.lang.Exception -> Lf8
            r12 = r3
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Exception -> Lf8
            java.lang.Object r3 = r6.getSecond()     // Catch: java.lang.Exception -> Lf8
            r13 = r3
            java.lang.String r13 = (java.lang.String) r13     // Catch: java.lang.Exception -> Lf8
            com.moengage.core.Properties r3 = new com.moengage.core.Properties     // Catch: java.lang.Exception -> Lf8
            r3.<init>()     // Catch: java.lang.Exception -> Lf8
            com.livpure.safedrink.app.LSApplication$Companion r6 = com.livpure.safedrink.app.LSApplication.Companion     // Catch: java.lang.Exception -> Lf8
            com.livpure.safedrink.login.data.models.User r6 = r6.getUser()     // Catch: java.lang.Exception -> Lf8
            r16 = 0
            if (r6 == 0) goto L3e
            java.lang.String r6 = r6.getId()     // Catch: java.lang.Exception -> Lf8
            goto L40
        L3e:
            r6 = r16
        L40:
            com.moengage.core.Properties r3 = r3.addAttribute(r2, r6)     // Catch: java.lang.Exception -> Lf8
            com.moengage.core.Properties r3 = r3.addAttribute(r5, r1)     // Catch: java.lang.Exception -> Lf8
            com.moengage.core.analytics.MoEAnalyticsHelper r6 = com.moengage.core.analytics.MoEAnalyticsHelper.INSTANCE     // Catch: java.lang.Exception -> Lf8
            android.content.Context r7 = r0.context     // Catch: java.lang.Exception -> Lf8
            java.lang.String r17 = "context"
            if (r7 != 0) goto L55
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r17)     // Catch: java.lang.Exception -> Lf8
            r7 = r16
        L55:
            r6.trackEvent(r7, r4, r3)     // Catch: java.lang.Exception -> Lf8
            com.google.firebase.ktx.Firebase r3 = com.google.firebase.ktx.Firebase.INSTANCE     // Catch: java.lang.Exception -> Lf8
            com.google.firebase.analytics.FirebaseAnalytics r3 = com.google.firebase.analytics.ktx.AnalyticsKt.getAnalytics(r3)     // Catch: java.lang.Exception -> Lf8
            r0.firebaseAnalytics = r3     // Catch: java.lang.Exception -> Lf8
            if (r3 != 0) goto L69
            java.lang.String r3 = "firebaseAnalytics"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)     // Catch: java.lang.Exception -> Lf8
            r3 = r16
        L69:
            com.google.firebase.analytics.ktx.ParametersBuilder r6 = new com.google.firebase.analytics.ktx.ParametersBuilder     // Catch: java.lang.Exception -> Lf8
            r6.<init>()     // Catch: java.lang.Exception -> Lf8
            java.lang.String r7 = "item_id"
            com.livpure.safedrink.app.LSApplication$Companion r8 = com.livpure.safedrink.app.LSApplication.Companion     // Catch: java.lang.Exception -> Lf8
            com.livpure.safedrink.login.data.models.User r8 = r8.getUser()     // Catch: java.lang.Exception -> Lf8
            if (r8 == 0) goto L7d
            java.lang.String r8 = r8.getId()     // Catch: java.lang.Exception -> Lf8
            goto L7f
        L7d:
            r8 = r16
        L7f:
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Exception -> Lf8
            r6.param(r7, r8)     // Catch: java.lang.Exception -> Lf8
            java.lang.String r7 = "item_name"
            r6.param(r7, r5)     // Catch: java.lang.Exception -> Lf8
            android.os.Bundle r6 = r6.getBundle()     // Catch: java.lang.Exception -> Lf8
            r3.logEvent(r4, r6)     // Catch: java.lang.Exception -> Lf8
            com.livpure.safedrink.segment.SegmentIdentityManager$Companion r3 = com.livpure.safedrink.segment.SegmentIdentityManager.Companion     // Catch: java.lang.Exception -> Lf8
            android.content.Context r6 = r0.context     // Catch: java.lang.Exception -> Lf8
            if (r6 != 0) goto L9d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r17)     // Catch: java.lang.Exception -> Lf8
            r6 = r16
        L9d:
            com.livpure.safedrink.segment.SegmentIdentityManager r7 = r3.with(r6)     // Catch: java.lang.Exception -> Lf8
            com.livpure.safedrink.app.LSApplication$Companion r3 = com.livpure.safedrink.app.LSApplication.Companion     // Catch: java.lang.Exception -> Lf8
            com.livpure.safedrink.login.data.models.User r3 = r3.getUser()     // Catch: java.lang.Exception -> Lf8
            if (r3 == 0) goto Laf
            java.lang.String r3 = r3.getId()     // Catch: java.lang.Exception -> Lf8
            r8 = r3
            goto Lb1
        Laf:
            r8 = r16
        Lb1:
            com.livpure.safedrink.app.LSApplication$Companion r3 = com.livpure.safedrink.app.LSApplication.Companion     // Catch: java.lang.Exception -> Lf8
            com.livpure.safedrink.login.data.models.User r3 = r3.getUser()     // Catch: java.lang.Exception -> Lf8
            if (r3 == 0) goto Lbf
            java.lang.String r3 = r3.getId()     // Catch: java.lang.Exception -> Lf8
            r9 = r3
            goto Lc1
        Lbf:
            r9 = r16
        Lc1:
            r10 = r20
            r11 = r24
            r14 = r21
            r15 = r22
            r7.identifyExistingUserDetails(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch: java.lang.Exception -> Lf8
            com.segment.analytics.Properties r3 = r18.initializeProperties()     // Catch: java.lang.Exception -> Lf8
            com.livpure.safedrink.app.LSApplication$Companion r6 = com.livpure.safedrink.app.LSApplication.Companion     // Catch: java.lang.Exception -> Lf8
            com.livpure.safedrink.login.data.models.User r6 = r6.getUser()     // Catch: java.lang.Exception -> Lf8
            if (r6 == 0) goto Ldd
            java.lang.String r6 = r6.getId()     // Catch: java.lang.Exception -> Lf8
            goto Ldf
        Ldd:
            r6 = r16
        Ldf:
            com.segment.analytics.Properties r2 = com.livpure.safedrink.segment.AnalyticsUtilKt.putString(r3, r2, r6)     // Catch: java.lang.Exception -> Lf8
            com.segment.analytics.Properties r1 = com.livpure.safedrink.segment.AnalyticsUtilKt.putString(r2, r5, r1)     // Catch: java.lang.Exception -> Lf8
            android.content.Context r2 = r0.context     // Catch: java.lang.Exception -> Lf8
            if (r2 != 0) goto Lef
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r17)     // Catch: java.lang.Exception -> Lf8
            goto Lf1
        Lef:
            r16 = r2
        Lf1:
            com.segment.analytics.Analytics r2 = com.segment.analytics.Analytics.with(r16)     // Catch: java.lang.Exception -> Lf8
            r2.track(r4, r1)     // Catch: java.lang.Exception -> Lf8
        Lf8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.segment.SegmentLogger.sendSignedInEvent(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static /* synthetic */ void sendSignedUpEvent$default(SegmentLogger segmentLogger, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 16) != 0) {
            str5 = "";
        }
        segmentLogger.sendSignedUpEvent(str, str2, str3, str4, str5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0037, code lost:
        if (r14 == null) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void sendSignedUpEvent(java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36) {
        /*
            Method dump skipped, instructions count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.segment.SegmentLogger.sendSignedUpEvent(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final void sendPlanSelectedEvent(String str, String str2, String str3) {
        try {
            Properties addAttribute = new Properties().addAttribute("plan_tier", str).addAttribute("plan_id", str2).addAttribute("plan_duration", str3);
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context context = this.context;
            Context context2 = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            moEAnalyticsHelper.trackEvent(context, SegmentEventNames.PLAN_SELECTED, addAttribute);
            FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
            this.firebaseAnalytics = analytics;
            if (analytics == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                analytics = null;
            }
            ParametersBuilder parametersBuilder = new ParametersBuilder();
            User user = LSApplication.Companion.getUser();
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(user != null ? user.getId() : null));
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_NAME, "username");
            analytics.logEvent(SegmentEventNames.PLAN_SELECTED, parametersBuilder.getBundle());
            com.segment.analytics.Properties putString = AnalyticsUtilKt.putString(AnalyticsUtilKt.putString(AnalyticsUtilKt.putString(initializeProperties(), "plan_tier", str), "plan_id", str2), "plan_duration", str3);
            Context context3 = this.context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
            } else {
                context2 = context3;
            }
            Analytics.with(context2).track(SegmentEventNames.PLAN_SELECTED, putString);
        } catch (Exception unused) {
        }
    }

    public final void sendSubscriptionStartedEvent(String str, String str2, String str3, String str4, String str5, Long l, Integer num) {
        String str6;
        String str7;
        try {
            Properties addAttribute = new Properties().addAttribute("plan_tier", str).addAttribute("plan_id", str2).addAttribute("plan_duration", str3).addAttribute(SegmentProperties.ORDER_ID, str5).addAttribute(SegmentProperties.SUBSCRIPTION_AMOUNT, l).addAttribute(SegmentProperties.PAYMENT_METHOD, SegmentProperties.OLD_PAYMENT_METHOD).addAttribute(SegmentProperties.LITRES, num);
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context context = this.context;
            Context context2 = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            moEAnalyticsHelper.trackEvent(context, SegmentEventNames.SUBSCRIPTION_STARTED, addAttribute);
            FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
            this.firebaseAnalytics = analytics;
            if (analytics == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                analytics = null;
            }
            ParametersBuilder parametersBuilder = new ParametersBuilder();
            User user = LSApplication.Companion.getUser();
            if (user != null) {
                str7 = user.getId();
                str6 = SegmentProperties.PAYMENT_METHOD;
            } else {
                str6 = SegmentProperties.PAYMENT_METHOD;
                str7 = null;
            }
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(str7));
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_NAME, "username");
            analytics.logEvent(SegmentEventNames.SUBSCRIPTION_STARTED, parametersBuilder.getBundle());
            SegmentIdentityManager.Companion companion = SegmentIdentityManager.Companion;
            Context context3 = this.context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context3 = null;
            }
            companion.with(context3).identifyUserPlanPreference(str4, str, str3, str2);
            SegmentIdentityManager.Companion companion2 = SegmentIdentityManager.Companion;
            Context context4 = this.context;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context4 = null;
            }
            companion2.with(context4).identifySubscriptionDate();
            com.segment.analytics.Properties putValue = AnalyticsUtilKt.putString(AnalyticsUtilKt.putString(AnalyticsUtilKt.putString(AnalyticsUtilKt.putString(initializeProperties(), "plan_tier", str), "plan_id", str2), "plan_duration", str3), SegmentProperties.ORDER_ID, str5).putOrderId(str5).putValue(SegmentProperties.SUBSCRIPTION_AMOUNT, (Object) l).putValue(str6, (Object) SegmentProperties.OLD_PAYMENT_METHOD).putValue(SegmentProperties.LITRES, (Object) num);
            Context context5 = this.context;
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
            } else {
                context2 = context5;
            }
            Analytics.with(context2).track(SegmentEventNames.SUBSCRIPTION_STARTED, putValue);
        } catch (Exception unused) {
        }
    }

    public final void sendSubscriptionRechargedEvent(String str, Long l, String str2, String str3, String str4, Integer num, String str5) {
        String str6;
        String str7;
        try {
            Properties addAttribute = new Properties().addAttribute(SegmentProperties.ORDER_ID, str).addAttribute(SegmentProperties.RECHARGE_AMOUNT, l).addAttribute(SegmentProperties.PAYMENT_METHOD, SegmentProperties.OLD_PAYMENT_METHOD).addAttribute("plan_tier", str3).addAttribute("plan_id", str2).addAttribute("plan_duration", str4).addAttribute(SegmentProperties.LITRES, num);
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context context = this.context;
            Context context2 = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            moEAnalyticsHelper.trackEvent(context, SegmentEventNames.SUBSCRIPTION_RECHARGED, addAttribute);
            FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
            this.firebaseAnalytics = analytics;
            if (analytics == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                analytics = null;
            }
            ParametersBuilder parametersBuilder = new ParametersBuilder();
            User user = LSApplication.Companion.getUser();
            if (user != null) {
                str7 = user.getId();
                str6 = "plan_id";
            } else {
                str6 = "plan_id";
                str7 = null;
            }
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(str7));
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_NAME, "username");
            analytics.logEvent(SegmentEventNames.SUBSCRIPTION_RECHARGED, parametersBuilder.getBundle());
            SegmentIdentityManager.Companion companion = SegmentIdentityManager.Companion;
            Context context3 = this.context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context3 = null;
            }
            companion.with(context3).identifyUserPlanPreference(str5, str3, str4, str2);
            SegmentIdentityManager.Companion companion2 = SegmentIdentityManager.Companion;
            Context context4 = this.context;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context4 = null;
            }
            companion2.with(context4).identifyRechargeDate();
            com.segment.analytics.Properties putValue = AnalyticsUtilKt.putString(initializeProperties(), SegmentProperties.ORDER_ID, str).putOrderId(str).putValue(SegmentProperties.RECHARGE_AMOUNT, (Object) l).putValue(SegmentProperties.PAYMENT_METHOD, (Object) SegmentProperties.OLD_PAYMENT_METHOD);
            Intrinsics.checkNotNullExpressionValue(putValue, "initializeProperties()\n …rties.OLD_PAYMENT_METHOD)");
            com.segment.analytics.Properties putValue2 = AnalyticsUtilKt.putString(AnalyticsUtilKt.putString(AnalyticsUtilKt.putString(putValue, "plan_tier", str3), str6, str2), "plan_duration", str4).putValue(SegmentProperties.LITRES, (Object) num);
            Context context5 = this.context;
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
            } else {
                context2 = context5;
            }
            Analytics.with(context2).track(SegmentEventNames.SUBSCRIPTION_RECHARGED, putValue2);
        } catch (Exception unused) {
        }
    }

    public final void sendSubscriptionUpgradedEvent(String str, Long l, String str2, String str3, String str4, Integer num, String str5, String str6) {
        String str7;
        String str8;
        String str9;
        try {
            Properties addAttribute = new Properties().addAttribute(SegmentProperties.ORDER_ID, str).addAttribute(SegmentProperties.RECHARGE_AMOUNT, l).addAttribute(SegmentProperties.PAYMENT_METHOD, SegmentProperties.OLD_PAYMENT_METHOD).addAttribute("plan_tier", str3).addAttribute("plan_id", str2).addAttribute("plan_duration", str4).addAttribute(SegmentProperties.LITRES, num).addAttribute(SegmentProperties.PREVIOUS_PLAN_ID, str6);
            if (str6 != null) {
                str7 = SegmentProperties.LITRES;
                if (AppConstants.PLAN_MAPPING.containsKey(str6)) {
                    addAttribute.addAttribute(SegmentProperties.PREVIOUS_PLAN_TIER, AppConstants.PLAN_MAPPING.get(str6));
                }
            } else {
                str7 = SegmentProperties.LITRES;
            }
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            try {
                Context context = this.context;
                Context context2 = null;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                    context = null;
                }
                moEAnalyticsHelper.trackEvent(context, SegmentEventNames.SUBSCRIPTION_UPGRADED, addAttribute);
                FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
                this.firebaseAnalytics = analytics;
                if (analytics == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                    analytics = null;
                }
                ParametersBuilder parametersBuilder = new ParametersBuilder();
                User user = LSApplication.Companion.getUser();
                if (user != null) {
                    str9 = user.getId();
                    str8 = "plan_id";
                } else {
                    str8 = "plan_id";
                    str9 = null;
                }
                parametersBuilder.param(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(str9));
                parametersBuilder.param(FirebaseAnalytics.Param.ITEM_NAME, "username");
                analytics.logEvent(SegmentEventNames.SUBSCRIPTION_UPGRADED, parametersBuilder.getBundle());
                SegmentIdentityManager.Companion companion = SegmentIdentityManager.Companion;
                Context context3 = this.context;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                    context3 = null;
                }
                companion.with(context3).identifyUserPlanPreference(str5, str3, str4, str2);
                SegmentIdentityManager.Companion companion2 = SegmentIdentityManager.Companion;
                Context context4 = this.context;
                if (context4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                    context4 = null;
                }
                companion2.with(context4).identifyRechargeDate();
                com.segment.analytics.Properties putValue = AnalyticsUtilKt.putString(initializeProperties(), SegmentProperties.ORDER_ID, str).putOrderId(str).putValue(SegmentProperties.RECHARGE_AMOUNT, (Object) l).putValue(SegmentProperties.PAYMENT_METHOD, (Object) SegmentProperties.OLD_PAYMENT_METHOD);
                Intrinsics.checkNotNullExpressionValue(putValue, "initializeProperties()\n …rties.OLD_PAYMENT_METHOD)");
                com.segment.analytics.Properties putValue2 = AnalyticsUtilKt.putString(AnalyticsUtilKt.putString(AnalyticsUtilKt.putString(putValue, "plan_tier", str3), str8, str2), "plan_duration", str4).putValue(str7, (Object) num);
                Intrinsics.checkNotNullExpressionValue(putValue2, "initializeProperties()\n …roperties.LITRES, litres)");
                com.segment.analytics.Properties putString = AnalyticsUtilKt.putString(putValue2, SegmentProperties.PREVIOUS_PLAN_ID, str6);
                if (str6 != null && AppConstants.PLAN_MAPPING.containsKey(str6)) {
                    AnalyticsUtilKt.putString(putString, SegmentProperties.PREVIOUS_PLAN_TIER, AppConstants.PLAN_MAPPING.get(str6));
                }
                Context context5 = this.context;
                if (context5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                } else {
                    context2 = context5;
                }
                Analytics.with(context2).track(SegmentEventNames.SUBSCRIPTION_UPGRADED, putString);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        }
    }

    public final void sendSubscriptionDowngradedEvent(String str, Long l, String str2, String str3, String str4, Integer num, String str5, String str6) {
        String str7;
        String str8;
        String str9;
        try {
            Properties addAttribute = new Properties().addAttribute(SegmentProperties.ORDER_ID, str).addAttribute(SegmentProperties.RECHARGE_AMOUNT, l).addAttribute(SegmentProperties.PAYMENT_METHOD, SegmentProperties.OLD_PAYMENT_METHOD).addAttribute("plan_tier", str3).addAttribute("plan_id", str2).addAttribute("plan_duration", str4).addAttribute(SegmentProperties.LITRES, num).addAttribute(SegmentProperties.PREVIOUS_PLAN_ID, str6);
            if (str6 != null) {
                str7 = SegmentProperties.LITRES;
                if (AppConstants.PLAN_MAPPING.containsKey(str6)) {
                    addAttribute.addAttribute(SegmentProperties.PREVIOUS_PLAN_TIER, AppConstants.PLAN_MAPPING.get(str6));
                }
            } else {
                str7 = SegmentProperties.LITRES;
            }
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            try {
                Context context = this.context;
                Context context2 = null;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                    context = null;
                }
                moEAnalyticsHelper.trackEvent(context, SegmentEventNames.SUBSCRIPTION_DOWNGRADED, addAttribute);
                FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
                this.firebaseAnalytics = analytics;
                if (analytics == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                    analytics = null;
                }
                ParametersBuilder parametersBuilder = new ParametersBuilder();
                User user = LSApplication.Companion.getUser();
                if (user != null) {
                    str9 = user.getId();
                    str8 = "plan_id";
                } else {
                    str8 = "plan_id";
                    str9 = null;
                }
                parametersBuilder.param(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(str9));
                parametersBuilder.param(FirebaseAnalytics.Param.ITEM_NAME, "username");
                analytics.logEvent(SegmentEventNames.SUBSCRIPTION_DOWNGRADED, parametersBuilder.getBundle());
                SegmentIdentityManager.Companion companion = SegmentIdentityManager.Companion;
                Context context3 = this.context;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                    context3 = null;
                }
                companion.with(context3).identifyUserPlanPreference(str5, str3, str4, str2);
                SegmentIdentityManager.Companion companion2 = SegmentIdentityManager.Companion;
                Context context4 = this.context;
                if (context4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                    context4 = null;
                }
                companion2.with(context4).identifyRechargeDate();
                com.segment.analytics.Properties putValue = AnalyticsUtilKt.putString(initializeProperties(), SegmentProperties.ORDER_ID, str).putOrderId(str).putValue(SegmentProperties.RECHARGE_AMOUNT, (Object) l).putValue(SegmentProperties.PAYMENT_METHOD, (Object) SegmentProperties.OLD_PAYMENT_METHOD);
                Intrinsics.checkNotNullExpressionValue(putValue, "initializeProperties()\n …rties.OLD_PAYMENT_METHOD)");
                com.segment.analytics.Properties putValue2 = AnalyticsUtilKt.putString(AnalyticsUtilKt.putString(AnalyticsUtilKt.putString(putValue, "plan_tier", str3), str8, str2), "plan_duration", str4).putValue(str7, (Object) num);
                Intrinsics.checkNotNullExpressionValue(putValue2, "initializeProperties()\n …roperties.LITRES, litres)");
                com.segment.analytics.Properties putString = AnalyticsUtilKt.putString(putValue2, SegmentProperties.PREVIOUS_PLAN_ID, str6);
                if (str6 != null && AppConstants.PLAN_MAPPING.containsKey(str6)) {
                    AnalyticsUtilKt.putString(putString, SegmentProperties.PREVIOUS_PLAN_TIER, AppConstants.PLAN_MAPPING.get(str6));
                }
                Context context5 = this.context;
                if (context5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                } else {
                    context2 = context5;
                }
                Analytics.with(context2).track(SegmentEventNames.SUBSCRIPTION_DOWNGRADED, putString);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        }
    }

    public final void sendAddedLitresEvent(String str, Long l, Integer num) {
        try {
            Properties addAttribute = new Properties().addAttribute(SegmentProperties.ORDER_ID, str).addAttribute(SegmentProperties.RECHARGE_AMOUNT, l).addAttribute(SegmentProperties.PAYMENT_METHOD, SegmentProperties.OLD_PAYMENT_METHOD).addAttribute(SegmentProperties.LITRES, num);
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context context = this.context;
            Context context2 = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            moEAnalyticsHelper.trackEvent(context, SegmentEventNames.ADDED_LITRES, addAttribute);
            FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
            this.firebaseAnalytics = analytics;
            if (analytics == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                analytics = null;
            }
            ParametersBuilder parametersBuilder = new ParametersBuilder();
            User user = LSApplication.Companion.getUser();
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(user != null ? user.getId() : null));
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_NAME, "username");
            analytics.logEvent(SegmentEventNames.ADDED_LITRES, parametersBuilder.getBundle());
            com.segment.analytics.Properties putValue = AnalyticsUtilKt.putString(initializeProperties(), SegmentProperties.ORDER_ID, str).putOrderId(str).putValue(SegmentProperties.RECHARGE_AMOUNT, (Object) l).putValue(SegmentProperties.PAYMENT_METHOD, (Object) SegmentProperties.OLD_PAYMENT_METHOD).putValue(SegmentProperties.LITRES, (Object) num);
            Context context3 = this.context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
            } else {
                context2 = context3;
            }
            Analytics.with(context2).track(SegmentEventNames.ADDED_LITRES, putValue);
        } catch (Exception unused) {
        }
    }

    public final void sendPaymentClickedEvent() {
        try {
            Properties addAttribute = new Properties().addAttribute(SegmentProperties.PAYMENT_METHOD, SegmentProperties.OLD_PAYMENT_METHOD);
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context context = this.context;
            Context context2 = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            moEAnalyticsHelper.trackEvent(context, SegmentEventNames.CLICKED_PAYMENT, addAttribute);
            FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
            this.firebaseAnalytics = analytics;
            if (analytics == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                analytics = null;
            }
            ParametersBuilder parametersBuilder = new ParametersBuilder();
            User user = LSApplication.Companion.getUser();
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(user != null ? user.getId() : null));
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_NAME, "username");
            analytics.logEvent(SegmentEventNames.CLICKED_PAYMENT, parametersBuilder.getBundle());
            com.segment.analytics.Properties putString = AnalyticsUtilKt.putString(initializeProperties(), SegmentProperties.PAYMENT_METHOD, SegmentProperties.OLD_PAYMENT_METHOD);
            Context context3 = this.context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
            } else {
                context2 = context3;
            }
            Analytics.with(context2).track(SegmentEventNames.CLICKED_PAYMENT, putString);
        } catch (Exception unused) {
        }
    }

    public final void sendRechargeClickedEvent() {
        try {
            Properties addAttribute = new Properties().addAttribute(SegmentProperties.PAYMENT_METHOD, SegmentProperties.OLD_PAYMENT_METHOD);
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context context = this.context;
            Context context2 = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            moEAnalyticsHelper.trackEvent(context, SegmentEventNames.CLICKED_RECHARGE, addAttribute);
            FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
            this.firebaseAnalytics = analytics;
            if (analytics == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                analytics = null;
            }
            ParametersBuilder parametersBuilder = new ParametersBuilder();
            User user = LSApplication.Companion.getUser();
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(user != null ? user.getId() : null));
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_NAME, "username");
            analytics.logEvent(SegmentEventNames.CLICKED_RECHARGE, parametersBuilder.getBundle());
            com.segment.analytics.Properties putString = AnalyticsUtilKt.putString(initializeProperties(), SegmentProperties.PAYMENT_METHOD, SegmentProperties.OLD_PAYMENT_METHOD);
            Context context3 = this.context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
            } else {
                context2 = context3;
            }
            Analytics.with(context2).track(SegmentEventNames.CLICKED_RECHARGE, putString);
        } catch (Exception unused) {
        }
    }

    public final void sendUploadedKYCEvent(String str, String str2) {
        try {
            Properties addAttribute = new Properties().addAttribute("id_proof", str).addAttribute("address_proof", str2);
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context context = this.context;
            Context context2 = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            moEAnalyticsHelper.trackEvent(context, SegmentEventNames.UPLOADED_KYC, addAttribute);
            FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
            this.firebaseAnalytics = analytics;
            if (analytics == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                analytics = null;
            }
            ParametersBuilder parametersBuilder = new ParametersBuilder();
            User user = LSApplication.Companion.getUser();
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(user != null ? user.getId() : null));
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_NAME, "username");
            analytics.logEvent(SegmentEventNames.UPLOADED_KYC, parametersBuilder.getBundle());
            SegmentIdentityManager.Companion companion = SegmentIdentityManager.Companion;
            Context context3 = this.context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context3 = null;
            }
            SegmentIdentityManager with = companion.with(context3);
            User user2 = LSApplication.Companion.getUser();
            with.identifyUserKycUploadStatus(user2 != null ? user2.getId() : null, true);
            SegmentIdentityManager.Companion companion2 = SegmentIdentityManager.Companion;
            Context context4 = this.context;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context4 = null;
            }
            companion2.with(context4).identifyProofs(str, str2);
            com.segment.analytics.Properties putString = AnalyticsUtilKt.putString(AnalyticsUtilKt.putString(initializeProperties(), "id_proof", str), "address_proof", str2);
            Context context5 = this.context;
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
            } else {
                context2 = context5;
            }
            Analytics.with(context2).track(SegmentEventNames.UPLOADED_KYC, putString);
        } catch (Exception unused) {
        }
    }

    public final void sendAddedAddressEvent(String str, String str2, String str3) {
        try {
            Properties addAttribute = new Properties().addAttribute("city", str).addAttribute("state", str2).addAttribute("pincode", str3);
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context context = this.context;
            Context context2 = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            moEAnalyticsHelper.trackEvent(context, SegmentEventNames.ADDED_ADDRESS, addAttribute);
            FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
            this.firebaseAnalytics = analytics;
            if (analytics == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                analytics = null;
            }
            ParametersBuilder parametersBuilder = new ParametersBuilder();
            User user = LSApplication.Companion.getUser();
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(user != null ? user.getId() : null));
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_NAME, "username");
            analytics.logEvent(SegmentEventNames.ADDED_ADDRESS, parametersBuilder.getBundle());
            SegmentIdentityManager.Companion companion = SegmentIdentityManager.Companion;
            Context context3 = this.context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context3 = null;
            }
            SegmentIdentityManager with = companion.with(context3);
            User user2 = LSApplication.Companion.getUser();
            with.identifyAddress(user2 != null ? user2.getId() : null, str2, str, str3);
            com.segment.analytics.Properties putString = AnalyticsUtilKt.putString(AnalyticsUtilKt.putString(AnalyticsUtilKt.putString(initializeProperties(), "city", str), "state", str2), "pincode", str3);
            Context context4 = this.context;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
            } else {
                context2 = context4;
            }
            Analytics.with(context2).track(SegmentEventNames.ADDED_ADDRESS, putString);
        } catch (Exception unused) {
        }
    }

    public final void sendSignedOutEvent(String str) {
        try {
            Properties addAttribute = new Properties().addAttribute("username", str);
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context context = this.context;
            Context context2 = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            moEAnalyticsHelper.trackEvent(context, SegmentEventNames.SIGNED_OUT, addAttribute);
            FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
            this.firebaseAnalytics = analytics;
            if (analytics == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                analytics = null;
            }
            ParametersBuilder parametersBuilder = new ParametersBuilder();
            User user = LSApplication.Companion.getUser();
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(user != null ? user.getId() : null));
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_NAME, "username");
            analytics.logEvent(SegmentEventNames.SIGNED_OUT, parametersBuilder.getBundle());
            com.segment.analytics.Properties putString = AnalyticsUtilKt.putString(initializeProperties(), "username", str);
            Context context3 = this.context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
            } else {
                context2 = context3;
            }
            Analytics.with(context2).track(SegmentEventNames.SIGNED_OUT, putString);
            resetAnalytics();
        } catch (Exception unused) {
        }
    }

    public final void raiseServiceRequestClick(String str, String str2) {
        try {
            Properties addAttribute = new Properties().addAttribute("username", str).addAttribute(SegmentProperties.USER_ID, str2);
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            moEAnalyticsHelper.trackEvent(context, SegmentEventNames.RAISESERVICEREQUESTCLICK, addAttribute);
            FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
            this.firebaseAnalytics = analytics;
            if (analytics == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                analytics = null;
            }
            ParametersBuilder parametersBuilder = new ParametersBuilder();
            User user = LSApplication.Companion.getUser();
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(user != null ? user.getId() : null));
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_NAME, "username");
            analytics.logEvent(SegmentEventNames.RAISESERVICEREQUESTCLICK, parametersBuilder.getBundle());
        } catch (Exception unused) {
        }
    }

    public final void raiseServiceRequest(String str, String str2, String str3, String str4, String str5) {
        try {
            Properties addAttribute = new Properties().addAttribute("username", str).addAttribute(SegmentProperties.USER_ID, str2).addAttribute(SegmentProperties.SERVICEREASON, str3).addAttribute(SegmentProperties.APPOINTMENTDATE, str4).addAttribute(SegmentProperties.REMARK, str5);
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            moEAnalyticsHelper.trackEvent(context, SegmentEventNames.RAISESERVICEREQUEST, addAttribute);
            FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
            this.firebaseAnalytics = analytics;
            if (analytics == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                analytics = null;
            }
            ParametersBuilder parametersBuilder = new ParametersBuilder();
            User user = LSApplication.Companion.getUser();
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(user != null ? user.getId() : null));
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_NAME, "username");
            analytics.logEvent(SegmentEventNames.RAISESERVICEREQUEST, parametersBuilder.getBundle());
        } catch (Exception unused) {
        }
    }

    public final void raiseServiceRequestHistory(String str, String str2) {
        try {
            Properties addAttribute = new Properties().addAttribute("username", str).addAttribute(SegmentProperties.USER_ID, str2);
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            moEAnalyticsHelper.trackEvent(context, SegmentEventNames.RAISESERVICEREQUESTHISTORY, addAttribute);
            FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
            this.firebaseAnalytics = analytics;
            if (analytics == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                analytics = null;
            }
            ParametersBuilder parametersBuilder = new ParametersBuilder();
            User user = LSApplication.Companion.getUser();
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(user != null ? user.getId() : null));
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_NAME, "username");
            analytics.logEvent(SegmentEventNames.RAISESERVICEREQUESTHISTORY, parametersBuilder.getBundle());
        } catch (Exception unused) {
        }
    }

    public final void emailUsClick(String str, String str2) {
        try {
            Properties addAttribute = new Properties().addAttribute("username", str).addAttribute(SegmentProperties.USER_ID, str2);
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            moEAnalyticsHelper.trackEvent(context, SegmentEventNames.EMAILUS, addAttribute);
            FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
            this.firebaseAnalytics = analytics;
            if (analytics == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                analytics = null;
            }
            ParametersBuilder parametersBuilder = new ParametersBuilder();
            User user = LSApplication.Companion.getUser();
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(user != null ? user.getId() : null));
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_NAME, "username");
            analytics.logEvent(SegmentEventNames.EMAILUS, parametersBuilder.getBundle());
        } catch (Exception unused) {
        }
    }

    public final void contactUsClick(String str, String str2) {
        try {
            Properties addAttribute = new Properties().addAttribute("username", str).addAttribute(SegmentProperties.USER_ID, str2);
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            moEAnalyticsHelper.trackEvent(context, SegmentEventNames.CONTACTUS, addAttribute);
            FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
            this.firebaseAnalytics = analytics;
            if (analytics == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                analytics = null;
            }
            ParametersBuilder parametersBuilder = new ParametersBuilder();
            User user = LSApplication.Companion.getUser();
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(user != null ? user.getId() : null));
            parametersBuilder.param(FirebaseAnalytics.Param.ITEM_NAME, "username");
            analytics.logEvent(SegmentEventNames.CONTACTUS, parametersBuilder.getBundle());
        } catch (Exception unused) {
        }
    }

    private final void resetAnalytics() {
        try {
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            Analytics.with(context).reset();
        } catch (Exception unused) {
        }
    }

    private final com.segment.analytics.Properties initializeProperties() throws ContextNotFoundException {
        if (this.context == null) {
            throw new ContextNotFoundException(this, "Context not found for sending Analytics Event. Use SegmentLogger.with(context).sendEvent(...)");
        }
        return new com.segment.analytics.Properties();
    }

    /* compiled from: SegmentLogger.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/livpure/safedrink/segment/SegmentLogger$ContextNotFoundException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Lcom/livpure/safedrink/segment/SegmentLogger;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ContextNotFoundException extends Exception {
        final /* synthetic */ SegmentLogger this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContextNotFoundException(SegmentLogger segmentLogger, String message) {
            super(message);
            Intrinsics.checkNotNullParameter(message, "message");
            this.this$0 = segmentLogger;
        }
    }
}
