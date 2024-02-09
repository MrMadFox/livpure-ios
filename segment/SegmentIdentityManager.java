package com.livpure.safedrink.segment;

import android.content.Context;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.utils.StringUtilsKt;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import com.moengage.richnotification.internal.RichPushConstantsKt;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.segment.analytics.Analytics;
import com.segment.analytics.Traits;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: SegmentIdentityManager.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bJV\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\bJ\u001f\u0010\u0014\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017JL\u0010\u0018\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u001a\u001a\u00020\u0006J\u001a\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u001e\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u0006J\u001f\u0010 \u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J.\u0010\"\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010$\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\bJ\b\u0010%\u001a\u00020&H\u0002J\u0006\u0010'\u001a\u00020\u0006J\u001e\u0010(\u001a\u00020&*\u00020&2\u0006\u0010)\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0002J\u001e\u0010+\u001a\u00020&*\u00020&2\u0006\u0010)\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/livpure/safedrink/segment/SegmentIdentityManager;", "", "()V", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "identifyAddress", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "state", "city", "pinCode", "identifyExistingUserDetails", "userName", "email", "mobile", SegmentProperties.FIRST_NAME, SegmentProperties.LAST_NAME, "planTier", "planId", "identifyIfUserHasPaid", "hasPaid", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "identifyNewUserDetails", "referralCode", "identifyPlanValidity", "identifyProofs", "idProof", "addressProof", "identifyRechargeDate", "identifySubscriptionDate", "identifyUserKycUploadStatus", "uploadedKyc", "identifyUserPlanPreference", "tier", RichPushConstantsKt.PROPERTY_DURATION_KEY, "initTraits", "Lcom/segment/analytics/Traits;", "refreshUserDetails", "putIfNotNull", "key", "value", "putIfNotNullOrBlank", "Companion", "ContextNotFoundException", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SegmentIdentityManager {
    public static final Companion Companion = new Companion(null);
    private Context context;

    public /* synthetic */ SegmentIdentityManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SegmentIdentityManager() {
    }

    /* compiled from: SegmentIdentityManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/livpure/safedrink/segment/SegmentIdentityManager$Companion;", "", "()V", "with", "Lcom/livpure/safedrink/segment/SegmentIdentityManager;", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SegmentIdentityManager with(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SegmentIdentityManager segmentIdentityManager = new SegmentIdentityManager(null);
            segmentIdentityManager.context = context;
            return segmentIdentityManager;
        }
    }

    public final void identifyNewUserDetails(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        try {
            Traits putValue = initTraits().putValue("username", (Object) str).putValue("user_id", (Object) str2);
            Intrinsics.checkNotNullExpressionValue(putValue, "initTraits()\n           …ntTraits.USER_ID, userId)");
            Traits putValue2 = putIfNotNullOrBlank(putIfNotNullOrBlank(putValue, SegmentTraits.FIRST_NAME, str3), SegmentTraits.LAST_NAME, str4).putValue("email", (Object) str5);
            Intrinsics.checkNotNullExpressionValue(putValue2, "initTraits()\n           …gmentTraits.EMAIL, email)");
            Traits putValue3 = putIfNotNullOrBlank(putIfNotNullOrBlank(putIfNotNullOrBlank(putValue2, "mobile", str6), "phone", str6), "referral_code", str7).putValue(SegmentTraits.SIGNUP_SOURCE, "android").putValue(SegmentTraits.CREATED_AT, (Object) StringUtilsKt.toISOString(new Date()));
            if (str2 != null) {
                Context context = this.context;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                    context = null;
                }
                Analytics.with(context).identify(str2, putValue3, null);
            }
        } catch (Exception unused) {
        }
    }

    public final void identifyExistingUserDetails(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        try {
            Traits putValue = initTraits().putValue("username", (Object) str).putValue("user_id", (Object) str2).putValue("email", (Object) str3);
            Intrinsics.checkNotNullExpressionValue(putValue, "initTraits()\n           …gmentTraits.EMAIL, email)");
            Traits putIfNotNullOrBlank = putIfNotNullOrBlank(putIfNotNullOrBlank(putIfNotNullOrBlank(putIfNotNullOrBlank(putIfNotNullOrBlank(putIfNotNullOrBlank(putValue, "mobile", str4), "phone", str4), "plan_id", str8), "plan_tier", str7), SegmentTraits.FIRST_NAME, str5), SegmentTraits.LAST_NAME, str6);
            if (str2 != null) {
                Context context = this.context;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                    context = null;
                }
                Analytics.with(context).identify(str2, putIfNotNullOrBlank, null);
            }
        } catch (Exception unused) {
        }
    }

    public final void refreshUserDetails() {
        String id;
        String name;
        try {
            User user = LSApplication.Companion.getUser();
            Pair<String, String> firstAndLastName = (user == null || (name = user.getName()) == null) ? null : StringUtilsKt.getFirstAndLastName(name);
            Traits putIfNotNull = putIfNotNull(putIfNotNull(putIfNotNullOrBlank(putIfNotNullOrBlank(putIfNotNullOrBlank(putIfNotNullOrBlank(putIfNotNullOrBlank(putIfNotNullOrBlank(putIfNotNullOrBlank(putIfNotNullOrBlank(putIfNotNullOrBlank(putIfNotNullOrBlank(putIfNotNullOrBlank(putIfNotNullOrBlank(initTraits(), "username", user != null ? user.getId() : null), "user_id", user != null ? user.getId() : null), "email", user != null ? user.getEmail() : null), "mobile", user != null ? user.getMobile() : null), "phone", user != null ? user.getMobile() : null), "plan_id", user != null ? user.getPlanId() : null), "plan_tier", user != null ? user.getPlanName() : null), SegmentTraits.FIRST_NAME, firstAndLastName != null ? firstAndLastName.getFirst() : null), SegmentTraits.LAST_NAME, firstAndLastName != null ? firstAndLastName.getSecond() : null), "state", user != null ? user.getState() : null), "city", user != null ? user.getCity() : null), "pincode", user != null ? user.getPinCode() : null), SegmentTraits.HAS_PAID, user != null ? Boolean.valueOf(user.getPaymentCompleted()) : null), SegmentTraits.UPLOADED_KYC, user != null ? Boolean.valueOf(user.getKycCompleted()) : null);
            if (user == null || (id = user.getId()) == null) {
                return;
            }
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            Analytics.with(context).identify(id, putIfNotNull, null);
        } catch (Exception unused) {
        }
    }

    public final void identifyAddress(String str, String str2, String str3, String str4) {
        try {
            Traits putIfNotNullOrBlank = putIfNotNullOrBlank(putIfNotNullOrBlank(putIfNotNullOrBlank(initTraits(), "state", str2), "city", str3), "pincode", str4);
            if (str != null) {
                Context context = this.context;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                    context = null;
                }
                Analytics.with(context).identify(str, putIfNotNullOrBlank, null);
            }
        } catch (Exception unused) {
        }
    }

    public final void identifyUserPlanPreference(String str, String str2, String str3, String str4) {
        try {
            Traits putValue = initTraits().putValue("plan_id", (Object) str4).putValue("plan_tier", (Object) str2).putValue("plan_duration", (Object) str3);
            if (str != null) {
                Context context = this.context;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                    context = null;
                }
                Analytics.with(context).identify(str, putValue, null);
            }
        } catch (Exception unused) {
        }
    }

    public final void identifyIfUserHasPaid(String str, Boolean bool) {
        try {
            Traits putValue = initTraits().putValue(SegmentTraits.HAS_PAID, (Object) bool);
            if (str != null) {
                Context context = this.context;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                    context = null;
                }
                Analytics.with(context).identify(str, putValue, null);
            }
        } catch (Exception unused) {
        }
    }

    public final void identifyUserKycUploadStatus(String str, Boolean bool) {
        try {
            Traits putValue = initTraits().putValue(SegmentTraits.UPLOADED_KYC, (Object) bool);
            if (str != null) {
                Context context = this.context;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                    context = null;
                }
                Analytics.with(context).identify(str, putValue, null);
            }
        } catch (Exception unused) {
        }
    }

    public final void identifyProofs(String str, String str2) {
        String id;
        try {
            Traits putIfNotNullOrBlank = putIfNotNullOrBlank(putIfNotNullOrBlank(initTraits(), "id_proof", str), "address_proof", str2);
            User user = LSApplication.Companion.getUser();
            if (user == null || (id = user.getId()) == null) {
                return;
            }
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            Analytics.with(context).identify(id, putIfNotNullOrBlank, null);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020 A[Catch: Exception -> 0x0056, TryCatch #0 {Exception -> 0x0056, blocks: (B:2:0x0000, B:4:0x0009, B:6:0x000f, B:8:0x0014, B:14:0x0020, B:16:0x0026, B:18:0x002c, B:20:0x0038, B:22:0x003c, B:23:0x0042), top: B:26:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void identifyPlanValidity() {
        /*
            r4 = this;
            com.livpure.safedrink.app.LSApplication$Companion r0 = com.livpure.safedrink.app.LSApplication.Companion     // Catch: java.lang.Exception -> L56
            com.livpure.safedrink.login.data.models.User r0 = r0.getUser()     // Catch: java.lang.Exception -> L56
            r1 = 0
            if (r0 == 0) goto Le
            java.lang.String r0 = r0.getPlanValidTillDate()     // Catch: java.lang.Exception -> L56
            goto Lf
        Le:
            r0 = r1
        Lf:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Exception -> L56
            if (r2 == 0) goto L1d
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)     // Catch: java.lang.Exception -> L56
            if (r2 == 0) goto L1b
            goto L1d
        L1b:
            r2 = 0
            goto L1e
        L1d:
            r2 = 1
        L1e:
            if (r2 != 0) goto L56
            java.util.Date r0 = com.livpure.safedrink.utils.StringUtilsKt.toDate(r0)     // Catch: java.lang.Exception -> L56
            if (r0 == 0) goto L2b
            java.lang.String r0 = com.livpure.safedrink.utils.StringUtilsKt.toISOString(r0)     // Catch: java.lang.Exception -> L56
            goto L2c
        L2b:
            r0 = r1
        L2c:
            com.segment.analytics.Traits r2 = r4.initTraits()     // Catch: java.lang.Exception -> L56
            java.lang.String r3 = "recharge_due_date"
            com.segment.analytics.Traits r2 = r4.putIfNotNullOrBlank(r2, r3, r0)     // Catch: java.lang.Exception -> L56
            if (r0 == 0) goto L56
            android.content.Context r0 = r4.context     // Catch: java.lang.Exception -> L56
            if (r0 != 0) goto L42
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L56
            r0 = r1
        L42:
            com.segment.analytics.Analytics r0 = com.segment.analytics.Analytics.with(r0)     // Catch: java.lang.Exception -> L56
            com.livpure.safedrink.app.LSApplication$Companion r3 = com.livpure.safedrink.app.LSApplication.Companion     // Catch: java.lang.Exception -> L56
            com.livpure.safedrink.login.data.models.User r3 = r3.getUser()     // Catch: java.lang.Exception -> L56
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch: java.lang.Exception -> L56
            java.lang.String r3 = r3.getId()     // Catch: java.lang.Exception -> L56
            r0.identify(r3, r2, r1)     // Catch: java.lang.Exception -> L56
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.segment.SegmentIdentityManager.identifyPlanValidity():void");
    }

    public final void identifySubscriptionDate() {
        String id;
        try {
            Traits putIfNotNullOrBlank = putIfNotNullOrBlank(initTraits(), SegmentTraits.SUBSCRIBED_ON, StringUtilsKt.toISOString(new Date()));
            User user = LSApplication.Companion.getUser();
            if (user == null || (id = user.getId()) == null) {
                return;
            }
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            Analytics.with(context).identify(id, putIfNotNullOrBlank, null);
        } catch (Exception unused) {
        }
    }

    public final void identifyRechargeDate() {
        String id;
        try {
            Traits putIfNotNullOrBlank = putIfNotNullOrBlank(initTraits(), SegmentTraits.LAST_RECHARGE, StringUtilsKt.toISOString(new Date()));
            User user = LSApplication.Companion.getUser();
            if (user == null || (id = user.getId()) == null) {
                return;
            }
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT);
                context = null;
            }
            Analytics.with(context).identify(id, putIfNotNullOrBlank, null);
        } catch (Exception unused) {
        }
    }

    private final Traits initTraits() throws ContextNotFoundException {
        if (this.context == null) {
            throw new ContextNotFoundException(this, "Context not found for sending Analytics Event. Use SegmentIdentityManager.with(context).identifyX(...)");
        }
        return new Traits();
    }

    private final Traits putIfNotNullOrBlank(Traits traits, String str, String str2) {
        String str3 = str2;
        if (!(str3 == null || StringsKt.isBlank(str3))) {
            traits.putValue(str, (Object) str2);
        }
        return traits;
    }

    private final Traits putIfNotNull(Traits traits, String str, Object obj) {
        if (obj != null) {
            traits.putValue(str, obj);
        }
        return traits;
    }

    /* compiled from: SegmentIdentityManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/livpure/safedrink/segment/SegmentIdentityManager$ContextNotFoundException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Lcom/livpure/safedrink/segment/SegmentIdentityManager;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ContextNotFoundException extends Exception {
        final /* synthetic */ SegmentIdentityManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContextNotFoundException(SegmentIdentityManager segmentIdentityManager, String message) {
            super(message);
            Intrinsics.checkNotNullParameter(message, "message");
            this.this$0 = segmentIdentityManager;
        }
    }
}
