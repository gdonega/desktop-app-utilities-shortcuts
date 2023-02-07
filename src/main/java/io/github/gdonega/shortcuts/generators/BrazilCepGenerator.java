package io.github.gdonega.shortcuts.generators;

import java.util.Random;

public class BrazilCepGenerator {
    private static String randomDe0A9() {
        return Integer.toString(new Random().nextInt(0, 9 + 1));
    }

    public static String generate() {
        // Região:
        // 0: Grande São Paulo (SP)
        // 1: Interior e litoral de SP
        // 2: Rio de Janeiro (RJ) e Espírito Santo (ES)
        // 3: Minas Gerais (MG)
        // 4: Bahia (BA) e Sergipe (SE)
        // 5: Pernambuco (PE), Alagoas (AL), Paraiba (PB) e Rio Grande do Norte (RN)
        // 6: Ceará (CE), Piauí (PI), Maranhão (MA), Pará (PA), Amapá (AP), Amazonas (AM), Roraima (RR) e Acre (AC)
        // 7: Distrito Federal (DF), Goiás (GO), Rondônia (RO), Tocantins (TO), Mato Grosso (MT) e Mato Grosso do Sul (MS)
        // 8: Paraná (PR) e Santa Catarina (SC)
        // 9: Rio Grande do Sul (RS)
        final String regiao = randomDe0A9();

        // SubRegião: divide a Região
        final String subRegiao = randomDe0A9();

        // Setor: divide a Sub Região
        final String setor = randomDe0A9();

        // Sub Setor: divide o setor
        final String subSetor = randomDe0A9();

        // Divisor do Sub Setor: divide o sub setor
        final String divisorDeSubSetor = randomDe0A9();

        // Sufixo: Identificação individual de localidades, logradouros, código especiais e unidades dos correios
        final String sufixoAlg1 = randomDe0A9();
        final String sufixoAlg2 = randomDe0A9();
        final String sufixoAlg3 = randomDe0A9();

        // Gera o CEP
        return regiao + subRegiao + setor + subSetor + divisorDeSubSetor + sufixoAlg1 + sufixoAlg2 + sufixoAlg3;
    }
}
