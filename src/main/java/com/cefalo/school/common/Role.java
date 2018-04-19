package com.cefalo.school.common;

import com.cefalo.school.calculator.Impact;

public enum Role {
    DEVELOPER(new Impact(0.2, 0.2, 0.2, 0.2, 0.2)),
    TEAMLEAD(new Impact(0.3, 0.1, 0.3, 0.3, 0.0)),
    PROJECTMANAGER(new Impact(0.2, 0.1, 0.3, 0.4, 0.1)),
    CTO(new Impact(0.1, 0.3, 0.3, 0.3, 0.0));

    public Impact impact;

    Role(Impact impact) {
        this.impact = impact;
    }
}
