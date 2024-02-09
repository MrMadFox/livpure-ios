package com.livpure.safedrink.bolt.view;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.bolt.model.SettingModel;
import com.livpure.safedrink.bolt.service.Encrypt;
import com.livpure.safedrink.bolt.view.SettingsFragmentDirections;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.views.BaseFragment;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.utils.AnimProgressBar;
import com.livpure.safedrink.utils.AppConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.payload.PayloadController;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.json.JSONObject;
/* compiled from: SettingsFragment.kt */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010H\u001a\u00020I2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010J\u001a\u00020\u001eH\u0002J\b\u0010K\u001a\u00020\u001eH\u0002J\b\u0010L\u001a\u00020IH\u0002J\b\u0010M\u001a\u00020IH\u0002J\b\u0010N\u001a\u00020IH\u0002J\u0012\u0010O\u001a\u00020I2\b\u0010P\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010Q\u001a\u00020IH\u0002J\b\u0010R\u001a\u00020IH\u0002J\b\u0010S\u001a\u00020\u0005H\u0014J\b\u0010T\u001a\u00020UH\u0014J\b\u0010V\u001a\u00020IH\u0002J\u0018\u0010W\u001a\u00020I2\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010YH\u0002J\b\u0010[\u001a\u00020\u001eH\u0002J\u0010\u0010\\\u001a\u00020\r2\b\u0010]\u001a\u0004\u0018\u00010\rJ\u0012\u0010^\u001a\u00020I2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\b\u0010a\u001a\u00020IH\u0016J\b\u0010b\u001a\u00020IH\u0002J+\u0010b\u001a\u00020I2\u0006\u0010c\u001a\u00020\u00052\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010e\u001a\u00020fH\u0016¢\u0006\u0002\u0010gJ\b\u0010h\u001a\u00020IH\u0016J\b\u0010i\u001a\u00020IH\u0002J\u001a\u0010j\u001a\u00020I2\u0006\u0010k\u001a\u00020l2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010m\u001a\u00020I2\u0006\u0010n\u001a\u00020\u001eH\u0002J\u0012\u0010o\u001a\u0004\u0018\u00010\r2\b\u0010p\u001a\u0004\u0018\u00010\rJ\b\u0010q\u001a\u00020IH\u0002J\u0010\u0010r\u001a\u00020\u001e2\u0006\u0010s\u001a\u00020\u001eH\u0002J\u0014\u0010t\u001a\u0004\u0018\u00010\r2\b\u0010u\u001a\u0004\u0018\u000105H\u0002J\b\u0010v\u001a\u00020IH\u0002J\b\u0010w\u001a\u00020IH\u0002J\u0010\u0010x\u001a\u00020I2\u0006\u0010p\u001a\u00020\rH\u0002J\b\u0010y\u001a\u00020IH\u0002J\b\u0010z\u001a\u00020IH\u0002J\u0010\u0010{\u001a\u00020I2\u0006\u0010u\u001a\u000205H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R2\u0010\u0011\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0013`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R.\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010#j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b<\u0010=R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010B\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bD\u0010E¨\u0006|"}, d2 = {"Lcom/livpure/safedrink/bolt/view/SettingsFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/BaseFragment;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "LOCATION_PERMISSION_CODE", "", "getLOCATION_PERMISSION_CODE", "()I", "REQUEST_LOCATION_CODE", "SCAN_PERIOD", "", "android12BlePermission", "", "", "[Ljava/lang/String;", "animProgressBar", "Lcom/livpure/safedrink/utils/AnimProgressBar;", "attributes", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", AndroidContextPlugin.DEVICE_KEY, "Landroid/bluetooth/BluetoothDevice;", "dialog", "Landroidx/appcompat/app/AlertDialog;", "getWiFiCommandSent", "", "isDisconnected", "job", "Lkotlinx/coroutines/Job;", "listBluetoothDevice", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getListBluetoothDevice", "()Ljava/util/ArrayList;", "setListBluetoothDevice", "(Ljava/util/ArrayList;)V", "mBleConnected", "mBluetoothAdapterSettings", "Landroid/bluetooth/BluetoothAdapter;", "mBluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "mBluetoothLeScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "mDeviceAddress", "mDeviceName", "mGattCallback", "Landroid/bluetooth/BluetoothGattCallback;", "mNotifyCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "mReadCharacteristic", "mScanning", "mWriteCharacteristic", "macIdAdd", "navArgs", "Lcom/livpure/safedrink/bolt/view/SettingsFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/bolt/view/SettingsFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "scanCallback", "Landroid/bluetooth/le/ScanCallback;", "settingModel", "Lcom/livpure/safedrink/bolt/model/SettingModel;", "getSettingModel", "()Lcom/livpure/safedrink/bolt/model/SettingModel;", "settingModel$delegate", "Lkotlin/Lazy;", "addBluetoothDevice", "", "checkGPSEnabled", "checkIfLocationPermissionGranted", "checkLocationPermission", "connectWithBle", "disConnectBLE", "displayData", "data", "getBluetoothAdapter", "getBluetoothLeScanner", "getLayoutId", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "goBack", "initializeGattServices", "gattServices", "", "Landroid/bluetooth/BluetoothGattService;", "isLocationEnabled", "lookup", AnalyticsAttribute.UUID_ATTRIBUTE, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "requestCode", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onUpdateConfigurationButtonClicked", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "optionSelected", "ble", "publishToDevice", "message", "scanLeDevice", "setBluetooth", "enable", "setCharData", "characteristic", "setupBluetooth", "showAlert", "showToastMessage", "showWiFiConfirmationDialog", "updateWifiSettings", "writeCharacteristic", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SettingsFragment extends BaseFragment implements CoroutineScope {
    private AnimProgressBar animProgressBar;
    private BluetoothDevice device;
    private AlertDialog dialog;
    private boolean getWiFiCommandSent;
    private boolean isDisconnected;
    private Job job;
    private ArrayList<String> listBluetoothDevice;
    private boolean mBleConnected;
    private BluetoothAdapter mBluetoothAdapterSettings;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothLeScanner mBluetoothLeScanner;
    private String mDeviceAddress;
    private String mDeviceName;
    private BluetoothGattCharacteristic mNotifyCharacteristic;
    private BluetoothGattCharacteristic mReadCharacteristic;
    private boolean mScanning;
    private BluetoothGattCharacteristic mWriteCharacteristic;
    private final NavArgsLazy navArgs$delegate;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final long SCAN_PERIOD = PayloadController.PAYLOAD_COLLECTOR_TIMEOUT;
    private final int LOCATION_PERMISSION_CODE = 2;
    private String macIdAdd = "";
    private int REQUEST_LOCATION_CODE = 101;
    private final String[] android12BlePermission = {"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
    private final Lazy settingModel$delegate = LazyKt.lazy(new Function0<SettingModel>() { // from class: com.livpure.safedrink.bolt.view.SettingsFragment$settingModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SettingModel invoke() {
            SettingsFragmentArgs navArgs;
            SettingModel settingModel = (SettingModel) new ViewModelProvider(SettingsFragment.this).get(SettingModel.class);
            navArgs = SettingsFragment.this.getNavArgs();
            settingModel.setDevice(navArgs.getDevice());
            return settingModel;
        }
    });
    private final ScanCallback scanCallback = new ScanCallback() { // from class: com.livpure.safedrink.bolt.view.SettingsFragment$scanCallback$1
        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            super.onScanResult(i, result);
            SettingsFragment settingsFragment = SettingsFragment.this;
            BluetoothDevice device = result.getDevice();
            Intrinsics.checkNotNullExpressionValue(device, "result.device");
            settingsFragment.addBluetoothDevice(device);
        }
    };
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: com.livpure.safedrink.bolt.view.SettingsFragment$mGattCallback$1
        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int i) {
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt gatt, int i, int i2) {
            boolean z;
            AnimProgressBar animProgressBar;
            String[] strArr;
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            if (i2 == 0) {
                z = SettingsFragment.this.isDisconnected;
                if (!z) {
                    SettingsFragment.this.connectWithBle();
                }
                SettingsFragment.this.mBleConnected = false;
                animProgressBar = SettingsFragment.this.animProgressBar;
                if (animProgressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                    animProgressBar = null;
                }
                animProgressBar.dismiss();
            } else if (i2 != 2) {
            } else {
                if (ActivityCompat.checkSelfPermission(SettingsFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    gatt.requestMtu(500);
                } else if (Build.VERSION.SDK_INT >= 31) {
                    strArr = SettingsFragment.this.android12BlePermission;
                    ActivityCompat.requestPermissions(SettingsFragment.this.requireActivity(), strArr, 2);
                } else {
                    gatt.requestMtu(500);
                }
                SettingsFragment.this.isDisconnected = false;
                SettingsFragment.this.mBleConnected = true;
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            String[] strArr;
            if (i2 == 0) {
                if (ActivityCompat.checkSelfPermission(SettingsFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    Intrinsics.checkNotNull(bluetoothGatt);
                    bluetoothGatt.discoverServices();
                } else if (Build.VERSION.SDK_INT >= 31) {
                    strArr = SettingsFragment.this.android12BlePermission;
                    ActivityCompat.requestPermissions(SettingsFragment.this.requireActivity(), strArr, 2);
                } else {
                    Intrinsics.checkNotNull(bluetoothGatt);
                    bluetoothGatt.discoverServices();
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt gatt, int i) {
            BluetoothGatt bluetoothGatt;
            BluetoothGattCharacteristic bluetoothGattCharacteristic;
            BluetoothGatt bluetoothGatt2;
            BluetoothGattCharacteristic bluetoothGattCharacteristic2;
            String[] strArr;
            BluetoothGatt bluetoothGatt3;
            BluetoothGattCharacteristic bluetoothGattCharacteristic3;
            BluetoothGatt bluetoothGatt4;
            BluetoothGattCharacteristic bluetoothGattCharacteristic4;
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            if (ActivityCompat.checkSelfPermission(SettingsFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                if (i != 0) {
                    gatt.discoverServices();
                    return;
                }
                SettingsFragment settingsFragment = SettingsFragment.this;
                bluetoothGatt3 = settingsFragment.mBluetoothGatt;
                settingsFragment.initializeGattServices(bluetoothGatt3 != null ? bluetoothGatt3.getServices() : null);
                bluetoothGattCharacteristic3 = SettingsFragment.this.mReadCharacteristic;
                if (bluetoothGattCharacteristic3 != null) {
                    bluetoothGatt4 = SettingsFragment.this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt4);
                    bluetoothGattCharacteristic4 = SettingsFragment.this.mReadCharacteristic;
                    bluetoothGatt4.readCharacteristic(bluetoothGattCharacteristic4);
                }
            } else if (Build.VERSION.SDK_INT >= 31) {
                strArr = SettingsFragment.this.android12BlePermission;
                ActivityCompat.requestPermissions(SettingsFragment.this.requireActivity(), strArr, 2);
            } else if (i != 0) {
                gatt.discoverServices();
            } else {
                SettingsFragment settingsFragment2 = SettingsFragment.this;
                bluetoothGatt = settingsFragment2.mBluetoothGatt;
                settingsFragment2.initializeGattServices(bluetoothGatt != null ? bluetoothGatt.getServices() : null);
                bluetoothGattCharacteristic = SettingsFragment.this.mReadCharacteristic;
                if (bluetoothGattCharacteristic != null) {
                    bluetoothGatt2 = SettingsFragment.this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt2);
                    bluetoothGattCharacteristic2 = SettingsFragment.this.mReadCharacteristic;
                    bluetoothGatt2.readCharacteristic(bluetoothGattCharacteristic2);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int i) {
            String charData;
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            Intrinsics.checkNotNullParameter(characteristic, "characteristic");
            if (i == 0) {
                charData = SettingsFragment.this.setCharData(characteristic);
                BuildersKt__Builders_commonKt.launch$default(SettingsFragment.this, null, null, new SettingsFragment$mGattCallback$1$onCharacteristicRead$1(SettingsFragment.this, charData, null), 3, null);
            }
        }
    };
    private final HashMap<Object, Object> attributes = new HashMap<>();

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public int getLayoutId() {
        return R.layout.fragment_bolt_settings;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public SettingsFragment() {
        final SettingsFragment settingsFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(SettingsFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.bolt.view.SettingsFragment$special$$inlined$navArgs$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bundle invoke() {
                Bundle arguments = Fragment.this.getArguments();
                if (arguments != null) {
                    return arguments;
                }
                throw new IllegalStateException("Fragment " + Fragment.this + " has null arguments");
            }
        });
    }

    public final ArrayList<String> getListBluetoothDevice() {
        return this.listBluetoothDevice;
    }

    public final void setListBluetoothDevice(ArrayList<String> arrayList) {
        this.listBluetoothDevice = arrayList;
    }

    public final int getLOCATION_PERMISSION_CODE() {
        return this.LOCATION_PERMISSION_CODE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsFragmentArgs getNavArgs() {
        return (SettingsFragmentArgs) this.navArgs$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public AnalyticsViewModel getViewModel() {
        return (AnalyticsViewModel) new ViewModelProvider(this).get(AnalyticsViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingModel getSettingModel() {
        return (SettingModel) this.settingModel$delegate.getValue();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        Job job = this.job;
        if (job == null) {
            Intrinsics.throwUninitializedPropertyAccessException("job");
            job = null;
        }
        return job.plus(Dispatchers.getMain());
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        CompletableJob Job$default;
        super.onCreate(bundle);
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.job = Job$default;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((LinearLayout) _$_findCachedViewById(R.id.llbluetooth)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.bolt.view.SettingsFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.m498onViewCreated$lambda0(SettingsFragment.this, view2);
            }
        });
        ((RadioButton) _$_findCachedViewById(R.id.bleCheck)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.bolt.view.SettingsFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.m499onViewCreated$lambda1(SettingsFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.llWiFi)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.bolt.view.SettingsFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.m500onViewCreated$lambda2(SettingsFragment.this, view2);
            }
        });
        ((RadioButton) _$_findCachedViewById(R.id.wifiCheck)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.bolt.view.SettingsFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.m501onViewCreated$lambda3(SettingsFragment.this, view2);
            }
        });
        ((Button) _$_findCachedViewById(R.id.updateConfiguration)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.bolt.view.SettingsFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.m502onViewCreated$lambda4(SettingsFragment.this, view2);
            }
        });
        this.animProgressBar = new AnimProgressBar(requireContext());
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s\n%s", Arrays.copyOf(new Object[]{"Firmware version : 1.00", "Latest Firmware version : 1.00"}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        ((TextView) _$_findCachedViewById(R.id.firmwareTV)).setText(format);
        ((Button) _$_findCachedViewById(R.id.upgradeButton)).setEnabled(true);
        Drawable drawable = getResources().getDrawable(R.drawable.bluetooth_off);
        Intrinsics.checkNotNullExpressionValue(drawable, "resources.getDrawable(R.drawable.bluetooth_off)");
        Drawable drawable2 = getResources().getDrawable(R.drawable.wifi_off);
        Intrinsics.checkNotNullExpressionValue(drawable2, "resources.getDrawable(R.drawable.wifi_off)");
        ((ImageView) _$_findCachedViewById(R.id.bluetoothIV)).setImageDrawable(drawable);
        ((ImageView) _$_findCachedViewById(R.id.wifiIV)).setImageDrawable(drawable2);
        if (Intrinsics.areEqual(getSettingModel().getConnectivity(), "bluetooth")) {
            optionSelected(true);
        } else if (Intrinsics.areEqual(getSettingModel().getConnectivity(), "wifi")) {
            optionSelected(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m498onViewCreated$lambda0(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.optionSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m499onViewCreated$lambda1(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.optionSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m500onViewCreated$lambda2(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.optionSelected(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m501onViewCreated$lambda3(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.optionSelected(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m502onViewCreated$lambda4(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onUpdateConfigurationButtonClicked();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            Intrinsics.checkNotNull(alertDialog);
            if (alertDialog.isShowing()) {
                AlertDialog alertDialog2 = this.dialog;
                Intrinsics.checkNotNull(alertDialog2);
                alertDialog2.dismiss();
            }
        }
        if (checkGPSEnabled() && Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
            checkLocationPermission();
        }
    }

    private final void optionSelected(boolean z) {
        Drawable drawable = getResources().getDrawable(R.drawable.bluetooth_off);
        Intrinsics.checkNotNullExpressionValue(drawable, "resources.getDrawable(R.drawable.bluetooth_off)");
        Drawable drawable2 = getResources().getDrawable(R.drawable.bluetooth);
        Intrinsics.checkNotNullExpressionValue(drawable2, "resources.getDrawable(R.drawable.bluetooth)");
        Drawable drawable3 = getResources().getDrawable(R.drawable.wifi_off);
        Intrinsics.checkNotNullExpressionValue(drawable3, "resources.getDrawable(R.drawable.wifi_off)");
        Drawable drawable4 = getResources().getDrawable(R.drawable.wifi);
        Intrinsics.checkNotNullExpressionValue(drawable4, "resources.getDrawable(R.drawable.wifi)");
        if (z) {
            RadioButton radioButton = (RadioButton) _$_findCachedViewById(R.id.bleCheck);
            Objects.requireNonNull(radioButton, "null cannot be cast to non-null type android.widget.RadioButton");
            radioButton.setChecked(true);
            RadioButton radioButton2 = (RadioButton) _$_findCachedViewById(R.id.wifiCheck);
            Objects.requireNonNull(radioButton2, "null cannot be cast to non-null type android.widget.RadioButton");
            radioButton2.setChecked(false);
            ((ImageView) _$_findCachedViewById(R.id.bluetoothIV)).setImageDrawable(drawable2);
            ((ImageView) _$_findCachedViewById(R.id.wifiIV)).setImageDrawable(drawable3);
            return;
        }
        RadioButton radioButton3 = (RadioButton) _$_findCachedViewById(R.id.bleCheck);
        Objects.requireNonNull(radioButton3, "null cannot be cast to non-null type android.widget.RadioButton");
        radioButton3.setChecked(false);
        RadioButton radioButton4 = (RadioButton) _$_findCachedViewById(R.id.wifiCheck);
        Objects.requireNonNull(radioButton4, "null cannot be cast to non-null type android.widget.RadioButton");
        radioButton4.setChecked(true);
        ((ImageView) _$_findCachedViewById(R.id.wifiIV)).setImageDrawable(drawable4);
        ((ImageView) _$_findCachedViewById(R.id.bluetoothIV)).setImageDrawable(drawable);
    }

    private final void onUpdateConfigurationButtonClicked() {
        RadioButton radioButton = (RadioButton) _$_findCachedViewById(R.id.bleCheck);
        Objects.requireNonNull(radioButton, "null cannot be cast to non-null type android.widget.RadioButton");
        if (radioButton.isChecked()) {
            goBack();
        } else {
            showWiFiConfirmationDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateWifiSettings() {
        disConnectBLE();
        try {
            DeviceList deviceList = getSettingModel().get_device();
            AnimProgressBar animProgressBar = null;
            SettingsFragmentDirections.ActionBoltSettingsToWifiConfiguraton actionBoltSettingsToWifiConfiguraton = deviceList != null ? SettingsFragmentDirections.actionBoltSettingsToWifiConfiguraton(deviceList) : null;
            if (actionBoltSettingsToWifiConfiguraton != null) {
                AnimProgressBar animProgressBar2 = this.animProgressBar;
                if (animProgressBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                } else {
                    animProgressBar = animProgressBar2;
                }
                animProgressBar.dismiss();
                FragmentKt.findNavController(this).navigate(actionBoltSettingsToWifiConfiguraton);
            }
        } catch (Exception e) {
            Log.e(AgentHealth.DEFAULT_KEY, e.toString());
        }
    }

    private final void goBack() {
        setBluetooth(false);
        try {
            LiveData<Boolean> submissionStatus = getSettingModel().getSubmissionStatus(getSettingModel().getImeiNumber(), false, "bluetooth");
            if (submissionStatus != null) {
                LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
                submissionStatus.observe(viewLifecycleOwner, new Observer() { // from class: com.livpure.safedrink.bolt.view.SettingsFragment$goBack$$inlined$observe$1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(T t) {
                        ((Boolean) t).booleanValue();
                        if (SettingsFragment.this.isAdded()) {
                            FragmentKt.findNavController(SettingsFragment.this).popBackStack();
                        }
                    }
                });
            }
        } catch (Exception unused) {
            FragmentKt.findNavController(this).popBackStack();
        }
    }

    private final void showWiFiConfirmationDialog() {
        Context context = getContext();
        final Dialog dialog = context != null ? new Dialog(context) : null;
        if (dialog != null) {
            dialog.requestWindowFeature(1);
        }
        if (dialog != null) {
            dialog.setContentView(R.layout.dialog_wifi_confirmation);
        }
        Window window = dialog != null ? dialog.getWindow() : null;
        Intrinsics.checkNotNull(window);
        window.setLayout(-1, -2);
        Window window2 = dialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setBackgroundDrawable(new ColorDrawable(0));
        ((Button) dialog.findViewById(R.id.restButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.bolt.view.SettingsFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.m504showWiFiConfirmationDialog$lambda8(SettingsFragment.this, dialog, view);
            }
        });
        ((Button) dialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.bolt.view.SettingsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showWiFiConfirmationDialog$lambda-8  reason: not valid java name */
    public static final void m504showWiFiConfirmationDialog$lambda8(SettingsFragment this$0, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnimProgressBar animProgressBar = null;
        if (this$0.setBluetooth(true)) {
            BuildersKt__Builders_commonKt.launch$default(this$0, null, null, new SettingsFragment$showWiFiConfirmationDialog$1$1(this$0, null), 3, null);
        }
        AnimProgressBar animProgressBar2 = this$0.animProgressBar;
        if (animProgressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
        } else {
            animProgressBar = animProgressBar2;
        }
        animProgressBar.show();
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupBluetooth() {
        String format;
        if (Intrinsics.areEqual(getSettingModel().getProductType(), "air-purifier")) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            format = String.format("%s-%s", Arrays.copyOf(new Object[]{"LIV-ARP", StringsKt.takeLast(getSettingModel().getImeiNumber(), 4)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            format = String.format("%s-%s", Arrays.copyOf(new Object[]{"LIVSMT-RO", StringsKt.takeLast(getSettingModel().getImeiNumber(), 4)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        }
        this.macIdAdd = format;
        this.listBluetoothDevice = new ArrayList<>();
        getBluetoothAdapter();
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapterSettings;
        Boolean valueOf = bluetoothAdapter != null ? Boolean.valueOf(bluetoothAdapter.isEnabled()) : null;
        Intrinsics.checkNotNull(valueOf);
        if (!valueOf.booleanValue()) {
            try {
                startActivity(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));
                return;
            } catch (Exception e) {
                Log.e(AgentHealth.DEFAULT_KEY, e.toString());
                return;
            }
        }
        getBluetoothLeScanner();
        if (checkIfLocationPermissionGranted()) {
            scanLeDevice();
        } else {
            onRequestPermissionsResult();
        }
    }

    private final void getBluetoothAdapter() {
        Object systemService = getMContext().getSystemService("bluetooth");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        this.mBluetoothAdapterSettings = ((BluetoothManager) systemService).getAdapter();
        this.mScanning = false;
    }

    private final void getBluetoothLeScanner() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapterSettings;
        Intrinsics.checkNotNull(bluetoothAdapter);
        this.mBluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
    }

    private final void scanLeDevice() {
        if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_SCAN") == 0) {
            ArrayList<String> arrayList = this.listBluetoothDevice;
            Intrinsics.checkNotNull(arrayList);
            arrayList.clear();
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new SettingsFragment$scanLeDevice$1(this, null), 3, null);
            BluetoothLeScanner bluetoothLeScanner = this.mBluetoothLeScanner;
            Intrinsics.checkNotNull(bluetoothLeScanner);
            bluetoothLeScanner.startScan(this.scanCallback);
            this.mScanning = true;
        } else if (Build.VERSION.SDK_INT >= 31) {
            ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
        } else {
            ArrayList<String> arrayList2 = this.listBluetoothDevice;
            Intrinsics.checkNotNull(arrayList2);
            arrayList2.clear();
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new SettingsFragment$scanLeDevice$2(this, null), 3, null);
            BluetoothLeScanner bluetoothLeScanner2 = this.mBluetoothLeScanner;
            Intrinsics.checkNotNull(bluetoothLeScanner2);
            bluetoothLeScanner2.startScan(this.scanCallback);
            this.mScanning = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addBluetoothDevice(BluetoothDevice bluetoothDevice) {
        if (isAdded()) {
            if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                if (bluetoothDevice.getName() != null) {
                    String name = bluetoothDevice.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "device.name");
                    if (!StringsKt.startsWith$default(name, "LIVSMT-RO", false, 2, (Object) null)) {
                        String name2 = bluetoothDevice.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "device.name");
                        if (!StringsKt.startsWith$default(name2, "LIV-ARP", false, 2, (Object) null)) {
                            return;
                        }
                    }
                    String name3 = bluetoothDevice.getName();
                    ArrayList<String> arrayList = this.listBluetoothDevice;
                    Intrinsics.checkNotNull(arrayList);
                    if (arrayList.contains(name3)) {
                        return;
                    }
                    ArrayList<String> arrayList2 = this.listBluetoothDevice;
                    Intrinsics.checkNotNull(arrayList2);
                    arrayList2.add(name3);
                    if (StringsKt.equals(this.macIdAdd, name3, true)) {
                        this.mDeviceAddress = bluetoothDevice.getAddress();
                        this.mDeviceName = bluetoothDevice.getName();
                        this.device = bluetoothDevice;
                        connectWithBle();
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 31) {
                ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
            } else if (bluetoothDevice.getName() != null) {
                String name4 = bluetoothDevice.getName();
                Intrinsics.checkNotNullExpressionValue(name4, "device.name");
                if (!StringsKt.startsWith$default(name4, "LIVSMT-RO", false, 2, (Object) null)) {
                    String name5 = bluetoothDevice.getName();
                    Intrinsics.checkNotNullExpressionValue(name5, "device.name");
                    if (!StringsKt.startsWith$default(name5, "LIV-ARP", false, 2, (Object) null)) {
                        return;
                    }
                }
                String name6 = bluetoothDevice.getName();
                ArrayList<String> arrayList3 = this.listBluetoothDevice;
                Intrinsics.checkNotNull(arrayList3);
                if (arrayList3.contains(name6)) {
                    return;
                }
                ArrayList<String> arrayList4 = this.listBluetoothDevice;
                Intrinsics.checkNotNull(arrayList4);
                arrayList4.add(name6);
                if (StringsKt.equals(this.macIdAdd, name6, true)) {
                    this.mDeviceAddress = bluetoothDevice.getAddress();
                    this.mDeviceName = bluetoothDevice.getName();
                    this.device = bluetoothDevice;
                    connectWithBle();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connectWithBle() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new SettingsFragment$connectWithBle$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeGattServices(List<? extends BluetoothGattService> list) {
        if (list == null) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            for (BluetoothGattService bluetoothGattService : list) {
                List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                ArrayList arrayList = new ArrayList();
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                    arrayList.add(bluetoothGattCharacteristic);
                    int properties = bluetoothGattCharacteristic.getProperties();
                    if ((properties | 2) > 0) {
                        if (this.mNotifyCharacteristic != null) {
                            BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
                            Intrinsics.checkNotNull(bluetoothGatt);
                            bluetoothGatt.setCharacteristicNotification(this.mNotifyCharacteristic, true);
                        }
                        this.mReadCharacteristic = bluetoothGattCharacteristic;
                        BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
                        Intrinsics.checkNotNull(bluetoothGatt2);
                        bluetoothGatt2.readCharacteristic(bluetoothGattCharacteristic);
                    }
                    if ((properties | 16) > 0) {
                        this.mNotifyCharacteristic = bluetoothGattCharacteristic;
                        BluetoothGatt bluetoothGatt3 = this.mBluetoothGatt;
                        Intrinsics.checkNotNull(bluetoothGatt3);
                        bluetoothGatt3.setCharacteristicNotification(bluetoothGattCharacteristic, true);
                    }
                    if ((properties & 8) > 0) {
                        this.mWriteCharacteristic = bluetoothGattCharacteristic;
                    }
                }
            }
        } else if (Build.VERSION.SDK_INT >= 31) {
            ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
        } else {
            for (BluetoothGattService bluetoothGattService2 : list) {
                List<BluetoothGattCharacteristic> characteristics2 = bluetoothGattService2.getCharacteristics();
                ArrayList arrayList2 = new ArrayList();
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : characteristics2) {
                    arrayList2.add(bluetoothGattCharacteristic2);
                    int properties2 = bluetoothGattCharacteristic2.getProperties();
                    if ((properties2 | 2) > 0) {
                        if (this.mNotifyCharacteristic != null) {
                            BluetoothGatt bluetoothGatt4 = this.mBluetoothGatt;
                            Intrinsics.checkNotNull(bluetoothGatt4);
                            bluetoothGatt4.setCharacteristicNotification(this.mNotifyCharacteristic, true);
                        }
                        this.mReadCharacteristic = bluetoothGattCharacteristic2;
                        BluetoothGatt bluetoothGatt5 = this.mBluetoothGatt;
                        Intrinsics.checkNotNull(bluetoothGatt5);
                        bluetoothGatt5.readCharacteristic(bluetoothGattCharacteristic2);
                    }
                    if ((properties2 | 16) > 0) {
                        this.mNotifyCharacteristic = bluetoothGattCharacteristic2;
                        BluetoothGatt bluetoothGatt6 = this.mBluetoothGatt;
                        Intrinsics.checkNotNull(bluetoothGatt6);
                        bluetoothGatt6.setCharacteristicNotification(bluetoothGattCharacteristic2, true);
                    }
                    if ((properties2 & 8) > 0) {
                        this.mWriteCharacteristic = bluetoothGattCharacteristic2;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String setCharData(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] value = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getValue() : null;
        if (value != null) {
            if (!(value.length == 0)) {
                StringBuilder sb = new StringBuilder(value.length);
                for (byte b : value) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    sb.append(format);
                }
                return sb.toString();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayData(String str) {
        if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            if (str != null) {
                try {
                    if (StringsKt.lines(str).size() != 30 && str.length() <= 1199) {
                        AnimProgressBar animProgressBar = this.animProgressBar;
                        if (animProgressBar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                            animProgressBar = null;
                        }
                        animProgressBar.show();
                        BuildersKt__Builders_commonKt.launch$default(this, null, null, new SettingsFragment$displayData$2(this, null), 3, null);
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new SettingsFragment$displayData$1(this, null), 3, null);
                } catch (Exception unused) {
                    if (this.getWiFiCommandSent) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new SettingsFragment$displayData$3(this, null), 3, null);
                }
            }
        } else if (Build.VERSION.SDK_INT >= 31) {
            ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
        } else if (str != null) {
            try {
                if (StringsKt.lines(str).size() != 30 && str.length() <= 1199) {
                    AnimProgressBar animProgressBar2 = this.animProgressBar;
                    if (animProgressBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                        animProgressBar2 = null;
                    }
                    animProgressBar2.show();
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new SettingsFragment$displayData$5(this, null), 3, null);
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new SettingsFragment$displayData$4(this, null), 3, null);
            } catch (Exception unused2) {
                if (this.getWiFiCommandSent) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new SettingsFragment$displayData$6(this, null), 3, null);
            }
        }
    }

    public final String lookup(String str) {
        Object obj = this.attributes.get(str);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
        return (String) obj;
    }

    public final String publishToDevice(String str) {
        Log.e("mrigendra", "setting: " + str);
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("CMD", str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            byte[] hexStringToByteArray = Encrypt.hexStringToByteArray(Encrypt.encrypt(jSONObject.toString(), AppConstants.BEL_ENC_KEY));
            Intrinsics.checkNotNullExpressionValue(hexStringToByteArray, "hexStringToByteArray(encriptedData)");
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.mWriteCharacteristic;
            if (bluetoothGattCharacteristic != null) {
                bluetoothGattCharacteristic.setValue(hexStringToByteArray);
            }
            BluetoothGattCharacteristic bluetoothGattCharacteristic2 = this.mWriteCharacteristic;
            if (bluetoothGattCharacteristic2 != null) {
                writeCharacteristic(bluetoothGattCharacteristic2);
            }
            return "succes";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "Fail";
        }
    }

    private final void writeCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.mBluetoothGatt != null) {
            if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
                Intrinsics.checkNotNull(bluetoothGatt);
                bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
            } else if (Build.VERSION.SDK_INT >= 31) {
                ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
            } else {
                BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
                Intrinsics.checkNotNull(bluetoothGatt2);
                bluetoothGatt2.writeCharacteristic(bluetoothGattCharacteristic);
            }
        }
    }

    private final boolean checkIfLocationPermissionGranted() {
        FragmentActivity activity = getActivity();
        Integer valueOf = activity != null ? Integer.valueOf(ContextCompat.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION")) : null;
        return valueOf != null && valueOf.intValue() == 0;
    }

    private final void onRequestPermissionsResult() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this.LOCATION_PERMISSION_CODE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disConnectBLE() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt != null) {
            if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                bluetoothGatt.disconnect();
                bluetoothGatt.close();
            } else if (Build.VERSION.SDK_INT >= 31) {
                ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
            } else {
                bluetoothGatt.disconnect();
                bluetoothGatt.close();
            }
        }
        this.mBleConnected = false;
        Job job = this.job;
        if (job == null) {
            Intrinsics.throwUninitializedPropertyAccessException("job");
            job = null;
        }
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
    }

    private final boolean setBluetooth(boolean z) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean isEnabled = defaultAdapter.isEnabled();
        if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            if (!z || isEnabled) {
                if (z || !isEnabled) {
                    return true;
                }
                return defaultAdapter.disable();
            }
            return defaultAdapter.enable();
        } else if (Build.VERSION.SDK_INT >= 31) {
            ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
            return true;
        } else if (!z || isEnabled) {
            if (z || !isEnabled) {
                return true;
            }
            return defaultAdapter.disable();
        } else {
            return defaultAdapter.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToastMessage(String str) {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new SettingsFragment$showToastMessage$1(null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        disConnectBLE();
        this.isDisconnected = true;
    }

    private final boolean checkGPSEnabled() {
        if (!isLocationEnabled()) {
            showAlert();
        }
        return isLocationEnabled();
    }

    private final void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle("Enable Location").setMessage("Your Locations Settings is set to 'off'.\nPlease Enable Location to use this app").setCancelable(false).setPositiveButton("Location Settings", new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.bolt.view.SettingsFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SettingsFragment.m503showAlert$lambda14(SettingsFragment.this, dialogInterface, i);
            }
        });
        AlertDialog create = builder.create();
        this.dialog = create;
        Intrinsics.checkNotNull(create);
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showAlert$lambda-14  reason: not valid java name */
    public static final void m503showAlert$lambda14(SettingsFragment this$0, DialogInterface d, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(d, "d");
        d.dismiss();
        this$0.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    private final boolean isLocationEnabled() {
        Object systemService = requireActivity().getSystemService("location");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled(AndroidContextPlugin.NETWORK_KEY);
    }

    private final void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.ACCESS_FINE_LOCATION")) {
                new AlertDialog.Builder(requireActivity()).setTitle("Location Permission Needed").setCancelable(false).setMessage("This app needs the Location permission, please accept to use location functionality").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.bolt.view.SettingsFragment$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SettingsFragment.m497checkLocationPermission$lambda15(SettingsFragment.this, dialogInterface, i);
                    }
                }).create().show();
            } else {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this.REQUEST_LOCATION_CODE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkLocationPermission$lambda-15  reason: not valid java name */
    public static final void m497checkLocationPermission$lambda15(SettingsFragment this$0, DialogInterface d, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(d, "d");
        ActivityCompat.requestPermissions(this$0.requireActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this$0.REQUEST_LOCATION_CODE);
        d.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (i == this.REQUEST_LOCATION_CODE) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                if (ContextCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
                    Toast.makeText(requireActivity(), "permission granted", 1).show();
                    return;
                }
                return;
            }
            Toast.makeText(requireActivity(), "permission denied", 1).show();
        }
    }
}
