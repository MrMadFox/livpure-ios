package com.livpure.safedrink.servicebluetooth;

import android.app.Activity;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import com.facebook.internal.NativeProtocol;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import timber.log.Timber;
/* compiled from: BluetoothLeService.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001aJ\u0010\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\"\u001a\u00020\u001aJ\u0006\u0010#\u001a\u00020 J\u0010\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010(\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0018\u0010)\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010*\u001a\u00020 J\u0010\u0010+\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dR\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006."}, d2 = {"Lcom/livpure/safedrink/servicebluetooth/BluetoothLeService;", "Landroid/app/Service;", "()V", "android12BlePermission", "", "", "[Ljava/lang/String;", "mBinder", "Landroid/os/IBinder;", "mBluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "mBluetoothDeviceAddress", "mBluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "mBluetoothManager", "Landroid/bluetooth/BluetoothManager;", "mConnectionState", "", "mGattCallback", "Landroid/bluetooth/BluetoothGattCallback;", "supportedGattServices", "", "Landroid/bluetooth/BluetoothGattService;", "getSupportedGattServices", "()Ljava/util/List;", "broadcastUpdate", "", NativeProtocol.WEB_DIALOG_ACTION, "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "close", "connect", "", "address", "disconnect", "initialize", "onBind", "intent", "Landroid/content/Intent;", "onUnbind", "readCharacteristic", "setCharacteristicNotification", "enabled", "writeCharacteristic", "Companion", "LocalBinder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BluetoothLeService extends Service {
    public static final String ACTION_DATA_AVAILABLE = "android-er.ACTION_DATA_AVAILABLE";
    public static final String ACTION_GATT_CONNECTED = "android-er.ACTION_GATT_CONNECTED";
    public static final String ACTION_GATT_DISCONNECTED = "android-er.ACTION_GATT_DISCONNECTED";
    public static final String ACTION_GATT_SERVICES_DISCOVERED = "android-er.ACTION_GATT_SERVICES_DISCOVERED";
    public static final String ACTION_WRITE_DATA_AVAILABLE = "android-er.ACTION_DATA_WRITE_AVAILABLE";
    public static final String EXTRA_DATA = "android-er.EXTRA_DATA";
    private static final int STATE_CONNECTED = 2;
    private static final int STATE_CONNECTING = 1;
    private static final int STATE_DISCONNECTED = 0;
    private BluetoothAdapter mBluetoothAdapter;
    private String mBluetoothDeviceAddress;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothManager mBluetoothManager;
    private int mConnectionState;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "BluetoothLeService";
    private static String String_GENUINO101_SERVICE_READ = "000000ee-0000-1000-8000-00805f9b34fb";
    private static String String_GENUINO101_SERVICE_WRITE = "000000ff-0000-1000-8000-00805f9b34fb";
    private final String[] android12BlePermission = {"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
    private final BluetoothGattCallback mGattCallback = new BluetoothLeService$mGattCallback$1(this);
    private final IBinder mBinder = new LocalBinder();

    /* JADX INFO: Access modifiers changed from: private */
    public final void broadcastUpdate(String str) {
        sendBroadcast(new Intent(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void broadcastUpdate(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Intent intent = new Intent(str);
        byte[] value = bluetoothGattCharacteristic.getValue();
        if (value != null) {
            try {
                if (!(value.length == 0)) {
                    StringBuilder sb = new StringBuilder(value.length);
                    for (byte b : value) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        sb.append(format);
                        String str2 = TAG;
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        String format2 = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                        Timber.v(str2, format2);
                    }
                    intent.putExtra(EXTRA_DATA, new String(value, Charsets.UTF_8) + '\n' + ((Object) sb));
                }
            } catch (Exception e) {
                Timber.tag(TAG).e("Exception in broadcast update: %s", e.toString());
            }
        }
        sendBroadcast(intent);
    }

    /* compiled from: BluetoothLeService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/livpure/safedrink/servicebluetooth/BluetoothLeService$LocalBinder;", "Landroid/os/Binder;", "(Lcom/livpure/safedrink/servicebluetooth/BluetoothLeService;)V", NotificationCompat.CATEGORY_SERVICE, "Lcom/livpure/safedrink/servicebluetooth/BluetoothLeService;", "getService", "()Lcom/livpure/safedrink/servicebluetooth/BluetoothLeService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public final BluetoothLeService getService() {
            return BluetoothLeService.this;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return this.mBinder;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        close();
        disconnect();
        return super.onUnbind(intent);
    }

    public final boolean initialize() {
        if (this.mBluetoothManager == null) {
            Object systemService = getSystemService("bluetooth");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
            BluetoothManager bluetoothManager = (BluetoothManager) systemService;
            this.mBluetoothManager = bluetoothManager;
            if (bluetoothManager == null) {
                Timber.tag(TAG).e("Unable to initialize BluetoothManager.", new Object[0]);
                return false;
            }
        }
        BluetoothManager bluetoothManager2 = this.mBluetoothManager;
        Intrinsics.checkNotNull(bluetoothManager2);
        BluetoothAdapter adapter = bluetoothManager2.getAdapter();
        this.mBluetoothAdapter = adapter;
        if (adapter == null) {
            Timber.tag(TAG).e("Unable to obtain a BluetoothAdapter.", new Object[0]);
            return false;
        }
        return true;
    }

    public final boolean connect(String str) {
        if (this.mBluetoothAdapter == null || str == null) {
            Timber.tag(TAG).w("BluetoothAdapter not initialized or unspecified address.", new Object[0]);
            return false;
        }
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            String str2 = this.mBluetoothDeviceAddress;
            if (str2 != null && Intrinsics.areEqual(str, str2) && this.mBluetoothGatt != null) {
                Timber.tag(TAG).d("Trying to use an existing mBluetoothGatt for connection.", new Object[0]);
                BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
                Intrinsics.checkNotNull(bluetoothGatt);
                if (bluetoothGatt.connect()) {
                    this.mConnectionState = 1;
                    return true;
                }
                return false;
            }
            BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
            Intrinsics.checkNotNull(bluetoothAdapter);
            BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(str);
            if (remoteDevice == null) {
                Timber.tag(TAG).w("Device not found.  Unable to connect.", new Object[0]);
                return false;
            }
            this.mBluetoothGatt = remoteDevice.connectGatt(this, false, this.mGattCallback);
            Timber.tag(TAG).d("Trying to create a new connection.", new Object[0]);
            this.mBluetoothDeviceAddress = str;
            this.mConnectionState = 1;
        } else if (Build.VERSION.SDK_INT >= 31) {
            Context applicationContext = getApplicationContext();
            Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type android.app.Activity");
            ActivityCompat.requestPermissions((Activity) applicationContext, this.android12BlePermission, 2);
        } else {
            String str3 = this.mBluetoothDeviceAddress;
            if (str3 != null && Intrinsics.areEqual(str, str3) && this.mBluetoothGatt != null) {
                Timber.tag(TAG).d("Trying to use an existing mBluetoothGatt for connection.", new Object[0]);
                BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
                Intrinsics.checkNotNull(bluetoothGatt2);
                if (bluetoothGatt2.connect()) {
                    this.mConnectionState = 1;
                    return true;
                }
                return false;
            }
            BluetoothAdapter bluetoothAdapter2 = this.mBluetoothAdapter;
            Intrinsics.checkNotNull(bluetoothAdapter2);
            BluetoothDevice remoteDevice2 = bluetoothAdapter2.getRemoteDevice(str);
            if (remoteDevice2 == null) {
                Timber.tag(TAG).w("Device not found.  Unable to connect.", new Object[0]);
                return false;
            }
            this.mBluetoothGatt = remoteDevice2.connectGatt(this, false, this.mGattCallback);
            Timber.tag(TAG).d("Trying to create a new connection.", new Object[0]);
            this.mBluetoothDeviceAddress = str;
            this.mConnectionState = 1;
        }
        return true;
    }

    public final void disconnect() {
        try {
            if (this.mBluetoothAdapter != null && this.mBluetoothGatt != null) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt);
                    bluetoothGatt.close();
                } else if (Build.VERSION.SDK_INT >= 31) {
                    Context applicationContext = getApplicationContext();
                    if (applicationContext != null) {
                        ActivityCompat.requestPermissions((Activity) applicationContext, this.android12BlePermission, 2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                    }
                } else {
                    BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt2);
                    bluetoothGatt2.close();
                }
                this.mBluetoothGatt = null;
                return;
            }
            Timber.tag(TAG).w("BluetoothAdapter not initialized", new Object[0]);
        } catch (Exception e) {
            Timber.tag(TAG).e("Exception in disconnect: %s", e.toString());
        }
    }

    public final void close() {
        if (this.mBluetoothGatt == null) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
            Intrinsics.checkNotNull(bluetoothGatt);
            bluetoothGatt.close();
        } else if (Build.VERSION.SDK_INT >= 31) {
            Context applicationContext = getApplicationContext();
            Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type android.app.Activity");
            ActivityCompat.requestPermissions((Activity) applicationContext, this.android12BlePermission, 2);
        } else {
            BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
            Intrinsics.checkNotNull(bluetoothGatt2);
            bluetoothGatt2.close();
        }
        this.mBluetoothGatt = null;
    }

    public final void readCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.mBluetoothAdapter == null || this.mBluetoothGatt == null) {
            Timber.w("BluetoothAdapter not initialized", new Object[0]);
        } else if (ActivityCompat.checkSelfPermission(getApplicationContext(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
            Intrinsics.checkNotNull(bluetoothGatt);
            bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
        } else if (Build.VERSION.SDK_INT >= 31) {
            Context applicationContext = getApplicationContext();
            Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type android.app.Activity");
            ActivityCompat.requestPermissions((Activity) applicationContext, this.android12BlePermission, 2);
        } else {
            BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
            Intrinsics.checkNotNull(bluetoothGatt2);
            bluetoothGatt2.readCharacteristic(bluetoothGattCharacteristic);
        }
    }

    public final void setCharacteristicNotification(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        if (this.mBluetoothAdapter == null || this.mBluetoothGatt == null) {
            Timber.w("BluetoothAdapter not initialized", new Object[0]);
        } else if (ActivityCompat.checkSelfPermission(getApplicationContext(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
            Intrinsics.checkNotNull(bluetoothGatt);
            bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z);
        } else if (Build.VERSION.SDK_INT >= 31) {
            Context applicationContext = getApplicationContext();
            Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type android.app.Activity");
            ActivityCompat.requestPermissions((Activity) applicationContext, this.android12BlePermission, 2);
        } else {
            BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
            Intrinsics.checkNotNull(bluetoothGatt2);
            bluetoothGatt2.setCharacteristicNotification(bluetoothGattCharacteristic, z);
        }
    }

    public final void writeCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.mBluetoothGatt == null) {
            Timber.e("BluetoothAdapter not initialized", new Object[0]);
        } else if (ActivityCompat.checkSelfPermission(getApplicationContext(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
            Intrinsics.checkNotNull(bluetoothGatt);
            bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
        } else if (Build.VERSION.SDK_INT >= 31) {
            Context applicationContext = getApplicationContext();
            Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type android.app.Activity");
            ActivityCompat.requestPermissions((Activity) applicationContext, this.android12BlePermission, 2);
        } else {
            BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
            Intrinsics.checkNotNull(bluetoothGatt2);
            bluetoothGatt2.writeCharacteristic(bluetoothGattCharacteristic);
        }
    }

    public final List<BluetoothGattService> getSupportedGattServices() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt == null) {
            return null;
        }
        Intrinsics.checkNotNull(bluetoothGatt);
        return bluetoothGatt.getServices();
    }

    /* compiled from: BluetoothLeService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0016\u001a\n \u0017*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/livpure/safedrink/servicebluetooth/BluetoothLeService$Companion;", "", "()V", "ACTION_DATA_AVAILABLE", "", "ACTION_GATT_CONNECTED", "ACTION_GATT_DISCONNECTED", "ACTION_GATT_SERVICES_DISCOVERED", "ACTION_WRITE_DATA_AVAILABLE", "EXTRA_DATA", "STATE_CONNECTED", "", "STATE_CONNECTING", "STATE_DISCONNECTED", "String_GENUINO101_SERVICE_READ", "getString_GENUINO101_SERVICE_READ", "()Ljava/lang/String;", "setString_GENUINO101_SERVICE_READ", "(Ljava/lang/String;)V", "String_GENUINO101_SERVICE_WRITE", "getString_GENUINO101_SERVICE_WRITE", "setString_GENUINO101_SERVICE_WRITE", "TAG", "kotlin.jvm.PlatformType", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getString_GENUINO101_SERVICE_READ() {
            return BluetoothLeService.String_GENUINO101_SERVICE_READ;
        }

        public final void setString_GENUINO101_SERVICE_READ(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            BluetoothLeService.String_GENUINO101_SERVICE_READ = str;
        }

        public final String getString_GENUINO101_SERVICE_WRITE() {
            return BluetoothLeService.String_GENUINO101_SERVICE_WRITE;
        }

        public final void setString_GENUINO101_SERVICE_WRITE(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            BluetoothLeService.String_GENUINO101_SERVICE_WRITE = str;
        }
    }
}
