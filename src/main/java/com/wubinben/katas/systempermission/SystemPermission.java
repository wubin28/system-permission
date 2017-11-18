package com.wubinben.katas.systempermission;

public class SystemPermission {
    private String state;

    static final String REQUESTED = "REQUESTED";
    static final String CLAIMED = "CLAIMED";

    public SystemPermission() {
        this.state = REQUESTED;
    }

    public String getState() {
        return this.state;
    }

    public void claimedBy(SystemAdmin systemAdmin) {
        if (!state.equals(REQUESTED)) return;
        willBeHandledBy(systemAdmin);
        if (state.equals(REQUESTED)) state = CLAIMED;
    }

    private void willBeHandledBy(SystemAdmin systemAdmin) {

    }
}
