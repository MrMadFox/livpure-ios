package com.livpure.safedrink.subscription.payment.pager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.livpure.safedrink.R;
import com.livpure.safedrink.subscription.plan.data.model.payment.PlanItem;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final Context context;
    private final ArrayList<Fragment> mFragmentList;
    private final ArrayList<PlanItem> mFragmentTitleList;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object object) {
        return -2;
    }

    public ViewPagerAdapter(FragmentManager fm, int behavior, Context context) {
        super(fm, behavior);
        this.mFragmentList = new ArrayList<>();
        this.mFragmentTitleList = new ArrayList<>();
        this.context = context;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int position) {
        return this.mFragmentList.get(position);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mFragmentList.size();
    }

    public void addFrag(Fragment fragment, PlanItem title) {
        this.mFragmentList.add(fragment);
        this.mFragmentTitleList.add(title);
    }

    public View getTabView(final int position) {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.plan_pager_title_layout, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.txtPlanTitleId)).setText(this.mFragmentTitleList.get(position).getName());
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int position) {
        return this.mFragmentTitleList.get(position).getName();
    }
}
