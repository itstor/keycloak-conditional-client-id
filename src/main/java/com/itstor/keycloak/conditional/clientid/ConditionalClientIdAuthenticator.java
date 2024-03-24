package com.itstor.keycloak.conditional.clientid;

import org.jboss.logging.Logger;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.authenticators.conditional.ConditionalAuthenticator;
import org.keycloak.models.*;

public class ConditionalClientIdAuthenticator implements ConditionalAuthenticator {
    public static final ConditionalClientIdAuthenticator SINGLETON = new ConditionalClientIdAuthenticator();

    @Override
    public boolean matchCondition(AuthenticationFlowContext context) {
        ClientModel client = context.getAuthenticationSession().getClient();
        AuthenticatorConfigModel authConfig = context.getAuthenticatorConfig();

        if (authConfig != null && authConfig.getConfig() != null && client != null) {
            String currentClientId = client.getClientId();
            String clientIdRegex = authConfig.getConfig().get(ConditionalClientIdAuthenticatorFactory.CONDITIONAL_CLIENT_EXPRESSION);
            boolean resultInversion = Boolean.parseBoolean(authConfig.getConfig().get(ConditionalClientIdAuthenticatorFactory.CONDITIONAL_CLIENT_INVERSION));

            return resultInversion ^ (clientIdRegex != null && currentClientId.matches(clientIdRegex));
        }
        return false;
    }

    @Override
    public void action(AuthenticationFlowContext afc) {
        // Not used
    }

    @Override
    public boolean requiresUser() {
        return true;
    }

    @Override
    public void setRequiredActions(KeycloakSession ks, RealmModel rm, UserModel um) {
        // Not used
    }

    @Override
    public void close() {
        // Not used
    }
}
