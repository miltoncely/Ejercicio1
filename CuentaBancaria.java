public class CuentaBancaria {
    protected int numeroUsuario;
    protected double saldo;

    public CuentaBancaria(int numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
        this.saldo = 0.0;
    }

    public void depositar(double monto) {
        this.saldo += monto;
        System.out.println("Depósito realizado. Nuevo saldo: " + this.saldo);
    }

    public void retirar(double monto) {
        if (monto <= saldo) {
            this.saldo -= monto;
            System.out.println("Retiro realizado. Nuevo saldo: " + this.saldo);
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro.");
        }
    }

    static class CuentaAhorro extends CuentaBancaria {
        private String identificacionCliente;

        public CuentaAhorro(int numeroUsuario, String identificacionCliente) {
            super(numeroUsuario);
            this.identificacionCliente = identificacionCliente;
        }

    }

    static class CuentaInversion extends CuentaBancaria {
        private int anosTrabajando;

        public CuentaInversion(int numeroUsuario, int anosTrabajando) {
            super(numeroUsuario);
            this.anosTrabajando = anosTrabajando;
        }

    }

    static class EmpleadoBanco {
        private int identificacion;
        private int anosTrabajando;

        public EmpleadoBanco(int identificacion, int anosTrabajando) {
            this.identificacion = identificacion;
            this.anosTrabajando = anosTrabajando;
        }

        public int calcularVacaciones() {
            int diasVacaciones = Math.min(5 + 2 * anosTrabajando, 20);
            return diasVacaciones;
        }

    }

    static class CasaInversionista {
        private String clave;
        private String historial;
        private double porcentajeRetorno;
        private double montoInversion;
        private int plazo;

        public CasaInversionista(String clave, String historial, double porcentajeRetorno,
                                 double montoInversion, int plazo) {
            this.clave = clave;
            this.historial = historial;
            this.porcentajeRetorno = porcentajeRetorno;
            this.montoInversion = montoInversion;
            this.plazo = plazo;
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        CuentaAhorro cuentaAhorro = new CuentaAhorro(123, "IDCliente123");
        cuentaAhorro.depositar(1000);
        cuentaAhorro.retirar(500);

        CuentaInversion cuentaInversion = new CuentaInversion(456, 5);
        cuentaInversion.depositar(2000);

        EmpleadoBanco empleado = new EmpleadoBanco(789, 3);
        System.out.println("Días de vacaciones: " + empleado.calcularVacaciones());

        CasaInversionista casaInversionista = new CasaInversionista("Clave123", "Buen historial", 0.05, 5000, 12);

    }
}

