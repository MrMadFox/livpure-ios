package com.livpure.safedrink.dispenser.model;

import androidx.arch.core.util.Function;
import androidx.exifinterface.media.ExifInterface;
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
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.dispenser.data.DispenserCommandsRepository;
import com.livpure.safedrink.dispenser.data.models.DispenserCommands;
import com.livpure.safedrink.dispenser.data.models.DispenserImageStatus;
import com.livpure.safedrink.dispenser.data.models.DispenserPublishCommand;
import com.livpure.safedrink.subscription.plan.data.DispenserRoSetting;
import com.livpure.safedrink.subscription.plan.data.SubscriptionRepository;
import com.livpure.safedrink.subscription.plan.data.model.DashboardDetailsResponse;
import com.livpure.safedrink.subscription.plan.data.model.SubscriptionDetails;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.DailyConsumptionItem;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.DashboardDetails;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.ProductStats;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
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
/* compiled from: HomeAirToWaterModel.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bD\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010Ì\u0001\u001a\u00030Í\u00012\u0007\u0010Î\u0001\u001a\u00020$J\b\u0010Ï\u0001\u001a\u00030Í\u0001J\b\u0010Ð\u0001\u001a\u00030Í\u0001J!\u0010Ñ\u0001\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010\u00152\u0007\u0010Ò\u0001\u001a\u00020$2\u0007\u0010Ó\u0001\u001a\u00020$J#\u0010Ô\u0001\u001a\u00030Í\u00012\u0007\u0010Õ\u0001\u001a\u00020$2\u0007\u0010Ö\u0001\u001a\u00020$2\u0007\u0010×\u0001\u001a\u00020$R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR \u0010,\u001a\b\u0012\u0004\u0012\u00020$0-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\u001a\u00105\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010&\"\u0004\b7\u0010(R \u00108\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0018\"\u0004\b:\u0010\u001aR\u001a\u0010;\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010&\"\u0004\b=\u0010(R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020?0-X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010A\u001a\u0004\u0018\u00010\u000f2\b\u0010@\u001a\u0004\u0018\u00010\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0011\"\u0004\bC\u0010\u0013R\u000e\u0010D\u001a\u00020EX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010H\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\b\u001a\u0004\bJ\u0010KR\u001a\u0010M\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010&\"\u0004\bO\u0010(R\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020$0-¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010/R\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020$0-¢\u0006\b\n\u0000\u001a\u0004\bS\u0010/R\u0017\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0018R\u0017\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u0015¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\u0018R\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020$0\u0015¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010\u0018R \u0010[\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0018\"\u0004\b]\u0010\u001aR\u001a\u0010^\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010&\"\u0004\b`\u0010(R\u000e\u0010a\u001a\u00020bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010c\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010&\"\u0004\be\u0010(R \u0010f\u001a\b\u0012\u0004\u0012\u00020$0\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0018\"\u0004\bh\u0010\u001aR\u0017\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\bj\u0010\u0018R\u0017\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\bl\u0010\u0018R\u0017\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\bn\u0010\u0018R\u0017\u0010o\u001a\b\u0012\u0004\u0012\u00020$0\u0015¢\u0006\b\n\u0000\u001a\u0004\bp\u0010\u0018R\u0017\u0010q\u001a\b\u0012\u0004\u0012\u00020$0\u0015¢\u0006\b\n\u0000\u001a\u0004\br\u0010\u0018R\u0017\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\bt\u0010\u0018R\u0017\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\bv\u0010\u0018R\u0017\u0010w\u001a\b\u0012\u0004\u0012\u00020$0\u0015¢\u0006\b\n\u0000\u001a\u0004\bx\u0010\u0018R\u0017\u0010y\u001a\b\u0012\u0004\u0012\u00020$0\u0015¢\u0006\b\n\u0000\u001a\u0004\bz\u0010\u0018R\u0017\u0010{\u001a\b\u0012\u0004\u0012\u00020$0\u0015¢\u0006\b\n\u0000\u001a\u0004\b|\u0010\u0018R\u0017\u0010}\u001a\b\u0012\u0004\u0012\u00020$0\u0015¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u0018R\u0018\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020$0\u0015¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010\u0018R\u0019\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u0015¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u0018R\u0019\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u0015¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u0018R\u0019\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020W0\u0015¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010\u0018R\u001d\u0010\u0087\u0001\u001a\u00020$X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010&\"\u0005\b\u0089\u0001\u0010(R\u001d\u0010\u008a\u0001\u001a\u00020$X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010&\"\u0005\b\u008c\u0001\u0010(R\u001d\u0010\u008d\u0001\u001a\u00020$X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010&\"\u0005\b\u008f\u0001\u0010(R\u0019\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u0015¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010\u0018R\u0019\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020$0-¢\u0006\t\n\u0000\u001a\u0005\b\u0093\u0001\u0010/R#\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\u0018\"\u0005\b\u0096\u0001\u0010\u001aR\u0019\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020$0-¢\u0006\t\n\u0000\u001a\u0005\b\u0098\u0001\u0010/R#\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010\u0018\"\u0005\b\u009b\u0001\u0010\u001aR\u001e\u0010\u009c\u0001\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u009e\u0001\u0010\b\u001a\u0005\b\u009d\u0001\u0010KR\u001d\u0010\u009f\u0001\u001a\u00020$X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010&\"\u0005\b¡\u0001\u0010(R\u0019\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020W0\u0015¢\u0006\t\n\u0000\u001a\u0005\b£\u0001\u0010\u0018R\u0019\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u0015¢\u0006\t\n\u0000\u001a\u0005\b¥\u0001\u0010\u0018R \u0010¦\u0001\u001a\u00030§\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bª\u0001\u0010\b\u001a\u0006\b¨\u0001\u0010©\u0001R\u0019\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\t\n\u0000\u001a\u0005\b¬\u0001\u0010\u0018R\u001d\u0010\u00ad\u0001\u001a\u00020$X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010&\"\u0005\b¯\u0001\u0010(R?\u0010°\u0001\u001a.\u0012*\u0012(\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020$\u0018\u00010²\u0001\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030³\u0001\u0018\u00010²\u0001\u0012\u0004\u0012\u00020$0±\u00010\u0015¢\u0006\t\n\u0000\u001a\u0005\b´\u0001\u0010\u0018R\u0019\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\t\n\u0000\u001a\u0005\b¶\u0001\u0010\u0018R\u001d\u0010·\u0001\u001a\u00020$X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¸\u0001\u0010&\"\u0005\b¹\u0001\u0010(R#\u0010º\u0001\u001a\b\u0012\u0004\u0012\u00020$0-X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b»\u0001\u0010/\"\u0005\b¼\u0001\u00101R0\u0010½\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160¾\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¿\u0001\u0010\u0018\"\u0005\bÀ\u0001\u0010\u001aR#\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020W0-X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÂ\u0001\u0010/\"\u0005\bÃ\u0001\u00101R(\u0010Ä\u0001\u001a\u0017\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010\u00160¾\u00010\u0015¢\u0006\t\n\u0000\u001a\u0005\bÅ\u0001\u0010\u0018R#\u0010Æ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÇ\u0001\u0010\u0018\"\u0005\bÈ\u0001\u0010\u001aR#\u0010É\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÊ\u0001\u0010\u0018\"\u0005\bË\u0001\u0010\u001a¨\u0006Ø\u0001"}, d2 = {"Lcom/livpure/safedrink/dispenser/model/HomeAirToWaterModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "BLECommands", "Lcom/livpure/safedrink/bolt/data/BoltBleCommandsRespository;", "getBLECommands", "()Lcom/livpure/safedrink/bolt/data/BoltBleCommandsRespository;", "BLECommands$delegate", "Lkotlin/Lazy;", "BLERepository", "Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "getBLERepository", "()Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "BLERepository$delegate", "_device", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "get_device", "()Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "set_device", "(Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;)V", "bleImage", "Landroidx/lifecycle/LiveData;", "", "getBleImage", "()Landroidx/lifecycle/LiveData;", "setBleImage", "(Landroidx/lifecycle/LiveData;)V", "bleImageOff", "getBleImageOff", "setBleImageOff", "boltCommandsResponse", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", "getBoltCommandsResponse", "()Landroidx/lifecycle/MediatorLiveData;", "buzzer", "", "getBuzzer", "()Ljava/lang/String;", "setBuzzer", "(Ljava/lang/String;)V", "colTankImage", "getColTankImage", "setColTankImage", "coldTankStatus", "Landroidx/lifecycle/MutableLiveData;", "getColdTankStatus", "()Landroidx/lifecycle/MutableLiveData;", "setColdTankStatus", "(Landroidx/lifecycle/MutableLiveData;)V", "coldWaterDispenserStatus", "getColdWaterDispenserStatus", "setColdWaterDispenserStatus", "condenserFanSpeed", "getCondenserFanSpeed", "setCondenserFanSpeed", "condenserFanSpeedImage", "getCondenserFanSpeedImage", "setCondenserFanSpeedImage", "connectivity", "getConnectivity", "setConnectivity", "dashboardData", "Lcom/livpure/safedrink/subscription/plan/data/model/DashboardDetailsResponse;", "value", AndroidContextPlugin.DEVICE_KEY, "getDevice", "setDevice", "dispenseCommand", "Lcom/livpure/safedrink/dispenser/data/models/DispenserPublishCommand;", "dispenserCommand", "Lcom/livpure/safedrink/dispenser/data/models/DispenserCommands;", "dispenserCommandsRespository", "Lcom/livpure/safedrink/dispenser/data/DispenserCommandsRepository;", "getDispenserCommandsRespository", "()Lcom/livpure/safedrink/dispenser/data/DispenserCommandsRepository;", "dispenserCommandsRespository$delegate", "dispenserStatus", "getDispenserStatus", "setDispenserStatus", "faultDescription", "getFaultDescription", "filterLife", "getFilterLife", "filterLifeImage", "getFilterLifeImage", "hardwareUpdate", "", "getHardwareUpdate", "hardwareVersion", "getHardwareVersion", "heaterStatusImage", "getHeaterStatusImage", "setHeaterStatusImage", "hotWaterTemprature", "getHotWaterTemprature", "setHotWaterTemprature", "imageStatus", "Lcom/livpure/safedrink/dispenser/data/models/DispenserImageStatus;", "imeiNumber", "getImeiNumber", "setImeiNumber", "lastSynchronizedDate", "getLastSynchronizedDate", "setLastSynchronizedDate", "liveColdTankImage", "getLiveColdTankImage", "liveColdWaterDispenserStatusImage", "getLiveColdWaterDispenserStatusImage", "liveCollectionTankImage", "getLiveCollectionTankImage", "liveCompressorButtonStatus", "getLiveCompressorButtonStatus", "liveCondenserFanSpeed", "getLiveCondenserFanSpeed", "liveDispenserStatus", "getLiveDispenserStatus", "liveDispenserStatusImage", "getLiveDispenserStatusImage", "liveEvaporatorFanSpeed", "getLiveEvaporatorFanSpeed", "liveFeelsLikeZone", "getLiveFeelsLikeZone", "liveHeaterStatus", "getLiveHeaterStatus", "liveHumidity", "getLiveHumidity", "liveQuietModeStatus", "getLiveQuietModeStatus", "liveTemperature", "getLiveTemperature", "liveWaterGenerationStatus", "getLiveWaterGenerationStatus", "loadingStatus", "getLoadingStatus", "menuHeaterStatus", "getMenuHeaterStatus", "setMenuHeaterStatus", "menuQuietModeStatus", "getMenuQuietModeStatus", "setMenuQuietModeStatus", "menuWaterGenerationStatus", "getMenuWaterGenerationStatus", "setMenuWaterGenerationStatus", "planDetails", "getPlanDetails", "planName", "getPlanName", "productType", "getProductType", "setProductType", "publishCommandStatus", "getPublishCommandStatus", "quietModeStatusImage", "getQuietModeStatusImage", "setQuietModeStatusImage", "repository", "getRepository", "repository$delegate", "serialNumber", "getSerialNumber", "setSerialNumber", "softwareUpdate", "getSoftwareUpdate", "softwareVersion", "getSoftwareVersion", "subscriptionRepository", "Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "getSubscriptionRepository", "()Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "subscriptionRepository$delegate", "tdsImage", "getTdsImage", "tempStatus", "getTempStatus", "setTempStatus", "usageStats", "Lkotlin/Triple;", "", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "getUsageStats", "uvImage", "getUvImage", "warmWaterTemprature", "getWarmWaterTemprature", "setWarmWaterTemprature", "waterGenerationStatus", "getWaterGenerationStatus", "setWaterGenerationStatus", "waterGenerationStatusImage", "Lkotlin/Pair;", "getWaterGenerationStatusImage", "setWaterGenerationStatusImage", "waterPurificationStatus", "getWaterPurificationStatus", "setWaterPurificationStatus", "waterRemaining", "getWaterRemaining", "wifiImage", "getWifiImage", "setWifiImage", "wifiImageOff", "getWifiImageOff", "setWifiImageOff", "bleStatus", "", "status", "getDashboardDetails", "getPendingBleCommand", "getSubmissionBLEStatus", "statusPkt", "powerPkt", "publishCommand", "command", "warmWater", "hotWater", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeAirToWaterModel extends MediatorViewModel {
    private final Lazy BLECommands$delegate;
    private final Lazy BLERepository$delegate;
    private DeviceList _device;
    private LiveData<Integer> bleImage;
    private LiveData<Integer> bleImageOff;
    private final MediatorLiveData<BoltCommandsResponse> boltCommandsResponse;
    private LiveData<Integer> colTankImage;
    private MutableLiveData<String> coldTankStatus;
    private String condenserFanSpeed;
    private LiveData<Integer> condenserFanSpeedImage;
    private final MutableLiveData<DashboardDetailsResponse> dashboardData;
    private DeviceList device;
    private DispenserPublishCommand dispenseCommand;
    private DispenserCommands dispenserCommand;
    private final Lazy dispenserCommandsRespository$delegate;
    private final MutableLiveData<String> faultDescription;
    private final MutableLiveData<String> filterLife;
    private final LiveData<Integer> filterLifeImage;
    private final LiveData<Boolean> hardwareUpdate;
    private final LiveData<String> hardwareVersion;
    private LiveData<Integer> heaterStatusImage;
    private DispenserImageStatus imageStatus;
    private LiveData<String> lastSynchronizedDate;
    private final LiveData<Integer> liveColdTankImage;
    private final LiveData<Integer> liveColdWaterDispenserStatusImage;
    private final LiveData<Integer> liveCollectionTankImage;
    private final LiveData<String> liveCompressorButtonStatus;
    private final LiveData<String> liveCondenserFanSpeed;
    private final LiveData<Integer> liveDispenserStatus;
    private final LiveData<Integer> liveDispenserStatusImage;
    private final LiveData<String> liveEvaporatorFanSpeed;
    private final LiveData<String> liveFeelsLikeZone;
    private final LiveData<String> liveHeaterStatus;
    private final LiveData<String> liveHumidity;
    private final LiveData<String> liveQuietModeStatus;
    private final LiveData<String> liveTemperature;
    private final LiveData<String> liveWaterGenerationStatus;
    private final LiveData<Boolean> loadingStatus;
    private String menuHeaterStatus;
    private String menuQuietModeStatus;
    private String menuWaterGenerationStatus;
    private final LiveData<String> planDetails;
    private final MutableLiveData<String> planName;
    private LiveData<String> productType;
    private final MutableLiveData<String> publishCommandStatus;
    private LiveData<Integer> quietModeStatusImage;
    private final LiveData<Boolean> softwareUpdate;
    private final LiveData<String> softwareVersion;
    private final Lazy subscriptionRepository$delegate;
    private final LiveData<Integer> tdsImage;
    private final LiveData<Triple<List<String>, List<IBarDataSet>, String>> usageStats;
    private final LiveData<Integer> uvImage;
    private MutableLiveData<String> waterGenerationStatus;
    private LiveData<Pair<Integer, Integer>> waterGenerationStatusImage;
    private MutableLiveData<Boolean> waterPurificationStatus;
    private final LiveData<Pair<String, Integer>> waterRemaining;
    private LiveData<Integer> wifiImage;
    private LiveData<Integer> wifiImageOff;
    private final Lazy repository$delegate = LazyKt.lazy(new Function0<DispenserCommandsRepository>() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$repository$2
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
    private String coldWaterDispenserStatus = "";
    private String serialNumber = "";
    private String hotWaterTemprature = "";
    private String warmWaterTemprature = "";
    private String tempStatus = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadingStatus$lambda-19  reason: not valid java name */
    public static final Boolean m633loadingStatus$lambda19(Boolean bool) {
        return bool;
    }

    public HomeAirToWaterModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue("");
        this.waterGenerationStatus = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue("");
        this.coldTankStatus = mutableLiveData2;
        this.menuHeaterStatus = "";
        this.menuWaterGenerationStatus = "";
        this.menuQuietModeStatus = "";
        this.condenserFanSpeed = "";
        this.subscriptionRepository$delegate = LazyKt.lazy(new Function0<SubscriptionRepository>() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$subscriptionRepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SubscriptionRepository invoke() {
                return new SubscriptionRepository();
            }
        });
        this.dispenserCommandsRespository$delegate = LazyKt.lazy(new Function0<DispenserCommandsRepository>() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$dispenserCommandsRespository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DispenserCommandsRepository invoke() {
                return new DispenserCommandsRepository();
            }
        });
        MutableLiveData<DashboardDetailsResponse> mutableLiveData3 = new MutableLiveData<>();
        this.dashboardData = mutableLiveData3;
        this.boltCommandsResponse = new MediatorLiveData<>();
        this.BLERepository$delegate = LazyKt.lazy(new Function0<BoltDataUpdateRepository>() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$BLERepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BoltDataUpdateRepository invoke() {
                return new BoltDataUpdateRepository();
            }
        });
        this.BLECommands$delegate = LazyKt.lazy(new Function0<BoltBleCommandsRespository>() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$BLECommands$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BoltBleCommandsRespository invoke() {
                return new BoltBleCommandsRespository();
            }
        });
        MutableLiveData<String> mutableLiveData4 = new MutableLiveData<>();
        mutableLiveData4.setValue("");
        this.faultDescription = mutableLiveData4;
        MutableLiveData<String> mutableLiveData5 = new MutableLiveData<>();
        mutableLiveData5.setValue("");
        this.filterLife = mutableLiveData5;
        MutableLiveData<String> mutableLiveData6 = new MutableLiveData<>();
        mutableLiveData6.setValue("");
        this.planName = mutableLiveData6;
        this.publishCommandStatus = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData7 = new MutableLiveData<>();
        mutableLiveData7.setValue(false);
        this.waterPurificationStatus = mutableLiveData7;
        LiveData<String> map = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda15
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m618lastSynchronizedDate$lambda7;
                m618lastSynchronizedDate$lambda7 = HomeAirToWaterModel.m618lastSynchronizedDate$lambda7((DashboardDetailsResponse) obj);
                return m618lastSynchronizedDate$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.lastSynchronizedDate = map;
        LiveData<String> map2 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda24
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m635productType$lambda9;
                m635productType$lambda9 = HomeAirToWaterModel.m635productType$lambda9((DashboardDetailsResponse) obj);
                return m635productType$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.productType = map2;
        LiveData<Pair<Integer, Integer>> map3 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda11
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Pair m643waterGenerationStatusImage$lambda10;
                m643waterGenerationStatusImage$lambda10 = HomeAirToWaterModel.m643waterGenerationStatusImage$lambda10(HomeAirToWaterModel.this, (DashboardDetailsResponse) obj);
                return m643waterGenerationStatusImage$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map3, "map(dashboardData) {\n   …atus_off)\n        }\n    }");
        this.waterGenerationStatusImage = map3;
        LiveData<Integer> map4 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda22
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m609colTankImage$lambda11;
                m609colTankImage$lambda11 = HomeAirToWaterModel.m609colTankImage$lambda11(HomeAirToWaterModel.this, (DashboardDetailsResponse) obj);
                return m609colTankImage$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map4, "map(dashboardData) {\n   …ank_empty\n        }\n    }");
        this.colTankImage = map4;
        LiveData<Integer> map5 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m617heaterStatusImage$lambda12;
                m617heaterStatusImage$lambda12 = HomeAirToWaterModel.m617heaterStatusImage$lambda12(HomeAirToWaterModel.this, (DashboardDetailsResponse) obj);
                return m617heaterStatusImage$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map5, "map(dashboardData) {\n   …water_off\n        }\n    }");
        this.heaterStatusImage = map5;
        LiveData<Integer> map6 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda35
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m610condenserFanSpeedImage$lambda13;
                m610condenserFanSpeedImage$lambda13 = HomeAirToWaterModel.m610condenserFanSpeedImage$lambda13(HomeAirToWaterModel.this, (DashboardDetailsResponse) obj);
                return m610condenserFanSpeedImage$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map6, "map(dashboardData) {\n   …_mode_off\n        }\n    }");
        this.condenserFanSpeedImage = map6;
        LiveData<Integer> map7 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda36
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m637quietModeStatusImage$lambda14;
                m637quietModeStatusImage$lambda14 = HomeAirToWaterModel.m637quietModeStatusImage$lambda14(HomeAirToWaterModel.this, (DashboardDetailsResponse) obj);
                return m637quietModeStatusImage$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map7, "map(dashboardData) {\n   …_mode_off\n        }\n    }");
        this.quietModeStatusImage = map7;
        LiveData<Integer> map8 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda27
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m645wifiImage$lambda15;
                m645wifiImage$lambda15 = HomeAirToWaterModel.m645wifiImage$lambda15((DashboardDetailsResponse) obj);
                return m645wifiImage$lambda15;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map8, "map(dashboardData) {\n        R.drawable.wifi\n    }");
        this.wifiImage = map8;
        LiveData<Integer> map9 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda25
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m606bleImage$lambda16;
                m606bleImage$lambda16 = HomeAirToWaterModel.m606bleImage$lambda16((DashboardDetailsResponse) obj);
                return m606bleImage$lambda16;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map9, "map(dashboardData) {\n   ….drawable.bluetooth\n    }");
        this.bleImage = map9;
        LiveData<Integer> map10 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda18
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m646wifiImageOff$lambda17;
                m646wifiImageOff$lambda17 = HomeAirToWaterModel.m646wifiImageOff$lambda17((DashboardDetailsResponse) obj);
                return m646wifiImageOff$lambda17;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map10, "map(dashboardData) {\n   …R.drawable.wifi_off\n    }");
        this.wifiImageOff = map10;
        LiveData<Integer> map11 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda20
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m607bleImageOff$lambda18;
                m607bleImageOff$lambda18 = HomeAirToWaterModel.m607bleImageOff$lambda18((DashboardDetailsResponse) obj);
                return m607bleImageOff$lambda18;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map11, "map(dashboardData) {\n   …wable.bluetooth_off\n    }");
        this.bleImageOff = map11;
        LiveData<Boolean> map12 = Transformations.map(getLoading(), new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda29
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m633loadingStatus$lambda19;
                m633loadingStatus$lambda19 = HomeAirToWaterModel.m633loadingStatus$lambda19((Boolean) obj);
                return m633loadingStatus$lambda19;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map12, "map(loading) {\n        it\n    }");
        this.loadingStatus = map12;
        LiveData<Integer> map13 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda21
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m624liveDispenserStatus$lambda21;
                m624liveDispenserStatus$lambda21 = HomeAirToWaterModel.m624liveDispenserStatus$lambda21((DashboardDetailsResponse) obj);
                return m624liveDispenserStatus$lambda21;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map13, "map(dashboardData) {\n   …        }\n        0\n    }");
        this.liveDispenserStatus = map13;
        LiveData<Integer> map14 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda9
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m619liveColdTankImage$lambda22;
                m619liveColdTankImage$lambda22 = HomeAirToWaterModel.m619liveColdTankImage$lambda22((DashboardDetailsResponse) obj);
                return m619liveColdTankImage$lambda22;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map14, "map(dashboardData) {\n   …ank_empty\n        }\n    }");
        this.liveColdTankImage = map14;
        LiveData<Integer> map15 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda23
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m621liveCollectionTankImage$lambda23;
                m621liveCollectionTankImage$lambda23 = HomeAirToWaterModel.m621liveCollectionTankImage$lambda23((DashboardDetailsResponse) obj);
                return m621liveCollectionTankImage$lambda23;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map15, "map(dashboardData) {\n   …ank_empty\n        }\n    }");
        this.liveCollectionTankImage = map15;
        LiveData<String> map16 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda28
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m632liveWaterGenerationStatus$lambda24;
                m632liveWaterGenerationStatus$lambda24 = HomeAirToWaterModel.m632liveWaterGenerationStatus$lambda24((DashboardDetailsResponse) obj);
                return m632liveWaterGenerationStatus$lambda24;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map16, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.liveWaterGenerationStatus = map16;
        LiveData<String> map17 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda10
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m627liveFeelsLikeZone$lambda25;
                m627liveFeelsLikeZone$lambda25 = HomeAirToWaterModel.m627liveFeelsLikeZone$lambda25((DashboardDetailsResponse) obj);
                return m627liveFeelsLikeZone$lambda25;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map17, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.liveFeelsLikeZone = map17;
        LiveData<String> map18 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda12
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m626liveEvaporatorFanSpeed$lambda26;
                m626liveEvaporatorFanSpeed$lambda26 = HomeAirToWaterModel.m626liveEvaporatorFanSpeed$lambda26((DashboardDetailsResponse) obj);
                return m626liveEvaporatorFanSpeed$lambda26;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map18, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.liveEvaporatorFanSpeed = map18;
        LiveData<String> map19 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda4
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m623liveCondenserFanSpeed$lambda27;
                m623liveCondenserFanSpeed$lambda27 = HomeAirToWaterModel.m623liveCondenserFanSpeed$lambda27((DashboardDetailsResponse) obj);
                return m623liveCondenserFanSpeed$lambda27;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map19, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.liveCondenserFanSpeed = map19;
        LiveData<String> map20 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda14
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m628liveHeaterStatus$lambda28;
                m628liveHeaterStatus$lambda28 = HomeAirToWaterModel.m628liveHeaterStatus$lambda28((DashboardDetailsResponse) obj);
                return m628liveHeaterStatus$lambda28;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map20, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.liveHeaterStatus = map20;
        LiveData<String> map21 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda13
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m630liveQuietModeStatus$lambda29;
                m630liveQuietModeStatus$lambda29 = HomeAirToWaterModel.m630liveQuietModeStatus$lambda29((DashboardDetailsResponse) obj);
                return m630liveQuietModeStatus$lambda29;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map21, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.liveQuietModeStatus = map21;
        LiveData<String> map22 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda8
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m622liveCompressorButtonStatus$lambda30;
                m622liveCompressorButtonStatus$lambda30 = HomeAirToWaterModel.m622liveCompressorButtonStatus$lambda30((DashboardDetailsResponse) obj);
                return m622liveCompressorButtonStatus$lambda30;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map22, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.liveCompressorButtonStatus = map22;
        LiveData<String> map23 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda17
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m631liveTemperature$lambda31;
                m631liveTemperature$lambda31 = HomeAirToWaterModel.m631liveTemperature$lambda31((DashboardDetailsResponse) obj);
                return m631liveTemperature$lambda31;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map23, "map(dashboardData) {\n   …    \"_ _\"\n        }\n    }");
        this.liveTemperature = map23;
        LiveData<String> map24 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda5
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m629liveHumidity$lambda32;
                m629liveHumidity$lambda32 = HomeAirToWaterModel.m629liveHumidity$lambda32((DashboardDetailsResponse) obj);
                return m629liveHumidity$lambda32;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map24, "map(dashboardData) {\n   …    \"_ _\"\n        }\n    }");
        this.liveHumidity = map24;
        LiveData<Integer> map25 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda40
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m620liveColdWaterDispenserStatusImage$lambda33;
                m620liveColdWaterDispenserStatusImage$lambda33 = HomeAirToWaterModel.m620liveColdWaterDispenserStatusImage$lambda33((DashboardDetailsResponse) obj);
                return m620liveColdWaterDispenserStatusImage$lambda33;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map25, "map(dashboardData) {\n   …_dispense\n        }\n    }");
        this.liveColdWaterDispenserStatusImage = map25;
        LiveData<Integer> map26 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda7
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m625liveDispenserStatusImage$lambda34;
                m625liveDispenserStatusImage$lambda34 = HomeAirToWaterModel.m625liveDispenserStatusImage$lambda34((DashboardDetailsResponse) obj);
                return m625liveDispenserStatusImage$lambda34;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map26, "map(dashboardData) {\n   …_dispense\n        }\n    }");
        this.liveDispenserStatusImage = map26;
        LiveData<Pair<String, Integer>> map27 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda33
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Pair m644waterRemaining$lambda35;
                m644waterRemaining$lambda35 = HomeAirToWaterModel.m644waterRemaining$lambda35(HomeAirToWaterModel.this, (DashboardDetailsResponse) obj);
                return m644waterRemaining$lambda35;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map27, "map(dashboardData) {\n   …\"\", null)\n        }\n    }");
        this.waterRemaining = map27;
        LiveData<Integer> map28 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda19
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m642uvImage$lambda36;
                m642uvImage$lambda36 = HomeAirToWaterModel.m642uvImage$lambda36((DashboardDetailsResponse) obj);
                return m642uvImage$lambda36;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map28, "map(dashboardData) {\n   …le.uv_off\n        }\n    }");
        this.uvImage = map28;
        LiveData<Integer> map29 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda26
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m640tdsImage$lambda37;
                m640tdsImage$lambda37 = HomeAirToWaterModel.m640tdsImage$lambda37((DashboardDetailsResponse) obj);
                return m640tdsImage$lambda37;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map29, "map(dashboardData) {\n   …drawable.tds_band_1\n    }");
        this.tdsImage = map29;
        LiveData<String> map30 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda39
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m634planDetails$lambda38;
                m634planDetails$lambda38 = HomeAirToWaterModel.m634planDetails$lambda38((DashboardDetailsResponse) obj);
                return m634planDetails$lambda38;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map30, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.planDetails = map30;
        LiveData<Integer> map31 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m611filterLifeImage$lambda39;
                m611filterLifeImage$lambda39 = HomeAirToWaterModel.m611filterLifeImage$lambda39((DashboardDetailsResponse) obj);
                return m611filterLifeImage$lambda39;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map31, "map(dashboardData) {\n   …       -1\n        }\n    }");
        this.filterLifeImage = map31;
        LiveData<Boolean> map32 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda3
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m615hardwareUpdate$lambda40;
                m615hardwareUpdate$lambda40 = HomeAirToWaterModel.m615hardwareUpdate$lambda40((DashboardDetailsResponse) obj);
                return m615hardwareUpdate$lambda40;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map32, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.hardwareUpdate = map32;
        LiveData<Boolean> map33 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m638softwareUpdate$lambda41;
                m638softwareUpdate$lambda41 = HomeAirToWaterModel.m638softwareUpdate$lambda41((DashboardDetailsResponse) obj);
                return m638softwareUpdate$lambda41;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map33, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.softwareUpdate = map33;
        LiveData<String> map34 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda16
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m616hardwareVersion$lambda42;
                m616hardwareVersion$lambda42 = HomeAirToWaterModel.m616hardwareVersion$lambda42((DashboardDetailsResponse) obj);
                return m616hardwareVersion$lambda42;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map34, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.hardwareVersion = map34;
        LiveData<String> map35 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda6
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m639softwareVersion$lambda43;
                m639softwareVersion$lambda43 = HomeAirToWaterModel.m639softwareVersion$lambda43((DashboardDetailsResponse) obj);
                return m639softwareVersion$lambda43;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map35, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.softwareVersion = map35;
        LiveData<Triple<List<String>, List<IBarDataSet>, String>> map36 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda38
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Triple m641usageStats$lambda44;
                m641usageStats$lambda44 = HomeAirToWaterModel.m641usageStats$lambda44((DashboardDetailsResponse) obj);
                return m641usageStats$lambda44;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map36, "map(dashboardData) {\n   …null, \"\")\n        }\n    }");
        this.usageStats = map36;
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

    public final String getColdWaterDispenserStatus() {
        return this.coldWaterDispenserStatus;
    }

    public final void setColdWaterDispenserStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coldWaterDispenserStatus = str;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final void setSerialNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serialNumber = str;
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

    public final MutableLiveData<String> getWaterGenerationStatus() {
        return this.waterGenerationStatus;
    }

    public final void setWaterGenerationStatus(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.waterGenerationStatus = mutableLiveData;
    }

    public final MutableLiveData<String> getColdTankStatus() {
        return this.coldTankStatus;
    }

    public final void setColdTankStatus(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.coldTankStatus = mutableLiveData;
    }

    public final String getMenuHeaterStatus() {
        return this.menuHeaterStatus;
    }

    public final void setMenuHeaterStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.menuHeaterStatus = str;
    }

    public final String getMenuWaterGenerationStatus() {
        return this.menuWaterGenerationStatus;
    }

    public final void setMenuWaterGenerationStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.menuWaterGenerationStatus = str;
    }

    public final String getMenuQuietModeStatus() {
        return this.menuQuietModeStatus;
    }

    public final void setMenuQuietModeStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.menuQuietModeStatus = str;
    }

    public final String getCondenserFanSpeed() {
        return this.condenserFanSpeed;
    }

    public final void setCondenserFanSpeed(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.condenserFanSpeed = str;
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

    public final MutableLiveData<String> getPublishCommandStatus() {
        return this.publishCommandStatus;
    }

    public final MutableLiveData<Boolean> getWaterPurificationStatus() {
        return this.waterPurificationStatus;
    }

    public final void setWaterPurificationStatus(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.waterPurificationStatus = mutableLiveData;
    }

    public final void publishCommand(String command, String warmWater, String hotWater) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(warmWater, "warmWater");
        Intrinsics.checkNotNullParameter(hotWater, "hotWater");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            this.dispenseCommand = new DispenserPublishCommand(command, warmWater, hotWater, "");
            String str = this.imeiNumber;
            DispenserPublishCommand dispenserPublishCommand = this.dispenseCommand;
            DispenserCommands dispenserCommands = null;
            if (dispenserPublishCommand == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dispenseCommand");
                dispenserPublishCommand = null;
            }
            this.dispenserCommand = new DispenserCommands(str, dispenserPublishCommand);
            try {
                DispenserCommandsRepository dispenserCommandsRespository = getDispenserCommandsRespository();
                DispenserCommands dispenserCommands2 = this.dispenserCommand;
                if (dispenserCommands2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dispenserCommand");
                } else {
                    dispenserCommands = dispenserCommands2;
                }
                observeAndTrack(dispenserCommandsRespository.sendDispenserCommand(dispenserCommands), new Observer() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda31
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeAirToWaterModel.m636publishCommand$lambda6(HomeAirToWaterModel.this, (BaseDataHolder) obj);
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
    /* renamed from: publishCommand$lambda-6  reason: not valid java name */
    public static final void m636publishCommand$lambda6(HomeAirToWaterModel this$0, BaseDataHolder baseDataHolder) {
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
    /* renamed from: lastSynchronizedDate$lambda-7  reason: not valid java name */
    public static final String m618lastSynchronizedDate$lambda7(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getLastSyncDate() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getLastSyncDate() : "";
    }

    public final void bleStatus(final String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getBLERepository().sendBoltConfigtRequest(this.serialNumber, status, false), new Observer() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda34
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeAirToWaterModel.m608bleStatus$lambda8(HomeAirToWaterModel.this, status, (BaseDataHolder) obj);
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
    /* renamed from: bleStatus$lambda-8  reason: not valid java name */
    public static final void m608bleStatus$lambda8(HomeAirToWaterModel this$0, String status, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(status, "$status");
        this$0.getLoading().setValue(false);
        if (StringsKt.contains$default((CharSequence) status.toString(), (CharSequence) "\"FR\"", false, 2, (Object) null)) {
            this$0.getDashboardDetails();
        } else if (StringsKt.contains$default((CharSequence) status.toString(), (CharSequence) "DWC", false, 2, (Object) null)) {
            this$0.getPendingBleCommand();
        }
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
    public static final String m635productType$lambda9(DashboardDetailsResponse dashboardDetailsResponse) {
        ProductStats productStats;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return ((dashboardDetails == null || (productStats = dashboardDetails.getProductStats()) == null) ? null : productStats.getProductType()) != null ? dashboardDetailsResponse.getDashboardDetails().getProductStats().getProductType() : "";
    }

    public final LiveData<Pair<Integer, Integer>> getWaterGenerationStatusImage() {
        return this.waterGenerationStatusImage;
    }

    public final void setWaterGenerationStatusImage(LiveData<Pair<Integer, Integer>> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.waterGenerationStatusImage = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: waterGenerationStatusImage$lambda-10  reason: not valid java name */
    public static final Pair m643waterGenerationStatusImage$lambda10(HomeAirToWaterModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        DispenserRoSetting dispenserRoSetting;
        DispenserRoSetting dispenserRoSetting2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.menuWaterGenerationStatus = "";
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        boolean z = true;
        z = (((dashboardDetails == null || (dispenserRoSetting2 = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting2.getFaultCode()) == null || !StringsKt.equals(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getFaultCode(), "0200", true)) ? false : false;
        DashboardDetails dashboardDetails2 = dashboardDetailsResponse.getDashboardDetails();
        if (((dashboardDetails2 == null || (dispenserRoSetting = dashboardDetails2.getDispenserRoSetting()) == null) ? null : dispenserRoSetting.getWaterGenerationStatus()) != null) {
            if (StringsKt.equals$default(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getWaterGenerationStatus(), "1", false, 2, null)) {
                if (!z) {
                    this$0.menuWaterGenerationStatus = "ON";
                    this$0.waterGenerationStatus.setValue("Water Generation ON");
                    return new Pair(Integer.valueOf((int) R.drawable.ic_water_gen_on), Integer.valueOf((int) R.drawable.ic_generation_status_on));
                }
                this$0.menuWaterGenerationStatus = "ON";
                this$0.waterGenerationStatus.setValue("Unfavourable condition");
                return new Pair(Integer.valueOf((int) R.drawable.ic_water_gen_on), Integer.valueOf((int) R.drawable.ic_generation_status));
            } else if (!StringsKt.equals$default(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getWaterGenerationStatus(), AppEventsConstants.EVENT_PARAM_VALUE_NO, false, 2, null)) {
                this$0.menuWaterGenerationStatus = "OFF";
                this$0.waterGenerationStatus.setValue("Water Generation OFF");
                return new Pair(Integer.valueOf((int) R.drawable.ic_water_gen_off), Integer.valueOf((int) R.drawable.ic_generation_status_off));
            } else if (!z) {
                this$0.menuWaterGenerationStatus = "OFF";
                this$0.waterGenerationStatus.setValue("Water Generation OFF");
                return new Pair(Integer.valueOf((int) R.drawable.ic_water_gen_off), Integer.valueOf((int) R.drawable.ic_generation_status_off));
            } else {
                this$0.menuWaterGenerationStatus = "OFF";
                this$0.waterGenerationStatus.setValue("Unfavourable condition");
                return new Pair(Integer.valueOf((int) R.drawable.ic_water_gen_off), Integer.valueOf((int) R.drawable.ic_generation_status));
            }
        }
        this$0.menuWaterGenerationStatus = "OFF";
        this$0.waterGenerationStatus.setValue("Water Generation OFF");
        return new Pair(Integer.valueOf((int) R.drawable.ic_water_gen_off), Integer.valueOf((int) R.drawable.ic_generation_status_off));
    }

    public final LiveData<Integer> getColTankImage() {
        return this.colTankImage;
    }

    public final void setColTankImage(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.colTankImage = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: colTankImage$lambda-11  reason: not valid java name */
    public static final Integer m609colTankImage$lambda11(HomeAirToWaterModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        DispenserRoSetting dispenserRoSetting;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.coldTankStatus.setValue("Tank Not Full");
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        String coldTankStatus = (dashboardDetails == null || (dispenserRoSetting = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting.getColdTankStatus();
        int i = R.drawable.ic_cold_tank_empty;
        if (coldTankStatus != null) {
            if (StringsKt.equals$default(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getColdTankStatus(), "1", false, 2, null)) {
                this$0.coldTankStatus.setValue("Tank Full");
                i = R.drawable.ic_cold_tank_full;
            } else {
                this$0.coldTankStatus.setValue("Tank Not Full");
            }
        } else {
            this$0.coldTankStatus.setValue("Tank Not Full");
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Integer> getHeaterStatusImage() {
        return this.heaterStatusImage;
    }

    public final void setHeaterStatusImage(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.heaterStatusImage = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: heaterStatusImage$lambda-12  reason: not valid java name */
    public static final Integer m617heaterStatusImage$lambda12(HomeAirToWaterModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        DispenserRoSetting dispenserRoSetting;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.menuHeaterStatus = "OFF";
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        String heaterStatus = (dashboardDetails == null || (dispenserRoSetting = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting.getHeaterStatus();
        int i = R.drawable.ic_hot_water_off;
        if (heaterStatus != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getHeaterStatus().equals("1")) {
            this$0.menuHeaterStatus = "ON";
            i = R.drawable.ic_hot_water_on;
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Integer> getCondenserFanSpeedImage() {
        return this.condenserFanSpeedImage;
    }

    public final void setCondenserFanSpeedImage(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.condenserFanSpeedImage = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: condenserFanSpeedImage$lambda-13  reason: not valid java name */
    public static final Integer m610condenserFanSpeedImage$lambda13(HomeAirToWaterModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        DispenserRoSetting dispenserRoSetting;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        String condenserFanSpeed = (dashboardDetails == null || (dispenserRoSetting = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting.getCondenserFanSpeed();
        int i = R.drawable.ic_quiet_mode_off;
        if (condenserFanSpeed != null) {
            String condenserFanSpeed2 = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getCondenserFanSpeed();
            Intrinsics.checkNotNull(condenserFanSpeed2);
            this$0.condenserFanSpeed = condenserFanSpeed2;
            if (StringsKt.equals$default(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getCondenserFanSpeed(), ExifInterface.GPS_MEASUREMENT_3D, false, 2, null)) {
                i = R.drawable.ic_quiet_mode;
            }
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Integer> getQuietModeStatusImage() {
        return this.quietModeStatusImage;
    }

    public final void setQuietModeStatusImage(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.quietModeStatusImage = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: quietModeStatusImage$lambda-14  reason: not valid java name */
    public static final Integer m637quietModeStatusImage$lambda14(HomeAirToWaterModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        DispenserRoSetting dispenserRoSetting;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.menuQuietModeStatus = "OFF";
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        String quietModeStatus = (dashboardDetails == null || (dispenserRoSetting = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting.getQuietModeStatus();
        int i = R.drawable.ic_quiet_mode_off;
        if (quietModeStatus != null && StringsKt.equals$default(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getQuietModeStatus(), "1", false, 2, null)) {
            this$0.menuQuietModeStatus = "ON";
            i = R.drawable.ic_quiet_mode;
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Integer> getWifiImage() {
        return this.wifiImage;
    }

    public final void setWifiImage(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.wifiImage = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: wifiImage$lambda-15  reason: not valid java name */
    public static final Integer m645wifiImage$lambda15(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: bleImage$lambda-16  reason: not valid java name */
    public static final Integer m606bleImage$lambda16(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: wifiImageOff$lambda-17  reason: not valid java name */
    public static final Integer m646wifiImageOff$lambda17(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: bleImageOff$lambda-18  reason: not valid java name */
    public static final Integer m607bleImageOff$lambda18(DashboardDetailsResponse dashboardDetailsResponse) {
        return Integer.valueOf((int) R.drawable.bluetooth_off);
    }

    public final LiveData<Boolean> getLoadingStatus() {
        return this.loadingStatus;
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
        if (deviceList3 != null && (serialNo = deviceList3.getSerialNo()) != null) {
            str = serialNo;
        }
        this.serialNumber = str;
    }

    public final void getDashboardDetails() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getSubscriptionRepository().getDashboardDetails(this.serialNumber), new Observer() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda32
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeAirToWaterModel.m612getDashboardDetails$lambda20(HomeAirToWaterModel.this, (DashboardDetailsResponse) obj);
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
    /* renamed from: getDashboardDetails$lambda-20  reason: not valid java name */
    public static final void m612getDashboardDetails$lambda20(final HomeAirToWaterModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(dashboardDetailsResponse, new Function1<DashboardDetailsResponse, Unit>() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$getDashboardDetails$1$1
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
            public final void invoke2(DashboardDetailsResponse successfulResponse) {
                MutableLiveData mutableLiveData;
                DispenserRoSetting dispenserRoSetting;
                DispenserRoSetting dispenserRoSetting2;
                DispenserRoSetting dispenserRoSetting3;
                DispenserRoSetting dispenserRoSetting4;
                DispenserRoSetting dispenserRoSetting5;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                mutableLiveData = HomeAirToWaterModel.this.dashboardData;
                mutableLiveData.setValue(successfulResponse);
                MutableLiveData<String> faultDescription = HomeAirToWaterModel.this.getFaultDescription();
                DashboardDetails dashboardDetails = successfulResponse.getDashboardDetails();
                String str = null;
                faultDescription.setValue(String.valueOf((dashboardDetails == null || (dispenserRoSetting5 = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting5.getFault()));
                HomeAirToWaterModel homeAirToWaterModel = HomeAirToWaterModel.this;
                DashboardDetails dashboardDetails2 = successfulResponse.getDashboardDetails();
                homeAirToWaterModel.setDispenserStatus(String.valueOf((dashboardDetails2 == null || (dispenserRoSetting4 = dashboardDetails2.getDispenserRoSetting()) == null) ? null : dispenserRoSetting4.getDespensing()));
                HomeAirToWaterModel homeAirToWaterModel2 = HomeAirToWaterModel.this;
                DashboardDetails dashboardDetails3 = successfulResponse.getDashboardDetails();
                homeAirToWaterModel2.setColdWaterDispenserStatus(String.valueOf((dashboardDetails3 == null || (dispenserRoSetting3 = dashboardDetails3.getDispenserRoSetting()) == null) ? null : dispenserRoSetting3.getColdWaterDespensing()));
                HomeAirToWaterModel homeAirToWaterModel3 = HomeAirToWaterModel.this;
                DashboardDetails dashboardDetails4 = successfulResponse.getDashboardDetails();
                homeAirToWaterModel3.setHotWaterTemprature(String.valueOf((dashboardDetails4 == null || (dispenserRoSetting2 = dashboardDetails4.getDispenserRoSetting()) == null) ? null : dispenserRoSetting2.getHotWater()));
                HomeAirToWaterModel homeAirToWaterModel4 = HomeAirToWaterModel.this;
                DashboardDetails dashboardDetails5 = successfulResponse.getDashboardDetails();
                if (dashboardDetails5 != null && (dispenserRoSetting = dashboardDetails5.getDispenserRoSetting()) != null) {
                    str = dispenserRoSetting.getWarmWater();
                }
                homeAirToWaterModel4.setWarmWaterTemprature(String.valueOf(str));
            }
        }, new Function1<DashboardDetailsResponse, Unit>() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$getDashboardDetails$1$2
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
                toastMessageLiveData = HomeAirToWaterModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Oops! We faced an issue while fetching your dashboard details at this time."));
            }
        });
    }

    public final LiveData<Integer> getLiveDispenserStatus() {
        return this.liveDispenserStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveDispenserStatus$lambda-21  reason: not valid java name */
    public static final Integer m624liveDispenserStatus$lambda21(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null) != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing() != null && !Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing(), "")) {
            Integer.parseInt(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing());
        }
        return 0;
    }

    public final LiveData<Integer> getLiveColdTankImage() {
        return this.liveColdTankImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveColdTankImage$lambda-22  reason: not valid java name */
    public static final Integer m619liveColdTankImage$lambda22(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        DispenserRoSetting dispenserRoSetting = dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null;
        int i = R.drawable.tank_empty;
        if (dispenserRoSetting != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getColdTankStatus() != null && !Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getColdTankStatus(), "")) {
            String coldTankStatus = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getColdTankStatus();
            Intrinsics.checkNotNull(coldTankStatus);
            if (Integer.parseInt(coldTankStatus) == 1) {
                i = R.drawable.tank_full;
            }
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Integer> getLiveCollectionTankImage() {
        return this.liveCollectionTankImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveCollectionTankImage$lambda-23  reason: not valid java name */
    public static final Integer m621liveCollectionTankImage$lambda23(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        DispenserRoSetting dispenserRoSetting = dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null;
        int i = R.drawable.tank_empty;
        if (dispenserRoSetting != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getCollectionFloatStatus() != null && !Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getCollectionFloatStatus(), "")) {
            String collectionFloatStatus = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getCollectionFloatStatus();
            Intrinsics.checkNotNull(collectionFloatStatus);
            int parseInt = Integer.parseInt(collectionFloatStatus);
            if (parseInt == 1) {
                i = R.drawable.tank_full;
            } else if (parseInt == 2) {
                i = R.drawable.tank_charging;
            }
        }
        return Integer.valueOf(i);
    }

    public final LiveData<String> getLiveWaterGenerationStatus() {
        return this.liveWaterGenerationStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveWaterGenerationStatus$lambda-24  reason: not valid java name */
    public static final String m632liveWaterGenerationStatus$lambda24(DashboardDetailsResponse dashboardDetailsResponse) {
        DispenserRoSetting dispenserRoSetting;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if (((dashboardDetails == null || (dispenserRoSetting = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting.getWaterGenerationStatus()) == null || Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getWaterGenerationStatus(), "")) {
            return "";
        }
        String waterGenerationStatus = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getWaterGenerationStatus();
        Intrinsics.checkNotNull(waterGenerationStatus);
        return Integer.parseInt(waterGenerationStatus) == 1 ? "ON" : "OFF";
    }

    public final LiveData<String> getLiveFeelsLikeZone() {
        return this.liveFeelsLikeZone;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveFeelsLikeZone$lambda-25  reason: not valid java name */
    public static final String m627liveFeelsLikeZone$lambda25(DashboardDetailsResponse dashboardDetailsResponse) {
        DispenserRoSetting dispenserRoSetting;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if (((dashboardDetails == null || (dispenserRoSetting = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting.getFeelsLikeZone()) == null || Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getFeelsLikeZone(), "")) {
            return "";
        }
        String feelsLikeZone = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getFeelsLikeZone();
        Intrinsics.checkNotNull(feelsLikeZone);
        int parseInt = Integer.parseInt(feelsLikeZone);
        return parseInt != 1 ? parseInt != 2 ? parseInt != 3 ? "--" : "HUMID" : "HOT" : "DRY";
    }

    public final LiveData<String> getLiveEvaporatorFanSpeed() {
        return this.liveEvaporatorFanSpeed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveEvaporatorFanSpeed$lambda-26  reason: not valid java name */
    public static final String m626liveEvaporatorFanSpeed$lambda26(DashboardDetailsResponse dashboardDetailsResponse) {
        DispenserRoSetting dispenserRoSetting;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if (((dashboardDetails == null || (dispenserRoSetting = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting.getEvaporaterFanSpeed()) == null || Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getEvaporaterFanSpeed(), "")) {
            return "";
        }
        String evaporaterFanSpeed = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getEvaporaterFanSpeed();
        Intrinsics.checkNotNull(evaporaterFanSpeed);
        int parseInt = Integer.parseInt(evaporaterFanSpeed);
        return parseInt != 1 ? parseInt != 2 ? parseInt != 3 ? "--" : "High" : "Medium" : "Low";
    }

    public final LiveData<String> getLiveCondenserFanSpeed() {
        return this.liveCondenserFanSpeed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveCondenserFanSpeed$lambda-27  reason: not valid java name */
    public static final String m623liveCondenserFanSpeed$lambda27(DashboardDetailsResponse dashboardDetailsResponse) {
        DispenserRoSetting dispenserRoSetting;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if (((dashboardDetails == null || (dispenserRoSetting = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting.getCondenserFanSpeed()) == null || Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getCondenserFanSpeed(), "")) {
            return "";
        }
        String condenserFanSpeed = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getCondenserFanSpeed();
        Intrinsics.checkNotNull(condenserFanSpeed);
        int parseInt = Integer.parseInt(condenserFanSpeed);
        return parseInt != 1 ? parseInt != 2 ? parseInt != 3 ? "--" : "High" : "Medium" : "Low";
    }

    public final LiveData<String> getLiveHeaterStatus() {
        return this.liveHeaterStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveHeaterStatus$lambda-28  reason: not valid java name */
    public static final String m628liveHeaterStatus$lambda28(DashboardDetailsResponse dashboardDetailsResponse) {
        DispenserRoSetting dispenserRoSetting;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if (((dashboardDetails == null || (dispenserRoSetting = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting.getHeaterStatus()) == null || Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getHeaterStatus(), "")) {
            return "";
        }
        return Integer.parseInt(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getHeaterStatus()) == 1 ? "ON" : "OFF";
    }

    public final LiveData<String> getLiveQuietModeStatus() {
        return this.liveQuietModeStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveQuietModeStatus$lambda-29  reason: not valid java name */
    public static final String m630liveQuietModeStatus$lambda29(DashboardDetailsResponse dashboardDetailsResponse) {
        DispenserRoSetting dispenserRoSetting;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if (((dashboardDetails == null || (dispenserRoSetting = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting.getQuietModeStatus()) == null || Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getQuietModeStatus(), "")) {
            return "";
        }
        String quietModeStatus = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getQuietModeStatus();
        Intrinsics.checkNotNull(quietModeStatus);
        return Integer.parseInt(quietModeStatus) == 1 ? "ON" : "OFF";
    }

    public final LiveData<String> getLiveCompressorButtonStatus() {
        return this.liveCompressorButtonStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveCompressorButtonStatus$lambda-30  reason: not valid java name */
    public static final String m622liveCompressorButtonStatus$lambda30(DashboardDetailsResponse dashboardDetailsResponse) {
        DispenserRoSetting dispenserRoSetting;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if (((dashboardDetails == null || (dispenserRoSetting = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting.getCompressorButtonStatus()) == null || Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getCompressorButtonStatus(), "")) {
            return "";
        }
        String compressorButtonStatus = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getCompressorButtonStatus();
        Intrinsics.checkNotNull(compressorButtonStatus);
        return Integer.parseInt(compressorButtonStatus) == 1 ? "ON" : "OFF";
    }

    public final LiveData<String> getLiveTemperature() {
        return this.liveTemperature;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveTemperature$lambda-31  reason: not valid java name */
    public static final String m631liveTemperature$lambda31(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return ((dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null) == null || dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTemperature() == null || Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTemperature(), "")) ? "_ _" : dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTemperature();
    }

    public final LiveData<String> getLiveHumidity() {
        return this.liveHumidity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveHumidity$lambda-32  reason: not valid java name */
    public static final String m629liveHumidity$lambda32(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return ((dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null) == null || dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getHumidity() == null || Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getHumidity(), "")) ? "_ _" : dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getHumidity();
    }

    public final LiveData<Integer> getLiveColdWaterDispenserStatusImage() {
        return this.liveColdWaterDispenserStatusImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveColdWaterDispenserStatusImage$lambda-33  reason: not valid java name */
    public static final Integer m620liveColdWaterDispenserStatusImage$lambda33(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        DispenserRoSetting dispenserRoSetting = dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null;
        int i = R.drawable.cont_dispense;
        if (dispenserRoSetting != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getColdWaterDespensing() != null && !Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getColdWaterDespensing(), "") && Integer.parseInt(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getColdWaterDespensing()) == 1) {
            i = R.drawable.cont_dispense_sel;
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Integer> getLiveDispenserStatusImage() {
        return this.liveDispenserStatusImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveDispenserStatusImage$lambda-34  reason: not valid java name */
    public static final Integer m625liveDispenserStatusImage$lambda34(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: waterRemaining$lambda-35  reason: not valid java name */
    public static final Pair m644waterRemaining$lambda35(HomeAirToWaterModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        String str;
        String padStart;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        String str2 = "";
        if ((dashboardDetails != null ? dashboardDetails.getUsage() : null) != null) {
            if (dashboardDetailsResponse.getDashboardDetails().getUsage().getRemainingLitres() != null) {
                str = StringsKt.padStart(dashboardDetailsResponse.getDashboardDetails().getUsage().getRemainingLitres(), 6, '0');
            } else {
                String remainingLitres = dashboardDetailsResponse.getDashboardDetails().getUsage().getRemainingLitres();
                if (remainingLitres != null && (padStart = StringsKt.padStart(remainingLitres, 6, '0')) != null) {
                    str2 = padStart;
                }
                str = str2;
            }
            DispenserRoSetting dispenserRoSetting = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting();
            boolean z = false;
            if ((dispenserRoSetting != null ? dispenserRoSetting.getTank() : null) != null) {
                if (dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTank().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    this$0.waterPurificationStatus.setValue(Boolean.valueOf(StringsKt.equals$default(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getCollectionFloatStatus(), ExifInterface.GPS_MEASUREMENT_2D, false, 2, null)));
                } else {
                    this$0.waterPurificationStatus.setValue(false);
                    z = true;
                }
            }
            int i = R.drawable.emptywaterlarge;
            if (z && z) {
                i = R.drawable.fullwaterlarge;
            }
            return new Pair(str, Integer.valueOf(i));
        }
        return new Pair("", null);
    }

    public final LiveData<Integer> getUvImage() {
        return this.uvImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uvImage$lambda-36  reason: not valid java name */
    public static final Integer m642uvImage$lambda36(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        Boolean bool = null;
        DispenserRoSetting dispenserRoSetting = dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null;
        int i = R.drawable.uv_off;
        if (dispenserRoSetting != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTankUV() != null) {
            String tankUV = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTankUV();
            if (tankUV != null) {
                bool = Boolean.valueOf(tankUV.length() > 0);
            }
            Intrinsics.checkNotNull(bool);
            if (bool.booleanValue()) {
                String tankUV2 = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTankUV();
                int parseInt = tankUV2 != null ? Integer.parseInt(tankUV2) : 0;
                if (parseInt != 0 && parseInt == 1) {
                    i = R.drawable.uv_on;
                }
            }
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Integer> getTdsImage() {
        return this.tdsImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: tdsImage$lambda-37  reason: not valid java name */
    public static final Integer m640tdsImage$lambda37(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null) != null) {
            String tds = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTds();
            int parseInt = tds != null ? Integer.parseInt(tds) : 0;
            if (parseInt <= 0 && parseInt <= 1 && parseInt <= 2 && parseInt > 3) {
            }
        }
        return Integer.valueOf((int) R.drawable.tds_band_1);
    }

    public final LiveData<String> getPlanDetails() {
        return this.planDetails;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: planDetails$lambda-38  reason: not valid java name */
    public static final String m634planDetails$lambda38(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getSubscriptionDetails() : null) != null) {
            SubscriptionDetails subscriptionDetails = dashboardDetailsResponse.getDashboardDetails().getSubscriptionDetails();
            ProductStats productStats = dashboardDetailsResponse.getDashboardDetails().getProductStats();
            if ((productStats != null ? productStats.getProductType() : null) != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%s\n%s\n%s\n%s", Arrays.copyOf(new Object[]{subscriptionDetails.getPlanName(), "Valid Till: " + subscriptionDetails.getValidTillDate(), "Rate: " + subscriptionDetails.getPlanRate(), subscriptionDetails.getNormalizedBalanceString()}, 4));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                return format;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%s\n%s\n%s\n%s", Arrays.copyOf(new Object[]{subscriptionDetails.getPlanName(), "Valid Till: " + subscriptionDetails.getValidTillDate(), "Rate: " + subscriptionDetails.getPlanRate(), subscriptionDetails.getNormalizedBalanceString()}, 4));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        return "";
    }

    public final LiveData<Integer> getFilterLifeImage() {
        return this.filterLifeImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: filterLifeImage$lambda-39  reason: not valid java name */
    public static final Integer m611filterLifeImage$lambda39(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: hardwareUpdate$lambda-40  reason: not valid java name */
    public static final Boolean m615hardwareUpdate$lambda40(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getHardwareVersion() : false);
    }

    public final LiveData<Boolean> getSoftwareUpdate() {
        return this.softwareUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: softwareUpdate$lambda-41  reason: not valid java name */
    public static final Boolean m638softwareUpdate$lambda41(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getSoftwareVersion() : false);
    }

    public final LiveData<String> getHardwareVersion() {
        return this.hardwareVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hardwareVersion$lambda-42  reason: not valid java name */
    public static final String m616hardwareVersion$lambda42(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getCurrentHardwareVersion() : "";
    }

    public final LiveData<String> getSoftwareVersion() {
        return this.softwareVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: softwareVersion$lambda-43  reason: not valid java name */
    public static final String m639softwareVersion$lambda43(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getCurrentSoftwareVersion() : "";
    }

    public final LiveData<Triple<List<String>, List<IBarDataSet>, String>> getUsageStats() {
        return this.usageStats;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: usageStats$lambda-44  reason: not valid java name */
    public static final Triple m641usageStats$lambda44(DashboardDetailsResponse dashboardDetailsResponse) {
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
            return Transformations.map(getBLERepository().sendBoltConfigtRequest(this.serialNumber, statusPkt, false), new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda37
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean m614getSubmissionBLEStatus$lambda45;
                    m614getSubmissionBLEStatus$lambda45 = HomeAirToWaterModel.m614getSubmissionBLEStatus$lambda45((BaseDataHolder) obj);
                    return m614getSubmissionBLEStatus$lambda45;
                }
            });
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubmissionBLEStatus$lambda-45  reason: not valid java name */
    public static final Boolean m614getSubmissionBLEStatus$lambda45(BaseDataHolder baseDataHolder) {
        return Boolean.valueOf(baseDataHolder.getStatus());
    }

    public final void getPendingBleCommand() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            this.boltCommandsResponse.addSource(getBLECommands().getBoltBleCommands(this.serialNumber), new Observer() { // from class: com.livpure.safedrink.dispenser.model.HomeAirToWaterModel$$ExternalSyntheticLambda30
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeAirToWaterModel.m613getPendingBleCommand$lambda46(HomeAirToWaterModel.this, (BaseDataHolder) obj);
                }
            });
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPendingBleCommand$lambda-46  reason: not valid java name */
    public static final void m613getPendingBleCommand$lambda46(HomeAirToWaterModel this$0, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (baseDataHolder.getData() != null) {
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
}
