package com.livpure.safedrink.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moengage.core.internal.logger.LogManagerKt;
/* loaded from: classes3.dex */
public class PostDeviceInfo {
    @SerializedName(LogManagerKt.LOG_LEVEL_INFO)
    @Expose
    private String info;
    @SerializedName("status")
    @Expose
    private Boolean status;

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
