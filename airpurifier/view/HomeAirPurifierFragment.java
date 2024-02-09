package com.livpure.safedrink.airpurifier.view;

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
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.livpure.safedrink.R;
import com.livpure.safedrink.airpurifier.data.models.ImageStatus;
import com.livpure.safedrink.airpurifier.model.HomePurifierModel;
import com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragmentDirections;
import com.livpure.safedrink.airpurifier.view.adapter.AirPurifierBottomOptionAdapter;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import com.livpure.safedrink.bolt.data.models.RechargeResponse;
import com.livpure.safedrink.bolt.service.Base64Hex;
import com.livpure.safedrink.bolt.service.Encrypt;
import com.livpure.safedrink.common.UiUtilKt;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.DialogAirPurifierBottomSheetBinding;
import com.livpure.safedrink.databinding.FragmentHomeAirpurifierBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.model.AirPurifierBottomOption;
import com.livpure.safedrink.servicebluetooth.BluetoothLeService;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.utils.AnimProgressBar;
import com.livpure.safedrink.utils.AppConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
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
/* compiled from: HomeAirPurifierFragment.kt */
@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010R\u001a\u00020S2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010T\u001a\u00020S2\u0006\u0010!\u001a\u00020\u0002H\u0016J\u0012\u0010U\u001a\u00020V2\n\u0010W\u001a\u00020X\"\u00020\u0007J\b\u0010Y\u001a\u00020/H\u0002J\u0010\u0010Z\u001a\u00020S2\u0006\u0010[\u001a\u00020\fH\u0002J\b\u0010\\\u001a\u00020SH\u0002J\b\u0010]\u001a\u00020SH\u0002J\u0012\u0010^\u001a\u00020S2\b\u0010_\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010b\u001a\u00020\fH\u0002J\b\u0010c\u001a\u00020SH\u0002J\b\u0010d\u001a\u00020SH\u0002J\b\u0010e\u001a\u00020SH\u0002J\b\u0010f\u001a\u00020\u0007H\u0014J\b\u0010g\u001a\u00020hH\u0014J\u0018\u0010i\u001a\u00020S2\u000e\u0010j\u001a\n\u0012\u0004\u0012\u00020l\u0018\u00010kH\u0002J\u0010\u0010m\u001a\u00020S2\u0006\u0010n\u001a\u00020/H\u0002J\u0010\u0010o\u001a\u00020\f2\b\u0010p\u001a\u0004\u0018\u00010\fJ\u0012\u0010q\u001a\u00020S2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\b\u0010t\u001a\u00020SH\u0016J\u001a\u0010u\u001a\u00020S2\b\u0010v\u001a\u0004\u0018\u00010w2\u0006\u0010x\u001a\u00020\u0007H\u0016J\u0006\u0010y\u001a\u00020SJ\u001a\u0010z\u001a\u00020S2\u0006\u0010v\u001a\u00020w2\b\u0010r\u001a\u0004\u0018\u00010sH\u0017J\u0014\u0010{\u001a\u0004\u0018\u00010\f2\b\u0010|\u001a\u0004\u0018\u00010VH\u0002J\u0014\u0010}\u001a\u0004\u0018\u00010\f2\b\u0010|\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010~\u001a\u00020SH\u0002J\u0010\u0010\u007f\u001a\u00020S2\u0006\u0010x\u001a\u00020\u0007H\u0002J\u0012\u0010\u0080\u0001\u001a\u00020S2\u0007\u0010\u0081\u0001\u001a\u00020\fH\u0002J\u0010\u0010\u0082\u0001\u001a\u00020/2\u0007\u0010\u0083\u0001\u001a\u00020/J\u0016\u0010\u0084\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010BH\u0002J\t\u0010\u0086\u0001\u001a\u00020SH\u0002JX\u0010\u0087\u0001\u001a\u00020S2\u0017\u0010\u0088\u0001\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0015j\b\u0012\u0004\u0012\u00020\f`\u00162\u0019\u0010\u0089\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u008a\u00010\u0015j\t\u0012\u0005\u0012\u00030\u008a\u0001`\u00162\u0019\u0010\u008b\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u008a\u00010\u0015j\t\u0012\u0005\u0012\u00030\u008a\u0001`\u0016H\u0002J\t\u0010\u008c\u0001\u001a\u00020SH\u0002J\t\u0010\u008d\u0001\u001a\u00020SH\u0002J\u0012\u0010\u008e\u0001\u001a\u00020S2\u0007\u0010\u008f\u0001\u001a\u00020\fH\u0002J\t\u0010\u0090\u0001\u001a\u00020SH\u0002J\u000f\u0010\u0091\u0001\u001a\u00020S2\u0006\u0010|\u001a\u00020\fJ\u001d\u0010\u0092\u0001\u001a\u00020S2\t\b\u0001\u0010\u0093\u0001\u001a\u00020\u00072\u0007\u0010\u0094\u0001\u001a\u00020\fH\u0002J\u0012\u0010\u0095\u0001\u001a\u00020S2\u0007\u0010\u0085\u0001\u001a\u00020BH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R2\u0010\u0010\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0015j\b\u0012\u0004\u0012\u00020\f`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\"\u00102\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010J\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bL\u0010MR\u000e\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0096\u0001"}, d2 = {"Lcom/livpure/safedrink/airpurifier/view/HomeAirPurifierFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentHomeAirpurifierBinding;", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "LOCATION_PERMISSION_CODE", "", "SCAN_PERIOD", "", "android12BlePermission", "", "", "[Ljava/lang/String;", "animProgressBar", "Lcom/livpure/safedrink/utils/AnimProgressBar;", "attributes", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "bleCommandList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "bottomOptionIcons", "[Ljava/lang/Integer;", "bottomOptionList", "", "Lcom/livpure/safedrink/model/AirPurifierBottomOption;", "bottomOptionTitle", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "dataBinding", AndroidContextPlugin.DEVICE_KEY, "Landroid/bluetooth/BluetoothDevice;", "dialogAirPurifierBottomSheetBinding", "Lcom/livpure/safedrink/databinding/DialogAirPurifierBottomSheetBinding;", "handler", "Landroid/os/Handler;", "homeAirPurifierViewModel", "Lcom/livpure/safedrink/airpurifier/model/HomePurifierModel;", "getHomeAirPurifierViewModel", "()Lcom/livpure/safedrink/airpurifier/model/HomePurifierModel;", "homeAirPurifierViewModel$delegate", "Lkotlin/Lazy;", "isDisconnected", "", "job", "Lkotlinx/coroutines/Job;", "listBluetoothDevice", "mBleConnected", "mBluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "mBluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "mBluetoothLeScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "mBluetoothLeService", "Lcom/livpure/safedrink/servicebluetooth/BluetoothLeService;", "mConnected", "mDeviceAddress", "mDeviceName", "mGattCallback", "Landroid/bluetooth/BluetoothGattCallback;", "mNotifyCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "mReadCharacteristic", "mReadCharacteristicTemp", "mScanning", "mWriteCharacteristic", "macIdAdd", "myScanRunnable", "Ljava/lang/Runnable;", "navArgs", "Lcom/livpure/safedrink/airpurifier/view/HomeAirPurifierFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/airpurifier/view/HomeAirPurifierFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "scanCallback", "Landroid/bluetooth/le/ScanCallback;", "addBluetoothDevice", "", "bindVariablesToView", "byteArrayOfInts", "", "ints", "", "checkIfLocationPermissionGranted", "commandPublish", "command", "connectWithBle", "disConnectBLE", "displayData", "data", "drawLineGraph", "Landroid/view/View$OnClickListener;", "option", "getBluetoothAdapter", "getBluetoothLeScanner", "getCommandList", "getLayoutId", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "initializeGattServices", "gattServices", "", "Landroid/bluetooth/BluetoothGattService;", "isOutDoorInfo", "isShow", "lookup", AnalyticsAttribute.UUID_ATTRIBUTE, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "position", "onRequestPermissionsResult", "onViewCreated", "publishToDevice", "message", "publishToDeviceCommand", "scanLeDevice", "sendCommand", "sendToBLEJsonData", "value", "setBluetooth", "enable", "setCharData", "characteristic", "setupBluetooth", "setupUsageStats", "dates", "consumptionDataSetList", "Lcom/github/mikephil/charting/data/Entry;", "consumptionDataSetList1", "showBoltSettingsScreen", "showBottomOptions", "showModeDialog", "mode", "showPlanChangeAirScreen", "showToastMessage", "updateBleWiFiImage", "resId", "type", "writeCharacteristic", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeAirPurifierFragment extends DataBindingFragment<FragmentHomeAirpurifierBinding> implements ItemClickListener, CoroutineScope {
    private AnimProgressBar animProgressBar;
    private FragmentHomeAirpurifierBinding dataBinding;
    private BluetoothDevice device;
    private DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding;
    private Handler handler;
    private boolean isDisconnected;
    private Job job;
    private ArrayList<String> listBluetoothDevice;
    private boolean mBleConnected;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothLeScanner mBluetoothLeScanner;
    private BluetoothLeService mBluetoothLeService;
    private boolean mConnected;
    private String mDeviceAddress;
    private String mDeviceName;
    private BluetoothGattCharacteristic mNotifyCharacteristic;
    private BluetoothGattCharacteristic mReadCharacteristic;
    private BluetoothGattCharacteristic mReadCharacteristicTemp;
    private boolean mScanning;
    private BluetoothGattCharacteristic mWriteCharacteristic;
    private Runnable myScanRunnable;
    private final NavArgsLazy navArgs$delegate;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private Integer[] bottomOptionIcons = {Integer.valueOf((int) R.drawable.ic_power_off), Integer.valueOf((int) R.drawable.ic_mode_manual_off), Integer.valueOf((int) R.drawable.ic_fan_speed_1_off), Integer.valueOf((int) R.drawable.ic_ion_off), Integer.valueOf((int) R.drawable.ic_child_lock_off), Integer.valueOf((int) R.drawable.ic_timer_off)};
    private String[] bottomOptionTitle = {"On", "Mode", "Fan", "Ions", "Lock", "Timer"};
    private List<AirPurifierBottomOption> bottomOptionList = new ArrayList();
    private final Lazy homeAirPurifierViewModel$delegate = LazyKt.lazy(new Function0<HomePurifierModel>() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$homeAirPurifierViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HomePurifierModel invoke() {
            HomeAirPurifierFragmentArgs navArgs;
            HomePurifierModel homePurifierModel = (HomePurifierModel) new ViewModelProvider(HomeAirPurifierFragment.this).get(HomePurifierModel.class);
            navArgs = HomeAirPurifierFragment.this.getNavArgs();
            homePurifierModel.setDevice(navArgs.getDevice());
            return homePurifierModel;
        }
    });
    private final String[] android12BlePermission = {"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
    private final long SCAN_PERIOD = 10000;
    private final int LOCATION_PERMISSION_CODE = 2;
    private String macIdAdd = "";
    private final ScanCallback scanCallback = new ScanCallback() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$scanCallback$1
        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            super.onScanResult(i, result);
            HomeAirPurifierFragment homeAirPurifierFragment = HomeAirPurifierFragment.this;
            BluetoothDevice device = result.getDevice();
            Intrinsics.checkNotNullExpressionValue(device, "result.device");
            homeAirPurifierFragment.addBluetoothDevice(device);
        }
    };
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$mGattCallback$1
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
                z = HomeAirPurifierFragment.this.isDisconnected;
                if (!z) {
                    HomeAirPurifierFragment.this.connectWithBle();
                }
                HomeAirPurifierFragment.this.mBleConnected = false;
                HomeAirPurifierFragment.this.mConnected = false;
                BuildersKt__Builders_commonKt.launch$default(HomeAirPurifierFragment.this, null, null, new HomeAirPurifierFragment$mGattCallback$1$onConnectionStateChange$1(null), 3, null);
            } else if (i2 != 2) {
            } else {
                if (ActivityCompat.checkSelfPermission(HomeAirPurifierFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    gatt.requestMtu(500);
                } else if (Build.VERSION.SDK_INT >= 31) {
                    strArr = HomeAirPurifierFragment.this.android12BlePermission;
                    ActivityCompat.requestPermissions(HomeAirPurifierFragment.this.requireActivity(), strArr, 2);
                } else {
                    gatt.requestMtu(500);
                }
                HomeAirPurifierFragment.this.isDisconnected = false;
                HomeAirPurifierFragment.this.mBleConnected = true;
                HomeAirPurifierFragment.this.mConnected = true;
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            String[] strArr;
            if (i2 == 0) {
                if (ActivityCompat.checkSelfPermission(HomeAirPurifierFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    Intrinsics.checkNotNull(bluetoothGatt);
                    bluetoothGatt.discoverServices();
                } else if (Build.VERSION.SDK_INT >= 31) {
                    strArr = HomeAirPurifierFragment.this.android12BlePermission;
                    ActivityCompat.requestPermissions(HomeAirPurifierFragment.this.requireActivity(), strArr, 2);
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
            if (ActivityCompat.checkSelfPermission(HomeAirPurifierFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                if (i != 0) {
                    gatt.discoverServices();
                    return;
                }
                HomeAirPurifierFragment homeAirPurifierFragment = HomeAirPurifierFragment.this;
                bluetoothGatt3 = homeAirPurifierFragment.mBluetoothGatt;
                homeAirPurifierFragment.initializeGattServices(bluetoothGatt3 != null ? bluetoothGatt3.getServices() : null);
                bluetoothGattCharacteristic3 = HomeAirPurifierFragment.this.mReadCharacteristic;
                if (bluetoothGattCharacteristic3 != null) {
                    bluetoothGatt4 = HomeAirPurifierFragment.this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt4);
                    bluetoothGattCharacteristic4 = HomeAirPurifierFragment.this.mReadCharacteristic;
                    bluetoothGatt4.readCharacteristic(bluetoothGattCharacteristic4);
                }
            } else if (Build.VERSION.SDK_INT >= 31) {
                strArr = HomeAirPurifierFragment.this.android12BlePermission;
                ActivityCompat.requestPermissions(HomeAirPurifierFragment.this.requireActivity(), strArr, 2);
            } else if (i != 0) {
                gatt.discoverServices();
            } else {
                HomeAirPurifierFragment homeAirPurifierFragment2 = HomeAirPurifierFragment.this;
                bluetoothGatt = homeAirPurifierFragment2.mBluetoothGatt;
                homeAirPurifierFragment2.initializeGattServices(bluetoothGatt != null ? bluetoothGatt.getServices() : null);
                bluetoothGattCharacteristic = HomeAirPurifierFragment.this.mReadCharacteristic;
                if (bluetoothGattCharacteristic != null) {
                    bluetoothGatt2 = HomeAirPurifierFragment.this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt2);
                    bluetoothGattCharacteristic2 = HomeAirPurifierFragment.this.mReadCharacteristic;
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
                charData = HomeAirPurifierFragment.this.setCharData(characteristic);
                BuildersKt__Builders_commonKt.launch$default(HomeAirPurifierFragment.this, null, null, new HomeAirPurifierFragment$mGattCallback$1$onCharacteristicRead$1(HomeAirPurifierFragment.this, charData, null), 3, null);
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
        return R.layout.fragment_home_airpurifier;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public HomeAirPurifierFragment() {
        final HomeAirPurifierFragment homeAirPurifierFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(HomeAirPurifierFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$special$$inlined$navArgs$1
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
    public final HomeAirPurifierFragmentArgs getNavArgs() {
        return (HomeAirPurifierFragmentArgs) this.navArgs$delegate.getValue();
    }

    private final HomePurifierModel getHomeAirPurifierViewModel() {
        return (HomePurifierModel) this.homeAirPurifierViewModel$delegate.getValue();
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
        ((ImageView) _$_findCachedViewById(R.id.settingsIV)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeAirPurifierFragment.m243onViewCreated$lambda0(HomeAirPurifierFragment.this, view2);
            }
        });
        ((TextView) _$_findCachedViewById(R.id.renewPlan)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeAirPurifierFragment.m244onViewCreated$lambda1(HomeAirPurifierFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.lytOnId)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeAirPurifierFragment.m254onViewCreated$lambda2(HomeAirPurifierFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.lytModeId)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeAirPurifierFragment.m255onViewCreated$lambda3(HomeAirPurifierFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.lytFanId)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeAirPurifierFragment.m256onViewCreated$lambda4(HomeAirPurifierFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.lytIonsId)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeAirPurifierFragment.m257onViewCreated$lambda5(HomeAirPurifierFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.lytLockId)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeAirPurifierFragment.m258onViewCreated$lambda6(HomeAirPurifierFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.lytTimerId)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeAirPurifierFragment.m259onViewCreated$lambda7(HomeAirPurifierFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.openOutdoor)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeAirPurifierFragment.m260onViewCreated$lambda8(HomeAirPurifierFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.closeOutdoor)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeAirPurifierFragment.m261onViewCreated$lambda9(HomeAirPurifierFragment.this, view2);
            }
        });
        this.animProgressBar = new AnimProgressBar(requireContext());
        HomeAirPurifierFragment homeAirPurifierFragment = this;
        getHomeAirPurifierViewModel().getPowerOnStatusImage().observe(homeAirPurifierFragment, new Observer() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda18
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirPurifierFragment.m245onViewCreated$lambda10(HomeAirPurifierFragment.this, (ImageStatus) obj);
            }
        });
        this.handler = new Handler();
        getHomeAirPurifierViewModel().getConnectivityStatus().observe(homeAirPurifierFragment, new Observer() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda23
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirPurifierFragment.m246onViewCreated$lambda12(HomeAirPurifierFragment.this, (String) obj);
            }
        });
        if (LSApplication.Companion.isNetworkAvailable()) {
            getCommandList();
        }
        DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding = null;
        if (setBluetooth(true)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new HomeAirPurifierFragment$onViewCreated$13(this, null), 3, null);
        }
        getHomeAirPurifierViewModel().getDashboardDetails();
        getHomeAirPurifierViewModel().getLoadingStatus().observe(homeAirPurifierFragment, new Observer() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda19
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirPurifierFragment.m248onViewCreated$lambda13(HomeAirPurifierFragment.this, (Boolean) obj);
            }
        });
        ((SwipeRefreshLayout) _$_findCachedViewById(R.id.swipe_refresh_layout_comments)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda26
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                HomeAirPurifierFragment.m249onViewCreated$lambda14(HomeAirPurifierFragment.this);
            }
        });
        FragmentHomeAirpurifierBinding fragmentHomeAirpurifierBinding = this.dataBinding;
        Intrinsics.checkNotNull(fragmentHomeAirpurifierBinding);
        DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding2 = fragmentHomeAirpurifierBinding.includeBottomSheetId;
        Intrinsics.checkNotNullExpressionValue(dialogAirPurifierBottomSheetBinding2, "dataBinding!!.includeBottomSheetId");
        this.dialogAirPurifierBottomSheetBinding = dialogAirPurifierBottomSheetBinding2;
        if (dialogAirPurifierBottomSheetBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
            dialogAirPurifierBottomSheetBinding2 = null;
        }
        dialogAirPurifierBottomSheetBinding2.llDaily.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeAirPurifierFragment.m250onViewCreated$lambda15(HomeAirPurifierFragment.this, view2);
            }
        });
        DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding3 = this.dialogAirPurifierBottomSheetBinding;
        if (dialogAirPurifierBottomSheetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
            dialogAirPurifierBottomSheetBinding3 = null;
        }
        dialogAirPurifierBottomSheetBinding3.llWeekly.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeAirPurifierFragment.m251onViewCreated$lambda16(HomeAirPurifierFragment.this, view2);
            }
        });
        DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding4 = this.dialogAirPurifierBottomSheetBinding;
        if (dialogAirPurifierBottomSheetBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
        } else {
            dialogAirPurifierBottomSheetBinding = dialogAirPurifierBottomSheetBinding4;
        }
        dialogAirPurifierBottomSheetBinding.llMonthly.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeAirPurifierFragment.m252onViewCreated$lambda17(HomeAirPurifierFragment.this, view2);
            }
        });
        getHomeAirPurifierViewModel().getDailyUsageStats().observe(homeAirPurifierFragment, new Observer() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda24
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirPurifierFragment.m253onViewCreated$lambda18(HomeAirPurifierFragment.this, (Triple) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m243onViewCreated$lambda0(HomeAirPurifierFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showBoltSettingsScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m244onViewCreated$lambda1(HomeAirPurifierFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showPlanChangeAirScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m254onViewCreated$lambda2(HomeAirPurifierFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendCommand(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m255onViewCreated$lambda3(HomeAirPurifierFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendCommand(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m256onViewCreated$lambda4(HomeAirPurifierFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendCommand(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-5  reason: not valid java name */
    public static final void m257onViewCreated$lambda5(HomeAirPurifierFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendCommand(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-6  reason: not valid java name */
    public static final void m258onViewCreated$lambda6(HomeAirPurifierFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendCommand(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-7  reason: not valid java name */
    public static final void m259onViewCreated$lambda7(HomeAirPurifierFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendCommand(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-8  reason: not valid java name */
    public static final void m260onViewCreated$lambda8(HomeAirPurifierFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isOutDoorInfo(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-9  reason: not valid java name */
    public static final void m261onViewCreated$lambda9(HomeAirPurifierFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isOutDoorInfo(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-10  reason: not valid java name */
    public static final void m245onViewCreated$lambda10(HomeAirPurifierFragment this$0, ImageStatus imageStatus) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.bottomOptionIcons[0] = Integer.valueOf(imageStatus.getPowerOnImage());
        this$0.bottomOptionIcons[1] = Integer.valueOf(imageStatus.getModeImage());
        this$0.bottomOptionIcons[2] = Integer.valueOf(imageStatus.getFanImage());
        this$0.bottomOptionIcons[3] = Integer.valueOf(imageStatus.getIonsImage());
        this$0.bottomOptionIcons[4] = Integer.valueOf(imageStatus.getLockImage());
        this$0.bottomOptionIcons[5] = Integer.valueOf(imageStatus.getTimerImage());
        this$0.showBottomOptions();
        ImageView imageView = (ImageView) this$0._$_findCachedViewById(R.id.ivPowerOnImage);
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), imageStatus.getPowerOnImage()));
        }
        ImageView imageView2 = (ImageView) this$0._$_findCachedViewById(R.id.ivModeImage);
        if (imageView2 != null) {
            imageView2.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), imageStatus.getModeImage()));
        }
        ImageView imageView3 = (ImageView) this$0._$_findCachedViewById(R.id.ivFanImage);
        if (imageView3 != null) {
            imageView3.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), imageStatus.getFanImage()));
        }
        ImageView imageView4 = (ImageView) this$0._$_findCachedViewById(R.id.ivIonsImage);
        if (imageView4 != null) {
            imageView4.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), imageStatus.getIonsImage()));
        }
        ImageView imageView5 = (ImageView) this$0._$_findCachedViewById(R.id.ivLockImage);
        if (imageView5 != null) {
            imageView5.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), imageStatus.getLockImage()));
        }
        ImageView imageView6 = (ImageView) this$0._$_findCachedViewById(R.id.ivTimerImage);
        if (imageView6 != null) {
            imageView6.setImageDrawable(ContextCompat.getDrawable(this$0.requireActivity(), imageStatus.getTimerImage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-12  reason: not valid java name */
    public static final void m246onViewCreated$lambda12(final HomeAirPurifierFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = it.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, "bluetooth")) {
            return;
        }
        this$0.getHomeAirPurifierViewModel().getWifiImage().observe(this$0, new Observer() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda20
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirPurifierFragment.m247onViewCreated$lambda12$lambda11(HomeAirPurifierFragment.this, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-12$lambda-11  reason: not valid java name */
    public static final void m247onViewCreated$lambda12$lambda11(HomeAirPurifierFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateBleWiFiImage(it.intValue(), "WIFI");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-13  reason: not valid java name */
    public static final void m248onViewCreated$lambda13(HomeAirPurifierFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        AnimProgressBar animProgressBar = null;
        if (it.booleanValue()) {
            AnimProgressBar animProgressBar2 = this$0.animProgressBar;
            if (animProgressBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            } else {
                animProgressBar = animProgressBar2;
            }
            animProgressBar.show();
            return;
        }
        AnimProgressBar animProgressBar3 = this$0.animProgressBar;
        if (animProgressBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
        } else {
            animProgressBar = animProgressBar3;
        }
        animProgressBar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-14  reason: not valid java name */
    public static final void m249onViewCreated$lambda14(HomeAirPurifierFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getHomeAirPurifierViewModel().getDashboardDetails();
        if (this$0.mConnected) {
            if (ActivityCompat.checkSelfPermission(this$0.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                BluetoothGatt bluetoothGatt = this$0.mBluetoothGatt;
                Intrinsics.checkNotNull(bluetoothGatt);
                bluetoothGatt.readCharacteristic(this$0.mReadCharacteristic);
            } else if (Build.VERSION.SDK_INT >= 31) {
                ActivityCompat.requestPermissions(this$0.requireActivity(), this$0.android12BlePermission, 2);
            } else {
                BluetoothGatt bluetoothGatt2 = this$0.mBluetoothGatt;
                Intrinsics.checkNotNull(bluetoothGatt2);
                bluetoothGatt2.readCharacteristic(this$0.mReadCharacteristic);
            }
        }
        ((SwipeRefreshLayout) this$0._$_findCachedViewById(R.id.swipe_refresh_layout_comments)).setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-15  reason: not valid java name */
    public static final void m250onViewCreated$lambda15(HomeAirPurifierFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.drawLineGraph("daily");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-16  reason: not valid java name */
    public static final void m251onViewCreated$lambda16(HomeAirPurifierFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.drawLineGraph("weekly");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-17  reason: not valid java name */
    public static final void m252onViewCreated$lambda17(HomeAirPurifierFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.drawLineGraph("monthly");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-18  reason: not valid java name */
    public static final void m253onViewCreated$lambda18(HomeAirPurifierFragment this$0, Triple triple) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Collection collection = (Collection) triple.getFirst();
        boolean z = true;
        if (collection == null || collection.isEmpty()) {
            return;
        }
        Collection collection2 = (Collection) triple.getSecond();
        if (collection2 == null || collection2.isEmpty()) {
            return;
        }
        Collection collection3 = (Collection) triple.getThird();
        if (collection3 != null && !collection3.isEmpty()) {
            z = false;
        }
        if (z) {
            return;
        }
        DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding = this$0.dialogAirPurifierBottomSheetBinding;
        DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding2 = null;
        if (dialogAirPurifierBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
            dialogAirPurifierBottomSheetBinding = null;
        }
        dialogAirPurifierBottomSheetBinding.llDaily.setBackgroundResource(R.drawable.graph_button_selected);
        DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding3 = this$0.dialogAirPurifierBottomSheetBinding;
        if (dialogAirPurifierBottomSheetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
            dialogAirPurifierBottomSheetBinding3 = null;
        }
        dialogAirPurifierBottomSheetBinding3.llWeekly.setBackgroundResource(0);
        DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding4 = this$0.dialogAirPurifierBottomSheetBinding;
        if (dialogAirPurifierBottomSheetBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
            dialogAirPurifierBottomSheetBinding4 = null;
        }
        dialogAirPurifierBottomSheetBinding4.llMonthly.setBackgroundResource(0);
        DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding5 = this$0.dialogAirPurifierBottomSheetBinding;
        if (dialogAirPurifierBottomSheetBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
            dialogAirPurifierBottomSheetBinding5 = null;
        }
        dialogAirPurifierBottomSheetBinding5.tvDaily.setTextColor(this$0.getResources().getColor(R.color.moe_white));
        DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding6 = this$0.dialogAirPurifierBottomSheetBinding;
        if (dialogAirPurifierBottomSheetBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
            dialogAirPurifierBottomSheetBinding6 = null;
        }
        dialogAirPurifierBottomSheetBinding6.tvWeekly.setTextColor(this$0.getResources().getColor(R.color.color10));
        DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding7 = this$0.dialogAirPurifierBottomSheetBinding;
        if (dialogAirPurifierBottomSheetBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
            dialogAirPurifierBottomSheetBinding7 = null;
        }
        dialogAirPurifierBottomSheetBinding7.tvMonthly.setTextColor(this$0.getResources().getColor(R.color.color10));
        DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding8 = this$0.dialogAirPurifierBottomSheetBinding;
        if (dialogAirPurifierBottomSheetBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
        } else {
            dialogAirPurifierBottomSheetBinding2 = dialogAirPurifierBottomSheetBinding8;
        }
        dialogAirPurifierBottomSheetBinding2.tvSelectionType.setText(R.string.last_24_hours);
        Object first = triple.getFirst();
        Intrinsics.checkNotNull(first);
        Object second = triple.getSecond();
        Intrinsics.checkNotNull(second);
        Object third = triple.getThird();
        Intrinsics.checkNotNull(third);
        this$0.setupUsageStats((ArrayList) first, (ArrayList) second, (ArrayList) third);
    }

    private final View.OnClickListener drawLineGraph(String str) {
        ArrayList<Entry> second;
        ArrayList<Entry> third;
        ArrayList<Entry> second2;
        ArrayList<Entry> third2;
        ArrayList<Entry> second3;
        ArrayList<Entry> third3;
        int hashCode = str.hashCode();
        if (hashCode != -791707519) {
            if (hashCode != 95346201) {
                if (hashCode == 1236635661 && str.equals("monthly")) {
                    DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding = this.dialogAirPurifierBottomSheetBinding;
                    if (dialogAirPurifierBottomSheetBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                        dialogAirPurifierBottomSheetBinding = null;
                    }
                    dialogAirPurifierBottomSheetBinding.llDaily.setBackgroundResource(0);
                    DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding2 = this.dialogAirPurifierBottomSheetBinding;
                    if (dialogAirPurifierBottomSheetBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                        dialogAirPurifierBottomSheetBinding2 = null;
                    }
                    dialogAirPurifierBottomSheetBinding2.llWeekly.setBackgroundResource(0);
                    DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding3 = this.dialogAirPurifierBottomSheetBinding;
                    if (dialogAirPurifierBottomSheetBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                        dialogAirPurifierBottomSheetBinding3 = null;
                    }
                    dialogAirPurifierBottomSheetBinding3.llMonthly.setBackgroundResource(R.drawable.graph_button_selected);
                    DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding4 = this.dialogAirPurifierBottomSheetBinding;
                    if (dialogAirPurifierBottomSheetBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                        dialogAirPurifierBottomSheetBinding4 = null;
                    }
                    dialogAirPurifierBottomSheetBinding4.tvDaily.setTextColor(getResources().getColor(R.color.color10));
                    DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding5 = this.dialogAirPurifierBottomSheetBinding;
                    if (dialogAirPurifierBottomSheetBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                        dialogAirPurifierBottomSheetBinding5 = null;
                    }
                    dialogAirPurifierBottomSheetBinding5.tvWeekly.setTextColor(getResources().getColor(R.color.color10));
                    DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding6 = this.dialogAirPurifierBottomSheetBinding;
                    if (dialogAirPurifierBottomSheetBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                        dialogAirPurifierBottomSheetBinding6 = null;
                    }
                    dialogAirPurifierBottomSheetBinding6.tvMonthly.setTextColor(getResources().getColor(R.color.moe_white));
                    DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding7 = this.dialogAirPurifierBottomSheetBinding;
                    if (dialogAirPurifierBottomSheetBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                        dialogAirPurifierBottomSheetBinding7 = null;
                    }
                    dialogAirPurifierBottomSheetBinding7.tvSelectionType.setText(R.string.last_1_month);
                    getHomeAirPurifierViewModel().getMonthlyGraphData().getFirst();
                    ArrayList<String> first = getHomeAirPurifierViewModel().getMonthlyGraphData().getFirst();
                    if (first != null && (second3 = getHomeAirPurifierViewModel().getMonthlyGraphData().getSecond()) != null && (third3 = getHomeAirPurifierViewModel().getMonthlyGraphData().getThird()) != null && (!first.isEmpty()) && (!second3.isEmpty()) && (!third3.isEmpty())) {
                        setupUsageStats(first, second3, third3);
                    }
                }
            } else if (str.equals("daily")) {
                DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding8 = this.dialogAirPurifierBottomSheetBinding;
                if (dialogAirPurifierBottomSheetBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                    dialogAirPurifierBottomSheetBinding8 = null;
                }
                dialogAirPurifierBottomSheetBinding8.llDaily.setBackgroundResource(R.drawable.graph_button_selected);
                DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding9 = this.dialogAirPurifierBottomSheetBinding;
                if (dialogAirPurifierBottomSheetBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                    dialogAirPurifierBottomSheetBinding9 = null;
                }
                dialogAirPurifierBottomSheetBinding9.llWeekly.setBackgroundResource(0);
                DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding10 = this.dialogAirPurifierBottomSheetBinding;
                if (dialogAirPurifierBottomSheetBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                    dialogAirPurifierBottomSheetBinding10 = null;
                }
                dialogAirPurifierBottomSheetBinding10.llMonthly.setBackgroundResource(0);
                DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding11 = this.dialogAirPurifierBottomSheetBinding;
                if (dialogAirPurifierBottomSheetBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                    dialogAirPurifierBottomSheetBinding11 = null;
                }
                dialogAirPurifierBottomSheetBinding11.tvDaily.setTextColor(getResources().getColor(R.color.moe_white));
                DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding12 = this.dialogAirPurifierBottomSheetBinding;
                if (dialogAirPurifierBottomSheetBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                    dialogAirPurifierBottomSheetBinding12 = null;
                }
                dialogAirPurifierBottomSheetBinding12.tvWeekly.setTextColor(getResources().getColor(R.color.color10));
                DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding13 = this.dialogAirPurifierBottomSheetBinding;
                if (dialogAirPurifierBottomSheetBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                    dialogAirPurifierBottomSheetBinding13 = null;
                }
                dialogAirPurifierBottomSheetBinding13.tvMonthly.setTextColor(getResources().getColor(R.color.color10));
                DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding14 = this.dialogAirPurifierBottomSheetBinding;
                if (dialogAirPurifierBottomSheetBinding14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                    dialogAirPurifierBottomSheetBinding14 = null;
                }
                dialogAirPurifierBottomSheetBinding14.tvSelectionType.setText(R.string.last_24_hours);
                ArrayList<String> first2 = getHomeAirPurifierViewModel().getDailyGraphData().getFirst();
                if (first2 != null && (second2 = getHomeAirPurifierViewModel().getDailyGraphData().getSecond()) != null && (third2 = getHomeAirPurifierViewModel().getDailyGraphData().getThird()) != null && (!first2.isEmpty()) && (!second2.isEmpty()) && (!third2.isEmpty())) {
                    setupUsageStats(first2, second2, third2);
                }
            }
        } else if (str.equals("weekly")) {
            DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding15 = this.dialogAirPurifierBottomSheetBinding;
            if (dialogAirPurifierBottomSheetBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                dialogAirPurifierBottomSheetBinding15 = null;
            }
            dialogAirPurifierBottomSheetBinding15.llDaily.setBackgroundResource(0);
            DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding16 = this.dialogAirPurifierBottomSheetBinding;
            if (dialogAirPurifierBottomSheetBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                dialogAirPurifierBottomSheetBinding16 = null;
            }
            dialogAirPurifierBottomSheetBinding16.llWeekly.setBackgroundResource(R.drawable.graph_button_selected);
            DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding17 = this.dialogAirPurifierBottomSheetBinding;
            if (dialogAirPurifierBottomSheetBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                dialogAirPurifierBottomSheetBinding17 = null;
            }
            dialogAirPurifierBottomSheetBinding17.llMonthly.setBackgroundResource(0);
            DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding18 = this.dialogAirPurifierBottomSheetBinding;
            if (dialogAirPurifierBottomSheetBinding18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                dialogAirPurifierBottomSheetBinding18 = null;
            }
            dialogAirPurifierBottomSheetBinding18.tvDaily.setTextColor(getResources().getColor(R.color.color10));
            DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding19 = this.dialogAirPurifierBottomSheetBinding;
            if (dialogAirPurifierBottomSheetBinding19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                dialogAirPurifierBottomSheetBinding19 = null;
            }
            dialogAirPurifierBottomSheetBinding19.tvWeekly.setTextColor(getResources().getColor(R.color.moe_white));
            DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding20 = this.dialogAirPurifierBottomSheetBinding;
            if (dialogAirPurifierBottomSheetBinding20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                dialogAirPurifierBottomSheetBinding20 = null;
            }
            dialogAirPurifierBottomSheetBinding20.tvMonthly.setTextColor(getResources().getColor(R.color.color10));
            DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding21 = this.dialogAirPurifierBottomSheetBinding;
            if (dialogAirPurifierBottomSheetBinding21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
                dialogAirPurifierBottomSheetBinding21 = null;
            }
            dialogAirPurifierBottomSheetBinding21.tvSelectionType.setText(R.string.last_1_week);
            ArrayList<String> first3 = getHomeAirPurifierViewModel().getWeeklyGraphData().getFirst();
            if (first3 != null && (second = getHomeAirPurifierViewModel().getWeeklyGraphData().getSecond()) != null && (third = getHomeAirPurifierViewModel().getWeeklyGraphData().getThird()) != null && (!first3.isEmpty()) && (!second.isEmpty()) && (!third.isEmpty())) {
                setupUsageStats(first3, second, third);
            }
        }
        return null;
    }

    private final void setupUsageStats(ArrayList<String> arrayList, ArrayList<Entry> arrayList2, ArrayList<Entry> arrayList3) {
        LineDataSet lineDataSet = new LineDataSet(arrayList2, "Indoor");
        lineDataSet.setColor(getResources().getColor(R.color.livpure_orange));
        lineDataSet.setCircleRadius(0.0f);
        lineDataSet.setDrawValues(false);
        LineDataSet lineDataSet2 = new LineDataSet(arrayList3, "Outdoor");
        lineDataSet2.setColor(getResources().getColor(R.color.livpure_purple));
        lineDataSet2.setCircleRadius(0.0f);
        lineDataSet2.setDrawValues(false);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(lineDataSet);
        arrayList4.add(lineDataSet2);
        LineData lineData = new LineData(arrayList, arrayList4);
        DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding = this.dialogAirPurifierBottomSheetBinding;
        DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding2 = null;
        if (dialogAirPurifierBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
            dialogAirPurifierBottomSheetBinding = null;
        }
        Context context = dialogAirPurifierBottomSheetBinding.airPurifierLineChart.getContext();
        Integer valueOf = context != null ? Integer.valueOf(UiUtilKt.getColorFromAttr$default(context, R.attr.colorOnSurface, null, false, 6, null)) : null;
        DialogAirPurifierBottomSheetBinding dialogAirPurifierBottomSheetBinding3 = this.dialogAirPurifierBottomSheetBinding;
        if (dialogAirPurifierBottomSheetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogAirPurifierBottomSheetBinding");
        } else {
            dialogAirPurifierBottomSheetBinding2 = dialogAirPurifierBottomSheetBinding3;
        }
        LineChart lineChart = dialogAirPurifierBottomSheetBinding2.airPurifierLineChart;
        lineChart.setDescription("");
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setDrawLabels(true);
        if (valueOf != null) {
            xAxis.setTextColor(valueOf.intValue());
        }
        xAxis.setLabelRotationAngle(-45.0f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        if (valueOf != null) {
            lineChart.getAxisLeft().setTextColor(valueOf.intValue());
        }
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getAxisLeft().setSpaceBottom(0.0f);
        lineChart.setScaleEnabled(false);
        lineChart.setDoubleTapToZoomEnabled(false);
        lineChart.setPinchZoom(false);
        lineChart.getLegend().setEnabled(false);
        if (valueOf != null) {
            lineData.setValueTextColor(valueOf.intValue());
        }
        lineData.setHighlightEnabled(false);
        lineChart.animateXY(2000, 2000);
        lineChart.setData(lineData);
        lineChart.invalidate();
    }

    private final void isOutDoorInfo(boolean z) {
        if (!z) {
            ((LinearLayout) _$_findCachedViewById(R.id.openOutdoor)).setVisibility(0);
            ((LinearLayout) _$_findCachedViewById(R.id.closeOutdoor)).setVisibility(8);
            return;
        }
        ((LinearLayout) _$_findCachedViewById(R.id.openOutdoor)).setVisibility(8);
        ((LinearLayout) _$_findCachedViewById(R.id.closeOutdoor)).setVisibility(0);
    }

    private final void showBottomOptions() {
        this.bottomOptionList.clear();
        Iterator it = ArraysKt.toList(this.bottomOptionIcons).iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            AirPurifierBottomOption airPurifierBottomOption = new AirPurifierBottomOption(null, null, 3, null);
            airPurifierBottomOption.setIcon(this.bottomOptionIcons[i]);
            airPurifierBottomOption.setTitle(this.bottomOptionTitle[i]);
            this.bottomOptionList.add(airPurifierBottomOption);
            i++;
        }
        ((RecyclerView) _$_findCachedViewById(R.id.listBottomOptionId)).setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        AirPurifierBottomOptionAdapter airPurifierBottomOptionAdapter = new AirPurifierBottomOptionAdapter(requireContext, this.bottomOptionList);
        ((RecyclerView) _$_findCachedViewById(R.id.listBottomOptionId)).setAdapter(airPurifierBottomOptionAdapter);
        airPurifierBottomOptionAdapter.setOnItemClickListener(this);
    }

    private final void showBoltSettingsScreen() {
        disConnectBLE();
        DeviceList deviceList = getHomeAirPurifierViewModel().get_device();
        HomeAirPurifierFragmentDirections.ActionHomeAirPurifierFragmentToBoltSettingsFragment actionHomeAirPurifierFragmentToBoltSettingsFragment = deviceList != null ? HomeAirPurifierFragmentDirections.actionHomeAirPurifierFragmentToBoltSettingsFragment(deviceList) : null;
        if (actionHomeAirPurifierFragmentToBoltSettingsFragment != null) {
            FragmentKt.findNavController(this).navigate(actionHomeAirPurifierFragmentToBoltSettingsFragment);
        }
    }

    private final void showPlanChangeAirScreen() {
        disConnectBLE();
        DeviceList deviceList = getHomeAirPurifierViewModel().get_device();
        HomeAirPurifierFragmentDirections.ActionHomeFragmentToSelectPlanChargeFragment actionHomeFragmentToSelectPlanChargeFragment = deviceList != null ? HomeAirPurifierFragmentDirections.actionHomeFragmentToSelectPlanChargeFragment(deviceList) : null;
        if (actionHomeFragmentToSelectPlanChargeFragment != null) {
            FragmentKt.findNavController(this).navigate(actionHomeFragmentToSelectPlanChargeFragment);
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentHomeAirpurifierBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.dataBinding = dataBinding;
        dataBinding.setViewModel(getHomeAirPurifierViewModel());
    }

    @Override // com.livpure.safedrink.interfaces.ItemClickListener
    public void onItemClick(View view, int i) {
        sendCommand(i);
    }

    private final void showModeDialog(String str) {
        if (str.contentEquals("Fan")) {
            View inflate = getLayoutInflater().inflate(R.layout.cooler_fan_speed_popup, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(R…er_fan_speed_popup, null)");
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
            bottomSheetDialog.setContentView(inflate);
            bottomSheetDialog.show();
            ImageView imageView = (ImageView) bottomSheetDialog.findViewById(R.id.ivFanSpeed1);
            ImageView imageView2 = (ImageView) bottomSheetDialog.findViewById(R.id.ivFanSpeed2);
            ImageView imageView3 = (ImageView) bottomSheetDialog.findViewById(R.id.ivFanSpeed3);
            ImageView imageView4 = (ImageView) bottomSheetDialog.findViewById(R.id.ivFanSpeed4);
            ImageView imageView5 = (ImageView) bottomSheetDialog.findViewById(R.id.ivFanSpeed5);
            LinearLayout linearLayout = (LinearLayout) bottomSheetDialog.findViewById(R.id.llFanSpeed1);
            LinearLayout linearLayout2 = (LinearLayout) bottomSheetDialog.findViewById(R.id.llFanSpeed2);
            LinearLayout linearLayout3 = (LinearLayout) bottomSheetDialog.findViewById(R.id.llFanSpeed3);
            LinearLayout linearLayout4 = (LinearLayout) bottomSheetDialog.findViewById(R.id.llFanSpeed4);
            LinearLayout linearLayout5 = (LinearLayout) bottomSheetDialog.findViewById(R.id.llFanSpeed5);
            String fanSpeedStatus = getHomeAirPurifierViewModel().getFanSpeedStatus();
            switch (fanSpeedStatus.hashCode()) {
                case 49:
                    if (fanSpeedStatus.equals("1") && imageView != null) {
                        imageView.setImageResource(R.drawable.ic_fan_speed_1_on);
                        break;
                    }
                    break;
                case 50:
                    if (fanSpeedStatus.equals(ExifInterface.GPS_MEASUREMENT_2D) && imageView2 != null) {
                        imageView2.setImageResource(R.drawable.ic_fan_speed_2_on);
                        break;
                    }
                    break;
                case 51:
                    if (fanSpeedStatus.equals(ExifInterface.GPS_MEASUREMENT_3D) && imageView3 != null) {
                        imageView3.setImageResource(R.drawable.ic_fan_speed_3_on);
                        break;
                    }
                    break;
                case 52:
                    if (fanSpeedStatus.equals("4") && imageView4 != null) {
                        imageView4.setImageResource(R.drawable.ic_fan_speed_4_on);
                        break;
                    }
                    break;
                case 53:
                    if (fanSpeedStatus.equals("5") && imageView5 != null) {
                        imageView5.setImageResource(R.drawable.ic_fan_speed_5_on);
                        break;
                    }
                    break;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeAirPurifierFragment.m262showModeDialog$lambda32(HomeAirPurifierFragment.this, objectRef, bottomSheetDialog, view);
                    }
                });
            }
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda10
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeAirPurifierFragment.m263showModeDialog$lambda33(HomeAirPurifierFragment.this, objectRef, bottomSheetDialog, view);
                    }
                });
            }
            if (linearLayout3 != null) {
                linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeAirPurifierFragment.m264showModeDialog$lambda34(HomeAirPurifierFragment.this, objectRef, bottomSheetDialog, view);
                    }
                });
            }
            if (linearLayout4 != null) {
                linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda15
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeAirPurifierFragment.m265showModeDialog$lambda35(HomeAirPurifierFragment.this, objectRef, bottomSheetDialog, view);
                    }
                });
            }
            if (linearLayout5 != null) {
                linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda16
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeAirPurifierFragment.m266showModeDialog$lambda36(HomeAirPurifierFragment.this, objectRef, bottomSheetDialog, view);
                    }
                });
            }
        } else if (!str.contentEquals("Mode")) {
            if (str.contentEquals("Timer")) {
                View inflate2 = getLayoutInflater().inflate(R.layout.timer_mode_popup, (ViewGroup) null);
                Intrinsics.checkNotNullExpressionValue(inflate2, "layoutInflater.inflate(R…t.timer_mode_popup, null)");
                final BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(requireContext());
                bottomSheetDialog2.setContentView(inflate2);
                bottomSheetDialog2.show();
                final TextView textView = (TextView) bottomSheetDialog2.findViewById(R.id.hr);
                TextView textView2 = (TextView) bottomSheetDialog2.findViewById(R.id.save);
                TextView textView3 = (TextView) bottomSheetDialog2.findViewById(R.id.cancel);
                ImageView imageView6 = (ImageView) bottomSheetDialog2.findViewById(R.id.hr_decrease);
                ImageView imageView7 = (ImageView) bottomSheetDialog2.findViewById(R.id.hr_increase);
                if (textView3 != null) {
                    textView3.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda7
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HomeAirPurifierFragment.m271showModeDialog$lambda46(HomeAirPurifierFragment.this, bottomSheetDialog2, view);
                        }
                    });
                }
                if (textView2 != null) {
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HomeAirPurifierFragment.m272showModeDialog$lambda48(HomeAirPurifierFragment.this, textView, bottomSheetDialog2, view);
                        }
                    });
                }
                if (imageView6 != null) {
                    imageView6.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HomeAirPurifierFragment.m273showModeDialog$lambda50(HomeAirPurifierFragment.this, textView, view);
                        }
                    });
                }
                if (imageView7 != null) {
                    imageView7.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HomeAirPurifierFragment.m274showModeDialog$lambda52(HomeAirPurifierFragment.this, textView, view);
                        }
                    });
                }
            }
        } else {
            View inflate3 = getLayoutInflater().inflate(R.layout.mode_popup, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate3, "layoutInflater.inflate(R.layout.mode_popup, null)");
            final BottomSheetDialog bottomSheetDialog3 = new BottomSheetDialog(requireContext());
            bottomSheetDialog3.setContentView(inflate3);
            bottomSheetDialog3.show();
            ImageView imageView8 = (ImageView) bottomSheetDialog3.findViewById(R.id.ivMode_auto);
            ImageView imageView9 = (ImageView) bottomSheetDialog3.findViewById(R.id.ivMode_manual);
            ImageView imageView10 = (ImageView) bottomSheetDialog3.findViewById(R.id.ivMode_turbo);
            ImageView imageView11 = (ImageView) bottomSheetDialog3.findViewById(R.id.ivMode_Sleep);
            LinearLayout linearLayout6 = (LinearLayout) bottomSheetDialog3.findViewById(R.id.llModeAuto);
            LinearLayout linearLayout7 = (LinearLayout) bottomSheetDialog3.findViewById(R.id.llModeManual);
            LinearLayout linearLayout8 = (LinearLayout) bottomSheetDialog3.findViewById(R.id.llModeTurbo);
            LinearLayout linearLayout9 = (LinearLayout) bottomSheetDialog3.findViewById(R.id.llSleepTurbo);
            String modeStatus = getHomeAirPurifierViewModel().getModeStatus();
            int hashCode = modeStatus.hashCode();
            if (hashCode != 49) {
                if (hashCode != 50) {
                    if (hashCode == 52 && modeStatus.equals("4") && imageView9 != null) {
                        imageView9.setImageResource(R.drawable.ic_mode_manual_on);
                    }
                } else if (modeStatus.equals(ExifInterface.GPS_MEASUREMENT_2D) && imageView10 != null) {
                    imageView10.setImageResource(R.drawable.ic_turbo_on);
                }
            } else if (modeStatus.equals("1") && imageView8 != null) {
                imageView8.setImageResource(R.drawable.ic_auto_on);
            }
            if (Intrinsics.areEqual(getHomeAirPurifierViewModel().getSleepStatus(), "1") && imageView11 != null) {
                imageView11.setImageResource(R.drawable.ic_sleep_on);
            }
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            if (linearLayout6 != null) {
                linearLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda14
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeAirPurifierFragment.m267showModeDialog$lambda38(HomeAirPurifierFragment.this, objectRef2, bottomSheetDialog3, view);
                    }
                });
            }
            if (linearLayout7 != null) {
                linearLayout7.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda12
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeAirPurifierFragment.m268showModeDialog$lambda40(HomeAirPurifierFragment.this, objectRef2, bottomSheetDialog3, view);
                    }
                });
            }
            if (linearLayout8 != null) {
                linearLayout8.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda17
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeAirPurifierFragment.m269showModeDialog$lambda42(HomeAirPurifierFragment.this, objectRef2, bottomSheetDialog3, view);
                    }
                });
            }
            if (linearLayout9 != null) {
                linearLayout9.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda13
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeAirPurifierFragment.m270showModeDialog$lambda44(HomeAirPurifierFragment.this, objectRef2, bottomSheetDialog3, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r8v11, types: [T, java.lang.Object, java.lang.String] */
    /* renamed from: showModeDialog$lambda-32  reason: not valid java name */
    public static final void m262showModeDialog$lambda32(HomeAirPurifierFragment this$0, Ref.ObjectRef command, BottomSheetDialog dialogLog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(command, "$command");
        Intrinsics.checkNotNullParameter(dialogLog, "$dialogLog");
        if (Intrinsics.areEqual(this$0.getHomeAirPurifierViewModel().getPowerOnStatus(), "1")) {
            if (this$0.mConnected) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String COMMAND_AIR_FAN_SPEED = AppConstants.COMMAND_AIR_FAN_SPEED;
                Intrinsics.checkNotNullExpressionValue(COMMAND_AIR_FAN_SPEED, "COMMAND_AIR_FAN_SPEED");
                ?? format = String.format(COMMAND_AIR_FAN_SPEED, Arrays.copyOf(new Object[]{this$0.getHomeAirPurifierViewModel().getBuzzer(), "1"}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                command.element = format;
                this$0.commandPublish((String) command.element);
            } else {
                this$0.getHomeAirPurifierViewModel().publishCommand("11", "", "1");
            }
        }
        dialogLog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r8v11, types: [T, java.lang.Object, java.lang.String] */
    /* renamed from: showModeDialog$lambda-33  reason: not valid java name */
    public static final void m263showModeDialog$lambda33(HomeAirPurifierFragment this$0, Ref.ObjectRef command, BottomSheetDialog dialogLog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(command, "$command");
        Intrinsics.checkNotNullParameter(dialogLog, "$dialogLog");
        if (Intrinsics.areEqual(this$0.getHomeAirPurifierViewModel().getPowerOnStatus(), "1")) {
            if (this$0.mConnected) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String COMMAND_AIR_FAN_SPEED = AppConstants.COMMAND_AIR_FAN_SPEED;
                Intrinsics.checkNotNullExpressionValue(COMMAND_AIR_FAN_SPEED, "COMMAND_AIR_FAN_SPEED");
                ?? format = String.format(COMMAND_AIR_FAN_SPEED, Arrays.copyOf(new Object[]{this$0.getHomeAirPurifierViewModel().getBuzzer(), ExifInterface.GPS_MEASUREMENT_2D}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                command.element = format;
                this$0.commandPublish((String) command.element);
            } else {
                this$0.getHomeAirPurifierViewModel().publishCommand("11", "", ExifInterface.GPS_MEASUREMENT_2D);
            }
        }
        dialogLog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r8v11, types: [T, java.lang.Object, java.lang.String] */
    /* renamed from: showModeDialog$lambda-34  reason: not valid java name */
    public static final void m264showModeDialog$lambda34(HomeAirPurifierFragment this$0, Ref.ObjectRef command, BottomSheetDialog dialogLog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(command, "$command");
        Intrinsics.checkNotNullParameter(dialogLog, "$dialogLog");
        if (Intrinsics.areEqual(this$0.getHomeAirPurifierViewModel().getPowerOnStatus(), "1")) {
            if (this$0.mConnected) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String COMMAND_AIR_FAN_SPEED = AppConstants.COMMAND_AIR_FAN_SPEED;
                Intrinsics.checkNotNullExpressionValue(COMMAND_AIR_FAN_SPEED, "COMMAND_AIR_FAN_SPEED");
                ?? format = String.format(COMMAND_AIR_FAN_SPEED, Arrays.copyOf(new Object[]{this$0.getHomeAirPurifierViewModel().getBuzzer(), ExifInterface.GPS_MEASUREMENT_3D}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                command.element = format;
                this$0.commandPublish((String) command.element);
            } else {
                this$0.getHomeAirPurifierViewModel().publishCommand("11", "", ExifInterface.GPS_MEASUREMENT_3D);
            }
        }
        dialogLog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r8v11, types: [T, java.lang.Object, java.lang.String] */
    /* renamed from: showModeDialog$lambda-35  reason: not valid java name */
    public static final void m265showModeDialog$lambda35(HomeAirPurifierFragment this$0, Ref.ObjectRef command, BottomSheetDialog dialogLog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(command, "$command");
        Intrinsics.checkNotNullParameter(dialogLog, "$dialogLog");
        if (Intrinsics.areEqual(this$0.getHomeAirPurifierViewModel().getPowerOnStatus(), "1")) {
            if (this$0.mConnected) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String COMMAND_AIR_FAN_SPEED = AppConstants.COMMAND_AIR_FAN_SPEED;
                Intrinsics.checkNotNullExpressionValue(COMMAND_AIR_FAN_SPEED, "COMMAND_AIR_FAN_SPEED");
                ?? format = String.format(COMMAND_AIR_FAN_SPEED, Arrays.copyOf(new Object[]{this$0.getHomeAirPurifierViewModel().getBuzzer(), "4"}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                command.element = format;
                this$0.commandPublish((String) command.element);
            } else {
                this$0.getHomeAirPurifierViewModel().publishCommand("11", "", "4");
            }
        }
        dialogLog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r8v11, types: [T, java.lang.Object, java.lang.String] */
    /* renamed from: showModeDialog$lambda-36  reason: not valid java name */
    public static final void m266showModeDialog$lambda36(HomeAirPurifierFragment this$0, Ref.ObjectRef command, BottomSheetDialog dialogLog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(command, "$command");
        Intrinsics.checkNotNullParameter(dialogLog, "$dialogLog");
        if (Intrinsics.areEqual(this$0.getHomeAirPurifierViewModel().getPowerOnStatus(), "1")) {
            if (this$0.mConnected) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String COMMAND_AIR_FAN_SPEED = AppConstants.COMMAND_AIR_FAN_SPEED;
                Intrinsics.checkNotNullExpressionValue(COMMAND_AIR_FAN_SPEED, "COMMAND_AIR_FAN_SPEED");
                ?? format = String.format(COMMAND_AIR_FAN_SPEED, Arrays.copyOf(new Object[]{this$0.getHomeAirPurifierViewModel().getBuzzer(), "5"}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                command.element = format;
                this$0.commandPublish((String) command.element);
            } else {
                this$0.getHomeAirPurifierViewModel().publishCommand("11", "", "5");
            }
        }
        dialogLog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r7v11, types: [T, java.lang.Object, java.lang.String] */
    /* renamed from: showModeDialog$lambda-38  reason: not valid java name */
    public static final void m267showModeDialog$lambda38(HomeAirPurifierFragment this$0, Ref.ObjectRef command, BottomSheetDialog dialogLog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(command, "$command");
        Intrinsics.checkNotNullParameter(dialogLog, "$dialogLog");
        if (Intrinsics.areEqual(this$0.getHomeAirPurifierViewModel().getPowerOnStatus(), "1")) {
            if (this$0.mConnected) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String COMMAND_AIR_AUTO_MODE_ON = AppConstants.COMMAND_AIR_AUTO_MODE_ON;
                Intrinsics.checkNotNullExpressionValue(COMMAND_AIR_AUTO_MODE_ON, "COMMAND_AIR_AUTO_MODE_ON");
                ?? format = String.format(COMMAND_AIR_AUTO_MODE_ON, Arrays.copyOf(new Object[]{this$0.getHomeAirPurifierViewModel().getBuzzer(), "5"}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                command.element = format;
                this$0.commandPublish((String) command.element);
            } else {
                this$0.getHomeAirPurifierViewModel().publishCommand("04", "", "");
            }
        }
        dialogLog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r7v11, types: [T, java.lang.Object, java.lang.String] */
    /* renamed from: showModeDialog$lambda-40  reason: not valid java name */
    public static final void m268showModeDialog$lambda40(HomeAirPurifierFragment this$0, Ref.ObjectRef command, BottomSheetDialog dialogLog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(command, "$command");
        Intrinsics.checkNotNullParameter(dialogLog, "$dialogLog");
        if (Intrinsics.areEqual(this$0.getHomeAirPurifierViewModel().getPowerOnStatus(), "1")) {
            if (this$0.mConnected) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String COMMAND_AIR_MANUL_MODE_ON = AppConstants.COMMAND_AIR_MANUL_MODE_ON;
                Intrinsics.checkNotNullExpressionValue(COMMAND_AIR_MANUL_MODE_ON, "COMMAND_AIR_MANUL_MODE_ON");
                ?? format = String.format(COMMAND_AIR_MANUL_MODE_ON, Arrays.copyOf(new Object[]{this$0.getHomeAirPurifierViewModel().getBuzzer(), "5"}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                command.element = format;
                this$0.commandPublish((String) command.element);
            } else {
                this$0.getHomeAirPurifierViewModel().publishCommand("03", "", "");
            }
        }
        dialogLog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r7v11, types: [T, java.lang.Object, java.lang.String] */
    /* renamed from: showModeDialog$lambda-42  reason: not valid java name */
    public static final void m269showModeDialog$lambda42(HomeAirPurifierFragment this$0, Ref.ObjectRef command, BottomSheetDialog dialogLog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(command, "$command");
        Intrinsics.checkNotNullParameter(dialogLog, "$dialogLog");
        if (Intrinsics.areEqual(this$0.getHomeAirPurifierViewModel().getPowerOnStatus(), "1")) {
            if (this$0.mConnected) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String COMMAND_AIR_RAPID_MODE_ON = AppConstants.COMMAND_AIR_RAPID_MODE_ON;
                Intrinsics.checkNotNullExpressionValue(COMMAND_AIR_RAPID_MODE_ON, "COMMAND_AIR_RAPID_MODE_ON");
                ?? format = String.format(COMMAND_AIR_RAPID_MODE_ON, Arrays.copyOf(new Object[]{this$0.getHomeAirPurifierViewModel().getBuzzer(), "5"}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                command.element = format;
                this$0.commandPublish((String) command.element);
            } else {
                this$0.getHomeAirPurifierViewModel().publishCommand("06", "", "");
            }
        }
        dialogLog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r7v11, types: [T, java.lang.Object, java.lang.String] */
    /* renamed from: showModeDialog$lambda-44  reason: not valid java name */
    public static final void m270showModeDialog$lambda44(HomeAirPurifierFragment this$0, Ref.ObjectRef command, BottomSheetDialog dialogLog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(command, "$command");
        Intrinsics.checkNotNullParameter(dialogLog, "$dialogLog");
        if (Intrinsics.areEqual(this$0.getHomeAirPurifierViewModel().getPowerOnStatus(), "1")) {
            if (this$0.mConnected) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String COMMAND_AIR_SLEEP_MODE_ON = AppConstants.COMMAND_AIR_SLEEP_MODE_ON;
                Intrinsics.checkNotNullExpressionValue(COMMAND_AIR_SLEEP_MODE_ON, "COMMAND_AIR_SLEEP_MODE_ON");
                ?? format = String.format(COMMAND_AIR_SLEEP_MODE_ON, Arrays.copyOf(new Object[]{this$0.getHomeAirPurifierViewModel().getBuzzer(), "5"}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                command.element = format;
                this$0.commandPublish((String) command.element);
            } else {
                this$0.getHomeAirPurifierViewModel().publishCommand("05", "", "");
            }
        }
        dialogLog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showModeDialog$lambda-46  reason: not valid java name */
    public static final void m271showModeDialog$lambda46(HomeAirPurifierFragment this$0, BottomSheetDialog dialogLog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialogLog, "$dialogLog");
        dialogLog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showModeDialog$lambda-48  reason: not valid java name */
    public static final void m272showModeDialog$lambda48(HomeAirPurifierFragment this$0, TextView textView, BottomSheetDialog dialogLog, View view) {
        String str;
        CharSequence text;
        CharSequence text2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialogLog, "$dialogLog");
        if (Intrinsics.areEqual(this$0.getHomeAirPurifierViewModel().getPowerOnStatus(), "1")) {
            String str2 = null;
            if (!Intrinsics.areEqual(textView != null ? textView.getText() : null, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                if ((textView == null || (text2 = textView.getText()) == null || text2.length() != 1) ? false : true) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('0');
                    sb.append((Object) textView.getText());
                    str = sb.toString();
                } else {
                    if (textView != null && (text = textView.getText()) != null) {
                        str2 = text.toString();
                    }
                    Intrinsics.checkNotNull(str2);
                    str = str2;
                }
                if (this$0.mConnected) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String COMMAND_AIR_SET_COUNTDOWN = AppConstants.COMMAND_AIR_SET_COUNTDOWN;
                    Intrinsics.checkNotNullExpressionValue(COMMAND_AIR_SET_COUNTDOWN, "COMMAND_AIR_SET_COUNTDOWN");
                    String format = String.format(COMMAND_AIR_SET_COUNTDOWN, Arrays.copyOf(new Object[]{this$0.getHomeAirPurifierViewModel().getBuzzer(), str}, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    this$0.commandPublish(format);
                } else {
                    this$0.getHomeAirPurifierViewModel().publishCommand("12", str, "");
                }
            }
        }
        dialogLog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showModeDialog$lambda-50  reason: not valid java name */
    public static final void m273showModeDialog$lambda50(HomeAirPurifierFragment this$0, TextView textView, View view) {
        String obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer num = null;
        if (Intrinsics.areEqual(textView != null ? textView.getText() : null, AppEventsConstants.EVENT_PARAM_VALUE_NO) || textView == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (text != null && (obj = text.toString()) != null) {
            num = Integer.valueOf(Integer.parseInt(obj));
        }
        Intrinsics.checkNotNull(num);
        textView.setText(String.valueOf(num.intValue() - 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showModeDialog$lambda-52  reason: not valid java name */
    public static final void m274showModeDialog$lambda52(HomeAirPurifierFragment this$0, TextView textView, View view) {
        String obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer num = null;
        if (Intrinsics.areEqual(textView != null ? textView.getText() : null, "12") || textView == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (text != null && (obj = text.toString()) != null) {
            num = Integer.valueOf(Integer.parseInt(obj));
        }
        Intrinsics.checkNotNull(num);
        textView.setText(String.valueOf(num.intValue() + 1));
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void sendCommand(int r17) {
        /*
            Method dump skipped, instructions count: 800
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment.sendCommand(int):void");
    }

    private final void commandPublish(String str) {
        if (Intrinsics.areEqual(publishToDeviceCommand(str), "succes")) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeAirPurifierFragment$commandPublish$1(this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupBluetooth() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s-%s", Arrays.copyOf(new Object[]{"LIV-ARP", StringsKt.takeLast(getHomeAirPurifierViewModel().getImeiNumber(), 4)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        this.macIdAdd = format;
        this.listBluetoothDevice = new ArrayList<>();
        getBluetoothAdapter();
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        Boolean valueOf = bluetoothAdapter != null ? Boolean.valueOf(bluetoothAdapter.isEnabled()) : null;
        Intrinsics.checkNotNull(valueOf);
        if (!valueOf.booleanValue()) {
            if (Build.VERSION.SDK_INT < 31) {
                startActivity(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));
                return;
            }
            return;
        }
        getBluetoothLeScanner();
        try {
            if (checkIfLocationPermissionGranted()) {
                scanLeDevice();
            } else {
                onRequestPermissionsResult();
            }
        } catch (Exception e) {
            Log.e(AgentHealth.DEFAULT_KEY, e.toString());
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
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HomeAirPurifierFragment$scanLeDevice$1(this, null), 3, null);
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
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HomeAirPurifierFragment$scanLeDevice$2(this, null), 3, null);
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
                    if (StringsKt.startsWith$default(name, "LIV-ARP", false, 2, (Object) null)) {
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
                if (StringsKt.startsWith$default(name3, "LIV-ARP", false, 2, (Object) null)) {
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
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeAirPurifierFragment$connectWithBle$1(this, null), 3, null);
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

    private final void getCommandList() {
        this.bleCommandList.clear();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        getHomeAirPurifierViewModel().getPendingBleCommand().observe(this, new Observer() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda25
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirPurifierFragment.m242getCommandList$lambda53(HomeAirPurifierFragment.this, objectRef, (BoltCommandsResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getCommandList$lambda-53  reason: not valid java name */
    public static final void m242getCommandList$lambda53(HomeAirPurifierFragment this$0, Ref.ObjectRef boltCommandsResponse, BoltCommandsResponse it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(boltCommandsResponse, "$boltCommandsResponse");
        if (!this$0.isAdded()) {
            return;
        }
        this$0.bleCommandList.clear();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boltCommandsResponse.element = it;
        this$0.bleCommandList.add(((BoltCommandsResponse) boltCommandsResponse.element).getRTC_Time());
        List<RechargeResponse> rechargeCommands = ((BoltCommandsResponse) boltCommandsResponse.element).getRechargeCommands();
        Integer valueOf = rechargeCommands != null ? Integer.valueOf(rechargeCommands.size()) : null;
        Intrinsics.checkNotNull(valueOf);
        if (valueOf.intValue() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            List<RechargeResponse> rechargeCommands2 = ((BoltCommandsResponse) boltCommandsResponse.element).getRechargeCommands();
            Integer valueOf2 = rechargeCommands2 != null ? Integer.valueOf(rechargeCommands2.size()) : null;
            Intrinsics.checkNotNull(valueOf2);
            if (i >= valueOf2.intValue()) {
                return;
            }
            ArrayList<String> arrayList = this$0.bleCommandList;
            List<RechargeResponse> rechargeCommands3 = ((BoltCommandsResponse) boltCommandsResponse.element).getRechargeCommands();
            Intrinsics.checkNotNull(rechargeCommands3);
            arrayList.add(rechargeCommands3.get(i).getRechargeList());
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayData(String str) {
        List<String> lines;
        String decrypt;
        getHomeAirPurifierViewModel().getBleImage().observe(this, new Observer() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda21
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeAirPurifierFragment.m240displayData$lambda54(HomeAirPurifierFragment.this, (Integer) obj);
            }
        });
        if (str != null) {
            try {
                if (StringsKt.startsWith$default(str, "{", false, 2, (Object) null)) {
                    return;
                }
                String str2 = StringsKt.lines(str).get(lines.size() - 1);
                if (StringsKt.lines(str).size() != 30 && str2.length() <= 1199.0f) {
                    if (str2.length() == 40) {
                        String decrypt2 = Base64Hex.decrypt(StringsKt.take(str2, 32), AppConstants.BEL_ENC_KEY);
                        Intrinsics.checkNotNullExpressionValue(decrypt2, "decrypt(hexDataReceived.…AppConstants.BEL_ENC_KEY)");
                        decrypt = decrypt2 + "0\"}";
                    } else {
                        decrypt = Base64Hex.decrypt(str2, AppConstants.BEL_ENC_KEY);
                        Intrinsics.checkNotNullExpressionValue(decrypt, "decrypt(hexDataReceived, AppConstants.BEL_ENC_KEY)");
                    }
                    JSONObject jSONObject = new JSONObject(decrypt);
                    HomePurifierModel homeAirPurifierViewModel = getHomeAirPurifierViewModel();
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonData.toString()");
                    homeAirPurifierViewModel.bleStatus(jSONObject2);
                    if (this.bleCommandList.size() > 0) {
                        String str3 = this.bleCommandList.get(0);
                        Intrinsics.checkNotNullExpressionValue(str3, "bleCommandList[0]");
                        sendToBLEJsonData(str3);
                        this.bleCommandList.remove(0);
                        return;
                    }
                    return;
                }
                this.myScanRunnable = new Runnable() { // from class: com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$$ExternalSyntheticLambda27
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeAirPurifierFragment.m241displayData$lambda55(HomeAirPurifierFragment.this);
                    }
                };
                Handler handler = this.handler;
                Intrinsics.checkNotNull(handler);
                Runnable runnable = this.myScanRunnable;
                Intrinsics.checkNotNull(runnable);
                handler.postDelayed(runnable, 500L);
            } catch (Exception unused) {
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeAirPurifierFragment$displayData$3(this, null), 3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: displayData$lambda-54  reason: not valid java name */
    public static final void m240displayData$lambda54(HomeAirPurifierFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateBleWiFiImage(it.intValue(), "BLE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: displayData$lambda-55  reason: not valid java name */
    public static final void m241displayData$lambda55(HomeAirPurifierFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            BluetoothLeService bluetoothLeService = this$0.mBluetoothLeService;
            Intrinsics.checkNotNull(bluetoothLeService);
            bluetoothLeService.readCharacteristic(this$0.mReadCharacteristic);
            Handler handler = this$0.handler;
            Intrinsics.checkNotNull(handler);
            Runnable runnable = this$0.myScanRunnable;
            Intrinsics.checkNotNull(runnable);
            handler.removeCallbacks(runnable);
        } catch (Exception e) {
            Log.e(AgentHealth.DEFAULT_KEY, e.toString());
        }
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
            Intrinsics.checkNotNullExpressionValue(hexStringToByteArray, "hexStringToByteArray(encryptedData)");
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

    public final void onRequestPermissionsResult() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this.LOCATION_PERMISSION_CODE);
        }
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

    private final void sendToBLEJsonData(String str) {
        try {
            byte[] hexStringToByteArray = Encrypt.hexStringToByteArray(Encrypt.encrypt(str, AppConstants.BEL_ENC_KEY));
            Intrinsics.checkNotNullExpressionValue(hexStringToByteArray, "hexStringToByteArray(encryptedData)");
            if (Intrinsics.areEqual(publishToDevice(hexStringToByteArray), "succes")) {
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeAirPurifierFragment$sendToBLEJsonData$1(this, null), 3, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void updateBleWiFiImage(int i, String str) {
        ImageView imageView;
        if (Intrinsics.areEqual(str, "WIFI")) {
            ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.wifiInfoIV);
            if (imageView2 != null) {
                imageView2.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
            }
        } else if (!Intrinsics.areEqual(str, "BLE") || (imageView = (ImageView) _$_findCachedViewById(R.id.bleInfoIV)) == null) {
        } else {
            imageView.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
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

    public final void showToastMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new HomeAirPurifierFragment$showToastMessage$1(null), 3, null);
    }
}
