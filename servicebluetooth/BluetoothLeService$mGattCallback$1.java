package com.livpure.safedrink.servicebluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;
/* compiled from: BluetoothLeService.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\"\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"com/livpure/safedrink/servicebluetooth/BluetoothLeService$mGattCallback$1", "Landroid/bluetooth/BluetoothGattCallback;", "onCharacteristicChanged", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "onCharacteristicRead", "status", "", "onCharacteristicWrite", "onConnectionStateChange", "newState", "onMtuChanged", "mtu", "onServicesDiscovered", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BluetoothLeService$mGattCallback$1 extends BluetoothGattCallback {
    final /* synthetic */ BluetoothLeService this$0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onConnectionStateChange$lambda-0  reason: not valid java name */
    public static final void m1267onConnectionStateChange$lambda0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onConnectionStateChange$lambda-1  reason: not valid java name */
    public static final void m1268onConnectionStateChange$lambda1() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothLeService$mGattCallback$1(BluetoothLeService bluetoothLeService) {
        this.this$0 = bluetoothLeService;
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onConnectionStateChange(BluetoothGatt gatt, int i, int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        BluetoothGatt bluetoothGatt;
        String[] strArr;
        String str5;
        String str6;
        String str7;
        String str8;
        BluetoothGatt bluetoothGatt2;
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        if (ActivityCompat.checkSelfPermission(this.this$0.getApplicationContext(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            if (i2 == 0) {
                this.this$0.mConnectionState = 0;
                BluetoothLeService bluetoothLeService = this.this$0;
                str5 = bluetoothLeService.mBluetoothDeviceAddress;
                bluetoothLeService.connect(str5);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.livpure.safedrink.servicebluetooth.BluetoothLeService$mGattCallback$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        BluetoothLeService$mGattCallback$1.m1267onConnectionStateChange$lambda0();
                    }
                });
                str6 = BluetoothLeService.TAG;
                Timber.tag(str6).e("Disconnected from GATT server.", new Object[0]);
                this.this$0.broadcastUpdate(BluetoothLeService.ACTION_GATT_DISCONNECTED);
            } else if (i2 != 2) {
            } else {
                if (i != 133) {
                    this.this$0.mConnectionState = 2;
                    gatt.requestMtu(500);
                    this.this$0.broadcastUpdate(BluetoothLeService.ACTION_GATT_CONNECTED);
                    str7 = BluetoothLeService.TAG;
                    Timber.tag(str7).i("Connected to GATT server.", new Object[0]);
                    str8 = BluetoothLeService.TAG;
                    Timber.Tree tag = Timber.tag(str8);
                    bluetoothGatt2 = this.this$0.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt2);
                    tag.i("Attempting to start service discovery:%s", Boolean.valueOf(bluetoothGatt2.discoverServices()));
                    return;
                }
                gatt.disconnect();
            }
        } else if (Build.VERSION.SDK_INT >= 31) {
            Context applicationContext = this.this$0.getApplicationContext();
            Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type android.app.Activity");
            strArr = this.this$0.android12BlePermission;
            ActivityCompat.requestPermissions((Activity) applicationContext, strArr, 2);
        } else if (i2 == 0) {
            this.this$0.mConnectionState = 0;
            BluetoothLeService bluetoothLeService2 = this.this$0;
            str = bluetoothLeService2.mBluetoothDeviceAddress;
            bluetoothLeService2.connect(str);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.livpure.safedrink.servicebluetooth.BluetoothLeService$mGattCallback$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    BluetoothLeService$mGattCallback$1.m1268onConnectionStateChange$lambda1();
                }
            });
            str2 = BluetoothLeService.TAG;
            Timber.tag(str2).e("Disconnected from GATT server.", new Object[0]);
            this.this$0.broadcastUpdate(BluetoothLeService.ACTION_GATT_DISCONNECTED);
        } else if (i2 != 2) {
        } else {
            if (i != 133) {
                this.this$0.mConnectionState = 2;
                gatt.requestMtu(500);
                this.this$0.broadcastUpdate(BluetoothLeService.ACTION_GATT_CONNECTED);
                str3 = BluetoothLeService.TAG;
                Timber.tag(str3).i("Connected to GATT server.", new Object[0]);
                str4 = BluetoothLeService.TAG;
                Timber.Tree tag2 = Timber.tag(str4);
                bluetoothGatt = this.this$0.mBluetoothGatt;
                Intrinsics.checkNotNull(bluetoothGatt);
                tag2.i("Attempting to start service discovery:%s", Boolean.valueOf(bluetoothGatt.discoverServices()));
                return;
            }
            gatt.disconnect();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        String str;
        String[] strArr;
        String str2;
        if (i2 != 0) {
            str2 = BluetoothLeService.TAG;
            Timber.Tree tag = Timber.tag(str2);
            tag.e("Can't set mtu to: " + i, new Object[0]);
            return;
        }
        str = BluetoothLeService.TAG;
        Timber.Tree tag2 = Timber.tag(str);
        tag2.i("Connected to GATT server. MTU: " + i, new Object[0]);
        if (ActivityCompat.checkSelfPermission(this.this$0.getApplicationContext(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            Intrinsics.checkNotNull(bluetoothGatt);
            bluetoothGatt.discoverServices();
        } else if (Build.VERSION.SDK_INT >= 31) {
            Context applicationContext = this.this$0.getApplicationContext();
            Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type android.app.Activity");
            strArr = this.this$0.android12BlePermission;
            ActivityCompat.requestPermissions((Activity) applicationContext, strArr, 2);
        } else {
            Intrinsics.checkNotNull(bluetoothGatt);
            bluetoothGatt.discoverServices();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onServicesDiscovered(BluetoothGatt gatt, int i) {
        String str;
        String[] strArr;
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        if (i == 0) {
            this.this$0.broadcastUpdate(BluetoothLeService.ACTION_GATT_SERVICES_DISCOVERED);
            return;
        }
        str = BluetoothLeService.TAG;
        Timber.Tree tag = Timber.tag(str);
        tag.w("onServicesDiscovered received: " + i, new Object[0]);
        if (ActivityCompat.checkSelfPermission(this.this$0.getApplicationContext(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            gatt.discoverServices();
        } else if (Build.VERSION.SDK_INT >= 31) {
            Context applicationContext = this.this$0.getApplicationContext();
            Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type android.app.Activity");
            strArr = this.this$0.android12BlePermission;
            ActivityCompat.requestPermissions((Activity) applicationContext, strArr, 2);
        } else {
            gatt.discoverServices();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int i) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        if (i == 0) {
            this.this$0.broadcastUpdate(BluetoothLeService.ACTION_DATA_AVAILABLE, characteristic);
        }
        Timber.Tree tag = Timber.tag("");
        tag.e("------------- onCharacteristicRead status: " + i, new Object[0]);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int i) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        Timber.Tree tag = Timber.tag("");
        tag.e("------------- onCharacteristicWrite status: " + i, new Object[0]);
        Log.e("CharWriteBle", "gatt: " + gatt + ", characteristic: " + characteristic + ", status: " + i);
        this.this$0.broadcastUpdate(BluetoothLeService.ACTION_WRITE_DATA_AVAILABLE, characteristic);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        this.this$0.broadcastUpdate(BluetoothLeService.ACTION_DATA_AVAILABLE, characteristic);
    }
}
