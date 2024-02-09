package com.livpure.safedrink.dispenser.view;

import android.app.Activity;
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
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
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
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.zxing.Result;
import com.koushikdutta.async.http.body.StringBody;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.HomeFragmentDirections;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.bolt.data.models.BoldBleData;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import com.livpure.safedrink.bolt.data.models.RechargeResponse;
import com.livpure.safedrink.bolt.service.Base64Hex;
import com.livpure.safedrink.bolt.service.Encrypt;
import com.livpure.safedrink.common.UiUtilKt;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentUnlimitedWaterHomeBinding;
import com.livpure.safedrink.dispenser.data.models.EnvyBLEResponse;
import com.livpure.safedrink.dispenser.data.models.EnvyDashbordOffline;
import com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel;
import com.livpure.safedrink.dispenser.view.HomeDispenserFragmentDirections;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.segment.SegmentLogger;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.utils.AnimProgressBar;
import com.livpure.safedrink.utils.AppConstants;
import com.livpure.safedrink.utils.GPSTracker;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.payload.PayloadController;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
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
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* compiled from: UnlimitedWaterHomeFragment.kt */
@Metadata(d1 = {"\u0000¼\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 º\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002º\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010b\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010c\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0002H\u0016J\b\u0010d\u001a\u00020%H\u0002J\b\u0010e\u001a\u00020%H\u0002J\b\u0010f\u001a\u00020\rH\u0002J\b\u0010g\u001a\u00020\rH\u0002J\b\u0010h\u001a\u00020%H\u0002J\b\u0010i\u001a\u00020%H\u0002J\b\u0010j\u001a\u00020%H\u0002J\u0012\u0010k\u001a\u00020%2\b\u0010l\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010m\u001a\u00020%H\u0002J\b\u0010n\u001a\u00020%H\u0002J\b\u0010o\u001a\u00020%H\u0002J\b\u0010p\u001a\u00020\u0006H\u0014J\b\u0010q\u001a\u00020rH\u0014J\b\u0010s\u001a\u00020%H\u0002J\b\u0010t\u001a\u00020%H\u0002J\u0018\u0010u\u001a\u00020%2\u000e\u0010v\u001a\n\u0012\u0004\u0012\u00020x\u0018\u00010wH\u0002J\b\u0010y\u001a\u00020%H\u0002J\u0010\u0010z\u001a\u00020\u000b2\b\u0010{\u001a\u0004\u0018\u00010\u000bJ\"\u0010|\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u000b2\u0006\u0010~\u001a\u00020\u000b2\b\b\u0002\u0010\u007f\u001a\u00020\u0006H\u0002J&\u0010\u0080\u0001\u001a\u00020%2\u0007\u0010\u0081\u0001\u001a\u00020\u00062\u0007\u0010\u0082\u0001\u001a\u00020\u00062\t\u0010l\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J\u0015\u0010\u0084\u0001\u001a\u00020%2\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0016J\u001d\u0010\u0087\u0001\u001a\u00020%2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0016J\t\u0010\u008c\u0001\u001a\u00020%H\u0016J\u0013\u0010\u008d\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0016J\t\u0010\u0090\u0001\u001a\u00020%H\u0002J1\u0010\u0090\u0001\u001a\u00020%2\u0007\u0010\u0081\u0001\u001a\u00020\u00062\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016¢\u0006\u0003\u0010\u0094\u0001J\u001f\u0010\u0095\u0001\u001a\u00020%2\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0017J\t\u0010\u0098\u0001\u001a\u00020%H\u0002J\u0017\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u000b2\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0002J\t\u0010\u009c\u0001\u001a\u00020%H\u0002J\t\u0010\u009d\u0001\u001a\u00020%H\u0002J\u0012\u0010\u009e\u0001\u001a\u00020%2\u0007\u0010\u009f\u0001\u001a\u00020\u000bH\u0002J\t\u0010 \u0001\u001a\u00020\rH\u0002J\u0016\u0010¡\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010¢\u0001\u001a\u0004\u0018\u00010LH\u0002J\t\u0010£\u0001\u001a\u00020%H\u0003J\t\u0010¤\u0001\u001a\u00020%H\u0002J1\u0010¥\u0001\u001a\u00020%2\r\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0w2\u000e\u0010§\u0001\u001a\t\u0012\u0005\u0012\u00030¨\u00010w2\u0007\u0010©\u0001\u001a\u00020\u000bH\u0002J\t\u0010ª\u0001\u001a\u00020%H\u0002J\t\u0010«\u0001\u001a\u00020%H\u0002J\u0012\u0010¬\u0001\u001a\u00020%2\u0007\u0010\u00ad\u0001\u001a\u00020\u000bH\u0002J\u0012\u0010®\u0001\u001a\u00020%2\u0007\u0010¯\u0001\u001a\u00020\u000bH\u0002J\t\u0010°\u0001\u001a\u00020%H\u0002J\t\u0010±\u0001\u001a\u00020%H\u0002J\t\u0010²\u0001\u001a\u00020%H\u0002J\u0012\u0010³\u0001\u001a\u00020%2\u0007\u0010\u009a\u0001\u001a\u00020\u000bH\u0002J\t\u0010´\u0001\u001a\u00020%H\u0002J\u0014\u0010µ\u0001\u001a\u00020%2\t\b\u0001\u0010¶\u0001\u001a\u00020\u0006H\u0002J\u0014\u0010·\u0001\u001a\u00020%2\t\b\u0001\u0010¶\u0001\u001a\u00020\u0006H\u0002J\u0014\u0010¸\u0001\u001a\u00020%2\t\b\u0001\u0010¶\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010¹\u0001\u001a\u00020%2\u0007\u0010¢\u0001\u001a\u00020LH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00138\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R2\u0010\u0017\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0019`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u001cj\b\u0012\u0004\u0012\u00020\u000b`\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00105\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u0010'R\u000e\u00108\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010R\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bT\u0010UR\u000e\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\\\u001a\u00020]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\b^\u0010_¨\u0006»\u0001"}, d2 = {"Lcom/livpure/safedrink/dispenser/view/UnlimitedWaterHomeFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentUnlimitedWaterHomeBinding;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "CAMERA_PERMISSION_CODE", "", "LOCATION_PERMISSION_CODE", "SCAN_PERIOD", "", "_hardwareVersion", "", "_isFirmwareUpdate", "", "_isHardwareUpdate", "_isSoftwareUpdate", "_referralCode", "_softwareVersion", "android12BlePermission", "", "[Ljava/lang/String;", "animProgressBar", "Lcom/livpure/safedrink/utils/AnimProgressBar;", "attributes", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "bleCommandList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "codeScanner", "Lcom/budiyev/android/codescanner/CodeScanner;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "currentLocation", "", "getCurrentLocation", "()Lkotlin/Unit;", "dataBinding", AndroidContextPlugin.DEVICE_KEY, "Landroid/bluetooth/BluetoothDevice;", "firstLoad", "gpsTracker", "Lcom/livpure/safedrink/utils/GPSTracker;", "handler", "Landroid/os/Handler;", "isDisconnected", "job", "Lkotlinx/coroutines/Job;", "latitude", "", "listBluetoothDevice", "locationAccessPermission", "getLocationAccessPermission", "longitude", "mBleConnected", "mBluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "mBluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "mBluetoothLeScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "mDeviceAddress", "mDeviceName", "mGattCallback", "Landroid/bluetooth/BluetoothGattCallback;", "mLocationManager", "Landroid/location/LocationManager;", "mLocationPowerBalanceRequest", "Lcom/google/android/gms/location/LocationRequest;", "mLocationRequest", "mLocationSettingRequestBuilder", "Lcom/google/android/gms/location/LocationSettingsRequest$Builder;", "mNotifyCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "mReadCharacteristic", "mReadCharacteristicTemp", "mScanning", "mWriteCharacteristic", "macIdAdd", "navArgs", "Lcom/livpure/safedrink/dispenser/view/UnlimitedWaterHomeFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/dispenser/view/UnlimitedWaterHomeFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "scanCallback", "Landroid/bluetooth/le/ScanCallback;", "settingsClient", "Lcom/google/android/gms/location/SettingsClient;", "unlimitedWaterHomeModel", "Lcom/livpure/safedrink/dispenser/model/UnlimitedWaterHomeModel;", "getUnlimitedWaterHomeModel", "()Lcom/livpure/safedrink/dispenser/model/UnlimitedWaterHomeModel;", "unlimitedWaterHomeModel$delegate", "Lkotlin/Lazy;", "addBluetoothDevice", "bindVariablesToView", "buildLocationSettingRequest", "checkGpsEnablePermission", "checkIfLocationPermissionGranted", "checkLocationAccessPermission", "connectWithBle", "createLocationRequest", "disConnectBLE", "displayData", "data", "getBluetoothAdapter", "getBluetoothLeScanner", "getCommandList", "getLayoutId", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "gpsEnablePermission", "initContextViews", "initializeGattServices", "gattServices", "", "Landroid/bluetooth/BluetoothGattService;", "listeners", "lookup", AnalyticsAttribute.UUID_ATTRIBUTE, "matchDetails", "inputString", "whatToFind", "startIndex", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "openServiceComplaint", "publishToDevice", "message", "", "requestPermission", "scanLeDevice", "sendToBLEJsonData", "value", "setBluetooth", "setCharData", "characteristic", "setupBluetooth", "setupDashboard", "setupUsageStats", "dates", "consumptionDataSetList", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "averageConsumptionMessage", "showBoltSettingsScreen", "showCameraDialog", "showDialog", "description", "showInviteFriend", "referralLink", "showPlanChangeAirScreen", "showReferAndEarnScreen", "showSerialNumberDialog", "showToastMessage", "synchronizeBLE", "updateBleWiFiImage", "resId", "updateFilterLifeImage", "updateWaterRemainingView", "writeCharacteristic", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnlimitedWaterHomeFragment extends DataBindingFragment<FragmentUnlimitedWaterHomeBinding> implements CoroutineScope {
    public static final Companion Companion = new Companion(null);
    public static final long LOCATION_INTERVAL = 10000;
    public static final int LOCATION_PERMISSION = 102;
    public static final int LOCATION_SETTING_PERMISSION = 103;
    private boolean _isFirmwareUpdate;
    private boolean _isHardwareUpdate;
    private boolean _isSoftwareUpdate;
    private AnimProgressBar animProgressBar;
    private CodeScanner codeScanner;
    private FragmentUnlimitedWaterHomeBinding dataBinding;
    private BluetoothDevice device;
    private boolean firstLoad;
    private GPSTracker gpsTracker;
    private Handler handler;
    private boolean isDisconnected;
    private Job job;
    private double latitude;
    private ArrayList<String> listBluetoothDevice;
    private double longitude;
    private boolean mBleConnected;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothLeScanner mBluetoothLeScanner;
    private String mDeviceAddress;
    private String mDeviceName;
    private LocationManager mLocationManager;
    private LocationRequest mLocationPowerBalanceRequest;
    private LocationRequest mLocationRequest;
    private LocationSettingsRequest.Builder mLocationSettingRequestBuilder;
    private BluetoothGattCharacteristic mNotifyCharacteristic;
    private BluetoothGattCharacteristic mReadCharacteristic;
    private BluetoothGattCharacteristic mReadCharacteristicTemp;
    private boolean mScanning;
    private BluetoothGattCharacteristic mWriteCharacteristic;
    private final NavArgsLazy navArgs$delegate;
    private SettingsClient settingsClient;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy unlimitedWaterHomeModel$delegate = LazyKt.lazy(new Function0<UnlimitedWaterHomeModel>() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$unlimitedWaterHomeModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UnlimitedWaterHomeModel invoke() {
            UnlimitedWaterHomeFragmentArgs navArgs;
            UnlimitedWaterHomeModel unlimitedWaterHomeModel = (UnlimitedWaterHomeModel) new ViewModelProvider(UnlimitedWaterHomeFragment.this).get(UnlimitedWaterHomeModel.class);
            navArgs = UnlimitedWaterHomeFragment.this.getNavArgs();
            unlimitedWaterHomeModel.setDevice(navArgs.getDevice());
            return unlimitedWaterHomeModel;
        }
    });
    private String _referralCode = "";
    private final long SCAN_PERIOD = 10000;
    private final int LOCATION_PERMISSION_CODE = 2;
    private String macIdAdd = "";
    private String _hardwareVersion = "";
    private String _softwareVersion = "";
    private final int CAMERA_PERMISSION_CODE = 100;
    private final String[] android12BlePermission = {"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
    private final ScanCallback scanCallback = new ScanCallback() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$scanCallback$1
        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            super.onScanResult(i, result);
            UnlimitedWaterHomeFragment unlimitedWaterHomeFragment = UnlimitedWaterHomeFragment.this;
            BluetoothDevice device = result.getDevice();
            Intrinsics.checkNotNullExpressionValue(device, "result.device");
            unlimitedWaterHomeFragment.addBluetoothDevice(device);
        }
    };
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$mGattCallback$1
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
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding;
            UnlimitedWaterHomeModel unlimitedWaterHomeModel;
            String[] strArr;
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding2;
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding3 = null;
            if (i2 == 0) {
                z = UnlimitedWaterHomeFragment.this.isDisconnected;
                if (!z) {
                    UnlimitedWaterHomeFragment.this.connectWithBle();
                }
                UnlimitedWaterHomeFragment.this.mBleConnected = false;
                fragmentUnlimitedWaterHomeBinding = UnlimitedWaterHomeFragment.this.dataBinding;
                if (fragmentUnlimitedWaterHomeBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                } else {
                    fragmentUnlimitedWaterHomeBinding3 = fragmentUnlimitedWaterHomeBinding;
                }
                TextView textView = fragmentUnlimitedWaterHomeBinding3.lastSynchronized;
                StringBuilder sb = new StringBuilder();
                sb.append(UnlimitedWaterHomeFragment.this.requireActivity().getString(R.string.last_synchronized_on));
                sb.append(SafeJsonPrimitive.NULL_CHAR);
                unlimitedWaterHomeModel = UnlimitedWaterHomeFragment.this.getUnlimitedWaterHomeModel();
                sb.append(unlimitedWaterHomeModel.getLastSynchronizedOn());
                textView.setText(sb.toString());
            } else if (i2 != 2) {
            } else {
                if (ActivityCompat.checkSelfPermission(UnlimitedWaterHomeFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    gatt.requestMtu(500);
                } else if (Build.VERSION.SDK_INT >= 31) {
                    strArr = UnlimitedWaterHomeFragment.this.android12BlePermission;
                    ActivityCompat.requestPermissions(UnlimitedWaterHomeFragment.this.requireActivity(), strArr, 2);
                } else {
                    gatt.requestMtu(500);
                }
                UnlimitedWaterHomeFragment.this.isDisconnected = false;
                UnlimitedWaterHomeFragment.this.mBleConnected = true;
                fragmentUnlimitedWaterHomeBinding2 = UnlimitedWaterHomeFragment.this.dataBinding;
                if (fragmentUnlimitedWaterHomeBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                } else {
                    fragmentUnlimitedWaterHomeBinding3 = fragmentUnlimitedWaterHomeBinding2;
                }
                fragmentUnlimitedWaterHomeBinding3.lastSynchronized.setText(R.string.connection_established);
                if (LSApplication.Companion.isNetworkAvailable()) {
                    UnlimitedWaterHomeFragment.this.getCommandList();
                    UnlimitedWaterHomeFragment.this.initContextViews();
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            String[] strArr;
            if (i2 == 0) {
                if (ActivityCompat.checkSelfPermission(UnlimitedWaterHomeFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    Intrinsics.checkNotNull(bluetoothGatt);
                    bluetoothGatt.discoverServices();
                } else if (Build.VERSION.SDK_INT >= 31) {
                    strArr = UnlimitedWaterHomeFragment.this.android12BlePermission;
                    ActivityCompat.requestPermissions(UnlimitedWaterHomeFragment.this.requireActivity(), strArr, 2);
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
            if (ActivityCompat.checkSelfPermission(UnlimitedWaterHomeFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                if (i != 0) {
                    gatt.discoverServices();
                    return;
                }
                UnlimitedWaterHomeFragment unlimitedWaterHomeFragment = UnlimitedWaterHomeFragment.this;
                bluetoothGatt3 = unlimitedWaterHomeFragment.mBluetoothGatt;
                unlimitedWaterHomeFragment.initializeGattServices(bluetoothGatt3 != null ? bluetoothGatt3.getServices() : null);
                bluetoothGattCharacteristic3 = UnlimitedWaterHomeFragment.this.mReadCharacteristic;
                if (bluetoothGattCharacteristic3 != null) {
                    bluetoothGatt4 = UnlimitedWaterHomeFragment.this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt4);
                    bluetoothGattCharacteristic4 = UnlimitedWaterHomeFragment.this.mReadCharacteristic;
                    bluetoothGatt4.readCharacteristic(bluetoothGattCharacteristic4);
                }
            } else if (Build.VERSION.SDK_INT >= 31) {
                strArr = UnlimitedWaterHomeFragment.this.android12BlePermission;
                ActivityCompat.requestPermissions(UnlimitedWaterHomeFragment.this.requireActivity(), strArr, 2);
            } else if (i != 0) {
                gatt.discoverServices();
            } else {
                UnlimitedWaterHomeFragment unlimitedWaterHomeFragment2 = UnlimitedWaterHomeFragment.this;
                bluetoothGatt = unlimitedWaterHomeFragment2.mBluetoothGatt;
                unlimitedWaterHomeFragment2.initializeGattServices(bluetoothGatt != null ? bluetoothGatt.getServices() : null);
                bluetoothGattCharacteristic = UnlimitedWaterHomeFragment.this.mReadCharacteristic;
                if (bluetoothGattCharacteristic != null) {
                    bluetoothGatt2 = UnlimitedWaterHomeFragment.this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt2);
                    bluetoothGattCharacteristic2 = UnlimitedWaterHomeFragment.this.mReadCharacteristic;
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
                charData = UnlimitedWaterHomeFragment.this.setCharData(characteristic);
                BuildersKt__Builders_commonKt.launch$default(UnlimitedWaterHomeFragment.this, null, null, new UnlimitedWaterHomeFragment$mGattCallback$1$onCharacteristicRead$1(UnlimitedWaterHomeFragment.this, charData, null), 3, null);
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
        return R.layout.fragment_unlimited_water_home;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public UnlimitedWaterHomeFragment() {
        final UnlimitedWaterHomeFragment unlimitedWaterHomeFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(UnlimitedWaterHomeFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$special$$inlined$navArgs$1
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
    public final UnlimitedWaterHomeFragmentArgs getNavArgs() {
        return (UnlimitedWaterHomeFragmentArgs) this.navArgs$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UnlimitedWaterHomeModel getUnlimitedWaterHomeModel() {
        return (UnlimitedWaterHomeModel) this.unlimitedWaterHomeModel$delegate.getValue();
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
        setHasOptionsMenu(false);
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.job = Job$default;
        this.handler = new Handler();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.animProgressBar = new AnimProgressBar(requireContext());
        if (LSApplication.Companion.isNetworkAvailable()) {
            listeners();
            UnlimitedWaterHomeModel unlimitedWaterHomeModel = getUnlimitedWaterHomeModel();
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            unlimitedWaterHomeModel.getDashboardDetails(context);
            setupDashboard();
            synchronizeBLE();
            UnlimitedWaterHomeModel unlimitedWaterHomeModel2 = getUnlimitedWaterHomeModel();
            Context context2 = getContext();
            Intrinsics.checkNotNull(context2);
            unlimitedWaterHomeModel2.getAllEnvyBLEResponse(context2).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda20
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UnlimitedWaterHomeFragment.m947onViewCreated$lambda0(UnlimitedWaterHomeFragment.this, (List) obj);
                }
            });
        } else {
            UnlimitedWaterHomeModel unlimitedWaterHomeModel3 = getUnlimitedWaterHomeModel();
            Context context3 = getContext();
            Intrinsics.checkNotNull(context3);
            unlimitedWaterHomeModel3.getAllOflineDashboarData(context3).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda16
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UnlimitedWaterHomeFragment.m948onViewCreated$lambda2(UnlimitedWaterHomeFragment.this, (List) obj);
                }
            });
            UnlimitedWaterHomeModel unlimitedWaterHomeModel4 = getUnlimitedWaterHomeModel();
            Context context4 = getContext();
            Intrinsics.checkNotNull(context4);
            unlimitedWaterHomeModel4.getAllOflineBLECommands(context4).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda17
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UnlimitedWaterHomeFragment.m949onViewCreated$lambda3(UnlimitedWaterHomeFragment.this, (List) obj);
                }
            });
            UnlimitedWaterHomeModel unlimitedWaterHomeModel5 = getUnlimitedWaterHomeModel();
            Context context5 = getContext();
            Intrinsics.checkNotNull(context5);
            unlimitedWaterHomeModel5.getAllEnvyBLEResponse(context5).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda19
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UnlimitedWaterHomeFragment.m950onViewCreated$lambda4(UnlimitedWaterHomeFragment.this, (List) obj);
                }
            });
        }
        UnlimitedWaterHomeModel unlimitedWaterHomeModel6 = getUnlimitedWaterHomeModel();
        Context context6 = getContext();
        Intrinsics.checkNotNull(context6);
        unlimitedWaterHomeModel6.getAllEnvyBLEResponse(context6).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda18
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UnlimitedWaterHomeFragment.m951onViewCreated$lambda5(UnlimitedWaterHomeFragment.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m947onViewCreated$lambda0(UnlimitedWaterHomeFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list = it;
        if (list == null || list.isEmpty()) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!list.isEmpty()) {
            int i = 0;
            while (i < list.size()) {
                String serialNo = ((EnvyBLEResponse) it.get(i)).getSerialNo();
                Intrinsics.checkNotNull(serialNo);
                String response = ((EnvyBLEResponse) it.get(i)).getResponse();
                Intrinsics.checkNotNull(response);
                i++;
                if (i == list.size() - 1) {
                    UnlimitedWaterHomeModel unlimitedWaterHomeModel = this$0.getUnlimitedWaterHomeModel();
                    Context context = this$0.getContext();
                    Intrinsics.checkNotNull(context);
                    unlimitedWaterHomeModel.offlineBLEStatus(context, serialNo, response, true);
                } else {
                    UnlimitedWaterHomeModel unlimitedWaterHomeModel2 = this$0.getUnlimitedWaterHomeModel();
                    Context context2 = this$0.getContext();
                    Intrinsics.checkNotNull(context2);
                    unlimitedWaterHomeModel2.offlineBLEStatus(context2, serialNo, response, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m948onViewCreated$lambda2(UnlimitedWaterHomeFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        String str = this$0.requireActivity().getString(R.string.last_synchronized_on) + SafeJsonPrimitive.NULL_CHAR + ((EnvyDashbordOffline) list.get(0)).getLastSyncOn();
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding = this$0.dataBinding;
        if (fragmentUnlimitedWaterHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentUnlimitedWaterHomeBinding = null;
        }
        fragmentUnlimitedWaterHomeBinding.lastSynchronized.setText(str);
        UnlimitedWaterHomeModel unlimitedWaterHomeModel = this$0.getUnlimitedWaterHomeModel();
        String remaining = ((EnvyDashbordOffline) list.get(0)).getRemaining();
        Intrinsics.checkNotNull(remaining);
        this$0.updateWaterRemainingView(unlimitedWaterHomeModel.offlineWaterTank(remaining));
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding2 = this$0.dataBinding;
        if (fragmentUnlimitedWaterHomeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentUnlimitedWaterHomeBinding2 = null;
        }
        fragmentUnlimitedWaterHomeBinding2.planDetails.setText(((EnvyDashbordOffline) list.get(0)).getPlanDetails());
        String filterLife = ((EnvyDashbordOffline) list.get(0)).getFilterLife();
        Integer valueOf = filterLife != null ? Integer.valueOf(this$0.getUnlimitedWaterHomeModel().offlineFilterLife(filterLife)) : null;
        Intrinsics.checkNotNull(valueOf);
        this$0.updateFilterLifeImage(valueOf.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m949onViewCreated$lambda3(UnlimitedWaterHomeFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.bleCommandList.clear();
        List list = it;
        if (!(list == null || list.isEmpty())) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (true ^ list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    this$0.bleCommandList.add(((RechargeResponse) it.get(i)).getRechargeList());
                }
                this$0.setupDashboard();
            }
        }
        this$0.listeners();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m950onViewCreated$lambda4(UnlimitedWaterHomeFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list = it;
        if (list == null || list.isEmpty()) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!list.isEmpty()) {
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding = this$0.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding = null;
            }
            fragmentUnlimitedWaterHomeBinding.lastSynchronized.setText(R.string.please_connect_the_app_to_internet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-5  reason: not valid java name */
    public static final void m951onViewCreated$lambda5(UnlimitedWaterHomeFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list = it;
        if (list == null || list.isEmpty()) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!list.isEmpty()) {
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding = this$0.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding = null;
            }
            fragmentUnlimitedWaterHomeBinding.lastSynchronized.setText(R.string.recharge_is_available);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        inflater.inflate(R.menu.support_menu, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == R.id.menuSupportId) {
            if (!getUnlimitedWaterHomeModel().getAllowTopup()) {
                showDialog("Your plan’s validity has expired. Please recharge in order for your RO machine to start working again.");
            } else if (Double.valueOf(getUnlimitedWaterHomeModel().getRemainingLitres()).equals(0)) {
                showDialog("The allocated Litters as per your plan have expired. Please Top Up for your RO machine to start working again.");
            } else {
                NavController findNavController = FragmentKt.findNavController(this);
                HomeFragmentDirections.ActionHomeFragmentToContactUsFragment actionHomeFragmentToContactUsFragment = HomeFragmentDirections.actionHomeFragmentToContactUsFragment(getUnlimitedWaterHomeModel().getDeviceSerialNumber());
                Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToContactUsFragment, "actionHomeFragmentToCont…Model.deviceSerialNumber)");
                findNavController.navigate(actionHomeFragmentToContactUsFragment);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private final void showDialog(String str) {
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
        ((TextView) dialog.findViewById(R.id.header)).setText(getString(R.string.warning));
        ((TextView) dialog.findViewById(R.id.msg_txt)).setText(StringsKt.trimIndent(str));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private final void listeners() {
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding = null;
        if (LSApplication.Companion.isNetworkAvailable() || (!this.bleCommandList.isEmpty())) {
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding2 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding2 = null;
            }
            fragmentUnlimitedWaterHomeBinding2.swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda24
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    UnlimitedWaterHomeFragment.m946listeners$lambda9(UnlimitedWaterHomeFragment.this);
                }
            });
        } else {
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding3 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding3 = null;
            }
            fragmentUnlimitedWaterHomeBinding3.swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda25
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    UnlimitedWaterHomeFragment.m939listeners$lambda10(UnlimitedWaterHomeFragment.this);
                }
            });
        }
        if (LSApplication.Companion.isNetworkAvailable()) {
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding4 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding4 = null;
            }
            fragmentUnlimitedWaterHomeBinding4.renewPlan.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda31
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UnlimitedWaterHomeFragment.m940listeners$lambda11(UnlimitedWaterHomeFragment.this, view);
                }
            });
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding5 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding5 = null;
            }
            fragmentUnlimitedWaterHomeBinding5.knowMoreLL.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda32
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UnlimitedWaterHomeFragment.m941listeners$lambda12(UnlimitedWaterHomeFragment.this, view);
                }
            });
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding6 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding6 = null;
            }
            fragmentUnlimitedWaterHomeBinding6.inviteFriend.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda36
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UnlimitedWaterHomeFragment.m942listeners$lambda13(UnlimitedWaterHomeFragment.this, view);
                }
            });
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding7 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding7 = null;
            }
            fragmentUnlimitedWaterHomeBinding7.settingsIV.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda34
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UnlimitedWaterHomeFragment.m943listeners$lambda14(UnlimitedWaterHomeFragment.this, view);
                }
            });
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding8 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding8 = null;
            }
            fragmentUnlimitedWaterHomeBinding8.bleSyncIV.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda35
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UnlimitedWaterHomeFragment.m944listeners$lambda15(UnlimitedWaterHomeFragment.this, view);
                }
            });
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding9 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                fragmentUnlimitedWaterHomeBinding = fragmentUnlimitedWaterHomeBinding9;
            }
            fragmentUnlimitedWaterHomeBinding.llRaiseAserviceComplaint.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda33
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UnlimitedWaterHomeFragment.m945listeners$lambda16(UnlimitedWaterHomeFragment.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-9  reason: not valid java name */
    public static final void m946listeners$lambda9(UnlimitedWaterHomeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UnlimitedWaterHomeModel unlimitedWaterHomeModel = this$0.getUnlimitedWaterHomeModel();
        Context context = this$0.getContext();
        Intrinsics.checkNotNull(context);
        unlimitedWaterHomeModel.getDashboardDetails(context);
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding = null;
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
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UnlimitedWaterHomeFragment$listeners$1$1(this$0, null), 3, null);
        }
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding2 = this$0.dataBinding;
        if (fragmentUnlimitedWaterHomeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentUnlimitedWaterHomeBinding = fragmentUnlimitedWaterHomeBinding2;
        }
        fragmentUnlimitedWaterHomeBinding.swipeToRefresh.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-10  reason: not valid java name */
    public static final void m939listeners$lambda10(UnlimitedWaterHomeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding = this$0.dataBinding;
        if (fragmentUnlimitedWaterHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentUnlimitedWaterHomeBinding = null;
        }
        fragmentUnlimitedWaterHomeBinding.swipeToRefresh.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-11  reason: not valid java name */
    public static final void m940listeners$lambda11(UnlimitedWaterHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showPlanChangeAirScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-12  reason: not valid java name */
    public static final void m941listeners$lambda12(UnlimitedWaterHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showReferAndEarnScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-13  reason: not valid java name */
    public static final void m942listeners$lambda13(UnlimitedWaterHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (LSApplication.Companion.getReferralLink() == null || Intrinsics.areEqual(LSApplication.Companion.getReferralLink(), "")) {
            return;
        }
        String referralLink = LSApplication.Companion.getReferralLink();
        Intrinsics.checkNotNull(referralLink);
        this$0.showInviteFriend(referralLink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-14  reason: not valid java name */
    public static final void m943listeners$lambda14(UnlimitedWaterHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showBoltSettingsScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-15  reason: not valid java name */
    public static final void m944listeners$lambda15(UnlimitedWaterHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.synchronizeBLE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-16  reason: not valid java name */
    public static final void m945listeners$lambda16(UnlimitedWaterHomeFragment this$0, View view) {
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
        HomeFragmentDirections.ActionHomeFragmentToContactUsFragment actionHomeFragmentToContactUsFragment = HomeFragmentDirections.actionHomeFragmentToContactUsFragment(getUnlimitedWaterHomeModel().getDeviceSerialNumber());
        Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToContactUsFragment, "actionHomeFragmentToCont…Model.deviceSerialNumber)");
        findNavController.navigate(actionHomeFragmentToContactUsFragment);
    }

    private final void synchronizeBLE() {
        if (setBluetooth()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UnlimitedWaterHomeFragment$synchronizeBLE$1(this, null), 3, null);
        }
    }

    private final void showPlanChangeAirScreen() {
        disConnectBLE();
        DeviceList deviceList = getUnlimitedWaterHomeModel().get_device();
        HomeDispenserFragmentDirections.ActionDispenserFragmentToSelectPlanChargeFragment actionDispenserFragmentToSelectPlanChargeFragment = deviceList != null ? HomeDispenserFragmentDirections.actionDispenserFragmentToSelectPlanChargeFragment(deviceList) : null;
        if (actionDispenserFragmentToSelectPlanChargeFragment != null) {
            FragmentKt.findNavController(this).navigate(actionDispenserFragmentToSelectPlanChargeFragment);
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentUnlimitedWaterHomeBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.dataBinding = dataBinding;
        dataBinding.setViewModel(getUnlimitedWaterHomeModel());
    }

    private final void showBoltSettingsScreen() {
        disConnectBLE();
        DeviceList deviceList = getUnlimitedWaterHomeModel().get_device();
        HomeDispenserFragmentDirections.ActionHomeDispenserFragmentBoltSettingsFragment actionHomeDispenserFragmentBoltSettingsFragment = deviceList != null ? HomeDispenserFragmentDirections.actionHomeDispenserFragmentBoltSettingsFragment(deviceList) : null;
        if (actionHomeDispenserFragmentBoltSettingsFragment != null) {
            FragmentKt.findNavController(this).navigate(actionHomeDispenserFragmentBoltSettingsFragment);
        }
    }

    private final void showReferAndEarnScreen() {
        disConnectBLE();
        NavDirections actionHomeFragmentToReferAndEarnFragment = HomeFragmentDirections.actionHomeFragmentToReferAndEarnFragment();
        Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToReferAndEarnFragment, "actionHomeFragmentToReferAndEarnFragment()");
        FragmentKt.findNavController(this).navigate(actionHomeFragmentToReferAndEarnFragment);
    }

    private final void showInviteFriend(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", "Refer & Earn\nGet instant ₹100 discount. Subscribe to Livpure Smart RO today.\nApply my code " + this._referralCode + " now and subscribe to pure drinking water at home.\nClick here to know more :- \n" + str);
        intent.setType(StringBody.CONTENT_TYPE);
        startActivity(Intent.createChooser(intent, null));
    }

    private final void setupDashboard() {
        if (getUnlimitedWaterHomeModel().getImeiNumber().length() == 12) {
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding = null;
            }
            fragmentUnlimitedWaterHomeBinding.wifiInfoIV.setVisibility(0);
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding2 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding2 = null;
            }
            fragmentUnlimitedWaterHomeBinding2.settingsIV.setVisibility(0);
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding3 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding3 = null;
            }
            fragmentUnlimitedWaterHomeBinding3.bleInfoIV.setVisibility(0);
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding4 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding4 = null;
            }
            fragmentUnlimitedWaterHomeBinding4.bleSyncIV.setVisibility(0);
        } else {
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding5 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding5 = null;
            }
            fragmentUnlimitedWaterHomeBinding5.wifiInfoIV.setVisibility(8);
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding6 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding6 = null;
            }
            fragmentUnlimitedWaterHomeBinding6.settingsIV.setVisibility(8);
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding7 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding7 = null;
            }
            fragmentUnlimitedWaterHomeBinding7.bleInfoIV.setVisibility(8);
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding8 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding8 = null;
            }
            fragmentUnlimitedWaterHomeBinding8.bleSyncIV.setVisibility(8);
        }
        String str = getUnlimitedWaterHomeModel().get_productType();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, "zinger-copper-emi")) {
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding9 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding9 = null;
            }
            fragmentUnlimitedWaterHomeBinding9.renewPlan.setVisibility(8);
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding10 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding10 = null;
            }
            fragmentUnlimitedWaterHomeBinding10.makePayment.setVisibility(8);
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding11 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding11 = null;
            }
            fragmentUnlimitedWaterHomeBinding11.makePaymentDiabled.setVisibility(0);
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding12 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding12 = null;
            }
            fragmentUnlimitedWaterHomeBinding12.remainingWaterLabel.setText(R.string.label_water_consumed);
        } else {
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding13 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding13 = null;
            }
            fragmentUnlimitedWaterHomeBinding13.renewPlan.setVisibility(0);
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding14 = this.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentUnlimitedWaterHomeBinding14 = null;
            }
            fragmentUnlimitedWaterHomeBinding14.remainingWaterLabel.setText(R.string.label_water_remaining);
        }
        getUnlimitedWaterHomeModel().getWaterRemaining().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda21
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UnlimitedWaterHomeFragment.m952setupDashboard$lambda21(UnlimitedWaterHomeFragment.this, (Pair) obj);
            }
        });
        getUnlimitedWaterHomeModel().getHardwareUpdate().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UnlimitedWaterHomeFragment.m953setupDashboard$lambda22(UnlimitedWaterHomeFragment.this, (Boolean) obj);
            }
        });
        getUnlimitedWaterHomeModel().getSoftwareUpdate().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UnlimitedWaterHomeFragment.m954setupDashboard$lambda23(UnlimitedWaterHomeFragment.this, (Boolean) obj);
            }
        });
        getUnlimitedWaterHomeModel().getHardwareVersion().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UnlimitedWaterHomeFragment.m955setupDashboard$lambda24(UnlimitedWaterHomeFragment.this, (String) obj);
            }
        });
        getUnlimitedWaterHomeModel().getSoftwareVersion().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UnlimitedWaterHomeFragment.m956setupDashboard$lambda25(UnlimitedWaterHomeFragment.this, (String) obj);
            }
        });
        UnlimitedWaterHomeFragment unlimitedWaterHomeFragment = this;
        getUnlimitedWaterHomeModel().getReferralCode().observe(unlimitedWaterHomeFragment, new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UnlimitedWaterHomeFragment.m957setupDashboard$lambda26(UnlimitedWaterHomeFragment.this, (String) obj);
            }
        });
        getUnlimitedWaterHomeModel().getPlanDetails().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UnlimitedWaterHomeFragment.m958setupDashboard$lambda27(UnlimitedWaterHomeFragment.this, (String) obj);
            }
        });
        getUnlimitedWaterHomeModel().getFilterLifeImage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UnlimitedWaterHomeFragment.m959setupDashboard$lambda28(UnlimitedWaterHomeFragment.this, (Integer) obj);
            }
        });
        getUnlimitedWaterHomeModel().getProductType().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda13
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UnlimitedWaterHomeFragment.m960setupDashboard$lambda29(UnlimitedWaterHomeFragment.this, (String) obj);
            }
        });
        getUnlimitedWaterHomeModel().getUsageStats().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda23
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UnlimitedWaterHomeFragment.m961setupDashboard$lambda30(UnlimitedWaterHomeFragment.this, (Triple) obj);
            }
        });
        getUnlimitedWaterHomeModel().getLastSynchronizedDate().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda15
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UnlimitedWaterHomeFragment.m962setupDashboard$lambda31(UnlimitedWaterHomeFragment.this, (String) obj);
            }
        });
        getUnlimitedWaterHomeModel().getPublishCommandStatus().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UnlimitedWaterHomeFragment.m963setupDashboard$lambda32(UnlimitedWaterHomeFragment.this, (String) obj);
            }
        });
        if (LSApplication.Companion.isNetworkAvailable()) {
            if (setBluetooth()) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UnlimitedWaterHomeFragment$setupDashboard$13(this, null), 3, null);
            }
            getCommandList();
            getUnlimitedWaterHomeModel().getBoltCommandsResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UnlimitedWaterHomeFragment.m964setupDashboard$lambda33(UnlimitedWaterHomeFragment.this, (BoltCommandsResponse) obj);
                }
            });
            getUnlimitedWaterHomeModel().getScanSerialNo().observe(unlimitedWaterHomeFragment, new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UnlimitedWaterHomeFragment.m965setupDashboard$lambda34(UnlimitedWaterHomeFragment.this, (Boolean) obj);
                }
            });
        } else if (setBluetooth()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UnlimitedWaterHomeFragment$setupDashboard$16(this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-21  reason: not valid java name */
    public static final void m952setupDashboard$lambda21(UnlimitedWaterHomeFragment this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (((String) pair.getFirst()).length() != 5 || pair.getSecond() == null) {
            return;
        }
        Object second = pair.getSecond();
        Intrinsics.checkNotNull(second);
        this$0.updateWaterRemainingView(((Number) second).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-22  reason: not valid java name */
    public static final void m953setupDashboard$lambda22(UnlimitedWaterHomeFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boolean booleanValue = it.booleanValue();
        this$0._isHardwareUpdate = booleanValue;
        if (booleanValue) {
            this$0._isFirmwareUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-23  reason: not valid java name */
    public static final void m954setupDashboard$lambda23(UnlimitedWaterHomeFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boolean booleanValue = it.booleanValue();
        this$0._isSoftwareUpdate = booleanValue;
        if (booleanValue) {
            this$0._isFirmwareUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-24  reason: not valid java name */
    public static final void m955setupDashboard$lambda24(UnlimitedWaterHomeFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._hardwareVersion = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-25  reason: not valid java name */
    public static final void m956setupDashboard$lambda25(UnlimitedWaterHomeFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._softwareVersion = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-26  reason: not valid java name */
    public static final void m957setupDashboard$lambda26(UnlimitedWaterHomeFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._referralCode = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-27  reason: not valid java name */
    public static final void m958setupDashboard$lambda27(UnlimitedWaterHomeFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return;
        }
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding = this$0.dataBinding;
        if (fragmentUnlimitedWaterHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentUnlimitedWaterHomeBinding = null;
        }
        fragmentUnlimitedWaterHomeBinding.planDetails.setText(str2);
        if (this$0.isAdded()) {
            UserRepository.Companion companion = UserRepository.Companion;
            FragmentActivity requireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            companion.getInstance(requireActivity).setUser(LSApplication.Companion.getUser());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-28  reason: not valid java name */
    public static final void m959setupDashboard$lambda28(UnlimitedWaterHomeFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null && it.intValue() == -1) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateFilterLifeImage(it.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-29  reason: not valid java name */
    public static final void m960setupDashboard$lambda29(UnlimitedWaterHomeFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding = this$0.dataBinding;
        if (fragmentUnlimitedWaterHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentUnlimitedWaterHomeBinding = null;
        }
        fragmentUnlimitedWaterHomeBinding.remainingWaterLabel.setText(R.string.label_water_remaining);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-30  reason: not valid java name */
    public static final void m961setupDashboard$lambda30(UnlimitedWaterHomeFragment this$0, Triple triple) {
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
    /* renamed from: setupDashboard$lambda-31  reason: not valid java name */
    public static final void m962setupDashboard$lambda31(UnlimitedWaterHomeFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = this$0.requireActivity().getString(R.string.last_synchronized_on) + SafeJsonPrimitive.NULL_CHAR + str;
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding = this$0.dataBinding;
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding2 = null;
        if (fragmentUnlimitedWaterHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentUnlimitedWaterHomeBinding = null;
        }
        CharSequence text = fragmentUnlimitedWaterHomeBinding.lastSynchronized.getText();
        Intrinsics.checkNotNull(text);
        if (StringsKt.contains((CharSequence) text.toString(), (CharSequence) "Last sync on", true)) {
            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding3 = this$0.dataBinding;
            if (fragmentUnlimitedWaterHomeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                fragmentUnlimitedWaterHomeBinding2 = fragmentUnlimitedWaterHomeBinding3;
            }
            fragmentUnlimitedWaterHomeBinding2.lastSynchronized.setText(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-32  reason: not valid java name */
    public static final void m963setupDashboard$lambda32(UnlimitedWaterHomeFragment this$0, String str) {
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
        BuildersKt__Builders_commonKt.launch$default(this$0, null, null, new UnlimitedWaterHomeFragment$setupDashboard$12$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-33  reason: not valid java name */
    public static final void m964setupDashboard$lambda33(UnlimitedWaterHomeFragment this$0, BoltCommandsResponse boltCommandsResponse) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-34  reason: not valid java name */
    public static final void m965setupDashboard$lambda34(UnlimitedWaterHomeFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bool.booleanValue() || this$0.firstLoad) {
            return;
        }
        this$0.firstLoad = true;
        Context context = this$0.getContext();
        SharedPreferences sharedPreferences = context != null ? context.getSharedPreferences("PREFERENCES", 0) : null;
        Objects.requireNonNull(sharedPreferences, "null cannot be cast to non-null type android.content.SharedPreferences");
        String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String string = sharedPreferences.getString("LAST_LAUNCH_DATE", "nodate");
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(currentDate, "currentDate");
        if (StringsKt.contains$default((CharSequence) string, (CharSequence) currentDate, false, 2, (Object) null)) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("LAST_LAUNCH_DATE", currentDate);
        edit.apply();
        String str = this$0.getUnlimitedWaterHomeModel().get_productType();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, "bolt-waas-wifi-ble")) {
            return;
        }
        this$0.showSerialNumberDialog();
    }

    private final void showSerialNumberDialog() {
        Context context = getContext();
        final Dialog dialog = context != null ? new Dialog(context) : null;
        if (dialog != null) {
            dialog.requestWindowFeature(1);
        }
        if (dialog != null) {
            dialog.setContentView(R.layout.dialog_read_serial_number);
        }
        Window window = dialog != null ? dialog.getWindow() : null;
        Intrinsics.checkNotNull(window);
        window.setLayout(-1, -2);
        Window window2 = dialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setBackgroundDrawable(new ColorDrawable(0));
        ((Button) dialog.findViewById(R.id.submitButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UnlimitedWaterHomeFragment.m972showSerialNumberDialog$lambda38(UnlimitedWaterHomeFragment.this, dialog, view);
            }
        });
        ((TextView) dialog.findViewById(R.id.noThanksButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showSerialNumberDialog$lambda-38  reason: not valid java name */
    public static final void m972showSerialNumberDialog$lambda38(UnlimitedWaterHomeFragment this$0, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        boolean z = false;
        if (context != null && ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") == 0) {
            z = true;
        }
        if (!z) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                ActivityCompat.requestPermissions(activity, new String[]{"android.permission.CAMERA"}, this$0.CAMERA_PERMISSION_CODE);
                return;
            }
            return;
        }
        dialog.dismiss();
        this$0.showCameraDialog();
    }

    private final void showCameraDialog() {
        Context context = getContext();
        CodeScanner codeScanner = null;
        final Dialog dialog = context != null ? new Dialog(context) : null;
        if (dialog != null) {
            dialog.requestWindowFeature(1);
        }
        if (dialog != null) {
            dialog.setContentView(R.layout.dialog_camera_scanner);
        }
        Window window = dialog != null ? dialog.getWindow() : null;
        Intrinsics.checkNotNull(window);
        window.setLayout(-1, -2);
        Window window2 = dialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setBackgroundDrawable(new ColorDrawable(0));
        CodeScannerView codeScannerView = (CodeScannerView) dialog.findViewById(R.id.scanner_view);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.closeIV);
        Context context2 = getContext();
        CodeScanner codeScanner2 = context2 != null ? new CodeScanner(context2, codeScannerView) : null;
        Intrinsics.checkNotNull(codeScanner2);
        this.codeScanner = codeScanner2;
        if (codeScanner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeScanner");
        } else {
            codeScanner = codeScanner2;
        }
        codeScanner.setDecodeCallback(new DecodeCallback() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda26
            @Override // com.budiyev.android.codescanner.DecodeCallback
            public final void onDecoded(Result result) {
                UnlimitedWaterHomeFragment.m966showCameraDialog$lambda43(UnlimitedWaterHomeFragment.this, dialog, result);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.setCancelable(false);
        Handler handler = this.handler;
        Intrinsics.checkNotNull(handler);
        handler.postDelayed(new Runnable() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                UnlimitedWaterHomeFragment.m969showCameraDialog$lambda45(UnlimitedWaterHomeFragment.this);
            }
        }, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showCameraDialog$lambda-43  reason: not valid java name */
    public static final void m966showCameraDialog$lambda43(final UnlimitedWaterHomeFragment this$0, final Dialog dialog, final Result it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    UnlimitedWaterHomeFragment.m967showCameraDialog$lambda43$lambda42(dialog, this$0, it);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showCameraDialog$lambda-43$lambda-42  reason: not valid java name */
    public static final void m967showCameraDialog$lambda43$lambda42(Dialog dialog, UnlimitedWaterHomeFragment this$0, Result it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        dialog.dismiss();
        String text = it.getText();
        Intrinsics.checkNotNullExpressionValue(text, "it.text");
        String matchDetails$default = matchDetails$default(this$0, text, "=", 0, 4, null);
        if (matchDetails$default.length() == 14) {
            this$0.getUnlimitedWaterHomeModel().getSerialNumberStatus(matchDetails$default);
            dialog.dismiss();
            return;
        }
        CodeScanner codeScanner = this$0.codeScanner;
        if (codeScanner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeScanner");
            codeScanner = null;
        }
        codeScanner.startPreview();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showCameraDialog$lambda-45  reason: not valid java name */
    public static final void m969showCameraDialog$lambda45(UnlimitedWaterHomeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            CodeScanner codeScanner = this$0.codeScanner;
            if (codeScanner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("codeScanner");
                codeScanner = null;
            }
            codeScanner.startPreview();
        } catch (Exception e) {
            Log.e(AgentHealth.DEFAULT_KEY, e.toString());
        }
    }

    static /* synthetic */ String matchDetails$default(UnlimitedWaterHomeFragment unlimitedWaterHomeFragment, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return unlimitedWaterHomeFragment.matchDetails(str, str2, i);
    }

    private final String matchDetails(String str, String str2, int i) {
        String str3 = str;
        return StringsKt.indexOf$default((CharSequence) str3, str2, i, false, 4, (Object) null) >= 0 ? (String) StringsKt.split$default((CharSequence) str3, new String[]{str2}, false, 0, 6, (Object) null).get(1) : str;
    }

    private final void updateWaterRemainingView(int i) {
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding = this.dataBinding;
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding2 = null;
        if (fragmentUnlimitedWaterHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentUnlimitedWaterHomeBinding = null;
        }
        fragmentUnlimitedWaterHomeBinding.waterRemainingTenThousand.setText("U");
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding3 = this.dataBinding;
        if (fragmentUnlimitedWaterHomeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentUnlimitedWaterHomeBinding3 = null;
        }
        fragmentUnlimitedWaterHomeBinding3.waterRemainingThousands.setText("N");
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding4 = this.dataBinding;
        if (fragmentUnlimitedWaterHomeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentUnlimitedWaterHomeBinding4 = null;
        }
        fragmentUnlimitedWaterHomeBinding4.waterRemainingHundreds.setText("L");
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding5 = this.dataBinding;
        if (fragmentUnlimitedWaterHomeBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentUnlimitedWaterHomeBinding5 = null;
        }
        fragmentUnlimitedWaterHomeBinding5.waterRemainingTens.setText(ExifInterface.GPS_DIRECTION_TRUE);
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding6 = this.dataBinding;
        if (fragmentUnlimitedWaterHomeBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentUnlimitedWaterHomeBinding6 = null;
        }
        fragmentUnlimitedWaterHomeBinding6.waterRemainingOnes.setText("D");
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding7 = this.dataBinding;
        if (fragmentUnlimitedWaterHomeBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentUnlimitedWaterHomeBinding2 = fragmentUnlimitedWaterHomeBinding7;
        }
        fragmentUnlimitedWaterHomeBinding2.waterUsageImage.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
    }

    private final void updateFilterLifeImage(int i) {
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding = this.dataBinding;
        if (fragmentUnlimitedWaterHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentUnlimitedWaterHomeBinding = null;
        }
        fragmentUnlimitedWaterHomeBinding.filterLifeImage.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
    }

    private final void setupUsageStats(List<String> list, List<? extends IBarDataSet> list2, String str) {
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding = this.dataBinding;
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding2 = null;
        if (fragmentUnlimitedWaterHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentUnlimitedWaterHomeBinding = null;
        }
        Context context = fragmentUnlimitedWaterHomeBinding.barChart.getContext();
        Integer valueOf = context != null ? Integer.valueOf(UiUtilKt.getColorFromAttr$default(context, R.attr.colorOnSurface, null, false, 6, null)) : null;
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding3 = this.dataBinding;
        if (fragmentUnlimitedWaterHomeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentUnlimitedWaterHomeBinding3 = null;
        }
        BarChart barChart = fragmentUnlimitedWaterHomeBinding3.barChart;
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
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding4 = this.dataBinding;
        if (fragmentUnlimitedWaterHomeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentUnlimitedWaterHomeBinding2 = fragmentUnlimitedWaterHomeBinding4;
        }
        fragmentUnlimitedWaterHomeBinding2.averageWaterConsumption.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupBluetooth() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s-%s", Arrays.copyOf(new Object[]{"LIVSMT-RO", StringsKt.takeLast(getUnlimitedWaterHomeModel().getImeiNumber(), 4)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        this.macIdAdd = format;
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%s-%s", Arrays.copyOf(new Object[]{"LIVSMT-RO", "DF58"}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        this.macIdAdd = format2;
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
        if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_SCAN") == 0) {
            ArrayList<String> arrayList = this.listBluetoothDevice;
            Intrinsics.checkNotNull(arrayList);
            arrayList.clear();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UnlimitedWaterHomeFragment$scanLeDevice$1(this, null), 3, null);
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
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UnlimitedWaterHomeFragment$scanLeDevice$2(this, null), 3, null);
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
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new UnlimitedWaterHomeFragment$connectWithBle$1(this, null), 3, null);
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
        if (LSApplication.Companion.isNetworkAvailable()) {
            UnlimitedWaterHomeModel unlimitedWaterHomeModel = getUnlimitedWaterHomeModel();
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            unlimitedWaterHomeModel.getPendingBleCommand(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayData(String str) {
        List<String> lines;
        String decrypt;
        List<String> lines2;
        String decrypt2;
        getUnlimitedWaterHomeModel().getBleImage().observe(this, new Observer() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UnlimitedWaterHomeFragment.m938displayData$lambda48(UnlimitedWaterHomeFragment.this, (Integer) obj);
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
                        UnlimitedWaterHomeModel unlimitedWaterHomeModel = getUnlimitedWaterHomeModel();
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonData.toString()");
                        Context context = getContext();
                        Intrinsics.checkNotNull(context);
                        unlimitedWaterHomeModel.bleStatus(jSONObject2, context);
                        if (!LSApplication.Companion.isNetworkAvailable()) {
                            BoldBleData boldBleData = (BoldBleData) new Gson().fromJson(jSONObject.toString(), (Class<Object>) BoldBleData.class);
                            if (boldBleData.getRemainingLitre() != null) {
                                String padStart = StringsKt.padStart(boldBleData.getRemainingLitre(), 5, '0');
                                updateWaterRemainingView(getUnlimitedWaterHomeModel().offlineWaterTank(padStart));
                                showToastMessage("Remaining Litres : " + padStart);
                            }
                        }
                        String jSONObject3 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonData.toString()");
                        if (StringsKt.contains$default((CharSequence) jSONObject3, (CharSequence) "\"RSA\":\"1", false, 2, (Object) null)) {
                            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding = this.dataBinding;
                            if (fragmentUnlimitedWaterHomeBinding == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                fragmentUnlimitedWaterHomeBinding = null;
                            }
                            fragmentUnlimitedWaterHomeBinding.lastSynchronized.setText(R.string.recharge_successful);
                        }
                        if (this.bleCommandList.size() > 0) {
                            String str3 = this.bleCommandList.get(0);
                            Intrinsics.checkNotNullExpressionValue(str3, "bleCommandList[0]");
                            if (StringsKt.contains$default((CharSequence) str3, (CharSequence) "\"RS\":\"", false, 2, (Object) null)) {
                                FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding2 = this.dataBinding;
                                if (fragmentUnlimitedWaterHomeBinding2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                    fragmentUnlimitedWaterHomeBinding2 = null;
                                }
                                fragmentUnlimitedWaterHomeBinding2.lastSynchronized.setText(R.string.recharging_in_progress);
                            }
                            String str4 = this.bleCommandList.get(0);
                            Intrinsics.checkNotNullExpressionValue(str4, "bleCommandList[0]");
                            sendToBLEJsonData(str4);
                            this.bleCommandList.remove(0);
                            return;
                        }
                        String jSONObject4 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject4, "jsonData.toString()");
                        if (StringsKt.contains$default((CharSequence) jSONObject4, (CharSequence) "\"LC\"", false, 2, (Object) null)) {
                            BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
                            Intrinsics.checkNotNull(bluetoothGatt);
                            bluetoothGatt.readCharacteristic(this.mReadCharacteristic);
                            return;
                        }
                        String jSONObject5 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject5, "jsonData.toString()");
                        if (StringsKt.contains$default((CharSequence) jSONObject5, (CharSequence) "GRTC", false, 2, (Object) null)) {
                            BuildersKt__Builders_commonKt.launch$default(this, null, null, new UnlimitedWaterHomeFragment$displayData$3(this, null), 3, null);
                            return;
                        }
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new UnlimitedWaterHomeFragment$displayData$2(this, null), 3, null);
                    showToastMessage("Long Data : ");
                } catch (Exception unused) {
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new UnlimitedWaterHomeFragment$displayData$4(this, null), 3, null);
                }
            }
        } else if (Build.VERSION.SDK_INT >= 31) {
            ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
        } else if (str != null) {
            try {
                if (StringsKt.startsWith$default(str, "{", false, 2, (Object) null)) {
                    return;
                }
                String str5 = StringsKt.lines(str).get(lines.size() - 1);
                if (StringsKt.lines(str).size() != 30 && str5.length() <= 1199.0f) {
                    if (str5.length() == 40) {
                        String decrypt4 = Base64Hex.decrypt(StringsKt.take(str5, 32), AppConstants.BEL_ENC_KEY);
                        Intrinsics.checkNotNullExpressionValue(decrypt4, "decrypt(hexDataReceived.…AppConstants.BEL_ENC_KEY)");
                        decrypt = decrypt4 + "0\"}";
                    } else {
                        decrypt = Base64Hex.decrypt(str5, AppConstants.BEL_ENC_KEY);
                        Intrinsics.checkNotNullExpressionValue(decrypt, "decrypt(hexDataReceived, AppConstants.BEL_ENC_KEY)");
                    }
                    JSONObject jSONObject6 = new JSONObject(decrypt);
                    UnlimitedWaterHomeModel unlimitedWaterHomeModel2 = getUnlimitedWaterHomeModel();
                    String jSONObject7 = jSONObject6.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject7, "jsonData.toString()");
                    Context context2 = getContext();
                    Intrinsics.checkNotNull(context2);
                    unlimitedWaterHomeModel2.bleStatus(jSONObject7, context2);
                    if (!LSApplication.Companion.isNetworkAvailable()) {
                        BoldBleData boldBleData2 = (BoldBleData) new Gson().fromJson(jSONObject6.toString(), (Class<Object>) BoldBleData.class);
                        if (boldBleData2.getRemainingLitre() != null) {
                            String padStart2 = StringsKt.padStart(boldBleData2.getRemainingLitre(), 5, '0');
                            updateWaterRemainingView(getUnlimitedWaterHomeModel().offlineWaterTank(padStart2));
                            showToastMessage("Remaining Litres : " + padStart2);
                        }
                    }
                    String jSONObject8 = jSONObject6.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject8, "jsonData.toString()");
                    if (StringsKt.contains$default((CharSequence) jSONObject8, (CharSequence) "\"RSA\":\"1", false, 2, (Object) null)) {
                        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding3 = this.dataBinding;
                        if (fragmentUnlimitedWaterHomeBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                            fragmentUnlimitedWaterHomeBinding3 = null;
                        }
                        fragmentUnlimitedWaterHomeBinding3.lastSynchronized.setText(R.string.recharge_successful);
                    }
                    if (this.bleCommandList.size() > 0) {
                        String str6 = this.bleCommandList.get(0);
                        Intrinsics.checkNotNullExpressionValue(str6, "bleCommandList[0]");
                        if (StringsKt.contains$default((CharSequence) str6, (CharSequence) "\"RS\":\"", false, 2, (Object) null)) {
                            FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding4 = this.dataBinding;
                            if (fragmentUnlimitedWaterHomeBinding4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                fragmentUnlimitedWaterHomeBinding4 = null;
                            }
                            fragmentUnlimitedWaterHomeBinding4.lastSynchronized.setText(R.string.recharging_in_progress);
                        }
                        String str7 = this.bleCommandList.get(0);
                        Intrinsics.checkNotNullExpressionValue(str7, "bleCommandList[0]");
                        sendToBLEJsonData(str7);
                        this.bleCommandList.remove(0);
                        return;
                    }
                    String jSONObject9 = jSONObject6.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject9, "jsonData.toString()");
                    if (StringsKt.contains$default((CharSequence) jSONObject9, (CharSequence) "\"LC\"", false, 2, (Object) null)) {
                        BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
                        Intrinsics.checkNotNull(bluetoothGatt2);
                        bluetoothGatt2.readCharacteristic(this.mReadCharacteristic);
                        return;
                    }
                    String jSONObject10 = jSONObject6.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject10, "jsonData.toString()");
                    if (StringsKt.contains$default((CharSequence) jSONObject10, (CharSequence) "GRTC", false, 2, (Object) null)) {
                        BuildersKt__Builders_commonKt.launch$default(this, null, null, new UnlimitedWaterHomeFragment$displayData$6(this, null), 3, null);
                        return;
                    }
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new UnlimitedWaterHomeFragment$displayData$5(this, null), 3, null);
                showToastMessage("Long Data : ");
            } catch (Exception unused2) {
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new UnlimitedWaterHomeFragment$displayData$7(this, null), 3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: displayData$lambda-48  reason: not valid java name */
    public static final void m938displayData$lambda48(UnlimitedWaterHomeFragment this$0, Integer it) {
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
        try {
            return ContextCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    private final void onRequestPermissionsResult() {
        ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this.LOCATION_PERMISSION_CODE);
    }

    private final void sendToBLEJsonData(String str) {
        try {
            byte[] hexStringToByteArray = Encrypt.hexStringToByteArray(Encrypt.encrypt(str, AppConstants.BEL_ENC_KEY));
            Intrinsics.checkNotNullExpressionValue(hexStringToByteArray, "hexStringToByteArray(encriptedData)");
            if (Intrinsics.areEqual(publishToDevice(hexStringToByteArray), "succes")) {
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new UnlimitedWaterHomeFragment$sendToBLEJsonData$1(this, null), 3, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void updateBleWiFiImage(int i) {
        FragmentUnlimitedWaterHomeBinding fragmentUnlimitedWaterHomeBinding = this.dataBinding;
        if (fragmentUnlimitedWaterHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentUnlimitedWaterHomeBinding = null;
        }
        fragmentUnlimitedWaterHomeBinding.bleInfoIV.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
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
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new UnlimitedWaterHomeFragment$showToastMessage$1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initContextViews() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.gpsTracker = new GPSTracker(requireActivity);
        getCurrentLocation();
    }

    private final Unit getCurrentLocation() {
        Object systemService = requireContext().getSystemService("location");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        this.mLocationManager = locationManager;
        if (locationManager != null) {
            Intrinsics.checkNotNull(locationManager);
            if (locationManager.isProviderEnabled("gps")) {
                getLocationAccessPermission();
                return Unit.INSTANCE;
            }
        }
        gpsEnablePermission();
        return Unit.INSTANCE;
    }

    private final Unit getLocationAccessPermission() {
        if (checkLocationAccessPermission()) {
            GPSTracker gPSTracker = this.gpsTracker;
            Intrinsics.checkNotNull(gPSTracker);
            if (gPSTracker.canGetLocation()) {
                GPSTracker gPSTracker2 = this.gpsTracker;
                Intrinsics.checkNotNull(gPSTracker2);
                this.latitude = gPSTracker2.getLatitude();
                GPSTracker gPSTracker3 = this.gpsTracker;
                Intrinsics.checkNotNull(gPSTracker3);
                this.longitude = gPSTracker3.getLongitude();
                getUnlimitedWaterHomeModel().updateLocationDetails(String.valueOf(this.latitude), String.valueOf(this.longitude));
            }
        } else {
            requestPermission();
        }
        return Unit.INSTANCE;
    }

    private final void requestPermission() {
        ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 102);
    }

    private final boolean checkLocationAccessPermission() {
        return ContextCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private final void gpsEnablePermission() {
        createLocationRequest();
        buildLocationSettingRequest();
        checkGpsEnablePermission();
    }

    private final void createLocationRequest() {
        LocationRequest create = LocationRequest.create();
        this.mLocationRequest = create;
        if (create != null) {
            create.setPriority(100);
        }
        LocationRequest locationRequest = this.mLocationRequest;
        if (locationRequest != null) {
            locationRequest.setInterval(10000L);
        }
        LocationRequest locationRequest2 = this.mLocationRequest;
        if (locationRequest2 != null) {
            locationRequest2.setFastestInterval(PayloadController.PAYLOAD_COLLECTOR_TIMEOUT);
        }
        LocationRequest create2 = LocationRequest.create();
        this.mLocationPowerBalanceRequest = create2;
        if (create2 == null) {
            return;
        }
        create2.setPriority(102);
    }

    private final void buildLocationSettingRequest() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        LocationRequest locationRequest = this.mLocationRequest;
        Intrinsics.checkNotNull(locationRequest);
        LocationSettingsRequest.Builder addLocationRequest = builder.addLocationRequest(locationRequest);
        LocationRequest locationRequest2 = this.mLocationPowerBalanceRequest;
        Intrinsics.checkNotNull(locationRequest2);
        this.mLocationSettingRequestBuilder = addLocationRequest.addLocationRequest(locationRequest2).setNeedBle(true);
    }

    private final void checkGpsEnablePermission() {
        Task<LocationSettingsResponse> task;
        SettingsClient settingsClient = LocationServices.getSettingsClient((Activity) requireActivity());
        this.settingsClient = settingsClient;
        if (settingsClient != null) {
            LocationSettingsRequest.Builder builder = this.mLocationSettingRequestBuilder;
            Intrinsics.checkNotNull(builder);
            task = settingsClient.checkLocationSettings(builder.build());
        } else {
            task = null;
        }
        if (task != null) {
            task.addOnCompleteListener(requireActivity(), new OnCompleteListener() { // from class: com.livpure.safedrink.dispenser.view.UnlimitedWaterHomeFragment$$ExternalSyntheticLambda27
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    UnlimitedWaterHomeFragment.m937checkGpsEnablePermission$lambda53(UnlimitedWaterHomeFragment.this, task2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkGpsEnablePermission$lambda-53  reason: not valid java name */
    public static final void m937checkGpsEnablePermission$lambda53(UnlimitedWaterHomeFragment this$0, Task task) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            task.getResult(ApiException.class);
        } catch (ApiException e) {
            if (e.getStatusCode() == 6) {
                try {
                    ((ResolvableApiException) e).startResolutionForResult(this$0.requireActivity(), 103);
                } catch (IntentSender.SendIntentException | ClassCastException unused) {
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 103 && i2 == -1) {
            createLocationRequest();
            buildLocationSettingRequest();
            getLocationAccessPermission();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            GPSTracker gPSTracker = new GPSTracker(requireActivity);
            this.gpsTracker = gPSTracker;
            Intrinsics.checkNotNull(gPSTracker);
            if (gPSTracker.canGetLocation()) {
                GPSTracker gPSTracker2 = this.gpsTracker;
                Intrinsics.checkNotNull(gPSTracker2);
                this.latitude = gPSTracker2.getLatitude();
                GPSTracker gPSTracker3 = this.gpsTracker;
                Intrinsics.checkNotNull(gPSTracker3);
                this.longitude = gPSTracker3.getLongitude();
                getUnlimitedWaterHomeModel().updateLocationDetails(String.valueOf(this.latitude), String.valueOf(this.longitude));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(i, permissions, grantResults);
        if (i == 102 && grantResults[0] == 0) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            GPSTracker gPSTracker = new GPSTracker(requireActivity);
            this.gpsTracker = gPSTracker;
            Intrinsics.checkNotNull(gPSTracker);
            if (gPSTracker.canGetLocation()) {
                GPSTracker gPSTracker2 = this.gpsTracker;
                Intrinsics.checkNotNull(gPSTracker2);
                this.latitude = gPSTracker2.getLatitude();
                GPSTracker gPSTracker3 = this.gpsTracker;
                Intrinsics.checkNotNull(gPSTracker3);
                this.longitude = gPSTracker3.getLongitude();
                getUnlimitedWaterHomeModel().updateLocationDetails(String.valueOf(this.latitude), String.valueOf(this.longitude));
            }
        }
    }

    /* compiled from: UnlimitedWaterHomeFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/livpure/safedrink/dispenser/view/UnlimitedWaterHomeFragment$Companion;", "", "()V", "LOCATION_INTERVAL", "", "LOCATION_PERMISSION", "", "LOCATION_SETTING_PERMISSION", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
