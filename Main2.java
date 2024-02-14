public class Main2 {

    public static void main(String[] args) {
        // Ejemplo de uso
        Cliente cliente1 = new Cliente(1, "Juan", new CuentaAhorro(101, 5));
        Cliente cliente2 = new Cliente(2, "Maria", new CuentaInversion(102));

        cliente1.depositar(1500);
        cliente2.depositar(30000);

        cliente1.retirar(500);
        cliente2.retirar(15000);

        cliente1.calcularIntereses();
        cliente2.calcularIntereses();

        System.out.println(cliente1);
        System.out.println(cliente2);
    }
}

abstract class Cuenta {
    protected double saldo;
    protected int numeroCuenta;

    public Cuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

    public abstract void depositar(double monto);

    public abstract void retirar(double monto);

    public abstract void calcularIntereses();
}

class CuentaAhorro extends Cuenta {
    private static final double PRIMER_DEPOSITO = 1000;
    private static final double SALDO_MINIMO = 500;
    private double porcentajeAhorroAnual;

    public CuentaAhorro(int numeroCuenta, double porcentajeAhorroAnual) {
        super(numeroCuenta);
        this.porcentajeAhorroAnual = porcentajeAhorroAnual;
    }

    @Override
    public void depositar(double monto) {
        if (saldo == 0 && monto == PRIMER_DEPOSITO) {
            saldo += monto;
        } else if (monto > 0) {
            saldo += monto;
        }
    }

    @Override
    public void retirar(double monto) {
        if (saldo - monto >= SALDO_MINIMO) {
            saldo -= monto;
        }
    }

    @Override
    public void calcularIntereses() {
        double intereses = saldo * (porcentajeAhorroAnual / 100) / 12;
        saldo += intereses;
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" +
                "numeroCuenta=" + numeroCuenta +
                ", saldo=" + saldo +
                ", porcentajeAhorroAnual=" + porcentajeAhorroAnual +
                '}';
    }
}

class CuentaInversion extends Cuenta {
    private static final double MONTO_INICIAL = 25000;
    private static final double SALDO_MINIMO_RETENCION = 10000;

    public CuentaInversion(int numeroCuenta) {
        super(numeroCuenta);
        this.saldo = MONTO_INICIAL;
    }

    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    @Override
    public void retirar(double monto) {
        if (saldo - monto >= SALDO_MINIMO_RETENCION || saldo == monto) {
            saldo -= monto;
        }
    }

    @Override
    public void calcularIntereses() {
        // Lógica de cálculo de intereses para la cuenta de inversión (puedes implementarla según tus necesidades)
    }

    @Override
    public String toString() {
        return "CuentaInversion{" +
                "numeroCuenta=" + numeroCuenta +
                ", saldo=" + saldo +
                '}';
    }
}

class Cliente {
    private int numeroCliente;
    private String nombre;
    private Cuenta cuenta;

    public Cliente(int numeroCliente, String nombre, Cuenta cuenta) {
        this.numeroCliente = numeroCliente;
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    public void depositar(double monto) {
        cuenta.depositar(monto);
    }

    public void retirar(double monto) {
        cuenta.retirar(monto);
    }

    public void calcularIntereses() {
        cuenta.calcularIntereses();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "numeroCliente=" + numeroCliente +
                ", nombre='" + nombre + '\'' +
                ", cuenta=" + cuenta +
                '}';
    }
}
