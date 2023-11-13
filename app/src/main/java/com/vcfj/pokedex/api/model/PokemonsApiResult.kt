package com.vcfj.pokedex.api.model

import com.vcfj.pokedex.domain.PokemonType

data class PokemonsApiResult(
    val count: Int,
    val previous: String?,
    val next: String?,
    val results: List<PokemonResult>
) {
}

data class PokemonResult(
    val name: String,
    val url: String
)

data class PokemonApiResult(
    val id: Int,
    val name: String,
    val types: List<PokemonTypeSlot>
)

class PokemonTypeSlot(
    val slot: Int,
    val type: PokemonType
)
