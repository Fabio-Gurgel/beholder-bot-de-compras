package br.com.beholder.compras.utils;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

public final class Stopwatch {

    private Instant inicio;
    private Instant fim;
    private boolean iniciado = false;
    private boolean finalizado = false;

    private Stopwatch() {}

    public static Stopwatch iniciar() {
        Stopwatch timer = new Stopwatch();
        timer.inicio = Instant.now();
        timer.iniciado = true;
        return timer;
    }

    public void finalizar() {
        if (!iniciado) {
            throw new IllegalStateException("O cronômetro precisa ser iniciado antes de ser finalizado.");
        }
        if (finalizado) {
            throw new IllegalStateException("O cronômetro já foi finalizado.");
        }
        this.fim = Instant.now();
        this.finalizado = true;
    }

    public Duration getDuracao() {
        if (!finalizado) {
            throw new IllegalStateException("A duração só pode ser obtida após a finalização.");
        }
        return Duration.between(inicio, fim);
    }

    public long getDuracaoEmMilissegundos() {
        return getDuracao().toMillis();
    }

    public long getDuracaoEmSegundos() {
        return getDuracao().getSeconds();
    }

    public Optional<Instant> getInicio() {
        return Optional.ofNullable(inicio);
    }

    public Optional<Instant> getFim() {
        return Optional.ofNullable(fim);
    }

    @Override
    public String toString() {
        if (!finalizado) {
            return "Execução em andamento desde: " + inicio;
        }
        Duration duracao = getDuracao();
        long minutos = duracao.toMinutes();
        long segundos = duracao.minusMinutes(minutos).getSeconds();

        return String.format("Duração total: %02d min %02d seg (%d ms)", minutos, segundos, duracao.toMillis());
    }
}
