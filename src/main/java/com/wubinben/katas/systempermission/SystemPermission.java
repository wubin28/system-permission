package com.wubinben.katas.systempermission;

public class SystemPermission {
    private final User user;
    private String state;
    private SystemAdmin admin;

    static final String REQUESTED = "REQUESTED";
    static final String CLAIMED = "CLAIMED";
    static final String GRANTED = "GRANTED";
    static final String DENIED = "DENIED";
    static final String UNIX_PERMISSION_REQUESTED = "UNIX_PERMISSION_REQUESTED";
    static final String UNIX_PERMISSION_CLAIMED = "UNIX_PERMISSION_CLAIMED";


    public SystemPermission(User user) {
        this.user = user;
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
            throw new IllegalStateException("The state should be claimed when granted by admin");
        if (!this.admin.equals(systemAdmin))
            throw new IllegalArgumentException("The admin to grant should be the same one to claim.");

        state = GRANTED;
        notifyUserOfPermissionRequestResult();
    }

    public void deniedBy(SystemAdmin systemAdmin) {
        if (!state.equals(CLAIMED))
            throw new IllegalStateException("The state should be claimed when denied by admin");
        if (!this.admin.equals(systemAdmin))
            throw new IllegalArgumentException("The admin to deny should be the same one to claim.");
        state = DENIED;
        notifyUserOfPermissionRequestResult();
    }

    private void notifyUserOfPermissionRequestResult() {

    }

    public void unixRequestedBy(User user) {
        if (!state.equals(CLAIMED))
            throw new IllegalStateException("The state should be claimed when unix requested by user");
        if (!this.user.equals(user))
            throw new IllegalArgumentException("The user to request unix permission should be the same one to request system permission");

        state = UNIX_PERMISSION_REQUESTED;
    }

    public void unixClaimedBy(UnixAdmin unixAdmin) {
        if (!state.equals(UNIX_PERMISSION_REQUESTED))
            throw new IllegalStateException("The state should be unix permission requested when unix claimed by unix admin");

        willBeHandledBy(unixAdmin);
        state = UNIX_PERMISSION_CLAIMED;
    }
}
