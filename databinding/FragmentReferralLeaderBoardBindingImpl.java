package com.livpure.safedrink.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel;
/* loaded from: classes3.dex */
public class FragmentReferralLeaderBoardBindingImpl extends FragmentReferralLeaderBoardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView1;
    private final TextView mboundView10;
    private final TextView mboundView11;
    private final TextView mboundView12;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView6;
    private final TextView mboundView7;
    private final TextView mboundView8;
    private final TextView mboundView9;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.frameHedder, 13);
        sparseIntArray.put(R.id.txtSuperuserMessageId, 14);
        sparseIntArray.put(R.id.listSuperUserId, 15);
        sparseIntArray.put(R.id.lytRankId, 16);
    }

    public FragmentReferralLeaderBoardBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }

    private FragmentReferralLeaderBoardBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 12, (FrameLayout) bindings[13], (RecyclerView) bindings[15], (LinearLayout) bindings[0], (FrameLayout) bindings[16], (TextView) bindings[14]);
        this.mDirtyFlags = -1L;
        this.lytParentViewId.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[10];
        this.mboundView10 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[11];
        this.mboundView11 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) bindings[12];
        this.mboundView12 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) bindings[2];
        this.mboundView2 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) bindings[3];
        this.mboundView3 = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) bindings[4];
        this.mboundView4 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) bindings[5];
        this.mboundView5 = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) bindings[6];
        this.mboundView6 = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) bindings[7];
        this.mboundView7 = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) bindings[8];
        this.mboundView8 = textView11;
        textView11.setTag(null);
        TextView textView12 = (TextView) bindings[9];
        this.mboundView9 = textView12;
        textView12.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
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

    @Override // com.livpure.safedrink.databinding.FragmentReferralLeaderBoardBinding
    public void setUserData(ReferAndEarnViewModel UserData) {
        this.mUserData = UserData;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeUserDataTop2Name((MutableLiveData) object, fieldId);
            case 1:
                return onChangeUserDataTop3Name((MutableLiveData) object, fieldId);
            case 2:
                return onChangeUserDataReferralMonth((MutableLiveData) object, fieldId);
            case 3:
                return onChangeUserDataReferCount((MutableLiveData) object, fieldId);
            case 4:
                return onChangeUserDataReferRank((MutableLiveData) object, fieldId);
            case 5:
                return onChangeUserDataTop1Name((MutableLiveData) object, fieldId);
            case 6:
                return onChangeUserDataTop3Count((MutableLiveData) object, fieldId);
            case 7:
                return onChangeUserDataTop1AlliasName((MutableLiveData) object, fieldId);
            case 8:
                return onChangeUserDataTop3AlliasName((MutableLiveData) object, fieldId);
            case 9:
                return onChangeUserDataTop1Count((MutableLiveData) object, fieldId);
            case 10:
                return onChangeUserDataTop2Count((MutableLiveData) object, fieldId);
            case 11:
                return onChangeUserDataTop2AlliasName((MutableLiveData) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeUserDataTop2Name(MutableLiveData<String> UserDataTop2Name, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeUserDataTop3Name(MutableLiveData<String> UserDataTop3Name, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeUserDataReferralMonth(MutableLiveData<String> UserDataReferralMonth, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeUserDataReferCount(MutableLiveData<String> UserDataReferCount, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeUserDataReferRank(MutableLiveData<String> UserDataReferRank, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeUserDataTop1Name(MutableLiveData<String> UserDataTop1Name, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeUserDataTop3Count(MutableLiveData<String> UserDataTop3Count, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeUserDataTop1AlliasName(MutableLiveData<String> UserDataTop1AlliasName, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeUserDataTop3AlliasName(MutableLiveData<String> UserDataTop3AlliasName, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeUserDataTop1Count(MutableLiveData<String> UserDataTop1Count, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeUserDataTop2Count(MutableLiveData<String> UserDataTop2Count, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeUserDataTop2AlliasName(MutableLiveData<String> UserDataTop2AlliasName, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0140  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.databinding.FragmentReferralLeaderBoardBindingImpl.executeBindings():void");
    }
}
