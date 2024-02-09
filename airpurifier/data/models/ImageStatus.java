package com.livpure.safedrink.airpurifier.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
/* compiled from: ImageStatus.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/livpure/safedrink/airpurifier/data/models/ImageStatus;", "", "PowerOnImage", "", "ModeImage", "FanImage", "IonsImage", "SleepImage", "LockImage", "TimerImage", "(IIIIIII)V", "getFanImage", "()I", "getIonsImage", "getLockImage", "getModeImage", "getPowerOnImage", "getSleepImage", "getTimerImage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImageStatus {
    private final int FanImage;
    private final int IonsImage;
    private final int LockImage;
    private final int ModeImage;
    private final int PowerOnImage;
    private final int SleepImage;
    private final int TimerImage;

    public static /* synthetic */ ImageStatus copy$default(ImageStatus imageStatus, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i = imageStatus.PowerOnImage;
        }
        if ((i8 & 2) != 0) {
            i2 = imageStatus.ModeImage;
        }
        int i9 = i2;
        if ((i8 & 4) != 0) {
            i3 = imageStatus.FanImage;
        }
        int i10 = i3;
        if ((i8 & 8) != 0) {
            i4 = imageStatus.IonsImage;
        }
        int i11 = i4;
        if ((i8 & 16) != 0) {
            i5 = imageStatus.SleepImage;
        }
        int i12 = i5;
        if ((i8 & 32) != 0) {
            i6 = imageStatus.LockImage;
        }
        int i13 = i6;
        if ((i8 & 64) != 0) {
            i7 = imageStatus.TimerImage;
        }
        return imageStatus.copy(i, i9, i10, i11, i12, i13, i7);
    }

    public final int component1() {
        return this.PowerOnImage;
    }

    public final int component2() {
        return this.ModeImage;
    }

    public final int component3() {
        return this.FanImage;
    }

    public final int component4() {
        return this.IonsImage;
    }

    public final int component5() {
        return this.SleepImage;
    }

    public final int component6() {
        return this.LockImage;
    }

    public final int component7() {
        return this.TimerImage;
    }

    public final ImageStatus copy(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new ImageStatus(i, i2, i3, i4, i5, i6, i7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageStatus) {
            ImageStatus imageStatus = (ImageStatus) obj;
            return this.PowerOnImage == imageStatus.PowerOnImage && this.ModeImage == imageStatus.ModeImage && this.FanImage == imageStatus.FanImage && this.IonsImage == imageStatus.IonsImage && this.SleepImage == imageStatus.SleepImage && this.LockImage == imageStatus.LockImage && this.TimerImage == imageStatus.TimerImage;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.PowerOnImage * 31) + this.ModeImage) * 31) + this.FanImage) * 31) + this.IonsImage) * 31) + this.SleepImage) * 31) + this.LockImage) * 31) + this.TimerImage;
    }

    public String toString() {
        return "ImageStatus(PowerOnImage=" + this.PowerOnImage + ", ModeImage=" + this.ModeImage + ", FanImage=" + this.FanImage + ", IonsImage=" + this.IonsImage + ", SleepImage=" + this.SleepImage + ", LockImage=" + this.LockImage + ", TimerImage=" + this.TimerImage + ')';
    }

    public ImageStatus(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.PowerOnImage = i;
        this.ModeImage = i2;
        this.FanImage = i3;
        this.IonsImage = i4;
        this.SleepImage = i5;
        this.LockImage = i6;
        this.TimerImage = i7;
    }

    public final int getPowerOnImage() {
        return this.PowerOnImage;
    }

    public final int getModeImage() {
        return this.ModeImage;
    }

    public final int getFanImage() {
        return this.FanImage;
    }

    public final int getIonsImage() {
        return this.IonsImage;
    }

    public final int getSleepImage() {
        return this.SleepImage;
    }

    public final int getLockImage() {
        return this.LockImage;
    }

    public final int getTimerImage() {
        return this.TimerImage;
    }
}
