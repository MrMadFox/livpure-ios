package com.livpure.safedrink;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.databinding.ActivitySingleMainBindingImpl;
import com.livpure.safedrink.databinding.AdapterAirpurifierBottomOptionsBindingImpl;
import com.livpure.safedrink.databinding.AdapterAutoCompleteBindingImpl;
import com.livpure.safedrink.databinding.AdapterDispenserBottomOptionsBindingImpl;
import com.livpure.safedrink.databinding.AdapterExpandablePlanLayoutBindingImpl;
import com.livpure.safedrink.databinding.AdapterHolidayPlanLayoutBindingImpl;
import com.livpure.safedrink.databinding.AdapterNewPlanLayoutBindingImpl;
import com.livpure.safedrink.databinding.AdapterPlanDurationLayoutBindingImpl;
import com.livpure.safedrink.databinding.AdapterPlanDurationsLayoutBindingImpl;
import com.livpure.safedrink.databinding.AdapterPlanLayoutBindingImpl;
import com.livpure.safedrink.databinding.AdapterPlansDurationsLayoutBindingImpl;
import com.livpure.safedrink.databinding.AdapterRecommendedPlanLayoutBindingImpl;
import com.livpure.safedrink.databinding.AdapterReferrelDataLayoutBindingImpl;
import com.livpure.safedrink.databinding.AdapterReferrralHistoryBindingImpl;
import com.livpure.safedrink.databinding.AdapterReferrralSuperUserBindingImpl;
import com.livpure.safedrink.databinding.AdapterUnlimitedPlanLayoutBindingImpl;
import com.livpure.safedrink.databinding.DialogAirPurifierBottomSheetBindingImpl;
import com.livpure.safedrink.databinding.DialogRelocateSuccessfullyBindingImpl;
import com.livpure.safedrink.databinding.DialogRequestSuccessfullyBindingImpl;
import com.livpure.safedrink.databinding.DialogServiceRequestErrorBindingImpl;
import com.livpure.safedrink.databinding.DialogWifiListLayoutBindingImpl;
import com.livpure.safedrink.databinding.FragmentAddLitresBindingImpl;
import com.livpure.safedrink.databinding.FragmentAirtowaterBindingImpl;
import com.livpure.safedrink.databinding.FragmentCancelSubscriptionBindingImpl;
import com.livpure.safedrink.databinding.FragmentConfirmCancelSubscriptionBindingImpl;
import com.livpure.safedrink.databinding.FragmentDeviceHomeBindingImpl;
import com.livpure.safedrink.databinding.FragmentEmailMobileVerifyBindingImpl;
import com.livpure.safedrink.databinding.FragmentEnvyHomeBindingImpl;
import com.livpure.safedrink.databinding.FragmentForgotPasswordBindingImpl;
import com.livpure.safedrink.databinding.FragmentFurlencoHomeBindingImpl;
import com.livpure.safedrink.databinding.FragmentHomeAirpurifierBindingImpl;
import com.livpure.safedrink.databinding.FragmentHomeBindingImpl;
import com.livpure.safedrink.databinding.FragmentHomeDispenserAtlanticBindingImpl;
import com.livpure.safedrink.databinding.FragmentHomeDispenserMagnaBindingImpl;
import com.livpure.safedrink.databinding.FragmentHomeDispenserVeelineBindingImpl;
import com.livpure.safedrink.databinding.FragmentInstallationAddressBindingImpl;
import com.livpure.safedrink.databinding.FragmentKYCUploadBindingImpl;
import com.livpure.safedrink.databinding.FragmentOnboardingWebviewBindingImpl;
import com.livpure.safedrink.databinding.FragmentPlanBindingImpl;
import com.livpure.safedrink.databinding.FragmentPlanChangeBindingImpl;
import com.livpure.safedrink.databinding.FragmentPlanDurationBindingImpl;
import com.livpure.safedrink.databinding.FragmentProfileBindingImpl;
import com.livpure.safedrink.databinding.FragmentRaiseServiceRequestBindingImpl;
import com.livpure.safedrink.databinding.FragmentReferEarnBindingImpl;
import com.livpure.safedrink.databinding.FragmentReferralDataBindingImpl;
import com.livpure.safedrink.databinding.FragmentReferralHistoryBindingImpl;
import com.livpure.safedrink.databinding.FragmentReferralInvitesBindingImpl;
import com.livpure.safedrink.databinding.FragmentReferralLeaderBoardBindingImpl;
import com.livpure.safedrink.databinding.FragmentRelocationAddressBindingImpl;
import com.livpure.safedrink.databinding.FragmentResetPasswordBindingImpl;
import com.livpure.safedrink.databinding.FragmentReviewOrderBindingImpl;
import com.livpure.safedrink.databinding.FragmentSelectRechargePlanBindingImpl;
import com.livpure.safedrink.databinding.FragmentServiceRequestBindingImpl;
import com.livpure.safedrink.databinding.FragmentServiceRequestHistoryBindingImpl;
import com.livpure.safedrink.databinding.FragmentSignInBindingImpl;
import com.livpure.safedrink.databinding.FragmentSignUpBindingImpl;
import com.livpure.safedrink.databinding.FragmentTrackRelocationBindingImpl;
import com.livpure.safedrink.databinding.FragmentUnlimitedWaterHomeBindingImpl;
import com.livpure.safedrink.databinding.FragmentUploadKycBindingImpl;
import com.livpure.safedrink.databinding.FragmentWebviewBindingImpl;
import com.livpure.safedrink.databinding.FragmentWifiSettingsBindingImpl;
import com.livpure.safedrink.databinding.FrgmentHomeAirToWaterBindingImpl;
import com.livpure.safedrink.databinding.PlanPagerTitleLayoutBindingImpl;
import com.livpure.safedrink.databinding.RowItemSupportHistoryBindingImpl;
import com.livpure.safedrink.databinding.ViewDeviceBindingImpl;
import com.livpure.safedrink.databinding.ViewPlanBindingImpl;
import com.moengage.richnotification.internal.RichPushConstantsKt;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import io.branch.referral.Branch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYSINGLEMAIN = 1;
    private static final int LAYOUT_ADAPTERAIRPURIFIERBOTTOMOPTIONS = 2;
    private static final int LAYOUT_ADAPTERAUTOCOMPLETE = 3;
    private static final int LAYOUT_ADAPTERDISPENSERBOTTOMOPTIONS = 4;
    private static final int LAYOUT_ADAPTEREXPANDABLEPLANLAYOUT = 5;
    private static final int LAYOUT_ADAPTERHOLIDAYPLANLAYOUT = 6;
    private static final int LAYOUT_ADAPTERNEWPLANLAYOUT = 7;
    private static final int LAYOUT_ADAPTERPLANDURATIONLAYOUT = 8;
    private static final int LAYOUT_ADAPTERPLANDURATIONSLAYOUT = 9;
    private static final int LAYOUT_ADAPTERPLANLAYOUT = 10;
    private static final int LAYOUT_ADAPTERPLANSDURATIONSLAYOUT = 11;
    private static final int LAYOUT_ADAPTERRECOMMENDEDPLANLAYOUT = 12;
    private static final int LAYOUT_ADAPTERREFERRELDATALAYOUT = 13;
    private static final int LAYOUT_ADAPTERREFERRRALHISTORY = 14;
    private static final int LAYOUT_ADAPTERREFERRRALSUPERUSER = 15;
    private static final int LAYOUT_ADAPTERUNLIMITEDPLANLAYOUT = 16;
    private static final int LAYOUT_DIALOGAIRPURIFIERBOTTOMSHEET = 17;
    private static final int LAYOUT_DIALOGRELOCATESUCCESSFULLY = 18;
    private static final int LAYOUT_DIALOGREQUESTSUCCESSFULLY = 19;
    private static final int LAYOUT_DIALOGSERVICEREQUESTERROR = 20;
    private static final int LAYOUT_DIALOGWIFILISTLAYOUT = 21;
    private static final int LAYOUT_FRAGMENTADDLITRES = 22;
    private static final int LAYOUT_FRAGMENTAIRTOWATER = 23;
    private static final int LAYOUT_FRAGMENTCANCELSUBSCRIPTION = 24;
    private static final int LAYOUT_FRAGMENTCONFIRMCANCELSUBSCRIPTION = 25;
    private static final int LAYOUT_FRAGMENTDEVICEHOME = 26;
    private static final int LAYOUT_FRAGMENTEMAILMOBILEVERIFY = 27;
    private static final int LAYOUT_FRAGMENTENVYHOME = 28;
    private static final int LAYOUT_FRAGMENTFORGOTPASSWORD = 29;
    private static final int LAYOUT_FRAGMENTFURLENCOHOME = 30;
    private static final int LAYOUT_FRAGMENTHOME = 31;
    private static final int LAYOUT_FRAGMENTHOMEAIRPURIFIER = 32;
    private static final int LAYOUT_FRAGMENTHOMEDISPENSERATLANTIC = 33;
    private static final int LAYOUT_FRAGMENTHOMEDISPENSERMAGNA = 34;
    private static final int LAYOUT_FRAGMENTHOMEDISPENSERVEELINE = 35;
    private static final int LAYOUT_FRAGMENTINSTALLATIONADDRESS = 36;
    private static final int LAYOUT_FRAGMENTKYCUPLOAD = 37;
    private static final int LAYOUT_FRAGMENTONBOARDINGWEBVIEW = 38;
    private static final int LAYOUT_FRAGMENTPLAN = 39;
    private static final int LAYOUT_FRAGMENTPLANCHANGE = 40;
    private static final int LAYOUT_FRAGMENTPLANDURATION = 41;
    private static final int LAYOUT_FRAGMENTPROFILE = 42;
    private static final int LAYOUT_FRAGMENTRAISESERVICEREQUEST = 43;
    private static final int LAYOUT_FRAGMENTREFEREARN = 44;
    private static final int LAYOUT_FRAGMENTREFERRALDATA = 45;
    private static final int LAYOUT_FRAGMENTREFERRALHISTORY = 46;
    private static final int LAYOUT_FRAGMENTREFERRALINVITES = 47;
    private static final int LAYOUT_FRAGMENTREFERRALLEADERBOARD = 48;
    private static final int LAYOUT_FRAGMENTRELOCATIONADDRESS = 49;
    private static final int LAYOUT_FRAGMENTRESETPASSWORD = 50;
    private static final int LAYOUT_FRAGMENTREVIEWORDER = 51;
    private static final int LAYOUT_FRAGMENTSELECTRECHARGEPLAN = 52;
    private static final int LAYOUT_FRAGMENTSERVICEREQUEST = 53;
    private static final int LAYOUT_FRAGMENTSERVICEREQUESTHISTORY = 54;
    private static final int LAYOUT_FRAGMENTSIGNIN = 55;
    private static final int LAYOUT_FRAGMENTSIGNUP = 56;
    private static final int LAYOUT_FRAGMENTTRACKRELOCATION = 57;
    private static final int LAYOUT_FRAGMENTUNLIMITEDWATERHOME = 58;
    private static final int LAYOUT_FRAGMENTUPLOADKYC = 59;
    private static final int LAYOUT_FRAGMENTWEBVIEW = 60;
    private static final int LAYOUT_FRAGMENTWIFISETTINGS = 61;
    private static final int LAYOUT_FRGMENTHOMEAIRTOWATER = 62;
    private static final int LAYOUT_PLANPAGERTITLELAYOUT = 63;
    private static final int LAYOUT_ROWITEMSUPPORTHISTORY = 64;
    private static final int LAYOUT_VIEWDEVICE = 65;
    private static final int LAYOUT_VIEWPLAN = 66;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(66);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_single_main, 1);
        sparseIntArray.put(R.layout.adapter_airpurifier_bottom_options, 2);
        sparseIntArray.put(R.layout.adapter_auto_complete, 3);
        sparseIntArray.put(R.layout.adapter_dispenser_bottom_options, 4);
        sparseIntArray.put(R.layout.adapter_expandable_plan_layout, 5);
        sparseIntArray.put(R.layout.adapter_holiday_plan_layout, 6);
        sparseIntArray.put(R.layout.adapter_new_plan_layout, 7);
        sparseIntArray.put(R.layout.adapter_plan_duration_layout, 8);
        sparseIntArray.put(R.layout.adapter_plan_durations_layout, 9);
        sparseIntArray.put(R.layout.adapter_plan_layout, 10);
        sparseIntArray.put(R.layout.adapter_plans_durations_layout, 11);
        sparseIntArray.put(R.layout.adapter_recommended_plan_layout, 12);
        sparseIntArray.put(R.layout.adapter_referrel_data_layout, 13);
        sparseIntArray.put(R.layout.adapter_referrral_history, 14);
        sparseIntArray.put(R.layout.adapter_referrral_super_user, 15);
        sparseIntArray.put(R.layout.adapter_unlimited_plan_layout, 16);
        sparseIntArray.put(R.layout.dialog_air_purifier_bottom_sheet, 17);
        sparseIntArray.put(R.layout.dialog_relocate_successfully, 18);
        sparseIntArray.put(R.layout.dialog_request_successfully, 19);
        sparseIntArray.put(R.layout.dialog_service_request_error, 20);
        sparseIntArray.put(R.layout.dialog_wifi_list_layout, 21);
        sparseIntArray.put(R.layout.fragment_add_litres, 22);
        sparseIntArray.put(R.layout.fragment_airtowater, 23);
        sparseIntArray.put(R.layout.fragment_cancel_subscription, 24);
        sparseIntArray.put(R.layout.fragment_confirm_cancel_subscription, 25);
        sparseIntArray.put(R.layout.fragment_device_home, 26);
        sparseIntArray.put(R.layout.fragment_email_mobile_verify, 27);
        sparseIntArray.put(R.layout.fragment_envy_home, 28);
        sparseIntArray.put(R.layout.fragment_forgot_password, 29);
        sparseIntArray.put(R.layout.fragment_furlenco_home, 30);
        sparseIntArray.put(R.layout.fragment_home, 31);
        sparseIntArray.put(R.layout.fragment_home_airpurifier, 32);
        sparseIntArray.put(R.layout.fragment_home_dispenser_atlantic, 33);
        sparseIntArray.put(R.layout.fragment_home_dispenser_magna, 34);
        sparseIntArray.put(R.layout.fragment_home_dispenser_veeline, 35);
        sparseIntArray.put(R.layout.fragment_installation_address, 36);
        sparseIntArray.put(R.layout.fragment_k_y_c__upload, 37);
        sparseIntArray.put(R.layout.fragment_onboarding_webview, 38);
        sparseIntArray.put(R.layout.fragment_plan, 39);
        sparseIntArray.put(R.layout.fragment_plan_change, 40);
        sparseIntArray.put(R.layout.fragment_plan_duration, 41);
        sparseIntArray.put(R.layout.fragment_profile, 42);
        sparseIntArray.put(R.layout.fragment_raise_service_request, 43);
        sparseIntArray.put(R.layout.fragment_refer_earn, 44);
        sparseIntArray.put(R.layout.fragment_referral_data, 45);
        sparseIntArray.put(R.layout.fragment_referral_history, 46);
        sparseIntArray.put(R.layout.fragment_referral_invites, 47);
        sparseIntArray.put(R.layout.fragment_referral_leader_board, 48);
        sparseIntArray.put(R.layout.fragment_relocation_address, 49);
        sparseIntArray.put(R.layout.fragment_reset_password, 50);
        sparseIntArray.put(R.layout.fragment_review_order, 51);
        sparseIntArray.put(R.layout.fragment_select_recharge_plan, 52);
        sparseIntArray.put(R.layout.fragment_service_request, 53);
        sparseIntArray.put(R.layout.fragment_service_request_history, 54);
        sparseIntArray.put(R.layout.fragment_sign_in, 55);
        sparseIntArray.put(R.layout.fragment_sign_up, 56);
        sparseIntArray.put(R.layout.fragment_track_relocation, 57);
        sparseIntArray.put(R.layout.fragment_unlimited_water_home, 58);
        sparseIntArray.put(R.layout.fragment_upload_kyc, 59);
        sparseIntArray.put(R.layout.fragment_webview, 60);
        sparseIntArray.put(R.layout.fragment_wifi_settings, 61);
        sparseIntArray.put(R.layout.frgment_home_air_to_water, 62);
        sparseIntArray.put(R.layout.plan_pager_title_layout, 63);
        sparseIntArray.put(R.layout.row_item_support_history, 64);
        sparseIntArray.put(R.layout.view_device, 65);
        sparseIntArray.put(R.layout.view_plan, 66);
    }

    private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 1:
                if ("layout/activity_single_main_0".equals(tag)) {
                    return new ActivitySingleMainBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_single_main is invalid. Received: " + tag);
            case 2:
                if ("layout/adapter_airpurifier_bottom_options_0".equals(tag)) {
                    return new AdapterAirpurifierBottomOptionsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_airpurifier_bottom_options is invalid. Received: " + tag);
            case 3:
                if ("layout/adapter_auto_complete_0".equals(tag)) {
                    return new AdapterAutoCompleteBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_auto_complete is invalid. Received: " + tag);
            case 4:
                if ("layout/adapter_dispenser_bottom_options_0".equals(tag)) {
                    return new AdapterDispenserBottomOptionsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_dispenser_bottom_options is invalid. Received: " + tag);
            case 5:
                if ("layout/adapter_expandable_plan_layout_0".equals(tag)) {
                    return new AdapterExpandablePlanLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_expandable_plan_layout is invalid. Received: " + tag);
            case 6:
                if ("layout/adapter_holiday_plan_layout_0".equals(tag)) {
                    return new AdapterHolidayPlanLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_holiday_plan_layout is invalid. Received: " + tag);
            case 7:
                if ("layout/adapter_new_plan_layout_0".equals(tag)) {
                    return new AdapterNewPlanLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_new_plan_layout is invalid. Received: " + tag);
            case 8:
                if ("layout/adapter_plan_duration_layout_0".equals(tag)) {
                    return new AdapterPlanDurationLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_plan_duration_layout is invalid. Received: " + tag);
            case 9:
                if ("layout/adapter_plan_durations_layout_0".equals(tag)) {
                    return new AdapterPlanDurationsLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_plan_durations_layout is invalid. Received: " + tag);
            case 10:
                if ("layout/adapter_plan_layout_0".equals(tag)) {
                    return new AdapterPlanLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_plan_layout is invalid. Received: " + tag);
            case 11:
                if ("layout/adapter_plans_durations_layout_0".equals(tag)) {
                    return new AdapterPlansDurationsLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_plans_durations_layout is invalid. Received: " + tag);
            case 12:
                if ("layout/adapter_recommended_plan_layout_0".equals(tag)) {
                    return new AdapterRecommendedPlanLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_recommended_plan_layout is invalid. Received: " + tag);
            case 13:
                if ("layout/adapter_referrel_data_layout_0".equals(tag)) {
                    return new AdapterReferrelDataLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_referrel_data_layout is invalid. Received: " + tag);
            case 14:
                if ("layout/adapter_referrral_history_0".equals(tag)) {
                    return new AdapterReferrralHistoryBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_referrral_history is invalid. Received: " + tag);
            case 15:
                if ("layout/adapter_referrral_super_user_0".equals(tag)) {
                    return new AdapterReferrralSuperUserBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_referrral_super_user is invalid. Received: " + tag);
            case 16:
                if ("layout/adapter_unlimited_plan_layout_0".equals(tag)) {
                    return new AdapterUnlimitedPlanLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_unlimited_plan_layout is invalid. Received: " + tag);
            case 17:
                if ("layout/dialog_air_purifier_bottom_sheet_0".equals(tag)) {
                    return new DialogAirPurifierBottomSheetBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_air_purifier_bottom_sheet is invalid. Received: " + tag);
            case 18:
                if ("layout/dialog_relocate_successfully_0".equals(tag)) {
                    return new DialogRelocateSuccessfullyBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_relocate_successfully is invalid. Received: " + tag);
            case 19:
                if ("layout/dialog_request_successfully_0".equals(tag)) {
                    return new DialogRequestSuccessfullyBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_request_successfully is invalid. Received: " + tag);
            case 20:
                if ("layout/dialog_service_request_error_0".equals(tag)) {
                    return new DialogServiceRequestErrorBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_service_request_error is invalid. Received: " + tag);
            case 21:
                if ("layout/dialog_wifi_list_layout_0".equals(tag)) {
                    return new DialogWifiListLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_wifi_list_layout is invalid. Received: " + tag);
            case 22:
                if ("layout/fragment_add_litres_0".equals(tag)) {
                    return new FragmentAddLitresBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_add_litres is invalid. Received: " + tag);
            case 23:
                if ("layout/fragment_airtowater_0".equals(tag)) {
                    return new FragmentAirtowaterBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_airtowater is invalid. Received: " + tag);
            case 24:
                if ("layout/fragment_cancel_subscription_0".equals(tag)) {
                    return new FragmentCancelSubscriptionBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_cancel_subscription is invalid. Received: " + tag);
            case 25:
                if ("layout/fragment_confirm_cancel_subscription_0".equals(tag)) {
                    return new FragmentConfirmCancelSubscriptionBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_confirm_cancel_subscription is invalid. Received: " + tag);
            case 26:
                if ("layout/fragment_device_home_0".equals(tag)) {
                    return new FragmentDeviceHomeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_device_home is invalid. Received: " + tag);
            case 27:
                if ("layout/fragment_email_mobile_verify_0".equals(tag)) {
                    return new FragmentEmailMobileVerifyBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_email_mobile_verify is invalid. Received: " + tag);
            case 28:
                if ("layout/fragment_envy_home_0".equals(tag)) {
                    return new FragmentEnvyHomeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_envy_home is invalid. Received: " + tag);
            case 29:
                if ("layout/fragment_forgot_password_0".equals(tag)) {
                    return new FragmentForgotPasswordBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_forgot_password is invalid. Received: " + tag);
            case 30:
                if ("layout/fragment_furlenco_home_0".equals(tag)) {
                    return new FragmentFurlencoHomeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_furlenco_home is invalid. Received: " + tag);
            case 31:
                if ("layout/fragment_home_0".equals(tag)) {
                    return new FragmentHomeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
            case 32:
                if ("layout/fragment_home_airpurifier_0".equals(tag)) {
                    return new FragmentHomeAirpurifierBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_home_airpurifier is invalid. Received: " + tag);
            case 33:
                if ("layout/fragment_home_dispenser_atlantic_0".equals(tag)) {
                    return new FragmentHomeDispenserAtlanticBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_home_dispenser_atlantic is invalid. Received: " + tag);
            case 34:
                if ("layout/fragment_home_dispenser_magna_0".equals(tag)) {
                    return new FragmentHomeDispenserMagnaBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_home_dispenser_magna is invalid. Received: " + tag);
            case 35:
                if ("layout/fragment_home_dispenser_veeline_0".equals(tag)) {
                    return new FragmentHomeDispenserVeelineBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_home_dispenser_veeline is invalid. Received: " + tag);
            case 36:
                if ("layout/fragment_installation_address_0".equals(tag)) {
                    return new FragmentInstallationAddressBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_installation_address is invalid. Received: " + tag);
            case 37:
                if ("layout/fragment_k_y_c__upload_0".equals(tag)) {
                    return new FragmentKYCUploadBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_k_y_c__upload is invalid. Received: " + tag);
            case 38:
                if ("layout/fragment_onboarding_webview_0".equals(tag)) {
                    return new FragmentOnboardingWebviewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_onboarding_webview is invalid. Received: " + tag);
            case 39:
                if ("layout/fragment_plan_0".equals(tag)) {
                    return new FragmentPlanBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_plan is invalid. Received: " + tag);
            case 40:
                if ("layout/fragment_plan_change_0".equals(tag)) {
                    return new FragmentPlanChangeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_plan_change is invalid. Received: " + tag);
            case 41:
                if ("layout/fragment_plan_duration_0".equals(tag)) {
                    return new FragmentPlanDurationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_plan_duration is invalid. Received: " + tag);
            case 42:
                if ("layout/fragment_profile_0".equals(tag)) {
                    return new FragmentProfileBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
            case 43:
                if ("layout/fragment_raise_service_request_0".equals(tag)) {
                    return new FragmentRaiseServiceRequestBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_raise_service_request is invalid. Received: " + tag);
            case 44:
                if ("layout/fragment_refer_earn_0".equals(tag)) {
                    return new FragmentReferEarnBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_refer_earn is invalid. Received: " + tag);
            case 45:
                if ("layout/fragment_referral_data_0".equals(tag)) {
                    return new FragmentReferralDataBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_referral_data is invalid. Received: " + tag);
            case 46:
                if ("layout/fragment_referral_history_0".equals(tag)) {
                    return new FragmentReferralHistoryBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_referral_history is invalid. Received: " + tag);
            case 47:
                if ("layout/fragment_referral_invites_0".equals(tag)) {
                    return new FragmentReferralInvitesBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_referral_invites is invalid. Received: " + tag);
            case 48:
                if ("layout/fragment_referral_leader_board_0".equals(tag)) {
                    return new FragmentReferralLeaderBoardBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_referral_leader_board is invalid. Received: " + tag);
            case 49:
                if ("layout/fragment_relocation_address_0".equals(tag)) {
                    return new FragmentRelocationAddressBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_relocation_address is invalid. Received: " + tag);
            case 50:
                if ("layout/fragment_reset_password_0".equals(tag)) {
                    return new FragmentResetPasswordBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_reset_password is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 51:
                if ("layout/fragment_review_order_0".equals(tag)) {
                    return new FragmentReviewOrderBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_review_order is invalid. Received: " + tag);
            case 52:
                if ("layout/fragment_select_recharge_plan_0".equals(tag)) {
                    return new FragmentSelectRechargePlanBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_select_recharge_plan is invalid. Received: " + tag);
            case 53:
                if ("layout/fragment_service_request_0".equals(tag)) {
                    return new FragmentServiceRequestBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_service_request is invalid. Received: " + tag);
            case 54:
                if ("layout/fragment_service_request_history_0".equals(tag)) {
                    return new FragmentServiceRequestHistoryBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_service_request_history is invalid. Received: " + tag);
            case 55:
                if ("layout/fragment_sign_in_0".equals(tag)) {
                    return new FragmentSignInBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_sign_in is invalid. Received: " + tag);
            case 56:
                if ("layout/fragment_sign_up_0".equals(tag)) {
                    return new FragmentSignUpBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_sign_up is invalid. Received: " + tag);
            case 57:
                if ("layout/fragment_track_relocation_0".equals(tag)) {
                    return new FragmentTrackRelocationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_track_relocation is invalid. Received: " + tag);
            case 58:
                if ("layout/fragment_unlimited_water_home_0".equals(tag)) {
                    return new FragmentUnlimitedWaterHomeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_unlimited_water_home is invalid. Received: " + tag);
            case 59:
                if ("layout/fragment_upload_kyc_0".equals(tag)) {
                    return new FragmentUploadKycBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_upload_kyc is invalid. Received: " + tag);
            case 60:
                if ("layout/fragment_webview_0".equals(tag)) {
                    return new FragmentWebviewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_webview is invalid. Received: " + tag);
            case 61:
                if ("layout/fragment_wifi_settings_0".equals(tag)) {
                    return new FragmentWifiSettingsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_wifi_settings is invalid. Received: " + tag);
            case 62:
                if ("layout/frgment_home_air_to_water_0".equals(tag)) {
                    return new FrgmentHomeAirToWaterBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for frgment_home_air_to_water is invalid. Received: " + tag);
            case 63:
                if ("layout/plan_pager_title_layout_0".equals(tag)) {
                    return new PlanPagerTitleLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for plan_pager_title_layout is invalid. Received: " + tag);
            case 64:
                if ("layout/row_item_support_history_0".equals(tag)) {
                    return new RowItemSupportHistoryBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for row_item_support_history is invalid. Received: " + tag);
            case 65:
                if ("layout/view_device_0".equals(tag)) {
                    return new ViewDeviceBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for view_device is invalid. Received: " + tag);
            case 66:
                if ("layout/view_plan_0".equals(tag)) {
                    return new ViewPlanBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for view_plan is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
        int i = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
        if (i > 0) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new RuntimeException("view must have a tag");
            }
            int i2 = (i - 1) / 50;
            if (i2 != 0) {
                if (i2 != 1) {
                    return null;
                }
                return internalGetViewDataBinding1(component, view, i, tag);
            }
            return internalGetViewDataBinding0(component, view, i, tag);
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
        if (views == null || views.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId) <= 0 || views[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String tag) {
        Integer num;
        if (tag == null || (num = InnerLayoutIdLookup.sKeys.get(tag)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int localId) {
        return InnerBrLookup.sKeys.get(localId);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    /* loaded from: classes3.dex */
    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(19);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "activityViewModel");
            sparseArray.put(2, "callBack");
            sparseArray.put(3, AndroidContextPlugin.DEVICE_KEY);
            sparseArray.put(4, RichPushConstantsKt.PROPERTY_DURATION_KEY);
            sparseArray.put(5, "historyList");
            sparseArray.put(6, "isWifiRouter");
            sparseArray.put(7, "margin");
            sparseArray.put(8, "option");
            sparseArray.put(9, "paymentId");
            sparseArray.put(10, "plan");
            sparseArray.put(11, "planItem");
            sparseArray.put(12, "planTitle");
            sparseArray.put(13, "position");
            sparseArray.put(14, Branch.FEATURE_TAG_REFERRAL);
            sparseArray.put(15, "superUser");
            sparseArray.put(16, "user");
            sparseArray.put(17, "userData");
            sparseArray.put(18, "viewModel");
        }
    }

    /* loaded from: classes3.dex */
    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(66);
            sKeys = hashMap;
            hashMap.put("layout/activity_single_main_0", Integer.valueOf((int) R.layout.activity_single_main));
            hashMap.put("layout/adapter_airpurifier_bottom_options_0", Integer.valueOf((int) R.layout.adapter_airpurifier_bottom_options));
            hashMap.put("layout/adapter_auto_complete_0", Integer.valueOf((int) R.layout.adapter_auto_complete));
            hashMap.put("layout/adapter_dispenser_bottom_options_0", Integer.valueOf((int) R.layout.adapter_dispenser_bottom_options));
            hashMap.put("layout/adapter_expandable_plan_layout_0", Integer.valueOf((int) R.layout.adapter_expandable_plan_layout));
            hashMap.put("layout/adapter_holiday_plan_layout_0", Integer.valueOf((int) R.layout.adapter_holiday_plan_layout));
            hashMap.put("layout/adapter_new_plan_layout_0", Integer.valueOf((int) R.layout.adapter_new_plan_layout));
            hashMap.put("layout/adapter_plan_duration_layout_0", Integer.valueOf((int) R.layout.adapter_plan_duration_layout));
            hashMap.put("layout/adapter_plan_durations_layout_0", Integer.valueOf((int) R.layout.adapter_plan_durations_layout));
            hashMap.put("layout/adapter_plan_layout_0", Integer.valueOf((int) R.layout.adapter_plan_layout));
            hashMap.put("layout/adapter_plans_durations_layout_0", Integer.valueOf((int) R.layout.adapter_plans_durations_layout));
            hashMap.put("layout/adapter_recommended_plan_layout_0", Integer.valueOf((int) R.layout.adapter_recommended_plan_layout));
            hashMap.put("layout/adapter_referrel_data_layout_0", Integer.valueOf((int) R.layout.adapter_referrel_data_layout));
            hashMap.put("layout/adapter_referrral_history_0", Integer.valueOf((int) R.layout.adapter_referrral_history));
            hashMap.put("layout/adapter_referrral_super_user_0", Integer.valueOf((int) R.layout.adapter_referrral_super_user));
            hashMap.put("layout/adapter_unlimited_plan_layout_0", Integer.valueOf((int) R.layout.adapter_unlimited_plan_layout));
            hashMap.put("layout/dialog_air_purifier_bottom_sheet_0", Integer.valueOf((int) R.layout.dialog_air_purifier_bottom_sheet));
            hashMap.put("layout/dialog_relocate_successfully_0", Integer.valueOf((int) R.layout.dialog_relocate_successfully));
            hashMap.put("layout/dialog_request_successfully_0", Integer.valueOf((int) R.layout.dialog_request_successfully));
            hashMap.put("layout/dialog_service_request_error_0", Integer.valueOf((int) R.layout.dialog_service_request_error));
            hashMap.put("layout/dialog_wifi_list_layout_0", Integer.valueOf((int) R.layout.dialog_wifi_list_layout));
            hashMap.put("layout/fragment_add_litres_0", Integer.valueOf((int) R.layout.fragment_add_litres));
            hashMap.put("layout/fragment_airtowater_0", Integer.valueOf((int) R.layout.fragment_airtowater));
            hashMap.put("layout/fragment_cancel_subscription_0", Integer.valueOf((int) R.layout.fragment_cancel_subscription));
            hashMap.put("layout/fragment_confirm_cancel_subscription_0", Integer.valueOf((int) R.layout.fragment_confirm_cancel_subscription));
            hashMap.put("layout/fragment_device_home_0", Integer.valueOf((int) R.layout.fragment_device_home));
            hashMap.put("layout/fragment_email_mobile_verify_0", Integer.valueOf((int) R.layout.fragment_email_mobile_verify));
            hashMap.put("layout/fragment_envy_home_0", Integer.valueOf((int) R.layout.fragment_envy_home));
            hashMap.put("layout/fragment_forgot_password_0", Integer.valueOf((int) R.layout.fragment_forgot_password));
            hashMap.put("layout/fragment_furlenco_home_0", Integer.valueOf((int) R.layout.fragment_furlenco_home));
            hashMap.put("layout/fragment_home_0", Integer.valueOf((int) R.layout.fragment_home));
            hashMap.put("layout/fragment_home_airpurifier_0", Integer.valueOf((int) R.layout.fragment_home_airpurifier));
            hashMap.put("layout/fragment_home_dispenser_atlantic_0", Integer.valueOf((int) R.layout.fragment_home_dispenser_atlantic));
            hashMap.put("layout/fragment_home_dispenser_magna_0", Integer.valueOf((int) R.layout.fragment_home_dispenser_magna));
            hashMap.put("layout/fragment_home_dispenser_veeline_0", Integer.valueOf((int) R.layout.fragment_home_dispenser_veeline));
            hashMap.put("layout/fragment_installation_address_0", Integer.valueOf((int) R.layout.fragment_installation_address));
            hashMap.put("layout/fragment_k_y_c__upload_0", Integer.valueOf((int) R.layout.fragment_k_y_c__upload));
            hashMap.put("layout/fragment_onboarding_webview_0", Integer.valueOf((int) R.layout.fragment_onboarding_webview));
            hashMap.put("layout/fragment_plan_0", Integer.valueOf((int) R.layout.fragment_plan));
            hashMap.put("layout/fragment_plan_change_0", Integer.valueOf((int) R.layout.fragment_plan_change));
            hashMap.put("layout/fragment_plan_duration_0", Integer.valueOf((int) R.layout.fragment_plan_duration));
            hashMap.put("layout/fragment_profile_0", Integer.valueOf((int) R.layout.fragment_profile));
            hashMap.put("layout/fragment_raise_service_request_0", Integer.valueOf((int) R.layout.fragment_raise_service_request));
            hashMap.put("layout/fragment_refer_earn_0", Integer.valueOf((int) R.layout.fragment_refer_earn));
            hashMap.put("layout/fragment_referral_data_0", Integer.valueOf((int) R.layout.fragment_referral_data));
            hashMap.put("layout/fragment_referral_history_0", Integer.valueOf((int) R.layout.fragment_referral_history));
            hashMap.put("layout/fragment_referral_invites_0", Integer.valueOf((int) R.layout.fragment_referral_invites));
            hashMap.put("layout/fragment_referral_leader_board_0", Integer.valueOf((int) R.layout.fragment_referral_leader_board));
            hashMap.put("layout/fragment_relocation_address_0", Integer.valueOf((int) R.layout.fragment_relocation_address));
            hashMap.put("layout/fragment_reset_password_0", Integer.valueOf((int) R.layout.fragment_reset_password));
            hashMap.put("layout/fragment_review_order_0", Integer.valueOf((int) R.layout.fragment_review_order));
            hashMap.put("layout/fragment_select_recharge_plan_0", Integer.valueOf((int) R.layout.fragment_select_recharge_plan));
            hashMap.put("layout/fragment_service_request_0", Integer.valueOf((int) R.layout.fragment_service_request));
            hashMap.put("layout/fragment_service_request_history_0", Integer.valueOf((int) R.layout.fragment_service_request_history));
            hashMap.put("layout/fragment_sign_in_0", Integer.valueOf((int) R.layout.fragment_sign_in));
            hashMap.put("layout/fragment_sign_up_0", Integer.valueOf((int) R.layout.fragment_sign_up));
            hashMap.put("layout/fragment_track_relocation_0", Integer.valueOf((int) R.layout.fragment_track_relocation));
            hashMap.put("layout/fragment_unlimited_water_home_0", Integer.valueOf((int) R.layout.fragment_unlimited_water_home));
            hashMap.put("layout/fragment_upload_kyc_0", Integer.valueOf((int) R.layout.fragment_upload_kyc));
            hashMap.put("layout/fragment_webview_0", Integer.valueOf((int) R.layout.fragment_webview));
            hashMap.put("layout/fragment_wifi_settings_0", Integer.valueOf((int) R.layout.fragment_wifi_settings));
            hashMap.put("layout/frgment_home_air_to_water_0", Integer.valueOf((int) R.layout.frgment_home_air_to_water));
            hashMap.put("layout/plan_pager_title_layout_0", Integer.valueOf((int) R.layout.plan_pager_title_layout));
            hashMap.put("layout/row_item_support_history_0", Integer.valueOf((int) R.layout.row_item_support_history));
            hashMap.put("layout/view_device_0", Integer.valueOf((int) R.layout.view_device));
            hashMap.put("layout/view_plan_0", Integer.valueOf((int) R.layout.view_plan));
        }
    }
}
