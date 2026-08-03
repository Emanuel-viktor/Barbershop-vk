package barbershop_vk.enums;

public enum SchedulingStatus {
    FINALIZADO(1),
    AGENDADO(2),
    CANCELADO(3),
    ANDAMENTO(4);

    private int codeSchedulingStatus;

    private SchedulingStatus(int codeStatusPayment) {
        this.codeSchedulingStatus = codeSchedulingStatus;
    }

    public int getCodeSchedulingStatus() {
        return codeSchedulingStatus;
    }

    public static SchedulingStatus valueOf(int codeSchedulingStatus) {

        for (SchedulingStatus m : SchedulingStatus.values()) {

            if (m.getCodeSchedulingStatus() == codeSchedulingStatus) {
                return m;
            }
        }

        throw new IllegalArgumentException("Código inválido: " + codeSchedulingStatus);
    }
}
