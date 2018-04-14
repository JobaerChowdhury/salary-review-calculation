package com.cefalo.school.composite;

import com.cefalo.school.calculator.Impact;

public enum Role {
    DEVELOPER(new Impact(0.2, 0.2, 0.2, 0.2, 0.2)),
    TEAMLEAD(new Impact(0.3, 0.1, 0.3, 0.3, 0.0)),
    PROJECTMANAGER(new Impact(0.2, 0.1, 0.3, 0.4, 0.1)),
    CTO(new Impact(0.1, 0.3, 0.3, 0.3, 0.0));

    private Impact impact;

    private Role(Impact impact) {
        this.impact = impact;
    }

    public Impact getImpact() {
        return this.impact;
    }
}
