package com.livpure.safedrink.referNearn.viewmodels;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.facebook.appevents.AppEventsConstants;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.login.api.models.response.ReferralData;
import com.livpure.safedrink.login.api.models.response.ReferralLinkResponse;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.referNearn.model.LaderShipArrayResponse;
import com.livpure.safedrink.referNearn.model.ReferralHistoryResponse;
import com.livpure.safedrink.referNearn.model.ReferralRequest;
import com.livpure.safedrink.referNearn.model.TopThreeRankResponse;
import com.livpure.safedrink.referNearn.model.leadershipBoard;
import com.livpure.safedrink.referNearn.model.referralHistory;
import com.livpure.safedrink.referNearn.repository.ReferralRepository;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ReferAndEarnViewModel.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020>J\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00190A2\u0006\u0010B\u001a\u00020CR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R&\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R&\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\f0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0007\"\u0004\b7\u0010\u0010R\u0017\u00108\u001a\b\u0012\u0004\u0012\u0002090\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0007R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0007¨\u0006D"}, d2 = {"Lcom/livpure/safedrink/referNearn/viewmodels/ReferAndEarnViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "InviteNoow", "Landroidx/lifecycle/MutableLiveData;", "", "getInviteNoow", "()Landroidx/lifecycle/MutableLiveData;", "freeWater", "", "getFreeWater", "laderShipArrayList", "", "Lcom/livpure/safedrink/referNearn/model/LaderShipArrayResponse;", "getLaderShipArrayList", "setLaderShipArrayList", "(Landroidx/lifecycle/MutableLiveData;)V", "referCount", "getReferCount", "referRank", "getReferRank", "referalHistoryList", "Lcom/livpure/safedrink/referNearn/model/ReferralHistoryResponse;", "getReferalHistoryList", "referralLinkResponse", "Lcom/livpure/safedrink/login/api/models/response/ReferralLinkResponse;", "referralMonth", "getReferralMonth", "referralRepository", "Lcom/livpure/safedrink/referNearn/repository/ReferralRepository;", "getReferralRepository", "()Lcom/livpure/safedrink/referNearn/repository/ReferralRepository;", "referralRepository$delegate", "Lkotlin/Lazy;", "top1AlliasName", "getTop1AlliasName", "top1Count", "getTop1Count", "top1Name", "getTop1Name", "top2AlliasName", "getTop2AlliasName", "top2Count", "getTop2Count", "top2Name", "getTop2Name", "top3AlliasName", "getTop3AlliasName", "top3Count", "getTop3Count", "top3Name", "getTop3Name", "topThreeRankList", "Lcom/livpure/safedrink/referNearn/model/TopThreeRankResponse;", "getTopThreeRankList", "setTopThreeRankList", "user", "Lcom/livpure/safedrink/login/data/models/User;", "getUser", "voucher", "getVoucher", "getLeadershipBoard", "", "getReferralHistory", "getReferralLink", "Landroidx/lifecycle/LiveData;", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferAndEarnViewModel extends MediatorViewModel {
    private final MutableLiveData<Boolean> InviteNoow;
    private final MutableLiveData<String> freeWater;
    private MutableLiveData<List<LaderShipArrayResponse>> laderShipArrayList;
    private final MutableLiveData<String> referCount;
    private final MutableLiveData<String> referRank;
    private final MutableLiveData<List<ReferralHistoryResponse>> referalHistoryList;
    private final MutableLiveData<ReferralLinkResponse> referralLinkResponse;
    private final MutableLiveData<String> referralMonth;
    private final Lazy referralRepository$delegate;
    private final MutableLiveData<String> top1AlliasName;
    private final MutableLiveData<String> top1Count;
    private final MutableLiveData<String> top1Name;
    private final MutableLiveData<String> top2AlliasName;
    private final MutableLiveData<String> top2Count;
    private final MutableLiveData<String> top2Name;
    private final MutableLiveData<String> top3AlliasName;
    private final MutableLiveData<String> top3Count;
    private final MutableLiveData<String> top3Name;
    private MutableLiveData<List<TopThreeRankResponse>> topThreeRankList;
    private final MutableLiveData<User> user;
    private final MutableLiveData<String> voucher;

    public ReferAndEarnViewModel() {
        MutableLiveData<User> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(LSApplication.Companion.getUser());
        this.user = mutableLiveData;
        this.referralRepository$delegate = LazyKt.lazy(new Function0<ReferralRepository>() { // from class: com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel$referralRepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ReferralRepository invoke() {
                return new ReferralRepository();
            }
        });
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue("");
        this.voucher = mutableLiveData2;
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        mutableLiveData3.setValue("");
        this.freeWater = mutableLiveData3;
        MutableLiveData<String> mutableLiveData4 = new MutableLiveData<>();
        mutableLiveData4.setValue("");
        this.top1Name = mutableLiveData4;
        MutableLiveData<String> mutableLiveData5 = new MutableLiveData<>();
        mutableLiveData5.setValue("");
        this.top1Count = mutableLiveData5;
        MutableLiveData<String> mutableLiveData6 = new MutableLiveData<>();
        mutableLiveData6.setValue("");
        this.top1AlliasName = mutableLiveData6;
        MutableLiveData<String> mutableLiveData7 = new MutableLiveData<>();
        mutableLiveData7.setValue("");
        this.top2Name = mutableLiveData7;
        MutableLiveData<String> mutableLiveData8 = new MutableLiveData<>();
        mutableLiveData8.setValue("");
        this.top2Count = mutableLiveData8;
        MutableLiveData<String> mutableLiveData9 = new MutableLiveData<>();
        mutableLiveData9.setValue("");
        this.top2AlliasName = mutableLiveData9;
        MutableLiveData<String> mutableLiveData10 = new MutableLiveData<>();
        mutableLiveData10.setValue("");
        this.top3Name = mutableLiveData10;
        MutableLiveData<String> mutableLiveData11 = new MutableLiveData<>();
        mutableLiveData11.setValue("");
        this.top3Count = mutableLiveData11;
        MutableLiveData<String> mutableLiveData12 = new MutableLiveData<>();
        mutableLiveData12.setValue("");
        this.top3AlliasName = mutableLiveData12;
        MutableLiveData<Boolean> mutableLiveData13 = new MutableLiveData<>();
        mutableLiveData13.setValue(false);
        this.InviteNoow = mutableLiveData13;
        MutableLiveData<String> mutableLiveData14 = new MutableLiveData<>();
        mutableLiveData14.setValue("");
        this.referralMonth = mutableLiveData14;
        MutableLiveData<String> mutableLiveData15 = new MutableLiveData<>();
        mutableLiveData15.setValue("");
        this.referRank = mutableLiveData15;
        MutableLiveData<String> mutableLiveData16 = new MutableLiveData<>();
        mutableLiveData16.setValue("");
        this.referCount = mutableLiveData16;
        this.referalHistoryList = new MutableLiveData<>();
        this.topThreeRankList = new MutableLiveData<>();
        this.laderShipArrayList = new MutableLiveData<>();
        this.referralLinkResponse = new MutableLiveData<>();
    }

    public final MutableLiveData<User> getUser() {
        return this.user;
    }

    private final ReferralRepository getReferralRepository() {
        return (ReferralRepository) this.referralRepository$delegate.getValue();
    }

    public final MutableLiveData<String> getVoucher() {
        return this.voucher;
    }

    public final MutableLiveData<String> getFreeWater() {
        return this.freeWater;
    }

    public final MutableLiveData<String> getTop1Name() {
        return this.top1Name;
    }

    public final MutableLiveData<String> getTop1Count() {
        return this.top1Count;
    }

    public final MutableLiveData<String> getTop1AlliasName() {
        return this.top1AlliasName;
    }

    public final MutableLiveData<String> getTop2Name() {
        return this.top2Name;
    }

    public final MutableLiveData<String> getTop2Count() {
        return this.top2Count;
    }

    public final MutableLiveData<String> getTop2AlliasName() {
        return this.top2AlliasName;
    }

    public final MutableLiveData<String> getTop3Name() {
        return this.top3Name;
    }

    public final MutableLiveData<String> getTop3Count() {
        return this.top3Count;
    }

    public final MutableLiveData<String> getTop3AlliasName() {
        return this.top3AlliasName;
    }

    public final MutableLiveData<Boolean> getInviteNoow() {
        return this.InviteNoow;
    }

    public final MutableLiveData<String> getReferralMonth() {
        return this.referralMonth;
    }

    public final MutableLiveData<String> getReferRank() {
        return this.referRank;
    }

    public final MutableLiveData<String> getReferCount() {
        return this.referCount;
    }

    public final MutableLiveData<List<ReferralHistoryResponse>> getReferalHistoryList() {
        return this.referalHistoryList;
    }

    public final MutableLiveData<List<TopThreeRankResponse>> getTopThreeRankList() {
        return this.topThreeRankList;
    }

    public final void setTopThreeRankList(MutableLiveData<List<TopThreeRankResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.topThreeRankList = mutableLiveData;
    }

    public final MutableLiveData<List<LaderShipArrayResponse>> getLaderShipArrayList() {
        return this.laderShipArrayList;
    }

    public final void setLaderShipArrayList(MutableLiveData<List<LaderShipArrayResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.laderShipArrayList = mutableLiveData;
    }

    public final void getReferralHistory() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            User value = this.user.getValue();
            try {
                observeAndTrack(getReferralRepository().getReferralHistory(new ReferralRequest(value != null ? value.getId() : null, "")), new Observer() { // from class: com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel$$ExternalSyntheticLambda1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ReferAndEarnViewModel.m1137getReferralHistory$lambda16(ReferAndEarnViewModel.this, (BaseDataHolder) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue while fetching your dashboard details at this time."));
                return;
            }
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getReferralHistory$lambda-16  reason: not valid java name */
    public static final void m1137getReferralHistory$lambda16(ReferAndEarnViewModel this$0, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        if (baseDataHolder.getData() != null) {
            this$0.voucher.setValue(String.valueOf(((referralHistory) baseDataHolder.getData()).getReferralCount()));
            this$0.freeWater.setValue(String.valueOf(((referralHistory) baseDataHolder.getData()).getReferralLiters()));
            if (((referralHistory) baseDataHolder.getData()).getReferralHistory() != null) {
                this$0.referalHistoryList.setValue(((referralHistory) baseDataHolder.getData()).getReferralHistory());
                return;
            }
            return;
        }
        this$0.voucher.setValue(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this$0.freeWater.setValue("0 L");
        this$0.InviteNoow.setValue(true);
    }

    public final void getLeadershipBoard() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            User value = this.user.getValue();
            try {
                observeAndTrack(getReferralRepository().getLeadershipBoard(new ReferralRequest(value != null ? value.getId() : null, format.toString())), new Observer() { // from class: com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel$$ExternalSyntheticLambda0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ReferAndEarnViewModel.m1136getLeadershipBoard$lambda17(ReferAndEarnViewModel.this, (BaseDataHolder) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue while fetching your dashboard details at this time."));
                return;
            }
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getLeadershipBoard$lambda-17  reason: not valid java name */
    public static final void m1136getLeadershipBoard$lambda17(ReferAndEarnViewModel this$0, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        leadershipBoard leadershipboard = (leadershipBoard) baseDataHolder.getData();
        if ((leadershipboard != null ? leadershipboard.getReferralMonth() : null) != null) {
            this$0.referralMonth.setValue(((leadershipBoard) baseDataHolder.getData()).getReferralMonth().toString());
        }
        leadershipBoard leadershipboard2 = (leadershipBoard) baseDataHolder.getData();
        if ((leadershipboard2 != null ? leadershipboard2.getTopThreeRank() : null) != null) {
            this$0.topThreeRankList.setValue(((leadershipBoard) baseDataHolder.getData()).getTopThreeRank());
            for (TopThreeRankResponse topThreeRankResponse : ((leadershipBoard) baseDataHolder.getData()).getTopThreeRank()) {
                if (Intrinsics.areEqual(String.valueOf(topThreeRankResponse.getReferRank()), "1")) {
                    this$0.top1Name.setValue(topThreeRankResponse.getReferName().toString());
                    this$0.top1Count.setValue(String.valueOf(topThreeRankResponse.getReferCount()));
                    this$0.top1AlliasName.setValue(topThreeRankResponse.getReferAlliasName().toString());
                } else if (Intrinsics.areEqual(String.valueOf(topThreeRankResponse.getReferRank()), ExifInterface.GPS_MEASUREMENT_2D)) {
                    this$0.top2Name.setValue(topThreeRankResponse.getReferName().toString());
                    this$0.top2Count.setValue(String.valueOf(topThreeRankResponse.getReferCount()));
                    this$0.top2AlliasName.setValue(topThreeRankResponse.getReferAlliasName().toString());
                } else if (Intrinsics.areEqual(String.valueOf(topThreeRankResponse.getReferRank()), ExifInterface.GPS_MEASUREMENT_3D)) {
                    this$0.top3Name.setValue(topThreeRankResponse.getReferName().toString());
                    this$0.top3Count.setValue(String.valueOf(topThreeRankResponse.getReferCount()));
                    this$0.top3AlliasName.setValue(topThreeRankResponse.getReferAlliasName().toString());
                }
            }
        }
        leadershipBoard leadershipboard3 = (leadershipBoard) baseDataHolder.getData();
        if ((leadershipboard3 != null ? leadershipboard3.getLeaderShipArray() : null) != null) {
            this$0.laderShipArrayList.setValue(((leadershipBoard) baseDataHolder.getData()).getLeaderShipArray());
        }
        leadershipBoard leadershipboard4 = (leadershipBoard) baseDataHolder.getData();
        if ((leadershipboard4 != null ? leadershipboard4.getMyRank() : null) != null) {
            this$0.referRank.setValue(String.valueOf(((leadershipBoard) baseDataHolder.getData()).getMyRank().getReferRank()));
            this$0.referCount.setValue(String.valueOf(((leadershipBoard) baseDataHolder.getData()).getMyRank().getReferCount()));
        }
    }

    public final LiveData<ReferralLinkResponse> getReferralLink(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (LSApplication.Companion.isNetworkAvailable()) {
            User user = LSApplication.Companion.getUser();
            String id = user != null ? user.getId() : null;
            if (!(id == null || StringsKt.isBlank(id))) {
                getLoading().setValue(true);
                try {
                    User user2 = LSApplication.Companion.getUser();
                    Intrinsics.checkNotNull(user2);
                    String id2 = user2.getId();
                    Intrinsics.checkNotNull(id2);
                    observeAndTrack(UserRepository.Companion.getInstance(context).getReferralLink(id2), new Observer() { // from class: com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel$$ExternalSyntheticLambda2
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            ReferAndEarnViewModel.m1138getReferralLink$lambda18(ReferAndEarnViewModel.this, (ReferralLinkResponse) obj);
                        }
                    });
                } catch (APIException unused) {
                    getLoading().setValue(false);
                    getToastMessageLiveData().setValue(new Event<>("Oops! We faced some issue while fetching referral link."));
                }
            }
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
        return this.referralLinkResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getReferralLink$lambda-18  reason: not valid java name */
    public static final void m1138getReferralLink$lambda18(final ReferAndEarnViewModel this$0, ReferralLinkResponse referralLinkResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(referralLinkResponse, new Function1<ReferralLinkResponse, Unit>() { // from class: com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel$getReferralLink$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ReferralLinkResponse referralLinkResponse2) {
                invoke2(referralLinkResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ReferralLinkResponse successfulResponse) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                LSApplication.Companion companion = LSApplication.Companion;
                ReferralData data = successfulResponse.getData();
                Intrinsics.checkNotNull(data);
                companion.setReferralLink(data.getRefShortLink());
                mutableLiveData = ReferAndEarnViewModel.this.referralLinkResponse;
                mutableLiveData.setValue(successfulResponse);
            }
        }, new Function1<ReferralLinkResponse, Unit>() { // from class: com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel$getReferralLink$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ReferralLinkResponse referralLinkResponse2) {
                invoke2(referralLinkResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ReferralLinkResponse failedResponse) {
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(failedResponse, "failedResponse");
                toastMessageLiveData = ReferAndEarnViewModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Oops! We faced some issue while fetching referral link."));
            }
        });
    }
}
