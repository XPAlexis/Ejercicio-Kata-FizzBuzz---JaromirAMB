import java.math.BigDecimal

fun diferenteDe(s: String?): String? {
    val result = StringBuilder()
    val totalBigDecimal = BigDecimal(s).setScale(2, BigDecimal.ROUND_DOWN)
    val parteEntera = totalBigDecimal.toBigInteger().toLong()
    val triUnidades = (parteEntera % 1000).toInt()
    val triMiles = (parteEntera / 1000 % 1000).toInt()
    val triMillones = (parteEntera / 1000000 % 1000).toInt()
    val triMilMillones = (parteEntera / 1000000000 % 1000).toInt()
    if (parteEntera == 0L) {
        result.append("Cero ")
        return result.toString()
    }
    if (triMilMillones > 0) result.append(triTexto(triMilMillones).toString() + "Mil ")
    if (triMillones > 0) result.append(triTexto(triMillones).toString())
    if (triMilMillones == 0 && triMillones == 1) result.append("Millón ") else if (triMilMillones > 0 || triMillones > 0) result.append(
        "Millones "
    )
    if (triMiles > 0) result.append(triTexto(triMiles).toString() + "Mil ")
    if (triUnidades > 0) result.append(triTexto(triUnidades).toString())
    return result.toString()
}

/**
 * Convierte una cantidad de tres cifras a su representación escrita con letra.
 *
 * @param n La cantidad a convertir.
 * @return  Una cadena de texto que contiene la representación con letra
 * del número que se recibió como argumento.
 */

private fun triTexto(n: Int): StringBuilder {
    val result = StringBuilder()
    val centenas = n / 100
    val decenas = n % 100 / 10
    val unidades = n % 10
    when (centenas) {
        0 -> {}
        1 -> if (decenas == 0 && unidades == 0) {
            result.append("Cien ")
            return result
        } else result.append("Ciento ")
        2 -> result.append("Doscientos ")
        3 -> result.append("Trescientos ")
        4 -> result.append("Cuatrocientos ")
        5 -> result.append("Quinientos ")
        6 -> result.append("Seiscientos ")
        7 -> result.append("Setecientos ")
        8 -> result.append("Ochocientos ")
        9 -> result.append("Novecientos ")
    }
    when (decenas) {
        0 -> {}
        1 -> if (unidades == 0) {
            result.append("Diez ")
            return result
        } else if (unidades == 1) {
            result.append("Once ")
            return result
        } else if (unidades == 2) {
            result.append("Doce ")
            return result
        } else if (unidades == 3) {
            result.append("Trece ")
            return result
        } else if (unidades == 4) {
            result.append("Catorce ")
            return result
        } else if (unidades == 5) {
            result.append("Quince ")
            return result
        } else result.append("Dieci ")
        2 -> if (unidades == 0) {
            result.append("Veinte ")
            return result
        } else result.append("Veinti ")
        3 -> result.append("Treinta ")
        4 -> result.append("Cuarenta ")
        5 -> result.append("Cincuenta ")
        6 -> result.append("Sesenta ")
        7 -> result.append("Setenta ")
        8 -> result.append("Ochenta ")
        9 -> result.append("Noventa ")
    }
    if (decenas > 2 && unidades > 0) result.append("y ")
    when (unidades) {
        0 -> {}
        1 -> result.append("Un ")
        2 -> result.append("Dos ")
        3 -> result.append("Tres ")
        4 -> result.append("Cuatro ")
        5 -> result.append("Cinco ")
        6 -> result.append("Seis ")
        7 -> result.append("Siete ")
        8 -> result.append("Ocho ")
        9 -> result.append("Nueve ")
    }
    return result
}


fun main(args: Array<String>) {

    println("Escribe un número entero: ")
    val number= readLine()
    var numero= number?.toIntOrNull()
    if (numero != null) {
        when{
            numero %3 == 0 && numero % 5 == 0->println("fizzbuzz")
            numero %3 == 0 -> println("Fizz")
            numero %5 == 0 -> println("buzz")
            else ->  println(diferenteDe(number) + "!")
        }
    }

}