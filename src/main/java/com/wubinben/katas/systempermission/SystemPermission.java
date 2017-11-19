package com.wubinben.katas.systempermission;

public class SystemPermission {
    private String state;
    private SystemAdmin admin;

    static final String REQUESTED = "REQUESTED";
    static final String CLAIMED = "CLAIMED";
    static final String GRANTED = "GRANTED";
    static final String DENIED = "DENIED";


    public SystemPermission() {
        this.state = REQUESTED;
    }

    public String getState() {
        return this.state;
    }

    public void claimedBy(SystemAdmin systemAdmin) {
        if (!state.equals(REQUESTED)) return;

        willBeHandledBy(systemAdmin);
        state = CLAIMED;
    }

    private void willBeHandledBy(SystemAdmin systemAdmin) {
        this.admin = systemAdmin;
    }

    public void grantedBy(SystemAdmin systemAdmin) {
        if (!state.equals(CLAIMED))
            return;
        if (!this.admin.equals(admin))
            return;

        state = GRANTED;
        notifyUserOfPermissionRequestResult();
    }

    public void deniedBy(SystemAdmin systemAdmin) {
        if (!state.equals(CLAIMED))
            return;
        if (!this.admin.equals(admin))
            return;
        state = DENIED;
        notifyUserOfPermissionRequestResult();
    }

    private void notifyUserOfPermissionRequestResult() {

    }
}
