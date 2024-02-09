package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.ProfileViewModel;
import com.livpure.safedrink.login.data.models.User;
/* loaded from: classes3.dex */
public class FragmentProfileBindingImpl extends FragmentProfileBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView5;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.imageProfile, 8);
        sparseIntArray.put(R.id.imgEditMail, 9);
        sparseIntArray.put(R.id.imgEditMobile, 10);
        sparseIntArray.put(R.id.cancelSubscriptionLinearLayout, 11);
        sparseIntArray.put(R.id.cancelSubscriptionDetailsLinearLayout, 12);
        sparseIntArray.put(R.id.cancel_subscription_tv, 13);
    }

    public FragmentProfileBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }

    private FragmentProfileBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (LinearLayout) bindings[12], (LinearLayout) bindings[11], (TextView) bindings[13], (EditText) bindings[4], (EditText) bindings[6], (EditText) bindings[3], (EditText) bindings[2], (EditText) bindings[7], (ImageView) bindings[8], (ImageView) bindings[9], (ImageView) bindings[10]);
        this.mDirtyFlags = -1L;
        this.editMobileNumber.setTag(null);
        this.editTextAddress.setTag(null);
        this.editTextMail.setTag(null);
        this.editTextName.setTag(null);
        this.editTextRefferralCode.setTag(null);
        ScrollView scrollView = (ScrollView) bindings[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[5];
        this.mboundView5 = textView2;
        textView2.setTag(null);
        setRootTag(root);
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
        if (18 == variableId) {
            setViewModel((ProfileViewModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentProfileBinding
    public void setViewModel(ProfileViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            if (localFieldId != 1) {
                return false;
            }
            return onChangeViewModelInitials((LiveData) object, fieldId);
        }
        return onChangeViewModelUser((MutableLiveData) object, fieldId);
    }

    private boolean onChangeViewModelUser(MutableLiveData<User> ViewModelUser, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewModelInitials(LiveData<String> ViewModelInitials, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ProfileViewModel profileViewModel = this.mViewModel;
        int i = 0;
        String str14 = null;
        if ((15 & j) != 0) {
            int i2 = ((j & 13) > 0L ? 1 : ((j & 13) == 0L ? 0 : -1));
            if (i2 != 0) {
                MutableLiveData<User> user = profileViewModel != null ? profileViewModel.getUser() : null;
                updateLiveDataRegistration(0, user);
                User value = user != null ? user.getValue() : null;
                if (value != null) {
                    str3 = value.getEmail();
                    str10 = value.getArea();
                    str7 = value.getName();
                    str8 = value.getMobile();
                    str11 = value.getPinCode();
                    str12 = value.getState();
                    str13 = value.getCity();
                    str9 = value.getAddress();
                    str2 = value.getReferralCode();
                } else {
                    str2 = null;
                    str3 = null;
                    str10 = null;
                    str7 = null;
                    str8 = null;
                    str11 = null;
                    str12 = null;
                    str13 = null;
                    str9 = null;
                }
                z = str9 == null;
                str4 = String.format(this.editTextAddress.getResources().getString(R.string.format_address), str9, str10, str13, str12, str11);
                if (i2 != 0) {
                    j = z ? j | 128 : j | 64;
                }
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
                str7 = null;
                str8 = null;
                str9 = null;
                z = false;
            }
            if ((j & 14) != 0) {
                LiveData<String> initials = profileViewModel != null ? profileViewModel.getInitials() : null;
                updateLiveDataRegistration(1, initials);
                if (initials != null) {
                    str14 = initials.getValue();
                }
            }
            str6 = str14;
            str = str7;
            str5 = str8;
            str14 = str9;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            z = false;
        }
        boolean isEmpty = ((64 & j) == 0 || str14 == null) ? false : str14.isEmpty();
        int i3 = ((j & 13) > 0L ? 1 : ((j & 13) == 0L ? 0 : -1));
        if (i3 != 0) {
            boolean z2 = z ? true : isEmpty;
            if (i3 != 0) {
                j |= z2 ? 32L : 16L;
            }
            if (z2) {
                i = 8;
            }
        }
        if ((13 & j) != 0) {
            TextViewBindingAdapter.setText(this.editMobileNumber, str5);
            this.editTextAddress.setVisibility(i);
            TextViewBindingAdapter.setText(this.editTextAddress, str4);
            TextViewBindingAdapter.setText(this.editTextMail, str3);
            TextViewBindingAdapter.setText(this.editTextName, str);
            TextViewBindingAdapter.setText(this.editTextRefferralCode, str2);
            this.mboundView5.setVisibility(i);
        }
        if ((j & 14) != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str6);
        }
    }
}
