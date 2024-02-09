package com.livpure.safedrink.segment;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.segment.analytics.Properties;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: AnalyticsUtil.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u001a\"\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u001a\"\u0010\t\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u001a\u001c\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¨\u0006\r"}, d2 = {"putDouble", "Lcom/segment/analytics/Properties;", "key", "", "value", "", "(Lcom/segment/analytics/Properties;Ljava/lang/String;Ljava/lang/Double;)Lcom/segment/analytics/Properties;", "putIfNotNullOrBlank", "Lcom/segment/analytics/Properties$Product;", "putList", "", "", "putString", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AnalyticsUtilKt {
    public static final Properties putString(Properties properties, String key, String str) {
        Intrinsics.checkNotNullParameter(properties, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            properties.putValue(key, "");
        } else {
            properties.putValue(key, (Object) str);
        }
        return properties;
    }

    public static final Properties putDouble(Properties properties, String key, Double d) {
        Intrinsics.checkNotNullParameter(properties, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (d == null) {
            properties.putValue(key, (Object) Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        } else {
            properties.putValue(key, (Object) d);
        }
        return properties;
    }

    public static final Properties putList(Properties properties, String key, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(properties, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        List<? extends Object> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            properties.putValue(key, (Object) CollectionsKt.emptyList());
        } else {
            properties.putValue(key, (Object) list);
        }
        return properties;
    }

    public static final Properties.Product putIfNotNullOrBlank(Properties.Product product, String key, String str) {
        Intrinsics.checkNotNullParameter(product, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            product.putValue(key, "");
        } else {
            product.putValue(key, (Object) str);
        }
        return product;
    }

    public static final Properties.Product putList(Properties.Product product, String key, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(product, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        List<? extends Object> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            product.putValue(key, (Object) CollectionsKt.emptyList());
        } else {
            product.putValue(key, (Object) list);
        }
        return product;
    }
}
