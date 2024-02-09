package com.livpure.safedrink.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.livpure.safedrink.R;
import com.livpure.safedrink.generated.callback.OnClickListener;
import com.livpure.safedrink.referNearn.model.ReferralHistoryResponse;
import com.livpure.safedrink.referNearn.view.adapter.ReferralHistoryAdapter;
/* loaded from: classes3.dex */
public class AdapterReferrralHistoryBindingImpl extends AdapterReferrralHistoryBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback16;
    private final View.OnClickListener mCallback17;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView4;
    private final ImageView mboundView5;
    private final LinearLayout mboundView6;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    public AdapterReferrralHistoryBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    private AdapterReferrralHistoryBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[3], (ImageView) bindings[2]);
        this.mDirtyFlags = -1L;
        this.imgCallId.setTag(null);
        this.imgWhatsappId.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[4];
        this.mboundView4 = textView2;
        textView2.setTag(null);
        ImageView imageView = (ImageView) bindings[5];
        this.mboundView5 = imageView;
        imageView.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[6];
        this.mboundView6 = linearLayout2;
        linearLayout2.setTag(null);
        setRootTag(root);
        this.mCallback16 = new OnClickListener(this, 1);
        this.mCallback17 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
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
        if (13 == variableId) {
            setPosition((Integer) variable);
        } else if (14 == variableId) {
            setReferral((ReferralHistoryResponse) variable);
        } else if (2 != variableId) {
            return false;
        } else {
            setCallBack((ReferralHistoryAdapter) variable);
        }
        return true;
    }

    @Override // com.livpure.safedrink.databinding.AdapterReferrralHistoryBinding
    public void setPosition(Integer Position) {
        this.mPosition = Position;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.AdapterReferrralHistoryBinding
    public void setReferral(ReferralHistoryResponse Referral) {
        this.mReferral = Referral;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    @Override // com.livpure.safedrink.databinding.AdapterReferrralHistoryBinding
    public void setCallBack(ReferralHistoryAdapter CallBack) {
        this.mCallBack = CallBack;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        Drawable drawable;
        String str2;
        Context context;
        int i;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Integer num = this.mPosition;
        ReferralHistoryResponse referralHistoryResponse = this.mReferral;
        ReferralHistoryAdapter referralHistoryAdapter = this.mCallBack;
        String str3 = null;
        int i2 = ((j & 10) > 0L ? 1 : ((j & 10) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (referralHistoryResponse != null) {
                String registeredDate = referralHistoryResponse.getRegisteredDate();
                str2 = referralHistoryResponse.getUserPhone();
                str3 = referralHistoryResponse.getSubscribe();
                str = registeredDate;
            } else {
                str = null;
                str2 = null;
            }
            boolean equals = str3 != null ? str3.equals("TRUE") : false;
            if (i2 != 0) {
                if (equals) {
                    j2 = j | 32;
                    j3 = 128;
                } else {
                    j2 = j | 16;
                    j3 = 64;
                }
                j = j2 | j3;
            }
            r9 = equals ? 0 : 8;
            if (equals) {
                context = this.mboundView5.getContext();
                i = R.drawable.check_circle;
            } else {
                context = this.mboundView5.getContext();
                i = R.drawable.checkbox_gray_circle;
            }
            Drawable drawable2 = AppCompatResources.getDrawable(context, i);
            str3 = str2;
            drawable = drawable2;
        } else {
            str = null;
            drawable = null;
        }
        if ((8 & j) != 0) {
            this.imgCallId.setOnClickListener(this.mCallback17);
            this.imgWhatsappId.setOnClickListener(this.mCallback16);
        }
        if ((j & 10) != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str3);
            TextViewBindingAdapter.setText(this.mboundView4, str);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView5, drawable);
            this.mboundView6.setVisibility(r9);
        }
    }

    @Override // com.livpure.safedrink.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            Integer num = this.mPosition;
            ReferralHistoryAdapter referralHistoryAdapter = this.mCallBack;
            if (referralHistoryAdapter != null) {
                referralHistoryAdapter.onItemClick(callbackArg_0, num.intValue());
            }
        } else if (sourceId != 2) {
        } else {
            Integer num2 = this.mPosition;
            ReferralHistoryAdapter referralHistoryAdapter2 = this.mCallBack;
            if (referralHistoryAdapter2 != null) {
                referralHistoryAdapter2.onItemClick(callbackArg_0, num2.intValue());
            }
        }
    }
}
