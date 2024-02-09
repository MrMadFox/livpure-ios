package com.livpure.safedrink.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.DevicePagerAdapter;
import com.livpure.safedrink.databinding.ViewDeviceBinding;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DevicePagerAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\bH\u0016J\u001c\u0010\f\u001a\u00020\t2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\bH\u0016J*\u0010\f\u001a\u00020\t2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/livpure/safedrink/app/DevicePagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/livpure/safedrink/app/DevicePagerAdapter$DeviceViewHolder;", "deviceList", "", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "onDeviceClicked", "Lkotlin/Function1;", "", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "onBindViewHolder", "holder", "position", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DeviceViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DevicePagerAdapter extends RecyclerView.Adapter<DeviceViewHolder> {
    private final List<DeviceList> deviceList;
    private final Function1<Integer, Unit> onDeviceClicked;

    /* JADX WARN: Multi-variable type inference failed */
    public DevicePagerAdapter(List<DeviceList> deviceList, Function1<? super Integer, Unit> onDeviceClicked) {
        Intrinsics.checkNotNullParameter(deviceList, "deviceList");
        Intrinsics.checkNotNullParameter(onDeviceClicked, "onDeviceClicked");
        this.deviceList = deviceList;
        this.onDeviceClicked = onDeviceClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(DeviceViewHolder deviceViewHolder, int i, List list) {
        onBindViewHolder2(deviceViewHolder, i, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.view_device, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …                   false)");
        return new DeviceViewHolder(this, (ViewDeviceBinding) inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.deviceList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DeviceViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (i >= this.deviceList.size()) {
            return;
        }
        holder.bind(this.deviceList.get(i));
    }

    /* renamed from: onBindViewHolder  reason: avoid collision after fix types in other method */
    public void onBindViewHolder2(DeviceViewHolder holder, int i, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (i >= this.deviceList.size()) {
            return;
        }
        holder.bind(this.deviceList.get(i));
    }

    /* compiled from: DevicePagerAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/app/DevicePagerAdapter$DeviceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bindingItem", "Lcom/livpure/safedrink/databinding/ViewDeviceBinding;", "(Lcom/livpure/safedrink/app/DevicePagerAdapter;Lcom/livpure/safedrink/databinding/ViewDeviceBinding;)V", "bind", "", "deviceList", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class DeviceViewHolder extends RecyclerView.ViewHolder {
        private final ViewDeviceBinding bindingItem;
        final /* synthetic */ DevicePagerAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceViewHolder(DevicePagerAdapter devicePagerAdapter, ViewDeviceBinding bindingItem) {
            super(bindingItem.getRoot());
            Intrinsics.checkNotNullParameter(bindingItem, "bindingItem");
            this.this$0 = devicePagerAdapter;
            this.bindingItem = bindingItem;
        }

        public final void bind(DeviceList deviceList) {
            Intrinsics.checkNotNullParameter(deviceList, "deviceList");
            this.bindingItem.setDevice(deviceList);
            this.bindingItem.executePendingBindings();
            final DevicePagerAdapter devicePagerAdapter = this.this$0;
            ((LinearLayout) this.bindingItem.getRoot().findViewById(R.id.llDeviceList)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.DevicePagerAdapter$DeviceViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DevicePagerAdapter.DeviceViewHolder.m334bind$lambda0(DevicePagerAdapter.this, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m334bind$lambda0(DevicePagerAdapter this$0, DeviceViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.onDeviceClicked.invoke(Integer.valueOf(this$1.getAdapterPosition()));
        }
    }
}
