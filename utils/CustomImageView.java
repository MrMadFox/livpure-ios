package com.livpure.safedrink.utils;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CustomImageView.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ*\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rJ'\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/utils/CustomImageView;", "", "()V", "ImageViewLoaderURL", "", "url", "", "imageView", "Landroid/widget/ImageView;", "placeHolderImage", "", "progressBar", "Landroid/widget/FrameLayout;", "Landroid/widget/ProgressBar;", "imageViewDrawable", "drawableImage", "(Ljava/lang/Integer;Landroid/widget/ImageView;I)V", "imageViewURL", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CustomImageView {
    public static final CustomImageView INSTANCE = new CustomImageView();

    private CustomImageView() {
    }

    public final void imageViewURL(String str, ImageView imageView, int i) {
        if (str == null || Intrinsics.areEqual(str, "")) {
            return;
        }
        Picasso.get().load(str).placeholder(i).into(imageView);
    }

    public final void ImageViewLoaderURL(String str, ImageView imageView, int i, final FrameLayout progressBar) {
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        progressBar.setVisibility(0);
        if (str != null) {
            try {
                if (Intrinsics.areEqual(str, "")) {
                    return;
                }
                Picasso.get().load(str).placeholder(i).into(imageView, new Callback() { // from class: com.livpure.safedrink.utils.CustomImageView$ImageViewLoaderURL$1
                    @Override // com.squareup.picasso.Callback
                    public void onSuccess() {
                        progressBar.setVisibility(8);
                    }

                    @Override // com.squareup.picasso.Callback
                    public void onError(Exception e) {
                        Intrinsics.checkNotNullParameter(e, "e");
                        progressBar.setVisibility(8);
                    }
                });
            } catch (Exception unused) {
                progressBar.setVisibility(8);
            }
        }
    }

    public final void ImageViewLoaderURL(String str, ImageView imageView, int i, final ProgressBar progressBar) {
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        progressBar.setVisibility(0);
        if (str != null) {
            try {
                if (Intrinsics.areEqual(str, "")) {
                    return;
                }
                Picasso.get().load(str).placeholder(i).into(imageView, new Callback() { // from class: com.livpure.safedrink.utils.CustomImageView$ImageViewLoaderURL$2
                    @Override // com.squareup.picasso.Callback
                    public void onSuccess() {
                        progressBar.setVisibility(8);
                    }

                    @Override // com.squareup.picasso.Callback
                    public void onError(Exception e) {
                        Intrinsics.checkNotNullParameter(e, "e");
                        progressBar.setVisibility(8);
                    }
                });
            } catch (Exception unused) {
                progressBar.setVisibility(8);
            }
        }
    }

    public final void imageViewDrawable(Integer num, ImageView imageView, int i) {
        Picasso picasso = Picasso.get();
        Intrinsics.checkNotNull(num);
        picasso.load(num.intValue()).placeholder(i).into(imageView);
    }
}
