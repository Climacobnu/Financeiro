package com.myproject.financeiro.util;

import java.time.LocalDate;

public class ValidadorData {
    public static boolean isDataNoPassado(LocalDate data) {
        return data.isBefore(LocalDate.now());
    }
}