package com.wubinben.katas.systempermission;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SystemPermissionTest {
    @Test
    public void should_be_requested_by_user_when_it_is_initialized() throws Exception {
        SystemPermission systemPermission = new SystemPermission(new User());

        assertEquals(SystemPermission.REQUESTED, systemPermission.getState());
    }

    @Test
    public void should_be_claimed_when_claimed_by_admin_after_requested() throws Exception {
        SystemPermission systemPermission = new SystemPermission(new User());

        systemPermission.claimedBy(new SystemAdmin());

        assertEquals(SystemPermission.CLAIMED, systemPermission.getState());
    }

    @Test
    public void should_be_granted_when_granted_by_admin_after_claimed() throws Exception {
        SystemPermission systemPermission = new SystemPermission(new User());
        final SystemAdmin systemAdmin = new SystemAdmin();
        systemPermission.claimedBy(systemAdmin);

        systemPermission.grantedBy(systemAdmin);

        assertEquals(SystemPermission.GRANTED, systemPermission.getState());
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_be_the_same_admin_to_grant_after_claimed() throws Exception {
        SystemPermission systemPermission = new SystemPermission(new User());
        systemPermission.claimedBy(new SystemAdmin());

        systemPermission.grantedBy(new SystemAdmin());
    }


    @Test
    public void should_be_denied_when_denied_by_admin_after_claimed() throws Exception {
        SystemPermission systemPermission = new SystemPermission(new User());
        final SystemAdmin systemAdmin = new SystemAdmin();
        systemPermission.claimedBy(systemAdmin);

        systemPermission.deniedBy(systemAdmin);

        assertEquals(SystemPermission.DENIED, systemPermission.getState());
    }

    // should_be_the_same_admin_to_deny_after_claimed
    @Test
    public void should_be_unix_permission_requested_when_unix_requested_by_user_after_claimed() throws Exception {
        User user = new User();
        SystemPermission systemPermission = new SystemPermission(user);
        final SystemAdmin systemAdmin = new SystemAdmin();
        systemPermission.claimedBy(systemAdmin);

        systemPermission.unixRequestedBy(user);

        assertEquals(SystemPermission.UNIX_PERMISSION_REQUESTED, systemPermission.getState());
    }

    // should_be_the_same_user_to_request_unix_permission
    // should_be_unix_permission_claimed_when_unix_claimed_by_unix_admin_after_unix_permission_requested
    // should_be_granted_when_unix_granted_by_unix_admin_after_unix_permission_claimed
    // should_be_the_same_unix_admin_to_grant_after_unix_permission_claimed
    // should_be_denied_when_unix_denied_by_unix_admin_after_unix_permission_claimed
    // should_be_the_same_unix_admin_to_deny_after_unix_permission_claimed
    // should_be_unix_permission_claimed_when_unix_claimed_by_admin_after_unix_permission_requested
    // should_be_granted_when_unix_granted_by_admin_after_unix_permission_claimed
    // should_be_denied_when_unix_denied_by_admin_after_unix_permission_claimed
}
