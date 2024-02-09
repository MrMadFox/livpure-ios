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
import com.livpure.safedrink.databinding.FragmentEnvyHomeBinding;
import com.livpure.safedrink.dispenser.data.models.EnvyBLEResponse;
import com.livpure.safedrink.dispenser.data.models.EnvyDashbordOffline;
import com.livpure.safedrink.dispenser.model.EnvyHomeViewModel;
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
/* compiled from: EnvyHomeFragment.kt */
@Metadata(d1 = {"\u0000¾\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 Ã\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002Ã\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010g\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010h\u001a\u00020*2\u0006\u0010-\u001a\u00020\u0002H\u0016J\b\u0010i\u001a\u00020*H\u0002J\b\u0010j\u001a\u00020*H\u0002J\b\u0010k\u001a\u00020\u0012H\u0002J\b\u0010l\u001a\u00020\u0012H\u0002J\b\u0010m\u001a\u00020*H\u0002J\b\u0010n\u001a\u00020*H\u0002J\b\u0010o\u001a\u00020*H\u0002J\u0012\u0010p\u001a\u00020*2\b\u0010q\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010r\u001a\u00020\u0012H\u0002J\b\u0010s\u001a\u00020*H\u0002J\b\u0010t\u001a\u00020*H\u0002J\b\u0010u\u001a\u00020*H\u0002J\b\u0010v\u001a\u00020\u0006H\u0014J\b\u0010w\u001a\u00020xH\u0014J\b\u0010y\u001a\u00020*H\u0002J\b\u0010z\u001a\u00020*H\u0002J\u0018\u0010{\u001a\u00020*2\u000e\u0010|\u001a\n\u0012\u0004\u0012\u00020~\u0018\u00010}H\u0002J\b\u0010\u007f\u001a\u00020*H\u0002J\u0012\u0010\u0080\u0001\u001a\u00020\u000b2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000bJ&\u0010\u0082\u0001\u001a\u00020\u000b2\u0007\u0010\u0083\u0001\u001a\u00020\u000b2\u0007\u0010\u0084\u0001\u001a\u00020\u000b2\t\b\u0002\u0010\u0085\u0001\u001a\u00020\u0006H\u0002J&\u0010\u0086\u0001\u001a\u00020*2\u0007\u0010\u0087\u0001\u001a\u00020\u00062\u0007\u0010\u0088\u0001\u001a\u00020\u00062\t\u0010q\u001a\u0005\u0018\u00010\u0089\u0001H\u0016J\u0015\u0010\u008a\u0001\u001a\u00020*2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0016J\u001d\u0010\u008d\u0001\u001a\u00020*2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0016J\t\u0010\u0092\u0001\u001a\u00020*H\u0016J\u0013\u0010\u0093\u0001\u001a\u00020\u00122\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0016J\t\u0010\u0096\u0001\u001a\u00020*H\u0002J1\u0010\u0096\u0001\u001a\u00020*2\u0007\u0010\u0087\u0001\u001a\u00020\u00062\r\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00182\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0016¢\u0006\u0003\u0010\u009a\u0001J\u001f\u0010\u009b\u0001\u001a\u00020*2\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0017J\t\u0010\u009e\u0001\u001a\u00020*H\u0002J\u0017\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u000b2\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0002J\t\u0010¢\u0001\u001a\u00020*H\u0002J\t\u0010£\u0001\u001a\u00020*H\u0002J\u0012\u0010¤\u0001\u001a\u00020*2\u0007\u0010¥\u0001\u001a\u00020\u000bH\u0002J\t\u0010¦\u0001\u001a\u00020\u0012H\u0002J\u0016\u0010§\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010¨\u0001\u001a\u0004\u0018\u00010WH\u0002J\t\u0010©\u0001\u001a\u00020*H\u0003J\t\u0010ª\u0001\u001a\u00020*H\u0002J1\u0010«\u0001\u001a\u00020*2\r\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0}2\u000e\u0010\u00ad\u0001\u001a\t\u0012\u0005\u0012\u00030®\u00010}2\u0007\u0010¯\u0001\u001a\u00020\u000bH\u0002J\t\u0010°\u0001\u001a\u00020*H\u0002J\t\u0010±\u0001\u001a\u00020*H\u0003J\t\u0010²\u0001\u001a\u00020*H\u0002J\t\u0010³\u0001\u001a\u00020*H\u0002J\u0012\u0010´\u0001\u001a\u00020*2\u0007\u0010µ\u0001\u001a\u00020\u000bH\u0002J\u0012\u0010¶\u0001\u001a\u00020*2\u0007\u0010·\u0001\u001a\u00020\u000bH\u0002J\t\u0010¸\u0001\u001a\u00020*H\u0002J\t\u0010¹\u0001\u001a\u00020*H\u0002J\t\u0010º\u0001\u001a\u00020*H\u0002J\u0012\u0010»\u0001\u001a\u00020*2\u0007\u0010 \u0001\u001a\u00020\u000bH\u0002J\t\u0010¼\u0001\u001a\u00020*H\u0002J\u0014\u0010½\u0001\u001a\u00020*2\t\b\u0001\u0010¾\u0001\u001a\u00020\u0006H\u0002J\u0014\u0010¿\u0001\u001a\u00020*2\t\b\u0001\u0010¾\u0001\u001a\u00020\u0006H\u0002J\u001d\u0010À\u0001\u001a\u00020*2\u0007\u0010Á\u0001\u001a\u00020\u000b2\t\b\u0001\u0010¾\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010Â\u0001\u001a\u00020*2\u0007\u0010¨\u0001\u001a\u00020WH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00188\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R2\u0010\u001c\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dj\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001e`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u000b0!j\b\u0012\u0004\u0012\u00020\u000b`\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103R\u000e\u00106\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010@\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010!j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u00020*8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010,R\u000e\u0010C\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010]\u001a\u00020^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\b_\u0010`R\u000e\u0010c\u001a\u00020dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ä\u0001"}, d2 = {"Lcom/livpure/safedrink/dispenser/view/EnvyHomeFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentEnvyHomeBinding;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "CAMERA_PERMISSION_CODE", "", "LOCATION_PERMISSION_CODE", "SCAN_PERIOD", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "_hardwareVersion", "_isFirmwareUpdate", "", "_isHardwareUpdate", "_isSoftwareUpdate", "_referralCode", "_softwareVersion", "android12BlePermission", "", "[Ljava/lang/String;", "animProgressBar", "Lcom/livpure/safedrink/utils/AnimProgressBar;", "attributes", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "bleCommandList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "codeScanner", "Lcom/budiyev/android/codescanner/CodeScanner;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "currentLocation", "", "getCurrentLocation", "()Lkotlin/Unit;", "dataBinding", AndroidContextPlugin.DEVICE_KEY, "Landroid/bluetooth/BluetoothDevice;", "envyHomeViewModel", "Lcom/livpure/safedrink/dispenser/model/EnvyHomeViewModel;", "getEnvyHomeViewModel", "()Lcom/livpure/safedrink/dispenser/model/EnvyHomeViewModel;", "envyHomeViewModel$delegate", "Lkotlin/Lazy;", "firstLoad", "gpsTracker", "Lcom/livpure/safedrink/utils/GPSTracker;", "handler", "Landroid/os/Handler;", "isDisconnected", "job", "Lkotlinx/coroutines/Job;", "latitude", "", "listBluetoothDevice", "locationAccessPermission", "getLocationAccessPermission", "longitude", "mBleConnected", "mBluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "mBluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "mBluetoothLeScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "mDeviceAddress", "mDeviceName", "mGattCallback", "Landroid/bluetooth/BluetoothGattCallback;", "mLocationManager", "Landroid/location/LocationManager;", "mLocationPowerBalanceRequest", "Lcom/google/android/gms/location/LocationRequest;", "mLocationRequest", "mLocationSettingRequestBuilder", "Lcom/google/android/gms/location/LocationSettingsRequest$Builder;", "mNotifyCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "mReadCharacteristic", "mReadCharacteristicTemp", "mScanning", "mWriteCharacteristic", "macIdAdd", "navArgs", "Lcom/livpure/safedrink/dispenser/view/EnvyHomeFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/dispenser/view/EnvyHomeFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "scanCallback", "Landroid/bluetooth/le/ScanCallback;", "settingsClient", "Lcom/google/android/gms/location/SettingsClient;", "addBluetoothDevice", "bindVariablesToView", "buildLocationSettingRequest", "checkGpsEnablePermission", "checkIfLocationPermissionGranted", "checkLocationAccessPermission", "connectWithBle", "createLocationRequest", "disConnectBLE", "displayData", "data", "getBluetooth", "getBluetoothAdapter", "getBluetoothLeScanner", "getCommandList", "getLayoutId", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "gpsEnablePermission", "initContextViews", "initializeGattServices", "gattServices", "", "Landroid/bluetooth/BluetoothGattService;", "listeners", "lookup", AnalyticsAttribute.UUID_ATTRIBUTE, "matchDetails", "inputString", "whatToFind", "startIndex", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "openServiceComplaint", "publishToDevice", "message", "", "requestPermission", "scanLeDevice", "sendToBLEJsonData", "value", "setBluetooth", "setCharData", "characteristic", "setupBluetooth", "setupDashboard", "setupUsageStats", "dates", "consumptionDataSetList", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "averageConsumptionMessage", "showAddLitersScreen", "showBlePermissionDialog", "showBoltSettingsScreen", "showCameraDialog", "showDialog", "description", "showInviteFriend", "referralLink", "showPlanChangeAirScreen", "showReferAndEarnScreen", "showSerialNumberDialog", "showToastMessage", "synchronizeBLE", "updateBleWiFiImage", "resId", "updateFilterLifeImage", "updateWaterRemainingView", "waterRemaining", "writeCharacteristic", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EnvyHomeFragment extends DataBindingFragment<FragmentEnvyHomeBinding> implements CoroutineScope {
    public static final Companion Companion = new Companion(null);
    public static final long LOCATION_INTERVAL = 10000;
    public static final int LOCATION_PERMISSION = 102;
    public static final int LOCATION_SETTING_PERMISSION = 103;
    private boolean _isFirmwareUpdate;
    private boolean _isHardwareUpdate;
    private boolean _isSoftwareUpdate;
    private AnimProgressBar animProgressBar;
    private CodeScanner codeScanner;
    private FragmentEnvyHomeBinding dataBinding;
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
    private final Lazy envyHomeViewModel$delegate = LazyKt.lazy(new Function0<EnvyHomeViewModel>() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$envyHomeViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final EnvyHomeViewModel invoke() {
            EnvyHomeFragmentArgs navArgs;
            EnvyHomeViewModel envyHomeViewModel = (EnvyHomeViewModel) new ViewModelProvider(EnvyHomeFragment.this).get(EnvyHomeViewModel.class);
            navArgs = EnvyHomeFragment.this.getNavArgs();
            envyHomeViewModel.setDevice(navArgs.getDevice());
            return envyHomeViewModel;
        }
    });
    private String _referralCode = "";
    private final long SCAN_PERIOD = 10000;
    private final int LOCATION_PERMISSION_CODE = 2;
    private String macIdAdd = "";
    private String _hardwareVersion = "";
    private String _softwareVersion = "";
    private final int CAMERA_PERMISSION_CODE = 100;
    private String TAG = "livpurelogs";
    private final String[] android12BlePermission = {"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
    private final ScanCallback scanCallback = new ScanCallback() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$scanCallback$1
        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            super.onScanResult(i, result);
            EnvyHomeFragment envyHomeFragment = EnvyHomeFragment.this;
            BluetoothDevice device = result.getDevice();
            Intrinsics.checkNotNullExpressionValue(device, "result.device");
            envyHomeFragment.addBluetoothDevice(device);
        }
    };
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$mGattCallback$1
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
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding;
            EnvyHomeViewModel envyHomeViewModel;
            String[] strArr;
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding2;
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding3 = null;
            if (i2 == 0) {
                z = EnvyHomeFragment.this.isDisconnected;
                if (!z) {
                    EnvyHomeFragment.this.connectWithBle();
                }
                EnvyHomeFragment.this.mBleConnected = false;
                fragmentEnvyHomeBinding = EnvyHomeFragment.this.dataBinding;
                if (fragmentEnvyHomeBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                } else {
                    fragmentEnvyHomeBinding3 = fragmentEnvyHomeBinding;
                }
                TextView textView = fragmentEnvyHomeBinding3.lastSynchronized;
                StringBuilder sb = new StringBuilder();
                sb.append(EnvyHomeFragment.this.requireActivity().getString(R.string.last_synchronized_on));
                sb.append(SafeJsonPrimitive.NULL_CHAR);
                envyHomeViewModel = EnvyHomeFragment.this.getEnvyHomeViewModel();
                sb.append(envyHomeViewModel.getLastSynchronizedOn());
                textView.setText(sb.toString());
            } else if (i2 != 2) {
            } else {
                if (ActivityCompat.checkSelfPermission(EnvyHomeFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    gatt.requestMtu(500);
                } else if (Build.VERSION.SDK_INT >= 31) {
                    strArr = EnvyHomeFragment.this.android12BlePermission;
                    ActivityCompat.requestPermissions(EnvyHomeFragment.this.requireActivity(), strArr, 2);
                } else {
                    gatt.requestMtu(500);
                }
                EnvyHomeFragment.this.isDisconnected = false;
                EnvyHomeFragment.this.mBleConnected = true;
                fragmentEnvyHomeBinding2 = EnvyHomeFragment.this.dataBinding;
                if (fragmentEnvyHomeBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                } else {
                    fragmentEnvyHomeBinding3 = fragmentEnvyHomeBinding2;
                }
                fragmentEnvyHomeBinding3.lastSynchronized.setText(R.string.connection_established);
                if (LSApplication.Companion.isNetworkAvailable()) {
                    EnvyHomeFragment.this.getCommandList();
                    EnvyHomeFragment.this.initContextViews();
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            String[] strArr;
            if (i2 == 0) {
                if (ActivityCompat.checkSelfPermission(EnvyHomeFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    Intrinsics.checkNotNull(bluetoothGatt);
                    bluetoothGatt.discoverServices();
                } else if (Build.VERSION.SDK_INT >= 31) {
                    strArr = EnvyHomeFragment.this.android12BlePermission;
                    ActivityCompat.requestPermissions(EnvyHomeFragment.this.requireActivity(), strArr, 2);
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
            if (ActivityCompat.checkSelfPermission(EnvyHomeFragment.this.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                if (i != 0) {
                    gatt.discoverServices();
                    return;
                }
                EnvyHomeFragment envyHomeFragment = EnvyHomeFragment.this;
                bluetoothGatt3 = envyHomeFragment.mBluetoothGatt;
                envyHomeFragment.initializeGattServices(bluetoothGatt3 != null ? bluetoothGatt3.getServices() : null);
                bluetoothGattCharacteristic3 = EnvyHomeFragment.this.mReadCharacteristic;
                if (bluetoothGattCharacteristic3 != null) {
                    bluetoothGatt4 = EnvyHomeFragment.this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt4);
                    bluetoothGattCharacteristic4 = EnvyHomeFragment.this.mReadCharacteristic;
                    bluetoothGatt4.readCharacteristic(bluetoothGattCharacteristic4);
                }
            } else if (Build.VERSION.SDK_INT >= 31) {
                strArr = EnvyHomeFragment.this.android12BlePermission;
                ActivityCompat.requestPermissions(EnvyHomeFragment.this.requireActivity(), strArr, 2);
            } else if (i != 0) {
                gatt.discoverServices();
            } else {
                EnvyHomeFragment envyHomeFragment2 = EnvyHomeFragment.this;
                bluetoothGatt = envyHomeFragment2.mBluetoothGatt;
                envyHomeFragment2.initializeGattServices(bluetoothGatt != null ? bluetoothGatt.getServices() : null);
                bluetoothGattCharacteristic = EnvyHomeFragment.this.mReadCharacteristic;
                if (bluetoothGattCharacteristic != null) {
                    bluetoothGatt2 = EnvyHomeFragment.this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt2);
                    bluetoothGattCharacteristic2 = EnvyHomeFragment.this.mReadCharacteristic;
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
                charData = EnvyHomeFragment.this.setCharData(characteristic);
                BuildersKt__Builders_commonKt.launch$default(EnvyHomeFragment.this, null, null, new EnvyHomeFragment$mGattCallback$1$onCharacteristicRead$1(EnvyHomeFragment.this, charData, null), 3, null);
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
        return R.layout.fragment_envy_home;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public EnvyHomeFragment() {
        final EnvyHomeFragment envyHomeFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(EnvyHomeFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$special$$inlined$navArgs$1
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
    public final EnvyHomeFragmentArgs getNavArgs() {
        return (EnvyHomeFragmentArgs) this.navArgs$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EnvyHomeViewModel getEnvyHomeViewModel() {
        return (EnvyHomeViewModel) this.envyHomeViewModel$delegate.getValue();
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final void setTAG(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.TAG = str;
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
            EnvyHomeViewModel envyHomeViewModel = getEnvyHomeViewModel();
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            envyHomeViewModel.getDashboardDetails(context);
            setupDashboard();
            EnvyHomeViewModel envyHomeViewModel2 = getEnvyHomeViewModel();
            Context context2 = getContext();
            Intrinsics.checkNotNull(context2);
            envyHomeViewModel2.getAllEnvyBLEResponse(context2).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda21
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EnvyHomeFragment.m778onViewCreated$lambda0(EnvyHomeFragment.this, (List) obj);
                }
            });
        } else {
            EnvyHomeViewModel envyHomeViewModel3 = getEnvyHomeViewModel();
            Context context3 = getContext();
            Intrinsics.checkNotNull(context3);
            envyHomeViewModel3.getAllOflineDashboarData(context3).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda23
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EnvyHomeFragment.m779onViewCreated$lambda3(EnvyHomeFragment.this, (List) obj);
                }
            });
            EnvyHomeViewModel envyHomeViewModel4 = getEnvyHomeViewModel();
            Context context4 = getContext();
            Intrinsics.checkNotNull(context4);
            envyHomeViewModel4.getAllOflineBLECommands(context4).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda24
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EnvyHomeFragment.m780onViewCreated$lambda4(EnvyHomeFragment.this, (List) obj);
                }
            });
            EnvyHomeViewModel envyHomeViewModel5 = getEnvyHomeViewModel();
            Context context5 = getContext();
            Intrinsics.checkNotNull(context5);
            envyHomeViewModel5.getAllEnvyBLEResponse(context5).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda25
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EnvyHomeFragment.m781onViewCreated$lambda5(EnvyHomeFragment.this, (List) obj);
                }
            });
        }
        EnvyHomeViewModel envyHomeViewModel6 = getEnvyHomeViewModel();
        Context context6 = getContext();
        Intrinsics.checkNotNull(context6);
        envyHomeViewModel6.getAllEnvyBLEResponse(context6).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda26
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EnvyHomeFragment.m782onViewCreated$lambda6(EnvyHomeFragment.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m778onViewCreated$lambda0(EnvyHomeFragment this$0, List it) {
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
                    EnvyHomeViewModel envyHomeViewModel = this$0.getEnvyHomeViewModel();
                    Context context = this$0.getContext();
                    Intrinsics.checkNotNull(context);
                    envyHomeViewModel.offlineBLEStatus(context, serialNo, response, true);
                } else {
                    EnvyHomeViewModel envyHomeViewModel2 = this$0.getEnvyHomeViewModel();
                    Context context2 = this$0.getContext();
                    Intrinsics.checkNotNull(context2);
                    envyHomeViewModel2.offlineBLEStatus(context2, serialNo, response, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m779onViewCreated$lambda3(EnvyHomeFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        String str = this$0.requireActivity().getString(R.string.last_synchronized_on) + SafeJsonPrimitive.NULL_CHAR + ((EnvyDashbordOffline) list.get(0)).getLastSyncOn();
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding = this$0.dataBinding;
        if (fragmentEnvyHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentEnvyHomeBinding = null;
        }
        fragmentEnvyHomeBinding.lastSynchronized.setText(str);
        EnvyHomeViewModel envyHomeViewModel = this$0.getEnvyHomeViewModel();
        String remaining = ((EnvyDashbordOffline) list.get(0)).getRemaining();
        Intrinsics.checkNotNull(remaining);
        Integer offlineWaterTank = envyHomeViewModel.offlineWaterTank(remaining);
        if (offlineWaterTank != null) {
            int intValue = offlineWaterTank.intValue();
            String remaining2 = ((EnvyDashbordOffline) list.get(0)).getRemaining();
            Intrinsics.checkNotNull(remaining2);
            this$0.updateWaterRemainingView(remaining2, intValue);
        }
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding2 = this$0.dataBinding;
        if (fragmentEnvyHomeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentEnvyHomeBinding2 = null;
        }
        fragmentEnvyHomeBinding2.planDetails.setText(((EnvyDashbordOffline) list.get(0)).getPlanDetails());
        String filterLife = ((EnvyDashbordOffline) list.get(0)).getFilterLife();
        Integer offlineFilterLife = filterLife != null ? this$0.getEnvyHomeViewModel().offlineFilterLife(filterLife) : null;
        Intrinsics.checkNotNull(offlineFilterLife);
        this$0.updateFilterLifeImage(offlineFilterLife.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m780onViewCreated$lambda4(EnvyHomeFragment this$0, List it) {
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
    /* renamed from: onViewCreated$lambda-5  reason: not valid java name */
    public static final void m781onViewCreated$lambda5(EnvyHomeFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list = it;
        if (list == null || list.isEmpty()) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!list.isEmpty()) {
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding = this$0.dataBinding;
            if (fragmentEnvyHomeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding = null;
            }
            fragmentEnvyHomeBinding.lastSynchronized.setText(R.string.please_connect_the_app_to_internet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-6  reason: not valid java name */
    public static final void m782onViewCreated$lambda6(EnvyHomeFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list = it;
        if (list == null || list.isEmpty()) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!list.isEmpty()) {
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding = this$0.dataBinding;
            if (fragmentEnvyHomeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding = null;
            }
            fragmentEnvyHomeBinding.lastSynchronized.setText(R.string.recharge_is_available);
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
            if (!getEnvyHomeViewModel().getAllowTopup()) {
                showDialog("Your plan’s validity has expired. Please recharge in order for your RO machine to start working again.");
            } else if (Long.valueOf(getEnvyHomeViewModel().getRemainingLitres()).equals(0)) {
                showDialog("The allocated Litters as per your plan have expired. Please Top Up for your RO machine to start working again.");
            } else {
                NavController findNavController = FragmentKt.findNavController(this);
                HomeFragmentDirections.ActionHomeFragmentToContactUsFragment actionHomeFragmentToContactUsFragment = HomeFragmentDirections.actionHomeFragmentToContactUsFragment(getEnvyHomeViewModel().getDeviceSerialNumber());
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
        button.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private final void listeners() {
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding = null;
        if (LSApplication.Companion.isNetworkAvailable() || (!this.bleCommandList.isEmpty())) {
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding2 = this.dataBinding;
            if (fragmentEnvyHomeBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding2 = null;
            }
            fragmentEnvyHomeBinding2.swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda30
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    EnvyHomeFragment.m768listeners$lambda10(EnvyHomeFragment.this);
                }
            });
        } else {
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding3 = this.dataBinding;
            if (fragmentEnvyHomeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding3 = null;
            }
            fragmentEnvyHomeBinding3.swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda29
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    EnvyHomeFragment.m769listeners$lambda11(EnvyHomeFragment.this);
                }
            });
        }
        if (LSApplication.Companion.isNetworkAvailable()) {
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding4 = this.dataBinding;
            if (fragmentEnvyHomeBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding4 = null;
            }
            fragmentEnvyHomeBinding4.renewPlan.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda40
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EnvyHomeFragment.m770listeners$lambda12(EnvyHomeFragment.this, view);
                }
            });
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding5 = this.dataBinding;
            if (fragmentEnvyHomeBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding5 = null;
            }
            fragmentEnvyHomeBinding5.makePayment.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda41
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EnvyHomeFragment.m771listeners$lambda13(EnvyHomeFragment.this, view);
                }
            });
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding6 = this.dataBinding;
            if (fragmentEnvyHomeBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding6 = null;
            }
            fragmentEnvyHomeBinding6.addLitres.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda37
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EnvyHomeFragment.m772listeners$lambda14(EnvyHomeFragment.this, view);
                }
            });
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding7 = this.dataBinding;
            if (fragmentEnvyHomeBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding7 = null;
            }
            fragmentEnvyHomeBinding7.knowMoreLL.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda38
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EnvyHomeFragment.m773listeners$lambda15(EnvyHomeFragment.this, view);
                }
            });
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding8 = this.dataBinding;
            if (fragmentEnvyHomeBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding8 = null;
            }
            fragmentEnvyHomeBinding8.inviteFriend.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda39
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EnvyHomeFragment.m774listeners$lambda16(EnvyHomeFragment.this, view);
                }
            });
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding9 = this.dataBinding;
            if (fragmentEnvyHomeBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding9 = null;
            }
            fragmentEnvyHomeBinding9.settingsIV.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EnvyHomeFragment.m775listeners$lambda17(EnvyHomeFragment.this, view);
                }
            });
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding10 = this.dataBinding;
            if (fragmentEnvyHomeBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding10 = null;
            }
            fragmentEnvyHomeBinding10.bleSyncIV.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EnvyHomeFragment.m776listeners$lambda18(EnvyHomeFragment.this, view);
                }
            });
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding11 = this.dataBinding;
            if (fragmentEnvyHomeBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                fragmentEnvyHomeBinding = fragmentEnvyHomeBinding11;
            }
            fragmentEnvyHomeBinding.llRaiseAserviceComplaint.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EnvyHomeFragment.m777listeners$lambda19(EnvyHomeFragment.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-10  reason: not valid java name */
    public static final void m768listeners$lambda10(EnvyHomeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EnvyHomeViewModel envyHomeViewModel = this$0.getEnvyHomeViewModel();
        Context context = this$0.getContext();
        Intrinsics.checkNotNull(context);
        envyHomeViewModel.getDashboardDetails(context);
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding = null;
        if (this$0.getEnvyHomeViewModel().getImeiNumber().length() == 12) {
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
            } else if (this$0.getBluetooth()) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new EnvyHomeFragment$listeners$1$1(this$0, null), 3, null);
            } else {
                this$0.showBlePermissionDialog();
            }
        }
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding2 = this$0.dataBinding;
        if (fragmentEnvyHomeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentEnvyHomeBinding = fragmentEnvyHomeBinding2;
        }
        fragmentEnvyHomeBinding.swipeToRefresh.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-11  reason: not valid java name */
    public static final void m769listeners$lambda11(EnvyHomeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding = this$0.dataBinding;
        if (fragmentEnvyHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentEnvyHomeBinding = null;
        }
        fragmentEnvyHomeBinding.swipeToRefresh.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-12  reason: not valid java name */
    public static final void m770listeners$lambda12(EnvyHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showPlanChangeAirScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-13  reason: not valid java name */
    public static final void m771listeners$lambda13(EnvyHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showPlanChangeAirScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-14  reason: not valid java name */
    public static final void m772listeners$lambda14(EnvyHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showAddLitersScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-15  reason: not valid java name */
    public static final void m773listeners$lambda15(EnvyHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showReferAndEarnScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-16  reason: not valid java name */
    public static final void m774listeners$lambda16(EnvyHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (LSApplication.Companion.getReferralLink() == null || Intrinsics.areEqual(LSApplication.Companion.getReferralLink(), "")) {
            return;
        }
        String referralLink = LSApplication.Companion.getReferralLink();
        Intrinsics.checkNotNull(referralLink);
        this$0.showInviteFriend(referralLink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-17  reason: not valid java name */
    public static final void m775listeners$lambda17(EnvyHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showBoltSettingsScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-18  reason: not valid java name */
    public static final void m776listeners$lambda18(EnvyHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.synchronizeBLE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-19  reason: not valid java name */
    public static final void m777listeners$lambda19(EnvyHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openServiceComplaint();
    }

    private final void openServiceComplaint() {
        if (!getEnvyHomeViewModel().getAllowTopup()) {
            showDialog("Your plan’s validity has expired. Please recharge in order for your RO machine to start working again.");
        } else if (Long.valueOf(getEnvyHomeViewModel().getRemainingLitres()).equals(0)) {
            showDialog("The allocated Litters as per your plan have expired. Please Top Up for your RO machine to start working again.");
        } else {
            Context context = getContext();
            if (context != null) {
                SegmentLogger with = SegmentLogger.Companion.with(context);
                User user = LSApplication.Companion.getUser();
                String name = user != null ? user.getName() : null;
                User user2 = LSApplication.Companion.getUser();
                with.raiseServiceRequestClick(name, user2 != null ? user2.getId() : null);
            }
            NavController findNavController = FragmentKt.findNavController(this);
            HomeFragmentDirections.ActionHomeFragmentToContactUsFragment actionHomeFragmentToContactUsFragment = HomeFragmentDirections.actionHomeFragmentToContactUsFragment(getEnvyHomeViewModel().getDeviceSerialNumber());
            Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToContactUsFragment, "actionHomeFragmentToCont…Model.deviceSerialNumber)");
            findNavController.navigate(actionHomeFragmentToContactUsFragment);
        }
    }

    private final void synchronizeBLE() {
        if (getBluetooth()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new EnvyHomeFragment$synchronizeBLE$1(this, null), 3, null);
        } else {
            showBlePermissionDialog();
        }
    }

    private final void showPlanChangeAirScreen() {
        disConnectBLE();
        DeviceList deviceList = getEnvyHomeViewModel().get_device();
        HomeDispenserFragmentDirections.ActionDispenserFragmentToSelectPlanChargeFragment actionDispenserFragmentToSelectPlanChargeFragment = deviceList != null ? HomeDispenserFragmentDirections.actionDispenserFragmentToSelectPlanChargeFragment(deviceList) : null;
        if (actionDispenserFragmentToSelectPlanChargeFragment != null) {
            FragmentKt.findNavController(this).navigate(actionDispenserFragmentToSelectPlanChargeFragment);
        }
    }

    private final void showAddLitersScreen() {
        disConnectBLE();
        DeviceList deviceList = getEnvyHomeViewModel().get_device();
        HomeDispenserFragmentDirections.ActionDispenserFragmentToAddLitresFagment actionDispenserFragmentToAddLitresFagment = deviceList != null ? HomeDispenserFragmentDirections.actionDispenserFragmentToAddLitresFagment(deviceList) : null;
        if (actionDispenserFragmentToAddLitresFagment != null) {
            FragmentKt.findNavController(this).navigate(actionDispenserFragmentToAddLitresFagment);
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentEnvyHomeBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.dataBinding = dataBinding;
        dataBinding.setViewModel(getEnvyHomeViewModel());
    }

    private final void showBoltSettingsScreen() {
        disConnectBLE();
        DeviceList deviceList = getEnvyHomeViewModel().get_device();
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
        if (getEnvyHomeViewModel().getImeiNumber().length() == 12) {
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding = this.dataBinding;
            if (fragmentEnvyHomeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding = null;
            }
            fragmentEnvyHomeBinding.wifiInfoIV.setVisibility(0);
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding2 = this.dataBinding;
            if (fragmentEnvyHomeBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding2 = null;
            }
            fragmentEnvyHomeBinding2.settingsIV.setVisibility(0);
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding3 = this.dataBinding;
            if (fragmentEnvyHomeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding3 = null;
            }
            fragmentEnvyHomeBinding3.bleInfoIV.setVisibility(0);
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding4 = this.dataBinding;
            if (fragmentEnvyHomeBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding4 = null;
            }
            fragmentEnvyHomeBinding4.bleSyncIV.setVisibility(0);
        } else {
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding5 = this.dataBinding;
            if (fragmentEnvyHomeBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding5 = null;
            }
            fragmentEnvyHomeBinding5.wifiInfoIV.setVisibility(8);
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding6 = this.dataBinding;
            if (fragmentEnvyHomeBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding6 = null;
            }
            fragmentEnvyHomeBinding6.settingsIV.setVisibility(8);
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding7 = this.dataBinding;
            if (fragmentEnvyHomeBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding7 = null;
            }
            fragmentEnvyHomeBinding7.bleInfoIV.setVisibility(8);
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding8 = this.dataBinding;
            if (fragmentEnvyHomeBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding8 = null;
            }
            fragmentEnvyHomeBinding8.bleSyncIV.setVisibility(8);
        }
        String str = getEnvyHomeViewModel().get_productType();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, "zinger-copper-emi")) {
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding9 = this.dataBinding;
            if (fragmentEnvyHomeBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding9 = null;
            }
            fragmentEnvyHomeBinding9.renewPlan.setVisibility(8);
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding10 = this.dataBinding;
            if (fragmentEnvyHomeBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding10 = null;
            }
            fragmentEnvyHomeBinding10.addLitres.setVisibility(8);
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding11 = this.dataBinding;
            if (fragmentEnvyHomeBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding11 = null;
            }
            fragmentEnvyHomeBinding11.makePaymentDiabled.setVisibility(8);
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding12 = this.dataBinding;
            if (fragmentEnvyHomeBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding12 = null;
            }
            fragmentEnvyHomeBinding12.remainingWaterLabel.setText(R.string.label_water_consumed);
            getEnvyHomeViewModel().isEMIEnable().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda8
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EnvyHomeFragment.m783setupDashboard$lambda25(EnvyHomeFragment.this, (Boolean) obj);
                }
            });
        } else {
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding13 = this.dataBinding;
            if (fragmentEnvyHomeBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding13 = null;
            }
            fragmentEnvyHomeBinding13.renewPlan.setVisibility(0);
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding14 = this.dataBinding;
            if (fragmentEnvyHomeBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding14 = null;
            }
            fragmentEnvyHomeBinding14.addLitres.setVisibility(0);
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding15 = this.dataBinding;
            if (fragmentEnvyHomeBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding15 = null;
            }
            fragmentEnvyHomeBinding15.remainingWaterLabel.setText(R.string.label_water_remaining);
        }
        if (Intrinsics.areEqual(LSApplication.Companion.getPlanName(), "Bolt-Unlimited")) {
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding16 = this.dataBinding;
            if (fragmentEnvyHomeBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding16 = null;
            }
            fragmentEnvyHomeBinding16.addLitres.setVisibility(8);
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding17 = this.dataBinding;
            if (fragmentEnvyHomeBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding17 = null;
            }
            fragmentEnvyHomeBinding17.renewPlan.setBackgroundResource(0);
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding18 = this.dataBinding;
            if (fragmentEnvyHomeBinding18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding18 = null;
            }
            fragmentEnvyHomeBinding18.renewPlan.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorBlack10));
        } else {
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding19 = this.dataBinding;
            if (fragmentEnvyHomeBinding19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding19 = null;
            }
            fragmentEnvyHomeBinding19.addLitres.setVisibility(0);
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding20 = this.dataBinding;
            if (fragmentEnvyHomeBinding20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding20 = null;
            }
            fragmentEnvyHomeBinding20.renewPlan.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.colorWhite));
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding21 = this.dataBinding;
            if (fragmentEnvyHomeBinding21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentEnvyHomeBinding21 = null;
            }
            fragmentEnvyHomeBinding21.renewPlan.setTextColor(ContextCompat.getColor(requireContext(), R.color.color_78afe2));
        }
        getEnvyHomeViewModel().getWaterRemaining().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda27
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EnvyHomeFragment.m784setupDashboard$lambda26(EnvyHomeFragment.this, (Pair) obj);
            }
        });
        getEnvyHomeViewModel().getHardwareUpdate().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EnvyHomeFragment.m785setupDashboard$lambda27(EnvyHomeFragment.this, (Boolean) obj);
            }
        });
        getEnvyHomeViewModel().getSoftwareUpdate().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EnvyHomeFragment.m786setupDashboard$lambda28(EnvyHomeFragment.this, (Boolean) obj);
            }
        });
        getEnvyHomeViewModel().getHardwareVersion().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda19
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EnvyHomeFragment.m787setupDashboard$lambda29(EnvyHomeFragment.this, (String) obj);
            }
        });
        getEnvyHomeViewModel().getSoftwareVersion().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda18
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EnvyHomeFragment.m788setupDashboard$lambda30(EnvyHomeFragment.this, (String) obj);
            }
        });
        EnvyHomeFragment envyHomeFragment = this;
        getEnvyHomeViewModel().getReferralCode().observe(envyHomeFragment, new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda17
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EnvyHomeFragment.m789setupDashboard$lambda31(EnvyHomeFragment.this, (String) obj);
            }
        });
        getEnvyHomeViewModel().getPlanDetails().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda16
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EnvyHomeFragment.m790setupDashboard$lambda32(EnvyHomeFragment.this, (String) obj);
            }
        });
        getEnvyHomeViewModel().getFilterLifeImage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EnvyHomeFragment.m791setupDashboard$lambda33(EnvyHomeFragment.this, (Integer) obj);
            }
        });
        getEnvyHomeViewModel().getProductType().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EnvyHomeFragment.m792setupDashboard$lambda34(EnvyHomeFragment.this, (String) obj);
            }
        });
        getEnvyHomeViewModel().getUsageStats().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda28
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EnvyHomeFragment.m793setupDashboard$lambda35(EnvyHomeFragment.this, (Triple) obj);
            }
        });
        getEnvyHomeViewModel().getLastSynchronizedDate().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda20
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EnvyHomeFragment.m794setupDashboard$lambda36(EnvyHomeFragment.this, (String) obj);
            }
        });
        getEnvyHomeViewModel().getPublishCommandStatus().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda15
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EnvyHomeFragment.m795setupDashboard$lambda37(EnvyHomeFragment.this, (String) obj);
            }
        });
        if (LSApplication.Companion.isNetworkAvailable()) {
            if (getEnvyHomeViewModel().getImeiNumber().length() == 12) {
                if (getBluetooth()) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new EnvyHomeFragment$setupDashboard$14(this, null), 3, null);
                } else {
                    showBlePermissionDialog();
                }
            }
            getCommandList();
            getEnvyHomeViewModel().getBoltCommandsResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda6
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EnvyHomeFragment.m796setupDashboard$lambda38(EnvyHomeFragment.this, (BoltCommandsResponse) obj);
                }
            });
            getEnvyHomeViewModel().getScanSerialNo().observe(envyHomeFragment, new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda7
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EnvyHomeFragment.m797setupDashboard$lambda39(EnvyHomeFragment.this, (Boolean) obj);
                }
            });
        } else if (getBluetooth()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new EnvyHomeFragment$setupDashboard$17(this, null), 3, null);
        } else {
            showBlePermissionDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-25  reason: not valid java name */
    public static final void m783setupDashboard$lambda25(EnvyHomeFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bool.booleanValue()) {
            return;
        }
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding = this$0.dataBinding;
        if (fragmentEnvyHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentEnvyHomeBinding = null;
        }
        fragmentEnvyHomeBinding.makePayment.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-26  reason: not valid java name */
    public static final void m784setupDashboard$lambda26(EnvyHomeFragment this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (((String) pair.getFirst()).length() != 5 || pair.getSecond() == null) {
            return;
        }
        Object second = pair.getSecond();
        Intrinsics.checkNotNull(second);
        this$0.updateWaterRemainingView((String) pair.getFirst(), ((Number) second).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-27  reason: not valid java name */
    public static final void m785setupDashboard$lambda27(EnvyHomeFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boolean booleanValue = it.booleanValue();
        this$0._isHardwareUpdate = booleanValue;
        if (booleanValue) {
            this$0._isFirmwareUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-28  reason: not valid java name */
    public static final void m786setupDashboard$lambda28(EnvyHomeFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boolean booleanValue = it.booleanValue();
        this$0._isSoftwareUpdate = booleanValue;
        if (booleanValue) {
            this$0._isFirmwareUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-29  reason: not valid java name */
    public static final void m787setupDashboard$lambda29(EnvyHomeFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._hardwareVersion = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-30  reason: not valid java name */
    public static final void m788setupDashboard$lambda30(EnvyHomeFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._softwareVersion = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-31  reason: not valid java name */
    public static final void m789setupDashboard$lambda31(EnvyHomeFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._referralCode = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-32  reason: not valid java name */
    public static final void m790setupDashboard$lambda32(EnvyHomeFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return;
        }
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding = this$0.dataBinding;
        if (fragmentEnvyHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentEnvyHomeBinding = null;
        }
        fragmentEnvyHomeBinding.planDetails.setText(str2);
        if (this$0.isAdded()) {
            UserRepository.Companion companion = UserRepository.Companion;
            FragmentActivity requireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            companion.getInstance(requireActivity).setUser(LSApplication.Companion.getUser());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-33  reason: not valid java name */
    public static final void m791setupDashboard$lambda33(EnvyHomeFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null && it.intValue() == -1) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateFilterLifeImage(it.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-34  reason: not valid java name */
    public static final void m792setupDashboard$lambda34(EnvyHomeFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding = this$0.dataBinding;
        if (fragmentEnvyHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentEnvyHomeBinding = null;
        }
        fragmentEnvyHomeBinding.remainingWaterLabel.setText(R.string.label_water_remaining);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-35  reason: not valid java name */
    public static final void m793setupDashboard$lambda35(EnvyHomeFragment this$0, Triple triple) {
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
    /* renamed from: setupDashboard$lambda-36  reason: not valid java name */
    public static final void m794setupDashboard$lambda36(EnvyHomeFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = this$0.requireActivity().getString(R.string.last_synchronized_on) + SafeJsonPrimitive.NULL_CHAR + str;
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding = this$0.dataBinding;
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding2 = null;
        if (fragmentEnvyHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentEnvyHomeBinding = null;
        }
        CharSequence text = fragmentEnvyHomeBinding.lastSynchronized.getText();
        Intrinsics.checkNotNull(text);
        if (StringsKt.contains((CharSequence) text.toString(), (CharSequence) "Last sync on", true)) {
            FragmentEnvyHomeBinding fragmentEnvyHomeBinding3 = this$0.dataBinding;
            if (fragmentEnvyHomeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                fragmentEnvyHomeBinding2 = fragmentEnvyHomeBinding3;
            }
            fragmentEnvyHomeBinding2.lastSynchronized.setText(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-37  reason: not valid java name */
    public static final void m795setupDashboard$lambda37(EnvyHomeFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (StringsKt.equals$default(str, "timeout", false, 2, null)) {
            return;
        }
        AnimProgressBar animProgressBar = this$0.animProgressBar;
        if (animProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            animProgressBar = null;
        }
        animProgressBar.show();
        BuildersKt__Builders_commonKt.launch$default(this$0, null, null, new EnvyHomeFragment$setupDashboard$13$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-38  reason: not valid java name */
    public static final void m796setupDashboard$lambda38(EnvyHomeFragment this$0, BoltCommandsResponse boltCommandsResponse) {
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
    /* renamed from: setupDashboard$lambda-39  reason: not valid java name */
    public static final void m797setupDashboard$lambda39(EnvyHomeFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bool.booleanValue() || this$0.firstLoad) {
            return;
        }
        this$0.firstLoad = true;
        Context context = this$0.getContext();
        SharedPreferences sharedPreferences = context != null ? context.getSharedPreferences("PREFERENCES", 0) : null;
        Objects.requireNonNull(sharedPreferences, "null cannot be cast to non-null type android.content.SharedPreferences");
        String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String string = sharedPreferences.getString("LAST_LAUNCH_DATE", "noDate");
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(currentDate, "currentDate");
        if (StringsKt.contains$default((CharSequence) string, (CharSequence) currentDate, false, 2, (Object) null)) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("LAST_LAUNCH_DATE", currentDate);
        edit.apply();
        String str = this$0.getEnvyHomeViewModel().get_productType();
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
        ((Button) dialog.findViewById(R.id.submitButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EnvyHomeFragment.m806showSerialNumberDialog$lambda43(EnvyHomeFragment.this, dialog, view);
            }
        });
        ((TextView) dialog.findViewById(R.id.noThanksButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showSerialNumberDialog$lambda-43  reason: not valid java name */
    public static final void m806showSerialNumberDialog$lambda43(EnvyHomeFragment this$0, Dialog dialog, View view) {
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
        codeScanner.setDecodeCallback(new DecodeCallback() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda31
            @Override // com.budiyev.android.codescanner.DecodeCallback
            public final void onDecoded(Result result) {
                EnvyHomeFragment.m800showCameraDialog$lambda48(EnvyHomeFragment.this, dialog, result);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.setCancelable(false);
        Handler handler = this.handler;
        Intrinsics.checkNotNull(handler);
        handler.postDelayed(new Runnable() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                EnvyHomeFragment.m803showCameraDialog$lambda50(EnvyHomeFragment.this);
            }
        }, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showCameraDialog$lambda-48  reason: not valid java name */
    public static final void m800showCameraDialog$lambda48(final EnvyHomeFragment this$0, final Dialog dialog, final Result it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda34
                @Override // java.lang.Runnable
                public final void run() {
                    EnvyHomeFragment.m801showCameraDialog$lambda48$lambda47(dialog, this$0, it);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showCameraDialog$lambda-48$lambda-47  reason: not valid java name */
    public static final void m801showCameraDialog$lambda48$lambda47(Dialog dialog, EnvyHomeFragment this$0, Result it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        dialog.dismiss();
        String text = it.getText();
        Intrinsics.checkNotNullExpressionValue(text, "it.text");
        String matchDetails$default = matchDetails$default(this$0, text, "=", 0, 4, null);
        if (matchDetails$default.length() == 14) {
            this$0.getEnvyHomeViewModel().getSerialNumberStatus(matchDetails$default);
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
    /* renamed from: showCameraDialog$lambda-50  reason: not valid java name */
    public static final void m803showCameraDialog$lambda50(EnvyHomeFragment this$0) {
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

    static /* synthetic */ String matchDetails$default(EnvyHomeFragment envyHomeFragment, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return envyHomeFragment.matchDetails(str, str2, i);
    }

    private final String matchDetails(String str, String str2, int i) {
        String str3 = str;
        return StringsKt.indexOf$default((CharSequence) str3, str2, i, false, 4, (Object) null) >= 0 ? (String) StringsKt.split$default((CharSequence) str3, new String[]{str2}, false, 0, 6, (Object) null).get(1) : str;
    }

    private final void updateWaterRemainingView(String str, int i) {
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding = this.dataBinding;
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding2 = null;
        if (fragmentEnvyHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentEnvyHomeBinding = null;
        }
        fragmentEnvyHomeBinding.waterRemainingTenThousand.setText(String.valueOf(str.charAt(0)));
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding3 = this.dataBinding;
        if (fragmentEnvyHomeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentEnvyHomeBinding3 = null;
        }
        fragmentEnvyHomeBinding3.waterRemainingThousands.setText(String.valueOf(str.charAt(1)));
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding4 = this.dataBinding;
        if (fragmentEnvyHomeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentEnvyHomeBinding4 = null;
        }
        fragmentEnvyHomeBinding4.waterRemainingHundreds.setText(String.valueOf(str.charAt(2)));
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding5 = this.dataBinding;
        if (fragmentEnvyHomeBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentEnvyHomeBinding5 = null;
        }
        fragmentEnvyHomeBinding5.waterRemainingTens.setText(String.valueOf(str.charAt(3)));
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding6 = this.dataBinding;
        if (fragmentEnvyHomeBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentEnvyHomeBinding6 = null;
        }
        fragmentEnvyHomeBinding6.waterRemainingOnes.setText(String.valueOf(str.charAt(4)));
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding7 = this.dataBinding;
        if (fragmentEnvyHomeBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentEnvyHomeBinding2 = fragmentEnvyHomeBinding7;
        }
        fragmentEnvyHomeBinding2.waterUsageImage.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
    }

    private final void updateFilterLifeImage(int i) {
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding = this.dataBinding;
        if (fragmentEnvyHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentEnvyHomeBinding = null;
        }
        fragmentEnvyHomeBinding.filterLifeImage.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
    }

    private final void setupUsageStats(List<String> list, List<? extends IBarDataSet> list2, String str) {
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding = this.dataBinding;
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding2 = null;
        if (fragmentEnvyHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentEnvyHomeBinding = null;
        }
        Context context = fragmentEnvyHomeBinding.barChart.getContext();
        Integer valueOf = context != null ? Integer.valueOf(UiUtilKt.getColorFromAttr$default(context, R.attr.colorOnSurface, null, false, 6, null)) : null;
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding3 = this.dataBinding;
        if (fragmentEnvyHomeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentEnvyHomeBinding3 = null;
        }
        BarChart barChart = fragmentEnvyHomeBinding3.barChart;
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
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding4 = this.dataBinding;
        if (fragmentEnvyHomeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            fragmentEnvyHomeBinding2 = fragmentEnvyHomeBinding4;
        }
        fragmentEnvyHomeBinding2.averageWaterConsumption.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupBluetooth() {
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s-%s", Arrays.copyOf(new Object[]{"LIVSMT-RO", StringsKt.takeLast(getEnvyHomeViewModel().getImeiNumber(), 4)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            this.macIdAdd = format;
            String str = this.TAG;
            Log.e(str, "macIdAdd: " + this.macIdAdd);
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
        } catch (Exception e2) {
            Log.e(AgentHealth.DEFAULT_KEY, e2.toString());
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
        Log.e(this.TAG, "scanLeDevice: ");
        try {
            ArrayList<String> arrayList = this.listBluetoothDevice;
            Intrinsics.checkNotNull(arrayList);
            arrayList.clear();
            if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_SCAN") == 0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new EnvyHomeFragment$scanLeDevice$1(this, null), 3, null);
                BluetoothLeScanner bluetoothLeScanner = this.mBluetoothLeScanner;
                Intrinsics.checkNotNull(bluetoothLeScanner);
                bluetoothLeScanner.startScan(this.scanCallback);
                this.mScanning = true;
            } else if (Build.VERSION.SDK_INT < 31) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new EnvyHomeFragment$scanLeDevice$2(this, null), 3, null);
                BluetoothLeScanner bluetoothLeScanner2 = this.mBluetoothLeScanner;
                Intrinsics.checkNotNull(bluetoothLeScanner2);
                bluetoothLeScanner2.startScan(this.scanCallback);
                this.mScanning = true;
            } else {
                ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
            }
        } catch (Exception e) {
            Log.e(AgentHealth.DEFAULT_KEY, e.toString());
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
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new EnvyHomeFragment$connectWithBle$1(this, null), 3, null);
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
        if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            if (list != null) {
                for (BluetoothGattService bluetoothGattService : list) {
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
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
                }
            }
        } else if (Build.VERSION.SDK_INT >= 31) {
            ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
        } else if (list != null) {
            for (BluetoothGattService bluetoothGattService2 : list) {
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : bluetoothGattService2.getCharacteristics()) {
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
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCommandList() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            EnvyHomeViewModel envyHomeViewModel = getEnvyHomeViewModel();
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            envyHomeViewModel.getPendingBleCommand(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayData(String str) {
        List<String> lines;
        String decrypt;
        List<String> lines2;
        String decrypt2;
        getEnvyHomeViewModel().getBleImage().observe(this, new Observer() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda13
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EnvyHomeFragment.m767displayData$lambda53(EnvyHomeFragment.this, (Integer) obj);
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
                        Log.e(this.TAG, "displayData: " + decrypt2);
                        JSONObject jSONObject = new JSONObject(decrypt2);
                        EnvyHomeViewModel envyHomeViewModel = getEnvyHomeViewModel();
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonData.toString()");
                        Context context = getContext();
                        Intrinsics.checkNotNull(context);
                        envyHomeViewModel.bleStatus(jSONObject2, context);
                        if (!LSApplication.Companion.isNetworkAvailable()) {
                            BoldBleData boldBleData = (BoldBleData) new Gson().fromJson(jSONObject.toString(), (Class<Object>) BoldBleData.class);
                            if (boldBleData.getRemainingLitre() != null) {
                                String padStart = StringsKt.padStart(boldBleData.getRemainingLitre(), 5, '0');
                                Integer offlineWaterTank = getEnvyHomeViewModel().offlineWaterTank(padStart);
                                if (offlineWaterTank != null) {
                                    updateWaterRemainingView(padStart, offlineWaterTank.intValue());
                                }
                                showToastMessage("Remaining Litres : " + padStart);
                            }
                        }
                        String jSONObject3 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonData.toString()");
                        if (StringsKt.contains$default((CharSequence) jSONObject3, (CharSequence) "\"RSA\":\"1", false, 2, (Object) null)) {
                            FragmentEnvyHomeBinding fragmentEnvyHomeBinding = this.dataBinding;
                            if (fragmentEnvyHomeBinding == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                fragmentEnvyHomeBinding = null;
                            }
                            fragmentEnvyHomeBinding.lastSynchronized.setText(R.string.recharge_successful);
                            BuildersKt__Builders_commonKt.launch$default(this, null, null, new EnvyHomeFragment$displayData$4(this, null), 3, null);
                        }
                        if (this.bleCommandList.size() > 0) {
                            String str3 = this.bleCommandList.get(0);
                            Intrinsics.checkNotNullExpressionValue(str3, "bleCommandList[0]");
                            if (StringsKt.contains$default((CharSequence) str3, (CharSequence) "\"RS\":\"", false, 2, (Object) null)) {
                                FragmentEnvyHomeBinding fragmentEnvyHomeBinding2 = this.dataBinding;
                                if (fragmentEnvyHomeBinding2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                    fragmentEnvyHomeBinding2 = null;
                                }
                                fragmentEnvyHomeBinding2.lastSynchronized.setText(R.string.recharging_in_progress);
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
                            BuildersKt__Builders_commonKt.launch$default(this, null, null, new EnvyHomeFragment$displayData$5(this, null), 3, null);
                            return;
                        }
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new EnvyHomeFragment$displayData$2(this, null), 3, null);
                    showToastMessage("Long Data : ");
                } catch (Exception unused) {
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new EnvyHomeFragment$displayData$6(this, null), 3, null);
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
                    Log.e(this.TAG, "displayData: " + decrypt);
                    JSONObject jSONObject6 = new JSONObject(decrypt);
                    EnvyHomeViewModel envyHomeViewModel2 = getEnvyHomeViewModel();
                    String jSONObject7 = jSONObject6.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject7, "jsonData.toString()");
                    Context context2 = getContext();
                    Intrinsics.checkNotNull(context2);
                    envyHomeViewModel2.bleStatus(jSONObject7, context2);
                    if (!LSApplication.Companion.isNetworkAvailable()) {
                        BoldBleData boldBleData2 = (BoldBleData) new Gson().fromJson(jSONObject6.toString(), (Class<Object>) BoldBleData.class);
                        if (boldBleData2.getRemainingLitre() != null) {
                            String padStart2 = StringsKt.padStart(boldBleData2.getRemainingLitre(), 5, '0');
                            Integer offlineWaterTank2 = getEnvyHomeViewModel().offlineWaterTank(padStart2);
                            if (offlineWaterTank2 != null) {
                                updateWaterRemainingView(padStart2, offlineWaterTank2.intValue());
                            }
                            showToastMessage("Remaining Litres : " + padStart2);
                        }
                    }
                    String jSONObject8 = jSONObject6.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject8, "jsonData.toString()");
                    if (StringsKt.contains$default((CharSequence) jSONObject8, (CharSequence) "\"RSA\":\"1", false, 2, (Object) null)) {
                        FragmentEnvyHomeBinding fragmentEnvyHomeBinding3 = this.dataBinding;
                        if (fragmentEnvyHomeBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                            fragmentEnvyHomeBinding3 = null;
                        }
                        fragmentEnvyHomeBinding3.lastSynchronized.setText(R.string.recharge_successful);
                        BuildersKt__Builders_commonKt.launch$default(this, null, null, new EnvyHomeFragment$displayData$9(this, null), 3, null);
                    }
                    if (this.bleCommandList.size() > 0) {
                        String str6 = this.bleCommandList.get(0);
                        Intrinsics.checkNotNullExpressionValue(str6, "bleCommandList[0]");
                        if (StringsKt.contains$default((CharSequence) str6, (CharSequence) "\"RS\":\"", false, 2, (Object) null)) {
                            FragmentEnvyHomeBinding fragmentEnvyHomeBinding4 = this.dataBinding;
                            if (fragmentEnvyHomeBinding4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                fragmentEnvyHomeBinding4 = null;
                            }
                            fragmentEnvyHomeBinding4.lastSynchronized.setText(R.string.recharging_in_progress);
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
                        BuildersKt__Builders_commonKt.launch$default(this, null, null, new EnvyHomeFragment$displayData$10(this, null), 3, null);
                        return;
                    }
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new EnvyHomeFragment$displayData$7(this, null), 3, null);
                showToastMessage("Long Data : ");
            } catch (Exception unused2) {
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new EnvyHomeFragment$displayData$11(this, null), 3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: displayData$lambda-53  reason: not valid java name */
    public static final void m767displayData$lambda53(EnvyHomeFragment this$0, Integer it) {
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
            Intrinsics.checkNotNullExpressionValue(hexStringToByteArray, "hexStringToByteArray(encryptedData)");
            if (Intrinsics.areEqual(publishToDevice(hexStringToByteArray), "succes")) {
                BuildersKt__Builders_commonKt.launch$default(this, null, null, new EnvyHomeFragment$sendToBLEJsonData$1(this, null), 3, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void updateBleWiFiImage(int i) {
        FragmentEnvyHomeBinding fragmentEnvyHomeBinding = this.dataBinding;
        if (fragmentEnvyHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            fragmentEnvyHomeBinding = null;
        }
        fragmentEnvyHomeBinding.bleInfoIV.setImageDrawable(ContextCompat.getDrawable(requireActivity(), i));
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

    private final boolean getBluetooth() {
        return BluetoothAdapter.getDefaultAdapter().isEnabled();
    }

    private final boolean setBluetooth() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean isEnabled = defaultAdapter.isEnabled();
        if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            setupBluetooth();
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

    private final void showBlePermissionDialog() {
        Context context = getContext();
        final Dialog dialog = context != null ? new Dialog(context) : null;
        if (dialog != null) {
            dialog.requestWindowFeature(1);
        }
        if (dialog != null) {
            dialog.setContentView(R.layout.custome_dialog_ble);
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
        button2.setText(requireActivity().getString(R.string.enable_bluetooth));
        button.setText(requireActivity().getString(R.string.not_allow));
        ((TextView) dialog.findViewById(R.id.header)).setText(requireActivity().getString(R.string.ble_permission_header));
        ((TextView) dialog.findViewById(R.id.msg_txt)).setText(requireActivity().getString(R.string.ble_permission_text));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EnvyHomeFragment.m799showBlePermissionDialog$lambda62(EnvyHomeFragment.this, dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showBlePermissionDialog$lambda-62  reason: not valid java name */
    public static final void m799showBlePermissionDialog$lambda62(EnvyHomeFragment this$0, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.setBluetooth()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new EnvyHomeFragment$showBlePermissionDialog$2$1(this$0, null), 3, null);
        }
        dialog.dismiss();
    }

    private final void showToastMessage(String str) {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new EnvyHomeFragment$showToastMessage$1(this, str, null), 3, null);
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
                getEnvyHomeViewModel().updateLocationDetails(String.valueOf(this.latitude), String.valueOf(this.longitude));
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
            task.addOnCompleteListener(requireActivity(), new OnCompleteListener() { // from class: com.livpure.safedrink.dispenser.view.EnvyHomeFragment$$ExternalSyntheticLambda32
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    EnvyHomeFragment.m766checkGpsEnablePermission$lambda63(EnvyHomeFragment.this, task2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkGpsEnablePermission$lambda-63  reason: not valid java name */
    public static final void m766checkGpsEnablePermission$lambda63(EnvyHomeFragment this$0, Task task) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            task.getResult(ApiException.class);
        } catch (ApiException e) {
            if (e.getStatusCode() == 6) {
                try {
                    FragmentActivity activity = this$0.getActivity();
                    Intrinsics.checkNotNull(activity);
                    ((ResolvableApiException) e).startResolutionForResult(activity, 103);
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
                getEnvyHomeViewModel().updateLocationDetails(String.valueOf(this.latitude), String.valueOf(this.longitude));
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
                getEnvyHomeViewModel().updateLocationDetails(String.valueOf(this.latitude), String.valueOf(this.longitude));
            }
        }
    }

    /* compiled from: EnvyHomeFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/livpure/safedrink/dispenser/view/EnvyHomeFragment$Companion;", "", "()V", "LOCATION_INTERVAL", "", "LOCATION_PERMISSION", "", "LOCATION_SETTING_PERMISSION", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
