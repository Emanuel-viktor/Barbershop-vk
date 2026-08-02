package barbershop_vk.enums;

public enum StatusPayment {
    PENDENTE(1),
    APROVADO(2);


    private int codeStatusPayment;

    private StatusPayment(int codeStatusPayment) {
        this.codeStatusPayment = codeStatusPayment;
    }

    public int getCodeStatusPayment() {
        return codeStatusPayment;
    }

    public static StatusPayment valueOf(int codeStatusPayment) {

        for (StatusPayment m : StatusPayment.values()) {

            if (m.getCodeStatusPayment() == codeStatusPayment) {
                return m;
            }
        }

        throw new IllegalArgumentException("Código inválido: " + codeStatusPayment);
    }
}
