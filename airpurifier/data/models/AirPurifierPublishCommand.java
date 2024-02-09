package com.livpure.safedrink.airpurifier.data.models;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AirPurifierPublishCommand.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierPublishCommand;", "", "cmd", "", "buzzer", "countdown", TransferTable.COLUMN_SPEED, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuzzer", "()Ljava/lang/String;", "setBuzzer", "(Ljava/lang/String;)V", "getCmd", "setCmd", "getCountdown", "setCountdown", "getSpeed", "setSpeed", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AirPurifierPublishCommand {
    private String buzzer;
    private String cmd;
    private String countdown;
    private String speed;

    public static /* synthetic */ AirPurifierPublishCommand copy$default(AirPurifierPublishCommand airPurifierPublishCommand, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = airPurifierPublishCommand.cmd;
        }
        if ((i & 2) != 0) {
            str2 = airPurifierPublishCommand.buzzer;
        }
        if ((i & 4) != 0) {
            str3 = airPurifierPublishCommand.countdown;
        }
        if ((i & 8) != 0) {
            str4 = airPurifierPublishCommand.speed;
        }
        return airPurifierPublishCommand.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.cmd;
    }

    public final String component2() {
        return this.buzzer;
    }

    public final String component3() {
        return this.countdown;
    }

    public final String component4() {
        return this.speed;
    }

    public final AirPurifierPublishCommand copy(String cmd, String buzzer, String countdown, String speed) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(buzzer, "buzzer");
        Intrinsics.checkNotNullParameter(countdown, "countdown");
        Intrinsics.checkNotNullParameter(speed, "speed");
        return new AirPurifierPublishCommand(cmd, buzzer, countdown, speed);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AirPurifierPublishCommand) {
            AirPurifierPublishCommand airPurifierPublishCommand = (AirPurifierPublishCommand) obj;
            return Intrinsics.areEqual(this.cmd, airPurifierPublishCommand.cmd) && Intrinsics.areEqual(this.buzzer, airPurifierPublishCommand.buzzer) && Intrinsics.areEqual(this.countdown, airPurifierPublishCommand.countdown) && Intrinsics.areEqual(this.speed, airPurifierPublishCommand.speed);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.cmd.hashCode() * 31) + this.buzzer.hashCode()) * 31) + this.countdown.hashCode()) * 31) + this.speed.hashCode();
    }

    public String toString() {
        return "AirPurifierPublishCommand(cmd=" + this.cmd + ", buzzer=" + this.buzzer + ", countdown=" + this.countdown + ", speed=" + this.speed + ')';
    }

    public AirPurifierPublishCommand(String cmd, String buzzer, String countdown, String speed) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(buzzer, "buzzer");
        Intrinsics.checkNotNullParameter(countdown, "countdown");
        Intrinsics.checkNotNullParameter(speed, "speed");
        this.cmd = cmd;
        this.buzzer = buzzer;
        this.countdown = countdown;
        this.speed = speed;
    }

    public final String getCmd() {
        return this.cmd;
    }

    public final void setCmd(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cmd = str;
    }

    public final String getBuzzer() {
        return this.buzzer;
    }

    public final void setBuzzer(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.buzzer = str;
    }

    public final String getCountdown() {
        return this.countdown;
    }

    public final void setCountdown(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.countdown = str;
    }

    public final String getSpeed() {
        return this.speed;
    }

    public final void setSpeed(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.speed = str;
    }
}
