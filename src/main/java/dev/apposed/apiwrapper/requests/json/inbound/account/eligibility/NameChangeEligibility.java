package dev.apposed.apiwrapper.requests.json.inbound.account.eligibility;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class NameChangeEligibility {

    private String changedAt, createdAt;
    private boolean nameChangeAllowed;
}
