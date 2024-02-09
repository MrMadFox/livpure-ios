package com.livpure.safedrink.app;

import android.app.Activity;
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
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
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
import com.livpure.safedrink.app.HomeViewModel;
import com.livpure.safedrink.bolt.data.models.BoldBleData;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import com.livpure.safedrink.bolt.data.models.RechargeResponse;
import com.livpure.safedrink.bolt.service.Base64Hex;
import com.livpure.safedrink.bolt.service.Encrypt;
import com.livpure.safedrink.common.UiUtilKt;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentHomeBinding;
import com.livpure.safedrink.login.api.models.response.UserDetailsResponse;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.segment.SegmentIdentityManager;
import com.livpure.safedrink.servicebluetooth.BluetoothLeService;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.utils.AppConstants;
import com.livpure.safedrink.utils.AppUtils;
import com.livpure.safedrink.utils.GPSTracker;
import com.livpure.safedrink.utils.MyVolleySingleton;
import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.payload.PayloadController;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.segment.analytics.Analytics;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.wssholmes.stark.circular_score.CircularScoreView;
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
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: HomeFragment.kt */
@Metadata(d1 = {"\u0000â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 ã\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002ã\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010y\u001a\u00020'2\u0006\u0010z\u001a\u00020CH\u0002J\u0010\u0010{\u001a\u00020'2\u0006\u0010|\u001a\u00020\u0002H\u0016J\b\u0010}\u001a\u00020'H\u0002J\b\u0010~\u001a\u00020'H\u0002J\b\u0010\u007f\u001a\u00020'H\u0002J\t\u0010\u0080\u0001\u001a\u00020\u0005H\u0002J\t\u0010\u0081\u0001\u001a\u00020\u0005H\u0002J\t\u0010\u0082\u0001\u001a\u00020'H\u0002J\t\u0010\u0083\u0001\u001a\u00020'H\u0002J\u0014\u0010\u0084\u0001\u001a\u00020'2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000fH\u0002J\t\u0010\u0086\u0001\u001a\u00020'H\u0002J\t\u0010\u0087\u0001\u001a\u00020'H\u0002J\t\u0010\u0088\u0001\u001a\u00020'H\u0002J\t\u0010\u0089\u0001\u001a\u00020'H\u0002J\u0012\u0010\u008a\u0001\u001a\u00020'2\u0007\u0010\u008b\u0001\u001a\u00020\u000fH\u0002J\u0012\u0010\u008c\u0001\u001a\u00020'2\u0007\u0010\u008b\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u008d\u0001\u001a\u00020\bH\u0014J\t\u0010\u008e\u0001\u001a\u00020;H\u0014J\t\u0010\u008f\u0001\u001a\u00020'H\u0002J\t\u0010\u0090\u0001\u001a\u00020'H\u0002J\u001c\u0010\u0091\u0001\u001a\u00020'2\u0011\u0010\u0092\u0001\u001a\f\u0012\u0005\u0012\u00030\u0094\u0001\u0018\u00010\u0093\u0001H\u0002J\u0012\u0010\u0095\u0001\u001a\u00020\u000f2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u000fJ\n\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0002J&\u0010\u0099\u0001\u001a\u00020\u000f2\u0007\u0010\u009a\u0001\u001a\u00020\u000f2\u0007\u0010\u009b\u0001\u001a\u00020\u000f2\t\b\u0002\u0010\u009c\u0001\u001a\u00020\bH\u0002J\u0013\u0010\u009d\u0001\u001a\u00020'2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0002J\t\u0010 \u0001\u001a\u00020'H\u0002J'\u0010¡\u0001\u001a\u00020'2\u0007\u0010¢\u0001\u001a\u00020\b2\u0007\u0010£\u0001\u001a\u00020\b2\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010¤\u0001H\u0016J\u0015\u0010¥\u0001\u001a\u00020'2\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0016J\u001d\u0010¨\u0001\u001a\u00020'2\b\u0010©\u0001\u001a\u00030ª\u00012\b\u0010«\u0001\u001a\u00030¬\u0001H\u0016J\t\u0010\u00ad\u0001\u001a\u00020'H\u0016J\u0013\u0010®\u0001\u001a\u00020\u00052\b\u0010¯\u0001\u001a\u00030°\u0001H\u0016J\t\u0010±\u0001\u001a\u00020'H\u0016J\u0007\u0010²\u0001\u001a\u00020'J1\u0010²\u0001\u001a\u00020'2\u0007\u0010¢\u0001\u001a\u00020\b2\r\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00172\b\u0010´\u0001\u001a\u00030µ\u0001H\u0016¢\u0006\u0003\u0010¶\u0001J\t\u0010·\u0001\u001a\u00020'H\u0016J\u001f\u0010¸\u0001\u001a\u00020'2\b\u0010¹\u0001\u001a\u00030º\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0016J\t\u0010»\u0001\u001a\u00020'H\u0002J\u0015\u0010¼\u0001\u001a\u0004\u0018\u00010\u000f2\n\u0010½\u0001\u001a\u0005\u0018\u00010¾\u0001J\t\u0010¿\u0001\u001a\u00020'H\u0002J\u0012\u0010À\u0001\u001a\u00020'2\u0007\u0010Á\u0001\u001a\u00020\u000fH\u0002J\t\u0010Â\u0001\u001a\u00020'H\u0002J\t\u0010Ã\u0001\u001a\u00020'H\u0002J\u0012\u0010Ä\u0001\u001a\u00020'2\u0007\u0010Å\u0001\u001a\u00020\u000fH\u0002J\u001b\u0010Ä\u0001\u001a\u00020'2\u0007\u0010Å\u0001\u001a\u00020\u000f2\u0007\u0010Æ\u0001\u001a\u00020\u0005H\u0002J\u0010\u0010Ç\u0001\u001a\u00020\u00052\u0007\u0010È\u0001\u001a\u00020\u0005J\t\u0010É\u0001\u001a\u00020'H\u0002J\t\u0010Ê\u0001\u001a\u00020'H\u0002J3\u0010Ë\u0001\u001a\u00020'2\u000e\u0010Ì\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0093\u00012\u000f\u0010Í\u0001\u001a\n\u0012\u0005\u0012\u00030Î\u00010\u0093\u00012\u0007\u0010Ï\u0001\u001a\u00020\u000fH\u0002J\t\u0010Ð\u0001\u001a\u00020'H\u0002J\t\u0010Ñ\u0001\u001a\u00020'H\u0002J\t\u0010Ò\u0001\u001a\u00020'H\u0002J\t\u0010Ó\u0001\u001a\u00020'H\u0002J\u0007\u0010Ô\u0001\u001a\u00020'J\t\u0010Õ\u0001\u001a\u00020'H\u0002J\t\u0010Ö\u0001\u001a\u00020'H\u0002J\t\u0010×\u0001\u001a\u00020'H\u0002J\t\u0010Ø\u0001\u001a\u00020'H\u0002J\u0012\u0010Ù\u0001\u001a\u00020\u00052\u0007\u0010Ú\u0001\u001a\u00020\u000fH\u0002J\u001d\u0010Û\u0001\u001a\u00020'2\t\b\u0001\u0010Ü\u0001\u001a\u00020\b2\u0007\u0010Ý\u0001\u001a\u00020\u000fH\u0002J\u0014\u0010Þ\u0001\u001a\u00020'2\t\b\u0001\u0010Ü\u0001\u001a\u00020\bH\u0002J\u001d\u0010ß\u0001\u001a\u00020'2\u0007\u0010à\u0001\u001a\u00020\u000f2\t\b\u0001\u0010Ü\u0001\u001a\u00020\bH\u0002J\u0012\u0010á\u0001\u001a\u00020'2\u0007\u0010â\u0001\u001a\u00020`H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00178\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u001e\u0010\u0019\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u001dj\b\u0012\u0004\u0012\u00020\u000f`\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0010\u00109\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b<\u0010=R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010B\u001a\u0016\u0012\u0004\u0012\u00020C\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020C\u0018\u0001`\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u0010)R\u000e\u0010J\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010QX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u0004\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u0004\u0018\u00010hX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010hX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010l\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010m\u001a\u00020n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bo\u0010pR\u001e\u0010s\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u001dj\b\u0012\u0004\u0012\u00020\u000f`\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020uX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u0004\u0018\u00010xX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ä\u0001"}, d2 = {"Lcom/livpure/safedrink/app/HomeFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentHomeBinding;", "()V", "BLE_LOCATION_PACKET_RECEIVED", "", "BLE_STATUS_PACKET_RECEIVED", "CAMERA_PERMISSION_CODE", "", "LOCATION_PERMISSION_CODE", "SCAN_PERIOD", "", "_OTAUPDATECANCELREQUEST", "_OTAUPDATEREQUEST", "_hardwareVersion", "", "_isFirmwareUpdate", "_isHardwareUpdate", "_isSoftwareUpdate", "_isTopupAllowed", "_referralCode", "_softwareVersion", "android12BlePermission", "", "[Ljava/lang/String;", "attributes", "Ljava/util/HashMap;", "", "bleCommandList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "boltCommandsResponse", "Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", "circularScoreView", "Lcom/wssholmes/stark/circular_score/CircularScoreView;", "codeScanner", "Lcom/budiyev/android/codescanner/CodeScanner;", "counter", "currentLocation", "", "getCurrentLocation", "()Lkotlin/Unit;", "firmwareDialoglog", "Landroid/app/Dialog;", "firmwareHandler", "Landroid/os/Handler;", "firmwareParts", "", "firstLoad", "gpsTracker", "Lcom/livpure/safedrink/utils/GPSTracker;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "setGson", "(Lcom/google/gson/Gson;)V", "handler", "homeViewModel", "Lcom/livpure/safedrink/app/HomeViewModel;", "getHomeViewModel", "()Lcom/livpure/safedrink/app/HomeViewModel;", "homeViewModel$delegate", "Lkotlin/Lazy;", "latitude", "", "listBluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "getListBluetoothDevice", "()Ljava/util/ArrayList;", "setListBluetoothDevice", "(Ljava/util/ArrayList;)V", "locationAccessPermission", "getLocationAccessPermission", "longitude", "mBleConnected", "mBluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "mBluetoothLeScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "mBluetoothLeService", "Lcom/livpure/safedrink/servicebluetooth/BluetoothLeService;", "mConnected", "mDeviceAddress", "mDeviceName", "mGattUpdateReceiver", "Landroid/content/BroadcastReceiver;", "mHandler", "mLocationManager", "Landroid/location/LocationManager;", "mLocationPowerBalanceRequest", "Lcom/google/android/gms/location/LocationRequest;", "mLocationRequest", "mLocationSettingRequestBuilder", "Lcom/google/android/gms/location/LocationSettingsRequest$Builder;", "mNotifyCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "mReadCharacteristic", "mScanning", "mServiceConnection", "Landroid/content/ServiceConnection;", "mWriteCharacteristic", "macIdAdd", "myFirmwareUpdateRunnable", "Ljava/lang/Runnable;", "myRunnable", "myScanDataRunnable", "myScanFirstRunnable", "myScanRunnable", "navArgs", "Lcom/livpure/safedrink/app/HomeFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/app/HomeFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "packet_list", "scanCallback", "Landroid/bluetooth/le/ScanCallback;", "sentPacket", "settingsClient", "Lcom/google/android/gms/location/SettingsClient;", "addBluetoothDevice", AndroidContextPlugin.DEVICE_KEY, "bindVariablesToView", "dataBinding", "bleOFF", "buildLocationSettingRequest", "checkGpsEnablePermission", "checkIfLocationPermissionGranted", "checkLocationAccessPermission", "createLocationRequest", "discconnectBLE", "displayData", "data", "getBleData", "getBluetoothAdapter", "getBluetoothLeScanner", "getCommandList", "getFirmwareData", "roData", "getFirmwareNextData", "getLayoutId", "getViewModel", "gpsEnablePermission", "initContextViews", "initializeGattServices", "gattServices", "", "Landroid/bluetooth/BluetoothGattService;", "lookup", AnalyticsAttribute.UUID_ATTRIBUTE, "makeGattUpdateIntentFilter", "Landroid/content/IntentFilter;", "matchDetails", "inputString", "whatToFind", "startIndex", MoEPushConstants.ACTION_NAVIGATE, NativeProtocol.WEB_DIALOG_ACTION, "Landroidx/navigation/NavDirections;", "navigateToSelectOrRechargePlan", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPause", "onRequestPermissionsResult", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "productTypeInfo", "publishToDevice", "message", "", "requestPermission", "reqularPacket", "jsonData", "scanLeDevice", "sendContinueCommand", "sendToBLEJsonData", "value", "acknowledgement", "setBluetooth", "enable", "setupBluetooth", "setupDashboard", "setupUsageStats", "dates", "consumptionDataSetList", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "averageConsumptionMessage", "showAddLitesScreen", "showBoltSettingsScreen", "showCameraDialog", "showContactUsScreen", "showFirmwareUpdateDialog", "showReferAndEarnScreen", "showRenewChangePlanScreen", "showSerialNumberDialog", "showUploadKYCScreen", "splitToNChar", "text", "updateBleWiFiImage", "resId", "type", "updateFilterLifeImage", "updateWaterRemainingView", "waterRemaining", "writeCharacteristic", "characteristic", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeFragment extends DataBindingFragment<FragmentHomeBinding> {
    public static final Companion Companion = new Companion(null);
    public static final long LOCATION_INTERVAL = 10000;
    public static final int LOCATION_PERMISSION = 102;
    public static final int LOCATION_SETTING_PERMISSION = 103;
    private boolean BLE_LOCATION_PACKET_RECEIVED;
    private boolean BLE_STATUS_PACKET_RECEIVED;
    private boolean _OTAUPDATECANCELREQUEST;
    private boolean _OTAUPDATEREQUEST;
    private boolean _isFirmwareUpdate;
    private boolean _isHardwareUpdate;
    private boolean _isSoftwareUpdate;
    private boolean _isTopupAllowed;
    private BoltCommandsResponse boltCommandsResponse;
    private CircularScoreView circularScoreView;
    private CodeScanner codeScanner;
    private int counter;
    private Dialog firmwareDialoglog;
    private boolean firstLoad;
    private GPSTracker gpsTracker;
    private Handler handler;
    private double latitude;
    private ArrayList<BluetoothDevice> listBluetoothDevice;
    private double longitude;
    private boolean mBleConnected;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeScanner mBluetoothLeScanner;
    private BluetoothLeService mBluetoothLeService;
    private boolean mConnected;
    private String mDeviceAddress;
    private String mDeviceName;
    private Handler mHandler;
    private LocationManager mLocationManager;
    private LocationRequest mLocationPowerBalanceRequest;
    private LocationRequest mLocationRequest;
    private LocationSettingsRequest.Builder mLocationSettingRequestBuilder;
    private BluetoothGattCharacteristic mNotifyCharacteristic;
    private BluetoothGattCharacteristic mReadCharacteristic;
    private boolean mScanning;
    private BluetoothGattCharacteristic mWriteCharacteristic;
    private Runnable myFirmwareUpdateRunnable;
    private final Runnable myRunnable;
    private Runnable myScanDataRunnable;
    private final Runnable myScanFirstRunnable;
    private Runnable myScanRunnable;
    private final NavArgsLazy navArgs$delegate;
    private int sentPacket;
    private SettingsClient settingsClient;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy homeViewModel$delegate = LazyKt.lazy(new Function0<HomeViewModel>() { // from class: com.livpure.safedrink.app.HomeFragment$homeViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HomeViewModel invoke() {
            HomeFragmentArgs navArgs;
            HomeViewModel homeViewModel = (HomeViewModel) new ViewModelProvider(HomeFragment.this).get(HomeViewModel.class);
            navArgs = HomeFragment.this.getNavArgs();
            homeViewModel.setDevice(navArgs.getDevice());
            return homeViewModel;
        }
    });
    private String _referralCode = "";
    private Gson gson = new Gson();
    private final ArrayList<String> bleCommandList = new ArrayList<>();
    private String _hardwareVersion = "";
    private String _softwareVersion = "";
    private final long SCAN_PERIOD = 10000;
    private ArrayList<String> packet_list = new ArrayList<>();
    private final int LOCATION_PERMISSION_CODE = 2;
    private String macIdAdd = "";
    private final String[] android12BlePermission = {"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
    private final int CAMERA_PERMISSION_CODE = 100;
    private final List<String> firmwareParts = new ArrayList();
    private final ScanCallback scanCallback = new ScanCallback() { // from class: com.livpure.safedrink.app.HomeFragment$scanCallback$1
        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            super.onScanResult(i, result);
            HomeFragment homeFragment = HomeFragment.this;
            BluetoothDevice device = result.getDevice();
            Intrinsics.checkNotNullExpressionValue(device, "result.device");
            homeFragment.addBluetoothDevice(device);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> results) {
            Intrinsics.checkNotNullParameter(results, "results");
            super.onBatchScanResults(results);
        }
    };
    private final ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.livpure.safedrink.app.HomeFragment$mServiceConnection$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            BluetoothLeService bluetoothLeService;
            BluetoothLeService bluetoothLeService2;
            String str;
            Intrinsics.checkNotNullParameter(componentName, "componentName");
            Intrinsics.checkNotNullParameter(service, "service");
            HomeFragment.this.mBluetoothLeService = ((BluetoothLeService.LocalBinder) service).getService();
            bluetoothLeService = HomeFragment.this.mBluetoothLeService;
            Intrinsics.checkNotNull(bluetoothLeService);
            if (bluetoothLeService.initialize()) {
                bluetoothLeService2 = HomeFragment.this.mBluetoothLeService;
                Intrinsics.checkNotNull(bluetoothLeService2);
                str = HomeFragment.this.mDeviceAddress;
                bluetoothLeService2.connect(str);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Intrinsics.checkNotNullParameter(componentName, "componentName");
            HomeFragment.this.mBluetoothLeService = null;
        }
    };
    private final BroadcastReceiver mGattUpdateReceiver = new BroadcastReceiver() { // from class: com.livpure.safedrink.app.HomeFragment$mGattUpdateReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BluetoothLeService bluetoothLeService;
            BluetoothLeService bluetoothLeService2;
            BluetoothGattCharacteristic bluetoothGattCharacteristic;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            String action = intent.getAction();
            if (Intrinsics.areEqual(BluetoothLeService.ACTION_GATT_CONNECTED, action)) {
                HomeFragment.this.initContextViews();
                HomeFragment.this.mConnected = true;
                HomeFragment.this.BLE_STATUS_PACKET_RECEIVED = false;
                HomeFragment.this.getCommandList();
            } else if (Intrinsics.areEqual(BluetoothLeService.ACTION_GATT_DISCONNECTED, action)) {
                HomeFragment.this.mConnected = false;
                HomeFragment.this.bleOFF();
            } else if (Intrinsics.areEqual(BluetoothLeService.ACTION_GATT_SERVICES_DISCOVERED, action)) {
                HomeFragment homeFragment = HomeFragment.this;
                bluetoothLeService = homeFragment.mBluetoothLeService;
                homeFragment.initializeGattServices(bluetoothLeService != null ? bluetoothLeService.getSupportedGattServices() : null);
                bluetoothLeService2 = HomeFragment.this.mBluetoothLeService;
                Intrinsics.checkNotNull(bluetoothLeService2);
                bluetoothGattCharacteristic = HomeFragment.this.mReadCharacteristic;
                bluetoothLeService2.readCharacteristic(bluetoothGattCharacteristic);
            } else if (Intrinsics.areEqual(BluetoothLeService.ACTION_DATA_AVAILABLE, action)) {
                HomeFragment.this.displayData(intent.getStringExtra(BluetoothLeService.EXTRA_DATA));
            } else if (Intrinsics.areEqual(BluetoothLeService.ACTION_WRITE_DATA_AVAILABLE, action)) {
                HomeFragment.this.sendContinueCommand();
            }
        }
    };
    private final HashMap<Object, Object> attributes = new HashMap<>();
    private Handler firmwareHandler = new Handler(Looper.getMainLooper());

    /* compiled from: HomeFragment.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HomeViewModel.HomeNavigationStates.values().length];
            iArr[HomeViewModel.HomeNavigationStates.CHECK_KYC.ordinal()] = 1;
            iArr[HomeViewModel.HomeNavigationStates.CHECK_PAYMENT.ordinal()] = 2;
            iArr[HomeViewModel.HomeNavigationStates.SELECT_PLAN.ordinal()] = 3;
            iArr[HomeViewModel.HomeNavigationStates.UPDATE_KYC.ordinal()] = 4;
            iArr[HomeViewModel.HomeNavigationStates.CHECK_INSTALLATION.ordinal()] = 5;
            iArr[HomeViewModel.HomeNavigationStates.INSTALLATION_PENDING.ordinal()] = 6;
            iArr[HomeViewModel.HomeNavigationStates.ADD_LITRES.ordinal()] = 7;
            iArr[HomeViewModel.HomeNavigationStates.RECHARGE_CHANGE_PLAN.ordinal()] = 8;
            iArr[HomeViewModel.HomeNavigationStates.REFER_AND_EARN.ordinal()] = 9;
            iArr[HomeViewModel.HomeNavigationStates.BOLT_SETTINGS.ordinal()] = 10;
            iArr[HomeViewModel.HomeNavigationStates.INVITE.ordinal()] = 11;
            iArr[HomeViewModel.HomeNavigationStates.HOME.ordinal()] = 12;
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
        return R.layout.fragment_home;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public HomeFragment() {
        final HomeFragment homeFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(HomeFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.app.HomeFragment$special$$inlined$navArgs$1
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
    public final HomeFragmentArgs getNavArgs() {
        return (HomeFragmentArgs) this.navArgs$delegate.getValue();
    }

    private final HomeViewModel getHomeViewModel() {
        return (HomeViewModel) this.homeViewModel$delegate.getValue();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public HomeViewModel getViewModel() {
        return getHomeViewModel();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (LSApplication.Companion.getHasSplashBeenShown()) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            this.gpsTracker = new GPSTracker(requireActivity);
            setupDashboard();
            HomeFragment homeFragment = this;
            getHomeViewModel().observeAnalytics().observe(homeFragment, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda45
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeFragment.m358onCreate$lambda0(HomeFragment.this, (Event) obj);
                }
            });
            getHomeViewModel().isTopUpAllowed().observe(homeFragment, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeFragment.m359onCreate$lambda1(HomeFragment.this, (Boolean) obj);
                }
            });
            getHomeViewModel().getReferralCode().observe(homeFragment, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda17
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeFragment.m360onCreate$lambda2(HomeFragment.this, (String) obj);
                }
            });
            getHomeViewModel().getLastSynchronizedDate().observe(homeFragment, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda15
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeFragment.m361onCreate$lambda3(HomeFragment.this, (String) obj);
                }
            });
            HomeViewModel homeViewModel = getHomeViewModel();
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
            homeViewModel.getUserDetails(requireActivity2).observe(homeFragment, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda46
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeFragment.m362onCreate$lambda6(HomeFragment.this, (UserDetailsResponse) obj);
                }
            });
            getHomeViewModel().getScanSerialNo().observe(homeFragment, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeFragment.m364onCreate$lambda7(HomeFragment.this, (Boolean) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m358onCreate$lambda0(HomeFragment this$0, Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAdded() && event.getContentIfNotHandled() == HomeViewModel.Analytics.UPDATE_USER_PLAN_VALIDITY) {
            SegmentIdentityManager.Companion companion = SegmentIdentityManager.Companion;
            FragmentActivity requireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            companion.with(requireActivity).identifyPlanValidity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m359onCreate$lambda1(HomeFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._isTopupAllowed = it.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m360onCreate$lambda2(HomeFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._referralCode = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m361onCreate$lambda3(HomeFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((TextView) this$0._$_findCachedViewById(R.id.lastSynchronized)).setText(this$0.requireActivity().getString(R.string.last_synchronized_on) + SafeJsonPrimitive.NULL_CHAR + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-6  reason: not valid java name */
    public static final void m362onCreate$lambda6(final HomeFragment this$0, UserDetailsResponse userDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual((Object) userDetailsResponse.getStatus(), (Object) true)) {
            this$0.getHomeViewModel().getHomeNavigationState().observe(this$0, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda43
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeFragment.m363onCreate$lambda6$lambda5(HomeFragment.this, (HomeViewModel.HomeNavigationStates) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-6$lambda-5  reason: not valid java name */
    public static final void m363onCreate$lambda6$lambda5(final HomeFragment this$0, HomeViewModel.HomeNavigationStates homeNavigationStates) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (homeNavigationStates == null ? -1 : WhenMappings.$EnumSwitchMapping$0[homeNavigationStates.ordinal()]) {
            case 1:
                this$0.getHomeViewModel().checkKYCStatus();
                return;
            case 2:
                this$0.getHomeViewModel().checkPaymentStatus();
                return;
            case 3:
                if (this$0.isAdded()) {
                    this$0.navigateToSelectOrRechargePlan();
                    return;
                }
                return;
            case 4:
                if (this$0.isAdded()) {
                    this$0.showUploadKYCScreen();
                    return;
                }
                return;
            case 5:
                this$0.getHomeViewModel().checkInstallationStatus();
                return;
            case 6:
                this$0.getHomeViewModel().showHintView(R.drawable.ic_watch_later_white_150dp, "Your payment is complete and KYC Documents have been received. Our Delivery and Installation team would reach you shortly. (*T&C apply)", "Contact Us", "eKYC Documents Uploaded!", new Function0<Unit>() { // from class: com.livpure.safedrink.app.HomeFragment$onCreate$5$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        HomeFragment.this.showContactUsScreen();
                    }
                });
                return;
            case 7:
                if (this$0._isTopupAllowed) {
                    this$0.showAddLitesScreen();
                    return;
                } else {
                    UiUtilKt.getAlertCustomDialogWithHeaderAndMsg(this$0.requireActivity(), (ConstraintLayout) this$0._$_findCachedViewById(R.id.resetPasswordContainer), "", "Validity expired. Please recharge before Top Up");
                    return;
                }
            case 8:
                this$0.showRenewChangePlanScreen();
                return;
            case 9:
                this$0.showReferAndEarnScreen();
                return;
            case 10:
                this$0.discconnectBLE();
                this$0.setBluetooth(false);
                this$0.showBoltSettingsScreen();
                return;
            case 11:
                Intent intent = new Intent();
                if (LSApplication.Companion.getReferralLink() != null && !Intrinsics.areEqual(LSApplication.Companion.getReferralLink(), "")) {
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", "Refer & Earn\nGet instant ₹100 discount. Subscribe to Livpure Smart RO today.\nApply my code " + this$0._referralCode + " now and subscribe to pure drinking water at home.\nClick here to know more :- \n" + LSApplication.Companion.getReferralLink());
                    intent.setType(StringBody.CONTENT_TYPE);
                }
                this$0.startActivity(Intent.createChooser(intent, null));
                return;
            case 12:
                this$0.getHomeViewModel().hideHintView();
                this$0.getHomeViewModel().getDashboardDetails();
                if (this$0.isAdded()) {
                    Analytics.with(this$0.requireActivity()).screen("Dashboard");
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-7  reason: not valid java name */
    public static final void m364onCreate$lambda7(HomeFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!bool.booleanValue()) {
            if (this$0.firstLoad) {
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
                this$0.productTypeInfo();
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("LAST_LAUNCH_DATE", currentDate);
            edit.apply();
            String str = this$0.getHomeViewModel().get_productType();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (Intrinsics.areEqual(lowerCase, "bolt-waas-wifi-ble")) {
                return;
            }
            this$0.showSerialNumberDialog();
            return;
        }
        this$0.productTypeInfo();
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
            NavController findNavController = FragmentKt.findNavController(this);
            HomeFragmentDirections.ActionHomeFragmentToContactUsFragment actionHomeFragmentToContactUsFragment = HomeFragmentDirections.actionHomeFragmentToContactUsFragment(getHomeViewModel().getDeviceSerialNumber());
            Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToContactUsFragment, "actionHomeFragmentToCont…Model.deviceSerialNumber)");
            findNavController.navigate(actionHomeFragmentToContactUsFragment);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (isAdded()) {
            UiUtilKt.hideKeyboard(requireActivity());
        }
        getHomeViewModel().refreshHintView();
        String str = getHomeViewModel().get_productType();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, "bolt-waas-wifi-ble")) {
            this.handler = new Handler();
            ((ImageView) _$_findCachedViewById(R.id.wifiInfoIV)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R.id.settingsIV)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R.id.bleInfoIV)).setVisibility(0);
        } else {
            ((ImageView) _$_findCachedViewById(R.id.wifiInfoIV)).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R.id.settingsIV)).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R.id.bleInfoIV)).setVisibility(8);
        }
        String str2 = getHomeViewModel().get_productType();
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
        String lowerCase2 = str2.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase2, "zinger-copper-emi")) {
            ((Button) _$_findCachedViewById(R.id.renewSubscriptionButton)).setVisibility(8);
            ((Button) _$_findCachedViewById(R.id.addLitresButton)).setVisibility(8);
            ((Button) _$_findCachedViewById(R.id.makePayment)).setVisibility(8);
            ((Button) _$_findCachedViewById(R.id.makePaymentDiabled)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R.id.remainingWaterLabel)).setText(R.string.label_water_consumed);
        } else {
            ((Button) _$_findCachedViewById(R.id.renewSubscriptionButton)).setVisibility(0);
            ((Button) _$_findCachedViewById(R.id.addLitresButton)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R.id.remainingWaterLabel)).setText(R.string.label_water_remaining);
        }
        ((SwipeRefreshLayout) _$_findCachedViewById(R.id.swipe_refresh_layout_comments)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda24
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                HomeFragment.m365onViewCreated$lambda9(HomeFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-9  reason: not valid java name */
    public static final void m365onViewCreated$lambda9(final HomeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.getHomeViewModel().get_productType();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, "bolt-waas-wifi-ble")) {
            if (this$0.setBluetooth(true)) {
                Runnable runnable = new Runnable() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda40
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeFragment.m366onViewCreated$lambda9$lambda8(HomeFragment.this);
                    }
                };
                Handler handler = this$0.handler;
                Intrinsics.checkNotNull(handler);
                handler.postDelayed(runnable, 500L);
            }
        } else {
            this$0.getHomeViewModel().getDashboardDetails();
        }
        ((SwipeRefreshLayout) this$0._$_findCachedViewById(R.id.swipe_refresh_layout_comments)).setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-9$lambda-8  reason: not valid java name */
    public static final void m366onViewCreated$lambda9$lambda8(HomeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.setupBluetooth();
        } catch (Exception e) {
            Log.e(AgentHealth.DEFAULT_KEY, e.toString());
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentHomeBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        dataBinding.setViewModel(getHomeViewModel());
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
                getHomeViewModel().updateLocationDetails(String.valueOf(this.latitude), String.valueOf(this.longitude));
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
            task.addOnCompleteListener(requireActivity(), new OnCompleteListener() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda28
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    HomeFragment.m350checkGpsEnablePermission$lambda10(HomeFragment.this, task2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkGpsEnablePermission$lambda-10  reason: not valid java name */
    public static final void m350checkGpsEnablePermission$lambda10(HomeFragment this$0, Task task) {
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
                getHomeViewModel().updateLocationDetails(String.valueOf(this.latitude), String.valueOf(this.longitude));
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
                getHomeViewModel().updateLocationDetails(String.valueOf(this.latitude), String.valueOf(this.longitude));
            }
        }
    }

    /* compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/livpure/safedrink/app/HomeFragment$Companion;", "", "()V", "LOCATION_INTERVAL", "", "LOCATION_PERMISSION", "", "LOCATION_SETTING_PERMISSION", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void showUploadKYCScreen() {
        User user = LSApplication.Companion.getUser();
        if (Intrinsics.areEqual(user != null ? user.getRelocation_status() : null, "1")) {
            NavDirections actionHomeFragmentToKycUpload = HomeFragmentDirections.actionHomeFragmentToKycUpload();
            Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToKycUpload, "actionHomeFragmentToKycUpload()");
            navigate(actionHomeFragmentToKycUpload);
            return;
        }
        HomeFragmentDirections.ActionHomeFragmentToUploadKYCFragment actionHomeFragmentToUploadKYCFragment = HomeFragmentDirections.actionHomeFragmentToUploadKYCFragment(requireActivity().getString(R.string.empty_payment_id));
        Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToUploadKYCFragment, "actionHomeFragmentToUplo…string.empty_payment_id))");
        navigate(actionHomeFragmentToUploadKYCFragment);
    }

    private final void navigateToSelectOrRechargePlan() {
        HomeFragmentDirections.ActionHomeFragmentToSelectPlanChargeFragment actionHomeFragmentToSelectPlanChargeFragment;
        DeviceList deviceList = getHomeViewModel().get_device();
        if (deviceList == null || (actionHomeFragmentToSelectPlanChargeFragment = HomeFragmentDirections.actionHomeFragmentToSelectPlanChargeFragment(deviceList)) == null) {
            return;
        }
        navigate(actionHomeFragmentToSelectPlanChargeFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showContactUsScreen() {
        HomeFragmentDirections.ActionHomeFragmentToContactUsFragment actionHomeFragmentToContactUsFragment = HomeFragmentDirections.actionHomeFragmentToContactUsFragment(getHomeViewModel().getDeviceSerialNumber());
        Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToContactUsFragment, "actionHomeFragmentToCont…Model.deviceSerialNumber)");
        navigate(actionHomeFragmentToContactUsFragment);
    }

    private final void showAddLitesScreen() {
        HomeFragmentDirections.ActionHomeFragmentToAddLitresFragment actionHomeFragmentToAddLitresFragment;
        DeviceList deviceList = getHomeViewModel().get_device();
        if (deviceList == null || (actionHomeFragmentToAddLitresFragment = HomeFragmentDirections.actionHomeFragmentToAddLitresFragment(deviceList)) == null) {
            return;
        }
        navigate(actionHomeFragmentToAddLitresFragment);
    }

    private final void showReferAndEarnScreen() {
        NavDirections actionHomeFragmentToReferAndEarnFragment = HomeFragmentDirections.actionHomeFragmentToReferAndEarnFragment();
        Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToReferAndEarnFragment, "actionHomeFragmentToReferAndEarnFragment()");
        navigate(actionHomeFragmentToReferAndEarnFragment);
    }

    private final void showBoltSettingsScreen() {
        HomeFragmentDirections.ActionHomeFragmentToBoltSettingsFragment actionHomeFragmentToBoltSettingsFragment;
        DeviceList deviceList = getHomeViewModel().get_device();
        if (deviceList == null || (actionHomeFragmentToBoltSettingsFragment = HomeFragmentDirections.actionHomeFragmentToBoltSettingsFragment(deviceList)) == null) {
            return;
        }
        navigate(actionHomeFragmentToBoltSettingsFragment);
    }

    private final void showRenewChangePlanScreen() {
        HomeFragmentDirections.ActionHomeFragmentToSelectPlanChargeFragment actionHomeFragmentToSelectPlanChargeFragment;
        DeviceList deviceList = getHomeViewModel().get_device();
        if (deviceList == null || (actionHomeFragmentToSelectPlanChargeFragment = HomeFragmentDirections.actionHomeFragmentToSelectPlanChargeFragment(deviceList)) == null) {
            return;
        }
        navigate(actionHomeFragmentToSelectPlanChargeFragment);
    }

    private final void navigate(NavDirections navDirections) {
        try {
            discconnectBLE();
            FragmentKt.findNavController(this).navigate(navDirections);
        } catch (Exception e) {
            Log.e(AgentHealth.DEFAULT_KEY, e.toString());
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
        getHomeViewModel().getBleImageOff().observe(this, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.m349bleOFF$lambda19(HomeFragment.this, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bleOFF$lambda-19  reason: not valid java name */
    public static final void m349bleOFF$lambda19(HomeFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateBleWiFiImage(it.intValue(), "BLE");
    }

    private final void setupBluetooth() {
        getHomeViewModel().getConnectivity().observe(this, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda18
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.m373setupBluetooth$lambda22(HomeFragment.this, (String) obj);
            }
        });
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s-%s", Arrays.copyOf(new Object[]{"LIVSMT-RO", StringsKt.takeLast(getHomeViewModel().getImeiNo(), 4)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        this.macIdAdd = format;
        this.listBluetoothDevice = new ArrayList<>();
        this.mHandler = new Handler();
        getBluetoothAdapter();
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        Boolean valueOf = bluetoothAdapter != null ? Boolean.valueOf(bluetoothAdapter.isEnabled()) : null;
        Intrinsics.checkNotNull(valueOf);
        if (!valueOf.booleanValue()) {
            Intent intent = new Intent(getActivity(), "android.bluetooth.adapter.action.REQUEST_ENABLE".getClass());
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.startActivity(intent);
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
    /* renamed from: setupBluetooth$lambda-22  reason: not valid java name */
    public static final void m373setupBluetooth$lambda22(final HomeFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(str, "bluetooth")) {
            this$0.getHomeViewModel().getBleImage().observe(this$0, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda12
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeFragment.m374setupBluetooth$lambda22$lambda20(HomeFragment.this, (Integer) obj);
                }
            });
        } else {
            this$0.getHomeViewModel().getWifiImage().observe(this$0, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda5
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeFragment.m375setupBluetooth$lambda22$lambda21(HomeFragment.this, (Integer) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupBluetooth$lambda-22$lambda-20  reason: not valid java name */
    public static final void m374setupBluetooth$lambda22$lambda20(HomeFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateBleWiFiImage(it.intValue(), "BLE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupBluetooth$lambda-22$lambda-21  reason: not valid java name */
    public static final void m375setupBluetooth$lambda22$lambda21(HomeFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateBleWiFiImage(it.intValue(), "WIFI");
    }

    private final void setupDashboard() {
        HomeFragment homeFragment = this;
        getHomeViewModel().getWaterRemaining().observe(homeFragment, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda20
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.m376setupDashboard$lambda23(HomeFragment.this, (Pair) obj);
            }
        });
        getHomeViewModel().getHardwareUpdate().observe(homeFragment, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.m377setupDashboard$lambda24(HomeFragment.this, (Boolean) obj);
            }
        });
        getHomeViewModel().getSoftwareUpdate().observe(homeFragment, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.m378setupDashboard$lambda25(HomeFragment.this, (Boolean) obj);
            }
        });
        getHomeViewModel().getPlanDetails().observe(homeFragment, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.m379setupDashboard$lambda26(HomeFragment.this, (String) obj);
            }
        });
        getHomeViewModel().getFilterLifeImage().observe(homeFragment, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.m380setupDashboard$lambda27(HomeFragment.this, (Integer) obj);
            }
        });
        getHomeViewModel().getHardwareVersion().observe(homeFragment, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda13
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.m381setupDashboard$lambda28(HomeFragment.this, (String) obj);
            }
        });
        getHomeViewModel().getSoftwareVersion().observe(homeFragment, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda16
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.m382setupDashboard$lambda29(HomeFragment.this, (String) obj);
            }
        });
        getHomeViewModel().getProductType().observe(homeFragment, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda19
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.m383setupDashboard$lambda30(HomeFragment.this, (String) obj);
            }
        });
        getHomeViewModel().getUsageStats().observe(homeFragment, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda21
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.m384setupDashboard$lambda31(HomeFragment.this, (Triple) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-23  reason: not valid java name */
    public static final void m376setupDashboard$lambda23(HomeFragment this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (((String) pair.getFirst()).length() != 5 || pair.getSecond() == null) {
            return;
        }
        Object second = pair.getSecond();
        Intrinsics.checkNotNull(second);
        this$0.updateWaterRemainingView((String) pair.getFirst(), ((Number) second).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-24  reason: not valid java name */
    public static final void m377setupDashboard$lambda24(HomeFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boolean booleanValue = it.booleanValue();
        this$0._isHardwareUpdate = booleanValue;
        if (booleanValue) {
            this$0._isFirmwareUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-25  reason: not valid java name */
    public static final void m378setupDashboard$lambda25(HomeFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boolean booleanValue = it.booleanValue();
        this$0._isSoftwareUpdate = booleanValue;
        if (booleanValue) {
            this$0._isFirmwareUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-26  reason: not valid java name */
    public static final void m379setupDashboard$lambda26(HomeFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return;
        }
        ((TextView) this$0._$_findCachedViewById(R.id.planDetails)).setText(str2);
        if (this$0.isAdded()) {
            UserRepository.Companion companion = UserRepository.Companion;
            FragmentActivity requireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            companion.getInstance(requireActivity).setUser(LSApplication.Companion.getUser());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-27  reason: not valid java name */
    public static final void m380setupDashboard$lambda27(HomeFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null && it.intValue() == -1) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateFilterLifeImage(it.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-28  reason: not valid java name */
    public static final void m381setupDashboard$lambda28(HomeFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._hardwareVersion = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-29  reason: not valid java name */
    public static final void m382setupDashboard$lambda29(HomeFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0._softwareVersion = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-30  reason: not valid java name */
    public static final void m383setupDashboard$lambda30(HomeFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = str.toString();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = str2.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, "bolt-waas-wifi-ble")) {
            ((ImageView) this$0._$_findCachedViewById(R.id.wifiInfoIV)).setVisibility(0);
            ((ImageView) this$0._$_findCachedViewById(R.id.settingsIV)).setVisibility(0);
            ((ImageView) this$0._$_findCachedViewById(R.id.bleInfoIV)).setVisibility(0);
        } else {
            ((ImageView) this$0._$_findCachedViewById(R.id.wifiInfoIV)).setVisibility(8);
            ((ImageView) this$0._$_findCachedViewById(R.id.settingsIV)).setVisibility(8);
            ((ImageView) this$0._$_findCachedViewById(R.id.bleInfoIV)).setVisibility(8);
        }
        String str3 = str.toString();
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
        String lowerCase2 = str3.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase2, "zinger-copper-emi")) {
            ((Button) this$0._$_findCachedViewById(R.id.renewSubscriptionButton)).setVisibility(8);
            ((Button) this$0._$_findCachedViewById(R.id.addLitresButton)).setVisibility(8);
            ((Button) this$0._$_findCachedViewById(R.id.makePayment)).setVisibility(8);
            ((Button) this$0._$_findCachedViewById(R.id.makePaymentDiabled)).setVisibility(0);
            ((TextView) this$0._$_findCachedViewById(R.id.remainingWaterLabel)).setText(R.string.label_water_consumed);
            return;
        }
        ((Button) this$0._$_findCachedViewById(R.id.renewSubscriptionButton)).setVisibility(0);
        ((Button) this$0._$_findCachedViewById(R.id.addLitresButton)).setVisibility(0);
        ((TextView) this$0._$_findCachedViewById(R.id.remainingWaterLabel)).setText(R.string.label_water_remaining);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDashboard$lambda-31  reason: not valid java name */
    public static final void m384setupDashboard$lambda31(HomeFragment this$0, Triple triple) {
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
        ((Button) dialog.findViewById(R.id.submitButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment.m392showSerialNumberDialog$lambda37(HomeFragment.this, dialog, view);
            }
        });
        ((TextView) dialog.findViewById(R.id.noThanksButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment.m393showSerialNumberDialog$lambda38(dialog, this, view);
            }
        });
        dialog.show();
        dialog.setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showSerialNumberDialog$lambda-37  reason: not valid java name */
    public static final void m392showSerialNumberDialog$lambda37(HomeFragment this$0, Dialog dialog, View view) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showSerialNumberDialog$lambda-38  reason: not valid java name */
    public static final void m393showSerialNumberDialog$lambda38(Dialog dialog, HomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        this$0.productTypeInfo();
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
        codeScanner.setDecodeCallback(new DecodeCallback() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda27
            @Override // com.budiyev.android.codescanner.DecodeCallback
            public final void onDecoded(Result result) {
                HomeFragment.m385showCameraDialog$lambda42(HomeFragment.this, dialog, result);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment.m387showCameraDialog$lambda43(dialog, this, view);
            }
        });
        dialog.show();
        dialog.setCancelable(false);
        new Handler().postDelayed(new Runnable() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.m388showCameraDialog$lambda44(HomeFragment.this);
            }
        }, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showCameraDialog$lambda-42  reason: not valid java name */
    public static final void m385showCameraDialog$lambda42(final HomeFragment this$0, final Dialog dialog, final Result it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda29
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.m386showCameraDialog$lambda42$lambda41(dialog, this$0, it);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showCameraDialog$lambda-42$lambda-41  reason: not valid java name */
    public static final void m386showCameraDialog$lambda42$lambda41(Dialog dialog, HomeFragment this$0, Result it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        dialog.dismiss();
        String text = it.getText();
        Intrinsics.checkNotNullExpressionValue(text, "it.text");
        String matchDetails$default = matchDetails$default(this$0, text, "=", 0, 4, null);
        if (matchDetails$default.length() == 14) {
            this$0.getHomeViewModel().getSerialNumberStatus(matchDetails$default);
            dialog.dismiss();
            this$0.productTypeInfo();
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
    /* renamed from: showCameraDialog$lambda-43  reason: not valid java name */
    public static final void m387showCameraDialog$lambda43(Dialog dialog, HomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        this$0.productTypeInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showCameraDialog$lambda-44  reason: not valid java name */
    public static final void m388showCameraDialog$lambda44(HomeFragment this$0) {
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

    static /* synthetic */ String matchDetails$default(HomeFragment homeFragment, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return homeFragment.matchDetails(str, str2, i);
    }

    private final String matchDetails(String str, String str2, int i) {
        String str3 = str;
        return StringsKt.indexOf$default((CharSequence) str3, str2, i, false, 4, (Object) null) >= 0 ? (String) StringsKt.split$default((CharSequence) str3, new String[]{str2}, false, 0, 6, (Object) null).get(1) : str;
    }

    private final void productTypeInfo() {
        String str = getHomeViewModel().get_productType();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, "bolt-waas-wifi-ble") && setBluetooth(true) && setBluetooth(true)) {
            Runnable runnable = new Runnable() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda36
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.m367productTypeInfo$lambda45(HomeFragment.this);
                }
            };
            Handler handler = this.handler;
            Intrinsics.checkNotNull(handler);
            handler.postDelayed(runnable, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: productTypeInfo$lambda-45  reason: not valid java name */
    public static final void m367productTypeInfo$lambda45(HomeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.setupBluetooth();
        } catch (Exception e) {
            Log.e(AgentHealth.DEFAULT_KEY, e.toString());
        }
    }

    private final void getBluetoothAdapter() {
        FragmentActivity activity = getActivity();
        Object systemService = activity != null ? activity.getSystemService("bluetooth") : null;
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
            ArrayList<BluetoothDevice> arrayList = this.listBluetoothDevice;
            Intrinsics.checkNotNull(arrayList);
            arrayList.clear();
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.postDelayed(new Runnable() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda31
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeFragment.m369scanLeDevice$lambda46(HomeFragment.this);
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
            ArrayList<BluetoothDevice> arrayList2 = this.listBluetoothDevice;
            Intrinsics.checkNotNull(arrayList2);
            arrayList2.clear();
            Handler handler2 = this.mHandler;
            if (handler2 != null) {
                handler2.postDelayed(new Runnable() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda38
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeFragment.m370scanLeDevice$lambda47(HomeFragment.this);
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
    /* renamed from: scanLeDevice$lambda-46  reason: not valid java name */
    public static final void m369scanLeDevice$lambda46(HomeFragment this$0) {
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
        }
        this$0.mScanning = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scanLeDevice$lambda-47  reason: not valid java name */
    public static final void m370scanLeDevice$lambda47(HomeFragment this$0) {
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
        Log.e("Address : ", bluetoothDevice.getAddress());
        if (isAdded()) {
            if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                if (bluetoothDevice.getName() != null) {
                    Log.e("Name", bluetoothDevice.getAddress());
                    String name = bluetoothDevice.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "device.name");
                    if (StringsKt.startsWith$default(name, "LIVSMT-RO", false, 2, (Object) null)) {
                        Log.e("name", bluetoothDevice.getName());
                        this.mBleConnected = true;
                        if (StringsKt.equals(this.macIdAdd, bluetoothDevice.getName(), true)) {
                            getHomeViewModel().getBleImage().observe(this, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda8
                                @Override // androidx.lifecycle.Observer
                                public final void onChanged(Object obj) {
                                    HomeFragment.m347addBluetoothDevice$lambda48(HomeFragment.this, (Integer) obj);
                                }
                            });
                            this.mBleConnected = true;
                            this.mDeviceAddress = bluetoothDevice.getAddress();
                            this.mDeviceName = bluetoothDevice.getName();
                            Intent intent = new Intent(getActivity(), BluetoothLeService.class);
                            FragmentActivity activity = getActivity();
                            if (activity != null) {
                                activity.bindService(intent, this.mServiceConnection, 1);
                            }
                        }
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 31) {
                ActivityCompat.requestPermissions(requireActivity(), this.android12BlePermission, 2);
            } else if (bluetoothDevice.getName() != null) {
                Log.e("Name", bluetoothDevice.getAddress());
                String name2 = bluetoothDevice.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "device.name");
                if (StringsKt.startsWith$default(name2, "LIVSMT-RO", false, 2, (Object) null)) {
                    Log.e("name", bluetoothDevice.getName());
                    this.mBleConnected = true;
                    if (StringsKt.equals(this.macIdAdd, bluetoothDevice.getName(), true)) {
                        getHomeViewModel().getBleImage().observe(this, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda6
                            @Override // androidx.lifecycle.Observer
                            public final void onChanged(Object obj) {
                                HomeFragment.m348addBluetoothDevice$lambda49(HomeFragment.this, (Integer) obj);
                            }
                        });
                        this.mBleConnected = true;
                        this.mDeviceAddress = bluetoothDevice.getAddress();
                        this.mDeviceName = bluetoothDevice.getName();
                        Intent intent2 = new Intent(getActivity(), BluetoothLeService.class);
                        FragmentActivity activity2 = getActivity();
                        if (activity2 != null) {
                            activity2.bindService(intent2, this.mServiceConnection, 1);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addBluetoothDevice$lambda-48  reason: not valid java name */
    public static final void m347addBluetoothDevice$lambda48(HomeFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateBleWiFiImage(it.intValue(), "BLE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addBluetoothDevice$lambda-49  reason: not valid java name */
    public static final void m348addBluetoothDevice$lambda49(HomeFragment this$0, Integer it) {
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
                        BluetoothLeService bluetoothLeService2 = this.mBluetoothLeService;
                        Intrinsics.checkNotNull(bluetoothLeService2);
                        bluetoothLeService2.readCharacteristic(bluetoothGattCharacteristic);
                    }
                    if ((properties | 16) > 0) {
                        this.mNotifyCharacteristic = bluetoothGattCharacteristic;
                        Log.e(" status :", "characteristics notification set");
                        BluetoothLeService bluetoothLeService3 = this.mBluetoothLeService;
                        Intrinsics.checkNotNull(bluetoothLeService3);
                        bluetoothLeService3.setCharacteristicNotification(bluetoothGattCharacteristic, true);
                    }
                    if ((properties & 8) > 0) {
                        Log.e("mwc initialised", "BluetoothGattCharacteristic has PROPERTY_WRITE | PROPERTY_WRITE_WITH_RESPONSE");
                        this.mWriteCharacteristic = bluetoothGattCharacteristic;
                    }
                    arrayList3.add(hashMap2);
                }
                arrayList2.add(arrayList3);
            } else {
                Log.e("Disconnect", "disconnect");
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.registerReceiver(this.mGattUpdateReceiver, makeGattUpdateIntentFilter());
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.unregisterReceiver(this.mGattUpdateReceiver);
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
            Log.e(AgentHealth.DEFAULT_KEY, e.toString());
        }
        try {
            getHomeViewModel().getBleImage().observe(this, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda7
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeFragment.m351displayData$lambda50(HomeFragment.this, (Integer) obj);
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
            this.myScanRunnable = new Runnable() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda34
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.m352displayData$lambda51(HomeFragment.this);
                }
            };
            Handler handler2 = this.handler;
            Intrinsics.checkNotNull(handler2);
            Runnable runnable2 = this.myScanRunnable;
            Intrinsics.checkNotNull(runnable2);
            handler2.postDelayed(runnable2, 500L);
        } catch (Exception unused) {
            this.myScanRunnable = new Runnable() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.m353displayData$lambda52(HomeFragment.this);
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
    /* renamed from: displayData$lambda-50  reason: not valid java name */
    public static final void m351displayData$lambda50(HomeFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.updateBleWiFiImage(it.intValue(), "BLE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: displayData$lambda-51  reason: not valid java name */
    public static final void m352displayData$lambda51(HomeFragment this$0) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: displayData$lambda-52  reason: not valid java name */
    public static final void m353displayData$lambda52(HomeFragment this$0) {
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
        LiveData<Boolean> submissionBLEStatus = getHomeViewModel().getSubmissionBLEStatus(str, "");
        if (submissionBLEStatus != null) {
            submissionBLEStatus.observe(this, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda23
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeFragment.m368reqularPacket$lambda53(HomeFragment.this, boldBleData, (Boolean) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reqularPacket$lambda-53  reason: not valid java name */
    public static final void m368reqularPacket$lambda53(HomeFragment this$0, BoldBleData boldBleData, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAdded()) {
            if (this$0.bleCommandList.size() > 0) {
                String str = this$0.bleCommandList.get(0);
                Intrinsics.checkNotNullExpressionValue(str, "bleCommandList[0]");
                this$0.sendToBLEJsonData(str);
                this$0.bleCommandList.remove(0);
            } else if (boldBleData.getFlowRate() != null) {
                this$0.BLE_STATUS_PACKET_RECEIVED = true;
                this$0.getHomeViewModel().getDashboardDetails();
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
            Log.e("check", "in writeC called ");
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

    private final void sendToBLEJsonData(String str) {
        try {
            byte[] hexStringToByteArray = Encrypt.hexStringToByteArray(Encrypt.encrypt(str, AppConstants.BEL_ENC_KEY));
            Intrinsics.checkNotNullExpressionValue(hexStringToByteArray, "hexStringToByteArray(encriptedData)");
            Log.e("Return Hex Data:----", Encrypt.byteArrayToHexString(hexStringToByteArray));
            if (Intrinsics.areEqual(publishToDevice(hexStringToByteArray), "succes")) {
                this.myScanRunnable = new Runnable() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda37
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeFragment.m371sendToBLEJsonData$lambda58(HomeFragment.this);
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
    /* renamed from: sendToBLEJsonData$lambda-58  reason: not valid java name */
    public static final void m371sendToBLEJsonData$lambda58(HomeFragment this$0) {
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
                this.myScanRunnable = new Runnable() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda39
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeFragment.m372sendToBLEJsonData$lambda59(HomeFragment.this);
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
    /* renamed from: sendToBLEJsonData$lambda-59  reason: not valid java name */
    public static final void m372sendToBLEJsonData$lambda59(HomeFragment this$0) {
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
        getHomeViewModel().getPendingBleCommand().observe(this, new Observer() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda44
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.m354getCommandList$lambda60(HomeFragment.this, (BoltCommandsResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCommandList$lambda-60  reason: not valid java name */
    public static final void m354getCommandList$lambda60(HomeFragment this$0, BoltCommandsResponse it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAdded()) {
            this$0.bleCommandList.clear();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.boltCommandsResponse = it;
            ArrayList<String> arrayList = this$0.bleCommandList;
            BoltCommandsResponse boltCommandsResponse = null;
            if (it == null) {
                Intrinsics.throwUninitializedPropertyAccessException("boltCommandsResponse");
                it = null;
            }
            arrayList.add(it.getRTC_Time());
            BoltCommandsResponse boltCommandsResponse2 = this$0.boltCommandsResponse;
            if (boltCommandsResponse2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("boltCommandsResponse");
                boltCommandsResponse2 = null;
            }
            List<RechargeResponse> rechargeCommands = boltCommandsResponse2.getRechargeCommands();
            Integer valueOf = rechargeCommands != null ? Integer.valueOf(rechargeCommands.size()) : null;
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.intValue() > 0) {
                int i = 0;
                while (true) {
                    BoltCommandsResponse boltCommandsResponse3 = this$0.boltCommandsResponse;
                    if (boltCommandsResponse3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("boltCommandsResponse");
                        boltCommandsResponse3 = null;
                    }
                    List<RechargeResponse> rechargeCommands2 = boltCommandsResponse3.getRechargeCommands();
                    Integer valueOf2 = rechargeCommands2 != null ? Integer.valueOf(rechargeCommands2.size()) : null;
                    Intrinsics.checkNotNull(valueOf2);
                    if (i >= valueOf2.intValue()) {
                        break;
                    }
                    ArrayList<String> arrayList2 = this$0.bleCommandList;
                    BoltCommandsResponse boltCommandsResponse4 = this$0.boltCommandsResponse;
                    if (boltCommandsResponse4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("boltCommandsResponse");
                        boltCommandsResponse4 = null;
                    }
                    List<RechargeResponse> rechargeCommands3 = boltCommandsResponse4.getRechargeCommands();
                    Intrinsics.checkNotNull(rechargeCommands3);
                    arrayList2.add(rechargeCommands3.get(i).getRechargeList());
                    i++;
                }
            }
            BoltCommandsResponse boltCommandsResponse5 = this$0.boltCommandsResponse;
            if (boltCommandsResponse5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("boltCommandsResponse");
            } else {
                boltCommandsResponse = boltCommandsResponse5;
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
                if (this$0.BLE_STATUS_PACKET_RECEIVED) {
                    String str = this$0.bleCommandList.get(0);
                    Intrinsics.checkNotNullExpressionValue(str, "bleCommandList[0]");
                    this$0.sendToBLEJsonData(str);
                    this$0.bleCommandList.remove(0);
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
            this.myFirmwareUpdateRunnable = new Runnable() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda32
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.m357getFirmwareNextData$lambda61(HomeFragment.this);
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
    /* renamed from: getFirmwareNextData$lambda-61  reason: not valid java name */
    public static final void m357getFirmwareNextData$lambda61(HomeFragment this$0) {
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
        final Response.Listener listener = new Response.Listener() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda26
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                HomeFragment.m355getFirmwareData$lambda62(progressDialog, this, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda25
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                HomeFragment.m356getFirmwareData$lambda63(progressDialog, this, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(listener, errorListener) { // from class: com.livpure.safedrink.app.HomeFragment$getFirmwareData$stringRequest$1
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
    /* renamed from: getFirmwareData$lambda-62  reason: not valid java name */
    public static final void m355getFirmwareData$lambda62(ProgressDialog dialog, HomeFragment this$0, String str) {
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
    /* renamed from: getFirmwareData$lambda-63  reason: not valid java name */
    public static final void m356getFirmwareData$lambda63(ProgressDialog dialog, HomeFragment this$0, VolleyError volleyError) {
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
        button.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment.m389showFirmwareUpdateDialog$lambda65(button, linearLayout, textView, button2, textView2, this, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment.m390showFirmwareUpdateDialog$lambda66(HomeFragment.this, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.HomeFragment$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment.m391showFirmwareUpdateDialog$lambda67(HomeFragment.this, view);
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
    /* renamed from: showFirmwareUpdateDialog$lambda-65  reason: not valid java name */
    public static final void m389showFirmwareUpdateDialog$lambda65(Button button, LinearLayout linearLayout, TextView textView, Button button2, TextView textView2, HomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        button.setVisibility(8);
        linearLayout.setVisibility(0);
        textView.setVisibility(8);
        button2.setVisibility(0);
        textView2.setText("The firmware is being updated, please do not turn off the RO, do not close the app, make sure phone is near the RO");
        this$0.sendToBLEJsonData(this$0.firmwareParts.get(0), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showFirmwareUpdateDialog$lambda-66  reason: not valid java name */
    public static final void m390showFirmwareUpdateDialog$lambda66(HomeFragment this$0, View view) {
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
    /* renamed from: showFirmwareUpdateDialog$lambda-67  reason: not valid java name */
    public static final void m391showFirmwareUpdateDialog$lambda67(HomeFragment this$0, View view) {
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
