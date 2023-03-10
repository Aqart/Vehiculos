package Assets;


import Exceptions.FechaIncorrecta;
import java.util.Date;

public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    public Fecha() {
        Date d = new Date();
        this.dia = d.getDate();
        this.mes = d.getMonth() + 1;
        this.anio = d.getYear() + 1900;
    }

    public Fecha(int dia, int mes, int anio) {

        try {
            validarAnio(anio);

            this.anio = anio;
        } catch (Exception e) {
            Date d = new Date();
            System.out.println(e.getMessage());
            this.anio = d.getYear() + 1900;
        }

        try {
            validarMes(mes);
            this.mes = mes;
        } catch (Exception e) {
            Date d = new Date();
            System.out.println(e.getMessage());
            this.mes = d.getMonth() + 1;
        }

        try {
            validarDia(dia);
            this.dia = dia;
        } catch (Exception e) {
            Date d = new Date();
            System.out.println(e.getMessage());
            this.dia = d.getDate();
        }
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        String diastr = dia + "";
        String messtr = mes + "";
        if (dia < 10) {
            diastr = "0" + diastr;
        }
        if (mes < 10) {
            messtr = "0" + messtr;
        }

        return diastr + "/" + messtr + "/" + anio;
    }

    public boolean esBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 100 == 0 && anio % 400 == 0);
    }

    public int diasMes() {
        int diasmes = 0;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                diasmes = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diasmes = 30;
                break;
            case 2:
                diasmes = 28;
                if (esBisiesto(anio)) {
                    diasmes++;
                }
                break;
            default:
                diasmes = -1;
        }

        return diasmes;

    }

    public void validarDia(int dia) throws FechaIncorrecta {

        if (!(dia >= 1 && dia <= diasMes())) {

            throw new FechaIncorrecta("El dia no es correcto se establece por defecto la fecha de hoy");

        }

    }

    public void validarMes(int mes) throws FechaIncorrecta {

        if (!(mes >= 1 && mes <= 12)) {

            throw new FechaIncorrecta("El mes no es correcto se establece por defecto la fecha de hoy");

        }

    }

    public void validarAnio(int anio) throws FechaIncorrecta {

        if (anio <= 0) {

            throw new FechaIncorrecta("El año no es correcto se establece por defecto la fecha de hoy");

        }

    }

}
