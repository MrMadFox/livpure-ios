package com.livpure.safedrink.airpurifier.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AirPurifierCommand.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierCommand;", "", "macId", "", "airCommand", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierPublishCommand;", "(Ljava/lang/String;Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierPublishCommand;)V", "getAirCommand", "()Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierPublishCommand;", "getMacId", "()Ljava/lang/String;", "component1", "component2", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AirPurifierCommand {
    private final AirPurifierPublishCommand airCommand;
    private final String macId;

    public static /* synthetic */ AirPurifierCommand copy$default(AirPurifierCommand airPurifierCommand, String str, AirPurifierPublishCommand airPurifierPublishCommand, int i, Object obj) {
        if ((i & 1) != 0) {
            str = airPurifierCommand.macId;
        }
        if ((i & 2) != 0) {
            airPurifierPublishCommand = airPurifierCommand.airCommand;
        }
        return airPurifierCommand.copy(str, airPurifierPublishCommand);
    }

    public final String component1() {
        return this.macId;
    }

    public final AirPurifierPublishCommand component2() {
        return this.airCommand;
    }

    public final AirPurifierCommand copy(String str, AirPurifierPublishCommand airCommand) {
        Intrinsics.checkNotNullParameter(airCommand, "airCommand");
        return new AirPurifierCommand(str, airCommand);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AirPurifierCommand) {
            AirPurifierCommand airPurifierCommand = (AirPurifierCommand) obj;
            return Intrinsics.areEqual(this.macId, airPurifierCommand.macId) && Intrinsics.areEqual(this.airCommand, airPurifierCommand.airCommand);
        }
        return false;
    }

    public int hashCode() {
        String str = this.macId;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.airCommand.hashCode();
    }

    public String toString() {
        return "AirPurifierCommand(macId=" + this.macId + ", airCommand=" + this.airCommand + ')';
    }

    public AirPurifierCommand(String str, AirPurifierPublishCommand airCommand) {
        Intrinsics.checkNotNullParameter(airCommand, "airCommand");
        this.macId = str;
        this.airCommand = airCommand;
    }

    public /* synthetic */ AirPurifierCommand(String str, AirPurifierPublishCommand airPurifierPublishCommand, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, airPurifierPublishCommand);
    }

    public final String getMacId() {
        return this.macId;
    }

    public final AirPurifierPublishCommand getAirCommand() {
        return this.airCommand;
    }
}
