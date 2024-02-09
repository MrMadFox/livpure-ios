package com.livpure.safedrink.dispenser.view;

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
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.crashlytics.android.beta.BuildConfig;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import com.livpure.safedrink.bolt.data.models.RechargeResponse;
import com.livpure.safedrink.bolt.service.Base64Hex;
import com.livpure.safedrink.bolt.service.Encrypt;
import com.livpure.safedrink.common.UiUtilKt;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentAirtowaterBinding;
import com.livpure.safedrink.dispenser.model.HomeAirToWaterModel;
import com.livpure.safedrink.dispenser.view.HomeAirToWaterFragmentDirections;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.utils.AnimProgressBar;
import com.livpure.safedrink.utils.AppConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import kotlin.Pair;
import kotlin.Triple;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.json.JSONObject;
/* compiled from: HomeAirToWaterFragment.kt */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\nH\u0002J\u0010\u0010J\u001a\u00020H2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010K\u001a\u00020H2\u0006\u0010 \u001a\u00020\u0002H\u0016J\b\u0010L\u001a\u00020\fH\u0002J\b\u0010M\u001a\u00020HH\u0002J\b\u0010N\u001a\u00020HH\u0002J\u0012\u0010O\u001a\u00020H2\b\u0010P\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010Q\u001a\u00020HH\u0002J\b\u0010R\u001a\u00020HH\u0002J\b\u0010S\u001a\u00020HH\u0002J\b\u0010T\u001a\u00020\u0006H\u0014J\b\u0010U\u001a\u00020VH\u0014J\b\u0010W\u001a\u00020HH\u0002J\u0018\u0010X\u001a\u00020H2\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010ZH\u0002J\b\u0010\\\u001a\u00020HH\u0002J\u0010\u0010]\u001a\u00020\n2\b\u0010^\u001a\u0004\u0018\u00010\nJ\u0012\u0010_\u001a\u00020H2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\b\u0010b\u001a\u00020HH\u0016J\b\u0010c\u001a\u00020HH\u0002J\u001a\u0010d\u001a\u00020H2\u0006\u0010e\u001a\u00020f2\b\u0010`\u001a\u0004\u0018\u00010aH\u0017J\u0014\u0010g\u001a\u0004\u0018\u00010\n2\b\u0010h\u001a\u0004\u0018\u00010iH\u0002J\u0014\u0010j\u001a\u0004\u0018\u00010\n2\b\u0010h\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010k\u001a\u00020HH\u0002J\b\u0010l\u001a\u00020HH\u0002J\u0010\u0010m\u001a\u00020H2\u0006\u0010n\u001a\u00020\nH\u0002J\b\u0010o\u001a\u00020\fH\u0002J\u0014\u0010p\u001a\u0004\u0018\u00010\n2\b\u0010q\u001a\u0004\u0018\u000109H\u0002J\b\u0010r\u001a\u00020HH\u0003J\b\u0010s\u001a\u00020HH\u0002J,\u0010t\u001a\u00020H2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020\n0Z2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020w0Z2\u0006\u0010x\u001a\u00020\nH\u0002J\b\u0010y\u001a\u00020HH\u0002J\b\u0010z\u001a\u00020HH\u0002J\u0018\u0010{\u001a\u00020H2\u0006\u0010|\u001a\u00020\u00062\u0006\u0010}\u001a\u00020\nH\u0007J\b\u0010~\u001a\u00020HH\u0002J\u000e\u0010\u007f\u001a\u00020H2\u0006\u0010h\u001a\u00020\nJ\u0014\u0010\u0080\u0001\u001a\u00020H2\t\b\u0001\u0010\u0081\u0001\u001a\u00020\u0006H\u0002J\u0014\u0010\u0082\u0001\u001a\u00020H2\t\b\u0001\u0010\u0081\u0001\u001a\u00020\u0006H\u0002J\u001d\u0010\u0083\u0001\u001a\u00020H2\u0007\u0010\u0084\u0001\u001a\u00020\n2\t\b\u0001\u0010\u0081\u0001\u001a\u00020\u0006H\u0002J\t\u0010\u0085\u0001\u001a\u00020HH\u0002J\u0011\u0010\u0086\u0001\u001a\u00020H2\u0006\u0010q\u001a\u000209H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u00118\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R2\u0010\u0015\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0017`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\n0\u001aj\b\u0012\u0004\u0012\u00020\n`\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u000e\u0010)\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\"\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bA\u0010BR\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0087\u0001"}, d2 = {"Lcom/livpure/safedrink/dispenser/view/HomeAirToWaterFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentAirtowaterBinding;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "LOCATION_PERMISSION_CODE", "", "SCAN_PERIOD", "", "_hardwareVersion", "", "_isFirmwareUpdate", "", "_isHardwareUpdate", "_isSoftwareUpdate", "_softwareVersion", "android12BlePermission", "", "[Ljava/lang/String;", "animProgressBar", "Lcom/livpure/safedrink/utils/AnimProgressBar;", "attributes", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "bleCommandList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "dataBinding", AndroidContextPlugin.DEVICE_KEY, "Landroid/bluetooth/BluetoothDevice;", "homeAirToWaterModel", "Lcom/livpure/safedrink/dispenser/model/HomeAirToWaterModel;", "getHomeAirToWaterModel", "()Lcom/livpure/safedrink/dispenser/model/HomeAirToWaterModel;", "homeAirToWaterModel$delegate", "Lkotlin/Lazy;", "isDisconnected", "job", "Lkotlinx/coroutines/Job;", "listBluetoothDevice", "mBleConnected", "mBluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "mBluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "mBluetoothLeScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "mDeviceAddress", "mDeviceName", "mGattCallback", "Landroid/bluetooth/BluetoothGattCallback;", "mNotifyCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "mReadCharacteristic", "mReadCharacteristicTemp", "mScanning", "mWriteCharacteristic", "macIdAdd", "navArgs", "Lcom/livpure/safedrink/dispenser/view/HomeAirToWaterFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/dispenser/view/HomeAirToWaterFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "scanCallback", "Landroid/bluetooth/le/ScanCallback;", "CommandPublish", "", "command", "addBluetoothDevice", "bindVariablesToView", "checkIfLocationPermissionGranted", "connectWithBle", "disConnectBLE", "displayData", "data", "getBluetoothAdapter", "getBluetoothLeScanner", "getCommandList", "getLayoutId", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "heaterStatusChange", "initializeGattServices", "gattServices", "", "Landroid/bluetooth/BluetoothGattService;", "listeners", "lookup", AnalyticsAttribute.UUID_ATTRIBUTE, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "publishToDevice", "message", "", "publishToDeviceCommand", "quietModeStatusChange", "scanLeDevice", "sendToBLEJsonData", "value", "setBluetooth", "setCharData", "characteristic", "setupBluetooth", "setupDashboard", "setupUsageStats", "dates", "consumptionDataSetList", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "averageConsumptionMessage", "showAddLitersScreen", "showBoltSettingsScreen", "showOptionDialog", "mode", "hedding", "showPlanChangeAirScreen", "showToastMessage", "updateBleWiFiImage", "resId", "updateFilterLifeImage", "updateWaterRemainingView", "waterRemaining", "waterGenerationStatusChange", "writeCharacteristic", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeAirToWaterFragment extends DataBindingFragment<FragmentAirtowaterBinding> implements CoroutineScope {
    private boolean _isFirmwareUpdate;
    private boolean _isHardwareUpdate;
    private boolean _isSoftwareUpdate;
    private AnimProgressBar animProgressBar;
    private FragmentAirtowaterBinding dataBinding;
    private BluetoothDevice device;
    private boolean isDisconnected;
    private Job job;
    private ArrayList<String> listBluetoothDevice;
    private boolean mBleConnected;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothLeScanner mBluetoothLeScanner;
    private String mDeviceAddress;
    private String mDeviceName;
    private BluetoothGattCharacteristic mNotifyCharacteristic;
    private BluetoothGattCharacteristic mReadCharacteristic;
    private BluetoothGattCharacteristic mReadCharacteristicTemp;
    private boolean mScanning;
    private BluetoothGattCharacteristic mWriteCharacteristic;
    private final NavArgsLazy navArgs$delegate;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy homeAirToWaterModel$delegate = LazyKt.lazy(new Function0<HomeAirToWaterModel>() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$homeAirToWaterModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HomeAirToWaterModel invoke() {
            HomeAirToWaterFragmentArgs navArgs;
            HomeAirToWaterModel homeAirToWaterModel = (HomeAirToWaterModel) new ViewModelProvider(HomeAirToWaterFragment.this).get(HomeAirToWaterModel.class);
            navArgs = HomeAirToWaterFragment.this.getNavArgs();
            homeAirToWaterModel.setDevice(navArgs.getDevice());
            return homeAirToWaterModel;
        }
    });
    private final long SCAN_PERIOD = 10000;
    private final int LOCATION_PERMISSION_CODE = 2;
    private String macIdAdd = "";
    private String _hardwareVersion = "";
    private String _softwareVersion = "";
    private final String[] android12BlePermission = {"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
    private final ScanCallback scanCallback = new ScanCallback() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$scanCallback$1
        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            super.onScanResult(i, result);
            HomeAirToWaterFragment homeAirToWaterFragment = HomeAirToWaterFragment.this;
            BluetoothDevice device = result.getDevice();
            Intrinsics.checkNotNullExpressionValue(device, "result.device");
            homeAirToWaterFragment.addBluetoothDevice(device);
        }
    };
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$mGattCallback$1
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
            String[] strArr;
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            if (i2 == 0) {
                z = HomeAirToWaterFragment.this.isDisconnected;
                if (!z) {
                    HomeAirToWaterFragment.this.connectWithBle();
                }
                HomeAirToWaterFragment.this.mBleConnected = false;
            } else if (i2 != 2) {
            } else {
                if (ActivityCompat.checkSelfPermission(HomeAirToWaterFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    gatt.requestMtu(500);
                } else if (Build.VERSION.SDK_INT >= 31) {
                    strArr = HomeAirToWaterFragment.this.android12BlePermission;
                    ActivityCompat.requestPermissions(HomeAirToWaterFragment.this.requireActivity(), strArr, 2);
                } else {
                    gatt.requestMtu(500);
                }
                HomeAirToWaterFragment.this.isDisconnected = false;
                HomeAirToWaterFragment.this.mBleConnected = true;
                HomeAirToWaterFragment.this.getCommandList();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            String[] strArr;
            if (i2 == 0) {
                if (ActivityCompat.checkSelfPermission(HomeAirToWaterFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    Intrinsics.checkNotNull(bluetoothGatt);
                    bluetoothGatt.discoverServices();
                } else if (Build.VERSION.SDK_INT >= 31) {
                    strArr = HomeAirToWaterFragment.this.android12BlePermission;
                    ActivityCompat.requestPermissions(HomeAirToWaterFragment.this.requireActivity(), strArr, 2);
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
            if (ActivityCompat.checkSelfPermission(HomeAirToWaterFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                if (i != 0) {
                    gatt.discoverServices();
                    return;
                }
                HomeAirToWaterFragment homeAirToWaterFragment = HomeAirToWaterFragment.this;
                bluetoothGatt3 = homeAirToWaterFragment.mBluetoothGatt;
                homeAirToWaterFragment.initializeGattServices(bluetoothGatt3 != null ? bluetoothGatt3.getServices() : null);
                bluetoothGattCharacteristic3 = HomeAirToWaterFragment.this.mReadCharacteristic;
                if (bluetoothGattCharacteristic3 != null) {
                    bluetoothGatt4 = HomeAirToWaterFragment.this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt4);
                    bluetoothGattCharacteristic4 = HomeAirToWaterFragment.this.mReadCharacteristic;
                    bluetoothGatt4.readCharacteristic(bluetoothGattCharacteristic4);
                }
            } else if (Build.VERSION.SDK_INT >= 31) {
                strArr = HomeAirToWaterFragment.this.android12BlePermission;
                ActivityCompat.requestPermissions(HomeAirToWaterFragment.this.requireActivity(), strArr, 2);
            } else if (i != 0) {
                gatt.discoverServices();
            } else {
                HomeAirToWaterFragment homeAirToWaterFragment2 = HomeAirToWaterFragment.this;
                bluetoothGatt = homeAirToWaterFragment2.mBluetoothGatt;
                homeAirToWaterFragment2.initializeGattServices(bluetoothGatt != null ? bluetoothGatt.getServices() : null);
                bluetoothGattCharacteristic = HomeAirToWaterFragment.this.mReadCharacteristic;
                if (bluetoothGattCharacteristic != null) {
                    bluetoothGatt2 = HomeAirToWaterFragment.this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt2);
                    bluetoothGattCharacteristic2 = HomeAirToWaterFragment.this.mReadCharacteristic;
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
                charData = HomeAirToWaterFragment.this.setCharData(characteristic);
                BuildersKt__Builders_commonKt.launch$default(HomeAirToWaterFragment.this, null, null, new HomeAirToWaterFragment$mGattCallback$1$onCharacteristicRead$1(HomeAirToWaterFragment.this, charData, null), 3, null);
            }
        }
    };
    private final ArrayList<String> bleCommandList = new ArrayList<>();
    private final HashMap<Object, Object> attributes = new HashMap<>();

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
        return R.layout.fragment_airtowater;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public HomeAirToWaterFragment() {
        final HomeAirToWaterFragment homeAirToWaterFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(HomeAirToWaterFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$special$$inlined$navArgs$1
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

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeAirToWaterFragmentArgs getNavArgs() {
        return (HomeAirToWaterFragmentArgs) this.navArgs$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeAirToWaterModel getHomeAirToWaterModel() {
        return (HomeAirToWaterModel) this.homeAirToWaterModel$delegate.getValue();
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
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        listeners();
        this.animProgressBar = new AnimProgressBar(requireContext());
        getHomeAirToWaterModel().getDashboardDetails();
        setupDashboard();
    }

    private final void listeners() {
        FragmentAirtowaterBinding fragmentAirtowaterBinding = this.dataBinding;
        FragmentAirtowaterBinding fragmentAirtowaterBinding2 = null;
        if (fragmentAirtowaterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding = null;
        }
        fragmentAirtowaterBinding.settingsIV.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeAirToWaterFragment.m818listeners$lambda0(HomeAirToWaterFragment.this, view);
            }
        });
        FragmentAirtowaterBinding fragmentAirtowaterBinding3 = this.dataBinding;
        if (fragmentAirtowaterBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding3 = null;
        }
        fragmentAirtowaterBinding3.lytHotWaterId.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeAirToWaterFragment.m819listeners$lambda1(HomeAirToWaterFragment.this, view);
            }
        });
        FragmentAirtowaterBinding fragmentAirtowaterBinding4 = this.dataBinding;
        if (fragmentAirtowaterBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding4 = null;
        }
        fragmentAirtowaterBinding4.lytWaterGenerationId.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeAirToWaterFragment.m820listeners$lambda2(HomeAirToWaterFragment.this, view);
            }
        });
        FragmentAirtowaterBinding fragmentAirtowaterBinding5 = this.dataBinding;
        if (fragmentAirtowaterBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding5 = null;
        }
        fragmentAirtowaterBinding5.lytQuietModeId.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeAirToWaterFragment.m821listeners$lambda3(HomeAirToWaterFragment.this, view);
            }
        });
        FragmentAirtowaterBinding fragmentAirtowaterBinding6 = this.dataBinding;
        if (fragmentAirtowaterBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding6 = null;
        }
        fragmentAirtowaterBinding6.swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda26
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                HomeAirToWaterFragment.m822listeners$lambda4(HomeAirToWaterFragment.this);
            }
        });
        FragmentAirtowaterBinding fragmentAirtowaterBinding7 = this.dataBinding;
        if (fragmentAirtowaterBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding7 = null;
        }
        fragmentAirtowaterBinding7.renewPlan.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeAirToWaterFragment.m823listeners$lambda5(HomeAirToWaterFragment.this, view);
            }
        });
        FragmentAirtowaterBinding fragmentAirtowaterBinding8 = this.dataBinding;
        if (fragmentAirtowaterBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentAirtowaterBinding2 = fragmentAirtowaterBinding8;
        }
        fragmentAirtowaterBinding2.addLitres.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeAirToWaterFragment.m824listeners$lambda6(HomeAirToWaterFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-0  reason: not valid java name */
    public static final void m818listeners$lambda0(HomeAirToWaterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showBoltSettingsScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-1  reason: not valid java name */
    public static final void m819listeners$lambda1(HomeAirToWaterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showOptionDialog(1, "Hot Water");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-2  reason: not valid java name */
    public static final void m820listeners$lambda2(HomeAirToWaterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showOptionDialog(2, "Water Generation");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-3  reason: not valid java name */
    public static final void m821listeners$lambda3(HomeAirToWaterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showOptionDialog(3, "Quiet mode");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-4  reason: not valid java name */
    public static final void m822listeners$lambda4(HomeAirToWaterFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getHomeAirToWaterModel().getDashboardDetails();
        FragmentAirtowaterBinding fragmentAirtowaterBinding = null;
        if (this$0.mBleConnected) {
            try {
                if (ActivityCompat.checkSelfPermission(this$0.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    BluetoothGatt bluetoothGatt = this$0.mBluetoothGatt;
                    if (bluetoothGatt != null) {
                        bluetoothGatt.readCharacteristic(this$0.mReadCharacteristic);
                    }
                } else if (Build.VERSION.SDK_INT >= 31) {
                    ActivityCompat.requestPermissions(this$0.requireActivity(), this$0.android12BlePermission, 2);
                } else {
                    BluetoothGatt bluetoothGatt2 = this$0.mBluetoothGatt;
                    if (bluetoothGatt2 != null) {
                        bluetoothGatt2.readCharacteristic(this$0.mReadCharacteristic);
                    }
                }
            } catch (Exception e) {
                Log.e(AgentHealth.DEFAULT_KEY, e.toString());
            }
        } else {
            this$0.setBluetooth();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new HomeAirToWaterFragment$listeners$5$1(this$0, null), 3, null);
        }
        FragmentAirtowaterBinding fragmentAirtowaterBinding2 = this$0.dataBinding;
        if (fragmentAirtowaterBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentAirtowaterBinding = fragmentAirtowaterBinding2;
        }
        fragmentAirtowaterBinding.swipeToRefresh.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-5  reason: not valid java name */
    public static final void m823listeners$lambda5(HomeAirToWaterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showPlanChangeAirScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-6  reason: not valid java name */
    public static final void m824listeners$lambda6(HomeAirToWaterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showAddLitersScreen();
    }

    private final void showPlanChangeAirScreen() {
        disConnectBLE();
        DeviceList deviceList = getHomeAirToWaterModel().get_device();
        HomeAirToWaterFragmentDirections.ActionDispenserFragmentToSelectPlanChargeFragment actionDispenserFragmentToSelectPlanChargeFragment = deviceList != null ? HomeAirToWaterFragmentDirections.actionDispenserFragmentToSelectPlanChargeFragment(deviceList) : null;
        if (actionDispenserFragmentToSelectPlanChargeFragment != null) {
            FragmentKt.findNavController(this).navigate(actionDispenserFragmentToSelectPlanChargeFragment);
        }
    }

    private final void showAddLitersScreen() {
        disConnectBLE();
        DeviceList deviceList = getHomeAirToWaterModel().get_device();
        HomeAirToWaterFragmentDirections.ActionDispenserFragmentToAddLitresFagment actionDispenserFragmentToAddLitresFagment = deviceList != null ? HomeAirToWaterFragmentDirections.actionDispenserFragmentToAddLitresFagment(deviceList) : null;
        if (actionDispenserFragmentToAddLitresFagment != null) {
            FragmentKt.findNavController(this).navigate(actionDispenserFragmentToAddLitresFagment);
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentAirtowaterBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.dataBinding = dataBinding;
        dataBinding.setViewModel(getHomeAirToWaterModel());
    }

    private final void showBoltSettingsScreen() {
        disConnectBLE();
        DeviceList deviceList = getHomeAirToWaterModel().get_device();
        HomeAirToWaterFragmentDirections.ActionHomeDispenserFragmentBoltSettingsFragment actionHomeDispenserFragmentBoltSettingsFragment = deviceList != null ? HomeAirToWaterFragmentDirections.actionHomeDispenserFragmentBoltSettingsFragment(deviceList) : null;
        if (actionHomeDispenserFragmentBoltSettingsFragment != null) {
            FragmentKt.findNavController(this).navigate(actionHomeDispenserFragmentBoltSettingsFragment);
        }
    }

    private final void setupDashboard() {
        getHomeAirToWaterModel().getWaterRemaining().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda24
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m825setupDashboard$lambda10(HomeAirToWaterFragment.this, (Pair) obj);
            }
        });
        getHomeAirToWaterModel().getHardwareUpdate().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m826setupDashboard$lambda11(HomeAirToWaterFragment.this, (Boolean) obj);
            }
        });
        getHomeAirToWaterModel().getSoftwareUpdate().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m827setupDashboard$lambda12(HomeAirToWaterFragment.this, (Boolean) obj);
            }
        });
        getHomeAirToWaterModel().getHardwareVersion().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda20
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m828setupDashboard$lambda13(HomeAirToWaterFragment.this, (String) obj);
            }
        });
        getHomeAirToWaterModel().getSoftwareVersion().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda18
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m829setupDashboard$lambda14(HomeAirToWaterFragment.this, (String) obj);
            }
        });
        getHomeAirToWaterModel().getPlanDetails().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m830setupDashboard$lambda15(HomeAirToWaterFragment.this, (String) obj);
            }
        });
        getHomeAirToWaterModel().getFilterLifeImage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m831setupDashboard$lambda16(HomeAirToWaterFragment.this, (Integer) obj);
            }
        });
        getHomeAirToWaterModel().getUvImage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m832setupDashboard$lambda17(HomeAirToWaterFragment.this, (Integer) obj);
            }
        });
        getHomeAirToWaterModel().getLiveTemperature().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda15
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m833setupDashboard$lambda18(HomeAirToWaterFragment.this, (String) obj);
            }
        });
        getHomeAirToWaterModel().getLiveHumidity().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m834setupDashboard$lambda19(HomeAirToWaterFragment.this, (String) obj);
            }
        });
        getHomeAirToWaterModel().getColTankImage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m835setupDashboard$lambda20(HomeAirToWaterFragment.this, (Integer) obj);
            }
        });
        getHomeAirToWaterModel().getProductType().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda17
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m836setupDashboard$lambda21(HomeAirToWaterFragment.this, (String) obj);
            }
        });
        getHomeAirToWaterModel().getWaterGenerationStatusImage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda23
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m837setupDashboard$lambda22(HomeAirToWaterFragment.this, (Pair) obj);
            }
        });
        getHomeAirToWaterModel().getHeaterStatusImage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m838setupDashboard$lambda23(HomeAirToWaterFragment.this, (Integer) obj);
            }
        });
        getHomeAirToWaterModel().getQuietModeStatusImage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m839setupDashboard$lambda24(HomeAirToWaterFragment.this, (Integer) obj);
            }
        });
        getHomeAirToWaterModel().getUsageStats().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda25
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m840setupDashboard$lambda25(HomeAirToWaterFragment.this, (Triple) obj);
            }
        });
        getHomeAirToWaterModel().getLastSynchronizedDate().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda13
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m841setupDashboard$lambda26(HomeAirToWaterFragment.this, (String) obj);
            }
        });
        getHomeAirToWaterModel().getProductType().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda16
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m842setupDashboard$lambda27(HomeAirToWaterFragment.this, (String) obj);
            }
        });
        getHomeAirToWaterModel().getPlanName().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda19
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m843setupDashboard$lambda28(HomeAirToWaterFragment.this, (String) obj);
            }
        });
        getHomeAirToWaterModel().getPublishCommandStatus().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda21
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m844setupDashboard$lambda29(HomeAirToWaterFragment.this, (String) obj);
            }
        });
        if (setBluetooth()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new HomeAirToWaterFragment$setupDashboard$21(this, null), 3, null);
        }
        getCommandList();
        getHomeAirToWaterModel().getBoltCommandsResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m845setupDashboard$lambda30(HomeAirToWaterFragment.this, (BoltCommandsResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-10  reason: not valid java name */
    public static final void m825setupDashboard$lambda10(HomeAirToWaterFragment this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (((String) pair.getFirst()).length() != 6 || pair.getSecond() == null) {
            return;
        }
        Object second = pair.getSecond();
        Intrinsics.checkNotNull(second);
        this$0.updateWaterRemainingView((String) pair.getFirst(), ((Number) second).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-11  reason: not valid java name */
    public static final void m826setupDashboard$lambda11(HomeAirToWaterFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boolean booleanValue = it.booleanValue();
        this$0._isHardwareUpdate = booleanValue;
        if (booleanValue) {
            this$0._isFirmwareUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-12  reason: not valid java name */
    public static final void m827setupDashboard$lambda12(HomeAirToWaterFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boolean booleanValue = it.booleanValue();
        this$0._isSoftwareUpdate = booleanValue;
        if (booleanValue) {
            this$0._isFirmwareUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-13  reason: not valid java name */
    public static final void m828setupDashboard$lambda13(HomeAirToWaterFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._hardwareVersion = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-14  reason: not valid java name */
    public static final void m829setupDashboard$lambda14(HomeAirToWaterFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._softwareVersion = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-15  reason: not valid java name */
    public static final void m830setupDashboard$lambda15(HomeAirToWaterFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return;
        }
        FragmentAirtowaterBinding fragmentAirtowaterBinding = this$0.dataBinding;
        if (fragmentAirtowaterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding = null;
        }
        fragmentAirtowaterBinding.planDetails.setText(str2);
        if (this$0.isAdded()) {
            UserRepository.Companion companion = UserRepository.Companion;
            FragmentActivity requireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            companion.getInstance(requireActivity).setUser(LSApplication.Companion.getUser());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-16  reason: not valid java name */
    public static final void m831setupDashboard$lambda16(HomeAirToWaterFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null && it.intValue() == -1) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateFilterLifeImage(it.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-17  reason: not valid java name */
    public static final void m832setupDashboard$lambda17(HomeAirToWaterFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null && it.intValue() == -1) {
            return;
        }
        FragmentAirtowaterBinding fragmentAirtowaterBinding = this$0.dataBinding;
        if (fragmentAirtowaterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding = null;
        }
        ImageView imageView = fragmentAirtowaterBinding.uvStatusImage;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), it.intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-18  reason: not valid java name */
    public static final void m833setupDashboard$lambda18(HomeAirToWaterFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentAirtowaterBinding fragmentAirtowaterBinding = this$0.dataBinding;
        if (fragmentAirtowaterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding = null;
        }
        TextView textView = fragmentAirtowaterBinding.tvTemprature;
        textView.setText(str + (char) 8451);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-19  reason: not valid java name */
    public static final void m834setupDashboard$lambda19(HomeAirToWaterFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentAirtowaterBinding fragmentAirtowaterBinding = this$0.dataBinding;
        if (fragmentAirtowaterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding = null;
        }
        TextView textView = fragmentAirtowaterBinding.tvHumidity;
        textView.setText(str + '%');
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-20  reason: not valid java name */
    public static final void m835setupDashboard$lambda20(HomeAirToWaterFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentAirtowaterBinding fragmentAirtowaterBinding = this$0.dataBinding;
        if (fragmentAirtowaterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding = null;
        }
        ImageView imageView = fragmentAirtowaterBinding.coldTankImage;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), it.intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-21  reason: not valid java name */
    public static final void m836setupDashboard$lambda21(HomeAirToWaterFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentAirtowaterBinding fragmentAirtowaterBinding = this$0.dataBinding;
        if (fragmentAirtowaterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding = null;
        }
        fragmentAirtowaterBinding.remainingWaterLabel.setText(R.string.total_water_generated);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-22  reason: not valid java name */
    public static final void m837setupDashboard$lambda22(HomeAirToWaterFragment this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentAirtowaterBinding fragmentAirtowaterBinding = this$0.dataBinding;
        FragmentAirtowaterBinding fragmentAirtowaterBinding2 = null;
        if (fragmentAirtowaterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding = null;
        }
        fragmentAirtowaterBinding.ivWaterGenerationImage.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), ((Number) pair.getFirst()).intValue()));
        FragmentAirtowaterBinding fragmentAirtowaterBinding3 = this$0.dataBinding;
        if (fragmentAirtowaterBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentAirtowaterBinding2 = fragmentAirtowaterBinding3;
        }
        fragmentAirtowaterBinding2.collectionTankImage.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), ((Number) pair.getSecond()).intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-23  reason: not valid java name */
    public static final void m838setupDashboard$lambda23(HomeAirToWaterFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentAirtowaterBinding fragmentAirtowaterBinding = this$0.dataBinding;
        if (fragmentAirtowaterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding = null;
        }
        ImageView imageView = fragmentAirtowaterBinding.ivHotWaterImage;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), it.intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-24  reason: not valid java name */
    public static final void m839setupDashboard$lambda24(HomeAirToWaterFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentAirtowaterBinding fragmentAirtowaterBinding = this$0.dataBinding;
        if (fragmentAirtowaterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding = null;
        }
        ImageView imageView = fragmentAirtowaterBinding.ivQuietModeImage;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), it.intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-25  reason: not valid java name */
    public static final void m840setupDashboard$lambda25(HomeAirToWaterFragment this$0, Triple triple) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Collection collection = (Collection) triple.getFirst();
        boolean z = false;
        if (collection == null || collection.isEmpty()) {
            return;
        }
        Collection collection2 = (Collection) triple.getSecond();
        if ((collection2 == null || collection2.isEmpty()) ? true : true) {
            return;
        }
        Object first = triple.getFirst();
        Intrinsics.checkNotNull(first);
        Object second = triple.getSecond();
        Intrinsics.checkNotNull(second);
        this$0.setupUsageStats((List) first, (List) second, (String) triple.getThird());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-26  reason: not valid java name */
    public static final void m841setupDashboard$lambda26(HomeAirToWaterFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = this$0.requireActivity().getString(R.string.last_synchronized_on) + SafeJsonPrimitive.NULL_CHAR + str;
        FragmentAirtowaterBinding fragmentAirtowaterBinding = this$0.dataBinding;
        if (fragmentAirtowaterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding = null;
        }
        fragmentAirtowaterBinding.lastSynchronized.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-27  reason: not valid java name */
    public static final void m842setupDashboard$lambda27(HomeAirToWaterFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = it.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, "zingerhotwaas")) {
            FragmentAirtowaterBinding fragmentAirtowaterBinding = this$0.dataBinding;
            if (fragmentAirtowaterBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentAirtowaterBinding = null;
            }
            fragmentAirtowaterBinding.addLitres.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-28  reason: not valid java name */
    public static final void m843setupDashboard$lambda28(HomeAirToWaterFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(str, "Bolt-Unlimited")) {
            FragmentAirtowaterBinding fragmentAirtowaterBinding = this$0.dataBinding;
            if (fragmentAirtowaterBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentAirtowaterBinding = null;
            }
            fragmentAirtowaterBinding.addLitres.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-29  reason: not valid java name */
    public static final void m844setupDashboard$lambda29(HomeAirToWaterFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str.equals("timeout")) {
            return;
        }
        AnimProgressBar animProgressBar = this$0.animProgressBar;
        if (animProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            animProgressBar = null;
        }
        animProgressBar.show();
        BuildersKt__Builders_commonKt.launch$default(this$0, null, null, new HomeAirToWaterFragment$setupDashboard$20$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-30  reason: not valid java name */
    public static final void m845setupDashboard$lambda30(HomeAirToWaterFragment this$0, BoltCommandsResponse boltCommandsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.bleCommandList.clear();
        this$0.bleCommandList.add(boltCommandsResponse.getRTC_Time());
        List<RechargeResponse> rechargeCommands = boltCommandsResponse.getRechargeCommands();
        Integer valueOf = rechargeCommands != null ? Integer.valueOf(rechargeCommands.size()) : null;
        Intrinsics.checkNotNull(valueOf);
        if (valueOf.intValue() > 0) {
            for (int i = 0; i < boltCommandsResponse.getRechargeCommands().size(); i++) {
                this$0.bleCommandList.add(boltCommandsResponse.getRechargeCommands().get(i).getRechargeList());
            }
        }
        if (boltCommandsResponse.getPullFiveRequest() == null || !boltCommandsResponse.getPullFiveRequest().booleanValue()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("PULL", "5");
            this$0.bleCommandList.add(jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void updateWaterRemainingView(String str, int i) {
        FragmentAirtowaterBinding fragmentAirtowaterBinding = this.dataBinding;
        FragmentAirtowaterBinding fragmentAirtowaterBinding2 = null;
        if (fragmentAirtowaterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding = null;
        }
        fragmentAirtowaterBinding.waterRemainingHundredThousands.setText(String.valueOf(str.charAt(0)));
        FragmentAirtowaterBinding fragmentAirtowaterBinding3 = this.dataBinding;
        if (fragmentAirtowaterBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding3 = null;
        }
        fragmentAirtowaterBinding3.waterRemainingTenThousands.setText(String.valueOf(str.charAt(1)));
        FragmentAirtowaterBinding fragmentAirtowaterBinding4 = this.dataBinding;
        if (fragmentAirtowaterBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding4 = null;
        }
        fragmentAirtowaterBinding4.waterRemainingThousands.setText(String.valueOf(str.charAt(2)));
        FragmentAirtowaterBinding fragmentAirtowaterBinding5 = this.dataBinding;
        if (fragmentAirtowaterBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding5 = null;
        }
        fragmentAirtowaterBinding5.waterRemainingHundreds.setText(String.valueOf(str.charAt(3)));
        FragmentAirtowaterBinding fragmentAirtowaterBinding6 = this.dataBinding;
        if (fragmentAirtowaterBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding6 = null;
        }
        fragmentAirtowaterBinding6.waterRemainingTens.setText(String.valueOf(str.charAt(4)));
        FragmentAirtowaterBinding fragmentAirtowaterBinding7 = this.dataBinding;
        if (fragmentAirtowaterBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding7 = null;
        }
        fragmentAirtowaterBinding7.waterRemainingOnes.setText(String.valueOf(str.charAt(5)));
        FragmentAirtowaterBinding fragmentAirtowaterBinding8 = this.dataBinding;
        if (fragmentAirtowaterBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentAirtowaterBinding2 = fragmentAirtowaterBinding8;
        }
        fragmentAirtowaterBinding2.waterDispenseUsageImage.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
    }

    private final void updateFilterLifeImage(int i) {
        FragmentAirtowaterBinding fragmentAirtowaterBinding = this.dataBinding;
        if (fragmentAirtowaterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding = null;
        }
        fragmentAirtowaterBinding.filterLifeImage.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
    }

    private final void setupUsageStats(List<String> list, List<? extends IBarDataSet> list2, String str) {
        FragmentAirtowaterBinding fragmentAirtowaterBinding = this.dataBinding;
        FragmentAirtowaterBinding fragmentAirtowaterBinding2 = null;
        if (fragmentAirtowaterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding = null;
        }
        Context context = fragmentAirtowaterBinding.barChart.getContext();
        Integer valueOf = context != null ? Integer.valueOf(UiUtilKt.getColorFromAttr$default(context, R.attr.colorOnSurface, null, false, 6, null)) : null;
        FragmentAirtowaterBinding fragmentAirtowaterBinding3 = this.dataBinding;
        if (fragmentAirtowaterBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding3 = null;
        }
        BarChart barChart = fragmentAirtowaterBinding3.barChart;
        barChart.setDescription("");
        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawLabels(true);
        if (valueOf != null) {
            xAxis.setTextColor(valueOf.intValue());
        }
        xAxis.setLabelRotationAngle(-45.0f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        if (valueOf != null) {
            barChart.getAxisLeft().setTextColor(valueOf.intValue());
        }
        barChart.getAxisRight().setEnabled(false);
        barChart.getAxisLeft().setSpaceBottom(0.0f);
        barChart.setScaleEnabled(false);
        barChart.setDoubleTapToZoomEnabled(false);
        barChart.setPinchZoom(false);
        barChart.getLegend().setEnabled(false);
        barChart.setData(new BarData(list, (List<IBarDataSet>) list2));
        if (valueOf != null) {
            ((BarData) barChart.getData()).setValueTextColor(valueOf.intValue());
        }
        ((BarData) barChart.getData()).setHighlightEnabled(false);
        barChart.animateXY(2000, 2000);
        barChart.invalidate();
        FragmentAirtowaterBinding fragmentAirtowaterBinding4 = this.dataBinding;
        if (fragmentAirtowaterBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentAirtowaterBinding2 = fragmentAirtowaterBinding4;
        }
        fragmentAirtowaterBinding2.averageWaterConsumption.setText(StringsKt.replace$default(str, "Average Water Consumption in a Week", "Average Water Generation in a Week", false, 4, (Object) null));
    }

    private final void heaterStatusChange() {
        AnimProgressBar animProgressBar = this.animProgressBar;
        AnimProgressBar animProgressBar2 = null;
        if (animProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            animProgressBar = null;
        }
        animProgressBar.show();
        if (this.mBleConnected) {
            String command = AppConstants.COMMAND_HEATER_ON;
            if (Intrinsics.areEqual(getHomeAirToWaterModel().getMenuHeaterStatus(), "ON")) {
                command = AppConstants.COMMAND_HEATER_OFF;
            }
            Intrinsics.checkNotNullExpressionValue(command, "command");
            CommandPublish(command);
            AnimProgressBar animProgressBar3 = this.animProgressBar;
            if (animProgressBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            } else {
                animProgressBar2 = animProgressBar3;
            }
            animProgressBar2.dismiss();
            return;
        }
        if (Intrinsics.areEqual(getHomeAirToWaterModel().getMenuHeaterStatus(), "ON")) {
            getHomeAirToWaterModel().publishCommand("07", "", "");
        } else {
            getHomeAirToWaterModel().publishCommand("06", "", "");
        }
        AnimProgressBar animProgressBar4 = this.animProgressBar;
        if (animProgressBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
        } else {
            animProgressBar2 = animProgressBar4;
        }
        animProgressBar2.dismiss();
    }

    private final void quietModeStatusChange() {
        AnimProgressBar animProgressBar = this.animProgressBar;
        AnimProgressBar animProgressBar2 = null;
        if (animProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            animProgressBar = null;
        }
        animProgressBar.show();
        if (this.mBleConnected) {
            String command = AppConstants.COMMAND_QUIET_MODE_ON;
            if (Intrinsics.areEqual(getHomeAirToWaterModel().getMenuQuietModeStatus(), "ON")) {
                command = AppConstants.COMMAND_QUIET_MODE_OFF;
            }
            Intrinsics.checkNotNullExpressionValue(command, "command");
            CommandPublish(command);
            AnimProgressBar animProgressBar3 = this.animProgressBar;
            if (animProgressBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            } else {
                animProgressBar2 = animProgressBar3;
            }
            animProgressBar2.dismiss();
            return;
        }
        if (Intrinsics.areEqual(getHomeAirToWaterModel().getMenuQuietModeStatus(), "ON")) {
            getHomeAirToWaterModel().publishCommand(BuildConfig.BUILD_NUMBER, "", "");
        } else {
            getHomeAirToWaterModel().publishCommand("26", "", "");
        }
        AnimProgressBar animProgressBar4 = this.animProgressBar;
        if (animProgressBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
        } else {
            animProgressBar2 = animProgressBar4;
        }
        animProgressBar2.dismiss();
    }

    private final void waterGenerationStatusChange() {
        if (!Intrinsics.areEqual(getHomeAirToWaterModel().getMenuWaterGenerationStatus(), "")) {
            AnimProgressBar animProgressBar = this.animProgressBar;
            AnimProgressBar animProgressBar2 = null;
            if (animProgressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                animProgressBar = null;
            }
            animProgressBar.show();
            if (this.mBleConnected) {
                String command = AppConstants.COMMAND_WATER_GENERATION_ON;
                if (Intrinsics.areEqual(getHomeAirToWaterModel().getMenuWaterGenerationStatus(), "ON")) {
                    command = AppConstants.COMMAND_WATER_GENERATION_OFF;
                }
                Intrinsics.checkNotNullExpressionValue(command, "command");
                CommandPublish(command);
                AnimProgressBar animProgressBar3 = this.animProgressBar;
                if (animProgressBar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                } else {
                    animProgressBar2 = animProgressBar3;
                }
                animProgressBar2.dismiss();
                return;
            }
            if (Intrinsics.areEqual(getHomeAirToWaterModel().getMenuWaterGenerationStatus(), "ON")) {
                getHomeAirToWaterModel().publishCommand("25", "", "");
            } else {
                getHomeAirToWaterModel().publishCommand("24", "", "");
            }
            AnimProgressBar animProgressBar4 = this.animProgressBar;
            if (animProgressBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            } else {
                animProgressBar2 = animProgressBar4;
            }
            animProgressBar2.dismiss();
            return;
        }
        Toast.makeText(getMContext(), "Water Generation Unfavourable Conditions", 0).show();
    }

    public final void showOptionDialog(final int i, String hedding) {
        Intrinsics.checkNotNullParameter(hedding, "hedding");
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        View inflate = getLayoutInflater().inflate(R.layout.air_to_water_bottomsheet, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(R…_water_bottomsheet, null)");
        bottomSheetDialog.setContentView(inflate);
        TextView textView = (TextView) bottomSheetDialog.findViewById(R.id.tvHeadding);
        TextView textView2 = (TextView) bottomSheetDialog.findViewById(R.id.tvlabel);
        final ImageView imageView = (ImageView) bottomSheetDialog.findViewById(R.id.switchButton);
        TextView textView3 = (TextView) bottomSheetDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(textView);
        String str = hedding;
        textView.setText(str);
        Intrinsics.checkNotNull(textView2);
        textView2.setText(str);
        if (i == 1) {
            getHomeAirToWaterModel().getLiveHeaterStatus().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeAirToWaterFragment.m846showOptionDialog$lambda33(imageView, this, (String) obj);
                }
            });
        } else if (i == 2) {
            getHomeAirToWaterModel().getLiveWaterGenerationStatus().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda32
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeAirToWaterFragment.m847showOptionDialog$lambda34(imageView, this, (String) obj);
                }
            });
        } else if (i == 3) {
            getHomeAirToWaterModel().getLiveQuietModeStatus().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda33
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeAirToWaterFragment.m848showOptionDialog$lambda35(imageView, this, (String) obj);
                }
            });
        }
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeAirToWaterFragment.m849showOptionDialog$lambda36(i, this, view);
                }
            });
        }
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeAirToWaterFragment.m850showOptionDialog$lambda37(BottomSheetDialog.this, view);
                }
            });
        }
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showOptionDialog$lambda-33  reason: not valid java name */
    public static final void m846showOptionDialog$lambda33(ImageView imageView, HomeAirToWaterFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(str, "ON")) {
            if (imageView != null) {
                imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), R.drawable.ic_switch_on));
            }
        } else if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), R.drawable.ic_switch_off));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showOptionDialog$lambda-34  reason: not valid java name */
    public static final void m847showOptionDialog$lambda34(ImageView imageView, HomeAirToWaterFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(str, "ON")) {
            if (imageView != null) {
                imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), R.drawable.ic_switch_on));
            }
        } else if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), R.drawable.ic_switch_off));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showOptionDialog$lambda-35  reason: not valid java name */
    public static final void m848showOptionDialog$lambda35(ImageView imageView, HomeAirToWaterFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(str, "ON")) {
            if (imageView != null) {
                imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), R.drawable.ic_switch_on));
            }
        } else if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), R.drawable.ic_switch_off));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showOptionDialog$lambda-36  reason: not valid java name */
    public static final void m849showOptionDialog$lambda36(int i, HomeAirToWaterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == 1) {
            this$0.heaterStatusChange();
        } else if (i == 2) {
            this$0.waterGenerationStatusChange();
        } else if (i != 3) {
        } else {
            this$0.quietModeStatusChange();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showOptionDialog$lambda-37  reason: not valid java name */
    public static final void m850showOptionDialog$lambda37(BottomSheetDialog dialoglog, View view) {
        Intrinsics.checkNotNullParameter(dialoglog, "$dialoglog");
        dialoglog.dismiss();
    }

    private final void CommandPublish(String str) {
        try {
            if (Intrinsics.areEqual(publishToDeviceCommand(str), "succes")) {
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeAirToWaterFragment$CommandPublish$1(this, null), 3, null);
            }
        } catch (Exception e) {
            Log.e(AgentHealth.DEFAULT_KEY, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupBluetooth() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s-%s", Arrays.copyOf(new Object[]{"LIVSMT-RO", StringsKt.takeLast(getHomeAirToWaterModel().getImeiNumber(), 4)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        this.macIdAdd = format;
        this.listBluetoothDevice = new ArrayList<>();
        getBluetoothAdapter();
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
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
        this.mBluetoothAdapter = ((BluetoothManager) systemService).getAdapter();
        this.mScanning = false;
    }

    private final void getBluetoothLeScanner() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        Intrinsics.checkNotNull(bluetoothAdapter);
        this.mBluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
    }

    private final void scanLeDevice() {
        if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_SCAN") == 0) {
            ArrayList<String> arrayList = this.listBluetoothDevice;
            Intrinsics.checkNotNull(arrayList);
            arrayList.clear();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HomeAirToWaterFragment$scanLeDevice$1(this, null), 3, null);
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
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HomeAirToWaterFragment$scanLeDevice$2(this, null), 3, null);
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
                    if (StringsKt.startsWith$default(name, "LIVSMT-RO", false, 2, (Object) null)) {
                        String name2 = bluetoothDevice.getName();
                        ArrayList<String> arrayList = this.listBluetoothDevice;
                        Intrinsics.checkNotNull(arrayList);
                        if (arrayList.contains(name2)) {
                            return;
                        }
                        ArrayList<String> arrayList2 = this.listBluetoothDevice;
                        Intrinsics.checkNotNull(arrayList2);
                        arrayList2.add(name2);
                        if (StringsKt.equals(this.macIdAdd, name2, true)) {
                            this.mDeviceAddress = bluetoothDevice.getAddress();
                            this.mDeviceName = bluetoothDevice.getName();
                            this.device = bluetoothDevice;
                            connectWithBle();
                        }
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 31) {
                ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
            } else if (bluetoothDevice.getName() != null) {
                String name3 = bluetoothDevice.getName();
                Intrinsics.checkNotNullExpressionValue(name3, "device.name");
                if (StringsKt.startsWith$default(name3, "LIVSMT-RO", false, 2, (Object) null)) {
                    String name4 = bluetoothDevice.getName();
                    ArrayList<String> arrayList3 = this.listBluetoothDevice;
                    Intrinsics.checkNotNull(arrayList3);
                    if (arrayList3.contains(name4)) {
                        return;
                    }
                    ArrayList<String> arrayList4 = this.listBluetoothDevice;
                    Intrinsics.checkNotNull(arrayList4);
                    arrayList4.add(name4);
                    if (StringsKt.equals(this.macIdAdd, name4, true)) {
                        this.mDeviceAddress = bluetoothDevice.getAddress();
                        this.mDeviceName = bluetoothDevice.getName();
                        this.device = bluetoothDevice;
                        connectWithBle();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connectWithBle() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeAirToWaterFragment$connectWithBle$1(this, null), 3, null);
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
    public final void initializeGattServices(List<? extends BluetoothGattService> list) {
        if (list != null) {
            for (BluetoothGattService bluetoothGattService : list) {
                List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                        this.mReadCharacteristicTemp = bluetoothGattCharacteristic;
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
                } else if (Build.VERSION.SDK_INT >= 31) {
                    ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
                } else {
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : characteristics) {
                        this.mReadCharacteristicTemp = bluetoothGattCharacteristic2;
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
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        disConnectBLE();
        Job job = this.job;
        if (job == null) {
            Intrinsics.throwUninitializedPropertyAccessException("job");
            job = null;
        }
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        this.isDisconnected = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCommandList() {
        getHomeAirToWaterModel().getPendingBleCommand();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayData(String str) {
        List<String> lines;
        String decrypt;
        List<String> lines2;
        String decrypt2;
        getHomeAirToWaterModel().getBleImage().observe(this, new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirToWaterFragment.m817displayData$lambda38(HomeAirToWaterFragment.this, (Integer) obj);
            }
        });
        if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            if (str != null) {
                try {
                    if (StringsKt.startsWith$default(str, "{", false, 2, (Object) null)) {
                        return;
                    }
                    String str2 = StringsKt.lines(str).get(lines2.size() - 1);
                    if (StringsKt.lines(str).size() != 30 && str2.length() <= 1199.0f) {
                        if (str2.length() == 40) {
                            String decrypt3 = Base64Hex.decrypt(StringsKt.take(str2, 32), AppConstants.BEL_ENC_KEY);
                            Intrinsics.checkNotNullExpressionValue(decrypt3, "decrypt(hexDataReceived.…AppConstants.BEL_ENC_KEY)");
                            decrypt2 = decrypt3 + "0\"}";
                        } else {
                            decrypt2 = Base64Hex.decrypt(str2, AppConstants.BEL_ENC_KEY);
                            Intrinsics.checkNotNullExpressionValue(decrypt2, "decrypt(hexDataReceived, AppConstants.BEL_ENC_KEY)");
                        }
                        JSONObject jSONObject = new JSONObject(decrypt2);
                        HomeAirToWaterModel homeAirToWaterModel = getHomeAirToWaterModel();
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonData.toString()");
                        homeAirToWaterModel.bleStatus(jSONObject2);
                        if (this.bleCommandList.size() > 0) {
                            String str3 = this.bleCommandList.get(0);
                            Intrinsics.checkNotNullExpressionValue(str3, "bleCommandList[0]");
                            sendToBLEJsonData(str3);
                            this.bleCommandList.remove(0);
                            return;
                        }
                        String jSONObject3 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonData.toString()");
                        if (StringsKt.contains$default((CharSequence) jSONObject3, (CharSequence) "\"LC\"", false, 2, (Object) null)) {
                            BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
                            Intrinsics.checkNotNull(bluetoothGatt);
                            bluetoothGatt.readCharacteristic(this.mReadCharacteristic);
                            return;
                        }
                        String jSONObject4 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject4, "jsonData.toString()");
                        if (StringsKt.contains$default((CharSequence) jSONObject4, (CharSequence) "GRTC", false, 2, (Object) null)) {
                            BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeAirToWaterFragment$displayData$3(this, null), 3, null);
                            return;
                        }
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeAirToWaterFragment$displayData$2(this, null), 3, null);
                } catch (Exception unused) {
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeAirToWaterFragment$displayData$4(this, null), 3, null);
                }
            }
        } else if (Build.VERSION.SDK_INT >= 31) {
            ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
        } else if (str != null) {
            try {
                if (StringsKt.startsWith$default(str, "{", false, 2, (Object) null)) {
                    return;
                }
                String str4 = StringsKt.lines(str).get(lines.size() - 1);
                if (StringsKt.lines(str).size() != 30 && str4.length() <= 1199.0f) {
                    if (str4.length() == 40) {
                        String decrypt4 = Base64Hex.decrypt(StringsKt.take(str4, 32), AppConstants.BEL_ENC_KEY);
                        Intrinsics.checkNotNullExpressionValue(decrypt4, "decrypt(hexDataReceived.…AppConstants.BEL_ENC_KEY)");
                        decrypt = decrypt4 + "0\"}";
                    } else {
                        decrypt = Base64Hex.decrypt(str4, AppConstants.BEL_ENC_KEY);
                        Intrinsics.checkNotNullExpressionValue(decrypt, "decrypt(hexDataReceived, AppConstants.BEL_ENC_KEY)");
                    }
                    JSONObject jSONObject5 = new JSONObject(decrypt);
                    HomeAirToWaterModel homeAirToWaterModel2 = getHomeAirToWaterModel();
                    String jSONObject6 = jSONObject5.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject6, "jsonData.toString()");
                    homeAirToWaterModel2.bleStatus(jSONObject6);
                    if (this.bleCommandList.size() > 0) {
                        String str5 = this.bleCommandList.get(0);
                        Intrinsics.checkNotNullExpressionValue(str5, "bleCommandList[0]");
                        sendToBLEJsonData(str5);
                        this.bleCommandList.remove(0);
                        return;
                    }
                    String jSONObject7 = jSONObject5.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject7, "jsonData.toString()");
                    if (StringsKt.contains$default((CharSequence) jSONObject7, (CharSequence) "\"LC\"", false, 2, (Object) null)) {
                        BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
                        Intrinsics.checkNotNull(bluetoothGatt2);
                        bluetoothGatt2.readCharacteristic(this.mReadCharacteristic);
                        return;
                    }
                    String jSONObject8 = jSONObject5.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject8, "jsonData.toString()");
                    if (StringsKt.contains$default((CharSequence) jSONObject8, (CharSequence) "GRTC", false, 2, (Object) null)) {
                        BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeAirToWaterFragment$displayData$6(this, null), 3, null);
                        return;
                    }
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeAirToWaterFragment$displayData$5(this, null), 3, null);
            } catch (Exception unused2) {
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeAirToWaterFragment$displayData$7(this, null), 3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: displayData$lambda-38  reason: not valid java name */
    public static final void m817displayData$lambda38(HomeAirToWaterFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateBleWiFiImage(it.intValue());
    }

    public final String lookup(String str) {
        Object obj = this.attributes.get(str);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
        return (String) obj;
    }

    private final String publishToDevice(byte[] bArr) {
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

    private final String publishToDeviceCommand(String str) {
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
        return ContextCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private final void onRequestPermissionsResult() {
        ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this.LOCATION_PERMISSION_CODE);
    }

    private final void sendToBLEJsonData(String str) {
        try {
            byte[] hexStringToByteArray = Encrypt.hexStringToByteArray(Encrypt.encrypt(str, AppConstants.BEL_ENC_KEY));
            Intrinsics.checkNotNullExpressionValue(hexStringToByteArray, "hexStringToByteArray(encriptedData)");
            if (Intrinsics.areEqual(publishToDevice(hexStringToByteArray), "succes")) {
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeAirToWaterFragment$sendToBLEJsonData$1(this, null), 3, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void updateBleWiFiImage(int i) {
        FragmentAirtowaterBinding fragmentAirtowaterBinding = this.dataBinding;
        if (fragmentAirtowaterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentAirtowaterBinding = null;
        }
        fragmentAirtowaterBinding.bleInfoIV.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
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

    private final boolean setBluetooth() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean isEnabled = defaultAdapter.isEnabled();
        if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            if (isEnabled) {
                return true;
            }
            return defaultAdapter.enable();
        } else if (Build.VERSION.SDK_INT >= 31) {
            ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
            return true;
        } else if (isEnabled) {
            return true;
        } else {
            return defaultAdapter.enable();
        }
    }

    public final void showToastMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeAirToWaterFragment$showToastMessage$1(null), 3, null);
    }
}
