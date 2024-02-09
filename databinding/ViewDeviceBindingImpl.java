package com.livpure.safedrink.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.amazonaws.services.s3.internal.Constants;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
/* loaded from: classes3.dex */
public class ViewDeviceBindingImpl extends ViewDeviceBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ImageView mboundView1;
    private final ImageView mboundView10;
    private final ImageView mboundView11;
    private final ImageView mboundView12;
    private final ImageView mboundView13;
    private final ImageView mboundView2;
    private final ImageView mboundView3;
    private final ImageView mboundView4;
    private final ImageView mboundView5;
    private final ImageView mboundView6;
    private final ImageView mboundView7;
    private final ImageView mboundView8;
    private final ImageView mboundView9;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    public ViewDeviceBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private ViewDeviceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[14], (LinearLayout) bindings[0], (TextView) bindings[15]);
        this.mDirtyFlags = -1L;
        this.imeiNoTv.setTag(null);
        this.llDeviceList.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[10];
        this.mboundView10 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[11];
        this.mboundView11 = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) bindings[12];
        this.mboundView12 = imageView4;
        imageView4.setTag(null);
        ImageView imageView5 = (ImageView) bindings[13];
        this.mboundView13 = imageView5;
        imageView5.setTag(null);
        ImageView imageView6 = (ImageView) bindings[2];
        this.mboundView2 = imageView6;
        imageView6.setTag(null);
        ImageView imageView7 = (ImageView) bindings[3];
        this.mboundView3 = imageView7;
        imageView7.setTag(null);
        ImageView imageView8 = (ImageView) bindings[4];
        this.mboundView4 = imageView8;
        imageView8.setTag(null);
        ImageView imageView9 = (ImageView) bindings[5];
        this.mboundView5 = imageView9;
        imageView9.setTag(null);
        ImageView imageView10 = (ImageView) bindings[6];
        this.mboundView6 = imageView10;
        imageView10.setTag(null);
        ImageView imageView11 = (ImageView) bindings[7];
        this.mboundView7 = imageView11;
        imageView11.setTag(null);
        ImageView imageView12 = (ImageView) bindings[8];
        this.mboundView8 = imageView12;
        imageView12.setTag(null);
        ImageView imageView13 = (ImageView) bindings[9];
        this.mboundView9 = imageView13;
        imageView13.setTag(null);
        this.serialNoTV.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (3 == variableId) {
            setDevice((DeviceList) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.ViewDeviceBinding
    public void setDevice(DeviceList Device) {
        this.mDevice = Device;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        int i11;
        long j2;
        int i12;
        boolean z3;
        boolean z4;
        boolean z5;
        int i13;
        int i14;
        String str3;
        String str4;
        String str5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        String str6;
        long j3;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        DeviceList deviceList = this.mDevice;
        String str7 = null;
        int i15 = ((j & 3) > 0L ? 1 : ((j & 3) == 0L ? 0 : -1));
        if (i15 != 0) {
            if (deviceList != null) {
                str4 = deviceList.getProductType();
                str = deviceList.getName();
                str3 = deviceList.getSerialNo();
            } else {
                str3 = null;
                str4 = null;
                str = null;
            }
            if (str4 != null) {
                z11 = str4.equals("air-purifier");
                z12 = str4.equals("envy-waas");
                z9 = str4.equals("bolt-waas-wifi-ble");
                z10 = str4.equals("bolt-copper-waas");
                z7 = str4.equals("zinger-waas");
                z8 = str4.equals("i-waas");
                z6 = str4.equals("zinger-copper-emi");
                z = str4.equals("bolt-waas");
                str5 = str4.toLowerCase();
            } else {
                str5 = null;
                z6 = false;
                z = false;
                z7 = false;
                z8 = false;
                z9 = false;
                z10 = false;
                z11 = false;
                z12 = false;
            }
            if (i15 != 0) {
                j |= z11 ? PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            if ((j & 3) != 0) {
                j = z12 ? j | PlaybackStateCompat.ACTION_PREPARE_FROM_URI : j | 65536;
            }
            if ((j & 3) != 0) {
                j |= z9 ? 536870912L : 268435456L;
            }
            if ((j & 3) != 0) {
                j |= z10 ? PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            if ((j & 3) != 0) {
                j |= z7 ? 128L : 64L;
            }
            if ((j & 3) != 0) {
                j |= z8 ? 8L : 4L;
            }
            if ((j & 3) != 0) {
                j |= z6 ? PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : 16384L;
            }
            if ((j & 3) != 0) {
                j = z ? j | 33554432 : j | 16777216;
            }
            int i16 = z11 ? 0 : 8;
            i8 = z9 ? 0 : 8;
            i9 = z10 ? 0 : 8;
            int i17 = z7 ? 0 : 8;
            i7 = z8 ? 0 : 8;
            i2 = z6 ? 0 : 8;
            if (str5 != null) {
                boolean equals = str5.equals("atlantic-mountain-waas");
                boolean equals2 = str5.equals("zinger-waas-copper");
                str6 = str3;
                boolean equals3 = str5.equals("magna-waas");
                z17 = str5.equals("liv-knight+");
                j3 = 3;
                z14 = str5.equals("zingerhotwaas");
                z13 = equals3;
                z16 = equals2;
                z15 = equals;
            } else {
                str6 = str3;
                j3 = 3;
                z13 = false;
                z14 = false;
                z15 = false;
                z16 = false;
                z17 = false;
            }
            if ((j & j3) != 0) {
                j |= z15 ? 134217728L : 67108864L;
            }
            if ((j & j3) != 0) {
                j |= z16 ? 32L : 16L;
            }
            if ((j & j3) != 0) {
                j |= z13 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            if ((j & j3) != 0) {
                j |= z17 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            if ((j & j3) != 0) {
                j |= z14 ? 8388608L : 4194304L;
            }
            i4 = z15 ? 0 : 8;
            int i18 = z16 ? 0 : 8;
            i = z13 ? 0 : 8;
            int i19 = z17 ? 0 : 8;
            i3 = z14 ? 0 : 8;
            i11 = i17;
            str2 = str6;
            i6 = i19;
            z2 = z12;
            i10 = i18;
            j2 = 16777216;
            int i20 = i16;
            str7 = str5;
            i5 = i20;
        } else {
            str = null;
            str2 = null;
            i = 0;
            i2 = 0;
            z = false;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
            i10 = 0;
            z2 = false;
            i11 = 0;
            j2 = 16777216;
        }
        if ((j & j2) == 0 || str7 == null) {
            i12 = i2;
            z3 = false;
        } else {
            i12 = i2;
            z3 = str7.contains("bolt_unltd");
        }
        if ((j & 65536) == 0 || str7 == null) {
            z4 = z3;
            z5 = false;
        } else {
            z4 = z3;
            z5 = str7.contains("envy_unltd");
        }
        int i21 = ((j & 3) > 0L ? 1 : ((j & 3) == 0L ? 0 : -1));
        if (i21 != 0) {
            if (z2) {
                z5 = true;
            }
            if (z) {
                z4 = true;
            }
            if (i21 != 0) {
                j |= z5 ? 512L : 256L;
            }
            if ((j & 3) != 0) {
                j |= z4 ? 2147483648L : Constants.GB;
            }
            i14 = z5 ? 0 : 8;
            i13 = z4 ? 0 : 8;
        } else {
            i13 = 0;
            i14 = 0;
        }
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.imeiNoTv, str);
            this.mboundView1.setVisibility(i);
            this.mboundView10.setVisibility(i7);
            this.mboundView11.setVisibility(i13);
            this.mboundView12.setVisibility(i9);
            this.mboundView13.setVisibility(i8);
            this.mboundView2.setVisibility(i6);
            this.mboundView3.setVisibility(i3);
            this.mboundView4.setVisibility(i4);
            this.mboundView5.setVisibility(i10);
            this.mboundView6.setVisibility(i5);
            this.mboundView7.setVisibility(i12);
            this.mboundView8.setVisibility(i11);
            this.mboundView9.setVisibility(i14);
            TextViewBindingAdapter.setText(this.serialNoTV, str2);
        }
    }
}
