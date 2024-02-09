package com.livpure.safedrink.bolt.view;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.util.Log;
import com.livpure.safedrink.bolt.model.SettingModel;
import com.livpure.safedrink.utils.AnimProgressBar;
import com.newrelic.agent.android.harvest.AgentHealth;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.livpure.safedrink.bolt.view.SettingsFragment$scanLeDevice$1", f = "SettingsFragment.kt", i = {}, l = {338}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class SettingsFragment$scanLeDevice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SettingsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsFragment$scanLeDevice$1(SettingsFragment settingsFragment, Continuation<? super SettingsFragment$scanLeDevice$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsFragment$scanLeDevice$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsFragment$scanLeDevice$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        BluetoothLeScanner bluetoothLeScanner;
        boolean z;
        AnimProgressBar animProgressBar;
        SettingModel settingModel;
        BluetoothAdapter bluetoothAdapter;
        BluetoothLeScanner bluetoothLeScanner2;
        ScanCallback scanCallback;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z2 = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            j = this.this$0.SCAN_PERIOD;
            this.label = 1;
            if (DelayKt.delay(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        bluetoothLeScanner = this.this$0.mBluetoothLeScanner;
        if (bluetoothLeScanner != null) {
            bluetoothAdapter = this.this$0.mBluetoothAdapterSettings;
            if ((bluetoothAdapter == null || bluetoothAdapter.getState() != 12) ? false : false) {
                bluetoothLeScanner2 = this.this$0.mBluetoothLeScanner;
                Intrinsics.checkNotNull(bluetoothLeScanner2);
                scanCallback = this.this$0.scanCallback;
                bluetoothLeScanner2.stopScan(scanCallback);
            }
        }
        z = this.this$0.mBleConnected;
        if (!z) {
            try {
                animProgressBar = this.this$0.animProgressBar;
                if (animProgressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                    animProgressBar = null;
                }
                animProgressBar.dismiss();
                settingModel = this.this$0.getSettingModel();
                if (Intrinsics.areEqual(settingModel.getProductType(), "air-purifier")) {
                    this.this$0.showToastMessage("Please Switch ON the Air Purifier and try again !!");
                } else {
                    this.this$0.showToastMessage("Please Switch ON the RO and try again !!");
                }
            } catch (Exception e) {
                Log.e(AgentHealth.DEFAULT_KEY, e.toString());
            }
        }
        this.this$0.mScanning = false;
        return Unit.INSTANCE;
    }
}
