package com.appgate.coderefactoring.socialmention.commons.constants;

public class SocialNetworkConstants {

    public static class RiskLevelsTweeter {
        public static final String HIGH_RISK_TWEETER = "El riesgo es alto debido al analisis de la cuenta de Tweeter, que indican una posible vulnerabilidad significativa.";
        public static final String MEDIUM_RISK_TWEETER = "El riesgo es moderado según los analisis de tu cuenta de Tweeter, lo que indica una posible amenaza que debe ser monitoreada más de cerca. Se recomienda realizar una revisión de los datos en las próximas semanas para evaluar cambios en la tendencia.";
        public static final String LOW_RISK_TWEETER = "El riesgo es bajo según los analisis de tu cuenta de Tweeter, no se requieren acciones inmediatas.";
    }

    public static class RiskLevelsFaceBook {
        public static final String HIGH_RISK_FB = "El riesgo es alto debido al análisis de los comentarios y post de la cuenta de Facebook, que indican una posible vulnerabilidad significativa.";
        public static final String MEDIUM_RISK_FB = "El riesgo es moderado según los análisis de tu cuenta de facebook, lo que indica una posible amenaza que debe ser monitoreada más de cerca. Se recomienda realizar una revisión de los datos en las próximas semanas para evaluar cambios en la tendencia.";
        public static final String LOW_RISK_FB = "El riesgo es bajo según los análisis de tu cuenta de facebook, no se requieren acciones inmediatas.";
    }

    public static class riskCategories {
        public static final int HIGH_RISK_CATEGORY = 1;
        public static final int MEDIUM_RISK_CATEGORY = 2;
        public static final int LOW_RISK_CATEGORY = 3;
    }

    public static class ValidationMessage {
        public static final String MESSAGE_NULL = "El mensaje no puede ser nulo";
        public static final String DATE_NULL = "la fecha de creacion no puede ser nula";
        public static final String PAST_OR_PRESENT_VALIDATION = "La fecha de creación no puede ser futura";
        public static final String ONE_ACCOUNT_VALIDATION = "Debe especificar al menos una cuenta (Facebook o Twitter)";
        public static final String ONE_DATA_VALIDATION = "Debe existir al menos un comentario de Facebook o una URL de Twitter";
        public static final String IS_FACEBOOK_VALID = "Si se incluye una cuenta de Facebook, debe incluirse también una lista de comentarios de Facebook";
        public static final String IS_TWIITER_VALID = "Si se incluye una cuenta de Twitter, debe incluirse también una URL de Twitter";
        public static final String IS_MUTUAL_EXCLUSION_VALID = "No se pueden incluir ambas redes sociales con sus campos asociados al mismo tiempo";
    }

}
