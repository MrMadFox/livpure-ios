package com.livpure.safedrink.common;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.livpure.safedrink.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: UiUtil.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u001a<\u0010\t\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u001a\u001e\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0016\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u001a\n\u0010\u0016\u001a\u00020\u0017*\u00020\u0007\u001a(\u0010\u0018\u001a\u00020\u0011*\u00020\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u001a\f\u0010\u001e\u001a\u00020\u0001*\u0004\u0018\u00010\u0003¨\u0006\u001f"}, d2 = {"getAlertCustomDialogWithHeaderAndMsg", "", "ctx", "Landroid/content/Context;", "containerId", "Landroid/view/ViewGroup;", "header", "", "msg", "getCustomDialogWithHeaderAndMsg", "positiveBtnListener", "Lkotlin/Function0;", "setLightStatusBarColor", "container", "Landroid/view/View;", "Landroidx/fragment/app/FragmentActivity;", "color", "", "setStatusBarColor", "displayError", "Landroid/widget/Spinner;", "errorMessage", "fromHTML", "Landroid/text/Spanned;", "getColorFromAttr", "attrColor", "typedValue", "Landroid/util/TypedValue;", "resolveRefs", "", "hideKeyboard", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UiUtilKt {
    public static final void getCustomDialogWithHeaderAndMsg(Context context, ViewGroup viewGroup, String str, String str2, final Function0<Unit> positiveBtnListener) {
        Intrinsics.checkNotNullParameter(positiveBtnListener, "positiveBtnListener");
        Intrinsics.checkNotNull(context);
        final AlertDialog create = new AlertDialog.Builder(context).create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        boolean z = true;
        create.requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_with_header, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ader, containerId, false)");
        TextView textView = (TextView) inflate.findViewById(R.id.header);
        String str3 = str;
        if (str3 != null && !StringsKt.isBlank(str3)) {
            z = false;
        }
        textView.setVisibility(z ? 8 : 0);
        textView.setText(str3);
        ((TextView) inflate.findViewById(R.id.msg_txt)).setText(str2);
        inflate.findViewById(R.id.ok_btn).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.common.UiUtilKt$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UiUtilKt.m538getCustomDialogWithHeaderAndMsg$lambda1(AlertDialog.this, positiveBtnListener, view);
            }
        });
        create.setView(inflate);
        create.show();
        create.setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCustomDialogWithHeaderAndMsg$lambda-1  reason: not valid java name */
    public static final void m538getCustomDialogWithHeaderAndMsg$lambda1(AlertDialog dialog, Function0 positiveBtnListener, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(positiveBtnListener, "$positiveBtnListener");
        dialog.dismiss();
        positiveBtnListener.invoke();
    }

    public static final void getAlertCustomDialogWithHeaderAndMsg(Context context, ViewGroup viewGroup, String str, String str2) {
        Intrinsics.checkNotNull(context);
        final AlertDialog create = new AlertDialog.Builder(context).create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        boolean z = true;
        create.requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(R.layout.alert_dialog_with_header, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ader, containerId, false)");
        TextView textView = (TextView) inflate.findViewById(R.id.header);
        String str3 = str;
        if (str3 != null && !StringsKt.isBlank(str3)) {
            z = false;
        }
        textView.setVisibility(z ? 8 : 0);
        textView.setText(str3);
        ((TextView) inflate.findViewById(R.id.msg_txt)).setText(str2);
        inflate.findViewById(R.id.ok_btn).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.common.UiUtilKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UiUtilKt.m537getAlertCustomDialogWithHeaderAndMsg$lambda3(AlertDialog.this, view);
            }
        });
        create.setView(inflate);
        create.show();
        create.setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAlertCustomDialogWithHeaderAndMsg$lambda-3  reason: not valid java name */
    public static final void m537getAlertCustomDialogWithHeaderAndMsg$lambda3(AlertDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    public static final Spanned fromHTML(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned fromHtml = Html.fromHtml(str, 0);
            Intrinsics.checkNotNullExpressionValue(fromHtml, "{\n        Html.fromHtml(…M_HTML_MODE_LEGACY)\n    }");
            return fromHtml;
        }
        Spanned fromHtml2 = Html.fromHtml(str);
        Intrinsics.checkNotNullExpressionValue(fromHtml2, "{\n        @Suppress(\"DEP…Html.fromHtml(this)\n    }");
        return fromHtml2;
    }

    public static /* synthetic */ void displayError$default(Spinner spinner, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        displayError(spinner, str);
    }

    public static final void displayError(Spinner spinner, String errorMessage) {
        Intrinsics.checkNotNullParameter(spinner, "<this>");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        TextView textView = (TextView) spinner.getSelectedView();
        if (textView != null) {
            textView.setError(errorMessage);
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "this.context");
            textView.setTextColor(getColorFromAttr$default(context, R.attr.colorError, null, false, 6, null));
        }
    }

    public static final void setStatusBarColor(FragmentActivity ctx, int i) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = ctx.getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
        }
    }

    public static final void setLightStatusBarColor(View container, FragmentActivity ctx, int i) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (Build.VERSION.SDK_INT >= 23) {
            container.setSystemUiVisibility(container.getSystemUiVisibility() | 8192);
            ctx.getWindow().setStatusBarColor(ContextCompat.getColor(ctx, i));
        }
    }

    public static /* synthetic */ int getColorFromAttr$default(Context context, int i, TypedValue typedValue, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            typedValue = new TypedValue();
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return getColorFromAttr(context, i, typedValue, z);
    }

    public static final int getColorFromAttr(Context context, int i, TypedValue typedValue, boolean z) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(typedValue, "typedValue");
        context.getTheme().resolveAttribute(i, typedValue, z);
        return typedValue.data;
    }

    public static final void hideKeyboard(Context context) {
        if (context == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        View currentFocus = ((Activity) context).getCurrentFocus();
        if (currentFocus == null || inputMethodManager == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }
}
