package com.livpure.safedrink.utils;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.livpure.safedrink.R;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AnimProgressBar.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/livpure/safedrink/utils/AnimProgressBar;", "", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "dialog", "Landroidx/appcompat/app/AlertDialog;", MoEPushConstants.ACTION_DISMISS, "", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "show", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AnimProgressBar {
    private final AlertDialog dialog;

    public AnimProgressBar(Context context) {
        Window window;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setPadding(30, 30, 30, 30);
        linearLayout.setGravity(17);
        Intrinsics.checkNotNull(context);
        linearLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.transparent));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.addView(new ProgressBar(context));
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(linearLayout);
        AlertDialog create = builder.create();
        this.dialog = create;
        create.setCanceledOnTouchOutside(false);
        if (create.isShowing() || (window = create.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(R.color.transparent);
        window.clearFlags(2);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        Window window2 = create.getWindow();
        Intrinsics.checkNotNull(window2);
        layoutParams2.copyFrom(window2.getAttributes());
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        Window window3 = create.getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setAttributes(layoutParams2);
    }

    public final void show() {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
    }

    public final void hide() {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.hide();
        }
    }

    public final void dismiss() {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }
}
