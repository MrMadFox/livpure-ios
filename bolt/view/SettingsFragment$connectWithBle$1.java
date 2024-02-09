package com.livpure.safedrink.bolt.view;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCallback;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.livpure.safedrink.bolt.view.SettingsFragment$connectWithBle$1", f = "SettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class SettingsFragment$connectWithBle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SettingsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsFragment$connectWithBle$1(SettingsFragment settingsFragment, Continuation<? super SettingsFragment$connectWithBle$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsFragment$connectWithBle$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsFragment$connectWithBle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BluetoothDevice bluetoothDevice;
        BluetoothGattCallback bluetoothGattCallback;
        String[] strArr;
        BluetoothDevice bluetoothDevice2;
        BluetoothGattCallback bluetoothGattCallback2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            BluetoothDevice bluetoothDevice3 = null;
            if (ActivityCompat.checkSelfPermission(this.this$0.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                SettingsFragment settingsFragment = this.this$0;
                bluetoothDevice2 = settingsFragment.device;
                if (bluetoothDevice2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AndroidContextPlugin.DEVICE_KEY);
                } else {
                    bluetoothDevice3 = bluetoothDevice2;
                }
                bluetoothGattCallback2 = this.this$0.mGattCallback;
                settingsFragment.mBluetoothGatt = bluetoothDevice3.connectGatt(this.this$0.getMContext(), false, bluetoothGattCallback2);
            } else if (Build.VERSION.SDK_INT >= 31) {
                strArr = this.this$0.android12BlePermission;
                ActivityCompat.requestPermissions(this.this$0.requireActivity(), strArr, 2);
            } else {
                SettingsFragment settingsFragment2 = this.this$0;
                bluetoothDevice = settingsFragment2.device;
                if (bluetoothDevice == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AndroidContextPlugin.DEVICE_KEY);
                } else {
                    bluetoothDevice3 = bluetoothDevice;
                }
                bluetoothGattCallback = this.this$0.mGattCallback;
                settingsFragment2.mBluetoothGatt = bluetoothDevice3.connectGatt(this.this$0.getMContext(), false, bluetoothGattCallback);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
