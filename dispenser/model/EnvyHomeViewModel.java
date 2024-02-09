package com.livpure.safedrink.dispenser.model;

import android.content.Context;
import android.util.Log;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.facebook.appevents.AppEventsConstants;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.livpure.safedrink.R;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.bolt.data.BoltBleCommandsRespository;
import com.livpure.safedrink.bolt.data.BoltDataUpdateRepository;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import com.livpure.safedrink.bolt.data.models.RechargeResponse;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.dispenser.data.BLECommandListRepository;
import com.livpure.safedrink.dispenser.data.DispenserCommandsRepository;
import com.livpure.safedrink.dispenser.data.DispenserOflineRepository;
import com.livpure.safedrink.dispenser.data.EnvyBLEResponseRepository;
import com.livpure.safedrink.dispenser.data.models.DispenserCommands;
import com.livpure.safedrink.dispenser.data.models.DispenserImageStatus;
import com.livpure.safedrink.dispenser.data.models.DispenserPublishCommand;
import com.livpure.safedrink.dispenser.data.models.EnvyBLEResponse;
import com.livpure.safedrink.dispenser.data.models.EnvyDashbordOffline;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.subscription.plan.data.DispenserRoSetting;
import com.livpure.safedrink.subscription.plan.data.SubscriptionRepository;
import com.livpure.safedrink.subscription.plan.data.model.DashboardDetailsResponse;
import com.livpure.safedrink.subscription.plan.data.model.SerialNumberUpdateResponse;
import com.livpure.safedrink.subscription.plan.data.model.SubscriptionDetails;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.DailyConsumptionItem;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.DashboardDetails;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.ProductStats;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.Arrays;
import java.util.List;
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
import kotlin.text.StringsKt;
/* compiled from: EnvyHomeViewModel.kt */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010·\u0001\u001a\u00020\u00152\b\u0010¸\u0001\u001a\u00030¹\u0001J\u001d\u0010º\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0N0!2\b\u0010¸\u0001\u001a\u00030¹\u0001J\u001d\u0010»\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u007f0N0!2\b\u0010¸\u0001\u001a\u00030¹\u0001J\u001d\u0010¼\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0N0!2\b\u0010¸\u0001\u001a\u00030¹\u0001J\u0012\u0010½\u0001\u001a\u00030¶\u00012\b\u0010¸\u0001\u001a\u00030¹\u0001J\u0012\u0010¾\u0001\u001a\u00030¶\u00012\b\u0010¸\u0001\u001a\u00030¹\u0001J\u0011\u0010¿\u0001\u001a\u00030¶\u00012\u0007\u0010À\u0001\u001a\u00020\u0015J!\u0010Á\u0001\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!2\u0007\u0010Â\u0001\u001a\u00020\u00152\u0007\u0010Ã\u0001\u001a\u00020\u0015J-\u0010Ä\u0001\u001a\u00030¶\u00012\b\u0010¸\u0001\u001a\u00030¹\u00012\u0007\u0010Å\u0001\u001a\u00020\u00152\u0007\u0010·\u0001\u001a\u00020\u00152\u0007\u0010Æ\u0001\u001a\u00020\u001bJ\u0018\u0010Ç\u0001\u001a\u0004\u0018\u00010\"2\u0007\u0010È\u0001\u001a\u00020\u0015¢\u0006\u0003\u0010É\u0001J\u0018\u0010Ê\u0001\u001a\u0004\u0018\u00010\"2\u0007\u0010È\u0001\u001a\u00020\u0015¢\u0006\u0003\u0010É\u0001J#\u0010Ë\u0001\u001a\u00030¶\u00012\u0007\u0010Ì\u0001\u001a\u00020\u00152\u0007\u0010Í\u0001\u001a\u00020\u00152\u0007\u0010Î\u0001\u001a\u00020\u0015J\u001a\u0010Ï\u0001\u001a\u00030¶\u00012\u0007\u0010Ð\u0001\u001a\u00020\u00152\u0007\u0010Ñ\u0001\u001a\u00020\u0015R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010'\u001a\b\u0012\u0004\u0012\u00020\"0!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R\u001a\u00102\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020706X\u0082\u0004¢\u0006\u0002\n\u0000R(\u00109\u001a\u0004\u0018\u00010\u000f2\b\u00108\u001a\u0004\u0018\u00010\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0011\"\u0004\b;\u0010\u0013R\u001a\u0010<\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0017\"\u0004\b>\u0010\u0019R\u000e\u0010?\u001a\u00020@X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010C\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\b\u001a\u0004\bE\u0010FR\u001a\u0010H\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0017\"\u0004\bJ\u0010\u0019R\u000e\u0010K\u001a\u00020LX\u0082.¢\u0006\u0002\n\u0000R\u001d\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0N0+¢\u0006\b\n\u0000\u001a\u0004\bO\u0010.R\u000e\u0010P\u001a\u00020QX\u0082.¢\u0006\u0002\n\u0000R\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001506¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001506¢\u0006\b\n\u0000\u001a\u0004\bV\u0010TR\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\b\n\u0000\u001a\u0004\bX\u0010$R\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001b0!¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010$R\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00150!¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010$R\u001a\u0010]\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0017\"\u0004\b_\u0010\u0019R\u000e\u0010`\u001a\u00020aX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010b\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0017\"\u0004\bd\u0010\u0019R \u0010e\u001a\b\u0012\u0004\u0012\u00020\u001b0!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010$\"\u0004\bf\u0010&R \u0010g\u001a\b\u0012\u0004\u0012\u00020\u00150!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010$\"\u0004\bi\u0010&R\u001a\u0010j\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0017\"\u0004\bl\u0010\u0019R\u0017\u0010m\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\b\n\u0000\u001a\u0004\bn\u0010$R\u0017\u0010o\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\b\n\u0000\u001a\u0004\bp\u0010$R\u0017\u0010q\u001a\b\u0012\u0004\u0012\u00020\u001b0!¢\u0006\b\n\u0000\u001a\u0004\br\u0010$R\u001d\u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0N0+¢\u0006\b\n\u0000\u001a\u0004\bt\u0010.R\u0017\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00150!¢\u0006\b\n\u0000\u001a\u0004\bv\u0010$R\u0017\u0010w\u001a\b\u0012\u0004\u0012\u00020\u001506¢\u0006\b\n\u0000\u001a\u0004\bx\u0010TR \u0010y\u001a\b\u0012\u0004\u0012\u00020\u00150!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010$\"\u0004\b{\u0010&R\u0019\u0010|\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001506¢\u0006\b\n\u0000\u001a\u0004\b}\u0010TR\u001e\u0010~\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u007f0N0+¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010.R\u0019\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150!¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010$R \u0010\u0083\u0001\u001a\u00030\u0084\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001e\u0010\u0089\u0001\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u008b\u0001\u0010\b\u001a\u0005\b\u008a\u0001\u0010FR#\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010$\"\u0005\b\u008e\u0001\u0010&R\u001d\u0010\u008f\u0001\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0017\"\u0005\b\u0091\u0001\u0010\u0019R\u0019\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0!¢\u0006\t\n\u0000\u001a\u0005\b\u0093\u0001\u0010$R\u0019\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150!¢\u0006\t\n\u0000\u001a\u0005\b\u0095\u0001\u0010$R \u0010\u0096\u0001\u001a\u00030\u0097\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009a\u0001\u0010\b\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0019\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\t\n\u0000\u001a\u0005\b\u009c\u0001\u0010$R\u001d\u0010\u009d\u0001\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010\u0017\"\u0005\b\u009f\u0001\u0010\u0019R=\u0010 \u0001\u001a,\u0012(\u0012&\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010N\u0012\r\u0012\u000b\u0012\u0005\u0012\u00030¢\u0001\u0018\u00010N\u0012\u0004\u0012\u00020\u00150¡\u00010!¢\u0006\t\n\u0000\u001a\u0005\b£\u0001\u0010$R\u001a\u0010¤\u0001\u001a\t\u0012\u0005\u0012\u00030¥\u000106¢\u0006\t\n\u0000\u001a\u0005\b¦\u0001\u0010TR\u0019\u0010§\u0001\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\t\n\u0000\u001a\u0005\b¨\u0001\u0010$R\u001d\u0010©\u0001\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bª\u0001\u0010\u0017\"\u0005\b«\u0001\u0010\u0019R(\u0010¬\u0001\u001a\u0017\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00ad\u00010!¢\u0006\t\n\u0000\u001a\u0005\b®\u0001\u0010$R#\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020\"0!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b°\u0001\u0010$\"\u0005\b±\u0001\u0010&R#\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020\"0!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b³\u0001\u0010$\"\u0005\b´\u0001\u0010&¨\u0006Ò\u0001²\u0006\f\u0010Ó\u0001\u001a\u00030Ô\u0001X\u008a\u0084\u0002²\u0006\f\u0010Õ\u0001\u001a\u00030Ö\u0001X\u008a\u0084\u0002²\u0006\f\u0010×\u0001\u001a\u00030Ø\u0001X\u008a\u0084\u0002²\u0006\f\u0010Ó\u0001\u001a\u00030Ô\u0001X\u008a\u0084\u0002²\u0006\f\u0010×\u0001\u001a\u00030Ø\u0001X\u008a\u0084\u0002²\u0006\f\u0010Ó\u0001\u001a\u00030Ô\u0001X\u008a\u0084\u0002²\u0006\f\u0010Õ\u0001\u001a\u00030Ö\u0001X\u008a\u0084\u0002²\u0006\f\u0010Õ\u0001\u001a\u00030Ö\u0001X\u008a\u0084\u0002"}, d2 = {"Lcom/livpure/safedrink/dispenser/model/EnvyHomeViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "BLECommands", "Lcom/livpure/safedrink/bolt/data/BoltBleCommandsRespository;", "getBLECommands", "()Lcom/livpure/safedrink/bolt/data/BoltBleCommandsRespository;", "BLECommands$delegate", "Lkotlin/Lazy;", "BLERepository", "Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "getBLERepository", "()Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "BLERepository$delegate", "_device", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "get_device", "()Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "set_device", "(Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;)V", "_productType", "", "get_productType", "()Ljava/lang/String;", "set_productType", "(Ljava/lang/String;)V", "allowTopup", "", "getAllowTopup", "()Z", "setAllowTopup", "(Z)V", "bleImage", "Landroidx/lifecycle/LiveData;", "", "getBleImage", "()Landroidx/lifecycle/LiveData;", "setBleImage", "(Landroidx/lifecycle/LiveData;)V", "bleImageOff", "getBleImageOff", "setBleImageOff", "boltCommandsResponse", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", "getBoltCommandsResponse", "()Landroidx/lifecycle/MediatorLiveData;", "buzzer", "getBuzzer", "setBuzzer", "connectivity", "getConnectivity", "setConnectivity", "dashboardData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/livpure/safedrink/subscription/plan/data/model/DashboardDetailsResponse;", "value", AndroidContextPlugin.DEVICE_KEY, "getDevice", "setDevice", "deviceSerialNumber", "getDeviceSerialNumber", "setDeviceSerialNumber", "dispenseCommand", "Lcom/livpure/safedrink/dispenser/data/models/DispenserPublishCommand;", "dispenserCommand", "Lcom/livpure/safedrink/dispenser/data/models/DispenserCommands;", "dispenserCommandsRespository", "Lcom/livpure/safedrink/dispenser/data/DispenserCommandsRepository;", "getDispenserCommandsRespository", "()Lcom/livpure/safedrink/dispenser/data/DispenserCommandsRepository;", "dispenserCommandsRespository$delegate", "dispenserStatus", "getDispenserStatus", "setDispenserStatus", "envyBLEResponse", "Lcom/livpure/safedrink/dispenser/data/models/EnvyBLEResponse;", "envyBLEResponseList", "", "getEnvyBLEResponseList", "envyDashbordOffline", "Lcom/livpure/safedrink/dispenser/data/models/EnvyDashbordOffline;", "faultDescription", "getFaultDescription", "()Landroidx/lifecycle/MutableLiveData;", "filterLife", "getFilterLife", "filterLifeImage", "getFilterLifeImage", "hardwareUpdate", "getHardwareUpdate", "hardwareVersion", "getHardwareVersion", "hotWaterTemprature", "getHotWaterTemprature", "setHotWaterTemprature", "imageStatus", "Lcom/livpure/safedrink/dispenser/data/models/DispenserImageStatus;", "imeiNumber", "getImeiNumber", "setImeiNumber", "isEMIEnable", "setEMIEnable", "lastSynchronizedDate", "getLastSynchronizedDate", "setLastSynchronizedDate", "lastSynchronizedOn", "getLastSynchronizedOn", "setLastSynchronizedOn", "liveDispenserStatus", "getLiveDispenserStatus", "liveDispenserStatusImage", "getLiveDispenserStatusImage", "loadingStatus", "getLoadingStatus", "offlineDashboard", "getOfflineDashboard", "planDetails", "getPlanDetails", "planName", "getPlanName", "productType", "getProductType", "setProductType", "publishCommandStatus", "getPublishCommandStatus", "rechargeResponse", "Lcom/livpure/safedrink/bolt/data/models/RechargeResponse;", "getRechargeResponse", "referralCode", "getReferralCode", "remainingLitres", "", "getRemainingLitres", "()J", "setRemainingLitres", "(J)V", "repository", "getRepository", "repository$delegate", "scanSerialNo", "getScanSerialNo", "setScanSerialNo", "serialNo", "getSerialNo", "setSerialNo", "softwareUpdate", "getSoftwareUpdate", "softwareVersion", "getSoftwareVersion", "subscriptionRepository", "Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "getSubscriptionRepository", "()Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "subscriptionRepository$delegate", "tdsImage", "getTdsImage", "tempStatus", "getTempStatus", "setTempStatus", "usageStats", "Lkotlin/Triple;", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "getUsageStats", "user", "Lcom/livpure/safedrink/login/data/models/User;", "getUser", "uvImage", "getUvImage", "warmWaterTemprature", "getWarmWaterTemprature", "setWarmWaterTemprature", "waterRemaining", "Lkotlin/Pair;", "getWaterRemaining", "wifiImage", "getWifiImage", "setWifiImage", "wifiImageOff", "getWifiImageOff", "setWifiImageOff", "bleStatus", "", "status", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "getAllEnvyBLEResponse", "getAllOflineBLECommands", "getAllOflineDashboarData", "getDashboardDetails", "getPendingBleCommand", "getSerialNumberStatus", "roSerialNumber", "getSubmissionBLEStatus", "statusPkt", "powerPkt", "offlineBLEStatus", "serialNumber", "lastPacket", "offlineFilterLife", "reading", "(Ljava/lang/String;)Ljava/lang/Integer;", "offlineWaterTank", "publishCommand", "command", "warmWater", "hotWater", "updateLocationDetails", "latitude", "longitude", "app_productionRelease", "bleCommandListRepository", "Lcom/livpure/safedrink/dispenser/data/BLECommandListRepository;", "envyBLEResponseRepository", "Lcom/livpure/safedrink/dispenser/data/EnvyBLEResponseRepository;", "dispenserOflineRepository", "Lcom/livpure/safedrink/dispenser/data/DispenserOflineRepository;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EnvyHomeViewModel extends MediatorViewModel {
    private final Lazy BLECommands$delegate;
    private final Lazy BLERepository$delegate;
    private DeviceList _device;
    private boolean allowTopup;
    private LiveData<Integer> bleImage;
    private LiveData<Integer> bleImageOff;
    private final MediatorLiveData<BoltCommandsResponse> boltCommandsResponse;
    private final MutableLiveData<DashboardDetailsResponse> dashboardData;
    private DeviceList device;
    private DispenserPublishCommand dispenseCommand;
    private DispenserCommands dispenserCommand;
    private EnvyBLEResponse envyBLEResponse;
    private final MediatorLiveData<List<EnvyBLEResponse>> envyBLEResponseList;
    private EnvyDashbordOffline envyDashbordOffline;
    private final MutableLiveData<String> faultDescription;
    private final MutableLiveData<String> filterLife;
    private final LiveData<Integer> filterLifeImage;
    private final LiveData<Boolean> hardwareUpdate;
    private final LiveData<String> hardwareVersion;
    private DispenserImageStatus imageStatus;
    private LiveData<Boolean> isEMIEnable;
    private LiveData<String> lastSynchronizedDate;
    private final LiveData<Integer> liveDispenserStatus;
    private final LiveData<Integer> liveDispenserStatusImage;
    private final LiveData<Boolean> loadingStatus;
    private final MediatorLiveData<List<EnvyDashbordOffline>> offlineDashboard;
    private final LiveData<String> planDetails;
    private final MutableLiveData<String> planName;
    private LiveData<String> productType;
    private final MutableLiveData<String> publishCommandStatus;
    private final MediatorLiveData<List<RechargeResponse>> rechargeResponse;
    private final LiveData<String> referralCode;
    private long remainingLitres;
    private LiveData<Boolean> scanSerialNo;
    private final LiveData<Boolean> softwareUpdate;
    private final LiveData<String> softwareVersion;
    private final LiveData<Integer> tdsImage;
    private final LiveData<Triple<List<String>, List<IBarDataSet>, String>> usageStats;
    private final MutableLiveData<User> user;
    private final LiveData<Integer> uvImage;
    private final LiveData<Pair<String, Integer>> waterRemaining;
    private LiveData<Integer> wifiImage;
    private LiveData<Integer> wifiImageOff;
    private final Lazy repository$delegate = LazyKt.lazy(new Function0<DispenserCommandsRepository>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$repository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DispenserCommandsRepository invoke() {
            return new DispenserCommandsRepository();
        }
    });
    private String imeiNumber = "";
    private String connectivity = "";
    private String buzzer = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private String dispenserStatus = "";
    private String serialNo = "";
    private String hotWaterTemprature = "";
    private String warmWaterTemprature = "";
    private String tempStatus = "";
    private String _productType = "";
    private String deviceSerialNumber = "";
    private String lastSynchronizedOn = "";
    private final Lazy subscriptionRepository$delegate = LazyKt.lazy(new Function0<SubscriptionRepository>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$subscriptionRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubscriptionRepository invoke() {
            return new SubscriptionRepository();
        }
    });
    private final Lazy dispenserCommandsRespository$delegate = LazyKt.lazy(new Function0<DispenserCommandsRepository>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$dispenserCommandsRespository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DispenserCommandsRepository invoke() {
            return new DispenserCommandsRepository();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadingStatus$lambda-14  reason: not valid java name */
    public static final Boolean m574loadingStatus$lambda14(Boolean bool) {
        return bool;
    }

    public EnvyHomeViewModel() {
        MutableLiveData<DashboardDetailsResponse> mutableLiveData = new MutableLiveData<>();
        this.dashboardData = mutableLiveData;
        this.boltCommandsResponse = new MediatorLiveData<>();
        this.BLERepository$delegate = LazyKt.lazy(new Function0<BoltDataUpdateRepository>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$BLERepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BoltDataUpdateRepository invoke() {
                return new BoltDataUpdateRepository();
            }
        });
        this.BLECommands$delegate = LazyKt.lazy(new Function0<BoltBleCommandsRespository>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$BLECommands$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BoltBleCommandsRespository invoke() {
                return new BoltBleCommandsRespository();
            }
        });
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue("");
        this.faultDescription = mutableLiveData2;
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        mutableLiveData3.setValue("");
        this.filterLife = mutableLiveData3;
        MutableLiveData<String> mutableLiveData4 = new MutableLiveData<>();
        mutableLiveData4.setValue("");
        this.planName = mutableLiveData4;
        MutableLiveData<User> mutableLiveData5 = new MutableLiveData<>();
        mutableLiveData5.setValue(LSApplication.Companion.getUser());
        this.user = mutableLiveData5;
        this.publishCommandStatus = new MutableLiveData<>();
        LiveData<String> map = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda11
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m571lastSynchronizedDate$lambda5;
                m571lastSynchronizedDate$lambda5 = EnvyHomeViewModel.m571lastSynchronizedDate$lambda5(EnvyHomeViewModel.this, (DashboardDetailsResponse) obj);
                return m571lastSynchronizedDate$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.lastSynchronizedDate = map;
        LiveData<String> map2 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda12
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m578productType$lambda9;
                m578productType$lambda9 = EnvyHomeViewModel.m578productType$lambda9((DashboardDetailsResponse) obj);
                return m578productType$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.productType = map2;
        LiveData<Integer> map3 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda8
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m589wifiImage$lambda10;
                m589wifiImage$lambda10 = EnvyHomeViewModel.m589wifiImage$lambda10((DashboardDetailsResponse) obj);
                return m589wifiImage$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map3, "map(dashboardData) {\n        R.drawable.wifi\n    }");
        this.wifiImage = map3;
        LiveData<Integer> map4 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda26
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m553bleImage$lambda11;
                m553bleImage$lambda11 = EnvyHomeViewModel.m553bleImage$lambda11((DashboardDetailsResponse) obj);
                return m553bleImage$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map4, "map(dashboardData) {\n   ….drawable.bluetooth\n    }");
        this.bleImage = map4;
        LiveData<Integer> map5 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda4
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m590wifiImageOff$lambda12;
                m590wifiImageOff$lambda12 = EnvyHomeViewModel.m590wifiImageOff$lambda12((DashboardDetailsResponse) obj);
                return m590wifiImageOff$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map5, "map(dashboardData) {\n   …R.drawable.wifi_off\n    }");
        this.wifiImageOff = map5;
        LiveData<Integer> map6 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda7
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m554bleImageOff$lambda13;
                m554bleImageOff$lambda13 = EnvyHomeViewModel.m554bleImageOff$lambda13((DashboardDetailsResponse) obj);
                return m554bleImageOff$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map6, "map(dashboardData) {\n   …wable.bluetooth_off\n    }");
        this.bleImageOff = map6;
        LiveData<Boolean> map7 = Transformations.map(getLoading(), new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda14
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m574loadingStatus$lambda14;
                m574loadingStatus$lambda14 = EnvyHomeViewModel.m574loadingStatus$lambda14((Boolean) obj);
                return m574loadingStatus$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map7, "map(loading) {\n        it\n    }");
        this.loadingStatus = map7;
        LiveData<Boolean> map8 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda9
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m581scanSerialNo$lambda15;
                m581scanSerialNo$lambda15 = EnvyHomeViewModel.m581scanSerialNo$lambda15((DashboardDetailsResponse) obj);
                return m581scanSerialNo$lambda15;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map8, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.scanSerialNo = map8;
        LiveData<Integer> map9 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda25
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m572liveDispenserStatus$lambda18;
                m572liveDispenserStatus$lambda18 = EnvyHomeViewModel.m572liveDispenserStatus$lambda18((DashboardDetailsResponse) obj);
                return m572liveDispenserStatus$lambda18;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map9, "map(dashboardData) {\n   …        }\n        0\n    }");
        this.liveDispenserStatus = map9;
        LiveData<String> map10 = Transformations.map(mutableLiveData5, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda24
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m580referralCode$lambda19;
                m580referralCode$lambda19 = EnvyHomeViewModel.m580referralCode$lambda19((User) obj);
                return m580referralCode$lambda19;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map10, "map(user) {\n        if (…       \"\"\n        }\n    }");
        this.referralCode = map10;
        LiveData<Integer> map11 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda29
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m573liveDispenserStatusImage$lambda20;
                m573liveDispenserStatusImage$lambda20 = EnvyHomeViewModel.m573liveDispenserStatusImage$lambda20((DashboardDetailsResponse) obj);
                return m573liveDispenserStatusImage$lambda20;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map11, "map(dashboardData) {\n   …_dispense\n        }\n    }");
        this.liveDispenserStatusImage = map11;
        LiveData<Pair<String, Integer>> map12 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Pair m588waterRemaining$lambda21;
                m588waterRemaining$lambda21 = EnvyHomeViewModel.m588waterRemaining$lambda21(EnvyHomeViewModel.this, (DashboardDetailsResponse) obj);
                return m588waterRemaining$lambda21;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map12, "map(dashboardData) {\n   …\"\", null)\n        }\n    }");
        this.waterRemaining = map12;
        LiveData<Integer> map13 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda6
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m587uvImage$lambda22;
                m587uvImage$lambda22 = EnvyHomeViewModel.m587uvImage$lambda22((DashboardDetailsResponse) obj);
                return m587uvImage$lambda22;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map13, "map(dashboardData) {\n   …  R.drawable.uv_off\n    }");
        this.uvImage = map13;
        LiveData<Integer> map14 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda3
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m584tdsImage$lambda23;
                m584tdsImage$lambda23 = EnvyHomeViewModel.m584tdsImage$lambda23((DashboardDetailsResponse) obj);
                return m584tdsImage$lambda23;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map14, "map(dashboardData) {\n   …drawable.tds_band_1\n    }");
        this.tdsImage = map14;
        LiveData<Boolean> map15 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda10
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m570isEMIEnable$lambda24;
                m570isEMIEnable$lambda24 = EnvyHomeViewModel.m570isEMIEnable$lambda24((DashboardDetailsResponse) obj);
                return m570isEMIEnable$lambda24;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map15, "map(dashboardData) {\n   …    }\n        false\n    }");
        this.isEMIEnable = map15;
        LiveData<String> map16 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda22
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m577planDetails$lambda25;
                m577planDetails$lambda25 = EnvyHomeViewModel.m577planDetails$lambda25(EnvyHomeViewModel.this, (DashboardDetailsResponse) obj);
                return m577planDetails$lambda25;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map16, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.planDetails = map16;
        LiveData<Integer> map17 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m558filterLifeImage$lambda26;
                m558filterLifeImage$lambda26 = EnvyHomeViewModel.m558filterLifeImage$lambda26((DashboardDetailsResponse) obj);
                return m558filterLifeImage$lambda26;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map17, "map(dashboardData) {\n   …       -1\n        }\n    }");
        this.filterLifeImage = map17;
        LiveData<Boolean> map18 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda27
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m568hardwareUpdate$lambda27;
                m568hardwareUpdate$lambda27 = EnvyHomeViewModel.m568hardwareUpdate$lambda27((DashboardDetailsResponse) obj);
                return m568hardwareUpdate$lambda27;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map18, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.hardwareUpdate = map18;
        LiveData<Boolean> map19 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda13
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m582softwareUpdate$lambda28;
                m582softwareUpdate$lambda28 = EnvyHomeViewModel.m582softwareUpdate$lambda28((DashboardDetailsResponse) obj);
                return m582softwareUpdate$lambda28;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map19, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.softwareUpdate = map19;
        LiveData<String> map20 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda5
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m569hardwareVersion$lambda29;
                m569hardwareVersion$lambda29 = EnvyHomeViewModel.m569hardwareVersion$lambda29((DashboardDetailsResponse) obj);
                return m569hardwareVersion$lambda29;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map20, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.hardwareVersion = map20;
        LiveData<String> map21 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m583softwareVersion$lambda30;
                m583softwareVersion$lambda30 = EnvyHomeViewModel.m583softwareVersion$lambda30((DashboardDetailsResponse) obj);
                return m583softwareVersion$lambda30;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map21, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.softwareVersion = map21;
        LiveData<Triple<List<String>, List<IBarDataSet>, String>> map22 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda28
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Triple m586usageStats$lambda31;
                m586usageStats$lambda31 = EnvyHomeViewModel.m586usageStats$lambda31((DashboardDetailsResponse) obj);
                return m586usageStats$lambda31;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map22, "map(dashboardData) {\n   …null, \"\")\n        }\n    }");
        this.usageStats = map22;
        this.offlineDashboard = new MediatorLiveData<>();
        this.rechargeResponse = new MediatorLiveData<>();
        this.envyBLEResponseList = new MediatorLiveData<>();
    }

    private final DispenserCommandsRepository getRepository() {
        return (DispenserCommandsRepository) this.repository$delegate.getValue();
    }

    public final String getImeiNumber() {
        return this.imeiNumber;
    }

    public final void setImeiNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imeiNumber = str;
    }

    public final String getConnectivity() {
        return this.connectivity;
    }

    public final void setConnectivity(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.connectivity = str;
    }

    public final String getBuzzer() {
        return this.buzzer;
    }

    public final void setBuzzer(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.buzzer = str;
    }

    public final DeviceList get_device() {
        return this._device;
    }

    public final void set_device(DeviceList deviceList) {
        this._device = deviceList;
    }

    public final String getDispenserStatus() {
        return this.dispenserStatus;
    }

    public final void setDispenserStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dispenserStatus = str;
    }

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serialNo = str;
    }

    public final String getHotWaterTemprature() {
        return this.hotWaterTemprature;
    }

    public final void setHotWaterTemprature(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hotWaterTemprature = str;
    }

    public final String getWarmWaterTemprature() {
        return this.warmWaterTemprature;
    }

    public final void setWarmWaterTemprature(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.warmWaterTemprature = str;
    }

    public final String getTempStatus() {
        return this.tempStatus;
    }

    public final void setTempStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tempStatus = str;
    }

    public final String get_productType() {
        return this._productType;
    }

    public final void set_productType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this._productType = str;
    }

    public final String getDeviceSerialNumber() {
        return this.deviceSerialNumber;
    }

    public final void setDeviceSerialNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceSerialNumber = str;
    }

    public final String getLastSynchronizedOn() {
        return this.lastSynchronizedOn;
    }

    public final void setLastSynchronizedOn(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lastSynchronizedOn = str;
    }

    private final SubscriptionRepository getSubscriptionRepository() {
        return (SubscriptionRepository) this.subscriptionRepository$delegate.getValue();
    }

    private final DispenserCommandsRepository getDispenserCommandsRespository() {
        return (DispenserCommandsRepository) this.dispenserCommandsRespository$delegate.getValue();
    }

    public final MediatorLiveData<BoltCommandsResponse> getBoltCommandsResponse() {
        return this.boltCommandsResponse;
    }

    private final BoltDataUpdateRepository getBLERepository() {
        return (BoltDataUpdateRepository) this.BLERepository$delegate.getValue();
    }

    private final BoltBleCommandsRespository getBLECommands() {
        return (BoltBleCommandsRespository) this.BLECommands$delegate.getValue();
    }

    public final MutableLiveData<String> getFaultDescription() {
        return this.faultDescription;
    }

    public final MutableLiveData<String> getFilterLife() {
        return this.filterLife;
    }

    public final MutableLiveData<String> getPlanName() {
        return this.planName;
    }

    public final MutableLiveData<User> getUser() {
        return this.user;
    }

    public final MutableLiveData<String> getPublishCommandStatus() {
        return this.publishCommandStatus;
    }

    public final boolean getAllowTopup() {
        return this.allowTopup;
    }

    public final void setAllowTopup(boolean z) {
        this.allowTopup = z;
    }

    public final long getRemainingLitres() {
        return this.remainingLitres;
    }

    public final void setRemainingLitres(long j) {
        this.remainingLitres = j;
    }

    public final void publishCommand(String command, String warmWater, String hotWater) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(warmWater, "warmWater");
        Intrinsics.checkNotNullParameter(hotWater, "hotWater");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            DispenserPublishCommand dispenserPublishCommand = new DispenserPublishCommand(command, warmWater, hotWater, "");
            this.dispenseCommand = dispenserPublishCommand;
            this.dispenserCommand = new DispenserCommands(this.imeiNumber, dispenserPublishCommand);
            try {
                DispenserCommandsRepository dispenserCommandsRespository = getDispenserCommandsRespository();
                DispenserCommands dispenserCommands = this.dispenserCommand;
                if (dispenserCommands == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dispenserCommand");
                    dispenserCommands = null;
                }
                observeAndTrack(dispenserCommandsRespository.sendDispenserCommand(dispenserCommands), new Observer() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda15
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        EnvyHomeViewModel.m579publishCommand$lambda4(EnvyHomeViewModel.this, (BaseDataHolder) obj);
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
    /* renamed from: publishCommand$lambda-4  reason: not valid java name */
    public static final void m579publishCommand$lambda4(EnvyHomeViewModel this$0, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.publishCommandStatus.setValue(baseDataHolder.getMessage());
    }

    public final LiveData<String> getLastSynchronizedDate() {
        return this.lastSynchronizedDate;
    }

    public final void setLastSynchronizedDate(LiveData<String> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.lastSynchronizedDate = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lastSynchronizedDate$lambda-5  reason: not valid java name */
    public static final String m571lastSynchronizedDate$lambda5(EnvyHomeViewModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getLastSyncDate() : null) != null) {
            this$0.lastSynchronizedOn = dashboardDetailsResponse.getDashboardDetails().getLastSyncDate();
            return dashboardDetailsResponse.getDashboardDetails().getLastSyncDate();
        }
        return "";
    }

    public final void bleStatus(final String status, final Context context) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(context, "context");
        Log.e("livpurelogs", "Update Status: ");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getBLERepository().sendBoltConfigtRequest(this.deviceSerialNumber, status, false), new Observer() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda17
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        EnvyHomeViewModel.m555bleStatus$lambda7(EnvyHomeViewModel.this, status, context, (BaseDataHolder) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue while fetching your dashboard details at this time."));
                return;
            }
        }
        Lazy lazy = LazyKt.lazy(new Function0<EnvyBLEResponseRepository>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$bleStatus$envyBLEResponseRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EnvyBLEResponseRepository invoke() {
                return new EnvyBLEResponseRepository(context);
            }
        });
        EnvyBLEResponse envyBLEResponse = null;
        if (StringsKt.contains$default((CharSequence) status.toString(), (CharSequence) "RSA", false, 2, (Object) null)) {
            this.envyBLEResponse = new EnvyBLEResponse(this.deviceSerialNumber, status);
            EnvyBLEResponseRepository m557bleStatus$lambda8 = m557bleStatus$lambda8(lazy);
            EnvyBLEResponse envyBLEResponse2 = this.envyBLEResponse;
            if (envyBLEResponse2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("envyBLEResponse");
            } else {
                envyBLEResponse = envyBLEResponse2;
            }
            m557bleStatus$lambda8.insert(envyBLEResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bleStatus$lambda-7  reason: not valid java name */
    public static final void m555bleStatus$lambda7(EnvyHomeViewModel this$0, String status, final Context context, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(status, "$status");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.getLoading().setValue(false);
        if (StringsKt.contains$default((CharSequence) status.toString(), (CharSequence) "\"FR\"", false, 2, (Object) null)) {
            this$0.getDashboardDetails(context);
        } else if (StringsKt.contains$default((CharSequence) status.toString(), (CharSequence) "DWC", false, 2, (Object) null)) {
            this$0.getPendingBleCommand(context);
        } else if (StringsKt.contains$default((CharSequence) status.toString(), (CharSequence) "RSA", false, 2, (Object) null)) {
            m556bleStatus$lambda7$lambda6(LazyKt.lazy(new Function0<BLECommandListRepository>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$bleStatus$1$bleCommandListRepository$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BLECommandListRepository invoke() {
                    return new BLECommandListRepository(context);
                }
            })).deleteBLEDataList();
        }
    }

    /* renamed from: bleStatus$lambda-7$lambda-6  reason: not valid java name */
    private static final BLECommandListRepository m556bleStatus$lambda7$lambda6(Lazy<BLECommandListRepository> lazy) {
        return lazy.getValue();
    }

    /* renamed from: bleStatus$lambda-8  reason: not valid java name */
    private static final EnvyBLEResponseRepository m557bleStatus$lambda8(Lazy<EnvyBLEResponseRepository> lazy) {
        return lazy.getValue();
    }

    public final LiveData<String> getProductType() {
        return this.productType;
    }

    public final void setProductType(LiveData<String> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.productType = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: productType$lambda-9  reason: not valid java name */
    public static final String m578productType$lambda9(DashboardDetailsResponse dashboardDetailsResponse) {
        ProductStats productStats;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return ((dashboardDetails == null || (productStats = dashboardDetails.getProductStats()) == null) ? null : productStats.getProductType()) != null ? dashboardDetailsResponse.getDashboardDetails().getProductStats().getProductType() : "";
    }

    public final LiveData<Integer> getWifiImage() {
        return this.wifiImage;
    }

    public final void setWifiImage(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.wifiImage = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: wifiImage$lambda-10  reason: not valid java name */
    public static final Integer m589wifiImage$lambda10(DashboardDetailsResponse dashboardDetailsResponse) {
        return Integer.valueOf((int) R.drawable.wifi);
    }

    public final LiveData<Integer> getBleImage() {
        return this.bleImage;
    }

    public final void setBleImage(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.bleImage = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bleImage$lambda-11  reason: not valid java name */
    public static final Integer m553bleImage$lambda11(DashboardDetailsResponse dashboardDetailsResponse) {
        return Integer.valueOf((int) R.drawable.bluetooth);
    }

    public final LiveData<Integer> getWifiImageOff() {
        return this.wifiImageOff;
    }

    public final void setWifiImageOff(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.wifiImageOff = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: wifiImageOff$lambda-12  reason: not valid java name */
    public static final Integer m590wifiImageOff$lambda12(DashboardDetailsResponse dashboardDetailsResponse) {
        return Integer.valueOf((int) R.drawable.wifi_off);
    }

    public final LiveData<Integer> getBleImageOff() {
        return this.bleImageOff;
    }

    public final void setBleImageOff(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.bleImageOff = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bleImageOff$lambda-13  reason: not valid java name */
    public static final Integer m554bleImageOff$lambda13(DashboardDetailsResponse dashboardDetailsResponse) {
        return Integer.valueOf((int) R.drawable.bluetooth_off);
    }

    public final LiveData<Boolean> getLoadingStatus() {
        return this.loadingStatus;
    }

    public final LiveData<Boolean> getScanSerialNo() {
        return this.scanSerialNo;
    }

    public final void setScanSerialNo(LiveData<Boolean> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.scanSerialNo = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scanSerialNo$lambda-15  reason: not valid java name */
    public static final Boolean m581scanSerialNo$lambda15(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getScanSerialNo() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getScanSerialNo().booleanValue() : false);
    }

    public final DeviceList getDevice() {
        return this.device;
    }

    public final void setDevice(DeviceList deviceList) {
        String serialNo;
        this._device = deviceList;
        this.device = deviceList;
        String str = "";
        this.imeiNumber = (deviceList == null || (r2 = deviceList.getImeiNo()) == null) ? "" : "";
        DeviceList deviceList2 = this.device;
        this.connectivity = (deviceList2 == null || (r2 = deviceList2.getConnectivity()) == null) ? "" : "";
        DeviceList deviceList3 = this.device;
        this._productType = (deviceList3 == null || (r2 = deviceList3.getProductType()) == null) ? "" : "";
        DeviceList deviceList4 = this.device;
        this.serialNo = (deviceList4 == null || (r2 = deviceList4.getSerialNo()) == null) ? "" : "";
        DeviceList deviceList5 = this.device;
        if (deviceList5 != null && (serialNo = deviceList5.getSerialNo()) != null) {
            str = serialNo;
        }
        this.deviceSerialNumber = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getDashboardDetails$lambda-16  reason: not valid java name */
    public static final DispenserOflineRepository m562getDashboardDetails$lambda16(Lazy<DispenserOflineRepository> lazy) {
        return lazy.getValue();
    }

    public final void getDashboardDetails(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        final Lazy lazy = LazyKt.lazy(new Function0<DispenserOflineRepository>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$getDashboardDetails$dispenserOflineRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DispenserOflineRepository invoke() {
                return new DispenserOflineRepository(context);
            }
        });
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            m562getDashboardDetails$lambda16(lazy).deleteDashboard();
            try {
                observeAndTrack(getSubscriptionRepository().getDashboardDetails(this.serialNo), new Observer() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda19
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        EnvyHomeViewModel.m563getDashboardDetails$lambda17(EnvyHomeViewModel.this, lazy, (DashboardDetailsResponse) obj);
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
    /* renamed from: getDashboardDetails$lambda-17  reason: not valid java name */
    public static final void m563getDashboardDetails$lambda17(final EnvyHomeViewModel this$0, final Lazy dispenserOflineRepository$delegate, DashboardDetailsResponse dashboardDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dispenserOflineRepository$delegate, "$dispenserOflineRepository$delegate");
        this$0.getLoading().setValue(false);
        this$0.processResponse(dashboardDetailsResponse, new Function1<DashboardDetailsResponse, Unit>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$getDashboardDetails$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DashboardDetailsResponse dashboardDetailsResponse2) {
                invoke2(dashboardDetailsResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DashboardDetailsResponse successfulResponse) {
                MutableLiveData mutableLiveData;
                String str;
                String format;
                DispenserOflineRepository m562getDashboardDetails$lambda16;
                EnvyDashbordOffline envyDashbordOffline;
                EnvyDashbordOffline envyDashbordOffline2;
                ProductStats productStats;
                ProductStats productStats2;
                ProductStats productStats3;
                ProductStats productStats4;
                DispenserRoSetting dispenserRoSetting;
                DispenserRoSetting dispenserRoSetting2;
                DispenserRoSetting dispenserRoSetting3;
                DispenserRoSetting dispenserRoSetting4;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                mutableLiveData = EnvyHomeViewModel.this.dashboardData;
                mutableLiveData.setValue(successfulResponse);
                MutableLiveData<String> faultDescription = EnvyHomeViewModel.this.getFaultDescription();
                DashboardDetails dashboardDetails = successfulResponse.getDashboardDetails();
                faultDescription.setValue(String.valueOf((dashboardDetails == null || (dispenserRoSetting4 = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting4.getFault()));
                EnvyHomeViewModel envyHomeViewModel = EnvyHomeViewModel.this;
                DashboardDetails dashboardDetails2 = successfulResponse.getDashboardDetails();
                envyHomeViewModel.setDispenserStatus(String.valueOf((dashboardDetails2 == null || (dispenserRoSetting3 = dashboardDetails2.getDispenserRoSetting()) == null) ? null : dispenserRoSetting3.getDespensing()));
                EnvyHomeViewModel envyHomeViewModel2 = EnvyHomeViewModel.this;
                DashboardDetails dashboardDetails3 = successfulResponse.getDashboardDetails();
                envyHomeViewModel2.setHotWaterTemprature(String.valueOf((dashboardDetails3 == null || (dispenserRoSetting2 = dashboardDetails3.getDispenserRoSetting()) == null) ? null : dispenserRoSetting2.getHotWater()));
                EnvyHomeViewModel envyHomeViewModel3 = EnvyHomeViewModel.this;
                DashboardDetails dashboardDetails4 = successfulResponse.getDashboardDetails();
                envyHomeViewModel3.setWarmWaterTemprature(String.valueOf((dashboardDetails4 == null || (dispenserRoSetting = dashboardDetails4.getDispenserRoSetting()) == null) ? null : dispenserRoSetting.getWarmWater()));
                DashboardDetails dashboardDetails5 = successfulResponse.getDashboardDetails();
                String str2 = "";
                String lastSyncDate = (dashboardDetails5 != null ? dashboardDetails5.getLastSyncDate() : null) != null ? successfulResponse.getDashboardDetails().getLastSyncDate() : "";
                DashboardDetails dashboardDetails6 = successfulResponse.getDashboardDetails();
                if ((dashboardDetails6 != null ? dashboardDetails6.getUsage() : null) != null) {
                    String remainingLitres = successfulResponse.getDashboardDetails().getUsage().getRemainingLitres();
                    str = (remainingLitres == null || (r2 = StringsKt.padStart(remainingLitres, 5, '0')) == null) ? "" : "";
                } else {
                    str = "";
                }
                DashboardDetails dashboardDetails7 = successfulResponse.getDashboardDetails();
                SubscriptionDetails subscriptionDetails = dashboardDetails7 != null ? dashboardDetails7.getSubscriptionDetails() : null;
                DashboardDetails dashboardDetails8 = successfulResponse.getDashboardDetails();
                if (((dashboardDetails8 == null || (productStats4 = dashboardDetails8.getProductStats()) == null) ? null : productStats4.getProductType()) != null) {
                    DashboardDetails dashboardDetails9 = successfulResponse.getDashboardDetails();
                    if (StringsKt.contains((CharSequence) ((dashboardDetails9 == null || (productStats3 = dashboardDetails9.getProductStats()) == null) ? null : productStats3.getProductType()), (CharSequence) "emi", true)) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        Object[] objArr = new Object[4];
                        objArr[0] = subscriptionDetails != null ? subscriptionDetails.getPlanName() : null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Valid Till: ");
                        sb.append(subscriptionDetails != null ? subscriptionDetails.getValidTillDate() : null);
                        objArr[1] = sb.toString();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Rate: ");
                        sb2.append(subscriptionDetails != null ? subscriptionDetails.getPlanRate() : null);
                        objArr[2] = sb2.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("EMI Paid: ");
                        sb3.append(subscriptionDetails != null ? subscriptionDetails.getEmiPaid() : null);
                        objArr[3] = sb3.toString();
                        format = String.format("%s\n%s\n%s\n%s", Arrays.copyOf(objArr, 4));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    } else {
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = subscriptionDetails != null ? subscriptionDetails.getPlanName() : null;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Valid Till: ");
                        sb4.append(subscriptionDetails != null ? subscriptionDetails.getValidFromTo() : null);
                        objArr2[1] = sb4.toString();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Rate: ");
                        sb5.append(subscriptionDetails != null ? subscriptionDetails.getPlanRate() : null);
                        objArr2[2] = sb5.toString();
                        objArr2[3] = subscriptionDetails != null ? subscriptionDetails.getNormalizedBalanceString() : null;
                        format = String.format("%s\n%s\n%s\n%s", Arrays.copyOf(objArr2, 4));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    }
                } else {
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    Object[] objArr3 = new Object[4];
                    objArr3[0] = subscriptionDetails != null ? subscriptionDetails.getPlanName() : null;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Valid Till: ");
                    sb6.append(subscriptionDetails != null ? subscriptionDetails.getValidFromTo() : null);
                    objArr3[1] = sb6.toString();
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("Rate: ");
                    sb7.append(subscriptionDetails != null ? subscriptionDetails.getPlanRate() : null);
                    objArr3[2] = sb7.toString();
                    objArr3[3] = subscriptionDetails != null ? subscriptionDetails.getNormalizedBalanceString() : null;
                    format = String.format("%s\n%s\n%s\n%s", Arrays.copyOf(objArr3, 4));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                }
                String str3 = format;
                DashboardDetails dashboardDetails10 = successfulResponse.getDashboardDetails();
                if (!StringsKt.equals$default((dashboardDetails10 == null || (productStats2 = dashboardDetails10.getProductStats()) == null) ? null : productStats2.getFilterLife(), "", false, 2, null)) {
                    DashboardDetails dashboardDetails11 = successfulResponse.getDashboardDetails();
                    str2 = String.valueOf((dashboardDetails11 == null || (productStats = dashboardDetails11.getProductStats()) == null) ? null : productStats.getFilterLife());
                }
                EnvyHomeViewModel.this.envyDashbordOffline = new EnvyDashbordOffline(EnvyHomeViewModel.this.getDeviceSerialNumber(), lastSyncDate, str, str3, str2, "", EnvyHomeViewModel.this.get_productType(), "");
                m562getDashboardDetails$lambda16 = EnvyHomeViewModel.m562getDashboardDetails$lambda16(dispenserOflineRepository$delegate);
                envyDashbordOffline = EnvyHomeViewModel.this.envyDashbordOffline;
                if (envyDashbordOffline == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("envyDashbordOffline");
                    envyDashbordOffline2 = null;
                } else {
                    envyDashbordOffline2 = envyDashbordOffline;
                }
                m562getDashboardDetails$lambda16.insert(envyDashbordOffline2);
            }
        }, new Function1<DashboardDetailsResponse, Unit>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$getDashboardDetails$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DashboardDetailsResponse dashboardDetailsResponse2) {
                invoke2(dashboardDetailsResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DashboardDetailsResponse it) {
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(it, "it");
                toastMessageLiveData = EnvyHomeViewModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Oops! We faced an issue while fetching your dashboard details at this time."));
            }
        });
    }

    public final LiveData<Integer> getLiveDispenserStatus() {
        return this.liveDispenserStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveDispenserStatus$lambda-18  reason: not valid java name */
    public static final Integer m572liveDispenserStatus$lambda18(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null) != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing() != null && !Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing(), "")) {
            Integer.parseInt(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing());
        }
        return 0;
    }

    public final LiveData<String> getReferralCode() {
        return this.referralCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: referralCode$lambda-19  reason: not valid java name */
    public static final String m580referralCode$lambda19(User user) {
        return user.getReferralCode() != null ? user.getReferralCode() : "";
    }

    public final LiveData<Integer> getLiveDispenserStatusImage() {
        return this.liveDispenserStatusImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveDispenserStatusImage$lambda-20  reason: not valid java name */
    public static final Integer m573liveDispenserStatusImage$lambda20(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        DispenserRoSetting dispenserRoSetting = dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null;
        int i = R.drawable.cont_dispense;
        if (dispenserRoSetting != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing() != null && !Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing(), "") && Integer.parseInt(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing()) == 1) {
            i = R.drawable.cont_dispense_sel;
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Pair<String, Integer>> getWaterRemaining() {
        return this.waterRemaining;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: waterRemaining$lambda-21  reason: not valid java name */
    public static final Pair m588waterRemaining$lambda21(EnvyHomeViewModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        String remainingLitres;
        String padStart;
        String remainingLitres2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        String str = "";
        if ((dashboardDetails != null ? dashboardDetails.getUsage() : null) != null) {
            ProductStats productStats = dashboardDetailsResponse.getDashboardDetails().getProductStats();
            if ((productStats != null ? productStats.getProductType() : null) == null ? !((remainingLitres = dashboardDetailsResponse.getDashboardDetails().getUsage().getRemainingLitres()) == null || (padStart = StringsKt.padStart(remainingLitres, 5, '0')) == null) : !((remainingLitres2 = dashboardDetailsResponse.getDashboardDetails().getUsage().getRemainingLitres()) == null || (padStart = StringsKt.padStart(remainingLitres2, 5, '0')) == null)) {
                str = padStart;
            }
            long parseLong = Long.parseLong(str);
            this$0.remainingLitres = parseLong;
            return new Pair(str, Integer.valueOf(parseLong > 40 ? R.drawable.fullwaterlarge : parseLong > 10 ? R.drawable.purifyinglarge : R.drawable.emptywaterlarge));
        }
        return new Pair("", null);
    }

    public final LiveData<Integer> getUvImage() {
        return this.uvImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uvImage$lambda-22  reason: not valid java name */
    public static final Integer m587uvImage$lambda22(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null) != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getUv() != null) {
            if (dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getUv().length() > 0) {
                Integer.parseInt(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getUv());
            }
        }
        return Integer.valueOf((int) R.drawable.uv_off);
    }

    public final LiveData<Integer> getTdsImage() {
        return this.tdsImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: tdsImage$lambda-23  reason: not valid java name */
    public static final Integer m584tdsImage$lambda23(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null) != null) {
            String tds = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTds();
            int parseInt = tds != null ? Integer.parseInt(tds) : 0;
            if (parseInt <= 0 && parseInt <= 1 && parseInt <= 2 && parseInt > 3) {
            }
        }
        return Integer.valueOf((int) R.drawable.tds_band_1);
    }

    public final LiveData<Boolean> isEMIEnable() {
        return this.isEMIEnable;
    }

    public final void setEMIEnable(LiveData<Boolean> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.isEMIEnable = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isEMIEnable$lambda-24  reason: not valid java name */
    public static final Boolean m570isEMIEnable$lambda24(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getSubscriptionDetails() : null) != null) {
            SubscriptionDetails subscriptionDetails = dashboardDetailsResponse.getDashboardDetails().getSubscriptionDetails();
            if (subscriptionDetails.getEmiPaid() != null) {
                List split$default = StringsKt.split$default((CharSequence) subscriptionDetails.getEmiPaid().toString(), new String[]{"/"}, false, 0, 6, (Object) null);
                int parseInt = Integer.parseInt((String) split$default.get(0)) % Integer.parseInt((String) split$default.get(1));
            }
        }
        return false;
    }

    public final LiveData<String> getPlanDetails() {
        return this.planDetails;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: planDetails$lambda-25  reason: not valid java name */
    public static final String m577planDetails$lambda25(EnvyHomeViewModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        ProductStats productStats;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getSubscriptionDetails() : null) != null) {
            SubscriptionDetails subscriptionDetails = dashboardDetailsResponse.getDashboardDetails().getSubscriptionDetails();
            subscriptionDetails.getNormalizedBalanceString();
            dashboardDetailsResponse.getDashboardDetails().getSubscriptionDetails().get_AllowTopup();
            this$0.allowTopup = subscriptionDetails.get_AllowTopup();
            ProductStats productStats2 = dashboardDetailsResponse.getDashboardDetails().getProductStats();
            if ((productStats2 != null ? productStats2.getProductType() : null) != null) {
                DashboardDetails dashboardDetails2 = dashboardDetailsResponse.getDashboardDetails();
                if (StringsKt.contains((CharSequence) ((dashboardDetails2 == null || (productStats = dashboardDetails2.getProductStats()) == null) ? null : productStats.getProductType()), (CharSequence) "emi", true)) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    Object[] objArr = new Object[3];
                    objArr[0] = "Plan - EMI";
                    StringBuilder sb = new StringBuilder();
                    sb.append("EMI Till: ");
                    sb.append(subscriptionDetails != null ? subscriptionDetails.getValidTillDate() : null);
                    objArr[1] = sb.toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("EMI Paid: ");
                    sb2.append(subscriptionDetails != null ? subscriptionDetails.getEmiPaid() : null);
                    objArr[2] = sb2.toString();
                    String format = String.format("%s\n%s\n%s", Arrays.copyOf(objArr, 3));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    return format;
                }
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                Object[] objArr2 = new Object[4];
                objArr2[0] = subscriptionDetails != null ? subscriptionDetails.getPlanName() : null;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Valid Till: ");
                sb3.append(subscriptionDetails != null ? subscriptionDetails.getValidFromTo() : null);
                objArr2[1] = sb3.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Rate: ");
                sb4.append(subscriptionDetails != null ? subscriptionDetails.getPlanRate() : null);
                objArr2[2] = sb4.toString();
                objArr2[3] = subscriptionDetails != null ? subscriptionDetails.getNormalizedBalanceString() : null;
                String format2 = String.format("%s\n%s\n%s\n%s", Arrays.copyOf(objArr2, 4));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                return format2;
            }
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format("%s\n%s\n%s\n%s", Arrays.copyOf(new Object[]{subscriptionDetails.getPlanName(), "Valid Till: " + subscriptionDetails.getValidFromTo(), "Rate: " + subscriptionDetails.getPlanRate(), subscriptionDetails.getNormalizedBalanceString()}, 4));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            return format3;
        }
        return "";
    }

    public final LiveData<Integer> getFilterLifeImage() {
        return this.filterLifeImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: filterLifeImage$lambda-26  reason: not valid java name */
    public static final Integer m558filterLifeImage$lambda26(DashboardDetailsResponse dashboardDetailsResponse) {
        int i;
        ProductStats productStats;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if (((dashboardDetails == null || (productStats = dashboardDetails.getProductStats()) == null) ? null : productStats.getFilterLife()) != null) {
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (!dashboardDetailsResponse.getDashboardDetails().getProductStats().getFilterLife().equals("")) {
                d = Double.parseDouble(dashboardDetailsResponse.getDashboardDetails().getProductStats().getFilterLife());
            }
            i = Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getProductStats().getProductType(), "zinger-waas") ? d > 10.0d ? R.drawable.zbluemedium : d > 3.0d ? R.drawable.zgreenmedium : R.drawable.zredmedium : d > 10.0d ? R.drawable.envygood : d > 3.0d ? R.drawable.envynormal : R.drawable.envybad;
        } else {
            i = -1;
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Boolean> getHardwareUpdate() {
        return this.hardwareUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hardwareUpdate$lambda-27  reason: not valid java name */
    public static final Boolean m568hardwareUpdate$lambda27(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getHardwareVersion() : false);
    }

    public final LiveData<Boolean> getSoftwareUpdate() {
        return this.softwareUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: softwareUpdate$lambda-28  reason: not valid java name */
    public static final Boolean m582softwareUpdate$lambda28(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getSoftwareVersion() : false);
    }

    public final LiveData<String> getHardwareVersion() {
        return this.hardwareVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hardwareVersion$lambda-29  reason: not valid java name */
    public static final String m569hardwareVersion$lambda29(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getCurrentHardwareVersion() : "";
    }

    public final LiveData<String> getSoftwareVersion() {
        return this.softwareVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: softwareVersion$lambda-30  reason: not valid java name */
    public static final String m583softwareVersion$lambda30(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getCurrentSoftwareVersion() : "";
    }

    public final LiveData<Triple<List<String>, List<IBarDataSet>, String>> getUsageStats() {
        return this.usageStats;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: usageStats$lambda-31  reason: not valid java name */
    public static final Triple m586usageStats$lambda31(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        List<DailyConsumptionItem> dailyConsumptionList = dashboardDetails != null ? dashboardDetails.getDailyConsumptionList() : null;
        if (!(dailyConsumptionList == null || dailyConsumptionList.isEmpty())) {
            DashboardDetails dashboardDetails2 = dashboardDetailsResponse.getDashboardDetails();
            Intrinsics.checkNotNull(dashboardDetails2);
            return dashboardDetails2.getConsumptionData();
        }
        return new Triple(null, null, "");
    }

    public final LiveData<Boolean> getSubmissionBLEStatus(String statusPkt, String powerPkt) {
        Intrinsics.checkNotNullParameter(statusPkt, "statusPkt");
        Intrinsics.checkNotNullParameter(powerPkt, "powerPkt");
        if (LSApplication.Companion.isNetworkAvailable()) {
            return Transformations.map(getBLERepository().sendBoltConfigtRequest(this.serialNo, statusPkt, false), new Function() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda23
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean m567getSubmissionBLEStatus$lambda32;
                    m567getSubmissionBLEStatus$lambda32 = EnvyHomeViewModel.m567getSubmissionBLEStatus$lambda32((BaseDataHolder) obj);
                    return m567getSubmissionBLEStatus$lambda32;
                }
            });
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubmissionBLEStatus$lambda-32  reason: not valid java name */
    public static final Boolean m567getSubmissionBLEStatus$lambda32(BaseDataHolder baseDataHolder) {
        return Boolean.valueOf(baseDataHolder.getStatus());
    }

    public final void getPendingBleCommand(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (LSApplication.Companion.isNetworkAvailable()) {
            final Lazy lazy = LazyKt.lazy(new Function0<BLECommandListRepository>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$getPendingBleCommand$bleCommandListRepository$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BLECommandListRepository invoke() {
                    return new BLECommandListRepository(context);
                }
            });
            m564getPendingBleCommand$lambda33(lazy).deleteBLEDataList();
            getLoading().setValue(true);
            this.boltCommandsResponse.addSource(getBLECommands().getBoltBleCommands(this.serialNo), new Observer() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda18
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EnvyHomeViewModel.m565getPendingBleCommand$lambda34(EnvyHomeViewModel.this, lazy, (BaseDataHolder) obj);
                }
            });
            return;
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* renamed from: getPendingBleCommand$lambda-33  reason: not valid java name */
    private static final BLECommandListRepository m564getPendingBleCommand$lambda33(Lazy<BLECommandListRepository> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPendingBleCommand$lambda-34  reason: not valid java name */
    public static final void m565getPendingBleCommand$lambda34(EnvyHomeViewModel this$0, Lazy bleCommandListRepository$delegate, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bleCommandListRepository$delegate, "$bleCommandListRepository$delegate");
        this$0.getLoading().setValue(false);
        if (baseDataHolder.getData() != null) {
            if (((BoltCommandsResponse) baseDataHolder.getData()).getRechargeCommands() != null && ((BoltCommandsResponse) baseDataHolder.getData()).getRechargeCommands().size() > 0) {
                m564getPendingBleCommand$lambda33(bleCommandListRepository$delegate).insert(((BoltCommandsResponse) baseDataHolder.getData()).getRechargeCommands());
            }
            this$0.boltCommandsResponse.setValue(baseDataHolder.getData());
            return;
        }
        MutableLiveData<Event<String>> toastMessageLiveData = this$0.getToastMessageLiveData();
        String message = baseDataHolder.getMessage();
        if (message == null) {
            message = "Sorry! We got an error while fetching all those plans.";
        }
        toastMessageLiveData.setValue(new Event<>(message));
    }

    public final void getSerialNumberStatus(String roSerialNumber) {
        Intrinsics.checkNotNullParameter(roSerialNumber, "roSerialNumber");
        if (Intrinsics.areEqual(roSerialNumber, "")) {
            return;
        }
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getSubscriptionRepository().getUpdateSerialNumber(roSerialNumber), new Observer() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda16
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        EnvyHomeViewModel.m566getSerialNumberStatus$lambda35(EnvyHomeViewModel.this, (SerialNumberUpdateResponse) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue while fetching data."));
                return;
            }
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSerialNumberStatus$lambda-35  reason: not valid java name */
    public static final void m566getSerialNumberStatus$lambda35(final EnvyHomeViewModel this$0, final SerialNumberUpdateResponse serialNumberUpdateResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(serialNumberUpdateResponse, new Function1<SerialNumberUpdateResponse, Unit>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$getSerialNumberStatus$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SerialNumberUpdateResponse serialNumberUpdateResponse2) {
                invoke2(serialNumberUpdateResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SerialNumberUpdateResponse successfulResponse) {
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                SerialNumberUpdateResponse.this.getMessage();
            }
        }, new Function1<SerialNumberUpdateResponse, Unit>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$getSerialNumberStatus$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SerialNumberUpdateResponse serialNumberUpdateResponse2) {
                invoke2(serialNumberUpdateResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SerialNumberUpdateResponse it) {
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(it, "it");
                toastMessageLiveData = EnvyHomeViewModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event(String.valueOf(it.getMessage())));
            }
        });
    }

    public final void updateLocationDetails(String latitude, String longitude) {
        Intrinsics.checkNotNullParameter(latitude, "latitude");
        Intrinsics.checkNotNullParameter(longitude, "longitude");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getSubscriptionRepository().updateLocationDetails(this.deviceSerialNumber, latitude, longitude), new Observer() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda21
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ((BaseDataHolder) obj).getStatus();
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

    public final MediatorLiveData<List<EnvyDashbordOffline>> getOfflineDashboard() {
        return this.offlineDashboard;
    }

    /* renamed from: getAllOflineDashboarData$lambda-37  reason: not valid java name */
    private static final DispenserOflineRepository m561getAllOflineDashboarData$lambda37(Lazy<DispenserOflineRepository> lazy) {
        return lazy.getValue();
    }

    public final LiveData<List<EnvyDashbordOffline>> getAllOflineDashboarData(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.offlineDashboard.setValue(m561getAllOflineDashboarData$lambda37(LazyKt.lazy(new Function0<DispenserOflineRepository>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$getAllOflineDashboarData$dispenserOflineRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DispenserOflineRepository invoke() {
                return new DispenserOflineRepository(context);
            }
        })).getDashboard());
        return this.offlineDashboard;
    }

    public final MediatorLiveData<List<RechargeResponse>> getRechargeResponse() {
        return this.rechargeResponse;
    }

    /* renamed from: getAllOflineBLECommands$lambda-38  reason: not valid java name */
    private static final BLECommandListRepository m560getAllOflineBLECommands$lambda38(Lazy<BLECommandListRepository> lazy) {
        return lazy.getValue();
    }

    public final LiveData<List<RechargeResponse>> getAllOflineBLECommands(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.rechargeResponse.setValue(m560getAllOflineBLECommands$lambda38(LazyKt.lazy(new Function0<BLECommandListRepository>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$getAllOflineBLECommands$bleCommandListRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BLECommandListRepository invoke() {
                return new BLECommandListRepository(context);
            }
        })).getBLEDataList());
        return this.rechargeResponse;
    }

    public final MediatorLiveData<List<EnvyBLEResponse>> getEnvyBLEResponseList() {
        return this.envyBLEResponseList;
    }

    /* renamed from: getAllEnvyBLEResponse$lambda-39  reason: not valid java name */
    private static final EnvyBLEResponseRepository m559getAllEnvyBLEResponse$lambda39(Lazy<EnvyBLEResponseRepository> lazy) {
        return lazy.getValue();
    }

    public final LiveData<List<EnvyBLEResponse>> getAllEnvyBLEResponse(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.envyBLEResponseList.setValue(m559getAllEnvyBLEResponse$lambda39(LazyKt.lazy(new Function0<EnvyBLEResponseRepository>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$getAllEnvyBLEResponse$envyBLEResponseRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EnvyBLEResponseRepository invoke() {
                return new EnvyBLEResponseRepository(context);
            }
        })).getBLEResponse());
        return this.envyBLEResponseList;
    }

    public final void offlineBLEStatus(final Context context, String serialNumber, String status, final boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serialNumber, "serialNumber");
        Intrinsics.checkNotNullParameter(status, "status");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getBLERepository().sendBoltConfigtRequest(serialNumber, status, true), new Observer() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$$ExternalSyntheticLambda20
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        EnvyHomeViewModel.m575offlineBLEStatus$lambda41(EnvyHomeViewModel.this, z, context, (BaseDataHolder) obj);
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
    /* renamed from: offlineBLEStatus$lambda-41  reason: not valid java name */
    public static final void m575offlineBLEStatus$lambda41(EnvyHomeViewModel this$0, boolean z, final Context context, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.getLoading().setValue(false);
        if (z) {
            m576offlineBLEStatus$lambda41$lambda40(LazyKt.lazy(new Function0<EnvyBLEResponseRepository>() { // from class: com.livpure.safedrink.dispenser.model.EnvyHomeViewModel$offlineBLEStatus$1$envyBLEResponseRepository$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final EnvyBLEResponseRepository invoke() {
                    return new EnvyBLEResponseRepository(context);
                }
            })).deleteBLEResponse();
        }
    }

    /* renamed from: offlineBLEStatus$lambda-41$lambda-40  reason: not valid java name */
    private static final EnvyBLEResponseRepository m576offlineBLEStatus$lambda41$lambda40(Lazy<EnvyBLEResponseRepository> lazy) {
        return lazy.getValue();
    }

    public final Integer offlineWaterTank(String reading) {
        Intrinsics.checkNotNullParameter(reading, "reading");
        long parseLong = Long.parseLong(reading);
        this.remainingLitres = parseLong;
        return Integer.valueOf(parseLong > 40 ? R.drawable.fullwaterlarge : parseLong > 10 ? R.drawable.purifyinglarge : R.drawable.emptywaterlarge);
    }

    public final Integer offlineFilterLife(String reading) {
        Intrinsics.checkNotNullParameter(reading, "reading");
        try {
            double parseLong = Long.parseLong(reading);
            return Integer.valueOf(parseLong > 10.0d ? R.drawable.envygood : parseLong > 3.0d ? R.drawable.envynormal : R.drawable.envybad);
        } catch (Exception unused) {
            return Integer.valueOf((int) R.drawable.envygood);
        }
    }
}
