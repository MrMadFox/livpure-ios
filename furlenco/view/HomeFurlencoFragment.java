package com.livpure.safedrink.furlenco.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.gson.Gson;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.HomeViewModel;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.bolt.data.models.BoldBleData;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import com.livpure.safedrink.bolt.data.models.RechargeResponse;
import com.livpure.safedrink.bolt.service.Base64Hex;
import com.livpure.safedrink.bolt.service.Encrypt;
import com.livpure.safedrink.common.UiUtilKt;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentFurlencoHomeBinding;
import com.livpure.safedrink.furlenco.model.HomeFurlencoModel;
import com.livpure.safedrink.furlenco.view.HomeFurlencoFragmentDirections;
import com.livpure.safedrink.login.MainActivity;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.servicebluetooth.BluetoothLeService;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.utils.AppConstants;
import com.livpure.safedrink.utils.AppUtils;
import com.livpure.safedrink.utils.MyVolleySingleton;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.wssholmes.stark.circular_score.CircularScoreView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;
/* compiled from: HomeFurlencoFragment.kt */
@Metadata(d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020=H\u0002J\u0010\u0010d\u001a\u00020b2\u0006\u0010e\u001a\u00020\u0002H\u0016J\b\u0010f\u001a\u00020bH\u0002J\b\u0010g\u001a\u00020\u0005H\u0002J\b\u0010h\u001a\u00020bH\u0002J\u0012\u0010i\u001a\u00020b2\b\u0010j\u001a\u0004\u0018\u00010\u000eH\u0002J\u001c\u0010k\u001a\u00020b2\b\u0010l\u001a\u0004\u0018\u00010m2\b\u0010n\u001a\u0004\u0018\u00010oH\u0002J\b\u0010p\u001a\u00020bH\u0002J\b\u0010q\u001a\u00020bH\u0002J\b\u0010r\u001a\u00020bH\u0002J\b\u0010s\u001a\u00020bH\u0002J\u0010\u0010t\u001a\u00020b2\u0006\u0010u\u001a\u00020\u000eH\u0002J\u0010\u0010v\u001a\u00020b2\u0006\u0010u\u001a\u00020\u000eH\u0002J\b\u0010w\u001a\u00020\bH\u0014J\b\u0010x\u001a\u000206H\u0014J\u0018\u0010y\u001a\u00020b2\u000e\u0010z\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010{H\u0002J\u0010\u0010}\u001a\u00020\u000e2\b\u0010~\u001a\u0004\u0018\u00010\u000eJ\t\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\u0013\u0010\u0081\u0001\u001a\u00020b2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J\u0015\u0010\u0084\u0001\u001a\u00020b2\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0016J\u0012\u0010\u0087\u0001\u001a\u00020b2\u0007\u0010\u0088\u0001\u001a\u00020mH\u0016J\u0015\u0010\u0089\u0001\u001a\u00020b2\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0016J\u001d\u0010\u008a\u0001\u001a\u00020b2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0016J\t\u0010\u008f\u0001\u001a\u00020bH\u0016J\t\u0010\u0090\u0001\u001a\u00020bH\u0016J\u0013\u0010\u0091\u0001\u001a\u00020\u00052\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\t\u0010\u0094\u0001\u001a\u00020bH\u0016J\u0007\u0010\u0095\u0001\u001a\u00020bJ\t\u0010\u0096\u0001\u001a\u00020bH\u0016J\u001f\u0010\u0097\u0001\u001a\u00020b2\b\u0010\u0098\u0001\u001a\u00030\u0099\u00012\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0016J\u0015\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u000e2\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001J\u0012\u0010\u009d\u0001\u001a\u00020b2\u0007\u0010\u009e\u0001\u001a\u00020\u000eH\u0002J\t\u0010\u009f\u0001\u001a\u00020bH\u0002J\t\u0010 \u0001\u001a\u00020bH\u0002J\u0012\u0010¡\u0001\u001a\u00020b2\u0007\u0010¢\u0001\u001a\u00020\u000eH\u0002J\u001b\u0010¡\u0001\u001a\u00020b2\u0007\u0010¢\u0001\u001a\u00020\u000e2\u0007\u0010£\u0001\u001a\u00020\u0005H\u0002J\u0010\u0010¤\u0001\u001a\u00020\u00052\u0007\u0010¥\u0001\u001a\u00020\u0005J\t\u0010¦\u0001\u001a\u00020bH\u0002J\t\u0010§\u0001\u001a\u00020bH\u0002J1\u0010¨\u0001\u001a\u00020b2\r\u0010©\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0{2\u000e\u0010ª\u0001\u001a\t\u0012\u0005\u0012\u00030«\u00010{2\u0007\u0010¬\u0001\u001a\u00020\u000eH\u0002J\t\u0010\u00ad\u0001\u001a\u00020bH\u0002J\u0007\u0010®\u0001\u001a\u00020bJ\u0012\u0010¯\u0001\u001a\u00020\u00052\u0007\u0010°\u0001\u001a\u00020\u000eH\u0002J\u001d\u0010±\u0001\u001a\u00020b2\t\b\u0001\u0010²\u0001\u001a\u00020\b2\u0007\u0010³\u0001\u001a\u00020\u000eH\u0002J\u0014\u0010´\u0001\u001a\u00020b2\t\b\u0001\u0010²\u0001\u001a\u00020\bH\u0002J\u001d\u0010µ\u0001\u001a\u00020b2\u0007\u0010¶\u0001\u001a\u00020\u000e2\t\b\u0001\u0010²\u0001\u001a\u00020\bH\u0002J\u0012\u0010·\u0001\u001a\u00020b2\u0007\u0010¸\u0001\u001a\u00020PH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a8\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\u001bR2\u0010\u001c\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dj\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001e`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u000e0!j\b\u0012\u0004\u0012\u00020\u000e`\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0-X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b7\u00108R\u000e\u0010;\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010<\u001a\u0016\u0012\u0004\u0012\u00020=\u0018\u00010!j\n\u0012\u0004\u0012\u00020=\u0018\u0001`\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010XX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010XX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\u000e0!j\b\u0012\u0004\u0012\u00020\u000e`\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020_X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¹\u0001"}, d2 = {"Lcom/livpure/safedrink/furlenco/view/HomeFurlencoFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentFurlencoHomeBinding;", "()V", "BLE_LOCATION_PACKET_RECEIVED", "", "BLE_STATUS_PACKET_RECEIVED", "LOCATION_PERMISSION_CODE", "", "SCAN_PERIOD", "", "_OTAUPDATECANCELREQUEST", "_OTAUPDATEREQUEST", "_hardwareVersion", "", "_isFirmwareUpdate", "_isHardwareUpdate", "_isSoftwareUpdate", "_softwareVersion", "activity", "Lcom/livpure/safedrink/login/MainActivity;", "getActivity", "()Lcom/livpure/safedrink/login/MainActivity;", "setActivity", "(Lcom/livpure/safedrink/login/MainActivity;)V", "android12BlePermission", "", "[Ljava/lang/String;", "attributes", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "bleCommandList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "boltCommandsResponse", "Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", "circularScoreView", "Lcom/wssholmes/stark/circular_score/CircularScoreView;", "counter", "firmwareDialoglog", "Landroid/app/Dialog;", "firmwareHandler", "Landroid/os/Handler;", "firmwareParts", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "setGson", "(Lcom/google/gson/Gson;)V", "handler", "homeFurlencoModel", "Lcom/livpure/safedrink/furlenco/model/HomeFurlencoModel;", "getHomeFurlencoModel", "()Lcom/livpure/safedrink/furlenco/model/HomeFurlencoModel;", "homeFurlencoModel$delegate", "Lkotlin/Lazy;", "isSignOut", "listBluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "getListBluetoothDevice", "()Ljava/util/ArrayList;", "setListBluetoothDevice", "(Ljava/util/ArrayList;)V", "mBleConnected", "mBluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "mBluetoothLeScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "mBluetoothLeService", "Lcom/livpure/safedrink/servicebluetooth/BluetoothLeService;", "mConnected", "mDeviceAddress", "mDeviceName", "mGattUpdateReceiver", "Landroid/content/BroadcastReceiver;", "mHandler", "mNotifyCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "mReadCharacteristic", "mScanning", "mServiceConnection", "Landroid/content/ServiceConnection;", "mWriteCharacteristic", "macIdAdd", "myFirmwareUpdateRunnable", "Ljava/lang/Runnable;", "myRunnable", "myScanDataRunnable", "myScanFirstRunnable", "myScanRunnable", "packet_list", "scanCallback", "Landroid/bluetooth/le/ScanCallback;", "sentPacket", "addBluetoothDevice", "", AndroidContextPlugin.DEVICE_KEY, "bindVariablesToView", "dataBinding", "bleOFF", "checkIfLocationPermissionGranted", "discconnectBLE", "displayData", "data", "getAlertCustomDialogWithHeaderAndMsg", "ctx", "Landroid/content/Context;", "containerId", "Landroid/view/ViewGroup;", "getBleData", "getBluetoothAdapter", "getBluetoothLeScanner", "getCommandList", "getFirmwareData", "roData", "getFirmwareNextData", "getLayoutId", "getViewModel", "initializeGattServices", "gattServices", "", "Landroid/bluetooth/BluetoothGattService;", "lookup", AnalyticsAttribute.UUID_ATTRIBUTE, "makeGattUpdateIntentFilter", "Landroid/content/IntentFilter;", MoEPushConstants.ACTION_NAVIGATE, NativeProtocol.WEB_DIALOG_ACTION, "Landroidx/navigation/NavDirections;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onDestroy", "onDestroyView", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPause", "onRequestPermissionsResult", "onResume", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "publishToDevice", "message", "", "reqularPacket", "jsonData", "scanLeDevice", "sendContinueCommand", "sendToBLEJsonData", "value", "acknowledgement", "setBluetooth", "enable", "setupBluetooth", "setupDashboard", "setupUsageStats", "dates", "consumptionDataSetList", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "averageConsumptionMessage", "showBoltSettingsScreen", "showFirmwareUpdateDialog", "splitToNChar", "text", "updateBleWiFiImage", "resId", "type", "updateFilterLifeImage", "updateWaterRemainingView", "waterRemaining", "writeCharacteristic", "characteristic", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeFurlencoFragment extends DataBindingFragment<FragmentFurlencoHomeBinding> {
    private boolean BLE_LOCATION_PACKET_RECEIVED;
    private boolean BLE_STATUS_PACKET_RECEIVED;
    private boolean _OTAUPDATECANCELREQUEST;
    private boolean _OTAUPDATEREQUEST;
    private boolean _isFirmwareUpdate;
    private boolean _isHardwareUpdate;
    private boolean _isSoftwareUpdate;
    private MainActivity activity;
    private BoltCommandsResponse boltCommandsResponse;
    private CircularScoreView circularScoreView;
    private int counter;
    private Dialog firmwareDialoglog;
    private Handler handler;
    private boolean isSignOut;
    private ArrayList<BluetoothDevice> listBluetoothDevice;
    private boolean mBleConnected;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeScanner mBluetoothLeScanner;
    private BluetoothLeService mBluetoothLeService;
    private boolean mConnected;
    private String mDeviceAddress;
    private String mDeviceName;
    private Handler mHandler;
    private BluetoothGattCharacteristic mNotifyCharacteristic;
    private BluetoothGattCharacteristic mReadCharacteristic;
    private boolean mScanning;
    private BluetoothGattCharacteristic mWriteCharacteristic;
    private Runnable myFirmwareUpdateRunnable;
    private final Runnable myRunnable;
    private Runnable myScanDataRunnable;
    private final Runnable myScanFirstRunnable;
    private Runnable myScanRunnable;
    private int sentPacket;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy homeFurlencoModel$delegate = LazyKt.lazy(new Function0<HomeFurlencoModel>() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$homeFurlencoModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HomeFurlencoModel invoke() {
            return (HomeFurlencoModel) new ViewModelProvider(HomeFurlencoFragment.this).get(HomeFurlencoModel.class);
        }
    });
    private String _hardwareVersion = "";
    private String _softwareVersion = "";
    private final ArrayList<String> bleCommandList = new ArrayList<>();
    private final List<String> firmwareParts = new ArrayList();
    private Gson gson = new Gson();
    private final long SCAN_PERIOD = 10000;
    private ArrayList<String> packet_list = new ArrayList<>();
    private final int LOCATION_PERMISSION_CODE = 2;
    private String macIdAdd = "";
    private final String[] android12BlePermission = {"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
    private final ScanCallback scanCallback = new ScanCallback() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$scanCallback$1
        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            super.onScanResult(i, result);
            HomeFurlencoFragment homeFurlencoFragment = HomeFurlencoFragment.this;
            BluetoothDevice device = result.getDevice();
            Intrinsics.checkNotNullExpressionValue(device, "result.device");
            homeFurlencoFragment.addBluetoothDevice(device);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> results) {
            Intrinsics.checkNotNullParameter(results, "results");
            super.onBatchScanResults(results);
        }
    };
    private final ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$mServiceConnection$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            BluetoothLeService bluetoothLeService;
            BluetoothLeService bluetoothLeService2;
            String str;
            Intrinsics.checkNotNullParameter(componentName, "componentName");
            Intrinsics.checkNotNullParameter(service, "service");
            HomeFurlencoFragment.this.mBluetoothLeService = ((BluetoothLeService.LocalBinder) service).getService();
            bluetoothLeService = HomeFurlencoFragment.this.mBluetoothLeService;
            Intrinsics.checkNotNull(bluetoothLeService);
            if (bluetoothLeService.initialize()) {
                bluetoothLeService2 = HomeFurlencoFragment.this.mBluetoothLeService;
                Intrinsics.checkNotNull(bluetoothLeService2);
                str = HomeFurlencoFragment.this.mDeviceAddress;
                bluetoothLeService2.connect(str);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Intrinsics.checkNotNullParameter(componentName, "componentName");
            HomeFurlencoFragment.this.mBluetoothLeService = null;
        }
    };
    private final BroadcastReceiver mGattUpdateReceiver = new BroadcastReceiver() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$mGattUpdateReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BluetoothLeService bluetoothLeService;
            BluetoothLeService bluetoothLeService2;
            BluetoothGattCharacteristic bluetoothGattCharacteristic;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            String action = intent.getAction();
            if (Intrinsics.areEqual(BluetoothLeService.ACTION_GATT_CONNECTED, action)) {
                HomeFurlencoFragment.this.mConnected = true;
                HomeFurlencoFragment.this.BLE_STATUS_PACKET_RECEIVED = false;
                HomeFurlencoFragment.this.getCommandList();
            } else if (Intrinsics.areEqual(BluetoothLeService.ACTION_GATT_DISCONNECTED, action)) {
                HomeFurlencoFragment.this.mConnected = false;
                HomeFurlencoFragment.this.bleOFF();
            } else if (Intrinsics.areEqual(BluetoothLeService.ACTION_GATT_SERVICES_DISCOVERED, action)) {
                HomeFurlencoFragment homeFurlencoFragment = HomeFurlencoFragment.this;
                bluetoothLeService = homeFurlencoFragment.mBluetoothLeService;
                homeFurlencoFragment.initializeGattServices(bluetoothLeService != null ? bluetoothLeService.getSupportedGattServices() : null);
                bluetoothLeService2 = HomeFurlencoFragment.this.mBluetoothLeService;
                Intrinsics.checkNotNull(bluetoothLeService2);
                bluetoothGattCharacteristic = HomeFurlencoFragment.this.mReadCharacteristic;
                bluetoothLeService2.readCharacteristic(bluetoothGattCharacteristic);
            } else if (Intrinsics.areEqual(BluetoothLeService.ACTION_DATA_AVAILABLE, action)) {
                HomeFurlencoFragment.this.displayData(intent.getStringExtra(BluetoothLeService.EXTRA_DATA));
            } else if (Intrinsics.areEqual(BluetoothLeService.ACTION_WRITE_DATA_AVAILABLE, action)) {
                HomeFurlencoFragment.this.sendContinueCommand();
            }
        }
    };
    private final HashMap<Object, Object> attributes = new HashMap<>();
    private Handler firmwareHandler = new Handler(Looper.getMainLooper());

    /* compiled from: HomeFurlencoFragment.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HomeViewModel.HomeNavigationStates.values().length];
            iArr[HomeViewModel.HomeNavigationStates.BOLT_SETTINGS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
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
        return R.layout.fragment_furlenco_home;
    }

    private final HomeFurlencoModel getHomeFurlencoModel() {
        return (HomeFurlencoModel) this.homeFurlencoModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public HomeFurlencoModel getViewModel() {
        return getHomeFurlencoModel();
    }

    public final Gson getGson() {
        return this.gson;
    }

    public final void setGson(Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "<set-?>");
        this.gson = gson;
    }

    public final ArrayList<BluetoothDevice> getListBluetoothDevice() {
        return this.listBluetoothDevice;
    }

    public final void setListBluetoothDevice(ArrayList<BluetoothDevice> arrayList) {
        this.listBluetoothDevice = arrayList;
    }

    @Override // androidx.fragment.app.Fragment
    public final MainActivity getActivity() {
        return this.activity;
    }

    public final void setActivity(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.handler = new Handler();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.activity = context instanceof MainActivity ? (MainActivity) context : null;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((SwipeRefreshLayout) _$_findCachedViewById(R.id.swipe_refresh_layout_comments)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda17
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                HomeFurlencoFragment.m1030onViewCreated$lambda1(HomeFurlencoFragment.this);
            }
        });
        getHomeFurlencoModel().getDashboardDetails();
        setupDashboard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m1030onViewCreated$lambda1(final HomeFurlencoFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getHomeFurlencoModel().getImeiNo().length() == 12) {
            try {
                if (this$0.setBluetooth(true)) {
                    Runnable runnable = new Runnable() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda29
                        @Override // java.lang.Runnable
                        public final void run() {
                            HomeFurlencoFragment.m1031onViewCreated$lambda1$lambda0(HomeFurlencoFragment.this);
                        }
                    };
                    Handler handler = this$0.handler;
                    Intrinsics.checkNotNull(handler);
                    handler.postDelayed(runnable, 500L);
                }
            } catch (Exception e) {
                Timber.tag("Exp in setBluetooth").e(e.toString(), new Object[0]);
            }
        }
        ((SwipeRefreshLayout) this$0._$_findCachedViewById(R.id.swipe_refresh_layout_comments)).setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1$lambda-0  reason: not valid java name */
    public static final void m1031onViewCreated$lambda1$lambda0(HomeFurlencoFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.setupBluetooth();
        } catch (Exception e) {
            Timber.tag("Exp in setUpBluetooth").e(e.toString(), new Object[0]);
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (!this.isSignOut) {
            getAlertCustomDialogWithHeaderAndMsg(requireActivity(), (ConstraintLayout) _$_findCachedViewById(R.id.resetPasswordContainer));
        }
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        inflater.inflate(R.menu.furlenco_logout_menu, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == R.id.menuSupportId) {
            this.isSignOut = true;
            UserRepository.Companion companion = UserRepository.Companion;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "this.requireActivity()");
            companion.getInstance(requireActivity).logout();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentFurlencoHomeBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        dataBinding.setViewModel(getHomeFurlencoModel());
    }

    private final void setupDashboard() {
        HomeFurlencoFragment homeFurlencoFragment = this;
        getHomeFurlencoModel().getWaterRemaining().observe(homeFurlencoFragment, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFurlencoFragment.m1044setupDashboard$lambda2(HomeFurlencoFragment.this, (Pair) obj);
            }
        });
        getHomeFurlencoModel().getHardwareUpdate().observe(homeFurlencoFragment, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda34
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFurlencoFragment.m1045setupDashboard$lambda3(HomeFurlencoFragment.this, (Boolean) obj);
            }
        });
        getHomeFurlencoModel().getSoftwareUpdate().observe(homeFurlencoFragment, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda35
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFurlencoFragment.m1046setupDashboard$lambda4(HomeFurlencoFragment.this, (Boolean) obj);
            }
        });
        getHomeFurlencoModel().getPlanDetails().observe(homeFurlencoFragment, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFurlencoFragment.m1047setupDashboard$lambda5(HomeFurlencoFragment.this, (String) obj);
            }
        });
        getHomeFurlencoModel().getFilterLifeImage().observe(homeFurlencoFragment, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda36
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFurlencoFragment.m1048setupDashboard$lambda6(HomeFurlencoFragment.this, (Integer) obj);
            }
        });
        getHomeFurlencoModel().getHardwareVersion().observe(homeFurlencoFragment, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFurlencoFragment.m1049setupDashboard$lambda7(HomeFurlencoFragment.this, (String) obj);
            }
        });
        getHomeFurlencoModel().getSoftwareVersion().observe(homeFurlencoFragment, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFurlencoFragment.m1050setupDashboard$lambda8(HomeFurlencoFragment.this, (String) obj);
            }
        });
        getHomeFurlencoModel().getDeviceIMEI_Number().observe(homeFurlencoFragment, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda13
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFurlencoFragment.m1051setupDashboard$lambda9(HomeFurlencoFragment.this, (String) obj);
            }
        });
        getHomeFurlencoModel().getUsageStats().observe(homeFurlencoFragment, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda15
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFurlencoFragment.m1040setupDashboard$lambda10(HomeFurlencoFragment.this, (Triple) obj);
            }
        });
        getHomeFurlencoModel().getHomeNavigationState().observe(homeFurlencoFragment, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda32
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFurlencoFragment.m1041setupDashboard$lambda11(HomeFurlencoFragment.this, (HomeViewModel.HomeNavigationStates) obj);
            }
        });
        getHomeFurlencoModel().getDeviceIMEI_Number().observe(homeFurlencoFragment, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFurlencoFragment.m1042setupDashboard$lambda13(HomeFurlencoFragment.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-2  reason: not valid java name */
    public static final void m1044setupDashboard$lambda2(HomeFurlencoFragment this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (((String) pair.getFirst()).length() != 5 || pair.getSecond() == null) {
            return;
        }
        Object second = pair.getSecond();
        Intrinsics.checkNotNull(second);
        this$0.updateWaterRemainingView((String) pair.getFirst(), ((Number) second).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-3  reason: not valid java name */
    public static final void m1045setupDashboard$lambda3(HomeFurlencoFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boolean booleanValue = it.booleanValue();
        this$0._isHardwareUpdate = booleanValue;
        if (booleanValue) {
            this$0._isFirmwareUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-4  reason: not valid java name */
    public static final void m1046setupDashboard$lambda4(HomeFurlencoFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boolean booleanValue = it.booleanValue();
        this$0._isSoftwareUpdate = booleanValue;
        if (booleanValue) {
            this$0._isFirmwareUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-5  reason: not valid java name */
    public static final void m1047setupDashboard$lambda5(HomeFurlencoFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return;
        }
        ((TextView) this$0._$_findCachedViewById(R.id.planDetails)).setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-6  reason: not valid java name */
    public static final void m1048setupDashboard$lambda6(HomeFurlencoFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null && it.intValue() == -1) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateFilterLifeImage(it.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-7  reason: not valid java name */
    public static final void m1049setupDashboard$lambda7(HomeFurlencoFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._hardwareVersion = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-8  reason: not valid java name */
    public static final void m1050setupDashboard$lambda8(HomeFurlencoFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._softwareVersion = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-9  reason: not valid java name */
    public static final void m1051setupDashboard$lambda9(HomeFurlencoFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str.toString().length() == 12) {
            ((ImageView) this$0._$_findCachedViewById(R.id.wifiInfoIV)).setVisibility(0);
            ((ImageView) this$0._$_findCachedViewById(R.id.settingsIV)).setVisibility(0);
            ((ImageView) this$0._$_findCachedViewById(R.id.bleInfoIV)).setVisibility(0);
            return;
        }
        ((ImageView) this$0._$_findCachedViewById(R.id.wifiInfoIV)).setVisibility(8);
        ((ImageView) this$0._$_findCachedViewById(R.id.settingsIV)).setVisibility(8);
        ((ImageView) this$0._$_findCachedViewById(R.id.bleInfoIV)).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-10  reason: not valid java name */
    public static final void m1040setupDashboard$lambda10(HomeFurlencoFragment this$0, Triple triple) {
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
    /* renamed from: setupDashboard$lambda-11  reason: not valid java name */
    public static final void m1041setupDashboard$lambda11(HomeFurlencoFragment this$0, HomeViewModel.HomeNavigationStates homeNavigationStates) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((homeNavigationStates == null ? -1 : WhenMappings.$EnumSwitchMapping$0[homeNavigationStates.ordinal()]) == 1) {
            this$0.discconnectBLE();
            this$0.setBluetooth(false);
            this$0.showBoltSettingsScreen();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-13  reason: not valid java name */
    public static final void m1042setupDashboard$lambda13(final HomeFurlencoFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str.toString().length() != 12 || this$0.mConnected || Intrinsics.areEqual(this$0.getHomeFurlencoModel().getImeiNo(), "")) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                HomeFurlencoFragment.m1043setupDashboard$lambda13$lambda12(HomeFurlencoFragment.this);
            }
        };
        Handler handler = this$0.handler;
        Intrinsics.checkNotNull(handler);
        handler.postDelayed(runnable, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-13$lambda-12  reason: not valid java name */
    public static final void m1043setupDashboard$lambda13$lambda12(HomeFurlencoFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.setupBluetooth();
        } catch (Exception e) {
            Timber.tag("Exp in setupBluetooth").e(e.toString(), new Object[0]);
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, this, false, new Function1<OnBackPressedCallback, Unit>() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$onActivityCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnBackPressedCallback onBackPressedCallback) {
                invoke2(onBackPressedCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnBackPressedCallback addCallback) {
                Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
                HomeFurlencoFragment homeFurlencoFragment = HomeFurlencoFragment.this;
                homeFurlencoFragment.getAlertCustomDialogWithHeaderAndMsg(homeFurlencoFragment.requireActivity(), (ConstraintLayout) HomeFurlencoFragment.this._$_findCachedViewById(R.id.resetPasswordContainer));
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAlertCustomDialogWithHeaderAndMsg(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNull(context);
        final AlertDialog create = new AlertDialog.Builder(context).create();
        create.requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(R.layout.alert_dialog_with_header, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ader, containerId, false)");
        TextView textView = (TextView) inflate.findViewById(R.id.header);
        textView.setVisibility(8);
        textView.setText("");
        ((TextView) inflate.findViewById(R.id.msg_txt)).setText(getString(R.string.exit));
        ((Button) inflate.findViewById(R.id.cancel_btn)).setVisibility(8);
        inflate.findViewById(R.id.ok_btn).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFurlencoFragment.m1024getAlertCustomDialogWithHeaderAndMsg$lambda15(HomeFurlencoFragment.this, create, view);
            }
        });
        inflate.findViewById(R.id.cancel_btn).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                create.dismiss();
            }
        });
        create.setView(inflate);
        create.show();
        create.setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAlertCustomDialogWithHeaderAndMsg$lambda-15  reason: not valid java name */
    public static final void m1024getAlertCustomDialogWithHeaderAndMsg$lambda15(HomeFurlencoFragment this$0, AlertDialog alertDialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setBluetooth(false);
        try {
            this$0.discconnectBLE();
        } catch (Exception e) {
            Timber.tag("Exp in setBluetooth").e(e.toString(), new Object[0]);
        }
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    private final void updateWaterRemainingView(String str, int i) {
        ((TextView) _$_findCachedViewById(R.id.waterRemainingTenThousand)).setText(String.valueOf(str.charAt(0)));
        ((TextView) _$_findCachedViewById(R.id.waterRemainingThousands)).setText(String.valueOf(str.charAt(1)));
        ((TextView) _$_findCachedViewById(R.id.waterRemainingHundreds)).setText(String.valueOf(str.charAt(2)));
        ((TextView) _$_findCachedViewById(R.id.waterRemainingTens)).setText(String.valueOf(str.charAt(3)));
        ((TextView) _$_findCachedViewById(R.id.waterRemainingOnes)).setText(String.valueOf(str.charAt(4)));
        ((ImageView) _$_findCachedViewById(R.id.waterUsageImage)).setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
    }

    private final void updateFilterLifeImage(int i) {
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.filterLifeImage);
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
        }
    }

    private final void setupUsageStats(List<String> list, List<? extends IBarDataSet> list2, String str) {
        Context context = ((BarChart) _$_findCachedViewById(R.id.barChart)).getContext();
        Intrinsics.checkNotNullExpressionValue(context, "barChart.context");
        int colorFromAttr$default = UiUtilKt.getColorFromAttr$default(context, R.attr.colorOnSurface, null, false, 6, null);
        BarChart barChart = (BarChart) _$_findCachedViewById(R.id.barChart);
        barChart.setDescription("");
        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawLabels(true);
        xAxis.setTextColor(colorFromAttr$default);
        xAxis.setLabelRotationAngle(-45.0f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.getAxisLeft().setTextColor(colorFromAttr$default);
        barChart.getAxisRight().setEnabled(false);
        barChart.getAxisLeft().setSpaceBottom(0.0f);
        barChart.setScaleEnabled(false);
        barChart.setDoubleTapToZoomEnabled(false);
        barChart.setPinchZoom(false);
        barChart.getLegend().setEnabled(false);
        barChart.setData(new BarData(list, (List<IBarDataSet>) list2));
        ((BarData) barChart.getData()).setValueTextColor(colorFromAttr$default);
        ((BarData) barChart.getData()).setHighlightEnabled(false);
        barChart.animateXY(2000, 2000);
        barChart.invalidate();
        ((TextView) _$_findCachedViewById(R.id.averageWaterConsumption)).setText(str);
    }

    private final void showBoltSettingsScreen() {
        this.isSignOut = true;
        String serialNo = getHomeFurlencoModel().getSerialNo();
        String imeiNo = getHomeFurlencoModel().getImeiNo();
        User user = LSApplication.Companion.getUser();
        String id = user != null ? user.getId() : null;
        String value = getHomeFurlencoModel().getProductType().getValue();
        User user2 = LSApplication.Companion.getUser();
        HomeFurlencoFragmentDirections.ActionHomeFragmentToBoltSettingsFragment actionHomeFragmentToBoltSettingsFragment = HomeFurlencoFragmentDirections.actionHomeFragmentToBoltSettingsFragment(new DeviceList(serialNo, imeiNo, id, value, true, user2 != null ? user2.getPlanName() : null, getHomeFurlencoModel().getDeviceConnectivity()));
        Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToBoltSettingsFragment, "_device.let { HomeFurlen…oltSettingsFragment(it) }");
        navigate(actionHomeFragmentToBoltSettingsFragment);
    }

    private final void navigate(NavDirections navDirections) {
        discconnectBLE();
        HomeFurlencoFragment homeFurlencoFragment = this;
        NavDestination currentDestination = FragmentKt.findNavController(homeFurlencoFragment).getCurrentDestination();
        boolean z = false;
        if (currentDestination != null && currentDestination.getId() == R.id.homeFurlencoFragment) {
            z = true;
        }
        if (z) {
            FragmentKt.findNavController(homeFurlencoFragment).navigate(navDirections);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void bleOFF() {
        getHomeFurlencoModel().getBleImageOff().observe(this, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFurlencoFragment.m1020bleOFF$lambda20(HomeFurlencoFragment.this, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bleOFF$lambda-20  reason: not valid java name */
    public static final void m1020bleOFF$lambda20(HomeFurlencoFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateBleWiFiImage(it.intValue(), "BLE");
    }

    private final void setupBluetooth() {
        getHomeFurlencoModel().getConnectivity().observe(this, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFurlencoFragment.m1037setupBluetooth$lambda23(HomeFurlencoFragment.this, (String) obj);
            }
        });
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s-%s", Arrays.copyOf(new Object[]{"LIVSMT-RO", StringsKt.takeLast(getHomeFurlencoModel().getImeiNo(), 4)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        this.macIdAdd = format;
        this.listBluetoothDevice = new ArrayList<>();
        this.mHandler = new Handler();
        getBluetoothAdapter();
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        Boolean valueOf = bluetoothAdapter != null ? Boolean.valueOf(bluetoothAdapter.isEnabled()) : null;
        Intrinsics.checkNotNull(valueOf);
        if (!valueOf.booleanValue()) {
            if (Build.VERSION.SDK_INT < 31) {
                Intent intent = new Intent(this.activity, "android.bluetooth.adapter.action.REQUEST_ENABLE".getClass());
                MainActivity mainActivity = this.activity;
                if (mainActivity != null) {
                    mainActivity.startActivity(intent);
                    return;
                }
                return;
            }
            return;
        }
        getBluetoothLeScanner();
        if (checkIfLocationPermissionGranted()) {
            scanLeDevice();
        } else {
            onRequestPermissionsResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupBluetooth$lambda-23  reason: not valid java name */
    public static final void m1037setupBluetooth$lambda23(final HomeFurlencoFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(str, "bluetooth")) {
            this$0.getHomeFurlencoModel().getBleImage().observe(this$0, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeFurlencoFragment.m1038setupBluetooth$lambda23$lambda21(HomeFurlencoFragment.this, (Integer) obj);
                }
            });
        } else {
            this$0.getHomeFurlencoModel().getWifiImage().observe(this$0, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeFurlencoFragment.m1039setupBluetooth$lambda23$lambda22(HomeFurlencoFragment.this, (Integer) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupBluetooth$lambda-23$lambda-21  reason: not valid java name */
    public static final void m1038setupBluetooth$lambda23$lambda21(HomeFurlencoFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateBleWiFiImage(it.intValue(), "BLE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupBluetooth$lambda-23$lambda-22  reason: not valid java name */
    public static final void m1039setupBluetooth$lambda23$lambda22(HomeFurlencoFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateBleWiFiImage(it.intValue(), "WIFI");
    }

    private final void getBluetoothAdapter() {
        MainActivity mainActivity = this.activity;
        Object systemService = mainActivity != null ? mainActivity.getSystemService("bluetooth") : null;
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
        ArrayList<BluetoothDevice> arrayList = this.listBluetoothDevice;
        Intrinsics.checkNotNull(arrayList);
        arrayList.clear();
        if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_SCAN") == 0) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.postDelayed(new Runnable() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda20
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeFurlencoFragment.m1033scanLeDevice$lambda24(HomeFurlencoFragment.this);
                    }
                }, this.SCAN_PERIOD);
            }
            BluetoothLeScanner bluetoothLeScanner = this.mBluetoothLeScanner;
            Intrinsics.checkNotNull(bluetoothLeScanner);
            bluetoothLeScanner.startScan(this.scanCallback);
            this.mScanning = true;
        } else if (Build.VERSION.SDK_INT >= 31) {
            ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
        } else {
            Handler handler2 = this.mHandler;
            if (handler2 != null) {
                handler2.postDelayed(new Runnable() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda28
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeFurlencoFragment.m1034scanLeDevice$lambda25(HomeFurlencoFragment.this);
                    }
                }, this.SCAN_PERIOD);
            }
            BluetoothLeScanner bluetoothLeScanner2 = this.mBluetoothLeScanner;
            Intrinsics.checkNotNull(bluetoothLeScanner2);
            bluetoothLeScanner2.startScan(this.scanCallback);
            this.mScanning = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scanLeDevice$lambda-24  reason: not valid java name */
    public static final void m1033scanLeDevice$lambda24(HomeFurlencoFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mBluetoothLeScanner != null) {
            BluetoothAdapter bluetoothAdapter = this$0.mBluetoothAdapter;
            if (bluetoothAdapter != null && bluetoothAdapter.getState() == 12) {
                BluetoothLeScanner bluetoothLeScanner = this$0.mBluetoothLeScanner;
                Intrinsics.checkNotNull(bluetoothLeScanner);
                bluetoothLeScanner.stopScan(this$0.scanCallback);
            }
        }
        if (!this$0.mBleConnected) {
            this$0.bleOFF();
            try {
                Toast.makeText(this$0.activity, "Please Switch ON the RO and try again !!", 0).show();
                Log.e("502", "Please Switch ON the RO and try again !!");
            } catch (Exception e) {
                Timber.tag("Exp in Toast").e(e.toString(), new Object[0]);
            }
        }
        this$0.mScanning = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scanLeDevice$lambda-25  reason: not valid java name */
    public static final void m1034scanLeDevice$lambda25(HomeFurlencoFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mBluetoothLeScanner != null) {
            BluetoothAdapter bluetoothAdapter = this$0.mBluetoothAdapter;
            if (bluetoothAdapter != null && bluetoothAdapter.getState() == 12) {
                BluetoothLeScanner bluetoothLeScanner = this$0.mBluetoothLeScanner;
                Intrinsics.checkNotNull(bluetoothLeScanner);
                bluetoothLeScanner.stopScan(this$0.scanCallback);
            }
        }
        if (!this$0.mBleConnected) {
            this$0.bleOFF();
            try {
                Toast.makeText(this$0.activity, "Please Switch ON the RO and try again !!", 0).show();
                Log.e("530", "Please Switch ON the RO and try again !!");
            } catch (Exception e) {
                Timber.tag("Exp in Toast").e(e.toString(), new Object[0]);
            }
        }
        this$0.mScanning = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addBluetoothDevice(BluetoothDevice bluetoothDevice) {
        ArrayList<BluetoothDevice> arrayList = this.listBluetoothDevice;
        Intrinsics.checkNotNull(arrayList);
        if (arrayList.contains(bluetoothDevice)) {
            return;
        }
        ArrayList<BluetoothDevice> arrayList2 = this.listBluetoothDevice;
        Intrinsics.checkNotNull(arrayList2);
        arrayList2.add(bluetoothDevice);
        Timber.tag("Address : ").e(bluetoothDevice.getAddress(), new Object[0]);
        if (isAdded()) {
            if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                if (bluetoothDevice.getName() != null) {
                    Timber.tag("Name").e(bluetoothDevice.getAddress(), new Object[0]);
                    String name = bluetoothDevice.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "device.name");
                    if (StringsKt.startsWith$default(name, "LIVSMT-RO", false, 2, (Object) null)) {
                        Timber.tag("name").e(bluetoothDevice.getName(), new Object[0]);
                        this.mBleConnected = true;
                        if (StringsKt.equals(this.macIdAdd, bluetoothDevice.getName(), true)) {
                            getHomeFurlencoModel().getBleImage().observe(this, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda4
                                @Override // androidx.lifecycle.Observer
                                public final void onChanged(Object obj) {
                                    HomeFurlencoFragment.m1018addBluetoothDevice$lambda26(HomeFurlencoFragment.this, (Integer) obj);
                                }
                            });
                            this.mBleConnected = true;
                            this.mDeviceAddress = bluetoothDevice.getAddress();
                            this.mDeviceName = bluetoothDevice.getName();
                            Intent intent = new Intent(this.activity, BluetoothLeService.class);
                            MainActivity mainActivity = this.activity;
                            if (mainActivity != null) {
                                mainActivity.bindService(intent, this.mServiceConnection, 1);
                            }
                        }
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 31) {
                ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
            } else if (bluetoothDevice.getName() != null) {
                Timber.tag("Name").e(bluetoothDevice.getAddress(), new Object[0]);
                String name2 = bluetoothDevice.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "device.name");
                if (StringsKt.startsWith$default(name2, "LIVSMT-RO", false, 2, (Object) null)) {
                    Timber.tag("name").e(bluetoothDevice.getName(), new Object[0]);
                    this.mBleConnected = true;
                    if (StringsKt.equals(this.macIdAdd, bluetoothDevice.getName(), true)) {
                        getHomeFurlencoModel().getBleImage().observe(this, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda1
                            @Override // androidx.lifecycle.Observer
                            public final void onChanged(Object obj) {
                                HomeFurlencoFragment.m1019addBluetoothDevice$lambda27(HomeFurlencoFragment.this, (Integer) obj);
                            }
                        });
                        this.mBleConnected = true;
                        this.mDeviceAddress = bluetoothDevice.getAddress();
                        this.mDeviceName = bluetoothDevice.getName();
                        Intent intent2 = new Intent(this.activity, BluetoothLeService.class);
                        MainActivity mainActivity2 = this.activity;
                        if (mainActivity2 != null) {
                            mainActivity2.bindService(intent2, this.mServiceConnection, 1);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addBluetoothDevice$lambda-26  reason: not valid java name */
    public static final void m1018addBluetoothDevice$lambda26(HomeFurlencoFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateBleWiFiImage(it.intValue(), "BLE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addBluetoothDevice$lambda-27  reason: not valid java name */
    public static final void m1019addBluetoothDevice$lambda27(HomeFurlencoFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateBleWiFiImage(it.intValue(), "BLE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeGattServices(List<? extends BluetoothGattService> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (BluetoothGattService bluetoothGattService : list) {
            HashMap hashMap = new HashMap();
            String uuid = bluetoothGattService.getUuid().toString();
            if (StringsKt.equals(uuid, BluetoothLeService.Companion.getString_GENUINO101_SERVICE_READ(), true) || StringsKt.equals(uuid, BluetoothLeService.Companion.getString_GENUINO101_SERVICE_WRITE(), true)) {
                arrayList.add(hashMap);
                ArrayList arrayList3 = new ArrayList();
                List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                ArrayList arrayList4 = new ArrayList();
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                    arrayList4.add(bluetoothGattCharacteristic);
                    HashMap hashMap2 = new HashMap();
                    String uuid2 = bluetoothGattCharacteristic.getUuid().toString();
                    Log.e(AnalyticsAttribute.UUID_ATTRIBUTE, uuid2 + "-----------");
                    int properties = bluetoothGattCharacteristic.getProperties();
                    if ((properties | 2) > 0) {
                        if (this.mNotifyCharacteristic != null) {
                            BluetoothLeService bluetoothLeService = this.mBluetoothLeService;
                            Intrinsics.checkNotNull(bluetoothLeService);
                            bluetoothLeService.setCharacteristicNotification(this.mNotifyCharacteristic, true);
                        }
                        this.mReadCharacteristic = bluetoothGattCharacteristic;
                        Log.e("Read char", String.valueOf(bluetoothGattCharacteristic));
                        BluetoothLeService bluetoothLeService2 = this.mBluetoothLeService;
                        Intrinsics.checkNotNull(bluetoothLeService2);
                        bluetoothLeService2.readCharacteristic(bluetoothGattCharacteristic);
                    }
                    if ((properties | 16) > 0) {
                        this.mNotifyCharacteristic = bluetoothGattCharacteristic;
                        Timber.tag(" status :").e("characteristics notification set", new Object[0]);
                        BluetoothLeService bluetoothLeService3 = this.mBluetoothLeService;
                        Intrinsics.checkNotNull(bluetoothLeService3);
                        bluetoothLeService3.setCharacteristicNotification(bluetoothGattCharacteristic, true);
                    }
                    if ((properties & 8) > 0) {
                        Timber.tag("mwc initialised").e("BluetoothGattCharacteristic has PROPERTY_WRITE | PROPERTY_WRITE_WITH_RESPONSE", new Object[0]);
                        this.mWriteCharacteristic = bluetoothGattCharacteristic;
                        Log.e("Write Char", String.valueOf(bluetoothGattCharacteristic));
                    }
                    arrayList3.add(hashMap2);
                }
                arrayList2.add(arrayList3);
            } else {
                Timber.tag("Disconnect").e("disconnect", new Object[0]);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MainActivity mainActivity = this.activity;
        if (mainActivity != null) {
            mainActivity.registerReceiver(this.mGattUpdateReceiver, makeGattUpdateIntentFilter());
        }
        BluetoothLeService bluetoothLeService = this.mBluetoothLeService;
        if (bluetoothLeService != null) {
            Intrinsics.checkNotNull(bluetoothLeService);
            boolean connect = bluetoothLeService.connect(this.mDeviceAddress);
            String tag = LSApplication.Companion.getTAG();
            Log.d(tag, "Connect request result=" + connect);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        MainActivity mainActivity = this.activity;
        if (mainActivity != null) {
            mainActivity.unregisterReceiver(this.mGattUpdateReceiver);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        discconnectBLE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayData(String str) {
        String decrypt;
        try {
            Handler handler = this.firmwareHandler;
            Intrinsics.checkNotNull(handler);
            Runnable runnable = this.myFirmwareUpdateRunnable;
            Intrinsics.checkNotNull(runnable);
            handler.removeCallbacks(runnable);
        } catch (Exception e) {
            Timber.tag("Exp in firmwareHandler").e(e.toString(), new Object[0]);
        }
        try {
            getHomeFurlencoModel().getBleImage().observe(this, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda5
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeFurlencoFragment.m1021displayData$lambda28(HomeFurlencoFragment.this, (Integer) obj);
                }
            });
            if (str == null || StringsKt.startsWith$default(str, "{", false, 2, (Object) null)) {
                return;
            }
            List<String> lines = StringsKt.lines(str);
            String str2 = lines.get(lines.size() - 1);
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
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonData.toString()");
                if (StringsKt.contains$default((CharSequence) jSONObject2, (CharSequence) "ORA", false, 2, (Object) null)) {
                    this._OTAUPDATEREQUEST = true;
                    String jSONObject3 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonData.toString()");
                    getFirmwareData(jSONObject3);
                    return;
                }
                String jSONObject4 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject4, "jsonData.toString()");
                if (StringsKt.contains$default((CharSequence) jSONObject4, (CharSequence) "OTDA", false, 2, (Object) null) && this._OTAUPDATEREQUEST) {
                    String jSONObject5 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject5, "jsonData.toString()");
                    getFirmwareNextData(jSONObject5);
                    return;
                }
                String jSONObject6 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject6, "jsonData.toString()");
                if (StringsKt.contains$default((CharSequence) jSONObject6, (CharSequence) "EOFA", false, 2, (Object) null)) {
                    String jSONObject7 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject7, "jsonData.toString()");
                    reqularPacket(jSONObject7);
                    return;
                } else if (this._OTAUPDATEREQUEST) {
                    getFirmwareNextData("");
                    return;
                } else {
                    String jSONObject8 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject8, "jsonData.toString()");
                    reqularPacket(jSONObject8);
                    return;
                }
            }
            this.myScanRunnable = new Runnable() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFurlencoFragment.m1022displayData$lambda29(HomeFurlencoFragment.this);
                }
            };
            Handler handler2 = this.handler;
            Intrinsics.checkNotNull(handler2);
            Runnable runnable2 = this.myScanRunnable;
            Intrinsics.checkNotNull(runnable2);
            handler2.postDelayed(runnable2, 500L);
            Toast.makeText(this.activity, "Long Data : ", 0).show();
        } catch (Exception unused) {
            this.myScanRunnable = new Runnable() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFurlencoFragment.m1023displayData$lambda30(HomeFurlencoFragment.this);
                }
            };
            Handler handler3 = this.handler;
            Intrinsics.checkNotNull(handler3);
            Runnable runnable3 = this.myScanRunnable;
            Intrinsics.checkNotNull(runnable3);
            handler3.postDelayed(runnable3, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: displayData$lambda-28  reason: not valid java name */
    public static final void m1021displayData$lambda28(HomeFurlencoFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateBleWiFiImage(it.intValue(), "BLE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: displayData$lambda-29  reason: not valid java name */
    public static final void m1022displayData$lambda29(HomeFurlencoFragment this$0) {
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
            Timber.tag("Exp mBluetoothLeService").e(e.toString(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: displayData$lambda-30  reason: not valid java name */
    public static final void m1023displayData$lambda30(HomeFurlencoFragment this$0) {
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

    private final void reqularPacket(String str) {
        final BoldBleData boldBleData = (BoldBleData) this.gson.fromJson(str, (Class<Object>) BoldBleData.class);
        LiveData<Boolean> submissionBLEStatus = getHomeFurlencoModel().getSubmissionBLEStatus(str, "");
        if (submissionBLEStatus != null) {
            submissionBLEStatus.observe(this, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda16
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeFurlencoFragment.m1032reqularPacket$lambda31(HomeFurlencoFragment.this, boldBleData, (Boolean) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reqularPacket$lambda-31  reason: not valid java name */
    public static final void m1032reqularPacket$lambda31(HomeFurlencoFragment this$0, BoldBleData boldBleData, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAdded()) {
            if (this$0.bleCommandList.size() > 0) {
                String str = this$0.bleCommandList.get(0);
                Intrinsics.checkNotNullExpressionValue(str, "bleCommandList[0]");
                this$0.sendToBLEJsonData(str);
                this$0.bleCommandList.remove(0);
            } else if (boldBleData.getFlowRate() != null) {
                this$0.BLE_STATUS_PACKET_RECEIVED = true;
                this$0.getHomeFurlencoModel().getDashboardDetails();
            } else if (boldBleData.getLocation() != null) {
                this$0.BLE_LOCATION_PACKET_RECEIVED = true;
                BluetoothLeService bluetoothLeService = this$0.mBluetoothLeService;
                Intrinsics.checkNotNull(bluetoothLeService);
                bluetoothLeService.readCharacteristic(this$0.mReadCharacteristic);
            } else if (boldBleData.getDailyWaterConsume() != null) {
                this$0.BLE_STATUS_PACKET_RECEIVED = false;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("DWCA", "1");
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "_object.toString()");
                    this$0.sendToBLEJsonData(jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (this$0.bleCommandList.size() > 0) {
            String str2 = this$0.bleCommandList.get(0);
            Intrinsics.checkNotNullExpressionValue(str2, "bleCommandList[0]");
            this$0.sendToBLEJsonData(str2);
            this$0.bleCommandList.remove(0);
        } else if (boldBleData.getFlowRate() != null) {
            this$0.BLE_STATUS_PACKET_RECEIVED = true;
            this$0.BLE_STATUS_PACKET_RECEIVED = true;
            this$0.getCommandList();
        } else if (boldBleData.getLocation() != null) {
            this$0.BLE_LOCATION_PACKET_RECEIVED = true;
            BluetoothLeService bluetoothLeService2 = this$0.mBluetoothLeService;
            Intrinsics.checkNotNull(bluetoothLeService2);
            bluetoothLeService2.readCharacteristic(this$0.mReadCharacteristic);
        } else if (boldBleData.getDailyWaterConsume() != null) {
            this$0.BLE_STATUS_PACKET_RECEIVED = false;
        }
    }

    public final String lookup(String str) {
        Object obj = this.attributes.get(str);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
        return (String) obj;
    }

    public final String publishToDevice(byte[] bArr) {
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

    private final void writeCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.mBluetoothLeService != null) {
            Log.e("check", "in writeC called: " + bluetoothGattCharacteristic + ".toString()");
            BluetoothLeService bluetoothLeService = this.mBluetoothLeService;
            Intrinsics.checkNotNull(bluetoothLeService);
            bluetoothLeService.writeCharacteristic(bluetoothGattCharacteristic);
        }
    }

    private final IntentFilter makeGattUpdateIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BluetoothLeService.ACTION_GATT_CONNECTED);
        intentFilter.addAction(BluetoothLeService.ACTION_GATT_DISCONNECTED);
        intentFilter.addAction(BluetoothLeService.ACTION_GATT_SERVICES_DISCOVERED);
        intentFilter.addAction(BluetoothLeService.ACTION_DATA_AVAILABLE);
        intentFilter.addAction(BluetoothLeService.ACTION_WRITE_DATA_AVAILABLE);
        return intentFilter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendContinueCommand() {
        if (this.counter < this.packet_list.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.mWriteCharacteristic;
            if (bluetoothGattCharacteristic != null) {
                bluetoothGattCharacteristic.setWriteType(2);
            }
            BluetoothGattCharacteristic bluetoothGattCharacteristic2 = this.mWriteCharacteristic;
            if (bluetoothGattCharacteristic2 != null) {
                bluetoothGattCharacteristic2.setValue(this.packet_list.get(this.counter));
            }
            this.counter++;
            BluetoothGattCharacteristic bluetoothGattCharacteristic3 = this.mWriteCharacteristic;
            if (bluetoothGattCharacteristic3 != null) {
                writeCharacteristic(bluetoothGattCharacteristic3);
                return;
            }
            return;
        }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private final boolean checkIfLocationPermissionGranted() {
        MainActivity mainActivity = this.activity;
        Integer valueOf = mainActivity != null ? Integer.valueOf(ContextCompat.checkSelfPermission(mainActivity, "android.permission.ACCESS_FINE_LOCATION")) : null;
        return valueOf != null && valueOf.intValue() == 0;
    }

    public final void onRequestPermissionsResult() {
        MainActivity mainActivity = this.activity;
        if (mainActivity != null) {
            ActivityCompat.requestPermissions(mainActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this.LOCATION_PERMISSION_CODE);
        }
    }

    private final void sendToBLEJsonData(String str) {
        try {
            byte[] hexStringToByteArray = Encrypt.hexStringToByteArray(Encrypt.encrypt(str, AppConstants.BEL_ENC_KEY));
            Intrinsics.checkNotNullExpressionValue(hexStringToByteArray, "hexStringToByteArray(encriptedData)");
            Log.e("Return Hex Data:----", Encrypt.byteArrayToHexString(hexStringToByteArray));
            if (Intrinsics.areEqual(publishToDevice(hexStringToByteArray), "succes")) {
                this.myScanRunnable = new Runnable() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda27
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeFurlencoFragment.m1035sendToBLEJsonData$lambda36(HomeFurlencoFragment.this);
                    }
                };
                Handler handler = this.handler;
                Intrinsics.checkNotNull(handler);
                Runnable runnable = this.myScanRunnable;
                Intrinsics.checkNotNull(runnable);
                handler.postDelayed(runnable, 3500L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendToBLEJsonData$lambda-36  reason: not valid java name */
    public static final void m1035sendToBLEJsonData$lambda36(HomeFurlencoFragment this$0) {
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

    private final void sendToBLEJsonData(String str, boolean z) {
        try {
            byte[] hexStringToByteArray = Encrypt.hexStringToByteArray(Encrypt.encrypt(str, AppConstants.BEL_ENC_KEY));
            Intrinsics.checkNotNullExpressionValue(hexStringToByteArray, "hexStringToByteArray(encriptedData)");
            Log.e("Return Hex Data:----", Encrypt.byteArrayToHexString(hexStringToByteArray));
            if (Intrinsics.areEqual(publishToDevice(hexStringToByteArray), "succes") && z) {
                this.myScanRunnable = new Runnable() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda25
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeFurlencoFragment.m1036sendToBLEJsonData$lambda37(HomeFurlencoFragment.this);
                    }
                };
                Handler handler = this.handler;
                Intrinsics.checkNotNull(handler);
                Runnable runnable = this.myScanRunnable;
                Intrinsics.checkNotNull(runnable);
                handler.postDelayed(runnable, 1000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendToBLEJsonData$lambda-37  reason: not valid java name */
    public static final void m1036sendToBLEJsonData$lambda37(HomeFurlencoFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Toast.makeText(this$0.activity, "Read Characteristic", 0).show();
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

    private final void getBleData() {
        if (this.bleCommandList.size() > 0) {
            String str = this.bleCommandList.get(0);
            Intrinsics.checkNotNullExpressionValue(str, "bleCommandList[0]");
            sendToBLEJsonData(str);
            this.bleCommandList.remove(0);
            return;
        }
        BluetoothLeService bluetoothLeService = this.mBluetoothLeService;
        Intrinsics.checkNotNull(bluetoothLeService);
        bluetoothLeService.readCharacteristic(this.mReadCharacteristic);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCommandList() {
        this.bleCommandList.clear();
        getHomeFurlencoModel().getPendingBleCommand().observe(this, new Observer() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda33
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFurlencoFragment.m1026getCommandList$lambda38(HomeFurlencoFragment.this, (BoltCommandsResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCommandList$lambda-38  reason: not valid java name */
    public static final void m1026getCommandList$lambda38(HomeFurlencoFragment this$0, BoltCommandsResponse it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAdded()) {
            this$0.bleCommandList.clear();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.boltCommandsResponse = it;
            BoltCommandsResponse boltCommandsResponse = null;
            if (it == null) {
                Intrinsics.throwUninitializedPropertyAccessException("boltCommandsResponse");
                it = null;
            }
            if (it.getRTC_Time() != null) {
                ArrayList<String> arrayList = this$0.bleCommandList;
                BoltCommandsResponse boltCommandsResponse2 = this$0.boltCommandsResponse;
                if (boltCommandsResponse2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("boltCommandsResponse");
                    boltCommandsResponse2 = null;
                }
                arrayList.add(boltCommandsResponse2.getRTC_Time());
            }
            BoltCommandsResponse boltCommandsResponse3 = this$0.boltCommandsResponse;
            if (boltCommandsResponse3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("boltCommandsResponse");
                boltCommandsResponse3 = null;
            }
            List<RechargeResponse> rechargeCommands = boltCommandsResponse3.getRechargeCommands();
            Integer valueOf = rechargeCommands != null ? Integer.valueOf(rechargeCommands.size()) : null;
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.intValue() > 0) {
                int i = 0;
                while (true) {
                    BoltCommandsResponse boltCommandsResponse4 = this$0.boltCommandsResponse;
                    if (boltCommandsResponse4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("boltCommandsResponse");
                        boltCommandsResponse4 = null;
                    }
                    List<RechargeResponse> rechargeCommands2 = boltCommandsResponse4.getRechargeCommands();
                    Integer valueOf2 = rechargeCommands2 != null ? Integer.valueOf(rechargeCommands2.size()) : null;
                    Intrinsics.checkNotNull(valueOf2);
                    if (i >= valueOf2.intValue()) {
                        break;
                    }
                    ArrayList<String> arrayList2 = this$0.bleCommandList;
                    BoltCommandsResponse boltCommandsResponse5 = this$0.boltCommandsResponse;
                    if (boltCommandsResponse5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("boltCommandsResponse");
                        boltCommandsResponse5 = null;
                    }
                    List<RechargeResponse> rechargeCommands3 = boltCommandsResponse5.getRechargeCommands();
                    Intrinsics.checkNotNull(rechargeCommands3);
                    arrayList2.add(rechargeCommands3.get(i).getRechargeList());
                    i++;
                }
            }
            BoltCommandsResponse boltCommandsResponse6 = this$0.boltCommandsResponse;
            if (boltCommandsResponse6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("boltCommandsResponse");
            } else {
                boltCommandsResponse = boltCommandsResponse6;
            }
            Boolean pullFiveRequest = boltCommandsResponse.getPullFiveRequest();
            Intrinsics.checkNotNull(pullFiveRequest);
            if (pullFiveRequest.booleanValue()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("PULL", "5");
                    this$0.bleCommandList.add(jSONObject.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (!this$0.BLE_LOCATION_PACKET_RECEIVED) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("PULL", "1");
                    this$0.bleCommandList.add(jSONObject2.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (this$0.bleCommandList.size() > 0) {
                Log.e("bleCommandList 0", this$0.bleCommandList.toString());
                if (this$0.BLE_STATUS_PACKET_RECEIVED) {
                    Log.e("bleCommandList 1", this$0.bleCommandList.toString());
                    String str = this$0.bleCommandList.get(0);
                    Intrinsics.checkNotNullExpressionValue(str, "bleCommandList[0]");
                    this$0.sendToBLEJsonData(str);
                    Log.e("bleCommandList 2", this$0.bleCommandList.toString());
                    this$0.bleCommandList.remove(0);
                    Log.e("bleCommandList 3", this$0.bleCommandList.toString());
                }
            } else if (this$0.BLE_STATUS_PACKET_RECEIVED) {
                this$0.discconnectBLE();
            }
        } else if (this$0.BLE_STATUS_PACKET_RECEIVED) {
            this$0.discconnectBLE();
        }
    }

    public final boolean setBluetooth(boolean z) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean isEnabled = defaultAdapter.isEnabled();
        if (isAdded()) {
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
        return true;
    }

    private final void getFirmwareNextData(String str) {
        if (!Intrinsics.areEqual(str, "")) {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("OTDA")) {
                List split$default = StringsKt.split$default((CharSequence) jSONObject.getString("OTDA").toString(), new String[]{","}, false, 0, 6, (Object) null);
                if (split$default.size() == 3) {
                    int parseInt = Integer.parseInt((String) split$default.get(1));
                    this.sentPacket = parseInt;
                    if (parseInt == this.firmwareParts.size()) {
                        this._OTAUPDATECANCELREQUEST = true;
                        this._OTAUPDATEREQUEST = false;
                        this.firmwareParts.clear();
                        Dialog dialog = this.firmwareDialoglog;
                        Intrinsics.checkNotNull(dialog);
                        dialog.dismiss();
                        getBleData();
                    } else if (Intrinsics.areEqual(split$default.get(2), AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        sendToBLEJsonData(this.firmwareParts.get(this.sentPacket), false);
                    } else {
                        sendToBLEJsonData(this.firmwareParts.get(this.sentPacket - 1), false);
                    }
                }
            }
        } else if (this.sentPacket == this.firmwareParts.size() - 1) {
            this._OTAUPDATECANCELREQUEST = true;
            this._OTAUPDATEREQUEST = false;
            this.firmwareParts.clear();
            Dialog dialog2 = this.firmwareDialoglog;
            Intrinsics.checkNotNull(dialog2);
            dialog2.dismiss();
            getBleData();
        } else {
            sendToBLEJsonData(this.firmwareParts.get(this.sentPacket), false);
        }
        int size = (this.sentPacket * 100) / this.firmwareParts.size();
        CircularScoreView circularScoreView = this.circularScoreView;
        Intrinsics.checkNotNull(circularScoreView);
        circularScoreView.setScore(size);
        if (this.sentPacket < this.firmwareParts.size() - 1) {
            this.myFirmwareUpdateRunnable = new Runnable() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda24
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFurlencoFragment.m1029getFirmwareNextData$lambda39(HomeFurlencoFragment.this);
                }
            };
            Handler handler = this.firmwareHandler;
            Intrinsics.checkNotNull(handler);
            Runnable runnable = this.myFirmwareUpdateRunnable;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getFirmwareNextData$lambda-39  reason: not valid java name */
    public static final void m1029getFirmwareNextData$lambda39(HomeFurlencoFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.sendToBLEJsonData(this$0.firmwareParts.get(this$0.sentPacket), false);
            Handler handler = this$0.firmwareHandler;
            Intrinsics.checkNotNull(handler);
            Runnable runnable = this$0.myFirmwareUpdateRunnable;
            Intrinsics.checkNotNull(runnable);
            handler.removeCallbacks(runnable);
        } catch (Exception e) {
            Log.e(AgentHealth.DEFAULT_KEY, e.toString());
        }
    }

    private final void getFirmwareData(final String str) {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please Wait..");
        progressDialog.show();
        progressDialog.setCancelable(false);
        final Response.Listener listener = new Response.Listener() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda19
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                HomeFurlencoFragment.m1027getFirmwareData$lambda40(progressDialog, this, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda18
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                HomeFurlencoFragment.m1028getFirmwareData$lambda41(progressDialog, this, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(listener, errorListener) { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$getFirmwareData$stringRequest$1
            @Override // com.android.volley.Request
            protected Map<String, String> getParams() {
                HashMap hashMap = new HashMap();
                hashMap.put("roData", str);
                return hashMap;
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000, 1, 1.0f));
        if (isAdded()) {
            MyVolleySingleton.getInstance(requireActivity()).getRequestQueue().add(stringRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getFirmwareData$lambda-40  reason: not valid java name */
    public static final void m1027getFirmwareData$lambda40(ProgressDialog dialog, HomeFurlencoFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            dialog.dismiss();
            JSONObject jSONObject = new JSONObject(String.valueOf(str));
            if (StringsKt.equals(jSONObject.getString("success"), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, true)) {
                String message = jSONObject.getString("message");
                Intrinsics.checkNotNullExpressionValue(message, "message");
                if (this$0.splitToNChar(message)) {
                    this$0.showFirmwareUpdateDialog();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getFirmwareData$lambda-41  reason: not valid java name */
    public static final void m1028getFirmwareData$lambda41(ProgressDialog dialog, HomeFurlencoFragment this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        AppUtils.showDefaultAlert(this$0.getContext(), "Server not responding");
    }

    private final boolean splitToNChar(String str) {
        this.firmwareParts.clear();
        int length = str.length();
        int i = 0;
        int i2 = 1;
        while (i < length) {
            String padStart = StringsKt.padStart(String.valueOf(i2), 3, '0');
            int i3 = i + 559;
            String substring = str.substring(i, RangesKt.coerceAtMost(length, i3));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String padStart2 = StringsKt.padStart(String.valueOf(substring.length()), 3, '0');
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("{\"OTD\":\"S%s%sW%s%s", Arrays.copyOf(new Object[]{padStart, padStart2, substring, "11E\"}"}, 4));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            this.firmwareParts.add(format);
            i2++;
            i = i3;
        }
        if (!this.firmwareParts.isEmpty()) {
            this.firmwareParts.add("{\"EOF\"=\"1\"}");
        }
        return true;
    }

    public final void showFirmwareUpdateDialog() {
        Context context = getContext();
        Dialog dialog = context != null ? new Dialog(context) : null;
        this.firmwareDialoglog = dialog;
        if (dialog != null) {
            dialog.requestWindowFeature(1);
        }
        Dialog dialog2 = this.firmwareDialoglog;
        if (dialog2 != null) {
            dialog2.setContentView(R.layout.dialog_firmware_update);
        }
        Dialog dialog3 = this.firmwareDialoglog;
        Window window = dialog3 != null ? dialog3.getWindow() : null;
        Intrinsics.checkNotNull(window);
        window.setLayout(-1, -2);
        Dialog dialog4 = this.firmwareDialoglog;
        Window window2 = dialog4 != null ? dialog4.getWindow() : null;
        Intrinsics.checkNotNull(window2);
        window2.setBackgroundDrawable(new ColorDrawable(0));
        Dialog dialog5 = this.firmwareDialoglog;
        Intrinsics.checkNotNull(dialog5);
        final Button button = (Button) dialog5.findViewById(R.id.updateButton);
        Dialog dialog6 = this.firmwareDialoglog;
        Intrinsics.checkNotNull(dialog6);
        final TextView textView = (TextView) dialog6.findViewById(R.id.noThanksButton);
        Dialog dialog7 = this.firmwareDialoglog;
        Intrinsics.checkNotNull(dialog7);
        final LinearLayout linearLayout = (LinearLayout) dialog7.findViewById(R.id.llAnimation);
        Dialog dialog8 = this.firmwareDialoglog;
        Intrinsics.checkNotNull(dialog8);
        final Button button2 = (Button) dialog8.findViewById(R.id.cancelButton);
        Dialog dialog9 = this.firmwareDialoglog;
        Intrinsics.checkNotNull(dialog9);
        final TextView textView2 = (TextView) dialog9.findViewById(R.id.firmwareText);
        Dialog dialog10 = this.firmwareDialoglog;
        Intrinsics.checkNotNull(dialog10);
        View findViewById = dialog10.findViewById(R.id.score_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.wssholmes.stark.circular_score.CircularScoreView");
        CircularScoreView circularScoreView = (CircularScoreView) findViewById;
        this.circularScoreView = circularScoreView;
        Intrinsics.checkNotNull(circularScoreView);
        circularScoreView.setScore(0);
        linearLayout.setVisibility(8);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFurlencoFragment.m1052showFirmwareUpdateDialog$lambda43(button, linearLayout, textView, button2, textView2, this, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFurlencoFragment.m1053showFirmwareUpdateDialog$lambda44(HomeFurlencoFragment.this, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.furlenco.view.HomeFurlencoFragment$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFurlencoFragment.m1054showFirmwareUpdateDialog$lambda45(HomeFurlencoFragment.this, view);
            }
        });
        Dialog dialog11 = this.firmwareDialoglog;
        Intrinsics.checkNotNull(dialog11);
        dialog11.show();
        Dialog dialog12 = this.firmwareDialoglog;
        Intrinsics.checkNotNull(dialog12);
        dialog12.setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showFirmwareUpdateDialog$lambda-43  reason: not valid java name */
    public static final void m1052showFirmwareUpdateDialog$lambda43(Button button, LinearLayout linearLayout, TextView textView, Button button2, TextView textView2, HomeFurlencoFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        button.setVisibility(8);
        linearLayout.setVisibility(0);
        textView.setVisibility(8);
        button2.setVisibility(0);
        textView2.setText("The firmware is being updated, please do not turn off the RO, do not close the app, make sure phone is near the RO");
        this$0.sendToBLEJsonData(this$0.firmwareParts.get(0), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showFirmwareUpdateDialog$lambda-44  reason: not valid java name */
    public static final void m1053showFirmwareUpdateDialog$lambda44(HomeFurlencoFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._OTAUPDATEREQUEST = false;
        this$0._OTAUPDATECANCELREQUEST = true;
        this$0.firmwareParts.clear();
        this$0.getBleData();
        Dialog dialog = this$0.firmwareDialoglog;
        Intrinsics.checkNotNull(dialog);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showFirmwareUpdateDialog$lambda-45  reason: not valid java name */
    public static final void m1054showFirmwareUpdateDialog$lambda45(HomeFurlencoFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._OTAUPDATEREQUEST = false;
        this$0._OTAUPDATECANCELREQUEST = true;
        this$0.firmwareParts.clear();
        this$0.getBleData();
        Dialog dialog = this$0.firmwareDialoglog;
        Intrinsics.checkNotNull(dialog);
        dialog.dismiss();
    }

    private final void discconnectBLE() {
        Handler handler = this.handler;
        if (handler != null) {
            try {
                Intrinsics.checkNotNull(handler);
                Runnable runnable = this.myRunnable;
                Intrinsics.checkNotNull(runnable);
                handler.removeCallbacks(runnable);
            } catch (Exception e) {
                Log.e(AgentHealth.DEFAULT_KEY, e.toString());
            }
            try {
                Handler handler2 = this.handler;
                Intrinsics.checkNotNull(handler2);
                Runnable runnable2 = this.myScanRunnable;
                Intrinsics.checkNotNull(runnable2);
                handler2.removeCallbacks(runnable2);
            } catch (Exception e2) {
                Log.e(AgentHealth.DEFAULT_KEY, e2.toString());
            }
            try {
                Handler handler3 = this.handler;
                Intrinsics.checkNotNull(handler3);
                Runnable runnable3 = this.myScanDataRunnable;
                Intrinsics.checkNotNull(runnable3);
                handler3.removeCallbacks(runnable3);
            } catch (Exception e3) {
                Log.e(AgentHealth.DEFAULT_KEY, e3.toString());
            }
            try {
                Handler handler4 = this.handler;
                Intrinsics.checkNotNull(handler4);
                Runnable runnable4 = this.myScanFirstRunnable;
                Intrinsics.checkNotNull(runnable4);
                handler4.removeCallbacks(runnable4);
            } catch (Exception e4) {
                Log.e(AgentHealth.DEFAULT_KEY, e4.toString());
            }
        }
        try {
            BluetoothLeService bluetoothLeService = this.mBluetoothLeService;
            Intrinsics.checkNotNull(bluetoothLeService);
            bluetoothLeService.disconnect();
        } catch (Exception e5) {
            Log.e(AgentHealth.DEFAULT_KEY, e5.toString());
        }
        try {
            BluetoothLeService bluetoothLeService2 = this.mBluetoothLeService;
            Intrinsics.checkNotNull(bluetoothLeService2);
            bluetoothLeService2.close();
        } catch (Exception e6) {
            Log.e(AgentHealth.DEFAULT_KEY, e6.toString());
        }
        try {
            this.mBluetoothLeService = null;
        } catch (IllegalArgumentException e7) {
            Log.e(AgentHealth.DEFAULT_KEY, e7.toString());
        }
        this.mBleConnected = false;
        this.mConnected = false;
    }
}
