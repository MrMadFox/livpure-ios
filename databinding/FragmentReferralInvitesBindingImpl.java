package com.livpure.safedrink.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.textview.MaterialTextView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel;
/* loaded from: classes3.dex */
public class FragmentReferralInvitesBindingImpl extends FragmentReferralInvitesBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final MaterialTextView mboundView1;
    private final TextView mboundView2;
    private final TextView mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.lytParentViewId, 4);
        sparseIntArray.put(R.id.txtCopyId, 5);
        sparseIntArray.put(R.id.txtHowWorksId, 6);
        sparseIntArray.put(R.id.termsAndConditionsLabel, 7);
        sparseIntArray.put(R.id.onShareReferralCodeWhatsAPPLink, 8);
        sparseIntArray.put(R.id.onShareReferralCode, 9);
    }

    public FragmentReferralInvitesBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private FragmentReferralInvitesBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (LinearLayout) bindings[4], (TextView) bindings[9], (MaterialTextView) bindings[8], (TextView) bindings[7], (TextView) bindings[5], (TextView) bindings[6]);
        this.mDirtyFlags = -1L;
        ScrollView scrollView = (ScrollView) bindings[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        MaterialTextView materialTextView = (MaterialTextView) bindings[1];
        this.mboundView1 = materialTextView;
        materialTextView.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16L;
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
        if (17 == variableId) {
            setUserData((ReferAndEarnViewModel) variable);
            return true;
        }
        return false;
    }

    @Override // com.livpure.safedrink.databinding.FragmentReferralInvitesBinding
    public void setUserData(ReferAndEarnViewModel UserData) {
        this.mUserData = UserData;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            if (localFieldId != 1) {
                if (localFieldId != 2) {
                    return false;
                }
                return onChangeUserDataVoucher((MutableLiveData) object, fieldId);
            }
            return onChangeUserDataFreeWater((MutableLiveData) object, fieldId);
        }
        return onChangeUserDataUser((MutableLiveData) object, fieldId);
    }

    private boolean onChangeUserDataUser(MutableLiveData<User> UserDataUser, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeUserDataFreeWater(MutableLiveData<String> UserDataFreeWater, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeUserDataVoucher(MutableLiveData<String> UserDataVoucher, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            long r2 = r1.mDirtyFlags     // Catch: java.lang.Throwable -> Lbd
            r4 = 0
            r1.mDirtyFlags = r4     // Catch: java.lang.Throwable -> Lbd
            monitor-exit(r18)     // Catch: java.lang.Throwable -> Lbd
            com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel r0 = r1.mUserData
            r6 = 31
            long r6 = r6 & r2
            r8 = 26
            r10 = 25
            r12 = 28
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 == 0) goto L9b
            long r6 = r2 & r10
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 == 0) goto L3c
            if (r0 == 0) goto L26
            androidx.lifecycle.MutableLiveData r6 = r0.getUser()
            goto L27
        L26:
            r6 = 0
        L27:
            r7 = 0
            r1.updateLiveDataRegistration(r7, r6)
            if (r6 == 0) goto L34
            java.lang.Object r6 = r6.getValue()
            com.livpure.safedrink.login.data.models.User r6 = (com.livpure.safedrink.login.data.models.User) r6
            goto L35
        L34:
            r6 = 0
        L35:
            if (r6 == 0) goto L3c
            java.lang.String r6 = r6.getReferralCode()
            goto L3d
        L3c:
            r6 = 0
        L3d:
            long r15 = r2 & r8
            int r7 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r7 == 0) goto L6b
            if (r0 == 0) goto L4a
            androidx.lifecycle.MutableLiveData r7 = r0.getFreeWater()
            goto L4b
        L4a:
            r7 = 0
        L4b:
            r15 = 1
            r1.updateLiveDataRegistration(r15, r7)
            if (r7 == 0) goto L58
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L59
        L58:
            r7 = 0
        L59:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r14 = "Free Water "
            r15.append(r14)
            r15.append(r7)
            java.lang.String r7 = r15.toString()
            goto L6c
        L6b:
            r7 = 0
        L6c:
            long r14 = r2 & r12
            int r17 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r17 == 0) goto L9d
            if (r0 == 0) goto L79
            androidx.lifecycle.MutableLiveData r0 = r0.getVoucher()
            goto L7a
        L79:
            r0 = 0
        L7a:
            r14 = 2
            r1.updateLiveDataRegistration(r14, r0)
            if (r0 == 0) goto L88
            java.lang.Object r0 = r0.getValue()
            r14 = r0
            java.lang.String r14 = (java.lang.String) r14
            goto L89
        L88:
            r14 = 0
        L89:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r15 = "Voucher "
            r0.append(r15)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            goto L9e
        L9b:
            r6 = 0
            r7 = 0
        L9d:
            r14 = 0
        L9e:
            long r12 = r12 & r2
            int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r0 == 0) goto La8
            com.google.android.material.textview.MaterialTextView r0 = r1.mboundView1
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r14)
        La8:
            long r8 = r8 & r2
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto Lb2
            android.widget.TextView r0 = r1.mboundView2
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r7)
        Lb2:
            long r2 = r2 & r10
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto Lbc
            android.widget.TextView r0 = r1.mboundView3
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r6)
        Lbc:
            return
        Lbd:
            r0 = move-exception
            monitor-exit(r18)     // Catch: java.lang.Throwable -> Lbd
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentReferralInvitesBindingImpl.executeBindings():void");
    }
}
