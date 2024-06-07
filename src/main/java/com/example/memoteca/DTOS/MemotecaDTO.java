package com.example.memoteca.DTOS;

import jakarta.validation.constraints.NotNull;

public record MemotecaDTO(@NotNull String conteudo, @NotNull String autor, @NotNull String modelo) {
}
