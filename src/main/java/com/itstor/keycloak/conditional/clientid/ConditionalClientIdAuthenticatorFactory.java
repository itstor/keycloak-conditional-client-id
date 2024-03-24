package com.itstor.keycloak.conditional.clientid;

import org.keycloak.Config;
import org.keycloak.authentication.authenticators.conditional.ConditionalAuthenticator;
import org.keycloak.authentication.authenticators.conditional.ConditionalAuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.provider.ProviderConfigurationBuilder;

import java.util.Collections;
import java.util.List;

public class ConditionalClientIdAuthenticatorFactory implements ConditionalAuthenticatorFactory {
    public static final String PROVIDER_ID = "conditional-client-id";
    public static final String PROVIDER_DISPLAY = "Condition - Client Id";
    public static final String PROVIDER_HELP = "Conditional Authenticator which matches the current client id.";

    protected static final String CONDITIONAL_CLIENT_EXPRESSION = "condClientExpression";
    protected static final String CONDITIONAL_CLIENT_INVERSION = "condClientInversion";

    private static final List<ProviderConfigProperty> commonConfig = Collections.unmodifiableList(ProviderConfigurationBuilder.create()
            .property().name(CONDITIONAL_CLIENT_EXPRESSION)
            .label("Required Client Id Regex")
            .helpText("Regular expression that must match current client id to execute this flow.")
            .type(ProviderConfigProperty.STRING_TYPE).add()
            .property().name(CONDITIONAL_CLIENT_INVERSION)
            .label("Expression Inversion")
            .helpText("Inverse match result")
            .type(ProviderConfigProperty.BOOLEAN_TYPE).add()
            .build()
    );

    private static final AuthenticationExecutionModel.Requirement[] REQUIREMENT_CHOICES = {
            AuthenticationExecutionModel.Requirement.REQUIRED,
            AuthenticationExecutionModel.Requirement.DISABLED
    };

    @Override
    public void init(Config.Scope config) {
        // Not used
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
        // Not used
    }

    @Override
    public void close() {
        // Not used
    }

    @Override
    public String getId() {
        return PROVIDER_ID;
    }

    @Override
    public String getDisplayType() {
        return PROVIDER_DISPLAY;
    }

    @Override
    public String getReferenceCategory() {
        return "condition";
    }

    @Override
    public boolean isConfigurable() {
        return true;
    }

    @Override
    public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
        return REQUIREMENT_CHOICES;
    }

    @Override
    public boolean isUserSetupAllowed() {
        return true;
    }

    @Override
    public String getHelpText() {
        return PROVIDER_HELP;
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return commonConfig;
    }

    @Override
    public ConditionalAuthenticator getSingleton() {
        return ConditionalClientIdAuthenticator.SINGLETON;
    }
}
