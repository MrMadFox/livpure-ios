package com.livpure.safedrink.dispenser.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DispenserPublishCommand.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/livpure/safedrink/dispenser/data/models/DispenserPublishCommand;", "", "cmd", "", "warmWater", "hotWater", "tds", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCmd", "()Ljava/lang/String;", "setCmd", "(Ljava/lang/String;)V", "getHotWater", "setHotWater", "getTds", "setTds", "getWarmWater", "setWarmWater", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DispenserPublishCommand {
    private String cmd;
    private String hotWater;
    private String tds;
    private String warmWater;

    public static /* synthetic */ DispenserPublishCommand copy$default(DispenserPublishCommand dispenserPublishCommand, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dispenserPublishCommand.cmd;
        }
        if ((i & 2) != 0) {
            str2 = dispenserPublishCommand.warmWater;
        }
        if ((i & 4) != 0) {
            str3 = dispenserPublishCommand.hotWater;
        }
        if ((i & 8) != 0) {
            str4 = dispenserPublishCommand.tds;
        }
        return dispenserPublishCommand.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.cmd;
    }

    public final String component2() {
        return this.warmWater;
    }

    public final String component3() {
        return this.hotWater;
    }

    public final String component4() {
        return this.tds;
    }

    public final DispenserPublishCommand copy(String cmd, String warmWater, String hotWater, String tds) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(warmWater, "warmWater");
        Intrinsics.checkNotNullParameter(hotWater, "hotWater");
        Intrinsics.checkNotNullParameter(tds, "tds");
        return new DispenserPublishCommand(cmd, warmWater, hotWater, tds);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DispenserPublishCommand) {
            DispenserPublishCommand dispenserPublishCommand = (DispenserPublishCommand) obj;
            return Intrinsics.areEqual(this.cmd, dispenserPublishCommand.cmd) && Intrinsics.areEqual(this.warmWater, dispenserPublishCommand.warmWater) && Intrinsics.areEqual(this.hotWater, dispenserPublishCommand.hotWater) && Intrinsics.areEqual(this.tds, dispenserPublishCommand.tds);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.cmd.hashCode() * 31) + this.warmWater.hashCode()) * 31) + this.hotWater.hashCode()) * 31) + this.tds.hashCode();
    }

    public String toString() {
        return "DispenserPublishCommand(cmd=" + this.cmd + ", warmWater=" + this.warmWater + ", hotWater=" + this.hotWater + ", tds=" + this.tds + ')';
    }

    public DispenserPublishCommand(String cmd, String warmWater, String hotWater, String tds) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(warmWater, "warmWater");
        Intrinsics.checkNotNullParameter(hotWater, "hotWater");
        Intrinsics.checkNotNullParameter(tds, "tds");
        this.cmd = cmd;
        this.warmWater = warmWater;
        this.hotWater = hotWater;
        this.tds = tds;
    }

    public final String getCmd() {
        return this.cmd;
    }

    public final void setCmd(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cmd = str;
    }

    public final String getWarmWater() {
        return this.warmWater;
    }

    public final void setWarmWater(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.warmWater = str;
    }

    public final String getHotWater() {
        return this.hotWater;
    }

    public final void setHotWater(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hotWater = str;
    }

    public final String getTds() {
        return this.tds;
    }

    public final void setTds(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tds = str;
    }
}
