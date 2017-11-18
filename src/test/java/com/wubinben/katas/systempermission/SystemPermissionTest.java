package com.wubinben.katas.systempermission;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class SystemPermissionTest {
    @Test
    public void should_be_requested_when_it_is_initialized() throws Exception {
        SystemPermission systemPermission = new SystemPermission();

        assertEquals("REQUESTED", systemPermission.getState());
    }

    // should_be_claimed_when_claimed_by_admin_after_requested
    // should_be_granted_when_granted_by_admin_after_claimed
    // should_be_denied_when_denied_by_admin_after_claimed
    // should_be_unix_permission_requested_when_unix_requested_by_admin_after_claimed
    // should_be_unix_permission_claimed_when_unix_claimed_by_admin_after_unix_permission_requested
    // should_be_granted_when_unix_granted_by_admin_after_unix_permission_claimed
    // should_be_denied_when_unix_denied_by_admin_after_unix_permission_claimed
}
