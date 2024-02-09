package com.livpure.safedrink.serviceRequest.view;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.LSHConfig;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentRaiseServiceRequestBinding;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.serviceRequest.data.model.CustomerVoiceResponse;
import com.livpure.safedrink.serviceRequest.data.model.RefreshRechargeResponse;
import com.livpure.safedrink.serviceRequest.data.model.WAASReasonResList;
import com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.logging.Logger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.JsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: RaiseServiceRequestFragment.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0013H\u0002J\b\u0010-\u001a\u00020*H\u0002J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u0005H\u0002J\b\u00100\u001a\u00020*H\u0002J\u0010\u00101\u001a\u00020*2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u00102\u001a\u00020*H\u0002J\b\u00103\u001a\u00020*H\u0002J\u000e\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020\u0005J\b\u00106\u001a\u00020*H\u0002J\u0014\u00107\u001a\u0004\u0018\u00010\u00052\b\u00108\u001a\u0004\u0018\u000109H\u0002J\b\u0010:\u001a\u00020\u0011H\u0014J\b\u0010;\u001a\u00020<H\u0014J\u0012\u0010=\u001a\u00020*2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\b\u0010@\u001a\u00020*H\u0016J\u001a\u0010A\u001a\u00020*2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0006\u0010F\u001a\u00020*J\b\u0010G\u001a\u00020*H\u0002J\b\u0010H\u001a\u00020*H\u0002J\b\u0010I\u001a\u00020*H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u000e\u0010#\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/view/RaiseServiceRequestFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentRaiseServiceRequestBinding;", "()V", "_appintmentDateTime", "", "cancelrequestList", "Ljava/util/ArrayList;", "cancelrequestList_ID", "getCancelrequestList_ID", "()Ljava/util/ArrayList;", "cancelrequestSubList", "cancelrequestSubList_ID", "getCancelrequestSubList_ID", "createDate", "dataBinding", "dateSelected", "", "isOtpVerify", "", "isReason", "isResend", "isShowOtp", "navArgs", "Lcom/livpure/safedrink/serviceRequest/view/RaiseServiceRequestFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/serviceRequest/view/RaiseServiceRequestFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "raiseServiceRequestModel", "Lcom/livpure/safedrink/serviceRequest/model/RaiseServiceRequestModel;", "getRaiseServiceRequestModel", "()Lcom/livpure/safedrink/serviceRequest/model/RaiseServiceRequestModel;", "raiseServiceRequestModel$delegate", "Lkotlin/Lazy;", "reference_id", "selectedReasonID", "selectedSubReasonID", "serviceRequestReason", "serviceRequestSubReason", "timeSelected", "DisplayDialog", "", "job_Description", "isJobSupport", "DisplayErrorDialog", "OTPVerification", "otp", "ValidateData", "bindVariablesToView", "callCustomerSupportApiReason", "callCustomerSupportApiSubReason", "cancelSubscrptionReasion", "reasonID", "customeDatePicker", "getDateInUTC", "date", "Ljava/util/Date;", "getLayoutId", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "hideKeyboard", "activity", "Landroid/app/Activity;", "onResume", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "openDate", "sendOTPVerification", "showOTPDialog", "validateAndUpdateHumsar", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RaiseServiceRequestFragment extends DataBindingFragment<FragmentRaiseServiceRequestBinding> {
    private FragmentRaiseServiceRequestBinding dataBinding;
    private int dateSelected;
    private boolean isOtpVerify;
    private boolean isReason;
    private boolean isResend;
    private boolean isShowOtp;
    private final NavArgsLazy navArgs$delegate;
    private int timeSelected;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private String reference_id = "";
    private String createDate = "";
    private String _appintmentDateTime = "";
    private final ArrayList<String> cancelrequestList = new ArrayList<>();
    private final ArrayList<String> cancelrequestList_ID = new ArrayList<>();
    private final ArrayList<String> cancelrequestSubList = new ArrayList<>();
    private final ArrayList<String> cancelrequestSubList_ID = new ArrayList<>();
    private String selectedReasonID = "";
    private String selectedSubReasonID = "";
    private ArrayList<String> serviceRequestReason = new ArrayList<>();
    private ArrayList<String> serviceRequestSubReason = new ArrayList<>();
    private final Lazy raiseServiceRequestModel$delegate = LazyKt.lazy(new Function0<RaiseServiceRequestModel>() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$raiseServiceRequestModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RaiseServiceRequestModel invoke() {
            RaiseServiceRequestFragmentArgs navArgs;
            RaiseServiceRequestModel raiseServiceRequestModel = (RaiseServiceRequestModel) new ViewModelProvider(RaiseServiceRequestFragment.this).get(RaiseServiceRequestModel.class);
            navArgs = RaiseServiceRequestFragment.this.getNavArgs();
            raiseServiceRequestModel.setSerialNumber(navArgs.getSerialNumber());
            return raiseServiceRequestModel;
        }
    });

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
        return R.layout.fragment_raise_service_request;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public RaiseServiceRequestFragment() {
        final RaiseServiceRequestFragment raiseServiceRequestFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(RaiseServiceRequestFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$special$$inlined$navArgs$1
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public AnalyticsViewModel getViewModel() {
        return (AnalyticsViewModel) new ViewModelProvider(this).get(AnalyticsViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RaiseServiceRequestFragmentArgs getNavArgs() {
        return (RaiseServiceRequestFragmentArgs) this.navArgs$delegate.getValue();
    }

    public final ArrayList<String> getCancelrequestList_ID() {
        return this.cancelrequestList_ID;
    }

    public final ArrayList<String> getCancelrequestSubList_ID() {
        return this.cancelrequestSubList_ID;
    }

    private final RaiseServiceRequestModel getRaiseServiceRequestModel() {
        return (RaiseServiceRequestModel) this.raiseServiceRequestModel$delegate.getValue();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        String[] stringArray = getResources().getStringArray(R.array.serviceRequestHeaderTemp);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray…serviceRequestHeaderTemp)");
        ((Spinner) _$_findCachedViewById(R.id.spinner_cust_voice)).setAdapter((SpinnerAdapter) new ArrayAdapter(view.getContext(), 17367043, stringArray));
        ((EditText) _$_findCachedViewById(R.id.appointmentDate)).setInputType(0);
        ((EditText) _$_findCachedViewById(R.id.appointmentDate)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RaiseServiceRequestFragment.m1233onViewCreated$lambda0(RaiseServiceRequestFragment.this, view2);
            }
        });
        ((EditText) _$_findCachedViewById(R.id.appointmentDate)).setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda18
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z) {
                RaiseServiceRequestFragment.m1234onViewCreated$lambda1(RaiseServiceRequestFragment.this, view2, z);
            }
        });
        if (Intrinsics.areEqual(getNavArgs().getCancelSubscription(), "1")) {
            ((LinearLayout) _$_findCachedViewById(R.id.llCustomerVoice)).setVisibility(8);
            ((LinearLayout) _$_findCachedViewById(R.id.ll_customer_cancel_voice)).setVisibility(0);
            ((LinearLayout) _$_findCachedViewById(R.id.ll_customer_sub_voice)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R.id.tvHeddingText)).setText(R.string.cancel_subscription);
            ((EditText) _$_findCachedViewById(R.id.appointmentDate)).setVisibility(0);
            cancelSubscrptionReasion("");
        } else {
            ((LinearLayout) _$_findCachedViewById(R.id.ll_customer_cancel_voice)).setVisibility(8);
            ((LinearLayout) _$_findCachedViewById(R.id.ll_customer_sub_voice)).setVisibility(8);
        }
        ((Spinner) _$_findCachedViewById(R.id.spinner_cust_voice)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$onViewCreated$3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view2, int i, long j) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(parent, "parent");
                String obj = parent.getItemAtPosition(i).toString();
                ((LinearLayout) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.ll_customer_sub_voice)).setVisibility(8);
                ((EditText) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.appointmentDate)).setVisibility(8);
                ((RelativeLayout) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.uploadLayout)).setVisibility(8);
                ((TextView) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.referralText)).setVisibility(8);
                ((EditText) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.requestBox)).setVisibility(0);
                ((TextView) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.submitButton)).setVisibility(0);
                if (StringsKt.equals(obj, "Service Issue", true)) {
                    ((LinearLayout) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.ll_customer_sub_voice)).setVisibility(0);
                    ((EditText) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.appointmentDate)).setVisibility(0);
                    arrayList = RaiseServiceRequestFragment.this.serviceRequestSubReason;
                    arrayList.clear();
                    String[] stringArray2 = RaiseServiceRequestFragment.this.getResources().getStringArray(R.array.serviceRequestTemp);
                    Intrinsics.checkNotNullExpressionValue(stringArray2, "resources.getStringArray…array.serviceRequestTemp)");
                    ((Spinner) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.spinner_cust_sub_voice)).setAdapter((SpinnerAdapter) new ArrayAdapter(view.getContext(), 17367043, stringArray2));
                } else if (StringsKt.equals(obj, "Installation", true)) {
                    ((EditText) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.appointmentDate)).setVisibility(0);
                } else if (StringsKt.equals(obj, "Referral Related", true)) {
                    ((TextView) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.referralText)).setVisibility(0);
                    ((EditText) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.requestBox)).setVisibility(8);
                    ((TextView) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.submitButton)).setVisibility(8);
                    ((TextView) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.referralText)).setText(RaiseServiceRequestFragment.this.getString(R.string.referrals));
                } else if (StringsKt.equals(obj, "Recharge Related", true)) {
                    ((LinearLayout) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.ll_customer_sub_voice)).setVisibility(0);
                    String[] stringArray3 = RaiseServiceRequestFragment.this.getResources().getStringArray(R.array.rechargeRequest);
                    Intrinsics.checkNotNullExpressionValue(stringArray3, "resources.getStringArray(R.array.rechargeRequest)");
                    ((Spinner) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.spinner_cust_sub_voice)).setAdapter((SpinnerAdapter) new ArrayAdapter(view.getContext(), 17367043, stringArray3));
                }
            }
        });
        ((TextView) _$_findCachedViewById(R.id.referralText)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RaiseServiceRequestFragment.m1235onViewCreated$lambda2(RaiseServiceRequestFragment.this, view2);
            }
        });
        ((Spinner) _$_findCachedViewById(R.id.spinner_cust_sub_voice)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$onViewCreated$5
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view2, int i, long j) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                parent.getItemAtPosition(i).toString();
            }
        });
        ((Spinner) _$_findCachedViewById(R.id.spinner_cust_cancel_voice)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$onViewCreated$6
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view2, int i, long j) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                RaiseServiceRequestFragment raiseServiceRequestFragment = RaiseServiceRequestFragment.this;
                String str = raiseServiceRequestFragment.getCancelrequestList_ID().get(i);
                Intrinsics.checkNotNullExpressionValue(str, "cancelrequestList_ID[position]");
                raiseServiceRequestFragment.selectedReasonID = str;
                RaiseServiceRequestFragment raiseServiceRequestFragment2 = RaiseServiceRequestFragment.this;
                String str2 = raiseServiceRequestFragment2.getCancelrequestList_ID().get(i);
                Intrinsics.checkNotNullExpressionValue(str2, "cancelrequestList_ID[position]");
                raiseServiceRequestFragment2.cancelSubscrptionReasion(str2);
            }
        });
        ((Spinner) _$_findCachedViewById(R.id.spinner_cust_sub_voice)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$onViewCreated$7
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view2, int i, long j) {
                RaiseServiceRequestFragmentArgs navArgs;
                Intrinsics.checkNotNullParameter(parent, "parent");
                try {
                    navArgs = RaiseServiceRequestFragment.this.getNavArgs();
                    if (Intrinsics.areEqual(navArgs.getCancelSubscription(), "1")) {
                        RaiseServiceRequestFragment raiseServiceRequestFragment = RaiseServiceRequestFragment.this;
                        String str = raiseServiceRequestFragment.getCancelrequestSubList_ID().get(i);
                        Intrinsics.checkNotNullExpressionValue(str, "cancelrequestSubList_ID[position]");
                        raiseServiceRequestFragment.selectedSubReasonID = str;
                    } else {
                        String obj = parent.getItemAtPosition(i).toString();
                        int hashCode = obj.hashCode();
                        if (hashCode != -232990603) {
                            if (hashCode != 1830386870) {
                                if (hashCode == 1862564492 && obj.equals("Refresh Recharge")) {
                                    ((EditText) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.requestBox)).setVisibility(8);
                                    ((RelativeLayout) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.uploadLayout)).setVisibility(8);
                                }
                            } else if (obj.equals("Status of last recharge")) {
                                ((EditText) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.requestBox)).setVisibility(8);
                                ((RelativeLayout) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.uploadLayout)).setVisibility(8);
                            }
                        } else if (obj.equals("Recharge not Updated")) {
                            ((RelativeLayout) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.uploadLayout)).setVisibility(0);
                            ((EditText) RaiseServiceRequestFragment.this._$_findCachedViewById(R.id.requestBox)).setVisibility(0);
                        }
                    }
                } catch (Exception e) {
                    Logger.getLogger(e.toString());
                }
            }
        });
        ((TextView) _$_findCachedViewById(R.id.submitButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RaiseServiceRequestFragment.m1236onViewCreated$lambda3(RaiseServiceRequestFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m1233onViewCreated$lambda0(RaiseServiceRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.customeDatePicker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m1234onViewCreated$lambda1(RaiseServiceRequestFragment this$0, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            this$0.customeDatePicker();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m1235onViewCreated$lambda2(RaiseServiceRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).navigate(R.id.action_raiseServiceRequest_to_referralData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m1236onViewCreated$lambda3(RaiseServiceRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideKeyboard(this$0.getActivity());
        if (Intrinsics.areEqual(this$0.getNavArgs().getCancelSubscription(), "1")) {
            this$0.isResend = false;
            this$0.isShowOtp = false;
            this$0.sendOTPVerification();
            return;
        }
        this$0.ValidateData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isReason = false;
    }

    private final void callCustomerSupportApiReason() {
        RaiseServiceRequestModel raiseServiceRequestModel = getRaiseServiceRequestModel();
        String string = getString(R.string.job_type_reason);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.job_type_reason)");
        raiseServiceRequestModel.getWAAS_GetCustomerVoice(string);
        getRaiseServiceRequestModel().getCustomerVoiceReasonResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda20
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RaiseServiceRequestFragment.m1213callCustomerSupportApiReason$lambda4(RaiseServiceRequestFragment.this, (CustomerVoiceResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: callCustomerSupportApiReason$lambda-4  reason: not valid java name */
    public static final void m1213callCustomerSupportApiReason$lambda4(RaiseServiceRequestFragment this$0, CustomerVoiceResponse customerVoiceResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Boolean status = customerVoiceResponse.getStatus();
        Intrinsics.checkNotNull(status);
        if (!status.booleanValue() || this$0.isReason) {
            return;
        }
        List<WAASReasonResList> waasReasonResList = customerVoiceResponse.getWaasReasonResList();
        boolean z = false;
        if (waasReasonResList != null && (!waasReasonResList.isEmpty())) {
            z = true;
        }
        if (z) {
            List<WAASReasonResList> waasReasonResList2 = customerVoiceResponse.getWaasReasonResList();
            IntRange indices = waasReasonResList2 != null ? CollectionsKt.getIndices(waasReasonResList2) : null;
            Intrinsics.checkNotNull(indices);
            int first = indices.getFirst();
            int last = indices.getLast();
            if (first <= last) {
                while (true) {
                    ArrayList<String> arrayList = this$0.serviceRequestReason;
                    List<WAASReasonResList> waasReasonResList3 = customerVoiceResponse.getWaasReasonResList();
                    Intrinsics.checkNotNull(waasReasonResList3);
                    arrayList.add(String.valueOf(waasReasonResList3.get(first).getReason()));
                    if (first == last) {
                        break;
                    }
                    first++;
                }
            }
            if (!this$0.serviceRequestReason.isEmpty()) {
                ((Spinner) this$0._$_findCachedViewById(R.id.spinner_cust_voice)).setAdapter((SpinnerAdapter) new ArrayAdapter(this$0.requireView().getContext(), 17367043, this$0.serviceRequestReason));
                this$0.isReason = true;
            }
        }
    }

    private final void callCustomerSupportApiSubReason() {
        RaiseServiceRequestModel raiseServiceRequestModel = getRaiseServiceRequestModel();
        String string = getString(R.string.job_type_sub_reason);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.job_type_sub_reason)");
        raiseServiceRequestModel.getWAAS_GetCustomerVoice(string);
        getRaiseServiceRequestModel().getCustomerVoiceSubReasonResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda19
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RaiseServiceRequestFragment.m1214callCustomerSupportApiSubReason$lambda5(RaiseServiceRequestFragment.this, (CustomerVoiceResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: callCustomerSupportApiSubReason$lambda-5  reason: not valid java name */
    public static final void m1214callCustomerSupportApiSubReason$lambda5(RaiseServiceRequestFragment this$0, CustomerVoiceResponse customerVoiceResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Boolean status = customerVoiceResponse.getStatus();
        Intrinsics.checkNotNull(status);
        if (status.booleanValue()) {
            List<WAASReasonResList> waasReasonResList = customerVoiceResponse.getWaasReasonResList();
            boolean z = false;
            if (waasReasonResList != null && (!waasReasonResList.isEmpty())) {
                z = true;
            }
            if (z) {
                List<WAASReasonResList> waasReasonResList2 = customerVoiceResponse.getWaasReasonResList();
                IntRange indices = waasReasonResList2 != null ? CollectionsKt.getIndices(waasReasonResList2) : null;
                Intrinsics.checkNotNull(indices);
                int first = indices.getFirst();
                int last = indices.getLast();
                if (first <= last) {
                    while (true) {
                        ArrayList<String> arrayList = this$0.serviceRequestSubReason;
                        List<WAASReasonResList> waasReasonResList3 = customerVoiceResponse.getWaasReasonResList();
                        Intrinsics.checkNotNull(waasReasonResList3);
                        arrayList.add(String.valueOf(waasReasonResList3.get(first).getReason()));
                        if (first == last) {
                            break;
                        }
                        first++;
                    }
                }
                if (!this$0.serviceRequestSubReason.isEmpty()) {
                    this$0.isReason = true;
                    ((Spinner) this$0._$_findCachedViewById(R.id.spinner_cust_sub_voice)).setAdapter((SpinnerAdapter) new ArrayAdapter(this$0.requireView().getContext(), 17367043, this$0.serviceRequestSubReason));
                }
            }
        }
    }

    private final void hideKeyboard(Activity activity) {
        if (activity == null || activity.getWindow() == null) {
            return;
        }
        activity.getWindow().getDecorView();
        Object systemService = activity.getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentRaiseServiceRequestBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.dataBinding = dataBinding;
        dataBinding.setViewModel(getRaiseServiceRequestModel());
    }

    private final String getDateInUTC(Date date) {
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "formatDateTime.format(c.time)");
        this.createDate = format;
        StringBuilder sb = new StringBuilder();
        sb.append("AND_");
        User user = LSApplication.Companion.getUser();
        sb.append(user != null ? user.getId() : null);
        sb.append('_');
        sb.append(simpleDateFormat2.format(calendar.getTime()));
        this.reference_id = sb.toString();
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat3.setTimeZone(TimeZone.getTimeZone("UTC"));
        Intrinsics.checkNotNull(date);
        String format2 = simpleDateFormat3.format(date);
        System.out.println((Object) ("UTC" + format2));
        return format2;
    }

    public final void openDate() {
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "formatDateTime.format(c.time)");
        this.createDate = format;
        StringBuilder sb = new StringBuilder();
        sb.append("AND_");
        User user = LSApplication.Companion.getUser();
        sb.append(user != null ? user.getId() : null);
        sb.append('_');
        sb.append(simpleDateFormat2.format(calendar.getTime()));
        this.reference_id = sb.toString();
        Context context = getContext();
        DatePickerDialog datePickerDialog = context != null ? new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda0
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                RaiseServiceRequestFragment.m1237openDate$lambda8$lambda7(RaiseServiceRequestFragment.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3) : null;
        DatePicker datePicker = datePickerDialog != null ? datePickerDialog.getDatePicker() : null;
        if (datePicker != null) {
            datePicker.setMinDate(calendar.getTimeInMillis());
        }
        if (datePickerDialog != null) {
            datePickerDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: openDate$lambda-8$lambda-7  reason: not valid java name */
    public static final void m1237openDate$lambda8$lambda7(final RaiseServiceRequestFragment this$0, DatePicker datePicker, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        calendar.set(i, i2, i3);
        final String format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "format.format(calendar.time)");
        Calendar calendar2 = Calendar.getInstance();
        new TimePickerDialog(this$0.getContext(), new TimePickerDialog.OnTimeSetListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda11
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public final void onTimeSet(TimePicker timePicker, int i4, int i5) {
                RaiseServiceRequestFragment.m1238openDate$lambda8$lambda7$lambda6(RaiseServiceRequestFragment.this, format, timePicker, i4, i5);
            }
        }, calendar2.get(11), calendar2.get(12), true).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: openDate$lambda-8$lambda-7$lambda-6  reason: not valid java name */
    public static final void m1238openDate$lambda8$lambda7$lambda6(RaiseServiceRequestFragment this$0, String strDate, TimePicker timePicker, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(strDate, "$strDate");
        ((EditText) this$0._$_findCachedViewById(R.id.appointmentDate)).setText(strDate + SafeJsonPrimitive.NULL_CHAR + StringsKt.padStart(String.valueOf(i), 2, '0') + JsonLexerKt.COLON + StringsKt.padStart(String.valueOf(i2), 2, '0') + ":00");
    }

    private final void customeDatePicker() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        final Dialog dialog = new Dialog(requireActivity());
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.custom_date_time);
        Window window = dialog.getWindow();
        Intrinsics.checkNotNull(window);
        window.setLayout(-1, -2);
        window.setGravity(17);
        Window window2 = dialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setBackgroundDrawable(new ColorDrawable(0));
        dialog.setCancelable(true);
        dialog.show();
        final TextView textView9 = (TextView) dialog.findViewById(R.id.tvMonthYear);
        final TextView textView10 = (TextView) dialog.findViewById(R.id.tvDay2);
        final TextView textView11 = (TextView) dialog.findViewById(R.id.tvDay3);
        TextView textView12 = (TextView) dialog.findViewById(R.id.tvDay4);
        TextView textView13 = (TextView) dialog.findViewById(R.id.tvDay5);
        TextView textView14 = (TextView) dialog.findViewById(R.id.tvDay6);
        TextView textView15 = (TextView) dialog.findViewById(R.id.tvDay7);
        TextView textView16 = (TextView) dialog.findViewById(R.id.tvDate1);
        TextView textView17 = (TextView) dialog.findViewById(R.id.tvDate2);
        final TextView textView18 = (TextView) dialog.findViewById(R.id.tvDate4);
        final TextView textView19 = (TextView) dialog.findViewById(R.id.tvDate5);
        final TextView textView20 = (TextView) dialog.findViewById(R.id.tvDate6);
        final TextView textView21 = (TextView) dialog.findViewById(R.id.tvDate7);
        TextView textView22 = textView16;
        final TextView textView23 = (TextView) dialog.findViewById(R.id.tvTime1);
        final TextView textView24 = (TextView) dialog.findViewById(R.id.tvTime2);
        final TextView textView25 = (TextView) dialog.findViewById(R.id.tvTime3);
        final TextView textView26 = (TextView) dialog.findViewById(R.id.tvTime4);
        final TextView textView27 = (TextView) dialog.findViewById(R.id.tvTime5);
        final TextView textView28 = (TextView) dialog.findViewById(R.id.tvTime6);
        final LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.llTime1);
        final LinearLayout linearLayout2 = (LinearLayout) dialog.findViewById(R.id.llTime2);
        final LinearLayout linearLayout3 = (LinearLayout) dialog.findViewById(R.id.llTime3);
        final LinearLayout linearLayout4 = (LinearLayout) dialog.findViewById(R.id.llTime4);
        final LinearLayout linearLayout5 = (LinearLayout) dialog.findViewById(R.id.llTime5);
        final LinearLayout linearLayout6 = (LinearLayout) dialog.findViewById(R.id.llTime6);
        TextView textView29 = (TextView) dialog.findViewById(R.id.tvDay1);
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        TextView textView30 = textView17;
        final SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd", Locale.ENGLISH);
        final SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("MMMyyyy", Locale.ENGLISH);
        final Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        TextView textView31 = (TextView) dialog.findViewById(R.id.tvDate3);
        Integer[] numArr = {1, 2, 3, 4, 5, 6, 7};
        textView9.setText(simpleDateFormat3.format(calendar.getTime()).toString());
        int i = 0;
        while (i < 7) {
            int intValue = numArr[i].intValue();
            Integer[] numArr2 = numArr;
            calendar.add(5, 1);
            switch (intValue) {
                case 1:
                    textView = textView14;
                    textView2 = textView30;
                    textView3 = textView31;
                    textView4 = textView15;
                    String format = simpleDateFormat.format(calendar.getTime());
                    Intrinsics.checkNotNullExpressionValue(format, "_day.format(cal.time)");
                    textView5 = textView13;
                    textView6 = textView29;
                    textView6.setText(StringsKt.take(format, 2));
                    textView7 = textView12;
                    textView8 = textView22;
                    textView8.setText(simpleDateFormat2.format(calendar.getTime()).toString());
                    break;
                case 2:
                    textView3 = textView31;
                    textView4 = textView15;
                    String format2 = simpleDateFormat.format(calendar.getTime());
                    Intrinsics.checkNotNullExpressionValue(format2, "_day.format(cal.time)");
                    textView10.setText(StringsKt.take(format2, 2));
                    textView = textView14;
                    textView2 = textView30;
                    textView2.setText(simpleDateFormat2.format(calendar.getTime()).toString());
                    textView7 = textView12;
                    textView5 = textView13;
                    textView8 = textView22;
                    textView6 = textView29;
                    break;
                case 3:
                    String format3 = simpleDateFormat.format(calendar.getTime());
                    Intrinsics.checkNotNullExpressionValue(format3, "_day.format(cal.time)");
                    textView11.setText(StringsKt.take(format3, 2));
                    textView3 = textView31;
                    textView3.setText(simpleDateFormat2.format(calendar.getTime()).toString());
                    textView7 = textView12;
                    textView5 = textView13;
                    textView = textView14;
                    textView4 = textView15;
                    textView8 = textView22;
                    textView2 = textView30;
                    textView6 = textView29;
                    break;
                case 4:
                    String format4 = simpleDateFormat.format(calendar.getTime());
                    Intrinsics.checkNotNullExpressionValue(format4, "_day.format(cal.time)");
                    textView12.setText(StringsKt.take(format4, 2));
                    textView18.setText(simpleDateFormat2.format(calendar.getTime()).toString());
                    textView7 = textView12;
                    textView5 = textView13;
                    textView = textView14;
                    textView8 = textView22;
                    textView2 = textView30;
                    textView3 = textView31;
                    textView6 = textView29;
                    textView4 = textView15;
                    break;
                case 5:
                    String format5 = simpleDateFormat.format(calendar.getTime());
                    Intrinsics.checkNotNullExpressionValue(format5, "_day.format(cal.time)");
                    textView13.setText(StringsKt.take(format5, 2));
                    textView19.setText(simpleDateFormat2.format(calendar.getTime()).toString());
                    textView7 = textView12;
                    textView5 = textView13;
                    textView = textView14;
                    textView8 = textView22;
                    textView2 = textView30;
                    textView3 = textView31;
                    textView6 = textView29;
                    textView4 = textView15;
                    break;
                case 6:
                    String format6 = simpleDateFormat.format(calendar.getTime());
                    Intrinsics.checkNotNullExpressionValue(format6, "_day.format(cal.time)");
                    textView14.setText(StringsKt.take(format6, 2));
                    textView20.setText(simpleDateFormat2.format(calendar.getTime()).toString());
                    textView7 = textView12;
                    textView5 = textView13;
                    textView = textView14;
                    textView8 = textView22;
                    textView2 = textView30;
                    textView3 = textView31;
                    textView6 = textView29;
                    textView4 = textView15;
                    break;
                case 7:
                    String format7 = simpleDateFormat.format(calendar.getTime());
                    Intrinsics.checkNotNullExpressionValue(format7, "_day.format(cal.time)");
                    textView15.setText(StringsKt.take(format7, 2));
                    textView21.setText(simpleDateFormat2.format(calendar.getTime()).toString());
                    textView7 = textView12;
                    textView5 = textView13;
                    textView = textView14;
                    textView8 = textView22;
                    textView2 = textView30;
                    textView3 = textView31;
                    textView6 = textView29;
                    textView4 = textView15;
                    break;
                default:
                    textView7 = textView12;
                    textView5 = textView13;
                    textView = textView14;
                    textView8 = textView22;
                    textView2 = textView30;
                    textView3 = textView31;
                    textView6 = textView29;
                    textView4 = textView15;
                    System.out.print((Object) "otherwise");
                    break;
            }
            i++;
            textView22 = textView8;
            textView29 = textView6;
            textView30 = textView2;
            textView15 = textView4;
            numArr = numArr2;
            textView12 = textView7;
            textView13 = textView5;
            textView14 = textView;
            textView31 = textView3;
        }
        final TextView textView32 = textView12;
        final TextView textView33 = textView13;
        final TextView textView34 = textView14;
        final Integer[] numArr3 = numArr;
        final TextView textView35 = textView22;
        final TextView textView36 = textView30;
        final TextView textView37 = textView31;
        final TextView textView38 = textView29;
        final TextView textView39 = textView15;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1232customeDatePicker$lambda9(textView23, this, textView24, textView25, textView26, textView27, textView28, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1217customeDatePicker$lambda10(textView24, this, textView23, textView25, textView26, textView27, textView28, linearLayout2, linearLayout, linearLayout3, linearLayout4, linearLayout5, linearLayout6, view);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1218customeDatePicker$lambda11(textView25, this, textView23, textView24, textView26, textView27, textView28, linearLayout3, linearLayout2, linearLayout, linearLayout4, linearLayout5, linearLayout6, view);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1219customeDatePicker$lambda12(textView26, this, textView23, textView25, textView24, textView27, textView28, linearLayout4, linearLayout2, linearLayout3, linearLayout, linearLayout5, linearLayout6, view);
            }
        });
        linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1220customeDatePicker$lambda13(textView27, this, textView23, textView25, textView26, textView24, textView28, linearLayout5, linearLayout2, linearLayout3, linearLayout4, linearLayout, linearLayout6, view);
            }
        });
        linearLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1221customeDatePicker$lambda14(textView28, this, textView23, textView25, textView26, textView27, textView24, linearLayout6, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout, view);
            }
        });
        textView35.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1222customeDatePicker$lambda15(textView35, textView36, textView37, textView18, textView19, textView20, textView21, this, view);
            }
        });
        textView36.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1223customeDatePicker$lambda16(textView36, textView35, textView37, textView18, textView19, textView20, textView21, this, view);
            }
        });
        textView37.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1224customeDatePicker$lambda17(textView37, textView36, textView35, textView18, textView19, textView20, textView21, this, view);
            }
        });
        textView18.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1225customeDatePicker$lambda18(textView18, textView36, textView37, textView35, textView19, textView20, textView21, this, view);
            }
        });
        textView19.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1226customeDatePicker$lambda19(textView19, textView36, textView37, textView18, textView35, textView20, textView21, this, view);
            }
        });
        textView20.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1227customeDatePicker$lambda20(textView20, textView36, textView37, textView18, textView19, textView35, textView21, this, view);
            }
        });
        textView21.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1228customeDatePicker$lambda21(textView21, textView36, textView37, textView18, textView19, textView20, textView35, this, view);
            }
        });
        Button button = (Button) dialog.findViewById(R.id.btSelect);
        final ImageView imageView = (ImageView) dialog.findViewById(R.id.ivLeftArrow);
        ImageView imageView2 = (ImageView) dialog.findViewById(R.id.ivRightArrow);
        final Ref.IntRef intRef = new Ref.IntRef();
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1229customeDatePicker$lambda22(Ref.IntRef.this, this, imageView, calendar, textView9, simpleDateFormat3, numArr3, textView38, simpleDateFormat, textView35, simpleDateFormat2, textView10, textView36, textView11, textView37, textView32, textView18, textView33, textView19, textView34, textView20, textView39, textView21, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1230customeDatePicker$lambda23(Ref.IntRef.this, this, imageView, textView9, simpleDateFormat3, calendar, numArr3, textView38, simpleDateFormat, textView35, simpleDateFormat2, textView10, textView36, textView11, textView37, textView32, textView18, textView33, textView19, textView34, textView20, textView39, textView21, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1231customeDatePicker$lambda24(RaiseServiceRequestFragment.this, calendar, textView23, textView24, textView25, textView26, textView27, textView28, dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: customeDatePicker$lambda-9  reason: not valid java name */
    public static final void m1232customeDatePicker$lambda9(TextView textView, RaiseServiceRequestFragment this$0, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        textView.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite));
        textView2.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView3.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView4.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView5.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView6.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        linearLayout.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.color3));
        linearLayout2.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout3.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout4.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout5.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout6.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        this$0.timeSelected = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: customeDatePicker$lambda-10  reason: not valid java name */
    public static final void m1217customeDatePicker$lambda10(TextView textView, RaiseServiceRequestFragment this$0, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        textView.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite));
        textView2.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView3.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView4.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView5.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView6.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        linearLayout.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.color3));
        linearLayout2.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout3.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout4.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout5.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout6.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        this$0.timeSelected = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: customeDatePicker$lambda-11  reason: not valid java name */
    public static final void m1218customeDatePicker$lambda11(TextView textView, RaiseServiceRequestFragment this$0, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        textView.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite));
        textView2.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView3.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView4.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView5.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView6.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        linearLayout.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.color3));
        linearLayout2.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout3.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout4.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout5.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout6.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        this$0.timeSelected = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: customeDatePicker$lambda-12  reason: not valid java name */
    public static final void m1219customeDatePicker$lambda12(TextView textView, RaiseServiceRequestFragment this$0, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        textView.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite));
        textView2.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView3.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView4.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView5.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView6.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        linearLayout.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.color3));
        linearLayout2.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout3.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout4.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout5.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout6.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        this$0.timeSelected = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: customeDatePicker$lambda-13  reason: not valid java name */
    public static final void m1220customeDatePicker$lambda13(TextView textView, RaiseServiceRequestFragment this$0, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        textView.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite));
        textView2.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView3.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView4.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView5.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView6.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        linearLayout.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.color3));
        linearLayout2.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout3.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout4.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout5.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout6.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        this$0.timeSelected = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: customeDatePicker$lambda-14  reason: not valid java name */
    public static final void m1221customeDatePicker$lambda14(TextView textView, RaiseServiceRequestFragment this$0, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        textView.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite));
        textView2.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView3.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView4.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView5.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView6.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        linearLayout.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.color3));
        linearLayout2.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout3.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout4.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout5.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        linearLayout6.setBackgroundColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorDimSurface));
        this$0.timeSelected = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: customeDatePicker$lambda-15  reason: not valid java name */
    public static final void m1222customeDatePicker$lambda15(TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, RaiseServiceRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        textView.setBackgroundResource(R.drawable.circle_date);
        textView2.setBackgroundResource(R.drawable.circle_date_white);
        textView3.setBackgroundResource(R.drawable.circle_date_white);
        textView4.setBackgroundResource(R.drawable.circle_date_white);
        textView5.setBackgroundResource(R.drawable.circle_date_white);
        textView6.setBackgroundResource(R.drawable.circle_date_white);
        textView7.setBackgroundResource(R.drawable.circle_date_white);
        textView.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite));
        textView2.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView3.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView4.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView5.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView6.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView7.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        this$0.dateSelected = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: customeDatePicker$lambda-16  reason: not valid java name */
    public static final void m1223customeDatePicker$lambda16(TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, RaiseServiceRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        textView.setBackgroundResource(R.drawable.circle_date);
        textView2.setBackgroundResource(R.drawable.circle_date_white);
        textView3.setBackgroundResource(R.drawable.circle_date_white);
        textView4.setBackgroundResource(R.drawable.circle_date_white);
        textView5.setBackgroundResource(R.drawable.circle_date_white);
        textView6.setBackgroundResource(R.drawable.circle_date_white);
        textView7.setBackgroundResource(R.drawable.circle_date_white);
        textView.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite));
        textView2.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView3.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView4.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView5.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView6.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView7.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        this$0.dateSelected = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: customeDatePicker$lambda-17  reason: not valid java name */
    public static final void m1224customeDatePicker$lambda17(TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, RaiseServiceRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        textView.setBackgroundResource(R.drawable.circle_date);
        textView2.setBackgroundResource(R.drawable.circle_date_white);
        textView3.setBackgroundResource(R.drawable.circle_date_white);
        textView4.setBackgroundResource(R.drawable.circle_date_white);
        textView5.setBackgroundResource(R.drawable.circle_date_white);
        textView6.setBackgroundResource(R.drawable.circle_date_white);
        textView7.setBackgroundResource(R.drawable.circle_date_white);
        textView.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite));
        textView2.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView3.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView4.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView5.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView6.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView7.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        this$0.dateSelected = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: customeDatePicker$lambda-18  reason: not valid java name */
    public static final void m1225customeDatePicker$lambda18(TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, RaiseServiceRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        textView.setBackgroundResource(R.drawable.circle_date);
        textView2.setBackgroundResource(R.drawable.circle_date_white);
        textView3.setBackgroundResource(R.drawable.circle_date_white);
        textView4.setBackgroundResource(R.drawable.circle_date_white);
        textView5.setBackgroundResource(R.drawable.circle_date_white);
        textView6.setBackgroundResource(R.drawable.circle_date_white);
        textView7.setBackgroundResource(R.drawable.circle_date_white);
        textView.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite));
        textView2.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView3.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView4.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView5.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView6.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView7.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        this$0.dateSelected = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: customeDatePicker$lambda-19  reason: not valid java name */
    public static final void m1226customeDatePicker$lambda19(TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, RaiseServiceRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        textView.setBackgroundResource(R.drawable.circle_date);
        textView2.setBackgroundResource(R.drawable.circle_date_white);
        textView3.setBackgroundResource(R.drawable.circle_date_white);
        textView4.setBackgroundResource(R.drawable.circle_date_white);
        textView5.setBackgroundResource(R.drawable.circle_date_white);
        textView6.setBackgroundResource(R.drawable.circle_date_white);
        textView7.setBackgroundResource(R.drawable.circle_date_white);
        textView.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite));
        textView2.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView3.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView4.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView5.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView6.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView7.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        this$0.dateSelected = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: customeDatePicker$lambda-20  reason: not valid java name */
    public static final void m1227customeDatePicker$lambda20(TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, RaiseServiceRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        textView.setBackgroundResource(R.drawable.circle_date);
        textView2.setBackgroundResource(R.drawable.circle_date_white);
        textView3.setBackgroundResource(R.drawable.circle_date_white);
        textView4.setBackgroundResource(R.drawable.circle_date_white);
        textView5.setBackgroundResource(R.drawable.circle_date_white);
        textView6.setBackgroundResource(R.drawable.circle_date_white);
        textView7.setBackgroundResource(R.drawable.circle_date_white);
        textView.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite));
        textView2.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView3.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView4.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView5.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView6.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView7.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        this$0.dateSelected = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: customeDatePicker$lambda-21  reason: not valid java name */
    public static final void m1228customeDatePicker$lambda21(TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, RaiseServiceRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        textView.setBackgroundResource(R.drawable.circle_date);
        textView2.setBackgroundResource(R.drawable.circle_date_white);
        textView3.setBackgroundResource(R.drawable.circle_date_white);
        textView4.setBackgroundResource(R.drawable.circle_date_white);
        textView5.setBackgroundResource(R.drawable.circle_date_white);
        textView6.setBackgroundResource(R.drawable.circle_date_white);
        textView7.setBackgroundResource(R.drawable.circle_date_white);
        textView.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite));
        textView2.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView3.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView4.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView5.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView6.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView7.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        this$0.dateSelected = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: customeDatePicker$lambda-22  reason: not valid java name */
    public static final void m1229customeDatePicker$lambda22(Ref.IntRef weekCount, RaiseServiceRequestFragment this$0, ImageView imageView, Calendar cal, TextView textView, SimpleDateFormat _monthyear, Integer[] numbers, TextView textView2, SimpleDateFormat _day, TextView textView3, SimpleDateFormat _date, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, View view) {
        Intrinsics.checkNotNullParameter(weekCount, "$weekCount");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cal, "$cal");
        Intrinsics.checkNotNullParameter(_monthyear, "$_monthyear");
        Intrinsics.checkNotNullParameter(numbers, "$numbers");
        Intrinsics.checkNotNullParameter(_day, "$_day");
        Intrinsics.checkNotNullParameter(_date, "$_date");
        weekCount.element--;
        int i = 0;
        this$0.dateSelected = 0;
        if (weekCount.element == 0) {
            imageView.setVisibility(4);
        }
        int i2 = 5;
        cal.add(5, -14);
        textView.setText(_monthyear.format(cal.getTime()).toString());
        int length = numbers.length;
        while (i < length) {
            int intValue = numbers[i].intValue();
            int i3 = length;
            cal.add(i2, 1);
            switch (intValue) {
                case 1:
                    String format = _day.format(cal.getTime());
                    Intrinsics.checkNotNullExpressionValue(format, "_day.format(cal.time)");
                    textView2.setText(StringsKt.take(format, 2));
                    textView3.setText(_date.format(cal.getTime()).toString());
                    continue;
                    i++;
                    length = i3;
                    i2 = 5;
                case 2:
                    String format2 = _day.format(cal.getTime());
                    Intrinsics.checkNotNullExpressionValue(format2, "_day.format(cal.time)");
                    textView4.setText(StringsKt.take(format2, 2));
                    textView5.setText(_date.format(cal.getTime()).toString());
                    break;
                case 3:
                    String format3 = _day.format(cal.getTime());
                    Intrinsics.checkNotNullExpressionValue(format3, "_day.format(cal.time)");
                    textView6.setText(StringsKt.take(format3, 2));
                    textView7.setText(_date.format(cal.getTime()).toString());
                    break;
                case 4:
                    String format4 = _day.format(cal.getTime());
                    Intrinsics.checkNotNullExpressionValue(format4, "_day.format(cal.time)");
                    textView8.setText(StringsKt.take(format4, 2));
                    textView9.setText(_date.format(cal.getTime()).toString());
                    break;
                case 5:
                    String format5 = _day.format(cal.getTime());
                    Intrinsics.checkNotNullExpressionValue(format5, "_day.format(cal.time)");
                    textView10.setText(StringsKt.take(format5, 2));
                    textView11.setText(_date.format(cal.getTime()).toString());
                    break;
                case 6:
                    String format6 = _day.format(cal.getTime());
                    Intrinsics.checkNotNullExpressionValue(format6, "_day.format(cal.time)");
                    textView12.setText(StringsKt.take(format6, 2));
                    textView13.setText(_date.format(cal.getTime()).toString());
                    break;
                case 7:
                    String format7 = _day.format(cal.getTime());
                    Intrinsics.checkNotNullExpressionValue(format7, "_day.format(cal.time)");
                    textView14.setText(StringsKt.take(format7, 2));
                    textView15.setText(_date.format(cal.getTime()).toString());
                    break;
                default:
                    System.out.print((Object) "otherwise");
                    continue;
                    i++;
                    length = i3;
                    i2 = 5;
            }
            i++;
            length = i3;
            i2 = 5;
        }
        textView15.setBackgroundResource(R.drawable.circle_date_white);
        textView5.setBackgroundResource(R.drawable.circle_date_white);
        textView7.setBackgroundResource(R.drawable.circle_date_white);
        textView9.setBackgroundResource(R.drawable.circle_date_white);
        textView11.setBackgroundResource(R.drawable.circle_date_white);
        textView13.setBackgroundResource(R.drawable.circle_date_white);
        textView3.setBackgroundResource(R.drawable.circle_date_white);
        textView15.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView5.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView7.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView9.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView11.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView13.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView3.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: customeDatePicker$lambda-23  reason: not valid java name */
    public static final void m1230customeDatePicker$lambda23(Ref.IntRef weekCount, RaiseServiceRequestFragment this$0, ImageView imageView, TextView textView, SimpleDateFormat _monthyear, Calendar cal, Integer[] numbers, TextView textView2, SimpleDateFormat _day, TextView textView3, SimpleDateFormat _date, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, View view) {
        int i;
        Intrinsics.checkNotNullParameter(weekCount, "$weekCount");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(_monthyear, "$_monthyear");
        Intrinsics.checkNotNullParameter(cal, "$cal");
        Intrinsics.checkNotNullParameter(numbers, "$numbers");
        Intrinsics.checkNotNullParameter(_day, "$_day");
        Intrinsics.checkNotNullParameter(_date, "$_date");
        int i2 = 1;
        weekCount.element++;
        int i3 = 0;
        this$0.dateSelected = 0;
        imageView.setVisibility(0);
        textView.setText(_monthyear.format(cal.getTime()).toString());
        int length = numbers.length;
        while (i3 < length) {
            int intValue = numbers[i3].intValue();
            cal.add(5, i2);
            switch (intValue) {
                case 1:
                    String format = _day.format(cal.getTime());
                    Intrinsics.checkNotNullExpressionValue(format, "_day.format(cal.time)");
                    textView2.setText(StringsKt.take(format, 2));
                    textView3.setText(_date.format(cal.getTime()).toString());
                    break;
                case 2:
                    String format2 = _day.format(cal.getTime());
                    Intrinsics.checkNotNullExpressionValue(format2, "_day.format(cal.time)");
                    textView4.setText(StringsKt.take(format2, 2));
                    textView5.setText(_date.format(cal.getTime()).toString());
                    break;
                case 3:
                    String format3 = _day.format(cal.getTime());
                    Intrinsics.checkNotNullExpressionValue(format3, "_day.format(cal.time)");
                    textView6.setText(StringsKt.take(format3, 2));
                    textView7.setText(_date.format(cal.getTime()).toString());
                    break;
                case 4:
                    String format4 = _day.format(cal.getTime());
                    Intrinsics.checkNotNullExpressionValue(format4, "_day.format(cal.time)");
                    textView8.setText(StringsKt.take(format4, 2));
                    textView9.setText(_date.format(cal.getTime()).toString());
                    break;
                case 5:
                    String format5 = _day.format(cal.getTime());
                    Intrinsics.checkNotNullExpressionValue(format5, "_day.format(cal.time)");
                    textView10.setText(StringsKt.take(format5, 2));
                    textView11.setText(_date.format(cal.getTime()).toString());
                    break;
                case 6:
                    String format6 = _day.format(cal.getTime());
                    Intrinsics.checkNotNullExpressionValue(format6, "_day.format(cal.time)");
                    textView12.setText(StringsKt.take(format6, 2));
                    textView13.setText(_date.format(cal.getTime()).toString());
                    break;
                case 7:
                    String format7 = _day.format(cal.getTime());
                    Intrinsics.checkNotNullExpressionValue(format7, "_day.format(cal.time)");
                    textView14.setText(StringsKt.take(format7, 2));
                    textView15.setText(_date.format(cal.getTime()).toString());
                    break;
                default:
                    i = length;
                    System.out.print((Object) "otherwise");
                    continue;
                    i3++;
                    length = i;
                    i2 = 1;
            }
            i = length;
            i3++;
            length = i;
            i2 = 1;
        }
        textView15.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView5.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView7.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView9.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView11.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView13.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView3.setTextColor(ContextCompat.getColor(this$0.requireContext(), R.color.color9));
        textView15.setBackgroundResource(R.drawable.circle_date_white);
        textView5.setBackgroundResource(R.drawable.circle_date_white);
        textView7.setBackgroundResource(R.drawable.circle_date_white);
        textView9.setBackgroundResource(R.drawable.circle_date_white);
        textView11.setBackgroundResource(R.drawable.circle_date_white);
        textView13.setBackgroundResource(R.drawable.circle_date_white);
        textView3.setBackgroundResource(R.drawable.circle_date_white);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: customeDatePicker$lambda-24  reason: not valid java name */
    public static final void m1231customeDatePicker$lambda24(RaiseServiceRequestFragment this$0, Calendar cal, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, Dialog dialoglog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cal, "$cal");
        Intrinsics.checkNotNullParameter(dialoglog, "$dialoglog");
        int i = this$0.dateSelected;
        if (i != 0 && this$0.timeSelected != 0) {
            cal.add(5, i - 7);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMM", Locale.ENGLISH);
            String format = simpleDateFormat.format(cal.getTime());
            Intrinsics.checkNotNullExpressionValue(format, "format.format(cal.time)");
            String format2 = simpleDateFormat2.format(cal.getTime());
            switch (this$0.timeSelected) {
                case 1:
                    this$0._appintmentDateTime = format + " 09:00:00";
                    String obj = textView.getText().toString();
                    ((EditText) this$0._$_findCachedViewById(R.id.appointmentDate)).setText(obj + " - " + format2);
                    break;
                case 2:
                    this$0._appintmentDateTime = format + " 11:00:00";
                    String obj2 = textView2.getText().toString();
                    ((EditText) this$0._$_findCachedViewById(R.id.appointmentDate)).setText(obj2 + " - " + format2);
                    break;
                case 3:
                    this$0._appintmentDateTime = format + " 13:00:00";
                    String obj3 = textView3.getText().toString();
                    ((EditText) this$0._$_findCachedViewById(R.id.appointmentDate)).setText(obj3 + " - " + format2);
                    break;
                case 4:
                    this$0._appintmentDateTime = format + " 15:00:00";
                    String obj4 = textView4.getText().toString();
                    ((EditText) this$0._$_findCachedViewById(R.id.appointmentDate)).setText(obj4 + " - " + format2);
                    break;
                case 5:
                    this$0._appintmentDateTime = format + " 17:00:00";
                    String obj5 = textView5.getText().toString();
                    ((EditText) this$0._$_findCachedViewById(R.id.appointmentDate)).setText(obj5 + " - " + format2);
                    break;
                case 6:
                    this$0._appintmentDateTime = format + " 19:00:00";
                    String obj6 = textView6.getText().toString();
                    ((EditText) this$0._$_findCachedViewById(R.id.appointmentDate)).setText(obj6 + " - " + format2);
                    break;
            }
        }
        dialoglog.dismiss();
    }

    public final void cancelSubscrptionReasion(final String reasonID) {
        Intrinsics.checkNotNullParameter(reasonID, "reasonID");
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please Wait..");
        progressDialog.show();
        progressDialog.setCancelable(false);
        StringBuilder sb = new StringBuilder();
        sb.append("http://humsar.sar-group.com/MobileAPI/AppServices.svc/");
        sb.append(Intrinsics.areEqual(reasonID, "") ? "WAAS_GetReason" : "WAAS_GetSubReason");
        String sb2 = sb.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("TokenNo", LSHConfig.HUMSAR_TOKEN_NO);
        hashMap.put("ReasonID", reasonID);
        JSONObject jSONObject = new JSONObject(hashMap);
        if (Intrinsics.areEqual(reasonID, "")) {
            this.cancelrequestList.clear();
            this.cancelrequestSubList.clear();
            this.cancelrequestList_ID.clear();
            this.cancelrequestSubList_ID.clear();
            this.cancelrequestList.add("-- Select the reason --");
            this.cancelrequestSubList.add("-- Select the sub reason --");
            this.cancelrequestList_ID.add(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else {
            this.cancelrequestSubList.clear();
            this.cancelrequestSubList_ID.clear();
            this.cancelrequestSubList.add("-- Select the sub reason --");
            this.cancelrequestSubList_ID.add(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        Volley.newRequestQueue(getContext()).add(new JsonObjectRequest(1, sb2, jSONObject, new Response.Listener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda30
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                RaiseServiceRequestFragment.m1215cancelSubscrptionReasion$lambda30(progressDialog, reasonID, this, (JSONObject) obj);
            }
        }, new Response.ErrorListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda26
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                RaiseServiceRequestFragment.m1216cancelSubscrptionReasion$lambda31(RaiseServiceRequestFragment.this, progressDialog, volleyError);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cancelSubscrptionReasion$lambda-30  reason: not valid java name */
    public static final void m1215cancelSubscrptionReasion$lambda30(ProgressDialog dialog, String reasonID, RaiseServiceRequestFragment this$0, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(reasonID, "$reasonID");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        if (jSONObject != null ? jSONObject.getBoolean("Status") : false) {
            Boolean valueOf = jSONObject != null ? Boolean.valueOf(jSONObject.has("cWAASReasonResList")) : null;
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.booleanValue()) {
                Object obj = jSONObject.get("cWAASReasonResList");
                Objects.requireNonNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
                JSONArray jSONArray = (JSONArray) obj;
                Iterator<Integer> it = RangesKt.until(0, jSONArray.length()).iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(((IntIterator) it).nextInt());
                    if (Intrinsics.areEqual(reasonID, "")) {
                        this$0.cancelrequestList.add(jSONObject2.get("Reason").toString());
                        this$0.cancelrequestList_ID.add(jSONObject2.get("ReasonID").toString());
                    } else {
                        this$0.cancelrequestSubList.add(jSONObject2.get("Reason").toString());
                        this$0.cancelrequestSubList_ID.add(jSONObject2.get("ReasonID").toString());
                    }
                }
                if (Intrinsics.areEqual(reasonID, "")) {
                    Context context = this$0.getContext();
                    ((Spinner) this$0._$_findCachedViewById(R.id.spinner_cust_cancel_voice)).setAdapter((SpinnerAdapter) (context != null ? new ArrayAdapter(context, 17367043, this$0.cancelrequestList) : null));
                    Context context2 = this$0.getContext();
                    ((Spinner) this$0._$_findCachedViewById(R.id.spinner_cust_sub_voice)).setAdapter((SpinnerAdapter) (context2 != null ? new ArrayAdapter(context2, 17367043, this$0.cancelrequestSubList) : null));
                } else {
                    Context context3 = this$0.getContext();
                    ((Spinner) this$0._$_findCachedViewById(R.id.spinner_cust_sub_voice)).setAdapter((SpinnerAdapter) (context3 != null ? new ArrayAdapter(context3, 17367043, this$0.cancelrequestSubList) : null));
                }
            }
        } else {
            Context context4 = this$0.getContext();
            ((Spinner) this$0._$_findCachedViewById(R.id.spinner_cust_sub_voice)).setAdapter((SpinnerAdapter) (context4 != null ? new ArrayAdapter(context4, 17367043, this$0.cancelrequestSubList) : null));
        }
        RaiseServiceRequestModel raiseServiceRequestModel = this$0.getRaiseServiceRequestModel();
        User user = LSApplication.Companion.getUser();
        String valueOf2 = String.valueOf(user != null ? user.getId() : null);
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "it.toString()");
        raiseServiceRequestModel.updateServiceLog(valueOf2, jSONObject3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cancelSubscrptionReasion$lambda-31  reason: not valid java name */
    public static final void m1216cancelSubscrptionReasion$lambda31(RaiseServiceRequestFragment this$0, ProgressDialog dialog, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.DisplayErrorDialog();
        dialog.dismiss();
        volleyError.printStackTrace();
        RaiseServiceRequestModel raiseServiceRequestModel = this$0.getRaiseServiceRequestModel();
        User user = LSApplication.Companion.getUser();
        raiseServiceRequestModel.updateServiceLog(String.valueOf(user != null ? user.getId() : null), volleyError.toString());
    }

    private final void sendOTPVerification() {
        if (Intrinsics.areEqual(this.selectedReasonID, AppEventsConstants.EVENT_PARAM_VALUE_NO) || Intrinsics.areEqual(this.selectedSubReasonID, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            Toast.makeText(getActivity(), "Please select the reason and sub reason for the cancelation", 0).show();
        } else if (getRaiseServiceRequestModel().isFormValid(((EditText) _$_findCachedViewById(R.id.appointmentDate)).getText().toString())) {
            getRaiseServiceRequestModel().getCancelOTP();
            getRaiseServiceRequestModel().getOtpUpdateMessage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda23
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RaiseServiceRequestFragment.m1239sendOTPVerification$lambda32(RaiseServiceRequestFragment.this, (String) obj);
                }
            });
        } else {
            Toast.makeText(getActivity(), "Please select the appointment date and time", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendOTPVerification$lambda-32  reason: not valid java name */
    public static final void m1239sendOTPVerification$lambda32(RaiseServiceRequestFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getRaiseServiceRequestModel().getOtpVerificationMessage().setValue(null);
        if (StringsKt.equals(str, "OTP has been sent successfully", true)) {
            if (!this$0.isShowOtp) {
                Toast.makeText(this$0.getActivity(), str, 0).show();
                this$0.isShowOtp = true;
            }
            if (this$0.isResend) {
                return;
            }
            this$0.showOTPDialog();
            this$0.getRaiseServiceRequestModel().getOtpUpdateMessage().setValue(null);
            this$0.isResend = true;
        } else if (str == null || this$0.isShowOtp) {
        } else {
            Toast.makeText(this$0.getActivity(), str, 0).show();
            this$0.isShowOtp = true;
        }
    }

    private final void OTPVerification(String str) {
        if (Intrinsics.areEqual(this.selectedReasonID, AppEventsConstants.EVENT_PARAM_VALUE_NO) || Intrinsics.areEqual(this.selectedSubReasonID, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            Toast.makeText(getActivity(), "Please select the reason and sub reason for the cancelation", 0).show();
        } else if (getRaiseServiceRequestModel().isFormValid(((EditText) _$_findCachedViewById(R.id.appointmentDate)).getText().toString())) {
            this.isOtpVerify = false;
            getRaiseServiceRequestModel().verifyCancelOtp(str);
        } else {
            Toast.makeText(getActivity(), "Please select the appointment date and time", 0).show();
        }
    }

    private final void showOTPDialog() {
        View root;
        Context context;
        String string;
        Context context2 = getContext();
        final Dialog dialog = context2 != null ? new Dialog(context2) : null;
        if (dialog != null) {
            dialog.requestWindowFeature(1);
        }
        if (dialog != null) {
            dialog.setContentView(R.layout.custom_dialog_otp_verification);
        }
        Window window = dialog != null ? dialog.getWindow() : null;
        Intrinsics.checkNotNull(window);
        window.setLayout(-1, -2);
        Window window2 = dialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setBackgroundDrawable(new ColorDrawable(0));
        ImageView imageView = (ImageView) dialog.findViewById(R.id.cancel_btn);
        final TextView textView = (TextView) dialog.findViewById(R.id.ok_btn);
        TextView textView2 = (TextView) dialog.findViewById(R.id.tvResendOTP);
        TextView textView3 = (TextView) dialog.findViewById(R.id.tvDescription);
        final TextView textView4 = (TextView) dialog.findViewById(R.id.editTextNumber);
        final TextView textView5 = (TextView) dialog.findViewById(R.id.editTextNumber2);
        final TextView textView6 = (TextView) dialog.findViewById(R.id.editTextNumber3);
        final TextView textView7 = (TextView) dialog.findViewById(R.id.editTextNumber4);
        FragmentRaiseServiceRequestBinding fragmentRaiseServiceRequestBinding = this.dataBinding;
        if (fragmentRaiseServiceRequestBinding != null && (root = fragmentRaiseServiceRequestBinding.getRoot()) != null && (context = root.getContext()) != null && (string = context.getString(R.string.app_verification_code)) != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[1];
            User user = LSApplication.Companion.getUser();
            objArr[0] = String.valueOf(user != null ? user.getMobile() : null);
            r1 = String.format(string, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(r1, "format(format, *args)");
        }
        textView3.setText(r1);
        textView4.addTextChangedListener(new TextWatcher() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$showOTPDialog$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i2 == 1) {
                    textView5.requestFocus();
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (i3 == 1) {
                    textView5.requestFocus();
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (textView4.getText().length() == 1) {
                    textView5.requestFocus();
                }
            }
        });
        textView5.addTextChangedListener(new TextWatcher() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$showOTPDialog$2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i2 == 1) {
                    textView6.requestFocus();
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (i3 == 1) {
                    textView6.requestFocus();
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (textView5.getText().length() == 1) {
                    textView6.requestFocus();
                }
            }
        });
        textView6.addTextChangedListener(new TextWatcher() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$showOTPDialog$3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i2 == 1) {
                    textView7.requestFocus();
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (i3 == 1) {
                    textView7.requestFocus();
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (textView6.getText().length() == 1) {
                    textView7.requestFocus();
                }
            }
        });
        textView7.addTextChangedListener(new TextWatcher() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$showOTPDialog$4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i2 == 1) {
                    textView.requestFocus();
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (i3 == 1) {
                    textView.requestFocus();
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (textView7.getText().length() == 1) {
                    textView.requestFocus();
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1241showOTPDialog$lambda36(textView4, textView5, textView6, textView7, this, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1242showOTPDialog$lambda37(RaiseServiceRequestFragment.this, view);
            }
        });
        final Dialog dialog2 = dialog;
        getRaiseServiceRequestModel().getOtpVerificationMessage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda25
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RaiseServiceRequestFragment.m1243showOTPDialog$lambda38(RaiseServiceRequestFragment.this, dialog2, textView4, textView5, textView6, textView7, (String) obj);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showOTPDialog$lambda-36  reason: not valid java name */
    public static final void m1241showOTPDialog$lambda36(TextView textView, TextView textView2, TextView textView3, TextView textView4, RaiseServiceRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!Intrinsics.areEqual(textView.getText().toString(), "") && !Intrinsics.areEqual(textView2.getText().toString(), "") && !Intrinsics.areEqual(textView3.getText().toString(), "") && !Intrinsics.areEqual(textView4.getText().toString(), "")) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s%s%s%s", Arrays.copyOf(new Object[]{textView.getText(), textView2.getText(), textView3.getText(), textView4.getText()}, 4));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            this$0.OTPVerification(format);
            return;
        }
        Toast.makeText(this$0.getActivity(), "Please enter the OTP", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showOTPDialog$lambda-37  reason: not valid java name */
    public static final void m1242showOTPDialog$lambda37(RaiseServiceRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isResend = true;
        this$0.isShowOtp = false;
        this$0.sendOTPVerification();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showOTPDialog$lambda-38  reason: not valid java name */
    public static final void m1243showOTPDialog$lambda38(RaiseServiceRequestFragment this$0, Dialog dialog, TextView textView, TextView textView2, TextView textView3, TextView textView4, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (StringsKt.equals(str, "Otp verified!", true)) {
            this$0.validateAndUpdateHumsar();
            dialog.dismiss();
            if (this$0.isOtpVerify) {
                return;
            }
            Toast.makeText(this$0.getActivity(), str, 1).show();
            this$0.isOtpVerify = true;
            return;
        }
        textView.setText("");
        textView2.setText("");
        textView3.setText("");
        textView4.setText("");
        textView.setHint("-");
        textView2.setHint("-");
        textView3.setHint("-");
        textView4.setHint("-");
        textView.requestFocus();
        if (str == null || this$0.isOtpVerify) {
            return;
        }
        Toast.makeText(this$0.getActivity(), str, 1).show();
        this$0.isOtpVerify = true;
    }

    private final void validateAndUpdateHumsar() {
        String str;
        Date parse;
        if (Intrinsics.areEqual(this.selectedReasonID, AppEventsConstants.EVENT_PARAM_VALUE_NO) || Intrinsics.areEqual(this.selectedSubReasonID, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            Toast.makeText(getActivity(), "Please select the reason and sub reason for the cancelation", 0).show();
        } else if (getRaiseServiceRequestModel().isFormValid(((EditText) _$_findCachedViewById(R.id.appointmentDate)).getText().toString())) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            try {
                parse = simpleDateFormat.parse(this._appintmentDateTime);
            } catch (Exception unused) {
                str = "";
            }
            if (parse == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.util.Date");
            }
            str = String.valueOf(getDateInUTC(parse));
            Calendar calendar = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(calendar.getTime());
            Intrinsics.checkNotNullExpressionValue(format, "formatDateTime.format(c.time)");
            this.createDate = format;
            final ProgressDialog progressDialog = new ProgressDialog(getContext());
            progressDialog.setMessage("Please Wait..");
            progressDialog.show();
            progressDialog.setCancelable(false);
            HashMap hashMap = new HashMap();
            hashMap.put("TokenNo", LSHConfig.HUMSAR_TOKEN_NO);
            User user = LSApplication.Companion.getUser();
            hashMap.put("LSH_ID", String.valueOf(user != null ? user.getId() : null));
            User user2 = LSApplication.Companion.getUser();
            hashMap.put("Mobile_No", String.valueOf(user2 != null ? user2.getMobile() : null));
            String serialNumber = getNavArgs().getSerialNumber();
            Intrinsics.checkNotNullExpressionValue(serialNumber, "navArgs.serialNumber");
            hashMap.put("Serial_No", serialNumber);
            hashMap.put("Request_Type", "Stopped Service");
            hashMap.put("Pickup_Date_Time", str);
            hashMap.put("Customer_Remarks", ((EditText) _$_findCachedViewById(R.id.requestBox)).getText().toString());
            hashMap.put("Reason_ID", this.selectedReasonID);
            hashMap.put("SubReason_ID", this.selectedSubReasonID);
            Volley.newRequestQueue(getContext()).add(new JsonObjectRequest(1, "http://humsar.sar-group.com/MobileAPI/AppServices.svc/WAAS_Cancellation", new JSONObject(hashMap), new Response.Listener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda29
                @Override // com.android.volley.Response.Listener
                public final void onResponse(Object obj) {
                    RaiseServiceRequestFragment.m1244validateAndUpdateHumsar$lambda39(progressDialog, this, (JSONObject) obj);
                }
            }, new Response.ErrorListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda27
                @Override // com.android.volley.Response.ErrorListener
                public final void onErrorResponse(VolleyError volleyError) {
                    RaiseServiceRequestFragment.m1245validateAndUpdateHumsar$lambda40(RaiseServiceRequestFragment.this, progressDialog, volleyError);
                }
            }));
        } else {
            Toast.makeText(getActivity(), "Please select the appointment date and time", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: validateAndUpdateHumsar$lambda-39  reason: not valid java name */
    public static final void m1244validateAndUpdateHumsar$lambda39(ProgressDialog dialog, RaiseServiceRequestFragment this$0, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        boolean z = jSONObject != null ? jSONObject.getBoolean("Status") : false;
        String string = jSONObject != null ? jSONObject.getString("Message") : null;
        if (string == null) {
            string = "";
        }
        if (z) {
            this$0.DisplayDialog(string, false);
            RaiseServiceRequestModel raiseServiceRequestModel = this$0.getRaiseServiceRequestModel();
            User user = LSApplication.Companion.getUser();
            String valueOf = String.valueOf(user != null ? user.getId() : null);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "it.toString()");
            raiseServiceRequestModel.updateServiceLog(valueOf, jSONObject2);
            return;
        }
        Toast.makeText(this$0.getActivity(), string, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: validateAndUpdateHumsar$lambda-40  reason: not valid java name */
    public static final void m1245validateAndUpdateHumsar$lambda40(RaiseServiceRequestFragment this$0, ProgressDialog dialog, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.DisplayErrorDialog();
        dialog.dismiss();
        volleyError.printStackTrace();
        RaiseServiceRequestModel raiseServiceRequestModel = this$0.getRaiseServiceRequestModel();
        User user = LSApplication.Companion.getUser();
        raiseServiceRequestModel.updateServiceLog(String.valueOf(user != null ? user.getId() : null), volleyError.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0227  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void ValidateData() {
        /*
            Method dump skipped, instructions count: 921
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment.ValidateData():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ValidateData$lambda-43  reason: not valid java name */
    public static final void m1209ValidateData$lambda43(ProgressDialog dialog, String url, JSONObject parameters, RaiseServiceRequestFragment this$0, JSONObject jSONObject) {
        String str;
        View root;
        Context context;
        String string;
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(parameters, "$parameters");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        Log.e("Url", url);
        Log.e("parameters", parameters.toString());
        Log.e("it", jSONObject.toString());
        String string2 = jSONObject != null ? jSONObject.getString("status") : null;
        if (string2 == null) {
            string2 = "";
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = string2.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, "success")) {
            Boolean valueOf = jSONObject != null ? Boolean.valueOf(jSONObject.has("js_number")) : null;
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.booleanValue()) {
                String string3 = jSONObject.getString("js_number");
                String str2 = string3 != null ? string3 : "";
                FragmentRaiseServiceRequestBinding fragmentRaiseServiceRequestBinding = this$0.dataBinding;
                if (fragmentRaiseServiceRequestBinding == null || (root = fragmentRaiseServiceRequestBinding.getRoot()) == null || (context = root.getContext()) == null || (string = context.getString(R.string.your_job_sheet)) == null) {
                    str = null;
                } else {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    str = String.format(string, Arrays.copyOf(new Object[]{str2}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                }
                Intrinsics.checkNotNull(str);
                this$0.DisplayDialog(str, false);
            }
        } else {
            String string4 = jSONObject != null ? jSONObject.getString("msg") : null;
            if (StringsKt.equals(string4 != null ? string4 : "", "Jobsheet already opened", true)) {
                NavDirections actionContactUsFragmentToRaiseServiceRequestHistoryFragment = RaiseServiceRequestFragmentDirections.actionContactUsFragmentToRaiseServiceRequestHistoryFragment();
                Intrinsics.checkNotNullExpressionValue(actionContactUsFragmentToRaiseServiceRequestHistoryFragment, "actionContactUsFragmentT…eRequestHistoryFragment()");
                FragmentKt.findNavController(this$0).navigate(actionContactUsFragmentToRaiseServiceRequestHistoryFragment);
            } else {
                this$0.DisplayErrorDialog();
            }
        }
        RaiseServiceRequestModel raiseServiceRequestModel = this$0.getRaiseServiceRequestModel();
        User user = LSApplication.Companion.getUser();
        String valueOf2 = String.valueOf(user != null ? user.getId() : null);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "it.toString()");
        raiseServiceRequestModel.updateServiceLog(valueOf2, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ValidateData$lambda-44  reason: not valid java name */
    public static final void m1210ValidateData$lambda44(RaiseServiceRequestFragment this$0, ProgressDialog dialog, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.DisplayErrorDialog();
        dialog.dismiss();
        volleyError.printStackTrace();
        RaiseServiceRequestModel raiseServiceRequestModel = this$0.getRaiseServiceRequestModel();
        User user = LSApplication.Companion.getUser();
        raiseServiceRequestModel.updateServiceLog(String.valueOf(user != null ? user.getId() : null), volleyError.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ValidateData$lambda-45  reason: not valid java name */
    public static final void m1211ValidateData$lambda45(RaiseServiceRequestFragment this$0, RefreshRechargeResponse refreshRechargeResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (refreshRechargeResponse.getStatus() != null) {
            Boolean status = refreshRechargeResponse.getStatus();
            Intrinsics.checkNotNull(status);
            if (status.booleanValue()) {
                String message = refreshRechargeResponse.getMessage();
                Intrinsics.checkNotNull(message);
                this$0.DisplayDialog(message, false);
                return;
            }
            Toast.makeText(this$0.getActivity(), refreshRechargeResponse.getMessage(), 0).show();
            return;
        }
        Toast.makeText(this$0.getActivity(), "Recharge refreshed. please sync the device.", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ValidateData$lambda-47  reason: not valid java name */
    public static final void m1212ValidateData$lambda47(RaiseServiceRequestFragment this$0, String str) {
        View root;
        Context context;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (StringsKt.equals(str, "Success", true)) {
            FragmentRaiseServiceRequestBinding fragmentRaiseServiceRequestBinding = this$0.dataBinding;
            this$0.DisplayDialog(String.valueOf((fragmentRaiseServiceRequestBinding == null || (root = fragmentRaiseServiceRequestBinding.getRoot()) == null || (context = root.getContext()) == null) ? null : context.getString(R.string.other_job_sheet)), true);
        }
    }

    private final void DisplayDialog(String str, boolean z) {
        Context context = getContext();
        final Dialog dialog = context != null ? new Dialog(context) : null;
        if (dialog != null) {
            dialog.requestWindowFeature(1);
        }
        if (dialog != null) {
            dialog.setContentView(R.layout.dialog_request_successfully);
        }
        Window window = dialog != null ? dialog.getWindow() : null;
        Intrinsics.checkNotNull(window);
        window.setLayout(-1, -2);
        Window window2 = dialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setBackgroundDrawable(new ColorDrawable(0));
        if (z) {
            ((TextView) dialog.findViewById(R.id.tvIcon)).setBackgroundResource(R.drawable.ic_noun_call_support_2075190_1);
        }
        ((TextView) dialog.findViewById(R.id.jobDescription)).setText(str);
        ((TextView) dialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1207DisplayDialog$lambda49(dialog, this, view);
            }
        });
        dialog.show();
        dialog.setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: DisplayDialog$lambda-49  reason: not valid java name */
    public static final void m1207DisplayDialog$lambda49(Dialog dialog, RaiseServiceRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        if (this$0.isAdded()) {
            FragmentKt.findNavController(this$0).popBackStack();
        }
    }

    private final void DisplayErrorDialog() {
        Context context = getContext();
        final Dialog dialog = context != null ? new Dialog(context) : null;
        if (dialog != null) {
            dialog.requestWindowFeature(1);
        }
        if (dialog != null) {
            dialog.setContentView(R.layout.dialog_service_request_error);
        }
        Window window = dialog != null ? dialog.getWindow() : null;
        Intrinsics.checkNotNull(window);
        window.setLayout(-1, -2);
        Window window2 = dialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) dialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RaiseServiceRequestFragment$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RaiseServiceRequestFragment.m1208DisplayErrorDialog$lambda51(dialog, this, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: DisplayErrorDialog$lambda-51  reason: not valid java name */
    public static final void m1208DisplayErrorDialog$lambda51(Dialog dialog, RaiseServiceRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        FragmentKt.findNavController(this$0).popBackStack();
    }
}
