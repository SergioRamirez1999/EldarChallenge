package com.sergioramirezme.eldar.utils;

import com.sergioramirezme.eldar.exceptions.BusinessException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

public class NashornUtils {

    public static double eval_expression(String raw_expression, Map<String, Double> arguments) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");

        String mathExpression = arguments.entrySet().stream()
                .reduce(
                        raw_expression,
                        (exp, kv) -> exp.replace(kv.getKey(), String.valueOf(kv.getValue())),
                        (a, b) -> a);

        Object result = engine.eval(mathExpression);
        return (double) result;

    }
}
