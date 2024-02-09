package com.livpure.safedrink.utils;

import android.util.Patterns;
import com.amazonaws.util.DateUtils;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: StringUtils.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\u0016\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003*\u00020\u0001\u001a\f\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u0001\u001a\f\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u0001\u001a\f\u0010\u0007\u001a\u00020\u0005*\u0004\u0018\u00010\u0001\u001a\f\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u0001\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\t¨\u0006\u000b"}, d2 = {"fromCamelCaseToSpacedWords", "", "getFirstAndLastName", "Lkotlin/Pair;", "isValidEmail", "", "isValidName", "isValidPhoneNumber", "toDate", "Ljava/util/Date;", "toISOString", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StringUtilsKt {
    public static final String fromCamelCaseToSpacedWords(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        String str2 = "";
        for (char c : charArray) {
            str2 = Character.isUpperCase(c) ? str2 + SafeJsonPrimitive.NULL_CHAR + c : str2 + c;
        }
        return str2;
    }

    public static final boolean isValidEmail(String str) {
        String str2 = str;
        return !(str2 == null || StringsKt.isBlank(str2)) && Patterns.EMAIL_ADDRESS.matcher(str2).matches();
    }

    public static final boolean isValidPhoneNumber(String str) {
        Pattern compile = Pattern.compile("[6-9][0-9]{9}");
        if (str == null) {
            str = "";
        }
        return compile.matcher(str).matches();
    }

    public static final boolean isValidName(String str) {
        String str2 = str;
        return !(str2 == null || StringsKt.isBlank(str2)) && Pattern.compile("^[ A-Za-z]+$").matcher(str2).matches();
    }

    public static final Date toDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String toISOString(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        try {
            return new SimpleDateFormat(DateUtils.ISO8601_DATE_PATTERN).format(date);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Pair<String, String> getFirstAndLastName(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        List mutableList = CollectionsKt.toMutableList((Collection) StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null));
        String str2 = (String) CollectionsKt.firstOrNull((List<? extends Object>) mutableList);
        if (str2 == null) {
            str2 = "";
        }
        mutableList.remove(0);
        return new Pair<>(str2, mutableList.isEmpty() ^ true ? CollectionsKt.joinToString$default(mutableList, " ", null, null, 0, null, null, 62, null) : "");
    }
}
