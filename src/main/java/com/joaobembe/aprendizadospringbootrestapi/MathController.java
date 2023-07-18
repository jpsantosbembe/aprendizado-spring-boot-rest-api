package com.joaobembe.aprendizadospringbootrestapi;

import java.util.concurrent.atomic.AtomicLong;

import com.joaobembe.aprendizadospringbootrestapi.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Valor não é numérico");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Valor não é numérico");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/mul/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mul(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Valor não é numérico");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception{
        if (!isNumeric(numberOne) || (!isNumeric(numberTwo))) {
            throw new UnsupportedMathOperationException("Valor não é numérico");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/av/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double av(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception{
        if (!isNumeric(numberOne) || (!isNumeric(numberTwo))) {
            throw new UnsupportedMathOperationException("Valor não é numérico");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @RequestMapping(value = "sqrt/{numberOne}", method = RequestMethod.GET)
    public Double sqrt(
            @PathVariable(value = "numberOne") String numberOne
    ) throws Exception{
        if (!isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Valor não é numérico");
        }
        return Math.sqrt(convertToDouble(numberOne));
    }

    private Double convertToDouble(String strNumber) {
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(strNumber)) return Double.parseDouble(number);
        return 0d;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }
}
