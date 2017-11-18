package com.wubinben.katas.systempermission;

public class SystemPermission {
    private String state;

    public static final String REQUESTED = "REQUESTED";

    public SystemPermission() {
        this.state = REQUESTED;
    }

    public String getState() {
        return this.state;
    }
}
