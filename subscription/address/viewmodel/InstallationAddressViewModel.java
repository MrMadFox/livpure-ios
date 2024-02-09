package com.livpure.safedrink.subscription.address.viewmodel;

import android.content.Context;
import android.view.View;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.segment.SegmentLogger;
import com.livpure.safedrink.subscription.address.data.AddressRepository;
import com.livpure.safedrink.subscription.address.data.CRMRepository;
import com.livpure.safedrink.subscription.address.data.CitiesRepository;
import com.livpure.safedrink.subscription.address.data.model.CitiesResponse;
import com.livpure.safedrink.subscription.address.data.model.CityDetailsItem;
import com.livpure.safedrink.subscription.address.data.model.SavedAddressItem;
import com.livpure.safedrink.subscription.address.data.model.ServiceableAreaItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: InstallationAddressViewModel.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 D2\u00020\u0001:\u0002DEB\u0005¢\u0006\u0002\u0010\u0002J\b\u00108\u001a\u000209H\u0002J\u0018\u0010:\u001a\u00020;2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0002J\f\u0010=\u001a\b\u0012\u0004\u0012\u0002010.J\u0012\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001b0.J\u0012\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001b0.J\b\u0010@\u001a\u00020;H\u0002J\u000e\u0010A\u001a\u00020;2\u0006\u0010B\u001a\u00020CR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b*\u0010+R\u001a\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001b0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001b0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007R\u000e\u00106\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/livpure/safedrink/subscription/address/viewmodel/InstallationAddressViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "addressLine1", "Landroidx/lifecycle/MutableLiveData;", "", "getAddressLine1", "()Landroidx/lifecycle/MutableLiveData;", "addressLine1Error", "getAddressLine1Error", "addressLine2", "getAddressLine2", "addressLine2Error", "getAddressLine2Error", "addressRepository", "Lcom/livpure/safedrink/subscription/address/data/AddressRepository;", "getAddressRepository", "()Lcom/livpure/safedrink/subscription/address/data/AddressRepository;", "addressRepository$delegate", "Lkotlin/Lazy;", "alternateMobileNumber", "getAlternateMobileNumber", "area", "getArea", "areaError", "getAreaError", "areaResponseLiveData", "", "Lcom/livpure/safedrink/subscription/address/data/model/ServiceableAreaItem;", "citiesRepository", "Lcom/livpure/safedrink/subscription/address/data/CitiesRepository;", "getCitiesRepository", "()Lcom/livpure/safedrink/subscription/address/data/CitiesRepository;", "citiesRepository$delegate", "city", "getCity", "cityError", "getCityError", "cityResponseLiveData", "Lcom/livpure/safedrink/subscription/address/data/model/CitiesResponse;", "crmRepository", "Lcom/livpure/safedrink/subscription/address/data/CRMRepository;", "getCrmRepository", "()Lcom/livpure/safedrink/subscription/address/data/CRMRepository;", "crmRepository$delegate", "listOfAreas", "Landroidx/lifecycle/LiveData;", "listOfCities", "navigationState", "Lcom/livpure/safedrink/subscription/address/viewmodel/InstallationAddressViewModel$InstallationAddressNavigationStates;", "pinCode", "getPinCode", "pinCodeError", "getPinCodeError", "selectedHubCode", "selectedState", "isFormValidated", "", "loadAreaSpinner", "", "listOfAreaItems", "observeNavigationStates", "populateAreasWhenAvailable", "populateCitiesWhenAvailable", "resetAreaSpinner", "saveAddress", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "Companion", "InstallationAddressNavigationStates", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstallationAddressViewModel extends MediatorViewModel {
    public static final Companion Companion = new Companion(null);
    private static final String PINCODE_BEFORE_AREA_MESSAGE = "Please enter a valid pincode first";
    private final MutableLiveData<String> addressLine1;
    private final MutableLiveData<String> addressLine1Error;
    private final MutableLiveData<String> addressLine2;
    private final MutableLiveData<String> addressLine2Error;
    private final Lazy addressRepository$delegate;
    private final MutableLiveData<String> alternateMobileNumber;
    private final MutableLiveData<String> area;
    private final MutableLiveData<String> areaError;
    private final MutableLiveData<List<ServiceableAreaItem>> areaResponseLiveData;
    private final Lazy citiesRepository$delegate;
    private final MutableLiveData<String> city;
    private final MutableLiveData<String> cityError;
    private final MutableLiveData<CitiesResponse> cityResponseLiveData;
    private final Lazy crmRepository$delegate;
    private final LiveData<List<String>> listOfAreas;
    private final LiveData<List<String>> listOfCities;
    private final MutableLiveData<InstallationAddressNavigationStates> navigationState;
    private final MutableLiveData<String> pinCode;
    private final MutableLiveData<String> pinCodeError;
    private String selectedHubCode;
    private String selectedState;

    /* compiled from: InstallationAddressViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/livpure/safedrink/subscription/address/viewmodel/InstallationAddressViewModel$InstallationAddressNavigationStates;", "", "(Ljava/lang/String;I)V", "BACK", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum InstallationAddressNavigationStates {
        BACK
    }

    public InstallationAddressViewModel() {
        String pinCode;
        String address;
        String address2;
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        User user = LSApplication.Companion.getUser();
        List split$default = (user == null || (address2 = user.getAddress()) == null) ? null : StringsKt.split$default((CharSequence) address2, new String[]{","}, false, 0, 6, (Object) null);
        List list = split$default;
        String str = "";
        mutableLiveData.setValue(!(list == null || list.isEmpty()) ? StringsKt.trim((CharSequence) ((String) split$default.get(0))).toString() : "");
        this.addressLine1 = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        User user2 = LSApplication.Companion.getUser();
        List split$default2 = (user2 == null || (address = user2.getAddress()) == null) ? null : StringsKt.split$default((CharSequence) address, new String[]{","}, false, 2, 2, (Object) null);
        mutableLiveData2.setValue((split$default2 == null || split$default2.size() < 2) ? "" : StringsKt.trim((CharSequence) ((String) split$default2.get(1))).toString());
        this.addressLine2 = mutableLiveData2;
        this.alternateMobileNumber = new MutableLiveData<>();
        this.crmRepository$delegate = LazyKt.lazy(new Function0<CRMRepository>() { // from class: com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel$crmRepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CRMRepository invoke() {
                return new CRMRepository();
            }
        });
        this.citiesRepository$delegate = LazyKt.lazy(new Function0<CitiesRepository>() { // from class: com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel$citiesRepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CitiesRepository invoke() {
                return new CitiesRepository();
            }
        });
        this.addressRepository$delegate = LazyKt.lazy(new Function0<AddressRepository>() { // from class: com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel$addressRepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AddressRepository invoke() {
                return new AddressRepository();
            }
        });
        this.navigationState = new MutableLiveData<>();
        MutableLiveData<List<ServiceableAreaItem>> mutableLiveData3 = new MutableLiveData<>();
        mutableLiveData3.setValue(null);
        this.areaResponseLiveData = mutableLiveData3;
        MutableLiveData<CitiesResponse> mutableLiveData4 = new MutableLiveData<>();
        this.cityResponseLiveData = mutableLiveData4;
        this.selectedHubCode = "";
        this.selectedState = "";
        this.city = new MutableLiveData<>();
        LiveData<List<String>> map = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                List m1278listOfCities$lambda5;
                m1278listOfCities$lambda5 = InstallationAddressViewModel.m1278listOfCities$lambda5(InstallationAddressViewModel.this, (CitiesResponse) obj);
                return m1278listOfCities$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(cityResponseLiveData…\n        citiesList\n    }");
        this.listOfCities = map;
        MutableLiveData<String> mutableLiveData5 = new MutableLiveData<>();
        User user3 = LSApplication.Companion.getUser();
        if (user3 != null && (pinCode = user3.getPinCode()) != null) {
            str = pinCode;
        }
        mutableLiveData5.setValue(str);
        observeAndTrack(mutableLiveData5, new Observer() { // from class: com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                InstallationAddressViewModel.m1279pinCode$lambda9$lambda8(InstallationAddressViewModel.this, (String) obj);
            }
        });
        this.pinCode = mutableLiveData5;
        this.addressLine1Error = new MutableLiveData<>();
        this.addressLine2Error = new MutableLiveData<>();
        this.pinCodeError = new MutableLiveData<>();
        this.areaError = new MutableLiveData<>();
        this.cityError = new MutableLiveData<>();
        MutableLiveData<String> mutableLiveData6 = new MutableLiveData<>();
        observeAndTrack(mutableLiveData6, new Observer() { // from class: com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                InstallationAddressViewModel.m1276area$lambda11$lambda10(InstallationAddressViewModel.this, (String) obj);
            }
        });
        this.area = mutableLiveData6;
        LiveData<List<String>> map2 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel$$ExternalSyntheticLambda1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                List m1277listOfAreas$lambda14;
                m1277listOfAreas$lambda14 = InstallationAddressViewModel.m1277listOfAreas$lambda14(InstallationAddressViewModel.this, (List) obj);
                return m1277listOfAreas$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "map(areaResponseLiveData…}\n        areasList\n    }");
        this.listOfAreas = map2;
    }

    public final MutableLiveData<String> getAddressLine1() {
        return this.addressLine1;
    }

    public final MutableLiveData<String> getAddressLine2() {
        return this.addressLine2;
    }

    public final MutableLiveData<String> getAlternateMobileNumber() {
        return this.alternateMobileNumber;
    }

    private final CRMRepository getCrmRepository() {
        return (CRMRepository) this.crmRepository$delegate.getValue();
    }

    private final CitiesRepository getCitiesRepository() {
        return (CitiesRepository) this.citiesRepository$delegate.getValue();
    }

    private final AddressRepository getAddressRepository() {
        return (AddressRepository) this.addressRepository$delegate.getValue();
    }

    public final MutableLiveData<String> getCity() {
        return this.city;
    }

    /* compiled from: InstallationAddressViewModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/subscription/address/viewmodel/InstallationAddressViewModel$Companion;", "", "()V", "PINCODE_BEFORE_AREA_MESSAGE", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listOfCities$lambda-5  reason: not valid java name */
    public static final List m1278listOfCities$lambda5(InstallationAddressViewModel this$0, CitiesResponse citiesResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList arrayList = new ArrayList();
        List<CityDetailsItem> cityDetailsList = citiesResponse.getCityDetailsList();
        if (cityDetailsList != null) {
            for (CityDetailsItem cityDetailsItem : cityDetailsList) {
                String cityName = cityDetailsItem.getCityName();
                if (cityName != null) {
                    arrayList.add(cityName);
                }
            }
        }
        User user = LSApplication.Companion.getUser();
        String city = user != null ? user.getCity() : null;
        if (!(city == null || StringsKt.isBlank(city))) {
            MutableLiveData<String> mutableLiveData = this$0.city;
            User user2 = LSApplication.Companion.getUser();
            mutableLiveData.setValue(user2 != null ? user2.getCity() : null);
        }
        return arrayList;
    }

    public final MutableLiveData<String> getPinCode() {
        return this.pinCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: pinCode$lambda-9$lambda-8  reason: not valid java name */
    public static final void m1279pinCode$lambda9$lambda8(final InstallationAddressViewModel this$0, String pinCodeText) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pinCodeText.length() == 6) {
            if (LSApplication.Companion.isNetworkAvailable()) {
                this$0.getLoading().setValue(true);
                CRMRepository crmRepository = this$0.getCrmRepository();
                Intrinsics.checkNotNullExpressionValue(pinCodeText, "pinCodeText");
                this$0.observeAndTrack(crmRepository.getMappedAreas(pinCodeText), new Observer() { // from class: com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel$$ExternalSyntheticLambda5
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        InstallationAddressViewModel.m1280pinCode$lambda9$lambda8$lambda7(InstallationAddressViewModel.this, (List) obj);
                    }
                });
                return;
            }
            this$0.getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
            return;
        }
        this$0.resetAreaSpinner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: pinCode$lambda-9$lambda-8$lambda-7  reason: not valid java name */
    public static final void m1280pinCode$lambda9$lambda8$lambda7(InstallationAddressViewModel this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z = false;
        this$0.getLoading().setValue(false);
        List list2 = list;
        if (!(list2 == null || list2.isEmpty()) && ((ServiceableAreaItem) list.get(0)).getMessage() == null) {
            this$0.pinCodeError.setValue(null);
            this$0.loadAreaSpinner(list);
            return;
        }
        if (!((list2 == null || list2.isEmpty()) ? true : true)) {
            this$0.pinCodeError.setValue("This pincode is either invalid or not serviceable.");
        }
        this$0.resetAreaSpinner();
    }

    public final MutableLiveData<String> getAddressLine1Error() {
        return this.addressLine1Error;
    }

    public final MutableLiveData<String> getAddressLine2Error() {
        return this.addressLine2Error;
    }

    public final MutableLiveData<String> getPinCodeError() {
        return this.pinCodeError;
    }

    public final MutableLiveData<String> getAreaError() {
        return this.areaError;
    }

    public final MutableLiveData<String> getCityError() {
        return this.cityError;
    }

    public final MutableLiveData<String> getArea() {
        return this.area;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: area$lambda-11$lambda-10  reason: not valid java name */
    public static final void m1276area$lambda11$lambda10(InstallationAddressViewModel this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(str, PINCODE_BEFORE_AREA_MESSAGE)) {
            return;
        }
        List<String> value = this$0.listOfAreas.getValue();
        int indexOf = value != null ? value.indexOf(str) : -1;
        if (indexOf != -1) {
            List<ServiceableAreaItem> value2 = this$0.areaResponseLiveData.getValue();
            Intrinsics.checkNotNull(value2);
            String hubCode = value2.get(indexOf).getHubCode();
            if (hubCode == null) {
                hubCode = "";
            }
            this$0.selectedHubCode = hubCode;
            List<ServiceableAreaItem> value3 = this$0.areaResponseLiveData.getValue();
            Intrinsics.checkNotNull(value3);
            String state = value3.get(indexOf).getState();
            this$0.selectedState = state != null ? state : "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
        if (r7.contains(r1) == true) goto L35;
     */
    /* renamed from: listOfAreas$lambda-14  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List m1277listOfAreas$lambda14(com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel r6, java.util.List r7) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            if (r7 == 0) goto L2a
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L14:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L2a
            java.lang.Object r1 = r7.next()
            com.livpure.safedrink.subscription.address.data.model.ServiceableAreaItem r1 = (com.livpure.safedrink.subscription.address.data.model.ServiceableAreaItem) r1
            java.lang.String r1 = r1.getArea()
            if (r1 == 0) goto L14
            r0.add(r1)
            goto L14
        L2a:
            boolean r7 = r0.isEmpty()
            if (r7 == 0) goto L35
            java.lang.String r7 = "Please enter a valid pincode first"
            r0.add(r7)
        L35:
            com.livpure.safedrink.app.LSApplication$Companion r7 = com.livpure.safedrink.app.LSApplication.Companion
            com.livpure.safedrink.login.data.models.User r7 = r7.getUser()
            java.lang.String r1 = ""
            if (r7 == 0) goto L45
            java.lang.String r7 = r7.getArea()
            if (r7 != 0) goto L46
        L45:
            r7 = r1
        L46:
            boolean r7 = r0.contains(r7)
            if (r7 == 0) goto L9a
            androidx.lifecycle.MutableLiveData<java.lang.String> r7 = r6.area
            com.livpure.safedrink.app.LSApplication$Companion r2 = com.livpure.safedrink.app.LSApplication.Companion
            com.livpure.safedrink.login.data.models.User r2 = r2.getUser()
            r3 = 0
            if (r2 == 0) goto L5c
            java.lang.String r2 = r2.getArea()
            goto L5d
        L5c:
            r2 = r3
        L5d:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r7.setValue(r2)
            androidx.lifecycle.LiveData<java.util.List<java.lang.String>> r7 = r6.listOfCities
            java.lang.Object r7 = r7.getValue()
            java.util.List r7 = (java.util.List) r7
            r2 = 1
            r4 = 0
            if (r7 == 0) goto L86
            com.livpure.safedrink.app.LSApplication$Companion r5 = com.livpure.safedrink.app.LSApplication.Companion
            com.livpure.safedrink.login.data.models.User r5 = r5.getUser()
            if (r5 == 0) goto L7f
            java.lang.String r5 = r5.getCity()
            if (r5 != 0) goto L7e
            goto L7f
        L7e:
            r1 = r5
        L7f:
            boolean r7 = r7.contains(r1)
            if (r7 != r2) goto L86
            goto L87
        L86:
            r2 = 0
        L87:
            if (r2 == 0) goto L9a
            androidx.lifecycle.MutableLiveData<java.lang.String> r6 = r6.city
            com.livpure.safedrink.app.LSApplication$Companion r7 = com.livpure.safedrink.app.LSApplication.Companion
            com.livpure.safedrink.login.data.models.User r7 = r7.getUser()
            if (r7 == 0) goto L97
            java.lang.String r3 = r7.getCity()
        L97:
            r6.setValue(r3)
        L9a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel.m1277listOfAreas$lambda14(com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel, java.util.List):java.util.List");
    }

    public final LiveData<InstallationAddressNavigationStates> observeNavigationStates() {
        return this.navigationState;
    }

    public final LiveData<List<String>> populateCitiesWhenAvailable() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            try {
                getLoading().setValue(true);
                observeAndTrack(getCitiesRepository().getCities(), new Observer() { // from class: com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel$$ExternalSyntheticLambda2
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        InstallationAddressViewModel.m1281populateCitiesWhenAvailable$lambda15(InstallationAddressViewModel.this, (CitiesResponse) obj);
                    }
                });
            } catch (APIException unused) {
                getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue while looking up serviceable cities"));
            }
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
        return this.listOfCities;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: populateCitiesWhenAvailable$lambda-15  reason: not valid java name */
    public static final void m1281populateCitiesWhenAvailable$lambda15(final InstallationAddressViewModel this$0, final CitiesResponse citiesResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(citiesResponse, new Function1<CitiesResponse, Unit>() { // from class: com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel$populateCitiesWhenAvailable$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CitiesResponse citiesResponse2) {
                invoke2(citiesResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CitiesResponse successfulResponse) {
                MutableLiveData toastMessageLiveData;
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                List<CityDetailsItem> cityDetailsList = CitiesResponse.this.getCityDetailsList();
                if (!(cityDetailsList == null || cityDetailsList.isEmpty())) {
                    mutableLiveData = this$0.cityResponseLiveData;
                    mutableLiveData.setValue(successfulResponse);
                    return;
                }
                toastMessageLiveData = this$0.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Sorry! We faced an issue while looking up serviceable cities"));
            }
        }, new Function1<CitiesResponse, Unit>() { // from class: com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel$populateCitiesWhenAvailable$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CitiesResponse citiesResponse2) {
                invoke2(citiesResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CitiesResponse failedResponse) {
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(failedResponse, "failedResponse");
                toastMessageLiveData = InstallationAddressViewModel.this.getToastMessageLiveData();
                String message = failedResponse.getMessage();
                if (message == null) {
                    message = "Sorry! We faced an issue while looking up serviceable cities";
                }
                toastMessageLiveData.setValue(new Event(message));
            }
        });
    }

    public final LiveData<List<String>> populateAreasWhenAvailable() {
        return this.listOfAreas;
    }

    public final void saveAddress(final View view) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        if (isFormValidated()) {
            boolean z = true;
            getLoading().setValue(true);
            if (LSApplication.Companion.isNetworkAvailable()) {
                AddressRepository addressRepository = getAddressRepository();
                String value = this.addressLine2.getValue();
                if (value != null && !StringsKt.isBlank(value)) {
                    z = false;
                }
                if (z) {
                    String value2 = this.addressLine1.getValue();
                    Intrinsics.checkNotNull(value2);
                    str = value2;
                } else {
                    str = this.addressLine1.getValue() + ", " + this.addressLine2.getValue();
                }
                String str2 = str;
                String value3 = this.pinCode.getValue();
                Intrinsics.checkNotNull(value3);
                String str3 = value3;
                String value4 = this.city.getValue();
                Intrinsics.checkNotNull(value4);
                String str4 = value4;
                String value5 = this.area.getValue();
                Intrinsics.checkNotNull(value5);
                observeAndTrack(addressRepository.saveAddress(str2, str3, str4, value5, this.selectedHubCode, this.selectedState, this.alternateMobileNumber.getValue()), new Observer() { // from class: com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel$$ExternalSyntheticLambda6
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        InstallationAddressViewModel.m1282saveAddress$lambda16(InstallationAddressViewModel.this, view, (BaseDataHolder) obj);
                    }
                });
                return;
            }
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveAddress$lambda-16  reason: not valid java name */
    public static final void m1282saveAddress$lambda16(InstallationAddressViewModel this$0, View view, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        this$0.getLoading().setValue(false);
        SavedAddressItem savedAddressItem = (SavedAddressItem) baseDataHolder.getData();
        if ((savedAddressItem != null ? savedAddressItem.getSavedAddress() : null) != null) {
            User user = LSApplication.Companion.getUser();
            if (user != null) {
                user.setAddress(((SavedAddressItem) baseDataHolder.getData()).getSavedAddress().getAddress());
            }
            if (user != null) {
                user.setPinCode(((SavedAddressItem) baseDataHolder.getData()).getSavedAddress().getPinCode());
            }
            if (user != null) {
                user.setCity(((SavedAddressItem) baseDataHolder.getData()).getSavedAddress().getCity());
            }
            if (user != null) {
                user.setArea(((SavedAddressItem) baseDataHolder.getData()).getSavedAddress().getArea());
            }
            if (user != null) {
                user.setState(((SavedAddressItem) baseDataHolder.getData()).getSavedAddress().getState());
            }
            if (user != null) {
                user.setHubCode(((SavedAddressItem) baseDataHolder.getData()).getSavedAddress().getHubCode());
            }
            UserRepository.Companion companion = UserRepository.Companion;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            companion.getInstance(context).setUser(user);
            this$0.getToastMessageLiveData().setValue(new Event<>("Installation Address saved successfully!"));
            SegmentLogger.Companion companion2 = SegmentLogger.Companion;
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            companion2.with(context2).sendAddedAddressEvent(((SavedAddressItem) baseDataHolder.getData()).getSavedAddress().getCity(), ((SavedAddressItem) baseDataHolder.getData()).getSavedAddress().getState(), ((SavedAddressItem) baseDataHolder.getData()).getSavedAddress().getPinCode());
            this$0.navigationState.setValue(InstallationAddressNavigationStates.BACK);
            return;
        }
        MutableLiveData<Event<String>> toastMessageLiveData = this$0.getToastMessageLiveData();
        String message = baseDataHolder.getMessage();
        if (message == null) {
            message = "Sorry! We faced an issue saving your address. Please check all the fields and try again.";
        }
        toastMessageLiveData.setValue(new Event<>(message));
    }

    private final boolean isFormValidated() {
        boolean z;
        String value = this.addressLine1.getValue();
        boolean z2 = true;
        if (value == null || StringsKt.isBlank(value)) {
            this.addressLine1Error.setValue("This information is required.");
            z = false;
        } else {
            this.addressLine1Error.setValue(null);
            z = true;
        }
        String value2 = this.addressLine2.getValue();
        if (value2 == null || StringsKt.isBlank(value2)) {
            this.addressLine2Error.setValue("This information is required.");
            z = false;
        } else {
            this.addressLine2Error.setValue(null);
        }
        String value3 = this.pinCode.getValue();
        if (!(value3 == null || StringsKt.isBlank(value3))) {
            String value4 = this.pinCode.getValue();
            if (value4 != null && value4.length() == 6) {
                this.pinCodeError.setValue(null);
                String value5 = this.city.getValue();
                if (value5 == null || StringsKt.isBlank(value5)) {
                    this.cityError.setValue("Please select a valid city.");
                    z = false;
                } else {
                    this.cityError.setValue(null);
                }
                String value6 = this.area.getValue();
                if (value6 != null && !StringsKt.isBlank(value6)) {
                    z2 = false;
                }
                if (z2) {
                    this.areaError.setValue("Please select a valid area.");
                    return false;
                } else if (Intrinsics.areEqual(this.area.getValue(), PINCODE_BEFORE_AREA_MESSAGE)) {
                    this.pinCodeError.setValue("Please enter a valid 6-digit pin code.");
                    this.areaError.setValue("");
                    return false;
                } else {
                    this.areaError.setValue(null);
                    return z;
                }
            }
        }
        this.pinCodeError.setValue("Please enter a valid 6-digit pin code.");
        return false;
    }

    private final void resetAreaSpinner() {
        this.areaResponseLiveData.setValue(null);
        MutableLiveData<String> mutableLiveData = this.area;
        if (mutableLiveData != null) {
            mutableLiveData.setValue(null);
        }
        MutableLiveData<String> mutableLiveData2 = this.city;
        if (mutableLiveData2 == null) {
            return;
        }
        mutableLiveData2.setValue(null);
    }

    private final void loadAreaSpinner(List<ServiceableAreaItem> list) {
        this.areaResponseLiveData.setValue(list);
    }
}
