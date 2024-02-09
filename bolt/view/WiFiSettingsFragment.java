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
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.bolt.api.WifiCommunicator;
import com.livpure.safedrink.bolt.model.WiFiSettingsModel;
import com.livpure.safedrink.bolt.service.Base64Hex;
import com.livpure.safedrink.bolt.service.Encrypt;
import com.livpure.safedrink.bolt.view.adapter.AutoCompleteAdapter;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentWifiSettingsBinding;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.servicebluetooth.BluetoothLeService;
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
import java.util.Locale;
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
/* compiled from: WiFiSettingsFragment.kt */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010V\u001a\u00020W2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020\u0002H\u0016J\u0012\u0010Z\u001a\u00020[2\n\u0010\\\u001a\u00020]\"\u00020\bJ\b\u0010^\u001a\u00020#H\u0002J\b\u0010_\u001a\u00020WH\u0002J\b\u0010`\u001a\u00020WH\u0002J\u0012\u0010a\u001a\u00020W2\b\u0010b\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010c\u001a\u00020WH\u0002J\b\u0010d\u001a\u00020WH\u0002J\b\u0010e\u001a\u00020\bH\u0014J\b\u0010f\u001a\u00020gH\u0014J\b\u0010h\u001a\u00020WH\u0002J\b\u0010i\u001a\u00020WH\u0002J\u0018\u0010j\u001a\u00020W2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010lH\u0002J\b\u0010n\u001a\u00020WH\u0002J\b\u0010o\u001a\u00020WH\u0002J\b\u0010p\u001a\u00020WH\u0002J\u0010\u0010q\u001a\u00020\u000e2\b\u0010r\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010s\u001a\u00020W2\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020\bH\u0016J\u0012\u0010w\u001a\u00020W2\b\u0010x\u001a\u0004\u0018\u00010yH\u0016J\b\u0010z\u001a\u00020WH\u0016J\b\u0010{\u001a\u00020WH\u0016J\b\u0010|\u001a\u00020WH\u0002J\b\u0010}\u001a\u00020WH\u0002J\u0006\u0010~\u001a\u00020WJ\u001c\u0010\u007f\u001a\u00020W2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\b\u0010x\u001a\u0004\u0018\u00010yH\u0016J\t\u0010\u0082\u0001\u001a\u00020WH\u0002J\t\u0010\u0083\u0001\u001a\u00020WH\u0002J\u0016\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u000e2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000eH\u0002J\u0016\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u000e2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010[H\u0002J\u0014\u0010\u0087\u0001\u001a\u00020W2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000eH\u0016J\t\u0010\u0089\u0001\u001a\u00020WH\u0002J\u0012\u0010\u008a\u0001\u001a\u00020W2\u0007\u0010\u008b\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010\u008c\u0001\u001a\u00020#2\u0007\u0010\u008d\u0001\u001a\u00020#H\u0002J\u0016\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u000e2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010<H\u0002J\t\u0010\u0090\u0001\u001a\u00020WH\u0002J\t\u0010\u0091\u0001\u001a\u00020WH\u0002J\u0012\u0010\u0092\u0001\u001a\u00020W2\u0007\u0010\u0085\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010\u0093\u0001\u001a\u00020W2\u0007\u0010\u008f\u0001\u001a\u00020<H\u0002R\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00148\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R.\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010*j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010D\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bF\u0010GR\u000e\u0010J\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010N\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bP\u0010QR\u000e\u0010T\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0094\u0001"}, d2 = {"Lcom/livpure/safedrink/bolt/view/WiFiSettingsFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentWifiSettingsBinding;", "Lcom/livpure/safedrink/bolt/api/WifiCommunicator;", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/widget/RadioGroup$OnCheckedChangeListener;", "()V", "LOCATION_PERMISSION_CODE", "", "getLOCATION_PERMISSION_CODE", "()I", "SCAN_PERIOD", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "android12BlePermission", "", "[Ljava/lang/String;", "animProgressBar", "Lcom/livpure/safedrink/utils/AnimProgressBar;", "attributes", "Ljava/util/HashMap;", "", "bleWiFICounter", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", AndroidContextPlugin.DEVICE_KEY, "Landroid/bluetooth/BluetoothDevice;", "getWiFiCommandSent", "", "handler", "Landroid/os/Handler;", "isDisconnected", "job", "Lkotlinx/coroutines/Job;", "listBluetoothDevice", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getListBluetoothDevice", "()Ljava/util/ArrayList;", "setListBluetoothDevice", "(Ljava/util/ArrayList;)V", "mBleConnected", "mBluetoothAdapterWiFi", "Landroid/bluetooth/BluetoothAdapter;", "mBluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "mBluetoothLeScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "mDeviceAddress", "mDeviceName", "mGattCallback", "Landroid/bluetooth/BluetoothGattCallback;", "mNotifyCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "mPassword", "mReadCharacteristic", "mScanning", "mWriteCharacteristic", "macIdAdd", "myScanRunnable", "Ljava/lang/Runnable;", "navArgs", "Lcom/livpure/safedrink/bolt/view/WiFiSettingsFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/bolt/view/WiFiSettingsFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "onResetWiFiConfigClicked", "scanCallback", "Landroid/bluetooth/le/ScanCallback;", "ssidName", "wiFiSettingsModel", "Lcom/livpure/safedrink/bolt/model/WiFiSettingsModel;", "getWiFiSettingsModel", "()Lcom/livpure/safedrink/bolt/model/WiFiSettingsModel;", "wiFiSettingsModel$delegate", "Lkotlin/Lazy;", "wifiSettingsBinding", "wifiType", "addBluetoothDevice", "", "bindVariablesToView", "dataBinding", "byteArrayOfInts", "", "ints", "", "checkIfLocationPermissionGranted", "connectWithBle", "disConnectBLE", "displayData", "data", "getBluetoothAdapter", "getBluetoothLeScanner", "getLayoutId", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "getWifiInputValue", "goBack", "initializeGattServices", "gattServices", "", "Landroid/bluetooth/BluetoothGattService;", "initializeViews", "launchErroDialog", "listeners", "lookup", AnalyticsAttribute.UUID_ATTRIBUTE, "onCheckedChanged", "group", "Landroid/widget/RadioGroup;", "checkedId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onReloadButtonClick", "onRequestPermissionsResult", "onResetWiFiConfigButtonClicked", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "onWiFiConfigButtonClicked", "publishCommandLoop", "publishToDevice", "message", "publishWiFiToDevice", "respond", "msg", "scanLeDevice", "sendToBLEJsonData", "value", "setBluetooth", "enable", "setCharData", "characteristic", "setupBluetooth", "showDialog", "showToastMessage", "writeCharacteristic", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WiFiSettingsFragment extends DataBindingFragment<FragmentWifiSettingsBinding> implements WifiCommunicator, CoroutineScope, RadioGroup.OnCheckedChangeListener {
    private AnimProgressBar animProgressBar;
    private int bleWiFICounter;
    private BluetoothDevice device;
    private boolean getWiFiCommandSent;
    private Handler handler;
    private boolean isDisconnected;
    private Job job;
    private ArrayList<String> listBluetoothDevice;
    private boolean mBleConnected;
    private BluetoothAdapter mBluetoothAdapterWiFi;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothLeScanner mBluetoothLeScanner;
    private String mDeviceAddress;
    private String mDeviceName;
    private BluetoothGattCharacteristic mNotifyCharacteristic;
    private String mPassword;
    private BluetoothGattCharacteristic mReadCharacteristic;
    private boolean mScanning;
    private BluetoothGattCharacteristic mWriteCharacteristic;
    private Runnable myScanRunnable;
    private final NavArgsLazy navArgs$delegate;
    private boolean onResetWiFiConfigClicked;
    private String ssidName;
    private FragmentWifiSettingsBinding wifiSettingsBinding;
    private String wifiType;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final int LOCATION_PERMISSION_CODE = 2;
    private final long SCAN_PERIOD = PayloadController.PAYLOAD_COLLECTOR_TIMEOUT;
    private String TAG = "livpurelogs";
    private final Lazy wiFiSettingsModel$delegate = LazyKt.lazy(new Function0<WiFiSettingsModel>() { // from class: com.livpure.safedrink.bolt.view.WiFiSettingsFragment$wiFiSettingsModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WiFiSettingsModel invoke() {
            WiFiSettingsFragmentArgs navArgs;
            WiFiSettingsModel wiFiSettingsModel = (WiFiSettingsModel) new ViewModelProvider(WiFiSettingsFragment.this).get(WiFiSettingsModel.class);
            navArgs = WiFiSettingsFragment.this.getNavArgs();
            wiFiSettingsModel.setDevice(navArgs.getDevice());
            return wiFiSettingsModel;
        }
    });
    private final String[] android12BlePermission = {"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
    private String macIdAdd = "";
    private final ScanCallback scanCallback = new ScanCallback() { // from class: com.livpure.safedrink.bolt.view.WiFiSettingsFragment$scanCallback$1
        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            super.onScanResult(i, result);
            WiFiSettingsFragment wiFiSettingsFragment = WiFiSettingsFragment.this;
            BluetoothDevice device = result.getDevice();
            Intrinsics.checkNotNullExpressionValue(device, "result.device");
            wiFiSettingsFragment.addBluetoothDevice(device);
        }
    };
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: com.livpure.safedrink.bolt.view.WiFiSettingsFragment$mGattCallback$1
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
            boolean z2;
            AnimProgressBar animProgressBar;
            String[] strArr;
            boolean z3;
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            if (i2 == 0) {
                z = WiFiSettingsFragment.this.isDisconnected;
                if (!z) {
                    WiFiSettingsFragment.this.connectWithBle();
                }
                WiFiSettingsFragment.this.mBleConnected = false;
                String tag = WiFiSettingsFragment.this.getTAG();
                StringBuilder sb = new StringBuilder();
                sb.append("onConnectionStateChange: ");
                z2 = WiFiSettingsFragment.this.mBleConnected;
                sb.append(z2);
                Log.e(tag, sb.toString());
                animProgressBar = WiFiSettingsFragment.this.animProgressBar;
                if (animProgressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                    animProgressBar = null;
                }
                animProgressBar.dismiss();
            } else if (i2 != 2) {
            } else {
                if (ActivityCompat.checkSelfPermission(WiFiSettingsFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    gatt.requestMtu(500);
                } else if (Build.VERSION.SDK_INT >= 31) {
                    strArr = WiFiSettingsFragment.this.android12BlePermission;
                    ActivityCompat.requestPermissions(WiFiSettingsFragment.this.requireActivity(), strArr, 2);
                } else {
                    gatt.requestMtu(500);
                }
                WiFiSettingsFragment.this.isDisconnected = false;
                WiFiSettingsFragment.this.mBleConnected = true;
                String tag2 = WiFiSettingsFragment.this.getTAG();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onConnectionStateChange: ");
                z3 = WiFiSettingsFragment.this.mBleConnected;
                sb2.append(z3);
                Log.e(tag2, sb2.toString());
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            String[] strArr;
            if (i2 == 0) {
                if (ActivityCompat.checkSelfPermission(WiFiSettingsFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    Intrinsics.checkNotNull(bluetoothGatt);
                    bluetoothGatt.discoverServices();
                } else if (Build.VERSION.SDK_INT >= 31) {
                    strArr = WiFiSettingsFragment.this.android12BlePermission;
                    ActivityCompat.requestPermissions(WiFiSettingsFragment.this.requireActivity(), strArr, 2);
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
            if (ActivityCompat.checkSelfPermission(WiFiSettingsFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                if (i != 0) {
                    gatt.discoverServices();
                    return;
                }
                WiFiSettingsFragment wiFiSettingsFragment = WiFiSettingsFragment.this;
                bluetoothGatt3 = wiFiSettingsFragment.mBluetoothGatt;
                wiFiSettingsFragment.initializeGattServices(bluetoothGatt3 != null ? bluetoothGatt3.getServices() : null);
                bluetoothGattCharacteristic3 = WiFiSettingsFragment.this.mReadCharacteristic;
                if (bluetoothGattCharacteristic3 != null) {
                    bluetoothGatt4 = WiFiSettingsFragment.this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt4);
                    bluetoothGattCharacteristic4 = WiFiSettingsFragment.this.mReadCharacteristic;
                    bluetoothGatt4.readCharacteristic(bluetoothGattCharacteristic4);
                }
            } else if (Build.VERSION.SDK_INT >= 31) {
                strArr = WiFiSettingsFragment.this.android12BlePermission;
                ActivityCompat.requestPermissions(WiFiSettingsFragment.this.requireActivity(), strArr, 2);
            } else if (i != 0) {
                gatt.discoverServices();
            } else {
                WiFiSettingsFragment wiFiSettingsFragment2 = WiFiSettingsFragment.this;
                bluetoothGatt = wiFiSettingsFragment2.mBluetoothGatt;
                wiFiSettingsFragment2.initializeGattServices(bluetoothGatt != null ? bluetoothGatt.getServices() : null);
                bluetoothGattCharacteristic = WiFiSettingsFragment.this.mReadCharacteristic;
                if (bluetoothGattCharacteristic != null) {
                    bluetoothGatt2 = WiFiSettingsFragment.this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt2);
                    bluetoothGattCharacteristic2 = WiFiSettingsFragment.this.mReadCharacteristic;
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
                charData = WiFiSettingsFragment.this.setCharData(characteristic);
                BuildersKt__Builders_commonKt.launch$default(WiFiSettingsFragment.this, null, null, new WiFiSettingsFragment$mGattCallback$1$onCharacteristicRead$1(WiFiSettingsFragment.this, charData, null), 3, null);
            }
        }
    };
    private final HashMap<Object, Object> attributes = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: launchErroDialog$lambda-5  reason: not valid java name */
    public static final void m510launchErroDialog$lambda5(DialogInterface dialogInterface, int i) {
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment
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
        return R.layout.fragment_wifi_settings;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public WiFiSettingsFragment() {
        final WiFiSettingsFragment wiFiSettingsFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(WiFiSettingsFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.bolt.view.WiFiSettingsFragment$special$$inlined$navArgs$1
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

    public final int getLOCATION_PERMISSION_CODE() {
        return this.LOCATION_PERMISSION_CODE;
    }

    public final ArrayList<String> getListBluetoothDevice() {
        return this.listBluetoothDevice;
    }

    public final void setListBluetoothDevice(ArrayList<String> arrayList) {
        this.listBluetoothDevice = arrayList;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final void setTAG(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.TAG = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WiFiSettingsFragmentArgs getNavArgs() {
        return (WiFiSettingsFragmentArgs) this.navArgs$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WiFiSettingsModel getWiFiSettingsModel() {
        return (WiFiSettingsModel) this.wiFiSettingsModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public AnalyticsViewModel getViewModel() {
        return (AnalyticsViewModel) new ViewModelProvider(this).get(AnalyticsViewModel.class);
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
        this.handler = new Handler();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.onResetWiFiConfigClicked = false;
        listeners();
        this.animProgressBar = new AnimProgressBar(requireContext());
        this.wifiType = "Wifi Router";
        if (setBluetooth(true)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new WiFiSettingsFragment$onViewCreated$1(this, null), 3, null);
        }
        ((SwipeRefreshLayout) _$_findCachedViewById(R.id.swipe_refresh_layout_comments)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.livpure.safedrink.bolt.view.WiFiSettingsFragment$$ExternalSyntheticLambda8
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                WiFiSettingsFragment.m514onViewCreated$lambda0(WiFiSettingsFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m514onViewCreated$lambda0(WiFiSettingsFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.bleWiFICounter == 0) {
            this$0.onResetWiFiConfigClicked = false;
            this$0.onReloadButtonClick();
        }
        ((SwipeRefreshLayout) this$0._$_findCachedViewById(R.id.swipe_refresh_layout_comments)).setRefreshing(false);
    }

    private final void listeners() {
        ((RadioGroup) _$_findCachedViewById(R.id.rgBtnWifiTypeId)).setOnCheckedChangeListener(this);
        ((RadioGroup) _$_findCachedViewById(R.id.rgBtnWifiTypeId)).check(R.id.rBtnWifiId);
        FragmentWifiSettingsBinding fragmentWifiSettingsBinding = this.wifiSettingsBinding;
        if (fragmentWifiSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wifiSettingsBinding");
            fragmentWifiSettingsBinding = null;
        }
        fragmentWifiSettingsBinding.setIsWifiRouter(true);
        ((Button) _$_findCachedViewById(R.id.update)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.bolt.view.WiFiSettingsFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WiFiSettingsFragment.m511listeners$lambda1(WiFiSettingsFragment.this, view);
            }
        });
        ((Button) _$_findCachedViewById(R.id.resetWiFi)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.bolt.view.WiFiSettingsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WiFiSettingsFragment.m512listeners$lambda2(WiFiSettingsFragment.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R.id.imgRefreshId)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.bolt.view.WiFiSettingsFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WiFiSettingsFragment.m513listeners$lambda3(WiFiSettingsFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-1  reason: not valid java name */
    public static final void m511listeners$lambda1(WiFiSettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onWiFiConfigButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-2  reason: not valid java name */
    public static final void m512listeners$lambda2(WiFiSettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onResetWiFiConfigButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-3  reason: not valid java name */
    public static final void m513listeners$lambda3(WiFiSettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onReloadButtonClick();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        String str;
        String str2;
        String str3;
        String planName;
        String planName2;
        String planName3;
        setBluetooth(false);
        try {
            disConnectBLE();
        } catch (Exception e) {
            Log.e(AgentHealth.DEFAULT_KEY, e.toString());
        }
        User user = LSApplication.Companion.getUser();
        if (user == null || (planName3 = user.getPlanName()) == null) {
            str = null;
        } else {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            str = planName3.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
        }
        if (!StringsKt.equals$default(str, "furlenco", false, 2, null)) {
            User user2 = LSApplication.Companion.getUser();
            if (user2 == null || (planName2 = user2.getPlanName()) == null) {
                str2 = null;
            } else {
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
                str2 = planName2.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(locale)");
            }
            if (!StringsKt.equals$default(str2, "rentmojo", false, 2, null)) {
                User user3 = LSApplication.Companion.getUser();
                if (user3 == null || (planName = user3.getPlanName()) == null) {
                    str3 = null;
                } else {
                    Locale locale3 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale3, "getDefault()");
                    str3 = planName.toLowerCase(locale3);
                    Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String).toLowerCase(locale)");
                }
                if (!StringsKt.equals$default(str3, "b2b", false, 2, null)) {
                    FragmentKt.findNavController(this).popBackStack(R.id.homeFragment, false);
                    super.onDetach();
                }
            }
        }
        FragmentKt.findNavController(this).popBackStack(R.id.homeFurlencoFragment, false);
        super.onDetach();
    }

    private final void onReloadButtonClick() {
        this.onResetWiFiConfigClicked = false;
        this.getWiFiCommandSent = false;
        disConnectBLE();
        if (setBluetooth(true)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new WiFiSettingsFragment$onReloadButtonClick$1(this, null), 3, null);
        }
    }

    private final void initializeViews() {
        FragmentActivity mContext = getMContext();
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        ((MaterialAutoCompleteTextView) _$_findCachedViewById(R.id.autoWifiNameId)).setAdapter(new AutoCompleteAdapter(mContext, R.layout.adapter_auto_complete, getWiFiSettingsModel().getListOfWifiName()));
        ((MaterialAutoCompleteTextView) _$_findCachedViewById(R.id.autoWifiNameId)).setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.livpure.safedrink.bolt.view.WiFiSettingsFragment$$ExternalSyntheticLambda6
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                WiFiSettingsFragment.m509initializeViews$lambda4(WiFiSettingsFragment.this, adapterView, view, i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initializeViews$lambda-4  reason: not valid java name */
    public static final void m509initializeViews$lambda4(WiFiSettingsFragment this$0, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ssidName = this$0.getWiFiSettingsModel().getListOfWifiName().get(i);
        FragmentWifiSettingsBinding fragmentWifiSettingsBinding = this$0.wifiSettingsBinding;
        if (fragmentWifiSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wifiSettingsBinding");
            fragmentWifiSettingsBinding = null;
        }
        fragmentWifiSettingsBinding.autoWifiNameId.setText(this$0.ssidName);
    }

    public final void onResetWiFiConfigButtonClicked() {
        Log.e(this.TAG, "onResetWiFiConfigButtonClicked: (mBleConnected" + this.mBleConnected);
        if (this.mBleConnected) {
            AnimProgressBar animProgressBar = this.animProgressBar;
            if (animProgressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                animProgressBar = null;
            }
            animProgressBar.show();
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new WiFiSettingsFragment$onResetWiFiConfigButtonClicked$1(this, null), 3, null);
        } else if (!this.onResetWiFiConfigClicked) {
            this.onResetWiFiConfigClicked = true;
            if (setBluetooth(true)) {
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new WiFiSettingsFragment$onResetWiFiConfigButtonClicked$2(this, null), 3, null);
            }
        } else {
            launchErroDialog();
        }
    }

    private final void launchErroDialog() {
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        new AlertDialog.Builder(context).setTitle(getString(R.string.bolt_ble_title)).setMessage(getString(R.string.bolt_ble_message)).setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.bolt.view.WiFiSettingsFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                WiFiSettingsFragment.m510launchErroDialog$lambda5(dialogInterface, i);
            }
        }).create().show();
    }

    private final void onWiFiConfigButtonClicked() {
        getWifiInputValue();
        String str = this.ssidName;
        boolean z = false;
        if (str == null || str.length() == 0) {
            showToastMessage("WiFi name should not be empty");
            return;
        }
        String str2 = this.mPassword;
        if ((str2 == null || str2.length() == 0) ? true : true) {
            showToastMessage("Password should not be empty");
        } else {
            onResetWiFiConfigButtonClicked();
        }
    }

    private final void getWifiInputValue() {
        String valueOf;
        FragmentWifiSettingsBinding fragmentWifiSettingsBinding = null;
        if (StringsKt.equals$default(this.wifiType, "Wifi Router", false, 2, null)) {
            valueOf = ((MaterialAutoCompleteTextView) _$_findCachedViewById(R.id.autoWifiNameId)).getText().toString();
        } else {
            valueOf = String.valueOf(((TextInputEditText) _$_findCachedViewById(R.id.edtWifiNameId)).getText());
        }
        this.ssidName = valueOf;
        FragmentWifiSettingsBinding fragmentWifiSettingsBinding2 = this.wifiSettingsBinding;
        if (fragmentWifiSettingsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wifiSettingsBinding");
        } else {
            fragmentWifiSettingsBinding = fragmentWifiSettingsBinding2;
        }
        this.mPassword = String.valueOf(fragmentWifiSettingsBinding.edtPasswordId.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goBack() {
        disConnectBLE();
        LiveData<Boolean> submissionStatus = getWiFiSettingsModel().getSubmissionStatus(getWiFiSettingsModel().getImeiNumber(), true);
        if (submissionStatus != null) {
            submissionStatus.observe(this, new Observer() { // from class: com.livpure.safedrink.bolt.view.WiFiSettingsFragment$$ExternalSyntheticLambda7
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WiFiSettingsFragment.m508goBack$lambda6(WiFiSettingsFragment.this, (Boolean) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: goBack$lambda-6  reason: not valid java name */
    public static final void m508goBack$lambda6(WiFiSettingsFragment this$0, Boolean bool) {
        String str;
        String str2;
        String str3;
        String str4;
        String planName;
        String planName2;
        String planName3;
        String planName4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAdded()) {
            User user = LSApplication.Companion.getUser();
            if (user == null || (planName4 = user.getPlanName()) == null) {
                str = null;
            } else {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                str = planName4.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
            }
            if (!StringsKt.equals$default(str, "furlenco", false, 2, null)) {
                User user2 = LSApplication.Companion.getUser();
                if (user2 == null || (planName3 = user2.getPlanName()) == null) {
                    str2 = null;
                } else {
                    Locale locale2 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
                    str2 = planName3.toLowerCase(locale2);
                    Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(locale)");
                }
                if (!StringsKt.equals$default(str2, "rentmojo", false, 2, null)) {
                    User user3 = LSApplication.Companion.getUser();
                    if (user3 == null || (planName2 = user3.getPlanName()) == null) {
                        str3 = null;
                    } else {
                        Locale locale3 = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue(locale3, "getDefault()");
                        str3 = planName2.toLowerCase(locale3);
                        Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String).toLowerCase(locale)");
                    }
                    if (!StringsKt.equals$default(str3, "rentomojo", false, 2, null)) {
                        User user4 = LSApplication.Companion.getUser();
                        if (user4 == null || (planName = user4.getPlanName()) == null) {
                            str4 = null;
                        } else {
                            Locale locale4 = Locale.getDefault();
                            Intrinsics.checkNotNullExpressionValue(locale4, "getDefault()");
                            str4 = planName.toLowerCase(locale4);
                            Intrinsics.checkNotNullExpressionValue(str4, "this as java.lang.String).toLowerCase(locale)");
                        }
                        if (!StringsKt.equals$default(str4, "b2b", false, 2, null)) {
                            FragmentKt.findNavController(this$0).popBackStack(R.id.homeFragment, false);
                            return;
                        }
                    }
                }
            }
            FragmentKt.findNavController(this$0).popBackStack(R.id.homeFurlencoFragment, false);
        }
    }

    @Override // com.livpure.safedrink.bolt.api.WifiCommunicator
    public void respond(String str) {
        goBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupBluetooth() {
        String format;
        AnimProgressBar animProgressBar = this.animProgressBar;
        if (animProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            animProgressBar = null;
        }
        animProgressBar.show();
        if (Intrinsics.areEqual(getWiFiSettingsModel().getProductType(), "air-purifier")) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            format = String.format("%s-%s", Arrays.copyOf(new Object[]{"LIV-ARP", StringsKt.takeLast(getWiFiSettingsModel().getImeiNumber(), 4)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            format = String.format("%s-%s", Arrays.copyOf(new Object[]{"LIVSMT-RO", StringsKt.takeLast(getWiFiSettingsModel().getImeiNumber(), 4)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        }
        this.macIdAdd = format;
        this.listBluetoothDevice = new ArrayList<>();
        getBluetoothAdapter();
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapterWiFi;
        Boolean valueOf = bluetoothAdapter != null ? Boolean.valueOf(bluetoothAdapter.isEnabled()) : null;
        Intrinsics.checkNotNull(valueOf);
        if (!valueOf.booleanValue()) {
            startActivity(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));
            return;
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
        this.mBluetoothAdapterWiFi = ((BluetoothManager) systemService).getAdapter();
        this.mScanning = false;
    }

    private final void getBluetoothLeScanner() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapterWiFi;
        Intrinsics.checkNotNull(bluetoothAdapter);
        this.mBluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
    }

    private final void scanLeDevice() {
        if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_SCAN") == 0) {
            ArrayList<String> arrayList = this.listBluetoothDevice;
            Intrinsics.checkNotNull(arrayList);
            arrayList.clear();
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new WiFiSettingsFragment$scanLeDevice$1(this, null), 3, null);
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
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new WiFiSettingsFragment$scanLeDevice$2(this, null), 3, null);
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
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new WiFiSettingsFragment$connectWithBle$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeGattServices(List<? extends BluetoothGattService> list) {
        if (list == null) {
            return;
        }
        for (BluetoothGattService bluetoothGattService : list) {
            String uuid = bluetoothGattService.getUuid().toString();
            if (StringsKt.equals(uuid, BluetoothLeService.Companion.getString_GENUINO101_SERVICE_READ(), true) || StringsKt.equals(uuid, BluetoothLeService.Companion.getString_GENUINO101_SERVICE_WRITE(), true)) {
                List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
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
                            this.mReadCharacteristic = bluetoothGattCharacteristic;
                            BluetoothGatt bluetoothGatt4 = this.mBluetoothGatt;
                            Intrinsics.checkNotNull(bluetoothGatt4);
                            bluetoothGatt4.readCharacteristic(bluetoothGattCharacteristic);
                        }
                        if ((properties & 8) > 0) {
                            this.mWriteCharacteristic = bluetoothGattCharacteristic;
                        }
                    }
                } else if (Build.VERSION.SDK_INT >= 31) {
                    ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
                } else {
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : characteristics) {
                        int properties2 = bluetoothGattCharacteristic2.getProperties();
                        if ((properties2 | 2) > 0) {
                            if (this.mNotifyCharacteristic != null) {
                                BluetoothGatt bluetoothGatt5 = this.mBluetoothGatt;
                                Intrinsics.checkNotNull(bluetoothGatt5);
                                bluetoothGatt5.setCharacteristicNotification(this.mNotifyCharacteristic, true);
                            }
                            this.mReadCharacteristic = bluetoothGattCharacteristic2;
                            BluetoothGatt bluetoothGatt6 = this.mBluetoothGatt;
                            Intrinsics.checkNotNull(bluetoothGatt6);
                            bluetoothGatt6.readCharacteristic(bluetoothGattCharacteristic2);
                        }
                        if ((properties2 | 16) > 0) {
                            this.mNotifyCharacteristic = bluetoothGattCharacteristic2;
                            BluetoothGatt bluetoothGatt7 = this.mBluetoothGatt;
                            Intrinsics.checkNotNull(bluetoothGatt7);
                            bluetoothGatt7.setCharacteristicNotification(bluetoothGattCharacteristic2, true);
                            this.mReadCharacteristic = bluetoothGattCharacteristic2;
                            BluetoothGatt bluetoothGatt8 = this.mBluetoothGatt;
                            Intrinsics.checkNotNull(bluetoothGatt8);
                            bluetoothGatt8.readCharacteristic(bluetoothGattCharacteristic2);
                        }
                        if ((properties2 & 8) > 0) {
                            this.mWriteCharacteristic = bluetoothGattCharacteristic2;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayData(String str) {
        String decrypt;
        String decrypt2;
        if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            if (str != null) {
                try {
                    if (StringsKt.startsWith$default(str, "{", false, 2, (Object) null)) {
                        return;
                    }
                    if (StringsKt.lines(str).size() != 30 && str.length() <= 1199) {
                        List<String> lines = StringsKt.lines(str);
                        String str2 = lines.get(lines.size() - 1);
                        if (str2.length() == 40) {
                            String decrypt3 = Base64Hex.decrypt(StringsKt.take(str2, 32), AppConstants.BEL_ENC_KEY);
                            Intrinsics.checkNotNullExpressionValue(decrypt3, "decrypt(hexDataReceived.…AppConstants.BEL_ENC_KEY)");
                            decrypt2 = decrypt3 + "0\"}";
                        } else {
                            decrypt2 = Base64Hex.decrypt(str2, AppConstants.BEL_ENC_KEY);
                            Intrinsics.checkNotNullExpressionValue(decrypt2, "decrypt(hexDataReceived, AppConstants.BEL_ENC_KEY)");
                        }
                        if (!StringsKt.contains$default((CharSequence) decrypt2, (CharSequence) "\"LC\"", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) decrypt2, (CharSequence) "\"FR\"", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) decrypt2, (CharSequence) "\"ST\"", false, 2, (Object) null)) {
                            if (StringsKt.contains$default((CharSequence) decrypt2, (CharSequence) "\"WIFI\"", false, 2, (Object) null)) {
                                Handler handler = this.handler;
                                Intrinsics.checkNotNull(handler);
                                Runnable runnable = this.myScanRunnable;
                                Intrinsics.checkNotNull(runnable);
                                handler.removeCallbacks(runnable);
                                AnimProgressBar animProgressBar = this.animProgressBar;
                                if (animProgressBar == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                                    animProgressBar = null;
                                }
                                animProgressBar.dismiss();
                                this.bleWiFICounter = 0;
                                AnimProgressBar animProgressBar2 = this.animProgressBar;
                                if (animProgressBar2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                                    animProgressBar2 = null;
                                }
                                animProgressBar2.dismiss();
                                JSONObject jSONObject = new JSONObject((String) StringsKt.split$default((CharSequence) decrypt2, new String[]{"\"WIFI\":"}, false, 0, 6, (Object) null).get(1));
                                getWiFiSettingsModel().getListOfWifiName().clear();
                                int length = jSONObject.length();
                                if (1 <= length) {
                                    int i = 1;
                                    while (true) {
                                        if (!Intrinsics.areEqual(jSONObject.getString(String.valueOf(i)), "")) {
                                            getWiFiSettingsModel().getListOfWifiName().add(jSONObject.getString(String.valueOf(i)));
                                        }
                                        if (i == length) {
                                            break;
                                        }
                                        i++;
                                    }
                                }
                                initializeViews();
                                return;
                            }
                            return;
                        }
                        if (!this.getWiFiCommandSent) {
                            this.getWiFiCommandSent = true;
                            this.bleWiFICounter = 0;
                            if (Intrinsics.areEqual(getWiFiSettingsModel().getProductType(), "air-purifier")) {
                                sendToBLEJsonData("{\"CMD\":\"IOT+CMD=16~\"}");
                                return;
                            } else {
                                sendToBLEJsonData("{\"CMD\":\"ARC+CMD=23~\"}");
                                return;
                            }
                        } else if (this.bleWiFICounter > 40) {
                            this.bleWiFICounter = 0;
                            AnimProgressBar animProgressBar3 = this.animProgressBar;
                            if (animProgressBar3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                                animProgressBar3 = null;
                            }
                            animProgressBar3.dismiss();
                            showDialog();
                            return;
                        } else {
                            return;
                        }
                    }
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new WiFiSettingsFragment$displayData$1(this, null), 3, null);
                } catch (Exception unused) {
                    if (this.getWiFiCommandSent) {
                        return;
                    }
                    this.getWiFiCommandSent = false;
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new WiFiSettingsFragment$displayData$2(this, null), 3, null);
                }
            }
        } else if (Build.VERSION.SDK_INT >= 31) {
            ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
        } else if (str != null) {
            try {
                if (StringsKt.startsWith$default(str, "{", false, 2, (Object) null)) {
                    return;
                }
                if (StringsKt.lines(str).size() != 30 && str.length() <= 1199) {
                    List<String> lines2 = StringsKt.lines(str);
                    String str3 = lines2.get(lines2.size() - 1);
                    if (str3.length() == 40) {
                        String decrypt4 = Base64Hex.decrypt(StringsKt.take(str3, 32), AppConstants.BEL_ENC_KEY);
                        Intrinsics.checkNotNullExpressionValue(decrypt4, "decrypt(hexDataReceived.…AppConstants.BEL_ENC_KEY)");
                        decrypt = decrypt4 + "0\"}";
                    } else {
                        decrypt = Base64Hex.decrypt(str3, AppConstants.BEL_ENC_KEY);
                        Intrinsics.checkNotNullExpressionValue(decrypt, "decrypt(hexDataReceived, AppConstants.BEL_ENC_KEY)");
                    }
                    Log.e("mrigendra", "wifi: " + decrypt);
                    if (!StringsKt.contains$default((CharSequence) decrypt, (CharSequence) "\"LC\"", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) decrypt, (CharSequence) "\"FR\"", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) decrypt, (CharSequence) "\"ST\"", false, 2, (Object) null)) {
                        if (StringsKt.contains$default((CharSequence) decrypt, (CharSequence) "\"WIFI\"", false, 2, (Object) null)) {
                            Handler handler2 = this.handler;
                            Intrinsics.checkNotNull(handler2);
                            Runnable runnable2 = this.myScanRunnable;
                            Intrinsics.checkNotNull(runnable2);
                            handler2.removeCallbacks(runnable2);
                            AnimProgressBar animProgressBar4 = this.animProgressBar;
                            if (animProgressBar4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                                animProgressBar4 = null;
                            }
                            animProgressBar4.dismiss();
                            this.bleWiFICounter = 0;
                            AnimProgressBar animProgressBar5 = this.animProgressBar;
                            if (animProgressBar5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                                animProgressBar5 = null;
                            }
                            animProgressBar5.dismiss();
                            JSONObject jSONObject2 = new JSONObject((String) StringsKt.split$default((CharSequence) decrypt, new String[]{"\"WIFI\":"}, false, 0, 6, (Object) null).get(1));
                            getWiFiSettingsModel().getListOfWifiName().clear();
                            int length2 = jSONObject2.length();
                            if (1 <= length2) {
                                int i2 = 1;
                                while (true) {
                                    if (!Intrinsics.areEqual(jSONObject2.getString(String.valueOf(i2)), "")) {
                                        getWiFiSettingsModel().getListOfWifiName().add(jSONObject2.getString(String.valueOf(i2)));
                                    }
                                    if (i2 == length2) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            initializeViews();
                            return;
                        }
                        return;
                    }
                    if (!this.getWiFiCommandSent) {
                        this.getWiFiCommandSent = true;
                        this.bleWiFICounter = 0;
                        if (Intrinsics.areEqual(getWiFiSettingsModel().getProductType(), "air-purifier")) {
                            sendToBLEJsonData("{\"CMD\":\"IOT+CMD=16~\"}");
                            return;
                        } else {
                            sendToBLEJsonData("{\"CMD\":\"ARC+CMD=23~\"}");
                            return;
                        }
                    } else if (this.bleWiFICounter > 40) {
                        this.bleWiFICounter = 0;
                        AnimProgressBar animProgressBar6 = this.animProgressBar;
                        if (animProgressBar6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                            animProgressBar6 = null;
                        }
                        animProgressBar6.dismiss();
                        showDialog();
                        return;
                    } else {
                        return;
                    }
                }
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new WiFiSettingsFragment$displayData$3(this, null), 3, null);
            } catch (Exception unused2) {
                if (this.getWiFiCommandSent) {
                    return;
                }
                this.getWiFiCommandSent = false;
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new WiFiSettingsFragment$displayData$4(this, null), 3, null);
            }
        }
    }

    private final void sendToBLEJsonData(String str) {
        Log.e("mrigendra", "wifi: " + str);
        AnimProgressBar animProgressBar = this.animProgressBar;
        if (animProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            animProgressBar = null;
        }
        animProgressBar.show();
        this.bleWiFICounter = 0;
        try {
            byte[] hexStringToByteArray = Encrypt.hexStringToByteArray(Encrypt.encrypt(str, AppConstants.BEL_ENC_KEY));
            Intrinsics.checkNotNullExpressionValue(hexStringToByteArray, "hexStringToByteArray(encriptedData)");
            if (Intrinsics.areEqual(publishWiFiToDevice(hexStringToByteArray), "succes")) {
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new WiFiSettingsFragment$sendToBLEJsonData$1(this, null), 3, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final String publishWiFiToDevice(byte[] bArr) {
        try {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.mWriteCharacteristic;
            if (bluetoothGattCharacteristic != null) {
                bluetoothGattCharacteristic.setValue(bArr);
            }
            BluetoothGattCharacteristic bluetoothGattCharacteristic2 = this.mWriteCharacteristic;
            if (bluetoothGattCharacteristic2 != null) {
                writeCharacteristic(bluetoothGattCharacteristic2);
            }
            return "succes";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public final String lookup(String str) {
        Object obj = this.attributes.get(str);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
        return (String) obj;
    }

    public final byte[] byteArrayOfInts(int... ints) {
        Intrinsics.checkNotNullParameter(ints, "ints");
        int length = ints.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) ints[i];
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String publishToDevice(String str) {
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
    public final void showDialog() {
        setBluetooth(false);
        Context context = getContext();
        final Dialog dialog = context != null ? new Dialog(context) : null;
        if (dialog != null) {
            dialog.requestWindowFeature(1);
        }
        if (dialog != null) {
            dialog.setContentView(R.layout.custome_dialog);
        }
        Window window = dialog != null ? dialog.getWindow() : null;
        Intrinsics.checkNotNull(window);
        window.setLayout(-1, -2);
        Window window2 = dialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setBackgroundDrawable(new ColorDrawable(0));
        dialog.show();
        Button button = (Button) dialog.findViewById(R.id.later_btn);
        Button button2 = (Button) dialog.findViewById(R.id.ok_btn);
        ((Button) dialog.findViewById(R.id.cancel_btn)).setVisibility(4);
        button2.setText(getString(R.string.refresh));
        button.setText(getString(R.string.ok));
        button2.setVisibility(4);
        ((TextView) dialog.findViewById(R.id.header)).setText(getString(R.string.wifi_list_refresh));
        String string = getString(R.string.switch_off_ro);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.switch_off_ro)");
        ((TextView) dialog.findViewById(R.id.msg_txt)).setText(StringsKt.trimIndent(string));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.bolt.view.WiFiSettingsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.bolt.view.WiFiSettingsFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WiFiSettingsFragment.m516showDialog$lambda14(WiFiSettingsFragment.this, dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDialog$lambda-14  reason: not valid java name */
    public static final void m516showDialog$lambda14(WiFiSettingsFragment this$0, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.bleWiFICounter = 0;
            this$0.disConnectBLE();
            BuildersKt__Builders_commonKt.launch$default(this$0, null, null, new WiFiSettingsFragment$showDialog$2$1(this$0, null), 3, null);
            dialog.dismiss();
        } catch (Exception e) {
            Log.e(AgentHealth.DEFAULT_KEY, e.toString());
        }
    }

    private final void disConnectBLE() {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean setBluetooth(boolean z) {
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
    public final void showToastMessage(String str) {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new WiFiSettingsFragment$showToastMessage$1(this, str, null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Job job = this.job;
        if (job == null) {
            Intrinsics.throwUninitializedPropertyAccessException("job");
            job = null;
        }
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        this.mBleConnected = false;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup group, int i) {
        Intrinsics.checkNotNullParameter(group, "group");
        this.wifiType = ((RadioButton) group.findViewById(i)).getText().toString();
        FragmentWifiSettingsBinding fragmentWifiSettingsBinding = this.wifiSettingsBinding;
        if (fragmentWifiSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wifiSettingsBinding");
            fragmentWifiSettingsBinding = null;
        }
        fragmentWifiSettingsBinding.setIsWifiRouter(Boolean.valueOf(StringsKt.equals$default(this.wifiType, "Wifi Router", false, 2, null)));
        this.ssidName = "";
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentWifiSettingsBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.wifiSettingsBinding = dataBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void publishCommandLoop() {
        this.myScanRunnable = new Runnable() { // from class: com.livpure.safedrink.bolt.view.WiFiSettingsFragment$publishCommandLoop$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                int i;
                BluetoothGatt bluetoothGatt;
                BluetoothGattCharacteristic bluetoothGattCharacteristic;
                String[] strArr;
                int i2;
                Handler handler;
                Runnable runnable;
                Handler handler2;
                Runnable runnable2;
                AnimProgressBar animProgressBar;
                BluetoothGatt bluetoothGatt2;
                BluetoothGattCharacteristic bluetoothGattCharacteristic2;
                try {
                    WiFiSettingsFragment wiFiSettingsFragment = WiFiSettingsFragment.this;
                    i = wiFiSettingsFragment.bleWiFICounter;
                    wiFiSettingsFragment.bleWiFICounter = i + 1;
                    if (ActivityCompat.checkSelfPermission(WiFiSettingsFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") != 0) {
                        if (Build.VERSION.SDK_INT >= 31) {
                            strArr = WiFiSettingsFragment.this.android12BlePermission;
                            ActivityCompat.requestPermissions(WiFiSettingsFragment.this.requireActivity(), strArr, 2);
                        } else {
                            bluetoothGatt = WiFiSettingsFragment.this.mBluetoothGatt;
                            Intrinsics.checkNotNull(bluetoothGatt);
                            bluetoothGattCharacteristic = WiFiSettingsFragment.this.mReadCharacteristic;
                            bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
                        }
                    } else {
                        bluetoothGatt2 = WiFiSettingsFragment.this.mBluetoothGatt;
                        Intrinsics.checkNotNull(bluetoothGatt2);
                        bluetoothGattCharacteristic2 = WiFiSettingsFragment.this.mReadCharacteristic;
                        bluetoothGatt2.readCharacteristic(bluetoothGattCharacteristic2);
                    }
                    i2 = WiFiSettingsFragment.this.bleWiFICounter;
                    if (i2 > 40) {
                        WiFiSettingsFragment.this.bleWiFICounter = 0;
                        handler2 = WiFiSettingsFragment.this.handler;
                        Intrinsics.checkNotNull(handler2);
                        runnable2 = WiFiSettingsFragment.this.myScanRunnable;
                        Intrinsics.checkNotNull(runnable2);
                        handler2.removeCallbacks(runnable2);
                        animProgressBar = WiFiSettingsFragment.this.animProgressBar;
                        if (animProgressBar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                            animProgressBar = null;
                        }
                        animProgressBar.dismiss();
                        WiFiSettingsFragment.this.showDialog();
                        return;
                    }
                    handler = WiFiSettingsFragment.this.handler;
                    Intrinsics.checkNotNull(handler);
                    runnable = WiFiSettingsFragment.this.myScanRunnable;
                    Intrinsics.checkNotNull(runnable);
                    handler.postDelayed(runnable, 1000L);
                } catch (Exception e) {
                    Log.e(AgentHealth.DEFAULT_KEY, e.toString());
                }
            }
        };
        Handler handler = this.handler;
        Intrinsics.checkNotNull(handler);
        Runnable runnable = this.myScanRunnable;
        Intrinsics.checkNotNull(runnable);
        handler.postDelayed(runnable, 1000L);
    }
}
