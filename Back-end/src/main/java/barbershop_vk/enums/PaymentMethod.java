package barbershop_vk.enums;

public enum PaymentMethod {
    PIX(1),
    DINHEIRO(2),
    CREDITO(3),
    DEBITO(4);

    private int codePaymentMethod;

    private PaymentMethod(int codePaymentMethod) {
        this.codePaymentMethod = codePaymentMethod;
    }

    public int getCodePaymentMethod() {
        return codePaymentMethod;
    }

    public static PaymentMethod valueOf(int codePaymentMethod) {

        for (PaymentMethod m : PaymentMethod.values()) {

            if (m.getCodePaymentMethod() == codePaymentMethod) {
                return m;
            }
        }

        throw new IllegalArgumentException("Código inválido: " + codePaymentMethod);
    }
}
