package com.livpure.safedrink.dispenser.view;

import android.app.Activity;
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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.android.material.bottomnavigation.BottomNavigationView;
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
import com.livpure.safedrink.databinding.FragmentHomeDispenserMagnaBinding;
import com.livpure.safedrink.dispenser.model.HomeDispenserModel;
import com.livpure.safedrink.dispenser.view.HomeDispenserFragmentDirections;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.segment.SegmentLogger;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.utils.AnimProgressBar;
import com.livpure.safedrink.utils.AppConstants;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
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
/* compiled from: HomeDispenserFragment.kt */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\bH\u0002J\u0018\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\bH\u0002J\u0010\u0010P\u001a\u00020M2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010Q\u001a\u00020M2\u0006\u0010%\u001a\u00020\u0002H\u0016J\b\u0010R\u001a\u00020\u0010H\u0002J\b\u0010S\u001a\u00020MH\u0002J\b\u0010T\u001a\u00020MH\u0002J\u0012\u0010U\u001a\u00020M2\b\u0010V\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010W\u001a\u00020MH\u0002J\b\u0010X\u001a\u00020MH\u0002J\b\u0010Y\u001a\u00020MH\u0002J\b\u0010Z\u001a\u00020\u000bH\u0014J\b\u0010[\u001a\u00020\\H\u0014J\u0018\u0010]\u001a\u00020M2\u000e\u0010^\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010_H\u0002J\b\u0010a\u001a\u00020MH\u0002J\u0010\u0010b\u001a\u00020\b2\b\u0010c\u001a\u0004\u0018\u00010\bJ\u0010\u0010d\u001a\u00020M2\u0006\u0010e\u001a\u00020fH\u0016J\u0012\u0010g\u001a\u00020M2\b\u0010h\u001a\u0004\u0018\u00010iH\u0016J\b\u0010j\u001a\u00020MH\u0016J\u0010\u0010k\u001a\u00020\u00102\u0006\u0010l\u001a\u00020mH\u0016J\b\u0010n\u001a\u00020MH\u0002J\u001a\u0010o\u001a\u00020M2\u0006\u0010p\u001a\u00020q2\b\u0010h\u001a\u0004\u0018\u00010iH\u0017J\b\u0010r\u001a\u00020MH\u0002J\u0014\u0010s\u001a\u0004\u0018\u00010\b2\b\u0010t\u001a\u0004\u0018\u00010uH\u0002J\u0014\u0010v\u001a\u0004\u0018\u00010\b2\b\u0010t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010w\u001a\u00020MH\u0002J\u0010\u0010x\u001a\u00020M2\u0006\u0010y\u001a\u00020\u000bH\u0002J\u0010\u0010z\u001a\u00020M2\u0006\u0010{\u001a\u00020\bH\u0002J\b\u0010|\u001a\u00020\u0010H\u0002J\u0014\u0010}\u001a\u0004\u0018\u00010\b2\b\u0010~\u001a\u0004\u0018\u00010>H\u0002J\b\u0010\u007f\u001a\u00020MH\u0002J\t\u0010\u0080\u0001\u001a\u00020MH\u0002J1\u0010\u0081\u0001\u001a\u00020M2\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\b0_2\u000e\u0010\u0083\u0001\u001a\t\u0012\u0005\u0012\u00030\u0084\u00010_2\u0007\u0010\u0085\u0001\u001a\u00020\bH\u0002J\t\u0010\u0086\u0001\u001a\u00020MH\u0002J\t\u0010\u0087\u0001\u001a\u00020MH\u0002J\u0012\u0010\u0088\u0001\u001a\u00020M2\u0007\u0010\u0089\u0001\u001a\u00020\bH\u0002J\t\u0010\u008a\u0001\u001a\u00020MH\u0002J\t\u0010\u008b\u0001\u001a\u00020MH\u0002J\u0014\u0010\u008c\u0001\u001a\u00020M2\t\b\u0001\u0010\u008d\u0001\u001a\u00020\u000bH\u0002J\u0014\u0010\u008e\u0001\u001a\u00020M2\t\b\u0001\u0010\u008d\u0001\u001a\u00020\u000bH\u0002J\u001d\u0010\u008f\u0001\u001a\u00020M2\u0007\u0010\u0090\u0001\u001a\u00020\b2\t\b\u0001\u0010\u008d\u0001\u001a\u00020\u000bH\u0002J\u0011\u0010\u0091\u0001\u001a\u00020M2\u0006\u0010~\u001a\u00020>H\u0002R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\u000e\u0010.\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u0016\u00101\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010D\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bF\u0010GR\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0092\u0001"}, d2 = {"Lcom/livpure/safedrink/dispenser/view/HomeDispenserFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentHomeDispenserMagnaBinding;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/google/android/material/bottomnavigation/BottomNavigationView$OnNavigationItemSelectedListener;", "()V", "ANDROID_12_BLE_PERMISSIONS", "", "", "[Ljava/lang/String;", "LOCATION_PERMISSION_CODE", "", "SCAN_PERIOD", "", "_hardwareVersion", "_isFirmwareUpdate", "", "_isHardwareUpdate", "_isSoftwareUpdate", "_softwareVersion", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "animProgressBar", "Lcom/livpure/safedrink/utils/AnimProgressBar;", "attributes", "Ljava/util/HashMap;", "", "bleCommandList", "Ljava/util/ArrayList;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "dataBinding", AndroidContextPlugin.DEVICE_KEY, "Landroid/bluetooth/BluetoothDevice;", "homeDispenserViewModel", "Lcom/livpure/safedrink/dispenser/model/HomeDispenserModel;", "getHomeDispenserViewModel", "()Lcom/livpure/safedrink/dispenser/model/HomeDispenserModel;", "homeDispenserViewModel$delegate", "Lkotlin/Lazy;", "isDisconnected", "job", "Lkotlinx/coroutines/Job;", "listBluetoothDevice", "mBleConnected", "mBluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "mBluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "mBluetoothLeScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "mDeviceAddress", "mDeviceName", "mGattCallback", "Landroid/bluetooth/BluetoothGattCallback;", "mNotifyCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "mReadCharacteristic", "mReadCharacteristicTemp", "mScanning", "mWriteCharacteristic", "macIdAdd", "navArgs", "Lcom/livpure/safedrink/dispenser/view/HomeDispenserFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/dispenser/view/HomeDispenserFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "scanCallback", "Landroid/bluetooth/le/ScanCallback;", "CommandPublish", "", "command", "command1", "addBluetoothDevice", "bindVariablesToView", "checkIfLocationPermissionGranted", "connectWithBle", "disConnectBLE", "displayData", "data", "getBluetoothAdapter", "getBluetoothLeScanner", "getCommandList", "getLayoutId", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "initializeGattServices", "gattServices", "", "Landroid/bluetooth/BluetoothGattService;", "listeners", "lookup", AnalyticsAttribute.UUID_ATTRIBUTE, "onAttach", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNavigationItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "openServiceComplaint", "publishToDevice", "message", "", "publishToDeviceCommand", "scanLeDevice", "sendCommand", "position", "sendToBLEJsonData", "value", "setBluetooth", "setCharData", "characteristic", "setupBluetooth", "setupDashboard", "setupUsageStats", "dates", "consumptionDataSetList", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "averageConsumptionMessage", "showAddLitersScreen", "showBoltSettingsScreen", "showDispenseDialog", "mode", "showPlanChangeAirScreen", "showToastMessage", "updateBleWiFiImage", "resId", "updateFilterLifeImage", "updateWaterRemainingView", "waterRemaining", "writeCharacteristic", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeDispenserFragment extends DataBindingFragment<FragmentHomeDispenserMagnaBinding> implements CoroutineScope, BottomNavigationView.OnNavigationItemSelectedListener {
    private boolean _isFirmwareUpdate;
    private boolean _isHardwareUpdate;
    private boolean _isSoftwareUpdate;
    private Activity activity;
    private AnimProgressBar animProgressBar;
    private FragmentHomeDispenserMagnaBinding dataBinding;
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
    private final Lazy homeDispenserViewModel$delegate = LazyKt.lazy(new Function0<HomeDispenserModel>() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$homeDispenserViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HomeDispenserModel invoke() {
            HomeDispenserFragmentArgs navArgs;
            HomeDispenserModel homeDispenserModel = (HomeDispenserModel) new ViewModelProvider(HomeDispenserFragment.this).get(HomeDispenserModel.class);
            navArgs = HomeDispenserFragment.this.getNavArgs();
            homeDispenserModel.setDevice(navArgs.getDevice());
            return homeDispenserModel;
        }
    });
    private final long SCAN_PERIOD = 10000;
    private final int LOCATION_PERMISSION_CODE = 2;
    private String macIdAdd = "";
    private String _hardwareVersion = "";
    private String _softwareVersion = "";
    private final String[] ANDROID_12_BLE_PERMISSIONS = {"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
    private final ScanCallback scanCallback = new ScanCallback() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$scanCallback$1
        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            super.onScanResult(i, result);
            HomeDispenserFragment homeDispenserFragment = HomeDispenserFragment.this;
            BluetoothDevice device = result.getDevice();
            Intrinsics.checkNotNullExpressionValue(device, "result.device");
            homeDispenserFragment.addBluetoothDevice(device);
        }
    };
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$mGattCallback$1
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
                z = HomeDispenserFragment.this.isDisconnected;
                if (!z) {
                    HomeDispenserFragment.this.connectWithBle();
                }
                HomeDispenserFragment.this.mBleConnected = false;
            } else if (i2 != 2) {
            } else {
                if (ActivityCompat.checkSelfPermission(HomeDispenserFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    gatt.requestMtu(500);
                } else if (Build.VERSION.SDK_INT >= 31) {
                    strArr = HomeDispenserFragment.this.ANDROID_12_BLE_PERMISSIONS;
                    ActivityCompat.requestPermissions(HomeDispenserFragment.this.requireActivity(), strArr, 2);
                } else {
                    gatt.requestMtu(500);
                }
                HomeDispenserFragment.this.isDisconnected = false;
                HomeDispenserFragment.this.mBleConnected = true;
                HomeDispenserFragment.this.getCommandList();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            String[] strArr;
            if (i2 == 0) {
                if (ActivityCompat.checkSelfPermission(HomeDispenserFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    Intrinsics.checkNotNull(bluetoothGatt);
                    bluetoothGatt.discoverServices();
                } else if (Build.VERSION.SDK_INT >= 31) {
                    strArr = HomeDispenserFragment.this.ANDROID_12_BLE_PERMISSIONS;
                    ActivityCompat.requestPermissions(HomeDispenserFragment.this.requireActivity(), strArr, 2);
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
            if (ActivityCompat.checkSelfPermission(HomeDispenserFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                if (i != 0) {
                    gatt.discoverServices();
                    return;
                }
                HomeDispenserFragment homeDispenserFragment = HomeDispenserFragment.this;
                bluetoothGatt3 = homeDispenserFragment.mBluetoothGatt;
                homeDispenserFragment.initializeGattServices(bluetoothGatt3 != null ? bluetoothGatt3.getServices() : null);
                bluetoothGattCharacteristic3 = HomeDispenserFragment.this.mReadCharacteristic;
                if (bluetoothGattCharacteristic3 != null) {
                    bluetoothGatt4 = HomeDispenserFragment.this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt4);
                    bluetoothGattCharacteristic4 = HomeDispenserFragment.this.mReadCharacteristic;
                    bluetoothGatt4.readCharacteristic(bluetoothGattCharacteristic4);
                }
            } else if (Build.VERSION.SDK_INT >= 31) {
                strArr = HomeDispenserFragment.this.ANDROID_12_BLE_PERMISSIONS;
                ActivityCompat.requestPermissions(HomeDispenserFragment.this.requireActivity(), strArr, 2);
            } else if (i != 0) {
                gatt.discoverServices();
            } else {
                HomeDispenserFragment homeDispenserFragment2 = HomeDispenserFragment.this;
                bluetoothGatt = homeDispenserFragment2.mBluetoothGatt;
                homeDispenserFragment2.initializeGattServices(bluetoothGatt != null ? bluetoothGatt.getServices() : null);
                bluetoothGattCharacteristic = HomeDispenserFragment.this.mReadCharacteristic;
                if (bluetoothGattCharacteristic != null) {
                    bluetoothGatt2 = HomeDispenserFragment.this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt2);
                    bluetoothGattCharacteristic2 = HomeDispenserFragment.this.mReadCharacteristic;
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
                charData = HomeDispenserFragment.this.setCharData(characteristic);
                BuildersKt__Builders_commonKt.launch$default(HomeDispenserFragment.this, null, null, new HomeDispenserFragment$mGattCallback$1$onCharacteristicRead$1(HomeDispenserFragment.this, charData, null), 3, null);
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
        return R.layout.fragment_home_dispenser_magna;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public HomeDispenserFragment() {
        final HomeDispenserFragment homeDispenserFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(HomeDispenserFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$special$$inlined$navArgs$1
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
    public final HomeDispenserFragmentArgs getNavArgs() {
        return (HomeDispenserFragmentArgs) this.navArgs$delegate.getValue();
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final void setActivity(Activity activity) {
        this.activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeDispenserModel getHomeDispenserViewModel() {
        return (HomeDispenserModel) this.homeDispenserViewModel$delegate.getValue();
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

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.activity = context instanceof Activity ? (Activity) context : null;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding = this.dataBinding;
        if (fragmentHomeDispenserMagnaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding = null;
        }
        fragmentHomeDispenserMagnaBinding.bottomNavigationId.setItemIconTintList(null);
        listeners();
        this.animProgressBar = new AnimProgressBar(requireContext());
        getHomeDispenserViewModel().getDashboardDetails();
        setupDashboard();
    }

    private final void listeners() {
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding = this.dataBinding;
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding2 = null;
        if (fragmentHomeDispenserMagnaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding = null;
        }
        fragmentHomeDispenserMagnaBinding.settingsIV.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeDispenserFragment.m905listeners$lambda0(HomeDispenserFragment.this, view);
            }
        });
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding3 = this.dataBinding;
        if (fragmentHomeDispenserMagnaBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding3 = null;
        }
        fragmentHomeDispenserMagnaBinding3.swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda15
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                HomeDispenserFragment.m906listeners$lambda1(HomeDispenserFragment.this);
            }
        });
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding4 = this.dataBinding;
        if (fragmentHomeDispenserMagnaBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding4 = null;
        }
        fragmentHomeDispenserMagnaBinding4.renewPlan.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeDispenserFragment.m907listeners$lambda2(HomeDispenserFragment.this, view);
            }
        });
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding5 = this.dataBinding;
        if (fragmentHomeDispenserMagnaBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding5 = null;
        }
        fragmentHomeDispenserMagnaBinding5.addLitres.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeDispenserFragment.m908listeners$lambda3(HomeDispenserFragment.this, view);
            }
        });
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding6 = this.dataBinding;
        if (fragmentHomeDispenserMagnaBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding6 = null;
        }
        fragmentHomeDispenserMagnaBinding6.bottomNavigationId.setOnNavigationItemSelectedListener(this);
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding7 = this.dataBinding;
        if (fragmentHomeDispenserMagnaBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentHomeDispenserMagnaBinding2 = fragmentHomeDispenserMagnaBinding7;
        }
        fragmentHomeDispenserMagnaBinding2.llRaiseAserviceComplaint.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeDispenserFragment.m909listeners$lambda4(HomeDispenserFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-0  reason: not valid java name */
    public static final void m905listeners$lambda0(HomeDispenserFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showBoltSettingsScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-1  reason: not valid java name */
    public static final void m906listeners$lambda1(HomeDispenserFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getHomeDispenserViewModel().getDashboardDetails();
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding = null;
        if (this$0.mBleConnected) {
            try {
                if (ActivityCompat.checkSelfPermission(this$0.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    BluetoothGatt bluetoothGatt = this$0.mBluetoothGatt;
                    if (bluetoothGatt != null) {
                        bluetoothGatt.readCharacteristic(this$0.mReadCharacteristic);
                    }
                } else if (Build.VERSION.SDK_INT >= 31) {
                    ActivityCompat.requestPermissions(this$0.requireActivity(), this$0.ANDROID_12_BLE_PERMISSIONS, 2);
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
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new HomeDispenserFragment$listeners$2$1(this$0, null), 3, null);
        }
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding2 = this$0.dataBinding;
        if (fragmentHomeDispenserMagnaBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentHomeDispenserMagnaBinding = fragmentHomeDispenserMagnaBinding2;
        }
        fragmentHomeDispenserMagnaBinding.swipeToRefresh.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-2  reason: not valid java name */
    public static final void m907listeners$lambda2(HomeDispenserFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showPlanChangeAirScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-3  reason: not valid java name */
    public static final void m908listeners$lambda3(HomeDispenserFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showAddLitersScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-4  reason: not valid java name */
    public static final void m909listeners$lambda4(HomeDispenserFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openServiceComplaint();
    }

    private final void openServiceComplaint() {
        Context context = getContext();
        if (context != null) {
            SegmentLogger with = SegmentLogger.Companion.with(context);
            User user = LSApplication.Companion.getUser();
            String name = user != null ? user.getName() : null;
            User user2 = LSApplication.Companion.getUser();
            with.raiseServiceRequestClick(name, user2 != null ? user2.getId() : null);
        }
        NavController findNavController = FragmentKt.findNavController(this);
        HomeDispenserFragmentDirections.ActionHomeFragmentToContactUsFragment actionHomeFragmentToContactUsFragment = HomeDispenserFragmentDirections.actionHomeFragmentToContactUsFragment(getHomeDispenserViewModel().getSerialNumber());
        Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToContactUsFragment, "actionHomeFragmentToCont…erViewModel.serialNumber)");
        findNavController.navigate(actionHomeFragmentToContactUsFragment);
    }

    private final void showPlanChangeAirScreen() {
        disConnectBLE();
        DeviceList deviceList = getHomeDispenserViewModel().get_device();
        HomeDispenserFragmentDirections.ActionDispenserFragmentToSelectPlanChargeFragment actionDispenserFragmentToSelectPlanChargeFragment = deviceList != null ? HomeDispenserFragmentDirections.actionDispenserFragmentToSelectPlanChargeFragment(deviceList) : null;
        if (actionDispenserFragmentToSelectPlanChargeFragment != null) {
            FragmentKt.findNavController(this).navigate(actionDispenserFragmentToSelectPlanChargeFragment);
        }
    }

    private final void showAddLitersScreen() {
        disConnectBLE();
        DeviceList deviceList = getHomeDispenserViewModel().get_device();
        HomeDispenserFragmentDirections.ActionDispenserFragmentToAddLitresFagment actionDispenserFragmentToAddLitresFagment = deviceList != null ? HomeDispenserFragmentDirections.actionDispenserFragmentToAddLitresFagment(deviceList) : null;
        if (actionDispenserFragmentToAddLitresFagment != null) {
            FragmentKt.findNavController(this).navigate(actionDispenserFragmentToAddLitresFagment);
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentHomeDispenserMagnaBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.dataBinding = dataBinding;
        dataBinding.setViewModel(getHomeDispenserViewModel());
    }

    private final void showBoltSettingsScreen() {
        disConnectBLE();
        DeviceList deviceList = getHomeDispenserViewModel().get_device();
        HomeDispenserFragmentDirections.ActionHomeDispenserFragmentBoltSettingsFragment actionHomeDispenserFragmentBoltSettingsFragment = deviceList != null ? HomeDispenserFragmentDirections.actionHomeDispenserFragmentBoltSettingsFragment(deviceList) : null;
        if (actionHomeDispenserFragmentBoltSettingsFragment != null) {
            FragmentKt.findNavController(this).navigate(actionHomeDispenserFragmentBoltSettingsFragment);
        }
    }

    private final void setupDashboard() {
        getHomeDispenserViewModel().getWaterRemaining().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda13
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserFragment.m924setupDashboard$lambda9(HomeDispenserFragment.this, (Pair) obj);
            }
        });
        getHomeDispenserViewModel().getHardwareUpdate().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda23
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserFragment.m910setupDashboard$lambda10(HomeDispenserFragment.this, (Boolean) obj);
            }
        });
        getHomeDispenserViewModel().getSoftwareUpdate().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda22
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserFragment.m911setupDashboard$lambda11(HomeDispenserFragment.this, (Boolean) obj);
            }
        });
        getHomeDispenserViewModel().getHardwareVersion().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserFragment.m912setupDashboard$lambda12(HomeDispenserFragment.this, (String) obj);
            }
        });
        getHomeDispenserViewModel().getSoftwareVersion().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserFragment.m913setupDashboard$lambda13(HomeDispenserFragment.this, (String) obj);
            }
        });
        getHomeDispenserViewModel().getPlanDetails().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserFragment.m914setupDashboard$lambda14(HomeDispenserFragment.this, (String) obj);
            }
        });
        getHomeDispenserViewModel().getFilterLifeImage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserFragment.m915setupDashboard$lambda15(HomeDispenserFragment.this, (Integer) obj);
            }
        });
        getHomeDispenserViewModel().getUvImage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserFragment.m916setupDashboard$lambda16(HomeDispenserFragment.this, (Integer) obj);
            }
        });
        getHomeDispenserViewModel().getProductType().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserFragment.m917setupDashboard$lambda17(HomeDispenserFragment.this, (String) obj);
            }
        });
        getHomeDispenserViewModel().getUsageStats().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserFragment.m918setupDashboard$lambda18(HomeDispenserFragment.this, (Triple) obj);
            }
        });
        getHomeDispenserViewModel().getLastSynchronizedDate().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserFragment.m919setupDashboard$lambda19(HomeDispenserFragment.this, (String) obj);
            }
        });
        getHomeDispenserViewModel().getProductType().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserFragment.m920setupDashboard$lambda20(HomeDispenserFragment.this, (String) obj);
            }
        });
        getHomeDispenserViewModel().getPlanName().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserFragment.m921setupDashboard$lambda21(HomeDispenserFragment.this, (String) obj);
            }
        });
        getHomeDispenserViewModel().getPublishCommandStatus().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserFragment.m922setupDashboard$lambda22(HomeDispenserFragment.this, (String) obj);
            }
        });
        if (setBluetooth()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new HomeDispenserFragment$setupDashboard$15(this, null), 3, null);
        }
        getCommandList();
        getHomeDispenserViewModel().getBoltCommandsResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda21
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserFragment.m923setupDashboard$lambda23(HomeDispenserFragment.this, (BoltCommandsResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-9  reason: not valid java name */
    public static final void m924setupDashboard$lambda9(HomeDispenserFragment this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (((String) pair.getFirst()).length() != 6 || pair.getSecond() == null) {
            return;
        }
        Object second = pair.getSecond();
        Intrinsics.checkNotNull(second);
        this$0.updateWaterRemainingView((String) pair.getFirst(), ((Number) second).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-10  reason: not valid java name */
    public static final void m910setupDashboard$lambda10(HomeDispenserFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boolean booleanValue = it.booleanValue();
        this$0._isHardwareUpdate = booleanValue;
        if (booleanValue) {
            this$0._isFirmwareUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-11  reason: not valid java name */
    public static final void m911setupDashboard$lambda11(HomeDispenserFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boolean booleanValue = it.booleanValue();
        this$0._isSoftwareUpdate = booleanValue;
        if (booleanValue) {
            this$0._isFirmwareUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-12  reason: not valid java name */
    public static final void m912setupDashboard$lambda12(HomeDispenserFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._hardwareVersion = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-13  reason: not valid java name */
    public static final void m913setupDashboard$lambda13(HomeDispenserFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._softwareVersion = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-14  reason: not valid java name */
    public static final void m914setupDashboard$lambda14(HomeDispenserFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return;
        }
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding = this$0.dataBinding;
        if (fragmentHomeDispenserMagnaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding = null;
        }
        fragmentHomeDispenserMagnaBinding.planDetails.setText(str2);
        if (this$0.isAdded()) {
            UserRepository.Companion companion = UserRepository.Companion;
            FragmentActivity requireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            companion.getInstance(requireActivity).setUser(LSApplication.Companion.getUser());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-15  reason: not valid java name */
    public static final void m915setupDashboard$lambda15(HomeDispenserFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null && it.intValue() == -1) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateFilterLifeImage(it.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-16  reason: not valid java name */
    public static final void m916setupDashboard$lambda16(HomeDispenserFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null && it.intValue() == -1) {
            return;
        }
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding = this$0.dataBinding;
        if (fragmentHomeDispenserMagnaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding = null;
        }
        ImageView imageView = fragmentHomeDispenserMagnaBinding.uvStatusImage;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), it.intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-17  reason: not valid java name */
    public static final void m917setupDashboard$lambda17(HomeDispenserFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding = this$0.dataBinding;
        if (fragmentHomeDispenserMagnaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding = null;
        }
        fragmentHomeDispenserMagnaBinding.remainingWaterLabel.setText(R.string.label_water_remaining);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-18  reason: not valid java name */
    public static final void m918setupDashboard$lambda18(HomeDispenserFragment this$0, Triple triple) {
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
    /* renamed from: setupDashboard$lambda-19  reason: not valid java name */
    public static final void m919setupDashboard$lambda19(HomeDispenserFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StringBuilder sb = new StringBuilder();
        Activity activity = this$0.activity;
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding = null;
        sb.append(activity != null ? activity.getString(R.string.last_synchronized_on) : null);
        sb.append(SafeJsonPrimitive.NULL_CHAR);
        sb.append(str);
        String sb2 = sb.toString();
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding2 = this$0.dataBinding;
        if (fragmentHomeDispenserMagnaBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentHomeDispenserMagnaBinding = fragmentHomeDispenserMagnaBinding2;
        }
        fragmentHomeDispenserMagnaBinding.lastSynchronized.setText(sb2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-20  reason: not valid java name */
    public static final void m920setupDashboard$lambda20(HomeDispenserFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = it.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, "zingerhotwaas")) {
            FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding = this$0.dataBinding;
            if (fragmentHomeDispenserMagnaBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentHomeDispenserMagnaBinding = null;
            }
            fragmentHomeDispenserMagnaBinding.addLitres.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-21  reason: not valid java name */
    public static final void m921setupDashboard$lambda21(HomeDispenserFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(str, "Bolt-Unlimited")) {
            FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding = this$0.dataBinding;
            if (fragmentHomeDispenserMagnaBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentHomeDispenserMagnaBinding = null;
            }
            fragmentHomeDispenserMagnaBinding.addLitres.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-22  reason: not valid java name */
    public static final void m922setupDashboard$lambda22(HomeDispenserFragment this$0, String str) {
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
        BuildersKt__Builders_commonKt.launch$default(this$0, null, null, new HomeDispenserFragment$setupDashboard$14$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-23  reason: not valid java name */
    public static final void m923setupDashboard$lambda23(HomeDispenserFragment this$0, BoltCommandsResponse boltCommandsResponse) {
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
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding = this.dataBinding;
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding2 = null;
        if (fragmentHomeDispenserMagnaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding = null;
        }
        fragmentHomeDispenserMagnaBinding.waterRemainingHundredThousands.setText(String.valueOf(str.charAt(0)));
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding3 = this.dataBinding;
        if (fragmentHomeDispenserMagnaBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding3 = null;
        }
        fragmentHomeDispenserMagnaBinding3.waterRemainingTenThousands.setText(String.valueOf(str.charAt(1)));
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding4 = this.dataBinding;
        if (fragmentHomeDispenserMagnaBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding4 = null;
        }
        fragmentHomeDispenserMagnaBinding4.waterRemainingThousands.setText(String.valueOf(str.charAt(2)));
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding5 = this.dataBinding;
        if (fragmentHomeDispenserMagnaBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding5 = null;
        }
        fragmentHomeDispenserMagnaBinding5.waterRemainingHundreds.setText(String.valueOf(str.charAt(3)));
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding6 = this.dataBinding;
        if (fragmentHomeDispenserMagnaBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding6 = null;
        }
        fragmentHomeDispenserMagnaBinding6.waterRemainingTens.setText(String.valueOf(str.charAt(4)));
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding7 = this.dataBinding;
        if (fragmentHomeDispenserMagnaBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding7 = null;
        }
        fragmentHomeDispenserMagnaBinding7.waterRemainingOnes.setText(String.valueOf(str.charAt(5)));
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding8 = this.dataBinding;
        if (fragmentHomeDispenserMagnaBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentHomeDispenserMagnaBinding2 = fragmentHomeDispenserMagnaBinding8;
        }
        fragmentHomeDispenserMagnaBinding2.waterDispenseUsageImage.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
    }

    private final void updateFilterLifeImage(int i) {
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding = this.dataBinding;
        if (fragmentHomeDispenserMagnaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding = null;
        }
        fragmentHomeDispenserMagnaBinding.filterLifeImage.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
    }

    private final void setupUsageStats(List<String> list, List<? extends IBarDataSet> list2, String str) {
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding = this.dataBinding;
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding2 = null;
        if (fragmentHomeDispenserMagnaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding = null;
        }
        Context context = fragmentHomeDispenserMagnaBinding.barChart.getContext();
        Integer valueOf = context != null ? Integer.valueOf(UiUtilKt.getColorFromAttr$default(context, R.attr.colorOnSurface, null, false, 6, null)) : null;
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding3 = this.dataBinding;
        if (fragmentHomeDispenserMagnaBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding3 = null;
        }
        BarChart barChart = fragmentHomeDispenserMagnaBinding3.barChart;
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
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding4 = this.dataBinding;
        if (fragmentHomeDispenserMagnaBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentHomeDispenserMagnaBinding2 = fragmentHomeDispenserMagnaBinding4;
        }
        fragmentHomeDispenserMagnaBinding2.averageWaterConsumption.setText(str);
    }

    private final void sendCommand(int i) {
        if (i == 0) {
            showDispenseDialog("Dispense");
        } else if (i != 1) {
        } else {
            showDispenseDialog("Temp");
        }
    }

    private final void showDispenseDialog(String str) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        if (Intrinsics.areEqual(str, "Dispense")) {
            View inflate = getLayoutInflater().inflate(R.layout.dispenser_popup, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(R…ut.dispenser_popup, null)");
            bottomSheetDialog.setContentView(inflate);
            final ImageView imageView = (ImageView) bottomSheetDialog.findViewById(R.id.waterDispensingImage);
            getHomeDispenserViewModel().getLiveDispenserStatusImage().observe(this, new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda20
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeDispenserFragment.m925showDispenseDialog$lambda26(imageView, this, (Integer) obj);
                }
            });
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda17
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeDispenserFragment.m926showDispenseDialog$lambda27(HomeDispenserFragment.this, view);
                    }
                });
            }
            bottomSheetDialog.show();
        } else if (Intrinsics.areEqual(str, "Temp")) {
            View inflate2 = getLayoutInflater().inflate(R.layout.bottom_sheet_temperature, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate2, "layoutInflater.inflate(R…_sheet_temperature, null)");
            bottomSheetDialog.setContentView(inflate2);
            TextView textView = (TextView) bottomSheetDialog.findViewById(R.id.tvSaveButton);
            String[] stringArray = getResources().getStringArray(R.array.temperature);
            Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(R.array.temperature)");
            final Spinner spinner = (Spinner) bottomSheetDialog.findViewById(R.id.spinner_hot_water);
            final Spinner spinner2 = (Spinner) bottomSheetDialog.findViewById(R.id.spinner_warm_water);
            if (spinner != null) {
                spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(inflate2.getContext(), 17367043, stringArray));
                String hotWaterTemprature = getHomeDispenserViewModel().getHotWaterTemprature();
                if (Intrinsics.areEqual(hotWaterTemprature, "74")) {
                    spinner.setSelection(1);
                } else if (Intrinsics.areEqual(hotWaterTemprature, "78")) {
                    spinner.setSelection(2);
                } else {
                    spinner.setSelection(0);
                }
            }
            if (spinner2 != null) {
                spinner2.setAdapter((SpinnerAdapter) new ArrayAdapter(inflate2.getContext(), 17367043, stringArray));
                String warmWaterTemprature = getHomeDispenserViewModel().getWarmWaterTemprature();
                if (Intrinsics.areEqual(warmWaterTemprature, "43")) {
                    spinner2.setSelection(1);
                } else if (Intrinsics.areEqual(warmWaterTemprature, "46")) {
                    spinner2.setSelection(2);
                } else {
                    spinner2.setSelection(0);
                }
            }
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeDispenserFragment.m927showDispenseDialog$lambda28(spinner, spinner2, this, bottomSheetDialog, view);
                    }
                });
            }
            bottomSheetDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDispenseDialog$lambda-26  reason: not valid java name */
    public static final void m925showDispenseDialog$lambda26(ImageView imageView, HomeDispenserFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (imageView != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), it.intValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDispenseDialog$lambda-27  reason: not valid java name */
    public static final void m926showDispenseDialog$lambda27(HomeDispenserFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnimProgressBar animProgressBar = this$0.animProgressBar;
        AnimProgressBar animProgressBar2 = null;
        if (animProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            animProgressBar = null;
        }
        animProgressBar.show();
        if (this$0.mBleConnected) {
            String command = AppConstants.COMMAND_DISPENSING_ON;
            if (Intrinsics.areEqual(this$0.getHomeDispenserViewModel().getDispenserStatus(), "1")) {
                command = AppConstants.COMMAND_DISPENSING_OFF;
            }
            Intrinsics.checkNotNullExpressionValue(command, "command");
            this$0.CommandPublish(command);
            AnimProgressBar animProgressBar3 = this$0.animProgressBar;
            if (animProgressBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            } else {
                animProgressBar2 = animProgressBar3;
            }
            animProgressBar2.dismiss();
            return;
        }
        if (Intrinsics.areEqual(this$0.getHomeDispenserViewModel().getDispenserStatus(), "1")) {
            this$0.getHomeDispenserViewModel().publishCommand("05", "", "");
        } else {
            this$0.getHomeDispenserViewModel().publishCommand("04", "", "");
        }
        AnimProgressBar animProgressBar4 = this$0.animProgressBar;
        if (animProgressBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
        } else {
            animProgressBar2 = animProgressBar4;
        }
        animProgressBar2.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDispenseDialog$lambda-28  reason: not valid java name */
    public static final void m927showDispenseDialog$lambda28(Spinner spinner, Spinner spinner2, HomeDispenserFragment this$0, BottomSheetDialog dialoglog, View view) {
        AnimProgressBar animProgressBar;
        String format;
        AnimProgressBar animProgressBar2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialoglog, "$dialoglog");
        int selectedItemId = spinner != null ? (int) spinner.getSelectedItemId() : 0;
        int selectedItemId2 = spinner2 != null ? (int) spinner2.getSelectedItemId() : 0;
        AnimProgressBar animProgressBar3 = this$0.animProgressBar;
        if (animProgressBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            animProgressBar3 = null;
        }
        animProgressBar3.show();
        String str = "";
        if (this$0.mBleConnected) {
            if (selectedItemId2 == 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String COMMAND_WARM_WATER = AppConstants.COMMAND_WARM_WATER;
                Intrinsics.checkNotNullExpressionValue(COMMAND_WARM_WATER, "COMMAND_WARM_WATER");
                format = String.format(COMMAND_WARM_WATER, Arrays.copyOf(new Object[]{"40"}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            } else if (selectedItemId2 == 1) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String COMMAND_WARM_WATER2 = AppConstants.COMMAND_WARM_WATER;
                Intrinsics.checkNotNullExpressionValue(COMMAND_WARM_WATER2, "COMMAND_WARM_WATER");
                format = String.format(COMMAND_WARM_WATER2, Arrays.copyOf(new Object[]{"43"}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            } else if (selectedItemId2 != 2) {
                format = "";
            } else {
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String COMMAND_WARM_WATER3 = AppConstants.COMMAND_WARM_WATER;
                Intrinsics.checkNotNullExpressionValue(COMMAND_WARM_WATER3, "COMMAND_WARM_WATER");
                format = String.format(COMMAND_WARM_WATER3, Arrays.copyOf(new Object[]{"46"}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            if (selectedItemId == 0) {
                StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                String COMMAND_HOT_WATER = AppConstants.COMMAND_HOT_WATER;
                Intrinsics.checkNotNullExpressionValue(COMMAND_HOT_WATER, "COMMAND_HOT_WATER");
                str = String.format(COMMAND_HOT_WATER, Arrays.copyOf(new Object[]{"70"}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            } else if (selectedItemId == 1) {
                StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                String COMMAND_HOT_WATER2 = AppConstants.COMMAND_HOT_WATER;
                Intrinsics.checkNotNullExpressionValue(COMMAND_HOT_WATER2, "COMMAND_HOT_WATER");
                str = String.format(COMMAND_HOT_WATER2, Arrays.copyOf(new Object[]{"74"}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            } else if (selectedItemId == 2) {
                StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
                String COMMAND_HOT_WATER3 = AppConstants.COMMAND_HOT_WATER;
                Intrinsics.checkNotNullExpressionValue(COMMAND_HOT_WATER3, "COMMAND_HOT_WATER");
                str = String.format(COMMAND_HOT_WATER3, Arrays.copyOf(new Object[]{"78"}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            }
            this$0.CommandPublish(format, str);
            AnimProgressBar animProgressBar4 = this$0.animProgressBar;
            if (animProgressBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                animProgressBar2 = null;
            } else {
                animProgressBar2 = animProgressBar4;
            }
            animProgressBar2.dismiss();
            dialoglog.dismiss();
            return;
        }
        if (selectedItemId == 0) {
            this$0.getHomeDispenserViewModel().publishCommand("02", "", "70");
        } else if (selectedItemId == 1) {
            this$0.getHomeDispenserViewModel().publishCommand("02", "", "74");
        } else if (selectedItemId == 2) {
            this$0.getHomeDispenserViewModel().publishCommand("02", "", "78");
        }
        if (selectedItemId2 == 0) {
            this$0.getHomeDispenserViewModel().publishCommand("01", "40", "");
        } else if (selectedItemId2 == 1) {
            this$0.getHomeDispenserViewModel().publishCommand("01", "43", "");
        } else if (selectedItemId2 == 2) {
            this$0.getHomeDispenserViewModel().publishCommand("01", "46", "");
        }
        AnimProgressBar animProgressBar5 = this$0.animProgressBar;
        if (animProgressBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            animProgressBar = null;
        } else {
            animProgressBar = animProgressBar5;
        }
        animProgressBar.dismiss();
        dialoglog.dismiss();
    }

    private final void CommandPublish(String str) {
        if (Intrinsics.areEqual(publishToDeviceCommand(str), "succes")) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserFragment$CommandPublish$1(this, null), 3, null);
        }
    }

    private final void CommandPublish(String str, String str2) {
        if (Intrinsics.areEqual(publishToDeviceCommand(str), "succes")) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserFragment$CommandPublish$2(this, str2, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupBluetooth() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s-%s", Arrays.copyOf(new Object[]{"LIVSMT-RO", StringsKt.takeLast(getHomeDispenserViewModel().getImeiNumber(), 4)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        this.macIdAdd = format;
        this.listBluetoothDevice = new ArrayList<>();
        getBluetoothAdapter();
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null) {
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
    }

    private final void getBluetoothAdapter() {
        if (isAdded()) {
            Object systemService = getMContext().getSystemService("bluetooth");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
            this.mBluetoothAdapter = ((BluetoothManager) systemService).getAdapter();
            this.mScanning = false;
        }
    }

    private final void getBluetoothLeScanner() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        Intrinsics.checkNotNull(bluetoothAdapter);
        this.mBluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
    }

    private final void scanLeDevice() {
        if (isAdded()) {
            if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_SCAN") == 0) {
                ArrayList<String> arrayList = this.listBluetoothDevice;
                Intrinsics.checkNotNull(arrayList);
                arrayList.clear();
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HomeDispenserFragment$scanLeDevice$1(this, null), 3, null);
                BluetoothLeScanner bluetoothLeScanner = this.mBluetoothLeScanner;
                Intrinsics.checkNotNull(bluetoothLeScanner);
                bluetoothLeScanner.startScan(this.scanCallback);
                this.mScanning = true;
            } else if (Build.VERSION.SDK_INT >= 31) {
                ActivityCompat.requestPermissions(requireActivity(), this.ANDROID_12_BLE_PERMISSIONS, 2);
            } else {
                ArrayList<String> arrayList2 = this.listBluetoothDevice;
                Intrinsics.checkNotNull(arrayList2);
                arrayList2.clear();
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HomeDispenserFragment$scanLeDevice$2(this, null), 3, null);
                BluetoothLeScanner bluetoothLeScanner2 = this.mBluetoothLeScanner;
                Intrinsics.checkNotNull(bluetoothLeScanner2);
                bluetoothLeScanner2.startScan(this.scanCallback);
                this.mScanning = true;
            }
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
                ActivityCompat.requestPermissions(requireActivity(), this.ANDROID_12_BLE_PERMISSIONS, 2);
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
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserFragment$connectWithBle$1(this, null), 3, null);
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
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                    this.mReadCharacteristicTemp = bluetoothGattCharacteristic;
                    int properties = bluetoothGattCharacteristic.getProperties();
                    if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
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
                    } else if (Build.VERSION.SDK_INT >= 31) {
                        ActivityCompat.requestPermissions(requireActivity(), this.ANDROID_12_BLE_PERMISSIONS, 2);
                    } else {
                        if ((properties | 2) > 0) {
                            if (this.mNotifyCharacteristic != null) {
                                BluetoothGatt bluetoothGatt4 = this.mBluetoothGatt;
                                Intrinsics.checkNotNull(bluetoothGatt4);
                                bluetoothGatt4.setCharacteristicNotification(this.mNotifyCharacteristic, true);
                            }
                            this.mReadCharacteristic = bluetoothGattCharacteristic;
                            BluetoothGatt bluetoothGatt5 = this.mBluetoothGatt;
                            Intrinsics.checkNotNull(bluetoothGatt5);
                            bluetoothGatt5.readCharacteristic(bluetoothGattCharacteristic);
                        }
                        if ((properties | 16) > 0) {
                            this.mNotifyCharacteristic = bluetoothGattCharacteristic;
                            BluetoothGatt bluetoothGatt6 = this.mBluetoothGatt;
                            Intrinsics.checkNotNull(bluetoothGatt6);
                            bluetoothGatt6.setCharacteristicNotification(bluetoothGattCharacteristic, true);
                        }
                        if ((properties & 8) > 0) {
                            this.mWriteCharacteristic = bluetoothGattCharacteristic;
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
        getHomeDispenserViewModel().getPendingBleCommand();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayData(String str) {
        List<String> lines;
        String decrypt;
        List<String> lines2;
        String decrypt2;
        getHomeDispenserViewModel().getBleImage().observe(this, new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserFragment.m904displayData$lambda29(HomeDispenserFragment.this, (Integer) obj);
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
                        HomeDispenserModel homeDispenserViewModel = getHomeDispenserViewModel();
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonData.toString()");
                        homeDispenserViewModel.bleStatus(jSONObject2);
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
                            BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserFragment$displayData$3(this, null), 3, null);
                            return;
                        }
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserFragment$displayData$2(this, null), 3, null);
                    showToastMessage();
                } catch (Exception unused) {
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserFragment$displayData$4(this, null), 3, null);
                }
            }
        } else if (Build.VERSION.SDK_INT >= 31) {
            ActivityCompat.requestPermissions(requireActivity(), this.ANDROID_12_BLE_PERMISSIONS, 2);
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
                    HomeDispenserModel homeDispenserViewModel2 = getHomeDispenserViewModel();
                    String jSONObject6 = jSONObject5.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject6, "jsonData.toString()");
                    homeDispenserViewModel2.bleStatus(jSONObject6);
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
                        BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserFragment$displayData$6(this, null), 3, null);
                        return;
                    }
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserFragment$displayData$5(this, null), 3, null);
                showToastMessage();
            } catch (Exception unused2) {
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserFragment$displayData$7(this, null), 3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: displayData$lambda-29  reason: not valid java name */
    public static final void m904displayData$lambda29(HomeDispenserFragment this$0, Integer it) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final String publishToDeviceCommand(String str) {
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
                ActivityCompat.requestPermissions(requireActivity(), this.ANDROID_12_BLE_PERMISSIONS, 2);
            } else {
                BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
                Intrinsics.checkNotNull(bluetoothGatt2);
                bluetoothGatt2.writeCharacteristic(bluetoothGattCharacteristic);
            }
        }
    }

    private final boolean checkIfLocationPermissionGranted() {
        Activity activity = this.activity;
        Integer valueOf = activity != null ? Integer.valueOf(ContextCompat.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION")) : null;
        return valueOf != null && valueOf.intValue() == 0;
    }

    private final void onRequestPermissionsResult() {
        Activity activity = this.activity;
        if (activity != null) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this.LOCATION_PERMISSION_CODE);
        }
    }

    private final void sendToBLEJsonData(String str) {
        try {
            byte[] hexStringToByteArray = Encrypt.hexStringToByteArray(Encrypt.encrypt(str, AppConstants.BEL_ENC_KEY));
            Intrinsics.checkNotNullExpressionValue(hexStringToByteArray, "hexStringToByteArray(encriptedData)");
            if (Intrinsics.areEqual(publishToDevice(hexStringToByteArray), "succes")) {
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserFragment$sendToBLEJsonData$1(this, null), 3, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void updateBleWiFiImage(int i) {
        FragmentHomeDispenserMagnaBinding fragmentHomeDispenserMagnaBinding = this.dataBinding;
        if (fragmentHomeDispenserMagnaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserMagnaBinding = null;
        }
        fragmentHomeDispenserMagnaBinding.bleInfoIV.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
    }

    private final void disConnectBLE() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt != null) {
            if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                bluetoothGatt.disconnect();
                bluetoothGatt.close();
            } else if (Build.VERSION.SDK_INT >= 31) {
                ActivityCompat.requestPermissions(requireActivity(), this.ANDROID_12_BLE_PERMISSIONS, 2);
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
            ActivityCompat.requestPermissions(requireActivity(), this.ANDROID_12_BLE_PERMISSIONS, 2);
            return true;
        } else if (isEnabled) {
            return true;
        } else {
            return defaultAdapter.enable();
        }
    }

    private final void showToastMessage() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserFragment$showToastMessage$1(null), 3, null);
    }

    @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
    public boolean onNavigationItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.action_dispense_id) {
            sendCommand(0);
        } else if (itemId != R.id.action_temp_setting_id) {
            return false;
        } else {
            sendCommand(1);
        }
        return true;
    }
}
