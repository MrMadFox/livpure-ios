package com.livpure.safedrink.utils;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.moengage.richnotification.internal.RichPushConstantsKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
/* compiled from: BindingAdapterView.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0015H\u0007J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0007J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0015H\u0007J$\u0010&\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\r2\b\u0010(\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\bH\u0007J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\bH\u0007¨\u0006+"}, d2 = {"Lcom/livpure/safedrink/utils/BindingAdapterView;", "", "()V", "goneUnless", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "visible", "", "setApplyDate", "textView", "Landroid/widget/TextView;", "dateTime", "", "setApplyTime", "setDeviceCategoryIcon", "image", "Landroid/widget/ImageView;", "url", "setDrawableImage", "drawableImage", "", "setDuration", RichPushConstantsKt.PROPERTY_DURATION_KEY, "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setImageResource", "imageView", "resource", "setImageUri", "imageUri", "Landroid/net/Uri;", "setLayoutSize", "size", "", "setMargin", "value", "setRejectReason", "verifyStatus", "reason", "setVisibility", "strikeThrough", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BindingAdapterView {
    public static final BindingAdapterView INSTANCE = new BindingAdapterView();

    private BindingAdapterView() {
    }

    @BindingAdapter({"app:drawableImage"})
    public final void setDrawableImage(ImageView image, int i) {
        Intrinsics.checkNotNullParameter(image, "image");
        image.setImageResource(i);
    }

    @BindingAdapter({"bind:verifyStatus", "bind:reason"})
    public final void setRejectReason(TextView textView, String str, String str2) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode == -543852386) {
                if (str.equals("Rejected")) {
                    textView.setText(str2);
                    return;
                }
                return;
            }
            if (hashCode != 982065527) {
                if (hashCode != 1249888983 || !str.equals("Approved")) {
                    return;
                }
            } else if (!str.equals("Pending")) {
                return;
            }
            textView.setText("");
        }
    }

    @BindingAdapter({"app:matrgin"})
    @JvmStatic
    public static final void setMargin(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.leftMargin = i;
        marginLayoutParams.rightMargin = i;
        view.setLayoutParams(marginLayoutParams);
    }

    @BindingAdapter({"app:deviceCategoryIcon"})
    @JvmStatic
    public static final void setDeviceCategoryIcon(ImageView imageView, String str) {
        CustomImageView.INSTANCE.imageViewURL(str, imageView, R.drawable.snowflake_variant);
    }

    @BindingAdapter({"app:dateText"})
    @JvmStatic
    public static final void setApplyDate(TextView textView, String dateTime) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(dateTime, "dateTime");
        Object[] array = new Regex(" ").split(dateTime, 0).toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        textView.setText(((String[]) array)[0]);
    }

    @BindingAdapter({"app:timeText"})
    public final void setApplyTime(TextView textView, String dateTime) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(dateTime, "dateTime");
        Object[] array = new Regex(" ").split(dateTime, 0).toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        textView.setText(((String[]) array)[1]);
    }

    @BindingAdapter({"app:visibility"})
    public final void setVisibility(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVisibility(z ? 0 : 8);
    }

    @BindingAdapter({"app:goneUnless"})
    public final void goneUnless(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVisibility(z ? 0 : 8);
    }

    @BindingAdapter({"app:layout_size"})
    @JvmStatic
    public static final void setLayoutSize(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "view.layoutParams");
        layoutParams.height = (int) f;
        layoutParams.width = -1;
        view.setLayoutParams(layoutParams);
    }

    @BindingAdapter({"strikeThrough"})
    @JvmStatic
    public static final void strikeThrough(TextView textView, boolean z) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (z) {
            textView.setPaintFlags(textView.getPaintFlags() | 16);
        } else {
            textView.setPaintFlags(textView.getPaintFlags() & (-17));
        }
    }

    @BindingAdapter({"app:planDuration"})
    @JvmStatic
    public static final void setDuration(TextView textView, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (Intrinsics.areEqual(str, "1")) {
            str2 = str + " Month";
        } else {
            str2 = str + " Months";
        }
        textView.setText(str2);
    }

    @BindingAdapter({"app:src"})
    @JvmStatic
    public static final void setImageUri(ImageView view, String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str == null) {
            view.setImageURI(null);
        } else {
            view.setImageURI(Uri.parse(str));
        }
    }

    @BindingAdapter({"app:src"})
    @JvmStatic
    public static final void setImageUri(ImageView view, Uri uri) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setImageURI(uri);
    }

    @BindingAdapter({"app:src"})
    @JvmStatic
    public static final void setImageDrawable(ImageView view, Drawable drawable) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setImageDrawable(drawable);
    }

    @BindingAdapter({"app:src"})
    @JvmStatic
    public static final void setImageResource(ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        imageView.setImageResource(i);
    }
}
