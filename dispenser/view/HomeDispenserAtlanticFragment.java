package com.livpure.safedrink.dispenser.view;

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
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.appevents.AppEventsConstants;
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
import com.livpure.safedrink.databinding.FragmentHomeDispenserAtlanticBinding;
import com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel;
import com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragmentDirections;
import com.livpure.safedrink.dispenser.view.HomeDispenserFragmentDirections;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.model.DispenserBottomOption;
import com.livpure.safedrink.segment.SegmentLogger;
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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.ArraysKt;
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
/* compiled from: HomeDispenserAtlanticFragment.kt */
@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u000bH\u0002J\u0010\u0010R\u001a\u00020P2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010S\u001a\u00020P2\u0006\u0010'\u001a\u00020\u0002H\u0016J\b\u0010T\u001a\u00020\rH\u0002J\b\u0010U\u001a\u00020PH\u0002J\b\u0010V\u001a\u00020PH\u0002J\u0012\u0010W\u001a\u00020P2\b\u0010X\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010Y\u001a\u00020PH\u0002J\b\u0010Z\u001a\u00020PH\u0002J\b\u0010[\u001a\u00020PH\u0002J\b\u0010\\\u001a\u00020\u0007H\u0014J\b\u0010]\u001a\u00020^H\u0014J\u0018\u0010_\u001a\u00020P2\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010aH\u0002J\b\u0010c\u001a\u00020PH\u0002J\u0010\u0010d\u001a\u00020\u000b2\b\u0010e\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010f\u001a\u00020P2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\b\u0010i\u001a\u00020PH\u0016J\u0010\u0010j\u001a\u00020\r2\u0006\u0010k\u001a\u00020lH\u0016J\b\u0010m\u001a\u00020PH\u0002J\u001a\u0010n\u001a\u00020P2\u0006\u0010o\u001a\u00020p2\b\u0010g\u001a\u0004\u0018\u00010hH\u0017J\b\u0010q\u001a\u00020PH\u0002J\b\u0010r\u001a\u00020PH\u0002J\u0014\u0010s\u001a\u0004\u0018\u00010\u000b2\b\u0010t\u001a\u0004\u0018\u00010uH\u0002J\u0014\u0010v\u001a\u0004\u0018\u00010\u000b2\b\u0010t\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010w\u001a\u00020PH\u0002J\u0010\u0010x\u001a\u00020P2\u0006\u0010y\u001a\u00020\u0007H\u0002J\u0010\u0010z\u001a\u00020P2\u0006\u0010{\u001a\u00020\u000bH\u0002J\b\u0010|\u001a\u00020\rH\u0002J\u0014\u0010}\u001a\u0004\u0018\u00010\u000b2\b\u0010~\u001a\u0004\u0018\u00010AH\u0002J\b\u0010\u007f\u001a\u00020PH\u0003J\t\u0010\u0080\u0001\u001a\u00020PH\u0002J1\u0010\u0081\u0001\u001a\u00020P2\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0a2\u000e\u0010\u0083\u0001\u001a\t\u0012\u0005\u0012\u00030\u0084\u00010a2\u0007\u0010\u0085\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u0086\u0001\u001a\u00020PH\u0002J\t\u0010\u0087\u0001\u001a\u00020PH\u0002J\t\u0010\u0088\u0001\u001a\u00020PH\u0002J$\u0010\u0089\u0001\u001a\u00020P2\u0007\u0010\u008a\u0001\u001a\u00020\u000b2\u0007\u0010\u008b\u0001\u001a\u00020\u000b2\u0007\u0010\u008c\u0001\u001a\u00020\rH\u0002J\u0012\u0010\u008d\u0001\u001a\u00020P2\u0007\u0010\u008e\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u008f\u0001\u001a\u00020PH\u0002J\u0011\u0010\u0090\u0001\u001a\u00020P2\u0006\u0010t\u001a\u00020\u000bH\u0002J\u0014\u0010\u0091\u0001\u001a\u00020P2\t\b\u0001\u0010\u0092\u0001\u001a\u00020\u0007H\u0002J\u0014\u0010\u0093\u0001\u001a\u00020P2\t\b\u0001\u0010\u0092\u0001\u001a\u00020\u0007H\u0002J\u001d\u0010\u0094\u0001\u001a\u00020P2\u0007\u0010\u0095\u0001\u001a\u00020\u000b2\t\b\u0001\u0010\u0092\u0001\u001a\u00020\u0007H\u0002J\u0011\u0010\u0096\u0001\u001a\u00020P2\u0006\u0010~\u001a\u00020AH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00128\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R2\u0010\u0016\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0018`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u001bj\b\u0012\u0004\u0012\u00020\u000b`\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u000e\u00100\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\"\u00103\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010G\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bI\u0010JR\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0097\u0001"}, d2 = {"Lcom/livpure/safedrink/dispenser/view/HomeDispenserAtlanticFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentHomeDispenserAtlanticBinding;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/google/android/material/bottomnavigation/BottomNavigationView$OnNavigationItemSelectedListener;", "()V", "LOCATION_PERMISSION_CODE", "", "SCAN_PERIOD", "", "_hardwareVersion", "", "_isFirmwareUpdate", "", "_isHardwareUpdate", "_isSoftwareUpdate", "_softwareVersion", "android12BlePermission", "", "[Ljava/lang/String;", "animProgressBar", "Lcom/livpure/safedrink/utils/AnimProgressBar;", "attributes", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "bleCommandList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "bottomOptionIcons", "[Ljava/lang/Integer;", "bottomOptionList", "", "Lcom/livpure/safedrink/model/DispenserBottomOption;", "bottomOptionTitle", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "dataBinding", AndroidContextPlugin.DEVICE_KEY, "Landroid/bluetooth/BluetoothDevice;", "homeDispenserAtlanticModel", "Lcom/livpure/safedrink/dispenser/model/HomeDispenserAtlanticModel;", "getHomeDispenserAtlanticModel", "()Lcom/livpure/safedrink/dispenser/model/HomeDispenserAtlanticModel;", "homeDispenserAtlanticModel$delegate", "Lkotlin/Lazy;", "isDisconnected", "job", "Lkotlinx/coroutines/Job;", "listBluetoothDevice", "loopPublishCommandCount", "mBleConnected", "mBluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "mBluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "mBluetoothLeScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "mDeviceAddress", "mDeviceName", "mGattCallback", "Landroid/bluetooth/BluetoothGattCallback;", "mNotifyCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "mReadCharacteristic", "mReadCharacteristicTemp", "mScanning", "mWriteCharacteristic", "macIdAdd", "navArg", "Lcom/livpure/safedrink/dispenser/view/HomeDispenserAtlanticFragmentArgs;", "getNavArg", "()Lcom/livpure/safedrink/dispenser/view/HomeDispenserAtlanticFragmentArgs;", "navArg$delegate", "Landroidx/navigation/NavArgsLazy;", "scanCallback", "Landroid/bluetooth/le/ScanCallback;", "CommandPublish", "", "command", "addBluetoothDevice", "bindVariablesToView", "checkIfLocationPermissionGranted", "connectWithBle", "disConnectBLE", "displayData", "data", "getBluetoothAdapter", "getBluetoothLeScanner", "getCommandList", "getLayoutId", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "initializeGattServices", "gattServices", "", "Landroid/bluetooth/BluetoothGattService;", "listeners", "lookup", AnalyticsAttribute.UUID_ATTRIBUTE, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNavigationItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "openServiceComplaint", "publishCommandLoop", "publishToDevice", "message", "", "publishToDeviceCommand", "scanLeDevice", "sendCommand", "position", "sendToBLEJsonData", "value", "setBluetooth", "setCharData", "characteristic", "setupBluetooth", "setupDashboard", "setupUsageStats", "dates", "consumptionDataSetList", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "averageConsumptionMessage", "showAddLitersScreen", "showBoltSettingsScreen", "showBottomOptions", "showDialog", "headder", "description", "isHotWater", "showDispenseDialog", "mode", "showPlanChangeAirScreen", "showToastMessage", "updateBleWiFiImage", "resId", "updateFilterLifeImage", "updateWaterRemainingView", "waterRemaining", "writeCharacteristic", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeDispenserAtlanticFragment extends DataBindingFragment<FragmentHomeDispenserAtlanticBinding> implements CoroutineScope, BottomNavigationView.OnNavigationItemSelectedListener {
    private boolean _isFirmwareUpdate;
    private boolean _isHardwareUpdate;
    private boolean _isSoftwareUpdate;
    private AnimProgressBar animProgressBar;
    private FragmentHomeDispenserAtlanticBinding dataBinding;
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
    private final NavArgsLazy navArg$delegate;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private Integer[] bottomOptionIcons = {Integer.valueOf((int) R.drawable.ic_dispense), Integer.valueOf((int) R.drawable.ic_tds_band), Integer.valueOf((int) R.drawable.ic_temp), Integer.valueOf((int) R.drawable.ic_disinfection)};
    private String[] bottomOptionTitle = {"Dispense", "TDS Band", "Temp Settings", "Disinfection"};
    private List<DispenserBottomOption> bottomOptionList = new ArrayList();
    private final long SCAN_PERIOD = 10000;
    private final int LOCATION_PERMISSION_CODE = 2;
    private String macIdAdd = "";
    private String _hardwareVersion = "";
    private String _softwareVersion = "";
    private final Lazy homeDispenserAtlanticModel$delegate = LazyKt.lazy(new Function0<HomeDispenserAtlanticModel>() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$homeDispenserAtlanticModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HomeDispenserAtlanticModel invoke() {
            HomeDispenserAtlanticFragmentArgs navArg;
            HomeDispenserAtlanticModel homeDispenserAtlanticModel = (HomeDispenserAtlanticModel) new ViewModelProvider(HomeDispenserAtlanticFragment.this).get(HomeDispenserAtlanticModel.class);
            navArg = HomeDispenserAtlanticFragment.this.getNavArg();
            homeDispenserAtlanticModel.setDevice(navArg.getDevice());
            return homeDispenserAtlanticModel;
        }
    });
    private final String[] android12BlePermission = {"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
    private int loopPublishCommandCount = 6;
    private final ScanCallback scanCallback = new ScanCallback() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$scanCallback$1
        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            super.onScanResult(i, result);
            HomeDispenserAtlanticFragment homeDispenserAtlanticFragment = HomeDispenserAtlanticFragment.this;
            BluetoothDevice device = result.getDevice();
            Intrinsics.checkNotNullExpressionValue(device, "result.device");
            homeDispenserAtlanticFragment.addBluetoothDevice(device);
        }
    };
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$mGattCallback$1
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
                z = HomeDispenserAtlanticFragment.this.isDisconnected;
                if (!z) {
                    HomeDispenserAtlanticFragment.this.connectWithBle();
                }
                HomeDispenserAtlanticFragment.this.mBleConnected = false;
            } else if (i2 != 2) {
            } else {
                if (ActivityCompat.checkSelfPermission(HomeDispenserAtlanticFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    gatt.requestMtu(500);
                } else if (Build.VERSION.SDK_INT >= 31) {
                    strArr = HomeDispenserAtlanticFragment.this.android12BlePermission;
                    ActivityCompat.requestPermissions(HomeDispenserAtlanticFragment.this.requireActivity(), strArr, 2);
                } else {
                    gatt.requestMtu(500);
                }
                HomeDispenserAtlanticFragment.this.isDisconnected = false;
                HomeDispenserAtlanticFragment.this.mBleConnected = true;
                HomeDispenserAtlanticFragment.this.getCommandList();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            String[] strArr;
            if (i2 == 0) {
                if (ActivityCompat.checkSelfPermission(HomeDispenserAtlanticFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    Intrinsics.checkNotNull(bluetoothGatt);
                    bluetoothGatt.discoverServices();
                } else if (Build.VERSION.SDK_INT >= 31) {
                    strArr = HomeDispenserAtlanticFragment.this.android12BlePermission;
                    ActivityCompat.requestPermissions(HomeDispenserAtlanticFragment.this.requireActivity(), strArr, 2);
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
            if (ActivityCompat.checkSelfPermission(HomeDispenserAtlanticFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                if (i != 0) {
                    gatt.discoverServices();
                    return;
                }
                HomeDispenserAtlanticFragment homeDispenserAtlanticFragment = HomeDispenserAtlanticFragment.this;
                bluetoothGatt3 = homeDispenserAtlanticFragment.mBluetoothGatt;
                homeDispenserAtlanticFragment.initializeGattServices(bluetoothGatt3 != null ? bluetoothGatt3.getServices() : null);
                bluetoothGattCharacteristic3 = HomeDispenserAtlanticFragment.this.mReadCharacteristic;
                if (bluetoothGattCharacteristic3 != null) {
                    bluetoothGatt4 = HomeDispenserAtlanticFragment.this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt4);
                    bluetoothGattCharacteristic4 = HomeDispenserAtlanticFragment.this.mReadCharacteristic;
                    bluetoothGatt4.readCharacteristic(bluetoothGattCharacteristic4);
                }
            } else if (Build.VERSION.SDK_INT >= 31) {
                strArr = HomeDispenserAtlanticFragment.this.android12BlePermission;
                ActivityCompat.requestPermissions(HomeDispenserAtlanticFragment.this.requireActivity(), strArr, 2);
            } else if (i != 0) {
                gatt.discoverServices();
            } else {
                HomeDispenserAtlanticFragment homeDispenserAtlanticFragment2 = HomeDispenserAtlanticFragment.this;
                bluetoothGatt = homeDispenserAtlanticFragment2.mBluetoothGatt;
                homeDispenserAtlanticFragment2.initializeGattServices(bluetoothGatt != null ? bluetoothGatt.getServices() : null);
                bluetoothGattCharacteristic = HomeDispenserAtlanticFragment.this.mReadCharacteristic;
                if (bluetoothGattCharacteristic != null) {
                    bluetoothGatt2 = HomeDispenserAtlanticFragment.this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt2);
                    bluetoothGattCharacteristic2 = HomeDispenserAtlanticFragment.this.mReadCharacteristic;
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
                charData = HomeDispenserAtlanticFragment.this.setCharData(characteristic);
                BuildersKt__Builders_commonKt.launch$default(HomeDispenserAtlanticFragment.this, null, null, new HomeDispenserAtlanticFragment$mGattCallback$1$onCharacteristicRead$1(HomeDispenserAtlanticFragment.this, charData, null), 3, null);
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
        return R.layout.fragment_home_dispenser_atlantic;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public HomeDispenserAtlanticFragment() {
        final HomeDispenserAtlanticFragment homeDispenserAtlanticFragment = this;
        this.navArg$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(HomeDispenserAtlanticFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$special$$inlined$navArgs$1
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
    public final HomeDispenserAtlanticFragmentArgs getNavArg() {
        return (HomeDispenserAtlanticFragmentArgs) this.navArg$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeDispenserAtlanticModel getHomeDispenserAtlanticModel() {
        return (HomeDispenserAtlanticModel) this.homeDispenserAtlanticModel$delegate.getValue();
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
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding = null;
        }
        fragmentHomeDispenserAtlanticBinding.bottomNavigationId.setItemIconTintList(null);
        listeners();
        this.animProgressBar = new AnimProgressBar(requireContext());
        getHomeDispenserAtlanticModel().getDashboardDetails();
        setupDashboard();
    }

    private final void listeners() {
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding = this.dataBinding;
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding2 = null;
        if (fragmentHomeDispenserAtlanticBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding = null;
        }
        fragmentHomeDispenserAtlanticBinding.settingsIV.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeDispenserAtlanticFragment.m865listeners$lambda0(HomeDispenserAtlanticFragment.this, view);
            }
        });
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding3 = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding3 = null;
        }
        fragmentHomeDispenserAtlanticBinding3.swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda25
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                HomeDispenserAtlanticFragment.m866listeners$lambda1(HomeDispenserAtlanticFragment.this);
            }
        });
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding4 = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding4 = null;
        }
        fragmentHomeDispenserAtlanticBinding4.renewPlan.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeDispenserAtlanticFragment.m867listeners$lambda2(HomeDispenserAtlanticFragment.this, view);
            }
        });
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding5 = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding5 = null;
        }
        fragmentHomeDispenserAtlanticBinding5.addLitres.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeDispenserAtlanticFragment.m868listeners$lambda3(HomeDispenserAtlanticFragment.this, view);
            }
        });
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding6 = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding6 = null;
        }
        fragmentHomeDispenserAtlanticBinding6.llRaiseAserviceComplaint.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeDispenserAtlanticFragment.m869listeners$lambda4(HomeDispenserAtlanticFragment.this, view);
            }
        });
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding7 = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding7 = null;
        }
        fragmentHomeDispenserAtlanticBinding7.llHotWaterClick.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeDispenserAtlanticFragment.m870listeners$lambda5(HomeDispenserAtlanticFragment.this, view);
            }
        });
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding8 = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding8 = null;
        }
        fragmentHomeDispenserAtlanticBinding8.llColdWaterClick.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeDispenserAtlanticFragment.m871listeners$lambda6(HomeDispenserAtlanticFragment.this, view);
            }
        });
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding9 = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentHomeDispenserAtlanticBinding2 = fragmentHomeDispenserAtlanticBinding9;
        }
        fragmentHomeDispenserAtlanticBinding2.bottomNavigationId.setOnNavigationItemSelectedListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-0  reason: not valid java name */
    public static final void m865listeners$lambda0(HomeDispenserAtlanticFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showBoltSettingsScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-1  reason: not valid java name */
    public static final void m866listeners$lambda1(HomeDispenserAtlanticFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getHomeDispenserAtlanticModel().getDashboardDetails();
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding = null;
        if (this$0.mBleConnected) {
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
        } else {
            this$0.setBluetooth();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new HomeDispenserAtlanticFragment$listeners$2$1(this$0, null), 3, null);
        }
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding2 = this$0.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentHomeDispenserAtlanticBinding = fragmentHomeDispenserAtlanticBinding2;
        }
        fragmentHomeDispenserAtlanticBinding.swipeToRefresh.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-2  reason: not valid java name */
    public static final void m867listeners$lambda2(HomeDispenserAtlanticFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showPlanChangeAirScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-3  reason: not valid java name */
    public static final void m868listeners$lambda3(HomeDispenserAtlanticFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showAddLitersScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-4  reason: not valid java name */
    public static final void m869listeners$lambda4(HomeDispenserAtlanticFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openServiceComplaint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-5  reason: not valid java name */
    public static final void m870listeners$lambda5(HomeDispenserAtlanticFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.getHomeDispenserAtlanticModel().getHotWaterValue(), "1")) {
            this$0.showDialog("Hot Water", "Do you want to switch off the hot water", true);
        } else {
            this$0.showDialog("Hot Water", "Do you want to switch on the hot water", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-6  reason: not valid java name */
    public static final void m871listeners$lambda6(HomeDispenserAtlanticFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.getHomeDispenserAtlanticModel().getColdWaterValue(), "1")) {
            this$0.showDialog("Cold Water", "Do you want to switch off the cold water", false);
        } else {
            this$0.showDialog("Cold Water", "Do you want to switch on the cold water", false);
        }
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
        HomeDispenserAtlanticFragmentDirections.ActionHomeFragmentToContactUsFragment actionHomeFragmentToContactUsFragment = HomeDispenserAtlanticFragmentDirections.actionHomeFragmentToContactUsFragment(getHomeDispenserAtlanticModel().getSerialNumber());
        Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToContactUsFragment, "actionHomeFragmentToCont…lanticModel.serialNumber)");
        findNavController.navigate(actionHomeFragmentToContactUsFragment);
    }

    private final void showPlanChangeAirScreen() {
        disConnectBLE();
        DeviceList deviceList = getHomeDispenserAtlanticModel().get_device();
        HomeDispenserFragmentDirections.ActionDispenserFragmentToSelectPlanChargeFragment actionDispenserFragmentToSelectPlanChargeFragment = deviceList != null ? HomeDispenserFragmentDirections.actionDispenserFragmentToSelectPlanChargeFragment(deviceList) : null;
        if (actionDispenserFragmentToSelectPlanChargeFragment != null) {
            FragmentKt.findNavController(this).navigate(actionDispenserFragmentToSelectPlanChargeFragment);
        }
    }

    private final void showAddLitersScreen() {
        disConnectBLE();
        DeviceList deviceList = getHomeDispenserAtlanticModel().get_device();
        HomeDispenserFragmentDirections.ActionDispenserFragmentToAddLitresFagment actionDispenserFragmentToAddLitresFagment = deviceList != null ? HomeDispenserFragmentDirections.actionDispenserFragmentToAddLitresFagment(deviceList) : null;
        if (actionDispenserFragmentToAddLitresFagment != null) {
            FragmentKt.findNavController(this).navigate(actionDispenserFragmentToAddLitresFagment);
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentHomeDispenserAtlanticBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.dataBinding = dataBinding;
        dataBinding.setViewModel(getHomeDispenserAtlanticModel());
    }

    private final void showBoltSettingsScreen() {
        disConnectBLE();
        DeviceList deviceList = getHomeDispenserAtlanticModel().get_device();
        HomeDispenserFragmentDirections.ActionHomeDispenserFragmentBoltSettingsFragment actionHomeDispenserFragmentBoltSettingsFragment = deviceList != null ? HomeDispenserFragmentDirections.actionHomeDispenserFragmentBoltSettingsFragment(deviceList) : null;
        if (actionHomeDispenserFragmentBoltSettingsFragment != null) {
            FragmentKt.findNavController(this).navigate(actionHomeDispenserFragmentBoltSettingsFragment);
        }
    }

    private final void setupDashboard() {
        getHomeDispenserAtlanticModel().getWaterRemaining().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda23
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m872setupDashboard$lambda11(HomeDispenserAtlanticFragment.this, (Pair) obj);
            }
        });
        getHomeDispenserAtlanticModel().getHardwareUpdate().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m873setupDashboard$lambda12(HomeDispenserAtlanticFragment.this, (Boolean) obj);
            }
        });
        getHomeDispenserAtlanticModel().getSoftwareUpdate().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m874setupDashboard$lambda13(HomeDispenserAtlanticFragment.this, (Boolean) obj);
            }
        });
        getHomeDispenserAtlanticModel().getHardwareVersion().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda18
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m875setupDashboard$lambda14(HomeDispenserAtlanticFragment.this, (String) obj);
            }
        });
        getHomeDispenserAtlanticModel().getSoftwareVersion().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda17
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m876setupDashboard$lambda15(HomeDispenserAtlanticFragment.this, (String) obj);
            }
        });
        getHomeDispenserAtlanticModel().getPlanDetails().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda16
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m877setupDashboard$lambda16(HomeDispenserAtlanticFragment.this, (String) obj);
            }
        });
        getHomeDispenserAtlanticModel().getFilterLifeImage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m878setupDashboard$lambda17(HomeDispenserAtlanticFragment.this, (Integer) obj);
            }
        });
        getHomeDispenserAtlanticModel().getProductType().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda19
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m879setupDashboard$lambda18(HomeDispenserAtlanticFragment.this, (String) obj);
            }
        });
        getHomeDispenserAtlanticModel().getUsageStats().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda24
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m880setupDashboard$lambda19(HomeDispenserAtlanticFragment.this, (Triple) obj);
            }
        });
        getHomeDispenserAtlanticModel().getLastSynchronizedDate().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda21
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m881setupDashboard$lambda20(HomeDispenserAtlanticFragment.this, (String) obj);
            }
        });
        getHomeDispenserAtlanticModel().getTds_selected_image().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m882setupDashboard$lambda21(HomeDispenserAtlanticFragment.this, (Integer) obj);
            }
        });
        getHomeDispenserAtlanticModel().getHotWaterImage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda15
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m883setupDashboard$lambda22(HomeDispenserAtlanticFragment.this, (Integer) obj);
            }
        });
        getHomeDispenserAtlanticModel().getColdWaterImage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m884setupDashboard$lambda23(HomeDispenserAtlanticFragment.this, (Integer) obj);
            }
        });
        getHomeDispenserAtlanticModel().getPublishCommandStatus().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda20
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m885setupDashboard$lambda24(HomeDispenserAtlanticFragment.this, (String) obj);
            }
        });
        getHomeDispenserAtlanticModel().getDisinfectionImage().observe(this, new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda13
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m886setupDashboard$lambda25(HomeDispenserAtlanticFragment.this, (Integer) obj);
            }
        });
        if (setBluetooth()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new HomeDispenserAtlanticFragment$setupDashboard$16(this, null), 3, null);
        }
        getCommandList();
        getHomeDispenserAtlanticModel().getBoltCommandsResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m887setupDashboard$lambda26(HomeDispenserAtlanticFragment.this, (BoltCommandsResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-11  reason: not valid java name */
    public static final void m872setupDashboard$lambda11(HomeDispenserAtlanticFragment this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (((String) pair.getFirst()).length() != 6 || pair.getSecond() == null) {
            return;
        }
        Object second = pair.getSecond();
        Intrinsics.checkNotNull(second);
        this$0.updateWaterRemainingView((String) pair.getFirst(), ((Number) second).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-12  reason: not valid java name */
    public static final void m873setupDashboard$lambda12(HomeDispenserAtlanticFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boolean booleanValue = it.booleanValue();
        this$0._isHardwareUpdate = booleanValue;
        if (booleanValue) {
            this$0._isFirmwareUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-13  reason: not valid java name */
    public static final void m874setupDashboard$lambda13(HomeDispenserAtlanticFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boolean booleanValue = it.booleanValue();
        this$0._isSoftwareUpdate = booleanValue;
        if (booleanValue) {
            this$0._isFirmwareUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-14  reason: not valid java name */
    public static final void m875setupDashboard$lambda14(HomeDispenserAtlanticFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._hardwareVersion = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-15  reason: not valid java name */
    public static final void m876setupDashboard$lambda15(HomeDispenserAtlanticFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._softwareVersion = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-16  reason: not valid java name */
    public static final void m877setupDashboard$lambda16(HomeDispenserAtlanticFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return;
        }
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding = this$0.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding = null;
        }
        fragmentHomeDispenserAtlanticBinding.planDetails.setText(str2);
        if (this$0.isAdded()) {
            UserRepository.Companion companion = UserRepository.Companion;
            FragmentActivity requireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            companion.getInstance(requireActivity).setUser(LSApplication.Companion.getUser());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-17  reason: not valid java name */
    public static final void m878setupDashboard$lambda17(HomeDispenserAtlanticFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null && it.intValue() == -1) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateFilterLifeImage(it.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-18  reason: not valid java name */
    public static final void m879setupDashboard$lambda18(HomeDispenserAtlanticFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding = this$0.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding = null;
        }
        fragmentHomeDispenserAtlanticBinding.remainingWaterLabel.setText(R.string.label_water_remaining);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-19  reason: not valid java name */
    public static final void m880setupDashboard$lambda19(HomeDispenserAtlanticFragment this$0, Triple triple) {
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
    /* renamed from: setupDashboard$lambda-20  reason: not valid java name */
    public static final void m881setupDashboard$lambda20(HomeDispenserAtlanticFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = this$0.requireActivity().getString(R.string.last_synchronized_on) + SafeJsonPrimitive.NULL_CHAR + str;
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding = this$0.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding = null;
        }
        fragmentHomeDispenserAtlanticBinding.lastSynchronized.setText(str2);
        this$0.showBottomOptions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-21  reason: not valid java name */
    public static final void m882setupDashboard$lambda21(HomeDispenserAtlanticFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding = this$0.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding = null;
        }
        ImageView imageView = fragmentHomeDispenserAtlanticBinding.tdsBandImage;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), it.intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-22  reason: not valid java name */
    public static final void m883setupDashboard$lambda22(HomeDispenserAtlanticFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding = this$0.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding = null;
        }
        ImageView imageView = fragmentHomeDispenserAtlanticBinding.hotWaterImage;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), it.intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-23  reason: not valid java name */
    public static final void m884setupDashboard$lambda23(HomeDispenserAtlanticFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding = this$0.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding = null;
        }
        ImageView imageView = fragmentHomeDispenserAtlanticBinding.coldWaterImage;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), it.intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-24  reason: not valid java name */
    public static final void m885setupDashboard$lambda24(HomeDispenserAtlanticFragment this$0, String str) {
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
        BuildersKt__Builders_commonKt.launch$default(this$0, null, null, new HomeDispenserAtlanticFragment$setupDashboard$14$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-25  reason: not valid java name */
    public static final void m886setupDashboard$lambda25(HomeDispenserAtlanticFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding = this$0.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding = null;
        }
        MenuItem item = fragmentHomeDispenserAtlanticBinding.bottomNavigationId.getMenu().getItem(3);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        item.setIcon(it.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-26  reason: not valid java name */
    public static final void m887setupDashboard$lambda26(HomeDispenserAtlanticFragment this$0, BoltCommandsResponse boltCommandsResponse) {
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
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding = this.dataBinding;
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding2 = null;
        if (fragmentHomeDispenserAtlanticBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding = null;
        }
        fragmentHomeDispenserAtlanticBinding.waterRemainingHundredThousands.setText(String.valueOf(str.charAt(0)));
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding3 = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding3 = null;
        }
        fragmentHomeDispenserAtlanticBinding3.waterRemainingTenThousands.setText(String.valueOf(str.charAt(1)));
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding4 = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding4 = null;
        }
        fragmentHomeDispenserAtlanticBinding4.waterRemainingThousands.setText(String.valueOf(str.charAt(2)));
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding5 = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding5 = null;
        }
        fragmentHomeDispenserAtlanticBinding5.waterRemainingHundreds.setText(String.valueOf(str.charAt(3)));
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding6 = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding6 = null;
        }
        fragmentHomeDispenserAtlanticBinding6.waterRemainingTens.setText(String.valueOf(str.charAt(4)));
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding7 = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding7 = null;
        }
        fragmentHomeDispenserAtlanticBinding7.waterRemainingOnes.setText(String.valueOf(str.charAt(5)));
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding8 = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentHomeDispenserAtlanticBinding2 = fragmentHomeDispenserAtlanticBinding8;
        }
        fragmentHomeDispenserAtlanticBinding2.waterDispenseUsageImage.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
    }

    private final void updateFilterLifeImage(int i) {
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding = null;
        }
        fragmentHomeDispenserAtlanticBinding.filterLifeImage.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
    }

    private final void setupUsageStats(List<String> list, List<? extends IBarDataSet> list2, String str) {
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding = this.dataBinding;
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding2 = null;
        if (fragmentHomeDispenserAtlanticBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding = null;
        }
        Context context = fragmentHomeDispenserAtlanticBinding.barChart.getContext();
        Integer valueOf = context != null ? Integer.valueOf(UiUtilKt.getColorFromAttr$default(context, R.attr.colorOnSurface, null, false, 6, null)) : null;
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding3 = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding3 = null;
        }
        BarChart barChart = fragmentHomeDispenserAtlanticBinding3.barChart;
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
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding4 = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentHomeDispenserAtlanticBinding2 = fragmentHomeDispenserAtlanticBinding4;
        }
        fragmentHomeDispenserAtlanticBinding2.averageWaterConsumption.setText(str);
    }

    private final void showBottomOptions() {
        this.bottomOptionList.clear();
        Iterator it = ArraysKt.toList(this.bottomOptionIcons).iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            DispenserBottomOption dispenserBottomOption = new DispenserBottomOption(null, null, 3, null);
            dispenserBottomOption.setIcon(this.bottomOptionIcons[i]);
            dispenserBottomOption.setTitle(this.bottomOptionTitle[i]);
            this.bottomOptionList.add(dispenserBottomOption);
            i++;
        }
    }

    private final void sendCommand(int i) {
        if (i == 0) {
            showDispenseDialog("Dispense");
        } else if (i == 1) {
            showDispenseDialog("TDS");
        } else if (i == 2) {
            showDispenseDialog("Temp");
        } else if (i != 3) {
        } else {
            if (Intrinsics.areEqual(getHomeDispenserAtlanticModel().getDisinfection(), AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                if (this.mBleConnected) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String COMMAND_BOTTLE_DISINFECTION_ON = AppConstants.COMMAND_BOTTLE_DISINFECTION_ON;
                    Intrinsics.checkNotNullExpressionValue(COMMAND_BOTTLE_DISINFECTION_ON, "COMMAND_BOTTLE_DISINFECTION_ON");
                    String format = String.format(COMMAND_BOTTLE_DISINFECTION_ON, Arrays.copyOf(new Object[0], 0));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    CommandPublish(format);
                    return;
                }
                getHomeDispenserAtlanticModel().publishCommand("11", "", "", "");
            } else if (Intrinsics.areEqual(getHomeDispenserAtlanticModel().getDisinfection(), "1")) {
                if (this.mBleConnected) {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String COMMAND_BOTTLE_DISINFECTION_OFF = AppConstants.COMMAND_BOTTLE_DISINFECTION_OFF;
                    Intrinsics.checkNotNullExpressionValue(COMMAND_BOTTLE_DISINFECTION_OFF, "COMMAND_BOTTLE_DISINFECTION_OFF");
                    String format2 = String.format(COMMAND_BOTTLE_DISINFECTION_OFF, Arrays.copyOf(new Object[0], 0));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                    CommandPublish(format2);
                } else {
                    getHomeDispenserAtlanticModel().publishCommand("12", "", "", "");
                }
                FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding = this.dataBinding;
                if (fragmentHomeDispenserAtlanticBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                    fragmentHomeDispenserAtlanticBinding = null;
                }
                fragmentHomeDispenserAtlanticBinding.bottomNavigationId.getMenu().getItem(3).setIcon(R.drawable.ic_disinfection_off);
            }
        }
    }

    private final void showDispenseDialog(String str) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        int hashCode = str.hashCode();
        if (hashCode == 82915) {
            if (str.equals("TDS")) {
                View inflate = getLayoutInflater().inflate(R.layout.tds_band, (ViewGroup) null);
                Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(R.layout.tds_band, null)");
                bottomSheetDialog.setContentView(inflate);
                final ImageView imageView = (ImageView) bottomSheetDialog.findViewById(R.id.ivTDS1);
                final ImageView imageView2 = (ImageView) bottomSheetDialog.findViewById(R.id.ivTDS2);
                final ImageView imageView3 = (ImageView) bottomSheetDialog.findViewById(R.id.ivTDS3);
                LinearLayout linearLayout = (LinearLayout) bottomSheetDialog.findViewById(R.id.llTDS1);
                LinearLayout linearLayout2 = (LinearLayout) bottomSheetDialog.findViewById(R.id.llTDS2);
                LinearLayout linearLayout3 = (LinearLayout) bottomSheetDialog.findViewById(R.id.llTDS3);
                getHomeDispenserAtlanticModel().getTds_selected().observe(this, new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda5
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeDispenserAtlanticFragment.m893showDispenseDialog$lambda32(imageView, this, imageView2, imageView3, (Triple) obj);
                    }
                });
                if (linearLayout != null) {
                    linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HomeDispenserAtlanticFragment.m894showDispenseDialog$lambda33(HomeDispenserAtlanticFragment.this, bottomSheetDialog, view);
                        }
                    });
                }
                if (linearLayout2 != null) {
                    linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HomeDispenserAtlanticFragment.m895showDispenseDialog$lambda34(HomeDispenserAtlanticFragment.this, bottomSheetDialog, view);
                        }
                    });
                }
                if (linearLayout3 != null) {
                    linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda32
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HomeDispenserAtlanticFragment.m896showDispenseDialog$lambda35(HomeDispenserAtlanticFragment.this, bottomSheetDialog, view);
                        }
                    });
                }
                bottomSheetDialog.show();
            }
        } else if (hashCode != 2602996) {
            if (hashCode == 349529469 && str.equals("Dispense")) {
                View inflate2 = getLayoutInflater().inflate(R.layout.dispenser_popup, (ViewGroup) null);
                Intrinsics.checkNotNullExpressionValue(inflate2, "layoutInflater.inflate(R…ut.dispenser_popup, null)");
                bottomSheetDialog.setContentView(inflate2);
                final ImageView imageView4 = (ImageView) bottomSheetDialog.findViewById(R.id.waterDispensingImage);
                getHomeDispenserAtlanticModel().getLiveDispenserStatusImage().observe(this, new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda4
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeDispenserAtlanticFragment.m890showDispenseDialog$lambda29(imageView4, this, (Integer) obj);
                    }
                });
                if (imageView4 != null) {
                    imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda27
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HomeDispenserAtlanticFragment.m891showDispenseDialog$lambda30(HomeDispenserAtlanticFragment.this, view);
                        }
                    });
                }
                bottomSheetDialog.show();
            }
        } else if (str.equals("Temp")) {
            View inflate3 = getLayoutInflater().inflate(R.layout.bottom_sheet_temperature, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate3, "layoutInflater.inflate(R…_sheet_temperature, null)");
            bottomSheetDialog.setContentView(inflate3);
            TextView textView = (TextView) bottomSheetDialog.findViewById(R.id.tvSaveButton);
            String[] stringArray = getResources().getStringArray(R.array.temperature);
            Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(R.array.temperature)");
            final Spinner spinner = (Spinner) bottomSheetDialog.findViewById(R.id.spinner_hot_water);
            Spinner spinner2 = (Spinner) bottomSheetDialog.findViewById(R.id.spinner_warm_water);
            LinearLayout linearLayout4 = (LinearLayout) bottomSheetDialog.findViewById(R.id.llWarmWater);
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
            if (spinner != null) {
                spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(inflate3.getContext(), 17367043, stringArray));
                String hotWaterTemprature = getHomeDispenserAtlanticModel().getHotWaterTemprature();
                if (Intrinsics.areEqual(hotWaterTemprature, "78")) {
                    spinner.setSelection(1);
                } else if (Intrinsics.areEqual(hotWaterTemprature, "82 ")) {
                    spinner.setSelection(2);
                } else {
                    spinner.setSelection(0);
                }
            }
            if (spinner2 != null) {
                spinner2.setAdapter((SpinnerAdapter) new ArrayAdapter(inflate3.getContext(), 17367043, stringArray));
            }
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda11
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeDispenserAtlanticFragment.m892showDispenseDialog$lambda31(spinner, this, bottomSheetDialog, view);
                    }
                });
            }
            bottomSheetDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDispenseDialog$lambda-29  reason: not valid java name */
    public static final void m890showDispenseDialog$lambda29(ImageView imageView, HomeDispenserAtlanticFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (imageView != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), it.intValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDispenseDialog$lambda-30  reason: not valid java name */
    public static final void m891showDispenseDialog$lambda30(HomeDispenserAtlanticFragment this$0, View view) {
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
            if (Intrinsics.areEqual(this$0.getHomeDispenserAtlanticModel().getDispenserStatus(), "1")) {
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
        if (Intrinsics.areEqual(this$0.getHomeDispenserAtlanticModel().getDispenserStatus(), "1")) {
            this$0.getHomeDispenserAtlanticModel().publishCommand("05", "", "", "");
        } else {
            this$0.getHomeDispenserAtlanticModel().publishCommand("04", "", "", "");
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
    /* renamed from: showDispenseDialog$lambda-31  reason: not valid java name */
    public static final void m892showDispenseDialog$lambda31(Spinner spinner, HomeDispenserAtlanticFragment this$0, BottomSheetDialog dialoglog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialoglog, "$dialoglog");
        int selectedItemId = spinner != null ? (int) spinner.getSelectedItemId() : 0;
        AnimProgressBar animProgressBar = this$0.animProgressBar;
        AnimProgressBar animProgressBar2 = null;
        if (animProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            animProgressBar = null;
        }
        animProgressBar.show();
        if (this$0.mBleConnected) {
            if (selectedItemId == 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String COMMAND_HOT_WATER = AppConstants.COMMAND_HOT_WATER;
                Intrinsics.checkNotNullExpressionValue(COMMAND_HOT_WATER, "COMMAND_HOT_WATER");
                String format = String.format(COMMAND_HOT_WATER, Arrays.copyOf(new Object[]{"74"}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                this$0.CommandPublish(format);
            } else if (selectedItemId == 1) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String COMMAND_HOT_WATER2 = AppConstants.COMMAND_HOT_WATER;
                Intrinsics.checkNotNullExpressionValue(COMMAND_HOT_WATER2, "COMMAND_HOT_WATER");
                String format2 = String.format(COMMAND_HOT_WATER2, Arrays.copyOf(new Object[]{"78"}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                this$0.CommandPublish(format2);
            } else if (selectedItemId == 2) {
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String COMMAND_HOT_WATER3 = AppConstants.COMMAND_HOT_WATER;
                Intrinsics.checkNotNullExpressionValue(COMMAND_HOT_WATER3, "COMMAND_HOT_WATER");
                String format3 = String.format(COMMAND_HOT_WATER3, Arrays.copyOf(new Object[]{"82"}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
                this$0.CommandPublish(format3);
            }
            AnimProgressBar animProgressBar3 = this$0.animProgressBar;
            if (animProgressBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            } else {
                animProgressBar2 = animProgressBar3;
            }
            animProgressBar2.dismiss();
        } else {
            if (selectedItemId == 0) {
                this$0.getHomeDispenserAtlanticModel().publishCommand("02", "", "74", "");
            } else if (selectedItemId == 1) {
                this$0.getHomeDispenserAtlanticModel().publishCommand("02", "", "78", "");
            } else if (selectedItemId == 2) {
                this$0.getHomeDispenserAtlanticModel().publishCommand("02", "", "82", "");
            }
            AnimProgressBar animProgressBar4 = this$0.animProgressBar;
            if (animProgressBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            } else {
                animProgressBar2 = animProgressBar4;
            }
            animProgressBar2.dismiss();
        }
        dialoglog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDispenseDialog$lambda-32  reason: not valid java name */
    public static final void m893showDispenseDialog$lambda32(ImageView imageView, HomeDispenserAtlanticFragment this$0, ImageView imageView2, ImageView imageView3, Triple triple) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), ((Number) triple.getFirst()).intValue()));
        }
        if (imageView2 != null) {
            imageView2.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), ((Number) triple.getSecond()).intValue()));
        }
        if (imageView3 != null) {
            imageView3.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), ((Number) triple.getThird()).intValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDispenseDialog$lambda-33  reason: not valid java name */
    public static final void m894showDispenseDialog$lambda33(HomeDispenserAtlanticFragment this$0, BottomSheetDialog dialoglog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialoglog, "$dialoglog");
        AnimProgressBar animProgressBar = this$0.animProgressBar;
        AnimProgressBar animProgressBar2 = null;
        if (animProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            animProgressBar = null;
        }
        animProgressBar.show();
        if (this$0.mBleConnected) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String COMMAND_TDS_SETTING = AppConstants.COMMAND_TDS_SETTING;
            Intrinsics.checkNotNullExpressionValue(COMMAND_TDS_SETTING, "COMMAND_TDS_SETTING");
            String format = String.format(COMMAND_TDS_SETTING, Arrays.copyOf(new Object[]{"1"}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            this$0.CommandPublish(format);
            AnimProgressBar animProgressBar3 = this$0.animProgressBar;
            if (animProgressBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            } else {
                animProgressBar2 = animProgressBar3;
            }
            animProgressBar2.dismiss();
            dialoglog.dismiss();
            return;
        }
        this$0.getHomeDispenserAtlanticModel().publishCommand("03", "", "", "1");
        AnimProgressBar animProgressBar4 = this$0.animProgressBar;
        if (animProgressBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
        } else {
            animProgressBar2 = animProgressBar4;
        }
        animProgressBar2.dismiss();
        dialoglog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDispenseDialog$lambda-34  reason: not valid java name */
    public static final void m895showDispenseDialog$lambda34(HomeDispenserAtlanticFragment this$0, BottomSheetDialog dialoglog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialoglog, "$dialoglog");
        AnimProgressBar animProgressBar = this$0.animProgressBar;
        AnimProgressBar animProgressBar2 = null;
        if (animProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            animProgressBar = null;
        }
        animProgressBar.show();
        if (this$0.mBleConnected) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String COMMAND_TDS_SETTING = AppConstants.COMMAND_TDS_SETTING;
            Intrinsics.checkNotNullExpressionValue(COMMAND_TDS_SETTING, "COMMAND_TDS_SETTING");
            String format = String.format(COMMAND_TDS_SETTING, Arrays.copyOf(new Object[]{ExifInterface.GPS_MEASUREMENT_2D}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            this$0.CommandPublish(format);
            AnimProgressBar animProgressBar3 = this$0.animProgressBar;
            if (animProgressBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            } else {
                animProgressBar2 = animProgressBar3;
            }
            animProgressBar2.dismiss();
            dialoglog.dismiss();
            return;
        }
        this$0.getHomeDispenserAtlanticModel().publishCommand("03", "", "", ExifInterface.GPS_MEASUREMENT_2D);
        AnimProgressBar animProgressBar4 = this$0.animProgressBar;
        if (animProgressBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
        } else {
            animProgressBar2 = animProgressBar4;
        }
        animProgressBar2.dismiss();
        dialoglog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDispenseDialog$lambda-35  reason: not valid java name */
    public static final void m896showDispenseDialog$lambda35(HomeDispenserAtlanticFragment this$0, BottomSheetDialog dialoglog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialoglog, "$dialoglog");
        AnimProgressBar animProgressBar = this$0.animProgressBar;
        AnimProgressBar animProgressBar2 = null;
        if (animProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            animProgressBar = null;
        }
        animProgressBar.show();
        if (this$0.mBleConnected) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String COMMAND_TDS_SETTING = AppConstants.COMMAND_TDS_SETTING;
            Intrinsics.checkNotNullExpressionValue(COMMAND_TDS_SETTING, "COMMAND_TDS_SETTING");
            String format = String.format(COMMAND_TDS_SETTING, Arrays.copyOf(new Object[]{ExifInterface.GPS_MEASUREMENT_3D}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            this$0.CommandPublish(format);
            AnimProgressBar animProgressBar3 = this$0.animProgressBar;
            if (animProgressBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            } else {
                animProgressBar2 = animProgressBar3;
            }
            animProgressBar2.dismiss();
            dialoglog.dismiss();
            return;
        }
        this$0.getHomeDispenserAtlanticModel().publishCommand("03", "", "", ExifInterface.GPS_MEASUREMENT_3D);
        AnimProgressBar animProgressBar4 = this$0.animProgressBar;
        if (animProgressBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
        } else {
            animProgressBar2 = animProgressBar4;
        }
        animProgressBar2.dismiss();
        dialoglog.dismiss();
    }

    private final void showDialog(String str, String str2, final boolean z) {
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
        ((Button) dialog.findViewById(R.id.cancel_btn)).setVisibility(8);
        button2.setText(getString(R.string.ok));
        button.setText(getString(R.string.cancel));
        ((TextView) dialog.findViewById(R.id.header)).setText(str);
        ((TextView) dialog.findViewById(R.id.msg_txt)).setText(StringsKt.trimIndent(str2));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeDispenserAtlanticFragment.m889showDialog$lambda38(z, this, dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDialog$lambda-38  reason: not valid java name */
    public static final void m889showDialog$lambda38(boolean z, HomeDispenserAtlanticFragment this$0, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            if (this$0.mBleConnected) {
                if (Intrinsics.areEqual(this$0.getHomeDispenserAtlanticModel().getHotWaterValue(), "1")) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String COMMAND_HEATER_OFF = AppConstants.COMMAND_HEATER_OFF;
                    Intrinsics.checkNotNullExpressionValue(COMMAND_HEATER_OFF, "COMMAND_HEATER_OFF");
                    String format = String.format(COMMAND_HEATER_OFF, Arrays.copyOf(new Object[0], 0));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    this$0.CommandPublish(format);
                } else {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String COMMAND_HEATER_ON = AppConstants.COMMAND_HEATER_ON;
                    Intrinsics.checkNotNullExpressionValue(COMMAND_HEATER_ON, "COMMAND_HEATER_ON");
                    String format2 = String.format(COMMAND_HEATER_ON, Arrays.copyOf(new Object[0], 0));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                    this$0.CommandPublish(format2);
                }
            } else if (Intrinsics.areEqual(this$0.getHomeDispenserAtlanticModel().getHotWaterValue(), "1")) {
                this$0.getHomeDispenserAtlanticModel().publishCommand("07", "", "", "");
            } else {
                this$0.getHomeDispenserAtlanticModel().publishCommand("06", "", "", "");
            }
        } else if (this$0.mBleConnected) {
            if (Intrinsics.areEqual(this$0.getHomeDispenserAtlanticModel().getColdWaterValue(), "1")) {
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String COMMAND_COOLIN_OFF = AppConstants.COMMAND_COOLIN_OFF;
                Intrinsics.checkNotNullExpressionValue(COMMAND_COOLIN_OFF, "COMMAND_COOLIN_OFF");
                String format3 = String.format(COMMAND_COOLIN_OFF, Arrays.copyOf(new Object[0], 0));
                Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
                this$0.CommandPublish(format3);
            } else {
                StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                String COMMAND_COOLIN_ON = AppConstants.COMMAND_COOLIN_ON;
                Intrinsics.checkNotNullExpressionValue(COMMAND_COOLIN_ON, "COMMAND_COOLIN_ON");
                String format4 = String.format(COMMAND_COOLIN_ON, Arrays.copyOf(new Object[0], 0));
                Intrinsics.checkNotNullExpressionValue(format4, "format(format, *args)");
                this$0.CommandPublish(format4);
            }
        } else if (Intrinsics.areEqual(this$0.getHomeDispenserAtlanticModel().getColdWaterValue(), "1")) {
            this$0.getHomeDispenserAtlanticModel().publishCommand("14", "", "", "");
        } else {
            this$0.getHomeDispenserAtlanticModel().publishCommand("13", "", "", "");
        }
        dialog.dismiss();
    }

    private final void CommandPublish(String str) {
        if (Intrinsics.areEqual(publishToDeviceCommand(str), "succes")) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserAtlanticFragment$CommandPublish$1(this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void publishCommandLoop() {
        try {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserAtlanticFragment$publishCommandLoop$1(this, null), 3, null);
        } catch (Exception e) {
            Log.e(AgentHealth.DEFAULT_KEY, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupBluetooth() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s-%s", Arrays.copyOf(new Object[]{"LIVSMT-RO", StringsKt.takeLast(getHomeDispenserAtlanticModel().getImeiNumber(), 4)}, 2));
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
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HomeDispenserAtlanticFragment$scanLeDevice$1(this, null), 3, null);
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
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HomeDispenserAtlanticFragment$scanLeDevice$2(this, null), 3, null);
            BluetoothLeScanner bluetoothLeScanner2 = this.mBluetoothLeScanner;
            Intrinsics.checkNotNull(bluetoothLeScanner2);
            bluetoothLeScanner2.startScan(this.scanCallback);
            this.mScanning = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addBluetoothDevice(BluetoothDevice bluetoothDevice) {
        showToastMessage("addBluetoothDevice");
        if (isAdded()) {
            if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                bluetoothDevice.getName();
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
            } else {
                bluetoothDevice.getName();
                if (bluetoothDevice.getName() != null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connectWithBle() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserAtlanticFragment$connectWithBle$1(this, null), 3, null);
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
        this.bleCommandList.clear();
        getHomeDispenserAtlanticModel().getPendingBleCommand();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayData(String str) {
        List<String> lines;
        String decrypt;
        List<String> lines2;
        String decrypt2;
        getHomeDispenserAtlanticModel().getBleImage().observe(this, new Observer() { // from class: com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$$ExternalSyntheticLambda14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeDispenserAtlanticFragment.m864displayData$lambda39(HomeDispenserAtlanticFragment.this, (Integer) obj);
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
                        HomeDispenserAtlanticModel homeDispenserAtlanticModel = getHomeDispenserAtlanticModel();
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonData.toString()");
                        homeDispenserAtlanticModel.bleStatus(jSONObject2);
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
                            BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserAtlanticFragment$displayData$3(this, null), 3, null);
                            return;
                        }
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserAtlanticFragment$displayData$2(this, null), 3, null);
                    showToastMessage("Long Data : ");
                } catch (Exception unused) {
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserAtlanticFragment$displayData$4(this, null), 3, null);
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
                    HomeDispenserAtlanticModel homeDispenserAtlanticModel2 = getHomeDispenserAtlanticModel();
                    String jSONObject6 = jSONObject5.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject6, "jsonData.toString()");
                    homeDispenserAtlanticModel2.bleStatus(jSONObject6);
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
                        BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserAtlanticFragment$displayData$6(this, null), 3, null);
                        return;
                    }
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserAtlanticFragment$displayData$5(this, null), 3, null);
                showToastMessage("Long Data : ");
            } catch (Exception unused2) {
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserAtlanticFragment$displayData$7(this, null), 3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: displayData$lambda-39  reason: not valid java name */
    public static final void m864displayData$lambda39(HomeDispenserAtlanticFragment this$0, Integer it) {
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
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserAtlanticFragment$sendToBLEJsonData$1(this, null), 3, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void updateBleWiFiImage(int i) {
        FragmentHomeDispenserAtlanticBinding fragmentHomeDispenserAtlanticBinding = this.dataBinding;
        if (fragmentHomeDispenserAtlanticBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentHomeDispenserAtlanticBinding = null;
        }
        fragmentHomeDispenserAtlanticBinding.bleInfoIV.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
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

    private final void showToastMessage(String str) {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeDispenserAtlanticFragment$showToastMessage$1(null), 3, null);
    }

    @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
    public boolean onNavigationItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        switch (item.getItemId()) {
            case R.id.action_dis_infection_id /* 2131361867 */:
                sendCommand(3);
                break;
            case R.id.action_dispense_id /* 2131361868 */:
                sendCommand(0);
                break;
            case R.id.action_tds_band_id /* 2131361928 */:
                sendCommand(1);
                break;
            case R.id.action_temp_setting_id /* 2131361929 */:
                sendCommand(2);
                break;
            default:
                return false;
        }
        return true;
    }
}
