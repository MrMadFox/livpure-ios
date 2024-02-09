package com.livpure.safedrink.referNearn.pager;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.livpure.safedrink.referNearn.view.fragment.ReferralHistoryFragment;
import com.livpure.safedrink.referNearn.view.fragment.ReferralInvitesFragment;
import com.livpure.safedrink.referNearn.view.fragment.ReferralLeaderBoardFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReferralPagerAdapter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/referNearn/pager/ReferralPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "createFragment", "position", "", "getItemCount", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferralPagerAdapter extends FragmentStateAdapter {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReferralPagerAdapter(Fragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i) {
        ReferralInvitesFragment referralInvitesFragment;
        if (i == 0) {
            referralInvitesFragment = new ReferralInvitesFragment();
        } else if (i == 1) {
            referralInvitesFragment = new ReferralHistoryFragment();
        } else if (i == 2) {
            referralInvitesFragment = new ReferralLeaderBoardFragment();
        } else {
            referralInvitesFragment = new ReferralInvitesFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("position", i);
        referralInvitesFragment.setArguments(bundle);
        return referralInvitesFragment;
    }
}
