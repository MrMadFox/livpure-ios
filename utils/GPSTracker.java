package com.livpure.safedrink.utils;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.facebook.applinks.AppLinkData;
import com.google.firebase.perf.metrics.resource.ResourceType;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GPSTracker.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u000bJ\n\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0002J\u0006\u0010\u0014\u001a\u00020\u000bJ\b\u0010\u0015\u001a\u00020\u0016H\u0003J\b\u0010\u0017\u001a\u00020\u0016H\u0003J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0016J \u0010\"\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0006\u0010'\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/livpure/safedrink/utils/GPSTracker;", "Landroid/app/Service;", "Landroid/location/LocationListener;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "canGetLocation", "", "isGPSEnabled", "isNetworkEnabled", "latitude", "", "Ljava/lang/Double;", "locationManager", "Landroid/location/LocationManager;", "locationObj", "Landroid/location/Location;", "longitude", "getLatitude", "getLocation", "getLongitude", "gprsEnabled", "", "netWorkEnables", "onBind", "Landroid/os/IBinder;", "arg0", "Landroid/content/Intent;", "onLocationChanged", "location", "onProviderDisabled", "provider", "", "onProviderEnabled", "onStatusChanged", "status", "", AppLinkData.ARGUMENTS_EXTRAS_KEY, "Landroid/os/Bundle;", "stopUsingGPS", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class GPSTracker extends Service implements LocationListener {
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 60000;
    private boolean canGetLocation;
    private boolean isGPSEnabled;
    private boolean isNetworkEnabled;
    private Double latitude;
    private LocationManager locationManager;
    private Location locationObj;
    private Double longitude;
    private final Context mContext;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "GPSTracker";

    @Override // android.app.Service
    public IBinder onBind(Intent arg0) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        return null;
    }

    public GPSTracker(Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        Double valueOf = Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.latitude = valueOf;
        this.longitude = valueOf;
        getLocation();
    }

    private final Location getLocation() {
        Object systemService;
        try {
            systemService = this.mContext.getSystemService("location");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
        }
        LocationManager locationManager = (LocationManager) systemService;
        this.locationManager = locationManager;
        Intrinsics.checkNotNull(locationManager);
        this.isGPSEnabled = locationManager.isProviderEnabled("gps");
        LocationManager locationManager2 = this.locationManager;
        Intrinsics.checkNotNull(locationManager2);
        boolean isProviderEnabled = locationManager2.isProviderEnabled(AndroidContextPlugin.NETWORK_KEY);
        this.isNetworkEnabled = isProviderEnabled;
        boolean z = this.isGPSEnabled;
        if (z || isProviderEnabled) {
            if (z) {
                gprsEnabled();
            }
            if (this.isNetworkEnabled) {
                netWorkEnables();
            }
        }
        return this.locationObj;
    }

    private final void gprsEnabled() {
        if (this.locationObj == null) {
            LocationManager locationManager = this.locationManager;
            Intrinsics.checkNotNull(locationManager);
            locationManager.requestLocationUpdates("gps", 60000L, 10.0f, this);
            Log.d("GPS Enabled", "GPS Enabled");
            LocationManager locationManager2 = this.locationManager;
            if (locationManager2 != null) {
                Intrinsics.checkNotNull(locationManager2);
                Location lastKnownLocation = locationManager2.getLastKnownLocation("gps");
                this.locationObj = lastKnownLocation;
                if (lastKnownLocation != null) {
                    this.canGetLocation = true;
                    Intrinsics.checkNotNull(lastKnownLocation);
                    this.latitude = Double.valueOf(lastKnownLocation.getLatitude());
                    Location location = this.locationObj;
                    Intrinsics.checkNotNull(location);
                    this.longitude = Double.valueOf(location.getLongitude());
                }
            }
        }
    }

    private final void netWorkEnables() {
        LocationManager locationManager = this.locationManager;
        Intrinsics.checkNotNull(locationManager);
        locationManager.requestLocationUpdates(AndroidContextPlugin.NETWORK_KEY, 60000L, 10.0f, this);
        Log.d(ResourceType.NETWORK, ResourceType.NETWORK);
        LocationManager locationManager2 = this.locationManager;
        if (locationManager2 != null) {
            Intrinsics.checkNotNull(locationManager2);
            Location lastKnownLocation = locationManager2.getLastKnownLocation(AndroidContextPlugin.NETWORK_KEY);
            this.locationObj = lastKnownLocation;
            if (lastKnownLocation != null) {
                this.canGetLocation = true;
                Intrinsics.checkNotNull(lastKnownLocation);
                this.latitude = Double.valueOf(lastKnownLocation.getLatitude());
                Location location = this.locationObj;
                Intrinsics.checkNotNull(location);
                this.longitude = Double.valueOf(location.getLongitude());
            }
        }
    }

    public final void stopUsingGPS() {
        LocationManager locationManager = this.locationManager;
        if (locationManager != null) {
            Intrinsics.checkNotNull(locationManager);
            locationManager.removeUpdates(this);
        }
    }

    public final double getLatitude() {
        Location location = this.locationObj;
        if (location != null) {
            this.latitude = location != null ? Double.valueOf(location.getLatitude()) : null;
        }
        Double d = this.latitude;
        Intrinsics.checkNotNull(d);
        return d.doubleValue();
    }

    public final double getLongitude() {
        Location location = this.locationObj;
        if (location != null) {
            Intrinsics.checkNotNull(location);
            this.longitude = Double.valueOf(location.getLongitude());
        }
        Double d = this.longitude;
        Intrinsics.checkNotNull(d);
        return d.doubleValue();
    }

    public final boolean canGetLocation() {
        return this.canGetLocation;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.locationObj = location;
        this.canGetLocation = true;
        getLatitude();
        getLongitude();
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Log.i(TAG, "onProviderDisabled");
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Log.i(TAG, "onProviderEnabled");
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String provider, int i, Bundle extras) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Log.i(TAG, "onStatusChanged");
    }

    /* compiled from: GPSTracker.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/utils/GPSTracker$Companion;", "", "()V", "MIN_DISTANCE_CHANGE_FOR_UPDATES", "", "MIN_TIME_BW_UPDATES", "TAG", "", "kotlin.jvm.PlatformType", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
